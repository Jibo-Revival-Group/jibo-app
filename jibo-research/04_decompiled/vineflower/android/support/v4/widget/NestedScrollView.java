package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.NestedScrollingChild2;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import java.util.ArrayList;

public class NestedScrollView extends FrameLayout implements NestedScrollingChild2, NestedScrollingParent {
   private static final NestedScrollView.AccessibilityDelegate w = new NestedScrollView.AccessibilityDelegate();
   private static final int[] x = new int[]{16843130};
   private float A;
   private NestedScrollView.OnScrollChangeListener B;
   private long a;
   private final Rect b = new Rect();
   private OverScroller c;
   private EdgeEffect d;
   private EdgeEffect e;
   private int f;
   private boolean g = true;
   private boolean h = false;
   private View i = null;
   private boolean j = false;
   private VelocityTracker k;
   private boolean l;
   private boolean m = true;
   private int n;
   private int o;
   private int p;
   private int q = -1;
   private final int[] r = new int[2];
   private final int[] s = new int[2];
   private int t;
   private int u;
   private NestedScrollView.SavedState v;
   private final NestedScrollingParentHelper y;
   private final NestedScrollingChildHelper z;

   public NestedScrollView(Context var1) {
      this(var1, null);
   }

   public NestedScrollView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public NestedScrollView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a();
      TypedArray var4 = var1.obtainStyledAttributes(var2, x, var3, 0);
      this.setFillViewport(var4.getBoolean(0, false));
      var4.recycle();
      this.y = new NestedScrollingParentHelper(this);
      this.z = new NestedScrollingChildHelper(this);
      this.setNestedScrollingEnabled(true);
      ViewCompat.a(this, w);
   }

   private View a(boolean var1, int var2, int var3) {
      ArrayList var12 = this.getFocusables(2);
      View var11 = null;
      boolean var4 = false;
      int var8 = var12.size();
      int var6 = 0;

      while (var6 < var8) {
         View var10;
         label59: {
            var10 = (View)var12.get(var6);
            int var9 = var10.getTop();
            int var7 = var10.getBottom();
            if (var2 < var7 && var9 < var3) {
               boolean var5;
               if (var2 < var9 && var7 < var3) {
                  var5 = true;
               } else {
                  var5 = false;
               }

               if (var11 == null) {
                  var4 = var5;
                  break label59;
               }

               boolean var13;
               if ((!var1 || var9 >= var11.getTop()) && (var1 || var7 <= var11.getBottom())) {
                  var13 = false;
               } else {
                  var13 = true;
               }

               if (var4) {
                  if (var5 && var13) {
                     break label59;
                  }
               } else {
                  if (var5) {
                     var4 = true;
                     break label59;
                  }

                  if (var13) {
                     break label59;
                  }
               }
            }

            var10 = var11;
         }

         var6++;
         var11 = var10;
      }

      return var11;
   }

   private void a() {
      this.c = new OverScroller(this.getContext());
      this.setFocusable(true);
      this.setDescendantFocusability(262144);
      this.setWillNotDraw(false);
      ViewConfiguration var1 = ViewConfiguration.get(this.getContext());
      this.n = var1.getScaledTouchSlop();
      this.o = var1.getScaledMinimumFlingVelocity();
      this.p = var1.getScaledMaximumFlingVelocity();
   }

   private void a(MotionEvent var1) {
      int var2 = var1.getActionIndex();
      if (var1.getPointerId(var2) == this.q) {
         byte var3;
         if (var2 == 0) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         this.f = (int)var1.getY(var3);
         this.q = var1.getPointerId(var3);
         if (this.k != null) {
            this.k.clear();
         }
      }
   }

   private boolean a(int var1, int var2, int var3) {
      boolean var7 = false;
      int var5 = this.getHeight();
      int var4 = this.getScrollY();
      var5 = var4 + var5;
      boolean var6;
      if (var1 == 33) {
         var6 = true;
      } else {
         var6 = false;
      }

      View var9 = this.a(var6, var2, var3);
      Object var8 = var9;
      if (var9 == null) {
         var8 = this;
      }

      if (var2 >= var4 && var3 <= var5) {
         var6 = var7;
      } else {
         if (var6) {
            var2 -= var4;
         } else {
            var2 = var3 - var5;
         }

         this.g(var2);
         var6 = true;
      }

      if (var8 != this.findFocus()) {
         var8.requestFocus(var1);
      }

      return var6;
   }

   private boolean a(Rect var1, boolean var2) {
      int var3 = this.a(var1);
      boolean var4;
      if (var3 != 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      if (var4) {
         if (var2) {
            this.scrollBy(0, var3);
         } else {
            this.b(0, var3);
         }
      }

      return var4;
   }

   private boolean a(View var1) {
      boolean var2 = false;
      if (!this.a(var1, 0, this.getHeight())) {
         var2 = true;
      }

      return var2;
   }

   private boolean a(View var1, int var2, int var3) {
      var1.getDrawingRect(this.b);
      this.offsetDescendantRectToMyCoords(var1, this.b);
      boolean var4;
      if (this.b.bottom + var2 >= this.getScrollY() && this.b.top - var2 <= this.getScrollY() + var3) {
         var4 = true;
      } else {
         var4 = false;
      }

      return var4;
   }

   private static boolean a(View var0, View var1) {
      boolean var2 = true;
      if (var0 != var1) {
         ViewParent var3 = var0.getParent();
         if (var3 instanceof ViewGroup && a((View)var3, var1)) {
            var2 = true;
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   private static int b(int var0, int var1, int var2) {
      int var3;
      if (var1 < var2 && var0 >= 0) {
         var3 = var0;
         if (var1 + var0 > var2) {
            var3 = var2 - var1;
         }
      } else {
         var3 = 0;
      }

      return var3;
   }

   private void b(View var1) {
      var1.getDrawingRect(this.b);
      this.offsetDescendantRectToMyCoords(var1, this.b);
      int var2 = this.a(this.b);
      if (var2 != 0) {
         this.scrollBy(0, var2);
      }
   }

   private boolean b() {
      boolean var3 = false;
      View var4 = this.getChildAt(0);
      boolean var2 = var3;
      if (var4 != null) {
         int var1 = var4.getHeight();
         var2 = var3;
         if (this.getHeight() < var1 + this.getPaddingTop() + this.getPaddingBottom()) {
            var2 = true;
         }
      }

      return var2;
   }

   private void c() {
      if (this.k == null) {
         this.k = VelocityTracker.obtain();
      } else {
         this.k.clear();
      }
   }

   private void d() {
      if (this.k == null) {
         this.k = VelocityTracker.obtain();
      }
   }

   private boolean d(int var1, int var2) {
      boolean var5 = false;
      boolean var4 = var5;
      if (this.getChildCount() > 0) {
         int var3 = this.getScrollY();
         View var6 = this.getChildAt(0);
         var4 = var5;
         if (var2 >= var6.getTop() - var3) {
            var4 = var5;
            if (var2 < var6.getBottom() - var3) {
               var4 = var5;
               if (var1 >= var6.getLeft()) {
                  var4 = var5;
                  if (var1 < var6.getRight()) {
                     var4 = true;
                  }
               }
            }
         }
      }

      return var4;
   }

   private void e() {
      if (this.k != null) {
         this.k.recycle();
         this.k = null;
      }
   }

   private void f() {
      this.j = false;
      this.e();
      this.a(0);
      if (this.d != null) {
         this.d.onRelease();
         this.e.onRelease();
      }
   }

   private void g() {
      if (this.getOverScrollMode() != 2) {
         if (this.d == null) {
            Context var1 = this.getContext();
            this.d = new EdgeEffect(var1);
            this.e = new EdgeEffect(var1);
         }
      } else {
         this.d = null;
         this.e = null;
      }
   }

   private void g(int var1) {
      if (var1 != 0) {
         if (this.m) {
            this.b(0, var1);
         } else {
            this.scrollBy(0, var1);
         }
      }
   }

   private float getVerticalScrollFactorCompat() {
      if (this.A == 0.0F) {
         TypedValue var2 = new TypedValue();
         Context var1 = this.getContext();
         if (!var1.getTheme().resolveAttribute(16842829, var2, true)) {
            throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
         }

         this.A = var2.getDimension(var1.getResources().getDisplayMetrics());
      }

      return this.A;
   }

   private void h(int var1) {
      int var2 = this.getScrollY();
      boolean var3;
      if (var2 <= 0 && var1 <= 0 || var2 >= this.getScrollRange() && var1 >= 0) {
         var3 = false;
      } else {
         var3 = true;
      }

      if (!this.dispatchNestedPreFling(0.0F, var1)) {
         this.dispatchNestedFling(0.0F, var1, var3);
         this.f(var1);
      }
   }

   protected int a(Rect var1) {
      int var2 = 0;
      if (this.getChildCount() != 0) {
         int var5 = this.getHeight();
         var2 = this.getScrollY();
         int var4 = var2 + var5;
         int var6 = this.getVerticalFadingEdgeLength();
         int var3 = var2;
         if (var1.top > 0) {
            var3 = var2 + var6;
         }

         var2 = var4;
         if (var1.bottom < this.getChildAt(0).getHeight()) {
            var2 = var4 - var6;
         }

         if (var1.bottom > var2 && var1.top > var3) {
            if (var1.height() > var5) {
               var3 = var1.top - var3 + 0;
            } else {
               var3 = var1.bottom - var2 + 0;
            }

            var2 = Math.min(var3, this.getChildAt(0).getBottom() - var2);
         } else if (var1.top < var3 && var1.bottom < var2) {
            if (var1.height() > var5) {
               var2 = 0 - (var2 - var1.bottom);
            } else {
               var2 = 0 - (var3 - var1.top);
            }

            var2 = Math.max(var2, -this.getScrollY());
         } else {
            var2 = 0;
         }
      }

      return var2;
   }

   public void a(int var1) {
      this.z.c(var1);
   }

   public boolean a(int var1, int var2) {
      return this.z.a(var1, var2);
   }

   boolean a(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9) {
      int var12 = this.getOverScrollMode();
      boolean var10;
      if (this.computeHorizontalScrollRange() > this.computeHorizontalScrollExtent()) {
         var10 = true;
      } else {
         var10 = false;
      }

      boolean var11;
      if (this.computeVerticalScrollRange() > this.computeVerticalScrollExtent()) {
         var11 = true;
      } else {
         var11 = false;
      }

      if (var12 != 0 && (var12 != 1 || !var10)) {
         var10 = false;
      } else {
         var10 = true;
      }

      if (var12 != 0 && (var12 != 1 || !var11)) {
         var11 = false;
      } else {
         var11 = true;
      }

      var1 = var3 + var1;
      if (!var10) {
         var7 = 0;
      }

      var2 = var4 + var2;
      if (!var11) {
         var8 = 0;
      }

      var4 = -var7;
      var7 += var5;
      var3 = -var8;
      var5 = var8 + var6;
      if (var1 > var7) {
         var9 = true;
         var1 = var7;
      } else if (var1 < var4) {
         var9 = true;
         var1 = var4;
      } else {
         var9 = false;
      }

      boolean var13;
      if (var2 > var5) {
         var13 = true;
         var2 = var5;
      } else if (var2 < var3) {
         var13 = true;
         var2 = var3;
      } else {
         var13 = false;
      }

      if (var13 && !this.b(1)) {
         this.c.springBack(var1, var2, 0, 0, 0, this.getScrollRange());
      }

      this.onOverScrolled(var1, var2, var9, var13);
      if (!var9 && !var13) {
         var9 = false;
      } else {
         var9 = true;
      }

      return var9;
   }

   public boolean a(int var1, int var2, int var3, int var4, int[] var5, int var6) {
      return this.z.a(var1, var2, var3, var4, var5, var6);
   }

   public boolean a(int var1, int var2, int[] var3, int[] var4, int var5) {
      return this.z.a(var1, var2, var3, var4, var5);
   }

   public boolean a(KeyEvent var1) {
      short var2 = 33;
      boolean var4 = false;
      this.b.setEmpty();
      boolean var3;
      if (!this.b()) {
         var3 = var4;
         if (this.isFocused()) {
            var3 = var4;
            if (var1.getKeyCode() != 4) {
               View var5 = this.findFocus();
               View var6 = var5;
               if (var5 == this) {
                  var6 = null;
               }

               View var7 = FocusFinder.getInstance().findNextFocus(this, var6, 130);
               if (var7 != null && var7 != this && var7.requestFocus(130)) {
                  var3 = true;
               } else {
                  var3 = false;
               }
            }
         }
      } else {
         var3 = var4;
         if (var1.getAction() == 0) {
            switch (var1.getKeyCode()) {
               case 19:
                  if (!var1.isAltPressed()) {
                     var3 = this.e(33);
                  } else {
                     var3 = this.d(33);
                  }
                  break;
               case 20:
                  if (!var1.isAltPressed()) {
                     var3 = this.e(130);
                  } else {
                     var3 = this.d(130);
                  }
                  break;
               case 62:
                  if (!var1.isShiftPressed()) {
                     var2 = 130;
                  }

                  this.c(var2);
                  var3 = var4;
                  break;
               default:
                  var3 = var4;
            }
         }
      }

      return var3;
   }

   public void addView(View var1) {
      if (this.getChildCount() > 0) {
         throw new IllegalStateException("ScrollView can host only one direct child");
      }

      super.addView(var1);
   }

   public void addView(View var1, int var2) {
      if (this.getChildCount() > 0) {
         throw new IllegalStateException("ScrollView can host only one direct child");
      }

      super.addView(var1, var2);
   }

   public void addView(View var1, int var2, LayoutParams var3) {
      if (this.getChildCount() > 0) {
         throw new IllegalStateException("ScrollView can host only one direct child");
      }

      super.addView(var1, var2, var3);
   }

   public void addView(View var1, LayoutParams var2) {
      if (this.getChildCount() > 0) {
         throw new IllegalStateException("ScrollView can host only one direct child");
      }

      super.addView(var1, var2);
   }

   public final void b(int var1, int var2) {
      if (this.getChildCount() != 0) {
         if (AnimationUtils.currentAnimationTimeMillis() - this.a > 250L) {
            int var4 = this.getHeight();
            var1 = this.getPaddingBottom();
            int var3 = this.getPaddingTop();
            var3 = Math.max(0, this.getChildAt(0).getHeight() - (var4 - var1 - var3));
            var1 = this.getScrollY();
            var2 = Math.max(0, Math.min(var1 + var2, var3));
            this.c.startScroll(this.getScrollX(), var1, 0, var2 - var1);
            ViewCompat.c(this);
         } else {
            if (!this.c.isFinished()) {
               this.c.abortAnimation();
            }

            this.scrollBy(var1, var2);
         }

         this.a = AnimationUtils.currentAnimationTimeMillis();
      }
   }

   public boolean b(int var1) {
      return this.z.a(var1);
   }

   public final void c(int var1, int var2) {
      this.b(var1 - this.getScrollX(), var2 - this.getScrollY());
   }

   public boolean c(int var1) {
      boolean var2;
      if (var1 == 130) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      int var3 = this.getHeight();
      if (var2) {
         this.b.top = this.getScrollY() + var3;
         var2 = this.getChildCount();
         if (var2 > 0) {
            View var4 = this.getChildAt(var2 - 1);
            if (this.b.top + var3 > var4.getBottom()) {
               this.b.top = var4.getBottom() - var3;
            }
         }
      } else {
         this.b.top = this.getScrollY() - var3;
         if (this.b.top < 0) {
            this.b.top = 0;
         }
      }

      this.b.bottom = this.b.top + var3;
      return this.a(var1, this.b.top, this.b.bottom);
   }

   public int computeHorizontalScrollExtent() {
      return super.computeHorizontalScrollExtent();
   }

   public int computeHorizontalScrollOffset() {
      return super.computeHorizontalScrollOffset();
   }

   public int computeHorizontalScrollRange() {
      return super.computeHorizontalScrollRange();
   }

   public void computeScroll() {
      if (this.c.computeScrollOffset()) {
         this.c.getCurrX();
         int var3 = this.c.getCurrY();
         int var2 = var3 - this.u;
         int var1 = var2;
         if (this.a(0, var2, this.s, null, 1)) {
            var1 = var2 - this.s[1];
         }

         if (var1 != 0) {
            int var4 = this.getScrollRange();
            var2 = this.getScrollY();
            this.a(0, var1, this.getScrollX(), var2, 0, var4, 0, 0, false);
            int var5 = this.getScrollY() - var2;
            if (!this.a(0, var5, 0, var1 - var5, null, 1)) {
               var1 = this.getOverScrollMode();
               boolean var7;
               if (var1 != 0 && (var1 != 1 || var4 <= 0)) {
                  var7 = false;
               } else {
                  var7 = true;
               }

               if (var7) {
                  this.g();
                  if (var3 <= 0 && var2 > 0) {
                     this.d.onAbsorb((int)this.c.getCurrVelocity());
                  } else if (var3 >= var4 && var2 < var4) {
                     this.e.onAbsorb((int)this.c.getCurrVelocity());
                  }
               }
            }
         }

         this.u = var3;
         ViewCompat.c(this);
      } else {
         if (this.b(1)) {
            this.a(1);
         }

         this.u = 0;
      }
   }

   public int computeVerticalScrollExtent() {
      return super.computeVerticalScrollExtent();
   }

   public int computeVerticalScrollOffset() {
      return Math.max(0, super.computeVerticalScrollOffset());
   }

   public int computeVerticalScrollRange() {
      int var2 = this.getChildCount();
      int var1 = this.getHeight() - this.getPaddingBottom() - this.getPaddingTop();
      if (var2 != 0) {
         var2 = this.getChildAt(0).getBottom();
         int var3 = this.getScrollY();
         int var4 = Math.max(0, var2 - var1);
         if (var3 < 0) {
            var1 = var2 - var3;
         } else {
            var1 = var2;
            if (var3 > var4) {
               var1 = var2 + (var3 - var4);
            }
         }
      }

      return var1;
   }

   public boolean d(int var1) {
      boolean var2;
      if (var1 == 130) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      int var3 = this.getHeight();
      this.b.top = 0;
      this.b.bottom = var3;
      if (var2) {
         var2 = this.getChildCount();
         if (var2 > 0) {
            View var4 = this.getChildAt(var2 - 1);
            this.b.bottom = var4.getBottom() + this.getPaddingBottom();
            this.b.top = this.b.bottom - var3;
         }
      }

      return this.a(var1, this.b.top, this.b.bottom);
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

   public boolean dispatchNestedFling(float var1, float var2, boolean var3) {
      return this.z.a(var1, var2, var3);
   }

   public boolean dispatchNestedPreFling(float var1, float var2) {
      return this.z.a(var1, var2);
   }

   public boolean dispatchNestedPreScroll(int var1, int var2, int[] var3, int[] var4) {
      return this.z.a(var1, var2, var3, var4);
   }

   public boolean dispatchNestedScroll(int var1, int var2, int var3, int var4, int[] var5) {
      return this.z.a(var1, var2, var3, var4, var5);
   }

   public void draw(Canvas var1) {
      byte var6 = 0;
      super.draw(var1);
      if (this.d != null) {
         int var9 = this.getScrollY();
         if (!this.d.isFinished()) {
            int var10 = var1.save();
            int var2 = this.getWidth();
            int var8 = this.getHeight();
            int var7 = Math.min(0, var9);
            int var3;
            if (VERSION.SDK_INT >= 21 && !this.getClipToPadding()) {
               var3 = 0;
            } else {
               var2 -= this.getPaddingLeft() + this.getPaddingRight();
               var3 = this.getPaddingLeft() + 0;
            }

            int var5 = var7;
            int var4 = var8;
            if (VERSION.SDK_INT >= 21) {
               var5 = var7;
               var4 = var8;
               if (this.getClipToPadding()) {
                  var4 = var8 - (this.getPaddingTop() + this.getPaddingBottom());
                  var5 = var7 + this.getPaddingTop();
               }
            }

            var1.translate(var3, var5);
            this.d.setSize(var2, var4);
            if (this.d.draw(var1)) {
               ViewCompat.c(this);
            }

            var1.restoreToCount(var10);
         }

         if (!this.e.isFinished()) {
            int var11;
            int var12;
            int var16;
            int var17;
            int var18;
            label40: {
               var18 = var1.save();
               int var13 = this.getWidth();
               var16 = this.getHeight();
               var17 = Math.max(this.getScrollRange(), var9) + var16;
               if (VERSION.SDK_INT >= 21) {
                  var11 = var13;
                  var12 = var6;
                  if (!this.getClipToPadding()) {
                     break label40;
                  }
               }

               var11 = var13 - (this.getPaddingLeft() + this.getPaddingRight());
               var12 = 0 + this.getPaddingLeft();
            }

            int var15 = var17;
            int var14 = var16;
            if (VERSION.SDK_INT >= 21) {
               var15 = var17;
               var14 = var16;
               if (this.getClipToPadding()) {
                  var14 = var16 - (this.getPaddingTop() + this.getPaddingBottom());
                  var15 = var17 - this.getPaddingBottom();
               }
            }

            var1.translate(var12 - var11, var15);
            var1.rotate(180.0F, var11, 0.0F);
            this.e.setSize(var11, var14);
            if (this.e.draw(var1)) {
               ViewCompat.c(this);
            }

            var1.restoreToCount(var18);
         }
      }
   }

   public boolean e(int var1) {
      View var8 = this.findFocus();
      View var7 = var8;
      if (var8 == this) {
         var7 = null;
      }

      var8 = FocusFinder.getInstance().findNextFocus(this, var7, var1);
      int var3 = this.getMaxScrollAmount();
      if (var8 != null && this.a(var8, var3, this.getHeight())) {
         var8.getDrawingRect(this.b);
         this.offsetDescendantRectToMyCoords(var8, this.b);
         this.g(this.a(this.b));
         var8.requestFocus(var1);
      } else {
         int var2;
         if (var1 == 33 && this.getScrollY() < var3) {
            var2 = this.getScrollY();
         } else {
            var2 = var3;
            if (var1 == 130) {
               var2 = var3;
               if (this.getChildCount() > 0) {
                  int var5 = this.getChildAt(0).getBottom();
                  int var4 = this.getScrollY() + this.getHeight() - this.getPaddingBottom();
                  var2 = var3;
                  if (var5 - var4 < var3) {
                     var2 = var5 - var4;
                  }
               }
            }
         }

         if (var2 == 0) {
            return false;
         }

         if (var1 != 130) {
            var2 = -var2;
         }

         this.g(var2);
      }

      if (var7 != null && var7.isFocused() && this.a(var7)) {
         var1 = this.getDescendantFocusability();
         this.setDescendantFocusability(131072);
         this.requestFocus();
         this.setDescendantFocusability(var1);
      }

      return true;
   }

   public void f(int var1) {
      if (this.getChildCount() > 0) {
         this.a(2, 1);
         this.c.fling(this.getScrollX(), this.getScrollY(), 0, var1, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
         this.u = this.getScrollY();
         ViewCompat.c(this);
      }
   }

   protected float getBottomFadingEdgeStrength() {
      float var1;
      if (this.getChildCount() == 0) {
         var1 = 0.0F;
      } else {
         int var2 = this.getVerticalFadingEdgeLength();
         int var3 = this.getHeight();
         int var4 = this.getPaddingBottom();
         var3 = this.getChildAt(0).getBottom() - this.getScrollY() - (var3 - var4);
         if (var3 < var2) {
            var1 = (float)var3 / var2;
         } else {
            var1 = 1.0F;
         }
      }

      return var1;
   }

   public int getMaxScrollAmount() {
      return (int)(0.5F * this.getHeight());
   }

   public int getNestedScrollAxes() {
      return this.y.a();
   }

   int getScrollRange() {
      int var1 = 0;
      if (this.getChildCount() > 0) {
         var1 = Math.max(0, this.getChildAt(0).getHeight() - (this.getHeight() - this.getPaddingBottom() - this.getPaddingTop()));
      }

      return var1;
   }

   protected float getTopFadingEdgeStrength() {
      float var1;
      if (this.getChildCount() == 0) {
         var1 = 0.0F;
      } else {
         int var2 = this.getVerticalFadingEdgeLength();
         int var3 = this.getScrollY();
         if (var3 < var2) {
            var1 = (float)var3 / var2;
         } else {
            var1 = 1.0F;
         }
      }

      return var1;
   }

   public boolean hasNestedScrollingParent() {
      return this.z.b();
   }

   @Override
   public boolean isNestedScrollingEnabled() {
      return this.z.a();
   }

   protected void measureChild(View var1, int var2, int var3) {
      LayoutParams var4 = var1.getLayoutParams();
      var1.measure(getChildMeasureSpec(var2, this.getPaddingLeft() + this.getPaddingRight(), var4.width), MeasureSpec.makeMeasureSpec(0, 0));
   }

   protected void measureChildWithMargins(View var1, int var2, int var3, int var4, int var5) {
      MarginLayoutParams var6 = (MarginLayoutParams)var1.getLayoutParams();
      var3 = getChildMeasureSpec(var2, this.getPaddingLeft() + this.getPaddingRight() + var6.leftMargin + var6.rightMargin + var3, var6.width);
      var2 = var6.topMargin;
      var1.measure(var3, MeasureSpec.makeMeasureSpec(var6.bottomMargin + var2, 0));
   }

   public void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.h = false;
   }

   public boolean onGenericMotionEvent(MotionEvent var1) {
      boolean var8 = false;
      boolean var7 = var8;
      if ((var1.getSource() & 2) != 0) {
         switch (var1.getAction()) {
            case 8:
               var7 = var8;
               if (!this.j) {
                  float var2 = var1.getAxisValue(9);
                  var7 = var8;
                  if (var2 != 0.0F) {
                     int var3 = (int)(var2 * this.getVerticalScrollFactorCompat());
                     int var4 = this.getScrollRange();
                     int var6 = this.getScrollY();
                     int var5 = var6 - var3;
                     if (var5 < 0) {
                        var3 = 0;
                     } else {
                        var3 = var4;
                        if (var5 <= var4) {
                           var3 = var5;
                        }
                     }

                     var7 = var8;
                     if (var3 != var6) {
                        super.scrollTo(this.getScrollX(), var3);
                        var7 = true;
                     }
                  }
               }
               break;
            default:
               var7 = var8;
         }
      }

      return var7;
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      boolean var4 = true;
      boolean var5 = true;
      int var2 = var1.getAction();
      if (var2 == 2 && this.j) {
         var4 = var5;
      } else {
         switch (var2 & 0xFF) {
            case 0:
               var2 = (int)var1.getY();
               if (!this.d((int)var1.getX(), var2)) {
                  this.j = false;
                  this.e();
               } else {
                  this.f = var2;
                  this.q = var1.getPointerId(0);
                  this.c();
                  this.k.addMovement(var1);
                  this.c.computeScrollOffset();
                  if (this.c.isFinished()) {
                     var4 = false;
                  }

                  this.j = var4;
                  this.a(2, 0);
               }
               break;
            case 1:
            case 3:
               this.j = false;
               this.q = -1;
               this.e();
               if (this.c.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
                  ViewCompat.c(this);
               }

               this.a(0);
               break;
            case 2:
               var2 = this.q;
               if (var2 != -1) {
                  int var3 = var1.findPointerIndex(var2);
                  if (var3 == -1) {
                     Log.e("NestedScrollView", "Invalid pointerId=" + var2 + " in onInterceptTouchEvent");
                  } else {
                     var2 = (int)var1.getY(var3);
                     if (Math.abs(var2 - this.f) > this.n && (this.getNestedScrollAxes() & 2) == 0) {
                        this.j = true;
                        this.f = var2;
                        this.d();
                        this.k.addMovement(var1);
                        this.t = 0;
                        ViewParent var6 = this.getParent();
                        if (var6 != null) {
                           var6.requestDisallowInterceptTouchEvent(true);
                        }
                     }
                  }
               }
            case 4:
            case 5:
            default:
               break;
            case 6:
               this.a(var1);
         }

         var4 = this.j;
      }

      return var4;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      this.g = false;
      if (this.i != null && a(this.i, this)) {
         this.b(this.i);
      }

      this.i = null;
      if (!this.h) {
         if (this.v != null) {
            this.scrollTo(this.getScrollX(), this.v.a);
            this.v = null;
         }

         if (this.getChildCount() > 0) {
            var2 = this.getChildAt(0).getMeasuredHeight();
         } else {
            var2 = 0;
         }

         var2 = Math.max(0, var2 - (var5 - var3 - this.getPaddingBottom() - this.getPaddingTop()));
         if (this.getScrollY() > var2) {
            this.scrollTo(this.getScrollX(), var2);
         } else if (this.getScrollY() < 0) {
            this.scrollTo(this.getScrollX(), 0);
         }
      }

      this.scrollTo(this.getScrollX(), this.getScrollY());
      this.h = true;
   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      if (this.l && MeasureSpec.getMode(var2) != 0 && this.getChildCount() > 0) {
         View var4 = this.getChildAt(0);
         var2 = this.getMeasuredHeight();
         if (var4.getMeasuredHeight() < var2) {
            android.widget.FrameLayout.LayoutParams var3 = (android.widget.FrameLayout.LayoutParams)var4.getLayoutParams();
            var4.measure(
               getChildMeasureSpec(var1, this.getPaddingLeft() + this.getPaddingRight(), var3.width),
               MeasureSpec.makeMeasureSpec(var2 - this.getPaddingTop() - this.getPaddingBottom(), 1073741824)
            );
         }
      }
   }

   @Override
   public boolean onNestedFling(View var1, float var2, float var3, boolean var4) {
      if (!var4) {
         this.h((int)var3);
         var4 = true;
      } else {
         var4 = false;
      }

      return var4;
   }

   @Override
   public boolean onNestedPreFling(View var1, float var2, float var3) {
      return this.dispatchNestedPreFling(var2, var3);
   }

   @Override
   public void onNestedPreScroll(View var1, int var2, int var3, int[] var4) {
      this.dispatchNestedPreScroll(var2, var3, var4, null);
   }

   @Override
   public void onNestedScroll(View var1, int var2, int var3, int var4, int var5) {
      var2 = this.getScrollY();
      this.scrollBy(0, var5);
      var2 = this.getScrollY() - var2;
      this.dispatchNestedScroll(0, var2, 0, var5 - var2, null);
   }

   @Override
   public void onNestedScrollAccepted(View var1, View var2, int var3) {
      this.y.a(var1, var2, var3);
      this.startNestedScroll(2);
   }

   protected void onOverScrolled(int var1, int var2, boolean var3, boolean var4) {
      super.scrollTo(var1, var2);
   }

   protected boolean onRequestFocusInDescendants(int var1, Rect var2) {
      boolean var4 = false;
      int var3;
      if (var1 == 2) {
         var3 = 130;
      } else {
         var3 = var1;
         if (var1 == 1) {
            var3 = 33;
         }
      }

      View var5;
      if (var2 == null) {
         var5 = FocusFinder.getInstance().findNextFocus(this, null, var3);
      } else {
         var5 = FocusFinder.getInstance().findNextFocusFromRect(this, var2, var3);
      }

      if (var5 != null && !this.a(var5)) {
         var4 = var5.requestFocus(var3, var2);
      }

      return var4;
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if (!(var1 instanceof NestedScrollView.SavedState)) {
         super.onRestoreInstanceState(var1);
      } else {
         NestedScrollView.SavedState var2 = (NestedScrollView.SavedState)var1;
         super.onRestoreInstanceState(var2.getSuperState());
         this.v = var2;
         this.requestLayout();
      }
   }

   protected Parcelable onSaveInstanceState() {
      NestedScrollView.SavedState var1 = new NestedScrollView.SavedState(super.onSaveInstanceState());
      var1.a = this.getScrollY();
      return var1;
   }

   protected void onScrollChanged(int var1, int var2, int var3, int var4) {
      super.onScrollChanged(var1, var2, var3, var4);
      if (this.B != null) {
         this.B.a(this, var1, var2, var3, var4);
      }
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      View var5 = this.findFocus();
      if (var5 != null && this != var5 && this.a(var5, 0, var4)) {
         var5.getDrawingRect(this.b);
         this.offsetDescendantRectToMyCoords(var5, this.b);
         this.g(this.a(this.b));
      }
   }

   @Override
   public boolean onStartNestedScroll(View var1, View var2, int var3) {
      boolean var4;
      if ((var3 & 2) != 0) {
         var4 = true;
      } else {
         var4 = false;
      }

      return var4;
   }

   @Override
   public void onStopNestedScroll(View var1) {
      this.y.a(var1);
      this.stopNestedScroll();
   }

   public boolean onTouchEvent(MotionEvent var1) {
      this.d();
      MotionEvent var9 = MotionEvent.obtain(var1);
      int var2 = var1.getActionMasked();
      if (var2 == 0) {
         this.t = 0;
      }

      var9.offsetLocation(0.0F, this.t);
      switch (var2) {
         case 0:
            if (this.getChildCount() == 0) {
               return false;
            }

            boolean var8;
            if (!this.c.isFinished()) {
               var8 = true;
            } else {
               var8 = false;
            }

            this.j = var8;
            if (var8) {
               ViewParent var21 = this.getParent();
               if (var21 != null) {
                  var21.requestDisallowInterceptTouchEvent(true);
               }
            }

            if (!this.c.isFinished()) {
               this.c.abortAnimation();
            }

            this.f = (int)var1.getY();
            this.q = var1.getPointerId(0);
            this.a(2, 0);
            break;
         case 1:
            VelocityTracker var11 = this.k;
            var11.computeCurrentVelocity(1000, this.p);
            var2 = (int)var11.getYVelocity(this.q);
            if (Math.abs(var2) > this.o) {
               this.h(-var2);
            } else if (this.c.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
               ViewCompat.c(this);
            }

            this.q = -1;
            this.f();
            break;
         case 2:
            int var4 = var1.findPointerIndex(this.q);
            if (var4 == -1) {
               Log.e("NestedScrollView", "Invalid pointerId=" + this.q + " in onTouchEvent");
            } else {
               int var5 = (int)var1.getY(var4);
               var2 = this.f - var5;
               int var3 = var2;
               if (this.a(0, var2, this.s, this.r, 0)) {
                  var3 = var2 - this.s[1];
                  var9.offsetLocation(0.0F, this.r[1]);
                  this.t = this.t + this.r[1];
               }

               var2 = var3;
               if (!this.j) {
                  var2 = var3;
                  if (Math.abs(var3) > this.n) {
                     ViewParent var10 = this.getParent();
                     if (var10 != null) {
                        var10.requestDisallowInterceptTouchEvent(true);
                     }

                     this.j = true;
                     if (var3 > 0) {
                        var2 = var3 - this.n;
                     } else {
                        var2 = var3 + this.n;
                     }
                  }
               }

               if (this.j) {
                  this.f = var5 - this.r[1];
                  int var6 = this.getScrollY();
                  var5 = this.getScrollRange();
                  var3 = this.getOverScrollMode();
                  boolean var17;
                  if (var3 != 0 && (var3 != 1 || var5 <= 0)) {
                     var17 = 0;
                  } else {
                     var17 = 1;
                  }

                  if (this.a(0, var2, 0, this.getScrollY(), 0, var5, 0, 0, true) && !this.b(0)) {
                     this.k.clear();
                  }

                  int var7 = this.getScrollY() - var6;
                  if (this.a(0, var7, 0, var2 - var7, this.r, 0)) {
                     this.f = this.f - this.r[1];
                     var9.offsetLocation(0.0F, this.r[1]);
                     this.t = this.t + this.r[1];
                  } else if (var17) {
                     this.g();
                     var17 = var6 + var2;
                     if (var17 < 0) {
                        EdgeEffectCompat.a(this.d, (float)var2 / this.getHeight(), var1.getX(var4) / this.getWidth());
                        if (!this.e.isFinished()) {
                           this.e.onRelease();
                        }
                     } else if (var17 > var5) {
                        EdgeEffectCompat.a(this.e, (float)var2 / this.getHeight(), 1.0F - var1.getX(var4) / this.getWidth());
                        if (!this.d.isFinished()) {
                           this.d.onRelease();
                        }
                     }

                     if (this.d != null && (!this.d.isFinished() || !this.e.isFinished())) {
                        ViewCompat.c(this);
                     }
                  }
               }
            }
            break;
         case 3:
            if (this.j && this.getChildCount() > 0 && this.c.springBack(this.getScrollX(), this.getScrollY(), 0, 0, 0, this.getScrollRange())) {
               ViewCompat.c(this);
            }

            this.q = -1;
            this.f();
         case 4:
         default:
            break;
         case 5:
            var2 = var1.getActionIndex();
            this.f = (int)var1.getY(var2);
            this.q = var1.getPointerId(var2);
            break;
         case 6:
            this.a(var1);
            this.f = (int)var1.getY(var1.findPointerIndex(this.q));
      }

      if (this.k != null) {
         this.k.addMovement(var9);
      }

      var9.recycle();
      return true;
   }

   public void requestChildFocus(View var1, View var2) {
      if (!this.g) {
         this.b(var2);
      } else {
         this.i = var2;
      }

      super.requestChildFocus(var1, var2);
   }

   public boolean requestChildRectangleOnScreen(View var1, Rect var2, boolean var3) {
      var2.offset(var1.getLeft() - var1.getScrollX(), var1.getTop() - var1.getScrollY());
      return this.a(var2, var3);
   }

   public void requestDisallowInterceptTouchEvent(boolean var1) {
      if (var1) {
         this.e();
      }

      super.requestDisallowInterceptTouchEvent(var1);
   }

   public void requestLayout() {
      this.g = true;
      super.requestLayout();
   }

   public void scrollTo(int var1, int var2) {
      if (this.getChildCount() > 0) {
         View var3 = this.getChildAt(0);
         var1 = b(var1, this.getWidth() - this.getPaddingRight() - this.getPaddingLeft(), var3.getWidth());
         var2 = b(var2, this.getHeight() - this.getPaddingBottom() - this.getPaddingTop(), var3.getHeight());
         if (var1 != this.getScrollX() || var2 != this.getScrollY()) {
            super.scrollTo(var1, var2);
         }
      }
   }

   public void setFillViewport(boolean var1) {
      if (var1 != this.l) {
         this.l = var1;
         this.requestLayout();
      }
   }

   public void setNestedScrollingEnabled(boolean var1) {
      this.z.a(var1);
   }

   public void setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener var1) {
      this.B = var1;
   }

   public void setSmoothScrollingEnabled(boolean var1) {
      this.m = var1;
   }

   public boolean shouldDelayChildPressedState() {
      return true;
   }

   public boolean startNestedScroll(int var1) {
      return this.z.b(var1);
   }

   @Override
   public void stopNestedScroll() {
      this.z.c();
   }

   static class AccessibilityDelegate extends AccessibilityDelegateCompat {
      @Override
      public void a(View var1, AccessibilityNodeInfoCompat var2) {
         super.a(var1, var2);
         NestedScrollView var4 = (NestedScrollView)var1;
         var2.b(ScrollView.class.getName());
         if (var4.isEnabled()) {
            int var3 = var4.getScrollRange();
            if (var3 > 0) {
               var2.k(true);
               if (var4.getScrollY() > 0) {
                  var2.a(8192);
               }

               if (var4.getScrollY() < var3) {
                  var2.a(4096);
               }
            }
         }
      }

      @Override
      public void a(View var1, AccessibilityEvent var2) {
         super.a(var1, var2);
         NestedScrollView var4 = (NestedScrollView)var1;
         var2.setClassName(ScrollView.class.getName());
         boolean var3;
         if (var4.getScrollRange() > 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         var2.setScrollable(var3);
         var2.setScrollX(var4.getScrollX());
         var2.setScrollY(var4.getScrollY());
         AccessibilityRecordCompat.a(var2, var4.getScrollX());
         AccessibilityRecordCompat.b(var2, var4.getScrollRange());
      }

      @Override
      public boolean a(View var1, int var2, Bundle var3) {
         boolean var6 = true;
         if (!super.a(var1, var2, var3)) {
            NestedScrollView var7 = (NestedScrollView)var1;
            if (!var7.isEnabled()) {
               var6 = false;
            } else {
               switch (var2) {
                  case 4096:
                     var2 = Math.min(var7.getHeight() - var7.getPaddingBottom() - var7.getPaddingTop() + var7.getScrollY(), var7.getScrollRange());
                     if (var2 != var7.getScrollY()) {
                        var7.c(0, var2);
                     } else {
                        var6 = false;
                     }
                     break;
                  case 8192:
                     int var4 = var7.getHeight();
                     var2 = var7.getPaddingBottom();
                     int var5 = var7.getPaddingTop();
                     var2 = Math.max(var7.getScrollY() - (var4 - var2 - var5), 0);
                     if (var2 != var7.getScrollY()) {
                        var7.c(0, var2);
                     } else {
                        var6 = false;
                     }
                     break;
                  default:
                     var6 = false;
               }
            }
         }

         return var6;
      }
   }

   public interface OnScrollChangeListener {
      void a(NestedScrollView var1, int var2, int var3, int var4, int var5);
   }

   static class SavedState extends BaseSavedState {
      public static final Creator<NestedScrollView.SavedState> CREATOR = new Creator<NestedScrollView.SavedState>() {
         public NestedScrollView.SavedState a(Parcel var1) {
            return new NestedScrollView.SavedState(var1);
         }

         public NestedScrollView.SavedState[] a(int var1) {
            return new NestedScrollView.SavedState[var1];
         }
      };
      public int a;

      SavedState(Parcel var1) {
         super(var1);
         this.a = var1.readInt();
      }

      SavedState(Parcelable var1) {
         super(var1);
      }

      public String toString() {
         return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.a + "}";
      }

      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         var1.writeInt(this.a);
      }
   }
}
