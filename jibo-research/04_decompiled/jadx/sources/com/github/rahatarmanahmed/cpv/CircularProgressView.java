package com.github.rahatarmanahmed.cpv;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CircularProgressView extends View {

    /* JADX INFO: renamed from: a */
    private Paint f5795a;

    /* JADX INFO: renamed from: b */
    private int f5796b;

    /* JADX INFO: renamed from: c */
    private RectF f5797c;

    /* JADX INFO: renamed from: d */
    private boolean f5798d;

    /* JADX INFO: renamed from: e */
    private boolean f5799e;

    /* JADX INFO: renamed from: f */
    private float f5800f;

    /* JADX INFO: renamed from: g */
    private float f5801g;

    /* JADX INFO: renamed from: h */
    private float f5802h;

    /* JADX INFO: renamed from: i */
    private float f5803i;

    /* JADX INFO: renamed from: j */
    private int f5804j;

    /* JADX INFO: renamed from: k */
    private int f5805k;

    /* JADX INFO: renamed from: l */
    private int f5806l;

    /* JADX INFO: renamed from: m */
    private int f5807m;

    /* JADX INFO: renamed from: n */
    private int f5808n;

    /* JADX INFO: renamed from: o */
    private int f5809o;

    /* JADX INFO: renamed from: p */
    private List<CircularProgressViewListener> f5810p;

    /* JADX INFO: renamed from: q */
    private float f5811q;

    /* JADX INFO: renamed from: r */
    private float f5812r;

    /* JADX INFO: renamed from: s */
    private ValueAnimator f5813s;

    /* JADX INFO: renamed from: t */
    private ValueAnimator f5814t;

    /* JADX INFO: renamed from: u */
    private AnimatorSet f5815u;

    /* JADX INFO: renamed from: v */
    private float f5816v;

    public CircularProgressView(Context context) {
        super(context);
        this.f5796b = 0;
        m6657a((AttributeSet) null, 0);
    }

    public CircularProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5796b = 0;
        m6657a(attributeSet, 0);
    }

    public CircularProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5796b = 0;
        m6657a(attributeSet, i);
    }

    /* JADX INFO: renamed from: a */
    protected void m6657a(AttributeSet attributeSet, int i) {
        this.f5810p = new ArrayList();
        m6651b(attributeSet, i);
        this.f5795a = new Paint(1);
        m6655e();
        this.f5797c = new RectF();
    }

    /* JADX INFO: renamed from: b */
    private void m6651b(AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CircularProgressView, i, 0);
        Resources resources = getResources();
        this.f5800f = typedArrayObtainStyledAttributes.getFloat(R.styleable.CircularProgressView_cpv_progress, resources.getInteger(R.integer.cpv_default_progress));
        this.f5801g = typedArrayObtainStyledAttributes.getFloat(R.styleable.CircularProgressView_cpv_maxProgress, resources.getInteger(R.integer.cpv_default_max_progress));
        this.f5804j = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.CircularProgressView_cpv_thickness, resources.getDimensionPixelSize(R.dimen.cpv_default_thickness));
        this.f5798d = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CircularProgressView_cpv_indeterminate, resources.getBoolean(R.bool.cpv_default_is_indeterminate));
        this.f5799e = typedArrayObtainStyledAttributes.getBoolean(R.styleable.CircularProgressView_cpv_animAutostart, resources.getBoolean(R.bool.cpv_default_anim_autostart));
        this.f5816v = typedArrayObtainStyledAttributes.getFloat(R.styleable.CircularProgressView_cpv_startAngle, resources.getInteger(R.integer.cpv_default_start_angle));
        this.f5811q = this.f5816v;
        int identifier = getContext().getResources().getIdentifier("colorAccent", "attr", getContext().getPackageName());
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CircularProgressView_cpv_color)) {
            this.f5805k = typedArrayObtainStyledAttributes.getColor(R.styleable.CircularProgressView_cpv_color, resources.getColor(R.color.cpv_default_color));
        } else if (identifier != 0) {
            TypedValue typedValue = new TypedValue();
            getContext().getTheme().resolveAttribute(identifier, typedValue, true);
            this.f5805k = typedValue.data;
        } else if (Build.VERSION.SDK_INT >= 21) {
            this.f5805k = getContext().obtainStyledAttributes(new int[]{android.R.attr.colorAccent}).getColor(0, resources.getColor(R.color.cpv_default_color));
        } else {
            this.f5805k = resources.getColor(R.color.cpv_default_color);
        }
        this.f5806l = typedArrayObtainStyledAttributes.getInteger(R.styleable.CircularProgressView_cpv_animDuration, resources.getInteger(R.integer.cpv_default_anim_duration));
        this.f5807m = typedArrayObtainStyledAttributes.getInteger(R.styleable.CircularProgressView_cpv_animSwoopDuration, resources.getInteger(R.integer.cpv_default_anim_swoop_duration));
        this.f5808n = typedArrayObtainStyledAttributes.getInteger(R.styleable.CircularProgressView_cpv_animSyncDuration, resources.getInteger(R.integer.cpv_default_anim_sync_duration));
        this.f5809o = typedArrayObtainStyledAttributes.getInteger(R.styleable.CircularProgressView_cpv_animSteps, resources.getInteger(R.integer.cpv_default_anim_steps));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int measuredWidth = getMeasuredWidth() - paddingLeft;
        int measuredHeight = getMeasuredHeight() - paddingTop;
        if (measuredWidth >= measuredHeight) {
            measuredWidth = measuredHeight;
        }
        this.f5796b = measuredWidth;
        setMeasuredDimension(this.f5796b + paddingLeft, this.f5796b + paddingTop);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i >= i2) {
            i = i2;
        }
        this.f5796b = i;
        m6654d();
    }

    /* JADX INFO: renamed from: d */
    private void m6654d() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        this.f5797c.set(this.f5804j + paddingLeft, this.f5804j + paddingTop, (this.f5796b - paddingLeft) - this.f5804j, (this.f5796b - paddingTop) - this.f5804j);
    }

    /* JADX INFO: renamed from: e */
    private void m6655e() {
        this.f5795a.setColor(this.f5805k);
        this.f5795a.setStyle(Paint.Style.STROKE);
        this.f5795a.setStrokeWidth(this.f5804j);
        this.f5795a.setStrokeCap(Paint.Cap.BUTT);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = isInEditMode() ? (this.f5800f / this.f5801g) * 360.0f : (this.f5812r / this.f5801g) * 360.0f;
        if (!this.f5798d) {
            canvas.drawArc(this.f5797c, this.f5811q, f, false, this.f5795a);
        } else {
            canvas.drawArc(this.f5797c, this.f5803i + this.f5811q, this.f5802h, false, this.f5795a);
        }
    }

    public void setIndeterminate(boolean z) {
        boolean z2 = this.f5798d;
        boolean z3 = this.f5798d == z;
        this.f5798d = z;
        if (z3) {
            m6658b();
        }
        if (z2 != z) {
            Iterator<CircularProgressViewListener> it = this.f5810p.iterator();
            while (it.hasNext()) {
                it.next().m6662a(z);
            }
        }
    }

    public int getThickness() {
        return this.f5804j;
    }

    public void setThickness(int i) {
        this.f5804j = i;
        m6655e();
        m6654d();
        invalidate();
    }

    public int getColor() {
        return this.f5805k;
    }

    public void setColor(int i) {
        this.f5805k = i;
        m6655e();
        invalidate();
    }

    public float getMaxProgress() {
        return this.f5801g;
    }

    public void setMaxProgress(float f) {
        this.f5801g = f;
        invalidate();
    }

    public float getProgress() {
        return this.f5800f;
    }

    public void setProgress(final float f) {
        this.f5800f = f;
        if (!this.f5798d) {
            if (this.f5814t != null && this.f5814t.isRunning()) {
                this.f5814t.cancel();
            }
            this.f5814t = ValueAnimator.ofFloat(this.f5812r, f);
            this.f5814t.setDuration(this.f5808n);
            this.f5814t.setInterpolator(new LinearInterpolator());
            this.f5814t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CircularProgressView.this.f5812r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    CircularProgressView.this.invalidate();
                }
            });
            this.f5814t.addListener(new AnimatorListenerAdapter() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    Iterator it = CircularProgressView.this.f5810p.iterator();
                    while (it.hasNext()) {
                        ((CircularProgressViewListener) it.next()).m6663b(f);
                    }
                }
            });
            this.f5814t.start();
        }
        invalidate();
        Iterator<CircularProgressViewListener> it = this.f5810p.iterator();
        while (it.hasNext()) {
            it.next().m6661a(f);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6656a() {
        m6658b();
    }

    /* JADX INFO: renamed from: b */
    public void m6658b() {
        int i = 0;
        if (this.f5813s != null && this.f5813s.isRunning()) {
            this.f5813s.cancel();
        }
        if (this.f5814t != null && this.f5814t.isRunning()) {
            this.f5814t.cancel();
        }
        if (this.f5815u != null && this.f5815u.isRunning()) {
            this.f5815u.cancel();
        }
        if (!this.f5798d) {
            this.f5811q = this.f5816v;
            this.f5813s = ValueAnimator.ofFloat(this.f5811q, this.f5811q + 360.0f);
            this.f5813s.setDuration(this.f5807m);
            this.f5813s.setInterpolator(new DecelerateInterpolator(2.0f));
            this.f5813s.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CircularProgressView.this.f5811q = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    CircularProgressView.this.invalidate();
                }
            });
            this.f5813s.start();
            this.f5812r = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f5814t = ValueAnimator.ofFloat(this.f5812r, this.f5800f);
            this.f5814t.setDuration(this.f5808n);
            this.f5814t.setInterpolator(new LinearInterpolator());
            this.f5814t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    CircularProgressView.this.f5812r = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    CircularProgressView.this.invalidate();
                }
            });
            this.f5814t.start();
            return;
        }
        this.f5802h = 15.0f;
        this.f5815u = new AnimatorSet();
        AnimatorSet animatorSet = null;
        while (i < this.f5809o) {
            AnimatorSet animatorSetM6647a = m6647a(i);
            AnimatorSet.Builder builderPlay = this.f5815u.play(animatorSetM6647a);
            if (animatorSet != null) {
                builderPlay.after(animatorSet);
            }
            i++;
            animatorSet = animatorSetM6647a;
        }
        this.f5815u.addListener(new AnimatorListenerAdapter() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.5

            /* JADX INFO: renamed from: a */
            boolean f5822a = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.f5822a = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.f5822a) {
                    CircularProgressView.this.m6658b();
                }
            }
        });
        this.f5815u.start();
        Iterator<CircularProgressViewListener> it = this.f5810p.iterator();
        while (it.hasNext()) {
            it.next().m6660a();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m6659c() {
        if (this.f5813s != null) {
            this.f5813s.cancel();
            this.f5813s = null;
        }
        if (this.f5814t != null) {
            this.f5814t.cancel();
            this.f5814t = null;
        }
        if (this.f5815u != null) {
            this.f5815u.cancel();
            this.f5815u = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private AnimatorSet m6647a(float f) {
        final float f2 = ((360.0f * (this.f5809o - 1)) / this.f5809o) + 15.0f;
        final float f3 = (-90.0f) + ((f2 - 15.0f) * f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(15.0f, f2);
        valueAnimatorOfFloat.setDuration((this.f5806l / this.f5809o) / 2);
        valueAnimatorOfFloat.setInterpolator(new DecelerateInterpolator(1.0f));
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressView.this.f5802h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressView.this.invalidate();
            }
        });
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat((f * 720.0f) / this.f5809o, ((0.5f + f) * 720.0f) / this.f5809o);
        valueAnimatorOfFloat2.setDuration((this.f5806l / this.f5809o) / 2);
        valueAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressView.this.f5803i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(f3, (f3 + f2) - 15.0f);
        valueAnimatorOfFloat3.setDuration((this.f5806l / this.f5809o) / 2);
        valueAnimatorOfFloat3.setInterpolator(new DecelerateInterpolator(1.0f));
        valueAnimatorOfFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.8
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressView.this.f5811q = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressView.this.f5802h = (f2 - CircularProgressView.this.f5811q) + f3;
                CircularProgressView.this.invalidate();
            }
        });
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(((0.5f + f) * 720.0f) / this.f5809o, ((1.0f + f) * 720.0f) / this.f5809o);
        valueAnimatorOfFloat4.setDuration((this.f5806l / this.f5809o) / 2);
        valueAnimatorOfFloat4.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.github.rahatarmanahmed.cpv.CircularProgressView.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                CircularProgressView.this.f5803i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(valueAnimatorOfFloat).with(valueAnimatorOfFloat2);
        animatorSet.play(valueAnimatorOfFloat3).with(valueAnimatorOfFloat4).after(valueAnimatorOfFloat2);
        return animatorSet;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f5799e) {
            m6656a();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m6659c();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        int visibility = getVisibility();
        super.setVisibility(i);
        if (i != visibility) {
            if (i == 0) {
                m6658b();
            } else if (i == 8 || i == 4) {
                m6659c();
            }
        }
    }
}
