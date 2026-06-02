package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class ViewDragHelper {

    /* JADX INFO: renamed from: v */
    private static final Interpolator f2770v = new Interpolator() { // from class: android.support.v4.widget.ViewDragHelper.1
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* JADX INFO: renamed from: a */
    private int f2771a;

    /* JADX INFO: renamed from: b */
    private int f2772b;

    /* JADX INFO: renamed from: d */
    private float[] f2774d;

    /* JADX INFO: renamed from: e */
    private float[] f2775e;

    /* JADX INFO: renamed from: f */
    private float[] f2776f;

    /* JADX INFO: renamed from: g */
    private float[] f2777g;

    /* JADX INFO: renamed from: h */
    private int[] f2778h;

    /* JADX INFO: renamed from: i */
    private int[] f2779i;

    /* JADX INFO: renamed from: j */
    private int[] f2780j;

    /* JADX INFO: renamed from: k */
    private int f2781k;

    /* JADX INFO: renamed from: l */
    private VelocityTracker f2782l;

    /* JADX INFO: renamed from: m */
    private float f2783m;

    /* JADX INFO: renamed from: n */
    private float f2784n;

    /* JADX INFO: renamed from: o */
    private int f2785o;

    /* JADX INFO: renamed from: p */
    private int f2786p;

    /* JADX INFO: renamed from: q */
    private OverScroller f2787q;

    /* JADX INFO: renamed from: r */
    private final Callback f2788r;

    /* JADX INFO: renamed from: s */
    private View f2789s;

    /* JADX INFO: renamed from: t */
    private boolean f2790t;

    /* JADX INFO: renamed from: u */
    private final ViewGroup f2791u;

    /* JADX INFO: renamed from: c */
    private int f2773c = -1;

    /* JADX INFO: renamed from: w */
    private final Runnable f2792w = new Runnable() { // from class: android.support.v4.widget.ViewDragHelper.2
        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper.this.m3162c(0);
        }
    };

    public static abstract class Callback {
        /* JADX INFO: renamed from: a */
        public abstract boolean mo548a(View view, int i);

        /* JADX INFO: renamed from: a */
        public void mo545a(int i) {
        }

        /* JADX INFO: renamed from: a */
        public void mo547a(View view, int i, int i2, int i3, int i4) {
        }

        /* JADX INFO: renamed from: b */
        public void mo841b(View view, int i) {
        }

        /* JADX INFO: renamed from: a */
        public void mo546a(View view, float f, float f2) {
        }

        /* JADX INFO: renamed from: a */
        public void mo3007a(int i, int i2) {
        }

        /* JADX INFO: renamed from: b */
        public boolean mo3011b(int i) {
            return false;
        }

        /* JADX INFO: renamed from: b */
        public void mo3010b(int i, int i2) {
        }

        /* JADX INFO: renamed from: c */
        public int m3169c(int i) {
            return i;
        }

        /* JADX INFO: renamed from: b */
        public int mo840b(View view) {
            return 0;
        }

        /* JADX INFO: renamed from: a */
        public int mo543a(View view) {
            return 0;
        }

        /* JADX INFO: renamed from: b */
        public int mo549b(View view, int i, int i2) {
            return 0;
        }

        /* JADX INFO: renamed from: a */
        public int mo544a(View view, int i, int i2) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: a */
    public static ViewDragHelper m3130a(ViewGroup viewGroup, Callback callback) {
        return new ViewDragHelper(viewGroup.getContext(), viewGroup, callback);
    }

    /* JADX INFO: renamed from: a */
    public static ViewDragHelper m3129a(ViewGroup viewGroup, float f, Callback callback) {
        ViewDragHelper viewDragHelperM3130a = m3130a(viewGroup, callback);
        viewDragHelperM3130a.f2772b = (int) (viewDragHelperM3130a.f2772b * (1.0f / f));
        return viewDragHelperM3130a;
    }

    private ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f2791u = viewGroup;
        this.f2788r = callback;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2785o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f2772b = viewConfiguration.getScaledTouchSlop();
        this.f2783m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f2784n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f2787q = new OverScroller(context, f2770v);
    }

    /* JADX INFO: renamed from: a */
    public void m3148a(float f) {
        this.f2784n = f;
    }

    /* JADX INFO: renamed from: a */
    public int m3147a() {
        return this.f2771a;
    }

    /* JADX INFO: renamed from: a */
    public void m3149a(int i) {
        this.f2786p = i;
    }

    /* JADX INFO: renamed from: b */
    public int m3155b() {
        return this.f2785o;
    }

    /* JADX INFO: renamed from: a */
    public void m3150a(View view, int i) {
        if (view.getParent() != this.f2791u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f2791u + ")");
        }
        this.f2789s = view;
        this.f2773c = i;
        this.f2788r.mo841b(view, i);
        m3162c(1);
    }

    /* JADX INFO: renamed from: c */
    public View m3161c() {
        return this.f2789s;
    }

    /* JADX INFO: renamed from: d */
    public int m3164d() {
        return this.f2772b;
    }

    /* JADX INFO: renamed from: e */
    public void m3167e() {
        this.f2773c = -1;
        m3144g();
        if (this.f2782l != null) {
            this.f2782l.recycle();
            this.f2782l = null;
        }
    }

    /* JADX INFO: renamed from: f */
    public void m3168f() {
        m3167e();
        if (this.f2771a == 2) {
            int currX = this.f2787q.getCurrX();
            int currY = this.f2787q.getCurrY();
            this.f2787q.abortAnimation();
            int currX2 = this.f2787q.getCurrX();
            int currY2 = this.f2787q.getCurrY();
            this.f2788r.mo547a(this.f2789s, currX2, currY2, currX2 - currX, currY2 - currY);
        }
        m3162c(0);
    }

    /* JADX INFO: renamed from: a */
    public boolean m3153a(View view, int i, int i2) {
        this.f2789s = view;
        this.f2773c = -1;
        boolean zM3134a = m3134a(i, i2, 0, 0);
        if (!zM3134a && this.f2771a == 0 && this.f2789s != null) {
            this.f2789s = null;
        }
        return zM3134a;
    }

    /* JADX INFO: renamed from: a */
    public boolean m3151a(int i, int i2) {
        if (!this.f2790t) {
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        return m3134a(i, i2, (int) this.f2782l.getXVelocity(this.f2773c), (int) this.f2782l.getYVelocity(this.f2773c));
    }

    /* JADX INFO: renamed from: a */
    private boolean m3134a(int i, int i2, int i3, int i4) {
        int left = this.f2789s.getLeft();
        int top = this.f2789s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f2787q.abortAnimation();
            m3162c(0);
            return false;
        }
        this.f2787q.startScroll(left, top, i5, i6, m3128a(this.f2789s, i5, i6, i3, i4));
        m3162c(2);
        return true;
    }

    /* JADX INFO: renamed from: a */
    private int m3128a(View view, int i, int i2, int i3, int i4) {
        int iM3137b = m3137b(i3, (int) this.f2784n, (int) this.f2783m);
        int iM3137b2 = m3137b(i4, (int) this.f2784n, (int) this.f2783m);
        int iAbs = Math.abs(i);
        int iAbs2 = Math.abs(i2);
        int iAbs3 = Math.abs(iM3137b);
        int iAbs4 = Math.abs(iM3137b2);
        int i5 = iAbs3 + iAbs4;
        int i6 = iAbs + iAbs2;
        return (int) (((iM3137b2 != 0 ? iAbs4 / i5 : iAbs2 / i6) * m3127a(i2, iM3137b2, this.f2788r.mo543a(view))) + ((iM3137b != 0 ? iAbs3 / i5 : iAbs / i6) * m3127a(i, iM3137b, this.f2788r.mo840b(view))));
    }

    /* JADX INFO: renamed from: a */
    private int m3127a(int i, int i2, int i3) {
        int iAbs;
        if (i == 0) {
            return 0;
        }
        int width = this.f2791u.getWidth();
        int i4 = width / 2;
        float fM3136b = (m3136b(Math.min(1.0f, Math.abs(i) / width)) * i4) + i4;
        int iAbs2 = Math.abs(i2);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fM3136b / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(iAbs, 600);
    }

    /* JADX INFO: renamed from: b */
    private int m3137b(int i, int i2, int i3) {
        int iAbs = Math.abs(i);
        if (iAbs < i2) {
            return 0;
        }
        return iAbs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    /* JADX INFO: renamed from: a */
    private float m3126a(float f, float f2, float f3) {
        float fAbs = Math.abs(f);
        return fAbs < f2 ? CropImageView.DEFAULT_ASPECT_RATIO : fAbs > f3 ? f <= CropImageView.DEFAULT_ASPECT_RATIO ? -f3 : f3 : f;
    }

    /* JADX INFO: renamed from: b */
    private float m3136b(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    /* JADX INFO: renamed from: a */
    public boolean m3154a(boolean z) {
        boolean z2;
        if (this.f2771a == 2) {
            boolean zComputeScrollOffset = this.f2787q.computeScrollOffset();
            int currX = this.f2787q.getCurrX();
            int currY = this.f2787q.getCurrY();
            int left = currX - this.f2789s.getLeft();
            int top = currY - this.f2789s.getTop();
            if (left != 0) {
                ViewCompat.m2600d(this.f2789s, left);
            }
            if (top != 0) {
                ViewCompat.m2598c(this.f2789s, top);
            }
            if (left != 0 || top != 0) {
                this.f2788r.mo547a(this.f2789s, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f2787q.getFinalX() && currY == this.f2787q.getFinalY()) {
                this.f2787q.abortAnimation();
                z2 = false;
            } else {
                z2 = zComputeScrollOffset;
            }
            if (!z2) {
                if (z) {
                    this.f2791u.post(this.f2792w);
                } else {
                    m3162c(0);
                }
            }
        }
        return this.f2771a == 2;
    }

    /* JADX INFO: renamed from: a */
    private void m3131a(float f, float f2) {
        this.f2790t = true;
        this.f2788r.mo546a(this.f2789s, f, f2);
        this.f2790t = false;
        if (this.f2771a == 1) {
            m3162c(0);
        }
    }

    /* JADX INFO: renamed from: g */
    private void m3144g() {
        if (this.f2774d != null) {
            Arrays.fill(this.f2774d, CropImageView.DEFAULT_ASPECT_RATIO);
            Arrays.fill(this.f2775e, CropImageView.DEFAULT_ASPECT_RATIO);
            Arrays.fill(this.f2776f, CropImageView.DEFAULT_ASPECT_RATIO);
            Arrays.fill(this.f2777g, CropImageView.DEFAULT_ASPECT_RATIO);
            Arrays.fill(this.f2778h, 0);
            Arrays.fill(this.f2779i, 0);
            Arrays.fill(this.f2780j, 0);
            this.f2781k = 0;
        }
    }

    /* JADX INFO: renamed from: e */
    private void m3142e(int i) {
        if (this.f2774d != null && m3157b(i)) {
            this.f2774d[i] = 0.0f;
            this.f2775e[i] = 0.0f;
            this.f2776f[i] = 0.0f;
            this.f2777g[i] = 0.0f;
            this.f2778h[i] = 0;
            this.f2779i[i] = 0;
            this.f2780j[i] = 0;
            this.f2781k &= (1 << i) ^ (-1);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m3143f(int i) {
        if (this.f2774d == null || this.f2774d.length <= i) {
            float[] fArr = new float[i + 1];
            float[] fArr2 = new float[i + 1];
            float[] fArr3 = new float[i + 1];
            float[] fArr4 = new float[i + 1];
            int[] iArr = new int[i + 1];
            int[] iArr2 = new int[i + 1];
            int[] iArr3 = new int[i + 1];
            if (this.f2774d != null) {
                System.arraycopy(this.f2774d, 0, fArr, 0, this.f2774d.length);
                System.arraycopy(this.f2775e, 0, fArr2, 0, this.f2775e.length);
                System.arraycopy(this.f2776f, 0, fArr3, 0, this.f2776f.length);
                System.arraycopy(this.f2777g, 0, fArr4, 0, this.f2777g.length);
                System.arraycopy(this.f2778h, 0, iArr, 0, this.f2778h.length);
                System.arraycopy(this.f2779i, 0, iArr2, 0, this.f2779i.length);
                System.arraycopy(this.f2780j, 0, iArr3, 0, this.f2780j.length);
            }
            this.f2774d = fArr;
            this.f2775e = fArr2;
            this.f2776f = fArr3;
            this.f2777g = fArr4;
            this.f2778h = iArr;
            this.f2779i = iArr2;
            this.f2780j = iArr3;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3132a(float f, float f2, int i) {
        m3143f(i);
        float[] fArr = this.f2774d;
        this.f2776f[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f2775e;
        this.f2777g[i] = f2;
        fArr2[i] = f2;
        this.f2778h[i] = m3141e((int) f, (int) f2);
        this.f2781k |= 1 << i;
    }

    /* JADX INFO: renamed from: c */
    private void m3140c(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (m3145g(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f2776f[pointerId] = x;
                this.f2777g[pointerId] = y;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m3157b(int i) {
        return (this.f2781k & (1 << i)) != 0;
    }

    /* JADX INFO: renamed from: c */
    void m3162c(int i) {
        this.f2791u.removeCallbacks(this.f2792w);
        if (this.f2771a != i) {
            this.f2771a = i;
            this.f2788r.mo545a(i);
            if (this.f2771a == 0) {
                this.f2789s = null;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    boolean m3159b(View view, int i) {
        if (view == this.f2789s && this.f2773c == i) {
            return true;
        }
        if (view != null && this.f2788r.mo548a(view, i)) {
            this.f2773c = i;
            m3150a(view, i);
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x010e  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m3152a(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.ViewDragHelper.m3152a(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: renamed from: b */
    public void m3156b(MotionEvent motionEvent) {
        int i;
        int i2 = 0;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m3167e();
        }
        if (this.f2782l == null) {
            this.f2782l = VelocityTracker.obtain();
        }
        this.f2782l.addMovement(motionEvent);
        switch (actionMasked) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int pointerId = motionEvent.getPointerId(0);
                View viewM3165d = m3165d((int) x, (int) y);
                m3132a(x, y, pointerId);
                m3159b(viewM3165d, pointerId);
                int i3 = this.f2778h[pointerId];
                if ((this.f2786p & i3) != 0) {
                    this.f2788r.mo3007a(i3 & this.f2786p, pointerId);
                }
                break;
            case 1:
                if (this.f2771a == 1) {
                    m3146h();
                }
                m3167e();
                break;
            case 2:
                if (this.f2771a == 1) {
                    if (m3145g(this.f2773c)) {
                        int iFindPointerIndex = motionEvent.findPointerIndex(this.f2773c);
                        float x2 = motionEvent.getX(iFindPointerIndex);
                        float y2 = motionEvent.getY(iFindPointerIndex);
                        int i4 = (int) (x2 - this.f2776f[this.f2773c]);
                        int i5 = (int) (y2 - this.f2777g[this.f2773c]);
                        m3139b(this.f2789s.getLeft() + i4, this.f2789s.getTop() + i5, i4, i5);
                        m3140c(motionEvent);
                    }
                } else {
                    int pointerCount = motionEvent.getPointerCount();
                    while (i2 < pointerCount) {
                        int pointerId2 = motionEvent.getPointerId(i2);
                        if (m3145g(pointerId2)) {
                            float x3 = motionEvent.getX(i2);
                            float y3 = motionEvent.getY(i2);
                            float f = x3 - this.f2774d[pointerId2];
                            float f2 = y3 - this.f2775e[pointerId2];
                            m3138b(f, f2, pointerId2);
                            if (this.f2771a != 1) {
                                View viewM3165d2 = m3165d((int) x3, (int) y3);
                                if (!m3135a(viewM3165d2, f, f2) || !m3159b(viewM3165d2, pointerId2)) {
                                }
                            }
                            m3140c(motionEvent);
                            break;
                        }
                        i2++;
                    }
                    m3140c(motionEvent);
                }
                break;
            case 3:
                if (this.f2771a == 1) {
                    m3131a(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
                }
                m3167e();
                break;
            case 5:
                int pointerId3 = motionEvent.getPointerId(actionIndex);
                float x4 = motionEvent.getX(actionIndex);
                float y4 = motionEvent.getY(actionIndex);
                m3132a(x4, y4, pointerId3);
                if (this.f2771a == 0) {
                    m3159b(m3165d((int) x4, (int) y4), pointerId3);
                    int i6 = this.f2778h[pointerId3];
                    if ((this.f2786p & i6) != 0) {
                        this.f2788r.mo3007a(i6 & this.f2786p, pointerId3);
                    }
                } else if (m3163c((int) x4, (int) y4)) {
                    m3159b(this.f2789s, pointerId3);
                }
                break;
            case 6:
                int pointerId4 = motionEvent.getPointerId(actionIndex);
                if (this.f2771a == 1 && pointerId4 == this.f2773c) {
                    int pointerCount2 = motionEvent.getPointerCount();
                    while (true) {
                        if (i2 >= pointerCount2) {
                            i = -1;
                        } else {
                            int pointerId5 = motionEvent.getPointerId(i2);
                            if (pointerId5 != this.f2773c) {
                                if (m3165d((int) motionEvent.getX(i2), (int) motionEvent.getY(i2)) == this.f2789s && m3159b(this.f2789s, pointerId5)) {
                                    i = this.f2773c;
                                }
                            }
                            i2++;
                        }
                    }
                    if (i == -1) {
                        m3146h();
                    }
                }
                m3142e(pointerId4);
                break;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m3138b(float f, float f2, int i) {
        int i2 = m3133a(f, f2, i, 1) ? 1 : 0;
        if (m3133a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m3133a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m3133a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f2779i;
            iArr[i] = iArr[i] | i2;
            this.f2788r.mo3010b(i2, i);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3133a(float f, float f2, int i, int i2) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        if ((this.f2778h[i] & i2) != i2 || (this.f2786p & i2) == 0 || (this.f2780j[i] & i2) == i2 || (this.f2779i[i] & i2) == i2) {
            return false;
        }
        if (fAbs <= this.f2772b && fAbs2 <= this.f2772b) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f2788r.mo3011b(i2)) {
            return (this.f2779i[i] & i2) == 0 && fAbs > ((float) this.f2772b);
        }
        int[] iArr = this.f2780j;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3135a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f2788r.mo840b(view) > 0;
        boolean z2 = this.f2788r.mo543a(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f2772b * this.f2772b)) : z ? Math.abs(f) > ((float) this.f2772b) : z2 && Math.abs(f2) > ((float) this.f2772b);
    }

    /* JADX INFO: renamed from: d */
    public boolean m3166d(int i) {
        int length = this.f2774d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (m3158b(i, i2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public boolean m3158b(int i, int i2) {
        if (!m3157b(i2)) {
            return false;
        }
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 2) == 2;
        float f = this.f2776f[i2] - this.f2774d[i2];
        float f2 = this.f2777g[i2] - this.f2775e[i2];
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f2772b * this.f2772b)) : z ? Math.abs(f) > ((float) this.f2772b) : z2 && Math.abs(f2) > ((float) this.f2772b);
    }

    /* JADX INFO: renamed from: h */
    private void m3146h() {
        this.f2782l.computeCurrentVelocity(1000, this.f2783m);
        m3131a(m3126a(this.f2782l.getXVelocity(this.f2773c), this.f2784n, this.f2783m), m3126a(this.f2782l.getYVelocity(this.f2773c), this.f2784n, this.f2783m));
    }

    /* JADX INFO: renamed from: b */
    private void m3139b(int i, int i2, int i3, int i4) {
        int iMo549b;
        int iMo544a;
        int left = this.f2789s.getLeft();
        int top = this.f2789s.getTop();
        if (i3 != 0) {
            iMo549b = this.f2788r.mo549b(this.f2789s, i, i3);
            ViewCompat.m2600d(this.f2789s, iMo549b - left);
        } else {
            iMo549b = i;
        }
        if (i4 != 0) {
            iMo544a = this.f2788r.mo544a(this.f2789s, i2, i4);
            ViewCompat.m2598c(this.f2789s, iMo544a - top);
        } else {
            iMo544a = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f2788r.mo547a(this.f2789s, iMo549b, iMo544a, iMo549b - left, iMo544a - top);
        }
    }

    /* JADX INFO: renamed from: c */
    public boolean m3163c(int i, int i2) {
        return m3160b(this.f2789s, i, i2);
    }

    /* JADX INFO: renamed from: b */
    public boolean m3160b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    /* JADX INFO: renamed from: d */
    public View m3165d(int i, int i2) {
        for (int childCount = this.f2791u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f2791u.getChildAt(this.f2788r.m3169c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    private int m3141e(int i, int i2) {
        int i3 = i < this.f2791u.getLeft() + this.f2785o ? 1 : 0;
        if (i2 < this.f2791u.getTop() + this.f2785o) {
            i3 |= 4;
        }
        if (i > this.f2791u.getRight() - this.f2785o) {
            i3 |= 2;
        }
        return i2 > this.f2791u.getBottom() - this.f2785o ? i3 | 8 : i3;
    }

    /* JADX INFO: renamed from: g */
    private boolean m3145g(int i) {
        if (m3157b(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
