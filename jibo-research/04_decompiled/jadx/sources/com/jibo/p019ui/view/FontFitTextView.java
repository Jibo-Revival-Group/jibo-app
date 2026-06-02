package com.jibo.p019ui.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.jibo.p019ui.view.proxima.CustomFontTextView;

/* JADX INFO: loaded from: classes.dex */
public class FontFitTextView extends CustomFontTextView {

    /* JADX INFO: renamed from: a */
    private float f11557a;

    /* JADX INFO: renamed from: b */
    private Paint f11558b;

    public FontFitTextView(Context context) {
        super(context);
        m11255a();
    }

    public FontFitTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11255a();
    }

    public FontFitTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11255a();
    }

    /* JADX INFO: renamed from: a */
    private void m11255a() {
        this.f11558b = new Paint();
        this.f11558b.set(getPaint());
        this.f11557a = getTextSize();
    }

    /* JADX INFO: renamed from: a */
    private void m11256a(String str, int i) {
        if (i > 0) {
            int paddingLeft = (i - getPaddingLeft()) - getPaddingRight();
            float f = this.f11557a;
            this.f11558b.set(getPaint());
            float f2 = 2.0f;
            while (f - f2 > 0.5f) {
                float f3 = (f + f2) / 2.0f;
                this.f11558b.setTextSize(f3);
                if (this.f11558b.measureText(str) < paddingLeft) {
                    f2 = f3;
                    f3 = f;
                }
                f = f3;
            }
            setTextSize(0, f2);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int measuredHeight = getMeasuredHeight();
        m11256a(getText().toString(), size);
        setMeasuredDimension(size, measuredHeight);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        m11256a(charSequence.toString(), getWidth());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (i != i3) {
            m11256a(getText().toString(), i);
        }
    }
}
