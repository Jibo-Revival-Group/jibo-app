package com.jibo.p019ui.fragment.dialog.passphrase;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Toast;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.common.model.CommandResponse;
import com.jibo.aws.integration.aws.services.key.JiboKeyAsyncClient;
import com.jibo.aws.integration.aws.services.key.model.BackupRequest;
import com.jibo.aws.integration.util.KeyManager;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseUtils;
import com.jibo.utils.SharedPreferencesUtil;
import com.jibo.utils.Util;

/* JADX INFO: loaded from: classes.dex */
public class LoopPassphraseSetDialog extends LoopPassphraseBaseDialog {

    /* JADX INFO: renamed from: g */
    public static final String f10301g = LoopPassphraseSetDialog.class.getSimpleName();

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog dialogM10572a = super.m10572a(bundle, R.layout.dialog_loop_passphrase);
        this.f10165c = SharedPreferencesUtil.m11443f(getContext());
        this.title.setText(R.string.title_loop_passphrase);
        this.text.setText(Html.fromHtml(getString(R.string.loop_passphrase_first_time)));
        if (LoopPassphraseUtils.DialogType.MEDIA_ADDED.equalsName(this.f10279e)) {
            this.text.setText(R.string.loop_passphrase_added_content);
        }
        if (LoopPassphraseUtils.DialogType.WEEK_AFTER.equalsName(this.f10279e)) {
            this.text.setText(getString(R.string.loop_passphrase_still_not_protected, this.f10165c.getName()));
        }
        if (LoopPassphraseUtils.DialogType.FROM_SETTINGS.equalsName(this.f10279e)) {
            this.text.setText(getString(R.string.loop_passphrase_not_protected, this.f10165c.getName()));
        }
        if (LoopPassphraseUtils.DialogType.ON_RECONNECT_TO_JIBO_NO_BACKUP.equalsName(this.f10279e)) {
            this.text.setText(getString(R.string.text_passphrase_jibo_reconnect, this.f10165c.getName()));
            this.title.setText(R.string.title_backup_your_jibo);
            this.btnCancel.setVisibility(4);
            this.btnSet.setText(R.string.set);
            setCancelable(false);
        }
        return dialogM10572a;
    }

    @OnClick
    public void onSetClicked(View view) {
        if (this.passphraseEdit.getText().toString().isEmpty()) {
            Toast.makeText(getContext(), R.string.loop_passphrase_empty, 1).show();
            return;
        }
        JiboKeyAsyncClient jiboKeyAsyncClientM10126d = EntityData.m10089a(getActivity()).m10126d();
        KeyManager keyManager = KeyManager.getInstance(getContext(), EntityData.m10089a(getActivity()).m10134i().getId());
        String id = this.f10165c.getId();
        try {
            jiboKeyAsyncClientM10126d.backupEncryptedKey(id, keyManager.getEncryptedKey(getContext(), id, this.passphraseEdit.getText().toString()), Util.m11495b(this.passphraseEdit.getText().toString()), new AsyncHandler<BackupRequest, CommandResponse>() { // from class: com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseSetDialog.1
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    LoopPassphraseSetDialog.this.m10491a(exc, "Error setting passphrase for key", true);
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(BackupRequest backupRequest, CommandResponse commandResponse) {
                    LoopPassphraseUtils.m10583a(LoopPassphraseSetDialog.this, LoopPassphraseUtils.DialogType.ON_SET, LoopPassphraseSetDialog.this.passphraseEdit.getText().toString());
                    LoopPassphraseUtils.m10580a(LoopPassphraseSetDialog.this.getContext());
                    LoopPassphraseSetDialog.this.dismiss();
                }
            });
        } catch (Exception e) {
            Crashlytics.m5597a((Throwable) e);
        }
    }

    @OnClick
    public void onCancelClicked(View view) {
        dismiss();
        if (LoopPassphraseUtils.DialogType.WEEK_AFTER.equalsName(this.f10279e)) {
            LoopPassphraseUtils.m10583a(this, LoopPassphraseUtils.DialogType.ON_CANCEL, (String) null);
        }
    }
}
