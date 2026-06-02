package android.support.v7.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {

    /* JADX INFO: renamed from: g */
    private static final int[] f3855g = {R.attr.state_pressed};

    /* JADX INFO: renamed from: h */
    private static final int[] f3856h = new int[0];

    /* JADX INFO: renamed from: a */
    int f3862a;

    /* JADX INFO: renamed from: b */
    int f3863b;

    /* JADX INFO: renamed from: c */
    float f3864c;

    /* JADX INFO: renamed from: d */
    int f3865d;

    /* JADX INFO: renamed from: e */
    int f3866e;

    /* JADX INFO: renamed from: f */
    float f3867f;

    /* JADX INFO: renamed from: i */
    private final int f3868i;

    /* JADX INFO: renamed from: j */
    private final int f3869j;

    /* JADX INFO: renamed from: k */
    private final StateListDrawable f3870k;

    /* JADX INFO: renamed from: l */
    private final Drawable f3871l;

    /* JADX INFO: renamed from: m */
    private final int f3872m;

    /* JADX INFO: renamed from: n */
    private final int f3873n;

    /* JADX INFO: renamed from: o */
    private final StateListDrawable f3874o;

    /* JADX INFO: renamed from: p */
    private final Drawable f3875p;

    /* JADX INFO: renamed from: q */
    private final int f3876q;

    /* JADX INFO: renamed from: r */
    private final int f3877r;

    /* JADX INFO: renamed from: u */
    private RecyclerView f3880u;

    /* JADX INFO: renamed from: s */
    private int f3878s = 0;

    /* JADX INFO: renamed from: t */
    private int f3879t = 0;

    /* JADX INFO: renamed from: v */
    private boolean f3881v = false;

    /* JADX INFO: renamed from: w */
    private boolean f3882w = false;

    /* JADX INFO: renamed from: x */
    private int f3883x = 0;

    /* JADX INFO: renamed from: y */
    private int f3884y = 0;

    /* JADX INFO: renamed from: z */
    private final int[] f3885z = new int[2];

    /* JADX INFO: renamed from: A */
    private final int[] f3857A = new int[2];

    /* JADX INFO: renamed from: B */
    private final ValueAnimator f3858B = ValueAnimator.ofFloat(CropImageView.DEFAULT_ASPECT_RATIO, 1.0f);

    /* JADX INFO: renamed from: C */
    private int f3859C = 0;

    /* JADX INFO: renamed from: D */
    private final Runnable f3860D = new Runnable() { // from class: android.support.v7.widget.FastScroller.1
        @Override // java.lang.Runnable
        public void run() {
            FastScroller.this.m4155a(500);
        }
    };

    /* JADX INFO: renamed from: E */
    private final RecyclerView.OnScrollListener f3861E = new RecyclerView.OnScrollListener() { // from class: android.support.v7.widget.FastScroller.2
        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        /* JADX INFO: renamed from: a */
        public void mo4164a(RecyclerView recyclerView, int i, int i2) {
            FastScroller.this.m4156a(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    };

    FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        this.f3870k = stateListDrawable;
        this.f3871l = drawable;
        this.f3874o = stateListDrawable2;
        this.f3875p = drawable2;
        this.f3872m = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f3873n = Math.max(i, drawable.getIntrinsicWidth());
        this.f3876q = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f3877r = Math.max(i, drawable2.getIntrinsicWidth());
        this.f3868i = i2;
        this.f3869j = i3;
        this.f3870k.setAlpha(255);
        this.f3871l.setAlpha(255);
        this.f3858B.addListener(new AnimatorListener());
        this.f3858B.addUpdateListener(new AnimatorUpdater());
        m4158a(recyclerView);
    }

    /* JADX INFO: renamed from: a */
    public void m4158a(RecyclerView recyclerView) {
        if (this.f3880u != recyclerView) {
            if (this.f3880u != null) {
                m4146c();
            }
            this.f3880u = recyclerView;
            if (this.f3880u != null) {
                m4139b();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m4139b() {
        this.f3880u.addItemDecoration(this);
        this.f3880u.addOnItemTouchListener(this);
        this.f3880u.addOnScrollListener(this.f3861E);
    }

    /* JADX INFO: renamed from: c */
    private void m4146c() {
        this.f3880u.removeItemDecoration(this);
        this.f3880u.removeOnItemTouchListener(this);
        this.f3880u.removeOnScrollListener(this.f3861E);
        m4151f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m4149d() {
        this.f3880u.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m4141b(int i) {
        if (i == 2 && this.f3883x != 2) {
            this.f3870k.setState(f3855g);
            m4151f();
        }
        if (i == 0) {
            m4149d();
        } else {
            m4154a();
        }
        if (this.f3883x == 2 && i != 2) {
            this.f3870k.setState(f3856h);
            m4147c(1200);
        } else if (i == 1) {
            m4147c(1500);
        }
        this.f3883x = i;
    }

    /* JADX INFO: renamed from: e */
    private boolean m4150e() {
        return ViewCompat.m2601e(this.f3880u) == 1;
    }

    /* JADX INFO: renamed from: a */
    public void m4154a() {
        switch (this.f3859C) {
            case 0:
                break;
            case 1:
            case 2:
            default:
                return;
            case 3:
                this.f3858B.cancel();
                break;
        }
        this.f3859C = 1;
        this.f3858B.setFloatValues(((Float) this.f3858B.getAnimatedValue()).floatValue(), 1.0f);
        this.f3858B.setDuration(500L);
        this.f3858B.setStartDelay(0L);
        this.f3858B.start();
    }

    /* JADX INFO: renamed from: a */
    void m4155a(int i) {
        switch (this.f3859C) {
            case 1:
                this.f3858B.cancel();
                break;
            case 2:
                break;
            default:
                return;
        }
        this.f3859C = 3;
        this.f3858B.setFloatValues(((Float) this.f3858B.getAnimatedValue()).floatValue(), CropImageView.DEFAULT_ASPECT_RATIO);
        this.f3858B.setDuration(i);
        this.f3858B.start();
    }

    /* JADX INFO: renamed from: f */
    private void m4151f() {
        this.f3880u.removeCallbacks(this.f3860D);
    }

    /* JADX INFO: renamed from: c */
    private void m4147c(int i) {
        m4151f();
        this.f3880u.postDelayed(this.f3860D, i);
    }

    @Override // android.support.v7.widget.RecyclerView.ItemDecoration
    /* JADX INFO: renamed from: a */
    public void mo4157a(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.f3878s != this.f3880u.getWidth() || this.f3879t != this.f3880u.getHeight()) {
            this.f3878s = this.f3880u.getWidth();
            this.f3879t = this.f3880u.getHeight();
            m4141b(0);
        } else if (this.f3859C != 0) {
            if (this.f3881v) {
                m4138a(canvas);
            }
            if (this.f3882w) {
                m4142b(canvas);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4138a(Canvas canvas) {
        int i = this.f3878s - this.f3872m;
        int i2 = this.f3863b - (this.f3862a / 2);
        this.f3870k.setBounds(0, 0, this.f3872m, this.f3862a);
        this.f3871l.setBounds(0, 0, this.f3873n, this.f3879t);
        if (m4150e()) {
            this.f3871l.draw(canvas);
            canvas.translate(this.f3872m, i2);
            canvas.scale(-1.0f, 1.0f);
            this.f3870k.draw(canvas);
            canvas.scale(1.0f, 1.0f);
            canvas.translate(-this.f3872m, -i2);
            return;
        }
        canvas.translate(i, CropImageView.DEFAULT_ASPECT_RATIO);
        this.f3871l.draw(canvas);
        canvas.translate(CropImageView.DEFAULT_ASPECT_RATIO, i2);
        this.f3870k.draw(canvas);
        canvas.translate(-i, -i2);
    }

    /* JADX INFO: renamed from: b */
    private void m4142b(Canvas canvas) {
        int i = this.f3879t - this.f3876q;
        int i2 = this.f3866e - (this.f3865d / 2);
        this.f3874o.setBounds(0, 0, this.f3865d, this.f3876q);
        this.f3875p.setBounds(0, 0, this.f3878s, this.f3877r);
        canvas.translate(CropImageView.DEFAULT_ASPECT_RATIO, i);
        this.f3875p.draw(canvas);
        canvas.translate(i2, CropImageView.DEFAULT_ASPECT_RATIO);
        this.f3874o.draw(canvas);
        canvas.translate(-i2, -i);
    }

    /* JADX INFO: renamed from: a */
    void m4156a(int i, int i2) {
        int iComputeVerticalScrollRange = this.f3880u.computeVerticalScrollRange();
        int i3 = this.f3879t;
        this.f3881v = iComputeVerticalScrollRange - i3 > 0 && this.f3879t >= this.f3868i;
        int iComputeHorizontalScrollRange = this.f3880u.computeHorizontalScrollRange();
        int i4 = this.f3878s;
        this.f3882w = iComputeHorizontalScrollRange - i4 > 0 && this.f3878s >= this.f3868i;
        if (!this.f3881v && !this.f3882w) {
            if (this.f3883x != 0) {
                m4141b(0);
                return;
            }
            return;
        }
        if (this.f3881v) {
            this.f3863b = (int) (((i2 + (i3 / 2.0f)) * i3) / iComputeVerticalScrollRange);
            this.f3862a = Math.min(i3, (i3 * i3) / iComputeVerticalScrollRange);
        }
        if (this.f3882w) {
            this.f3866e = (int) (((i + (i4 / 2.0f)) * i4) / iComputeHorizontalScrollRange);
            this.f3865d = Math.min(i4, (i4 * i4) / iComputeHorizontalScrollRange);
        }
        if (this.f3883x == 0 || this.f3883x == 1) {
            m4141b(1);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    /* JADX INFO: renamed from: a */
    public boolean mo4161a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f3883x != 1) {
            return this.f3883x == 2;
        }
        boolean zM4160a = m4160a(motionEvent.getX(), motionEvent.getY());
        boolean zM4163b = m4163b(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getAction() != 0 || (!zM4160a && !zM4163b)) {
            return false;
        }
        if (zM4163b) {
            this.f3884y = 1;
            this.f3867f = (int) motionEvent.getX();
        } else if (zM4160a) {
            this.f3884y = 2;
            this.f3864c = (int) motionEvent.getY();
        }
        m4141b(2);
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    /* JADX INFO: renamed from: b */
    public void mo4162b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f3883x != 0) {
            if (motionEvent.getAction() == 0) {
                boolean zM4160a = m4160a(motionEvent.getX(), motionEvent.getY());
                boolean zM4163b = m4163b(motionEvent.getX(), motionEvent.getY());
                if (zM4160a || zM4163b) {
                    if (zM4163b) {
                        this.f3884y = 1;
                        this.f3867f = (int) motionEvent.getX();
                    } else if (zM4160a) {
                        this.f3884y = 2;
                        this.f3864c = (int) motionEvent.getY();
                    }
                    m4141b(2);
                    return;
                }
                return;
            }
            if (motionEvent.getAction() == 1 && this.f3883x == 2) {
                this.f3864c = CropImageView.DEFAULT_ASPECT_RATIO;
                this.f3867f = CropImageView.DEFAULT_ASPECT_RATIO;
                m4141b(1);
                this.f3884y = 0;
                return;
            }
            if (motionEvent.getAction() == 2 && this.f3883x == 2) {
                m4154a();
                if (this.f3884y == 1) {
                    m4140b(motionEvent.getX());
                }
                if (this.f3884y == 2) {
                    m4137a(motionEvent.getY());
                }
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.OnItemTouchListener
    /* JADX INFO: renamed from: a */
    public void mo4159a(boolean z) {
    }

    /* JADX INFO: renamed from: a */
    private void m4137a(float f) {
        int[] iArrM4152g = m4152g();
        float fMax = Math.max(iArrM4152g[0], Math.min(iArrM4152g[1], f));
        if (Math.abs(this.f3863b - fMax) >= 2.0f) {
            int iM4134a = m4134a(this.f3864c, fMax, iArrM4152g, this.f3880u.computeVerticalScrollRange(), this.f3880u.computeVerticalScrollOffset(), this.f3879t);
            if (iM4134a != 0) {
                this.f3880u.scrollBy(0, iM4134a);
            }
            this.f3864c = fMax;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m4140b(float f) {
        int[] iArrM4153h = m4153h();
        float fMax = Math.max(iArrM4153h[0], Math.min(iArrM4153h[1], f));
        if (Math.abs(this.f3866e - fMax) >= 2.0f) {
            int iM4134a = m4134a(this.f3867f, fMax, iArrM4153h, this.f3880u.computeHorizontalScrollRange(), this.f3880u.computeHorizontalScrollOffset(), this.f3878s);
            if (iM4134a != 0) {
                this.f3880u.scrollBy(iM4134a, 0);
            }
            this.f3867f = fMax;
        }
    }

    /* JADX INFO: renamed from: a */
    private int m4134a(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    /* JADX INFO: renamed from: a */
    boolean m4160a(float f, float f2) {
        if (!m4150e() ? f >= this.f3878s - this.f3872m : f <= this.f3872m / 2) {
            if (f2 >= this.f3863b - (this.f3862a / 2) && f2 <= this.f3863b + (this.f3862a / 2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    boolean m4163b(float f, float f2) {
        return f2 >= ((float) (this.f3879t - this.f3876q)) && f >= ((float) (this.f3866e - (this.f3865d / 2))) && f <= ((float) (this.f3866e + (this.f3865d / 2)));
    }

    /* JADX INFO: renamed from: g */
    private int[] m4152g() {
        this.f3885z[0] = this.f3869j;
        this.f3885z[1] = this.f3879t - this.f3869j;
        return this.f3885z;
    }

    /* JADX INFO: renamed from: h */
    private int[] m4153h() {
        this.f3857A[0] = this.f3869j;
        this.f3857A[1] = this.f3878s - this.f3869j;
        return this.f3857A;
    }

    private class AnimatorListener extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: b */
        private boolean f3889b;

        private AnimatorListener() {
            this.f3889b = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f3889b) {
                this.f3889b = false;
            } else if (((Float) FastScroller.this.f3858B.getAnimatedValue()).floatValue() == CropImageView.DEFAULT_ASPECT_RATIO) {
                FastScroller.this.f3859C = 0;
                FastScroller.this.m4141b(0);
            } else {
                FastScroller.this.f3859C = 2;
                FastScroller.this.m4149d();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3889b = true;
        }
    }

    private class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        private AnimatorUpdater() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.f3870k.setAlpha(iFloatValue);
            FastScroller.this.f3871l.setAlpha(iFloatValue);
            FastScroller.this.m4149d();
        }
    }
}
