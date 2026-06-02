package com.jibo.p019ui.fragment.settings;

import com.jibo.R;
import com.jibo.p019ui.activity.SingleFragmentActivity;
import com.jibo.utils.LogUtils;

/* JADX INFO: loaded from: classes.dex */
public class ChangeEmailConfirmPasswordFragment extends ConfirmPasswordFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10920a = LogUtils.m11405a(ChangeEmailConfirmPasswordFragment.class);

    @Override // com.jibo.p019ui.fragment.settings.ConfirmPasswordFragment
    /* JADX INFO: renamed from: a */
    protected void mo10931a() {
        SingleFragmentActivity.Builder builder = new SingleFragmentActivity.Builder(this, ChangeEmailFragment.class.getName());
        builder.m10273a("ARGS_PASSWORD", this.password.getText().toString());
        builder.m10275a(999);
    }

    @Override // com.jibo.p019ui.fragment.settings.ConfirmPasswordFragment
    /* JADX INFO: renamed from: b */
    protected int mo10932b() {
        return R.layout.fragment_change_email_confirm_password;
    }

    @Override // com.jibo.p019ui.fragment.settings.ConfirmPasswordFragment, com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_change_email);
    }
}
