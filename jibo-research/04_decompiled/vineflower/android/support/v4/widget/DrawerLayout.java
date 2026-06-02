package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.View.MeasureSpec;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout extends ViewGroup {
   static final int[] a = new int[]{16842931};
   static final boolean b;
   private static final int[] c = new int[]{16843828};
   private static final boolean d;
   private float A;
   private Drawable B;
   private Drawable C;
   private Drawable D;
   private CharSequence E;
   private CharSequence F;
   private Object G;
   private boolean H;
   private Drawable I;
   private Drawable J;
   private Drawable K;
   private Drawable L;
   private final ArrayList<View> M;
   private final DrawerLayout.ChildAccessibilityDelegate e;
   private float f;
   private int g;
   private int h;
   private float i;
   private Paint j;
   private final ViewDragHelper k;
   private final ViewDragHelper l;
   private final DrawerLayout.ViewDragCallback m;
   private final DrawerLayout.ViewDragCallback n;
   private int o;
   private boolean p;
   private boolean q;
   private int r;
   private int s;
   private int t;
   private int u;
   private boolean v;
   private boolean w;
   private DrawerLayout.DrawerListener x;
   private List<DrawerLayout.DrawerListener> y;
   private float z;

   static {
      boolean var1 = true;
      boolean var0;
      if (VERSION.SDK_INT >= 19) {
         var0 = true;
      } else {
         var0 = false;
      }

      b = var0;
      if (VERSION.SDK_INT >= 21) {
         var0 = var1;
      } else {
         var0 = false;
      }

      d = var0;
   }

   public DrawerLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public DrawerLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.e = new DrawerLayout.ChildAccessibilityDelegate();
      this.h = -1728053248;
      this.j = new Paint();
      this.q = true;
      this.r = 3;
      this.s = 3;
      this.t = 3;
      this.u = 3;
      this.I = null;
      this.J = null;
      this.K = null;
      this.L = null;
      this.setDescendantFocusability(262144);
      float var5 = this.getResources().getDisplayMetrics().density;
      this.g = (int)(64.0F * var5 + 0.5F);
      float var4 = 400.0F * var5;
      this.m = new DrawerLayout.ViewDragCallback(this, 3);
      this.n = new DrawerLayout.ViewDragCallback(this, 5);
      this.k = ViewDragHelper.a(this, 1.0F, this.m);
      this.k.a(1);
      this.k.a(var4);
      this.m.a(this.k);
      this.l = ViewDragHelper.a(this, 1.0F, this.n);
      this.l.a(2);
      this.l.a(var4);
      this.n.a(this.l);
      this.setFocusableInTouchMode(true);
      ViewCompat.a(this, 1);
      ViewCompat.a(this, new DrawerLayout.AccessibilityDelegate(this));
      this.setMotionEventSplittingEnabled(false);
      label27:
      if (!ViewCompat.r(this)) {
         this.f = var5 * 10.0F;
         this.M = new ArrayList<>();
      } else {
         if (VERSION.SDK_INT >= 21) {
            this.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener(this) {
               final DrawerLayout a;

               {
                  this.a = var1;
               }

               @TargetApi(21)
               public WindowInsets onApplyWindowInsets(View var1, WindowInsets var2x) {
                  DrawerLayout var4x = (DrawerLayout)var1;
                  boolean var3x;
                  if (var2x.getSystemWindowInsetTop() > 0) {
                     var3x = true;
                  } else {
                     var3x = false;
                  }

                  var4x.a(var2x, var3x);
                  return var2x.consumeSystemWindowInsets();
               }
            });
            this.setSystemUiVisibility(1280);
            TypedArray var8 = var1.obtainStyledAttributes(c);

            try {
               this.B = var8.getDrawable(0);
            } finally {
               var8.recycle();
            }
         } else {
            this.B = null;
         }
         break label27;
      }
   }

   private boolean a(Drawable var1, int var2) {
      boolean var3;
      if (var1 != null && DrawableCompat.b(var1)) {
         DrawableCompat.b(var1, var2);
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   private void c(View var1, boolean var2) {
      int var4 = this.getChildCount();

      for (int var3 = 0; var3 < var4; var3++) {
         View var5 = this.getChildAt(var3);
         if ((var2 || this.g(var5)) && (!var2 || var5 != var1)) {
            ViewCompat.a(var5, 4);
         } else {
            ViewCompat.a(var5, 1);
         }
      }
   }

   static String d(int var0) {
      String var1;
      if ((var0 & 3) == 3) {
         var1 = "LEFT";
      } else if ((var0 & 5) == 5) {
         var1 = "RIGHT";
      } else {
         var1 = Integer.toHexString(var0);
      }

      return var1;
   }

   private void e() {
      if (!d) {
         this.C = this.f();
         this.D = this.g();
      }
   }

   private Drawable f() {
      int var1 = ViewCompat.e(this);
      if (var1 == 0) {
         if (this.I != null) {
            this.a(this.I, var1);
            return this.I;
         }
      } else if (this.J != null) {
         this.a(this.J, var1);
         return this.J;
      }

      return this.K;
   }

   private Drawable g() {
      int var1 = ViewCompat.e(this);
      if (var1 == 0) {
         if (this.J != null) {
            this.a(this.J, var1);
            return this.J;
         }
      } else if (this.I != null) {
         this.a(this.I, var1);
         return this.I;
      }

      return this.L;
   }

   private boolean h() {
      int var2 = this.getChildCount();
      int var1 = 0;

      boolean var3;
      while (true) {
         if (var1 >= var2) {
            var3 = false;
            break;
         }

         if (((DrawerLayout.LayoutParams)this.getChildAt(var1).getLayoutParams()).c) {
            var3 = true;
            break;
         }

         var1++;
      }

      return var3;
   }

   private boolean i() {
      boolean var1;
      if (this.c() != null) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   static boolean l(View var0) {
      boolean var1;
      if (ViewCompat.d(var0) != 4 && ViewCompat.d(var0) != 2) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private static boolean m(View var0) {
      boolean var2 = false;
      Drawable var3 = var0.getBackground();
      boolean var1 = var2;
      if (var3 != null) {
         var1 = var2;
         if (var3.getOpacity() == -1) {
            var1 = true;
         }
      }

      return var1;
   }

   public int a(int var1) {
      int var2 = ViewCompat.e(this);
      switch (var1) {
         case 3:
            if (this.r != 3) {
               var1 = this.r;
               return var1;
            }

            if (var2 == 0) {
               var1 = this.t;
            } else {
               var1 = this.u;
            }

            if (var1 != 3) {
               return var1;
            }
            break;
         case 5:
            if (this.s != 3) {
               var1 = this.s;
               return var1;
            }

            if (var2 == 0) {
               var1 = this.u;
            } else {
               var1 = this.t;
            }

            if (var1 != 3) {
               return var1;
            }
            break;
         case 8388611:
            if (this.t != 3) {
               var1 = this.t;
               return var1;
            }

            if (var2 == 0) {
               var1 = this.r;
            } else {
               var1 = this.s;
            }

            if (var1 != 3) {
               return var1;
            }
            break;
         case 8388613:
            if (this.u != 3) {
               var1 = this.u;
               return var1;
            }

            if (var2 == 0) {
               var1 = this.s;
            } else {
               var1 = this.r;
            }

            if (var1 != 3) {
               return var1;
            }
      }

      return 0;
   }

   public int a(View var1) {
      if (!this.g(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a drawer");
      } else {
         return this.a(((DrawerLayout.LayoutParams)var1.getLayoutParams()).a);
      }
   }

   View a() {
      int var2 = this.getChildCount();
      int var1 = 0;

      View var3;
      while (true) {
         if (var1 >= var2) {
            var3 = null;
            break;
         }

         var3 = this.getChildAt(var1);
         if ((((DrawerLayout.LayoutParams)var3.getLayoutParams()).d & 1) == 1) {
            break;
         }

         var1++;
      }

      return var3;
   }

   public void a(int var1, int var2) {
      int var3 = GravityCompat.a(var2, ViewCompat.e(this));
      switch (var2) {
         case 3:
            this.r = var1;
            break;
         case 5:
            this.s = var1;
            break;
         case 8388611:
            this.t = var1;
            break;
         case 8388613:
            this.u = var1;
      }

      if (var1 != 0) {
         ViewDragHelper var4;
         if (var3 == 3) {
            var4 = this.k;
         } else {
            var4 = this.l;
         }

         var4.e();
      }

      switch (var1) {
         case 1:
            View var6 = this.c(var3);
            if (var6 != null) {
               this.i(var6);
            }
            break;
         case 2:
            View var5 = this.c(var3);
            if (var5 != null) {
               this.h(var5);
            }
      }
   }

   void a(int var1, int var2, View var3) {
      int var4 = this.k.a();
      var1 = this.l.a();
      byte var7;
      if (var4 == 1 || var1 == 1) {
         var7 = 1;
      } else if (var4 != 2 && var1 != 2) {
         var7 = 0;
      } else {
         var7 = 2;
      }

      if (var3 != null && var2 == 0) {
         DrawerLayout.LayoutParams var5 = (DrawerLayout.LayoutParams)var3.getLayoutParams();
         if (var5.b == 0.0F) {
            this.b(var3);
         } else if (var5.b == 1.0F) {
            this.c(var3);
         }
      }

      if (var7 != this.o) {
         this.o = var7;
         if (this.y != null) {
            for (int var8 = this.y.size() - 1; var8 >= 0; var8--) {
               this.y.get(var8).a(var7);
            }
         }
      }
   }

   public void a(DrawerLayout.DrawerListener var1) {
      if (var1 != null) {
         if (this.y == null) {
            this.y = new ArrayList<>();
         }

         this.y.add(var1);
      }
   }

   void a(View var1, float var2) {
      if (this.y != null) {
         for (int var3 = this.y.size() - 1; var3 >= 0; var3--) {
            this.y.get(var3).a(var1, var2);
         }
      }
   }

   public void a(View var1, boolean var2) {
      if (!this.g(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a sliding drawer");
      }

      DrawerLayout.LayoutParams var3 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
      if (this.q) {
         var3.b = 1.0F;
         var3.d = 1;
         this.c(var1, true);
      } else if (var2) {
         var3.d |= 2;
         if (this.a(var1, 3)) {
            this.k.a(var1, 0, var1.getTop());
         } else {
            this.l.a(var1, this.getWidth() - var1.getWidth(), var1.getTop());
         }
      } else {
         this.c(var1, 1.0F);
         this.a(var3.a, 0, var1);
         var1.setVisibility(0);
      }

      this.invalidate();
   }

   public void a(Object var1, boolean var2) {
      this.G = var1;
      this.H = var2;
      if (!var2 && this.getBackground() == null) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.setWillNotDraw(var2);
      this.requestLayout();
   }

   void a(boolean var1) {
      int var5 = this.getChildCount();
      int var3 = 0;
      boolean var2 = false;

      while (var3 < var5) {
         View var7 = this.getChildAt(var3);
         DrawerLayout.LayoutParams var6 = (DrawerLayout.LayoutParams)var7.getLayoutParams();
         int var4 = var2;
         if (this.g(var7)) {
            if (var1 && !var6.c) {
               var4 = var2;
            } else {
               var4 = var7.getWidth();
               if (this.a(var7, 3)) {
                  var2 |= this.k.a(var7, -var4, var7.getTop());
               } else {
                  var2 |= this.l.a(var7, this.getWidth(), var7.getTop());
               }

               var6.c = false;
               var4 = var2;
            }
         }

         var3++;
         var2 = (boolean)var4;
      }

      this.m.a();
      this.n.a();
      if (var2) {
         this.invalidate();
      }
   }

   boolean a(View var1, int var2) {
      boolean var3;
      if ((this.e(var1) & var2) == var2) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   public void addFocusables(ArrayList<View> var1, int var2, int var3) {
      byte var6 = 0;
      if (this.getDescendantFocusability() != 393216) {
         int var7 = this.getChildCount();
         int var4 = 0;
         int var5 = 0;

         while (var4 < var7) {
            View var8 = this.getChildAt(var4);
            if (this.g(var8)) {
               if (this.j(var8)) {
                  var5 = 1;
                  var8.addFocusables(var1, var2, var3);
               }
            } else {
               this.M.add(var8);
            }

            var4++;
         }

         if (!var5) {
            var5 = this.M.size();

            for (int var9 = var6; var9 < var5; var9++) {
               View var11 = this.M.get(var9);
               if (var11.getVisibility() == 0) {
                  var11.addFocusables(var1, var2, var3);
               }
            }
         }

         this.M.clear();
      }
   }

   public void addView(View var1, int var2, android.view.ViewGroup.LayoutParams var3) {
      super.addView(var1, var2, var3);
      if (this.a() == null && !this.g(var1)) {
         ViewCompat.a(var1, 1);
      } else {
         ViewCompat.a(var1, 4);
      }

      if (!b) {
         ViewCompat.a(var1, this.e);
      }
   }

   public CharSequence b(int var1) {
      var1 = GravityCompat.a(var1, ViewCompat.e(this));
      CharSequence var2;
      if (var1 == 3) {
         var2 = this.E;
      } else if (var1 == 5) {
         var2 = this.F;
      } else {
         var2 = null;
      }

      return var2;
   }

   public void b() {
      this.a(false);
   }

   public void b(DrawerLayout.DrawerListener var1) {
      if (var1 != null && this.y != null) {
         this.y.remove(var1);
      }
   }

   void b(View var1) {
      DrawerLayout.LayoutParams var3 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
      if ((var3.d & 1) == 1) {
         var3.d = 0;
         if (this.y != null) {
            for (int var2 = this.y.size() - 1; var2 >= 0; var2--) {
               this.y.get(var2).b(var1);
            }
         }

         this.c(var1, false);
         if (this.hasWindowFocus()) {
            var1 = this.getRootView();
            if (var1 != null) {
               var1.sendAccessibilityEvent(32);
            }
         }
      }
   }

   void b(View var1, float var2) {
      DrawerLayout.LayoutParams var3 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
      if (var2 != var3.b) {
         var3.b = var2;
         this.a(var1, var2);
      }
   }

   public void b(View var1, boolean var2) {
      if (!this.g(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a sliding drawer");
      }

      DrawerLayout.LayoutParams var3 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
      if (this.q) {
         var3.b = 0.0F;
         var3.d = 0;
      } else if (var2) {
         var3.d |= 4;
         if (this.a(var1, 3)) {
            this.k.a(var1, -var1.getWidth(), var1.getTop());
         } else {
            this.l.a(var1, this.getWidth(), var1.getTop());
         }
      } else {
         this.c(var1, 0.0F);
         this.a(var3.a, 0, var1);
         var1.setVisibility(4);
      }

      this.invalidate();
   }

   View c() {
      int var2 = this.getChildCount();
      int var1 = 0;

      View var3;
      while (true) {
         if (var1 >= var2) {
            var3 = null;
            break;
         }

         var3 = this.getChildAt(var1);
         if (this.g(var3) && this.k(var3)) {
            break;
         }

         var1++;
      }

      return var3;
   }

   View c(int var1) {
      int var2 = GravityCompat.a(var1, ViewCompat.e(this));
      int var3 = this.getChildCount();
      var1 = 0;

      View var4;
      while (true) {
         if (var1 >= var3) {
            var4 = null;
            break;
         }

         var4 = this.getChildAt(var1);
         if ((this.e(var4) & 7) == (var2 & 7)) {
            break;
         }

         var1++;
      }

      return var4;
   }

   void c(View var1) {
      DrawerLayout.LayoutParams var3 = (DrawerLayout.LayoutParams)var1.getLayoutParams();
      if ((var3.d & 1) == 0) {
         var3.d = 1;
         if (this.y != null) {
            for (int var2 = this.y.size() - 1; var2 >= 0; var2--) {
               this.y.get(var2).a(var1);
            }
         }

         this.c(var1, true);
         if (this.hasWindowFocus()) {
            this.sendAccessibilityEvent(32);
         }
      }
   }

   void c(View var1, float var2) {
      float var3 = this.d(var1);
      int var4 = var1.getWidth();
      int var5 = (int)(var3 * var4);
      var4 = (int)(var4 * var2) - var5;
      if (!this.a(var1, 3)) {
         var4 = -var4;
      }

      var1.offsetLeftAndRight(var4);
      this.b(var1, var2);
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      boolean var2;
      if (var1 instanceof DrawerLayout.LayoutParams && super.checkLayoutParams(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public void computeScroll() {
      int var3 = this.getChildCount();
      float var1 = 0.0F;

      for (int var2 = 0; var2 < var3; var2++) {
         var1 = Math.max(var1, ((DrawerLayout.LayoutParams)this.getChildAt(var2).getLayoutParams()).b);
      }

      this.i = var1;
      boolean var4 = this.k.a(true);
      boolean var5 = this.l.a(true);
      if (var4 || var5) {
         ViewCompat.c(this);
      }
   }

   float d(View var1) {
      return ((DrawerLayout.LayoutParams)var1.getLayoutParams()).b;
   }

   void d() {
      int var1 = 0;
      if (!this.w) {
         long var3 = SystemClock.uptimeMillis();
         MotionEvent var5 = MotionEvent.obtain(var3, var3, 3, 0.0F, 0.0F, 0);

         for (int var2 = this.getChildCount(); var1 < var2; var1++) {
            this.getChildAt(var1).dispatchTouchEvent(var5);
         }

         var5.recycle();
         this.w = true;
      }
   }

   protected boolean drawChild(Canvas var1, View var2, long var3) {
      int var12 = this.getHeight();
      boolean var16 = this.f(var2);
      int var8 = 0;
      int var10 = 0;
      int var6 = this.getWidth();
      int var13 = var1.save();
      int var7 = var6;
      if (var16) {
         int var14 = this.getChildCount();
         int var9 = 0;
         var8 = var10;

         while (var9 < var14) {
            label55: {
               View var17 = this.getChildAt(var9);
               if (var17 != var2 && var17.getVisibility() == 0 && m(var17) && this.g(var17)) {
                  if (var17.getHeight() < var12) {
                     var10 = var8;
                     var7 = var6;
                     break label55;
                  }

                  if (this.a(var17, 3)) {
                     var7 = var17.getRight();
                     if (var7 <= var8) {
                        var7 = var8;
                     }

                     var10 = var7;
                     var7 = var6;
                     break label55;
                  }

                  int var11 = var17.getLeft();
                  var7 = var11;
                  var10 = var8;
                  if (var11 < var6) {
                     break label55;
                  }
               }

               var7 = var6;
               var10 = var8;
            }

            var9++;
            var6 = var7;
            var8 = var10;
         }

         var1.clipRect(var8, 0, var6, this.getHeight());
         var7 = var6;
      }

      boolean var15 = super.drawChild(var1, var2, var3);
      var1.restoreToCount(var13);
      if (this.i > 0.0F && var16) {
         int var29 = (int)(((this.h & 0xFF000000) >>> 24) * this.i);
         var6 = this.h;
         this.j.setColor(var29 << 24 | var6 & 16777215);
         var1.drawRect(var8, 0.0F, var7, this.getHeight(), this.j);
      } else if (this.C != null && this.a(var2, 3)) {
         var8 = this.C.getIntrinsicWidth();
         var6 = var2.getRight();
         var7 = this.k.b();
         float var18 = Math.max(0.0F, Math.min((float)var6 / var7, 1.0F));
         this.C.setBounds(var6, var2.getTop(), var8 + var6, var2.getBottom());
         this.C.setAlpha((int)(255.0F * var18));
         this.C.draw(var1);
      } else if (this.D != null && this.a(var2, 5)) {
         var8 = this.D.getIntrinsicWidth();
         var6 = var2.getLeft();
         int var28 = this.getWidth();
         var7 = this.l.b();
         float var5 = Math.max(0.0F, Math.min((float)(var28 - var6) / var7, 1.0F));
         this.D.setBounds(var6 - var8, var2.getTop(), var6, var2.getBottom());
         this.D.setAlpha((int)(255.0F * var5));
         this.D.draw(var1);
      }

      return var15;
   }

   int e(View var1) {
      return GravityCompat.a(((DrawerLayout.LayoutParams)var1.getLayoutParams()).a, ViewCompat.e(this));
   }

   boolean f(View var1) {
      boolean var2;
      if (((DrawerLayout.LayoutParams)var1.getLayoutParams()).a == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   boolean g(View var1) {
      int var2 = GravityCompat.a(((DrawerLayout.LayoutParams)var1.getLayoutParams()).a, ViewCompat.e(var1));
      boolean var3;
      if ((var2 & 3) != 0) {
         var3 = true;
      } else if ((var2 & 5) != 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
      return new DrawerLayout.LayoutParams(-1, -1);
   }

   public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new DrawerLayout.LayoutParams(this.getContext(), var1);
   }

   protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      DrawerLayout.LayoutParams var2;
      if (var1 instanceof DrawerLayout.LayoutParams) {
         var2 = new DrawerLayout.LayoutParams((DrawerLayout.LayoutParams)var1);
      } else if (var1 instanceof MarginLayoutParams) {
         var2 = new DrawerLayout.LayoutParams((MarginLayoutParams)var1);
      } else {
         var2 = new DrawerLayout.LayoutParams(var1);
      }

      return var2;
   }

   public float getDrawerElevation() {
      float var1;
      if (d) {
         var1 = this.f;
      } else {
         var1 = 0.0F;
      }

      return var1;
   }

   public Drawable getStatusBarBackgroundDrawable() {
      return this.B;
   }

   public void h(View var1) {
      this.a(var1, true);
   }

   public void i(View var1) {
      this.b(var1, true);
   }

   public boolean j(View var1) {
      if (!this.g(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a drawer");
      }

      boolean var2;
      if ((((DrawerLayout.LayoutParams)var1.getLayoutParams()).d & 1) == 1) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public boolean k(View var1) {
      if (!this.g(var1)) {
         throw new IllegalArgumentException("View " + var1 + " is not a drawer");
      }

      boolean var2;
      if (((DrawerLayout.LayoutParams)var1.getLayoutParams()).b > 0.0F) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.q = true;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.q = true;
   }

   public void onDraw(Canvas var1) {
      super.onDraw(var1);
      if (this.H && this.B != null) {
         int var2;
         if (VERSION.SDK_INT >= 21) {
            if (this.G != null) {
               var2 = ((WindowInsets)this.G).getSystemWindowInsetTop();
            } else {
               var2 = 0;
            }
         } else {
            var2 = 0;
         }

         if (var2 > 0) {
            this.B.setBounds(0, 0, this.getWidth(), var2);
            this.B.draw(var1);
         }
      }
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      boolean var5;
      boolean var6;
      boolean var7;
      int var9;
      label38: {
         var5 = false;
         var9 = var1.getActionMasked();
         var6 = this.k.a(var1);
         var7 = this.l.a(var1);
         switch (var9) {
            case 0:
               label32: {
                  float var3 = var1.getX();
                  float var2 = var1.getY();
                  this.z = var3;
                  this.A = var2;
                  if (this.i > 0.0F) {
                     View var8 = this.k.d((int)var3, (int)var2);
                     if (var8 != null && this.f(var8)) {
                        var9 = 1;
                        break label32;
                     }
                  }

                  var9 = 0;
               }

               this.v = false;
               this.w = false;
               break label38;
            case 1:
            case 3:
               this.a(true);
               this.v = false;
               this.w = false;
               break;
            case 2:
               if (this.k.d(3)) {
                  this.m.a();
                  this.n.a();
                  var9 = 0;
                  break label38;
               }
         }

         var9 = 0;
      }

      if (var6 | var7 || var9 || this.h() || this.w) {
         var5 = true;
      }

      return var5;
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      boolean var3;
      if (var1 == 4 && this.i()) {
         var2.startTracking();
         var3 = true;
      } else {
         var3 = super.onKeyDown(var1, var2);
      }

      return var3;
   }

   public boolean onKeyUp(int var1, KeyEvent var2) {
      boolean var3;
      if (var1 == 4) {
         View var4 = this.c();
         if (var4 != null && this.a(var4) == 0) {
            this.b();
         }

         if (var4 != null) {
            var3 = true;
         } else {
            var3 = false;
         }
      } else {
         var3 = super.onKeyUp(var1, var2);
      }

      return var3;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      this.p = true;
      int var10 = var4 - var2;
      int var11 = this.getChildCount();

      for (int var21 = 0; var21 < var11; var21++) {
         View var16 = this.getChildAt(var21);
         if (var16.getVisibility() != 8) {
            DrawerLayout.LayoutParams var15 = (DrawerLayout.LayoutParams)var16.getLayoutParams();
            if (this.f(var16)) {
               var16.layout(var15.leftMargin, var15.topMargin, var15.leftMargin + var16.getMeasuredWidth(), var15.topMargin + var16.getMeasuredHeight());
            } else {
               int var12 = var16.getMeasuredWidth();
               int var13 = var16.getMeasuredHeight();
               float var6;
               int var7;
               if (this.a(var16, 3)) {
                  var2 = -var12;
                  var7 = (int)(var12 * var15.b) + var2;
                  var6 = (float)(var12 + var7) / var12;
               } else {
                  var7 = var10 - (int)(var12 * var15.b);
                  var6 = (float)(var10 - var7) / var12;
               }

               boolean var8;
               if (var6 != var15.b) {
                  var8 = true;
               } else {
                  var8 = false;
               }

               switch (var15.a & 112) {
                  case 16:
                     int var14 = var5 - var3;
                     int var9 = (var14 - var13) / 2;
                     if (var9 < var15.topMargin) {
                        var2 = var15.topMargin;
                     } else {
                        var2 = var9;
                        if (var9 + var13 > var14 - var15.bottomMargin) {
                           var2 = var14 - var15.bottomMargin - var13;
                        }
                     }

                     var16.layout(var7, var2, var12 + var7, var13 + var2);
                     break;
                  case 80:
                     var2 = var5 - var3;
                     var16.layout(var7, var2 - var15.bottomMargin - var16.getMeasuredHeight(), var12 + var7, var2 - var15.bottomMargin);
                     break;
                  default:
                     var16.layout(var7, var15.topMargin, var12 + var7, var13 + var15.topMargin);
               }

               if (var8) {
                  this.b(var16, var6);
               }

               byte var20;
               if (var15.b > 0.0F) {
                  var20 = 0;
               } else {
                  var20 = 4;
               }

               if (var16.getVisibility() != var20) {
                  var16.setVisibility(var20);
               }
            }
         }
      }

      this.p = false;
      this.q = false;
   }

   protected void onMeasure(int var1, int var2) {
      int var4;
      int var17;
      label112: {
         int var5;
         label116: {
            int var7 = MeasureSpec.getMode(var1);
            int var6 = MeasureSpec.getMode(var2);
            var17 = MeasureSpec.getSize(var1);
            var5 = MeasureSpec.getSize(var2);
            if (var7 == 1073741824) {
               var4 = var17;
               if (var6 == 1073741824) {
                  break label116;
               }
            }

            if (!this.isInEditMode()) {
               throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }

            if (var7 != Integer.MIN_VALUE && var7 == 0) {
               var17 = 300;
            }

            if (var6 == Integer.MIN_VALUE) {
               var4 = var17;
               var17 = var5;
               break label112;
            }

            var4 = var17;
            if (var6 == 0) {
               short var18 = 300;
               var4 = var17;
               var17 = var18;
               break label112;
            }
         }

         var17 = var5;
      }

      this.setMeasuredDimension(var4, var17);
      boolean var23;
      if (this.G != null && ViewCompat.r(this)) {
         var23 = true;
      } else {
         var23 = false;
      }

      int var11 = ViewCompat.e(this);
      boolean var19 = false;
      boolean var21 = false;
      int var10 = this.getChildCount();

      for (int var8 = 0; var8 < var10; var8++) {
         View var15 = this.getChildAt(var8);
         if (var15.getVisibility() != 8) {
            DrawerLayout.LayoutParams var16 = (DrawerLayout.LayoutParams)var15.getLayoutParams();
            if (var23) {
               int var9 = GravityCompat.a(var16.a, var11);
               if (ViewCompat.r(var15)) {
                  if (VERSION.SDK_INT >= 21) {
                     WindowInsets var14 = (WindowInsets)this.G;
                     WindowInsets var13;
                     if (var9 == 3) {
                        var13 = var14.replaceSystemWindowInsets(
                           var14.getSystemWindowInsetLeft(), var14.getSystemWindowInsetTop(), 0, var14.getSystemWindowInsetBottom()
                        );
                     } else {
                        var13 = var14;
                        if (var9 == 5) {
                           var13 = var14.replaceSystemWindowInsets(
                              0, var14.getSystemWindowInsetTop(), var14.getSystemWindowInsetRight(), var14.getSystemWindowInsetBottom()
                           );
                        }
                     }

                     var15.dispatchApplyWindowInsets(var13);
                  }
               } else if (VERSION.SDK_INT >= 21) {
                  WindowInsets var29 = (WindowInsets)this.G;
                  WindowInsets var28;
                  if (var9 == 3) {
                     var28 = var29.replaceSystemWindowInsets(
                        var29.getSystemWindowInsetLeft(), var29.getSystemWindowInsetTop(), 0, var29.getSystemWindowInsetBottom()
                     );
                  } else {
                     var28 = var29;
                     if (var9 == 5) {
                        var28 = var29.replaceSystemWindowInsets(
                           0, var29.getSystemWindowInsetTop(), var29.getSystemWindowInsetRight(), var29.getSystemWindowInsetBottom()
                        );
                     }
                  }

                  var16.leftMargin = var28.getSystemWindowInsetLeft();
                  var16.topMargin = var28.getSystemWindowInsetTop();
                  var16.rightMargin = var28.getSystemWindowInsetRight();
                  var16.bottomMargin = var28.getSystemWindowInsetBottom();
               }
            }

            if (this.f(var15)) {
               var15.measure(
                  MeasureSpec.makeMeasureSpec(var4 - var16.leftMargin - var16.rightMargin, 1073741824),
                  MeasureSpec.makeMeasureSpec(var17 - var16.topMargin - var16.bottomMargin, 1073741824)
               );
            } else {
               if (!this.g(var15)) {
                  throw new IllegalStateException(
                     "Child "
                        + var15
                        + " at index "
                        + var8
                        + " does not have a valid layout_gravity - must be Gravity.LEFT, "
                        + "Gravity.RIGHT or Gravity.NO_GRAVITY"
                  );
               }

               if (d && ViewCompat.m(var15) != this.f) {
                  ViewCompat.a(var15, this.f);
               }

               int var12 = this.e(var15) & 7;
               boolean var24;
               if (var12 == 3) {
                  var24 = true;
               } else {
                  var24 = false;
               }

               if (var24 && var19 || !var24 && var21) {
                  throw new IllegalStateException(
                     "Child drawer has absolute gravity " + d(var12) + " but this " + "DrawerLayout" + " already has a " + "drawer view along that edge"
                  );
               }

               if (var24) {
                  var24 = true;
                  var19 = var21;
                  var21 = var24;
               } else {
                  var24 = true;
                  var21 = var19;
                  var19 = var24;
               }

               var15.measure(
                  getChildMeasureSpec(var1, this.g + var16.leftMargin + var16.rightMargin, var16.width),
                  getChildMeasureSpec(var2, var16.topMargin + var16.bottomMargin, var16.height)
               );
               var24 = var21;
               var21 = var19;
               var19 = var24;
            }
         }
      }
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if (!(var1 instanceof DrawerLayout.SavedState)) {
         super.onRestoreInstanceState(var1);
      } else {
         var1 = var1;
         super.onRestoreInstanceState(var1.a());
         if (var1.a != 0) {
            View var2 = this.c(var1.a);
            if (var2 != null) {
               this.h(var2);
            }
         }

         if (var1.b != 3) {
            this.a(var1.b, 3);
         }

         if (var1.c != 3) {
            this.a(var1.c, 5);
         }

         if (var1.e != 3) {
            this.a(var1.e, 8388611);
         }

         if (var1.f != 3) {
            this.a(var1.f, 8388613);
         }
      }
   }

   public void onRtlPropertiesChanged(int var1) {
      this.e();
   }

   protected Parcelable onSaveInstanceState() {
      DrawerLayout.SavedState var6 = new DrawerLayout.SavedState(super.onSaveInstanceState());
      int var4 = this.getChildCount();

      for (int var1 = 0; var1 < var4; var1++) {
         DrawerLayout.LayoutParams var5 = (DrawerLayout.LayoutParams)this.getChildAt(var1).getLayoutParams();
         boolean var2;
         if (var5.d == 1) {
            var2 = true;
         } else {
            var2 = false;
         }

         boolean var3;
         if (var5.d == 2) {
            var3 = true;
         } else {
            var3 = false;
         }

         if (var2 || var3) {
            var6.a = var5.a;
            break;
         }
      }

      var6.b = this.r;
      var6.c = this.s;
      var6.e = this.t;
      var6.f = this.u;
      return var6;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      this.k.b(var1);
      this.l.b(var1);
      switch (var1.getAction() & 0xFF) {
         case 0:
            float var11 = var1.getX();
            float var9 = var1.getY();
            this.z = var11;
            this.A = var9;
            this.v = false;
            this.w = false;
            break;
         case 1:
            boolean var5;
            label23: {
               float var2 = var1.getX();
               float var3 = var1.getY();
               View var6 = this.k.d((int)var2, (int)var3);
               if (var6 != null && this.f(var6)) {
                  var2 -= this.z;
                  var3 -= this.A;
                  int var4 = this.k.d();
                  if (var2 * var2 + var3 * var3 < var4 * var4) {
                     View var7 = this.a();
                     if (var7 != null) {
                        if (this.a(var7) == 2) {
                           var5 = true;
                        } else {
                           var5 = false;
                        }
                        break label23;
                     }
                  }
               }

               var5 = true;
            }

            this.a(var5);
            this.v = false;
         case 2:
         default:
            break;
         case 3:
            this.a(true);
            this.v = false;
            this.w = false;
      }

      return true;
   }

   public void requestDisallowInterceptTouchEvent(boolean var1) {
      super.requestDisallowInterceptTouchEvent(var1);
      this.v = var1;
      if (var1) {
         this.a(true);
      }
   }

   public void requestLayout() {
      if (!this.p) {
         super.requestLayout();
      }
   }

   public void setDrawerElevation(float var1) {
      this.f = var1;

      for (int var2 = 0; var2 < this.getChildCount(); var2++) {
         View var3 = this.getChildAt(var2);
         if (this.g(var3)) {
            ViewCompat.a(var3, this.f);
         }
      }
   }

   @Deprecated
   public void setDrawerListener(DrawerLayout.DrawerListener var1) {
      if (this.x != null) {
         this.b(this.x);
      }

      if (var1 != null) {
         this.a(var1);
      }

      this.x = var1;
   }

   public void setDrawerLockMode(int var1) {
      this.a(var1, 3);
      this.a(var1, 5);
   }

   public void setScrimColor(int var1) {
      this.h = var1;
      this.invalidate();
   }

   public void setStatusBarBackground(int var1) {
      Drawable var2;
      if (var1 != 0) {
         var2 = ContextCompat.a(this.getContext(), var1);
      } else {
         var2 = null;
      }

      this.B = var2;
      this.invalidate();
   }

   public void setStatusBarBackground(Drawable var1) {
      this.B = var1;
      this.invalidate();
   }

   public void setStatusBarBackgroundColor(int var1) {
      this.B = new ColorDrawable(var1);
      this.invalidate();
   }

   class AccessibilityDelegate extends AccessibilityDelegateCompat {
      final DrawerLayout a;
      private final Rect c;

      AccessibilityDelegate(DrawerLayout var1) {
         this.a = var1;
         this.c = new Rect();
      }

      private void a(AccessibilityNodeInfoCompat var1, AccessibilityNodeInfoCompat var2) {
         Rect var3 = this.c;
         var2.a(var3);
         var1.b(var3);
         var2.c(var3);
         var1.d(var3);
         var1.e(var2.h());
         var1.a(var2.p());
         var1.b(var2.q());
         var1.d(var2.s());
         var1.j(var2.m());
         var1.h(var2.k());
         var1.c(var2.f());
         var1.d(var2.g());
         var1.f(var2.i());
         var1.g(var2.j());
         var1.i(var2.l());
         var1.a(var2.b());
      }

      private void a(AccessibilityNodeInfoCompat var1, ViewGroup var2) {
         int var4 = var2.getChildCount();

         for (int var3 = 0; var3 < var4; var3++) {
            View var5 = var2.getChildAt(var3);
            if (DrawerLayout.l(var5)) {
               var1.b(var5);
            }
         }
      }

      @Override
      public void a(View var1, AccessibilityNodeInfoCompat var2) {
         if (DrawerLayout.b) {
            super.a(var1, var2);
         } else {
            AccessibilityNodeInfoCompat var3 = AccessibilityNodeInfoCompat.a(var2);
            super.a(var1, var3);
            var2.a(var1);
            ViewParent var4 = ViewCompat.f(var1);
            if (var4 instanceof View) {
               var2.c((View)var4);
            }

            this.a(var2, var3);
            var3.t();
            this.a(var2, (ViewGroup)var1);
         }

         var2.b(DrawerLayout.class.getName());
         var2.c(false);
         var2.d(false);
         var2.a(AccessibilityNodeInfoCompat.AccessibilityActionCompat.a);
         var2.a(AccessibilityNodeInfoCompat.AccessibilityActionCompat.b);
      }

      @Override
      public void a(View var1, AccessibilityEvent var2) {
         super.a(var1, var2);
         var2.setClassName(DrawerLayout.class.getName());
      }

      @Override
      public boolean a(ViewGroup var1, View var2, AccessibilityEvent var3) {
         boolean var4;
         if (!DrawerLayout.b && !DrawerLayout.l(var2)) {
            var4 = false;
         } else {
            var4 = super.a(var1, var2, var3);
         }

         return var4;
      }

      @Override
      public boolean d(View var1, AccessibilityEvent var2) {
         boolean var4;
         if (var2.getEventType() == 32) {
            List var5 = var2.getText();
            View var6 = this.a.c();
            if (var6 != null) {
               int var3 = this.a.e(var6);
               CharSequence var7 = this.a.b(var3);
               if (var7 != null) {
                  var5.add(var7);
               }
            }

            var4 = true;
         } else {
            var4 = super.d(var1, var2);
         }

         return var4;
      }
   }

   static final class ChildAccessibilityDelegate extends AccessibilityDelegateCompat {
      @Override
      public void a(View var1, AccessibilityNodeInfoCompat var2) {
         super.a(var1, var2);
         if (!DrawerLayout.l(var1)) {
            var2.c((View)null);
         }
      }
   }

   public interface DrawerListener {
      void a(int var1);

      void a(View var1);

      void a(View var1, float var2);

      void b(View var1);
   }

   public static class LayoutParams extends MarginLayoutParams {
      public int a = 0;
      float b;
      boolean c;
      int d;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, DrawerLayout.a);
         this.a = var3.getInt(0, 0);
         var3.recycle();
      }

      public LayoutParams(DrawerLayout.LayoutParams var1) {
         super(var1);
         this.a = var1.a;
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
      }
   }

   protected static class SavedState extends AbsSavedState {
      public static final Creator<DrawerLayout.SavedState> CREATOR = new ClassLoaderCreator<DrawerLayout.SavedState>() {
         public DrawerLayout.SavedState a(Parcel var1) {
            return new DrawerLayout.SavedState(var1, null);
         }

         public DrawerLayout.SavedState a(Parcel var1, ClassLoader var2) {
            return new DrawerLayout.SavedState(var1, var2);
         }

         public DrawerLayout.SavedState[] a(int var1) {
            return new DrawerLayout.SavedState[var1];
         }
      };
      int a = 0;
      int b;
      int c;
      int e;
      int f;

      public SavedState(Parcel var1, ClassLoader var2) {
         super(var1, var2);
         this.a = var1.readInt();
         this.b = var1.readInt();
         this.c = var1.readInt();
         this.e = var1.readInt();
         this.f = var1.readInt();
      }

      public SavedState(Parcelable var1) {
         super(var1);
      }

      @Override
      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeInt(this.a);
         var1.writeInt(this.b);
         var1.writeInt(this.c);
         var1.writeInt(this.e);
         var1.writeInt(this.f);
      }
   }

   private class ViewDragCallback extends ViewDragHelper.Callback {
      final DrawerLayout a;
      private final int b;
      private ViewDragHelper c;
      private final Runnable d;

      ViewDragCallback(DrawerLayout var1, int var2) {
         this.a = var1;
         this.d = new Runnable(this) {
            final DrawerLayout.ViewDragCallback a;

            {
               this.a = var1;
            }

            @Override
            public void run() {
               this.a.b();
            }
         };
         this.b = var2;
      }

      private void c() {
         byte var1 = 3;
         if (this.b == 3) {
            var1 = 5;
         }

         View var2 = this.a.c(var1);
         if (var2 != null) {
            this.a.i(var2);
         }
      }

      @Override
      public int a(View var1, int var2, int var3) {
         return var1.getTop();
      }

      public void a() {
         this.a.removeCallbacks(this.d);
      }

      @Override
      public void a(int var1) {
         this.a.a(this.b, var1, this.c.c());
      }

      @Override
      public void a(int var1, int var2) {
         this.a.postDelayed(this.d, 160L);
      }

      public void a(ViewDragHelper var1) {
         this.c = var1;
      }

      @Override
      public void a(View var1, float var2, float var3) {
         var3 = this.a.d(var1);
         int var6 = var1.getWidth();
         int var4;
         if (this.a.a(var1, 3)) {
            if (!(var2 > 0.0F) && (var2 != 0.0F || !(var3 > 0.5F))) {
               var4 = -var6;
            } else {
               var4 = 0;
            }
         } else {
            label20: {
               int var5 = this.a.getWidth();
               if (!(var2 < 0.0F)) {
                  var4 = var5;
                  if (var2 != 0.0F) {
                     break label20;
                  }

                  var4 = var5;
                  if (!(var3 > 0.5F)) {
                     break label20;
                  }
               }

               var4 = var5 - var6;
            }
         }

         this.c.a(var4, var1.getTop());
         this.a.invalidate();
      }

      @Override
      public void a(View var1, int var2, int var3, int var4, int var5) {
         var3 = var1.getWidth();
         float var6;
         if (this.a.a(var1, 3)) {
            var6 = (float)(var3 + var2) / var3;
         } else {
            var6 = (float)(this.a.getWidth() - var2) / var3;
         }

         this.a.b(var1, var6);
         byte var7;
         if (var6 == 0.0F) {
            var7 = 4;
         } else {
            var7 = 0;
         }

         var1.setVisibility(var7);
         this.a.invalidate();
      }

      @Override
      public boolean a(View var1, int var2) {
         boolean var3;
         if (this.a.g(var1) && this.a.a(var1, this.b) && this.a.a(var1) == 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         return var3;
      }

      @Override
      public int b(View var1) {
         int var2;
         if (this.a.g(var1)) {
            var2 = var1.getWidth();
         } else {
            var2 = 0;
         }

         return var2;
      }

      @Override
      public int b(View var1, int var2, int var3) {
         if (this.a.a(var1, 3)) {
            var2 = Math.max(-var1.getWidth(), Math.min(var2, 0));
         } else {
            var3 = this.a.getWidth();
            var2 = Math.max(var3 - var1.getWidth(), Math.min(var2, var3));
         }

         return var2;
      }

      void b() {
         int var2 = 0;
         int var3 = this.c.b();
         boolean var1;
         if (this.b == 3) {
            var1 = true;
         } else {
            var1 = false;
         }

         View var4;
         if (var1) {
            var4 = this.a.c(3);
            if (var4 != null) {
               var2 = -var4.getWidth();
            }

            var2 += var3;
         } else {
            var4 = this.a.c(5);
            var2 = this.a.getWidth();
            var2 -= var3;
         }

         if (var4 != null && (var1 && var4.getLeft() < var2 || !var1 && var4.getLeft() > var2) && this.a.a(var4) == 0) {
            DrawerLayout.LayoutParams var5 = (DrawerLayout.LayoutParams)var4.getLayoutParams();
            this.c.a(var4, var2, var4.getTop());
            var5.c = true;
            this.a.invalidate();
            this.c();
            this.a.d();
         }
      }

      @Override
      public void b(int var1, int var2) {
         View var3;
         if ((var1 & 1) == 1) {
            var3 = this.a.c(3);
         } else {
            var3 = this.a.c(5);
         }

         if (var3 != null && this.a.a(var3) == 0) {
            this.c.a(var3, var2);
         }
      }

      @Override
      public void b(View var1, int var2) {
         ((DrawerLayout.LayoutParams)var1.getLayoutParams()).c = false;
         this.c();
      }

      @Override
      public boolean b(int var1) {
         return false;
      }
   }
}
