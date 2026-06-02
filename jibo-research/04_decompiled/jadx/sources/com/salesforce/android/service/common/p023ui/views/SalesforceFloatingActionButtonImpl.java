package com.salesforce.android.service.common.p023ui.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Interpolator;
import com.salesforce.android.service.common.p023ui.R;
import com.salesforce.android.service.common.p023ui.internal.utils.DrawableUtils;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
class SalesforceFloatingActionButtonImpl {

    /* JADX INFO: renamed from: a */
    final View f13749a;

    /* JADX INFO: renamed from: b */
    GradientDrawable f13750b;

    /* JADX INFO: renamed from: c */
    GradientDrawable f13751c;

    /* JADX INFO: renamed from: d */
    GradientDrawable f13752d;

    /* JADX INFO: renamed from: e */
    Path f13753e = new Path();

    /* JADX INFO: renamed from: f */
    Drawable f13754f;

    /* JADX INFO: renamed from: g */
    Drawable f13755g;

    /* JADX INFO: renamed from: h */
    Drawable f13756h;

    /* JADX INFO: renamed from: i */
    int f13757i;

    /* JADX INFO: renamed from: j */
    int f13758j;

    /* JADX INFO: renamed from: k */
    int f13759k;

    /* JADX INFO: renamed from: l */
    Interpolator f13760l;

    /* JADX INFO: renamed from: m */
    ValueAnimator f13761m;

    /* JADX INFO: renamed from: n */
    ValueAnimator f13762n;

    /* JADX INFO: renamed from: o */
    private int f13763o;

    /* JADX INFO: renamed from: p */
    private int f13764p;

    /* JADX INFO: renamed from: q */
    private int f13765q;

    SalesforceFloatingActionButtonImpl(Builder builder) {
        this.f13749a = builder.f13774a;
        this.f13749a.setWillNotDraw(false);
        this.f13749a.setBackgroundColor(0);
        this.f13764p = this.f13749a.getResources().getDimensionPixelSize(R.dimen.salesforce_fab_default_icon_size);
        this.f13765q = this.f13749a.getResources().getDimensionPixelSize(R.dimen.salesforce_fab_elevation);
        this.f13760l = new FastOutSlowInInterpolator();
        this.f13750b = m14017a(builder.f13775b);
        this.f13751c = m14017a(builder.f13776c);
        this.f13752d = m14017a(builder.f13775b);
        this.f13757i = builder.f13777d;
        this.f13758j = builder.f13778e;
        this.f13755g = builder.f13779f;
        this.f13756h = builder.f13780g;
        m14024a(this.f13755g, this.f13757i);
    }

    /* JADX INFO: renamed from: a */
    void m14022a(int i, int i2) {
        this.f13763o = Math.min(i, i2);
        this.f13750b.setBounds(0, 0, this.f13763o, this.f13763o);
        this.f13755g.setBounds(m14019b(this.f13763o, this.f13764p));
        this.f13753e.addOval(new RectF(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, this.f13763o, this.f13763o), Path.Direction.CW);
        m14020b(this.f13763o);
        m14024a(this.f13754f, this.f13759k);
    }

    /* JADX INFO: renamed from: a */
    void m14024a(Drawable drawable, int i) {
        this.f13754f = drawable;
        this.f13759k = i;
        this.f13754f.setBounds(m14019b(this.f13763o, this.f13764p));
        DrawableUtils.m14012a(this.f13754f, this.f13759k);
    }

    /* JADX INFO: renamed from: a */
    void m14023a(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            canvas.clipPath(this.f13753e);
        }
        this.f13750b.draw(canvas);
        this.f13751c.draw(canvas);
        this.f13752d.draw(canvas);
        this.f13754f.draw(canvas);
    }

    /* JADX INFO: renamed from: a */
    Animator m14021a(final Coordinate coordinate) {
        if (this.f13761m != null && this.f13761m.isRunning()) {
            this.f13761m.cancel();
        }
        this.f13761m = m14016a();
        this.f13761m.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.salesforce.android.service.common.ui.views.SalesforceFloatingActionButtonImpl.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SalesforceFloatingActionButtonImpl.this.m14025a(SalesforceFloatingActionButtonImpl.this.f13751c, SalesforceFloatingActionButtonImpl.this.m14027c(coordinate), ((Float) SalesforceFloatingActionButtonImpl.this.f13761m.getAnimatedValue()).floatValue());
                SalesforceFloatingActionButtonImpl.this.f13749a.invalidate();
            }
        });
        this.f13761m.addListener(new AnimatorListenerAdapter() { // from class: com.salesforce.android.service.common.ui.views.SalesforceFloatingActionButtonImpl.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                SalesforceFloatingActionButtonImpl.this.m14024a(SalesforceFloatingActionButtonImpl.this.f13756h, SalesforceFloatingActionButtonImpl.this.f13758j);
            }
        });
        return this.f13761m;
    }

    /* JADX INFO: renamed from: b */
    Animator m14026b(final Coordinate coordinate) {
        if (this.f13762n != null && this.f13762n.isRunning()) {
            this.f13762n.cancel();
        }
        this.f13762n = m14016a();
        this.f13762n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.salesforce.android.service.common.ui.views.SalesforceFloatingActionButtonImpl.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SalesforceFloatingActionButtonImpl.this.m14025a(SalesforceFloatingActionButtonImpl.this.f13752d, SalesforceFloatingActionButtonImpl.this.m14027c(coordinate), ((Float) valueAnimator.getAnimatedValue()).floatValue());
                SalesforceFloatingActionButtonImpl.this.f13749a.invalidate();
            }
        });
        this.f13762n.addListener(new AnimatorListenerAdapter() { // from class: com.salesforce.android.service.common.ui.views.SalesforceFloatingActionButtonImpl.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SalesforceFloatingActionButtonImpl.this.f13751c.setBounds(0, 0, 0, 0);
                SalesforceFloatingActionButtonImpl.this.f13752d.setBounds(0, 0, 0, 0);
                SalesforceFloatingActionButtonImpl.this.m14024a(SalesforceFloatingActionButtonImpl.this.f13755g, SalesforceFloatingActionButtonImpl.this.f13757i);
                SalesforceFloatingActionButtonImpl.this.f13749a.invalidate();
            }
        });
        return this.f13762n;
    }

    /* JADX INFO: renamed from: a */
    private GradientDrawable m14017a(int i) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(i);
        return gradientDrawable;
    }

    /* JADX INFO: renamed from: a */
    private ValueAnimator m14016a() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        valueAnimatorOfFloat.setDuration(250L).setInterpolator(this.f13760l);
        return valueAnimatorOfFloat;
    }

    /* JADX INFO: renamed from: a */
    void m14025a(Drawable drawable, Coordinate coordinate, float f) {
        int iMax;
        if (Build.VERSION.SDK_INT >= 21) {
            iMax = Math.max(coordinate.m14209a(), coordinate.m14210b()) + Math.round(this.f13763o * 1.2f);
        } else {
            iMax = this.f13763o;
        }
        int iRound = Math.round(iMax * f);
        int iRound2 = Math.round(iMax * f);
        drawable.setBounds(coordinate.m14209a() - (iRound / 2), coordinate.m14210b() - (iRound2 / 2), iRound, iRound2);
    }

    /* JADX INFO: renamed from: c */
    Coordinate m14027c(Coordinate coordinate) {
        return Build.VERSION.SDK_INT >= 21 ? coordinate : Coordinate.m14208a(this.f13763o / 2, this.f13763o / 2);
    }

    /* JADX INFO: renamed from: b */
    private Rect m14019b(int i, int i2) {
        return new Rect((i / 2) - (i2 / 2), (i / 2) - (i2 / 2), (i / 2) + (i2 / 2), (i / 2) + (i2 / 2));
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: b */
    private void m14020b(final int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f13749a.setOutlineProvider(new ViewOutlineProvider() { // from class: com.salesforce.android.service.common.ui.views.SalesforceFloatingActionButtonImpl.5
                @Override // android.view.ViewOutlineProvider
                @TargetApi(21)
                public void getOutline(View view, Outline outline) {
                    outline.setOval(new Rect(0, 0, i, i));
                }
            });
            this.f13749a.setElevation(this.f13765q);
        }
    }

    /* JADX INFO: renamed from: a */
    static Builder m14018a(View view) {
        return new Builder(view);
    }

    static class Builder {

        /* JADX INFO: renamed from: a */
        final View f13774a;

        /* JADX INFO: renamed from: b */
        int f13775b;

        /* JADX INFO: renamed from: c */
        int f13776c;

        /* JADX INFO: renamed from: d */
        int f13777d;

        /* JADX INFO: renamed from: e */
        int f13778e;

        /* JADX INFO: renamed from: f */
        Drawable f13779f;

        /* JADX INFO: renamed from: g */
        Drawable f13780g;

        public Builder(View view) {
            this.f13774a = view;
        }

        /* JADX INFO: renamed from: a */
        public Builder m14028a(int i) {
            this.f13775b = i;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m14031b(int i) {
            this.f13776c = i;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public Builder m14033c(int i) {
            this.f13777d = i;
            return this;
        }

        /* JADX INFO: renamed from: d */
        public Builder m14034d(int i) {
            this.f13778e = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m14029a(Drawable drawable) {
            this.f13779f = drawable;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public Builder m14032b(Drawable drawable) {
            this.f13780g = drawable;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public SalesforceFloatingActionButtonImpl m14030a() {
            if (this.f13780g == null) {
                this.f13780g = this.f13779f;
            }
            return new SalesforceFloatingActionButtonImpl(this);
        }
    }
}
