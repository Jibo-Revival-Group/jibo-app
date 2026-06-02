package com.jibo.p019ui.fragment.onboarding;

import android.R;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public class SignupFragment_ViewBinding extends SocialMediaBaseFragment_ViewBinding {

    /* JADX INFO: renamed from: b */
    private SignupFragment f10777b;

    /* JADX INFO: renamed from: c */
    private View f10778c;

    public SignupFragment_ViewBinding(final SignupFragment signupFragment, View view) {
        super(signupFragment, view);
        this.f10777b = signupFragment;
        View viewM5158a = Utils.m5158a(view, R.id.checkbox, "field 'termsCheckbox' and method 'onTermsCheckboxClick'");
        signupFragment.termsCheckbox = (CheckBox) Utils.m5162c(viewM5158a, R.id.checkbox, "field 'termsCheckbox'", CheckBox.class);
        this.f10778c = viewM5158a;
        viewM5158a.setOnClickListener(new DebouncingOnClickListener() { // from class: com.jibo.ui.fragment.onboarding.SignupFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            /* JADX INFO: renamed from: a */
            public void mo5157a(View view2) {
                signupFragment.onTermsCheckboxClick();
            }
        });
        signupFragment.footerText = (TextView) Utils.m5161b(view, com.jibo.R.id.footer, "field 'footerText'", TextView.class);
        signupFragment.validationFooterText = (TextView) Utils.m5161b(view, com.jibo.R.id.validation_footer, "field 'validationFooterText'", TextView.class);
    }

    @Override // com.jibo.p019ui.fragment.onboarding.SocialMediaBaseFragment_ViewBinding, butterknife.Unbinder
    public void unbind() {
        SignupFragment signupFragment = this.f10777b;
        if (signupFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.f10777b = null;
        signupFragment.termsCheckbox = null;
        signupFragment.footerText = null;
        signupFragment.validationFooterText = null;
        this.f10778c.setOnClickListener(null);
        this.f10778c = null;
        super.unbind();
    }
}
