package com.jibo.p019ui.fragment.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.handlers.AsyncHandler;
import com.amazonaws.services.cognitoidentity.model.InvalidParameterException;
import com.crashlytics.android.Crashlytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.SendPasswordResetRequest;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes.dex */
public class ResetPasswordSentFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10748a = ResetPasswordSentFragment.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private String f10749b;

    /* JADX INFO: renamed from: c */
    private String f10750c;

    /* JADX INFO: renamed from: d */
    private boolean f10751d = false;

    @BindView
    TextView text_instructions;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_reset_password_sent, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f10749b = (getArguments() == null || TextUtils.isEmpty(getArguments().getString("email"))) ? "" : getArguments().getString("email");
        this.f10750c = (getArguments() == null || TextUtils.isEmpty(getArguments().getString("code"))) ? "" : getArguments().getString("code");
        this.text_instructions.setText(Html.fromHtml(String.format(getString(R.string.text_some_text_after_password_reset), this.f10749b)));
        if (!TextUtils.isEmpty(this.f10749b) && !TextUtils.isEmpty(this.f10750c) && !this.f10751d) {
            this.f10751d = true;
            getArguments().clear();
            getArguments().putString("email", this.f10749b);
            ((OnBoardingActivity) getActivity()).m10241c(this.f10750c);
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
    public void onResendPasswordResetEmailClick(View view) {
        try {
            if (TextUtils.isEmpty(this.f10749b)) {
                throw new InvalidParameterException(getString(R.string.error_invalid_email));
            }
            m10344f();
            EntityData.m10089a(getActivity()).m10110a().sendPasswordReset(this.f10749b, new AsyncHandler<SendPasswordResetRequest, Account>() { // from class: com.jibo.ui.fragment.onboarding.ResetPasswordSentFragment.1
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    ResetPasswordSentFragment.this.m10338a((Throwable) exc, "send password reset", true);
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(SendPasswordResetRequest sendPasswordResetRequest, Account account) {
                    ResetPasswordSentFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.onboarding.ResetPasswordSentFragment.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ResetPasswordSentFragment.this.mo10345g();
                        }
                    });
                }
            });
        } catch (InvalidParameterException e) {
        } catch (Exception e2) {
            mo10345g();
            Crashlytics.m5597a((Throwable) e2);
        }
    }

    @OnClick
    public void onOpenEmailAppClick(View view) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.APP_EMAIL");
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        getActivity().startActivity(intent);
    }
}
