package com.jibo.ui.fragment.dialog.passphrase;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.jibo.aws.integration.aws.services.key.JiboKeyAsyncClient;
import com.jibo.aws.integration.aws.services.key.model.Backup;
import com.jibo.aws.integration.aws.services.key.model.RestoreRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.db.EntityData;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.Util;
import java.security.NoSuchAlgorithmException;

public class LoopPassphraseRestoreDialog extends LoopPassphraseBaseDialog {
   @OnClick
   public void onCancelClicked(View var1) {
      this.dismiss();
   }

   @Override
   public Dialog onCreateDialog(Bundle var1) {
      Dialog var2 = super.a(var1, 2131427408);
      this.title.setText(this.getString(2131756047, this.c.getName()));
      if (!TextUtils.isEmpty(this.e)) {
         if (LoopPassphraseUtils.DialogType.ON_RECONNECT_TO_JIBO.equalsName(this.e)) {
            this.text.setText(2131755617);
            this.title.setText(2131756067);
         } else if (LoopPassphraseUtils.DialogType.RESTORE_BY_TIMEOUT.equalsName(this.e)) {
            this.text.setText(2131755805);
            this.title.setText(this.getString(2131756048, this.c.getName()));
         }
      }

      return var2;
   }

   @Override
   public void onDismiss(DialogInterface var1) {
      if (LoopPassphraseUtils.DialogType.RESTORE_BY_TIMEOUT.equalsName(this.e)) {
         SharedPreferencesUtil.e(this.getActivity(), this.c.getId());
      }

      super.onDismiss(var1);
   }

   @OnClick
   public void onSetClicked(View var1) {
      if (this.passphraseEdit.getText().toString().isEmpty()) {
         Toast.makeText(this.getContext(), 2131755512, 1).show();
      } else {
         JiboKeyAsyncClient var4 = EntityData.a(this.getActivity()).d();
         KeyManager var7 = KeyManager.getInstance(this.getContext(), EntityData.a(this.getActivity()).i().getId());
         String var5 = this.c.getId();

         try {
            String var2 = Util.b(this.passphraseEdit.getText().toString());
            AsyncHandler var3 = new AsyncHandler<RestoreRequest, Backup>(this, var7, var5) {
               final KeyManager a;
               final String b;
               final LoopPassphraseRestoreDialog c;

               {
                  this.c = var1;
                  this.a = var2x;
                  this.b = var3x;
               }

               public void a(RestoreRequest var1, Backup var2x) {
                  String var4x = var2x.getEncryptedKey();

                  try {
                     this.a.saveSymmetricKey(this.c.getContext(), this.b, var4x, this.c.passphraseEdit.getText().toString());
                     LoopPassphraseUtils.a(this.c.getContext());
                     if (this.c.getTargetFragment() != null && this.c.getTargetFragment() instanceof LoopPassphraseRestoreDialog.BackupKeyRestoredListener) {
                        ((LoopPassphraseRestoreDialog.BackupKeyRestoredListener)this.c.getTargetFragment()).a(this.c.c);
                     }
                  } catch (Exception var3x) {
                     Crashlytics.a(var3x);
                  }

                  this.c.dismiss();
               }

               @Override
               public void onError(Exception var1) {
                  this.c.a(var1, "Error restoring key", true);
               }
            };
            var4.restoreEncryptedKey(var5, var2, var3);
         } catch (NoSuchAlgorithmException var6) {
            Crashlytics.a(var6);
         }
      }
   }

   public interface BackupKeyRestoredListener {
      void a(Loop var1);
   }
}
