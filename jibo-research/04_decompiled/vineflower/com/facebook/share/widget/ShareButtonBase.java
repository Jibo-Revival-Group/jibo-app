package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.Sharer;
import com.facebook.share.internal.ShareInternalUtility;
import com.facebook.share.model.ShareContent;

public abstract class ShareButtonBase extends FacebookButtonBase {
   private boolean enabledExplicitlySet;
   private int requestCode = 0;
   private ShareContent shareContent;

   protected ShareButtonBase(Context var1, AttributeSet var2, int var3, String var4, String var5) {
      super(var1, var2, var3, 0, var4, var5);
      this.enabledExplicitlySet = false;
      if (this.isInEditMode()) {
         var3 = 0;
      } else {
         var3 = this.getDefaultRequestCode();
      }

      this.requestCode = var3;
      this.internalSetEnabled(false);
   }

   private void internalSetEnabled(boolean var1) {
      this.setEnabled(var1);
      this.enabledExplicitlySet = false;
   }

   protected boolean canShare() {
      return this.getDialog().canShow(this.getShareContent());
   }

   @Override
   protected void configureButton(Context var1, AttributeSet var2, int var3, int var4) {
      super.configureButton(var1, var2, var3, var4);
      this.setInternalOnClickListener(this.getShareOnClickListener());
   }

   protected abstract FacebookDialogBase<ShareContent, Sharer.Result> getDialog();

   @Override
   public int getRequestCode() {
      return this.requestCode;
   }

   public ShareContent getShareContent() {
      return this.shareContent;
   }

   protected OnClickListener getShareOnClickListener() {
      return new OnClickListener(this) {
         final ShareButtonBase this$0;

         {
            this.this$0 = var1;
         }

         public void onClick(View var1) {
            this.this$0.callExternalOnClickListener(var1);
            this.this$0.getDialog().show(this.this$0.getShareContent());
         }
      };
   }

   public void registerCallback(CallbackManager var1, FacebookCallback<Sharer.Result> var2) {
      ShareInternalUtility.registerSharerCallback(this.getRequestCode(), var1, var2);
   }

   public void registerCallback(CallbackManager var1, FacebookCallback<Sharer.Result> var2, int var3) {
      this.setRequestCode(var3);
      this.registerCallback(var1, var2);
   }

   public void setEnabled(boolean var1) {
      super.setEnabled(var1);
      this.enabledExplicitlySet = true;
   }

   protected void setRequestCode(int var1) {
      if (FacebookSdk.isFacebookRequestCode(var1)) {
         throw new IllegalArgumentException("Request code " + var1 + " cannot be within the range reserved by the Facebook SDK.");
      }

      this.requestCode = var1;
   }

   public void setShareContent(ShareContent var1) {
      this.shareContent = var1;
      if (!this.enabledExplicitlySet) {
         this.internalSetEnabled(this.canShare());
      }
   }
}
