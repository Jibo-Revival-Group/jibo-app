package com.jibo.p019ui.fragment.onboarding;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import com.crashlytics.android.Crashlytics;
import com.jibo.R;
import com.jibo.p018db.EntityData;
import com.jibo.p019ui.activity.OnBoardingActivity;
import com.jibo.p019ui.view.proxima.ProximaHelper;
import com.jibo.utils.UIUtils;
import com.jibo.utils.Util;

/* JADX INFO: loaded from: classes.dex */
public class SignupFragment extends SocialMediaBaseFragment {

    /* JADX INFO: renamed from: a */
    public static final String f10773a = SignupFragment.class.getSimpleName();

    /* JADX INFO: renamed from: d */
    private String f10774d;

    @BindView
    TextView footerText;

    @BindView
    CheckBox termsCheckbox;

    @BindView
    TextView validationFooterText;

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_create_account, viewGroup, false);
    }

    @Override // com.jibo.p019ui.fragment.onboarding.SocialMediaBaseFragment, com.jibo.p019ui.fragment.BaseFragment, android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle == null && getArguments() != null && !TextUtils.isEmpty(getArguments().getString("email"))) {
            this.emailEditText.setText(getArguments().getString("email"));
        }
        this.f10774d = (getArguments() == null || TextUtils.isEmpty(getArguments().getString("code"))) ? null : getArguments().getString("code");
        String string = getString(R.string.terms);
        String string2 = getString(R.string.privacy_policy);
        String string3 = getString(R.string.create_account_footer2, string, string2);
        int iIndexOf = string3.indexOf(string);
        int iIndexOf2 = string3.indexOf(string2);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string3);
        spannableStringBuilder.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.f11651c), iIndexOf, string.length() + iIndexOf, 33);
        spannableStringBuilder.setSpan(new Util.CustomTypefaceSpan("", ProximaHelper.f11651c), iIndexOf2, string2.length() + iIndexOf2, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.jibo_blue)), iIndexOf2, string2.length() + iIndexOf2, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.jibo_blue)), iIndexOf, string.length() + iIndexOf, 33);
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.jibo.ui.fragment.onboarding.SignupFragment.1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view2) {
                SignupFragment.this.m10865q();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, iIndexOf2, string2.length() + iIndexOf2, 33);
        spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.jibo.ui.fragment.onboarding.SignupFragment.2
            @Override // android.text.style.ClickableSpan
            public void onClick(View view2) {
                SignupFragment.this.m10866r();
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setUnderlineText(false);
            }
        }, iIndexOf, string.length() + iIndexOf, 33);
        this.footerText.setText(spannableStringBuilder);
        this.footerText.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q */
    public void m10865q() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.privacy_policy_link))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: r */
    public void m10866r() {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getString(R.string.terms_link))));
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10334a(ActionBar actionBar) {
        super.mo10334a(actionBar);
        actionBar.setDisplayHomeAsUpEnabled(true);
        m10350l();
    }

    @Override // com.jibo.p019ui.fragment.BaseFragment
    /* JADX INFO: renamed from: o */
    protected String mo10353o() {
        return getString(R.string.title_signup);
    }

    @Override // com.jibo.p019ui.fragment.onboarding.SocialMediaBaseFragment
    /* JADX INFO: renamed from: a */
    protected void mo10834a() {
        try {
            this.f10796b.setEnabled(false);
            m10343e();
            String string = this.emailEditText.getText().toString();
            String string2 = this.passwordEditText.getText().toString();
            m10344f();
            EntityData.m10089a(getActivity()).m10110a().create(string, string2, this.f10774d, this.f10797c);
        } catch (Exception e) {
            mo10345g();
            this.f10796b.setEnabled(true);
            ((OnBoardingActivity) getActivity()).m10202l();
            Crashlytics.m5597a((Throwable) e);
        }
    }

    @Override // com.jibo.p019ui.fragment.onboarding.SocialMediaBaseFragment
    /* JADX INFO: renamed from: b */
    protected void mo10836b() {
        super.mo10836b();
        if (this.f10796b != null) {
            this.f10796b.setEnabled(this.f10796b.isEnabled() && this.termsCheckbox.isChecked());
        }
        String string = this.passwordEditText.getText().toString();
        String string2 = this.emailEditText.getText().toString();
        UIUtils.m11477a(string, this.validationFooterText);
        m10861a(m10862a(string2), m10864b(string2));
    }

    @OnClick
    public void onTermsCheckboxClick() {
        mo10836b();
    }

    /* JADX INFO: renamed from: a */
    private boolean m10862a(String str) {
        return str.length() > 80;
    }

    /* JADX INFO: renamed from: b */
    private boolean m10864b(String str) {
        String[] strArrSplit = str.split("@");
        return strArrSplit.length > 0 && strArrSplit[0].length() > 64;
    }

    /* JADX INFO: renamed from: a */
    private void m10861a(boolean z, boolean z2) {
        if (z2 || z) {
            String string = z ? getString(R.string.email_too_long) : getString(R.string.email_first_part_too_long);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.firecracker)), 0, string.length(), 33);
            this.validationFooterText.setText(spannableStringBuilder);
        }
    }
}
