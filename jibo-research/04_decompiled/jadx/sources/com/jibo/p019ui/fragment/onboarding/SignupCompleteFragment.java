package com.jibo.p019ui.fragment.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.cognitoidentity.model.InvalidParameterException;
import com.crashlytics.android.Crashlytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.ActivateByCodeRequest;
import com.jibo.aws.integration.aws.services.account.model.EmailRequest;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.dialog.CircleProgressFragment;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.UIUtils;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class SignupCompleteFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10761a = SignupCompleteFragment.class.getSimpleName();

    @BindView
    Button btnOpenEmailApp;

    @BindView
    TextView text_instructions;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_signup_complete, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.text_instructions.setText(Html.fromHtml(String.format(getString(R.string.text_some_text_after_registration), (getArguments() == null || TextUtils.isEmpty(getArguments().getString("email"))) ? "" : getArguments().getString("email"))));
        if (!TextUtils.isEmpty(getArguments().getString("code", null))) {
            m10852a();
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
        return getString(R.string.text_check_your_email);
    }

    @OnClick
    public void onResendVerificationEmailClick(View view) {
        try {
            ((OnBoardingActivity) getActivity()).m10201k();
            Account accountM10134i = EntityData.m10089a(getActivity()).m10134i();
            JiboAccountAsyncClient jiboAccountAsyncClientM10110a = EntityData.m10089a(getActivity()).m10110a();
            if (accountM10134i != null && !TextUtils.isEmpty(accountM10134i.getEmail())) {
                jiboAccountAsyncClientM10110a.resendActivationCode(accountM10134i.getEmail(), new AsyncHandler<EmailRequest, Account>() { // from class: com.jibo.ui.fragment.onboarding.SignupCompleteFragment.1
                    @Override // com.amazonaws.handlers.AsyncHandler
                    public void onError(Exception exc) {
                        SignupCompleteFragment.this.m10338a((Throwable) exc, "resend activation code", true);
                    }

                    @Override // com.amazonaws.handlers.AsyncHandler
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public void onSuccess(EmailRequest emailRequest, Account account) {
                        SignupCompleteFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.onboarding.SignupCompleteFragment.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SignupCompleteFragment.this.mo10345g();
                            }
                        });
                    }
                });
            }
        } catch (Exception e) {
            ((OnBoardingActivity) getActivity()).m10202l();
            Crashlytics.m5597a((Throwable) e);
        }
    }

    @OnClick
    public void onOpenEmailAppClick(View view) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.APP_EMAIL");
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            getActivity().startActivity(intent);
        } else {
            UIUtils.m11475a(this.btnOpenEmailApp, getString(R.string.no_app_message));
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10852a() {
        try {
            m10343e();
            this.f9933j = new CircleProgressFragment();
            this.f9933j.m10504a(new CircleProgressFragment.OnDismissListener() { // from class: com.jibo.ui.fragment.onboarding.SignupCompleteFragment.2
                @Override // com.jibo.ui.fragment.dialog.CircleProgressFragment.OnDismissListener
                /* JADX INFO: renamed from: a */
                public void mo10227a(CircleProgressFragment.Status status) {
                    if (status == CircleProgressFragment.Status.Success) {
                        SignupCompleteFragment.this.m10348j();
                    }
                }
            });
            this.f9933j.show(getActivity().getSupportFragmentManager(), "CircleFragment");
            EntityData.m10089a(getActivity()).m10110a().activateByCode(getArguments().getString("code", ""), new AsyncHandler<ActivateByCodeRequest, Account>() { // from class: com.jibo.ui.fragment.onboarding.SignupCompleteFragment.3
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    SignupCompleteFragment.this.m10338a((Throwable) exc, "activate by code", false);
                    if (!ErrorHelper.m11385b((AmazonServiceException) exc) && !ErrorHelper.m11384a((AmazonServiceException) exc)) {
                        SignupCompleteFragment.this.f9933j.m10507b(((AmazonServiceException) exc).getErrorMessage());
                    }
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(ActivateByCodeRequest activateByCodeRequest, Account account) throws Throwable {
                    if (SignupCompleteFragment.this.m10342d()) {
                        EntityData.m10089a(SignupCompleteFragment.this.getActivity()).m10115a(account, true, null);
                    }
                    SignupCompleteFragment.this.f9933j.m10505a(SignupCompleteFragment.this.getString(R.string.account_activation_success));
                }
            });
        } catch (InvalidParameterException e) {
        } catch (Exception e2) {
            ((OnBoardingActivity) getActivity()).m10202l();
            Crashlytics.m5597a((Throwable) e2);
        }
    }
}
