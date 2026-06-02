package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
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
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoordinatorLayout extends ViewGroup implements NestedScrollingParent2 {
   static final String a;
   static final Class<?>[] b;
   static final ThreadLocal<Map<String, Constructor<CoordinatorLayout.Behavior>>> c;
   static final Comparator<View> d;
   private static final Pools.Pool<Rect> f;
   OnHierarchyChangeListener e;
   private final List<View> g;
   private final DirectedAcyclicGraph<View> h;
   private final List<View> i;
   private final List<View> j;
   private final int[] k;
   private Paint l;
   private boolean m;
   private boolean n;
   private int[] o;
   private View p;
   private View q;
   private CoordinatorLayout.OnPreDrawListener r;
   private boolean s;
   private WindowInsetsCompat t;
   private boolean u;
   private Drawable v;
   private OnApplyWindowInsetsListener w;
   private final NestedScrollingParentHelper x;

   static {
      Package var0 = CoordinatorLayout.class.getPackage();
      String var1;
      if (var0 != null) {
         var1 = var0.getName();
      } else {
         var1 = null;
      }

      a = var1;
      if (VERSION.SDK_INT >= 21) {
         d = new CoordinatorLayout.ViewElevationComparator();
      } else {
         d = null;
      }

      b = new Class[]{Context.class, AttributeSet.class};
      c = new ThreadLocal<>();
      f = new Pools.SynchronizedPool<>(12);
   }

   public CoordinatorLayout(Context var1) {
      this(var1, null);
   }

   public CoordinatorLayout(Context var1, AttributeSet var2) {
      this(var1, var2, R.attr.coordinatorLayoutStyle);
   }

   public CoordinatorLayout(Context var1, AttributeSet var2, int var3) {
      byte var5 = 0;
      super(var1, var2, var3);
      this.g = new ArrayList<>();
      this.h = new DirectedAcyclicGraph<>();
      this.i = new ArrayList<>();
      this.j = new ArrayList<>();
      this.k = new int[2];
      this.x = new NestedScrollingParentHelper(this);
      TypedArray var8;
      if (var3 == 0) {
         var8 = var1.obtainStyledAttributes(var2, R.styleable.CoordinatorLayout, 0, R.style.Widget_Support_CoordinatorLayout);
      } else {
         var8 = var1.obtainStyledAttributes(var2, R.styleable.CoordinatorLayout, var3, 0);
      }

      var3 = var8.getResourceId(R.styleable.CoordinatorLayout_keylines, 0);
      if (var3 != 0) {
         Resources var7 = var1.getResources();
         this.o = var7.getIntArray(var3);
         float var4 = var7.getDisplayMetrics().density;
         int var6 = this.o.length;

         for (int var10 = var5; var10 < var6; var10++) {
            this.o[var10] = (int)(this.o[var10] * var4);
         }
      }

      this.v = var8.getDrawable(R.styleable.CoordinatorLayout_statusBarBackground);
      var8.recycle();
      this.g();
      super.setOnHierarchyChangeListener(new CoordinatorLayout.HierarchyChangeListener(this));
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   static CoordinatorLayout.Behavior a(Context var0, AttributeSet var1, String var2) {
      CoordinatorLayout.Behavior var11;
      if (TextUtils.isEmpty(var2)) {
         var11 = null;
      } else {
         String var3;
         if (var2.startsWith(".")) {
            var3 = var0.getPackageName() + var2;
         } else {
            var3 = var2;
            if (var2.indexOf(46) < 0) {
               var3 = var2;
               if (!TextUtils.isEmpty(a)) {
                  var3 = a + '.' + var2;
               }
            }
         }

         try {
            var12 = c.get();
         } catch (Exception var10) {
            throw new RuntimeException("Could not inflate Behavior subclass " + var3, var10);
         }

         if (var12 == null) {
            try {
               var12 = new HashMap();
               c.set(var12);
            } catch (Exception var9) {
               throw new RuntimeException("Could not inflate Behavior subclass " + var3, var9);
            }
         }

         Constructor var5;
         try {
            var5 = (Constructor)var12.get(var3);
         } catch (Exception var8) {
            throw new RuntimeException("Could not inflate Behavior subclass " + var3, var8);
         }

         Constructor var4 = var5;
         if (var5 == null) {
            try {
               var4 = var0.getClassLoader().loadClass(var3).getConstructor(b);
               var4.setAccessible(true);
               var12.put(var3, var4);
            } catch (Exception var7) {
               throw new RuntimeException("Could not inflate Behavior subclass " + var3, var7);
            }
         }

         try {
            var11 = (CoordinatorLayout.Behavior)var4.newInstance(var0, var1);
         } catch (Exception var6) {
            throw new RuntimeException("Could not inflate Behavior subclass " + var3, var6);
         }
      }

      return var11;
   }

   private static void a(Rect var0) {
      var0.setEmpty();
      f.a(var0);
   }

   private void a(CoordinatorLayout.LayoutParams var1, Rect var2, int var3, int var4) {
      int var5 = this.getWidth();
      int var6 = this.getHeight();
      var5 = Math.max(this.getPaddingLeft() + var1.leftMargin, Math.min(var2.left, var5 - this.getPaddingRight() - var3 - var1.rightMargin));
      var6 = Math.max(this.getPaddingTop() + var1.topMargin, Math.min(var2.top, var6 - this.getPaddingBottom() - var4 - var1.bottomMargin));
      var2.set(var5, var6, var5 + var3, var6 + var4);
   }

   private void a(View var1, int var2, Rect var3, Rect var4, CoordinatorLayout.LayoutParams var5, int var6, int var7) {
      int var10 = GravityCompat.a(e(var5.c), var2);
      int var8 = GravityCompat.a(c(var5.d), var2);
      switch (var8 & 7) {
         case 1:
            var2 = var3.left;
            var2 = var3.width() / 2 + var2;
            break;
         case 5:
            var2 = var3.right;
            break;
         default:
            var2 = var3.left;
      }

      switch (var8 & 112) {
         case 16:
            var8 = var3.top + var3.height() / 2;
            break;
         case 80:
            var8 = var3.bottom;
            break;
         default:
            var8 = var3.top;
      }

      int var9 = var2;
      switch (var10 & 7) {
         case 1:
            var9 = var2 - var6 / 2;
         case 5:
            break;
         default:
            var9 = var2 - var6;
      }

      var2 = var8;
      switch (var10 & 112) {
         case 16:
            var2 = var8 - var7 / 2;
         case 80:
            break;
         default:
            var2 = var8 - var7;
      }

      var4.set(var9, var2, var9 + var6, var2 + var7);
   }

   private void a(View var1, Rect var2, int var3) {
      if (ViewCompat.y(var1) && var1.getWidth() > 0 && var1.getHeight() > 0) {
         CoordinatorLayout.LayoutParams var8 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
         CoordinatorLayout.Behavior var7 = var8.b();
         Rect var9 = e();
         Rect var10 = e();
         var10.set(var1.getLeft(), var1.getTop(), var1.getRight(), var1.getBottom());
         if (var7 != null && var7.a(this, var1, var9)) {
            if (!var10.contains(var9)) {
               throw new IllegalArgumentException(
                  "Rect should be within the child's bounds. Rect:" + var9.toShortString() + " | Bounds:" + var10.toShortString()
               );
            }
         } else {
            var9.set(var10);
         }

         a(var10);
         if (var9.isEmpty()) {
            a(var9);
         } else {
            int var5;
            label54: {
               var5 = GravityCompat.a(var8.h, var3);
               if ((var5 & 48) == 48) {
                  var3 = var9.top - var8.topMargin - var8.j;
                  if (var3 < var2.top) {
                     this.f(var1, var2.top - var3);
                     var12 = true;
                     break label54;
                  }
               }

               var12 = false;
            }

            int var4 = var12;
            if ((var5 & 80) == 80) {
               int var6 = this.getHeight() - var9.bottom - var8.bottomMargin + var8.j;
               var4 = var12;
               if (var6 < var2.bottom) {
                  this.f(var1, var6 - var2.bottom);
                  var4 = 1;
               }
            }

            if (!var4) {
               this.f(var1, 0);
            }

            label46: {
               if ((var5 & 3) == 3) {
                  var3 = var9.left - var8.leftMargin - var8.i;
                  if (var3 < var2.left) {
                     this.e(var1, var2.left - var3);
                     var14 = true;
                     break label46;
                  }
               }

               var14 = false;
            }

            if ((var5 & 5) == 5) {
               var5 = this.getWidth();
               var4 = var9.right;
               int var18 = var8.rightMargin;
               var4 = var8.i + (var5 - var4 - var18);
               if (var4 < var2.right) {
                  this.e(var1, var4 - var2.right);
                  var14 = true;
               }
            }

            if (!var14) {
               this.e(var1, 0);
            }

            a(var9);
         }
      }
   }

   private void a(View var1, View var2, int var3) {
      CoordinatorLayout.LayoutParams var4 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      Rect var5 = e();
      Rect var8 = e();

      try {
         this.a(var2, var5);
         this.a(var1, var3, var5, var8);
         var1.layout(var8.left, var8.top, var8.right, var8.bottom);
      } finally {
         a(var5);
         a(var8);
      }
   }

   private void a(List<View> var1) {
      var1.clear();
      boolean var5 = this.isChildrenDrawingOrderEnabled();
      int var4 = this.getChildCount();

      for (int var2 = var4 - 1; var2 >= 0; var2--) {
         int var3;
         if (var5) {
            var3 = this.getChildDrawingOrder(var4, var2);
         } else {
            var3 = var2;
         }

         var1.add(this.getChildAt(var3));
      }

      if (d != null) {
         Collections.sort(var1, d);
      }
   }

   private void a(boolean var1) {
      int var3 = this.getChildCount();

      for (int var2 = 0; var2 < var3; var2++) {
         View var6 = this.getChildAt(var2);
         CoordinatorLayout.Behavior var7 = ((CoordinatorLayout.LayoutParams)var6.getLayoutParams()).b();
         if (var7 != null) {
            long var4 = SystemClock.uptimeMillis();
            MotionEvent var8 = MotionEvent.obtain(var4, var4, 3, 0.0F, 0.0F, 0);
            if (var1) {
               var7.a(this, var6, var8);
            } else {
               var7.b(this, var6, var8);
            }

            var8.recycle();
         }
      }

      for (int var9 = 0; var9 < var3; var9++) {
         ((CoordinatorLayout.LayoutParams)this.getChildAt(var9).getLayoutParams()).f();
      }

      this.p = null;
      this.m = false;
   }

   private boolean a(MotionEvent var1, int var2) {
      boolean var7 = false;
      boolean var3 = false;
      MotionEvent var12 = null;
      int var5 = var1.getActionMasked();
      List var13 = this.i;
      this.a(var13);
      int var6 = var13.size();

      for (int var4 = 0; var4 < var6; var4++) {
         View var14 = (View)var13.get(var4);
         CoordinatorLayout.LayoutParams var16 = (CoordinatorLayout.LayoutParams)var14.getLayoutParams();
         CoordinatorLayout.Behavior var15 = var16.b();
         if ((var7 || var3) && var5 != 0) {
            if (var15 != null) {
               if (var12 == null) {
                  long var10 = SystemClock.uptimeMillis();
                  var12 = MotionEvent.obtain(var10, var10, 3, 0.0F, 0.0F, 0);
               }

               switch (var2) {
                  case 0:
                     var15.a(this, var14, var12);
                     break;
                  case 1:
                     var15.b(this, var14, var12);
               }
            }
         } else {
            boolean var8 = var7;
            if (!var7) {
               var8 = var7;
               if (var15 != null) {
                  switch (var2) {
                     case 0:
                        var7 = var15.a(this, var14, var1);
                        break;
                     case 1:
                        var7 = var15.b(this, var14, var1);
                  }

                  var8 = var7;
                  if (var7) {
                     this.p = var14;
                     var8 = var7;
                  }
               }
            }

            var7 = var8;
            var8 = var16.e();
            boolean var9 = var16.a(this, var14);
            if (var9 && !var8) {
               var3 = true;
            } else {
               var3 = false;
            }

            if (var9 && !var3) {
               break;
            }
         }
      }

      var13.clear();
      return var7;
   }

   private int b(int var1) {
      byte var2 = 0;
      if (this.o == null) {
         Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + var1);
         var1 = var2;
      } else if (var1 >= 0 && var1 < this.o.length) {
         var1 = this.o[var1];
      } else {
         Log.e("CoordinatorLayout", "Keyline index " + var1 + " out of range for " + this);
         var1 = var2;
      }

      return var1;
   }

   private WindowInsetsCompat b(WindowInsetsCompat var1) {
      if (!var1.f()) {
         int var3 = this.getChildCount();

         for (int var2 = 0; var2 < var3; var2++) {
            View var4 = this.getChildAt(var2);
            if (ViewCompat.r(var4)) {
               CoordinatorLayout.Behavior var5 = ((CoordinatorLayout.LayoutParams)var4.getLayoutParams()).b();
               if (var5 != null) {
                  WindowInsetsCompat var6 = var5.a(this, var4, var1);
                  var1 = var6;
                  if (var6.f()) {
                     var1 = var6;
                     break;
                  }
               }
            }
         }
      }

      return var1;
   }

   private void b(View var1, int var2, int var3) {
      CoordinatorLayout.LayoutParams var10 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      int var9 = GravityCompat.a(d(var10.c), var3);
      int var8 = this.getWidth();
      int var7 = this.getHeight();
      int var5 = var1.getMeasuredWidth();
      int var6 = var1.getMeasuredHeight();
      int var4 = var2;
      if (var3 == 1) {
         var4 = var8 - var2;
      }

      var2 = this.b(var4) - var5;
      var3 = 0;
      switch (var9 & 7) {
         case 1:
            var2 += var5 / 2;
            break;
         case 5:
            var2 += var5;
      }

      switch (var9 & 112) {
         case 16:
            var3 = 0 + var6 / 2;
            break;
         case 80:
            var3 = 0 + var6;
      }

      var2 = Math.max(this.getPaddingLeft() + var10.leftMargin, Math.min(var2, var8 - this.getPaddingRight() - var5 - var10.rightMargin));
      var3 = Math.max(this.getPaddingTop() + var10.topMargin, Math.min(var3, var7 - this.getPaddingBottom() - var6 - var10.bottomMargin));
      var1.layout(var2, var3, var2 + var5, var3 + var6);
   }

   private static int c(int var0) {
      if ((var0 & 7) == 0) {
         var0 |= 8388611;
      }

      int var1 = var0;
      if ((var0 & 112) == 0) {
         var1 = var0 | 48;
      }

      return var1;
   }

   private static int d(int var0) {
      int var1 = var0;
      if (var0 == 0) {
         var1 = 8388661;
      }

      return var1;
   }

   private void d(View var1, int var2) {
      CoordinatorLayout.LayoutParams var5 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      Rect var3 = e();
      var3.set(
         this.getPaddingLeft() + var5.leftMargin,
         this.getPaddingTop() + var5.topMargin,
         this.getWidth() - this.getPaddingRight() - var5.rightMargin,
         this.getHeight() - this.getPaddingBottom() - var5.bottomMargin
      );
      if (this.t != null && ViewCompat.r(this) && !ViewCompat.r(var1)) {
         var3.left = var3.left + this.t.a();
         var3.top = var3.top + this.t.b();
         var3.right = var3.right - this.t.c();
         var3.bottom = var3.bottom - this.t.d();
      }

      Rect var4 = e();
      GravityCompat.a(c(var5.c), var1.getMeasuredWidth(), var1.getMeasuredHeight(), var3, var4, var2);
      var1.layout(var4.left, var4.top, var4.right, var4.bottom);
      a(var3);
      a(var4);
   }

   private static int e(int var0) {
      int var1 = var0;
      if (var0 == 0) {
         var1 = 17;
      }

      return var1;
   }

   private static Rect e() {
      Rect var1 = f.a();
      Rect var0 = var1;
      if (var1 == null) {
         var0 = new Rect();
      }

      return var0;
   }

   private void e(View var1, int var2) {
      CoordinatorLayout.LayoutParams var3 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      if (var3.i != var2) {
         ViewCompat.d(var1, var2 - var3.i);
         var3.i = var2;
      }
   }

   private boolean e(View var1) {
      return this.h.e(var1);
   }

   private void f() {
      this.g.clear();
      this.h.a();
      int var3 = this.getChildCount();

      for (int var1 = 0; var1 < var3; var1++) {
         View var6 = this.getChildAt(var1);
         CoordinatorLayout.LayoutParams var4 = this.a(var6);
         var4.b(this, var6);
         this.h.a(var6);

         for (int var2 = 0; var2 < var3; var2++) {
            if (var2 != var1) {
               View var5 = this.getChildAt(var2);
               if (var4.a(this, var6, var5)) {
                  if (!this.h.b(var5)) {
                     this.h.a(var5);
                  }

                  this.h.a(var5, var6);
               }
            }
         }
      }

      this.g.addAll(this.h.b());
      Collections.reverse(this.g);
   }

   private void f(View var1, int var2) {
      CoordinatorLayout.LayoutParams var3 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      if (var3.j != var2) {
         ViewCompat.c(var1, var2 - var3.j);
         var3.j = var2;
      }
   }

   private void g() {
      if (VERSION.SDK_INT >= 21) {
         if (ViewCompat.r(this)) {
            if (this.w == null) {
               this.w = new OnApplyWindowInsetsListener(this) {
                  final CoordinatorLayout a;

                  {
                     this.a = var1;
                  }

                  @Override
                  public WindowInsetsCompat a(View var1, WindowInsetsCompat var2) {
                     return this.a.a(var2);
                  }
               };
            }

            ViewCompat.a(this, this.w);
            this.setSystemUiVisibility(1280);
         } else {
            ViewCompat.a(this, null);
         }
      }
   }

   public CoordinatorLayout.LayoutParams a(AttributeSet var1) {
      return new CoordinatorLayout.LayoutParams(this.getContext(), var1);
   }

   CoordinatorLayout.LayoutParams a(View var1) {
      CoordinatorLayout.LayoutParams var4 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      if (!var4.b) {
         if (var1 instanceof CoordinatorLayout.AttachedBehavior) {
            CoordinatorLayout.Behavior var6 = ((CoordinatorLayout.AttachedBehavior)var1).a();
            if (var6 == null) {
               Log.e("CoordinatorLayout", "Attached behavior class is null");
            }

            var4.a(var6);
            var4.b = true;
         } else {
            Class var2 = var1.getClass();
            CoordinatorLayout.DefaultBehavior var7 = null;

            while (var2 != null) {
               CoordinatorLayout.DefaultBehavior var3 = var2.getAnnotation(CoordinatorLayout.DefaultBehavior.class);
               var7 = var3;
               if (var3 != null) {
                  break;
               }

               var2 = var2.getSuperclass();
               var7 = var3;
            }

            if (var7 != null) {
               try {
                  var4.a(var7.a().getDeclaredConstructor().newInstance());
               } catch (Exception var5) {
                  Log.e(
                     "CoordinatorLayout",
                     "Default behavior class " + var7.a().getName() + " could not be instantiated. Did you forget" + " a default constructor?",
                     var5
                  );
               }
            }

            var4.b = true;
         }
      }

      return var4;
   }

   protected CoordinatorLayout.LayoutParams a(android.view.ViewGroup.LayoutParams var1) {
      CoordinatorLayout.LayoutParams var2;
      if (var1 instanceof CoordinatorLayout.LayoutParams) {
         var2 = new CoordinatorLayout.LayoutParams((CoordinatorLayout.LayoutParams)var1);
      } else if (var1 instanceof MarginLayoutParams) {
         var2 = new CoordinatorLayout.LayoutParams((MarginLayoutParams)var1);
      } else {
         var2 = new CoordinatorLayout.LayoutParams(var1);
      }

      return var2;
   }

   final WindowInsetsCompat a(WindowInsetsCompat var1) {
      boolean var3 = true;
      WindowInsetsCompat var4 = var1;
      if (!ObjectsCompat.a(this.t, var1)) {
         this.t = var1;
         boolean var2;
         if (var1 != null && var1.b() > 0) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.u = var2;
         if (!this.u && this.getBackground() == null) {
            var2 = var3;
         } else {
            var2 = false;
         }

         this.setWillNotDraw(var2);
         var4 = this.b(var1);
         this.requestLayout();
      }

      return var4;
   }

   void a() {
      boolean var4 = false;
      int var2 = this.getChildCount();
      int var1 = 0;

      boolean var3;
      while (true) {
         var3 = var4;
         if (var1 >= var2) {
            break;
         }

         if (this.e(this.getChildAt(var1))) {
            var3 = true;
            break;
         }

         var1++;
      }

      if (var3 != this.s) {
         if (var3) {
            this.b();
         } else {
            this.o_();
         }
      }
   }

   final void a(int var1) {
      int var4 = ViewCompat.e(this);
      int var5 = this.g.size();
      Rect var10 = e();
      Rect var7 = e();
      Rect var9 = e();

      for (int var2 = 0; var2 < var5; var2++) {
         View var8 = this.g.get(var2);
         CoordinatorLayout.LayoutParams var11 = (CoordinatorLayout.LayoutParams)var8.getLayoutParams();
         if (var1 != 0 || var8.getVisibility() != 8) {
            for (int var3 = 0; var3 < var2; var3++) {
               View var12 = this.g.get(var3);
               if (var11.l == var12) {
                  this.b(var8, var4);
               }
            }

            this.a(var8, true, var7);
            if (var11.g != 0 && !var7.isEmpty()) {
               int var14 = GravityCompat.a(var11.g, var4);
               switch (var14 & 112) {
                  case 48:
                     var10.top = Math.max(var10.top, var7.bottom);
                     break;
                  case 80:
                     var10.bottom = Math.max(var10.bottom, this.getHeight() - var7.top);
               }

               switch (var14 & 7) {
                  case 3:
                     var10.left = Math.max(var10.left, var7.right);
                  case 4:
                  default:
                     break;
                  case 5:
                     var10.right = Math.max(var10.right, this.getWidth() - var7.left);
               }
            }

            if (var11.h != 0 && var8.getVisibility() == 0) {
               this.a(var8, var10, var4);
            }

            if (var1 != 2) {
               this.c(var8, var9);
               if (var9.equals(var7)) {
                  continue;
               }

               this.b(var8, var7);
            }

            for (int var15 = var2 + 1; var15 < var5; var15++) {
               View var13 = this.g.get(var15);
               var11 = (CoordinatorLayout.LayoutParams)var13.getLayoutParams();
               CoordinatorLayout.Behavior var17 = var11.b();
               if (var17 != null && var17.a(this, var13, var8)) {
                  if (var1 == 0 && var11.g()) {
                     var11.h();
                  } else {
                     boolean var6;
                     switch (var1) {
                        case 2:
                           var17.d(this, var13, var8);
                           var6 = true;
                           break;
                        default:
                           var6 = var17.b(this, var13, var8);
                     }

                     if (var1 == 1) {
                        var11.a(var6);
                     }
                  }
               }
            }
         }
      }

      a(var10);
      a(var7);
      a(var9);
   }

   public void a(View var1, int var2) {
      CoordinatorLayout.LayoutParams var3 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      if (var3.d()) {
         throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
      }

      if (var3.k != null) {
         this.a(var1, var3.k, var2);
      } else if (var3.e >= 0) {
         this.b(var1, var3.e, var2);
      } else {
         this.d(var1, var2);
      }
   }

   public void a(View var1, int var2, int var3, int var4, int var5) {
      this.measureChildWithMargins(var1, var2, var3, var4, var5);
   }

   @Override
   public void a(View var1, int var2, int var3, int var4, int var5, int var6) {
      int var9 = this.getChildCount();
      boolean var7 = false;

      for (int var8 = 0; var8 < var9; var8++) {
         View var10 = this.getChildAt(var8);
         if (var10.getVisibility() != 8) {
            CoordinatorLayout.LayoutParams var11 = (CoordinatorLayout.LayoutParams)var10.getLayoutParams();
            if (var11.b(var6)) {
               CoordinatorLayout.Behavior var12 = var11.b();
               if (var12 != null) {
                  var12.a(this, var10, var1, var2, var3, var4, var5, var6);
                  var7 = true;
               }
            }
         }
      }

      if (var7) {
         this.a(1);
      }
   }

   @Override
   public void a(View var1, int var2, int var3, int[] var4, int var5) {
      int var7 = 0;
      int var6 = 0;
      int var8 = 0;
      int var11 = this.getChildCount();
      int var9 = 0;

      while (var9 < var11) {
         View var12 = this.getChildAt(var9);
         boolean var15;
         if (var12.getVisibility() == 8) {
            boolean var10 = (boolean)var8;
            var8 = var7;
            var7 = var6;
            var15 = var10;
         } else {
            CoordinatorLayout.LayoutParams var13 = (CoordinatorLayout.LayoutParams)var12.getLayoutParams();
            if (!var13.b(var5)) {
               boolean var20 = (boolean)var8;
               var8 = var7;
               var7 = var6;
               var15 = var20;
            } else {
               CoordinatorLayout.Behavior var14 = var13.b();
               if (var14 != null) {
                  int[] var23 = this.k;
                  this.k[1] = 0;
                  var23[0] = 0;
                  var14.a(this, var12, var1, var2, var3, this.k, var5);
                  if (var2 > 0) {
                     var8 = Math.max(var7, this.k[0]);
                  } else {
                     var8 = Math.min(var7, this.k[0]);
                  }

                  if (var3 > 0) {
                     var15 = Math.max(var6, this.k[1]);
                  } else {
                     var15 = Math.min(var6, this.k[1]);
                  }

                  var7 = var15;
                  var15 = 1;
               } else {
                  boolean var21 = (boolean)var8;
                  var8 = var7;
                  var7 = var6;
                  var15 = var21;
               }
            }
         }

         int var22 = var9 + 1;
         var9 = var7;
         var7 = var8;
         var8 = var15;
         var6 = var9;
         var9 = var22;
      }

      var4[0] = var7;
      var4[1] = var6;
      if (var8) {
         this.a(1);
      }
   }

   void a(View var1, int var2, Rect var3, Rect var4) {
      CoordinatorLayout.LayoutParams var7 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      int var5 = var1.getMeasuredWidth();
      int var6 = var1.getMeasuredHeight();
      this.a(var1, var2, var3, var4, var7, var5, var6);
      this.a(var7, var4, var5, var6);
   }

   void a(View var1, Rect var2) {
      ViewGroupUtils.b(this, var1, var2);
   }

   void a(View var1, boolean var2, Rect var3) {
      if (var1.isLayoutRequested() || var1.getVisibility() == 8) {
         var3.setEmpty();
      } else if (var2) {
         this.a(var1, var3);
      } else {
         var3.set(var1.getLeft(), var1.getTop(), var1.getRight(), var1.getBottom());
      }
   }

   public boolean a(View var1, int var2, int var3) {
      Rect var5 = e();
      this.a(var1, var5);

      try {
         return var5.contains(var2, var3);
      } finally {
         a(var5);
      }
   }

   // $VF: Could not verify finally blocks. A semaphore variable has been added to preserve control flow.
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public boolean a(View var1, View var2) {
      boolean var6 = true;
      boolean var5;
      if (var1.getVisibility() == 0 && var2.getVisibility() == 0) {
         Rect var7 = e();
         if (var1.getParent() != this) {
            var5 = true;
         } else {
            var5 = false;
         }

         this.a(var1, var5, var7);
         Rect var11 = e();
         if (var2.getParent() != this) {
            var5 = true;
         } else {
            var5 = false;
         }

         this.a(var2, var5, var11);
         boolean var9 = false /* VF: Semaphore variable */;

         label72: {
            label71: {
               int var3;
               int var4;
               try {
                  var9 = true;
                  if (var7.left > var11.right) {
                     var9 = false;
                     break label71;
                  }

                  if (var7.top > var11.bottom) {
                     var9 = false;
                     break label71;
                  }

                  if (var7.right < var11.left) {
                     var9 = false;
                     break label71;
                  }

                  var3 = var7.bottom;
                  var4 = var11.top;
                  var9 = false;
               } finally {
                  if (var9) {
                     a(var7);
                     a(var11);
                  }
               }

               if (var3 >= var4) {
                  var5 = var6;
                  break label72;
               }
            }

            var5 = false;
         }

         a(var7);
         a(var11);
      } else {
         var5 = false;
      }

      return var5;
   }

   @Override
   public boolean a(View var1, View var2, int var3, int var4) {
      boolean var7 = false;
      int var6 = this.getChildCount();

      for (int var5 = 0; var5 < var6; var5++) {
         View var11 = this.getChildAt(var5);
         if (var11.getVisibility() != 8) {
            CoordinatorLayout.LayoutParams var9 = (CoordinatorLayout.LayoutParams)var11.getLayoutParams();
            CoordinatorLayout.Behavior var10 = var9.b();
            if (var10 != null) {
               boolean var8 = var10.a(this, var11, var1, var2, var3, var4);
               var7 |= var8;
               var9.a(var4, var8);
            } else {
               var9.a(var4, false);
            }
         }
      }

      return var7;
   }

   void b() {
      if (this.n) {
         if (this.r == null) {
            this.r = new CoordinatorLayout.OnPreDrawListener(this);
         }

         this.getViewTreeObserver().addOnPreDrawListener(this.r);
      }

      this.s = true;
   }

   public void b(View var1) {
      List var4 = this.h.c(var1);
      if (var4 != null && !var4.isEmpty()) {
         for (int var2 = 0; var2 < var4.size(); var2++) {
            View var5 = (View)var4.get(var2);
            CoordinatorLayout.Behavior var3 = ((CoordinatorLayout.LayoutParams)var5.getLayoutParams()).b();
            if (var3 != null) {
               var3.b(this, var5, var1);
            }
         }
      }
   }

   void b(View var1, int var2) {
      CoordinatorLayout.LayoutParams var5 = (CoordinatorLayout.LayoutParams)var1.getLayoutParams();
      if (var5.k != null) {
         Rect var6 = e();
         Rect var9 = e();
         Rect var8 = e();
         this.a(var5.k, var6);
         this.a(var1, false, var9);
         int var3 = var1.getMeasuredWidth();
         int var4 = var1.getMeasuredHeight();
         this.a(var1, var2, var6, var8, var5, var3, var4);
         boolean var10;
         if (var8.left == var9.left && var8.top == var9.top) {
            var10 = false;
         } else {
            var10 = true;
         }

         this.a(var5, var8, var3, var4);
         var3 = var8.left - var9.left;
         var4 = var8.top - var9.top;
         if (var3 != 0) {
            ViewCompat.d(var1, var3);
         }

         if (var4 != 0) {
            ViewCompat.c(var1, var4);
         }

         if (var10) {
            CoordinatorLayout.Behavior var7 = var5.b();
            if (var7 != null) {
               var7.b(this, var1, var5.k);
            }
         }

         a(var6);
         a(var9);
         a(var8);
      }
   }

   void b(View var1, Rect var2) {
      ((CoordinatorLayout.LayoutParams)var1.getLayoutParams()).a(var2);
   }

   @Override
   public void b(View var1, View var2, int var3, int var4) {
      this.x.a(var1, var2, var3, var4);
      this.q = var2;
      int var6 = this.getChildCount();

      for (int var5 = 0; var5 < var6; var5++) {
         View var7 = this.getChildAt(var5);
         CoordinatorLayout.LayoutParams var8 = (CoordinatorLayout.LayoutParams)var7.getLayoutParams();
         if (var8.b(var4)) {
            CoordinatorLayout.Behavior var9 = var8.b();
            if (var9 != null) {
               var9.b(this, var7, var1, var2, var3, var4);
            }
         }
      }
   }

   public List<View> c(View var1) {
      List var2 = this.h.d(var1);
      this.j.clear();
      if (var2 != null) {
         this.j.addAll(var2);
      }

      return this.j;
   }

   @Override
   public void c(View var1, int var2) {
      this.x.a(var1, var2);
      int var4 = this.getChildCount();

      for (int var3 = 0; var3 < var4; var3++) {
         View var6 = this.getChildAt(var3);
         CoordinatorLayout.LayoutParams var5 = (CoordinatorLayout.LayoutParams)var6.getLayoutParams();
         if (var5.b(var2)) {
            CoordinatorLayout.Behavior var7 = var5.b();
            if (var7 != null) {
               var7.a(this, var6, var1, var2);
            }

            var5.a(var2);
            var5.h();
         }
      }

      this.q = null;
   }

   void c(View var1, Rect var2) {
      var2.set(((CoordinatorLayout.LayoutParams)var1.getLayoutParams()).c());
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      boolean var2;
      if (var1 instanceof CoordinatorLayout.LayoutParams && super.checkLayoutParams(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   protected CoordinatorLayout.LayoutParams d() {
      return new CoordinatorLayout.LayoutParams(-2, -2);
   }

   public List<View> d(View var1) {
      List var2 = this.h.c(var1);
      this.j.clear();
      if (var2 != null) {
         this.j.addAll(var2);
      }

      return this.j;
   }

   protected boolean drawChild(Canvas var1, View var2, long var3) {
      CoordinatorLayout.LayoutParams var7 = (CoordinatorLayout.LayoutParams)var2.getLayoutParams();
      if (var7.a != null) {
         float var5 = var7.a.d(this, var2);
         if (var5 > 0.0F) {
            if (this.l == null) {
               this.l = new Paint();
            }

            this.l.setColor(var7.a.c(this, var2));
            this.l.setAlpha(MathUtils.a(Math.round(var5 * 255.0F), 0, 255));
            int var6 = var1.save();
            if (var2.isOpaque()) {
               var1.clipRect(var2.getLeft(), var2.getTop(), var2.getRight(), var2.getBottom(), Op.DIFFERENCE);
            }

            var1.drawRect(
               this.getPaddingLeft(), this.getPaddingTop(), this.getWidth() - this.getPaddingRight(), this.getHeight() - this.getPaddingBottom(), this.l
            );
            var1.restoreToCount(var6);
         }
      }

      return super.drawChild(var1, var2, var3);
   }

   protected void drawableStateChanged() {
      super.drawableStateChanged();
      int[] var3 = this.getDrawableState();
      boolean var2 = false;
      Drawable var4 = this.v;
      boolean var1 = var2;
      if (var4 != null) {
         var1 = var2;
         if (var4.isStateful()) {
            var1 = false | var4.setState(var3);
         }
      }

      if (var1) {
         this.invalidate();
      }
   }

   final List<View> getDependencySortedChildren() {
      this.f();
      return Collections.unmodifiableList(this.g);
   }

   public final WindowInsetsCompat getLastWindowInsets() {
      return this.t;
   }

   public int getNestedScrollAxes() {
      return this.x.a();
   }

   public Drawable getStatusBarBackground() {
      return this.v;
   }

   protected int getSuggestedMinimumHeight() {
      return Math.max(super.getSuggestedMinimumHeight(), this.getPaddingTop() + this.getPaddingBottom());
   }

   protected int getSuggestedMinimumWidth() {
      return Math.max(super.getSuggestedMinimumWidth(), this.getPaddingLeft() + this.getPaddingRight());
   }

   void o_() {
      if (this.n && this.r != null) {
         this.getViewTreeObserver().removeOnPreDrawListener(this.r);
      }

      this.s = false;
   }

   public void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.a(false);
      if (this.s) {
         if (this.r == null) {
            this.r = new CoordinatorLayout.OnPreDrawListener(this);
         }

         this.getViewTreeObserver().addOnPreDrawListener(this.r);
      }

      if (this.t == null && ViewCompat.r(this)) {
         ViewCompat.q(this);
      }

      this.n = true;
   }

   public void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.a(false);
      if (this.s && this.r != null) {
         this.getViewTreeObserver().removeOnPreDrawListener(this.r);
      }

      if (this.q != null) {
         this.onStopNestedScroll(this.q);
      }

      this.n = false;
   }

   public void onDraw(Canvas var1) {
      super.onDraw(var1);
      if (this.u && this.v != null) {
         int var2;
         if (this.t != null) {
            var2 = this.t.b();
         } else {
            var2 = 0;
         }

         if (var2 > 0) {
            this.v.setBounds(0, 0, this.getWidth(), var2);
            this.v.draw(var1);
         }
      }
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      int var2 = var1.getActionMasked();
      if (var2 == 0) {
         this.a(true);
      }

      boolean var3 = this.a(var1, 0);
      if (false) {
         throw new NullPointerException();
      }

      if (var2 == 1 || var2 == 3) {
         this.a(true);
      }

      return var3;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      var3 = ViewCompat.e(this);
      var4 = this.g.size();

      for (int var8 = 0; var8 < var4; var8++) {
         View var6 = this.g.get(var8);
         if (var6.getVisibility() != 8) {
            CoordinatorLayout.Behavior var7 = ((CoordinatorLayout.LayoutParams)var6.getLayoutParams()).b();
            if (var7 == null || !var7.a(this, var6, var3)) {
               this.a(var6, var3);
            }
         }
      }
   }

   protected void onMeasure(int var1, int var2) {
      this.f();
      this.a();
      int var16 = this.getPaddingLeft();
      int var15 = this.getPaddingTop();
      int var13 = this.getPaddingRight();
      int var14 = this.getPaddingBottom();
      int var12 = ViewCompat.e(this);
      boolean var7;
      if (var12 == 1) {
         var7 = true;
      } else {
         var7 = false;
      }

      int var17 = MeasureSpec.getMode(var1);
      int var18 = MeasureSpec.getSize(var1);
      int var20 = MeasureSpec.getMode(var2);
      int var19 = MeasureSpec.getSize(var2);
      int var3 = this.getSuggestedMinimumWidth();
      int var4 = this.getSuggestedMinimumHeight();
      int var5 = 0;
      boolean var8;
      if (this.t != null && ViewCompat.r(this)) {
         var8 = true;
      } else {
         var8 = false;
      }

      int var21 = this.g.size();

      for (int var9 = 0; var9 < var21; var9++) {
         View var25 = this.g.get(var9);
         if (var25.getVisibility() != 8) {
            CoordinatorLayout.LayoutParams var26 = (CoordinatorLayout.LayoutParams)var25.getLayoutParams();
            int var10 = 0;
            int var6 = var10;
            if (var26.e >= 0) {
               var6 = var10;
               if (var17 != 0) {
                  int var22 = this.b(var26.e);
                  int var11 = GravityCompat.a(d(var26.c), var12) & 7;
                  label67:
                  if ((var11 != 3 || var7) && (var11 != 5 || !var7)) {
                     if (var11 != 5 || var7) {
                        var6 = var10;
                        if (var11 != 3) {
                           break label67;
                        }

                        var6 = var10;
                        if (!var7) {
                           break label67;
                        }
                     }

                     var6 = Math.max(0, var22 - var16);
                  } else {
                     var6 = Math.max(0, var18 - var13 - var22);
                  }
               }
            }

            int var29;
            if (var8 && !ViewCompat.r(var25)) {
               var29 = this.t.a();
               int var23 = this.t.c();
               int var31 = this.t.b();
               var10 = this.t.d();
               var29 = MeasureSpec.makeMeasureSpec(var18 - (var29 + var23), var17);
               var10 = MeasureSpec.makeMeasureSpec(var19 - (var31 + var10), var20);
            } else {
               var10 = var2;
               var29 = var1;
            }

            CoordinatorLayout.Behavior var24 = var26.b();
            if (var24 == null || !var24.a(this, var25, var29, var6, var10, 0)) {
               this.a(var25, var29, var6, var10, 0);
            }

            var3 = Math.max(var3, var25.getMeasuredWidth() + var16 + var13 + var26.leftMargin + var26.rightMargin);
            var4 = Math.max(var4, var25.getMeasuredHeight() + var15 + var14 + var26.topMargin + var26.bottomMargin);
            var5 = View.combineMeasuredStates(var5, var25.getMeasuredState());
         }
      }

      this.setMeasuredDimension(View.resolveSizeAndState(var3, var1, 0xFF000000 & var5), View.resolveSizeAndState(var4, var2, var5 << 16));
   }

   @Override
   public boolean onNestedFling(View var1, float var2, float var3, boolean var4) {
      int var6 = this.getChildCount();
      int var5 = 0;
      boolean var7 = false;

      while (var5 < var6) {
         View var8 = this.getChildAt(var5);
         if (var8.getVisibility() != 8) {
            CoordinatorLayout.LayoutParams var9 = (CoordinatorLayout.LayoutParams)var8.getLayoutParams();
            if (var9.b(0)) {
               CoordinatorLayout.Behavior var10 = var9.b();
               if (var10 != null) {
                  var7 |= var10.a(this, var8, var1, var2, var3, var4);
               }
            }
         }

         var5++;
      }

      if (var7) {
         this.a(1);
      }

      return var7;
   }

   @Override
   public boolean onNestedPreFling(View var1, float var2, float var3) {
      int var5 = this.getChildCount();
      int var4 = 0;
      boolean var6 = false;

      while (var4 < var5) {
         View var7 = this.getChildAt(var4);
         if (var7.getVisibility() != 8) {
            CoordinatorLayout.LayoutParams var8 = (CoordinatorLayout.LayoutParams)var7.getLayoutParams();
            if (var8.b(0)) {
               CoordinatorLayout.Behavior var9 = var8.b();
               if (var9 != null) {
                  var6 |= var9.a(this, var7, var1, var2, var3);
               }
            }
         }

         var4++;
      }

      return var6;
   }

   @Override
   public void onNestedPreScroll(View var1, int var2, int var3, int[] var4) {
      this.a(var1, var2, var3, var4, 0);
   }

   @Override
   public void onNestedScroll(View var1, int var2, int var3, int var4, int var5) {
      this.a(var1, var2, var3, var4, var5, 0);
   }

   @Override
   public void onNestedScrollAccepted(View var1, View var2, int var3) {
      this.b(var1, var2, var3, 0);
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if (!(var1 instanceof CoordinatorLayout.SavedState)) {
         super.onRestoreInstanceState(var1);
      } else {
         var1 = var1;
         super.onRestoreInstanceState(var1.a());
         SparseArray var9 = var1.a;
         int var3 = this.getChildCount();

         for (int var2 = 0; var2 < var3; var2++) {
            View var5 = this.getChildAt(var2);
            int var4 = var5.getId();
            CoordinatorLayout.Behavior var6 = this.a(var5).b();
            if (var4 != -1 && var6 != null) {
               Parcelable var7 = (Parcelable)var9.get(var4);
               if (var7 != null) {
                  var6.a(this, var5, var7);
               }
            }
         }
      }
   }

   protected Parcelable onSaveInstanceState() {
      CoordinatorLayout.SavedState var4 = new CoordinatorLayout.SavedState(super.onSaveInstanceState());
      SparseArray var5 = new SparseArray();
      int var2 = this.getChildCount();

      for (int var1 = 0; var1 < var2; var1++) {
         View var6 = this.getChildAt(var1);
         int var3 = var6.getId();
         CoordinatorLayout.Behavior var7 = ((CoordinatorLayout.LayoutParams)var6.getLayoutParams()).b();
         if (var3 != -1 && var7 != null) {
            Parcelable var8 = var7.b(this, var6);
            if (var8 != null) {
               var5.append(var3, var8);
            }
         }
      }

      var4.a = var5;
      return var4;
   }

   @Override
   public boolean onStartNestedScroll(View var1, View var2, int var3) {
      return this.a(var1, var2, var3, 0);
   }

   @Override
   public void onStopNestedScroll(View var1) {
      this.c(var1, 0);
   }

   public boolean onTouchEvent(MotionEvent var1) {
      int var2;
      boolean var3;
      boolean var4;
      Object var8;
      label45: {
         var8 = null;
         var2 = var1.getActionMasked();
         if (this.p == null) {
            var4 = this.a(var1, 1);
            if (!var4) {
               var3 = false;
               break label45;
            }
         } else {
            var4 = false;
         }

         CoordinatorLayout.Behavior var9 = ((CoordinatorLayout.LayoutParams)this.p.getLayoutParams()).b();
         if (var9 != null) {
            var3 = var9.b(this, this.p, var1);
         } else {
            var3 = false;
         }
      }

      boolean var5;
      if (this.p == null) {
         var5 = var3 | super.onTouchEvent(var1);
         var1 = (MotionEvent)var8;
      } else {
         var1 = (MotionEvent)var8;
         var5 = var3;
         if (var4) {
            if (true) {
               long var6 = SystemClock.uptimeMillis();
               var1 = MotionEvent.obtain(var6, var6, 3, 0.0F, 0.0F, 0);
            } else {
               var1 = null;
            }

            super.onTouchEvent(var1);
            var5 = var3;
         }
      }

      if (!var5 && var2 == 0) {
      }

      if (var1 != null) {
         var1.recycle();
      }

      if (var2 == 1 || var2 == 3) {
         this.a(false);
      }

      return var5;
   }

   public boolean requestChildRectangleOnScreen(View var1, Rect var2, boolean var3) {
      CoordinatorLayout.Behavior var4 = ((CoordinatorLayout.LayoutParams)var1.getLayoutParams()).b();
      if (var4 != null && var4.a(this, var1, var2, var3)) {
         var3 = true;
      } else {
         var3 = super.requestChildRectangleOnScreen(var1, var2, var3);
      }

      return var3;
   }

   public void requestDisallowInterceptTouchEvent(boolean var1) {
      super.requestDisallowInterceptTouchEvent(var1);
      if (var1 && !this.m) {
         this.a(false);
         this.m = true;
      }
   }

   public void setFitsSystemWindows(boolean var1) {
      super.setFitsSystemWindows(var1);
      this.g();
   }

   public void setOnHierarchyChangeListener(OnHierarchyChangeListener var1) {
      this.e = var1;
   }

   public void setStatusBarBackground(Drawable var1) {
      Drawable var3 = null;
      if (this.v != var1) {
         if (this.v != null) {
            this.v.setCallback(null);
         }

         if (var1 != null) {
            var3 = var1.mutate();
         }

         this.v = var3;
         if (this.v != null) {
            if (this.v.isStateful()) {
               this.v.setState(this.getDrawableState());
            }

            DrawableCompat.b(this.v, ViewCompat.e(this));
            var1 = this.v;
            boolean var2;
            if (this.getVisibility() == 0) {
               var2 = true;
            } else {
               var2 = false;
            }

            var1.setVisible(var2, false);
            this.v.setCallback(this);
         }

         ViewCompat.c(this);
      }
   }

   public void setStatusBarBackgroundColor(int var1) {
      this.setStatusBarBackground(new ColorDrawable(var1));
   }

   public void setStatusBarBackgroundResource(int var1) {
      Drawable var2;
      if (var1 != 0) {
         var2 = ContextCompat.a(this.getContext(), var1);
      } else {
         var2 = null;
      }

      this.setStatusBarBackground(var2);
   }

   public void setVisibility(int var1) {
      super.setVisibility(var1);
      boolean var2;
      if (var1 == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      if (this.v != null && this.v.isVisible() != var2) {
         this.v.setVisible(var2, false);
      }
   }

   protected boolean verifyDrawable(Drawable var1) {
      boolean var2;
      if (!super.verifyDrawable(var1) && var1 != this.v) {
         var2 = false;
      } else {
         var2 = true;
      }

      return var2;
   }

   public interface AttachedBehavior {
      CoordinatorLayout.Behavior a();
   }

   public abstract static class Behavior<V extends View> {
      public Behavior() {
      }

      public Behavior(Context var1, AttributeSet var2) {
      }

      public WindowInsetsCompat a(CoordinatorLayout var1, V var2, WindowInsetsCompat var3) {
         return var3;
      }

      public void a(CoordinatorLayout.LayoutParams var1) {
      }

      public void a(CoordinatorLayout var1, V var2, Parcelable var3) {
      }

      public void a(CoordinatorLayout var1, V var2, View var3, int var4) {
         if (var4 == 0) {
            this.c(var1, (V)var2, var3);
         }
      }

      @Deprecated
      public void a(CoordinatorLayout var1, V var2, View var3, int var4, int var5, int var6, int var7) {
      }

      public void a(CoordinatorLayout var1, V var2, View var3, int var4, int var5, int var6, int var7, int var8) {
         if (var8 == 0) {
            this.a(var1, (V)var2, var3, var4, var5, var6, var7);
         }
      }

      @Deprecated
      public void a(CoordinatorLayout var1, V var2, View var3, int var4, int var5, int[] var6) {
      }

      public void a(CoordinatorLayout var1, V var2, View var3, int var4, int var5, int[] var6, int var7) {
         if (var7 == 0) {
            this.a(var1, (V)var2, var3, var4, var5, var6);
         }
      }

      public boolean a(CoordinatorLayout var1, V var2, int var3) {
         return false;
      }

      public boolean a(CoordinatorLayout var1, V var2, int var3, int var4, int var5, int var6) {
         return false;
      }

      public boolean a(CoordinatorLayout var1, V var2, Rect var3) {
         return false;
      }

      public boolean a(CoordinatorLayout var1, V var2, Rect var3, boolean var4) {
         return false;
      }

      public boolean a(CoordinatorLayout var1, V var2, MotionEvent var3) {
         return false;
      }

      public boolean a(CoordinatorLayout var1, V var2, View var3) {
         return false;
      }

      public boolean a(CoordinatorLayout var1, V var2, View var3, float var4, float var5) {
         return false;
      }

      public boolean a(CoordinatorLayout var1, V var2, View var3, float var4, float var5, boolean var6) {
         return false;
      }

      @Deprecated
      public boolean a(CoordinatorLayout var1, V var2, View var3, View var4, int var5) {
         return false;
      }

      public boolean a(CoordinatorLayout var1, V var2, View var3, View var4, int var5, int var6) {
         boolean var7;
         if (var6 == 0) {
            var7 = this.a(var1, (V)var2, var3, var4, var5);
         } else {
            var7 = false;
         }

         return var7;
      }

      public Parcelable b(CoordinatorLayout var1, V var2) {
         return BaseSavedState.EMPTY_STATE;
      }

      @Deprecated
      public void b(CoordinatorLayout var1, V var2, View var3, View var4, int var5) {
      }

      public void b(CoordinatorLayout var1, V var2, View var3, View var4, int var5, int var6) {
         if (var6 == 0) {
            this.b(var1, (V)var2, var3, var4, var5);
         }
      }

      public boolean b(CoordinatorLayout var1, V var2, MotionEvent var3) {
         return false;
      }

      public boolean b(CoordinatorLayout var1, V var2, View var3) {
         return false;
      }

      public int c(CoordinatorLayout var1, V var2) {
         return -16777216;
      }

      public void c() {
      }

      @Deprecated
      public void c(CoordinatorLayout var1, V var2, View var3) {
      }

      public float d(CoordinatorLayout var1, V var2) {
         return 0.0F;
      }

      public void d(CoordinatorLayout var1, V var2, View var3) {
      }

      public boolean e(CoordinatorLayout var1, V var2) {
         boolean var3;
         if (this.d(var1, (V)var2) > 0.0F) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }
   }

   @Deprecated
   @Retention(RetentionPolicy.RUNTIME)
   public @interface DefaultBehavior {
      Class<? extends CoordinatorLayout.Behavior> a();
   }

   private class HierarchyChangeListener implements OnHierarchyChangeListener {
      final CoordinatorLayout a;

      HierarchyChangeListener(CoordinatorLayout var1) {
         this.a = var1;
      }

      public void onChildViewAdded(View var1, View var2) {
         if (this.a.e != null) {
            this.a.e.onChildViewAdded(var1, var2);
         }
      }

      public void onChildViewRemoved(View var1, View var2) {
         this.a.a(2);
         if (this.a.e != null) {
            this.a.e.onChildViewRemoved(var1, var2);
         }
      }
   }

   public static class LayoutParams extends MarginLayoutParams {
      CoordinatorLayout.Behavior a;
      boolean b = false;
      public int c = 0;
      public int d = 0;
      public int e = -1;
      int f = -1;
      public int g = 0;
      public int h = 0;
      int i;
      int j;
      View k;
      View l;
      final Rect m = new Rect();
      Object n;
      private boolean o;
      private boolean p;
      private boolean q;
      private boolean r;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
      }

      LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.CoordinatorLayout_Layout);
         this.c = var3.getInteger(R.styleable.CoordinatorLayout_Layout_android_layout_gravity, 0);
         this.f = var3.getResourceId(R.styleable.CoordinatorLayout_Layout_layout_anchor, -1);
         this.d = var3.getInteger(R.styleable.CoordinatorLayout_Layout_layout_anchorGravity, 0);
         this.e = var3.getInteger(R.styleable.CoordinatorLayout_Layout_layout_keyline, -1);
         this.g = var3.getInt(R.styleable.CoordinatorLayout_Layout_layout_insetEdge, 0);
         this.h = var3.getInt(R.styleable.CoordinatorLayout_Layout_layout_dodgeInsetEdges, 0);
         this.b = var3.hasValue(R.styleable.CoordinatorLayout_Layout_layout_behavior);
         if (this.b) {
            this.a = CoordinatorLayout.a(var1, var2, var3.getString(R.styleable.CoordinatorLayout_Layout_layout_behavior));
         }

         var3.recycle();
         if (this.a != null) {
            this.a.a(this);
         }
      }

      public LayoutParams(CoordinatorLayout.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
      }

      private void a(View var1, CoordinatorLayout var2) {
         this.k = var2.findViewById(this.f);
         if (this.k != null) {
            if (this.k == var2) {
               if (!var2.isInEditMode()) {
                  throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
               }

               this.l = null;
               this.k = null;
            } else {
               View var4 = this.k;

               for (ViewParent var3 = this.k.getParent(); var3 != var2 && var3 != null; var3 = var3.getParent()) {
                  if (var3 == var1) {
                     if (!var2.isInEditMode()) {
                        throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                     }

                     this.l = null;
                     this.k = null;
                     return;
                  }

                  if (var3 instanceof View) {
                     var4 = (View)var3;
                  }
               }

               this.l = var4;
            }
         } else {
            if (!var2.isInEditMode()) {
               throw new IllegalStateException(
                  "Could not find CoordinatorLayout descendant view with id " + var2.getResources().getResourceName(this.f) + " to anchor view " + var1
               );
            }

            this.l = null;
            this.k = null;
         }
      }

      private boolean a(View var1, int var2) {
         int var3 = GravityCompat.a(((CoordinatorLayout.LayoutParams)var1.getLayoutParams()).g, var2);
         boolean var4;
         if (var3 != 0 && (GravityCompat.a(this.h, var2) & var3) == var3) {
            var4 = true;
         } else {
            var4 = false;
         }

         return var4;
      }

      private boolean b(View var1, CoordinatorLayout var2) {
         boolean var3;
         if (this.k.getId() != this.f) {
            var3 = false;
         } else {
            View var5 = this.k;
            ViewParent var4 = this.k.getParent();

            while (true) {
               if (var4 == var2) {
                  this.l = var5;
                  var3 = true;
                  break;
               }

               if (var4 == null || var4 == var1) {
                  this.l = null;
                  this.k = null;
                  var3 = false;
                  break;
               }

               if (var4 instanceof View) {
                  var5 = (View)var4;
               }

               var4 = var4.getParent();
            }
         }

         return var3;
      }

      public int a() {
         return this.f;
      }

      void a(int var1) {
         this.a(var1, false);
      }

      void a(int var1, boolean var2) {
         switch (var1) {
            case 0:
               this.p = var2;
               break;
            case 1:
               this.q = var2;
         }
      }

      void a(Rect var1) {
         this.m.set(var1);
      }

      public void a(CoordinatorLayout.Behavior var1) {
         if (this.a != var1) {
            if (this.a != null) {
               this.a.c();
            }

            this.a = var1;
            this.n = null;
            this.b = true;
            if (var1 != null) {
               var1.a(this);
            }
         }
      }

      void a(boolean var1) {
         this.r = var1;
      }

      boolean a(CoordinatorLayout var1, View var2) {
         boolean var3;
         if (this.o) {
            var3 = true;
         } else {
            boolean var4 = this.o;
            if (this.a != null) {
               var3 = this.a.e(var1, var2);
            } else {
               var3 = false;
            }

            var3 |= var4;
            this.o = var3;
         }

         return var3;
      }

      boolean a(CoordinatorLayout var1, View var2, View var3) {
         boolean var4;
         if (var3 != this.l && !this.a(var3, ViewCompat.e(var1)) && (this.a == null || !this.a.a(var1, var2, var3))) {
            var4 = false;
         } else {
            var4 = true;
         }

         return var4;
      }

      public CoordinatorLayout.Behavior b() {
         return this.a;
      }

      View b(CoordinatorLayout var1, View var2) {
         Object var3 = null;
         View var4;
         if (this.f == -1) {
            this.l = null;
            this.k = null;
            var4 = (View)var3;
         } else {
            if (this.k == null || !this.b(var2, var1)) {
               this.a(var2, var1);
            }

            var4 = this.k;
         }

         return var4;
      }

      boolean b(int var1) {
         boolean var2;
         switch (var1) {
            case 0:
               var2 = this.p;
               break;
            case 1:
               var2 = this.q;
               break;
            default:
               var2 = false;
         }

         return var2;
      }

      Rect c() {
         return this.m;
      }

      boolean d() {
         boolean var1;
         if (this.k == null && this.f != -1) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      boolean e() {
         if (this.a == null) {
            this.o = false;
         }

         return this.o;
      }

      void f() {
         this.o = false;
      }

      boolean g() {
         return this.r;
      }

      void h() {
         this.r = false;
      }
   }

   class OnPreDrawListener implements android.view.ViewTreeObserver.OnPreDrawListener {
      final CoordinatorLayout a;

      OnPreDrawListener(CoordinatorLayout var1) {
         this.a = var1;
      }

      public boolean onPreDraw() {
         this.a.a(0);
         return true;
      }
   }

   protected static class SavedState extends AbsSavedState {
      public static final Creator<CoordinatorLayout.SavedState> CREATOR = new ClassLoaderCreator<CoordinatorLayout.SavedState>() {
         public CoordinatorLayout.SavedState a(Parcel var1) {
            return new CoordinatorLayout.SavedState(var1, null);
         }

         public CoordinatorLayout.SavedState a(Parcel var1, ClassLoader var2) {
            return new CoordinatorLayout.SavedState(var1, var2);
         }

         public CoordinatorLayout.SavedState[] a(int var1) {
            return new CoordinatorLayout.SavedState[var1];
         }
      };
      SparseArray<Parcelable> a;

      public SavedState(Parcel var1, ClassLoader var2) {
         super(var1, var2);
         int var4 = var1.readInt();
         int[] var5 = new int[var4];
         var1.readIntArray(var5);
         Parcelable[] var6 = var1.readParcelableArray(var2);
         this.a = new SparseArray(var4);

         for (int var3 = 0; var3 < var4; var3++) {
            this.a.append(var5[var3], var6[var3]);
         }
      }

      public SavedState(Parcelable var1) {
         super(var1);
      }

      @Override
      public void writeToParcel(Parcel var1, int var2) {
         int var4 = 0;
         super.writeToParcel(var1, var2);
         int var3;
         if (this.a != null) {
            var3 = this.a.size();
         } else {
            var3 = 0;
         }

         var1.writeInt(var3);
         int[] var6 = new int[var3];
         Parcelable[] var5 = new Parcelable[var3];

         while (var4 < var3) {
            var6[var4] = this.a.keyAt(var4);
            var5[var4] = (Parcelable)this.a.valueAt(var4);
            var4++;
         }

         var1.writeIntArray(var6);
         var1.writeParcelableArray(var5, var2);
      }
   }

   static class ViewElevationComparator implements Comparator<View> {
      public int a(View var1, View var2) {
         float var3 = ViewCompat.z(var1);
         float var4 = ViewCompat.z(var2);
         byte var5;
         if (var3 > var4) {
            var5 = -1;
         } else if (var3 < var4) {
            var5 = 1;
         } else {
            var5 = 0;
         }

         return var5;
      }
   }
}
