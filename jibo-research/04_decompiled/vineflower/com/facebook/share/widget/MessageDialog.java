package com.facebook.share.widget;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.Sharer;
import com.facebook.share.internal.LegacyNativeDialogParameters;
import com.facebook.share.internal.MessageDialogFeature;
import com.facebook.share.internal.NativeDialogParameters;
import com.facebook.share.internal.OpenGraphMessageDialogFeature;
import com.facebook.share.internal.ShareContentValidation;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideoContent;
import java.util.ArrayList;
import java.util.List;

public final class MessageDialog extends FacebookDialogBase<ShareContent, Sharer.Result> implements Sharer {
   private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Message.toRequestCode();
   private boolean shouldFailOnDataError = false;

   public MessageDialog(Activity var1) {
      super(var1, DEFAULT_REQUEST_CODE);
      ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
   }

   MessageDialog(Activity var1, int var2) {
      super(var1, var2);
      ShareInternalUtility.registerStaticShareCallback(var2);
   }

   public MessageDialog(Fragment var1) {
      this(new FragmentWrapper(var1));
   }

   MessageDialog(Fragment var1, int var2) {
      this(new FragmentWrapper(var1), var2);
   }

   public MessageDialog(android.support.v4.app.Fragment var1) {
      this(new FragmentWrapper(var1));
   }

   MessageDialog(android.support.v4.app.Fragment var1, int var2) {
      this(new FragmentWrapper(var1), var2);
   }

   private MessageDialog(FragmentWrapper var1) {
      super(var1, DEFAULT_REQUEST_CODE);
      ShareInternalUtility.registerStaticShareCallback(DEFAULT_REQUEST_CODE);
   }

   private MessageDialog(FragmentWrapper var1, int var2) {
      super(var1, var2);
      ShareInternalUtility.registerStaticShareCallback(var2);
   }

   public static boolean canShow(Class<? extends ShareContent> var0) {
      DialogFeature var2 = getFeature(var0);
      boolean var1;
      if (var2 != null && DialogPresenter.canPresentNativeDialogWithFeature(var2)) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private static DialogFeature getFeature(Class<? extends ShareContent> var0) {
      Enum var1;
      if (ShareLinkContent.class.isAssignableFrom(var0)) {
         var1 = MessageDialogFeature.MESSAGE_DIALOG;
      } else if (SharePhotoContent.class.isAssignableFrom(var0)) {
         var1 = MessageDialogFeature.PHOTOS;
      } else if (ShareVideoContent.class.isAssignableFrom(var0)) {
         var1 = MessageDialogFeature.VIDEO;
      } else if (ShareOpenGraphContent.class.isAssignableFrom(var0)) {
         var1 = OpenGraphMessageDialogFeature.OG_MESSAGE_DIALOG;
      } else {
         var1 = null;
      }

      return var1;
   }

   public static void show(Activity var0, ShareContent var1) {
      new MessageDialog(var0).show(var1);
   }

   public static void show(Fragment var0, ShareContent var1) {
      show(new FragmentWrapper(var0), var1);
   }

   public static void show(android.support.v4.app.Fragment var0, ShareContent var1) {
      show(new FragmentWrapper(var0), var1);
   }

   private static void show(FragmentWrapper var0, ShareContent var1) {
      new MessageDialog(var0).show(var1);
   }

   @Override
   protected AppCall createBaseAppCall() {
      return new AppCall(this.getRequestCode());
   }

   @Override
   protected List<FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler> getOrderedModeHandlers() {
      ArrayList var1 = new ArrayList();
      var1.add(new MessageDialog.NativeHandler(this));
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

   private class NativeHandler extends FacebookDialogBase<ShareContent, Sharer.Result>.ModeHandler {
      final MessageDialog this$0;

      private NativeHandler(MessageDialog var1) {
         super(var1);
         this.this$0 = var1;
      }

      public boolean canShow(ShareContent var1, boolean var2) {
         if (var1 != null && MessageDialog.canShow((Class<? extends ShareContent>)var1.getClass())) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public AppCall createAppCall(ShareContent var1) {
         ShareContentValidation.validateForMessage(var1);
         AppCall var2 = this.this$0.createBaseAppCall();
         DialogPresenter.setupAppCallForNativeDialog(var2, new DialogPresenter.ParameterProvider(this, var2, var1, this.this$0.getShouldFailOnDataError()) {
            final MessageDialog.NativeHandler this$1;
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
         }, MessageDialog.getFeature((Class<? extends ShareContent>)var1.getClass()));
         return var2;
      }
   }
}
