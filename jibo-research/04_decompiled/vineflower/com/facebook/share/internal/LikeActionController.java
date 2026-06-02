package com.facebook.share.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.BundleJSONConverter;
import com.facebook.internal.FileLruCache;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.Logger;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.PlatformServiceClient;
import com.facebook.internal.Utility;
import com.facebook.internal.WorkQueue;
import com.facebook.share.widget.LikeView;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LikeActionController {
   public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_ERROR = "com.facebook.sdk.LikeActionController.DID_ERROR";
   public static final String ACTION_LIKE_ACTION_CONTROLLER_DID_RESET = "com.facebook.sdk.LikeActionController.DID_RESET";
   public static final String ACTION_LIKE_ACTION_CONTROLLER_UPDATED = "com.facebook.sdk.LikeActionController.UPDATED";
   public static final String ACTION_OBJECT_ID_KEY = "com.facebook.sdk.LikeActionController.OBJECT_ID";
   private static final int ERROR_CODE_OBJECT_ALREADY_LIKED = 3501;
   public static final String ERROR_INVALID_OBJECT_ID = "Invalid Object Id";
   public static final String ERROR_PUBLISH_ERROR = "Unable to publish the like/unlike action";
   private static final String JSON_BOOL_IS_OBJECT_LIKED_KEY = "is_object_liked";
   private static final String JSON_BUNDLE_FACEBOOK_DIALOG_ANALYTICS_BUNDLE = "facebook_dialog_analytics_bundle";
   private static final String JSON_INT_OBJECT_TYPE_KEY = "object_type";
   private static final String JSON_INT_VERSION_KEY = "com.facebook.share.internal.LikeActionController.version";
   private static final String JSON_STRING_LIKE_COUNT_WITHOUT_LIKE_KEY = "like_count_string_without_like";
   private static final String JSON_STRING_LIKE_COUNT_WITH_LIKE_KEY = "like_count_string_with_like";
   private static final String JSON_STRING_OBJECT_ID_KEY = "object_id";
   private static final String JSON_STRING_SOCIAL_SENTENCE_WITHOUT_LIKE_KEY = "social_sentence_without_like";
   private static final String JSON_STRING_SOCIAL_SENTENCE_WITH_LIKE_KEY = "social_sentence_with_like";
   private static final String JSON_STRING_UNLIKE_TOKEN_KEY = "unlike_token";
   private static final String LIKE_ACTION_CONTROLLER_STORE = "com.facebook.LikeActionController.CONTROLLER_STORE_KEY";
   private static final String LIKE_ACTION_CONTROLLER_STORE_OBJECT_SUFFIX_KEY = "OBJECT_SUFFIX";
   private static final String LIKE_ACTION_CONTROLLER_STORE_PENDING_OBJECT_ID_KEY = "PENDING_CONTROLLER_KEY";
   private static final int LIKE_ACTION_CONTROLLER_VERSION = 3;
   private static final String LIKE_DIALOG_RESPONSE_LIKE_COUNT_STRING_KEY = "like_count_string";
   private static final String LIKE_DIALOG_RESPONSE_OBJECT_IS_LIKED_KEY = "object_is_liked";
   private static final String LIKE_DIALOG_RESPONSE_SOCIAL_SENTENCE_KEY = "social_sentence";
   private static final String LIKE_DIALOG_RESPONSE_UNLIKE_TOKEN_KEY = "unlike_token";
   private static final int MAX_CACHE_SIZE = 128;
   private static final int MAX_OBJECT_SUFFIX = 1000;
   private static final String TAG = LikeActionController.class.getSimpleName();
   private static AccessTokenTracker accessTokenTracker;
   private static final ConcurrentHashMap<String, LikeActionController> cache = new ConcurrentHashMap<>();
   private static FileLruCache controllerDiskCache;
   private static WorkQueue diskIOWorkQueue = new WorkQueue(1);
   private static Handler handler;
   private static boolean isInitialized;
   private static WorkQueue mruCacheWorkQueue = new WorkQueue(1);
   private static String objectIdForPendingController;
   private static volatile int objectSuffix;
   private AppEventsLogger appEventsLogger;
   private Bundle facebookDialogAnalyticsBundle;
   private boolean isObjectLiked;
   private boolean isObjectLikedOnServer;
   private boolean isPendingLikeOrUnlike;
   private String likeCountStringWithLike;
   private String likeCountStringWithoutLike;
   private String objectId;
   private boolean objectIsPage;
   private LikeView.ObjectType objectType;
   private String socialSentenceWithLike;
   private String socialSentenceWithoutLike;
   private String unlikeToken;
   private String verifiedObjectId;

   private LikeActionController(String var1, LikeView.ObjectType var2) {
      this.objectId = var1;
      this.objectType = var2;
   }

   private static void broadcastAction(LikeActionController var0, String var1) {
      broadcastAction(var0, var1, null);
   }

   private static void broadcastAction(LikeActionController var0, String var1, Bundle var2) {
      Intent var3 = new Intent(var1);
      Bundle var4 = var2;
      if (var0 != null) {
         var4 = var2;
         if (var2 == null) {
            var4 = new Bundle();
         }

         var4.putString("com.facebook.sdk.LikeActionController.OBJECT_ID", var0.getObjectId());
      }

      if (var4 != null) {
         var3.putExtras(var4);
      }

      LocalBroadcastManager.a(FacebookSdk.getApplicationContext()).a(var3);
   }

   private boolean canUseOGPublish() {
      AccessToken var2 = AccessToken.getCurrentAccessToken();
      boolean var1;
      if (!this.objectIsPage
         && this.verifiedObjectId != null
         && var2 != null
         && var2.getPermissions() != null
         && var2.getPermissions().contains("publish_actions")) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private void clearState() {
      this.facebookDialogAnalyticsBundle = null;
      storeObjectIdForPendingController(null);
   }

   private static void createControllerForObjectIdAndType(String var0, LikeView.ObjectType var1, LikeActionController.CreationCallback var2) {
      LikeActionController var3 = getControllerFromInMemoryCache(var0);
      if (var3 != null) {
         verifyControllerAndInvokeCallback(var3, var1, var2);
      } else {
         LikeActionController var4 = deserializeFromDiskSynchronously(var0);
         var3 = var4;
         if (var4 == null) {
            var3 = new LikeActionController(var0, var1);
            serializeToDiskAsync(var3);
         }

         putControllerInMemoryCache(var0, var3);
         handler.post(new Runnable(var3) {
            final LikeActionController val$controllerToRefresh;

            {
               this.val$controllerToRefresh = var1;
            }

            @Override
            public void run() {
               this.val$controllerToRefresh.refreshStatusAsync();
            }
         });
         invokeCallbackWithController(var2, var3, null);
      }
   }

   private static LikeActionController deserializeFromDiskSynchronously(String param0) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 3
      // 02: aconst_null
      // 03: astore 4
      // 05: aload 0
      // 06: invokestatic com/facebook/share/internal/LikeActionController.getCacheKeyForObjectId (Ljava/lang/String;)Ljava/lang/String;
      // 09: astore 0
      // 0a: getstatic com/facebook/share/internal/LikeActionController.controllerDiskCache Lcom/facebook/internal/FileLruCache;
      // 0d: aload 0
      // 0e: invokevirtual com/facebook/internal/FileLruCache.get (Ljava/lang/String;)Ljava/io/InputStream;
      // 11: astore 1
      // 12: aload 4
      // 14: astore 2
      // 15: aload 1
      // 16: ifnull 36
      // 19: aload 1
      // 1a: astore 0
      // 1b: aload 1
      // 1c: invokestatic com/facebook/internal/Utility.readStreamToString (Ljava/io/InputStream;)Ljava/lang/String;
      // 1f: astore 5
      // 21: aload 4
      // 23: astore 2
      // 24: aload 1
      // 25: astore 0
      // 26: aload 5
      // 28: invokestatic com/facebook/internal/Utility.isNullOrEmpty (Ljava/lang/String;)Z
      // 2b: ifne 36
      // 2e: aload 1
      // 2f: astore 0
      // 30: aload 5
      // 32: invokestatic com/facebook/share/internal/LikeActionController.deserializeFromJson (Ljava/lang/String;)Lcom/facebook/share/internal/LikeActionController;
      // 35: astore 2
      // 36: aload 2
      // 37: astore 0
      // 38: aload 1
      // 39: ifnull 42
      // 3c: aload 1
      // 3d: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 40: aload 2
      // 41: astore 0
      // 42: aload 0
      // 43: areturn
      // 44: astore 2
      // 45: aconst_null
      // 46: astore 1
      // 47: aload 1
      // 48: astore 0
      // 49: getstatic com/facebook/share/internal/LikeActionController.TAG Ljava/lang/String;
      // 4c: ldc_w "Unable to deserialize controller from disk"
      // 4f: aload 2
      // 50: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 53: pop
      // 54: aload 3
      // 55: astore 0
      // 56: aload 1
      // 57: ifnull 42
      // 5a: aload 1
      // 5b: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 5e: aload 3
      // 5f: astore 0
      // 60: goto 42
      // 63: astore 1
      // 64: aconst_null
      // 65: astore 0
      // 66: aload 0
      // 67: ifnull 6e
      // 6a: aload 0
      // 6b: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 6e: aload 1
      // 6f: athrow
      // 70: astore 1
      // 71: goto 66
      // 74: astore 2
      // 75: goto 47
      // try (4 -> 11): 42 java/io/IOException
      // try (4 -> 11): 61 null
      // try (17 -> 20): 72 java/io/IOException
      // try (17 -> 20): 70 null
      // try (24 -> 27): 72 java/io/IOException
      // try (24 -> 27): 70 null
      // try (29 -> 32): 72 java/io/IOException
      // try (29 -> 32): 70 null
      // try (47 -> 52): 70 null
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static LikeActionController deserializeFromJson(String var0) {
      LikeActionController var2 = null;

      JSONObject var3;
      try {
         var3 = new JSONObject(var0);
         if (var3.optInt("com.facebook.share.internal.LikeActionController.version", -1) != 3) {
            return var2;
         }
      } catch (JSONException var6) {
         Log.e(TAG, "Unable to deserialize controller from JSON", var6);
         return null;
      }

      try {
         var0 = var3.getString("object_id");
         int var1 = var3.optInt("object_type", LikeView.ObjectType.UNKNOWN.getValue());
         var2 = new LikeActionController(var0, LikeView.ObjectType.fromInt(var1));
         var2.likeCountStringWithLike = var3.optString("like_count_string_with_like", null);
         var2.likeCountStringWithoutLike = var3.optString("like_count_string_without_like", null);
         var2.socialSentenceWithLike = var3.optString("social_sentence_with_like", null);
         var2.socialSentenceWithoutLike = var3.optString("social_sentence_without_like", null);
         var2.isObjectLiked = var3.optBoolean("is_object_liked");
         var2.unlikeToken = var3.optString("unlike_token", null);
         var3 = var3.optJSONObject("facebook_dialog_analytics_bundle");
      } catch (JSONException var5) {
         Log.e(TAG, "Unable to deserialize controller from JSON", var5);
         return null;
      }

      LikeActionController var7 = var2;
      if (var3 != null) {
         try {
            var2.facebookDialogAnalyticsBundle = BundleJSONConverter.convertToBundle(var3);
         } catch (JSONException var4) {
            Log.e(TAG, "Unable to deserialize controller from JSON", var4);
            return null;
         }

         var7 = var2;
      }

      return var7;
   }

   private void fetchVerifiedObjectId(LikeActionController.RequestCompletionCallback var1) {
      if (!Utility.isNullOrEmpty(this.verifiedObjectId)) {
         if (var1 != null) {
            var1.onComplete();
         }
      } else {
         LikeActionController.GetOGObjectIdRequestWrapper var4 = new LikeActionController.GetOGObjectIdRequestWrapper(this, this.objectId, this.objectType);
         LikeActionController.GetPageIdRequestWrapper var2 = new LikeActionController.GetPageIdRequestWrapper(this, this.objectId, this.objectType);
         GraphRequestBatch var3 = new GraphRequestBatch();
         var4.addToBatch(var3);
         var2.addToBatch(var3);
         var3.addCallback(
            new GraphRequestBatch.Callback(this, var4, var2, var1) {
               final LikeActionController this$0;
               final LikeActionController.RequestCompletionCallback val$completionHandler;
               final LikeActionController.GetOGObjectIdRequestWrapper val$objectIdRequest;
               final LikeActionController.GetPageIdRequestWrapper val$pageIdRequest;

               {
                  this.this$0 = var1;
                  this.val$objectIdRequest = var2x;
                  this.val$pageIdRequest = var3x;
                  this.val$completionHandler = var4x;
               }

               @Override
               public void onBatchCompleted(GraphRequestBatch var1) {
                  this.this$0.verifiedObjectId = this.val$objectIdRequest.verifiedObjectId;
                  if (Utility.isNullOrEmpty(this.this$0.verifiedObjectId)) {
                     this.this$0.verifiedObjectId = this.val$pageIdRequest.verifiedObjectId;
                     this.this$0.objectIsPage = this.val$pageIdRequest.objectIsPage;
                  }

                  if (Utility.isNullOrEmpty(this.this$0.verifiedObjectId)) {
                     Logger.log(
                        LoggingBehavior.DEVELOPER_ERRORS,
                        LikeActionController.TAG,
                        "Unable to verify the FB id for '%s'. Verify that it is a valid FB object or page",
                        this.this$0.objectId
                     );
                     LikeActionController var2x = this.this$0;
                     FacebookRequestError var3x;
                     if (this.val$pageIdRequest.getError() != null) {
                        var3x = this.val$pageIdRequest.getError();
                     } else {
                        var3x = this.val$objectIdRequest.getError();
                     }

                     var2x.logAppEventForError("get_verified_id", var3x);
                  }

                  if (this.val$completionHandler != null) {
                     this.val$completionHandler.onComplete();
                  }
               }
            }
         );
         var3.executeAsync();
      }
   }

   private AppEventsLogger getAppEventsLogger() {
      if (this.appEventsLogger == null) {
         this.appEventsLogger = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
      }

      return this.appEventsLogger;
   }

   private static String getCacheKeyForObjectId(String var0) {
      String var1 = null;
      AccessToken var2 = AccessToken.getCurrentAccessToken();
      if (var2 != null) {
         var1 = var2.getToken();
      }

      String var3 = var1;
      if (var1 != null) {
         var3 = Utility.md5hash(var1);
      }

      return String.format(Locale.ROOT, "%s|%s|com.fb.sdk.like|%d", var0, Utility.coerceValueIfNullOrEmpty(var3, ""), objectSuffix);
   }

   public static void getControllerForObjectId(String var0, LikeView.ObjectType var1, LikeActionController.CreationCallback var2) {
      if (!isInitialized) {
         performFirstInitialize();
      }

      LikeActionController var3 = getControllerFromInMemoryCache(var0);
      if (var3 != null) {
         verifyControllerAndInvokeCallback(var3, var1, var2);
      } else {
         diskIOWorkQueue.addActiveWorkItem(new LikeActionController.CreateLikeActionControllerWorkItem(var0, var1, var2));
      }
   }

   private static LikeActionController getControllerFromInMemoryCache(String var0) {
      String var1 = getCacheKeyForObjectId(var0);
      LikeActionController var2 = cache.get(var1);
      if (var2 != null) {
         mruCacheWorkQueue.addActiveWorkItem(new LikeActionController.MRUCacheWorkItem(var1, false));
      }

      return var2;
   }

   private ResultProcessor getResultProcessor(Bundle var1) {
      return new ResultProcessor(this, null, var1) {
         final LikeActionController this$0;
         final Bundle val$analyticsParameters;

         {
            this.this$0 = var1;
            this.val$analyticsParameters = var3;
         }

         @Override
         public void onCancel(AppCall var1) {
            this.onError(var1, new FacebookOperationCanceledException());
         }

         @Override
         public void onError(AppCall var1, FacebookException var2) {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Like Dialog failed with error : %s", var2);
            Bundle var3;
            if (this.val$analyticsParameters == null) {
               var3 = new Bundle();
            } else {
               var3 = this.val$analyticsParameters;
            }

            var3.putString("call_id", var1.getCallId().toString());
            this.this$0.logAppEventForError("present_dialog", var3);
            LikeActionController.broadcastAction(this.this$0, "com.facebook.sdk.LikeActionController.DID_ERROR", NativeProtocol.createBundleForException(var2));
         }

         @Override
         public void onSuccess(AppCall var1, Bundle var2) {
            if (var2 != null && var2.containsKey("object_is_liked")) {
               boolean var3 = var2.getBoolean("object_is_liked");
               String var4 = this.this$0.likeCountStringWithLike;
               String var5 = this.this$0.likeCountStringWithoutLike;
               if (var2.containsKey("like_count_string")) {
                  var5 = var2.getString("like_count_string");
                  var4 = var5;
               }

               String var6 = this.this$0.socialSentenceWithLike;
               String var7 = this.this$0.socialSentenceWithoutLike;
               if (var2.containsKey("social_sentence")) {
                  var7 = var2.getString("social_sentence");
                  var6 = var7;
               }

               String var9;
               if (var2.containsKey("object_is_liked")) {
                  var9 = var2.getString("unlike_token");
               } else {
                  var9 = this.this$0.unlikeToken;
               }

               Bundle var8;
               if (this.val$analyticsParameters == null) {
                  var8 = new Bundle();
               } else {
                  var8 = this.val$analyticsParameters;
               }

               var8.putString("call_id", var1.getCallId().toString());
               this.this$0.getAppEventsLogger().logSdkEvent("fb_like_control_dialog_did_succeed", null, var8);
               this.this$0.updateState(var3, var4, var5, var6, var7, var9);
            }
         }
      };
   }

   public static boolean handleOnActivityResult(int var0, int var1, Intent var2) {
      boolean var3 = false;
      if (Utility.isNullOrEmpty(objectIdForPendingController)) {
         objectIdForPendingController = FacebookSdk.getApplicationContext()
            .getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0)
            .getString("PENDING_CONTROLLER_KEY", null);
      }

      if (!Utility.isNullOrEmpty(objectIdForPendingController)) {
         getControllerForObjectId(objectIdForPendingController, LikeView.ObjectType.UNKNOWN, new LikeActionController.CreationCallback(var0, var1, var2) {
            final Intent val$data;
            final int val$requestCode;
            final int val$resultCode;

            {
               this.val$requestCode = var1;
               this.val$resultCode = var2x;
               this.val$data = var3x;
            }

            @Override
            public void onComplete(LikeActionController var1, FacebookException var2x) {
               if (var2x == null) {
                  var1.onActivityResult(this.val$requestCode, this.val$resultCode, this.val$data);
               } else {
                  Utility.logd(LikeActionController.TAG, var2x);
               }
            }
         });
         var3 = true;
      }

      return var3;
   }

   private static void invokeCallbackWithController(LikeActionController.CreationCallback var0, LikeActionController var1, FacebookException var2) {
      if (var0 != null) {
         handler.post(new Runnable(var0, var1, var2) {
            final LikeActionController.CreationCallback val$callback;
            final LikeActionController val$controller;
            final FacebookException val$error;

            {
               this.val$callback = var1;
               this.val$controller = var2x;
               this.val$error = var3;
            }

            @Override
            public void run() {
               this.val$callback.onComplete(this.val$controller, this.val$error);
            }
         });
      }
   }

   private void logAppEventForError(String var1, Bundle var2) {
      var2 = new Bundle(var2);
      var2.putString("object_id", this.objectId);
      var2.putString("object_type", this.objectType.toString());
      var2.putString("current_action", var1);
      this.getAppEventsLogger().logSdkEvent("fb_like_control_error", null, var2);
   }

   private void logAppEventForError(String var1, FacebookRequestError var2) {
      Bundle var3 = new Bundle();
      if (var2 != null) {
         JSONObject var4 = var2.getRequestResult();
         if (var4 != null) {
            var3.putString("error", var4.toString());
         }
      }

      this.logAppEventForError(var1, var3);
   }

   private void onActivityResult(int var1, int var2, Intent var3) {
      ShareInternalUtility.handleActivityResult(var1, var2, var3, this.getResultProcessor(this.facebookDialogAnalyticsBundle));
      this.clearState();
   }

   private static void performFirstInitialize() {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
      //   at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
      //   at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
      //   at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
      //   at java.base/java.util.Objects.checkIndex(Objects.java:361)
      //   at java.base/java.util.ArrayList.remove(ArrayList.java:504)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.removeExceptionInstructionsEx(FinallyProcessor.java:1065)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.verifyFinallyEx(FinallyProcessor.java:566)
      //   at org.jetbrains.java.decompiler.modules.decompiler.FinallyProcessor.iterateGraph(FinallyProcessor.java:90)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:185)
      //
      // Bytecode:
      // 00: ldc com/facebook/share/internal/LikeActionController
      // 02: monitorenter
      // 03: getstatic com/facebook/share/internal/LikeActionController.isInitialized Z
      // 06: istore 1
      // 07: iload 1
      // 08: ifeq 0f
      // 0b: ldc com/facebook/share/internal/LikeActionController
      // 0d: monitorexit
      // 0e: return
      // 0f: new android/os/Handler
      // 12: astore 2
      // 13: aload 2
      // 14: invokestatic android/os/Looper.getMainLooper ()Landroid/os/Looper;
      // 17: invokespecial android/os/Handler.<init> (Landroid/os/Looper;)V
      // 1a: aload 2
      // 1b: putstatic com/facebook/share/internal/LikeActionController.handler Landroid/os/Handler;
      // 1e: invokestatic com/facebook/FacebookSdk.getApplicationContext ()Landroid/content/Context;
      // 21: ldc "com.facebook.LikeActionController.CONTROLLER_STORE_KEY"
      // 23: bipush 0
      // 24: invokevirtual android/content/Context.getSharedPreferences (Ljava/lang/String;I)Landroid/content/SharedPreferences;
      // 27: ldc "OBJECT_SUFFIX"
      // 29: bipush 1
      // 2a: invokeinterface android/content/SharedPreferences.getInt (Ljava/lang/String;I)I 3
      // 2f: putstatic com/facebook/share/internal/LikeActionController.objectSuffix I
      // 32: new com/facebook/internal/FileLruCache
      // 35: astore 3
      // 36: getstatic com/facebook/share/internal/LikeActionController.TAG Ljava/lang/String;
      // 39: astore 2
      // 3a: new com/facebook/internal/FileLruCache$Limits
      // 3d: astore 4
      // 3f: aload 4
      // 41: invokespecial com/facebook/internal/FileLruCache$Limits.<init> ()V
      // 44: aload 3
      // 45: aload 2
      // 46: aload 4
      // 48: invokespecial com/facebook/internal/FileLruCache.<init> (Ljava/lang/String;Lcom/facebook/internal/FileLruCache$Limits;)V
      // 4b: aload 3
      // 4c: putstatic com/facebook/share/internal/LikeActionController.controllerDiskCache Lcom/facebook/internal/FileLruCache;
      // 4f: invokestatic com/facebook/share/internal/LikeActionController.registerAccessTokenTracker ()V
      // 52: getstatic com/facebook/internal/CallbackManagerImpl$RequestCodeOffset.Like Lcom/facebook/internal/CallbackManagerImpl$RequestCodeOffset;
      // 55: invokevirtual com/facebook/internal/CallbackManagerImpl$RequestCodeOffset.toRequestCode ()I
      // 58: istore 0
      // 59: new com/facebook/share/internal/LikeActionController$3
      // 5c: astore 2
      // 5d: aload 2
      // 5e: invokespecial com/facebook/share/internal/LikeActionController$3.<init> ()V
      // 61: iload 0
      // 62: aload 2
      // 63: invokestatic com/facebook/internal/CallbackManagerImpl.registerStaticCallback (ILcom/facebook/internal/CallbackManagerImpl$Callback;)V
      // 66: bipush 1
      // 67: putstatic com/facebook/share/internal/LikeActionController.isInitialized Z
      // 6a: goto 0b
      // 6d: astore 2
      // 6e: ldc com/facebook/share/internal/LikeActionController
      // 70: monitorexit
      // 71: aload 2
      // 72: athrow
      // try (2 -> 4): 52 null
      // try (9 -> 51): 52 null
   }

   private void presentLikeDialog(Activity var1, FragmentWrapper var2, Bundle var3) {
      String var4;
      if (LikeDialog.canShowNativeDialog()) {
         var4 = "fb_like_control_did_present_dialog";
      } else if (LikeDialog.canShowWebFallback()) {
         var4 = "fb_like_control_did_present_fallback_dialog";
      } else {
         this.logAppEventForError("present_dialog", var3);
         Utility.logd(TAG, "Cannot show the Like Dialog on this device.");
         broadcastAction(null, "com.facebook.sdk.LikeActionController.UPDATED");
         var4 = null;
      }

      if (var4 != null) {
         if (this.objectType != null) {
            var4 = this.objectType.toString();
         } else {
            var4 = LikeView.ObjectType.UNKNOWN.toString();
         }

         LikeContent var6 = new LikeContent.Builder().setObjectId(this.objectId).setObjectType(var4).build();
         if (var2 != null) {
            new LikeDialog(var2).show(var6);
         } else {
            new LikeDialog(var1).show(var6);
         }

         this.saveState(var3);
         this.getAppEventsLogger().logSdkEvent("fb_like_control_did_present_dialog", null, var3);
      }
   }

   private void publishAgainIfNeeded(Bundle var1) {
      if (this.isObjectLiked != this.isObjectLikedOnServer && !this.publishLikeOrUnlikeAsync(this.isObjectLiked, var1)) {
         boolean var2;
         if (!this.isObjectLiked) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.publishDidError(var2);
      }
   }

   private void publishDidError(boolean var1) {
      this.updateLikeState(var1);
      Bundle var2 = new Bundle();
      var2.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Unable to publish the like/unlike action");
      broadcastAction(this, "com.facebook.sdk.LikeActionController.DID_ERROR", var2);
   }

   private void publishLikeAsync(Bundle var1) {
      this.isPendingLikeOrUnlike = true;
      this.fetchVerifiedObjectId(
         new LikeActionController.RequestCompletionCallback(this, var1) {
            final LikeActionController this$0;
            final Bundle val$analyticsParameters;

            {
               this.this$0 = var1;
               this.val$analyticsParameters = var2;
            }

            @Override
            public void onComplete() {
               if (Utility.isNullOrEmpty(this.this$0.verifiedObjectId)) {
                  Bundle var1x = new Bundle();
                  var1x.putString("com.facebook.platform.status.ERROR_DESCRIPTION", "Invalid Object Id");
                  LikeActionController.broadcastAction(this.this$0, "com.facebook.sdk.LikeActionController.DID_ERROR", var1x);
               } else {
                  GraphRequestBatch var3 = new GraphRequestBatch();
                  LikeActionController.PublishLikeRequestWrapper var2 = this.this$0.new PublishLikeRequestWrapper(
                     this.this$0, this.this$0.verifiedObjectId, this.this$0.objectType
                  );
                  var2.addToBatch(var3);
                  var3.addCallback(new GraphRequestBatch.Callback(this, var2) {
                     final <unrepresentable> this$1;
                     final LikeActionController.PublishLikeRequestWrapper val$likeRequest;

                     {
                        this.this$1 = var1;
                        this.val$likeRequest = var2x;
                     }

                     @Override
                     public void onBatchCompleted(GraphRequestBatch var1) {
                        this.this$1.this$0.isPendingLikeOrUnlike = false;
                        if (this.val$likeRequest.getError() != null) {
                           this.this$1.this$0.publishDidError(false);
                        } else {
                           this.this$1.this$0.unlikeToken = Utility.coerceValueIfNullOrEmpty(this.val$likeRequest.unlikeToken, null);
                           this.this$1.this$0.isObjectLikedOnServer = true;
                           this.this$1.this$0.getAppEventsLogger().logSdkEvent("fb_like_control_did_like", null, this.this$1.val$analyticsParameters);
                           this.this$1.this$0.publishAgainIfNeeded(this.this$1.val$analyticsParameters);
                        }
                     }
                  });
                  var3.executeAsync();
               }
            }
         }
      );
   }

   private boolean publishLikeOrUnlikeAsync(boolean var1, Bundle var2) {
      boolean var3 = true;
      if (this.canUseOGPublish()) {
         if (var1) {
            this.publishLikeAsync(var2);
            return var3;
         }

         if (!Utility.isNullOrEmpty(this.unlikeToken)) {
            this.publishUnlikeAsync(var2);
            return var3;
         }
      }

      return false;
   }

   private void publishUnlikeAsync(Bundle var1) {
      this.isPendingLikeOrUnlike = true;
      GraphRequestBatch var3 = new GraphRequestBatch();
      LikeActionController.PublishUnlikeRequestWrapper var2 = new LikeActionController.PublishUnlikeRequestWrapper(this, this.unlikeToken);
      var2.addToBatch(var3);
      var3.addCallback(new GraphRequestBatch.Callback(this, var2, var1) {
         final LikeActionController this$0;
         final Bundle val$analyticsParameters;
         final LikeActionController.PublishUnlikeRequestWrapper val$unlikeRequest;

         {
            this.this$0 = var1;
            this.val$unlikeRequest = var2x;
            this.val$analyticsParameters = var3x;
         }

         @Override
         public void onBatchCompleted(GraphRequestBatch var1) {
            this.this$0.isPendingLikeOrUnlike = false;
            if (this.val$unlikeRequest.getError() != null) {
               this.this$0.publishDidError(true);
            } else {
               this.this$0.unlikeToken = null;
               this.this$0.isObjectLikedOnServer = false;
               this.this$0.getAppEventsLogger().logSdkEvent("fb_like_control_did_unlike", null, this.val$analyticsParameters);
               this.this$0.publishAgainIfNeeded(this.val$analyticsParameters);
            }
         }
      });
      var3.executeAsync();
   }

   private static void putControllerInMemoryCache(String var0, LikeActionController var1) {
      var0 = getCacheKeyForObjectId(var0);
      mruCacheWorkQueue.addActiveWorkItem(new LikeActionController.MRUCacheWorkItem(var0, true));
      cache.put(var0, var1);
   }

   private void refreshStatusAsync() {
      if (AccessToken.getCurrentAccessToken() == null) {
         this.refreshStatusViaService();
      } else {
         this.fetchVerifiedObjectId(
            new LikeActionController.RequestCompletionCallback(this) {
               final LikeActionController this$0;

               {
                  this.this$0 = var1;
               }

               @Override
               public void onComplete() {
                  LikeActionController.AbstractRequestWrapper var1;
                  switch (<unrepresentable>.$SwitchMap$com$facebook$share$widget$LikeView$ObjectType[this.this$0.objectType.ordinal()]) {
                     case 1:
                        var1 = this.this$0.new GetPageLikesRequestWrapper(this.this$0, this.this$0.verifiedObjectId);
                        break;
                     default:
                        var1 = this.this$0.new GetOGObjectLikesRequestWrapper(this.this$0, this.this$0.verifiedObjectId, this.this$0.objectType);
                  }

                  LikeActionController.GetEngagementRequestWrapper var2 = this.this$0.new GetEngagementRequestWrapper(
                     this.this$0, this.this$0.verifiedObjectId, this.this$0.objectType
                  );
                  GraphRequestBatch var3 = new GraphRequestBatch();
                  var1.addToBatch(var3);
                  var2.addToBatch(var3);
                  var3.addCallback(
                     new GraphRequestBatch.Callback(this, var1, var2) {
                        final <unrepresentable> this$1;
                        final LikeActionController.GetEngagementRequestWrapper val$engagementRequest;
                        final LikeActionController.LikeRequestWrapper val$likeRequestWrapper;

                        {
                           this.this$1 = var1;
                           this.val$likeRequestWrapper = var2x;
                           this.val$engagementRequest = var3x;
                        }

                        @Override
                        public void onBatchCompleted(GraphRequestBatch var1) {
                           if (this.val$likeRequestWrapper.getError() == null && this.val$engagementRequest.getError() == null) {
                              this.this$1
                                 .this$0
                                 .updateState(
                                    this.val$likeRequestWrapper.isObjectLiked(),
                                    this.val$engagementRequest.likeCountStringWithLike,
                                    this.val$engagementRequest.likeCountStringWithoutLike,
                                    this.val$engagementRequest.socialSentenceStringWithLike,
                                    this.val$engagementRequest.socialSentenceStringWithoutLike,
                                    this.val$likeRequestWrapper.getUnlikeToken()
                                 );
                           } else {
                              Logger.log(
                                 LoggingBehavior.REQUESTS, LikeActionController.TAG, "Unable to refresh like state for id: '%s'", this.this$1.this$0.objectId
                              );
                           }
                        }
                     }
                  );
                  var3.executeAsync();
               }
            }
         );
      }
   }

   private void refreshStatusViaService() {
      LikeStatusClient var1 = new LikeStatusClient(FacebookSdk.getApplicationContext(), FacebookSdk.getApplicationId(), this.objectId);
      if (var1.start()) {
         var1.setCompletedListener(new PlatformServiceClient.CompletedListener(this) {
            final LikeActionController this$0;

            {
               this.this$0 = var1;
            }

            @Override
            public void completed(Bundle var1) {
               if (var1 != null && var1.containsKey("com.facebook.platform.extra.OBJECT_IS_LIKED")) {
                  boolean var2 = var1.getBoolean("com.facebook.platform.extra.OBJECT_IS_LIKED");
                  String var3;
                  if (var1.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE")) {
                     var3 = var1.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE");
                  } else {
                     var3 = this.this$0.likeCountStringWithLike;
                  }

                  String var4;
                  if (var1.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE")) {
                     var4 = var1.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE");
                  } else {
                     var4 = this.this$0.likeCountStringWithoutLike;
                  }

                  String var5;
                  if (var1.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE")) {
                     var5 = var1.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE");
                  } else {
                     var5 = this.this$0.socialSentenceWithLike;
                  }

                  String var6;
                  if (var1.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE")) {
                     var6 = var1.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE");
                  } else {
                     var6 = this.this$0.socialSentenceWithoutLike;
                  }

                  String var7;
                  if (var1.containsKey("com.facebook.platform.extra.UNLIKE_TOKEN")) {
                     var7 = var1.getString("com.facebook.platform.extra.UNLIKE_TOKEN");
                  } else {
                     var7 = this.this$0.unlikeToken;
                  }

                  this.this$0.updateState(var2, var3, var4, var5, var6, var7);
               }
            }
         });
      }
   }

   private static void registerAccessTokenTracker() {
      accessTokenTracker = new AccessTokenTracker() {
         @Override
         protected void onCurrentAccessTokenChanged(AccessToken var1, AccessToken var2) {
            Context var3 = FacebookSdk.getApplicationContext();
            if (var2 == null) {
               LikeActionController.objectSuffix = (LikeActionController.objectSuffix + 1) % 1000;
               var3.getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0)
                  .edit()
                  .putInt("OBJECT_SUFFIX", LikeActionController.objectSuffix)
                  .apply();
               LikeActionController.cache.clear();
               LikeActionController.controllerDiskCache.clearCache();
            }

            LikeActionController.broadcastAction(null, "com.facebook.sdk.LikeActionController.DID_RESET");
         }
      };
   }

   private void saveState(Bundle var1) {
      storeObjectIdForPendingController(this.objectId);
      this.facebookDialogAnalyticsBundle = var1;
      serializeToDiskAsync(this);
   }

   private static void serializeToDiskAsync(LikeActionController var0) {
      String var1 = serializeToJson(var0);
      String var2 = getCacheKeyForObjectId(var0.objectId);
      if (!Utility.isNullOrEmpty(var1) && !Utility.isNullOrEmpty(var2)) {
         diskIOWorkQueue.addActiveWorkItem(new LikeActionController.SerializeToDiskWorkItem(var2, var1));
      }
   }

   private static void serializeToDiskSynchronously(String param0, String param1) {
      // $VF: Couldn't be decompiled
      // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
      // java.lang.RuntimeException: parsing failure!
      //   at org.jetbrains.java.decompiler.modules.decompiler.decompose.DomHelper.parseGraph(DomHelper.java:211)
      //   at org.jetbrains.java.decompiler.main.rels.MethodProcessor.codeToJava(MethodProcessor.java:174)
      //
      // Bytecode:
      // 00: aconst_null
      // 01: astore 2
      // 02: aconst_null
      // 03: astore 3
      // 04: getstatic com/facebook/share/internal/LikeActionController.controllerDiskCache Lcom/facebook/internal/FileLruCache;
      // 07: aload 0
      // 08: invokevirtual com/facebook/internal/FileLruCache.openPutStream (Ljava/lang/String;)Ljava/io/OutputStream;
      // 0b: astore 0
      // 0c: aload 0
      // 0d: astore 3
      // 0e: aload 0
      // 0f: astore 2
      // 10: aload 0
      // 11: aload 1
      // 12: invokevirtual java/lang/String.getBytes ()[B
      // 15: invokevirtual java/io/OutputStream.write ([B)V
      // 18: aload 0
      // 19: ifnull 20
      // 1c: aload 0
      // 1d: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 20: return
      // 21: astore 0
      // 22: aload 3
      // 23: astore 2
      // 24: getstatic com/facebook/share/internal/LikeActionController.TAG Ljava/lang/String;
      // 27: ldc_w "Unable to serialize controller to disk"
      // 2a: aload 0
      // 2b: invokestatic android/util/Log.e (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      // 2e: pop
      // 2f: aload 3
      // 30: ifnull 20
      // 33: aload 3
      // 34: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 37: goto 20
      // 3a: astore 0
      // 3b: aload 2
      // 3c: ifnull 43
      // 3f: aload 2
      // 40: invokestatic com/facebook/internal/Utility.closeQuietly (Ljava/io/Closeable;)V
      // 43: aload 0
      // 44: athrow
      // try (4 -> 8): 21 java/io/IOException
      // try (4 -> 8): 34 null
      // try (12 -> 16): 21 java/io/IOException
      // try (12 -> 16): 34 null
      // try (24 -> 29): 34 null
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   private static String serializeToJson(LikeActionController var0) {
      JSONObject var1 = new JSONObject();

      try {
         var1.put("com.facebook.share.internal.LikeActionController.version", 3);
         var1.put("object_id", var0.objectId);
         var1.put("object_type", var0.objectType.getValue());
         var1.put("like_count_string_with_like", var0.likeCountStringWithLike);
         var1.put("like_count_string_without_like", var0.likeCountStringWithoutLike);
         var1.put("social_sentence_with_like", var0.socialSentenceWithLike);
         var1.put("social_sentence_without_like", var0.socialSentenceWithoutLike);
         var1.put("is_object_liked", var0.isObjectLiked);
         var1.put("unlike_token", var0.unlikeToken);
         if (var0.facebookDialogAnalyticsBundle == null) {
            return var1.toString();
         }

         var5 = BundleJSONConverter.convertToJSON(var0.facebookDialogAnalyticsBundle);
      } catch (JSONException var3) {
         Log.e(TAG, "Unable to serialize controller to JSON", var3);
         return null;
      }

      if (var5 != null) {
         try {
            var1.put("facebook_dialog_analytics_bundle", var5);
         } catch (JSONException var2) {
            Log.e(TAG, "Unable to serialize controller to JSON", var2);
            return null;
         }
      }

      return var1.toString();
   }

   private static void storeObjectIdForPendingController(String var0) {
      objectIdForPendingController = var0;
      FacebookSdk.getApplicationContext()
         .getSharedPreferences("com.facebook.LikeActionController.CONTROLLER_STORE_KEY", 0)
         .edit()
         .putString("PENDING_CONTROLLER_KEY", objectIdForPendingController)
         .apply();
   }

   private void updateLikeState(boolean var1) {
      this.updateState(
         var1, this.likeCountStringWithLike, this.likeCountStringWithoutLike, this.socialSentenceWithLike, this.socialSentenceWithoutLike, this.unlikeToken
      );
   }

   private void updateState(boolean var1, String var2, String var3, String var4, String var5, String var6) {
      var2 = Utility.coerceValueIfNullOrEmpty(var2, null);
      var3 = Utility.coerceValueIfNullOrEmpty(var3, null);
      var4 = Utility.coerceValueIfNullOrEmpty(var4, null);
      var5 = Utility.coerceValueIfNullOrEmpty(var5, null);
      var6 = Utility.coerceValueIfNullOrEmpty(var6, null);
      boolean var7;
      if (var1 == this.isObjectLiked
         && Utility.areObjectsEqual(var2, this.likeCountStringWithLike)
         && Utility.areObjectsEqual(var3, this.likeCountStringWithoutLike)
         && Utility.areObjectsEqual(var4, this.socialSentenceWithLike)
         && Utility.areObjectsEqual(var5, this.socialSentenceWithoutLike)
         && Utility.areObjectsEqual(var6, this.unlikeToken)) {
         var7 = false;
      } else {
         var7 = true;
      }

      if (var7) {
         this.isObjectLiked = var1;
         this.likeCountStringWithLike = var2;
         this.likeCountStringWithoutLike = var3;
         this.socialSentenceWithLike = var4;
         this.socialSentenceWithoutLike = var5;
         this.unlikeToken = var6;
         serializeToDiskAsync(this);
         broadcastAction(this, "com.facebook.sdk.LikeActionController.UPDATED");
      }
   }

   private static void verifyControllerAndInvokeCallback(LikeActionController var0, LikeView.ObjectType var1, LikeActionController.CreationCallback var2) {
      Object var3 = null;
      LikeView.ObjectType var4 = ShareInternalUtility.getMostSpecificObjectType(var1, var0.objectType);
      FacebookException var5;
      if (var4 == null) {
         var5 = new FacebookException(
            "Object with id:\"%s\" is already marked as type:\"%s\". Cannot change the type to:\"%s\"",
            var0.objectId,
            var0.objectType.toString(),
            var1.toString()
         );
         var0 = (LikeActionController)var3;
      } else {
         var0.objectType = var4;
         var5 = null;
      }

      invokeCallbackWithController(var2, var0, var5);
   }

   public String getLikeCountString() {
      String var1;
      if (this.isObjectLiked) {
         var1 = this.likeCountStringWithLike;
      } else {
         var1 = this.likeCountStringWithoutLike;
      }

      return var1;
   }

   public String getObjectId() {
      return this.objectId;
   }

   public String getSocialSentence() {
      String var1;
      if (this.isObjectLiked) {
         var1 = this.socialSentenceWithLike;
      } else {
         var1 = this.socialSentenceWithoutLike;
      }

      return var1;
   }

   public boolean isObjectLiked() {
      return this.isObjectLiked;
   }

   public boolean shouldEnableView() {
      boolean var2 = true;
      boolean var1 = var2;
      if (!LikeDialog.canShowNativeDialog()) {
         if (LikeDialog.canShowWebFallback()) {
            var1 = var2;
         } else if (!this.objectIsPage && this.objectType != LikeView.ObjectType.PAGE) {
            AccessToken var3 = AccessToken.getCurrentAccessToken();
            if (var3 != null && var3.getPermissions() != null) {
               var1 = var2;
               if (var3.getPermissions().contains("publish_actions")) {
                  return var1;
               }
            }

            var1 = false;
         } else {
            var1 = false;
         }
      }

      return var1;
   }

   public void toggleLike(Activity var1, FragmentWrapper var2, Bundle var3) {
      boolean var5 = true;
      boolean var4;
      if (!this.isObjectLiked) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (this.canUseOGPublish()) {
         this.updateLikeState(var4);
         if (this.isPendingLikeOrUnlike) {
            this.getAppEventsLogger().logSdkEvent("fb_like_control_did_undo_quickly", null, var3);
         } else if (!this.publishLikeOrUnlikeAsync(var4, var3)) {
            if (!var4) {
               var4 = var5;
            } else {
               var4 = false;
            }

            this.updateLikeState(var4);
            this.presentLikeDialog(var1, var2, var3);
         }
      } else {
         this.presentLikeDialog(var1, var2, var3);
      }
   }

   private abstract class AbstractRequestWrapper implements LikeActionController.RequestWrapper {
      protected FacebookRequestError error;
      protected String objectId;
      protected LikeView.ObjectType objectType;
      private GraphRequest request;
      final LikeActionController this$0;

      protected AbstractRequestWrapper(LikeActionController var1, String var2, LikeView.ObjectType var3) {
         this.this$0 = var1;
         this.objectId = var2;
         this.objectType = var3;
      }

      @Override
      public void addToBatch(GraphRequestBatch var1) {
         var1.add(this.request);
      }

      @Override
      public FacebookRequestError getError() {
         return this.error;
      }

      protected void processError(FacebookRequestError var1) {
         Logger.log(
            LoggingBehavior.REQUESTS,
            LikeActionController.TAG,
            "Error running request for object '%s' with type '%s' : %s",
            this.objectId,
            this.objectType,
            var1
         );
      }

      protected abstract void processSuccess(GraphResponse var1);

      protected void setRequest(GraphRequest var1) {
         this.request = var1;
         var1.setVersion(FacebookSdk.getGraphApiVersion());
         var1.setCallback(new GraphRequest.Callback(this) {
            final LikeActionController.AbstractRequestWrapper this$1;

            {
               this.this$1 = var1;
            }

            @Override
            public void onCompleted(GraphResponse var1) {
               this.this$1.error = var1.getError();
               if (this.this$1.error != null) {
                  this.this$1.processError(this.this$1.error);
               } else {
                  this.this$1.processSuccess(var1);
               }
            }
         });
      }
   }

   private static class CreateLikeActionControllerWorkItem implements Runnable {
      private LikeActionController.CreationCallback callback;
      private String objectId;
      private LikeView.ObjectType objectType;

      CreateLikeActionControllerWorkItem(String var1, LikeView.ObjectType var2, LikeActionController.CreationCallback var3) {
         this.objectId = var1;
         this.objectType = var2;
         this.callback = var3;
      }

      @Override
      public void run() {
         LikeActionController.createControllerForObjectIdAndType(this.objectId, this.objectType, this.callback);
      }
   }

   public interface CreationCallback {
      void onComplete(LikeActionController var1, FacebookException var2);
   }

   private class GetEngagementRequestWrapper extends LikeActionController.AbstractRequestWrapper {
      String likeCountStringWithLike;
      String likeCountStringWithoutLike;
      String socialSentenceStringWithLike;
      String socialSentenceStringWithoutLike;
      final LikeActionController this$0;

      GetEngagementRequestWrapper(LikeActionController var1, String var2, LikeView.ObjectType var3) {
         super(var1, var2, var3);
         this.this$0 = var1;
         this.likeCountStringWithLike = this.this$0.likeCountStringWithLike;
         this.likeCountStringWithoutLike = this.this$0.likeCountStringWithoutLike;
         this.socialSentenceStringWithLike = this.this$0.socialSentenceWithLike;
         this.socialSentenceStringWithoutLike = this.this$0.socialSentenceWithoutLike;
         Bundle var4 = new Bundle();
         var4.putString("fields", "engagement.fields(count_string_with_like,count_string_without_like,social_sentence_with_like,social_sentence_without_like)");
         var4.putString("locale", Locale.getDefault().toString());
         this.setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), var2, var4, HttpMethod.GET));
      }

      @Override
      protected void processError(FacebookRequestError var1) {
         Logger.log(
            LoggingBehavior.REQUESTS,
            LikeActionController.TAG,
            "Error fetching engagement for object '%s' with type '%s' : %s",
            this.objectId,
            this.objectType,
            var1
         );
         this.this$0.logAppEventForError("get_engagement", var1);
      }

      @Override
      protected void processSuccess(GraphResponse var1) {
         JSONObject var2 = Utility.tryGetJSONObjectFromResponse(var1.getJSONObject(), "engagement");
         if (var2 != null) {
            this.likeCountStringWithLike = var2.optString("count_string_with_like", this.likeCountStringWithLike);
            this.likeCountStringWithoutLike = var2.optString("count_string_without_like", this.likeCountStringWithoutLike);
            this.socialSentenceStringWithLike = var2.optString("social_sentence_with_like", this.socialSentenceStringWithLike);
            this.socialSentenceStringWithoutLike = var2.optString("social_sentence_without_like", this.socialSentenceStringWithoutLike);
         }
      }
   }

   private class GetOGObjectIdRequestWrapper extends LikeActionController.AbstractRequestWrapper {
      final LikeActionController this$0;
      String verifiedObjectId;

      GetOGObjectIdRequestWrapper(LikeActionController var1, String var2, LikeView.ObjectType var3) {
         super(var1, var2, var3);
         this.this$0 = var1;
         Bundle var4 = new Bundle();
         var4.putString("fields", "og_object.fields(id)");
         var4.putString("ids", var2);
         this.setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", var4, HttpMethod.GET));
      }

      @Override
      protected void processError(FacebookRequestError var1) {
         if (var1.getErrorMessage().contains("og_object")) {
            this.error = null;
         } else {
            Logger.log(
               LoggingBehavior.REQUESTS,
               LikeActionController.TAG,
               "Error getting the FB id for object '%s' with type '%s' : %s",
               this.objectId,
               this.objectType,
               var1
            );
         }
      }

      @Override
      protected void processSuccess(GraphResponse var1) {
         JSONObject var2 = Utility.tryGetJSONObjectFromResponse(var1.getJSONObject(), this.objectId);
         if (var2 != null) {
            JSONObject var3 = var2.optJSONObject("og_object");
            if (var3 != null) {
               this.verifiedObjectId = var3.optString("id");
            }
         }
      }
   }

   private class GetOGObjectLikesRequestWrapper extends LikeActionController.AbstractRequestWrapper implements LikeActionController.LikeRequestWrapper {
      private final String objectId;
      private boolean objectIsLiked;
      private final LikeView.ObjectType objectType;
      final LikeActionController this$0;
      private String unlikeToken;

      GetOGObjectLikesRequestWrapper(LikeActionController var1, String var2, LikeView.ObjectType var3) {
         super(var1, var2, var3);
         this.this$0 = var1;
         this.objectIsLiked = this.this$0.isObjectLiked;
         this.objectId = var2;
         this.objectType = var3;
         Bundle var4 = new Bundle();
         var4.putString("fields", "id,application");
         var4.putString("object", this.objectId);
         this.setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", var4, HttpMethod.GET));
      }

      @Override
      public String getUnlikeToken() {
         return this.unlikeToken;
      }

      @Override
      public boolean isObjectLiked() {
         return this.objectIsLiked;
      }

      @Override
      protected void processError(FacebookRequestError var1) {
         Logger.log(
            LoggingBehavior.REQUESTS,
            LikeActionController.TAG,
            "Error fetching like status for object '%s' with type '%s' : %s",
            this.objectId,
            this.objectType,
            var1
         );
         this.this$0.logAppEventForError("get_og_object_like", var1);
      }

      @Override
      protected void processSuccess(GraphResponse var1) {
         JSONArray var4 = Utility.tryGetJSONArrayFromResponse(var1.getJSONObject(), "data");
         if (var4 != null) {
            for (int var2 = 0; var2 < var4.length(); var2++) {
               JSONObject var3 = var4.optJSONObject(var2);
               if (var3 != null) {
                  this.objectIsLiked = true;
                  JSONObject var5 = var3.optJSONObject("application");
                  AccessToken var6 = AccessToken.getCurrentAccessToken();
                  if (var5 != null && var6 != null && Utility.areObjectsEqual(var6.getApplicationId(), var5.optString("id"))) {
                     this.unlikeToken = var3.optString("id");
                  }
               }
            }
         }
      }
   }

   private class GetPageIdRequestWrapper extends LikeActionController.AbstractRequestWrapper {
      boolean objectIsPage;
      final LikeActionController this$0;
      String verifiedObjectId;

      GetPageIdRequestWrapper(LikeActionController var1, String var2, LikeView.ObjectType var3) {
         super(var1, var2, var3);
         this.this$0 = var1;
         Bundle var4 = new Bundle();
         var4.putString("fields", "id");
         var4.putString("ids", var2);
         this.setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "", var4, HttpMethod.GET));
      }

      @Override
      protected void processError(FacebookRequestError var1) {
         Logger.log(
            LoggingBehavior.REQUESTS,
            LikeActionController.TAG,
            "Error getting the FB id for object '%s' with type '%s' : %s",
            this.objectId,
            this.objectType,
            var1
         );
      }

      @Override
      protected void processSuccess(GraphResponse var1) {
         JSONObject var3 = Utility.tryGetJSONObjectFromResponse(var1.getJSONObject(), this.objectId);
         if (var3 != null) {
            this.verifiedObjectId = var3.optString("id");
            boolean var2;
            if (!Utility.isNullOrEmpty(this.verifiedObjectId)) {
               var2 = true;
            } else {
               var2 = false;
            }

            this.objectIsPage = var2;
         }
      }
   }

   private class GetPageLikesRequestWrapper extends LikeActionController.AbstractRequestWrapper implements LikeActionController.LikeRequestWrapper {
      private boolean objectIsLiked;
      private String pageId;
      final LikeActionController this$0;

      GetPageLikesRequestWrapper(LikeActionController var1, String var2) {
         super(var1, var2, LikeView.ObjectType.PAGE);
         this.this$0 = var1;
         this.objectIsLiked = this.this$0.isObjectLiked;
         this.pageId = var2;
         Bundle var3 = new Bundle();
         var3.putString("fields", "id");
         this.setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/likes/" + var2, var3, HttpMethod.GET));
      }

      @Override
      public String getUnlikeToken() {
         return null;
      }

      @Override
      public boolean isObjectLiked() {
         return this.objectIsLiked;
      }

      @Override
      protected void processError(FacebookRequestError var1) {
         Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error fetching like status for page id '%s': %s", this.pageId, var1);
         this.this$0.logAppEventForError("get_page_like", var1);
      }

      @Override
      protected void processSuccess(GraphResponse var1) {
         JSONArray var2 = Utility.tryGetJSONArrayFromResponse(var1.getJSONObject(), "data");
         if (var2 != null && var2.length() > 0) {
            this.objectIsLiked = true;
         }
      }
   }

   private interface LikeRequestWrapper extends LikeActionController.RequestWrapper {
      String getUnlikeToken();

      boolean isObjectLiked();
   }

   private static class MRUCacheWorkItem implements Runnable {
      private static ArrayList<String> mruCachedItems = new ArrayList<>();
      private String cacheItem;
      private boolean shouldTrim;

      MRUCacheWorkItem(String var1, boolean var2) {
         this.cacheItem = var1;
         this.shouldTrim = var2;
      }

      @Override
      public void run() {
         if (this.cacheItem != null) {
            mruCachedItems.remove(this.cacheItem);
            mruCachedItems.add(0, this.cacheItem);
         }

         if (this.shouldTrim && mruCachedItems.size() >= 128) {
            while (64 < mruCachedItems.size()) {
               String var1 = mruCachedItems.remove(mruCachedItems.size() - 1);
               LikeActionController.cache.remove(var1);
            }
         }
      }
   }

   private class PublishLikeRequestWrapper extends LikeActionController.AbstractRequestWrapper {
      final LikeActionController this$0;
      String unlikeToken;

      PublishLikeRequestWrapper(LikeActionController var1, String var2, LikeView.ObjectType var3) {
         super(var1, var2, var3);
         this.this$0 = var1;
         Bundle var4 = new Bundle();
         var4.putString("object", var2);
         this.setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), "me/og.likes", var4, HttpMethod.POST));
      }

      @Override
      protected void processError(FacebookRequestError var1) {
         if (var1.getErrorCode() == 3501) {
            this.error = null;
         } else {
            Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error liking object '%s' with type '%s' : %s", this.objectId, this.objectType, var1);
            this.this$0.logAppEventForError("publish_like", var1);
         }
      }

      @Override
      protected void processSuccess(GraphResponse var1) {
         this.unlikeToken = Utility.safeGetStringFromResponse(var1.getJSONObject(), "id");
      }
   }

   private class PublishUnlikeRequestWrapper extends LikeActionController.AbstractRequestWrapper {
      final LikeActionController this$0;
      private String unlikeToken;

      PublishUnlikeRequestWrapper(LikeActionController var1, String var2) {
         super(var1, null, null);
         this.this$0 = var1;
         this.unlikeToken = var2;
         this.setRequest(new GraphRequest(AccessToken.getCurrentAccessToken(), var2, null, HttpMethod.DELETE));
      }

      @Override
      protected void processError(FacebookRequestError var1) {
         Logger.log(LoggingBehavior.REQUESTS, LikeActionController.TAG, "Error unliking object with unlike token '%s' : %s", this.unlikeToken, var1);
         this.this$0.logAppEventForError("publish_unlike", var1);
      }

      @Override
      protected void processSuccess(GraphResponse var1) {
      }
   }

   private interface RequestCompletionCallback {
      void onComplete();
   }

   private interface RequestWrapper {
      void addToBatch(GraphRequestBatch var1);

      FacebookRequestError getError();
   }

   private static class SerializeToDiskWorkItem implements Runnable {
      private String cacheKey;
      private String controllerJson;

      SerializeToDiskWorkItem(String var1, String var2) {
         this.cacheKey = var1;
         this.controllerJson = var2;
      }

      @Override
      public void run() {
         LikeActionController.serializeToDiskSynchronously(this.cacheKey, this.controllerJson);
      }
   }
}
