package com.salesforce.android.service.common.p023ui.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.salesforce.android.service.common.p023ui.R;
import com.salesforce.android.service.common.p023ui.internal.utils.ShapeFactory;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceProgressSpinner extends View implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    private final ProgressSpinner f13792a;

    public SalesforceProgressSpinner(Context context) {
        this(context, null);
    }

    public SalesforceProgressSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.salesforceProgressSpinnerStyle);
    }

    public SalesforceProgressSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SalesforceProgressSpinner, i, 0);
        ProgressSpinnerProperties progressSpinnerProperties = new ProgressSpinnerProperties();
        try {
            progressSpinnerProperties.f13800d = m14037a(typedArrayObtainStyledAttributes, R.styleable.SalesforceProgressSpinner_salesforce_highlight_color, R.color.salesforce_brand_secondary);
            progressSpinnerProperties.f13799c = m14037a(typedArrayObtainStyledAttributes, R.styleable.SalesforceProgressSpinner_salesforce_shadow_color, R.color.salesforce_contrast_tertiary);
            progressSpinnerProperties.f13798b = m14038a(m14039a(typedArrayObtainStyledAttributes, R.styleable.SalesforceProgressSpinner_salesforce_highlight_arc_degrees));
            progressSpinnerProperties.f13797a = m14041c(typedArrayObtainStyledAttributes, R.styleable.SalesforceProgressSpinner_salesforce_thickness);
            progressSpinnerProperties.f13801e = m14040b(typedArrayObtainStyledAttributes, R.styleable.SalesforceProgressSpinner_salesforce_rotations_per_second);
            typedArrayObtainStyledAttributes.recycle();
            this.f13792a = new ProgressSpinner(progressSpinnerProperties);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private int m14037a(TypedArray typedArray, int i, int i2) {
        return typedArray.getColor(i, ContextCompat.m1840c(getContext(), i2));
    }

    /* JADX INFO: renamed from: a */
    private String m14039a(TypedArray typedArray, int i) {
        return typedArray.getString(i);
    }

    /* JADX INFO: renamed from: a */
    private int m14038a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: b */
    private float m14040b(TypedArray typedArray, int i) {
        return typedArray.getFloat(i, CropImageView.DEFAULT_ASPECT_RATIO);
    }

    /* JADX INFO: renamed from: c */
    private int m14041c(TypedArray typedArray, int i) {
        return typedArray.getDimensionPixelSize(i, 0);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        setRotation(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f13792a.m14044a(i, i2);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            this.f13792a.m14045a(this);
            this.f13792a.m14042a();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.f13792a.m14048b();
            this.f13792a.m14042a();
        } else {
            this.f13792a.m14048b();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f13792a.m14048b();
        this.f13792a.m14049b(this);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f13792a.m14046a(canvas);
    }

    static class ProgressSpinnerProperties {

        /* JADX INFO: renamed from: a */
        int f13797a;

        /* JADX INFO: renamed from: b */
        int f13798b;

        /* JADX INFO: renamed from: c */
        int f13799c;

        /* JADX INFO: renamed from: d */
        int f13800d;

        /* JADX INFO: renamed from: e */
        float f13801e;

        ProgressSpinnerProperties() {
        }
    }

    static class ProgressSpinner {

        /* JADX INFO: renamed from: a */
        final GradientDrawable f13793a = m14050c();

        /* JADX INFO: renamed from: b */
        final GradientDrawable f13794b;

        /* JADX INFO: renamed from: c */
        private final ProgressSpinnerProperties f13795c;

        /* JADX INFO: renamed from: d */
        private final ValueAnimator f13796d;

        ProgressSpinner(ProgressSpinnerProperties progressSpinnerProperties) {
            this.f13795c = progressSpinnerProperties;
            this.f13796d = m14047b(this.f13795c.f13801e);
            this.f13793a.setStroke(this.f13795c.f13797a, this.f13795c.f13799c);
            this.f13794b = m14050c();
        }

        /* JADX INFO: renamed from: a */
        void m14046a(Canvas canvas) {
            this.f13793a.draw(canvas);
            this.f13794b.draw(canvas);
        }

        /* JADX INFO: renamed from: a */
        void m14044a(int i, int i2) {
            int iMin = Math.min(i, i2);
            float f = 3.1415927f * iMin;
            int i3 = (i - iMin) / 2;
            int i4 = (i2 - iMin) / 2;
            this.f13793a.setBounds(i3, i4, i - i3, i2 - i4);
            this.f13794b.setBounds(i3, i4, i - i3, i2 - i4);
            m14043a(f);
        }

        /* JADX INFO: renamed from: a */
        void m14043a(float f) {
            float f2 = (this.f13795c.f13798b / 360.0f) * f;
            this.f13794b.setStroke(this.f13795c.f13797a, this.f13795c.f13800d, f2, f - f2);
        }

        /* JADX INFO: renamed from: a */
        void m14042a() {
            this.f13796d.start();
        }

        /* JADX INFO: renamed from: b */
        void m14048b() {
            this.f13796d.cancel();
        }

        /* JADX INFO: renamed from: a */
        void m14045a(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            this.f13796d.addUpdateListener(animatorUpdateListener);
        }

        /* JADX INFO: renamed from: b */
        void m14049b(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
            this.f13796d.removeUpdateListener(animatorUpdateListener);
        }

        /* JADX INFO: renamed from: c */
        GradientDrawable m14050c() {
            GradientDrawable gradientDrawableM14013a = ShapeFactory.m14013a();
            gradientDrawableM14013a.setColor(0);
            gradientDrawableM14013a.setShape(1);
            return gradientDrawableM14013a;
        }

        /* JADX INFO: renamed from: b */
        ValueAnimator m14047b(float f) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(CropImageView.DEFAULT_ASPECT_RATIO, 360.0f);
            valueAnimatorOfFloat.setRepeatCount(-1);
            valueAnimatorOfFloat.setDuration((long) (1000.0f / f));
            valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
            return valueAnimatorOfFloat;
        }
    }
}
