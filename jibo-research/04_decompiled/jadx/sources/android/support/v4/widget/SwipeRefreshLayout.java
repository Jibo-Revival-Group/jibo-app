package android.support.v4.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import android.widget.ListView;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {

    /* JADX INFO: renamed from: A */
    private int f2716A;

    /* JADX INFO: renamed from: B */
    private boolean f2717B;

    /* JADX INFO: renamed from: C */
    private final DecelerateInterpolator f2718C;

    /* JADX INFO: renamed from: E */
    private int f2719E;

    /* JADX INFO: renamed from: F */
    private Animation f2720F;

    /* JADX INFO: renamed from: G */
    private Animation f2721G;

    /* JADX INFO: renamed from: H */
    private Animation f2722H;

    /* JADX INFO: renamed from: I */
    private Animation f2723I;

    /* JADX INFO: renamed from: J */
    private Animation f2724J;

    /* JADX INFO: renamed from: K */
    private int f2725K;

    /* JADX INFO: renamed from: L */
    private OnChildScrollUpCallback f2726L;

    /* JADX INFO: renamed from: M */
    private Animation.AnimationListener f2727M;

    /* JADX INFO: renamed from: N */
    private final Animation f2728N;

    /* JADX INFO: renamed from: O */
    private final Animation f2729O;

    /* JADX INFO: renamed from: a */
    OnRefreshListener f2730a;

    /* JADX INFO: renamed from: b */
    boolean f2731b;

    /* JADX INFO: renamed from: c */
    int f2732c;

    /* JADX INFO: renamed from: d */
    boolean f2733d;

    /* JADX INFO: renamed from: e */
    CircleImageView f2734e;

    /* JADX INFO: renamed from: f */
    protected int f2735f;

    /* JADX INFO: renamed from: g */
    float f2736g;

    /* JADX INFO: renamed from: h */
    protected int f2737h;

    /* JADX INFO: renamed from: i */
    int f2738i;

    /* JADX INFO: renamed from: j */
    CircularProgressDrawable f2739j;

    /* JADX INFO: renamed from: k */
    boolean f2740k;

    /* JADX INFO: renamed from: l */
    boolean f2741l;

    /* JADX INFO: renamed from: n */
    private View f2742n;

    /* JADX INFO: renamed from: o */
    private int f2743o;

    /* JADX INFO: renamed from: p */
    private float f2744p;

    /* JADX INFO: renamed from: q */
    private float f2745q;

    /* JADX INFO: renamed from: r */
    private final NestedScrollingParentHelper f2746r;

    /* JADX INFO: renamed from: s */
    private final NestedScrollingChildHelper f2747s;

    /* JADX INFO: renamed from: t */
    private final int[] f2748t;

    /* JADX INFO: renamed from: u */
    private final int[] f2749u;

    /* JADX INFO: renamed from: v */
    private boolean f2750v;

    /* JADX INFO: renamed from: w */
    private int f2751w;

    /* JADX INFO: renamed from: x */
    private float f2752x;

    /* JADX INFO: renamed from: y */
    private float f2753y;

    /* JADX INFO: renamed from: z */
    private boolean f2754z;

    /* JADX INFO: renamed from: m */
    private static final String f2715m = SwipeRefreshLayout.class.getSimpleName();

    /* JADX INFO: renamed from: D */
    private static final int[] f2714D = {R.attr.enabled};

    public interface OnChildScrollUpCallback {
        /* JADX INFO: renamed from: a */
        boolean m3114a(SwipeRefreshLayout swipeRefreshLayout, View view);
    }

    public interface OnRefreshListener {
        /* JADX INFO: renamed from: n_ */
        void mo3115n_();
    }

    /* JADX INFO: renamed from: a */
    void m3110a() {
        this.f2734e.clearAnimation();
        this.f2739j.stop();
        this.f2734e.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f2733d) {
            setAnimationProgress(CropImageView.DEFAULT_ASPECT_RATIO);
        } else {
            setTargetOffsetTopAndBottom(this.f2737h - this.f2732c);
        }
        this.f2732c = this.f2734e.getTop();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            m3110a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3110a();
    }

    private void setColorViewAlpha(int i) {
        this.f2734e.getBackground().setAlpha(i);
        this.f2739j.setAlpha(i);
    }

    public int getProgressViewStartOffset() {
        return this.f2737h;
    }

    public int getProgressViewEndOffset() {
        return this.f2738i;
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.f2725K = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f2725K = (int) (displayMetrics.density * 40.0f);
            }
            this.f2734e.setImageDrawable(null);
            this.f2739j.m2896a(i);
            this.f2734e.setImageDrawable(this.f2739j);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2731b = false;
        this.f2744p = -1.0f;
        this.f2748t = new int[2];
        this.f2749u = new int[2];
        this.f2716A = -1;
        this.f2719E = -1;
        this.f2727M = new Animation.AnimationListener() { // from class: android.support.v4.widget.SwipeRefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (SwipeRefreshLayout.this.f2731b) {
                    SwipeRefreshLayout.this.f2739j.setAlpha(255);
                    SwipeRefreshLayout.this.f2739j.start();
                    if (SwipeRefreshLayout.this.f2740k && SwipeRefreshLayout.this.f2730a != null) {
                        SwipeRefreshLayout.this.f2730a.mo3115n_();
                    }
                    SwipeRefreshLayout.this.f2732c = SwipeRefreshLayout.this.f2734e.getTop();
                    return;
                }
                SwipeRefreshLayout.this.m3110a();
            }
        };
        this.f2728N = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.6
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                int iAbs;
                if (!SwipeRefreshLayout.this.f2741l) {
                    iAbs = SwipeRefreshLayout.this.f2738i - Math.abs(SwipeRefreshLayout.this.f2737h);
                } else {
                    iAbs = SwipeRefreshLayout.this.f2738i;
                }
                SwipeRefreshLayout.this.setTargetOffsetTopAndBottom((((int) ((iAbs - SwipeRefreshLayout.this.f2735f) * f)) + SwipeRefreshLayout.this.f2735f) - SwipeRefreshLayout.this.f2734e.getTop());
                SwipeRefreshLayout.this.f2739j.m2899b(1.0f - f);
            }
        };
        this.f2729O = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.7
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.m3111a(f);
            }
        };
        this.f2743o = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f2751w = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.f2718C = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f2725K = (int) (40.0f * displayMetrics.density);
        m3103c();
        setChildrenDrawingOrderEnabled(true);
        this.f2738i = (int) (displayMetrics.density * 64.0f);
        this.f2744p = this.f2738i;
        this.f2746r = new NestedScrollingParentHelper(this);
        this.f2747s = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i = -this.f2725K;
        this.f2732c = i;
        this.f2737h = i;
        m3111a(1.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2714D);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.f2719E >= 0) {
            if (i2 == i - 1) {
                return this.f2719E;
            }
            if (i2 >= this.f2719E) {
                return i2 + 1;
            }
            return i2;
        }
        return i2;
    }

    /* JADX INFO: renamed from: c */
    private void m3103c() {
        this.f2734e = new CircleImageView(getContext(), -328966);
        this.f2739j = new CircularProgressDrawable(getContext());
        this.f2739j.m2896a(1);
        this.f2734e.setImageDrawable(this.f2739j);
        this.f2734e.setVisibility(8);
        addView(this.f2734e);
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.f2730a = onRefreshListener;
    }

    public void setRefreshing(boolean z) {
        int i;
        if (z && this.f2731b != z) {
            this.f2731b = z;
            if (!this.f2741l) {
                i = this.f2738i + this.f2737h;
            } else {
                i = this.f2738i;
            }
            setTargetOffsetTopAndBottom(i - this.f2732c);
            this.f2740k = false;
            m3102b(this.f2727M);
            return;
        }
        m3098a(z, false);
    }

    /* JADX INFO: renamed from: b */
    private void m3102b(Animation.AnimationListener animationListener) {
        this.f2734e.setVisibility(0);
        this.f2739j.setAlpha(255);
        this.f2720F = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f);
            }
        };
        this.f2720F.setDuration(this.f2751w);
        if (animationListener != null) {
            this.f2734e.m2879a(animationListener);
        }
        this.f2734e.clearAnimation();
        this.f2734e.startAnimation(this.f2720F);
    }

    void setAnimationProgress(float f) {
        this.f2734e.setScaleX(f);
        this.f2734e.setScaleY(f);
    }

    /* JADX INFO: renamed from: a */
    private void m3098a(boolean z, boolean z2) {
        if (this.f2731b != z) {
            this.f2740k = z2;
            m3109f();
            this.f2731b = z;
            if (this.f2731b) {
                m3096a(this.f2732c, this.f2727M);
            } else {
                m3112a(this.f2727M);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m3112a(Animation.AnimationListener animationListener) {
        this.f2721G = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.3
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.f2721G.setDuration(150L);
        this.f2734e.m2879a(animationListener);
        this.f2734e.clearAnimation();
        this.f2734e.startAnimation(this.f2721G);
    }

    /* JADX INFO: renamed from: d */
    private void m3106d() {
        this.f2722H = m3095a(this.f2739j.getAlpha(), 76);
    }

    /* JADX INFO: renamed from: e */
    private void m3108e() {
        this.f2723I = m3095a(this.f2739j.getAlpha(), 255);
    }

    /* JADX INFO: renamed from: a */
    private Animation m3095a(final int i, final int i2) {
        Animation animation = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.4
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.f2739j.setAlpha((int) (i + ((i2 - i) * f)));
            }
        };
        animation.setDuration(300L);
        this.f2734e.m2879a(null);
        this.f2734e.clearAnimation();
        this.f2734e.startAnimation(animation);
        return animation;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(ContextCompat.m1840c(getContext(), i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.f2734e.setBackgroundColor(i);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = ContextCompat.m1840c(context, iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        m3109f();
        this.f2739j.m2898a(iArr);
    }

    /* JADX INFO: renamed from: f */
    private void m3109f() {
        if (this.f2742n == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.f2734e)) {
                    this.f2742n = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.f2744p = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f2742n == null) {
                m3109f();
            }
            if (this.f2742n != null) {
                View view = this.f2742n;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.f2734e.getMeasuredWidth();
                this.f2734e.layout((measuredWidth / 2) - (measuredWidth2 / 2), this.f2732c, (measuredWidth / 2) + (measuredWidth2 / 2), this.f2732c + this.f2734e.getMeasuredHeight());
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f2742n == null) {
            m3109f();
        }
        if (this.f2742n != null) {
            this.f2742n.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f2734e.measure(View.MeasureSpec.makeMeasureSpec(this.f2725K, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f2725K, 1073741824));
            this.f2719E = -1;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.f2734e) {
                    this.f2719E = i3;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.f2725K;
    }

    /* JADX INFO: renamed from: b */
    public boolean m3113b() {
        if (this.f2726L != null) {
            return this.f2726L.m3114a(this, this.f2742n);
        }
        if (this.f2742n instanceof ListView) {
            return ListViewCompat.m3023b((ListView) this.f2742n, -1);
        }
        return this.f2742n.canScrollVertically(-1);
    }

    public void setOnChildScrollUpCallback(OnChildScrollUpCallback onChildScrollUpCallback) {
        this.f2726L = onChildScrollUpCallback;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m3109f();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f2717B && actionMasked == 0) {
            this.f2717B = false;
        }
        if (!isEnabled() || this.f2717B || m3113b() || this.f2731b || this.f2750v) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                setTargetOffsetTopAndBottom(this.f2737h - this.f2734e.getTop());
                this.f2716A = motionEvent.getPointerId(0);
                this.f2754z = false;
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f2716A);
                if (iFindPointerIndex < 0) {
                    return false;
                }
                this.f2753y = motionEvent.getY(iFindPointerIndex);
                break;
                break;
            case 1:
            case 3:
                this.f2754z = false;
                this.f2716A = -1;
                break;
            case 2:
                if (this.f2716A == -1) {
                    Log.e(f2715m, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.f2716A);
                if (iFindPointerIndex2 < 0) {
                    return false;
                }
                m3107d(motionEvent.getY(iFindPointerIndex2));
                break;
                break;
            case 6:
                m3097a(motionEvent);
                break;
        }
        return this.f2754z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.f2742n instanceof AbsListView)) {
            if (this.f2742n == null || ViewCompat.m2619w(this.f2742n)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.f2717B || this.f2731b || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f2746r.m2548a(view, view2, i);
        startNestedScroll(i & 2);
        this.f2745q = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f2750v = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.f2745q > CropImageView.DEFAULT_ASPECT_RATIO) {
            if (i2 > this.f2745q) {
                iArr[1] = i2 - ((int) this.f2745q);
                this.f2745q = CropImageView.DEFAULT_ASPECT_RATIO;
            } else {
                this.f2745q -= i2;
                iArr[1] = i2;
            }
            m3100b(this.f2745q);
        }
        if (this.f2741l && i2 > 0 && this.f2745q == CropImageView.DEFAULT_ASPECT_RATIO && Math.abs(i2 - iArr[1]) > 0) {
            this.f2734e.setVisibility(8);
        }
        int[] iArr2 = this.f2748t;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f2746r.m2545a();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.f2746r.m2546a(view);
        this.f2750v = false;
        if (this.f2745q > CropImageView.DEFAULT_ASPECT_RATIO) {
            m3104c(this.f2745q);
            this.f2745q = CropImageView.DEFAULT_ASPECT_RATIO;
        }
        stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.f2749u);
        if (this.f2749u[1] + i4 < 0 && !m3113b()) {
            this.f2745q = Math.abs(r0) + this.f2745q;
            m3100b(this.f2745q);
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.f2747s.m2531a(z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.f2747s.m2532a();
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.f2747s.m2542b(i);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.f2747s.m2543c();
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.f2747s.m2541b();
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f2747s.m2537a(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f2747s.m2539a(i, i2, iArr, iArr2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f2747s.m2534a(f, f2, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f2747s.m2533a(f, f2);
    }

    /* JADX INFO: renamed from: a */
    private boolean m3099a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    private void m3100b(float f) {
        this.f2739j.m2897a(true);
        float fMin = Math.min(1.0f, Math.abs(f / this.f2744p));
        float fMax = (((float) Math.max(((double) fMin) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f) - this.f2744p;
        float f2 = this.f2741l ? this.f2738i - this.f2737h : this.f2738i;
        float fMax2 = ((float) (((double) (Math.max(CropImageView.DEFAULT_ASPECT_RATIO, Math.min(fAbs, f2 * 2.0f) / f2) / 4.0f)) - Math.pow(r3 / 4.0f, 2.0d))) * 2.0f;
        int i = ((int) ((f2 * fMin) + (f2 * fMax2 * 2.0f))) + this.f2737h;
        if (this.f2734e.getVisibility() != 0) {
            this.f2734e.setVisibility(0);
        }
        if (!this.f2733d) {
            this.f2734e.setScaleX(1.0f);
            this.f2734e.setScaleY(1.0f);
        }
        if (this.f2733d) {
            setAnimationProgress(Math.min(1.0f, f / this.f2744p));
        }
        if (f < this.f2744p) {
            if (this.f2739j.getAlpha() > 76 && !m3099a(this.f2722H)) {
                m3106d();
            }
        } else if (this.f2739j.getAlpha() < 255 && !m3099a(this.f2723I)) {
            m3108e();
        }
        this.f2739j.m2895a(CropImageView.DEFAULT_ASPECT_RATIO, Math.min(0.8f, fMax * 0.8f));
        this.f2739j.m2899b(Math.min(1.0f, fMax));
        this.f2739j.m2900c(((-0.25f) + (fMax * 0.4f) + (fMax2 * 2.0f)) * 0.5f);
        setTargetOffsetTopAndBottom(i - this.f2732c);
    }

    /* JADX INFO: renamed from: c */
    private void m3104c(float f) {
        if (f > this.f2744p) {
            m3098a(true, true);
            return;
        }
        this.f2731b = false;
        this.f2739j.m2895a(CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO);
        Animation.AnimationListener animationListener = null;
        if (!this.f2733d) {
            animationListener = new Animation.AnimationListener() { // from class: android.support.v4.widget.SwipeRefreshLayout.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (!SwipeRefreshLayout.this.f2733d) {
                        SwipeRefreshLayout.this.m3112a((Animation.AnimationListener) null);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            };
        }
        m3101b(this.f2732c, animationListener);
        this.f2739j.m2897a(false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.f2717B && actionMasked == 0) {
            this.f2717B = false;
        }
        if (!isEnabled() || this.f2717B || m3113b() || this.f2731b || this.f2750v) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                this.f2716A = motionEvent.getPointerId(0);
                this.f2754z = false;
                return true;
            case 1:
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f2716A);
                if (iFindPointerIndex < 0) {
                    Log.e(f2715m, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.f2754z) {
                    float y = (motionEvent.getY(iFindPointerIndex) - this.f2752x) * 0.5f;
                    this.f2754z = false;
                    m3104c(y);
                }
                this.f2716A = -1;
                return false;
            case 2:
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.f2716A);
                if (iFindPointerIndex2 < 0) {
                    Log.e(f2715m, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y2 = motionEvent.getY(iFindPointerIndex2);
                m3107d(y2);
                if (this.f2754z) {
                    float f = (y2 - this.f2752x) * 0.5f;
                    if (f <= CropImageView.DEFAULT_ASPECT_RATIO) {
                        return false;
                    }
                    m3100b(f);
                }
                return true;
            case 3:
                return false;
            case 4:
            default:
                return true;
            case 5:
                int actionIndex = motionEvent.getActionIndex();
                if (actionIndex < 0) {
                    Log.e(f2715m, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.f2716A = motionEvent.getPointerId(actionIndex);
                return true;
            case 6:
                m3097a(motionEvent);
                return true;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m3107d(float f) {
        if (f - this.f2753y > this.f2743o && !this.f2754z) {
            this.f2752x = this.f2753y + this.f2743o;
            this.f2754z = true;
            this.f2739j.setAlpha(76);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3096a(int i, Animation.AnimationListener animationListener) {
        this.f2735f = i;
        this.f2728N.reset();
        this.f2728N.setDuration(200L);
        this.f2728N.setInterpolator(this.f2718C);
        if (animationListener != null) {
            this.f2734e.m2879a(animationListener);
        }
        this.f2734e.clearAnimation();
        this.f2734e.startAnimation(this.f2728N);
    }

    /* JADX INFO: renamed from: b */
    private void m3101b(int i, Animation.AnimationListener animationListener) {
        if (this.f2733d) {
            m3105c(i, animationListener);
            return;
        }
        this.f2735f = i;
        this.f2729O.reset();
        this.f2729O.setDuration(200L);
        this.f2729O.setInterpolator(this.f2718C);
        if (animationListener != null) {
            this.f2734e.m2879a(animationListener);
        }
        this.f2734e.clearAnimation();
        this.f2734e.startAnimation(this.f2729O);
    }

    /* JADX INFO: renamed from: a */
    void m3111a(float f) {
        setTargetOffsetTopAndBottom((this.f2735f + ((int) ((this.f2737h - this.f2735f) * f))) - this.f2734e.getTop());
    }

    /* JADX INFO: renamed from: c */
    private void m3105c(int i, Animation.AnimationListener animationListener) {
        this.f2735f = i;
        this.f2736g = this.f2734e.getScaleX();
        this.f2724J = new Animation() { // from class: android.support.v4.widget.SwipeRefreshLayout.8
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(SwipeRefreshLayout.this.f2736g + ((-SwipeRefreshLayout.this.f2736g) * f));
                SwipeRefreshLayout.this.m3111a(f);
            }
        };
        this.f2724J.setDuration(150L);
        if (animationListener != null) {
            this.f2734e.m2879a(animationListener);
        }
        this.f2734e.clearAnimation();
        this.f2734e.startAnimation(this.f2724J);
    }

    void setTargetOffsetTopAndBottom(int i) {
        this.f2734e.bringToFront();
        ViewCompat.m2598c(this.f2734e, i);
        this.f2732c = this.f2734e.getTop();
    }

    /* JADX INFO: renamed from: a */
    private void m3097a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2716A) {
            this.f2716A = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }
}
