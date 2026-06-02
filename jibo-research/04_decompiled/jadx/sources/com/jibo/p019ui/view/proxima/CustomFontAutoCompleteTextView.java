package com.jibo.p019ui.view.proxima;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.jibo.R;

/* JADX INFO: loaded from: classes.dex */
public class CustomFontAutoCompleteTextView extends AutoCompleteTextView {

    /* JADX INFO: renamed from: a */
    private static final String f11642a = CustomFontAutoCompleteTextView.class.getSimpleName();

    public CustomFontAutoCompleteTextView(Context context) {
        super(context);
    }

    public CustomFontAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11346a(context, attributeSet);
    }

    public CustomFontAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11346a(context, attributeSet);
    }

    /* JADX INFO: renamed from: a */
    private void m11346a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomFont);
        ProximaHelper.m11357a(this, typedArrayObtainStyledAttributes.getString(0));
        typedArrayObtainStyledAttributes.recycle();
    }
}
