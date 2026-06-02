package com.jibo.p019ui.fragment.dialog;

import android.R;
import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialog;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.jibo.aws.integration.aws.services.loop.model.Loop;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.view.proxima.CustomFontEditText;

/* JADX INFO: loaded from: classes.dex */
public class ChangeLoopNameDialog extends DialogFragment {

    /* JADX INFO: renamed from: a */
    Unbinder f10171a;

    /* JADX INFO: renamed from: b */
    private Loop f10172b;

    @BindView
    EditText nameEdit;

    @BindView
    TextView tipText;

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        if (bundle != null) {
            this.f10172b = (Loop) bundle.getParcelable(Loop.class.getSimpleName());
        } else if (getArguments() != null) {
            this.f10172b = (Loop) getArguments().getParcelable(Loop.class.getSimpleName());
        }
        AppCompatDialog appCompatDialog = new AppCompatDialog(getActivity(), R.style.Theme.DeviceDefault.Light.Dialog.NoActionBar);
        View viewInflate = getActivity().getLayoutInflater().inflate(com.jibo.R.layout.dialog_change_loop_name, (ViewGroup) null);
        this.f10171a = ButterKnife.m5154a(this, viewInflate);
        appCompatDialog.setContentView(viewInflate);
        appCompatDialog.setCancelable(true);
        this.tipText.setText(getString(com.jibo.R.string.dialog_change_name_tip, this.f10172b.getName()));
        this.nameEdit.setText(this.f10172b.getName().replace(" Jibo", ""));
        this.nameEdit.setFilters(new InputFilter[]{new CustomFontEditText.NameInputFilter()});
        return appCompatDialog;
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f10171a.unbind();
    }

    @OnClick
    public void onCancelClicked(View view) {
        dismiss();
    }

    @OnClick
    public void onSetClicked(View view) {
        if (TextUtils.isEmpty(this.nameEdit.getText().toString().trim())) {
            Snackbar.m804a(view, getString(com.jibo.R.string.please_provide_jibo_name), 0).m490c();
            return;
        }
        if (m10492a().length() > 27) {
            Snackbar.m804a(view, getString(com.jibo.R.string.shorter_jibo_name), 0).m490c();
            return;
        }
        if (getTargetFragment() != null && (getTargetFragment() instanceof DialogUtils.DialogFragmentWrapperClickListener)) {
            ((DialogUtils.DialogFragmentWrapperClickListener) getTargetFragment()).mo10186a(getTargetRequestCode(), view.getId(), m10492a());
        }
        dismiss();
    }

    /* JADX INFO: renamed from: a */
    private String m10492a() {
        return this.nameEdit.getText().toString().trim() + " Jibo";
    }
}
