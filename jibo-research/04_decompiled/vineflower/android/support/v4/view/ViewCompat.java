package android.support.v4.view;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.View.AccessibilityDelegate;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ViewCompat {
   static final ViewCompat.ViewCompatBaseImpl a;

   static {
      if (VERSION.SDK_INT >= 26) {
         a = new ViewCompat.ViewCompatApi26Impl();
      } else if (VERSION.SDK_INT >= 24) {
         a = new ViewCompat.ViewCompatApi24Impl();
      } else if (VERSION.SDK_INT >= 23) {
         a = new ViewCompat.ViewCompatApi23Impl();
      } else if (VERSION.SDK_INT >= 21) {
         a = new ViewCompat.ViewCompatApi21Impl();
      } else if (VERSION.SDK_INT >= 19) {
         a = new ViewCompat.ViewCompatApi19Impl();
      } else if (VERSION.SDK_INT >= 18) {
         a = new ViewCompat.ViewCompatApi18Impl();
      } else if (VERSION.SDK_INT >= 17) {
         a = new ViewCompat.ViewCompatApi17Impl();
      } else if (VERSION.SDK_INT >= 16) {
         a = new ViewCompat.ViewCompatApi16Impl();
      } else if (VERSION.SDK_INT >= 15) {
         a = new ViewCompat.ViewCompatApi15Impl();
      } else {
         a = new ViewCompat.ViewCompatBaseImpl();
      }
   }

   public static Rect A(View var0) {
      return a.q(var0);
   }

   public static boolean B(View var0) {
      return a.s(var0);
   }

   public static boolean C(View var0) {
      return a.a(var0);
   }

   public static Display D(View var0) {
      return a.p(var0);
   }

   public static WindowInsetsCompat a(View var0, WindowInsetsCompat var1) {
      return a.a(var0, var1);
   }

   public static void a(View var0, float var1) {
      a.a(var0, var1);
   }

   public static void a(View var0, int var1) {
      a.a(var0, var1);
   }

   public static void a(View var0, int var1, int var2) {
      a.a(var0, var1, var2);
   }

   public static void a(View var0, int var1, int var2, int var3, int var4) {
      a.a(var0, var1, var2, var3, var4);
   }

   public static void a(View var0, ColorStateList var1) {
      a.a(var0, var1);
   }

   public static void a(View var0, Paint var1) {
      a.a(var0, var1);
   }

   public static void a(View var0, Mode var1) {
      a.a(var0, var1);
   }

   public static void a(View var0, Rect var1) {
      a.a(var0, var1);
   }

   public static void a(View var0, Drawable var1) {
      a.a(var0, var1);
   }

   public static void a(View var0, AccessibilityDelegateCompat var1) {
      a.a(var0, var1);
   }

   public static void a(View var0, OnApplyWindowInsetsListener var1) {
      a.a(var0, var1);
   }

   public static void a(View var0, PointerIconCompat var1) {
      a.a(var0, var1);
   }

   public static void a(View var0, Runnable var1) {
      a.a(var0, var1);
   }

   public static void a(View var0, Runnable var1, long var2) {
      a.a(var0, var1, var2);
   }

   public static void a(View var0, String var1) {
      a.a(var0, var1);
   }

   public static void a(View var0, boolean var1) {
      a.a(var0, var1);
   }

   public static boolean a(View var0) {
      return a.B(var0);
   }

   public static WindowInsetsCompat b(View var0, WindowInsetsCompat var1) {
      return a.b(var0, var1);
   }

   public static void b(View var0, float var1) {
      a.b(var0, var1);
   }

   public static void b(View var0, int var1) {
      a.b(var0, var1);
   }

   public static void b(View var0, int var1, int var2, int var3, int var4) {
      a.b(var0, var1, var2, var3, var4);
   }

   @Deprecated
   public static void b(View var0, boolean var1) {
      var0.setFitsSystemWindows(var1);
   }

   public static boolean b(View var0) {
      return a.b(var0);
   }

   public static void c(View var0) {
      a.c(var0);
   }

   public static void c(View var0, int var1) {
      a.d(var0, var1);
   }

   public static int d(View var0) {
      return a.d(var0);
   }

   public static void d(View var0, int var1) {
      a.c(var0, var1);
   }

   public static int e(View var0) {
      return a.k(var0);
   }

   public static ViewParent f(View var0) {
      return a.e(var0);
   }

   public static int g(View var0) {
      return a.l(var0);
   }

   public static int h(View var0) {
      return a.m(var0);
   }

   @Deprecated
   public static float i(View var0) {
      return var0.getTranslationY();
   }

   public static int j(View var0) {
      return a.f(var0);
   }

   public static int k(View var0) {
      return a.g(var0);
   }

   public static ViewPropertyAnimatorCompat l(View var0) {
      return a.C(var0);
   }

   public static float m(View var0) {
      return a.u(var0);
   }

   public static float n(View var0) {
      return a.v(var0);
   }

   public static String o(View var0) {
      return a.t(var0);
   }

   public static int p(View var0) {
      return a.n(var0);
   }

   public static void q(View var0) {
      a.h(var0);
   }

   public static boolean r(View var0) {
      return a.i(var0);
   }

   public static boolean s(View var0) {
      return a.j(var0);
   }

   public static boolean t(View var0) {
      return a.o(var0);
   }

   public static ColorStateList u(View var0) {
      return a.y(var0);
   }

   public static Mode v(View var0) {
      return a.z(var0);
   }

   public static boolean w(View var0) {
      return a.w(var0);
   }

   public static void x(View var0) {
      a.x(var0);
   }

   public static boolean y(View var0) {
      return a.r(var0);
   }

   public static float z(View var0) {
      return a.A(var0);
   }

   static class ViewCompatApi15Impl extends ViewCompat.ViewCompatBaseImpl {
      @Override
      public boolean a(View var1) {
         return var1.hasOnClickListeners();
      }
   }

   static class ViewCompatApi16Impl extends ViewCompat.ViewCompatApi15Impl {
      @Override
      public void a(View var1, int var2) {
         int var3 = var2;
         if (var2 == 4) {
            var3 = 2;
         }

         var1.setImportantForAccessibility(var3);
      }

      @Override
      public void a(View var1, int var2, int var3, int var4, int var5) {
         var1.postInvalidateOnAnimation(var2, var3, var4, var5);
      }

      @Override
      public void a(View var1, Drawable var2) {
         var1.setBackground(var2);
      }

      @Override
      public void a(View var1, Runnable var2) {
         var1.postOnAnimation(var2);
      }

      @Override
      public void a(View var1, Runnable var2, long var3) {
         var1.postOnAnimationDelayed(var2, var3);
      }

      @Override
      public void a(View var1, boolean var2) {
         var1.setHasTransientState(var2);
      }

      @Override
      public boolean b(View var1) {
         return var1.hasTransientState();
      }

      @Override
      public void c(View var1) {
         var1.postInvalidateOnAnimation();
      }

      @Override
      public int d(View var1) {
         return var1.getImportantForAccessibility();
      }

      @Override
      public ViewParent e(View var1) {
         return var1.getParentForAccessibility();
      }

      @Override
      public int f(View var1) {
         return var1.getMinimumWidth();
      }

      @Override
      public int g(View var1) {
         return var1.getMinimumHeight();
      }

      @Override
      public void h(View var1) {
         var1.requestFitSystemWindows();
      }

      @Override
      public boolean i(View var1) {
         return var1.getFitsSystemWindows();
      }

      @Override
      public boolean j(View var1) {
         return var1.hasOverlappingRendering();
      }
   }

   static class ViewCompatApi17Impl extends ViewCompat.ViewCompatApi16Impl {
      @Override
      public void a(View var1, Paint var2) {
         var1.setLayerPaint(var2);
      }

      @Override
      public void b(View var1, int var2, int var3, int var4, int var5) {
         var1.setPaddingRelative(var2, var3, var4, var5);
      }

      @Override
      public int k(View var1) {
         return var1.getLayoutDirection();
      }

      @Override
      public int l(View var1) {
         return var1.getPaddingStart();
      }

      @Override
      public int m(View var1) {
         return var1.getPaddingEnd();
      }

      @Override
      public int n(View var1) {
         return var1.getWindowSystemUiVisibility();
      }

      @Override
      public boolean o(View var1) {
         return var1.isPaddingRelative();
      }

      @Override
      public Display p(View var1) {
         return var1.getDisplay();
      }
   }

   static class ViewCompatApi18Impl extends ViewCompat.ViewCompatApi17Impl {
      @Override
      public void a(View var1, Rect var2) {
         var1.setClipBounds(var2);
      }

      @Override
      public Rect q(View var1) {
         return var1.getClipBounds();
      }
   }

   static class ViewCompatApi19Impl extends ViewCompat.ViewCompatApi18Impl {
      @Override
      public void a(View var1, int var2) {
         var1.setImportantForAccessibility(var2);
      }

      @Override
      public void b(View var1, int var2) {
         var1.setAccessibilityLiveRegion(var2);
      }

      @Override
      public boolean r(View var1) {
         return var1.isLaidOut();
      }

      @Override
      public boolean s(View var1) {
         return var1.isAttachedToWindow();
      }
   }

   static class ViewCompatApi21Impl extends ViewCompat.ViewCompatApi19Impl {
      private static ThreadLocal<Rect> d;

      private static Rect b() {
         if (d == null) {
            d = new ThreadLocal<>();
         }

         Rect var1 = d.get();
         Rect var0 = var1;
         if (var1 == null) {
            var0 = new Rect();
            d.set(var0);
         }

         var0.setEmpty();
         return var0;
      }

      @Override
      public float A(View var1) {
         return var1.getZ();
      }

      @Override
      public WindowInsetsCompat a(View var1, WindowInsetsCompat var2) {
         WindowInsets var5 = (WindowInsets)WindowInsetsCompat.a(var2);
         WindowInsets var3 = var1.onApplyWindowInsets(var5);
         WindowInsets var4 = var5;
         if (var3 != var5) {
            var4 = new WindowInsets(var3);
         }

         return WindowInsetsCompat.a(var4);
      }

      @Override
      public void a(View var1, float var2) {
         var1.setElevation(var2);
      }

      @Override
      public void a(View var1, ColorStateList var2) {
         var1.setBackgroundTintList(var2);
         if (VERSION.SDK_INT == 21) {
            Drawable var4 = var1.getBackground();
            boolean var3;
            if (var1.getBackgroundTintList() == null && var1.getBackgroundTintMode() == null) {
               var3 = false;
            } else {
               var3 = true;
            }

            if (var4 != null && var3) {
               if (var4.isStateful()) {
                  var4.setState(var1.getDrawableState());
               }

               var1.setBackground(var4);
            }
         }
      }

      @Override
      public void a(View var1, Mode var2) {
         var1.setBackgroundTintMode(var2);
         if (VERSION.SDK_INT == 21) {
            Drawable var4 = var1.getBackground();
            boolean var3;
            if (var1.getBackgroundTintList() == null && var1.getBackgroundTintMode() == null) {
               var3 = false;
            } else {
               var3 = true;
            }

            if (var4 != null && var3) {
               if (var4.isStateful()) {
                  var4.setState(var1.getDrawableState());
               }

               var1.setBackground(var4);
            }
         }
      }

      @Override
      public void a(View var1, OnApplyWindowInsetsListener var2) {
         if (var2 == null) {
            var1.setOnApplyWindowInsetsListener(null);
         } else {
            var1.setOnApplyWindowInsetsListener(new android.view.View.OnApplyWindowInsetsListener(this, var2) {
               final OnApplyWindowInsetsListener a;
               final ViewCompat.ViewCompatApi21Impl b;

               {
                  this.b = var1;
                  this.a = var2x;
               }

               public WindowInsets onApplyWindowInsets(View var1, WindowInsets var2x) {
                  WindowInsetsCompat var3 = WindowInsetsCompat.a(var2x);
                  return (WindowInsets)WindowInsetsCompat.a(this.a.a(var1, var3));
               }
            });
         }
      }

      @Override
      public void a(View var1, String var2) {
         var1.setTransitionName(var2);
      }

      @Override
      public WindowInsetsCompat b(View var1, WindowInsetsCompat var2) {
         WindowInsets var5 = (WindowInsets)WindowInsetsCompat.a(var2);
         WindowInsets var3 = var1.dispatchApplyWindowInsets(var5);
         WindowInsets var4 = var5;
         if (var3 != var5) {
            var4 = new WindowInsets(var3);
         }

         return WindowInsetsCompat.a(var4);
      }

      @Override
      public void b(View var1, float var2) {
         var1.setTranslationZ(var2);
      }

      @Override
      public void c(View var1, int var2) {
         Rect var4 = b();
         ViewParent var5 = var1.getParent();
         boolean var3;
         if (var5 instanceof View) {
            View var6 = (View)var5;
            var4.set(var6.getLeft(), var6.getTop(), var6.getRight(), var6.getBottom());
            if (!var4.intersects(var1.getLeft(), var1.getTop(), var1.getRight(), var1.getBottom())) {
               var3 = true;
            } else {
               var3 = false;
            }
         } else {
            var3 = false;
         }

         super.c(var1, var2);
         if (var3 && var4.intersect(var1.getLeft(), var1.getTop(), var1.getRight(), var1.getBottom())) {
            ((View)var5).invalidate(var4);
         }
      }

      @Override
      public void d(View var1, int var2) {
         Rect var6 = b();
         ViewParent var4 = var1.getParent();
         boolean var3;
         if (var4 instanceof View) {
            View var5 = (View)var4;
            var6.set(var5.getLeft(), var5.getTop(), var5.getRight(), var5.getBottom());
            if (!var6.intersects(var1.getLeft(), var1.getTop(), var1.getRight(), var1.getBottom())) {
               var3 = true;
            } else {
               var3 = false;
            }
         } else {
            var3 = false;
         }

         super.d(var1, var2);
         if (var3 && var6.intersect(var1.getLeft(), var1.getTop(), var1.getRight(), var1.getBottom())) {
            ((View)var4).invalidate(var6);
         }
      }

      @Override
      public void h(View var1) {
         var1.requestApplyInsets();
      }

      @Override
      public String t(View var1) {
         return var1.getTransitionName();
      }

      @Override
      public float u(View var1) {
         return var1.getElevation();
      }

      @Override
      public float v(View var1) {
         return var1.getTranslationZ();
      }

      @Override
      public boolean w(View var1) {
         return var1.isNestedScrollingEnabled();
      }

      @Override
      public void x(View var1) {
         var1.stopNestedScroll();
      }

      @Override
      public ColorStateList y(View var1) {
         return var1.getBackgroundTintList();
      }

      @Override
      public Mode z(View var1) {
         return var1.getBackgroundTintMode();
      }
   }

   static class ViewCompatApi23Impl extends ViewCompat.ViewCompatApi21Impl {
      @Override
      public void a(View var1, int var2, int var3) {
         var1.setScrollIndicators(var2, var3);
      }

      @Override
      public void c(View var1, int var2) {
         var1.offsetLeftAndRight(var2);
      }

      @Override
      public void d(View var1, int var2) {
         var1.offsetTopAndBottom(var2);
      }
   }

   static class ViewCompatApi24Impl extends ViewCompat.ViewCompatApi23Impl {
      @Override
      public void a(View var1, PointerIconCompat var2) {
         Object var3;
         if (var2 != null) {
            var3 = var2.a();
         } else {
            var3 = null;
         }

         var1.setPointerIcon((PointerIcon)var3);
      }
   }

   static class ViewCompatApi26Impl extends ViewCompat.ViewCompatApi24Impl {
   }

   static class ViewCompatBaseImpl {
      static Field b;
      static boolean c = false;
      private static Field d;
      private static boolean e;
      private static Field f;
      private static boolean g;
      private static WeakHashMap<View, String> h;
      private static final AtomicInteger i = new AtomicInteger(1);
      WeakHashMap<View, ViewPropertyAnimatorCompat> a = null;

      private static void D(View var0) {
         float var1 = var0.getTranslationY();
         var0.setTranslationY(1.0F + var1);
         var0.setTranslationY(var1);
      }

      public float A(View var1) {
         return this.v(var1) + this.u(var1);
      }

      public boolean B(View var1) {
         boolean var2 = true;
         boolean var3 = false;
         if (c) {
            var2 = var3;
         } else {
            if (b == null) {
               try {
                  b = View.class.getDeclaredField("mAccessibilityDelegate");
                  b.setAccessible(true);
               } catch (Throwable var5) {
                  c = true;
                  var2 = var3;
                  return var2;
               }
            }

            try {
               var6 = b.get(var1);
            } catch (Throwable var4) {
               c = true;
               var2 = var3;
               return var2;
            }

            if (var6 == null) {
               var2 = false;
            }
         }

         return var2;
      }

      public ViewPropertyAnimatorCompat C(View var1) {
         if (this.a == null) {
            this.a = new WeakHashMap<>();
         }

         ViewPropertyAnimatorCompat var3 = this.a.get(var1);
         ViewPropertyAnimatorCompat var2 = var3;
         if (var3 == null) {
            var2 = new ViewPropertyAnimatorCompat(var1);
            this.a.put(var1, var2);
         }

         return var2;
      }

      long a() {
         return ValueAnimator.getFrameDelay();
      }

      public WindowInsetsCompat a(View var1, WindowInsetsCompat var2) {
         return var2;
      }

      public void a(View var1, float var2) {
      }

      public void a(View var1, int var2) {
      }

      public void a(View var1, int var2, int var3) {
      }

      public void a(View var1, int var2, int var3, int var4, int var5) {
         var1.postInvalidate(var2, var3, var4, var5);
      }

      public void a(View var1, ColorStateList var2) {
         if (var1 instanceof TintableBackgroundView) {
            ((TintableBackgroundView)var1).setSupportBackgroundTintList(var2);
         }
      }

      public void a(View var1, Paint var2) {
         var1.setLayerType(var1.getLayerType(), var2);
         var1.invalidate();
      }

      public void a(View var1, Mode var2) {
         if (var1 instanceof TintableBackgroundView) {
            ((TintableBackgroundView)var1).setSupportBackgroundTintMode(var2);
         }
      }

      public void a(View var1, Rect var2) {
      }

      public void a(View var1, Drawable var2) {
         var1.setBackgroundDrawable(var2);
      }

      public void a(View var1, AccessibilityDelegateCompat var2) {
         AccessibilityDelegate var3;
         if (var2 == null) {
            var3 = null;
         } else {
            var3 = var2.a();
         }

         var1.setAccessibilityDelegate(var3);
      }

      public void a(View var1, OnApplyWindowInsetsListener var2) {
      }

      public void a(View var1, PointerIconCompat var2) {
      }

      public void a(View var1, Runnable var2) {
         var1.postDelayed(var2, this.a());
      }

      public void a(View var1, Runnable var2, long var3) {
         var1.postDelayed(var2, this.a() + var3);
      }

      public void a(View var1, String var2) {
         if (h == null) {
            h = new WeakHashMap<>();
         }

         h.put(var1, var2);
      }

      public void a(View var1, boolean var2) {
      }

      public boolean a(View var1) {
         return false;
      }

      public WindowInsetsCompat b(View var1, WindowInsetsCompat var2) {
         return var2;
      }

      public void b(View var1, float var2) {
      }

      public void b(View var1, int var2) {
      }

      public void b(View var1, int var2, int var3, int var4, int var5) {
         var1.setPadding(var2, var3, var4, var5);
      }

      public boolean b(View var1) {
         return false;
      }

      public void c(View var1) {
         var1.postInvalidate();
      }

      public void c(View var1, int var2) {
         var1.offsetLeftAndRight(var2);
         if (var1.getVisibility() == 0) {
            D(var1);
            ViewParent var3 = var1.getParent();
            if (var3 instanceof View) {
               D((View)var3);
            }
         }
      }

      public int d(View var1) {
         return 0;
      }

      public void d(View var1, int var2) {
         var1.offsetTopAndBottom(var2);
         if (var1.getVisibility() == 0) {
            D(var1);
            ViewParent var3 = var1.getParent();
            if (var3 instanceof View) {
               D((View)var3);
            }
         }
      }

      public ViewParent e(View var1) {
         return var1.getParent();
      }

      public int f(View var1) {
         if (!e) {
            try {
               d = View.class.getDeclaredField("mMinWidth");
               d.setAccessible(true);
            } catch (NoSuchFieldException var4) {
            }

            e = true;
         }

         if (d != null) {
            try {
               return (Integer)d.get(var1);
            } catch (Exception var5) {
            }
         }

         return 0;
      }

      public int g(View var1) {
         if (!g) {
            try {
               f = View.class.getDeclaredField("mMinHeight");
               f.setAccessible(true);
            } catch (NoSuchFieldException var4) {
            }

            g = true;
         }

         if (f != null) {
            try {
               return (Integer)f.get(var1);
            } catch (Exception var5) {
            }
         }

         return 0;
      }

      public void h(View var1) {
      }

      public boolean i(View var1) {
         return false;
      }

      public boolean j(View var1) {
         return true;
      }

      public int k(View var1) {
         return 0;
      }

      public int l(View var1) {
         return var1.getPaddingLeft();
      }

      public int m(View var1) {
         return var1.getPaddingRight();
      }

      public int n(View var1) {
         return 0;
      }

      public boolean o(View var1) {
         return false;
      }

      public Display p(View var1) {
         Display var2;
         if (this.s(var1)) {
            var2 = ((WindowManager)var1.getContext().getSystemService("window")).getDefaultDisplay();
         } else {
            var2 = null;
         }

         return var2;
      }

      public Rect q(View var1) {
         return null;
      }

      public boolean r(View var1) {
         boolean var2;
         if (var1.getWidth() > 0 && var1.getHeight() > 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public boolean s(View var1) {
         boolean var2;
         if (var1.getWindowToken() != null) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      public String t(View var1) {
         String var2;
         if (h == null) {
            var2 = null;
         } else {
            var2 = h.get(var1);
         }

         return var2;
      }

      public float u(View var1) {
         return 0.0F;
      }

      public float v(View var1) {
         return 0.0F;
      }

      public boolean w(View var1) {
         boolean var2;
         if (var1 instanceof NestedScrollingChild) {
            var2 = ((NestedScrollingChild)var1).isNestedScrollingEnabled();
         } else {
            var2 = false;
         }

         return var2;
      }

      public void x(View var1) {
         if (var1 instanceof NestedScrollingChild) {
            ((NestedScrollingChild)var1).stopNestedScroll();
         }
      }

      public ColorStateList y(View var1) {
         ColorStateList var2;
         if (var1 instanceof TintableBackgroundView) {
            var2 = ((TintableBackgroundView)var1).getSupportBackgroundTintList();
         } else {
            var2 = null;
         }

         return var2;
      }

      public Mode z(View var1) {
         Mode var2;
         if (var1 instanceof TintableBackgroundView) {
            var2 = ((TintableBackgroundView)var1).getSupportBackgroundTintMode();
         } else {
            var2 = null;
         }

         return var2;
      }
   }
}
