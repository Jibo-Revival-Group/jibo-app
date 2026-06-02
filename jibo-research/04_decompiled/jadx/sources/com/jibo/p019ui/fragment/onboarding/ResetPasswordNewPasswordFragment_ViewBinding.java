package com.jibo.p019ui.fragment.onboarding;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class ResetPasswordNewPasswordFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private ResetPasswordNewPasswordFragment f10747b;

    public ResetPasswordNewPasswordFragment_ViewBinding(ResetPasswordNewPasswordFragment resetPasswordNewPasswordFragment, View view) {
        this.f10747b = resetPasswordNewPasswordFragment;
        resetPasswordNewPasswordFragment.passwordEdit = (EditText) Utils.m5161b(view, R.id.password, "field 'passwordEdit'", EditText.class);
        resetPasswordNewPasswordFragment.footer = (TextView) Utils.m5161b(view, R.id.footer, "field 'footer'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ResetPasswordNewPasswordFragment resetPasswordNewPasswordFragment = this.f10747b;
        if (resetPasswordNewPasswordFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10747b = null;
        resetPasswordNewPasswordFragment.passwordEdit = null;
        resetPasswordNewPasswordFragment.footer = null;
    }
}
