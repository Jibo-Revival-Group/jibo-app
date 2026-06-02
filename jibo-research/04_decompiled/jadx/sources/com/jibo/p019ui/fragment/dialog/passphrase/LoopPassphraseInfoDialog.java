package com.jibo.p019ui.fragment.dialog.passphrase;

import android.R;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseUtils;
import com.jibo.utils.SharedPreferencesUtil;

/* JADX INFO: loaded from: classes.dex */
public class LoopPassphraseInfoDialog extends LoopPassphraseBaseDialog {

    /* JADX INFO: renamed from: g */
    private String f10283g;

    @BindView
    TextView passphrase;

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), R.style.Theme.DeviceDefault.Light.Dialog.NoActionBar);
        View viewInflate = getActivity().getLayoutInflater().inflate(com.jibo.R.layout.dialog_loop_passphrase_set, (ViewGroup) null);
        ButterKnife.m5154a(this, viewInflate);
        this.f10165c = SharedPreferencesUtil.m11443f(getContext());
        this.btnCancel.setVisibility(8);
        if (!TextUtils.isEmpty(this.f10283g)) {
            this.passphrase.setText(this.f10283g);
            this.title.setText(getString(com.jibo.R.string.title_loop_passphrase_set, this.f10165c.getName()));
            this.text.setText(com.jibo.R.string.loop_passphrase_set_text);
        } else {
            this.passphrase.setVisibility(8);
            if (LoopPassphraseUtils.DialogType.NO_BACKUP_BY_TIMEOUT.equalsName(this.f10279e)) {
                this.title.setText(getString(com.jibo.R.string.title_loop_passphrase_restore_timeout, this.f10165c.getName()));
                this.text.setText(com.jibo.R.string.text_loop_passphrase_restore_timeout_nobackup);
                this.btnCancel.setText(com.jibo.R.string.loop_suspended_learn_more);
                this.btnCancel.setVisibility(0);
            } else {
                this.title.setText(getString(com.jibo.R.string.title_loop_passphrase_not_set, this.f10165c.getName()));
                this.text.setText(com.jibo.R.string.loop_passphrase_not_set_text);
            }
        }
        appCompatDialog.setContentView(viewInflate);
        appCompatDialog.setCancelable(true);
        return appCompatDialog;
    }

    @Override // com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseBaseDialog, com.jibo.p019ui.fragment.dialog.BaseDialogFragment, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("ARGS_PASSPHRASE", this.f10283g);
    }

    @Override // com.jibo.p019ui.fragment.dialog.passphrase.LoopPassphraseBaseDialog, com.jibo.p019ui.fragment.dialog.BaseDialogFragment
    /* JADX INFO: renamed from: a */
    public void mo10490a(Bundle bundle) {
        super.mo10490a(bundle);
        this.f10283g = getArguments().getString("ARGS_PASSPHRASE", "");
    }

    @Override // com.jibo.p019ui.fragment.dialog.BaseDialogFragment, android.support.v4.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (LoopPassphraseUtils.DialogType.NO_BACKUP_BY_TIMEOUT.equalsName(this.f10279e)) {
            SharedPreferencesUtil.m11442e(getActivity(), this.f10165c.getId());
        }
        super.onDismiss(dialogInterface);
    }

    @OnClick
    public void okayClicked(View view) {
        dismiss();
    }

    @OnClick
    public void cancelClicked(View view) {
        if (LoopPassphraseUtils.DialogType.NO_BACKUP_BY_TIMEOUT.equalsName(this.f10279e)) {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(com.jibo.R.string.wifi_setup_overview_url))));
        } else {
            dismiss();
        }
    }
}
