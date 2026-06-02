package com.jibo.p019ui.fragment.settings;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Editable;
import android.text.SpannableStringBuilder;
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
import com.amazonaws.handlers.AsyncHandler;
import com.jibo.R;
import com.jibo.aws.integration.aws.services.account.JiboAccountAsyncClient;
import com.jibo.aws.integration.aws.services.account.model.Account;
import com.jibo.aws.integration.aws.services.account.model.ChangePasswordRequest;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.fragment.BaseFragment;
import com.jibo.utils.Commons;
import com.jibo.utils.ImageUtils;
import com.jibo.utils.LogUtils;
import com.jibo.utils.UIUtils;

/* JADX INFO: loaded from: classes.dex */
public class ChangePasswordFragment extends BaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10931a = LogUtils.m11405a(ChangePasswordFragment.class);

    /* JADX INFO: renamed from: b */
    MenuItem f10932b;

    /* JADX INFO: renamed from: c */
    private JiboAccountAsyncClient f10933c;

    /* JADX INFO: renamed from: d */
    private String f10934d;

    /* JADX INFO: renamed from: e */
    private TextWatcher f10935e = new TextWatcher() { // from class: com.jibo.ui.fragment.settings.ChangePasswordFragment.1
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            ChangePasswordFragment.this.getActivity().invalidateOptionsMenu();
            ChangePasswordFragment.this.m10946b(ChangePasswordFragment.this.m10947b());
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }
    };

    @BindView
    TextView footer;

    @BindView
    EditText password;

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: b */
    public void mo10340b(Bundle bundle) {
        super.mo10340b(bundle);
        this.f10934d = bundle.getString("ARGS_OLD_PASSWORD");
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_change_password, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (R.id.action_save != menuItem.getItemId()) {
            return super.onOptionsItemSelected(menuItem);
        }
        m10948a();
        return true;
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.password.addTextChangedListener(this.f10935e);
        this.f10933c = EntityData.m10089a(getContext()).m10110a();
        m10946b(true);
    }

    @Override // android.support.v4.app.Fragment
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(R.menu.menu_action_save, menu);
        super.onCreateOptionsMenu(menu, menuInflater);
        this.f10932b = menu.findItem(R.id.action_save);
        ImageUtils.m11393a(getActivity(), menu);
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setDisplayShowCustomEnabled(false);
        actionBar.setHomeAsUpIndicator(R.drawable.x_white);
        m10352n();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_change_password);
    }

    @Override // android.support.v4.app.Fragment
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        this.f10932b.setEnabled(m10947b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public boolean m10947b() {
        return !TextUtils.isEmpty(this.password.getText().toString()) && Commons.f11677b.matcher(this.password.getText().toString()).matches();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m10946b(boolean z) {
        String string = getString(R.string.change_password_footer1);
        UIUtils.m11477a(this.password.getText().toString(), this.footer);
        this.footer.setText(new SpannableStringBuilder(string).append((CharSequence) "\n\n").append(this.footer.getText()));
    }

    /* JADX INFO: renamed from: a */
    public void m10948a() {
        m10339a(false);
        this.f10932b.setEnabled(false);
        this.f10933c.changePassword(this.f10934d, this.password.getText().toString(), new AsyncHandler<ChangePasswordRequest, Account>() { // from class: com.jibo.ui.fragment.settings.ChangePasswordFragment.2
            @Override // com.amazonaws.handlers.AsyncHandler
            public void onError(Exception exc) {
                ChangePasswordFragment.this.m10338a((Throwable) exc, "change password", false);
            }

            @Override // com.amazonaws.handlers.AsyncHandler
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onSuccess(ChangePasswordRequest changePasswordRequest, Account account) {
                ChangePasswordFragment.this.m10337a(new Runnable() { // from class: com.jibo.ui.fragment.settings.ChangePasswordFragment.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ChangePasswordFragment.this.mo10345g();
                        ChangePasswordFragment.this.f10932b.setEnabled(true);
                        ChangePasswordFragment.this.getActivity().finish();
                    }
                });
            }
        });
    }
}
