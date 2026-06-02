package android.support.v4.view;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Display;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.yalantis.ucrop.view.CropImageView;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class ViewCompat {

    /* JADX INFO: renamed from: a */
    static final ViewCompatBaseImpl f2337a;

    static class ViewCompatBaseImpl {

        /* JADX INFO: renamed from: b */
        static Field f2341b;

        /* JADX INFO: renamed from: d */
        private static Field f2343d;

        /* JADX INFO: renamed from: e */
        private static boolean f2344e;

        /* JADX INFO: renamed from: f */
        private static Field f2345f;

        /* JADX INFO: renamed from: g */
        private static boolean f2346g;

        /* JADX INFO: renamed from: h */
        private static WeakHashMap<View, String> f2347h;

        /* JADX INFO: renamed from: a */
        WeakHashMap<View, ViewPropertyAnimatorCompat> f2349a = null;

        /* JADX INFO: renamed from: i */
        private static final AtomicInteger f2348i = new AtomicInteger(1);

        /* JADX INFO: renamed from: c */
        static boolean f2342c = false;

        ViewCompatBaseImpl() {
        }

        /* JADX INFO: renamed from: a */
        public void m2677a(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
            view.setAccessibilityDelegate(accessibilityDelegateCompat == null ? null : accessibilityDelegateCompat.m2479a());
        }

        /* JADX INFO: renamed from: B */
        public boolean m2674B(View view) {
            if (f2342c) {
                return false;
            }
            if (f2341b == null) {
                try {
                    f2341b = View.class.getDeclaredField("mAccessibilityDelegate");
                    f2341b.setAccessible(true);
                } catch (Throwable th) {
                    f2342c = true;
                    return false;
                }
            }
            try {
                return f2341b.get(view) != null;
            } catch (Throwable th2) {
                f2342c = true;
                return false;
            }
        }

        /* JADX INFO: renamed from: b */
        public boolean mo2630b(View view) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public void mo2629a(View view, boolean z) {
        }

        /* JADX INFO: renamed from: c */
        public void mo2631c(View view) {
            view.postInvalidate();
        }

        /* JADX INFO: renamed from: a */
        public void mo2625a(View view, int i, int i2, int i3, int i4) {
            view.postInvalidate(i, i2, i3, i4);
        }

        /* JADX INFO: renamed from: a */
        public void mo2627a(View view, Runnable runnable) {
            view.postDelayed(runnable, m2676a());
        }

        /* JADX INFO: renamed from: a */
        public void mo2628a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, m2676a() + j);
        }

        /* JADX INFO: renamed from: a */
        long m2676a() {
            return ValueAnimator.getFrameDelay();
        }

        /* JADX INFO: renamed from: d */
        public int mo2632d(View view) {
            return 0;
        }

        /* JADX INFO: renamed from: a */
        public void mo2624a(View view, int i) {
        }

        /* JADX INFO: renamed from: a */
        public void mo2639a(View view, Paint paint) {
            view.setLayerType(view.getLayerType(), paint);
            view.invalidate();
        }

        /* JADX INFO: renamed from: k */
        public int mo2641k(View view) {
            return 0;
        }

        /* JADX INFO: renamed from: e */
        public ViewParent mo2633e(View view) {
            return view.getParent();
        }

        /* JADX INFO: renamed from: b */
        public void mo2649b(View view, int i) {
        }

        /* JADX INFO: renamed from: l */
        public int mo2642l(View view) {
            return view.getPaddingLeft();
        }

        /* JADX INFO: renamed from: m */
        public int mo2643m(View view) {
            return view.getPaddingRight();
        }

        /* JADX INFO: renamed from: b */
        public void mo2640b(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        /* JADX INFO: renamed from: j */
        public boolean mo2638j(View view) {
            return true;
        }

        /* JADX INFO: renamed from: f */
        public int mo2634f(View view) {
            if (!f2344e) {
                try {
                    f2343d = View.class.getDeclaredField("mMinWidth");
                    f2343d.setAccessible(true);
                } catch (NoSuchFieldException e) {
                }
                f2344e = true;
            }
            if (f2343d != null) {
                try {
                    return ((Integer) f2343d.get(view)).intValue();
                } catch (Exception e2) {
                }
            }
            return 0;
        }

        /* JADX INFO: renamed from: g */
        public int mo2635g(View view) {
            if (!f2346g) {
                try {
                    f2345f = View.class.getDeclaredField("mMinHeight");
                    f2345f.setAccessible(true);
                } catch (NoSuchFieldException e) {
                }
                f2346g = true;
            }
            if (f2345f != null) {
                try {
                    return ((Integer) f2345f.get(view)).intValue();
                } catch (Exception e2) {
                }
            }
            return 0;
        }

        /* JADX INFO: renamed from: C */
        public ViewPropertyAnimatorCompat m2675C(View view) {
            if (this.f2349a == null) {
                this.f2349a = new WeakHashMap<>();
            }
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f2349a.get(view);
            if (viewPropertyAnimatorCompat == null) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat2 = new ViewPropertyAnimatorCompat(view);
                this.f2349a.put(view, viewPropertyAnimatorCompat2);
                return viewPropertyAnimatorCompat2;
            }
            return viewPropertyAnimatorCompat;
        }

        /* JADX INFO: renamed from: a */
        public void mo2659a(View view, String str) {
            if (f2347h == null) {
                f2347h = new WeakHashMap<>();
            }
            f2347h.put(view, str);
        }

        /* JADX INFO: renamed from: t */
        public String mo2664t(View view) {
            if (f2347h == null) {
                return null;
            }
            return f2347h.get(view);
        }

        /* JADX INFO: renamed from: n */
        public int mo2644n(View view) {
            return 0;
        }

        /* JADX INFO: renamed from: h */
        public void mo2636h(View view) {
        }

        /* JADX INFO: renamed from: a */
        public void mo2655a(View view, float f) {
        }

        /* JADX INFO: renamed from: u */
        public float mo2665u(View view) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }

        /* JADX INFO: renamed from: b */
        public void mo2661b(View view, float f) {
        }

        /* JADX INFO: renamed from: v */
        public float mo2666v(View view) {
            return CropImageView.DEFAULT_ASPECT_RATIO;
        }

        /* JADX INFO: renamed from: a */
        public void mo2647a(View view, Rect rect) {
        }

        /* JADX INFO: renamed from: q */
        public Rect mo2648q(View view) {
            return null;
        }

        /* JADX INFO: renamed from: i */
        public boolean mo2637i(View view) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public void mo2658a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        }

        /* JADX INFO: renamed from: a */
        public WindowInsetsCompat mo2654a(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        /* JADX INFO: renamed from: b */
        public WindowInsetsCompat mo2660b(View view, WindowInsetsCompat windowInsetsCompat) {
            return windowInsetsCompat;
        }

        /* JADX INFO: renamed from: o */
        public boolean mo2645o(View view) {
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: w */
        public boolean mo2667w(View view) {
            if (view instanceof NestedScrollingChild) {
                return ((NestedScrollingChild) view).isNestedScrollingEnabled();
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        public void mo2626a(View view, Drawable drawable) {
            view.setBackgroundDrawable(drawable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: y */
        public ColorStateList mo2669y(View view) {
            if (view instanceof TintableBackgroundView) {
                return ((TintableBackgroundView) view).getSupportBackgroundTintList();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: a */
        public void mo2656a(View view, ColorStateList colorStateList) {
            if (view instanceof TintableBackgroundView) {
                ((TintableBackgroundView) view).setSupportBackgroundTintList(colorStateList);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: a */
        public void mo2657a(View view, PorterDuff.Mode mode) {
            if (view instanceof TintableBackgroundView) {
                ((TintableBackgroundView) view).setSupportBackgroundTintMode(mode);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: z */
        public PorterDuff.Mode mo2670z(View view) {
            if (view instanceof TintableBackgroundView) {
                return ((TintableBackgroundView) view).getSupportBackgroundTintMode();
            }
            return null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: x */
        public void mo2668x(View view) {
            if (view instanceof NestedScrollingChild) {
                ((NestedScrollingChild) view).stopNestedScroll();
            }
        }

        /* JADX INFO: renamed from: r */
        public boolean mo2650r(View view) {
            return view.getWidth() > 0 && view.getHeight() > 0;
        }

        /* JADX INFO: renamed from: A */
        public float mo2653A(View view) {
            return mo2666v(view) + mo2665u(view);
        }

        /* JADX INFO: renamed from: s */
        public boolean mo2651s(View view) {
            return view.getWindowToken() != null;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo2623a(View view) {
            return false;
        }

        /* JADX INFO: renamed from: a */
        public void mo2671a(View view, int i, int i2) {
        }

        /* JADX INFO: renamed from: c */
        public void mo2662c(View view, int i) {
            view.offsetLeftAndRight(i);
            if (view.getVisibility() == 0) {
                m2673D(view);
                Object parent = view.getParent();
                if (parent instanceof View) {
                    m2673D((View) parent);
                }
            }
        }

        /* JADX INFO: renamed from: d */
        public void mo2663d(View view, int i) {
            view.offsetTopAndBottom(i);
            if (view.getVisibility() == 0) {
                m2673D(view);
                Object parent = view.getParent();
                if (parent instanceof View) {
                    m2673D((View) parent);
                }
            }
        }

        /* JADX INFO: renamed from: D */
        private static void m2673D(View view) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
        }

        /* JADX INFO: renamed from: a */
        public void mo2672a(View view, PointerIconCompat pointerIconCompat) {
        }

        /* JADX INFO: renamed from: p */
        public Display mo2646p(View view) {
            if (mo2651s(view)) {
                return ((WindowManager) view.getContext().getSystemService("window")).getDefaultDisplay();
            }
            return null;
        }
    }

    static class ViewCompatApi15Impl extends ViewCompatBaseImpl {
        ViewCompatApi15Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public boolean mo2623a(View view) {
            return view.hasOnClickListeners();
        }
    }

    static class ViewCompatApi16Impl extends ViewCompatApi15Impl {
        ViewCompatApi16Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: b */
        public boolean mo2630b(View view) {
            return view.hasTransientState();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2629a(View view, boolean z) {
            view.setHasTransientState(z);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: c */
        public void mo2631c(View view) {
            view.postInvalidateOnAnimation();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2625a(View view, int i, int i2, int i3, int i4) {
            view.postInvalidateOnAnimation(i, i2, i3, i4);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2627a(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2628a(View view, Runnable runnable, long j) {
            view.postOnAnimationDelayed(runnable, j);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: d */
        public int mo2632d(View view) {
            return view.getImportantForAccessibility();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2624a(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            view.setImportantForAccessibility(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: e */
        public ViewParent mo2633e(View view) {
            return view.getParentForAccessibility();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: f */
        public int mo2634f(View view) {
            return view.getMinimumWidth();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: g */
        public int mo2635g(View view) {
            return view.getMinimumHeight();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: h */
        public void mo2636h(View view) {
            view.requestFitSystemWindows();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: i */
        public boolean mo2637i(View view) {
            return view.getFitsSystemWindows();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: j */
        public boolean mo2638j(View view) {
            return view.hasOverlappingRendering();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2626a(View view, Drawable drawable) {
            view.setBackground(drawable);
        }
    }

    static class ViewCompatApi17Impl extends ViewCompatApi16Impl {
        ViewCompatApi17Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2639a(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: k */
        public int mo2641k(View view) {
            return view.getLayoutDirection();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: l */
        public int mo2642l(View view) {
            return view.getPaddingStart();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: m */
        public int mo2643m(View view) {
            return view.getPaddingEnd();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: b */
        public void mo2640b(View view, int i, int i2, int i3, int i4) {
            view.setPaddingRelative(i, i2, i3, i4);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: n */
        public int mo2644n(View view) {
            return view.getWindowSystemUiVisibility();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: o */
        public boolean mo2645o(View view) {
            return view.isPaddingRelative();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: p */
        public Display mo2646p(View view) {
            return view.getDisplay();
        }
    }

    static class ViewCompatApi18Impl extends ViewCompatApi17Impl {
        ViewCompatApi18Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2647a(View view, Rect rect) {
            view.setClipBounds(rect);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: q */
        public Rect mo2648q(View view) {
            return view.getClipBounds();
        }
    }

    static class ViewCompatApi19Impl extends ViewCompatApi18Impl {
        ViewCompatApi19Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: b */
        public void mo2649b(View view, int i) {
            view.setAccessibilityLiveRegion(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatApi16Impl, android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2624a(View view, int i) {
            view.setImportantForAccessibility(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: r */
        public boolean mo2650r(View view) {
            return view.isLaidOut();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: s */
        public boolean mo2651s(View view) {
            return view.isAttachedToWindow();
        }
    }

    static class ViewCompatApi21Impl extends ViewCompatApi19Impl {

        /* JADX INFO: renamed from: d */
        private static ThreadLocal<Rect> f2338d;

        ViewCompatApi21Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2659a(View view, String str) {
            view.setTransitionName(str);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: t */
        public String mo2664t(View view) {
            return view.getTransitionName();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatApi16Impl, android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: h */
        public void mo2636h(View view) {
            view.requestApplyInsets();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2655a(View view, float f) {
            view.setElevation(f);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: u */
        public float mo2665u(View view) {
            return view.getElevation();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: b */
        public void mo2661b(View view, float f) {
            view.setTranslationZ(f);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: v */
        public float mo2666v(View view) {
            return view.getTranslationZ();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2658a(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
            if (onApplyWindowInsetsListener == null) {
                view.setOnApplyWindowInsetsListener(null);
            } else {
                view.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() { // from class: android.support.v4.view.ViewCompat.ViewCompatApi21Impl.1
                    @Override // android.view.View.OnApplyWindowInsetsListener
                    public WindowInsets onApplyWindowInsets(View view2, WindowInsets windowInsets) {
                        return (WindowInsets) WindowInsetsCompat.m2767a(onApplyWindowInsetsListener.mo399a(view2, WindowInsetsCompat.m2766a(windowInsets)));
                    }
                });
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: w */
        public boolean mo2667w(View view) {
            return view.isNestedScrollingEnabled();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: x */
        public void mo2668x(View view) {
            view.stopNestedScroll();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: y */
        public ColorStateList mo2669y(View view) {
            return view.getBackgroundTintList();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2656a(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2657a(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
            if (Build.VERSION.SDK_INT == 21) {
                Drawable background = view.getBackground();
                boolean z = (view.getBackgroundTintList() == null && view.getBackgroundTintMode() == null) ? false : true;
                if (background != null && z) {
                    if (background.isStateful()) {
                        background.setState(view.getDrawableState());
                    }
                    view.setBackground(background);
                }
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: z */
        public PorterDuff.Mode mo2670z(View view) {
            return view.getBackgroundTintMode();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public WindowInsetsCompat mo2654a(View view, WindowInsetsCompat windowInsetsCompat) {
            WindowInsets windowInsets = (WindowInsets) WindowInsetsCompat.m2767a(windowInsetsCompat);
            WindowInsets windowInsetsOnApplyWindowInsets = view.onApplyWindowInsets(windowInsets);
            if (windowInsetsOnApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(windowInsetsOnApplyWindowInsets);
            }
            return WindowInsetsCompat.m2766a(windowInsets);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: b */
        public WindowInsetsCompat mo2660b(View view, WindowInsetsCompat windowInsetsCompat) {
            WindowInsets windowInsets = (WindowInsets) WindowInsetsCompat.m2767a(windowInsetsCompat);
            WindowInsets windowInsetsDispatchApplyWindowInsets = view.dispatchApplyWindowInsets(windowInsets);
            if (windowInsetsDispatchApplyWindowInsets != windowInsets) {
                windowInsets = new WindowInsets(windowInsetsDispatchApplyWindowInsets);
            }
            return WindowInsetsCompat.m2766a(windowInsets);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: A */
        public float mo2653A(View view) {
            return view.getZ();
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: c */
        public void mo2662c(View view, int i) {
            boolean z;
            Rect rectM2652b = m2652b();
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                rectM2652b.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !rectM2652b.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z = false;
            }
            super.mo2662c(view, i);
            if (z && rectM2652b.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(rectM2652b);
            }
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: d */
        public void mo2663d(View view, int i) {
            boolean z;
            Rect rectM2652b = m2652b();
            Object parent = view.getParent();
            if (parent instanceof View) {
                View view2 = (View) parent;
                rectM2652b.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
                z = !rectM2652b.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            } else {
                z = false;
            }
            super.mo2663d(view, i);
            if (z && rectM2652b.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
                ((View) parent).invalidate(rectM2652b);
            }
        }

        /* JADX INFO: renamed from: b */
        private static Rect m2652b() {
            if (f2338d == null) {
                f2338d = new ThreadLocal<>();
            }
            Rect rect = f2338d.get();
            if (rect == null) {
                rect = new Rect();
                f2338d.set(rect);
            }
            rect.setEmpty();
            return rect;
        }
    }

    static class ViewCompatApi23Impl extends ViewCompatApi21Impl {
        ViewCompatApi23Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2671a(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatApi21Impl, android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: c */
        public void mo2662c(View view, int i) {
            view.offsetLeftAndRight(i);
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatApi21Impl, android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: d */
        public void mo2663d(View view, int i) {
            view.offsetTopAndBottom(i);
        }
    }

    static class ViewCompatApi24Impl extends ViewCompatApi23Impl {
        ViewCompatApi24Impl() {
        }

        @Override // android.support.v4.view.ViewCompat.ViewCompatBaseImpl
        /* JADX INFO: renamed from: a */
        public void mo2672a(View view, PointerIconCompat pointerIconCompat) {
            view.setPointerIcon((PointerIcon) (pointerIconCompat != null ? pointerIconCompat.m2568a() : null));
        }
    }

    static class ViewCompatApi26Impl extends ViewCompatApi24Impl {
        ViewCompatApi26Impl() {
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f2337a = new ViewCompatApi26Impl();
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            f2337a = new ViewCompatApi24Impl();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            f2337a = new ViewCompatApi23Impl();
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            f2337a = new ViewCompatApi21Impl();
            return;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            f2337a = new ViewCompatApi19Impl();
            return;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            f2337a = new ViewCompatApi18Impl();
            return;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            f2337a = new ViewCompatApi17Impl();
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            f2337a = new ViewCompatApi16Impl();
        } else if (Build.VERSION.SDK_INT >= 15) {
            f2337a = new ViewCompatApi15Impl();
        } else {
            f2337a = new ViewCompatBaseImpl();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m2583a(View view, AccessibilityDelegateCompat accessibilityDelegateCompat) {
        f2337a.m2677a(view, accessibilityDelegateCompat);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m2590a(View view) {
        return f2337a.m2674B(view);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m2596b(View view) {
        return f2337a.mo2630b(view);
    }

    /* JADX INFO: renamed from: a */
    public static void m2589a(View view, boolean z) {
        f2337a.mo2629a(view, z);
    }

    /* JADX INFO: renamed from: c */
    public static void m2597c(View view) {
        f2337a.mo2631c(view);
    }

    /* JADX INFO: renamed from: a */
    public static void m2577a(View view, int i, int i2, int i3, int i4) {
        f2337a.mo2625a(view, i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: a */
    public static void m2586a(View view, Runnable runnable) {
        f2337a.mo2627a(view, runnable);
    }

    /* JADX INFO: renamed from: a */
    public static void m2587a(View view, Runnable runnable, long j) {
        f2337a.mo2628a(view, runnable, j);
    }

    /* JADX INFO: renamed from: d */
    public static int m2599d(View view) {
        return f2337a.mo2632d(view);
    }

    /* JADX INFO: renamed from: a */
    public static void m2575a(View view, int i) {
        f2337a.mo2624a(view, i);
    }

    /* JADX INFO: renamed from: a */
    public static void m2579a(View view, Paint paint) {
        f2337a.mo2639a(view, paint);
    }

    /* JADX INFO: renamed from: e */
    public static int m2601e(View view) {
        return f2337a.mo2641k(view);
    }

    /* JADX INFO: renamed from: f */
    public static ViewParent m2602f(View view) {
        return f2337a.mo2633e(view);
    }

    /* JADX INFO: renamed from: b */
    public static void m2593b(View view, int i) {
        f2337a.mo2649b(view, i);
    }

    /* JADX INFO: renamed from: g */
    public static int m2603g(View view) {
        return f2337a.mo2642l(view);
    }

    /* JADX INFO: renamed from: h */
    public static int m2604h(View view) {
        return f2337a.mo2643m(view);
    }

    /* JADX INFO: renamed from: b */
    public static void m2594b(View view, int i, int i2, int i3, int i4) {
        f2337a.mo2640b(view, i, i2, i3, i4);
    }

    @Deprecated
    /* JADX INFO: renamed from: i */
    public static float m2605i(View view) {
        return view.getTranslationY();
    }

    /* JADX INFO: renamed from: j */
    public static int m2606j(View view) {
        return f2337a.mo2634f(view);
    }

    /* JADX INFO: renamed from: k */
    public static int m2607k(View view) {
        return f2337a.mo2635g(view);
    }

    /* JADX INFO: renamed from: l */
    public static ViewPropertyAnimatorCompat m2608l(View view) {
        return f2337a.m2675C(view);
    }

    /* JADX INFO: renamed from: a */
    public static void m2574a(View view, float f) {
        f2337a.mo2655a(view, f);
    }

    /* JADX INFO: renamed from: m */
    public static float m2609m(View view) {
        return f2337a.mo2665u(view);
    }

    /* JADX INFO: renamed from: b */
    public static void m2592b(View view, float f) {
        f2337a.mo2661b(view, f);
    }

    /* JADX INFO: renamed from: n */
    public static float m2610n(View view) {
        return f2337a.mo2666v(view);
    }

    /* JADX INFO: renamed from: a */
    public static void m2588a(View view, String str) {
        f2337a.mo2659a(view, str);
    }

    /* JADX INFO: renamed from: o */
    public static String m2611o(View view) {
        return f2337a.mo2664t(view);
    }

    /* JADX INFO: renamed from: p */
    public static int m2612p(View view) {
        return f2337a.mo2644n(view);
    }

    /* JADX INFO: renamed from: q */
    public static void m2613q(View view) {
        f2337a.mo2636h(view);
    }

    /* JADX INFO: renamed from: r */
    public static boolean m2614r(View view) {
        return f2337a.mo2637i(view);
    }

    @Deprecated
    /* JADX INFO: renamed from: b */
    public static void m2595b(View view, boolean z) {
        view.setFitsSystemWindows(z);
    }

    /* JADX INFO: renamed from: a */
    public static void m2584a(View view, OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        f2337a.mo2658a(view, onApplyWindowInsetsListener);
    }

    /* JADX INFO: renamed from: a */
    public static WindowInsetsCompat m2573a(View view, WindowInsetsCompat windowInsetsCompat) {
        return f2337a.mo2654a(view, windowInsetsCompat);
    }

    /* JADX INFO: renamed from: b */
    public static WindowInsetsCompat m2591b(View view, WindowInsetsCompat windowInsetsCompat) {
        return f2337a.mo2660b(view, windowInsetsCompat);
    }

    /* JADX INFO: renamed from: s */
    public static boolean m2615s(View view) {
        return f2337a.mo2638j(view);
    }

    /* JADX INFO: renamed from: t */
    public static boolean m2616t(View view) {
        return f2337a.mo2645o(view);
    }

    /* JADX INFO: renamed from: a */
    public static void m2582a(View view, Drawable drawable) {
        f2337a.mo2626a(view, drawable);
    }

    /* JADX INFO: renamed from: u */
    public static ColorStateList m2617u(View view) {
        return f2337a.mo2669y(view);
    }

    /* JADX INFO: renamed from: a */
    public static void m2578a(View view, ColorStateList colorStateList) {
        f2337a.mo2656a(view, colorStateList);
    }

    /* JADX INFO: renamed from: v */
    public static PorterDuff.Mode m2618v(View view) {
        return f2337a.mo2670z(view);
    }

    /* JADX INFO: renamed from: a */
    public static void m2580a(View view, PorterDuff.Mode mode) {
        f2337a.mo2657a(view, mode);
    }

    /* JADX INFO: renamed from: w */
    public static boolean m2619w(View view) {
        return f2337a.mo2667w(view);
    }

    /* JADX INFO: renamed from: x */
    public static void m2620x(View view) {
        f2337a.mo2668x(view);
    }

    /* JADX INFO: renamed from: y */
    public static boolean m2621y(View view) {
        return f2337a.mo2650r(view);
    }

    /* JADX INFO: renamed from: z */
    public static float m2622z(View view) {
        return f2337a.mo2653A(view);
    }

    /* JADX INFO: renamed from: c */
    public static void m2598c(View view, int i) {
        f2337a.mo2663d(view, i);
    }

    /* JADX INFO: renamed from: d */
    public static void m2600d(View view, int i) {
        f2337a.mo2662c(view, i);
    }

    /* JADX INFO: renamed from: a */
    public static void m2581a(View view, Rect rect) {
        f2337a.mo2647a(view, rect);
    }

    /* JADX INFO: renamed from: A */
    public static Rect m2569A(View view) {
        return f2337a.mo2648q(view);
    }

    /* JADX INFO: renamed from: B */
    public static boolean m2570B(View view) {
        return f2337a.mo2651s(view);
    }

    /* JADX INFO: renamed from: C */
    public static boolean m2571C(View view) {
        return f2337a.mo2623a(view);
    }

    /* JADX INFO: renamed from: a */
    public static void m2576a(View view, int i, int i2) {
        f2337a.mo2671a(view, i, i2);
    }

    /* JADX INFO: renamed from: a */
    public static void m2585a(View view, PointerIconCompat pointerIconCompat) {
        f2337a.mo2672a(view, pointerIconCompat);
    }

    /* JADX INFO: renamed from: D */
    public static Display m2572D(View view) {
        return f2337a.mo2646p(view);
    }
}
