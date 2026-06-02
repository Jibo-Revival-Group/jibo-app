package com.jibo.p019ui.fragment.onboarding;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.jibo.JiboApplication;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.PasswordResetByCodeRequest;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.utils.Commons;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.ImageUtils;

/* JADX INFO: loaded from: classes.dex */
public class ResetPasswordNewPasswordFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10741a = ResetPasswordNewPasswordFragment.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private String f10742b;

    /* JADX INFO: renamed from: c */
    private MenuItem f10743c;

    @BindView
    TextView footer;

    @BindView
    EditText passwordEdit;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_reset_password_newpassword, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f10742b = (getArguments() == null || TextUtils.isEmpty(getArguments().getString("code"))) ? "" : getArguments().getString("code");
        setHasOptionsMenu(true);
        this.passwordEdit.addTextChangedListener(new TextWatcher() { // from class: com.jibo.ui.fragment.onboarding.ResetPasswordNewPasswordFragment.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                ResetPasswordNewPasswordFragment.this.getActivity().invalidateOptionsMenu();
                ResetPasswordNewPasswordFragment.this.m10846b(ResetPasswordNewPasswordFragment.this.m10847b());
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        m10846b(true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        mo10345g();
        getActivity().invalidateOptionsMenu();
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_action_save, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f10743c = menu.findItem(R.id.action_save);
        ImageUtils.m11393a(getActivity(), menu);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_save != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        m10841a();
        return true;
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        m10350l();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.x_white);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_new_password);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f10743c.setEnabled(!TextUtils.isEmpty(this.passwordEdit.getText().toString()) && Commons.f11677b.matcher(this.passwordEdit.getText().toString()).matches());
    }

    /* JADX INFO: renamed from: a */
    private void m10841a() {
        try {
            this.f10743c.setEnabled(false);
            m10343e();
            String string = this.passwordEdit.getText().toString();
            m10344f();
            ((JiboApplication) getActivity().getApplication()).mo9832b();
            EntityData.m10089a(getActivity()).m10110a().passwordResetByCode(this.f10742b, string, new AsyncHandler<PasswordResetByCodeRequest, Account>() { // from class: com.jibo.ui.fragment.onboarding.ResetPasswordNewPasswordFragment.2
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    ResetPasswordNewPasswordFragment.this.m10338a((Throwable) exc, "password reset by code", true);
                    if (!ErrorHelper.m11385b((AmazonServiceException) exc) && !ErrorHelper.m11384a((AmazonServiceException) exc)) {
                        ResetPasswordNewPasswordFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.onboarding.ResetPasswordNewPasswordFragment.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ResetPasswordNewPasswordFragment.this.f10743c.setEnabled(true);
                            }
                        });
                    }
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(PasswordResetByCodeRequest passwordResetByCodeRequest, Account account) throws Throwable {
                    if (ResetPasswordNewPasswordFragment.this.m10342d()) {
                        EntityData.m10089a(ResetPasswordNewPasswordFragment.this.getActivity()).m10115a(account, true, null);
                    }
                    ResetPasswordNewPasswordFragment.this.m10348j();
                }
            });
        } catch (Exception e) {
            mo10345g();
            this.f10743c.setEnabled(true);
            Crashlytics.m5597a((Throwable) e);
            ((OnBoardingActivity) getActivity()).m10202l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m10846b(boolean z) {
        String string = getString(R.string.change_password_footer1);
        String str = string + "\n\n" + getString(R.string.change_password_footer2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (!z) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.firecracker)), string.length(), str.length(), 33);
        }
        this.footer.setText(spannableStringBuilder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public boolean m10847b() {
        return !TextUtils.isEmpty(this.passwordEdit.getText().toString()) && Commons.f11677b.matcher(this.passwordEdit.getText().toString()).matches();
    }
}
