package com.jibo.p019ui.fragment.onboarding;

import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class SignupLoginFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private SignupLoginFragment f10782b;

    /* JADX INFO: renamed from: c */
    private View f10783c;

    /* JADX INFO: renamed from: d */
    private View f10784d;

    /* JADX INFO: renamed from: e */
    private View f10785e;

    /* JADX INFO: renamed from: f */
    private View f10786f;

    public SignupLoginFragment_ViewBinding(final SignupLoginFragment signupLoginFragment, View view) {
        this.f10782b = signupLoginFragment;
        View viewM5158a = Utils.m5158a(view, R.id.btnLogin, "field 'btnLogin' and method 'openLoginScreen'");
        signupLoginFragment.btnLogin = (Button) Utils.m5162c(viewM5158a, R.id.btnLogin, "field 'btnLogin'", Button.class);
        this.f10783c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.SignupLoginFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                signupLoginFragment.openLoginScreen(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnSignUp, "field 'btnSignUp' and method 'openSignupScreen'");
        signupLoginFragment.btnSignUp = (Button) Utils.m5162c(viewM5158a2, R.id.btnSignUp, "field 'btnSignUp'", Button.class);
        this.f10784d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.SignupLoginFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                signupLoginFragment.openSignupScreen(view2);
            }
        });
        View viewM5158a3 = Utils.m5158a(view, R.id.btnLearnMore, "field 'btnLearnMore' and method 'openLearnMoreLink'");
        signupLoginFragment.btnLearnMore = viewM5158a3;
        this.f10785e = viewM5158a3;
        viewM5158a3.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.SignupLoginFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                signupLoginFragment.openLearnMoreLink(view2);
            }
        });
        View viewM5158a4 = Utils.m5158a(view, R.id.btnDevSettings, "method 'onDevSettings'");
        this.f10786f = viewM5158a4;
        viewM5158a4.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.jibo.ui.fragment.onboarding.SignupLoginFragment_ViewBinding.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return signupLoginFragment.onDevSettings(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignupLoginFragment signupLoginFragment = this.f10782b;
        if (signupLoginFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10782b = null;
        signupLoginFragment.btnLogin = null;
        signupLoginFragment.btnSignUp = null;
        signupLoginFragment.btnLearnMore = null;
        this.f10783c.setOnClickListener(null);
        this.f10783c = null;
        this.f10784d.setOnClickListener(null);
        this.f10784d = null;
        this.f10785e.setOnClickListener(null);
        this.f10785e = null;
        this.f10786f.setOnLongClickListener(null);
        this.f10786f = null;
    }
}
