package com.google.android.gms.common;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import com.google.android.gms.common.internal.zzbq;

public class SupportErrorDialogFragment extends DialogFragment {
   private Dialog a = null;
   private OnCancelListener b = null;

   public static SupportErrorDialogFragment a(Dialog var0, OnCancelListener var1) {
      SupportErrorDialogFragment var2 = new SupportErrorDialogFragment();
      var0 = zzbq.a(var0, "Cannot display null dialog");
      var0.setOnCancelListener(null);
      var0.setOnDismissListener(null);
      var2.a = var0;
      if (var1 != null) {
         var2.b = var1;
      }

      return var2;
   }

   @Override
   public void onCancel(DialogInterface var1) {
      if (this.b != null) {
         this.b.onCancel(var1);
      }
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      if (this.a == null) {
         this.setShowsDialog(false);
      }

      return this.a;
   }

   @Override
   public void show(FragmentManager var1, String var2) {
      super.show(var1, var2);
   }
}
