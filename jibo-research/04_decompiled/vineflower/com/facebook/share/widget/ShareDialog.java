package com.facebook.share.widget;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookCallback;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.facebook.internal.Utility;
import com.facebook.share.Sharer;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.OpenGraphActionDialogFeature;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareDialogFeature;
import com.facebook.share.internal.ShareFeedContent;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.internal.WebDialogParameters;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareMediaContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class ShareDialog extends FacebookDialogBase<ShareContent, Sharer.Result> implements Sharer {
   private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
   private static final String FEED_DIALOG = "feed";
   private static final String WEB_OG_SHARE_DIALOG = "share_open_graph";
   public static final String WEB_SHARE_DIALOG = "share";
   private boolean isAutomaticMode;
   private boolean shouldFailOnDataError = false;

   public ShareDialog(Activity var1) {
      super(var1, DEFAULT_REQUEST_CODE);
      this.isAutomaticMode = true;
      ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
   }

   ShareDialog(Activity var1, int var2) {
      super(var1, var2);
      this.isAutomaticMode = true;
      ShareInternalUtility.registerStaticShareCallback(var2);
   }

   public ShareDialog(Fragment var1) {
      this(new FragmentWrapper(var1));
   }

   ShareDialog(Fragment var1, int var2) {
      this(new FragmentWrapper(var1), var2);
   }

   public ShareDialog(android.support.v4.app.Fragment var1) {
      this(new FragmentWrapper(var1));
   }

   ShareDialog(android.support.v4.app.Fragment var1, int var2) {
      this(new FragmentWrapper(var1), var2);
   }

   private ShareDialog(FragmentWrapper var1) {
      super(var1, DEFAULT_REQUEST_CODE);
      this.isAutomaticMode = true;
      ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
   }

   private ShareDialog(FragmentWrapper var1, int var2) {
      super(var1, var2);
      this.isAutomaticMode = true;
      ShareInternalUtility.registerStaticShareCallback(var2);
   }

   public static boolean canShow(Class<? extends ShareContent> var0) {
      boolean var1;
      if (!canShowWebTypeCheck(var0) && !canShowNative(var0)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   private static boolean canShowNative(Class<? extends ShareContent> var0) {
      DialogFeature var2 = getFeature(var0);
      boolean var1;
      if (var2 != null && DialogPresenter.canPresentNativeDialogWithFeature(var2)) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private static boolean canShowWebTypeCheck(Class<? extends ShareContent> var0) {
      boolean var3 = false;
      AccessToken var4 = AccessToken.getCurrentAccessToken();
      boolean var1;
      if (var4 != null && !var4.isExpired()) {
         var1 = true;
      } else {
         var1 = false;
      }

      if (!ShareLinkContent.class.isAssignableFrom(var0) && !ShareOpenGraphContent.class.isAssignableFrom(var0)) {
         boolean var2 = var3;
         if (!SharePhotoContent.class.isAssignableFrom(var0)) {
            return var2;
         }

         var2 = var3;
         if (!var1) {
            return var2;
         }
      }

      return true;
   }

   private static DialogFeature getFeature(Class<? extends ShareContent> var0) {
      Enum var1;
      if (ShareLinkContent.class.isAssignableFrom(var0)) {
         var1 = ShareDialogFeature.SHARE_DIALOG;
      } else if (SharePhotoContent.class.isAssignableFrom(var0)) {
         var1 = ShareDialogFeature.PHOTOS;
      } else if (ShareVideoContent.class.isAssignableFrom(var0)) {
         var1 = ShareDialogFeature.VIDEO;
      } else if (ShareOpenGraphContent.class.isAssignableFrom(var0)) {
         var1 = OpenGraphActionDialogFeature.OG_ACTION_DIALOG;
      } else if (ShareMediaContent.class.isAssignableFrom(var0)) {
         var1 = ShareDialogFeature.MULTIMEDIA;
      } else {
         var1 = null;
      }

      return var1;
   }

   private void logDialogShare(Context var1, ShareContent var2, ShareDialog.Mode var3) {
      if (this.isAutomaticMode) {
         var3 = ShareDialog.Mode.AUTOMATIC;
      }

      String var8;
      switch (<unrepresentable>.$SwitchMap$com$facebook$share$widget$ShareDialog$Mode[var3.ordinal()]) {
         case 1:
            var8 = "automatic";
            break;
         case 2:
            var8 = "web";
            break;
         case 3:
            var8 = "native";
            break;
         default:
            var8 = "unknown";
      }

      DialogFeature var6 = getFeature((Class<? extends ShareContent>)var2.getClass());
      String var7;
      if (var6 == ShareDialogFeature.SHARE_DIALOG) {
         var7 = "status";
      } else if (var6 == ShareDialogFeature.PHOTOS) {
         var7 = "photo";
      } else if (var6 == ShareDialogFeature.VIDEO) {
         var7 = "video";
      } else if (var6 == OpenGraphActionDialogFeature.OG_ACTION_DIALOG) {
         var7 = "open_graph";
      } else {
         var7 = "unknown";
      }

      AppEventsLogger var5 = AppEventsLogger.newLogger(var1);
      Bundle var4 = new Bundle();
      var4.putString("fb_share_dialog_show", var8);
      var4.putString("fb_share_dialog_content_type", var7);
      var5.logSdkEvent("fb_share_dialog_show", null, var4);
   }

   public static void show(Activity var0, ShareContent var1) {
      new ShareDialog(var0).show(var1);
   }

   public static void show(Fragment var0, ShareContent var1) {
      show(new FragmentWrapper(var0), var1);
   }

   public static void show(android.support.v4.app.Fragment var0, ShareContent var1) {
      show(new FragmentWrapper(var0), var1);
   }

   private static void show(FragmentWrapper var0, ShareContent var1) {
      new ShareDialog(var0).show(var1);
   }

   public boolean canShow(ShareContent var1, ShareDialog.Mode var2) {
      Object var3 = var2;
      if (var2 == ShareDialog.Mode.AUTOMATIC) {
         var3 = BASE_AUTOMATIC_MODE;
      }

      return this.canShowImpl(var1, var3);
   }

   @Override
   protected AppCall createBaseAppCall() {
      return new AppCall(this.getRequestCode());
   }

   @Override
   protected List<FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler> getOrderedModeHandlers() {
      ArrayList var1 = new ArrayList();
      var1.add(new ShareDialog.NativeHandler(this));
      var1.add(new ShareDialog.FeedHandler(this));
      var1.add(new ShareDialog.WebShareHandler(this));
      return var1;
   }

   @Override
   public boolean getShouldFailOnDataError() {
      return this.shouldFailOnDataError;
   }

   @Override
   protected void registerCallbackImpl(CallbackManagerImpl var1, FacebookCallback<Sharer.Result> var2) {
      ShareInternalUtility.registerSharerCallback(this.getRequestCode(), var1, var2);
   }

   @Override
   public void setShouldFailOnDataError(boolean var1) {
      this.shouldFailOnDataError = var1;
   }

   public void show(ShareContent var1, ShareDialog.Mode var2) {
      boolean var3;
      if (var2 == ShareDialog.Mode.AUTOMATIC) {
         var3 = true;
      } else {
         var3 = false;
      }

      this.isAutomaticMode = var3;
      if (this.isAutomaticMode) {
         var2 = BASE_AUTOMATIC_MODE;
      }

      this.showImpl(var1, var2);
   }

   private class FeedHandler extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler {
      final ShareDialog this$0;

      private FeedHandler(ShareDialog var1) {
         super(var1);
         this.this$0 = var1;
      }

      public boolean canShow(ShareContent var1, boolean var2) {
         if (!(var1 instanceof ShareLinkContent) && !(var1 instanceof ShareFeedContent)) {
            var2 = false;
         } else {
            var2 = true;
         }

         return var2;
      }

      public AppCall createAppCall(ShareContent var1) {
         this.this$0.logDialogShare(this.this$0.getActivityContext(), var1, ShareDialog.Mode.FEED);
         AppCall var2 = this.this$0.createBaseAppCall();
         Bundle var4;
         if (var1 instanceof ShareLinkContent) {
            ShareLinkContent var3 = (ShareLinkContent)var1;
            ShareContentValidation.validateForWebShare(var3);
            var4 = WebDialogParameters.createForFeed(var3);
         } else {
            var4 = WebDialogParameters.createForFeed((ShareFeedContent)var1);
         }

         DialogPresenter.setupAppCallForWebDialog(var2, "feed", var4);
         return var2;
      }

      @Override
      public Object getMode() {
         return ShareDialog.Mode.FEED;
      }
   }

   public enum Mode {
      AUTOMATIC,
      FEED,
      NATIVE,
      WEB;

      private static final ShareDialog.Mode[] $VALUES = new ShareDialog.Mode[]{
         ShareDialog.Mode.AUTOMATIC, ShareDialog.Mode.NATIVE, ShareDialog.Mode.WEB, ShareDialog.Mode.FEED
      };
   }

   private class NativeHandler extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler {
      final ShareDialog this$0;

      private NativeHandler(ShareDialog var1) {
         super(var1);
         this.this$0 = var1;
      }

      public boolean canShow(ShareContent var1, boolean var2) {
         boolean var4 = true;
         boolean var3 = false;
         if (var1 == null) {
            var2 = var3;
         } else {
            if (!var2) {
               if (var1.getShareHashtag() != null) {
                  var2 = DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.HASHTAG);
               } else {
                  var2 = true;
               }

               var3 = var2;
               if (var1 instanceof ShareLinkContent) {
                  var3 = var2;
                  if (!Utility.isNullOrEmpty(((ShareLinkContent)var1).getQuote())) {
                     var3 = var2 & DialogPresenter.canPresentNativeDialogWithFeature(ShareDialogFeature.LINK_SHARE_QUOTES);
                  }
               }
            } else {
               var3 = true;
            }

            if (var3 && ShareDialog.canShowNative((Class<? extends ShareContent>)var1.getClass())) {
               var2 = var4;
            } else {
               var2 = false;
            }
         }

         return var2;
      }

      public AppCall createAppCall(ShareContent var1) {
         this.this$0.logDialogShare(this.this$0.getActivityContext(), var1, ShareDialog.Mode.NATIVE);
         ShareContentValidation.validateForNativeShare(var1);
         AppCall var2 = this.this$0.createBaseAppCall();
         DialogPresenter.setupAppCallForNativeDialog(var2, new DialogPresenter.ParameterProvider(this, var2, var1, this.this$0.getShouldFailOnDataError()) {
            final ShareDialog.NativeHandler this$1;
            final AppCall val$appCall;
            final ShareContent val$content;
            final boolean val$shouldFailOnDataError;

            {
               this.this$1 = var1;
               this.val$appCall = var2x;
               this.val$content = var3;
               this.val$shouldFailOnDataError = var4;
            }

            @Override
            public Bundle getLegacyParameters() {
               return LegacyNativeDialogParameters.create(this.val$appCall.getCallId(), this.val$content, this.val$shouldFailOnDataError);
            }

            @Override
            public Bundle getParameters() {
               return NativeDialogParameters.create(this.val$appCall.getCallId(), this.val$content, this.val$shouldFailOnDataError);
            }
         }, ShareDialog.getFeature((Class<? extends ShareContent>)var1.getClass()));
         return var2;
      }

      @Override
      public Object getMode() {
         return ShareDialog.Mode.NATIVE;
      }
   }

   private class WebShareHandler extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler {
      final ShareDialog this$0;

      private WebShareHandler(ShareDialog var1) {
         super(var1);
         this.this$0 = var1;
      }

      private SharePhotoContent createAndMapAttachments(SharePhotoContent var1, UUID var2) {
         SharePhotoContent.Builder var7 = new SharePhotoContent.Builder().readFrom(var1);
         ArrayList var6 = new ArrayList();
         ArrayList var8 = new ArrayList();

         for (int var3 = 0; var3 < var1.getPhotos().size(); var3++) {
            SharePhoto var5 = var1.getPhotos().get(var3);
            Bitmap var9 = var5.getBitmap();
            SharePhoto var4 = var5;
            if (var9 != null) {
               NativeAppCallAttachmentStore.Attachment var10 = NativeAppCallAttachmentStore.createAttachment(var2, var9);
               var4 = new SharePhoto.Builder().readFrom(var5).setImageUrl(Uri.parse(var10.getAttachmentUrl())).setBitmap(null).build();
               var8.add(var10);
            }

            var6.add(var4);
         }

         var7.setPhotos(var6);
         NativeAppCallAttachmentStore.addAttachments(var8);
         return var7.build();
      }

      private String getActionName(ShareContent var1) {
         String var2;
         if (var1 instanceof ShareLinkContent || var1 instanceof SharePhotoContent) {
            var2 = "share";
         } else if (var1 instanceof ShareOpenGraphContent) {
            var2 = "share_open_graph";
         } else {
            var2 = null;
         }

         return var2;
      }

      public boolean canShow(ShareContent var1, boolean var2) {
         if (var1 != null && ShareDialog.canShowWebTypeCheck((Class<? extends ShareContent>)var1.getClass())) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public AppCall createAppCall(ShareContent var1) {
         this.this$0.logDialogShare(this.this$0.getActivityContext(), var1, ShareDialog.Mode.WEB);
         AppCall var3 = this.this$0.createBaseAppCall();
         ShareContentValidation.validateForWebShare(var1);
         Bundle var2;
         if (var1 instanceof ShareLinkContent) {
            var2 = WebDialogParameters.create((ShareLinkContent)var1);
         } else if (var1 instanceof SharePhotoContent) {
            var2 = WebDialogParameters.create(this.createAndMapAttachments((SharePhotoContent)var1, var3.getCallId()));
         } else {
            var2 = WebDialogParameters.create((ShareOpenGraphContent)var1);
         }

         DialogPresenter.setupAppCallForWebDialog(var3, this.getActionName(var1), var2);
         return var3;
      }

      @Override
      public Object getMode() {
         return ShareDialog.Mode.WEB;
      }
   }
}
