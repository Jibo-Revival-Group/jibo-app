package com.facebook.share.internal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookGraphResponseException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareMedia;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphAction;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.LikeView;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ShareInternalUtility {
   public static final String MY_PHOTOS = "me/photos";
   private static final String MY_STAGING_RESOURCES = "me/staging_resources";
   private static final String STAGING_PARAM = "file";

   private static AppCall getAppCallFromActivityResult(int var0, int var1, Intent var2) {
      UUID var3 = NativeProtocol.getCallIdFromIntent(var2);
      AppCall var4;
      if (var3 == null) {
         var4 = null;
      } else {
         var4 = AppCall.finishPendingCall(var3, var0);
      }

      return var4;
   }

   private static NativeAppCallAttachmentStore.Attachment getAttachment(UUID var0, ShareMedia var1) {
      Object var3 = null;
      Bitmap var2;
      Uri var5;
      if (var1 instanceof SharePhoto) {
         SharePhoto var4 = (SharePhoto)var1;
         var2 = var4.getBitmap();
         var5 = var4.getImageUrl();
      } else if (var1 instanceof ShareVideo) {
         var5 = ((ShareVideo)var1).getLocalUrl();
         var2 = null;
      } else {
         var5 = null;
         var2 = null;
      }

      NativeAppCallAttachmentStore.Attachment var6;
      if (var2 != null) {
         var6 = NativeAppCallAttachmentStore.createAttachment(var0, var2);
      } else {
         var6 = (NativeAppCallAttachmentStore.Attachment)var3;
         if (var5 != null) {
            var6 = NativeAppCallAttachmentStore.createAttachment(var0, var5);
         }
      }

      return var6;
   }

   public static Pair<String, String> getFieldNameAndNamespaceFromFullName(String var0) {
      Object var4 = null;
      int var1 = var0.indexOf(58);
      String var3 = (String)var4;
      String var2 = var0;
      if (var1 != -1) {
         var3 = (String)var4;
         var2 = var0;
         if (var0.length() > var1 + 1) {
            var3 = var0.substring(0, var1);
            var2 = var0.substring(var1 + 1);
         }
      }

      return new Pair(var3, var2);
   }

   public static List<Bundle> getMediaInfos(ShareMediaContent var0, UUID var1) {
      if (var0 != null) {
         List var3 = var0.getMedia();
         if (var3 != null) {
            ArrayList var2 = new ArrayList();
            List var4 = Utility.map(var3, new Utility.Mapper<ShareMedia, Bundle>(var1, var2) {
               final UUID val$appCallId;
               final List val$attachments;

               {
                  this.val$appCallId = var1;
                  this.val$attachments = var2x;
               }

               public Bundle apply(ShareMedia var1) {
                  NativeAppCallAttachmentStore.Attachment var2x = ShareInternalUtility.getAttachment(this.val$appCallId, var1);
                  this.val$attachments.add(var2x);
                  Bundle var3x = new Bundle();
                  var3x.putString("type", var1.getMediaType().name());
                  var3x.putString("uri", var2x.getAttachmentUrl());
                  return var3x;
               }
            });
            NativeAppCallAttachmentStore.addAttachments(var2);
            return var4;
         }
      }

      return null;
   }

   public static LikeView.ObjectType getMostSpecificObjectType(LikeView.ObjectType var0, LikeView.ObjectType var1) {
      if (var0 != var1) {
         if (var0 == LikeView.ObjectType.UNKNOWN) {
            var0 = var1;
         } else if (var1 != LikeView.ObjectType.UNKNOWN) {
            var0 = null;
         }
      }

      return var0;
   }

   public static String getNativeDialogCompletionGesture(Bundle var0) {
      String var1;
      if (var0.containsKey("completionGesture")) {
         var1 = var0.getString("completionGesture");
      } else {
         var1 = var0.getString("com.facebook.platform.extra.COMPLETION_GESTURE");
      }

      return var1;
   }

   public static List<String> getPhotoUrls(SharePhotoContent var0, UUID var1) {
      if (var0 != null) {
         List var2 = var0.getPhotos();
         if (var2 != null) {
            List var4 = Utility.map(var2, new Utility.Mapper<SharePhoto, NativeAppCallAttachmentStore.Attachment>(var1) {
               final UUID val$appCallId;

               {
                  this.val$appCallId = var1;
               }

               public NativeAppCallAttachmentStore.Attachment apply(SharePhoto var1) {
                  return ShareInternalUtility.getAttachment(this.val$appCallId, var1);
               }
            });
            List var3 = Utility.map(var4, new Utility.Mapper<NativeAppCallAttachmentStore.Attachment, String>() {
               public String apply(NativeAppCallAttachmentStore.Attachment var1) {
                  return var1.getAttachmentUrl();
               }
            });
            NativeAppCallAttachmentStore.addAttachments(var4);
            return var3;
         }
      }

      return null;
   }

   public static String getShareDialogPostId(Bundle var0) {
      String var1;
      if (var0.containsKey("postId")) {
         var1 = var0.getString("postId");
      } else if (var0.containsKey("com.facebook.platform.extra.POST_ID")) {
         var1 = var0.getString("com.facebook.platform.extra.POST_ID");
      } else {
         var1 = var0.getString("post_id");
      }

      return var1;
   }

   public static ResultProcessor getShareResultProcessor(FacebookCallback<Sharer.Result> var0) {
      return new ResultProcessor(var0, var0) {
         final FacebookCallback val$callback;

         {
            this.val$callback = var2;
         }

         @Override
         public void onCancel(AppCall var1) {
            ShareInternalUtility.invokeOnCancelCallback(this.val$callback);
         }

         @Override
         public void onError(AppCall var1, FacebookException var2) {
            ShareInternalUtility.invokeOnErrorCallback(this.val$callback, var2);
         }

         @Override
         public void onSuccess(AppCall var1, Bundle var2) {
            if (var2 != null) {
               String var3 = ShareInternalUtility.getNativeDialogCompletionGesture(var2);
               if (var3 == null || "post".equalsIgnoreCase(var3)) {
                  String var4 = ShareInternalUtility.getShareDialogPostId(var2);
                  ShareInternalUtility.invokeOnSuccessCallback(this.val$callback, var4);
               } else if ("cancel".equalsIgnoreCase(var3)) {
                  ShareInternalUtility.invokeOnCancelCallback(this.val$callback);
               } else {
                  ShareInternalUtility.invokeOnErrorCallback(this.val$callback, new FacebookException("UnknownError"));
               }
            }
         }
      };
   }

   public static String getVideoUrl(ShareVideoContent var0, UUID var1) {
      String var2;
      if (var0 != null && var0.getVideo() != null) {
         NativeAppCallAttachmentStore.Attachment var3 = NativeAppCallAttachmentStore.createAttachment(var1, var0.getVideo().getLocalUrl());
         ArrayList var4 = new ArrayList(1);
         var4.add(var3);
         NativeAppCallAttachmentStore.addAttachments(var4);
         var2 = var3.getAttachmentUrl();
      } else {
         var2 = null;
      }

      return var2;
   }

   public static boolean handleActivityResult(int var0, int var1, Intent var2, ResultProcessor var3) {
      boolean var5 = true;
      AppCall var6 = getAppCallFromActivityResult(var0, var1, var2);
      boolean var4;
      if (var6 == null) {
         var4 = false;
      } else {
         NativeAppCallAttachmentStore.cleanupAttachmentsForCall(var6.getCallId());
         var4 = var5;
         if (var3 != null) {
            FacebookException var7 = NativeProtocol.getExceptionFromErrorData(NativeProtocol.getErrorDataFromResultIntent(var2));
            if (var7 != null) {
               if (var7 instanceof FacebookOperationCanceledException) {
                  var3.onCancel(var6);
                  var4 = var5;
               } else {
                  var3.onError(var6, var7);
                  var4 = var5;
               }
            } else {
               var3.onSuccess(var6, NativeProtocol.getSuccessResultsFromIntent(var2));
               var4 = var5;
            }
         }
      }

      return var4;
   }

   public static void invokeCallbackWithError(FacebookCallback<Sharer.Result> var0, String var1) {
      invokeOnErrorCallback(var0, var1);
   }

   public static void invokeCallbackWithException(FacebookCallback<Sharer.Result> var0, Exception var1) {
      if (var1 instanceof FacebookException) {
         invokeOnErrorCallback(var0, (FacebookException)var1);
      } else {
         invokeCallbackWithError(var0, "Error preparing share content: " + var1.getLocalizedMessage());
      }
   }

   public static void invokeCallbackWithResults(FacebookCallback<Sharer.Result> var0, String var1, GraphResponse var2) {
      FacebookRequestError var3 = var2.getError();
      if (var3 != null) {
         String var5 = var3.getErrorMessage();
         var1 = var5;
         if (Utility.isNullOrEmpty(var5)) {
            var1 = "Unexpected error sharing.";
         }

         invokeOnErrorCallback(var0, var2, var1);
      } else {
         invokeOnSuccessCallback(var0, var1);
      }
   }

   static void invokeOnCancelCallback(FacebookCallback<Sharer.Result> var0) {
      logShareResult("cancelled", null);
      if (var0 != null) {
         var0.onCancel();
      }
   }

   static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> var0, FacebookException var1) {
      logShareResult("error", var1.getMessage());
      if (var0 != null) {
         var0.onError(var1);
      }
   }

   static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> var0, GraphResponse var1, String var2) {
      logShareResult("error", var2);
      if (var0 != null) {
         var0.onError(new FacebookGraphResponseException(var1, var2));
      }
   }

   static void invokeOnErrorCallback(FacebookCallback<Sharer.Result> var0, String var1) {
      logShareResult("error", var1);
      if (var0 != null) {
         var0.onError(new FacebookException(var1));
      }
   }

   static void invokeOnSuccessCallback(FacebookCallback<Sharer.Result> var0, String var1) {
      logShareResult("succeeded", null);
      if (var0 != null) {
         var0.onSuccess(new Sharer.Result(var1));
      }
   }

   private static void logShareResult(String var0, String var1) {
      AppEventsLogger var2 = AppEventsLogger.newLogger(FacebookSdk.getApplicationContext());
      Bundle var3 = new Bundle();
      var3.putString("fb_share_dialog_outcome", var0);
      if (var1 != null) {
         var3.putString("error_message", var1);
      }

      var2.logSdkEvent("fb_share_dialog_result", null, var3);
   }

   public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken var0, Bitmap var1, GraphRequest.Callback var2) {
      Bundle var3 = new Bundle(1);
      var3.putParcelable("file", var1);
      return new GraphRequest(var0, "me/staging_resources", var3, HttpMethod.POST, var2);
   }

   public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken var0, Uri var1, GraphRequest.Callback var2) throws FileNotFoundException {
      GraphRequest var4;
      if (Utility.isFileUri(var1)) {
         var4 = newUploadStagingResourceWithImageRequest(var0, new File(var1.getPath()), var2);
      } else {
         if (!Utility.isContentUri(var1)) {
            throw new FacebookException("The image Uri must be either a file:// or content:// Uri");
         }

         GraphRequest.ParcelableResourceWithMimeType var5 = new GraphRequest.ParcelableResourceWithMimeType(var1, "image/png");
         Bundle var3 = new Bundle(1);
         var3.putParcelable("file", var5);
         var4 = new GraphRequest(var0, "me/staging_resources", var3, HttpMethod.POST, var2);
      }

      return var4;
   }

   public static GraphRequest newUploadStagingResourceWithImageRequest(AccessToken var0, File var1, GraphRequest.Callback var2) throws FileNotFoundException {
      GraphRequest.ParcelableResourceWithMimeType var3 = new GraphRequest.ParcelableResourceWithMimeType(
         ParcelFileDescriptor.open(var1, 268435456), "image/png"
      );
      Bundle var4 = new Bundle(1);
      var4.putParcelable("file", var3);
      return new GraphRequest(var0, "me/staging_resources", var4, HttpMethod.POST, var2);
   }

   public static void registerSharerCallback(int var0, CallbackManager var1, FacebookCallback<Sharer.Result> var2) {
      if (!(var1 instanceof CallbackManagerImpl)) {
         throw new FacebookException("Unexpected CallbackManager, please use the provided Factory.");
      }

      ((CallbackManagerImpl)var1)
         .registerCallback(
            var0,
            new CallbackManagerImpl.Callback(var0, var2) {
               final FacebookCallback val$callback;
               final int val$requestCode;

               {
                  this.val$requestCode = var1;
                  this.val$callback = var2x;
               }

               @Override
               public boolean onActivityResult(int var1, Intent var2x) {
                  return ShareInternalUtility.handleActivityResult(
                     this.val$requestCode, var1, var2x, ShareInternalUtility.getShareResultProcessor(this.val$callback)
                  );
               }
            }
         );
   }

   public static void registerStaticShareCallback(int var0) {
      CallbackManagerImpl.registerStaticCallback(var0, new CallbackManagerImpl.Callback(var0) {
         final int val$requestCode;

         {
            this.val$requestCode = var1;
         }

         @Override
         public boolean onActivityResult(int var1, Intent var2) {
            return ShareInternalUtility.handleActivityResult(this.val$requestCode, var1, var2, ShareInternalUtility.getShareResultProcessor(null));
         }
      });
   }

   public static JSONArray removeNamespacesFromOGJsonArray(JSONArray var0, boolean var1) throws JSONException {
      JSONArray var5 = new JSONArray();

      for (int var2 = 0; var2 < var0.length(); var2++) {
         Object var4 = var0.get(var2);
         Object var3;
         if (var4 instanceof JSONArray) {
            var3 = removeNamespacesFromOGJsonArray((JSONArray)var4, var1);
         } else {
            var3 = var4;
            if (var4 instanceof JSONObject) {
               var3 = removeNamespacesFromOGJsonObject((JSONObject)var4, var1);
            }
         }

         var5.put(var3);
      }

      return var5;
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   public static JSONObject removeNamespacesFromOGJsonObject(JSONObject var0, boolean var1) {
      if (var0 == null) {
         var0 = null;
      } else {
         JSONObject var4;
         JSONArray var5;
         JSONObject var6;
         try {
            var4 = new JSONObject();
            var6 = new JSONObject();
            var5 = var0.names();
         } catch (JSONException var14) {
            throw new FacebookException("Failed to create json object from share content");
         }

         int var2 = 0;

         while (true) {
            Object var3;
            String var7;
            label117: {
               try {
                  if (var2 >= var5.length()) {
                     break;
                  }

                  var7 = var5.getString(var2);
                  var3 = var0.get(var7);
                  if (var3 instanceof JSONObject) {
                     var3 = removeNamespacesFromOGJsonObject((JSONObject)var3, true);
                     break label117;
                  }
               } catch (JSONException var16) {
                  throw new FacebookException("Failed to create json object from share content");
               }

               try {
                  if (var3 instanceof JSONArray) {
                     var3 = removeNamespacesFromOGJsonArray((JSONArray)var3, true);
                  }
               } catch (JSONException var17) {
                  throw new FacebookException("Failed to create json object from share content");
               }
            }

            String var8;
            String var22;
            try {
               Pair var9 = getFieldNameAndNamespaceFromFullName(var7);
               var8 = (String)var9.first;
               var22 = (String)var9.second;
            } catch (JSONException var13) {
               throw new FacebookException("Failed to create json object from share content");
            }

            label105:
            if (var1) {
               if (var8 != null) {
                  try {
                     if (var8.equals("fbsdk")) {
                        var4.put(var7, var3);
                        break label105;
                     }
                  } catch (JSONException var20) {
                     throw new FacebookException("Failed to create json object from share content");
                  }
               }

               label93: {
                  if (var8 != null) {
                     try {
                        if (!var8.equals("og")) {
                           break label93;
                        }
                     } catch (JSONException var18) {
                        throw new FacebookException("Failed to create json object from share content");
                     }
                  }

                  try {
                     var4.put(var22, var3);
                     break label105;
                  } catch (JSONException var12) {
                     throw new FacebookException("Failed to create json object from share content");
                  }
               }

               try {
                  var6.put(var22, var3);
               } catch (JSONException var11) {
                  throw new FacebookException("Failed to create json object from share content");
               }
            } else {
               label99: {
                  if (var8 != null) {
                     try {
                        if (var8.equals("fb")) {
                           var4.put(var7, var3);
                           break label99;
                        }
                     } catch (JSONException var19) {
                        throw new FacebookException("Failed to create json object from share content");
                     }
                  }

                  try {
                     var4.put(var22, var3);
                  } catch (JSONException var10) {
                     throw new FacebookException("Failed to create json object from share content");
                  }
               }
            }

            var2++;
         }

         try {
            if (var6.length() > 0) {
               var4.put("data", var6);
            }
         } catch (JSONException var15) {
            throw new FacebookException("Failed to create json object from share content");
         }

         var0 = var4;
      }

      return var0;
   }

   public static JSONObject toJSONObjectForCall(UUID var0, ShareOpenGraphContent var1) throws JSONException {
      ShareOpenGraphAction var2 = var1.getAction();
      ArrayList var3 = new ArrayList();
      JSONObject var7 = OpenGraphJSONUtility.toJSONObject(var2, new OpenGraphJSONUtility.PhotoJSONProcessor(var0, var3) {
         final ArrayList val$attachments;
         final UUID val$callId;

         {
            this.val$callId = var1;
            this.val$attachments = var2x;
         }

         // $VF: Duplicated exception handlers to handle obfuscated exceptions
         @Override
         public JSONObject toJSONObject(SharePhoto var1) {
            NativeAppCallAttachmentStore.Attachment var2x = ShareInternalUtility.getAttachment(this.val$callId, var1);
            JSONObject var6;
            if (var2x == null) {
               var6 = null;
            } else {
               this.val$attachments.add(var2x);
               JSONObject var3x = new JSONObject();

               try {
                  var3x.put("url", var2x.getAttachmentUrl());
               } catch (JSONException var4) {
                  throw new FacebookException("Unable to attach images", var4);
               }

               JSONObject var7x = var3x;

               try {
                  if (!var1.getUserGenerated()) {
                     return var7x;
                  }

                  var3x.put("user_generated", true);
               } catch (JSONException var5) {
                  throw new FacebookException("Unable to attach images", var5);
               }

               var6 = var3x;
            }

            return var6;
         }
      });
      NativeAppCallAttachmentStore.addAttachments(var3);
      if (var1.getPlaceId() != null && Utility.isNullOrEmpty(var7.optString("place"))) {
         var7.put("place", var1.getPlaceId());
      }

      if (var1.getPeopleIds() != null) {
         JSONArray var4 = var7.optJSONArray("tags");
         Set var5;
         if (var4 == null) {
            var5 = new HashSet();
         } else {
            var5 = Utility.jsonArrayToSet(var4);
         }

         Iterator var6 = var1.getPeopleIds().iterator();

         while (var6.hasNext()) {
            var5.add((String)var6.next());
         }

         var7.put("tags", new JSONArray(var5));
      }

      return var7;
   }

   public static JSONObject toJSONObjectForWeb(ShareOpenGraphContent var0) throws JSONException {
      return OpenGraphJSONUtility.toJSONObject(var0.getAction(), new OpenGraphJSONUtility.PhotoJSONProcessor() {
         @Override
         public JSONObject toJSONObject(SharePhoto var1) {
            Uri var4 = var1.getImageUrl();
            JSONObject var2 = new JSONObject();

            try {
               var2.put("url", var4.toString());
               return var2;
            } catch (JSONException var3) {
               throw new FacebookException("Unable to attach images", var3);
            }
         }
      });
   }
}
