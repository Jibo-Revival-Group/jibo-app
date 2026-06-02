package com.jibo.p019ui.fragment.onboarding;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.ChangeEmailRequest;
import com.jibo.aws.integration.aws.services.common.model.IdResponse;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.TabbedActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.p019ui.fragment.dialog.EmailChangeFailedDialog;

/* JADX INFO: loaded from: classes.dex */
public class ChangeEmailSentFragment extends BaseFragment implements DialogUtils.DialogFragmentWrapperClickListener {

    /* JADX INFO: renamed from: a */
    public static final String f10664a = ChangeEmailSentFragment.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private String f10665b;

    /* JADX INFO: renamed from: c */
    private boolean f10666c = false;

    /* JADX INFO: renamed from: d */
    private boolean f10667d = false;

    /* JADX INFO: renamed from: e */
    private String f10668e;

    @BindView
    TextView text_instructions;

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        this.f10665b = bundle.getString("ARGS_EMAIL");
        this.f10668e = bundle.getString("ARGS_PASSWORD");
        this.f10667d = bundle.getBoolean("ARGS_IS_ERROR", false);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_email_change_sent, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.text_instructions.setText(Html.fromHtml(String.format(getString(R.string.change_email_sent_text), this.f10665b)));
        if (this.f10667d) {
            this.f10667d = false;
            m10823a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10823a() {
        Bundle bundle = new Bundle();
        bundle.putString("ARGS_EMAIL", this.f10665b);
        EmailChangeFailedDialog emailChangeFailedDialog = new EmailChangeFailedDialog();
        emailChangeFailedDialog.setArguments(bundle);
        emailChangeFailedDialog.setTargetFragment(this, 1);
        emailChangeFailedDialog.show(getFragmentManager(), EmailChangeFailedDialog.class.getSimpleName());
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        m10350l();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.text_check_your_email);
    }

    @OnClick
    public void logout(View view) {
        getActivity().setResult(TabbedActivity.f9761c);
        getActivity().finish();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapperClickListener
    /* JADX INFO: renamed from: a */
    public void mo10186a(int i, int i2, Object obj) {
        m10339a(false);
        EntityData.m10089a(getContext()).m10110a().changeEmail(this.f10665b, this.f10668e, new AsyncHandler<ChangeEmailRequest, IdResponse>() { // from class: com.jibo.ui.fragment.onboarding.ChangeEmailSentFragment.1
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                ChangeEmailSentFragment.this.m10338a((Throwable) exc, "change email", false);
                ChangeEmailSentFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.onboarding.ChangeEmailSentFragment.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChangeEmailSentFragment.this.mo10345g();
                        ChangeEmailSentFragment.this.m10823a();
                    }
                });
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(ChangeEmailRequest changeEmailRequest, IdResponse idResponse) {
                ChangeEmailSentFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.onboarding.ChangeEmailSentFragment.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ChangeEmailSentFragment.this.mo10345g();
                    }
                });
            }
        });
    }
}
