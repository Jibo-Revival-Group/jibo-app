package android.support.v4.view;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.facebook.internal.Utility;
import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ViewPager extends ViewGroup {

    /* JADX INFO: renamed from: A */
    private int f2356A;

    /* JADX INFO: renamed from: B */
    private boolean f2357B;

    /* JADX INFO: renamed from: C */
    private boolean f2358C;

    /* JADX INFO: renamed from: D */
    private int f2359D;

    /* JADX INFO: renamed from: E */
    private int f2360E;

    /* JADX INFO: renamed from: F */
    private int f2361F;

    /* JADX INFO: renamed from: G */
    private float f2362G;

    /* JADX INFO: renamed from: H */
    private float f2363H;

    /* JADX INFO: renamed from: I */
    private float f2364I;

    /* JADX INFO: renamed from: J */
    private float f2365J;

    /* JADX INFO: renamed from: K */
    private int f2366K;

    /* JADX INFO: renamed from: L */
    private VelocityTracker f2367L;

    /* JADX INFO: renamed from: M */
    private int f2368M;

    /* JADX INFO: renamed from: N */
    private int f2369N;

    /* JADX INFO: renamed from: O */
    private int f2370O;

    /* JADX INFO: renamed from: P */
    private int f2371P;

    /* JADX INFO: renamed from: Q */
    private boolean f2372Q;

    /* JADX INFO: renamed from: R */
    private EdgeEffect f2373R;

    /* JADX INFO: renamed from: S */
    private EdgeEffect f2374S;

    /* JADX INFO: renamed from: T */
    private boolean f2375T;

    /* JADX INFO: renamed from: U */
    private boolean f2376U;

    /* JADX INFO: renamed from: V */
    private boolean f2377V;

    /* JADX INFO: renamed from: W */
    private int f2378W;

    /* JADX INFO: renamed from: aa */
    private List<OnPageChangeListener> f2379aa;

    /* JADX INFO: renamed from: ab */
    private OnPageChangeListener f2380ab;

    /* JADX INFO: renamed from: ac */
    private OnPageChangeListener f2381ac;

    /* JADX INFO: renamed from: ad */
    private List<OnAdapterChangeListener> f2382ad;

    /* JADX INFO: renamed from: ae */
    private PageTransformer f2383ae;

    /* JADX INFO: renamed from: af */
    private int f2384af;

    /* JADX INFO: renamed from: ag */
    private int f2385ag;

    /* JADX INFO: renamed from: ah */
    private ArrayList<View> f2386ah;

    /* JADX INFO: renamed from: aj */
    private final Runnable f2387aj;

    /* JADX INFO: renamed from: ak */
    private int f2388ak;

    /* JADX INFO: renamed from: b */
    PagerAdapter f2389b;

    /* JADX INFO: renamed from: c */
    int f2390c;

    /* JADX INFO: renamed from: d */
    private int f2391d;

    /* JADX INFO: renamed from: g */
    private final ArrayList<ItemInfo> f2392g;

    /* JADX INFO: renamed from: h */
    private final ItemInfo f2393h;

    /* JADX INFO: renamed from: i */
    private final Rect f2394i;

    /* JADX INFO: renamed from: j */
    private int f2395j;

    /* JADX INFO: renamed from: k */
    private Parcelable f2396k;

    /* JADX INFO: renamed from: l */
    private ClassLoader f2397l;

    /* JADX INFO: renamed from: m */
    private Scroller f2398m;

    /* JADX INFO: renamed from: n */
    private boolean f2399n;

    /* JADX INFO: renamed from: o */
    private PagerObserver f2400o;

    /* JADX INFO: renamed from: p */
    private int f2401p;

    /* JADX INFO: renamed from: q */
    private Drawable f2402q;

    /* JADX INFO: renamed from: r */
    private int f2403r;

    /* JADX INFO: renamed from: s */
    private int f2404s;

    /* JADX INFO: renamed from: t */
    private float f2405t;

    /* JADX INFO: renamed from: u */
    private float f2406u;

    /* JADX INFO: renamed from: v */
    private int f2407v;

    /* JADX INFO: renamed from: w */
    private int f2408w;

    /* JADX INFO: renamed from: x */
    private boolean f2409x;

    /* JADX INFO: renamed from: y */
    private boolean f2410y;

    /* JADX INFO: renamed from: z */
    private boolean f2411z;

    /* JADX INFO: renamed from: a */
    static final int[] f2352a = {R.attr.layout_gravity};

    /* JADX INFO: renamed from: e */
    private static final Comparator<ItemInfo> f2354e = new Comparator<ItemInfo>() { // from class: android.support.v4.view.ViewPager.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.f2416b - itemInfo2.f2416b;
        }
    };

    /* JADX INFO: renamed from: f */
    private static final Interpolator f2355f = new Interpolator() { // from class: android.support.v4.view.ViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };

    /* JADX INFO: renamed from: ai */
    private static final ViewPositionComparator f2353ai = new ViewPositionComparator();

    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DecorView {
    }

    public interface OnAdapterChangeListener {
        /* JADX INFO: renamed from: a */
        void mo877a(ViewPager viewPager, PagerAdapter pagerAdapter, PagerAdapter pagerAdapter2);
    }

    public interface OnPageChangeListener {
        /* JADX INFO: renamed from: a */
        void mo906a(int i);

        /* JADX INFO: renamed from: a */
        void mo907a(int i, float f, int i2);

        /* JADX INFO: renamed from: b */
        void mo908b(int i);
    }

    public interface PageTransformer {
        /* JADX INFO: renamed from: a */
        void mo2732a(View view, float f);
    }

    static class ItemInfo {

        /* JADX INFO: renamed from: a */
        Object f2415a;

        /* JADX INFO: renamed from: b */
        int f2416b;

        /* JADX INFO: renamed from: c */
        boolean f2417c;

        /* JADX INFO: renamed from: d */
        float f2418d;

        /* JADX INFO: renamed from: e */
        float f2419e;

        ItemInfo() {
        }
    }

    public ViewPager(Context context) {
        super(context);
        this.f2392g = new ArrayList<>();
        this.f2393h = new ItemInfo();
        this.f2394i = new Rect();
        this.f2395j = -1;
        this.f2396k = null;
        this.f2397l = null;
        this.f2405t = -3.4028235E38f;
        this.f2406u = Float.MAX_VALUE;
        this.f2356A = 1;
        this.f2366K = -1;
        this.f2375T = true;
        this.f2376U = false;
        this.f2387aj = new Runnable() { // from class: android.support.v4.view.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.m2726c();
            }
        };
        this.f2388ak = 0;
        m2707a();
    }

    public ViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2392g = new ArrayList<>();
        this.f2393h = new ItemInfo();
        this.f2394i = new Rect();
        this.f2395j = -1;
        this.f2396k = null;
        this.f2397l = null;
        this.f2405t = -3.4028235E38f;
        this.f2406u = Float.MAX_VALUE;
        this.f2356A = 1;
        this.f2366K = -1;
        this.f2375T = true;
        this.f2376U = false;
        this.f2387aj = new Runnable() { // from class: android.support.v4.view.ViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                ViewPager.this.setScrollState(0);
                ViewPager.this.m2726c();
            }
        };
        this.f2388ak = 0;
        m2707a();
    }

    /* JADX INFO: renamed from: a */
    void m2707a() {
        setWillNotDraw(false);
        setDescendantFocusability(MediaHttpUploader.MINIMUM_CHUNK_SIZE);
        setFocusable(true);
        Context context = getContext();
        this.f2398m = new Scroller(context, f2355f);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f2361F = viewConfiguration.getScaledPagingTouchSlop();
        this.f2368M = (int) (400.0f * f);
        this.f2369N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f2373R = new EdgeEffect(context);
        this.f2374S = new EdgeEffect(context);
        this.f2370O = (int) (25.0f * f);
        this.f2371P = (int) (2.0f * f);
        this.f2359D = (int) (16.0f * f);
        ViewCompat.m2583a(this, new MyAccessibilityDelegate());
        if (ViewCompat.m2599d(this) == 0) {
            ViewCompat.m2575a((View) this, 1);
        }
        ViewCompat.m2584a(this, new OnApplyWindowInsetsListener() { // from class: android.support.v4.view.ViewPager.4

            /* JADX INFO: renamed from: b */
            private final Rect f2414b = new Rect();

            @Override // android.support.v4.view.OnApplyWindowInsetsListener
            /* JADX INFO: renamed from: a */
            public WindowInsetsCompat mo399a(View view, WindowInsetsCompat windowInsetsCompat) {
                WindowInsetsCompat windowInsetsCompatM2573a = ViewCompat.m2573a(view, windowInsetsCompat);
                if (!windowInsetsCompatM2573a.m2774f()) {
                    Rect rect = this.f2414b;
                    rect.left = windowInsetsCompatM2573a.m2768a();
                    rect.top = windowInsetsCompatM2573a.m2770b();
                    rect.right = windowInsetsCompatM2573a.m2771c();
                    rect.bottom = windowInsetsCompatM2573a.m2772d();
                    int childCount = ViewPager.this.getChildCount();
                    for (int i = 0; i < childCount; i++) {
                        WindowInsetsCompat windowInsetsCompatM2591b = ViewCompat.m2591b(ViewPager.this.getChildAt(i), windowInsetsCompatM2573a);
                        rect.left = Math.min(windowInsetsCompatM2591b.m2768a(), rect.left);
                        rect.top = Math.min(windowInsetsCompatM2591b.m2770b(), rect.top);
                        rect.right = Math.min(windowInsetsCompatM2591b.m2771c(), rect.right);
                        rect.bottom = Math.min(windowInsetsCompatM2591b.m2772d(), rect.bottom);
                    }
                    return windowInsetsCompatM2573a.m2769a(rect.left, rect.top, rect.right, rect.bottom);
                }
                return windowInsetsCompatM2573a;
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.f2387aj);
        if (this.f2398m != null && !this.f2398m.isFinished()) {
            this.f2398m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    void setScrollState(int i) {
        if (this.f2388ak != i) {
            this.f2388ak = i;
            if (this.f2383ae != null) {
                m2692b(i != 0);
            }
            m2699f(i);
        }
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        if (this.f2389b != null) {
            this.f2389b.m2561c((DataSetObserver) null);
            this.f2389b.mo1619a((ViewGroup) this);
            for (int i = 0; i < this.f2392g.size(); i++) {
                ItemInfo itemInfo = this.f2392g.get(i);
                this.f2389b.mo1620a((ViewGroup) this, itemInfo.f2416b, itemInfo.f2415a);
            }
            this.f2389b.mo1623b((ViewGroup) this);
            this.f2392g.clear();
            m2698f();
            this.f2390c = 0;
            scrollTo(0, 0);
        }
        PagerAdapter pagerAdapter2 = this.f2389b;
        this.f2389b = pagerAdapter;
        this.f2391d = 0;
        if (this.f2389b != null) {
            if (this.f2400o == null) {
                this.f2400o = new PagerObserver();
            }
            this.f2389b.m2561c(this.f2400o);
            this.f2411z = false;
            boolean z = this.f2375T;
            this.f2375T = true;
            this.f2391d = this.f2389b.mo2555b();
            if (this.f2395j >= 0) {
                this.f2389b.mo1618a(this.f2396k, this.f2397l);
                m2712a(this.f2395j, false, true);
                this.f2395j = -1;
                this.f2396k = null;
                this.f2397l = null;
            } else if (!z) {
                m2726c();
            } else {
                requestLayout();
            }
        }
        if (this.f2382ad != null && !this.f2382ad.isEmpty()) {
            int size = this.f2382ad.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f2382ad.get(i2).mo877a(this, pagerAdapter2, pagerAdapter);
            }
        }
    }

    /* JADX INFO: renamed from: f */
    private void m2698f() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < getChildCount()) {
                if (!((LayoutParams) getChildAt(i2).getLayoutParams()).f2420a) {
                    removeViewAt(i2);
                    i2--;
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public PagerAdapter getAdapter() {
        return this.f2389b;
    }

    /* JADX INFO: renamed from: a */
    public void m2714a(OnAdapterChangeListener onAdapterChangeListener) {
        if (this.f2382ad == null) {
            this.f2382ad = new ArrayList();
        }
        this.f2382ad.add(onAdapterChangeListener);
    }

    /* JADX INFO: renamed from: b */
    public void m2723b(OnAdapterChangeListener onAdapterChangeListener) {
        if (this.f2382ad != null) {
            this.f2382ad.remove(onAdapterChangeListener);
        }
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        this.f2411z = false;
        m2712a(i, !this.f2375T, false);
    }

    /* JADX INFO: renamed from: a */
    public void m2711a(int i, boolean z) {
        this.f2411z = false;
        m2712a(i, z, false);
    }

    public int getCurrentItem() {
        return this.f2390c;
    }

    /* JADX INFO: renamed from: a */
    void m2712a(int i, boolean z, boolean z2) {
        m2713a(i, z, z2, 0);
    }

    /* JADX INFO: renamed from: a */
    void m2713a(int i, boolean z, boolean z2, int i2) {
        if (this.f2389b == null || this.f2389b.mo2555b() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z2 && this.f2390c == i && this.f2392g.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i < 0) {
            i = 0;
        } else if (i >= this.f2389b.mo2555b()) {
            i = this.f2389b.mo2555b() - 1;
        }
        int i3 = this.f2356A;
        if (i > this.f2390c + i3 || i < this.f2390c - i3) {
            for (int i4 = 0; i4 < this.f2392g.size(); i4++) {
                this.f2392g.get(i4).f2417c = true;
            }
        }
        boolean z3 = this.f2390c != i;
        if (this.f2375T) {
            this.f2390c = i;
            if (z3) {
                m2697e(i);
            }
            requestLayout();
            return;
        }
        m2708a(i);
        m2686a(i, z, i2, z3);
    }

    /* JADX INFO: renamed from: a */
    private void m2686a(int i, boolean z, int i2, boolean z2) {
        int iMax;
        ItemInfo itemInfoM2720b = m2720b(i);
        if (itemInfoM2720b != null) {
            iMax = (int) (Math.max(this.f2405t, Math.min(itemInfoM2720b.f2419e, this.f2406u)) * getClientWidth());
        } else {
            iMax = 0;
        }
        if (z) {
            m2710a(iMax, 0, i2);
            if (z2) {
                m2697e(i);
                return;
            }
            return;
        }
        if (z2) {
            m2697e(i);
        }
        m2689a(false);
        scrollTo(iMax, 0);
        m2696d(iMax);
    }

    @Deprecated
    public void setOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        this.f2380ab = onPageChangeListener;
    }

    /* JADX INFO: renamed from: a */
    public void m2715a(OnPageChangeListener onPageChangeListener) {
        if (this.f2379aa == null) {
            this.f2379aa = new ArrayList();
        }
        this.f2379aa.add(onPageChangeListener);
    }

    /* JADX INFO: renamed from: b */
    public void m2724b(OnPageChangeListener onPageChangeListener) {
        if (this.f2379aa != null) {
            this.f2379aa.remove(onPageChangeListener);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2716a(boolean z, PageTransformer pageTransformer) {
        m2717a(z, pageTransformer, 2);
    }

    /* JADX INFO: renamed from: a */
    public void m2717a(boolean z, PageTransformer pageTransformer, int i) {
        boolean z2 = pageTransformer != null;
        boolean z3 = z2 != (this.f2383ae != null);
        this.f2383ae = pageTransformer;
        setChildrenDrawingOrderEnabled(z2);
        if (z2) {
            this.f2385ag = z ? 2 : 1;
            this.f2384af = i;
        } else {
            this.f2385ag = 0;
        }
        if (z3) {
            m2726c();
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.f2385ag == 2) {
            i2 = (i - 1) - i2;
        }
        return ((LayoutParams) this.f2386ah.get(i2).getLayoutParams()).f2425f;
    }

    /* JADX INFO: renamed from: c */
    OnPageChangeListener m2725c(OnPageChangeListener onPageChangeListener) {
        OnPageChangeListener onPageChangeListener2 = this.f2381ac;
        this.f2381ac = onPageChangeListener;
        return onPageChangeListener2;
    }

    public int getOffscreenPageLimit() {
        return this.f2356A;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.f2356A) {
            this.f2356A = i;
            m2726c();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.f2401p;
        this.f2401p = i;
        int width = getWidth();
        m2685a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.f2401p;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f2402q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(ContextCompat.m1832a(getContext(), i));
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2402q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f2402q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    /* JADX INFO: renamed from: a */
    float m2704a(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    /* JADX INFO: renamed from: a */
    void m2710a(int i, int i2, int i3) {
        int scrollX;
        int iAbs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if ((this.f2398m == null || this.f2398m.isFinished()) ? false : true) {
            int currX = this.f2399n ? this.f2398m.getCurrX() : this.f2398m.getStartX();
            this.f2398m.abortAnimation();
            setScrollingCacheEnabled(false);
            scrollX = currX;
        } else {
            scrollX = getScrollX();
        }
        int scrollY = getScrollY();
        int i4 = i - scrollX;
        int i5 = i2 - scrollY;
        if (i4 == 0 && i5 == 0) {
            m2689a(false);
            m2726c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientWidth = getClientWidth();
        int i6 = clientWidth / 2;
        float fM2704a = (i6 * m2704a(Math.min(1.0f, (Math.abs(i4) * 1.0f) / clientWidth))) + i6;
        int iAbs2 = Math.abs(i3);
        if (iAbs2 > 0) {
            iAbs = Math.round(1000.0f * Math.abs(fM2704a / iAbs2)) * 4;
        } else {
            iAbs = (int) (((Math.abs(i4) / ((clientWidth * this.f2389b.m2562d(this.f2390c)) + this.f2401p)) + 1.0f) * 100.0f);
        }
        int iMin = Math.min(iAbs, 600);
        this.f2399n = false;
        this.f2398m.startScroll(scrollX, scrollY, i4, i5, iMin);
        ViewCompat.m2597c(this);
    }

    /* JADX INFO: renamed from: a */
    ItemInfo m2705a(int i, int i2) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.f2416b = i;
        itemInfo.f2415a = this.f2389b.mo1617a((ViewGroup) this, i);
        itemInfo.f2418d = this.f2389b.m2562d(i);
        if (i2 < 0 || i2 >= this.f2392g.size()) {
            this.f2392g.add(itemInfo);
        } else {
            this.f2392g.add(i2, itemInfo);
        }
        return itemInfo;
    }

    /* JADX INFO: renamed from: b */
    void m2722b() {
        int i;
        boolean z;
        int iMax;
        boolean z2;
        int iMo2555b = this.f2389b.mo2555b();
        this.f2391d = iMo2555b;
        boolean z3 = this.f2392g.size() < (this.f2356A * 2) + 1 && this.f2392g.size() < iMo2555b;
        boolean z4 = false;
        int i2 = this.f2390c;
        boolean z5 = z3;
        int i3 = 0;
        while (i3 < this.f2392g.size()) {
            ItemInfo itemInfo = this.f2392g.get(i3);
            int iM2550a = this.f2389b.m2550a(itemInfo.f2415a);
            if (iM2550a == -1) {
                i = i3;
                z = z4;
                iMax = i2;
                z2 = z5;
            } else if (iM2550a == -2) {
                this.f2392g.remove(i3);
                int i4 = i3 - 1;
                if (!z4) {
                    this.f2389b.mo1619a((ViewGroup) this);
                    z4 = true;
                }
                this.f2389b.mo1620a((ViewGroup) this, itemInfo.f2416b, itemInfo.f2415a);
                if (this.f2390c == itemInfo.f2416b) {
                    i = i4;
                    z = z4;
                    iMax = Math.max(0, Math.min(this.f2390c, iMo2555b - 1));
                    z2 = true;
                } else {
                    i = i4;
                    z = z4;
                    iMax = i2;
                    z2 = true;
                }
            } else if (itemInfo.f2416b != iM2550a) {
                if (itemInfo.f2416b == this.f2390c) {
                    i2 = iM2550a;
                }
                itemInfo.f2416b = iM2550a;
                i = i3;
                z = z4;
                iMax = i2;
                z2 = true;
            } else {
                i = i3;
                z = z4;
                iMax = i2;
                z2 = z5;
            }
            z5 = z2;
            i2 = iMax;
            z4 = z;
            i3 = i + 1;
        }
        if (z4) {
            this.f2389b.mo1623b((ViewGroup) this);
        }
        Collections.sort(this.f2392g, f2354e);
        if (z5) {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i5).getLayoutParams();
                if (!layoutParams.f2420a) {
                    layoutParams.f2422c = CropImageView.DEFAULT_ASPECT_RATIO;
                }
            }
            m2712a(i2, false, true);
            requestLayout();
        }
    }

    /* JADX INFO: renamed from: c */
    void m2726c() {
        m2708a(this.f2390c);
    }

    /* JADX INFO: renamed from: a */
    void m2708a(int i) {
        ItemInfo itemInfo;
        String hexString;
        int i2;
        ItemInfo itemInfo2;
        ItemInfo itemInfoM2706a;
        if (this.f2390c == i) {
            itemInfo = null;
        } else {
            ItemInfo itemInfoM2720b = m2720b(this.f2390c);
            this.f2390c = i;
            itemInfo = itemInfoM2720b;
        }
        if (this.f2389b == null) {
            m2700g();
            return;
        }
        if (this.f2411z) {
            m2700g();
            return;
        }
        if (getWindowToken() != null) {
            this.f2389b.mo1619a((ViewGroup) this);
            int i3 = this.f2356A;
            int iMax = Math.max(0, this.f2390c - i3);
            int iMo2555b = this.f2389b.mo2555b();
            int iMin = Math.min(iMo2555b - 1, i3 + this.f2390c);
            if (iMo2555b != this.f2391d) {
                try {
                    hexString = getResources().getResourceName(getId());
                } catch (Resources.NotFoundException e) {
                    hexString = Integer.toHexString(getId());
                }
                throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.f2391d + ", found: " + iMo2555b + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.f2389b.getClass());
            }
            int i4 = 0;
            while (true) {
                i2 = i4;
                if (i2 >= this.f2392g.size()) {
                    break;
                }
                itemInfo2 = this.f2392g.get(i2);
                if (itemInfo2.f2416b < this.f2390c) {
                    i4 = i2 + 1;
                } else if (itemInfo2.f2416b != this.f2390c) {
                    break;
                }
            }
            itemInfo2 = null;
            ItemInfo itemInfoM2705a = (itemInfo2 != null || iMo2555b <= 0) ? itemInfo2 : m2705a(this.f2390c, i2);
            if (itemInfoM2705a != null) {
                int i5 = i2 - 1;
                ItemInfo itemInfo3 = i5 >= 0 ? this.f2392g.get(i5) : null;
                int clientWidth = getClientWidth();
                float paddingLeft = clientWidth <= 0 ? CropImageView.DEFAULT_ASPECT_RATIO : (2.0f - itemInfoM2705a.f2418d) + (getPaddingLeft() / clientWidth);
                float f = 0.0f;
                int i6 = i2;
                int i7 = i5;
                for (int i8 = this.f2390c - 1; i8 >= 0; i8--) {
                    if (f >= paddingLeft && i8 < iMax) {
                        if (itemInfo3 == null) {
                            break;
                        }
                        if (i8 == itemInfo3.f2416b && !itemInfo3.f2417c) {
                            this.f2392g.remove(i7);
                            this.f2389b.mo1620a((ViewGroup) this, i8, itemInfo3.f2415a);
                            i7--;
                            i6--;
                            itemInfo3 = i7 >= 0 ? this.f2392g.get(i7) : null;
                        }
                    } else if (itemInfo3 != null && i8 == itemInfo3.f2416b) {
                        f += itemInfo3.f2418d;
                        i7--;
                        itemInfo3 = i7 >= 0 ? this.f2392g.get(i7) : null;
                    } else {
                        f += m2705a(i8, i7 + 1).f2418d;
                        i6++;
                        itemInfo3 = i7 >= 0 ? this.f2392g.get(i7) : null;
                    }
                }
                float f2 = itemInfoM2705a.f2418d;
                int i9 = i6 + 1;
                if (f2 < 2.0f) {
                    ItemInfo itemInfo4 = i9 < this.f2392g.size() ? this.f2392g.get(i9) : null;
                    float paddingRight = clientWidth <= 0 ? 0.0f : (getPaddingRight() / clientWidth) + 2.0f;
                    ItemInfo itemInfo5 = itemInfo4;
                    int i10 = i9;
                    int i11 = this.f2390c + 1;
                    while (i11 < iMo2555b) {
                        if (f2 >= paddingRight && i11 > iMin) {
                            if (itemInfo5 == null) {
                                break;
                            }
                            if (i11 == itemInfo5.f2416b && !itemInfo5.f2417c) {
                                this.f2392g.remove(i10);
                                this.f2389b.mo1620a((ViewGroup) this, i11, itemInfo5.f2415a);
                                itemInfo5 = i10 < this.f2392g.size() ? this.f2392g.get(i10) : null;
                            }
                        } else if (itemInfo5 != null && i11 == itemInfo5.f2416b) {
                            f2 += itemInfo5.f2418d;
                            i10++;
                            itemInfo5 = i10 < this.f2392g.size() ? this.f2392g.get(i10) : null;
                        } else {
                            ItemInfo itemInfoM2705a2 = m2705a(i11, i10);
                            i10++;
                            f2 += itemInfoM2705a2.f2418d;
                            itemInfo5 = i10 < this.f2392g.size() ? this.f2392g.get(i10) : null;
                        }
                        i11++;
                        itemInfo5 = itemInfo5;
                        f2 = f2;
                    }
                }
                m2687a(itemInfoM2705a, i6, itemInfo);
                this.f2389b.mo1624b((ViewGroup) this, this.f2390c, itemInfoM2705a.f2415a);
            }
            this.f2389b.mo1623b((ViewGroup) this);
            int childCount = getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                layoutParams.f2425f = i12;
                if (!layoutParams.f2420a && layoutParams.f2422c == CropImageView.DEFAULT_ASPECT_RATIO && (itemInfoM2706a = m2706a(childAt)) != null) {
                    layoutParams.f2422c = itemInfoM2706a.f2418d;
                    layoutParams.f2424e = itemInfoM2706a.f2416b;
                }
            }
            m2700g();
            if (hasFocus()) {
                View viewFindFocus = findFocus();
                ItemInfo itemInfoM2721b = viewFindFocus != null ? m2721b(viewFindFocus) : null;
                if (itemInfoM2721b == null || itemInfoM2721b.f2416b != this.f2390c) {
                    for (int i13 = 0; i13 < getChildCount(); i13++) {
                        View childAt2 = getChildAt(i13);
                        ItemInfo itemInfoM2706a2 = m2706a(childAt2);
                        if (itemInfoM2706a2 != null && itemInfoM2706a2.f2416b == this.f2390c && childAt2.requestFocus(2)) {
                            return;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private void m2700g() {
        if (this.f2385ag != 0) {
            if (this.f2386ah == null) {
                this.f2386ah = new ArrayList<>();
            } else {
                this.f2386ah.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.f2386ah.add(getChildAt(i));
            }
            Collections.sort(this.f2386ah, f2353ai);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2687a(ItemInfo itemInfo, int i, ItemInfo itemInfo2) {
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int iMo2555b = this.f2389b.mo2555b();
        int clientWidth = getClientWidth();
        float f = clientWidth > 0 ? this.f2401p / clientWidth : 0.0f;
        if (itemInfo2 != null) {
            int i2 = itemInfo2.f2416b;
            if (i2 < itemInfo.f2416b) {
                float fM2562d = itemInfo2.f2419e + itemInfo2.f2418d + f;
                int i3 = i2 + 1;
                int i4 = 0;
                while (i3 <= itemInfo.f2416b && i4 < this.f2392g.size()) {
                    ItemInfo itemInfo5 = this.f2392g.get(i4);
                    while (true) {
                        itemInfo4 = itemInfo5;
                        if (i3 <= itemInfo4.f2416b || i4 >= this.f2392g.size() - 1) {
                            break;
                        }
                        i4++;
                        itemInfo5 = this.f2392g.get(i4);
                    }
                    while (i3 < itemInfo4.f2416b) {
                        fM2562d += this.f2389b.m2562d(i3) + f;
                        i3++;
                    }
                    itemInfo4.f2419e = fM2562d;
                    fM2562d += itemInfo4.f2418d + f;
                    i3++;
                }
            } else if (i2 > itemInfo.f2416b) {
                int size = this.f2392g.size() - 1;
                float fM2562d2 = itemInfo2.f2419e;
                int i5 = i2 - 1;
                while (i5 >= itemInfo.f2416b && size >= 0) {
                    ItemInfo itemInfo6 = this.f2392g.get(size);
                    while (true) {
                        itemInfo3 = itemInfo6;
                        if (i5 >= itemInfo3.f2416b || size <= 0) {
                            break;
                        }
                        size--;
                        itemInfo6 = this.f2392g.get(size);
                    }
                    while (i5 > itemInfo3.f2416b) {
                        fM2562d2 -= this.f2389b.m2562d(i5) + f;
                        i5--;
                    }
                    fM2562d2 -= itemInfo3.f2418d + f;
                    itemInfo3.f2419e = fM2562d2;
                    i5--;
                }
            }
        }
        int size2 = this.f2392g.size();
        float f2 = itemInfo.f2419e;
        int i6 = itemInfo.f2416b - 1;
        this.f2405t = itemInfo.f2416b == 0 ? itemInfo.f2419e : -3.4028235E38f;
        this.f2406u = itemInfo.f2416b == iMo2555b + (-1) ? (itemInfo.f2419e + itemInfo.f2418d) - 1.0f : Float.MAX_VALUE;
        for (int i7 = i - 1; i7 >= 0; i7--) {
            ItemInfo itemInfo7 = this.f2392g.get(i7);
            float fM2562d3 = f2;
            while (i6 > itemInfo7.f2416b) {
                fM2562d3 -= this.f2389b.m2562d(i6) + f;
                i6--;
            }
            f2 = fM2562d3 - (itemInfo7.f2418d + f);
            itemInfo7.f2419e = f2;
            if (itemInfo7.f2416b == 0) {
                this.f2405t = f2;
            }
            i6--;
        }
        float f3 = itemInfo.f2419e + itemInfo.f2418d + f;
        int i8 = itemInfo.f2416b + 1;
        for (int i9 = i + 1; i9 < size2; i9++) {
            ItemInfo itemInfo8 = this.f2392g.get(i9);
            float fM2562d4 = f3;
            while (i8 < itemInfo8.f2416b) {
                fM2562d4 = this.f2389b.m2562d(i8) + f + fM2562d4;
                i8++;
            }
            if (itemInfo8.f2416b == iMo2555b - 1) {
                this.f2406u = (itemInfo8.f2418d + fM2562d4) - 1.0f;
            }
            itemInfo8.f2419e = fM2562d4;
            f3 = fM2562d4 + itemInfo8.f2418d + f;
            i8++;
        }
        this.f2376U = false;
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.v4.view.ViewPager.SavedState.1
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
        int f2428a;

        /* JADX INFO: renamed from: b */
        Parcelable f2429b;

        /* JADX INFO: renamed from: c */
        ClassLoader f2430c;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2428a);
            parcel.writeParcelable(this.f2429b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f2428a + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.f2428a = parcel.readInt();
            this.f2429b = parcel.readParcelable(classLoader);
            this.f2430c = classLoader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2428a = this.f2390c;
        if (this.f2389b != null) {
            savedState.f2429b = this.f2389b.mo1615a();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.m2474a());
        if (this.f2389b != null) {
            this.f2389b.mo1618a(savedState.f2429b, savedState.f2430c);
            m2712a(savedState.f2428a, false, true);
        } else {
            this.f2395j = savedState.f2428a;
            this.f2396k = savedState.f2429b;
            this.f2397l = savedState.f2430c;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        ViewGroup.LayoutParams layoutParamsGenerateLayoutParams = !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : layoutParams;
        LayoutParams layoutParams2 = (LayoutParams) layoutParamsGenerateLayoutParams;
        layoutParams2.f2420a |= m2695c(view);
        if (this.f2409x) {
            if (layoutParams2 != null && layoutParams2.f2420a) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.f2423d = true;
            addViewInLayout(view, i, layoutParamsGenerateLayoutParams);
            return;
        }
        super.addView(view, i, layoutParamsGenerateLayoutParams);
    }

    /* JADX INFO: renamed from: c */
    private static boolean m2695c(View view) {
        return view.getClass().getAnnotation(DecorView.class) != null;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.f2409x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    /* JADX INFO: renamed from: a */
    ItemInfo m2706a(View view) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f2392g.size()) {
                ItemInfo itemInfo = this.f2392g.get(i2);
                if (!this.f2389b.mo1621a(view, itemInfo.f2415a)) {
                    i = i2 + 1;
                } else {
                    return itemInfo;
                }
            } else {
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    ItemInfo m2721b(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent != this) {
                if (parent == null || !(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return m2706a(view);
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    ItemInfo m2720b(int i) {
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.f2392g.size()) {
                ItemInfo itemInfo = this.f2392g.get(i3);
                if (itemInfo.f2416b != i) {
                    i2 = i3 + 1;
                } else {
                    return itemInfo;
                }
            } else {
                return null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2375T = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x010a A[PHI: r1
      0x010a: PHI (r1v18 int) = (r1v17 int), (r1v20 int) binds: [B:28:0x0088, B:30:0x008f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.onMeasure(int, int):void");
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m2685a(i, i3, this.f2401p, this.f2401p);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2685a(int i, int i2, int i3, int i4) {
        if (i2 > 0 && !this.f2392g.isEmpty()) {
            if (!this.f2398m.isFinished()) {
                this.f2398m.setFinalX(getCurrentItem() * getClientWidth());
                return;
            }
            scrollTo((int) ((((i - getPaddingLeft()) - getPaddingRight()) + i3) * (getScrollX() / (((i2 - getPaddingLeft()) - getPaddingRight()) + i4))), getScrollY());
            return;
        }
        ItemInfo itemInfoM2720b = m2720b(this.f2390c);
        int iMin = (int) ((itemInfoM2720b != null ? Math.min(itemInfoM2720b.f2419e, this.f2406u) : CropImageView.DEFAULT_ASPECT_RATIO) * ((i - getPaddingLeft()) - getPaddingRight()));
        if (iMin != getScrollX()) {
            m2689a(false);
            scrollTo(iMin, getScrollY());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0141  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onLayout(boolean r18, int r19, int r20, int r21, int r22) {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public void computeScroll() {
        this.f2399n = true;
        if (!this.f2398m.isFinished() && this.f2398m.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f2398m.getCurrX();
            int currY = this.f2398m.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
                if (!m2696d(currX)) {
                    this.f2398m.abortAnimation();
                    scrollTo(0, currY);
                }
            }
            ViewCompat.m2597c(this);
            return;
        }
        m2689a(true);
    }

    /* JADX INFO: renamed from: d */
    private boolean m2696d(int i) {
        if (this.f2392g.size() == 0) {
            if (this.f2375T) {
                return false;
            }
            this.f2377V = false;
            m2709a(0, CropImageView.DEFAULT_ASPECT_RATIO, 0);
            if (this.f2377V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo itemInfoM2702i = m2702i();
        int clientWidth = getClientWidth();
        int i2 = this.f2401p + clientWidth;
        int i3 = itemInfoM2702i.f2416b;
        float f = ((i / clientWidth) - itemInfoM2702i.f2419e) / (itemInfoM2702i.f2418d + (this.f2401p / clientWidth));
        this.f2377V = false;
        m2709a(i3, f, (int) (i2 * f));
        if (!this.f2377V) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    protected void m2709a(int i, float f, int i2) {
        int measuredWidth;
        int i3;
        int i4;
        if (this.f2378W > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i5 = 0;
            while (i5 < childCount) {
                View childAt = getChildAt(i5);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f2420a) {
                    switch (layoutParams.f2421b & 7) {
                        case 1:
                            measuredWidth = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            int i6 = paddingRight;
                            i3 = paddingLeft;
                            i4 = i6;
                            break;
                        case 2:
                        case 4:
                        default:
                            measuredWidth = paddingLeft;
                            int i7 = paddingRight;
                            i3 = paddingLeft;
                            i4 = i7;
                            break;
                        case 3:
                            int width2 = childAt.getWidth() + paddingLeft;
                            int i8 = paddingLeft;
                            i4 = paddingRight;
                            i3 = width2;
                            measuredWidth = i8;
                            break;
                        case 5:
                            measuredWidth = (width - paddingRight) - childAt.getMeasuredWidth();
                            int measuredWidth2 = paddingRight + childAt.getMeasuredWidth();
                            i3 = paddingLeft;
                            i4 = measuredWidth2;
                            break;
                    }
                    int left = (measuredWidth + scrollX) - childAt.getLeft();
                    if (left != 0) {
                        childAt.offsetLeftAndRight(left);
                    }
                } else {
                    int i9 = paddingRight;
                    i3 = paddingLeft;
                    i4 = i9;
                }
                i5++;
                int i10 = i4;
                paddingLeft = i3;
                paddingRight = i10;
            }
        }
        m2691b(i, f, i2);
        if (this.f2383ae != null) {
            int scrollX2 = getScrollX();
            int childCount2 = getChildCount();
            for (int i11 = 0; i11 < childCount2; i11++) {
                View childAt2 = getChildAt(i11);
                if (!((LayoutParams) childAt2.getLayoutParams()).f2420a) {
                    this.f2383ae.mo2732a(childAt2, (childAt2.getLeft() - scrollX2) / getClientWidth());
                }
            }
        }
        this.f2377V = true;
    }

    /* JADX INFO: renamed from: b */
    private void m2691b(int i, float f, int i2) {
        if (this.f2380ab != null) {
            this.f2380ab.mo907a(i, f, i2);
        }
        if (this.f2379aa != null) {
            int size = this.f2379aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                OnPageChangeListener onPageChangeListener = this.f2379aa.get(i3);
                if (onPageChangeListener != null) {
                    onPageChangeListener.mo907a(i, f, i2);
                }
            }
        }
        if (this.f2381ac != null) {
            this.f2381ac.mo907a(i, f, i2);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m2697e(int i) {
        if (this.f2380ab != null) {
            this.f2380ab.mo908b(i);
        }
        if (this.f2379aa != null) {
            int size = this.f2379aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = this.f2379aa.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.mo908b(i);
                }
            }
        }
        if (this.f2381ac != null) {
            this.f2381ac.mo908b(i);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m2699f(int i) {
        if (this.f2380ab != null) {
            this.f2380ab.mo906a(i);
        }
        if (this.f2379aa != null) {
            int size = this.f2379aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                OnPageChangeListener onPageChangeListener = this.f2379aa.get(i2);
                if (onPageChangeListener != null) {
                    onPageChangeListener.mo906a(i);
                }
            }
        }
        if (this.f2381ac != null) {
            this.f2381ac.mo906a(i);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2689a(boolean z) {
        boolean z2 = this.f2388ak == 2;
        if (z2) {
            setScrollingCacheEnabled(false);
            if (!this.f2398m.isFinished()) {
                this.f2398m.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f2398m.getCurrX();
                int currY = this.f2398m.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m2696d(currX);
                    }
                }
            }
        }
        this.f2411z = false;
        boolean z3 = z2;
        for (int i = 0; i < this.f2392g.size(); i++) {
            ItemInfo itemInfo = this.f2392g.get(i);
            if (itemInfo.f2417c) {
                itemInfo.f2417c = false;
                z3 = true;
            }
        }
        if (z3) {
            if (z) {
                ViewCompat.m2586a(this, this.f2387aj);
            } else {
                this.f2387aj.run();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m2690a(float f, float f2) {
        return (f < ((float) this.f2360E) && f2 > CropImageView.DEFAULT_ASPECT_RATIO) || (f > ((float) (getWidth() - this.f2360E)) && f2 < CropImageView.DEFAULT_ASPECT_RATIO);
    }

    /* JADX INFO: renamed from: b */
    private void m2692b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            getChildAt(i).setLayerType(z ? this.f2384af : 0, null);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m2701h();
            return false;
        }
        if (action != 0) {
            if (this.f2357B) {
                return true;
            }
            if (this.f2358C) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f2364I = x;
                this.f2362G = x;
                float y = motionEvent.getY();
                this.f2365J = y;
                this.f2363H = y;
                this.f2366K = motionEvent.getPointerId(0);
                this.f2358C = false;
                this.f2399n = true;
                this.f2398m.computeScrollOffset();
                if (this.f2388ak == 2 && Math.abs(this.f2398m.getFinalX() - this.f2398m.getCurrX()) > this.f2371P) {
                    this.f2398m.abortAnimation();
                    this.f2411z = false;
                    m2726c();
                    this.f2357B = true;
                    m2694c(true);
                    setScrollState(1);
                } else {
                    m2689a(false);
                    this.f2357B = false;
                }
                break;
            case 2:
                int i = this.f2366K;
                if (i != -1) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(i);
                    float x2 = motionEvent.getX(iFindPointerIndex);
                    float f = x2 - this.f2362G;
                    float fAbs = Math.abs(f);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    float fAbs2 = Math.abs(y2 - this.f2365J);
                    if (f != CropImageView.DEFAULT_ASPECT_RATIO && !m2690a(this.f2362G, f) && mo2719a(this, false, (int) f, (int) x2, (int) y2)) {
                        this.f2362G = x2;
                        this.f2363H = y2;
                        this.f2358C = true;
                        return false;
                    }
                    if (fAbs > this.f2361F && 0.5f * fAbs > fAbs2) {
                        this.f2357B = true;
                        m2694c(true);
                        setScrollState(1);
                        this.f2362G = f > CropImageView.DEFAULT_ASPECT_RATIO ? this.f2364I + this.f2361F : this.f2364I - this.f2361F;
                        this.f2363H = y2;
                        setScrollingCacheEnabled(true);
                    } else if (fAbs2 > this.f2361F) {
                        this.f2358C = true;
                    }
                    if (this.f2357B && m2693b(x2)) {
                        ViewCompat.m2597c(this);
                    }
                }
                break;
            case 6:
                m2688a(motionEvent);
                break;
        }
        if (this.f2367L == null) {
            this.f2367L = VelocityTracker.obtain();
        }
        this.f2367L.addMovement(motionEvent);
        return this.f2357B;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00c4  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: renamed from: h */
    private boolean m2701h() {
        this.f2366K = -1;
        m2703j();
        this.f2373R.onRelease();
        this.f2374S.onRelease();
        return this.f2373R.isFinished() || this.f2374S.isFinished();
    }

    /* JADX INFO: renamed from: c */
    private void m2694c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m2693b(float f) {
        boolean z;
        float f2;
        boolean z2;
        boolean z3 = true;
        float f3 = this.f2362G - f;
        this.f2362G = f;
        float scrollX = getScrollX() + f3;
        int clientWidth = getClientWidth();
        float f4 = clientWidth * this.f2405t;
        float f5 = clientWidth * this.f2406u;
        ItemInfo itemInfo = this.f2392g.get(0);
        ItemInfo itemInfo2 = this.f2392g.get(this.f2392g.size() - 1);
        if (itemInfo.f2416b != 0) {
            f4 = itemInfo.f2419e * clientWidth;
            z = false;
        } else {
            z = true;
        }
        if (itemInfo2.f2416b != this.f2389b.mo2555b() - 1) {
            f2 = itemInfo2.f2419e * clientWidth;
            z2 = false;
        } else {
            f2 = f5;
            z2 = true;
        }
        if (scrollX < f4) {
            if (z) {
                this.f2373R.onPull(Math.abs(f4 - scrollX) / clientWidth);
            } else {
                z3 = false;
            }
        } else if (scrollX > f2) {
            if (z2) {
                this.f2374S.onPull(Math.abs(scrollX - f2) / clientWidth);
            } else {
                z3 = false;
            }
            f4 = f2;
        } else {
            f4 = scrollX;
            z3 = false;
        }
        this.f2362G += f4 - ((int) f4);
        scrollTo((int) f4, getScrollY());
        m2696d((int) f4);
        return z3;
    }

    /* JADX INFO: renamed from: i */
    private ItemInfo m2702i() {
        int i;
        ItemInfo itemInfo;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? getScrollX() / clientWidth : 0.0f;
        float f = clientWidth > 0 ? this.f2401p / clientWidth : 0.0f;
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i2 = -1;
        int i3 = 0;
        boolean z = true;
        ItemInfo itemInfo2 = null;
        while (i3 < this.f2392g.size()) {
            ItemInfo itemInfo3 = this.f2392g.get(i3);
            if (z || itemInfo3.f2416b == i2 + 1) {
                i = i3;
                itemInfo = itemInfo3;
            } else {
                ItemInfo itemInfo4 = this.f2393h;
                itemInfo4.f2419e = f2 + f3 + f;
                itemInfo4.f2416b = i2 + 1;
                itemInfo4.f2418d = this.f2389b.m2562d(itemInfo4.f2416b);
                i = i3 - 1;
                itemInfo = itemInfo4;
            }
            float f4 = itemInfo.f2419e;
            float f5 = itemInfo.f2418d + f4 + f;
            if (!z && scrollX < f4) {
                return itemInfo2;
            }
            if (scrollX < f5 || i == this.f2392g.size() - 1) {
                return itemInfo;
            }
            f3 = f4;
            i2 = itemInfo.f2416b;
            z = false;
            f2 = itemInfo.f2418d;
            itemInfo2 = itemInfo;
            i3 = i + 1;
        }
        return itemInfo2;
    }

    /* JADX INFO: renamed from: a */
    private int m2683a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) > this.f2370O && Math.abs(i2) > this.f2368M) {
            if (i2 <= 0) {
                i++;
            }
        } else {
            i += (int) ((i >= this.f2390c ? 0.4f : 0.6f) + f);
        }
        if (this.f2392g.size() > 0) {
            return Math.max(this.f2392g.get(0).f2416b, Math.min(i, this.f2392g.get(this.f2392g.size() - 1).f2416b));
        }
        return i;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        boolean zDraw = false;
        int overScrollMode = getOverScrollMode();
        if (overScrollMode == 0 || (overScrollMode == 1 && this.f2389b != null && this.f2389b.mo2555b() > 1)) {
            if (!this.f2373R.isFinished()) {
                int iSave = canvas.save();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                int width = getWidth();
                canvas.rotate(270.0f);
                canvas.translate((-height) + getPaddingTop(), this.f2405t * width);
                this.f2373R.setSize(height, width);
                zDraw = false | this.f2373R.draw(canvas);
                canvas.restoreToCount(iSave);
            }
            if (!this.f2374S.isFinished()) {
                int iSave2 = canvas.save();
                int width2 = getWidth();
                int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate(-getPaddingTop(), (-(this.f2406u + 1.0f)) * width2);
                this.f2374S.setSize(height2, width2);
                zDraw |= this.f2374S.draw(canvas);
                canvas.restoreToCount(iSave2);
            }
        } else {
            this.f2373R.finish();
            this.f2374S.finish();
        }
        if (zDraw) {
            ViewCompat.m2597c(this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        if (this.f2401p > 0 && this.f2402q != null && this.f2392g.size() > 0 && this.f2389b != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f2 = this.f2401p / width;
            ItemInfo itemInfo = this.f2392g.get(0);
            float f3 = itemInfo.f2419e;
            int size = this.f2392g.size();
            int i = itemInfo.f2416b;
            int i2 = this.f2392g.get(size - 1).f2416b;
            int i3 = 0;
            for (int i4 = i; i4 < i2; i4++) {
                while (i4 > itemInfo.f2416b && i3 < size) {
                    i3++;
                    itemInfo = this.f2392g.get(i3);
                }
                if (i4 == itemInfo.f2416b) {
                    f = (itemInfo.f2419e + itemInfo.f2418d) * width;
                    f3 = itemInfo.f2419e + itemInfo.f2418d + f2;
                } else {
                    float fM2562d = this.f2389b.m2562d(i4);
                    f = (f3 + fM2562d) * width;
                    f3 += fM2562d + f2;
                }
                if (this.f2401p + f > scrollX) {
                    this.f2402q.setBounds(Math.round(f), this.f2403r, Math.round(this.f2401p + f), this.f2404s);
                    this.f2402q.draw(canvas);
                }
                if (f > scrollX + width) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2688a(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f2366K) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f2362G = motionEvent.getX(i);
            this.f2366K = motionEvent.getPointerId(i);
            if (this.f2367L != null) {
                this.f2367L.clear();
            }
        }
    }

    /* JADX INFO: renamed from: j */
    private void m2703j() {
        this.f2357B = false;
        this.f2358C = false;
        if (this.f2367L != null) {
            this.f2367L.recycle();
            this.f2367L = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f2410y != z) {
            this.f2410y = z;
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        if (this.f2389b == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            return scrollX > ((int) (((float) clientWidth) * this.f2405t));
        }
        if (i > 0) {
            return scrollX < ((int) (((float) clientWidth) * this.f2406u));
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    protected boolean mo2719a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom() && mo2719a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z && view.canScrollHorizontally(-i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m2718a(keyEvent);
    }

    /* JADX INFO: renamed from: a */
    public boolean m2718a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                if (!keyEvent.hasModifiers(2)) {
                }
                break;
            case 22:
                if (!keyEvent.hasModifiers(2)) {
                }
                break;
            case 61:
                if (!keyEvent.hasNoModifiers()) {
                    if (keyEvent.hasModifiers(1)) {
                    }
                }
                break;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00de  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m2727c(int r10) {
        /*
            Method dump skipped, instruction units count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.m2727c(int):boolean");
    }

    /* JADX INFO: renamed from: a */
    private Rect m2684a(Rect rect, View view) {
        Rect rect2 = rect == null ? new Rect() : rect;
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    /* JADX INFO: renamed from: d */
    boolean m2728d() {
        if (this.f2390c <= 0) {
            return false;
        }
        m2711a(this.f2390c - 1, true);
        return true;
    }

    /* JADX INFO: renamed from: e */
    boolean m2729e() {
        if (this.f2389b == null || this.f2390c >= this.f2389b.mo2555b() - 1) {
            return false;
        }
        m2711a(this.f2390c + 1, true);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        ItemInfo itemInfoM2706a;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0 && (itemInfoM2706a = m2706a(childAt)) != null && itemInfoM2706a.f2416b == this.f2390c) {
                    childAt.addFocusables(arrayList, i, i2);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
                arrayList.add(this);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo itemInfoM2706a;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (itemInfoM2706a = m2706a(childAt)) != null && itemInfoM2706a.f2416b == this.f2390c) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        ItemInfo itemInfoM2706a;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0 && (itemInfoM2706a = m2706a(childAt)) != null && itemInfoM2706a.f2416b == this.f2390c && childAt.requestFocus(i, rect)) {
                return true;
            }
            i2 += i3;
        }
        return false;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo itemInfoM2706a;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0 && (itemInfoM2706a = m2706a(childAt)) != null && itemInfoM2706a.f2416b == this.f2390c && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
        MyAccessibilityDelegate() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        /* JADX INFO: renamed from: a */
        public void mo559a(View view, AccessibilityEvent accessibilityEvent) {
            super.mo559a(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            accessibilityEvent.setScrollable(m2731b());
            if (accessibilityEvent.getEventType() == 4096 && ViewPager.this.f2389b != null) {
                accessibilityEvent.setItemCount(ViewPager.this.f2389b.mo2555b());
                accessibilityEvent.setFromIndex(ViewPager.this.f2390c);
                accessibilityEvent.setToIndex(ViewPager.this.f2390c);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        /* JADX INFO: renamed from: a */
        public void mo365a(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.mo365a(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.m2793b((CharSequence) ViewPager.class.getName());
            accessibilityNodeInfoCompat.m2819k(m2731b());
            if (ViewPager.this.canScrollHorizontally(1)) {
                accessibilityNodeInfoCompat.m2782a(4096);
            }
            if (ViewPager.this.canScrollHorizontally(-1)) {
                accessibilityNodeInfoCompat.m2782a(Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        /* JADX INFO: renamed from: a */
        public boolean mo558a(View view, int i, Bundle bundle) {
            if (super.mo558a(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!ViewPager.this.canScrollHorizontally(1)) {
                        return false;
                    }
                    ViewPager.this.setCurrentItem(ViewPager.this.f2390c + 1);
                    return true;
                case Utility.DEFAULT_STREAM_BUFFER_SIZE /* 8192 */:
                    if (!ViewPager.this.canScrollHorizontally(-1)) {
                        return false;
                    }
                    ViewPager.this.setCurrentItem(ViewPager.this.f2390c - 1);
                    return true;
                default:
                    return false;
            }
        }

        /* JADX INFO: renamed from: b */
        private boolean m2731b() {
            return ViewPager.this.f2389b != null && ViewPager.this.f2389b.mo2555b() > 1;
        }
    }

    private class PagerObserver extends DataSetObserver {
        PagerObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            ViewPager.this.m2722b();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ViewPager.this.m2722b();
        }
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* JADX INFO: renamed from: a */
        public boolean f2420a;

        /* JADX INFO: renamed from: b */
        public int f2421b;

        /* JADX INFO: renamed from: c */
        float f2422c;

        /* JADX INFO: renamed from: d */
        boolean f2423d;

        /* JADX INFO: renamed from: e */
        int f2424e;

        /* JADX INFO: renamed from: f */
        int f2425f;

        public LayoutParams() {
            super(-1, -1);
            this.f2422c = CropImageView.DEFAULT_ASPECT_RATIO;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2422c = CropImageView.DEFAULT_ASPECT_RATIO;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f2352a);
            this.f2421b = typedArrayObtainStyledAttributes.getInteger(0, 48);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    static class ViewPositionComparator implements Comparator<View> {
        ViewPositionComparator() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            if (layoutParams.f2420a != layoutParams2.f2420a) {
                return layoutParams.f2420a ? 1 : -1;
            }
            return layoutParams.f2424e - layoutParams2.f2424e;
        }
    }
}
