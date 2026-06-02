package com.jibo.p019ui.view.proxima;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class CustomFontTextView extends TextView {

    /* JADX INFO: renamed from: a */
    private static final String f11647a = CustomFontTextView.class.getSimpleName();

    public CustomFontTextView(Context context) {
        super(context);
    }

    public CustomFontTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11352a(context, attributeSet);
    }

    public CustomFontTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11352a(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    private void m11352a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomFont);
        ProximaHelper.m11357a(this, typedArrayObtainStyledAttributes.getString(0));
        typedArrayObtainStyledAttributes.recycle();
    }
}
