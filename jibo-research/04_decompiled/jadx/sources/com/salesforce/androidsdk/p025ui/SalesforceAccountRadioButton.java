package com.salesforce.androidsdk.p025ui;

import android.R;
import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.widget.RadioButton;
import android.widget.TextView;
import com.salesforce.androidsdk.accounts.UserAccount;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceAccountRadioButton extends RadioButton {

    /* JADX INFO: renamed from: a */
    private Context f14430a;

    /* JADX INFO: renamed from: b */
    private UserAccount f14431b;

    public SalesforceAccountRadioButton(Context context, UserAccount userAccount) {
        super(context);
        this.f14430a = context;
        this.f14431b = userAccount;
        m14923a();
    }

    /* JADX INFO: renamed from: a */
    public void m14923a() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.f14431b != null && this.f14431b.m14248h() != null && this.f14431b.m14243c() != null) {
            String strM14248h = this.f14431b.m14248h();
            String strM14243c = this.f14431b.m14243c();
            SpannableString spannableString = new SpannableString(strM14248h);
            spannableString.setSpan(new TextAppearanceSpan(this.f14430a, R.style.TextAppearance.Medium), 0, strM14248h.length(), 33);
            SpannableString spannableString2 = new SpannableString(strM14243c);
            spannableString2.setSpan(new TextAppearanceSpan(this.f14430a, R.style.TextAppearance.Small), 0, strM14243c.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) System.getProperty("line.separator"));
            spannableStringBuilder.append((CharSequence) spannableString2);
        }
        super.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    public UserAccount getAccount() {
        return this.f14431b;
    }
}
