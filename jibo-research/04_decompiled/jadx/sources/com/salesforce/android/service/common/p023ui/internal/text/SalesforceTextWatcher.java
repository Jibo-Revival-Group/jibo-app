package com.salesforce.android.service.common.p023ui.internal.text;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceTextWatcher implements TextWatcher {

    /* JADX INFO: renamed from: a */
    private OnBeforeTextChangedListener f13736a;

    /* JADX INFO: renamed from: b */
    private OnTextChangedListener f13737b;

    /* JADX INFO: renamed from: c */
    private OnAfterTextChangedListener f13738c;

    public interface OnAfterTextChangedListener {
        /* JADX INFO: renamed from: a */
        void mo12805a(Editable editable);
    }

    public interface OnBeforeTextChangedListener {
        /* JADX INFO: renamed from: a */
        void m14009a(CharSequence charSequence, int i, int i2, int i3);
    }

    public interface OnTextChangedListener {
        /* JADX INFO: renamed from: a */
        void m14010a(CharSequence charSequence, int i, int i2, int i3);
    }

    /* JADX INFO: renamed from: a */
    public void m14008a(OnAfterTextChangedListener onAfterTextChangedListener) {
        this.f13738c = onAfterTextChangedListener;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f13736a != null) {
            this.f13736a.m14009a(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f13737b != null) {
            this.f13737b.m14010a(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (this.f13738c != null) {
            this.f13738c.mo12805a(editable);
        }
    }
}
