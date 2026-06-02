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
import com.amazonaws.AmazonServiceException;
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.model.ChangeEmailRequest;
import com.jibo.aws.integration.aws.services.common.model.IdResponse;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.p019ui.fragment.onboarding.ChangeEmailSentFragment;
import com.jibo.utils.Commons;
import com.jibo.utils.ErrorHelper;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class ChangeEmailFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10921a = LogUtils.m11405a(ChangeEmailFragment.class);

    /* JADX INFO: renamed from: b */
    MenuItem f10922b;

    /* JADX INFO: renamed from: c */
    private String f10923c;

    /* JADX INFO: renamed from: d */
    private TextWatcher f10924d = new TextWatcher() { // from class: com.jibo.ui.fragment.settings.ChangeEmailFragment.2
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ChangeEmailFragment.this.getActivity().invalidateOptionsMenu();
            ChangeEmailFragment.this.m10938s();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }
    };

    @BindView
    EditText email;

    @BindView
    TextView footer;

    @BindView
    TextView footerError;

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        this.f10923c = bundle.getString("ARGS_PASSWORD");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(m10940b(), viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_done != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        m10939a();
        return true;
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.email.addTextChangedListener(this.f10924d);
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
        this.f10922b = menu.findItem(R.id.action_done);
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
        this.f10922b.setEnabled(m10936q());
    }

    /* JADX INFO: renamed from: q */
    private boolean m10936q() {
        return !TextUtils.isEmpty(this.email.getText().toString()) && Commons.f11676a.matcher(this.email.getText().toString()).matches();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_change_email);
    }

    /* JADX INFO: renamed from: a */
    public void m10939a() {
        m10339a(false);
        this.f10922b.setEnabled(false);
        EntityData.m10089a(getContext()).m10110a().changeEmail(this.email.getText().toString(), this.f10923c, new AsyncHandler<ChangeEmailRequest, IdResponse>() { // from class: com.jibo.ui.fragment.settings.ChangeEmailFragment.1
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(final Exception exc) {
                ChangeEmailFragment.this.m10338a((Throwable) exc, "change email", false);
                if (!ErrorHelper.m11385b((AmazonServiceException) exc) && !ErrorHelper.m11384a((AmazonServiceException) exc)) {
                    ChangeEmailFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.ChangeEmailFragment.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ChangeEmailFragment.this.mo10345g();
                            ChangeEmailFragment.this.f10922b.setEnabled(true);
                            if (((AmazonServiceException) exc).getErrorCode().equals("EMAIL_ALREADY_EXISTS")) {
                                ChangeEmailFragment.this.f10922b.setEnabled(false);
                                ChangeEmailFragment.this.footerError.setText(R.string.change_email_email_exists_error);
                                ChangeEmailFragment.this.m10937r();
                                return;
                            }
                            ChangeEmailFragment.this.m10941b(false);
                        }
                    });
                }
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(ChangeEmailRequest changeEmailRequest, IdResponse idResponse) {
                ChangeEmailFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.ChangeEmailFragment.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        ChangeEmailFragment.this.mo10345g();
                        ChangeEmailFragment.this.f10922b.setEnabled(true);
                        ChangeEmailFragment.this.m10941b(true);
                    }
                });
            }
        });
    }

    /* JADX INFO: renamed from: b */
    protected void m10941b(boolean z) {
        SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(this, ChangeEmailSentFragment.class.getName());
        builder.m10273a("ARGS_EMAIL", this.email.getText().toString());
        builder.m10273a("ARGS_PASSWORD", this.f10923c);
        builder.m10274a("ARGS_IS_ERROR", !z);
        builder.m10275a(999);
    }

    /* JADX INFO: renamed from: b */
    protected int m10940b() {
        return R.layout.fragment_change_email_enter_email;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: r */
    public void m10937r() {
        this.footer.setVisibility(8);
        this.footerError.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s */
    public void m10938s() {
        this.footer.setVisibility(0);
        this.footerError.setVisibility(8);
    }
}
