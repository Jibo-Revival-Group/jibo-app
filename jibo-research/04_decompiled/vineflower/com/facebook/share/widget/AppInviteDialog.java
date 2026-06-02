package com.facebook.share.widget;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.FacebookCallback;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.DialogFeature;
import com.facebook.internal.DialogPresenter;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.internal.AppInviteDialogFeature;
import com.facebook.share.internal.ResultProcessor;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.AppInviteContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class AppInviteDialog extends FacebookDialogBase<AppInviteContent, AppInviteDialog.Result> {
   private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.AppInvite.toRequestCode();
   private static final String TAG = "AppInviteDialog";

   public AppInviteDialog(Activity var1) {
      super(var1, DEFAULT_REQUEST_CODE);
   }

   public AppInviteDialog(Fragment var1) {
      this(new FragmentWrapper(var1));
   }

   public AppInviteDialog(android.support.v4.app.Fragment var1) {
      this(new FragmentWrapper(var1));
   }

   private AppInviteDialog(FragmentWrapper var1) {
      super(var1, DEFAULT_REQUEST_CODE);
   }

   public static boolean canShow() {
      boolean var0;
      if (!canShowNativeDialog() && !canShowWebFallback()) {
         var0 = false;
      } else {
         var0 = true;
      }

      return var0;
   }

   private static boolean canShowNativeDialog() {
      return DialogPresenter.canPresentNativeDialogWithFeature(getFeature());
   }

   private static boolean canShowWebFallback() {
      return DialogPresenter.canPresentWebFallbackDialogWithFeature(getFeature());
   }

   private static Bundle createParameters(AppInviteContent var0) {
      Bundle var2 = new Bundle();
      var2.putString("app_link_url", var0.getApplinkUrl());
      var2.putString("preview_image_url", var0.getPreviewImageUrl());
      var2.putString("destination", var0.getDestination().toString());
      String var1 = var0.getPromotionCode();
      if (var1 == null) {
         var1 = "";
      }

      String var3 = var0.getPromotionText();
      if (!TextUtils.isEmpty(var3)) {
         try {
            JSONObject var5 = new JSONObject();
            var5.put("promo_code", var1);
            var5.put("promo_text", var3);
            var2.putString("deeplink_context", var5.toString());
            var2.putString("promo_code", var1);
            var2.putString("promo_text", var3);
         } catch (JSONException var4) {
            Log.e("AppInviteDialog", "Json Exception in creating deeplink context");
         }
      }

      return var2;
   }

   private static DialogFeature getFeature() {
      return AppInviteDialogFeature.APP_INVITES_DIALOG;
   }

   public static void show(Activity var0, AppInviteContent var1) {
      new AppInviteDialog(var0).show(var1);
   }

   public static void show(Fragment var0, AppInviteContent var1) {
      show(new FragmentWrapper(var0), var1);
   }

   public static void show(android.support.v4.app.Fragment var0, AppInviteContent var1) {
      show(new FragmentWrapper(var0), var1);
   }

   private static void show(FragmentWrapper var0, AppInviteContent var1) {
      new AppInviteDialog(var0).show(var1);
   }

   @Override
   protected AppCall createBaseAppCall() {
      return new AppCall(this.getRequestCode());
   }

   @Override
   protected List<FacebookDialogBase<AppInviteContent, AppInviteDialog.Result>.ModeHandler> getOrderedModeHandlers() {
      ArrayList var1 = new ArrayList();
      var1.add(new AppInviteDialog.NativeHandler(this));
      var1.add(new AppInviteDialog.WebFallbackHandler(this));
      return var1;
   }

   @Override
   protected void registerCallbackImpl(CallbackManagerImpl var1, FacebookCallback<AppInviteDialog.Result> var2) {
      ResultProcessor var3;
      if (var2 == null) {
         var3 = null;
      } else {
         var3 = new ResultProcessor(this, var2, var2) {
            final AppInviteDialog this$0;
            final FacebookCallback val$callback;

            {
               this.this$0 = var1;
               this.val$callback = var3x;
            }

            @Override
            public void onSuccess(AppCall var1, Bundle var2x) {
               if ("cancel".equalsIgnoreCase(ShareInternalUtility.getNativeDialogCompletionGesture(var2x))) {
                  this.val$callback.onCancel();
               } else {
                  this.val$callback.onSuccess(new AppInviteDialog.Result(var2x));
               }
            }
         };
      }

      CallbackManagerImpl.Callback var4 = new CallbackManagerImpl.Callback(this, var3) {
         final AppInviteDialog this$0;
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

   private class NativeHandler extends FacebookDialogBase<AppInviteContent, AppInviteDialog.Result>.ModeHandler {
      final AppInviteDialog this$0;

      private NativeHandler(AppInviteDialog var1) {
         super(var1);
         this.this$0 = var1;
      }

      public boolean canShow(AppInviteContent var1, boolean var2) {
         return AppInviteDialog.canShowNativeDialog();
      }

      public AppCall createAppCall(AppInviteContent var1) {
         AppCall var2 = this.this$0.createBaseAppCall();
         DialogPresenter.setupAppCallForNativeDialog(var2, new DialogPresenter.ParameterProvider(this, var1) {
            final AppInviteDialog.NativeHandler this$1;
            final AppInviteContent val$content;

            {
               this.this$1 = var1;
               this.val$content = var2x;
            }

            @Override
            public Bundle getLegacyParameters() {
               Log.e("AppInviteDialog", "Attempting to present the AppInviteDialog with an outdated Facebook app on the device");
               return new Bundle();
            }

            @Override
            public Bundle getParameters() {
               return AppInviteDialog.createParameters(this.val$content);
            }
         }, AppInviteDialog.getFeature());
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

   private class WebFallbackHandler extends FacebookDialogBase<AppInviteContent, AppInviteDialog.Result>.ModeHandler {
      final AppInviteDialog this$0;

      private WebFallbackHandler(AppInviteDialog var1) {
         super(var1);
         this.this$0 = var1;
      }

      public boolean canShow(AppInviteContent var1, boolean var2) {
         return AppInviteDialog.canShowWebFallback();
      }

      public AppCall createAppCall(AppInviteContent var1) {
         AppCall var2 = this.this$0.createBaseAppCall();
         DialogPresenter.setupAppCallForWebFallbackDialog(var2, AppInviteDialog.createParameters(var1), AppInviteDialog.getFeature());
         return var2;
      }
   }
}
