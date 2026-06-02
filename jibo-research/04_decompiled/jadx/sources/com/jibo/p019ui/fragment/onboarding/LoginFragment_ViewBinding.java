package com.jibo.p019ui.fragment.onboarding;

import android.view.View;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class LoginFragment_ViewBinding extends SocialMediaBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private LoginFragment f10729b;

    /* JADX INFO: renamed from: c */
    private View f10730c;

    public LoginFragment_ViewBinding(final LoginFragment loginFragment, View view) {
        super(loginFragment, view);
        this.f10729b = loginFragment;
        loginFragment.validationMessagePassword = (TextView) Utils.m5161b(view, R.id.validation_message_password, "field 'validationMessagePassword'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnForgotPassword, "method 'onForgotPasswordClick'");
        this.f10730c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.LoginFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                loginFragment.onForgotPasswordClick(view2);
            }
        });
    }

    @Override // com.jibo.p019ui.fragment.onboarding.SocialMediaBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        LoginFragment loginFragment = this.f10729b;
        if (loginFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10729b = null;
        loginFragment.validationMessagePassword = null;
        this.f10730c.setOnClickListener(null);
        this.f10730c = null;
        super.unbind();
    }
}
