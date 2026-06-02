package com.salesforce.android.service.common.p023ui.internal.text;

import android.text.GetChars;
import android.text.Spannable;

/* JADX INFO: loaded from: classes.dex */
public class SpannableString implements GetChars, Spannable, CharSequence {

    /* JADX INFO: renamed from: a */
    private android.text.SpannableString f13739a;

    public SpannableString(CharSequence charSequence) {
        this.f13739a = new android.text.SpannableString(charSequence);
    }

    @Override // android.text.GetChars
    public void getChars(int i, int i2, char[] cArr, int i3) {
        this.f13739a.getChars(i, i2, cArr, i3);
    }

    @Override // android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        this.f13739a.setSpan(obj, i, i2, i3);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object obj) {
        this.f13739a.removeSpan(obj);
    }

    @Override // android.text.Spanned
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return (T[]) this.f13739a.getSpans(i, i2, cls);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.f13739a.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.f13739a.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.f13739a.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f13739a.nextSpanTransition(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.f13739a.length();
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.f13739a.charAt(i);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.f13739a.subSequence(i, i2);
    }

    public int hashCode() {
        return this.f13739a.hashCode();
    }

    public boolean equals(Object obj) {
        return this.f13739a.equals(obj);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.f13739a.toString();
    }
}
