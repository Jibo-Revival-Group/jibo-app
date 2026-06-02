package com.salesforce.android.service.common.p023ui.internal.text;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.salesforce.android.service.common.p023ui.R;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceStyleHelper {

    /* JADX INFO: renamed from: a */
    private final Context f13732a;

    /* JADX INFO: renamed from: b */
    private final AttributeSet f13733b;

    /* JADX INFO: renamed from: c */
    private final Typeface f13734c = m14000a();

    /* JADX INFO: renamed from: d */
    private StyleSpan f13735d;

    /* JADX INFO: renamed from: a */
    public static SalesforceStyleHelper m13998a(Context context, AttributeSet attributeSet) {
        return new SalesforceStyleHelper(context, attributeSet);
    }

    SalesforceStyleHelper(Context context, AttributeSet attributeSet) {
        this.f13732a = context;
        this.f13733b = attributeSet;
    }

    /* JADX INFO: renamed from: a */
    Typeface m14000a() {
        TypedArray typedArrayM14005c = m14005c();
        TypedArray typedArrayM14006d = m14006d();
        try {
            Typeface typefaceM14001a = m14001a(typedArrayM14005c);
            this.f13735d = new StyleSpan(m13999a(typedArrayM14006d, m14007e()));
            return typefaceM14001a;
        } finally {
            typedArrayM14005c.recycle();
            typedArrayM14006d.recycle();
        }
    }

    /* JADX INFO: renamed from: b */
    public Typeface m14004b() {
        return this.f13734c;
    }

    /* JADX INFO: renamed from: c */
    TypedArray m14005c() {
        return this.f13732a.getTheme().obtainStyledAttributes(this.f13733b, R.styleable.SalesforceTextView, R.attr.salesforceFontStyle, 0);
    }

    /* JADX INFO: renamed from: a */
    Typeface m14001a(TypedArray typedArray) {
        String string = typedArray.getString(R.styleable.SalesforceTextView_salesforceFont);
        if (string == null || string.isEmpty()) {
            return null;
        }
        return TypefaceFactory.m14011a(this.f13732a.getAssets(), string);
    }

    /* JADX INFO: renamed from: a */
    public CharSequence m14002a(CharSequence charSequence) {
        if (this.f13735d == null || charSequence == null || charSequence.length() < 1) {
            return charSequence;
        }
        CharSequence spannableString = !(charSequence instanceof Spannable) ? new SpannableString(charSequence) : charSequence;
        m14003a((Spannable) spannableString, this.f13735d);
        return spannableString;
    }

    /* JADX INFO: renamed from: d */
    TypedArray m14006d() {
        return this.f13732a.obtainStyledAttributes(this.f13733b, new int[]{android.R.attr.textStyle});
    }

    /* JADX INFO: renamed from: e */
    int m14007e() {
        TypedValue typedValue = new TypedValue();
        this.f13732a.getTheme().resolveAttribute(android.R.attr.textStyle, typedValue, true);
        return typedValue.data;
    }

    /* JADX INFO: renamed from: a */
    int m13999a(TypedArray typedArray, int i) {
        return typedArray.getInt(i, 0);
    }

    /* JADX INFO: renamed from: a */
    void m14003a(Spannable spannable, StyleSpan styleSpan) {
        spannable.setSpan(styleSpan, 0, spannable.length(), 33);
    }
}
