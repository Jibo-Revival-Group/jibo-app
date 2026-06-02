package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.coreui.R;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.util.Pools;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.NestedScrollingParent2;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v4.widget.DirectedAcyclicGraph;
import android.support.v4.widget.ViewGroupUtils;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.yalantis.ucrop.util.FileUtils;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2 {

    /* JADX INFO: renamed from: a */
    static final String f669a;

    /* JADX INFO: renamed from: b */
    static final Class<?>[] f670b;

    /* JADX INFO: renamed from: c */
    static final ThreadLocal<Map<String, Constructor<Behavior>>> f671c;

    /* JADX INFO: renamed from: d */
    static final Comparator<View> f672d;

    /* JADX INFO: renamed from: f */
    private static final Pools.Pool<Rect> f673f;

    /* JADX INFO: renamed from: e */
    ViewGroup.OnHierarchyChangeListener f674e;

    /* JADX INFO: renamed from: g */
    private final List<View> f675g;

    /* JADX INFO: renamed from: h */
    private final DirectedAcyclicGraph<View> f676h;

    /* JADX INFO: renamed from: i */
    private final List<View> f677i;

    /* JADX INFO: renamed from: j */
    private final List<View> f678j;

    /* JADX INFO: renamed from: k */
    private final int[] f679k;

    /* JADX INFO: renamed from: l */
    private Paint f680l;

    /* JADX INFO: renamed from: m */
    private boolean f681m;

    /* JADX INFO: renamed from: n */
    private boolean f682n;

    /* JADX INFO: renamed from: o */
    private int[] f683o;

    /* JADX INFO: renamed from: p */
    private View f684p;

    /* JADX INFO: renamed from: q */
    private View f685q;

    /* JADX INFO: renamed from: r */
    private OnPreDrawListener f686r;

    /* JADX INFO: renamed from: s */
    private boolean f687s;

    /* JADX INFO: renamed from: t */
    private WindowInsetsCompat f688t;

    /* JADX INFO: renamed from: u */
    private boolean f689u;

    /* JADX INFO: renamed from: v */
    private Drawable f690v;

    /* JADX INFO: renamed from: w */
    private OnApplyWindowInsetsListener f691w;

    /* JADX INFO: renamed from: x */
    private final NestedScrollingParentHelper f692x;

    public interface AttachedBehavior {
        /* JADX INFO: renamed from: a */
        Behavior m674a();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Deprecated
    public @interface DefaultBehavior {
        /* JADX INFO: renamed from: a */
        Class<? extends Behavior> m687a();
    }

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        f669a = r0 != null ? r0.getName() : null;
        if (Build.VERSION.SDK_INT >= 21) {
            f672d = new ViewElevationComparator();
        } else {
            f672d = null;
        }
        f670b = new Class[]{Context.class, AttributeSet.class};
        f671c = new ThreadLocal<>();
        f673f = new Pools.SynchronizedPool(12);
    }

    /* JADX INFO: renamed from: e */
    private static Rect m641e() {
        Rect rectMo2438a = f673f.mo2438a();
        if (rectMo2438a == null) {
            return new Rect();
        }
        return rectMo2438a;
    }

    /* JADX INFO: renamed from: a */
    private static void m626a(Rect rect) {
        rect.setEmpty();
        f673f.mo2439a(rect);
    }

    public CoordinatorLayout(Context context) {
        this(context, null);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.coordinatorLayoutStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        TypedArray typedArrayObtainStyledAttributes;
        super(context, attributeSet, i);
        this.f675g = new ArrayList();
        this.f676h = new DirectedAcyclicGraph<>();
        this.f677i = new ArrayList();
        this.f678j = new ArrayList();
        this.f679k = new int[2];
        this.f692x = new NestedScrollingParentHelper(this);
        if (i == 0) {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
        } else {
            typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout, i, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            this.f683o = resources.getIntArray(resourceId);
            float f = resources.getDisplayMetrics().density;
            int length = this.f683o.length;
            for (int i2 = 0; i2 < length; i2++) {
                this.f683o[i2] = (int) (this.f683o[i2] * f);
            }
        }
        this.f690v = typedArrayObtainStyledAttributes.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
        typedArrayObtainStyledAttributes.recycle();
        m646g();
        super.setOnHierarchyChangeListener(new HierarchyChangeListener());
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f674e = onHierarchyChangeListener;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m632a(false);
        if (this.f687s) {
            if (this.f686r == null) {
                this.f686r = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f686r);
        }
        if (this.f688t == null && ViewCompat.m2614r(this)) {
            ViewCompat.m2613q(this);
        }
        this.f682n = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m632a(false);
        if (this.f687s && this.f686r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f686r);
        }
        if (this.f685q != null) {
            onStopNestedScroll(this.f685q);
        }
        this.f682n = false;
    }

    public void setStatusBarBackground(Drawable drawable) {
        if (this.f690v != drawable) {
            if (this.f690v != null) {
                this.f690v.setCallback(null);
            }
            this.f690v = drawable != null ? drawable.mutate() : null;
            if (this.f690v != null) {
                if (this.f690v.isStateful()) {
                    this.f690v.setState(getDrawableState());
                }
                DrawableCompat.m1995b(this.f690v, ViewCompat.m2601e(this));
                this.f690v.setVisible(getVisibility() == 0, false);
                this.f690v.setCallback(this);
            }
            ViewCompat.m2597c(this);
        }
    }

    public Drawable getStatusBarBackground() {
        return this.f690v;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        boolean state = false;
        Drawable drawable = this.f690v;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f690v;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        if (this.f690v != null && this.f690v.isVisible() != z) {
            this.f690v.setVisible(z, false);
        }
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? ContextCompat.m1832a(getContext(), i) : null);
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    /* JADX INFO: renamed from: a */
    final WindowInsetsCompat m650a(WindowInsetsCompat windowInsetsCompat) {
        if (!ObjectsCompat.m2436a(this.f688t, windowInsetsCompat)) {
            this.f688t = windowInsetsCompat;
            this.f689u = windowInsetsCompat != null && windowInsetsCompat.m2770b() > 0;
            setWillNotDraw(!this.f689u && getBackground() == null);
            WindowInsetsCompat windowInsetsCompatM635b = m635b(windowInsetsCompat);
            requestLayout();
            return windowInsetsCompatM635b;
        }
        return windowInsetsCompat;
    }

    public final WindowInsetsCompat getLastWindowInsets() {
        return this.f688t;
    }

    /* JADX INFO: renamed from: a */
    private void m632a(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            Behavior behaviorM699b = ((LayoutParams) childAt.getLayoutParams()).m699b();
            if (behaviorM699b != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0);
                if (z) {
                    behaviorM699b.mo510a(this, childAt, motionEventObtain);
                } else {
                    behaviorM699b.mo539b(this, childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((LayoutParams) getChildAt(i2).getLayoutParams()).m705f();
        }
        this.f684p = null;
        this.f681m = false;
    }

    /* JADX INFO: renamed from: a */
    private void m631a(List<View> list) {
        list.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i = childCount - 1; i >= 0; i--) {
            list.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i) : i));
        }
        if (f672d != null) {
            Collections.sort(list, f672d);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m633a(MotionEvent motionEvent, int i) {
        boolean z;
        MotionEvent motionEventObtain;
        boolean z2;
        boolean zMo539b = false;
        boolean z3 = false;
        MotionEvent motionEvent2 = null;
        int actionMasked = motionEvent.getActionMasked();
        List<View> list = this.f677i;
        m631a(list);
        int size = list.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                View view = list.get(i2);
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                Behavior behaviorM699b = layoutParams.m699b();
                if ((zMo539b || z3) && actionMasked != 0) {
                    if (behaviorM699b != null) {
                        if (motionEvent2 == null) {
                            long jUptimeMillis = SystemClock.uptimeMillis();
                            motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, CropImageView.DEFAULT_ASPECT_RATIO, CropImageView.DEFAULT_ASPECT_RATIO, 0);
                        } else {
                            motionEventObtain = motionEvent2;
                        }
                        switch (i) {
                            case 0:
                                behaviorM699b.mo510a(this, view, motionEventObtain);
                                break;
                            case 1:
                                behaviorM699b.mo539b(this, view, motionEventObtain);
                                break;
                        }
                        z2 = z3;
                        z = zMo539b;
                    } else {
                        motionEventObtain = motionEvent2;
                        z = zMo539b;
                        z2 = z3;
                    }
                } else {
                    if (!zMo539b && behaviorM699b != null) {
                        switch (i) {
                            case 0:
                                zMo539b = behaviorM699b.mo510a(this, view, motionEvent);
                                break;
                            case 1:
                                zMo539b = behaviorM699b.mo539b(this, view, motionEvent);
                                break;
                        }
                        if (zMo539b) {
                            this.f684p = view;
                        }
                    }
                    z = zMo539b;
                    boolean zM704e = layoutParams.m704e();
                    boolean zM697a = layoutParams.m697a(this, view);
                    boolean z4 = zM697a && !zM704e;
                    if (!zM697a || z4) {
                        MotionEvent motionEvent3 = motionEvent2;
                        z2 = z4;
                        motionEventObtain = motionEvent3;
                    }
                }
                i2++;
                z3 = z2;
                zMo539b = z;
                motionEvent2 = motionEventObtain;
            } else {
                z = zMo539b;
            }
        }
        list.clear();
        return z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = null;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m632a(true);
        }
        boolean zM633a = m633a(motionEvent, 0);
        if (0 != 0) {
            motionEvent2.recycle();
        }
        if (actionMasked == 1 || actionMasked == 3) {
            m632a(true);
        }
        return zM633a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r12) {
        /*
            r11 = this;
            r4 = 3
            r10 = 1
            r5 = 0
            r7 = 0
            r2 = 0
            int r9 = r12.getActionMasked()
            android.view.View r0 = r11.f684p
            if (r0 != 0) goto L5d
            boolean r0 = r11.m633a(r12, r10)
            if (r0 == 0) goto L5a
            r1 = r0
        L14:
            android.view.View r0 = r11.f684p
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()
            android.support.design.widget.CoordinatorLayout$LayoutParams r0 = (android.support.design.widget.CoordinatorLayout.LayoutParams) r0
            android.support.design.widget.CoordinatorLayout$Behavior r0 = r0.m699b()
            if (r0 == 0) goto L58
            android.view.View r3 = r11.f684p
            boolean r0 = r0.mo539b(r11, r3, r12)
            r8 = r0
        L29:
            android.view.View r0 = r11.f684p
            if (r0 != 0) goto L43
            boolean r0 = super.onTouchEvent(r12)
            r8 = r8 | r0
        L32:
            if (r8 != 0) goto L36
            if (r9 != 0) goto L36
        L36:
            if (r2 == 0) goto L3b
            r2.recycle()
        L3b:
            if (r9 == r10) goto L3f
            if (r9 != r4) goto L42
        L3f:
            r11.m632a(r7)
        L42:
            return r8
        L43:
            if (r1 == 0) goto L32
            if (r2 != 0) goto L56
            long r0 = android.os.SystemClock.uptimeMillis()
            r2 = r0
            r6 = r5
            android.view.MotionEvent r0 = android.view.MotionEvent.obtain(r0, r2, r4, r5, r6, r7)
        L51:
            super.onTouchEvent(r0)
            r2 = r0
            goto L32
        L56:
            r0 = r2
            goto L51
        L58:
            r8 = r7
            goto L29
        L5a:
            r1 = r0
            r8 = r7
            goto L29
        L5d:
            r1 = r7
            goto L14
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z && !this.f681m) {
            m632a(false);
            this.f681m = true;
        }
    }

    /* JADX INFO: renamed from: b */
    private int m634b(int i) {
        if (this.f683o == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i < 0 || i >= this.f683o.length) {
            Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
            return 0;
        }
        return this.f683o[i];
    }

    /* JADX INFO: renamed from: a */
    static Behavior m625a(Context context, AttributeSet attributeSet, String str) {
        Map map;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith(FileUtils.HIDDEN_PREFIX)) {
            str = context.getPackageName() + str;
        } else if (str.indexOf(46) < 0 && !TextUtils.isEmpty(f669a)) {
            str = f669a + '.' + str;
        }
        try {
            Map<String, Constructor<Behavior>> map2 = f671c.get();
            if (map2 == null) {
                HashMap map3 = new HashMap();
                f671c.set(map3);
                map = map3;
            } else {
                map = map2;
            }
            Constructor<?> constructor = (Constructor) map.get(str);
            if (constructor == null) {
                constructor = context.getClassLoader().loadClass(str).getConstructor(f670b);
                constructor.setAccessible(true);
                map.put(str, constructor);
            }
            return (Behavior) constructor.newInstance(context, attributeSet);
        } catch (Exception e) {
            throw new RuntimeException("Could not inflate Behavior subclass " + str, e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    LayoutParams m648a(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f696b) {
            if (view instanceof AttachedBehavior) {
                Behavior behaviorM674a = ((AttachedBehavior) view).m674a();
                if (behaviorM674a == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                layoutParams.m695a(behaviorM674a);
                layoutParams.f696b = true;
            } else {
                DefaultBehavior defaultBehavior = null;
                for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                    defaultBehavior = (DefaultBehavior) superclass.getAnnotation(DefaultBehavior.class);
                    if (defaultBehavior != null) {
                        break;
                    }
                }
                DefaultBehavior defaultBehavior2 = defaultBehavior;
                if (defaultBehavior2 != null) {
                    try {
                        layoutParams.m695a(defaultBehavior2.m687a().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                    } catch (Exception e) {
                        Log.e("CoordinatorLayout", "Default behavior class " + defaultBehavior2.m687a().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                    }
                }
                layoutParams.f696b = true;
            }
        }
        return layoutParams;
    }

    /* JADX INFO: renamed from: f */
    private void m644f() {
        this.f675g.clear();
        this.f676h.m2948a();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            LayoutParams layoutParamsM648a = m648a(childAt);
            layoutParamsM648a.m700b(this, childAt);
            this.f676h.m2949a(childAt);
            for (int i2 = 0; i2 < childCount; i2++) {
                if (i2 != i) {
                    View childAt2 = getChildAt(i2);
                    if (layoutParamsM648a.m698a(this, childAt, childAt2)) {
                        if (!this.f676h.m2952b(childAt2)) {
                            this.f676h.m2949a(childAt2);
                        }
                        this.f676h.m2950a(childAt2, childAt);
                    }
                }
            }
        }
        this.f675g.addAll(this.f676h.m2951b());
        Collections.reverse(this.f675g);
    }

    /* JADX INFO: renamed from: a */
    void m658a(View view, Rect rect) {
        ViewGroupUtils.m3172b(this, view, rect);
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: renamed from: a */
    public void m654a(View view, int i, int i2, int i3, int i4) {
        measureChildWithMargins(view, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iMakeMeasureSpec;
        int iMakeMeasureSpec2;
        int iMax;
        int iCombineMeasuredStates;
        int i3;
        m644f();
        m651a();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int iM2601e = ViewCompat.m2601e(this);
        boolean z = iM2601e == 1;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = paddingLeft + paddingRight;
        int i5 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        int suggestedMinimumHeight = getSuggestedMinimumHeight();
        int i6 = 0;
        boolean z2 = this.f688t != null && ViewCompat.m2614r(this);
        int size3 = this.f675g.size();
        int i7 = 0;
        while (i7 < size3) {
            View view = this.f675g.get(i7);
            if (view.getVisibility() == 8) {
                iCombineMeasuredStates = i6;
                iMax = suggestedMinimumHeight;
                i3 = suggestedMinimumWidth;
            } else {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                int iMax2 = 0;
                if (layoutParams.f699e >= 0 && mode != 0) {
                    int iM634b = m634b(layoutParams.f699e);
                    int iM2508a = GravityCompat.m2508a(m638d(layoutParams.f697c), iM2601e) & 7;
                    if ((iM2508a == 3 && !z) || (iM2508a == 5 && z)) {
                        iMax2 = Math.max(0, (size - paddingRight) - iM634b);
                    } else if ((iM2508a == 5 && !z) || (iM2508a == 3 && z)) {
                        iMax2 = Math.max(0, iM634b - paddingLeft);
                    }
                }
                if (!z2 || ViewCompat.m2614r(view)) {
                    iMakeMeasureSpec = i2;
                    iMakeMeasureSpec2 = i;
                } else {
                    int iM2768a = this.f688t.m2768a() + this.f688t.m2771c();
                    int iM2770b = this.f688t.m2770b() + this.f688t.m2772d();
                    iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(size - iM2768a, mode);
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size2 - iM2770b, mode2);
                }
                Behavior behaviorM699b = layoutParams.m699b();
                if (behaviorM699b == null || !behaviorM699b.mo456a(this, view, iMakeMeasureSpec2, iMax2, iMakeMeasureSpec, 0)) {
                    m654a(view, iMakeMeasureSpec2, iMax2, iMakeMeasureSpec, 0);
                }
                int iMax3 = Math.max(suggestedMinimumWidth, view.getMeasuredWidth() + i4 + layoutParams.leftMargin + layoutParams.rightMargin);
                iMax = Math.max(suggestedMinimumHeight, view.getMeasuredHeight() + i5 + layoutParams.topMargin + layoutParams.bottomMargin);
                iCombineMeasuredStates = View.combineMeasuredStates(i6, view.getMeasuredState());
                i3 = iMax3;
            }
            i7++;
            i6 = iCombineMeasuredStates;
            suggestedMinimumHeight = iMax;
            suggestedMinimumWidth = i3;
        }
        setMeasuredDimension(View.resolveSizeAndState(suggestedMinimumWidth, i, (-16777216) & i6), View.resolveSizeAndState(suggestedMinimumHeight, i2, i6 << 16));
    }

    /* JADX INFO: renamed from: b */
    private WindowInsetsCompat m635b(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompatM675a;
        Behavior behaviorM699b;
        if (!windowInsetsCompat.m2774f()) {
            int childCount = getChildCount();
            int i = 0;
            WindowInsetsCompat windowInsetsCompat2 = windowInsetsCompat;
            while (true) {
                if (i >= childCount) {
                    windowInsetsCompatM675a = windowInsetsCompat2;
                    break;
                }
                View childAt = getChildAt(i);
                if (!ViewCompat.m2614r(childAt) || (behaviorM699b = ((LayoutParams) childAt.getLayoutParams()).m699b()) == null) {
                    windowInsetsCompatM675a = windowInsetsCompat2;
                } else {
                    windowInsetsCompatM675a = behaviorM699b.m675a(this, childAt, windowInsetsCompat2);
                    if (windowInsetsCompatM675a.m2774f()) {
                        break;
                    }
                }
                i++;
                windowInsetsCompat2 = windowInsetsCompatM675a;
            }
            return windowInsetsCompatM675a;
        }
        return windowInsetsCompat;
    }

    /* JADX INFO: renamed from: a */
    public void m653a(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.m703d()) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        if (layoutParams.f705k != null) {
            m630a(view, layoutParams.f705k, i);
        } else if (layoutParams.f699e >= 0) {
            m636b(view, layoutParams.f699e, i);
        } else {
            m639d(view, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Behavior behaviorM699b;
        int iM2601e = ViewCompat.m2601e(this);
        int size = this.f675g.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = this.f675g.get(i5);
            if (view.getVisibility() != 8 && ((behaviorM699b = ((LayoutParams) view.getLayoutParams()).m699b()) == null || !behaviorM699b.mo455a(this, view, iM2601e))) {
                m653a(view, iM2601e);
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f689u && this.f690v != null) {
            int iM2770b = this.f688t != null ? this.f688t.m2770b() : 0;
            if (iM2770b > 0) {
                this.f690v.setBounds(0, 0, getWidth(), iM2770b);
                this.f690v.draw(canvas);
            }
        }
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        m646g();
    }

    /* JADX INFO: renamed from: b */
    void m666b(View view, Rect rect) {
        ((LayoutParams) view.getLayoutParams()).m694a(rect);
    }

    /* JADX INFO: renamed from: c */
    void m670c(View view, Rect rect) {
        rect.set(((LayoutParams) view.getLayoutParams()).m702c());
    }

    /* JADX INFO: renamed from: a */
    void m659a(View view, boolean z, Rect rect) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            m658a(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m628a(View view, int i, Rect rect, Rect rect2, LayoutParams layoutParams, int i2, int i3) {
        int iWidth;
        int iHeight;
        int iM2508a = GravityCompat.m2508a(m640e(layoutParams.f697c), i);
        int iM2508a2 = GravityCompat.m2508a(m637c(layoutParams.f698d), i);
        int i4 = iM2508a & 7;
        int i5 = iM2508a & 112;
        int i6 = iM2508a2 & 112;
        switch (iM2508a2 & 7) {
            case 1:
                iWidth = (rect.width() / 2) + rect.left;
                break;
            case 5:
                iWidth = rect.right;
                break;
            default:
                iWidth = rect.left;
                break;
        }
        switch (i6) {
            case 16:
                iHeight = rect.top + (rect.height() / 2);
                break;
            case 80:
                iHeight = rect.bottom;
                break;
            default:
                iHeight = rect.top;
                break;
        }
        switch (i4) {
            case 1:
                iWidth -= i2 / 2;
                break;
            case 5:
                break;
            default:
                iWidth -= i2;
                break;
        }
        switch (i5) {
            case 16:
                iHeight -= i3 / 2;
                break;
            case 80:
                break;
            default:
                iHeight -= i3;
                break;
        }
        rect2.set(iWidth, iHeight, iWidth + i2, iHeight + i3);
    }

    /* JADX INFO: renamed from: a */
    private void m627a(LayoutParams layoutParams, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - layoutParams.rightMargin));
        int iMax2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - layoutParams.bottomMargin));
        rect.set(iMax, iMax2, iMax + i, iMax2 + i2);
    }

    /* JADX INFO: renamed from: a */
    void m657a(View view, int i, Rect rect, Rect rect2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        m628a(view, i, rect, rect2, layoutParams, measuredWidth, measuredHeight);
        m627a(layoutParams, rect2, measuredWidth, measuredHeight);
    }

    /* JADX INFO: renamed from: a */
    private void m630a(View view, View view2, int i) {
        Rect rectM641e = m641e();
        Rect rectM641e2 = m641e();
        try {
            m658a(view2, rectM641e);
            m657a(view, i, rectM641e, rectM641e2);
            view.layout(rectM641e2.left, rectM641e2.top, rectM641e2.right, rectM641e2.bottom);
        } finally {
            m626a(rectM641e);
            m626a(rectM641e2);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m636b(View view, int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iM2508a = GravityCompat.m2508a(m638d(layoutParams.f697c), i2);
        int i3 = iM2508a & 7;
        int i4 = iM2508a & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (i2 == 1) {
            i = width - i;
        }
        int iM634b = m634b(i) - measuredWidth;
        int i5 = 0;
        switch (i3) {
            case 1:
                iM634b += measuredWidth / 2;
                break;
            case 5:
                iM634b += measuredWidth;
                break;
        }
        switch (i4) {
            case 16:
                i5 = 0 + (measuredHeight / 2);
                break;
            case 80:
                i5 = 0 + measuredHeight;
                break;
        }
        int iMax = Math.max(getPaddingLeft() + layoutParams.leftMargin, Math.min(iM634b, ((width - getPaddingRight()) - measuredWidth) - layoutParams.rightMargin));
        int iMax2 = Math.max(getPaddingTop() + layoutParams.topMargin, Math.min(i5, ((height - getPaddingBottom()) - measuredHeight) - layoutParams.bottomMargin));
        view.layout(iMax, iMax2, iMax + measuredWidth, iMax2 + measuredHeight);
    }

    /* JADX INFO: renamed from: d */
    private void m639d(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rectM641e = m641e();
        rectM641e.set(getPaddingLeft() + layoutParams.leftMargin, getPaddingTop() + layoutParams.topMargin, (getWidth() - getPaddingRight()) - layoutParams.rightMargin, (getHeight() - getPaddingBottom()) - layoutParams.bottomMargin);
        if (this.f688t != null && ViewCompat.m2614r(this) && !ViewCompat.m2614r(view)) {
            rectM641e.left += this.f688t.m2768a();
            rectM641e.top += this.f688t.m2770b();
            rectM641e.right -= this.f688t.m2771c();
            rectM641e.bottom -= this.f688t.m2772d();
        }
        Rect rectM641e2 = m641e();
        GravityCompat.m2509a(m637c(layoutParams.f697c), view.getMeasuredWidth(), view.getMeasuredHeight(), rectM641e, rectM641e2, i);
        view.layout(rectM641e2.left, rectM641e2.top, rectM641e2.right, rectM641e2.bottom);
        m626a(rectM641e);
        m626a(rectM641e2);
    }

    /* JADX INFO: renamed from: c */
    private static int m637c(int i) {
        int i2 = (i & 7) == 0 ? 8388611 | i : i;
        if ((i2 & 112) == 0) {
            return i2 | 48;
        }
        return i2;
    }

    /* JADX INFO: renamed from: d */
    private static int m638d(int i) {
        if (i == 0) {
            return 8388661;
        }
        return i;
    }

    /* JADX INFO: renamed from: e */
    private static int m640e(int i) {
        if (i == 0) {
            return 17;
        }
        return i;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f695a != null) {
            float fM684d = layoutParams.f695a.m684d(this, view);
            if (fM684d > CropImageView.DEFAULT_ASPECT_RATIO) {
                if (this.f680l == null) {
                    this.f680l = new Paint();
                }
                this.f680l.setColor(layoutParams.f695a.m682c(this, view));
                this.f680l.setAlpha(MathUtils.m2025a(Math.round(fM684d * 255.0f), 0, 255));
                int iSave = canvas.save();
                if (view.isOpaque()) {
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), Region.Op.DIFFERENCE);
                }
                canvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.f680l);
                canvas.restoreToCount(iSave);
            }
        }
        return super.drawChild(canvas, view, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x008b  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final void m652a(int r15) {
        /*
            Method dump skipped, instruction units count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.m652a(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0107  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m629a(android.view.View r11, android.graphics.Rect r12, int r13) {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.m629a(android.view.View, android.graphics.Rect, int):void");
    }

    /* JADX INFO: renamed from: e */
    private void m642e(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f703i != i) {
            ViewCompat.m2600d(view, i - layoutParams.f703i);
            layoutParams.f703i = i;
        }
    }

    /* JADX INFO: renamed from: f */
    private void m645f(View view, int i) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f704j != i) {
            ViewCompat.m2598c(view, i - layoutParams.f704j);
            layoutParams.f704j = i;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m664b(View view) {
        List listM2953c = this.f676h.m2953c(view);
        if (listM2953c != null && !listM2953c.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < listM2953c.size()) {
                    View view2 = (View) listM2953c.get(i2);
                    Behavior behaviorM699b = ((LayoutParams) view2.getLayoutParams()).m699b();
                    if (behaviorM699b != null) {
                        behaviorM699b.mo481b(this, view2, view);
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public List<View> m668c(View view) {
        List<View> listM2954d = this.f676h.m2954d(view);
        this.f678j.clear();
        if (listM2954d != null) {
            this.f678j.addAll(listM2954d);
        }
        return this.f678j;
    }

    /* JADX INFO: renamed from: d */
    public List<View> m672d(View view) {
        List listM2953c = this.f676h.m2953c(view);
        this.f678j.clear();
        if (listM2953c != null) {
            this.f678j.addAll(listM2953c);
        }
        return this.f678j;
    }

    final List<View> getDependencySortedChildren() {
        m644f();
        return Collections.unmodifiableList(this.f675g);
    }

    /* JADX INFO: renamed from: a */
    void m651a() {
        boolean z = false;
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                break;
            }
            if (!m643e(getChildAt(i))) {
                i++;
            } else {
                z = true;
                break;
            }
        }
        if (z != this.f687s) {
            if (z) {
                m663b();
            } else {
                m673o_();
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private boolean m643e(View view) {
        return this.f676h.m2955e(view);
    }

    /* JADX INFO: renamed from: b */
    void m663b() {
        if (this.f682n) {
            if (this.f686r == null) {
                this.f686r = new OnPreDrawListener();
            }
            getViewTreeObserver().addOnPreDrawListener(this.f686r);
        }
        this.f687s = true;
    }

    /* JADX INFO: renamed from: o_ */
    void m673o_() {
        if (this.f682n && this.f686r != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.f686r);
        }
        this.f687s = false;
    }

    /* JADX INFO: renamed from: b */
    void m665b(View view, int i) {
        Behavior behaviorM699b;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (layoutParams.f705k != null) {
            Rect rectM641e = m641e();
            Rect rectM641e2 = m641e();
            Rect rectM641e3 = m641e();
            m658a(layoutParams.f705k, rectM641e);
            m659a(view, false, rectM641e2);
            int measuredWidth = view.getMeasuredWidth();
            int measuredHeight = view.getMeasuredHeight();
            m628a(view, i, rectM641e, rectM641e3, layoutParams, measuredWidth, measuredHeight);
            boolean z = (rectM641e3.left == rectM641e2.left && rectM641e3.top == rectM641e2.top) ? false : true;
            m627a(layoutParams, rectM641e3, measuredWidth, measuredHeight);
            int i2 = rectM641e3.left - rectM641e2.left;
            int i3 = rectM641e3.top - rectM641e2.top;
            if (i2 != 0) {
                ViewCompat.m2600d(view, i2);
            }
            if (i3 != 0) {
                ViewCompat.m2598c(view, i3);
            }
            if (z && (behaviorM699b = layoutParams.m699b()) != null) {
                behaviorM699b.mo481b(this, view, layoutParams.f705k);
            }
            m626a(rectM641e);
            m626a(rectM641e2);
            m626a(rectM641e3);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m660a(View view, int i, int i2) {
        Rect rectM641e = m641e();
        m658a(view, rectM641e);
        try {
            return rectM641e.contains(i, i2);
        } finally {
            m626a(rectM641e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m661a(android.view.View r7, android.view.View r8) {
        /*
            r6 = this;
            r1 = 1
            r2 = 0
            int r0 = r7.getVisibility()
            if (r0 != 0) goto L57
            int r0 = r8.getVisibility()
            if (r0 != 0) goto L57
            android.graphics.Rect r3 = m641e()
            android.view.ViewParent r0 = r7.getParent()
            if (r0 == r6) goto L49
            r0 = r1
        L19:
            r6.m659a(r7, r0, r3)
            android.graphics.Rect r4 = m641e()
            android.view.ViewParent r0 = r8.getParent()
            if (r0 == r6) goto L4b
            r0 = r1
        L27:
            r6.m659a(r8, r0, r4)
            int r0 = r3.left     // Catch: java.lang.Throwable -> L4f
            int r5 = r4.right     // Catch: java.lang.Throwable -> L4f
            if (r0 > r5) goto L4d
            int r0 = r3.top     // Catch: java.lang.Throwable -> L4f
            int r5 = r4.bottom     // Catch: java.lang.Throwable -> L4f
            if (r0 > r5) goto L4d
            int r0 = r3.right     // Catch: java.lang.Throwable -> L4f
            int r5 = r4.left     // Catch: java.lang.Throwable -> L4f
            if (r0 < r5) goto L4d
            int r0 = r3.bottom     // Catch: java.lang.Throwable -> L4f
            int r5 = r4.top     // Catch: java.lang.Throwable -> L4f
            if (r0 < r5) goto L4d
        L42:
            m626a(r3)
            m626a(r4)
        L48:
            return r1
        L49:
            r0 = r2
            goto L19
        L4b:
            r0 = r2
            goto L27
        L4d:
            r1 = r2
            goto L42
        L4f:
            r0 = move-exception
            m626a(r3)
            m626a(r4)
            throw r0
        L57:
            r1 = r2
            goto L48
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.CoordinatorLayout.m661a(android.view.View, android.view.View):boolean");
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return mo662a(view, view2, i, 0);
    }

    @Override // android.support.v4.view.NestedScrollingParent2
    /* JADX INFO: renamed from: a */
    public boolean mo662a(View view, View view2, int i, int i2) {
        boolean z;
        boolean z2 = false;
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() == 8) {
                z = z2;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                Behavior behaviorM699b = layoutParams.m699b();
                if (behaviorM699b != null) {
                    boolean zMo457a = behaviorM699b.mo457a(this, childAt, view, view2, i, i2);
                    z = z2 | zMo457a;
                    layoutParams.m693a(i2, zMo457a);
                } else {
                    layoutParams.m693a(i2, false);
                    z = z2;
                }
            }
            i3++;
            z2 = z;
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        mo667b(view, view2, i, 0);
    }

    @Override // android.support.v4.view.NestedScrollingParent2
    /* JADX INFO: renamed from: b */
    public void mo667b(View view, View view2, int i, int i2) {
        Behavior behaviorM699b;
        this.f692x.m2549a(view, view2, i, i2);
        this.f685q = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.m701b(i2) && (behaviorM699b = layoutParams.m699b()) != null) {
                behaviorM699b.m681b(this, childAt, view, view2, i, i2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        mo669c(view, 0);
    }

    @Override // android.support.v4.view.NestedScrollingParent2
    /* JADX INFO: renamed from: c */
    public void mo669c(View view, int i) {
        this.f692x.m2547a(view, i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (layoutParams.m701b(i)) {
                Behavior behaviorM699b = layoutParams.m699b();
                if (behaviorM699b != null) {
                    behaviorM699b.mo447a(this, childAt, view, i);
                }
                layoutParams.m692a(i);
                layoutParams.m707h();
            }
        }
        this.f685q = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        mo655a(view, i, i2, i3, i4, 0);
    }

    @Override // android.support.v4.view.NestedScrollingParent2
    /* JADX INFO: renamed from: a */
    public void mo655a(View view, int i, int i2, int i3, int i4, int i5) {
        boolean z;
        int childCount = getChildCount();
        boolean z2 = false;
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                z = z2;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.m701b(i5)) {
                    Behavior behaviorM699b = layoutParams.m699b();
                    if (behaviorM699b != null) {
                        behaviorM699b.mo448a(this, childAt, view, i, i2, i3, i4, i5);
                        z = true;
                    } else {
                        z = z2;
                    }
                } else {
                    z = z2;
                }
            }
            i6++;
            z2 = z;
        }
        if (z2) {
            m652a(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        mo656a(view, i, i2, iArr, 0);
    }

    @Override // android.support.v4.view.NestedScrollingParent2
    /* JADX INFO: renamed from: a */
    public void mo656a(View view, int i, int i2, int[] iArr, int i3) {
        boolean z;
        int iMax;
        int iMax2;
        int i4 = 0;
        int i5 = 0;
        boolean z2 = false;
        int childCount = getChildCount();
        int i6 = 0;
        while (i6 < childCount) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() == 8) {
                z = z2;
                iMax = i4;
                iMax2 = i5;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.m701b(i3)) {
                    Behavior behaviorM699b = layoutParams.m699b();
                    if (behaviorM699b != null) {
                        int[] iArr2 = this.f679k;
                        this.f679k[1] = 0;
                        iArr2[0] = 0;
                        behaviorM699b.mo449a(this, childAt, view, i, i2, this.f679k, i3);
                        iMax = i > 0 ? Math.max(i4, this.f679k[0]) : Math.min(i4, this.f679k[0]);
                        iMax2 = i2 > 0 ? Math.max(i5, this.f679k[1]) : Math.min(i5, this.f679k[1]);
                        z = true;
                    } else {
                        z = z2;
                        iMax = i4;
                        iMax2 = i5;
                    }
                } else {
                    z = z2;
                    iMax = i4;
                    iMax2 = i5;
                }
            }
            i6++;
            i5 = iMax2;
            i4 = iMax;
            z2 = z;
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (z2) {
            m652a(1);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        boolean zM679a;
        int childCount = getChildCount();
        int i = 0;
        boolean z2 = false;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 8) {
                zM679a = z2;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.m701b(0)) {
                    Behavior behaviorM699b = layoutParams.m699b();
                    zM679a = behaviorM699b != null ? behaviorM699b.m679a(this, childAt, view, f, f2, z) | z2 : z2;
                } else {
                    zM679a = z2;
                }
            }
            i++;
            z2 = zM679a;
        }
        if (z2) {
            m652a(1);
        }
        return z2;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        boolean zMo534a;
        int childCount = getChildCount();
        int i = 0;
        boolean z = false;
        while (i < childCount) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 8) {
                zMo534a = z;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.m701b(0)) {
                    Behavior behaviorM699b = layoutParams.m699b();
                    zMo534a = behaviorM699b != null ? behaviorM699b.mo534a(this, childAt, view, f, f2) | z : z;
                } else {
                    zMo534a = z;
                }
            }
            i++;
            z = zMo534a;
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f692x.m2545a();
    }

    class OnPreDrawListener implements ViewTreeObserver.OnPreDrawListener {
        OnPreDrawListener() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            CoordinatorLayout.this.m652a(0);
            return true;
        }
    }

    static class ViewElevationComparator implements Comparator<View> {
        ViewElevationComparator() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(View view, View view2) {
            float fM2622z = ViewCompat.m2622z(view);
            float fM2622z2 = ViewCompat.m2622z(view2);
            if (fM2622z > fM2622z2) {
                return -1;
            }
            if (fM2622z < fM2622z2) {
                return 1;
            }
            return 0;
        }
    }

    public static abstract class Behavior<V extends View> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
        }

        /* JADX INFO: renamed from: a */
        public void mo676a(LayoutParams layoutParams) {
        }

        /* JADX INFO: renamed from: c */
        public void m683c() {
        }

        /* JADX INFO: renamed from: a */
        public boolean mo510a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        /* JADX INFO: renamed from: b */
        public boolean mo539b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
            return false;
        }

        /* JADX INFO: renamed from: c */
        public int m682c(CoordinatorLayout coordinatorLayout, V v) {
            return -16777216;
        }

        /* JADX INFO: renamed from: d */
        public float m684d(CoordinatorLayout coordinatorLayout, V v) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }

        /* JADX INFO: renamed from: e */
        public boolean m686e(CoordinatorLayout coordinatorLayout, V v) {
            return m684d(coordinatorLayout, v) > CropImageView.DEFAULT_ASPECT_RATIO;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo478a(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        /* JADX INFO: renamed from: b */
        public boolean mo481b(CoordinatorLayout coordinatorLayout, V v, View view) {
            return false;
        }

        /* JADX INFO: renamed from: d */
        public void mo685d(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        /* JADX INFO: renamed from: a */
        public boolean mo456a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo455a(CoordinatorLayout coordinatorLayout, V v, int i) {
            return false;
        }

        @Deprecated
        /* JADX INFO: renamed from: a */
        public boolean mo535a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo457a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                return mo535a(coordinatorLayout, v, view, view2, i);
            }
            return false;
        }

        @Deprecated
        /* JADX INFO: renamed from: b */
        public void m680b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i) {
        }

        /* JADX INFO: renamed from: b */
        public void m681b(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
            if (i2 == 0) {
                m680b(coordinatorLayout, v, view, view2, i);
            }
        }

        @Deprecated
        /* JADX INFO: renamed from: c */
        public void mo541c(CoordinatorLayout coordinatorLayout, V v, View view) {
        }

        /* JADX INFO: renamed from: a */
        public void mo447a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
            if (i == 0) {
                mo541c(coordinatorLayout, v, view);
            }
        }

        @Deprecated
        /* JADX INFO: renamed from: a */
        public void m677a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4) {
        }

        /* JADX INFO: renamed from: a */
        public void mo448a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5) {
            if (i5 == 0) {
                m677a(coordinatorLayout, v, view, i, i2, i3, i4);
            }
        }

        @Deprecated
        /* JADX INFO: renamed from: a */
        public void mo531a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr) {
        }

        /* JADX INFO: renamed from: a */
        public void mo449a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
            if (i3 == 0) {
                mo531a(coordinatorLayout, v, view, i, i2, iArr);
            }
        }

        /* JADX INFO: renamed from: a */
        public boolean m679a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2, boolean z) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo534a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public WindowInsetsCompat m675a(CoordinatorLayout coordinatorLayout, V v, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo477a(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public void mo446a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        }

        /* JADX INFO: renamed from: b */
        public Parcelable mo462b(CoordinatorLayout coordinatorLayout, V v) {
            return View.BaseSavedState.EMPTY_STATE;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo678a(CoordinatorLayout coordinatorLayout, V v, Rect rect) {
            return false;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a */
        Behavior f695a;

        /* JADX INFO: renamed from: b */
        boolean f696b;

        /* JADX INFO: renamed from: c */
        public int f697c;

        /* JADX INFO: renamed from: d */
        public int f698d;

        /* JADX INFO: renamed from: e */
        public int f699e;

        /* JADX INFO: renamed from: f */
        int f700f;

        /* JADX INFO: renamed from: g */
        public int f701g;

        /* JADX INFO: renamed from: h */
        public int f702h;

        /* JADX INFO: renamed from: i */
        int f703i;

        /* JADX INFO: renamed from: j */
        int f704j;

        /* JADX INFO: renamed from: k */
        View f705k;

        /* JADX INFO: renamed from: l */
        View f706l;

        /* JADX INFO: renamed from: m */
        final Rect f707m;

        /* JADX INFO: renamed from: n */
        Object f708n;

        /* JADX INFO: renamed from: o */
        private boolean f709o;

        /* JADX INFO: renamed from: p */
        private boolean f710p;

        /* JADX INFO: renamed from: q */
        private boolean f711q;

        /* JADX INFO: renamed from: r */
        private boolean f712r;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f696b = false;
            this.f697c = 0;
            this.f698d = 0;
            this.f699e = -1;
            this.f700f = -1;
            this.f701g = 0;
            this.f702h = 0;
            this.f707m = new Rect();
        }

        LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f696b = false;
            this.f697c = 0;
            this.f698d = 0;
            this.f699e = -1;
            this.f700f = -1;
            this.f701g = 0;
            this.f702h = 0;
            this.f707m = new Rect();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CoordinatorLayout_Layout);
            this.f697c = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
            this.f700f = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
            this.f698d = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
            this.f699e = typedArrayObtainStyledAttributes.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
            this.f701g = typedArrayObtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
            this.f702h = typedArrayObtainStyledAttributes.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
            this.f696b = typedArrayObtainStyledAttributes.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
            if (this.f696b) {
                this.f695a = CoordinatorLayout.m625a(context, attributeSet, typedArrayObtainStyledAttributes.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
            }
            typedArrayObtainStyledAttributes.recycle();
            if (this.f695a != null) {
                this.f695a.mo676a(this);
            }
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f696b = false;
            this.f697c = 0;
            this.f698d = 0;
            this.f699e = -1;
            this.f700f = -1;
            this.f701g = 0;
            this.f702h = 0;
            this.f707m = new Rect();
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f696b = false;
            this.f697c = 0;
            this.f698d = 0;
            this.f699e = -1;
            this.f700f = -1;
            this.f701g = 0;
            this.f702h = 0;
            this.f707m = new Rect();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f696b = false;
            this.f697c = 0;
            this.f698d = 0;
            this.f699e = -1;
            this.f700f = -1;
            this.f701g = 0;
            this.f702h = 0;
            this.f707m = new Rect();
        }

        /* JADX INFO: renamed from: a */
        public int m691a() {
            return this.f700f;
        }

        /* JADX INFO: renamed from: b */
        public Behavior m699b() {
            return this.f695a;
        }

        /* JADX INFO: renamed from: a */
        public void m695a(Behavior behavior) {
            if (this.f695a != behavior) {
                if (this.f695a != null) {
                    this.f695a.m683c();
                }
                this.f695a = behavior;
                this.f708n = null;
                this.f696b = true;
                if (behavior != null) {
                    behavior.mo676a(this);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        void m694a(Rect rect) {
            this.f707m.set(rect);
        }

        /* JADX INFO: renamed from: c */
        Rect m702c() {
            return this.f707m;
        }

        /* JADX INFO: renamed from: d */
        boolean m703d() {
            return this.f705k == null && this.f700f != -1;
        }

        /* JADX INFO: renamed from: e */
        boolean m704e() {
            if (this.f695a == null) {
                this.f709o = false;
            }
            return this.f709o;
        }

        /* JADX INFO: renamed from: a */
        boolean m697a(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f709o) {
                return true;
            }
            boolean zM686e = (this.f695a != null ? this.f695a.m686e(coordinatorLayout, view) : false) | this.f709o;
            this.f709o = zM686e;
            return zM686e;
        }

        /* JADX INFO: renamed from: f */
        void m705f() {
            this.f709o = false;
        }

        /* JADX INFO: renamed from: a */
        void m692a(int i) {
            m693a(i, false);
        }

        /* JADX INFO: renamed from: a */
        void m693a(int i, boolean z) {
            switch (i) {
                case 0:
                    this.f710p = z;
                    break;
                case 1:
                    this.f711q = z;
                    break;
            }
        }

        /* JADX INFO: renamed from: b */
        boolean m701b(int i) {
            switch (i) {
                case 0:
                    return this.f710p;
                case 1:
                    return this.f711q;
                default:
                    return false;
            }
        }

        /* JADX INFO: renamed from: g */
        boolean m706g() {
            return this.f712r;
        }

        /* JADX INFO: renamed from: a */
        void m696a(boolean z) {
            this.f712r = z;
        }

        /* JADX INFO: renamed from: h */
        void m707h() {
            this.f712r = false;
        }

        /* JADX INFO: renamed from: a */
        boolean m698a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 == this.f706l || m689a(view2, ViewCompat.m2601e(coordinatorLayout)) || (this.f695a != null && this.f695a.mo478a(coordinatorLayout, view, view2));
        }

        /* JADX INFO: renamed from: b */
        View m700b(CoordinatorLayout coordinatorLayout, View view) {
            if (this.f700f == -1) {
                this.f706l = null;
                this.f705k = null;
                return null;
            }
            if (this.f705k == null || !m690b(view, coordinatorLayout)) {
                m688a(view, coordinatorLayout);
            }
            return this.f705k;
        }

        /* JADX INFO: renamed from: a */
        private void m688a(View view, CoordinatorLayout coordinatorLayout) {
            this.f705k = coordinatorLayout.findViewById(this.f700f);
            if (this.f705k != null) {
                if (this.f705k == coordinatorLayout) {
                    if (coordinatorLayout.isInEditMode()) {
                        this.f706l = null;
                        this.f705k = null;
                        return;
                    }
                    throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                }
                View view2 = this.f705k;
                for (ViewParent parent = this.f705k.getParent(); parent != coordinatorLayout && parent != null; parent = parent.getParent()) {
                    if (parent == view) {
                        if (coordinatorLayout.isInEditMode()) {
                            this.f706l = null;
                            this.f705k = null;
                            return;
                        }
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                    }
                    if (parent instanceof View) {
                        view2 = (View) parent;
                    }
                }
                this.f706l = view2;
                return;
            }
            if (coordinatorLayout.isInEditMode()) {
                this.f706l = null;
                this.f705k = null;
                return;
            }
            throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + coordinatorLayout.getResources().getResourceName(this.f700f) + " to anchor view " + view);
        }

        /* JADX INFO: renamed from: b */
        private boolean m690b(View view, CoordinatorLayout coordinatorLayout) {
            if (this.f705k.getId() != this.f700f) {
                return false;
            }
            View view2 = this.f705k;
            for (ViewParent parent = this.f705k.getParent(); parent != coordinatorLayout; parent = parent.getParent()) {
                if (parent == null || parent == view) {
                    this.f706l = null;
                    this.f705k = null;
                    return false;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
            this.f706l = view2;
            return true;
        }

        /* JADX INFO: renamed from: a */
        private boolean m689a(View view, int i) {
            int iM2508a = GravityCompat.m2508a(((LayoutParams) view.getLayoutParams()).f701g, i);
            return iM2508a != 0 && (GravityCompat.m2508a(this.f702h, i) & iM2508a) == iM2508a;
        }
    }

    private class HierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        HierarchyChangeListener() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (CoordinatorLayout.this.f674e != null) {
                CoordinatorLayout.this.f674e.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            CoordinatorLayout.this.m652a(2);
            if (CoordinatorLayout.this.f674e != null) {
                CoordinatorLayout.this.f674e.onChildViewRemoved(view, view2);
            }
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.m2474a());
        SparseArray<Parcelable> sparseArray = savedState.f714a;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behaviorM699b = m648a(childAt).m699b();
            if (id != -1 && behaviorM699b != null && (parcelable2 = sparseArray.get(id)) != null) {
                behaviorM699b.mo446a(this, childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable parcelableMo462b;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            Behavior behaviorM699b = ((LayoutParams) childAt.getLayoutParams()).m699b();
            if (id != -1 && behaviorM699b != null && (parcelableMo462b = behaviorM699b.mo462b(this, childAt)) != null) {
                sparseArray.append(id, parcelableMo462b);
            }
        }
        savedState.f714a = sparseArray;
        return savedState;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        Behavior behaviorM699b = ((LayoutParams) view.getLayoutParams()).m699b();
        if (behaviorM699b == null || !behaviorM699b.mo477a(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    /* JADX INFO: renamed from: g */
    private void m646g() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (ViewCompat.m2614r(this)) {
                if (this.f691w == null) {
                    this.f691w = new OnApplyWindowInsetsListener() { // from class: android.support.design.widget.CoordinatorLayout.1
                        @Override // android.support.v4.view.OnApplyWindowInsetsListener
                        /* JADX INFO: renamed from: a */
                        public WindowInsetsCompat mo399a(View view, WindowInsetsCompat windowInsetsCompat) {
                            return CoordinatorLayout.this.m650a(windowInsetsCompat);
                        }
                    };
                }
                ViewCompat.m2584a(this, this.f691w);
                setSystemUiVisibility(1280);
                return;
            }
            ViewCompat.m2584a(this, (OnApplyWindowInsetsListener) null);
        }
    }

    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.design.widget.CoordinatorLayout.SavedState.1
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
        SparseArray<Parcelable> f714a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            int i = parcel.readInt();
            int[] iArr = new int[i];
            parcel.readIntArray(iArr);
            Parcelable[] parcelableArray = parcel.readParcelableArray(classLoader);
            this.f714a = new SparseArray<>(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.f714a.append(iArr[i2], parcelableArray[i2]);
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            int size = this.f714a != null ? this.f714a.size() : 0;
            parcel.writeInt(size);
            int[] iArr = new int[size];
            Parcelable[] parcelableArr = new Parcelable[size];
            for (int i2 = 0; i2 < size; i2++) {
                iArr[i2] = this.f714a.keyAt(i2);
                parcelableArr[i2] = this.f714a.valueAt(i2);
            }
            parcel.writeIntArray(iArr);
            parcel.writeParcelableArray(parcelableArr, i);
        }
    }
}
