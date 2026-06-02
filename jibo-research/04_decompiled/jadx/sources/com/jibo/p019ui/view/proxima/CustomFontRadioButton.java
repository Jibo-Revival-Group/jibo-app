package com.jibo.p019ui.view.proxima;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class CustomFontRadioButton extends AppCompatRadioButton {

    /* JADX INFO: renamed from: a */
    private static final String f11646a = CustomFontRadioButton.class.getSimpleName();

    public CustomFontRadioButton(Context context) {
        super(context);
    }

    public CustomFontRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11351a(context, attributeSet);
    }

    public CustomFontRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11351a(context, attributeSet);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    /* JADX INFO: renamed from: a */
    private void m11351a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomFont);
        ProximaHelper.m11357a(this, typedArrayObtainStyledAttributes.getString(0));
        typedArrayObtainStyledAttributes.recycle();
    }
}
