package android.support.v4.widget;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {

    /* JADX INFO: renamed from: b */
    static final boolean f2586b;

    /* JADX INFO: renamed from: d */
    private static final boolean f2588d;

    /* JADX INFO: renamed from: A */
    private float f2589A;

    /* JADX INFO: renamed from: B */
    private Drawable f2590B;

    /* JADX INFO: renamed from: C */
    private Drawable f2591C;

    /* JADX INFO: renamed from: D */
    private Drawable f2592D;

    /* JADX INFO: renamed from: E */
    private CharSequence f2593E;

    /* JADX INFO: renamed from: F */
    private CharSequence f2594F;

    /* JADX INFO: renamed from: G */
    private Object f2595G;

    /* JADX INFO: renamed from: H */
    private boolean f2596H;

    /* JADX INFO: renamed from: I */
    private Drawable f2597I;

    /* JADX INFO: renamed from: J */
    private Drawable f2598J;

    /* JADX INFO: renamed from: K */
    private Drawable f2599K;

    /* JADX INFO: renamed from: L */
    private Drawable f2600L;

    /* JADX INFO: renamed from: M */
    private final ArrayList<View> f2601M;

    /* JADX INFO: renamed from: e */
    private final ChildAccessibilityDelegate f2602e;

    /* JADX INFO: renamed from: f */
    private float f2603f;

    /* JADX INFO: renamed from: g */
    private int f2604g;

    /* JADX INFO: renamed from: h */
    private int f2605h;

    /* JADX INFO: renamed from: i */
    private float f2606i;

    /* JADX INFO: renamed from: j */
    private Paint f2607j;

    /* JADX INFO: renamed from: k */
    private final ViewDragHelper f2608k;

    /* JADX INFO: renamed from: l */
    private final ViewDragHelper f2609l;

    /* JADX INFO: renamed from: m */
    private final ViewDragCallback f2610m;

    /* JADX INFO: renamed from: n */
    private final ViewDragCallback f2611n;

    /* JADX INFO: renamed from: o */
    private int f2612o;

    /* JADX INFO: renamed from: p */
    private boolean f2613p;

    /* JADX INFO: renamed from: q */
    private boolean f2614q;

    /* JADX INFO: renamed from: r */
    private int f2615r;

    /* JADX INFO: renamed from: s */
    private int f2616s;

    /* JADX INFO: renamed from: t */
    private int f2617t;

    /* JADX INFO: renamed from: u */
    private int f2618u;

    /* JADX INFO: renamed from: v */
    private boolean f2619v;

    /* JADX INFO: renamed from: w */
    private boolean f2620w;

    /* JADX INFO: renamed from: x */
    private DrawerListener f2621x;

    /* JADX INFO: renamed from: y */
    private List<DrawerListener> f2622y;

    /* JADX INFO: renamed from: z */
    private float f2623z;

    /* JADX INFO: renamed from: c */
    private static final int[] f2587c = {R.attr.colorPrimaryDark};

    /* JADX INFO: renamed from: a */
    static final int[] f2585a = {R.attr.layout_gravity};

    public interface DrawerListener {
        /* JADX INFO: renamed from: a */
        void mo2998a(int i);

        /* JADX INFO: renamed from: a */
        void mo2999a(View view);

        /* JADX INFO: renamed from: a */
        void mo3000a(View view, float f);

        /* JADX INFO: renamed from: b */
        void mo3001b(View view);
    }

    static {
        f2586b = Build.VERSION.SDK_INT >= 19;
        f2588d = Build.VERSION.SDK_INT >= 21;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2602e = new ChildAccessibilityDelegate();
        this.f2605h = -1728053248;
        this.f2607j = new Paint();
        this.f2614q = true;
        this.f2615r = 3;
        this.f2616s = 3;
        this.f2617t = 3;
        this.f2618u = 3;
        this.f2597I = null;
        this.f2598J = null;
        this.f2599K = null;
        this.f2600L = null;
        setDescendantFocusability(MediaHttpUploader.MINIMUM_CHUNK_SIZE);
        float f = getResources().getDisplayMetrics().density;
        this.f2604g = (int) ((64.0f * f) + 0.5f);
        float f2 = 400.0f * f;
        this.f2610m = new ViewDragCallback(3);
        this.f2611n = new ViewDragCallback(5);
        this.f2608k = ViewDragHelper.m3129a(this, 1.0f, this.f2610m);
        this.f2608k.m3149a(1);
        this.f2608k.m3148a(f2);
        this.f2610m.m3008a(this.f2608k);
        this.f2609l = ViewDragHelper.m3129a(this, 1.0f, this.f2611n);
        this.f2609l.m3149a(2);
        this.f2609l.m3148a(f2);
        this.f2611n.m3008a(this.f2609l);
        setFocusableInTouchMode(true);
        ViewCompat.m2575a((View) this, 1);
        ViewCompat.m2583a(this, new AccessibilityDelegate());
        setMotionEventSplittingEnabled(false);
        if (ViewCompat.m2614r(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: android.support.v4.widget.DrawerLayout.1
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    @TargetApi(21)
                    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                        ((DrawerLayout) view).m2974a(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
                        return windowInsets.consumeSystemWindowInsets();
                    }
                });
                setSystemUiVisibility(1280);
                TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(f2587c);
                try {
                    this.f2590B = typedArrayObtainStyledAttributes.getDrawable(0);
                } finally {
                    typedArrayObtainStyledAttributes.recycle();
                }
            } else {
                this.f2590B = null;
            }
        }
        this.f2603f = f * 10.0f;
        this.f2601M = new ArrayList<>();
    }

    public void setDrawerElevation(float f) {
        this.f2603f = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (m2991g(childAt)) {
                ViewCompat.m2574a(childAt, this.f2603f);
            }
        }
    }

    public float getDrawerElevation() {
        return f2588d ? this.f2603f : CropImageView.DEFAULT_ASPECT_RATIO;
    }

    /* JADX INFO: renamed from: a */
    public void m2974a(Object obj, boolean z) {
        this.f2595G = obj;
        this.f2596H = z;
        setWillNotDraw(!z && getBackground() == null);
        requestLayout();
    }

    public void setScrimColor(int i) {
        this.f2605h = i;
        invalidate();
    }

    @Deprecated
    public void setDrawerListener(DrawerListener drawerListener) {
        if (this.f2621x != null) {
            m2979b(this.f2621x);
        }
        if (drawerListener != null) {
            m2971a(drawerListener);
        }
        this.f2621x = drawerListener;
    }

    /* JADX INFO: renamed from: a */
    public void m2971a(DrawerListener drawerListener) {
        if (drawerListener != null) {
            if (this.f2622y == null) {
                this.f2622y = new ArrayList();
            }
            this.f2622y.add(drawerListener);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m2979b(DrawerListener drawerListener) {
        if (drawerListener != null && this.f2622y != null) {
            this.f2622y.remove(drawerListener);
        }
    }

    public void setDrawerLockMode(int i) {
        m2969a(i, 3);
        m2969a(i, 5);
    }

    /* JADX INFO: renamed from: a */
    public void m2969a(int i, int i2) {
        int iM2508a = GravityCompat.m2508a(i2, ViewCompat.m2601e(this));
        switch (i2) {
            case 3:
                this.f2615r = i;
                break;
            case 5:
                this.f2616s = i;
                break;
            case 8388611:
                this.f2617t = i;
                break;
            case 8388613:
                this.f2618u = i;
                break;
        }
        if (i != 0) {
            (iM2508a == 3 ? this.f2608k : this.f2609l).m3167e();
        }
        switch (i) {
            case 1:
                View viewM2984c = m2984c(iM2508a);
                if (viewM2984c != null) {
                    m2993i(viewM2984c);
                }
                break;
            case 2:
                View viewM2984c2 = m2984c(iM2508a);
                if (viewM2984c2 != null) {
                    m2992h(viewM2984c2);
                }
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0008 A[ORIG_RETURN, RETURN] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int m2966a(int r4) {
        /*
            r3 = this;
            r2 = 3
            int r0 = android.support.v4.view.ViewCompat.m2601e(r3)
            switch(r4) {
                case 3: goto La;
                case 5: goto L1b;
                case 8388611: goto L2c;
                case 8388613: goto L3d;
                default: goto L8;
            }
        L8:
            r0 = 0
        L9:
            return r0
        La:
            int r1 = r3.f2615r
            if (r1 == r2) goto L11
            int r0 = r3.f2615r
            goto L9
        L11:
            if (r0 != 0) goto L18
            int r0 = r3.f2617t
        L15:
            if (r0 == r2) goto L8
            goto L9
        L18:
            int r0 = r3.f2618u
            goto L15
        L1b:
            int r1 = r3.f2616s
            if (r1 == r2) goto L22
            int r0 = r3.f2616s
            goto L9
        L22:
            if (r0 != 0) goto L29
            int r0 = r3.f2618u
        L26:
            if (r0 == r2) goto L8
            goto L9
        L29:
            int r0 = r3.f2617t
            goto L26
        L2c:
            int r1 = r3.f2617t
            if (r1 == r2) goto L33
            int r0 = r3.f2617t
            goto L9
        L33:
            if (r0 != 0) goto L3a
            int r0 = r3.f2615r
        L37:
            if (r0 == r2) goto L8
            goto L9
        L3a:
            int r0 = r3.f2616s
            goto L37
        L3d:
            int r1 = r3.f2618u
            if (r1 == r2) goto L44
            int r0 = r3.f2618u
            goto L9
        L44:
            if (r0 != 0) goto L4b
            int r0 = r3.f2616s
        L48:
            if (r0 == r2) goto L8
            goto L9
        L4b:
            int r0 = r3.f2615r
            goto L48
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.m2966a(int):int");
    }

    /* JADX INFO: renamed from: a */
    public int m2967a(View view) {
        if (!m2991g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        return m2966a(((LayoutParams) view.getLayoutParams()).f2627a);
    }

    /* JADX INFO: renamed from: b */
    public CharSequence m2977b(int i) {
        int iM2508a = GravityCompat.m2508a(i, ViewCompat.m2601e(this));
        if (iM2508a == 3) {
            return this.f2593E;
        }
        if (iM2508a == 5) {
            return this.f2594F;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    void m2970a(int i, int i2, View view) {
        int i3;
        int iM3147a = this.f2608k.m3147a();
        int iM3147a2 = this.f2609l.m3147a();
        if (iM3147a == 1 || iM3147a2 == 1) {
            i3 = 1;
        } else {
            i3 = (iM3147a == 2 || iM3147a2 == 2) ? 2 : 0;
        }
        if (view != null && i2 == 0) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.f2628b == CropImageView.DEFAULT_ASPECT_RATIO) {
                m2980b(view);
            } else if (layoutParams.f2628b == 1.0f) {
                m2985c(view);
            }
        }
        if (i3 != this.f2612o) {
            this.f2612o = i3;
            if (this.f2622y != null) {
                for (int size = this.f2622y.size() - 1; size >= 0; size--) {
                    this.f2622y.get(size).mo2998a(i3);
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m2980b(View view) {
        View rootView;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f2630d & 1) == 1) {
            layoutParams.f2630d = 0;
            if (this.f2622y != null) {
                for (int size = this.f2622y.size() - 1; size >= 0; size--) {
                    this.f2622y.get(size).mo3001b(view);
                }
            }
            m2957c(view, false);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    void m2985c(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if ((layoutParams.f2630d & 1) == 0) {
            layoutParams.f2630d = 1;
            if (this.f2622y != null) {
                for (int size = this.f2622y.size() - 1; size >= 0; size--) {
                    this.f2622y.get(size).mo2999a(view);
                }
            }
            m2957c(view, true);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m2957c(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((!z && !m2991g(childAt)) || (z && childAt == view)) {
                ViewCompat.m2575a(childAt, 1);
            } else {
                ViewCompat.m2575a(childAt, 4);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m2972a(View view, float f) {
        if (this.f2622y != null) {
            for (int size = this.f2622y.size() - 1; size >= 0; size--) {
                this.f2622y.get(size).mo3000a(view, f);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m2981b(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.f2628b) {
            layoutParams.f2628b = f;
            m2972a(view, f);
        }
    }

    /* JADX INFO: renamed from: d */
    float m2987d(View view) {
        return ((LayoutParams) view.getLayoutParams()).f2628b;
    }

    /* JADX INFO: renamed from: e */
    int m2989e(View view) {
        return GravityCompat.m2508a(((LayoutParams) view.getLayoutParams()).f2627a, ViewCompat.m2601e(this));
    }

    /* JADX INFO: renamed from: a */
    boolean m2976a(View view, int i) {
        return (m2989e(view) & i) == i;
    }

    /* JADX INFO: renamed from: a */
    View m2968a() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((LayoutParams) childAt.getLayoutParams()).f2630d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    void m2986c(View view, float f) {
        float fM2987d = m2987d(view);
        int width = view.getWidth();
        int i = ((int) (width * f)) - ((int) (fM2987d * width));
        if (!m2976a(view, 3)) {
            i = -i;
        }
        view.offsetLeftAndRight(i);
        m2981b(view, f);
    }

    /* JADX INFO: renamed from: c */
    View m2984c(int i) {
        int iM2508a = GravityCompat.m2508a(i, ViewCompat.m2601e(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m2989e(childAt) & 7) == iM2508a) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    static String m2958d(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2614q = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2614q = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x01fe A[PHI: r2
      0x01fe: PHI (r2v55 int) = (r2v3 int), (r2v0 int) binds: [B:25:0x0060, B:5:0x0016] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 514
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    /* JADX INFO: renamed from: e */
    private void m2959e() {
        if (!f2588d) {
            this.f2591C = m2960f();
            this.f2592D = m2961g();
        }
    }

    /* JADX INFO: renamed from: f */
    private Drawable m2960f() {
        int iM2601e = ViewCompat.m2601e(this);
        if (iM2601e == 0) {
            if (this.f2597I != null) {
                m2956a(this.f2597I, iM2601e);
                return this.f2597I;
            }
        } else if (this.f2598J != null) {
            m2956a(this.f2598J, iM2601e);
            return this.f2598J;
        }
        return this.f2599K;
    }

    /* JADX INFO: renamed from: g */
    private Drawable m2961g() {
        int iM2601e = ViewCompat.m2601e(this);
        if (iM2601e == 0) {
            if (this.f2598J != null) {
                m2956a(this.f2598J, iM2601e);
                return this.f2598J;
            }
        } else if (this.f2597I != null) {
            m2956a(this.f2597I, iM2601e);
            return this.f2597I;
        }
        return this.f2600L;
    }

    /* JADX INFO: renamed from: a */
    private boolean m2956a(Drawable drawable, int i) {
        if (drawable == null || !DrawableCompat.m1994b(drawable)) {
            return false;
        }
        DrawableCompat.m1995b(drawable, i);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        float f;
        this.f2613p = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (m2990f(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m2976a(childAt, 3)) {
                        i5 = ((int) (measuredWidth * layoutParams.f2628b)) + (-measuredWidth);
                        f = (measuredWidth + i5) / measuredWidth;
                    } else {
                        i5 = i6 - ((int) (measuredWidth * layoutParams.f2628b));
                        f = (i6 - i5) / measuredWidth;
                    }
                    boolean z2 = f != layoutParams.f2628b;
                    switch (layoutParams.f2627a & 112) {
                        case 16:
                            int i8 = i4 - i2;
                            int i9 = (i8 - measuredHeight) / 2;
                            if (i9 < layoutParams.topMargin) {
                                i9 = layoutParams.topMargin;
                            } else if (i9 + measuredHeight > i8 - layoutParams.bottomMargin) {
                                i9 = (i8 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i5, i9, measuredWidth + i5, measuredHeight + i9);
                            break;
                        case 80:
                            int i10 = i4 - i2;
                            childAt.layout(i5, (i10 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i10 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(i5, layoutParams.topMargin, measuredWidth + i5, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (z2) {
                        m2981b(childAt, f);
                    }
                    int i11 = layoutParams.f2628b > CropImageView.DEFAULT_ASPECT_RATIO ? 0 : 4;
                    if (childAt.getVisibility() != i11) {
                        childAt.setVisibility(i11);
                    }
                }
            }
        }
        this.f2613p = false;
        this.f2614q = false;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f2613p) {
            super.requestLayout();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float fMax = 0.0f;
        for (int i = 0; i < childCount; i++) {
            fMax = Math.max(fMax, ((LayoutParams) getChildAt(i).getLayoutParams()).f2628b);
        }
        this.f2606i = fMax;
        boolean zM3154a = this.f2608k.m3154a(true);
        boolean zM3154a2 = this.f2609l.m3154a(true);
        if (zM3154a || zM3154a2) {
            ViewCompat.m2597c(this);
        }
    }

    /* JADX INFO: renamed from: m */
    private static boolean m2965m(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f2590B = drawable;
        invalidate();
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f2590B;
    }

    public void setStatusBarBackground(int i) {
        this.f2590B = i != 0 ? ContextCompat.m1832a(getContext(), i) : null;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.f2590B = new ColorDrawable(i);
        invalidate();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        m2959e();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2596H && this.f2590B != null) {
            int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || this.f2595G == null) ? 0 : ((WindowInsets) this.f2595G).getSystemWindowInsetTop();
            if (systemWindowInsetTop > 0) {
                this.f2590B.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.f2590B.draw(canvas);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0055  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected boolean drawChild(android.graphics.Canvas r10, android.view.View r11, long r12) {
        /*
            Method dump skipped, instruction units count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.drawChild(android.graphics.Canvas, android.view.View, long):boolean");
    }

    /* JADX INFO: renamed from: f */
    boolean m2990f(View view) {
        return ((LayoutParams) view.getLayoutParams()).f2627a == 0;
    }

    /* JADX INFO: renamed from: g */
    boolean m2991g(View view) {
        int iM2508a = GravityCompat.m2508a(((LayoutParams) view.getLayoutParams()).f2627a, ViewCompat.m2601e(view));
        return ((iM2508a & 3) == 0 && (iM2508a & 5) == 0) ? false : true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0016  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            r1 = 1
            r2 = 0
            int r0 = r8.getActionMasked()
            android.support.v4.widget.ViewDragHelper r3 = r7.f2608k
            boolean r3 = r3.m3152a(r8)
            android.support.v4.widget.ViewDragHelper r4 = r7.f2609l
            boolean r4 = r4.m3152a(r8)
            r3 = r3 | r4
            switch(r0) {
                case 0: goto L27;
                case 1: goto L65;
                case 2: goto L50;
                case 3: goto L65;
                default: goto L16;
            }
        L16:
            r0 = r2
        L17:
            if (r3 != 0) goto L25
            if (r0 != 0) goto L25
            boolean r0 = r7.m2962h()
            if (r0 != 0) goto L25
            boolean r0 = r7.f2620w
            if (r0 == 0) goto L26
        L25:
            r2 = r1
        L26:
            return r2
        L27:
            float r0 = r8.getX()
            float r4 = r8.getY()
            r7.f2623z = r0
            r7.f2589A = r4
            float r5 = r7.f2606i
            r6 = 0
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L6d
            android.support.v4.widget.ViewDragHelper r5 = r7.f2608k
            int r0 = (int) r0
            int r4 = (int) r4
            android.view.View r0 = r5.m3165d(r0, r4)
            if (r0 == 0) goto L6d
            boolean r0 = r7.m2990f(r0)
            if (r0 == 0) goto L6d
            r0 = r1
        L4b:
            r7.f2619v = r2
            r7.f2620w = r2
            goto L17
        L50:
            android.support.v4.widget.ViewDragHelper r0 = r7.f2608k
            r4 = 3
            boolean r0 = r0.m3166d(r4)
            if (r0 == 0) goto L16
            android.support.v4.widget.DrawerLayout$ViewDragCallback r0 = r7.f2610m
            r0.m3006a()
            android.support.v4.widget.DrawerLayout$ViewDragCallback r0 = r7.f2611n
            r0.m3006a()
            r0 = r2
            goto L17
        L65:
            r7.m2975a(r1)
            r7.f2619v = r2
            r7.f2620w = r2
            goto L16
        L6d:
            r0 = r2
            goto L4b
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View viewM2968a;
        this.f2608k.m3156b(motionEvent);
        this.f2609l.m3156b(motionEvent);
        switch (motionEvent.getAction() & 255) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                this.f2623z = x;
                this.f2589A = y;
                this.f2619v = false;
                this.f2620w = false;
                return true;
            case 1:
                float x2 = motionEvent.getX();
                float y2 = motionEvent.getY();
                View viewM3165d = this.f2608k.m3165d((int) x2, (int) y2);
                if (viewM3165d != null && m2990f(viewM3165d)) {
                    float f = x2 - this.f2623z;
                    float f2 = y2 - this.f2589A;
                    int iM3164d = this.f2608k.m3164d();
                    z = (f * f) + (f2 * f2) >= ((float) (iM3164d * iM3164d)) || (viewM2968a = m2968a()) == null || m2967a(viewM2968a) == 2;
                    m2975a(z);
                    this.f2619v = false;
                } else {
                    z = true;
                    m2975a(z);
                    this.f2619v = false;
                }
                return true;
            case 2:
            default:
                return true;
            case 3:
                m2975a(true);
                this.f2619v = false;
                this.f2620w = false;
                return true;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f2619v = z;
        if (z) {
            m2975a(true);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m2978b() {
        m2975a(false);
    }

    /* JADX INFO: renamed from: a */
    void m2975a(boolean z) {
        int childCount = getChildCount();
        boolean zM3153a = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (m2991g(childAt) && (!z || layoutParams.f2629c)) {
                int width = childAt.getWidth();
                if (m2976a(childAt, 3)) {
                    zM3153a |= this.f2608k.m3153a(childAt, -width, childAt.getTop());
                } else {
                    zM3153a |= this.f2609l.m3153a(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.f2629c = false;
            }
        }
        this.f2610m.m3006a();
        this.f2611n.m3006a();
        if (zM3153a) {
            invalidate();
        }
    }

    /* JADX INFO: renamed from: h */
    public void m2992h(View view) {
        m2973a(view, true);
    }

    /* JADX INFO: renamed from: a */
    public void m2973a(View view, boolean z) {
        if (!m2991g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.f2614q) {
            layoutParams.f2628b = 1.0f;
            layoutParams.f2630d = 1;
            m2957c(view, true);
        } else if (z) {
            layoutParams.f2630d |= 2;
            if (m2976a(view, 3)) {
                this.f2608k.m3153a(view, 0, view.getTop());
            } else {
                this.f2609l.m3153a(view, getWidth() - view.getWidth(), view.getTop());
            }
        } else {
            m2986c(view, 1.0f);
            m2970a(layoutParams.f2627a, 0, view);
            view.setVisibility(0);
        }
        invalidate();
    }

    /* JADX INFO: renamed from: i */
    public void m2993i(View view) {
        m2982b(view, true);
    }

    /* JADX INFO: renamed from: b */
    public void m2982b(View view, boolean z) {
        if (!m2991g(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (this.f2614q) {
            layoutParams.f2628b = CropImageView.DEFAULT_ASPECT_RATIO;
            layoutParams.f2630d = 0;
        } else if (z) {
            layoutParams.f2630d |= 4;
            if (m2976a(view, 3)) {
                this.f2608k.m3153a(view, -view.getWidth(), view.getTop());
            } else {
                this.f2609l.m3153a(view, getWidth(), view.getTop());
            }
        } else {
            m2986c(view, CropImageView.DEFAULT_ASPECT_RATIO);
            m2970a(layoutParams.f2627a, 0, view);
            view.setVisibility(4);
        }
        invalidate();
    }

    /* JADX INFO: renamed from: j */
    public boolean m2994j(View view) {
        if (m2991g(view)) {
            return (((LayoutParams) view.getLayoutParams()).f2630d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* JADX INFO: renamed from: k */
    public boolean m2995k(View view) {
        if (m2991g(view)) {
            return ((LayoutParams) view.getLayoutParams()).f2628b > CropImageView.DEFAULT_ASPECT_RATIO;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    /* JADX INFO: renamed from: h */
    private boolean m2962h() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((LayoutParams) getChildAt(i).getLayoutParams()).f2629c) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z = false;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (m2991g(childAt)) {
                    if (m2994j(childAt)) {
                        z = true;
                        childAt.addFocusables(arrayList, i, i2);
                    }
                } else {
                    this.f2601M.add(childAt);
                }
            }
            if (!z) {
                int size = this.f2601M.size();
                for (int i4 = 0; i4 < size; i4++) {
                    View view = this.f2601M.get(i4);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i, i2);
                    }
                }
            }
            this.f2601M.clear();
        }
    }

    /* JADX INFO: renamed from: i */
    private boolean m2963i() {
        return m2983c() != null;
    }

    /* JADX INFO: renamed from: c */
    View m2983c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m2991g(childAt) && m2995k(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    void m2988d() {
        if (!this.f2620w) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0);
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                getChildAt(i).dispatchTouchEvent(motionEventObtain);
            }
            motionEventObtain.recycle();
            this.f2620w = true;
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || !m2963i()) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4) {
            View viewM2983c = m2983c();
            if (viewM2983c != null && m2967a(viewM2983c) == 0) {
                m2978b();
            }
            return viewM2983c != null;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View viewM2984c;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.m2474a());
        if (savedState.f2631a != 0 && (viewM2984c = m2984c(savedState.f2631a)) != null) {
            m2992h(viewM2984c);
        }
        if (savedState.f2632b != 3) {
            m2969a(savedState.f2632b, 3);
        }
        if (savedState.f2633c != 3) {
            m2969a(savedState.f2633c, 5);
        }
        if (savedState.f2634e != 3) {
            m2969a(savedState.f2634e, 8388611);
        }
        if (savedState.f2635f != 3) {
            m2969a(savedState.f2635f, 8388613);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            boolean z = layoutParams.f2630d == 1;
            boolean z2 = layoutParams.f2630d == 2;
            if (z || z2) {
                savedState.f2631a = layoutParams.f2627a;
                break;
            }
        }
        savedState.f2632b = this.f2615r;
        savedState.f2633c = this.f2616s;
        savedState.f2634e = this.f2617t;
        savedState.f2635f = this.f2618u;
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (m2968a() != null || m2991g(view)) {
            ViewCompat.m2575a(view, 4);
        } else {
            ViewCompat.m2575a(view, 1);
        }
        if (!f2586b) {
            ViewCompat.m2583a(view, this.f2602e);
        }
    }

    /* JADX INFO: renamed from: l */
    static boolean m2964l(View view) {
        return (ViewCompat.m2599d(view) == 4 || ViewCompat.m2599d(view) == 2) ? false : true;
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.v4.widget.DrawerLayout.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
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
        int f2631a;

        /* JADX INFO: renamed from: b */
        int f2632b;

        /* JADX INFO: renamed from: c */
        int f2633c;

        /* JADX INFO: renamed from: e */
        int f2634e;

        /* JADX INFO: renamed from: f */
        int f2635f;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2631a = 0;
            this.f2631a = parcel.readInt();
            this.f2632b = parcel.readInt();
            this.f2633c = parcel.readInt();
            this.f2634e = parcel.readInt();
            this.f2635f = parcel.readInt();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f2631a = 0;
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2631a);
            parcel.writeInt(this.f2632b);
            parcel.writeInt(this.f2633c);
            parcel.writeInt(this.f2634e);
            parcel.writeInt(this.f2635f);
        }
    }

    private class ViewDragCallback extends ViewDragHelper.Callback {

        /* JADX INFO: renamed from: b */
        private final int f2637b;

        /* JADX INFO: renamed from: c */
        private ViewDragHelper f2638c;

        /* JADX INFO: renamed from: d */
        private final Runnable f2639d = new Runnable() { // from class: android.support.v4.widget.DrawerLayout.ViewDragCallback.1
            @Override // java.lang.Runnable
            public void run() {
                ViewDragCallback.this.m3009b();
            }
        };

        ViewDragCallback(int i) {
            this.f2637b = i;
        }

        /* JADX INFO: renamed from: a */
        public void m3008a(ViewDragHelper viewDragHelper) {
            this.f2638c = viewDragHelper;
        }

        /* JADX INFO: renamed from: a */
        public void m3006a() {
            DrawerLayout.this.removeCallbacks(this.f2639d);
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: a */
        public boolean mo548a(View view, int i) {
            return DrawerLayout.this.m2991g(view) && DrawerLayout.this.m2976a(view, this.f2637b) && DrawerLayout.this.m2967a(view) == 0;
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: a */
        public void mo545a(int i) {
            DrawerLayout.this.m2970a(this.f2637b, i, this.f2638c.m3161c());
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: a */
        public void mo547a(View view, int i, int i2, int i3, int i4) {
            float width;
            int width2 = view.getWidth();
            if (DrawerLayout.this.m2976a(view, 3)) {
                width = (width2 + i) / width2;
            } else {
                width = (DrawerLayout.this.getWidth() - i) / width2;
            }
            DrawerLayout.this.m2981b(view, width);
            view.setVisibility(width == CropImageView.DEFAULT_ASPECT_RATIO ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: b */
        public void mo841b(View view, int i) {
            ((LayoutParams) view.getLayoutParams()).f2629c = false;
            m3005c();
        }

        /* JADX INFO: renamed from: c */
        private void m3005c() {
            View viewM2984c = DrawerLayout.this.m2984c(this.f2637b == 3 ? 5 : 3);
            if (viewM2984c != null) {
                DrawerLayout.this.m2993i(viewM2984c);
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: a */
        public void mo546a(View view, float f, float f2) {
            int width;
            float fM2987d = DrawerLayout.this.m2987d(view);
            int width2 = view.getWidth();
            if (DrawerLayout.this.m2976a(view, 3)) {
                width = (f > CropImageView.DEFAULT_ASPECT_RATIO || (f == CropImageView.DEFAULT_ASPECT_RATIO && fM2987d > 0.5f)) ? 0 : -width2;
            } else {
                width = DrawerLayout.this.getWidth();
                if (f < CropImageView.DEFAULT_ASPECT_RATIO || (f == CropImageView.DEFAULT_ASPECT_RATIO && fM2987d > 0.5f)) {
                    width -= width2;
                }
            }
            this.f2638c.m3151a(width, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: a */
        public void mo3007a(int i, int i2) {
            DrawerLayout.this.postDelayed(this.f2639d, 160L);
        }

        /* JADX INFO: renamed from: b */
        void m3009b() {
            View view;
            int i;
            int iM3155b = this.f2638c.m3155b();
            boolean z = this.f2637b == 3;
            if (z) {
                View viewM2984c = DrawerLayout.this.m2984c(3);
                int i2 = (viewM2984c != null ? -viewM2984c.getWidth() : 0) + iM3155b;
                view = viewM2984c;
                i = i2;
            } else {
                View viewM2984c2 = DrawerLayout.this.m2984c(5);
                int width = DrawerLayout.this.getWidth() - iM3155b;
                view = viewM2984c2;
                i = width;
            }
            if (view != null) {
                if (((z && view.getLeft() < i) || (!z && view.getLeft() > i)) && DrawerLayout.this.m2967a(view) == 0) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    this.f2638c.m3153a(view, i, view.getTop());
                    layoutParams.f2629c = true;
                    DrawerLayout.this.invalidate();
                    m3005c();
                    DrawerLayout.this.m2988d();
                }
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: b */
        public boolean mo3011b(int i) {
            return false;
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: b */
        public void mo3010b(int i, int i2) {
            View viewM2984c;
            if ((i & 1) == 1) {
                viewM2984c = DrawerLayout.this.m2984c(3);
            } else {
                viewM2984c = DrawerLayout.this.m2984c(5);
            }
            if (viewM2984c != null && DrawerLayout.this.m2967a(viewM2984c) == 0) {
                this.f2638c.m3150a(viewM2984c, i2);
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: b */
        public int mo840b(View view) {
            if (DrawerLayout.this.m2991g(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: b */
        public int mo549b(View view, int i, int i2) {
            if (DrawerLayout.this.m2976a(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i, width));
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        /* JADX INFO: renamed from: a */
        public int mo544a(View view, int i, int i2) {
            return view.getTop();
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a */
        public int f2627a;

        /* JADX INFO: renamed from: b */
        float f2628b;

        /* JADX INFO: renamed from: c */
        boolean f2629c;

        /* JADX INFO: renamed from: d */
        int f2630d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2627a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f2585a);
            this.f2627a = typedArrayObtainStyledAttributes.getInt(0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f2627a = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f2627a = 0;
            this.f2627a = layoutParams.f2627a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2627a = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2627a = 0;
        }
    }

    class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: c */
        private final Rect f2626c = new Rect();

        AccessibilityDelegate() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        /* JADX INFO: renamed from: a */
        public void mo365a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (DrawerLayout.f2586b) {
                super.mo365a(view, accessibilityNodeInfoCompat);
            } else {
                AccessibilityNodeInfoCompat accessibilityNodeInfoCompatM2778a = AccessibilityNodeInfoCompat.m2778a(accessibilityNodeInfoCompat);
                super.mo365a(view, accessibilityNodeInfoCompatM2778a);
                accessibilityNodeInfoCompat.m2784a(view);
                Object objM2602f = ViewCompat.m2602f(view);
                if (objM2602f instanceof View) {
                    accessibilityNodeInfoCompat.m2798c((View) objM2602f);
                }
                m2996a(accessibilityNodeInfoCompat, accessibilityNodeInfoCompatM2778a);
                accessibilityNodeInfoCompatM2778a.m2832t();
                m2997a(accessibilityNodeInfoCompat, (ViewGroup) view);
            }
            accessibilityNodeInfoCompat.m2793b((CharSequence) DrawerLayout.class.getName());
            accessibilityNodeInfoCompat.m2800c(false);
            accessibilityNodeInfoCompat.m2804d(false);
            accessibilityNodeInfoCompat.m2788a(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2451a);
            accessibilityNodeInfoCompat.m2788a(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f2452b);
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        /* JADX INFO: renamed from: a */
        public void mo559a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo559a(view, accessibilityEvent);
            accessibilityEvent.setClassName(DrawerLayout.class.getName());
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        /* JADX INFO: renamed from: d */
        public boolean mo2483d(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.mo2483d(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View viewM2983c = DrawerLayout.this.m2983c();
            if (viewM2983c != null) {
                CharSequence charSequenceM2977b = DrawerLayout.this.m2977b(DrawerLayout.this.m2989e(viewM2983c));
                if (charSequenceM2977b != null) {
                    text.add(charSequenceM2977b);
                }
            }
            return true;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        /* JADX INFO: renamed from: a */
        public boolean mo2481a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.f2586b || DrawerLayout.m2964l(view)) {
                return super.mo2481a(viewGroup, view, accessibilityEvent);
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        private void m2997a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (DrawerLayout.m2964l(childAt)) {
                    accessibilityNodeInfoCompat.m2792b(childAt);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        private void m2996a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2) {
            Rect rect = this.f2626c;
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
        }
    }

    static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
        ChildAccessibilityDelegate() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        /* JADX INFO: renamed from: a */
        public void mo365a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo365a(view, accessibilityNodeInfoCompat);
            if (!DrawerLayout.m2964l(view)) {
                accessibilityNodeInfoCompat.m2798c((View) null);
            }
        }
    }
}
