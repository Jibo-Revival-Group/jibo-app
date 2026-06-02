package android.support.v4.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class SlidingPaneLayout extends ViewGroup {

    /* JADX INFO: renamed from: h */
    static final SlidingPanelLayoutImpl f2680h;

    /* JADX INFO: renamed from: a */
    View f2681a;

    /* JADX INFO: renamed from: b */
    float f2682b;

    /* JADX INFO: renamed from: c */
    int f2683c;

    /* JADX INFO: renamed from: d */
    boolean f2684d;

    /* JADX INFO: renamed from: e */
    final ViewDragHelper f2685e;

    /* JADX INFO: renamed from: f */
    boolean f2686f;

    /* JADX INFO: renamed from: g */
    final ArrayList<DisableLayerRunnable> f2687g;

    /* JADX INFO: renamed from: i */
    private int f2688i;

    /* JADX INFO: renamed from: j */
    private int f2689j;

    /* JADX INFO: renamed from: k */
    private Drawable f2690k;

    /* JADX INFO: renamed from: l */
    private Drawable f2691l;

    /* JADX INFO: renamed from: m */
    private final int f2692m;

    /* JADX INFO: renamed from: n */
    private boolean f2693n;

    /* JADX INFO: renamed from: o */
    private float f2694o;

    /* JADX INFO: renamed from: p */
    private int f2695p;

    /* JADX INFO: renamed from: q */
    private float f2696q;

    /* JADX INFO: renamed from: r */
    private float f2697r;

    /* JADX INFO: renamed from: s */
    private PanelSlideListener f2698s;

    /* JADX INFO: renamed from: t */
    private boolean f2699t;

    /* JADX INFO: renamed from: u */
    private final Rect f2700u;

    public interface PanelSlideListener {
        /* JADX INFO: renamed from: a */
        void m3087a(View view);

        /* JADX INFO: renamed from: a */
        void m3088a(View view, float f);

        /* JADX INFO: renamed from: b */
        void m3089b(View view);
    }

    interface SlidingPanelLayoutImpl {
        /* JADX INFO: renamed from: a */
        void mo3093a(SlidingPaneLayout slidingPaneLayout, View view);
    }

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            f2680h = new SlidingPanelLayoutImplJBMR1();
        } else if (Build.VERSION.SDK_INT >= 16) {
            f2680h = new SlidingPanelLayoutImplJB();
        } else {
            f2680h = new SlidingPanelLayoutImplBase();
        }
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingPaneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2688i = -858993460;
        this.f2699t = true;
        this.f2700u = new Rect();
        this.f2687g = new ArrayList<>();
        float f = context.getResources().getDisplayMetrics().density;
        this.f2692m = (int) ((32.0f * f) + 0.5f);
        setWillNotDraw(false);
        ViewCompat.m2583a(this, new AccessibilityDelegate());
        ViewCompat.m2575a((View) this, 1);
        this.f2685e = ViewDragHelper.m3129a(this, 0.5f, new DragHelperCallback());
        this.f2685e.m3148a(f * 400.0f);
    }

    public void setParallaxDistance(int i) {
        this.f2695p = i;
        requestLayout();
    }

    public int getParallaxDistance() {
        return this.f2695p;
    }

    public void setSliderFadeColor(int i) {
        this.f2688i = i;
    }

    public int getSliderFadeColor() {
        return this.f2688i;
    }

    public void setCoveredFadeColor(int i) {
        this.f2689j = i;
    }

    public int getCoveredFadeColor() {
        return this.f2689j;
    }

    public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
        this.f2698s = panelSlideListener;
    }

    /* JADX INFO: renamed from: a */
    void m3073a(View view) {
        if (this.f2698s != null) {
            this.f2698s.m3088a(view, this.f2682b);
        }
    }

    /* JADX INFO: renamed from: b */
    void m3075b(View view) {
        if (this.f2698s != null) {
            this.f2698s.m3087a(view);
        }
        sendAccessibilityEvent(32);
    }

    /* JADX INFO: renamed from: c */
    void m3077c(View view) {
        if (this.f2698s != null) {
            this.f2698s.m3089b(view);
        }
        sendAccessibilityEvent(32);
    }

    /* JADX INFO: renamed from: d */
    void m3079d(View view) {
        int bottom;
        int top;
        int right;
        int left;
        int i;
        boolean zM3083f = m3083f();
        int width = zM3083f ? getWidth() - getPaddingRight() : getPaddingLeft();
        int paddingLeft = zM3083f ? getPaddingLeft() : getWidth() - getPaddingRight();
        int paddingTop = getPaddingTop();
        int height = getHeight() - getPaddingBottom();
        if (view != null && m3070g(view)) {
            left = view.getLeft();
            right = view.getRight();
            top = view.getTop();
            bottom = view.getBottom();
        } else {
            bottom = 0;
            top = 0;
            right = 0;
            left = 0;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != view) {
                if (childAt.getVisibility() != 8) {
                    int iMax = Math.max(zM3083f ? paddingLeft : width, childAt.getLeft());
                    int iMax2 = Math.max(paddingTop, childAt.getTop());
                    int iMin = Math.min(zM3083f ? width : paddingLeft, childAt.getRight());
                    int iMin2 = Math.min(height, childAt.getBottom());
                    if (iMax >= left && iMax2 >= top && iMin <= right && iMin2 <= bottom) {
                        i = 4;
                    } else {
                        i = 0;
                    }
                    childAt.setVisibility(i);
                }
            } else {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m3071a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private static boolean m3070g(View view) {
        Drawable background;
        if (view.isOpaque()) {
            return true;
        }
        return Build.VERSION.SDK_INT < 18 && (background = view.getBackground()) != null && background.getOpacity() == -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2699t = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2699t = true;
        int size = this.f2687g.size();
        for (int i = 0; i < size; i++) {
            this.f2687g.get(i).run();
        }
        this.f2687g.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:124:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d3 A[PHI: r3
      0x00d3: PHI (r3v12 float) = (r3v11 float), (r3v14 float) binds: [B:35:0x00c5, B:37:0x00cc] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 636
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int width;
        int i9;
        boolean zM3083f = m3083f();
        if (zM3083f) {
            this.f2685e.m3149a(2);
        } else {
            this.f2685e.m3149a(1);
        }
        int i10 = i3 - i;
        int paddingRight = zM3083f ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = zM3083f ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.f2699t) {
            this.f2682b = (this.f2693n && this.f2686f) ? 1.0f : CropImageView.DEFAULT_ASPECT_RATIO;
        }
        int i11 = 0;
        int i12 = paddingRight;
        while (i11 < childCount) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 8) {
                width = paddingRight;
                i9 = i12;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                if (layoutParams.f2708b) {
                    int iMin = (Math.min(paddingRight, (i10 - paddingLeft) - this.f2692m) - i12) - (layoutParams.leftMargin + layoutParams.rightMargin);
                    this.f2683c = iMin;
                    int i13 = zM3083f ? layoutParams.rightMargin : layoutParams.leftMargin;
                    layoutParams.f2709c = ((i12 + i13) + iMin) + (measuredWidth / 2) > i10 - paddingLeft;
                    int i14 = (int) (iMin * this.f2682b);
                    i6 = i12 + i13 + i14;
                    this.f2682b = i14 / this.f2683c;
                    i5 = 0;
                } else if (!this.f2693n || this.f2695p == 0) {
                    i5 = 0;
                    i6 = paddingRight;
                } else {
                    i5 = (int) ((1.0f - this.f2682b) * this.f2695p);
                    i6 = paddingRight;
                }
                if (zM3083f) {
                    i8 = (i10 - i6) + i5;
                    i7 = i8 - measuredWidth;
                } else {
                    i7 = i6 - i5;
                    i8 = i7 + measuredWidth;
                }
                childAt.layout(i7, paddingTop, i8, childAt.getMeasuredHeight() + paddingTop);
                width = childAt.getWidth() + paddingRight;
                i9 = i6;
            }
            i11++;
            paddingRight = width;
            i12 = i9;
        }
        if (this.f2699t) {
            if (this.f2693n) {
                if (this.f2695p != 0) {
                    m3066a(this.f2682b);
                }
                if (((LayoutParams) this.f2681a.getLayoutParams()).f2709c) {
                    m3067a(this.f2681a, this.f2682b, this.f2688i);
                }
            } else {
                for (int i15 = 0; i15 < childCount; i15++) {
                    m3067a(getChildAt(i15), CropImageView.DEFAULT_ASPECT_RATIO, this.f2688i);
                }
            }
            m3079d(this.f2681a);
        }
        this.f2699t = false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            this.f2699t = true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        if (!isInTouchMode() && !this.f2693n) {
            this.f2686f = view == this.f2681a;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View childAt;
        int actionMasked = motionEvent.getActionMasked();
        if (!this.f2693n && actionMasked == 0 && getChildCount() > 1 && (childAt = getChildAt(1)) != null) {
            this.f2686f = !this.f2685e.m3160b(childAt, (int) motionEvent.getX(), (int) motionEvent.getY());
        }
        if (!this.f2693n || (this.f2684d && actionMasked != 0)) {
            this.f2685e.m3167e();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (actionMasked == 3 || actionMasked == 1) {
            this.f2685e.m3167e();
            return false;
        }
        switch (actionMasked) {
            case 0:
                this.f2684d = false;
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f2696q = x;
                this.f2697r = y;
                z = this.f2685e.m3160b(this.f2681a, (int) x, (int) y) && m3084f(this.f2681a);
                break;
            case 1:
            default:
                z = false;
                break;
            case 2:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float fAbs = Math.abs(x2 - this.f2696q);
                float fAbs2 = Math.abs(y2 - this.f2697r);
                if (fAbs > this.f2685e.m3164d() && fAbs2 > fAbs) {
                    this.f2685e.m3167e();
                    this.f2684d = true;
                    return false;
                }
                z = false;
                break;
                break;
        }
        return this.f2685e.m3152a(motionEvent) || z;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f2693n) {
            return super.onTouchEvent(motionEvent);
        }
        this.f2685e.m3156b(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f2696q = x;
                this.f2697r = y;
                return true;
            case 1:
                if (!m3084f(this.f2681a)) {
                    return true;
                }
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                float f = x2 - this.f2696q;
                float f2 = y2 - this.f2697r;
                int iM3164d = this.f2685e.m3164d();
                if ((f * f) + (f2 * f2) >= iM3164d * iM3164d || !this.f2685e.m3160b(this.f2681a, (int) x2, (int) y2)) {
                    return true;
                }
                m3068a(this.f2681a, 0);
                return true;
            default:
                return true;
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m3068a(View view, int i) {
        if (!this.f2699t && !m3074a(CropImageView.DEFAULT_ASPECT_RATIO, i)) {
            return false;
        }
        this.f2686f = false;
        return true;
    }

    /* JADX INFO: renamed from: b */
    private boolean m3069b(View view, int i) {
        if (!this.f2699t && !m3074a(1.0f, i)) {
            return false;
        }
        this.f2686f = true;
        return true;
    }

    /* JADX INFO: renamed from: b */
    public boolean m3076b() {
        return m3069b(this.f2681a, 0);
    }

    /* JADX INFO: renamed from: c */
    public boolean m3078c() {
        return m3068a(this.f2681a, 0);
    }

    /* JADX INFO: renamed from: d */
    public boolean m3080d() {
        return !this.f2693n || this.f2682b == 1.0f;
    }

    /* JADX INFO: renamed from: e */
    public boolean m3082e() {
        return this.f2693n;
    }

    /* JADX INFO: renamed from: a */
    void m3072a(int i) {
        if (this.f2681a == null) {
            this.f2682b = CropImageView.DEFAULT_ASPECT_RATIO;
            return;
        }
        boolean zM3083f = m3083f();
        LayoutParams layoutParams = (LayoutParams) this.f2681a.getLayoutParams();
        int width = this.f2681a.getWidth();
        if (zM3083f) {
            i = (getWidth() - i) - width;
        }
        this.f2682b = (i - ((zM3083f ? layoutParams.rightMargin : layoutParams.leftMargin) + (zM3083f ? getPaddingRight() : getPaddingLeft()))) / this.f2683c;
        if (this.f2695p != 0) {
            m3066a(this.f2682b);
        }
        if (layoutParams.f2709c) {
            m3067a(this.f2681a, this.f2682b, this.f2688i);
        }
        m3073a(this.f2681a);
    }

    /* JADX INFO: renamed from: a */
    private void m3067a(View view, float f, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f > CropImageView.DEFAULT_ASPECT_RATIO && i != 0) {
            int i2 = (((int) ((((-16777216) & i) >>> 24) * f)) << 24) | (16777215 & i);
            if (layoutParams.f2710d == null) {
                layoutParams.f2710d = new Paint();
            }
            layoutParams.f2710d.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_OVER));
            if (view.getLayerType() != 2) {
                view.setLayerType(2, layoutParams.f2710d);
            }
            m3081e(view);
            return;
        }
        if (view.getLayerType() != 0) {
            if (layoutParams.f2710d != null) {
                layoutParams.f2710d.setColorFilter(null);
            }
            DisableLayerRunnable disableLayerRunnable = new DisableLayerRunnable(view);
            this.f2687g.add(disableLayerRunnable);
            ViewCompat.m2586a(this, disableLayerRunnable);
        }
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iSave = canvas.save();
        if (this.f2693n && !layoutParams.f2708b && this.f2681a != null) {
            canvas.getClipBounds(this.f2700u);
            if (m3083f()) {
                this.f2700u.left = Math.max(this.f2700u.left, this.f2681a.getRight());
            } else {
                this.f2700u.right = Math.min(this.f2700u.right, this.f2681a.getLeft());
            }
            canvas.clipRect(this.f2700u);
        }
        boolean zDrawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    /* JADX INFO: renamed from: e */
    void m3081e(View view) {
        f2680h.mo3093a(this, view);
    }

    /* JADX INFO: renamed from: a */
    boolean m3074a(float f, int i) {
        int paddingLeft;
        if (!this.f2693n) {
            return false;
        }
        boolean zM3083f = m3083f();
        LayoutParams layoutParams = (LayoutParams) this.f2681a.getLayoutParams();
        if (zM3083f) {
            paddingLeft = (int) (getWidth() - (((layoutParams.rightMargin + getPaddingRight()) + (this.f2683c * f)) + this.f2681a.getWidth()));
        } else {
            paddingLeft = (int) (layoutParams.leftMargin + getPaddingLeft() + (this.f2683c * f));
        }
        if (!this.f2685e.m3153a(this.f2681a, paddingLeft, this.f2681a.getTop())) {
            return false;
        }
        m3071a();
        ViewCompat.m2597c(this);
        return true;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.f2685e.m3154a(true)) {
            if (!this.f2693n) {
                this.f2685e.m3168f();
            } else {
                ViewCompat.m2597c(this);
            }
        }
    }

    @Deprecated
    public void setShadowDrawable(Drawable drawable) {
        setShadowDrawableLeft(drawable);
    }

    public void setShadowDrawableLeft(Drawable drawable) {
        this.f2690k = drawable;
    }

    public void setShadowDrawableRight(Drawable drawable) {
        this.f2691l = drawable;
    }

    @Deprecated
    public void setShadowResource(int i) {
        setShadowDrawable(getResources().getDrawable(i));
    }

    public void setShadowResourceLeft(int i) {
        setShadowDrawableLeft(ContextCompat.m1832a(getContext(), i));
    }

    public void setShadowResourceRight(int i) {
        setShadowDrawableRight(ContextCompat.m1832a(getContext(), i));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Drawable drawable;
        int left;
        int right;
        super.draw(canvas);
        if (m3083f()) {
            drawable = this.f2691l;
        } else {
            drawable = this.f2690k;
        }
        View childAt = getChildCount() > 1 ? getChildAt(1) : null;
        if (childAt != null && drawable != null) {
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (m3083f()) {
                right = childAt.getRight();
                left = right + intrinsicWidth;
            } else {
                left = childAt.getLeft();
                right = left - intrinsicWidth;
            }
            drawable.setBounds(right, top, left, bottom);
            drawable.draw(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m3066a(float r10) {
        /*
            r9 = this;
            r1 = 0
            r8 = 1065353216(0x3f800000, float:1.0)
            boolean r3 = r9.m3083f()
            android.view.View r0 = r9.f2681a
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.support.v4.widget.SlidingPaneLayout$LayoutParams r0 = (android.support.v4.widget.SlidingPaneLayout.LayoutParams) r0
            boolean r2 = r0.f2709c
            if (r2 == 0) goto L30
            if (r3 == 0) goto L2d
            int r0 = r0.rightMargin
        L17:
            if (r0 > 0) goto L30
            r0 = 1
        L1a:
            int r4 = r9.getChildCount()
            r2 = r1
        L1f:
            if (r2 >= r4) goto L5d
            android.view.View r5 = r9.getChildAt(r2)
            android.view.View r1 = r9.f2681a
            if (r5 != r1) goto L32
        L29:
            int r1 = r2 + 1
            r2 = r1
            goto L1f
        L2d:
            int r0 = r0.leftMargin
            goto L17
        L30:
            r0 = r1
            goto L1a
        L32:
            float r1 = r9.f2694o
            float r1 = r8 - r1
            int r6 = r9.f2695p
            float r6 = (float) r6
            float r1 = r1 * r6
            int r1 = (int) r1
            r9.f2694o = r10
            float r6 = r8 - r10
            int r7 = r9.f2695p
            float r7 = (float) r7
            float r6 = r6 * r7
            int r6 = (int) r6
            int r1 = r1 - r6
            if (r3 == 0) goto L48
            int r1 = -r1
        L48:
            r5.offsetLeftAndRight(r1)
            if (r0 == 0) goto L29
            if (r3 == 0) goto L58
            float r1 = r9.f2694o
            float r1 = r1 - r8
        L52:
            int r6 = r9.f2689j
            r9.m3067a(r5, r1, r6)
            goto L29
        L58:
            float r1 = r9.f2694o
            float r1 = r8 - r1
            goto L52
        L5d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.SlidingPaneLayout.m3066a(float):void");
    }

    /* JADX INFO: renamed from: f */
    boolean m3084f(View view) {
        if (view == null) {
            return false;
        }
        return this.f2693n && ((LayoutParams) view.getLayoutParams()).f2709c && this.f2682b > CropImageView.DEFAULT_ASPECT_RATIO;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2711a = m3082e() ? m3080d() : this.f2686f;
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.m2474a());
        if (savedState.f2711a) {
            m3076b();
        } else {
            m3078c();
        }
        this.f2686f = savedState.f2711a;
    }

    private class DragHelperCallback extends ViewDragHelper.Callback {
        DragHelperCallback() {
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: a */
        public boolean mo548a(View view, int i) {
            if (SlidingPaneLayout.this.f2684d) {
                return false;
            }
            return ((LayoutParams) view.getLayoutParams()).f2708b;
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: a */
        public void mo545a(int i) {
            if (SlidingPaneLayout.this.f2685e.m3147a() == 0) {
                if (SlidingPaneLayout.this.f2682b == CropImageView.DEFAULT_ASPECT_RATIO) {
                    SlidingPaneLayout.this.m3079d(SlidingPaneLayout.this.f2681a);
                    SlidingPaneLayout.this.m3077c(SlidingPaneLayout.this.f2681a);
                    SlidingPaneLayout.this.f2686f = false;
                } else {
                    SlidingPaneLayout.this.m3075b(SlidingPaneLayout.this.f2681a);
                    SlidingPaneLayout.this.f2686f = true;
                }
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: b */
        public void mo841b(View view, int i) {
            SlidingPaneLayout.this.m3071a();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: a */
        public void mo547a(View view, int i, int i2, int i3, int i4) {
            SlidingPaneLayout.this.m3072a(i);
            SlidingPaneLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: a */
        public void mo546a(View view, float f, float f2) {
            int paddingLeft;
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (SlidingPaneLayout.this.m3083f()) {
                int paddingRight = layoutParams.rightMargin + SlidingPaneLayout.this.getPaddingRight();
                if (f < CropImageView.DEFAULT_ASPECT_RATIO || (f == CropImageView.DEFAULT_ASPECT_RATIO && SlidingPaneLayout.this.f2682b > 0.5f)) {
                    paddingRight += SlidingPaneLayout.this.f2683c;
                }
                paddingLeft = (SlidingPaneLayout.this.getWidth() - paddingRight) - SlidingPaneLayout.this.f2681a.getWidth();
            } else {
                paddingLeft = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
                if (f > CropImageView.DEFAULT_ASPECT_RATIO || (f == CropImageView.DEFAULT_ASPECT_RATIO && SlidingPaneLayout.this.f2682b > 0.5f)) {
                    paddingLeft += SlidingPaneLayout.this.f2683c;
                }
            }
            SlidingPaneLayout.this.f2685e.m3151a(paddingLeft, view.getTop());
            SlidingPaneLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: b */
        public int mo840b(View view) {
            return SlidingPaneLayout.this.f2683c;
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: b */
        public int mo549b(View view, int i, int i2) {
            LayoutParams layoutParams = (LayoutParams) SlidingPaneLayout.this.f2681a.getLayoutParams();
            if (SlidingPaneLayout.this.m3083f()) {
                int width = SlidingPaneLayout.this.getWidth() - ((layoutParams.rightMargin + SlidingPaneLayout.this.getPaddingRight()) + SlidingPaneLayout.this.f2681a.getWidth());
                return Math.max(Math.min(i, width), width - SlidingPaneLayout.this.f2683c);
            }
            int paddingLeft = layoutParams.leftMargin + SlidingPaneLayout.this.getPaddingLeft();
            return Math.min(Math.max(i, paddingLeft), SlidingPaneLayout.this.f2683c + paddingLeft);
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: a */
        public int mo544a(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: b */
        public void mo3010b(int i, int i2) {
            SlidingPaneLayout.this.f2685e.m3150a(SlidingPaneLayout.this.f2681a, i2);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: e */
        private static final int[] f2706e = {R.attr.layout_weight};

        /* JADX INFO: renamed from: a */
        public float f2707a;

        /* JADX INFO: renamed from: b */
        boolean f2708b;

        /* JADX INFO: renamed from: c */
        boolean f2709c;

        /* JADX INFO: renamed from: d */
        Paint f2710d;

        public LayoutParams() {
            super(-1, -1);
            this.f2707a = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2707a = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2707a = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2707a = CropImageView.DEFAULT_ASPECT_RATIO;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2706e);
            this.f2707a = typedArrayObtainStyledAttributes.getFloat(0, CropImageView.DEFAULT_ASPECT_RATIO);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.v4.widget.SlidingPaneLayout.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        boolean f2711a;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2711a = parcel.readInt() != 0;
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2711a ? 1 : 0);
        }
    }

    static class SlidingPanelLayoutImplBase implements SlidingPanelLayoutImpl {
        SlidingPanelLayoutImplBase() {
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        /* JADX INFO: renamed from: a */
        public void mo3093a(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.m2577a(slidingPaneLayout, view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    static class SlidingPanelLayoutImplJB extends SlidingPanelLayoutImplBase {

        /* JADX INFO: renamed from: a */
        private Method f2712a;

        /* JADX INFO: renamed from: b */
        private Field f2713b;

        SlidingPanelLayoutImplJB() {
            try {
                this.f2712a = View.class.getDeclaredMethod("getDisplayList", (Class[]) null);
            } catch (NoSuchMethodException e) {
                Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", e);
            }
            try {
                this.f2713b = View.class.getDeclaredField("mRecreateDisplayList");
                this.f2713b.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", e2);
            }
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase, android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        /* JADX INFO: renamed from: a */
        public void mo3093a(SlidingPaneLayout slidingPaneLayout, View view) {
            if (this.f2712a != null && this.f2713b != null) {
                try {
                    this.f2713b.setBoolean(view, true);
                    this.f2712a.invoke(view, (Object[]) null);
                } catch (Exception e) {
                    Log.e("SlidingPaneLayout", "Error refreshing display list state", e);
                }
                super.mo3093a(slidingPaneLayout, view);
                return;
            }
            view.invalidate();
        }
    }

    static class SlidingPanelLayoutImplJBMR1 extends SlidingPanelLayoutImplBase {
        SlidingPanelLayoutImplJBMR1() {
        }

        @Override // android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImplBase, android.support.v4.widget.SlidingPaneLayout.SlidingPanelLayoutImpl
        /* JADX INFO: renamed from: a */
        public void mo3093a(SlidingPaneLayout slidingPaneLayout, View view) {
            ViewCompat.m2579a(view, ((LayoutParams) view.getLayoutParams()).f2710d);
        }
    }

    class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: c */
        private final Rect f2702c = new Rect();

        AccessibilityDelegate() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        /* JADX INFO: renamed from: a */
        public void mo365a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatM2778a = AccessibilityNodeInfoCompat.m2778a(accessibilityNodeInfoCompat);
            super.mo365a(view, accessibilityNodeInfoCompatM2778a);
            m3085a(accessibilityNodeInfoCompat, accessibilityNodeInfoCompatM2778a);
            accessibilityNodeInfoCompatM2778a.m2832t();
            accessibilityNodeInfoCompat.m2793b((CharSequence) SlidingPaneLayout.class.getName());
            accessibilityNodeInfoCompat.m2784a(view);
            Object objM2602f = ViewCompat.m2602f(view);
            if (objM2602f instanceof View) {
                accessibilityNodeInfoCompat.m2798c((View) objM2602f);
            }
            int childCount = SlidingPaneLayout.this.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = SlidingPaneLayout.this.getChildAt(i);
                if (!m3086b(childAt) && childAt.getVisibility() == 0) {
                    ViewCompat.m2575a(childAt, 1);
                    accessibilityNodeInfoCompat.m2792b(childAt);
                }
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        /* JADX INFO: renamed from: a */
        public void mo559a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo559a(view, accessibilityEvent);
            accessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        /* JADX INFO: renamed from: a */
        public boolean mo2481a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (m3086b(view)) {
                return false;
            }
            return super.mo2481a(viewGroup, view, accessibilityEvent);
        }

        /* JADX INFO: renamed from: b */
        public boolean m3086b(View view) {
            return SlidingPaneLayout.this.m3084f(view);
        }

        /* JADX INFO: renamed from: a */
        private void m3085a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f2702c;
            accessibilityNodeInfoCompat2.m2783a(rect);
            accessibilityNodeInfoCompat.m2791b(rect);
            accessibilityNodeInfoCompat2.m2797c(rect);
            accessibilityNodeInfoCompat.m2801d(rect);
            accessibilityNodeInfoCompat.m2807e(accessibilityNodeInfoCompat2.m2814h());
            accessibilityNodeInfoCompat.m2785a(accessibilityNodeInfoCompat2.m2828p());
            accessibilityNodeInfoCompat.m2793b(accessibilityNodeInfoCompat2.m2829q());
            accessibilityNodeInfoCompat.m2803d(accessibilityNodeInfoCompat2.m2831s());
            accessibilityNodeInfoCompat.m2817j(accessibilityNodeInfoCompat2.m2824m());
            accessibilityNodeInfoCompat.m2813h(accessibilityNodeInfoCompat2.m2820k());
            accessibilityNodeInfoCompat.m2800c(accessibilityNodeInfoCompat2.m2810f());
            accessibilityNodeInfoCompat.m2804d(accessibilityNodeInfoCompat2.m2812g());
            accessibilityNodeInfoCompat.m2809f(accessibilityNodeInfoCompat2.m2816i());
            accessibilityNodeInfoCompat.m2811g(accessibilityNodeInfoCompat2.m2818j());
            accessibilityNodeInfoCompat.m2815i(accessibilityNodeInfoCompat2.m2822l());
            accessibilityNodeInfoCompat.m2782a(accessibilityNodeInfoCompat2.m2789b());
            accessibilityNodeInfoCompat.m2790b(accessibilityNodeInfoCompat2.m2796c());
        }
    }

    private class DisableLayerRunnable implements Runnable {

        /* JADX INFO: renamed from: a */
        final View f2703a;

        DisableLayerRunnable(View view) {
            this.f2703a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2703a.getParent() == SlidingPaneLayout.this) {
                this.f2703a.setLayerType(0, null);
                SlidingPaneLayout.this.m3081e(this.f2703a);
            }
            SlidingPaneLayout.this.f2687g.remove(this);
        }
    }

    /* JADX INFO: renamed from: f */
    boolean m3083f() {
        return ViewCompat.m2601e(this) == 1;
    }
}
