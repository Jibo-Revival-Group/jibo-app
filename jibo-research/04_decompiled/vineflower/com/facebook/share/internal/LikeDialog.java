package com.facebook.share.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import java.util.ArrayList;
import java.util.List;

public class LikeDialog extends FacebookDialogBase<LikeContent, LikeDialog.Result> {
   private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.Like.toRequestCode();
   private static final String TAG = "LikeDialog";

   public LikeDialog(Activity var1) {
      super(var1, DEFAULT_REQUEST_CODE);
   }

   public LikeDialog(Fragment var1) {
      this(new FragmentWrapper(var1));
   }

   public LikeDialog(android.support.v4.app.Fragment var1) {
      this(new FragmentWrapper(var1));
   }

   public LikeDialog(FragmentWrapper var1) {
      super(var1, DEFAULT_REQUEST_CODE);
   }

   public static boolean canShowNativeDialog() {
      return DialogPresenter.canPresentNativeDialogWithFeature(getFeature());
   }

   public static boolean canShowWebFallback() {
      return DialogPresenter.canPresentWebFallbackDialogWithFeature(getFeature());
   }

   private static Bundle createParameters(LikeContent var0) {
      Bundle var1 = new Bundle();
      var1.putString("object_id", var0.getObjectId());
      var1.putString("object_type", var0.getObjectType());
      return var1;
   }

   private static DialogFeature getFeature() {
      return LikeDialogFeature.LIKE_DIALOG;
   }

   @Override
   protected AppCall createBaseAppCall() {
      return new AppCall(this.getRequestCode());
   }

   @Override
   protected List<FacebookDialogBase<LikeContent, LikeDialog.Result>.ModeHandler> getOrderedModeHandlers() {
      ArrayList var1 = new ArrayList();
      var1.add(new LikeDialog.NativeHandler(this));
      var1.add(new LikeDialog.WebFallbackHandler(this));
      return var1;
   }

   @Override
   protected void registerCallbackImpl(CallbackManagerImpl var1, FacebookCallback<LikeDialog.Result> var2) {
      ResultProcessor var3;
      if (var2 == null) {
         var3 = null;
      } else {
         var3 = new ResultProcessor(this, var2, var2) {
            final LikeDialog this$0;
            final FacebookCallback val$callback;

            {
               this.this$0 = var1;
               this.val$callback = var3x;
            }

            @Override
            public void onSuccess(AppCall var1, Bundle var2x) {
               this.val$callback.onSuccess(new LikeDialog.Result(var2x));
            }
         };
      }

      CallbackManagerImpl.Callback var4 = new CallbackManagerImpl.Callback(this, var3) {
         final LikeDialog this$0;
         final ResultProcessor val$resultProcessor;

         {
            this.this$0 = var1;
            this.val$resultProcessor = var2x;
         }

         @Override
         public boolean onActivityResult(int var1, Intent var2x) {
            return ShareInternalUtility.handleActivityResult(this.this$0.getRequestCode(), var1, var2x, this.val$resultProcessor);
         }
      };
      var1.registerCallback(this.getRequestCode(), var4);
   }

   private class NativeHandler extends FacebookDialogBase<LikeContent, LikeDialog.Result>.ModeHandler {
      final LikeDialog this$0;

      private NativeHandler(LikeDialog var1) {
         super(var1);
         this.this$0 = var1;
      }

      public boolean canShow(LikeContent var1, boolean var2) {
         if (var1 != null && LikeDialog.canShowNativeDialog()) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public AppCall createAppCall(LikeContent var1) {
         AppCall var2 = this.this$0.createBaseAppCall();
         DialogPresenter.setupAppCallForNativeDialog(var2, new DialogPresenter.ParameterProvider(this, var1) {
            final LikeDialog.NativeHandler this$1;
            final LikeContent val$content;

            {
               this.this$1 = var1;
               this.val$content = var2x;
            }

            @Override
            public Bundle getLegacyParameters() {
               Log.e("LikeDialog", "Attempting to present the Like Dialog with an outdated Facebook app on the device");
               return new Bundle();
            }

            @Override
            public Bundle getParameters() {
               return LikeDialog.createParameters(this.val$content);
            }
         }, LikeDialog.getFeature());
         return var2;
      }
   }

   public static final class Result {
      private final Bundle bundle;

      public Result(Bundle var1) {
         this.bundle = var1;
      }

      public Bundle getData() {
         return this.bundle;
      }
   }

   private class WebFallbackHandler extends FacebookDialogBase<LikeContent, LikeDialog.Result>.ModeHandler {
      final LikeDialog this$0;

      private WebFallbackHandler(LikeDialog var1) {
         super(var1);
         this.this$0 = var1;
      }

      public boolean canShow(LikeContent var1, boolean var2) {
         if (var1 != null && LikeDialog.canShowWebFallback()) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public AppCall createAppCall(LikeContent var1) {
         AppCall var2 = this.this$0.createBaseAppCall();
         DialogPresenter.setupAppCallForWebFallbackDialog(var2, LikeDialog.createParameters(var1), LikeDialog.getFeature());
         return var2;
      }
   }
}
