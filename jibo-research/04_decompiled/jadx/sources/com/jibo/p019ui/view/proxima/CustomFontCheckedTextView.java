package com.jibo.p019ui.view.proxima;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class CustomFontCheckedTextView extends CheckedTextView {

    /* JADX INFO: renamed from: a */
    private static final String f11644a = CustomFontCheckedTextView.class.getSimpleName();

    public CustomFontCheckedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11348a(context, attributeSet);
    }

    public CustomFontCheckedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11348a(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    private void m11348a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomFont);
        ProximaHelper.m11357a(this, typedArrayObtainStyledAttributes.getString(0));
        typedArrayObtainStyledAttributes.recycle();
    }
}
