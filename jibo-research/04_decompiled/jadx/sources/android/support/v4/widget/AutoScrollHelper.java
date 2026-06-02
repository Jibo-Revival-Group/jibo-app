package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {

    /* JADX INFO: renamed from: r */
    private static final int f2488r = ViewConfiguration.getTapTimeout();

    /* JADX INFO: renamed from: b */
    final View f2490b;

    /* JADX INFO: renamed from: c */
    boolean f2491c;

    /* JADX INFO: renamed from: d */
    boolean f2492d;

    /* JADX INFO: renamed from: e */
    boolean f2493e;

    /* JADX INFO: renamed from: g */
    private Runnable f2495g;

    /* JADX INFO: renamed from: j */
    private int f2498j;

    /* JADX INFO: renamed from: k */
    private int f2499k;

    /* JADX INFO: renamed from: o */
    private boolean f2503o;

    /* JADX INFO: renamed from: p */
    private boolean f2504p;

    /* JADX INFO: renamed from: q */
    private boolean f2505q;

    /* JADX INFO: renamed from: a */
    final ClampedScroller f2489a = new ClampedScroller();

    /* JADX INFO: renamed from: f */
    private final Interpolator f2494f = new AccelerateInterpolator();

    /* JADX INFO: renamed from: h */
    private float[] f2496h = {CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO};

    /* JADX INFO: renamed from: i */
    private float[] f2497i = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: l */
    private float[] f2500l = {CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO};

    /* JADX INFO: renamed from: m */
    private float[] f2501m = {CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO};

    /* JADX INFO: renamed from: n */
    private float[] f2502n = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: renamed from: a */
    public abstract void mo2853a(int i, int i2);

    /* JADX INFO: renamed from: e */
    public abstract boolean mo2863e(int i);

    /* JADX INFO: renamed from: f */
    public abstract boolean mo2864f(int i);

    public AutoScrollHelper(View view) {
        this.f2490b = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        m2850a(i, i);
        m2855b(i2, i2);
        m2851a(1);
        m2862e(Float.MAX_VALUE, Float.MAX_VALUE);
        m2860d(0.2f, 0.2f);
        m2858c(1.0f, 1.0f);
        m2856b(f2488r);
        m2859c(500);
        m2861d(500);
    }

    /* JADX INFO: renamed from: a */
    public AutoScrollHelper m2852a(boolean z) {
        if (this.f2504p && !z) {
            m2848d();
        }
        this.f2504p = z;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public AutoScrollHelper m2850a(float f, float f2) {
        this.f2502n[0] = f / 1000.0f;
        this.f2502n[1] = f2 / 1000.0f;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public AutoScrollHelper m2855b(float f, float f2) {
        this.f2501m[0] = f / 1000.0f;
        this.f2501m[1] = f2 / 1000.0f;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public AutoScrollHelper m2858c(float f, float f2) {
        this.f2500l[0] = f / 1000.0f;
        this.f2500l[1] = f2 / 1000.0f;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public AutoScrollHelper m2851a(int i) {
        this.f2498j = i;
        return this;
    }

    /* JADX INFO: renamed from: d */
    public AutoScrollHelper m2860d(float f, float f2) {
        this.f2496h[0] = f;
        this.f2496h[1] = f2;
        return this;
    }

    /* JADX INFO: renamed from: e */
    public AutoScrollHelper m2862e(float f, float f2) {
        this.f2497i[0] = f;
        this.f2497i[1] = f2;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public AutoScrollHelper m2856b(int i) {
        this.f2499k = i;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public AutoScrollHelper m2859c(int i) {
        this.f2489a.m2869a(i);
        return this;
    }

    /* JADX INFO: renamed from: d */
    public AutoScrollHelper m2861d(int i) {
        this.f2489a.m2871b(i);
        return this;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f2504p) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f2492d = true;
                this.f2503o = false;
                this.f2489a.m2868a(m2845a(0, motionEvent.getX(), view.getWidth(), this.f2490b.getWidth()), m2845a(1, motionEvent.getY(), view.getHeight(), this.f2490b.getHeight()));
                if (!this.f2493e && m2854a()) {
                    m2847c();
                }
                break;
            case 1:
            case 3:
                m2848d();
                break;
            case 2:
                this.f2489a.m2868a(m2845a(0, motionEvent.getX(), view.getWidth(), this.f2490b.getWidth()), m2845a(1, motionEvent.getY(), view.getHeight(), this.f2490b.getHeight()));
                if (!this.f2493e) {
                    m2847c();
                }
                break;
        }
        return this.f2505q && this.f2493e;
    }

    /* JADX INFO: renamed from: a */
    boolean m2854a() {
        ClampedScroller clampedScroller = this.f2489a;
        int iM2875f = clampedScroller.m2875f();
        int iM2874e = clampedScroller.m2874e();
        return (iM2875f != 0 && mo2864f(iM2875f)) || (iM2874e != 0 && mo2863e(iM2874e));
    }

    /* JADX INFO: renamed from: c */
    private void m2847c() {
        if (this.f2495g == null) {
            this.f2495g = new ScrollAnimationRunnable();
        }
        this.f2493e = true;
        this.f2491c = true;
        if (!this.f2503o && this.f2499k > 0) {
            ViewCompat.m2587a(this.f2490b, this.f2495g, this.f2499k);
        } else {
            this.f2495g.run();
        }
        this.f2503o = true;
    }

    /* JADX INFO: renamed from: d */
    private void m2848d() {
        if (this.f2491c) {
            this.f2493e = false;
        } else {
            this.f2489a.m2870b();
        }
    }

    /* JADX INFO: renamed from: a */
    private float m2845a(int i, float f, float f2, float f3) {
        float fM2844a = m2844a(this.f2496h[i], f2, this.f2497i[i], f);
        if (fM2844a == CropImageView.DEFAULT_ASPECT_RATIO) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        float f4 = this.f2500l[i];
        float f5 = this.f2501m[i];
        float f6 = this.f2502n[i];
        float f7 = f4 * f3;
        if (fM2844a > CropImageView.DEFAULT_ASPECT_RATIO) {
            return m2843a(fM2844a * f7, f5, f6);
        }
        return -m2843a((-fM2844a) * f7, f5, f6);
    }

    /* JADX INFO: renamed from: a */
    private float m2844a(float f, float f2, float f3, float f4) {
        float interpolation;
        float fM2843a = m2843a(f * f2, CropImageView.DEFAULT_ASPECT_RATIO, f3);
        float fM2849f = m2849f(f2 - f4, fM2843a) - m2849f(f4, fM2843a);
        if (fM2849f < CropImageView.DEFAULT_ASPECT_RATIO) {
            interpolation = -this.f2494f.getInterpolation(-fM2849f);
        } else {
            if (fM2849f <= CropImageView.DEFAULT_ASPECT_RATIO) {
                return CropImageView.DEFAULT_ASPECT_RATIO;
            }
            interpolation = this.f2494f.getInterpolation(fM2849f);
        }
        return m2843a(interpolation, -1.0f, 1.0f);
    }

    /* JADX INFO: renamed from: f */
    private float m2849f(float f, float f2) {
        if (f2 == CropImageView.DEFAULT_ASPECT_RATIO) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }
        switch (this.f2498j) {
            case 0:
            case 1:
                if (f < f2) {
                    if (f >= CropImageView.DEFAULT_ASPECT_RATIO) {
                        break;
                    } else if (this.f2493e && this.f2498j == 1) {
                        break;
                    }
                }
                break;
            case 2:
                if (f < CropImageView.DEFAULT_ASPECT_RATIO) {
                }
                break;
        }
        return CropImageView.DEFAULT_ASPECT_RATIO;
    }

    /* JADX INFO: renamed from: a */
    static int m2846a(int i, int i2, int i3) {
        if (i > i3) {
            return i3;
        }
        return i < i2 ? i2 : i;
    }

    /* JADX INFO: renamed from: a */
    static float m2843a(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        return f < f2 ? f2 : f;
    }

    /* JADX INFO: renamed from: b */
    void m2857b() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0);
        this.f2490b.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private class ScrollAnimationRunnable implements Runnable {
        ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AutoScrollHelper.this.f2493e) {
                if (AutoScrollHelper.this.f2491c) {
                    AutoScrollHelper.this.f2491c = false;
                    AutoScrollHelper.this.f2489a.m2867a();
                }
                ClampedScroller clampedScroller = AutoScrollHelper.this.f2489a;
                if (clampedScroller.m2872c() || !AutoScrollHelper.this.m2854a()) {
                    AutoScrollHelper.this.f2493e = false;
                    return;
                }
                if (AutoScrollHelper.this.f2492d) {
                    AutoScrollHelper.this.f2492d = false;
                    AutoScrollHelper.this.m2857b();
                }
                clampedScroller.m2873d();
                AutoScrollHelper.this.mo2853a(clampedScroller.m2876g(), clampedScroller.m2877h());
                ViewCompat.m2586a(AutoScrollHelper.this.f2490b, this);
            }
        }
    }

    private static class ClampedScroller {

        /* JADX INFO: renamed from: a */
        private int f2506a;

        /* JADX INFO: renamed from: b */
        private int f2507b;

        /* JADX INFO: renamed from: c */
        private float f2508c;

        /* JADX INFO: renamed from: d */
        private float f2509d;

        /* JADX INFO: renamed from: j */
        private float f2515j;

        /* JADX INFO: renamed from: k */
        private int f2516k;

        /* JADX INFO: renamed from: e */
        private long f2510e = Long.MIN_VALUE;

        /* JADX INFO: renamed from: i */
        private long f2514i = -1;

        /* JADX INFO: renamed from: f */
        private long f2511f = 0;

        /* JADX INFO: renamed from: g */
        private int f2512g = 0;

        /* JADX INFO: renamed from: h */
        private int f2513h = 0;

        ClampedScroller() {
        }

        /* JADX INFO: renamed from: a */
        public void m2869a(int i) {
            this.f2506a = i;
        }

        /* JADX INFO: renamed from: b */
        public void m2871b(int i) {
            this.f2507b = i;
        }

        /* JADX INFO: renamed from: a */
        public void m2867a() {
            this.f2510e = AnimationUtils.currentAnimationTimeMillis();
            this.f2514i = -1L;
            this.f2511f = this.f2510e;
            this.f2515j = 0.5f;
            this.f2512g = 0;
            this.f2513h = 0;
        }

        /* JADX INFO: renamed from: b */
        public void m2870b() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f2516k = AutoScrollHelper.m2846a((int) (jCurrentAnimationTimeMillis - this.f2510e), 0, this.f2507b);
            this.f2515j = m2866a(jCurrentAnimationTimeMillis);
            this.f2514i = jCurrentAnimationTimeMillis;
        }

        /* JADX INFO: renamed from: c */
        public boolean m2872c() {
            return this.f2514i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f2514i + ((long) this.f2516k);
        }

        /* JADX INFO: renamed from: a */
        private float m2866a(long j) {
            if (j < this.f2510e) {
                return CropImageView.DEFAULT_ASPECT_RATIO;
            }
            if (this.f2514i < 0 || j < this.f2514i) {
                return AutoScrollHelper.m2843a((j - this.f2510e) / this.f2506a, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f) * 0.5f;
            }
            return (AutoScrollHelper.m2843a((j - this.f2514i) / this.f2516k, CropImageView.DEFAULT_ASPECT_RATIO, 1.0f) * this.f2515j) + (1.0f - this.f2515j);
        }

        /* JADX INFO: renamed from: a */
        private float m2865a(float f) {
            return ((-4.0f) * f * f) + (4.0f * f);
        }

        /* JADX INFO: renamed from: d */
        public void m2873d() {
            if (this.f2511f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fM2865a = m2865a(m2866a(jCurrentAnimationTimeMillis));
            long j = jCurrentAnimationTimeMillis - this.f2511f;
            this.f2511f = jCurrentAnimationTimeMillis;
            this.f2512g = (int) (j * fM2865a * this.f2508c);
            this.f2513h = (int) (j * fM2865a * this.f2509d);
        }

        /* JADX INFO: renamed from: a */
        public void m2868a(float f, float f2) {
            this.f2508c = f;
            this.f2509d = f2;
        }

        /* JADX INFO: renamed from: e */
        public int m2874e() {
            return (int) (this.f2508c / Math.abs(this.f2508c));
        }

        /* JADX INFO: renamed from: f */
        public int m2875f() {
            return (int) (this.f2509d / Math.abs(this.f2509d));
        }

        /* JADX INFO: renamed from: g */
        public int m2876g() {
            return this.f2512g;
        }

        /* JADX INFO: renamed from: h */
        public int m2877h() {
            return this.f2513h;
        }
    }
}
