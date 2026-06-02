package com.jibo.p019ui.view.proxima;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class CustomTextInputLayout extends TextInputLayout {

    /* JADX INFO: renamed from: e */
    private static final String f11648e = CustomTextInputLayout.class.getSimpleName();

    public CustomTextInputLayout(Context context) {
        super(context);
    }

    public CustomTextInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11353a(context, attributeSet);
    }

    public CustomTextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11353a(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    private void m11353a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomFont);
        ProximaHelper.m11357a(this, typedArrayObtainStyledAttributes.getString(0));
        typedArrayObtainStyledAttributes.recycle();
    }
}
