package com.jibo.p019ui.fragment.onboarding;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class ResetPasswordSentFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private ResetPasswordSentFragment f10754b;

    /* JADX INFO: renamed from: c */
    private View f10755c;

    /* JADX INFO: renamed from: d */
    private View f10756d;

    public ResetPasswordSentFragment_ViewBinding(final ResetPasswordSentFragment resetPasswordSentFragment, View view) {
        this.f10754b = resetPasswordSentFragment;
        resetPasswordSentFragment.text_instructions = (TextView) Utils.m5161b(view, R.id.text_instructions, "field 'text_instructions'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnResendPasswordResetEmail, "method 'onResendPasswordResetEmailClick'");
        this.f10755c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.ResetPasswordSentFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                resetPasswordSentFragment.onResendPasswordResetEmailClick(view2);
            }
        });
        View viewM5158a2 = Utils.m5158a(view, R.id.btnOpenEmailApp, "method 'onOpenEmailAppClick'");
        this.f10756d = viewM5158a2;
        viewM5158a2.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.ResetPasswordSentFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                resetPasswordSentFragment.onOpenEmailAppClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ResetPasswordSentFragment resetPasswordSentFragment = this.f10754b;
        if (resetPasswordSentFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10754b = null;
        resetPasswordSentFragment.text_instructions = null;
        this.f10755c.setOnClickListener(null);
        this.f10755c = null;
        this.f10756d.setOnClickListener(null);
        this.f10756d = null;
    }
}
