package com.jibo.p019ui.fragment.onboarding;

import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class ResetPasswordFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private ResetPasswordFragment f10740b;

    public ResetPasswordFragment_ViewBinding(ResetPasswordFragment resetPasswordFragment, View view) {
        this.f10740b = resetPasswordFragment;
        resetPasswordFragment.emailEditText = (EditText) Utils.m5161b(view, R.id.email, "field 'emailEditText'", EditText.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        ResetPasswordFragment resetPasswordFragment = this.f10740b;
        if (resetPasswordFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10740b = null;
        resetPasswordFragment.emailEditText = null;
    }
}
