package com.jibo.p019ui.fragment.onboarding;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import butterknife.BindView;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.JiboAnalytics;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.AccountRequest;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.utils.Commons;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.UIUtils;

/* JADX INFO: loaded from: classes.dex */
public abstract class SocialMediaBaseFragment extends BaseFragment {

    /* JADX INFO: renamed from: b */
    protected MenuItem f10796b;

    @BindView
    EditText emailEditText;

    @BindView
    EditText passwordEditText;

    /* JADX INFO: renamed from: a */
    private TextWatcher f10795a = new TextWatcher() { // from class: com.jibo.ui.fragment.onboarding.SocialMediaBaseFragment.1
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            SocialMediaBaseFragment.this.mo10836b();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }
    };

    /* JADX INFO: renamed from: c */
    AsyncHandler f10797c = new AsyncHandler<AccountRequest, Account>() { // from class: com.jibo.ui.fragment.onboarding.SocialMediaBaseFragment.2
        @Override // com.amazonaws.handlers.AsyncHandler
        public void onError(final Exception exc) {
            SocialMediaBaseFragment.this.m10338a((Throwable) exc, "login", false);
            if (!ErrorHelper.m11384a((AmazonServiceException) exc)) {
                SocialMediaBaseFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.onboarding.SocialMediaBaseFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SocialMediaBaseFragment.this.mo10835a(exc);
                        SocialMediaBaseFragment.this.f10796b.setEnabled(true);
                    }
                });
            }
        }

        @Override // com.amazonaws.handlers.AsyncHandler
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(AccountRequest accountRequest, final Account account) throws Throwable {
            if (SocialMediaBaseFragment.this.m10342d()) {
                EntityData.m10089a(SocialMediaBaseFragment.this.getActivity()).m10115a(account, true, null);
                JiboAnalytics.m9835a(SocialMediaBaseFragment.this.getActivity(), account);
                JiboAnalytics.m9837a(SocialMediaBaseFragment.this.getActivity(), account.getEmail());
                if (account.isActive().booleanValue()) {
                    SocialMediaBaseFragment.this.m10348j();
                } else {
                    SocialMediaBaseFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.onboarding.SocialMediaBaseFragment.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            SocialMediaBaseFragment.this.mo10345g();
                            ((OnBoardingActivity) SocialMediaBaseFragment.this.getActivity()).m10240b(account.getEmail(), (String) null);
                        }
                    });
                }
            }
        }
    };

    /* JADX INFO: renamed from: a */
    protected abstract void mo10834a();

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        setHasOptionsMenu(true);
        this.emailEditText.addTextChangedListener(this.f10795a);
        this.passwordEditText.addTextChangedListener(this.f10795a);
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
        this.f10796b = menu.findItem(R.id.action_done);
        ImageUtils.m11393a(getActivity(), menu);
        mo10836b();
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_done != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        mo10834a();
        return true;
    }

    /* JADX INFO: renamed from: a */
    protected void mo10835a(Exception exc) {
        UIUtils.m11476a(getView(), exc);
    }

    /* JADX INFO: renamed from: b */
    protected void mo10836b() {
        boolean zIsEmpty = this.emailEditText.getText().toString().trim().isEmpty();
        boolean zMatches = Commons.f11676a.matcher(this.emailEditText.getText().toString().trim()).matches();
        boolean z = !TextUtils.isEmpty(this.passwordEditText.getText().toString()) && Commons.f11677b.matcher(this.passwordEditText.getText().toString()).matches();
        if (this.f10796b != null) {
            this.f10796b.setEnabled(!zIsEmpty && zMatches && z);
        }
    }
}
