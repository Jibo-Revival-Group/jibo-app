package com.jibo.ui.fragment.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class CantDeleteDialog extends DialogFragment {
   @Override
   public Dialog onCreateDialog(Bundle var1) {
      TextView var3 = (TextView)LayoutInflater.from(this.getActivity()).inflate(2131427417, null);
      var3.setText(2131755576);
      View var2 = LayoutInflater.from(this.getActivity()).inflate(2131427398, null);
      AlertDialog.Builder var4 = new AlertDialog.Builder(this.getActivity()).a(var3).b(var2);
      var4.a(2131755570, new OnClickListener(this) {
         final CantDeleteDialog a;

         {
            this.a = var1;
         }

         public void onClick(DialogInterface var1, int var2x) {
            this.a.dismiss();
         }
      });
      var4.b(2131755544, new OnClickListener(this) {
         final CantDeleteDialog a;

         {
            this.a = var1;
         }

         public void onClick(DialogInterface var1, int var2) {
            Intent var3 = new Intent("android.intent.action.VIEW", Uri.parse("https://support.jibo.com/jibo/articles/en_US/FAQ/delete-account"));
            this.a.startActivity(var3);
         }
      });
      return var4.b();
   }

   @Override
   public void onDestroyView() {
      super.onDestroyView();
   }
}
