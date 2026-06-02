package com.jibo.p019ui.fragment.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import com.jibo.R;
import com.jibo.p019ui.fragment.dialog.DialogUtils;

/* JADX INFO: loaded from: classes.dex */
public class EmailChangeFailedDialog extends DialogFragment {

    /* JADX INFO: renamed from: a */
    Unbinder f10228a;

    /* JADX INFO: renamed from: b */
    private String f10229b;

    @BindView
    TextView email;

    @BindView
    TextView footer;

    @BindView
    TextView textView;

    @Override // android.support.v4.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        TextView textView = (TextView) LayoutInflater.from(getActivity()).inflate(R.layout.dialog_title, (ViewGroup) null);
        textView.setText(R.string.email_change_failed);
        View viewInflate = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_email_change_failed, (ViewGroup) null);
        AlertDialog.Builder builderM3233b = new AlertDialog.Builder(getActivity()).m3225a(textView).m3233b(viewInflate);
        this.f10228a = ButterKnife.m5154a(this, viewInflate);
        this.f10229b = bundle != null ? bundle.getString("ARGS_EMAIL") : getArguments().getString("ARGS_EMAIL");
        this.email.setText(this.f10229b);
        return builderM3233b.m3236b();
    }

    @Override // android.support.v4.app.DialogFragment, android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f10228a.unbind();
    }

    @OnClick
    public void onCancelClicked(View view) {
        dismiss();
    }

    @OnClick
    public void onTryAgainClicked(View view) {
        if (getTargetFragment() != null && (getTargetFragment() instanceof DialogUtils.DialogFragmentWrapperClickListener)) {
            ((DialogUtils.DialogFragmentWrapperClickListener) getTargetFragment()).mo10186a(getTargetRequestCode(), view.getId(), null);
        }
        dismiss();
    }
}
