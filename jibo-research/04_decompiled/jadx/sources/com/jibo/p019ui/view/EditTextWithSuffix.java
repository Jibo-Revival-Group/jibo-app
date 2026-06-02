package com.jibo.p019ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import com.jibo.R;
import com.jibo.p019ui.view.proxima.CustomFontEditText;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class EditTextWithSuffix extends CustomFontEditText {

    /* JADX INFO: renamed from: a */
    TextPaint f11553a;

    /* JADX INFO: renamed from: b */
    private String f11554b;

    /* JADX INFO: renamed from: c */
    private float f11555c;

    public EditTextWithSuffix(Context context) {
        super(context);
        this.f11553a = new TextPaint();
        this.f11554b = "";
    }

    public EditTextWithSuffix(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11553a = new TextPaint();
        this.f11554b = "";
        m11254a(context, attributeSet, 0);
    }

    public EditTextWithSuffix(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11553a = new TextPaint();
        this.f11554b = "";
        m11254a(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(this.f11554b, Math.max(((int) getPaint().measureText(getText().toString())) + getPaddingLeft(), this.f11555c), getBaseline(), this.f11553a);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f11553a.setColor(getCurrentTextColor());
        this.f11553a.setTextSize(getTextSize());
        this.f11553a.setTextAlign(Paint.Align.LEFT);
    }

    /* JADX INFO: renamed from: a */
    private void m11254a(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EditTextWithSuffix, i, 0);
        if (typedArrayObtainStyledAttributes != null) {
            this.f11554b = typedArrayObtainStyledAttributes.getString(0);
            if (this.f11554b == null) {
                this.f11554b = "";
            }
            this.f11555c = typedArrayObtainStyledAttributes.getDimension(1, CropImageView.DEFAULT_ASPECT_RATIO);
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
