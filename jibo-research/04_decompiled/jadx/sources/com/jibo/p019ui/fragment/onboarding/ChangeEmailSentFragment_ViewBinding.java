package com.jibo.p019ui.fragment.onboarding;

import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class ChangeEmailSentFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private ChangeEmailSentFragment f10672b;

    /* JADX INFO: renamed from: c */
    private View f10673c;

    public ChangeEmailSentFragment_ViewBinding(final ChangeEmailSentFragment changeEmailSentFragment, View view) {
        this.f10672b = changeEmailSentFragment;
        changeEmailSentFragment.text_instructions = (TextView) Utils.m5161b(view, R.id.text_instructions, "field 'text_instructions'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.btnLogout, "method 'logout'");
        this.f10673c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.ChangeEmailSentFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                changeEmailSentFragment.logout(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ChangeEmailSentFragment changeEmailSentFragment = this.f10672b;
        if (changeEmailSentFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10672b = null;
        changeEmailSentFragment.text_instructions = null;
        this.f10673c.setOnClickListener(null);
        this.f10673c = null;
    }
}
