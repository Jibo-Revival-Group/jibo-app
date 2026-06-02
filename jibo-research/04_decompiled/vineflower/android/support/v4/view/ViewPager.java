package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.Resources.NotFoundException;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
   static final int[] a = new int[]{16842931};
   private static final ViewPager.ViewPositionComparator ai = new ViewPager.ViewPositionComparator();
   private static final Comparator<ViewPager.ItemInfo> e = new Comparator<ViewPager.ItemInfo>() {
      public int a(ViewPager.ItemInfo var1, ViewPager.ItemInfo var2) {
         return var1.b - var2.b;
      }
   };
   private static final Interpolator f = new Interpolator() {
      public float getInterpolation(float var1) {
         return --var1 * (var1 * var1 * var1 * var1) + 1.0F;
      }
   };
   private int A;
   private boolean B;
   private boolean C;
   private int D;
   private int E;
   private int F;
   private float G;
   private float H;
   private float I;
   private float J;
   private int K;
   private VelocityTracker L;
   private int M;
   private int N;
   private int O;
   private int P;
   private boolean Q;
   private EdgeEffect R;
   private EdgeEffect S;
   private boolean T;
   private boolean U;
   private boolean V;
   private int W;
   private List<ViewPager.OnPageChangeListener> aa;
   private ViewPager.OnPageChangeListener ab;
   private ViewPager.OnPageChangeListener ac;
   private List<ViewPager.OnAdapterChangeListener> ad;
   private ViewPager.PageTransformer ae;
   private int af;
   private int ag;
   private ArrayList<View> ah;
   private final Runnable aj;
   private int ak;
   PagerAdapter b;
   int c;
   private int d;
   private final ArrayList<ViewPager.ItemInfo> g = new ArrayList<>();
   private final ViewPager.ItemInfo h = new ViewPager.ItemInfo();
   private final Rect i = new Rect();
   private int j = -1;
   private Parcelable k = null;
   private ClassLoader l = null;
   private Scroller m;
   private boolean n;
   private ViewPager.PagerObserver o;
   private int p;
   private Drawable q;
   private int r;
   private int s;
   private float t = -Float.MAX_VALUE;
   private float u = Float.MAX_VALUE;
   private int v;
   private int w;
   private boolean x;
   private boolean y;
   private boolean z;

   public ViewPager(Context var1) {
      super(var1);
      this.A = 1;
      this.K = -1;
      this.T = true;
      this.U = false;
      this.aj = new Runnable(this) {
         final ViewPager a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.setScrollState(0);
            this.a.c();
         }
      };
      this.ak = 0;
      this.a();
   }

   public ViewPager(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.A = 1;
      this.K = -1;
      this.T = true;
      this.U = false;
      this.aj = new Runnable(this) {
         final ViewPager a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.setScrollState(0);
            this.a.c();
         }
      };
      this.ak = 0;
      this.a();
   }

   private int a(int var1, float var2, int var3, int var4) {
      if (Math.abs(var4) > this.O && Math.abs(var3) > this.M) {
         if (var3 <= 0) {
            var1++;
         }
      } else {
         float var5;
         if (var1 >= this.c) {
            var5 = 0.4F;
         } else {
            var5 = 0.6F;
         }

         var1 += (int)(var5 + var2);
      }

      var3 = var1;
      if (this.g.size() > 0) {
         ViewPager.ItemInfo var6 = this.g.get(0);
         ViewPager.ItemInfo var7 = this.g.get(this.g.size() - 1);
         var3 = Math.max(var6.b, Math.min(var1, var7.b));
      }

      return var3;
   }

   private Rect a(Rect var1, View var2) {
      if (var1 == null) {
         var1 = new Rect();
      }

      if (var2 == null) {
         var1.set(0, 0, 0, 0);
      } else {
         var1.left = var2.getLeft();
         var1.right = var2.getRight();
         var1.top = var2.getTop();
         var1.bottom = var2.getBottom();
         ViewParent var3 = var2.getParent();

         while (var3 instanceof ViewGroup && var3 != this) {
            ViewGroup var4 = (ViewGroup)var3;
            var1.left = var1.left + var4.getLeft();
            var1.right = var1.right + var4.getRight();
            var1.top = var1.top + var4.getTop();
            var1.bottom = var1.bottom + var4.getBottom();
            var3 = var4.getParent();
         }
      }

      return var1;
   }

   private void a(int var1, int var2, int var3, int var4) {
      if (var2 <= 0 || this.g.isEmpty()) {
         ViewPager.ItemInfo var10 = this.b(this.c);
         float var12;
         if (var10 != null) {
            var12 = Math.min(var10.e, this.u);
         } else {
            var12 = 0.0F;
         }

         var1 = (int)(var12 * (var1 - this.getPaddingLeft() - this.getPaddingRight()));
         if (var1 != this.getScrollX()) {
            this.a(false);
            this.scrollTo(var1, this.getScrollY());
         }
      } else if (!this.m.isFinished()) {
         this.m.setFinalX(this.getCurrentItem() * this.getClientWidth());
      } else {
         int var6 = this.getPaddingLeft();
         int var8 = this.getPaddingRight();
         int var7 = this.getPaddingLeft();
         int var9 = this.getPaddingRight();
         float var5 = (float)this.getScrollX() / (var2 - var7 - var9 + var4);
         this.scrollTo((int)((var1 - var6 - var8 + var3) * var5), this.getScrollY());
      }
   }

   private void a(int var1, boolean var2, int var3, boolean var4) {
      ViewPager.ItemInfo var7 = this.b(var1);
      int var6;
      if (var7 != null) {
         float var5 = this.getClientWidth();
         var6 = (int)(Math.max(this.t, Math.min(var7.e, this.u)) * var5);
      } else {
         var6 = 0;
      }

      if (var2) {
         this.a(var6, 0, var3);
         if (var4) {
            this.e(var1);
         }
      } else {
         if (var4) {
            this.e(var1);
         }

         this.a(false);
         this.scrollTo(var6, 0);
         this.d(var6);
      }
   }

   private void a(ViewPager.ItemInfo var1, int var2, ViewPager.ItemInfo var3) {
      int var10 = this.b.b();
      int var7 = this.getClientWidth();
      float var5;
      if (var7 > 0) {
         var5 = (float)this.p / var7;
      } else {
         var5 = 0.0F;
      }

      if (var3 != null) {
         var7 = var3.b;
         if (var7 < var1.b) {
            float var4 = var3.e + var3.d + var5;
            var7++;
            int var8 = 0;

            while (var7 <= var1.b && var8 < this.g.size()) {
               var3 = this.g.get(var8);

               float var6;
               int var9;
               while (true) {
                  var9 = var7;
                  var6 = var4;
                  if (var7 <= var3.b) {
                     break;
                  }

                  var9 = var7;
                  var6 = var4;
                  if (var8 >= this.g.size() - 1) {
                     break;
                  }

                  var3 = this.g.get(++var8);
               }

               while (var9 < var3.b) {
                  var6 += this.b.d(var9) + var5;
                  var9++;
               }

               var3.e = var6;
               var4 = var6 + (var3.d + var5);
               var7 = var9 + 1;
            }
         } else if (var7 > var1.b) {
            int var28 = this.g.size() - 1;
            float var16 = var3.e;
            var7--;

            while (var7 >= var1.b && var28 >= 0) {
               var3 = this.g.get(var28);

               float var21;
               int var31;
               while (true) {
                  var31 = var7;
                  var21 = var16;
                  if (var7 >= var3.b) {
                     break;
                  }

                  var31 = var7;
                  var21 = var16;
                  if (var28 <= 0) {
                     break;
                  }

                  var3 = this.g.get(--var28);
               }

               while (var31 > var3.b) {
                  var21 -= this.b.d(var31) + var5;
                  var31--;
               }

               var16 = var21 - (var3.d + var5);
               var3.e = var16;
               var7 = var31 - 1;
            }
         }
      }

      int var32 = this.g.size();
      float var22 = var1.e;
      var7 = var1.b - 1;
      float var17;
      if (var1.b == 0) {
         var17 = var1.e;
      } else {
         var17 = -Float.MAX_VALUE;
      }

      this.t = var17;
      if (var1.b == var10 - 1) {
         var17 = var1.e + var1.d - 1.0F;
      } else {
         var17 = Float.MAX_VALUE;
      }

      this.u = var17;
      int var29 = var2 - 1;
      var17 = var22;

      while (var29 >= 0) {
         for (var3 = this.g.get(var29); var7 > var3.b; var7--) {
            var17 -= this.b.d(var7) + var5;
         }

         var17 -= var3.d + var5;
         var3.e = var17;
         if (var3.b == 0) {
            this.t = var17;
         }

         var7--;
         var29--;
      }

      var17 = var1.e + var1.d + var5;
      var29 = var1.b + 1;
      var7 = var2 + 1;
      var2 = var29;

      while (var7 < var32) {
         for (var1 = this.g.get(var7); var2 < var1.b; var2++) {
            var17 += this.b.d(var2) + var5;
         }

         if (var1.b == var10 - 1) {
            this.u = var1.d + var17 - 1.0F;
         }

         var1.e = var17;
         var17 += var1.d + var5;
         var2++;
         var7++;
      }

      this.U = false;
   }

   private void a(MotionEvent var1) {
      int var2 = var1.getActionIndex();
      if (var1.getPointerId(var2) == this.K) {
         byte var3;
         if (var2 == 0) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         this.G = var1.getX(var3);
         this.K = var1.getPointerId(var3);
         if (this.L != null) {
            this.L.clear();
         }
      }
   }

   private void a(boolean var1) {
      boolean var2;
      if (this.ak == 2) {
         var2 = true;
      } else {
         var2 = false;
      }

      if (var2) {
         this.setScrollingCacheEnabled(false);
         boolean var3;
         if (!this.m.isFinished()) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         if (var3) {
            this.m.abortAnimation();
            int var5 = this.getScrollX();
            int var4 = this.getScrollY();
            var3 = this.m.getCurrX();
            int var6 = this.m.getCurrY();
            if (var5 != var3 || var4 != var6) {
               this.scrollTo(var3, var6);
               if (var3 != var5) {
                  this.d(var3);
               }
            }
         }
      }

      this.z = false;
      byte var11 = 0;
      boolean var10 = var2;

      for (int var8 = var11; var8 < this.g.size(); var8++) {
         ViewPager.ItemInfo var7 = this.g.get(var8);
         if (var7.c) {
            var7.c = false;
            var10 = true;
         }
      }

      if (var10) {
         if (var1) {
            ViewCompat.a(this, this.aj);
         } else {
            this.aj.run();
         }
      }
   }

   private boolean a(float var1, float var2) {
      boolean var3;
      if ((!(var1 < this.E) || !(var2 > 0.0F)) && (!(var1 > this.getWidth() - this.E) || !(var2 < 0.0F))) {
         var3 = false;
      } else {
         var3 = true;
      }

      return var3;
   }

   private void b(int var1, float var2, int var3) {
      if (this.ab != null) {
         this.ab.a(var1, var2, var3);
      }

      if (this.aa != null) {
         int var5 = this.aa.size();

         for (int var4 = 0; var4 < var5; var4++) {
            ViewPager.OnPageChangeListener var6 = this.aa.get(var4);
            if (var6 != null) {
               var6.a(var1, var2, var3);
            }
         }
      }

      if (this.ac != null) {
         this.ac.a(var1, var2, var3);
      }
   }

   private void b(boolean var1) {
      int var4 = this.getChildCount();

      for (int var2 = 0; var2 < var4; var2++) {
         int var3;
         if (var1) {
            var3 = this.af;
         } else {
            var3 = 0;
         }

         this.getChildAt(var2).setLayerType(var3, null);
      }
   }

   private boolean b(float var1) {
      boolean var8 = true;
      boolean var9 = true;
      float var2 = this.G;
      this.G = var1;
      float var3 = this.getScrollX() + (var2 - var1);
      int var7 = this.getClientWidth();
      var1 = var7 * this.t;
      float var4 = var7;
      var2 = this.u;
      ViewPager.ItemInfo var11 = this.g.get(0);
      ViewPager.ItemInfo var10 = this.g.get(this.g.size() - 1);
      boolean var5;
      if (var11.b != 0) {
         var1 = var11.e * var7;
         var5 = false;
      } else {
         var5 = true;
      }

      boolean var6;
      if (var10.b != this.b.b() - 1) {
         var2 = var10.e * var7;
         var6 = false;
      } else {
         var2 = var4 * var2;
         var6 = true;
      }

      if (var3 < var1) {
         if (var5) {
            this.R.onPull(Math.abs(var1 - var3) / var7);
            var8 = var9;
         } else {
            var8 = false;
         }
      } else if (var3 > var2) {
         if (var6) {
            this.S.onPull(Math.abs(var3 - var2) / var7);
         } else {
            var8 = false;
         }

         var1 = var2;
      } else {
         var1 = var3;
         var8 = false;
      }

      this.G += var1 - (int)var1;
      this.scrollTo((int)var1, this.getScrollY());
      this.d((int)var1);
      return var8;
   }

   private void c(boolean var1) {
      ViewParent var2 = this.getParent();
      if (var2 != null) {
         var2.requestDisallowInterceptTouchEvent(var1);
      }
   }

   private static boolean c(View var0) {
      boolean var1;
      if (var0.getClass().getAnnotation(ViewPager.DecorView.class) != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private boolean d(int var1) {
      boolean var6 = false;
      if (this.g.size() == 0) {
         if (!this.T) {
            this.V = false;
            this.a(0, 0.0F, 0);
            if (!this.V) {
               throw new IllegalStateException("onPageScrolled did not call superclass implementation");
            }
         }
      } else {
         ViewPager.ItemInfo var7 = this.i();
         int var4 = this.getClientWidth();
         int var5 = this.p;
         float var2 = (float)this.p / var4;
         int var3 = var7.b;
         var2 = ((float)var1 / var4 - var7.e) / (var7.d + var2);
         var1 = (int)((var5 + var4) * var2);
         this.V = false;
         this.a(var3, var2, var1);
         if (!this.V) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
         }

         var6 = true;
      }

      return var6;
   }

   private void e(int var1) {
      if (this.ab != null) {
         this.ab.b(var1);
      }

      if (this.aa != null) {
         int var3 = this.aa.size();

         for (int var2 = 0; var2 < var3; var2++) {
            ViewPager.OnPageChangeListener var4 = this.aa.get(var2);
            if (var4 != null) {
               var4.b(var1);
            }
         }
      }

      if (this.ac != null) {
         this.ac.b(var1);
      }
   }

   private void f() {
      int var1 = 0;

      while (var1 < this.getChildCount()) {
         int var2 = var1;
         if (!((ViewPager.LayoutParams)this.getChildAt(var1).getLayoutParams()).a) {
            this.removeViewAt(var1);
            var2 = var1 - 1;
         }

         var1 = var2 + 1;
      }
   }

   private void f(int var1) {
      if (this.ab != null) {
         this.ab.a(var1);
      }

      if (this.aa != null) {
         int var3 = this.aa.size();

         for (int var2 = 0; var2 < var3; var2++) {
            ViewPager.OnPageChangeListener var4 = this.aa.get(var2);
            if (var4 != null) {
               var4.a(var1);
            }
         }
      }

      if (this.ac != null) {
         this.ac.a(var1);
      }
   }

   private void g() {
      if (this.ag != 0) {
         if (this.ah == null) {
            this.ah = new ArrayList<>();
         } else {
            this.ah.clear();
         }

         int var2 = this.getChildCount();

         for (int var1 = 0; var1 < var2; var1++) {
            View var3 = this.getChildAt(var1);
            this.ah.add(var3);
         }

         Collections.sort(this.ah, ai);
      }
   }

   private int getClientWidth() {
      return this.getMeasuredWidth() - this.getPaddingLeft() - this.getPaddingRight();
   }

   private boolean h() {
      this.K = -1;
      this.j();
      this.R.onRelease();
      this.S.onRelease();
      boolean var1;
      if (!this.R.isFinished() && !this.S.isFinished()) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   private ViewPager.ItemInfo i() {
      int var5 = this.getClientWidth();
      float var1;
      if (var5 > 0) {
         var1 = (float)this.getScrollX() / var5;
      } else {
         var1 = 0.0F;
      }

      float var2;
      if (var5 > 0) {
         var2 = (float)this.p / var5;
      } else {
         var2 = 0.0F;
      }

      float var4 = 0.0F;
      float var3 = 0.0F;
      int var7 = -1;
      var5 = 0;
      boolean var6 = true;
      ViewPager.ItemInfo var9 = null;

      ViewPager.ItemInfo var10;
      while (true) {
         var10 = var9;
         if (var5 >= this.g.size()) {
            break;
         }

         ViewPager.ItemInfo var8 = this.g.get(var5);
         if (!var6 && var8.b != var7 + 1) {
            var8 = this.h;
            var8.e = var4 + var3 + var2;
            var8.b = var7 + 1;
            var8.d = this.b.d(var8.b);
            var5--;
         }

         var3 = var8.e;
         var4 = var8.d;
         if (!var6) {
            var10 = var9;
            if (!(var1 >= var3)) {
               break;
            }
         }

         if (var1 < var4 + var3 + var2 || var5 == this.g.size() - 1) {
            var10 = var8;
            break;
         }

         var7 = var8.b;
         var4 = var8.d;
         var6 = false;
         var5++;
         var9 = var8;
      }

      return var10;
   }

   private void j() {
      this.B = false;
      this.C = false;
      if (this.L != null) {
         this.L.recycle();
         this.L = null;
      }
   }

   private void setScrollingCacheEnabled(boolean var1) {
      if (this.y != var1) {
         this.y = var1;
      }
   }

   float a(float var1) {
      return (float)Math.sin((var1 - 0.5F) * 0.47123894F);
   }

   ViewPager.ItemInfo a(int var1, int var2) {
      ViewPager.ItemInfo var3 = new ViewPager.ItemInfo();
      var3.b = var1;
      var3.a = this.b.a(this, var1);
      var3.d = this.b.d(var1);
      if (var2 >= 0 && var2 < this.g.size()) {
         this.g.add(var2, var3);
      } else {
         this.g.add(var3);
      }

      return var3;
   }

   ViewPager.ItemInfo a(View var1) {
      int var2 = 0;

      while (true) {
         if (var2 >= this.g.size()) {
            var4 = null;
            break;
         }

         ViewPager.ItemInfo var3 = this.g.get(var2);
         if (this.b.a(var1, var3.a)) {
            var4 = var3;
            break;
         }

         var2++;
      }

      return var4;
   }

   void a() {
      this.setWillNotDraw(false);
      this.setDescendantFocusability(262144);
      this.setFocusable(true);
      Context var2 = this.getContext();
      this.m = new Scroller(var2, f);
      ViewConfiguration var3 = ViewConfiguration.get(var2);
      float var1 = var2.getResources().getDisplayMetrics().density;
      this.F = var3.getScaledPagingTouchSlop();
      this.M = (int)(400.0F * var1);
      this.N = var3.getScaledMaximumFlingVelocity();
      this.R = new EdgeEffect(var2);
      this.S = new EdgeEffect(var2);
      this.O = (int)(25.0F * var1);
      this.P = (int)(2.0F * var1);
      this.D = (int)(16.0F * var1);
      ViewCompat.a(this, new ViewPager.MyAccessibilityDelegate(this));
      if (ViewCompat.d(this) == 0) {
         ViewCompat.a(this, 1);
      }

      ViewCompat.a(this, new OnApplyWindowInsetsListener(this) {
         final ViewPager a;
         private final Rect b;

         {
            this.a = var1;
            this.b = new Rect();
         }

         @Override
         public WindowInsetsCompat a(View var1, WindowInsetsCompat var2x) {
            WindowInsetsCompat var6 = ViewCompat.a(var1, var2x);
            if (!var6.f()) {
               Rect var5 = this.b;
               var5.left = var6.a();
               var5.top = var6.b();
               var5.right = var6.c();
               var5.bottom = var6.d();
               int var3x = 0;

               for (int var4 = this.a.getChildCount(); var3x < var4; var3x++) {
                  var2x = ViewCompat.b(this.a.getChildAt(var3x), var6);
                  var5.left = Math.min(var2x.a(), var5.left);
                  var5.top = Math.min(var2x.b(), var5.top);
                  var5.right = Math.min(var2x.c(), var5.right);
                  var5.bottom = Math.min(var2x.d(), var5.bottom);
               }

               var6 = var6.a(var5.left, var5.top, var5.right, var5.bottom);
            }

            return var6;
         }
      });
   }

   void a(int var1) {
      ViewPager.ItemInfo var14;
      if (this.c != var1) {
         var14 = this.b(this.c);
         this.c = var1;
      } else {
         var14 = null;
      }

      if (this.b == null) {
         this.g();
      } else if (this.z) {
         this.g();
      } else if (this.getWindowToken() != null) {
         this.b.a(this);
         var1 = this.A;
         int var11 = Math.max(0, this.c - var1);
         int var9 = this.b.b();
         int var10 = Math.min(var9 - 1, var1 + this.c);
         if (var9 != this.d) {
            String var40;
            try {
               var40 = this.getResources().getResourceName(this.getId());
            } catch (NotFoundException var17) {
               var40 = Integer.toHexString(this.getId());
            }

            throw new IllegalStateException(
               "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: "
                  + this.d
                  + ", found: "
                  + var9
                  + " Pager id: "
                  + var40
                  + " Pager class: "
                  + this.getClass()
                  + " Problematic adapter: "
                  + this.b.getClass()
            );
         }

         ViewPager.ItemInfo var13;
         label208: {
            for (var1 = 0; var1 < this.g.size(); var1++) {
               var13 = this.g.get(var1);
               if (var13.b >= this.c) {
                  if (var13.b == this.c) {
                     break label208;
                  }
                  break;
               }
            }

            var13 = null;
         }

         ViewPager.ItemInfo var15;
         if (var13 == null && var9 > 0) {
            var15 = this.a(this.c, var1);
         } else {
            var15 = var13;
         }

         if (var15 != null) {
            int var8 = var1 - 1;
            if (var8 >= 0) {
               var13 = this.g.get(var8);
            } else {
               var13 = null;
            }

            int var12 = this.getClientWidth();
            float var3;
            if (var12 <= 0) {
               var3 = 0.0F;
            } else {
               var3 = 2.0F - var15.d + (float)this.getPaddingLeft() / var12;
            }

            int var5 = this.c;
            float var4 = 0.0F;
            int var7 = var5 - 1;
            int var6 = var1;
            ViewPager.ItemInfo var16 = var13;

            while (var7 >= 0) {
               float var2;
               if (var4 >= var3 && var7 < var11) {
                  if (var16 == null) {
                     break;
                  }

                  var13 = var16;
                  var1 = var8;
                  var2 = var4;
                  var5 = var6;
                  if (var7 == var16.b) {
                     var13 = var16;
                     var1 = var8;
                     var2 = var4;
                     var5 = var6;
                     if (!var16.c) {
                        this.g.remove(var8);
                        this.b.a(this, var7, var16.a);
                        var1 = var8 - 1;
                        var5 = var6 - 1;
                        if (var1 >= 0) {
                           var13 = this.g.get(var1);
                           var2 = var4;
                        } else {
                           var13 = null;
                           var2 = var4;
                        }
                     }
                  }
               } else if (var16 != null && var7 == var16.b) {
                  var2 = var4 + var16.d;
                  var1 = var8 - 1;
                  if (var1 >= 0) {
                     var13 = this.g.get(var1);
                     var5 = var6;
                  } else {
                     var13 = null;
                     var5 = var6;
                  }
               } else {
                  var2 = var4 + this.a(var7, var8 + 1).d;
                  var5 = var6 + 1;
                  if (var8 >= 0) {
                     var13 = this.g.get(var8);
                     var1 = var8;
                  } else {
                     var13 = null;
                     var1 = var8;
                  }
               }

               var7--;
               var16 = var13;
               var8 = var1;
               var4 = var2;
               var6 = var5;
            }

            float var24 = var15.d;
            var1 = var6 + 1;
            if (var24 < 2.0F) {
               if (var1 < this.g.size()) {
                  var13 = this.g.get(var1);
               } else {
                  var13 = null;
               }

               if (var12 <= 0) {
                  var3 = 0.0F;
               } else {
                  var3 = (float)this.getPaddingRight() / var12 + 2.0F;
               }

               var5 = this.c;
               var5++;

               for (; var5 < var9; var5++) {
                  if (var24 >= var3 && var5 > var10) {
                     if (var13 == null) {
                        break;
                     }

                     if (var5 == var13.b && !var13.c) {
                        this.g.remove(var1);
                        this.b.a(this, var5, var13.a);
                        if (var1 < this.g.size()) {
                           var13 = this.g.get(var1);
                        } else {
                           var13 = null;
                        }
                     }
                  } else if (var13 != null && var5 == var13.b) {
                     var4 = var13.d;
                     if (++var1 < this.g.size()) {
                        var13 = this.g.get(var1);
                     } else {
                        var13 = null;
                     }

                     var24 += var4;
                  } else {
                     var13 = this.a(var5, var1);
                     var1++;
                     var4 = var13.d;
                     if (var1 < this.g.size()) {
                        var13 = this.g.get(var1);
                     } else {
                        var13 = null;
                     }

                     var24 += var4;
                  }
               }
            }

            this.a(var15, var6, var14);
            this.b.b(this, this.c, var15.a);
         }

         this.b.b(this);
         int var31 = this.getChildCount();

         for (int var22 = 0; var22 < var31; var22++) {
            View var41 = this.getChildAt(var22);
            ViewPager.LayoutParams var36 = (ViewPager.LayoutParams)var41.getLayoutParams();
            var36.f = var22;
            if (!var36.a && var36.c == 0.0F) {
               var14 = this.a(var41);
               if (var14 != null) {
                  var36.c = var14.d;
                  var36.e = var14.b;
               }
            }
         }

         this.g();
         if (this.hasFocus()) {
            View var37 = this.findFocus();
            if (var37 != null) {
               var13 = this.b(var37);
            } else {
               var13 = null;
            }

            if (var13 == null || var13.b != this.c) {
               for (int var23 = 0; var23 < this.getChildCount(); var23++) {
                  View var43 = this.getChildAt(var23);
                  var13 = this.a(var43);
                  if (var13 != null && var13.b == this.c && var43.requestFocus(2)) {
                     break;
                  }
               }
            }
         }
      }
   }

   protected void a(int var1, float var2, int var3) {
      if (this.W > 0) {
         int var10 = this.getScrollX();
         int var4 = this.getPaddingLeft();
         int var5 = this.getPaddingRight();
         int var11 = this.getWidth();
         int var9 = this.getChildCount();
         int var8 = 0;

         while (var8 < var9) {
            View var14 = this.getChildAt(var8);
            ViewPager.LayoutParams var13 = (ViewPager.LayoutParams)var14.getLayoutParams();
            int var6;
            int var7;
            if (!var13.a) {
               var6 = var4;
               var7 = var5;
            } else {
               switch (var13.b & 7) {
                  case 1:
                     var6 = Math.max((var11 - var14.getMeasuredWidth()) / 2, var4);
                     var7 = var4;
                     var4 = var5;
                     var5 = var7;
                     break;
                  case 2:
                  case 4:
                  default:
                     var6 = var4;
                     var7 = var4;
                     var4 = var5;
                     var5 = var7;
                     break;
                  case 3:
                     var6 = var14.getWidth();
                     var7 = var6 + var4;
                     var6 = var4;
                     var4 = var5;
                     var5 = var7;
                     break;
                  case 5:
                     var6 = var11 - var5 - var14.getMeasuredWidth();
                     int var12 = var14.getMeasuredWidth();
                     var7 = var4;
                     var4 = var5 + var12;
                     var5 = var7;
               }

               int var27 = var6 + var10 - var14.getLeft();
               var7 = var4;
               var6 = var5;
               if (var27 != 0) {
                  var14.offsetLeftAndRight(var27);
                  var7 = var4;
                  var6 = var5;
               }
            }

            var8++;
            var4 = var6;
            var5 = var7;
         }
      }

      this.b(var1, var2, var3);
      if (this.ae != null) {
         var3 = this.getScrollX();
         int var19 = this.getChildCount();

         for (int var15 = 0; var15 < var19; var15++) {
            View var28 = this.getChildAt(var15);
            if (!((ViewPager.LayoutParams)var28.getLayoutParams()).a) {
               var2 = (float)(var28.getLeft() - var3) / this.getClientWidth();
               this.ae.a(var28, var2);
            }
         }
      }

      this.V = true;
   }

   void a(int var1, int var2, int var3) {
      if (this.getChildCount() == 0) {
         this.setScrollingCacheEnabled(false);
      } else {
         boolean var7;
         if (this.m != null && !this.m.isFinished()) {
            var7 = 1;
         } else {
            var7 = 0;
         }

         if (var7) {
            if (this.n) {
               var7 = this.m.getCurrX();
            } else {
               var7 = this.m.getStartX();
            }

            this.m.abortAnimation();
            this.setScrollingCacheEnabled(false);
         } else {
            var7 = this.getScrollX();
         }

         int var8 = this.getScrollY();
         int var9 = var1 - var7;
         var2 -= var8;
         if (var9 == 0 && var2 == 0) {
            this.a(false);
            this.c();
            this.setScrollState(0);
         } else {
            this.setScrollingCacheEnabled(true);
            this.setScrollState(2);
            var1 = this.getClientWidth();
            int var10 = var1 / 2;
            float var6 = Math.min(1.0F, Math.abs(var9) * 1.0F / var1);
            float var4 = var10;
            float var5 = var10;
            var6 = this.a(var6);
            var3 = Math.abs(var3);
            if (var3 > 0) {
               var1 = Math.round(1000.0F * Math.abs((var5 * var6 + var4) / var3)) * 4;
            } else {
               var5 = var1;
               var4 = this.b.d(this.c);
               var1 = (int)((Math.abs(var9) / (var5 * var4 + this.p) + 1.0F) * 100.0F);
            }

            var1 = Math.min(var1, 600);
            this.n = false;
            this.m.startScroll(var7, var8, var9, var2, var1);
            ViewCompat.c(this);
         }
      }
   }

   public void a(int var1, boolean var2) {
      this.z = false;
      this.a(var1, var2, false);
   }

   void a(int var1, boolean var2, boolean var3) {
      this.a(var1, var2, var3, 0);
   }

   void a(int var1, boolean var2, boolean var3, int var4) {
      boolean var6 = false;
      if (this.b == null || this.b.b() <= 0) {
         this.setScrollingCacheEnabled(false);
      } else if (!var3 && this.c == var1 && this.g.size() != 0) {
         this.setScrollingCacheEnabled(false);
      } else {
         int var5;
         if (var1 < 0) {
            var5 = 0;
         } else {
            var5 = var1;
            if (var1 >= this.b.b()) {
               var5 = this.b.b() - 1;
            }
         }

         var1 = this.A;
         if (var5 > this.c + var1 || var5 < this.c - var1) {
            for (int var8 = 0; var8 < this.g.size(); var8++) {
               this.g.get(var8).c = true;
            }
         }

         var3 = var6;
         if (this.c != var5) {
            var3 = true;
         }

         if (this.T) {
            this.c = var5;
            if (var3) {
               this.e(var5);
            }

            this.requestLayout();
         } else {
            this.a(var5);
            this.a(var5, var2, var4, var3);
         }
      }
   }

   public void a(ViewPager.OnAdapterChangeListener var1) {
      if (this.ad == null) {
         this.ad = new ArrayList<>();
      }

      this.ad.add(var1);
   }

   public void a(ViewPager.OnPageChangeListener var1) {
      if (this.aa == null) {
         this.aa = new ArrayList<>();
      }

      this.aa.add(var1);
   }

   public void a(boolean var1, ViewPager.PageTransformer var2) {
      this.a(var1, var2, 2);
   }

   public void a(boolean var1, ViewPager.PageTransformer var2, int var3) {
      byte var5 = 1;
      boolean var6;
      if (var2 != null) {
         var6 = true;
      } else {
         var6 = false;
      }

      boolean var7;
      if (this.ae != null) {
         var7 = true;
      } else {
         var7 = false;
      }

      boolean var4;
      if (var6 != var7) {
         var4 = true;
      } else {
         var4 = false;
      }

      this.ae = var2;
      this.setChildrenDrawingOrderEnabled(var6);
      if (var6) {
         if (var1) {
            var5 = 2;
         }

         this.ag = var5;
         this.af = var3;
      } else {
         this.ag = 0;
      }

      if (var4) {
         this.c();
      }
   }

   public boolean a(KeyEvent var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if (var1.getAction() == 0) {
         switch (var1.getKeyCode()) {
            case 21:
               if (var1.hasModifiers(2)) {
                  var2 = this.d();
               } else {
                  var2 = this.c(17);
               }
               break;
            case 22:
               if (var1.hasModifiers(2)) {
                  var2 = this.e();
               } else {
                  var2 = this.c(66);
               }
               break;
            case 61:
               if (var1.hasNoModifiers()) {
                  var2 = this.c(2);
               } else {
                  var2 = var3;
                  if (var1.hasModifiers(1)) {
                     var2 = this.c(1);
                  }
               }
               break;
            default:
               var2 = var3;
         }
      }

      return var2;
   }

   protected boolean a(View var1, boolean var2, int var3, int var4, int var5) {
      boolean var9 = true;
      if (var1 instanceof ViewGroup) {
         ViewGroup var10 = (ViewGroup)var1;
         int var7 = var1.getScrollX();
         int var8 = var1.getScrollY();

         for (int var6 = var10.getChildCount() - 1; var6 >= 0; var6--) {
            View var11 = var10.getChildAt(var6);
            if (var4 + var7 >= var11.getLeft()
               && var4 + var7 < var11.getRight()
               && var5 + var8 >= var11.getTop()
               && var5 + var8 < var11.getBottom()
               && this.a(var11, true, var3, var4 + var7 - var11.getLeft(), var5 + var8 - var11.getTop())) {
               var2 = var9;
               return var2;
            }
         }
      }

      if (var2) {
         var2 = var9;
         if (var1.canScrollHorizontally(-var3)) {
            return var2;
         }
      }

      return false;
   }

   public void addFocusables(ArrayList<View> var1, int var2, int var3) {
      int var5 = var1.size();
      int var6 = this.getDescendantFocusability();
      if (var6 != 393216) {
         for (int var4 = 0; var4 < this.getChildCount(); var4++) {
            View var8 = this.getChildAt(var4);
            if (var8.getVisibility() == 0) {
               ViewPager.ItemInfo var7 = this.a(var8);
               if (var7 != null && var7.b == this.c) {
                  var8.addFocusables(var1, var2, var3);
               }
            }
         }
      }

      if ((var6 != 262144 || var5 == var1.size())
         && this.isFocusable()
         && ((var3 & 1) != 1 || !this.isInTouchMode() || this.isFocusableInTouchMode())
         && var1 != null) {
         var1.add(this);
      }
   }

   public void addTouchables(ArrayList<View> var1) {
      for (int var2 = 0; var2 < this.getChildCount(); var2++) {
         View var3 = this.getChildAt(var2);
         if (var3.getVisibility() == 0) {
            ViewPager.ItemInfo var4 = this.a(var3);
            if (var4 != null && var4.b == this.c) {
               var3.addTouchables(var1);
            }
         }
      }
   }

   public void addView(View var1, int var2, android.view.ViewGroup.LayoutParams var3) {
      if (!this.checkLayoutParams(var3)) {
         var3 = this.generateLayoutParams(var3);
      }

      ViewPager.LayoutParams var4 = (ViewPager.LayoutParams)var3;
      var4.a = var4.a | c(var1);
      if (this.x) {
         if (var4 != null && var4.a) {
            throw new IllegalStateException("Cannot add pager decor view during layout");
         }

         var4.d = true;
         this.addViewInLayout(var1, var2, var3);
      } else {
         super.addView(var1, var2, var3);
      }
   }

   ViewPager.ItemInfo b(int var1) {
      int var2 = 0;

      ViewPager.ItemInfo var3;
      while (true) {
         if (var2 >= this.g.size()) {
            var3 = null;
            break;
         }

         var3 = this.g.get(var2);
         if (var3.b == var1) {
            break;
         }

         var2++;
      }

      return var3;
   }

   ViewPager.ItemInfo b(View var1) {
      while (true) {
         ViewParent var2 = var1.getParent();
         ViewPager.ItemInfo var3;
         if (var2 != this) {
            if (var2 != null && var2 instanceof View) {
               var1 = (View)var2;
               continue;
            }

            var3 = null;
         } else {
            var3 = this.a(var1);
         }

         return var3;
      }
   }

   void b() {
      int var7 = this.b.b();
      this.d = var7;
      boolean var1;
      if (this.g.size() < this.A * 2 + 1 && this.g.size() < var7) {
         var1 = 1;
      } else {
         var1 = 0;
      }

      int var2 = this.c;
      int var3 = 0;
      int var5 = 0;
      int var4 = var1;
      var1 = var2;
      int var11 = var3;
      var3 = var5;

      while (var3 < this.g.size()) {
         ViewPager.ItemInfo var8 = this.g.get(var3);
         var5 = this.b.a(var8.a);
         boolean var10;
         boolean var15;
         if (var5 == -1) {
            var5 = var3;
            boolean var6 = (boolean)var11;
            var15 = (boolean)var4;
            var11 = var1;
            var10 = var6;
            var4 = var5;
         } else if (var5 == -2) {
            this.g.remove(var3);
            var4 = var3 - 1;
            var15 = (boolean)var11;
            if (!var11) {
               this.b.a(this);
               var15 = true;
            }

            this.b.a(this, var8.b, var8.a);
            if (this.c == var8.b) {
               var11 = Math.max(0, Math.min(this.c, var7 - 1));
               var10 = var15;
               var15 = true;
            } else {
               var11 = var1;
               boolean var21 = true;
               var10 = var15;
               var15 = var21;
            }
         } else if (var8.b != var5) {
            if (var8.b == this.c) {
               var1 = var5;
            }

            var8.b = var5;
            var5 = var1;
            boolean var25 = true;
            var4 = var3;
            var10 = (boolean)var11;
            var11 = var5;
            var15 = var25;
         } else {
            boolean var26 = (boolean)var11;
            var11 = var1;
            boolean var23 = (boolean)var4;
            var4 = var3;
            var10 = var26;
            var15 = var23;
         }

         boolean var24 = var15;
         int var27 = var11;
         var3 = var4 + 1;
         var11 = var10;
         var1 = var27;
         var4 = var24;
      }

      if (var11) {
         this.b.b(this);
      }

      Collections.sort(this.g, e);
      if (var4) {
         var3 = this.getChildCount();

         for (int var13 = 0; var13 < var3; var13++) {
            ViewPager.LayoutParams var28 = (ViewPager.LayoutParams)this.getChildAt(var13).getLayoutParams();
            if (!var28.a) {
               var28.c = 0.0F;
            }
         }

         this.a(var1, false, true);
         this.requestLayout();
      }
   }

   public void b(ViewPager.OnAdapterChangeListener var1) {
      if (this.ad != null) {
         this.ad.remove(var1);
      }
   }

   public void b(ViewPager.OnPageChangeListener var1) {
      if (this.aa != null) {
         this.aa.remove(var1);
      }
   }

   ViewPager.OnPageChangeListener c(ViewPager.OnPageChangeListener var1) {
      ViewPager.OnPageChangeListener var2 = this.ac;
      this.ac = var1;
      return var2;
   }

   void c() {
      this.a(this.c);
   }

   public boolean c(int var1) {
      View var6 = this.findFocus();
      View var5;
      if (var6 == this) {
         var5 = null;
      } else {
         label89: {
            if (var6 != null) {
               ViewParent var11 = var6.getParent();

               boolean var2;
               while (true) {
                  if (!(var11 instanceof ViewGroup)) {
                     var2 = false;
                     break;
                  }

                  if (var11 == this) {
                     var2 = true;
                     break;
                  }

                  var11 = var11.getParent();
               }

               if (!var2) {
                  StringBuilder var7 = new StringBuilder();
                  var7.append(var6.getClass().getSimpleName());

                  for (ViewParent var12 = var6.getParent(); var12 instanceof ViewGroup; var12 = var12.getParent()) {
                     var7.append(" => ").append(var12.getClass().getSimpleName());
                  }

                  Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + var7.toString());
                  var5 = null;
                  break label89;
               }
            }

            var5 = var6;
         }
      }

      boolean var4;
      label98: {
         var6 = FocusFinder.getInstance().findNextFocus(this, var5, var1);
         if (var6 != null && var6 != var5) {
            if (var1 == 17) {
               int var10 = this.a(this.i, var6).left;
               int var9 = this.a(this.i, var5).left;
               if (var5 != null && var10 >= var9) {
                  var4 = this.d();
               } else {
                  var4 = var6.requestFocus();
               }
               break label98;
            }

            if (var1 == 66) {
               int var3 = this.a(this.i, var6).left;
               int var8 = this.a(this.i, var5).left;
               if (var5 != null && var3 <= var8) {
                  var4 = this.e();
               } else {
                  var4 = var6.requestFocus();
               }
               break label98;
            }
         } else {
            if (var1 == 17 || var1 == 1) {
               var4 = this.d();
               break label98;
            }

            if (var1 == 66 || var1 == 2) {
               var4 = this.e();
               break label98;
            }
         }

         var4 = false;
      }

      if (var4) {
         this.playSoundEffect(SoundEffectConstants.getContantForFocusDirection(var1));
      }

      return var4;
   }

   public boolean canScrollHorizontally(int var1) {
      boolean var5 = true;
      boolean var4 = true;
      boolean var6 = false;
      if (this.b == null) {
         var4 = var6;
      } else {
         int var2 = this.getClientWidth();
         int var3 = this.getScrollX();
         if (var1 < 0) {
            if (var3 <= (int)(var2 * this.t)) {
               var4 = false;
            }
         } else {
            var4 = var6;
            if (var1 > 0) {
               if (var3 < (int)(var2 * this.u)) {
                  var4 = var5;
               } else {
                  var4 = false;
               }
            }
         }
      }

      return var4;
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      boolean var2;
      if (var1 instanceof ViewPager.LayoutParams && super.checkLayoutParams(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public void computeScroll() {
      this.n = true;
      if (!this.m.isFinished() && this.m.computeScrollOffset()) {
         int var1 = this.getScrollX();
         int var2 = this.getScrollY();
         int var3 = this.m.getCurrX();
         int var4 = this.m.getCurrY();
         if (var1 != var3 || var2 != var4) {
            this.scrollTo(var3, var4);
            if (!this.d(var3)) {
               this.m.abortAnimation();
               this.scrollTo(0, var4);
            }
         }

         ViewCompat.c(this);
      } else {
         this.a(true);
      }
   }

   boolean d() {
      boolean var1 = true;
      if (this.c > 0) {
         this.a(this.c - 1, true);
      } else {
         var1 = false;
      }

      return var1;
   }

   public boolean dispatchKeyEvent(KeyEvent var1) {
      boolean var2;
      if (!super.dispatchKeyEvent(var1) && !this.a(var1)) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent var1) {
      boolean var5 = false;
      boolean var4;
      if (var1.getEventType() == 4096) {
         var4 = super.dispatchPopulateAccessibilityEvent(var1);
      } else {
         int var3 = this.getChildCount();
         int var2 = 0;

         while (true) {
            var4 = var5;
            if (var2 >= var3) {
               break;
            }

            View var6 = this.getChildAt(var2);
            if (var6.getVisibility() == 0) {
               ViewPager.ItemInfo var7 = this.a(var6);
               if (var7 != null && var7.b == this.c && var6.dispatchPopulateAccessibilityEvent(var1)) {
                  var4 = true;
                  break;
               }
            }

            var2++;
         }
      }

      return var4;
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      int var3 = 0;
      int var2 = 0;
      int var4 = this.getOverScrollMode();
      if (var4 == 0 || var4 == 1 && this.b != null && this.b.b() > 1) {
         if (!this.R.isFinished()) {
            var3 = var1.save();
            var2 = this.getHeight() - this.getPaddingTop() - this.getPaddingBottom();
            var4 = this.getWidth();
            var1.rotate(270.0F);
            var1.translate(-var2 + this.getPaddingTop(), this.t * var4);
            this.R.setSize(var2, var4);
            var2 = false | this.R.draw(var1);
            var1.restoreToCount(var3);
         }

         var3 = var2;
         if (!this.S.isFinished()) {
            var4 = var1.save();
            int var5 = this.getWidth();
            int var6 = this.getHeight();
            int var7 = this.getPaddingTop();
            var3 = this.getPaddingBottom();
            var1.rotate(90.0F);
            var1.translate(-this.getPaddingTop(), -(this.u + 1.0F) * var5);
            this.S.setSize(var6 - var7 - var3, var5);
            var3 = var2 | this.S.draw(var1);
            var1.restoreToCount(var4);
         }
      } else {
         this.R.finish();
         this.S.finish();
      }

      if (var3) {
         ViewCompat.c(this);
      }
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      Drawable var1 = this.q;
      if (var1 != null && var1.isStateful()) {
         var1.setState(this.getDrawableState());
      }
   }

   boolean e() {
      boolean var1 = true;
      if (this.b != null && this.c < this.b.b() - 1) {
         this.a(this.c + 1, true);
      } else {
         var1 = false;
      }

      return var1;
   }

   protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
      return new ViewPager.LayoutParams();
   }

   public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new ViewPager.LayoutParams(this.getContext(), var1);
   }

   protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return this.generateDefaultLayoutParams();
   }

   public PagerAdapter getAdapter() {
      return this.b;
   }

   protected int getChildDrawingOrder(int var1, int var2) {
      int var3 = var2;
      if (this.ag == 2) {
         var3 = var1 - 1 - var2;
      }

      return ((ViewPager.LayoutParams)this.ah.get(var3).getLayoutParams()).f;
   }

   public int getCurrentItem() {
      return this.c;
   }

   public int getOffscreenPageLimit() {
      return this.A;
   }

   public int getPageMargin() {
      return this.p;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.T = true;
   }

   protected void onDetachedFromWindow() {
      this.removeCallbacks(this.aj);
      if (this.m != null && !this.m.isFinished()) {
         this.m.abortAnimation();
      }

      super.onDetachedFromWindow();
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      if (this.p > 0 && this.q != null && this.g.size() > 0 && this.b != null) {
         int var10 = this.getScrollX();
         int var11 = this.getWidth();
         float var4 = (float)this.p / var11;
         ViewPager.ItemInfo var12 = this.g.get(0);
         float var2 = var12.e;
         int var8 = this.g.size();
         int var6 = var12.b;
         int var9 = this.g.get(var8 - 1).b;
         int var7 = 0;

         while (var6 < var9) {
            while (var6 > var12.b && var7 < var8) {
               ArrayList var13 = this.g;
               var12 = (ViewPager.ItemInfo)var13.get(++var7);
            }

            float var3;
            if (var6 == var12.b) {
               var3 = (var12.e + var12.d) * var11;
               var2 = var12.e + var12.d + var4;
            } else {
               float var5 = this.b.d(var6);
               var3 = (var2 + var5) * var11;
               var2 += var5 + var4;
            }

            if (this.p + var3 > var10) {
               this.q.setBounds(Math.round(var3), this.r, Math.round(this.p + var3), this.s);
               this.q.draw(var1);
            }

            if (var3 > var10 + var11) {
               break;
            }

            var6++;
         }
      }
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      boolean var9 = false;
      int var7 = var1.getAction() & 0xFF;
      boolean var8;
      if (var7 != 3 && var7 != 1) {
         if (var7 != 0) {
            if (this.B) {
               var8 = true;
               return var8;
            }

            var8 = var9;
            if (this.C) {
               return var8;
            }
         }

         switch (var7) {
            case 0:
               float var11 = var1.getX();
               this.I = var11;
               this.G = var11;
               var11 = var1.getY();
               this.J = var11;
               this.H = var11;
               this.K = var1.getPointerId(0);
               this.C = false;
               this.n = true;
               this.m.computeScrollOffset();
               if (this.ak == 2 && Math.abs(this.m.getFinalX() - this.m.getCurrX()) > this.P) {
                  this.m.abortAnimation();
                  this.z = false;
                  this.c();
                  this.B = true;
                  this.c(true);
                  this.setScrollState(1);
               } else {
                  this.a(false);
                  this.B = false;
               }
               break;
            case 2:
               var7 = this.K;
               if (var7 != -1) {
                  var7 = var1.findPointerIndex(var7);
                  float var4 = var1.getX(var7);
                  float var2 = var4 - this.G;
                  float var5 = Math.abs(var2);
                  float var3 = var1.getY(var7);
                  float var6 = Math.abs(var3 - this.J);
                  if (var2 != 0.0F && !this.a(this.G, var2) && this.a(this, false, (int)var2, (int)var4, (int)var3)) {
                     this.G = var4;
                     this.H = var3;
                     this.C = true;
                     var8 = var9;
                     return var8;
                  }

                  if (var5 > this.F && 0.5F * var5 > var6) {
                     this.B = true;
                     this.c(true);
                     this.setScrollState(1);
                     if (var2 > 0.0F) {
                        var2 = this.I + this.F;
                     } else {
                        var2 = this.I - this.F;
                     }

                     this.G = var2;
                     this.H = var3;
                     this.setScrollingCacheEnabled(true);
                  } else if (var6 > this.F) {
                     this.C = true;
                  }

                  if (this.B && this.b(var4)) {
                     ViewCompat.c(this);
                  }
               }
               break;
            case 6:
               this.a(var1);
         }

         if (this.L == null) {
            this.L = VelocityTracker.obtain();
         }

         this.L.addMovement(var1);
         var8 = this.B;
      } else {
         this.h();
         var8 = var9;
      }

      return var8;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      int var12 = this.getChildCount();
      int var14 = var4 - var2;
      int var13 = var5 - var3;
      var3 = this.getPaddingLeft();
      var2 = this.getPaddingTop();
      int var7 = this.getPaddingRight();
      var4 = this.getPaddingBottom();
      int var15 = this.getScrollX();
      int var8 = 0;
      int var10 = 0;

      while (var10 < var12) {
         label54: {
            View var18 = this.getChildAt(var10);
            if (var18.getVisibility() != 8) {
               ViewPager.LayoutParams var17 = (ViewPager.LayoutParams)var18.getLayoutParams();
               if (var17.a) {
                  var5 = var17.b;
                  int var11 = var17.b;
                  int var42;
                  switch (var5 & 7) {
                     case 1:
                        var5 = Math.max((var14 - var18.getMeasuredWidth()) / 2, var3);
                        var42 = var3;
                        break;
                     case 2:
                     case 4:
                     default:
                        var5 = var3;
                        var42 = var3;
                        break;
                     case 3:
                        var42 = var18.getMeasuredWidth();
                        var5 = var3;
                        var42 += var3;
                        break;
                     case 5:
                        var5 = var18.getMeasuredWidth();
                        var42 = var7 + var18.getMeasuredWidth();
                        var5 = var14 - var7 - var5;
                        var7 = var42;
                        var42 = var3;
                  }

                  switch (var11 & 112) {
                     case 16:
                        var11 = Math.max((var13 - var18.getMeasuredHeight()) / 2, var2);
                        var3 = var2;
                        var2 = var4;
                        var4 = var11;
                        break;
                     case 48:
                        var11 = var18.getMeasuredHeight();
                        var3 = var4;
                        var11 += var2;
                        var4 = var2;
                        var2 = var3;
                        var3 = var11;
                        break;
                     case 80:
                        var11 = var13 - var4 - var18.getMeasuredHeight();
                        int var16 = var18.getMeasuredHeight();
                        var3 = var2;
                        var2 = var4 + var16;
                        var4 = var11;
                        break;
                     default:
                        var11 = var2;
                        var3 = var2;
                        var2 = var4;
                        var4 = var11;
                  }

                  var5 += var15;
                  var18.layout(var5, var4, var18.getMeasuredWidth() + var5, var18.getMeasuredHeight() + var4);
                  var8++;
                  var5 = var7;
                  var4 = var42;
                  var7 = var2;
                  var2 = var8;
                  break label54;
               }
            }

            var5 = var8;
            var8 = var2;
            int var9 = var3;
            var2 = var5;
            var5 = var7;
            var7 = var4;
            var3 = var8;
            var4 = var9;
         }

         var10++;
         int var44 = var4;
         var8 = var2;
         var2 = var3;
         var4 = var7;
         var7 = var5;
         var3 = var44;
      }

      var7 = var14 - var3 - var7;

      for (int var35 = 0; var35 < var12; var35++) {
         View var52 = this.getChildAt(var35);
         if (var52.getVisibility() != 8) {
            ViewPager.LayoutParams var51 = (ViewPager.LayoutParams)var52.getLayoutParams();
            if (!var51.a) {
               ViewPager.ItemInfo var19 = this.a(var52);
               if (var19 != null) {
                  float var6 = var7;
                  int var45 = (int)(var19.e * var6) + var3;
                  if (var51.d) {
                     var51.d = false;
                     var6 = var7;
                     var52.measure(MeasureSpec.makeMeasureSpec((int)(var51.c * var6), 1073741824), MeasureSpec.makeMeasureSpec(var13 - var2 - var4, 1073741824));
                  }

                  var52.layout(var45, var2, var52.getMeasuredWidth() + var45, var52.getMeasuredHeight() + var2);
               }
            }
         }
      }

      this.r = var2;
      this.s = var13 - var4;
      this.W = var8;
      if (this.T) {
         this.a(this.c, false, 0, false);
      }

      this.T = false;
   }

   protected void onMeasure(int var1, int var2) {
      this.setMeasuredDimension(getDefaultSize(0, var1), getDefaultSize(0, var2));
      var1 = this.getMeasuredWidth();
      this.E = Math.min(var1 / 10, this.D);
      var1 = var1 - this.getPaddingLeft() - this.getPaddingRight();
      var2 = this.getMeasuredHeight() - this.getPaddingTop() - this.getPaddingBottom();
      int var12 = this.getChildCount();
      int var6 = 0;

      while (var6 < var12) {
         View var14 = this.getChildAt(var6);
         int var4 = var1;
         int var5 = var2;
         if (var14.getVisibility() != 8) {
            ViewPager.LayoutParams var13 = (ViewPager.LayoutParams)var14.getLayoutParams();
            var4 = var1;
            var5 = var2;
            if (var13 != null) {
               var4 = var1;
               var5 = var2;
               if (var13.a) {
                  var4 = var13.b & 7;
                  int var7 = var13.b & 112;
                  int var9 = Integer.MIN_VALUE;
                  var5 = Integer.MIN_VALUE;
                  boolean var24;
                  if (var7 != 48 && var7 != 80) {
                     var24 = false;
                  } else {
                     var24 = true;
                  }

                  boolean var8;
                  if (var4 != 3 && var4 != 5) {
                     var8 = false;
                  } else {
                     var8 = true;
                  }

                  if (var24) {
                     var4 = 1073741824;
                  } else {
                     var4 = var9;
                     if (var8) {
                        var5 = 1073741824;
                        var4 = var9;
                     }
                  }

                  if (var13.width != -2) {
                     var9 = 1073741824;
                     if (var13.width != -1) {
                        var4 = var13.width;
                     } else {
                        var4 = var1;
                     }
                  } else {
                     var9 = var4;
                     var4 = var1;
                  }

                  int var26;
                  label66: {
                     if (var13.height != -2) {
                        var26 = 1073741824;
                        var5 = var26;
                        if (var13.height != -1) {
                           int var11 = var13.height;
                           var5 = var26;
                           var26 = var11;
                           break label66;
                        }
                     }

                     var26 = var2;
                  }

                  var14.measure(MeasureSpec.makeMeasureSpec(var4, var9), MeasureSpec.makeMeasureSpec(var26, var5));
                  if (var24) {
                     var5 = var2 - var14.getMeasuredHeight();
                     var4 = var1;
                  } else {
                     var4 = var1;
                     var5 = var2;
                     if (var8) {
                        var4 = var1 - var14.getMeasuredWidth();
                        var5 = var2;
                     }
                  }
               }
            }
         }

         var6++;
         var1 = var4;
         var2 = var5;
      }

      this.v = MeasureSpec.makeMeasureSpec(var1, 1073741824);
      this.w = MeasureSpec.makeMeasureSpec(var2, 1073741824);
      this.x = true;
      this.c();
      this.x = false;
      int var22 = this.getChildCount();

      for (int var18 = 0; var18 < var22; var18++) {
         View var27 = this.getChildAt(var18);
         if (var27.getVisibility() != 8) {
            ViewPager.LayoutParams var28 = (ViewPager.LayoutParams)var27.getLayoutParams();
            if (var28 == null || !var28.a) {
               float var3 = var1;
               var27.measure(MeasureSpec.makeMeasureSpec((int)(var28.c * var3), 1073741824), this.w);
            }
         }
      }
   }

   protected boolean onRequestFocusInDescendants(int var1, Rect var2) {
      boolean var6 = true;
      byte var4 = -1;
      int var5 = this.getChildCount();
      int var3;
      if ((var1 & 2) != 0) {
         var4 = 1;
         var3 = 0;
      } else {
         var3 = var5 - 1;
         var5 = -1;
      }

      while (true) {
         if (var3 == var5) {
            var6 = false;
            break;
         }

         View var7 = this.getChildAt(var3);
         if (var7.getVisibility() == 0) {
            ViewPager.ItemInfo var8 = this.a(var7);
            if (var8 != null && var8.b == this.c && var7.requestFocus(var1, var2)) {
               break;
            }
         }

         var3 += var4;
      }

      return var6;
   }

   public void onRestoreInstanceState(Parcelable var1) {
      if (!(var1 instanceof ViewPager.SavedState)) {
         super.onRestoreInstanceState(var1);
      } else {
         var1 = var1;
         super.onRestoreInstanceState(var1.a());
         if (this.b != null) {
            this.b.a(var1.b, var1.c);
            this.a(var1.a, false, true);
         } else {
            this.j = var1.a;
            this.k = var1.b;
            this.l = var1.c;
         }
      }
   }

   public Parcelable onSaveInstanceState() {
      ViewPager.SavedState var1 = new ViewPager.SavedState(super.onSaveInstanceState());
      var1.a = this.c;
      if (this.b != null) {
         var1.b = this.b.a();
      }

      return var1;
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      if (var1 != var3) {
         this.a(var1, var3, this.p, this.p);
      }
   }

   public boolean onTouchEvent(MotionEvent var1) {
      boolean var10 = false;
      boolean var9;
      if (this.Q) {
         var9 = true;
      } else if (var1.getAction() == 0 && var1.getEdgeFlags() != 0) {
         var9 = false;
      } else if (this.b != null && this.b.b() != 0) {
         if (this.L == null) {
            this.L = VelocityTracker.obtain();
         }

         this.L.addMovement(var1);
         var9 = var10;
         switch (var1.getAction() & 0xFF) {
            case 0:
               this.m.abortAnimation();
               this.z = false;
               this.c();
               float var14 = var1.getX();
               this.I = var14;
               this.G = var14;
               var14 = var1.getY();
               this.J = var14;
               this.H = var14;
               this.K = var1.getPointerId(0);
               var9 = var10;
               break;
            case 1:
               var9 = var10;
               if (this.B) {
                  VelocityTracker var19 = this.L;
                  var19.computeCurrentVelocity(1000, this.N);
                  int var8 = (int)var19.getXVelocity(this.K);
                  this.z = true;
                  int var17 = this.getClientWidth();
                  int var7 = this.getScrollX();
                  ViewPager.ItemInfo var20 = this.i();
                  float var13 = (float)this.p / var17;
                  this.a(
                     this.a(var20.b, ((float)var7 / var17 - var20.e) / (var20.d + var13), var8, (int)(var1.getX(var1.findPointerIndex(this.K)) - this.I)),
                     true,
                     true,
                     var8
                  );
                  var9 = this.h();
               }
               break;
            case 2:
               if (!this.B) {
                  int var16 = var1.findPointerIndex(this.K);
                  if (var16 == -1) {
                     var9 = this.h();
                     break;
                  }

                  float var2 = var1.getX(var16);
                  float var5 = Math.abs(var2 - this.G);
                  float var3 = var1.getY(var16);
                  float var4 = Math.abs(var3 - this.H);
                  if (var5 > this.F && var5 > var4) {
                     this.B = true;
                     this.c(true);
                     if (var2 - this.I > 0.0F) {
                        var2 = this.I + this.F;
                     } else {
                        var2 = this.I - this.F;
                     }

                     this.G = var2;
                     this.H = var3;
                     this.setScrollState(1);
                     this.setScrollingCacheEnabled(true);
                     ViewParent var11 = this.getParent();
                     if (var11 != null) {
                        var11.requestDisallowInterceptTouchEvent(true);
                     }
                  }
               }

               var9 = var10;
               if (this.B) {
                  var9 = false | this.b(var1.getX(var1.findPointerIndex(this.K)));
               }
               break;
            case 3:
               var9 = var10;
               if (this.B) {
                  this.a(this.c, true, 0, false);
                  var9 = this.h();
               }
            case 4:
               break;
            case 5:
               int var6 = var1.getActionIndex();
               this.G = var1.getX(var6);
               this.K = var1.getPointerId(var6);
               var9 = var10;
               break;
            case 6:
               this.a(var1);
               this.G = var1.getX(var1.findPointerIndex(this.K));
               var9 = var10;
               break;
            default:
               var9 = var10;
         }

         if (var9) {
            ViewCompat.c(this);
         }

         var9 = true;
      } else {
         var9 = false;
      }

      return var9;
   }

   public void removeView(View var1) {
      if (this.x) {
         this.removeViewInLayout(var1);
      } else {
         super.removeView(var1);
      }
   }

   public void setAdapter(PagerAdapter var1) {
      byte var3 = 0;
      if (this.b != null) {
         this.b.c(null);
         this.b.a(this);

         for (int var2 = 0; var2 < this.g.size(); var2++) {
            ViewPager.ItemInfo var6 = this.g.get(var2);
            this.b.a(this, var6.b, var6.a);
         }

         this.b.b(this);
         this.g.clear();
         this.f();
         this.c = 0;
         this.scrollTo(0, 0);
      }

      PagerAdapter var8 = this.b;
      this.b = var1;
      this.d = 0;
      if (this.b != null) {
         if (this.o == null) {
            this.o = new ViewPager.PagerObserver(this);
         }

         this.b.c(this.o);
         this.z = false;
         boolean var5 = this.T;
         this.T = true;
         this.d = this.b.b();
         if (this.j >= 0) {
            this.b.a(this.k, this.l);
            this.a(this.j, false, true);
            this.j = -1;
            this.k = null;
            this.l = null;
         } else if (!var5) {
            this.c();
         } else {
            this.requestLayout();
         }
      }

      if (this.ad != null && !this.ad.isEmpty()) {
         int var4 = this.ad.size();

         for (int var7 = var3; var7 < var4; var7++) {
            this.ad.get(var7).a(this, var8, var1);
         }
      }
   }

   public void setCurrentItem(int var1) {
      this.z = false;
      boolean var2;
      if (!this.T) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.a(var1, var2, false);
   }

   public void setOffscreenPageLimit(int var1) {
      int var2 = var1;
      if (var1 < 1) {
         Log.w("ViewPager", "Requested offscreen page limit " + var1 + " too small; defaulting to " + 1);
         var2 = 1;
      }

      if (var2 != this.A) {
         this.A = var2;
         this.c();
      }
   }

   @Deprecated
   public void setOnPageChangeListener(ViewPager.OnPageChangeListener var1) {
      this.ab = var1;
   }

   public void setPageMargin(int var1) {
      int var3 = this.p;
      this.p = var1;
      int var2 = this.getWidth();
      this.a(var2, var2, var1, var3);
      this.requestLayout();
   }

   public void setPageMarginDrawable(int var1) {
      this.setPageMarginDrawable(ContextCompat.a(this.getContext(), var1));
   }

   public void setPageMarginDrawable(Drawable var1) {
      this.q = var1;
      if (var1 != null) {
         this.refreshDrawableState();
      }

      boolean var2;
      if (var1 == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.setWillNotDraw(var2);
      this.invalidate();
   }

   void setScrollState(int var1) {
      if (this.ak != var1) {
         this.ak = var1;
         if (this.ae != null) {
            boolean var2;
            if (var1 != 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            this.b(var2);
         }

         this.f(var1);
      }
   }

   protected boolean verifyDrawable(Drawable var1) {
      boolean var2;
      if (!super.verifyDrawable(var1) && var1 != this.q) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   @Inherited
   @Retention(RetentionPolicy.RUNTIME)
   @Target(ElementType.TYPE)
   public @interface DecorView {
   }

   static class ItemInfo {
      Object a;
      int b;
      boolean c;
      float d;
      float e;
   }

   public static class LayoutParams extends android.view.ViewGroup.LayoutParams {
      public boolean a;
      public int b;
      float c = 0.0F;
      boolean d;
      int e;
      int f;

      public LayoutParams() {
         super(-1, -1);
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, ViewPager.a);
         this.b = var3.getInteger(0, 48);
         var3.recycle();
      }
   }

   class MyAccessibilityDelegate extends AccessibilityDelegateCompat {
      final ViewPager a;

      MyAccessibilityDelegate(ViewPager var1) {
         this.a = var1;
      }

      private boolean b() {
         boolean var1 = true;
         if (this.a.b == null || this.a.b.b() <= 1) {
            var1 = false;
         }

         return var1;
      }

      @Override
      public void a(View var1, AccessibilityNodeInfoCompat var2) {
         super.a(var1, var2);
         var2.b(ViewPager.class.getName());
         var2.k(this.b());
         if (this.a.canScrollHorizontally(1)) {
            var2.a(4096);
         }

         if (this.a.canScrollHorizontally(-1)) {
            var2.a(8192);
         }
      }

      @Override
      public void a(View var1, AccessibilityEvent var2) {
         super.a(var1, var2);
         var2.setClassName(ViewPager.class.getName());
         var2.setScrollable(this.b());
         if (var2.getEventType() == 4096 && this.a.b != null) {
            var2.setItemCount(this.a.b.b());
            var2.setFromIndex(this.a.c);
            var2.setToIndex(this.a.c);
         }
      }

      @Override
      public boolean a(View var1, int var2, Bundle var3) {
         boolean var4 = true;
         if (!super.a(var1, var2, var3)) {
            switch (var2) {
               case 4096:
                  if (this.a.canScrollHorizontally(1)) {
                     this.a.setCurrentItem(this.a.c + 1);
                  } else {
                     var4 = false;
                  }
                  break;
               case 8192:
                  if (this.a.canScrollHorizontally(-1)) {
                     this.a.setCurrentItem(this.a.c - 1);
                  } else {
                     var4 = false;
                  }
                  break;
               default:
                  var4 = false;
            }
         }

         return var4;
      }
   }

   public interface OnAdapterChangeListener {
      void a(ViewPager var1, PagerAdapter var2, PagerAdapter var3);
   }

   public interface OnPageChangeListener {
      void a(int var1);

      void a(int var1, float var2, int var3);

      void b(int var1);
   }

   public interface PageTransformer {
      void a(View var1, float var2);
   }

   private class PagerObserver extends DataSetObserver {
      final ViewPager a;

      PagerObserver(ViewPager var1) {
         this.a = var1;
      }

      public void onChanged() {
         this.a.b();
      }

      public void onInvalidated() {
         this.a.b();
      }
   }

   public static class SavedState extends AbsSavedState {
      public static final Creator<ViewPager.SavedState> CREATOR = new ClassLoaderCreator<ViewPager.SavedState>() {
         public ViewPager.SavedState a(Parcel var1) {
            return new ViewPager.SavedState(var1, null);
         }

         public ViewPager.SavedState a(Parcel var1, ClassLoader var2) {
            return new ViewPager.SavedState(var1, var2);
         }

         public ViewPager.SavedState[] a(int var1) {
            return new ViewPager.SavedState[var1];
         }
      };
      int a;
      Parcelable b;
      ClassLoader c;

      SavedState(Parcel var1, ClassLoader var2) {
         super(var1, var2);
         ClassLoader var3 = var2;
         if (var2 == null) {
            var3 = this.getClass().getClassLoader();
         }

         this.a = var1.readInt();
         this.b = var1.readParcelable(var3);
         this.c = var3;
      }

      public SavedState(Parcelable var1) {
         super(var1);
      }

      @Override
      public String toString() {
         return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.a + "}";
      }

      @Override
      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeInt(this.a);
         var1.writeParcelable(this.b, var2);
      }
   }

   static class ViewPositionComparator implements Comparator<View> {
      public int a(View var1, View var2) {
         ViewPager.LayoutParams var4 = (ViewPager.LayoutParams)var1.getLayoutParams();
         ViewPager.LayoutParams var5 = (ViewPager.LayoutParams)var2.getLayoutParams();
         int var3;
         if (var4.a != var5.a) {
            if (var4.a) {
               var3 = 1;
            } else {
               var3 = -1;
            }
         } else {
            var3 = var4.e - var5.e;
         }

         return var3;
      }
   }
}
