package com.jibo.p019ui.fragment.dialog.passphrase;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.key.JiboKeyAsyncClient;
import com.jibo.aws.integration.aws.services.key.model.Backup;
import com.jibo.aws.integration.aws.services.key.model.RestoreRequest;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseUtils;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.Util;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public class LoopPassphraseRestoreDialog extends LoopPassphraseBaseDialog {

    public interface BackupKeyRestoredListener {
        /* JADX INFO: renamed from: a */
        void mo10576a(Loop loop);
    }

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogM10572a = super.m10572a(bundle, R.layout.dialog_loop_passphrase_restore);
        this.title.setText(getString(R.string.title_loop_passphrase_restore, this.f10165c.getName()));
        if (!TextUtils.isEmpty(this.f10279e)) {
            if (LoopPassphraseUtils.DialogType.ON_RECONNECT_TO_JIBO.equalsName(this.f10279e)) {
                this.text.setText(R.string.reconnect_to_your_jibo_text);
                this.title.setText(R.string.title_reconnect_to_your_jibo);
            } else if (LoopPassphraseUtils.DialogType.RESTORE_BY_TIMEOUT.equalsName(this.f10279e)) {
                this.text.setText(R.string.text_loop_passphrase_restore_timeout);
                this.title.setText(getString(R.string.title_loop_passphrase_restore_timeout, this.f10165c.getName()));
            }
        }
        return dialogM10572a;
    }

    @Override // com.jibo.p019ui.fragment.dialog.BaseDialogFragment, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (LoopPassphraseUtils.DialogType.RESTORE_BY_TIMEOUT.equalsName(this.f10279e)) {
            SharedPreferencesUtil.m11442e(getActivity(), this.f10165c.getId());
        }
        super.onDismiss(dialogInterface);
    }

    @OnClick
    public void onSetClicked(View view) {
        if (this.passphraseEdit.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), R.string.loop_passphrase_empty, 1).show();
            return;
        }
        JiboKeyAsyncClient jiboKeyAsyncClientM10126d = EntityData.m10089a(getActivity()).m10126d();
        final KeyManager keyManager = KeyManager.getInstance(getContext(), EntityData.m10089a(getActivity()).m10134i().getId());
        final String id = this.f10165c.getId();
        try {
            jiboKeyAsyncClientM10126d.restoreEncryptedKey(id, Util.m11495b(this.passphraseEdit.getText().toString()), new AsyncHandler<RestoreRequest, Backup>() { // from class: com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseRestoreDialog.1
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    LoopPassphraseRestoreDialog.this.m10491a(exc, "Error restoring key", true);
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(RestoreRequest restoreRequest, Backup backup) {
                    try {
                        keyManager.saveSymmetricKey(LoopPassphraseRestoreDialog.this.getContext(), id, backup.getEncryptedKey(), LoopPassphraseRestoreDialog.this.passphraseEdit.getText().toString());
                        LoopPassphraseUtils.m10580a(LoopPassphraseRestoreDialog.this.getContext());
                        if (LoopPassphraseRestoreDialog.this.getTargetFragment() != null && (LoopPassphraseRestoreDialog.this.getTargetFragment() instanceof BackupKeyRestoredListener)) {
                            ((BackupKeyRestoredListener) LoopPassphraseRestoreDialog.this.getTargetFragment()).mo10576a(LoopPassphraseRestoreDialog.this.f10165c);
                        }
                    } catch (Exception e) {
                        Crashlytics.m5597a((Throwable) e);
                    }
                    LoopPassphraseRestoreDialog.this.dismiss();
                }
            });
        } catch (NoSuchAlgorithmException e) {
            Crashlytics.m5597a((Throwable) e);
        }
    }

    @OnClick
    public void onCancelClicked(View view) {
        dismiss();
    }
}
