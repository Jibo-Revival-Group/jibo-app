package com.jibo.p019ui.fragment.onboarding;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import butterknife.BindView;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.SendPasswordResetRequest;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.utils.Commons;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.ImageUtils;

/* JADX INFO: loaded from: classes.dex */
public class ResetPasswordFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10733a = ResetPasswordFragment.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private MenuItem f10734b;

    @BindView
    EditText emailEditText;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_reset_password, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setHasOptionsMenu(true);
        this.emailEditText.setText(getArguments().getString("email", ""));
        this.emailEditText.addTextChangedListener(new TextWatcher() { // from class: com.jibo.ui.fragment.onboarding.ResetPasswordFragment.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ResetPasswordFragment.this.getActivity().invalidateOptionsMenu();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        mo10345g();
        getActivity().invalidateOptionsMenu();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_action_next, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f10734b = menu.findItem(R.id.action_done);
        ImageUtils.m11393a(getActivity(), menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_done != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        m10839a();
        return true;
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f10734b.setEnabled(!this.emailEditText.getText().toString().trim().isEmpty() && Commons.f11676a.matcher(this.emailEditText.getText().toString().trim()).matches());
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
        return getString(R.string.title_reset_password);
    }

    /* JADX INFO: renamed from: a */
    public void m10839a() {
        try {
            this.f10734b.setEnabled(false);
            m10343e();
            String string = this.emailEditText.getText().toString();
            m10344f();
            EntityData.m10089a(getActivity()).m10110a().sendPasswordReset(string, new AsyncHandler<SendPasswordResetRequest, Account>() { // from class: com.jibo.ui.fragment.onboarding.ResetPasswordFragment.2
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    ResetPasswordFragment.this.m10338a((Throwable) exc, "send password reset", true);
                    if (!ErrorHelper.m11385b((AmazonServiceException) exc) && !ErrorHelper.m11384a((AmazonServiceException) exc)) {
                        ResetPasswordFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.onboarding.ResetPasswordFragment.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ResetPasswordFragment.this.f10734b.setEnabled(true);
                            }
                        });
                    }
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(SendPasswordResetRequest sendPasswordResetRequest, final Account account) {
                    ResetPasswordFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.onboarding.ResetPasswordFragment.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ResetPasswordFragment.this.f10734b.setEnabled(true);
                            ResetPasswordFragment.this.mo10345g();
                            ((OnBoardingActivity) ResetPasswordFragment.this.getActivity()).m10242c(account.getEmail(), "");
                        }
                    });
                }
            });
        } catch (Exception e) {
            mo10345g();
            this.f10734b.setEnabled(true);
            mo10345g();
            Crashlytics.m5597a((Throwable) e);
        }
    }
}
