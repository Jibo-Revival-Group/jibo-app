package com.jibo.p019ui.fragment.settings;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class ConfirmPasswordFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private ConfirmPasswordFragment f10951b;

    /* JADX INFO: renamed from: c */
    private View f10952c;

    public ConfirmPasswordFragment_ViewBinding(final ConfirmPasswordFragment confirmPasswordFragment, View view) {
        this.f10951b = confirmPasswordFragment;
        confirmPasswordFragment.password = (EditText) Utils.m5161b(view, R.id.password, "field 'password'", EditText.class);
        confirmPasswordFragment.footer = (TextView) Utils.m5161b(view, R.id.footer1, "field 'footer'", TextView.class);
        confirmPasswordFragment.footerError = (TextView) Utils.m5161b(view, R.id.footer_error, "field 'footerError'", TextView.class);
        View viewM5158a = Utils.m5158a(view, R.id.reset_password, "method 'onForgotPasswordClick'");
        this.f10952c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.settings.ConfirmPasswordFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                confirmPasswordFragment.onForgotPasswordClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ConfirmPasswordFragment confirmPasswordFragment = this.f10951b;
        if (confirmPasswordFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10951b = null;
        confirmPasswordFragment.password = null;
        confirmPasswordFragment.footer = null;
        confirmPasswordFragment.footerError = null;
        this.f10952c.setOnClickListener(null);
        this.f10952c = null;
    }
}
