package com.jibo.p019ui.fragment.onboarding;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class SignupCompleteFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private SignupCompleteFragment f10766b;

    /* JADX INFO: renamed from: c */
    private View f10767c;

    /* JADX INFO: renamed from: d */
    private View f10768d;

    public SignupCompleteFragment_ViewBinding(final SignupCompleteFragment signupCompleteFragment, View view) {
        this.f10766b = signupCompleteFragment;
        View viewM5158a = Utils.m5158a(view, R.id.btnOpenEmailApp, "field 'btnOpenEmailApp' and method 'onOpenEmailAppClick'");
        signupCompleteFragment.btnOpenEmailApp = (Button) Utils.m5162c(viewM5158a, R.id.btnOpenEmailApp, "field 'btnOpenEmailApp'", Button.class);
        this.f10767c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.SignupCompleteFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                signupCompleteFragment.onOpenEmailAppClick(view2);
            }
        });
        signupCompleteFragment.text_instructions = (TextView) Utils.m5161b(view, R.id.text_instructions, "field 'text_instructions'", TextView.class);
        View viewM5158a2 = Utils.m5158a(view, R.id.btnResendVerificationEmail, "method 'onResendVerificationEmailClick'");
        this.f10768d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.SignupCompleteFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                signupCompleteFragment.onResendVerificationEmailClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SignupCompleteFragment signupCompleteFragment = this.f10766b;
        if (signupCompleteFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10766b = null;
        signupCompleteFragment.btnOpenEmailApp = null;
        signupCompleteFragment.text_instructions = null;
        this.f10767c.setOnClickListener(null);
        this.f10767c = null;
        this.f10768d.setOnClickListener(null);
        this.f10768d = null;
    }
}
