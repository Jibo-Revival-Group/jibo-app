package com.facebook.share;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import com.facebook.FacebookActivity;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.internal.AppCall;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.internal.FragmentWrapper;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import java.util.List;

public class DeviceShareDialog extends FacebookDialogBase<ShareContent, DeviceShareDialog.Result> {
   private static final int DEFAULT_REQUEST_CODE = CallbackManagerImpl.RequestCodeOffset.DeviceShare.toRequestCode();

   public DeviceShareDialog(Activity var1) {
      super(var1, DEFAULT_REQUEST_CODE);
   }

   public DeviceShareDialog(Fragment var1) {
      super(new FragmentWrapper(var1), DEFAULT_REQUEST_CODE);
   }

   public DeviceShareDialog(android.support.v4.app.Fragment var1) {
      super(new FragmentWrapper(var1), DEFAULT_REQUEST_CODE);
   }

   protected boolean canShowImpl(ShareContent var1, Object var2) {
      boolean var3;
      if (!(var1 instanceof ShareLinkContent) && !(var1 instanceof ShareOpenGraphContent)) {
         var3 = false;
      } else {
         var3 = true;
      }

      return var3;
   }

   @Override
   protected AppCall createBaseAppCall() {
      return null;
   }

   @Override
   protected List<FacebookDialogBase<ShareContent, DeviceShareDialog.Result>.ModeHandler> getOrderedModeHandlers() {
      return null;
   }

   @Override
   protected void registerCallbackImpl(CallbackManagerImpl var1, FacebookCallback<DeviceShareDialog.Result> var2) {
      var1.registerCallback(this.getRequestCode(), new CallbackManagerImpl.Callback(this, var2) {
         final DeviceShareDialog this$0;
         final FacebookCallback val$callback;

         {
            this.this$0 = var1;
            this.val$callback = var2x;
         }

         @Override
         public boolean onActivityResult(int var1, Intent var2x) {
            if (var2x.hasExtra("error")) {
               FacebookRequestError var3 = (FacebookRequestError)var2x.getParcelableExtra("error");
               this.val$callback.onError(var3.getException());
            } else {
               this.val$callback.onSuccess(new DeviceShareDialog.Result());
            }

            return true;
         }
      });
   }

   protected void showImpl(ShareContent var1, Object var2) {
      if (var1 == null) {
         throw new FacebookException("Must provide non-null content to share");
      }

      if (!(var1 instanceof ShareLinkContent) && !(var1 instanceof ShareOpenGraphContent)) {
         throw new FacebookException(this.getClass().getSimpleName() + " only supports ShareLinkContent or ShareOpenGraphContent");
      }

      var2 = new Intent();
      var2.setClass(FacebookSdk.getApplicationContext(), FacebookActivity.class);
      var2.setAction("DeviceShareDialogFragment");
      var2.putExtra("content", var1);
      this.startActivityForResult(var2, this.getRequestCode());
   }

   public static class Result {
   }
}
