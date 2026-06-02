package com.facebook.share.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.facebook.R;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FacebookDialogBase;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareContent;

public final class SendButton extends ShareButtonBase {
   public SendButton(Context var1) {
      super(var1, null, 0, "fb_send_button_create", "fb_send_button_did_tap");
   }

   public SendButton(Context var1, AttributeSet var2) {
      super(var1, var2, 0, "fb_send_button_create", "fb_send_button_did_tap");
   }

   public SendButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3, "fb_send_button_create", "fb_send_button_did_tap");
   }

   @Override
   protected int getDefaultRequestCode() {
      return CallbackManagerImpl.RequestCodeOffset.Message.toRequestCode();
   }

   @Override
   protected int getDefaultStyleResource() {
      return R.style.com_facebook_button_send;
   }

   @Override
   protected FacebookDialogBase<ShareContent, Sharer.Result> getDialog() {
      MessageDialog var1;
      if (this.getFragment() != null) {
         var1 = new MessageDialog(this.getFragment(), this.getRequestCode());
      } else if (this.getNativeFragment() != null) {
         var1 = new MessageDialog(this.getNativeFragment(), this.getRequestCode());
      } else {
         var1 = new MessageDialog(this.getActivity(), this.getRequestCode());
      }

      return var1;
   }
}
