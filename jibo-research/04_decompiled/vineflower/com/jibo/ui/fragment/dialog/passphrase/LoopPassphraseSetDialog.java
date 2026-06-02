package com.jibo.ui.fragment.dialog.passphrase;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Toast;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.key.JiboKeyAsyncClient;
import com.jibo.aws.integration.aws.services.key.model.BackupRequest;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.db.EntityData;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.Util;

public class LoopPassphraseSetDialog extends LoopPassphraseBaseDialog {
   public static final String g = LoopPassphraseSetDialog.class.getSimpleName();

   @OnClick
   public void onCancelClicked(View var1) {
      this.dismiss();
      if (LoopPassphraseUtils.DialogType.WEEK_AFTER.equalsName(this.e)) {
         LoopPassphraseUtils.a(this, LoopPassphraseUtils.DialogType.ON_CANCEL, null);
      }
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      Dialog var2 = super.a(var1, 2131427407);
      this.c = SharedPreferencesUtil.f(this.getContext());
      this.title.setText(2131756045);
      this.text.setText(Html.fromHtml(this.getString(2131755513)));
      if (LoopPassphraseUtils.DialogType.MEDIA_ADDED.equalsName(this.e)) {
         this.text.setText(2131755511);
      }

      if (LoopPassphraseUtils.DialogType.WEEK_AFTER.equalsName(this.e)) {
         this.text.setText(this.getString(2131755518, this.c.getName()));
      }

      if (LoopPassphraseUtils.DialogType.FROM_SETTINGS.equalsName(this.e)) {
         this.text.setText(this.getString(2131755514, this.c.getName()));
      }

      if (LoopPassphraseUtils.DialogType.ON_RECONNECT_TO_JIBO_NO_BACKUP.equalsName(this.e)) {
         this.text.setText(this.getString(2131755823, this.c.getName()));
         this.title.setText(2131756027);
         this.btnCancel.setVisibility(4);
         this.btnSet.setText(2131755653);
         this.setCancelable(false);
      }

      return var2;
   }

   @OnClick
   public void onSetClicked(View var1) {
      if (this.passphraseEdit.getText().toString().isEmpty()) {
         Toast.makeText(this.getContext(), 2131755512, 1).show();
      } else {
         JiboKeyAsyncClient var2 = EntityData.a(this.getActivity()).d();
         KeyManager var3 = KeyManager.getInstance(this.getContext(), EntityData.a(this.getActivity()).i().getId());
         String var7 = this.c.getId();

         try {
            String var5 = var3.getEncryptedKey(this.getContext(), var7, this.passphraseEdit.getText().toString());
            String var4 = Util.b(this.passphraseEdit.getText().toString());
            AsyncHandler var8 = new AsyncHandler<BackupRequest, CommandResponse>(this) {
               final LoopPassphraseSetDialog a;

               {
                  this.a = var1;
               }

               public void a(BackupRequest var1, CommandResponse var2x) {
                  LoopPassphraseUtils.a(this.a, LoopPassphraseUtils.DialogType.ON_SET, this.a.passphraseEdit.getText().toString());
                  LoopPassphraseUtils.a(this.a.getContext());
                  this.a.dismiss();
               }

               @Override
               public void onError(Exception var1) {
                  this.a.a(var1, "Error setting passphrase for key", true);
               }
            };
            var2.backupEncryptedKey(var7, var5, var4, var8);
         } catch (Exception var6) {
            Crashlytics.a(var6);
         }
      }
   }
}
