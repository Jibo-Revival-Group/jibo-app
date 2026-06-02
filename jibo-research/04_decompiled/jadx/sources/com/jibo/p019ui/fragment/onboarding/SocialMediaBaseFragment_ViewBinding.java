package com.jibo.p019ui.fragment.onboarding;

import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class SocialMediaBaseFragment_ViewBinding implements Unbinder {

    /* JADX INFO: renamed from: b */
    private SocialMediaBaseFragment f10804b;

    public SocialMediaBaseFragment_ViewBinding(SocialMediaBaseFragment socialMediaBaseFragment, View view) {
        this.f10804b = socialMediaBaseFragment;
        socialMediaBaseFragment.emailEditText = (EditText) Utils.m5161b(view, R.id.email, "field 'emailEditText'", EditText.class);
        socialMediaBaseFragment.passwordEditText = (EditText) Utils.m5161b(view, R.id.password, "field 'passwordEditText'", EditText.class);
    }

    @Override // butterknife.Unbinder
    public void unbind() {
        SocialMediaBaseFragment socialMediaBaseFragment = this.f10804b;
        if (socialMediaBaseFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10804b = null;
        socialMediaBaseFragment.emailEditText = null;
        socialMediaBaseFragment.passwordEditText = null;
    }
}
