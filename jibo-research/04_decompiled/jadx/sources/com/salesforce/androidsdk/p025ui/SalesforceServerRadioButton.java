package com.salesforce.androidsdk.p025ui;

import android.R;
import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.widget.RadioButton;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceServerRadioButton extends RadioButton {

    /* JADX INFO: renamed from: a */
    private Context f14453a;

    /* JADX INFO: renamed from: b */
    private String f14454b;

    /* JADX INFO: renamed from: c */
    private String f14455c;

    /* JADX INFO: renamed from: d */
    private boolean f14456d;

    public SalesforceServerRadioButton(Context context, String str, String str2, boolean z) {
        super(context);
        this.f14453a = context;
        this.f14454b = str;
        this.f14455c = str2;
        this.f14456d = z;
        m14999a();
    }

    /* JADX INFO: renamed from: a */
    public void m14999a() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.f14454b != null && this.f14455c != null) {
            SpannableString spannableString = new SpannableString(this.f14454b);
            spannableString.setSpan(new TextAppearanceSpan(this.f14453a, R.style.TextAppearance.Medium), 0, this.f14454b.length(), 33);
            SpannableString spannableString2 = new SpannableString(this.f14455c);
            spannableString2.setSpan(new TextAppearanceSpan(this.f14453a, R.style.TextAppearance.Small), 0, this.f14455c.length(), 33);
            spannableStringBuilder.append((CharSequence) spannableString);
            spannableStringBuilder.append((CharSequence) System.getProperty("line.separator"));
            spannableStringBuilder.append((CharSequence) spannableString2);
        }
        super.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    public String getName() {
        return this.f14454b;
    }

    public String getUrl() {
        return this.f14455c;
    }

    /* JADX INFO: renamed from: b */
    public boolean m15000b() {
        return this.f14456d;
    }
}
