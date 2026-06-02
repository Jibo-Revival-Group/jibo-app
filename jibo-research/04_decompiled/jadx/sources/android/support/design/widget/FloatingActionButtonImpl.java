package android.support.design.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
class FloatingActionButtonImpl {

    /* JADX INFO: renamed from: a */
    static final Interpolator f736a = AnimationUtils.f472c;

    /* JADX INFO: renamed from: j */
    static final int[] f737j = {R.attr.state_pressed, R.attr.state_enabled};

    /* JADX INFO: renamed from: k */
    static final int[] f738k = {R.attr.state_focused, R.attr.state_enabled};

    /* JADX INFO: renamed from: l */
    static final int[] f739l = {R.attr.state_enabled};

    /* JADX INFO: renamed from: m */
    static final int[] f740m = new int[0];

    /* JADX INFO: renamed from: c */
    ShadowDrawableWrapper f742c;

    /* JADX INFO: renamed from: d */
    Drawable f743d;

    /* JADX INFO: renamed from: e */
    Drawable f744e;

    /* JADX INFO: renamed from: f */
    CircularBorderDrawable f745f;

    /* JADX INFO: renamed from: g */
    Drawable f746g;

    /* JADX INFO: renamed from: h */
    float f747h;

    /* JADX INFO: renamed from: i */
    float f748i;

    /* JADX INFO: renamed from: n */
    final VisibilityAwareImageButton f749n;

    /* JADX INFO: renamed from: o */
    final ShadowViewDelegate f750o;

    /* JADX INFO: renamed from: q */
    private float f752q;

    /* JADX INFO: renamed from: s */
    private ViewTreeObserver.OnPreDrawListener f754s;

    /* JADX INFO: renamed from: b */
    int f741b = 0;

    /* JADX INFO: renamed from: r */
    private final Rect f753r = new Rect();

    /* JADX INFO: renamed from: p */
    private final StateListAnimator f751p = new StateListAnimator();

    interface InternalVisibilityChangedListener {
        /* JADX INFO: renamed from: a */
        void mo726a();

        /* JADX INFO: renamed from: b */
        void mo727b();
    }

    FloatingActionButtonImpl(VisibilityAwareImageButton visibilityAwareImageButton, ShadowViewDelegate shadowViewDelegate) {
        this.f749n = visibilityAwareImageButton;
        this.f750o = shadowViewDelegate;
        this.f751p.m830a(f737j, m742a(new ElevateToTranslationZAnimation()));
        this.f751p.m830a(f738k, m742a(new ElevateToTranslationZAnimation()));
        this.f751p.m830a(f739l, m742a(new ResetElevationAnimation()));
        this.f751p.m830a(f740m, m742a(new DisabledElevationAnimation()));
        this.f752q = this.f749n.getRotation();
    }

    /* JADX INFO: renamed from: a */
    void mo753a(ColorStateList colorStateList, PorterDuff.Mode mode, int i, int i2) {
        Drawable[] drawableArr;
        this.f743d = DrawableCompat.m2000g(m770k());
        DrawableCompat.m1989a(this.f743d, colorStateList);
        if (mode != null) {
            DrawableCompat.m1992a(this.f743d, mode);
        }
        this.f744e = DrawableCompat.m2000g(m770k());
        DrawableCompat.m1989a(this.f744e, m743b(i));
        if (i2 > 0) {
            this.f745f = m748a(i2, colorStateList);
            drawableArr = new Drawable[]{this.f745f, this.f743d, this.f744e};
        } else {
            this.f745f = null;
            drawableArr = new Drawable[]{this.f743d, this.f744e};
        }
        this.f746g = new LayerDrawable(drawableArr);
        this.f742c = new ShadowDrawableWrapper(this.f749n.getContext(), this.f746g, this.f750o.mo738a(), this.f747h, this.f747h + this.f748i);
        this.f742c.m801a(false);
        this.f750o.mo740a(this.f742c);
    }

    /* JADX INFO: renamed from: a */
    void m752a(ColorStateList colorStateList) {
        if (this.f743d != null) {
            DrawableCompat.m1989a(this.f743d, colorStateList);
        }
        if (this.f745f != null) {
            this.f745f.m563a(colorStateList);
        }
    }

    /* JADX INFO: renamed from: a */
    void m754a(PorterDuff.Mode mode) {
        if (this.f743d != null) {
            DrawableCompat.m1992a(this.f743d, mode);
        }
    }

    /* JADX INFO: renamed from: a */
    void mo751a(int i) {
        if (this.f744e != null) {
            DrawableCompat.m1989a(this.f744e, m743b(i));
        }
    }

    /* JADX INFO: renamed from: a */
    final void m749a(float f) {
        if (this.f747h != f) {
            this.f747h = f;
            mo750a(f, this.f748i);
        }
    }

    /* JADX INFO: renamed from: a */
    float mo747a() {
        return this.f747h;
    }

    /* JADX INFO: renamed from: b */
    final void m759b(float f) {
        if (this.f748i != f) {
            this.f748i = f;
            mo750a(this.f747h, f);
        }
    }

    /* JADX INFO: renamed from: a */
    void mo750a(float f, float f2) {
        if (this.f742c != null) {
            this.f742c.m800a(f, this.f748i + f);
            m764e();
        }
    }

    /* JADX INFO: renamed from: a */
    void mo757a(int[] iArr) {
        this.f751p.m829a(iArr);
    }

    /* JADX INFO: renamed from: b */
    void mo758b() {
        this.f751p.m828a();
    }

    /* JADX INFO: renamed from: a */
    void m756a(final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z) {
        if (!m773n()) {
            this.f749n.animate().cancel();
            if (m745p()) {
                this.f741b = 1;
                this.f749n.animate().scaleX(CropImageView.DEFAULT_ASPECT_RATIO).scaleY(CropImageView.DEFAULT_ASPECT_RATIO).alpha(CropImageView.DEFAULT_ASPECT_RATIO).setDuration(200L).setInterpolator(AnimationUtils.f472c).setListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.FloatingActionButtonImpl.1

                    /* JADX INFO: renamed from: d */
                    private boolean f758d;

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        FloatingActionButtonImpl.this.f749n.m951a(0, z);
                        this.f758d = false;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                        this.f758d = true;
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        FloatingActionButtonImpl.this.f741b = 0;
                        if (!this.f758d) {
                            FloatingActionButtonImpl.this.f749n.m951a(z ? 8 : 4, z);
                            if (internalVisibilityChangedListener != null) {
                                internalVisibilityChangedListener.mo727b();
                            }
                        }
                    }
                });
            } else {
                this.f749n.m951a(z ? 8 : 4, z);
                if (internalVisibilityChangedListener != null) {
                    internalVisibilityChangedListener.mo727b();
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m761b(final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z) {
        if (!m772m()) {
            this.f749n.animate().cancel();
            if (m745p()) {
                this.f741b = 2;
                if (this.f749n.getVisibility() != 0) {
                    this.f749n.setAlpha(CropImageView.DEFAULT_ASPECT_RATIO);
                    this.f749n.setScaleY(CropImageView.DEFAULT_ASPECT_RATIO);
                    this.f749n.setScaleX(CropImageView.DEFAULT_ASPECT_RATIO);
                }
                this.f749n.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200L).setInterpolator(AnimationUtils.f473d).setListener(new AnimatorListenerAdapter() { // from class: android.support.design.widget.FloatingActionButtonImpl.2
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                        FloatingActionButtonImpl.this.f749n.m951a(0, z);
                    }

                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        FloatingActionButtonImpl.this.f741b = 0;
                        if (internalVisibilityChangedListener != null) {
                            internalVisibilityChangedListener.mo726a();
                        }
                    }
                });
                return;
            }
            this.f749n.m951a(0, z);
            this.f749n.setAlpha(1.0f);
            this.f749n.setScaleY(1.0f);
            this.f749n.setScaleX(1.0f);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.mo726a();
            }
        }
    }

    /* JADX INFO: renamed from: c */
    final Drawable m762c() {
        return this.f746g;
    }

    /* JADX INFO: renamed from: d */
    void mo763d() {
    }

    /* JADX INFO: renamed from: e */
    final void m764e() {
        Rect rect = this.f753r;
        mo755a(rect);
        mo760b(rect);
        this.f750o.mo739a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: renamed from: a */
    void mo755a(Rect rect) {
        this.f742c.getPadding(rect);
    }

    /* JADX INFO: renamed from: b */
    void mo760b(Rect rect) {
    }

    /* JADX INFO: renamed from: f */
    void m765f() {
        if (mo767h()) {
            m744o();
            this.f749n.getViewTreeObserver().addOnPreDrawListener(this.f754s);
        }
    }

    /* JADX INFO: renamed from: g */
    void m766g() {
        if (this.f754s != null) {
            this.f749n.getViewTreeObserver().removeOnPreDrawListener(this.f754s);
            this.f754s = null;
        }
    }

    /* JADX INFO: renamed from: h */
    boolean mo767h() {
        return true;
    }

    /* JADX INFO: renamed from: a */
    CircularBorderDrawable m748a(int i, ColorStateList colorStateList) {
        Context context = this.f749n.getContext();
        CircularBorderDrawable circularBorderDrawableMo768i = mo768i();
        circularBorderDrawableMo768i.m562a(ContextCompat.m1840c(context, android.support.design.R.color.design_fab_stroke_top_outer_color), ContextCompat.m1840c(context, android.support.design.R.color.design_fab_stroke_top_inner_color), ContextCompat.m1840c(context, android.support.design.R.color.design_fab_stroke_end_inner_color), ContextCompat.m1840c(context, android.support.design.R.color.design_fab_stroke_end_outer_color));
        circularBorderDrawableMo768i.m561a(i);
        circularBorderDrawableMo768i.m563a(colorStateList);
        return circularBorderDrawableMo768i;
    }

    /* JADX INFO: renamed from: i */
    CircularBorderDrawable mo768i() {
        return new CircularBorderDrawable();
    }

    /* JADX INFO: renamed from: j */
    void m769j() {
        float rotation = this.f749n.getRotation();
        if (this.f752q != rotation) {
            this.f752q = rotation;
            m746q();
        }
    }

    /* JADX INFO: renamed from: o */
    private void m744o() {
        if (this.f754s == null) {
            this.f754s = new ViewTreeObserver.OnPreDrawListener() { // from class: android.support.design.widget.FloatingActionButtonImpl.3
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    FloatingActionButtonImpl.this.m769j();
                    return true;
                }
            };
        }
    }

    /* JADX INFO: renamed from: k */
    GradientDrawable m770k() {
        GradientDrawable gradientDrawableMo771l = mo771l();
        gradientDrawableMo771l.setShape(1);
        gradientDrawableMo771l.setColor(-1);
        return gradientDrawableMo771l;
    }

    /* JADX INFO: renamed from: l */
    GradientDrawable mo771l() {
        return new GradientDrawable();
    }

    /* JADX INFO: renamed from: m */
    boolean m772m() {
        return this.f749n.getVisibility() != 0 ? this.f741b == 2 : this.f741b != 1;
    }

    /* JADX INFO: renamed from: n */
    boolean m773n() {
        return this.f749n.getVisibility() == 0 ? this.f741b == 1 : this.f741b != 2;
    }

    /* JADX INFO: renamed from: a */
    private ValueAnimator m742a(ShadowAnimatorImpl shadowAnimatorImpl) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f736a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(shadowAnimatorImpl);
        valueAnimator.addUpdateListener(shadowAnimatorImpl);
        valueAnimator.setFloatValues(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        return valueAnimator;
    }

    private abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a */
        private boolean f766a;

        /* JADX INFO: renamed from: c */
        private float f768c;

        /* JADX INFO: renamed from: d */
        private float f769d;

        /* JADX INFO: renamed from: a */
        protected abstract float mo774a();

        private ShadowAnimatorImpl() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f766a) {
                this.f768c = FloatingActionButtonImpl.this.f742c.m798a();
                this.f769d = mo774a();
                this.f766a = true;
            }
            FloatingActionButtonImpl.this.f742c.m802b(this.f768c + ((this.f769d - this.f768c) * valueAnimator.getAnimatedFraction()));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl.this.f742c.m802b(this.f769d);
            this.f766a = false;
        }
    }

    private class ResetElevationAnimation extends ShadowAnimatorImpl {
        ResetElevationAnimation() {
            super();
        }

        @Override // android.support.design.widget.FloatingActionButtonImpl.ShadowAnimatorImpl
        /* JADX INFO: renamed from: a */
        protected float mo774a() {
            return FloatingActionButtonImpl.this.f747h;
        }
    }

    private class ElevateToTranslationZAnimation extends ShadowAnimatorImpl {
        ElevateToTranslationZAnimation() {
            super();
        }

        @Override // android.support.design.widget.FloatingActionButtonImpl.ShadowAnimatorImpl
        /* JADX INFO: renamed from: a */
        protected float mo774a() {
            return FloatingActionButtonImpl.this.f747h + FloatingActionButtonImpl.this.f748i;
        }
    }

    private class DisabledElevationAnimation extends ShadowAnimatorImpl {
        DisabledElevationAnimation() {
            super();
        }

        @Override // android.support.design.widget.FloatingActionButtonImpl.ShadowAnimatorImpl
        /* JADX INFO: renamed from: a */
        protected float mo774a() {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
    }

    /* JADX INFO: renamed from: b */
    private static ColorStateList m743b(int i) {
        return new ColorStateList(new int[][]{f738k, f737j, new int[0]}, new int[]{i, i, 0});
    }

    /* JADX INFO: renamed from: p */
    private boolean m745p() {
        return ViewCompat.m2621y(this.f749n) && !this.f749n.isInEditMode();
    }

    /* JADX INFO: renamed from: q */
    private void m746q() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.f752q % 90.0f != CropImageView.DEFAULT_ASPECT_RATIO) {
                if (this.f749n.getLayerType() != 1) {
                    this.f749n.setLayerType(1, null);
                }
            } else if (this.f749n.getLayerType() != 0) {
                this.f749n.setLayerType(0, null);
            }
        }
        if (this.f742c != null) {
            this.f742c.m799a(-this.f752q);
        }
        if (this.f745f != null) {
            this.f745f.m564b(-this.f752q);
        }
    }
}
