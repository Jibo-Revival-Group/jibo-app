package com.jibo.p019ui.fragment.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.crashlytics.android.Crashlytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.ChangePasswordRequest;
import com.jibo.aws.integration.aws.services.account.model.SendPasswordResetRequest;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.BaseActivity;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.onboarding.ResetPasswordSentFragment;
import com.jibo.utils.Commons;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class ConfirmPasswordFragment extends BaseFragment {

    /* JADX INFO: renamed from: b */
    public static final String f10940b = LogUtils.m11405a(ConfirmPasswordFragment.class);

    /* JADX INFO: renamed from: a */
    private JiboAccountAsyncClient f10941a;

    /* JADX INFO: renamed from: c */
    MenuItem f10942c;

    /* JADX INFO: renamed from: d */
    private TextWatcher f10943d = new TextWatcher() { // from class: com.jibo.ui.fragment.settings.ConfirmPasswordFragment.3
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ConfirmPasswordFragment.this.getActivity().invalidateOptionsMenu();
            ConfirmPasswordFragment.this.m10956t();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }
    };

    @BindView
    TextView footer;

    @BindView
    TextView footerError;

    @BindView
    EditText password;

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(mo10932b(), viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_done != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        m10957q();
        return true;
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.password.addTextChangedListener(this.f10943d);
        this.f10941a = EntityData.m10089a(getContext()).m10110a();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 999) {
            getActivity().setResult(i2);
            getActivity().finish();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_action_next, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f10942c = menu.findItem(R.id.action_done);
        ImageUtils.m11393a(getActivity(), menu);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowCustomEnabled(false);
        m10352n();
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f10942c.setEnabled(m10954r());
    }

    @OnClick
    public void onForgotPasswordClick(View view) {
        try {
            m10344f();
            final String email = EntityData.m10089a(getActivity()).m10134i().getEmail();
            EntityData.m10089a(getActivity()).m10110a().sendPasswordReset(email, new AsyncHandler<SendPasswordResetRequest, Account>() { // from class: com.jibo.ui.fragment.settings.ConfirmPasswordFragment.1
                @Override // com.amazonaws.handlers.AsyncHandler
                public void onError(Exception exc) {
                    ConfirmPasswordFragment.this.m10338a((Throwable) exc, "send password reset", true);
                }

                @Override // com.amazonaws.handlers.AsyncHandler
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onSuccess(SendPasswordResetRequest sendPasswordResetRequest, Account account) {
                    ConfirmPasswordFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.ConfirmPasswordFragment.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ConfirmPasswordFragment.this.mo10345g();
                            Bundle bundle = new Bundle();
                            bundle.putString("email", email);
                            ((BaseActivity) ConfirmPasswordFragment.this.getActivity()).m10187a(ResetPasswordSentFragment.class, bundle);
                        }
                    });
                }
            });
        } catch (Exception e) {
            mo10345g();
            Crashlytics.m5597a((Throwable) e);
        }
    }

    /* JADX INFO: renamed from: r */
    private boolean m10954r() {
        return !TextUtils.isEmpty(this.password.getText().toString()) && Commons.f11677b.matcher(this.password.getText().toString()).matches();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_current_password);
    }

    /* JADX INFO: renamed from: q */
    public void m10957q() {
        m10339a(false);
        this.f10942c.setEnabled(false);
        this.f10941a.changePassword(this.password.getText().toString(), this.password.getText().toString(), new AsyncHandler<ChangePasswordRequest, Account>() { // from class: com.jibo.ui.fragment.settings.ConfirmPasswordFragment.2
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                ConfirmPasswordFragment.this.m10338a((Throwable) exc, "change password", false);
                if (!ErrorHelper.m11385b((AmazonServiceException) exc) && !ErrorHelper.m11384a((AmazonServiceException) exc)) {
                    ConfirmPasswordFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.ConfirmPasswordFragment.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ConfirmPasswordFragment.this.m10955s();
                            ConfirmPasswordFragment.this.mo10345g();
                        }
                    });
                }
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(ChangePasswordRequest changePasswordRequest, Account account) {
                ConfirmPasswordFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.ConfirmPasswordFragment.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ConfirmPasswordFragment.this.mo10345g();
                        ConfirmPasswordFragment.this.f10942c.setEnabled(true);
                        ConfirmPasswordFragment.this.mo10931a();
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: a */
    protected void mo10931a() {
        SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(this, ChangePasswordFragment.class.getName());
        builder.m10273a("ARGS_OLD_PASSWORD", this.password.getText().toString());
        builder.m10275a(999);
    }

    /* JADX INFO: renamed from: b */
    protected int mo10932b() {
        return R.layout.fragment_confirm_password;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s */
    public void m10955s() {
        this.footer.setVisibility(8);
        this.footerError.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: t */
    public void m10956t() {
        this.footer.setVisibility(0);
        this.footerError.setVisibility(8);
    }
}
