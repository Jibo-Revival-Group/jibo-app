package com.jibo.p019ui.fragment.dialog.passphrase;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.jibo.R;
import com.jibo.p019ui.fragment.dialog.BaseDialogFragment;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.UIUtils;

/* JADX INFO: loaded from: classes.dex */
public class LoopPassphraseBaseDialog extends BaseDialogFragment {

    /* JADX INFO: renamed from: d */
    public static final String f10278d = LoopPassphraseBaseDialog.class.getSimpleName();

    @BindView
    TextView btnCancel;

    @BindView
    TextView btnSet;

    /* JADX INFO: renamed from: e */
    protected String f10279e;

    /* JADX INFO: renamed from: f */
    protected TextWatcher f10280f = new TextWatcher() { // from class: com.jibo.ui.fragment.dialog.passphrase.LoopPassphraseBaseDialog.1
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            LoopPassphraseBaseDialog.this.getActivity().invalidateOptionsMenu();
            UIUtils.m11481b(LoopPassphraseBaseDialog.this.passphraseEdit.getText().toString(), LoopPassphraseBaseDialog.this.footer, ImageUtils.m11399b(LoopPassphraseBaseDialog.this.getContext(), R.color.black));
            LoopPassphraseBaseDialog.this.btnSet.setEnabled(UIUtils.m11479a(LoopPassphraseBaseDialog.this.passphraseEdit.getText().toString()));
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }
    };

    @BindView
    TextView footer;

    @BindView
    EditText passphraseEdit;

    @BindView
    TextView text;

    @BindView
    TextView title;

    /* JADX INFO: renamed from: a */
    public Dialog m10572a(Bundle bundle, int i) {
        AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), android.R.style.Theme.DeviceDefault.Light.Dialog.NoActionBar);
        this.f10164b = getActivity().getLayoutInflater().inflate(i, (ViewGroup) null);
        ButterKnife.m5154a(this, this.f10164b);
        this.passphraseEdit.addTextChangedListener(this.f10280f);
        UIUtils.m11481b(this.passphraseEdit.getText().toString(), this.footer, ImageUtils.m11399b(getContext(), R.color.black));
        this.btnSet.setEnabled(UIUtils.m11479a(this.passphraseEdit.getText().toString()));
        appCompatDialog.setContentView(this.f10164b);
        setCancelable(true);
        return appCompatDialog;
    }

    @Override // com.jibo.p019ui.fragment.dialog.BaseDialogFragment, android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("ARGS_DIALOG_TYPE", this.f10279e);
    }

    @Override // com.jibo.p019ui.fragment.dialog.BaseDialogFragment
    /* JADX INFO: renamed from: a */
    public void mo10490a(Bundle bundle) {
        super.mo10490a(bundle);
        this.f10279e = getArguments().getString("ARGS_DIALOG_TYPE", "");
    }
}
