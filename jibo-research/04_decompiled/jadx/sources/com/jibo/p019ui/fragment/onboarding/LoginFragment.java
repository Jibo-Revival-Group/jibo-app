package com.jibo.p019ui.fragment.onboarding;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.crashlytics.android.Crashlytics;
import com.jibo.JiboApplication;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.exception.ResourceNotFoundException;
import com.jibo.aws.integration.aws.services.exception.UnauthorizedRequestException;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.fragment.dialog.DialogUtils;
import com.jibo.utils.Commons;

/* JADX INFO: loaded from: classes.dex */
public class LoginFragment extends SocialMediaBaseFragment implements DialogUtils.DialogFragmentWrapperClickListener {

    /* JADX INFO: renamed from: a */
    public static final String f10728a = LoginFragment.class.getSimpleName();

    @BindView
    TextView validationMessagePassword;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_login, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.onboarding.SocialMediaBaseFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle == null && getArguments() != null && !TextUtils.isEmpty(getArguments().getString("email"))) {
            this.emailEditText.setText(getArguments().getString("email"));
        }
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
        return getString(R.string.title_login);
    }

    @OnClick
    public void onForgotPasswordClick(View view) {
        ((OnBoardingActivity) getActivity()).m10239b(this.emailEditText.getText().toString());
    }

    @Override // com.jibo.p019ui.fragment.onboarding.SocialMediaBaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10834a() {
        try {
            this.f10796b.setEnabled(false);
            m10343e();
            String string = this.emailEditText.getText().toString();
            String string2 = this.passwordEditText.getText().toString();
            m10344f();
            ((JiboApplication) getActivity().getApplication()).mo9832b();
            EntityData.m10089a(getActivity()).m10110a().login(string, string2, this.f10797c);
        } catch (Exception e) {
            mo10345g();
            this.f10796b.setEnabled(true);
            ((OnBoardingActivity) getActivity()).m10202l();
            Crashlytics.m5597a((Throwable) e);
        }
    }

    @Override // com.jibo.p019ui.fragment.onboarding.SocialMediaBaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10835a(Exception exc) {
        if (exc instanceof UnauthorizedRequestException) {
            this.validationMessagePassword.setVisibility(0);
        } else if (exc instanceof ResourceNotFoundException) {
            DialogUtils.m10518a(this, getFragmentManager(), 103, getString(R.string.account_not_found_title), getString(R.string.account_not_found_text), getString(R.string.account_not_found_new_account), getString(R.string.account_not_found_edit));
        } else {
            super.mo10835a(exc);
        }
    }

    @Override // com.jibo.p019ui.fragment.onboarding.SocialMediaBaseFragment
    /* JADX INFO: renamed from: b */
    protected void mo10836b() {
        this.validationMessagePassword.setVisibility(8);
        boolean z = (this.emailEditText.getText().toString().trim().isEmpty() || !Commons.f11676a.matcher(this.emailEditText.getText().toString().trim()).matches() || this.passwordEditText.getText().toString().trim().isEmpty()) ? false : true;
        if (this.f10796b != null) {
            this.f10796b.setEnabled(z);
        }
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, com.jibo.ui.fragment.dialog.DialogUtils.DialogFragmentWrapperClickListener
    /* JADX INFO: renamed from: a */
    public void mo10186a(int i, int i2, Object obj) {
        super.mo10186a(i, i2, obj);
        if (i2 == -1) {
            ((OnBoardingActivity) getActivity()).m10236a(this.emailEditText.getText().toString(), (String) null);
        }
    }
}
