package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.R;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.share.DeviceShareDialog;
import com.facebook.share.model.ShareContent;

public final class DeviceShareButton extends FacebookButtonBase {
   private DeviceShareDialog dialog;
   private boolean enabledExplicitlySet;
   private int requestCode = 0;
   private ShareContent shareContent;

   public DeviceShareButton(Context var1) {
      this(var1, null, 0);
   }

   public DeviceShareButton(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   private DeviceShareButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3, 0, "fb_device_share_button_create", "fb_device_share_button_did_tap");
      this.enabledExplicitlySet = false;
      this.dialog = null;
      if (this.isInEditMode()) {
         var3 = 0;
      } else {
         var3 = this.getDefaultRequestCode();
      }

      this.requestCode = var3;
      this.internalSetEnabled(false);
   }

   private boolean canShare() {
      return new DeviceShareDialog(this.getActivity()).canShow(this.getShareContent());
   }

   private DeviceShareDialog getDialog() {
      DeviceShareDialog var1;
      if (this.dialog != null) {
         var1 = this.dialog;
      } else {
         if (this.getFragment() != null) {
            this.dialog = new DeviceShareDialog(this.getFragment());
         } else if (this.getNativeFragment() != null) {
            this.dialog = new DeviceShareDialog(this.getNativeFragment());
         } else {
            this.dialog = new DeviceShareDialog(this.getActivity());
         }

         var1 = this.dialog;
      }

      return var1;
   }

   private void internalSetEnabled(boolean var1) {
      this.setEnabled(var1);
      this.enabledExplicitlySet = false;
   }

   private void setRequestCode(int var1) {
      if (FacebookSdk.isFacebookRequestCode(var1)) {
         throw new IllegalArgumentException("Request code " + var1 + " cannot be within the range reserved by the Facebook SDK.");
      }

      this.requestCode = var1;
   }

   @Override
   protected void configureButton(Context var1, AttributeSet var2, int var3, int var4) {
      super.configureButton(var1, var2, var3, var4);
      this.setInternalOnClickListener(this.getShareOnClickListener());
   }

   @Override
   protected int getDefaultRequestCode() {
      return CallbackManagerImpl.RequestCodeOffset.Share.toRequestCode();
   }

   @Override
   protected int getDefaultStyleResource() {
      return R.style.com_facebook_button_share;
   }

   @Override
   public int getRequestCode() {
      return this.requestCode;
   }

   public ShareContent getShareContent() {
      return this.shareContent;
   }

   protected OnClickListener getShareOnClickListener() {
      return new OnClickListener(this) {
         final DeviceShareButton this$0;

         {
            this.this$0 = var1;
         }

         public void onClick(View var1) {
            this.this$0.callExternalOnClickListener(var1);
            this.this$0.getDialog().show(this.this$0.getShareContent());
         }
      };
   }

   public void registerCallback(CallbackManager var1, FacebookCallback<DeviceShareDialog.Result> var2) {
      this.getDialog().registerCallback(var1, var2);
   }

   public void registerCallback(CallbackManager var1, FacebookCallback<DeviceShareDialog.Result> var2, int var3) {
      this.setRequestCode(var3);
      this.getDialog().registerCallback(var1, var2, var3);
   }

   public void setEnabled(boolean var1) {
      super.setEnabled(var1);
      this.enabledExplicitlySet = true;
   }

   public void setShareContent(ShareContent var1) {
      this.shareContent = var1;
      if (!this.enabledExplicitlySet) {
         this.internalSetEnabled(this.canShare());
      }
   }
}
