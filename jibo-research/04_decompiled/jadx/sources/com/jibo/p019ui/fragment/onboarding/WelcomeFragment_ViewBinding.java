package com.jibo.p019ui.fragment.onboarding;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class WelcomeFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private WelcomeFragment f10806b;

    /* JADX INFO: renamed from: c */
    private View f10807c;

    /* JADX INFO: renamed from: d */
    private View f10808d;

    /* JADX INFO: renamed from: e */
    private View f10809e;

    public WelcomeFragment_ViewBinding(final WelcomeFragment welcomeFragment, View view) {
        this.f10806b = welcomeFragment;
        View viewM5158a = Utils.m5158a(view, R.id.btnLogin, "field 'btnLogin' and method 'openLoginScreen'");
        welcomeFragment.btnLogin = (TextView) Utils.m5162c(viewM5158a, R.id.btnLogin, "field 'btnLogin'", TextView.class);
        this.f10807c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.WelcomeFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                welcomeFragment.openLoginScreen(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnSignUp, "field 'btnSignUp' and method 'openSignupScreen'");
        welcomeFragment.btnSignUp = (Button) Utils.m5162c(viewM5158a2, R.id.btnSignUp, "field 'btnSignUp'", Button.class);
        this.f10808d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.WelcomeFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                welcomeFragment.openSignupScreen(view2);
            }
        });
        View viewM5158a3 = Utils.m5158a(view, R.id.btnDevSettings, "method 'onDevSettings'");
        this.f10809e = viewM5158a3;
        viewM5158a3.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.jibo.ui.fragment.onboarding.WelcomeFragment_ViewBinding.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view2) {
                return welcomeFragment.onDevSettings(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        WelcomeFragment welcomeFragment = this.f10806b;
        if (welcomeFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10806b = null;
        welcomeFragment.btnLogin = null;
        welcomeFragment.btnSignUp = null;
        this.f10807c.setOnClickListener(null);
        this.f10807c = null;
        this.f10808d.setOnClickListener(null);
        this.f10808d = null;
        this.f10809e.setOnLongClickListener(null);
        this.f10809e = null;
    }
}
