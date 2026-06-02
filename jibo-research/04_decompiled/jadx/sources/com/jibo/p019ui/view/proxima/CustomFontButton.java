package com.jibo.p019ui.view.proxima;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class CustomFontButton extends Button {

    /* JADX INFO: renamed from: a */
    private static final String f11643a = CustomFontButton.class.getSimpleName();

    public CustomFontButton(Context context) {
        super(context);
    }

    public CustomFontButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11347a(context, attributeSet);
    }

    public CustomFontButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11347a(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    private void m11347a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomFont);
        ProximaHelper.m11357a(this, typedArrayObtainStyledAttributes.getString(0));
        typedArrayObtainStyledAttributes.recycle();
    }
}
