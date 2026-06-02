package com.jibo.ui.fragment.dialog.passphrase;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jibo.utils.SharedPreferencesUtil;

public class LoopPassphraseInfoDialog extends LoopPassphraseBaseDialog {
   private String g;
   @BindView
   TextView passphrase;

   @Override
   public void a(Bundle var1) {
      super.a(var1);
      this.g = this.getArguments().getString("ARGS_PASSPHRASE", "");
   }

   @OnClick
   public void cancelClicked(View var1) {
      if (LoopPassphraseUtils.DialogType.NO_BACKUP_BY_TIMEOUT.equalsName(this.e)) {
         this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.getString(2131756103))));
      } else {
         this.dismiss();
      }
   }

   @OnClick
   public void okayClicked(View var1) {
      this.dismiss();
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      AppCompatDialog var3 = new AppCompatDialog(this.getActivity(), 16974132);
      View var2 = this.getActivity().getLayoutInflater().inflate(2131427409, null);
      ButterKnife.a(this, var2);
      this.c = SharedPreferencesUtil.f(this.getContext());
      this.btnCancel.setVisibility(8);
      if (!TextUtils.isEmpty(this.g)) {
         this.passphrase.setText(this.g);
         this.title.setText(this.getString(2131756049, this.c.getName()));
         this.text.setText(2131755517);
      } else {
         this.passphrase.setVisibility(8);
         if (LoopPassphraseUtils.DialogType.NO_BACKUP_BY_TIMEOUT.equalsName(this.e)) {
            this.title.setText(this.getString(2131756048, this.c.getName()));
            this.text.setText(2131755806);
            this.btnCancel.setText(2131755520);
            this.btnCancel.setVisibility(0);
         } else {
            this.title.setText(this.getString(2131756046, this.c.getName()));
            this.text.setText(2131755515);
         }
      }

      var3.setContentView(var2);
      var3.setCancelable(true);
      return var3;
   }

   @Override
   public void onDismiss(DialogInterface var1) {
      if (LoopPassphraseUtils.DialogType.NO_BACKUP_BY_TIMEOUT.equalsName(this.e)) {
         SharedPreferencesUtil.e(this.getActivity(), this.c.getId());
      }

      super.onDismiss(var1);
   }

   @Override
   public void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      var1.putString("ARGS_PASSPHRASE", this.g);
   }
}
