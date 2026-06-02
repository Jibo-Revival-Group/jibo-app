package android.support.v4.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.Preconditions;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {

    /* JADX INFO: renamed from: a */
    private static final Interpolator f2524a = new LinearInterpolator();

    /* JADX INFO: renamed from: b */
    private static final Interpolator f2525b = new FastOutSlowInInterpolator();

    /* JADX INFO: renamed from: c */
    private static final int[] f2526c = {-16777216};

    /* JADX INFO: renamed from: d */
    private final Ring f2527d = new Ring();

    /* JADX INFO: renamed from: e */
    private float f2528e;

    /* JADX INFO: renamed from: f */
    private Resources f2529f;

    /* JADX INFO: renamed from: g */
    private Animator f2530g;

    /* JADX INFO: renamed from: h */
    private float f2531h;

    /* JADX INFO: renamed from: i */
    private boolean f2532i;

    public CircularProgressDrawable(Context context) {
        this.f2529f = ((Context) Preconditions.m2441a(context)).getResources();
        this.f2527d.m2909a(f2526c);
        m2894a(2.5f);
        m2883a();
    }

    /* JADX INFO: renamed from: a */
    private void m2884a(float f, float f2, float f3, float f4) {
        Ring ring = this.f2527d;
        float f5 = this.f2529f.getDisplayMetrics().density;
        ring.m2902a(f2 * f5);
        ring.m2919e(f * f5);
        ring.m2912b(0);
        ring.m2903a(f3 * f5, f5 * f4);
    }

    /* JADX INFO: renamed from: a */
    public void m2896a(int i) {
        if (i == 0) {
            m2884a(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            m2884a(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    /* JADX INFO: renamed from: a */
    public void m2894a(float f) {
        this.f2527d.m2902a(f);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: a */
    public void m2897a(boolean z) {
        this.f2527d.m2908a(z);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: b */
    public void m2899b(float f) {
        this.f2527d.m2921f(f);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: a */
    public void m2895a(float f, float f2) {
        this.f2527d.m2911b(f);
        this.f2527d.m2914c(f2);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: c */
    public void m2900c(float f) {
        this.f2527d.m2917d(f);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: a */
    public void m2898a(int... iArr) {
        this.f2527d.m2909a(iArr);
        this.f2527d.m2912b(0);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f2528e, bounds.exactCenterX(), bounds.exactCenterY());
        this.f2527d.m2906a(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f2527d.m2915c(i);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2527d.m2916d();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2527d.m2907a(colorFilter);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: d */
    private void m2893d(float f) {
        this.f2528e = f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f2530g.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f2530g.cancel();
        this.f2527d.m2926k();
        if (this.f2527d.m2924i() != this.f2527d.m2918e()) {
            this.f2532i = true;
            this.f2530g.setDuration(666L);
            this.f2530g.start();
        } else {
            this.f2527d.m2912b(0);
            this.f2527d.m2927l();
            this.f2530g.setDuration(1332L);
            this.f2530g.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f2530g.cancel();
        m2893d(CropImageView.DEFAULT_ASPECT_RATIO);
        this.f2527d.m2908a(false);
        this.f2527d.m2912b(0);
        this.f2527d.m2927l();
        invalidateSelf();
    }

    /* JADX INFO: renamed from: a */
    private int m2882a(float f, int i, int i2) {
        return ((((i >> 24) & 255) + ((int) ((((i2 >> 24) & 255) - r0) * f))) << 24) | ((((i >> 16) & 255) + ((int) ((((i2 >> 16) & 255) - r1) * f))) << 16) | ((((int) ((((i2 >> 8) & 255) - r2) * f)) + ((i >> 8) & 255)) << 8) | (((int) (((i2 & 255) - r3) * f)) + (i & 255));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m2885a(float f, Ring ring) {
        if (f > 0.75f) {
            ring.m2904a(m2882a((f - 0.75f) / 0.25f, ring.m2923h(), ring.m2901a()));
        } else {
            ring.m2904a(ring.m2923h());
        }
    }

    /* JADX INFO: renamed from: b */
    private void m2892b(float f, Ring ring) {
        m2885a(f, ring);
        float fFloor = (float) (Math.floor(ring.m2925j() / 0.8f) + 1.0d);
        ring.m2911b(ring.m2920f() + (((ring.m2922g() - 0.01f) - ring.m2920f()) * f));
        ring.m2914c(ring.m2922g());
        ring.m2917d(((fFloor - ring.m2925j()) * f) + ring.m2925j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m2886a(float f, Ring ring, boolean z) {
        float fM2920f;
        float interpolation;
        if (this.f2532i) {
            m2892b(f, ring);
            return;
        }
        if (f != 1.0f || z) {
            float fM2925j = ring.m2925j();
            if (f < 0.5f) {
                interpolation = ring.m2920f();
                fM2920f = (f2525b.getInterpolation(f / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                fM2920f = ring.m2920f() + 0.79f;
                interpolation = fM2920f - (((1.0f - f2525b.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            float f2 = 216.0f * (this.f2531h + f);
            ring.m2911b(interpolation);
            ring.m2914c(fM2920f);
            ring.m2917d(fM2925j + (0.20999998f * f));
            m2893d(f2);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2883a() {
        final Ring ring = this.f2527d;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.v4.widget.CircularProgressDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.this.m2885a(fFloatValue, ring);
                CircularProgressDrawable.this.m2886a(fFloatValue, ring, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setRepeatMode(1);
        valueAnimatorOfFloat.setInterpolator(f2524a);
        valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: android.support.v4.widget.CircularProgressDrawable.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.f2531h = CropImageView.DEFAULT_ASPECT_RATIO;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.m2886a(1.0f, ring, true);
                ring.m2926k();
                ring.m2913c();
                if (CircularProgressDrawable.this.f2532i) {
                    CircularProgressDrawable.this.f2532i = false;
                    animator.cancel();
                    animator.setDuration(1332L);
                    animator.start();
                    ring.m2908a(false);
                    return;
                }
                CircularProgressDrawable.this.f2531h += 1.0f;
            }
        });
        this.f2530g = valueAnimatorOfFloat;
    }

    private static class Ring {

        /* JADX INFO: renamed from: i */
        int[] f2545i;

        /* JADX INFO: renamed from: j */
        int f2546j;

        /* JADX INFO: renamed from: k */
        float f2547k;

        /* JADX INFO: renamed from: l */
        float f2548l;

        /* JADX INFO: renamed from: m */
        float f2549m;

        /* JADX INFO: renamed from: n */
        boolean f2550n;

        /* JADX INFO: renamed from: o */
        Path f2551o;

        /* JADX INFO: renamed from: q */
        float f2553q;

        /* JADX INFO: renamed from: r */
        int f2554r;

        /* JADX INFO: renamed from: s */
        int f2555s;

        /* JADX INFO: renamed from: u */
        int f2557u;

        /* JADX INFO: renamed from: a */
        final RectF f2537a = new RectF();

        /* JADX INFO: renamed from: b */
        final Paint f2538b = new Paint();

        /* JADX INFO: renamed from: c */
        final Paint f2539c = new Paint();

        /* JADX INFO: renamed from: d */
        final Paint f2540d = new Paint();

        /* JADX INFO: renamed from: e */
        float f2541e = CropImageView.DEFAULT_ASPECT_RATIO;

        /* JADX INFO: renamed from: f */
        float f2542f = CropImageView.DEFAULT_ASPECT_RATIO;

        /* JADX INFO: renamed from: g */
        float f2543g = CropImageView.DEFAULT_ASPECT_RATIO;

        /* JADX INFO: renamed from: h */
        float f2544h = 5.0f;

        /* JADX INFO: renamed from: p */
        float f2552p = 1.0f;

        /* JADX INFO: renamed from: t */
        int f2556t = 255;

        Ring() {
            this.f2538b.setStrokeCap(Paint.Cap.SQUARE);
            this.f2538b.setAntiAlias(true);
            this.f2538b.setStyle(Paint.Style.STROKE);
            this.f2539c.setStyle(Paint.Style.FILL);
            this.f2539c.setAntiAlias(true);
            this.f2540d.setColor(0);
        }

        /* JADX INFO: renamed from: a */
        void m2903a(float f, float f2) {
            this.f2554r = (int) f;
            this.f2555s = (int) f2;
        }

        /* JADX INFO: renamed from: a */
        void m2906a(Canvas canvas, Rect rect) {
            RectF rectF = this.f2537a;
            float fMin = this.f2553q + (this.f2544h / 2.0f);
            if (this.f2553q <= CropImageView.DEFAULT_ASPECT_RATIO) {
                fMin = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.f2554r * this.f2552p) / 2.0f, this.f2544h / 2.0f);
            }
            rectF.set(rect.centerX() - fMin, rect.centerY() - fMin, rect.centerX() + fMin, fMin + rect.centerY());
            float f = (this.f2541e + this.f2543g) * 360.0f;
            float f2 = ((this.f2542f + this.f2543g) * 360.0f) - f;
            this.f2538b.setColor(this.f2557u);
            this.f2538b.setAlpha(this.f2556t);
            float f3 = this.f2544h / 2.0f;
            rectF.inset(f3, f3);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.f2540d);
            rectF.inset(-f3, -f3);
            canvas.drawArc(rectF, f, f2, false, this.f2538b);
            m2905a(canvas, f, f2, rectF);
        }

        /* JADX INFO: renamed from: a */
        void m2905a(Canvas canvas, float f, float f2, RectF rectF) {
            if (this.f2550n) {
                if (this.f2551o == null) {
                    this.f2551o = new Path();
                    this.f2551o.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    this.f2551o.reset();
                }
                float fMin = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f3 = (this.f2554r * this.f2552p) / 2.0f;
                this.f2551o.moveTo(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                this.f2551o.lineTo(this.f2554r * this.f2552p, CropImageView.DEFAULT_ASPECT_RATIO);
                this.f2551o.lineTo((this.f2554r * this.f2552p) / 2.0f, this.f2555s * this.f2552p);
                this.f2551o.offset((fMin + rectF.centerX()) - f3, rectF.centerY() + (this.f2544h / 2.0f));
                this.f2551o.close();
                this.f2539c.setColor(this.f2557u);
                this.f2539c.setAlpha(this.f2556t);
                canvas.save();
                canvas.rotate(f + f2, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.f2551o, this.f2539c);
                canvas.restore();
            }
        }

        /* JADX INFO: renamed from: a */
        void m2909a(int[] iArr) {
            this.f2545i = iArr;
            m2912b(0);
        }

        /* JADX INFO: renamed from: a */
        void m2904a(int i) {
            this.f2557u = i;
        }

        /* JADX INFO: renamed from: b */
        void m2912b(int i) {
            this.f2546j = i;
            this.f2557u = this.f2545i[this.f2546j];
        }

        /* JADX INFO: renamed from: a */
        int m2901a() {
            return this.f2545i[m2910b()];
        }

        /* JADX INFO: renamed from: b */
        int m2910b() {
            return (this.f2546j + 1) % this.f2545i.length;
        }

        /* JADX INFO: renamed from: c */
        void m2913c() {
            m2912b(m2910b());
        }

        /* JADX INFO: renamed from: a */
        void m2907a(ColorFilter colorFilter) {
            this.f2538b.setColorFilter(colorFilter);
        }

        /* JADX INFO: renamed from: c */
        void m2915c(int i) {
            this.f2556t = i;
        }

        /* JADX INFO: renamed from: d */
        int m2916d() {
            return this.f2556t;
        }

        /* JADX INFO: renamed from: a */
        void m2902a(float f) {
            this.f2544h = f;
            this.f2538b.setStrokeWidth(f);
        }

        /* JADX INFO: renamed from: b */
        void m2911b(float f) {
            this.f2541e = f;
        }

        /* JADX INFO: renamed from: e */
        float m2918e() {
            return this.f2541e;
        }

        /* JADX INFO: renamed from: f */
        float m2920f() {
            return this.f2547k;
        }

        /* JADX INFO: renamed from: g */
        float m2922g() {
            return this.f2548l;
        }

        /* JADX INFO: renamed from: h */
        int m2923h() {
            return this.f2545i[this.f2546j];
        }

        /* JADX INFO: renamed from: c */
        void m2914c(float f) {
            this.f2542f = f;
        }

        /* JADX INFO: renamed from: i */
        float m2924i() {
            return this.f2542f;
        }

        /* JADX INFO: renamed from: d */
        void m2917d(float f) {
            this.f2543g = f;
        }

        /* JADX INFO: renamed from: e */
        void m2919e(float f) {
            this.f2553q = f;
        }

        /* JADX INFO: renamed from: a */
        void m2908a(boolean z) {
            if (this.f2550n != z) {
                this.f2550n = z;
            }
        }

        /* JADX INFO: renamed from: f */
        void m2921f(float f) {
            if (f != this.f2552p) {
                this.f2552p = f;
            }
        }

        /* JADX INFO: renamed from: j */
        float m2925j() {
            return this.f2549m;
        }

        /* JADX INFO: renamed from: k */
        void m2926k() {
            this.f2547k = this.f2541e;
            this.f2548l = this.f2542f;
            this.f2549m = this.f2543g;
        }

        /* JADX INFO: renamed from: l */
        void m2927l() {
            this.f2547k = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2548l = CropImageView.DEFAULT_ASPECT_RATIO;
            this.f2549m = CropImageView.DEFAULT_ASPECT_RATIO;
            m2911b(CropImageView.DEFAULT_ASPECT_RATIO);
            m2914c(CropImageView.DEFAULT_ASPECT_RATIO);
            m2917d(CropImageView.DEFAULT_ASPECT_RATIO);
        }
    }
}
