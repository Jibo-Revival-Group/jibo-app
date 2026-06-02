package com.facebook.share.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.internal.WorkQueue;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoUploader {
   private static final String ERROR_BAD_SERVER_RESPONSE = "Unexpected error in server response";
   private static final String ERROR_UPLOAD = "Video upload failed";
   private static final int MAX_RETRIES_PER_PHASE = 2;
   private static final String PARAM_DESCRIPTION = "description";
   private static final String PARAM_END_OFFSET = "end_offset";
   private static final String PARAM_FILE_SIZE = "file_size";
   private static final String PARAM_REF = "ref";
   private static final String PARAM_SESSION_ID = "upload_session_id";
   private static final String PARAM_START_OFFSET = "start_offset";
   private static final String PARAM_TITLE = "title";
   private static final String PARAM_UPLOAD_PHASE = "upload_phase";
   private static final String PARAM_VALUE_UPLOAD_FINISH_PHASE = "finish";
   private static final String PARAM_VALUE_UPLOAD_START_PHASE = "start";
   private static final String PARAM_VALUE_UPLOAD_TRANSFER_PHASE = "transfer";
   private static final String PARAM_VIDEO_FILE_CHUNK = "video_file_chunk";
   private static final String PARAM_VIDEO_ID = "video_id";
   private static final int RETRY_DELAY_BACK_OFF_FACTOR = 3;
   private static final int RETRY_DELAY_UNIT_MS = 5000;
   private static final String TAG = "VideoUploader";
   private static final int UPLOAD_QUEUE_MAX_CONCURRENT = 8;
   private static AccessTokenTracker accessTokenTracker;
   private static Handler handler;
   private static boolean initialized;
   private static Set<VideoUploader.UploadContext> pendingUploads = new HashSet<>();
   private static WorkQueue uploadQueue = new WorkQueue(8);

   private static void cancelAllRequests() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1058)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.insertSemaphore(FinallyProcessor.java:351)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:98)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: ldc com/facebook/share/internal/VideoUploader
      // 02: monitorenter
      // 03: getstatic com/facebook/share/internal/VideoUploader.pendingUploads Ljava/util/Set;
      // 06: invokeinterface java/util/Set.iterator ()Ljava/util/Iterator; 1
      // 0b: astore 0
      // 0c: aload 0
      // 0d: invokeinterface java/util/Iterator.hasNext ()Z 1
      // 12: ifeq 2b
      // 15: aload 0
      // 16: invokeinterface java/util/Iterator.next ()Ljava/lang/Object; 1
      // 1b: checkcast com/facebook/share/internal/VideoUploader$UploadContext
      // 1e: bipush 1
      // 1f: putfield com/facebook/share/internal/VideoUploader$UploadContext.isCanceled Z
      // 22: goto 0c
      // 25: astore 0
      // 26: ldc com/facebook/share/internal/VideoUploader
      // 28: monitorexit
      // 29: aload 0
      // 2a: athrow
      // 2b: ldc com/facebook/share/internal/VideoUploader
      // 2d: monitorexit
      // 2e: return
      // try (2 -> 5): 14 null
      // try (5 -> 13): 14 null
   }

   private static void enqueueRequest(VideoUploader.UploadContext var0, Runnable var1) {
      synchronized (VideoUploader.class) {
         var0.workItem = uploadQueue.addActiveWorkItem(var1);
      }
   }

   private static void enqueueUploadChunk(VideoUploader.UploadContext var0, String var1, String var2, int var3) {
      enqueueRequest(var0, new VideoUploader.TransferChunkWorkItem(var0, var1, var2, var3));
   }

   private static void enqueueUploadFinish(VideoUploader.UploadContext var0, int var1) {
      enqueueRequest(var0, new VideoUploader.FinishUploadWorkItem(var0, var1));
   }

   private static void enqueueUploadStart(VideoUploader.UploadContext var0, int var1) {
      enqueueRequest(var0, new VideoUploader.StartUploadWorkItem(var0, var1));
   }

   private static byte[] getChunk(VideoUploader.UploadContext var0, String var1, String var2) throws IOException {
      byte[] var9;
      if (!Utility.areObjectsEqual(var1, var0.chunkStart)) {
         logError(null, "Error reading video chunk. Expected chunk '%s'. Requested chunk '%s'.", var0.chunkStart, var1);
         var9 = null;
      } else {
         long var6 = Long.parseLong(var1);
         int var3 = (int)(Long.parseLong(var2) - var6);
         ByteArrayOutputStream var10 = new ByteArrayOutputStream();
         byte[] var8 = new byte[Math.min(8192, var3)];

         while (true) {
            int var5 = var0.videoStream.read(var8);
            if (var5 == -1) {
               break;
            }

            var10.write(var8, 0, var5);
            int var4 = var3 - var5;
            if (var4 == 0) {
               break;
            }

            var3 = var4;
            if (var4 < 0) {
               logError(null, "Error reading video chunk. Expected buffer length - '%d'. Actual - '%d'.", var4 + var5, var5);
               Object var11 = null;
               return (byte[])var11;
            }
         }

         var0.chunkStart = var2;
         var9 = var10.toByteArray();
      }

      return var9;
   }

   private static Handler getHandler() {
      synchronized (VideoUploader.class) {
         if (handler == null) {
            Handler var0 = new Handler(Looper.getMainLooper());
            handler = var0;
         }

         return handler;
      }
   }

   private static void issueResponse(VideoUploader.UploadContext var0, FacebookException var1, String var2) {
      removePendingUpload(var0);
      Utility.closeQuietly(var0.videoStream);
      if (var0.callback != null) {
         if (var1 != null) {
            ShareInternalUtility.invokeOnErrorCallback(var0.callback, var1);
         } else if (var0.isCanceled) {
            ShareInternalUtility.invokeOnCancelCallback(var0.callback);
         } else {
            ShareInternalUtility.invokeOnSuccessCallback(var0.callback, var2);
         }
      }
   }

   private static void logError(Exception var0, String var1, Object... var2) {
      Log.e("VideoUploader", String.format(Locale.ROOT, var1, var2), var0);
   }

   private static void registerAccessTokenTracker() {
      accessTokenTracker = new AccessTokenTracker() {
         @Override
         protected void onCurrentAccessTokenChanged(AccessToken var1, AccessToken var2) {
            if (var1 != null && (var2 == null || !Utility.areObjectsEqual(var2.getUserId(), var1.getUserId()))) {
               VideoUploader.cancelAllRequests();
            }
         }
      };
   }

   private static void removePendingUpload(VideoUploader.UploadContext var0) {
      synchronized (VideoUploader.class) {
         pendingUploads.remove(var0);
      }
   }

   public static void uploadAsync(ShareVideoContent var0, FacebookCallback<Sharer.Result> var1) throws FileNotFoundException {
      synchronized (VideoUploader.class) {
         uploadAsync(var0, "me", var1);
      }
   }

   public static void uploadAsync(ShareVideoContent var0, String var1, FacebookCallback<Sharer.Result> var2) throws FileNotFoundException {
      synchronized (VideoUploader.class) {
         if (!initialized) {
            registerAccessTokenTracker();
            initialized = true;
         }

         Validate.notNull(var0, "videoContent");
         Validate.notNull(var1, "graphNode");
         ShareVideo var3 = var0.getVideo();
         Validate.notNull(var3, "videoContent.video");
         Validate.notNull(var3.getLocalUrl(), "videoContent.video.localUrl");
         VideoUploader.UploadContext var6 = new VideoUploader.UploadContext(var0, var1, var2);
         var6.initialize();
         pendingUploads.add(var6);
         enqueueUploadStart(var6, 0);
      }
   }

   private static class FinishUploadWorkItem extends VideoUploader.UploadWorkItemBase {
      static final Set<Integer> transientErrorCodes = new HashSet<Integer>() {
         {
            this.add(1363011);
         }
      };

      public FinishUploadWorkItem(VideoUploader.UploadContext var1, int var2) {
         super(var1, var2);
      }

      @Override
      protected void enqueueRetry(int var1) {
         VideoUploader.enqueueUploadFinish(this.uploadContext, var1);
      }

      @Override
      public Bundle getParameters() {
         Bundle var1 = new Bundle();
         if (this.uploadContext.params != null) {
            var1.putAll(this.uploadContext.params);
         }

         var1.putString("upload_phase", "finish");
         var1.putString("upload_session_id", this.uploadContext.sessionId);
         Utility.putNonEmptyString(var1, "title", this.uploadContext.title);
         Utility.putNonEmptyString(var1, "description", this.uploadContext.description);
         Utility.putNonEmptyString(var1, "ref", this.uploadContext.ref);
         return var1;
      }

      @Override
      protected Set<Integer> getTransientErrorCodes() {
         return transientErrorCodes;
      }

      @Override
      protected void handleError(FacebookException var1) {
         VideoUploader.logError(var1, "Video '%s' failed to finish uploading", this.uploadContext.videoId);
         this.endUploadWithFailure(var1);
      }

      @Override
      protected void handleSuccess(JSONObject var1) throws JSONException {
         if (var1.getBoolean("success")) {
            this.issueResponseOnMainThread(null, this.uploadContext.videoId);
         } else {
            this.handleError(new FacebookException("Unexpected error in server response"));
         }
      }
   }

   private static class StartUploadWorkItem extends VideoUploader.UploadWorkItemBase {
      static final Set<Integer> transientErrorCodes = new HashSet<Integer>() {
         {
            this.add(6000);
         }
      };

      public StartUploadWorkItem(VideoUploader.UploadContext var1, int var2) {
         super(var1, var2);
      }

      @Override
      protected void enqueueRetry(int var1) {
         VideoUploader.enqueueUploadStart(this.uploadContext, var1);
      }

      @Override
      public Bundle getParameters() {
         Bundle var1 = new Bundle();
         var1.putString("upload_phase", "start");
         var1.putLong("file_size", this.uploadContext.videoSize);
         return var1;
      }

      @Override
      protected Set<Integer> getTransientErrorCodes() {
         return transientErrorCodes;
      }

      @Override
      protected void handleError(FacebookException var1) {
         VideoUploader.logError(var1, "Error starting video upload");
         this.endUploadWithFailure(var1);
      }

      @Override
      protected void handleSuccess(JSONObject var1) throws JSONException {
         this.uploadContext.sessionId = var1.getString("upload_session_id");
         this.uploadContext.videoId = var1.getString("video_id");
         String var2 = var1.getString("start_offset");
         String var3 = var1.getString("end_offset");
         VideoUploader.enqueueUploadChunk(this.uploadContext, var2, var3, 0);
      }
   }

   private static class TransferChunkWorkItem extends VideoUploader.UploadWorkItemBase {
      static final Set<Integer> transientErrorCodes = new HashSet<Integer>() {
         {
            this.add(1363019);
            this.add(1363021);
            this.add(1363030);
            this.add(1363033);
            this.add(1363041);
         }
      };
      private String chunkEnd;
      private String chunkStart;

      public TransferChunkWorkItem(VideoUploader.UploadContext var1, String var2, String var3, int var4) {
         super(var1, var4);
         this.chunkStart = var2;
         this.chunkEnd = var3;
      }

      @Override
      protected void enqueueRetry(int var1) {
         VideoUploader.enqueueUploadChunk(this.uploadContext, this.chunkStart, this.chunkEnd, var1);
      }

      @Override
      public Bundle getParameters() throws IOException {
         Bundle var1 = new Bundle();
         var1.putString("upload_phase", "transfer");
         var1.putString("upload_session_id", this.uploadContext.sessionId);
         var1.putString("start_offset", this.chunkStart);
         byte[] var2 = VideoUploader.getChunk(this.uploadContext, this.chunkStart, this.chunkEnd);
         if (var2 != null) {
            var1.putByteArray("video_file_chunk", var2);
            return var1;
         } else {
            throw new FacebookException("Error reading video");
         }
      }

      @Override
      protected Set<Integer> getTransientErrorCodes() {
         return transientErrorCodes;
      }

      @Override
      protected void handleError(FacebookException var1) {
         VideoUploader.logError(var1, "Error uploading video '%s'", this.uploadContext.videoId);
         this.endUploadWithFailure(var1);
      }

      @Override
      protected void handleSuccess(JSONObject var1) throws JSONException {
         String var2 = var1.getString("start_offset");
         String var3 = var1.getString("end_offset");
         if (Utility.areObjectsEqual(var2, var3)) {
            VideoUploader.enqueueUploadFinish(this.uploadContext, 0);
         } else {
            VideoUploader.enqueueUploadChunk(this.uploadContext, var2, var3, 0);
         }
      }
   }

   private static class UploadContext {
      public final AccessToken accessToken;
      public final FacebookCallback<Sharer.Result> callback;
      public String chunkStart = "0";
      public final String description;
      public final String graphNode;
      public boolean isCanceled;
      public Bundle params;
      public final String ref;
      public String sessionId;
      public final String title;
      public String videoId;
      public long videoSize;
      public InputStream videoStream;
      public final Uri videoUri;
      public WorkQueue.WorkItem workItem;

      private UploadContext(ShareVideoContent var1, String var2, FacebookCallback<Sharer.Result> var3) {
         this.accessToken = AccessToken.getCurrentAccessToken();
         this.videoUri = var1.getVideo().getLocalUrl();
         this.title = var1.getContentTitle();
         this.description = var1.getContentDescription();
         this.ref = var1.getRef();
         this.graphNode = var2;
         this.callback = var3;
         this.params = var1.getVideo().getParameters();
         if (!Utility.isNullOrEmpty(var1.getPeopleIds())) {
            this.params.putString("tags", TextUtils.join(", ", var1.getPeopleIds()));
         }

         if (!Utility.isNullOrEmpty(var1.getPlaceId())) {
            this.params.putString("place", var1.getPlaceId());
         }

         if (!Utility.isNullOrEmpty(var1.getRef())) {
            this.params.putString("ref", var1.getRef());
         }
      }

      private void initialize() throws FileNotFoundException {
         try {
            if (Utility.isFileUri(this.videoUri)) {
               File var1 = new File(this.videoUri.getPath());
               ParcelFileDescriptor var2 = ParcelFileDescriptor.open(var1, 268435456);
               this.videoSize = var2.getStatSize();
               AutoCloseInputStream var4 = new AutoCloseInputStream(var2);
               this.videoStream = var4;
            } else {
               if (!Utility.isContentUri(this.videoUri)) {
                  FacebookException var5 = new FacebookException("Uri must be a content:// or file:// uri");
                  throw var5;
               }

               this.videoSize = Utility.getContentSize(this.videoUri);
               this.videoStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(this.videoUri);
            }
         } catch (FileNotFoundException var3) {
            Utility.closeQuietly(this.videoStream);
            throw var3;
         }
      }
   }

   private abstract static class UploadWorkItemBase implements Runnable {
      protected int completedRetries;
      protected VideoUploader.UploadContext uploadContext;

      protected UploadWorkItemBase(VideoUploader.UploadContext var1, int var2) {
         this.uploadContext = var1;
         this.completedRetries = var2;
      }

      private boolean attemptRetry(int var1) {
         boolean var2;
         if (this.completedRetries < 2 && this.getTransientErrorCodes().contains(var1)) {
            var1 = (int)Math.pow(3.0, this.completedRetries);
            VideoUploader.getHandler().postDelayed(new Runnable(this) {
               final VideoUploader.UploadWorkItemBase this$0;

               {
                  this.this$0 = var1;
               }

               @Override
               public void run() {
                  this.this$0.enqueueRetry(this.this$0.completedRetries + 1);
               }
            }, var1 * 5000);
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      protected void endUploadWithFailure(FacebookException var1) {
         this.issueResponseOnMainThread(var1, null);
      }

      protected abstract void enqueueRetry(int var1);

      protected void executeGraphRequestSynchronously(Bundle var1) {
         GraphResponse var5 = new GraphRequest(
               this.uploadContext.accessToken, String.format(Locale.ROOT, "%s/videos", this.uploadContext.graphNode), var1, HttpMethod.POST, null
            )
            .executeAndWait();
         if (var5 != null) {
            FacebookRequestError var3 = var5.getError();
            JSONObject var2 = var5.getJSONObject();
            if (var3 != null) {
               if (!this.attemptRetry(var3.getSubErrorCode())) {
                  this.handleError(new FacebookGraphResponseException(var5, "Video upload failed"));
               }
            } else if (var2 != null) {
               try {
                  this.handleSuccess(var2);
               } catch (JSONException var4) {
                  this.endUploadWithFailure(new FacebookException("Unexpected error in server response", var4));
               }
            } else {
               this.handleError(new FacebookException("Unexpected error in server response"));
            }
         } else {
            this.handleError(new FacebookException("Unexpected error in server response"));
         }
      }

      protected abstract Bundle getParameters() throws Exception;

      protected abstract Set<Integer> getTransientErrorCodes();

      protected abstract void handleError(FacebookException var1);

      protected abstract void handleSuccess(JSONObject var1) throws JSONException;

      protected void issueResponseOnMainThread(FacebookException var1, String var2) {
         VideoUploader.getHandler().post(new Runnable(this, var1, var2) {
            final VideoUploader.UploadWorkItemBase this$0;
            final FacebookException val$error;
            final String val$videoId;

            {
               this.this$0 = var1;
               this.val$error = var2x;
               this.val$videoId = var3;
            }

            @Override
            public void run() {
               VideoUploader.issueResponse(this.this$0.uploadContext, this.val$error, this.val$videoId);
            }
         });
      }

      @Override
      public void run() {
         if (!this.uploadContext.isCanceled) {
            try {
               this.executeGraphRequestSynchronously(this.getParameters());
            } catch (FacebookException var2) {
               this.endUploadWithFailure(var2);
            } catch (Exception var3) {
               this.endUploadWithFailure(new FacebookException("Video upload failed", var3));
            }
         } else {
            this.endUploadWithFailure(null);
         }
      }
   }
}
