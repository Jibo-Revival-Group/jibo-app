package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;

public class FacebookDialogFragment extends DialogFragment {
   public static final String TAG = "FacebookDialogFragment";
   private Dialog dialog;

   private void onCompleteWebDialog(Bundle var1, FacebookException var2) {
      FragmentActivity var4 = this.getActivity();
      Intent var5 = NativeProtocol.createProtocolResultIntent(var4.getIntent(), var1, var2);
      byte var3;
      if (var2 == null) {
         var3 = -1;
      } else {
         var3 = 0;
      }

      var4.setResult(var3, var5);
      var4.finish();
   }

   private void onCompleteWebFallbackDialog(Bundle var1) {
      FragmentActivity var4 = this.getActivity();
      Intent var3 = new Intent();
      Bundle var2 = var1;
      if (var1 == null) {
         var2 = new Bundle();
      }

      var3.putExtras(var2);
      var4.setResult(-1, var3);
      var4.finish();
   }

   @Override
   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      if (this.dialog instanceof WebDialog && this.isResumed()) {
         ((WebDialog)this.dialog).resize();
      }
   }

   @Override
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      if (this.dialog == null) {
         FragmentActivity var4 = this.getActivity();
         Bundle var3 = NativeProtocol.getMethodArgumentsFromIntent(var4.getIntent());
         WebDialog var5;
         if (!var3.getBoolean("is_fallback", false)) {
            String var2 = var3.getString("action");
            var3 = var3.getBundle("params");
            if (Utility.isNullOrEmpty(var2)) {
               Utility.logd("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
               var4.finish();
               return;
            }

            var5 = new WebDialog.Builder(var4, var2, var3).setOnCompleteListener(new WebDialog.OnCompleteListener(this) {
               final FacebookDialogFragment this$0;

               {
                  this.this$0 = var1;
               }

               @Override
               public void onComplete(Bundle var1, FacebookException var2x) {
                  this.this$0.onCompleteWebDialog(var1, var2x);
               }
            }).build();
         } else {
            String var6 = var3.getString("url");
            if (Utility.isNullOrEmpty(var6)) {
               Utility.logd("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
               var4.finish();
               return;
            }

            var5 = new FacebookWebFallbackDialog(var4, var6, String.format("fb%s://bridge/", FacebookSdk.getApplicationId()));
            var5.setOnCompleteListener(new WebDialog.OnCompleteListener(this) {
               final FacebookDialogFragment this$0;

               {
                  this.this$0 = var1;
               }

               @Override
               public void onComplete(Bundle var1, FacebookException var2) {
                  this.this$0.onCompleteWebFallbackDialog(var1);
               }
            });
         }

         this.dialog = var5;
      }
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      if (this.dialog == null) {
         this.onCompleteWebDialog(null, null);
         this.setShowsDialog(false);
      }

      return this.dialog;
   }

   @Override
   public void onDestroyView() {
      if (this.getDialog() != null && this.getRetainInstance()) {
         this.getDialog().setDismissMessage(null);
      }

      super.onDestroyView();
   }

   @Override
   public void onResume() {
      super.onResume();
      if (this.dialog instanceof WebDialog) {
         ((WebDialog)this.dialog).resize();
      }
   }

   public void setDialog(Dialog var1) {
      this.dialog = var1;
   }
}
