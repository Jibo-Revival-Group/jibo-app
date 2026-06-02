package com.jibo.p019ui.view.proxima;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.AttributeSet;
import android.widget.EditText;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class CustomFontEditText extends EditText {

    /* JADX INFO: renamed from: a */
    private static final String f11645a = CustomFontEditText.class.getSimpleName();

    public CustomFontEditText(Context context) {
        super(context);
    }

    public CustomFontEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11349a(context, attributeSet);
    }

    public CustomFontEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11349a(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    private void m11349a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomFont);
        ProximaHelper.m11357a(this, typedArrayObtainStyledAttributes.getString(0));
        typedArrayObtainStyledAttributes.recycle();
    }

    public static class NameInputFilter implements InputFilter {
        /* JADX INFO: renamed from: a */
        private boolean m11350a(char c) {
            return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (charSequence instanceof SpannableStringBuilder) {
                SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
                for (int i5 = i2 - 1; i5 >= i; i5--) {
                    char cCharAt = charSequence.charAt(i5);
                    if (!m11350a(cCharAt) && !Character.isSpaceChar(cCharAt) && cCharAt != '-' && cCharAt != '\'') {
                        spannableStringBuilder.delete(i5, i5 + 1);
                    }
                }
                return charSequence;
            }
            StringBuilder sb = new StringBuilder();
            while (i < i2) {
                char cCharAt2 = charSequence.charAt(i);
                if (m11350a(cCharAt2) || Character.isSpaceChar(cCharAt2) || cCharAt2 == '-' || cCharAt2 == '\'') {
                    sb.append(cCharAt2);
                }
                i++;
            }
            return sb.toString();
        }
    }
}
