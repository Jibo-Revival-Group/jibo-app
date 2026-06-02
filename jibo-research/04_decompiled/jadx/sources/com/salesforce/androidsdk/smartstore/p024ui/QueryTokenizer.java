package com.salesforce.androidsdk.smartstore.p024ui;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.MultiAutoCompleteTextView;

/* JADX INFO: compiled from: SmartStoreInspectorActivity.java */
/* JADX INFO: loaded from: classes.dex */
class QueryTokenizer implements MultiAutoCompleteTextView.Tokenizer {
    QueryTokenizer() {
    }

    @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
    public int findTokenStart(CharSequence charSequence, int i) {
        while (i > 0 && charSequence.charAt(i - 1) != ' ') {
            i--;
        }
        return i;
    }

    @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
    public int findTokenEnd(CharSequence charSequence, int i) {
        int length = charSequence.length();
        for (int i2 = i; i2 < length; i2++) {
            if (charSequence.charAt(i2) == ' ') {
                return i2;
            }
        }
        return length;
    }

    @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
    public CharSequence terminateToken(CharSequence charSequence) {
        int length = charSequence.length();
        while (length > 0 && charSequence.charAt(length - 1) == ' ') {
            length--;
        }
        if ((length <= 0 || charSequence.charAt(length - 1) != ' ') && (charSequence instanceof Spanned)) {
            SpannableString spannableString = new SpannableString(((Object) charSequence) + " ");
            TextUtils.copySpansFrom((Spanned) charSequence, 0, charSequence.length(), Object.class, spannableString, 0);
            return spannableString;
        }
        return charSequence;
    }
}
