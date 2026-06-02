package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareContent;

public final class ShareButton extends ShareButtonBase {
   public ShareButton(Context var1) {
      super(var1, null, 0, "fb_share_button_create", "fb_share_button_did_tap");
   }

   public ShareButton(Context var1, AttributeSet var2) {
      super(var1, var2, 0, "fb_share_button_create", "fb_share_button_did_tap");
   }

   public ShareButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3, "fb_share_button_create", "fb_share_button_did_tap");
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
   protected FacebookDialogBase<ShareContent, Sharer.Result> getDialog() {
      ShareDialog var1;
      if (this.getFragment() != null) {
         var1 = new ShareDialog(this.getFragment(), this.getRequestCode());
      } else if (this.getNativeFragment() != null) {
         var1 = new ShareDialog(this.getNativeFragment(), this.getRequestCode());
      } else {
         var1 = new ShareDialog(this.getActivity(), this.getRequestCode());
      }

      return var1;
   }
}
