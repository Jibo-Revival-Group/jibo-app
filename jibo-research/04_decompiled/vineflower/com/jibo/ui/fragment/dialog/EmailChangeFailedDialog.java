package com.jibo.ui.fragment.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class EmailChangeFailedDialog extends DialogFragment {
   Unbinder a;
   private String b;
   @BindView
   TextView email;
   @BindView
   TextView footer;
   @BindView
   TextView textView;

   @OnClick
   public void onCancelClicked(View var1) {
      this.dismiss();
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      TextView var2 = (TextView)LayoutInflater.from(this.getActivity()).inflate(2131427417, null);
      var2.setText(2131755285);
      View var3 = LayoutInflater.from(this.getActivity()).inflate(2131427402, null);
      AlertDialog.Builder var5 = new AlertDialog.Builder(this.getActivity()).a(var2).b(var3);
      this.a = ButterKnife.a(this, var3);
      String var4;
      if (var1 != null) {
         var4 = var1.getString("ARGS_EMAIL");
      } else {
         var4 = this.getArguments().getString("ARGS_EMAIL");
      }

      this.b = var4;
      this.email.setText(this.b);
      return var5.b();
   }

   @Override
   public void onDestroyView() {
      super.onDestroyView();
      this.a.unbind();
   }

   @OnClick
   public void onTryAgainClicked(View var1) {
      if (this.getTargetFragment() != null && this.getTargetFragment() instanceof DialogUtils.DialogFragmentWrapperClickListener) {
         ((DialogUtils.DialogFragmentWrapperClickListener)this.getTargetFragment()).a(this.getTargetRequestCode(), var1.getId(), null);
      }

      this.dismiss();
   }
}
