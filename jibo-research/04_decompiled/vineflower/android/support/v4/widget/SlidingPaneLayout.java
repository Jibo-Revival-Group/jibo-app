package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup {
   static final SlidingPaneLayout.SlidingPanelLayoutImpl h;
   View a;
   float b;
   int c;
   boolean d;
   final ViewDragHelper e;
   boolean f;
   final ArrayList<SlidingPaneLayout.DisableLayerRunnable> g;
   private int i = -858993460;
   private int j;
   private Drawable k;
   private Drawable l;
   private final int m;
   private boolean n;
   private float o;
   private int p;
   private float q;
   private float r;
   private SlidingPaneLayout.PanelSlideListener s;
   private boolean t = true;
   private final Rect u = new Rect();

   static {
      if (VERSION.SDK_INT >= 17) {
         h = new SlidingPaneLayout.SlidingPanelLayoutImplJBMR1();
      } else if (VERSION.SDK_INT >= 16) {
         h = new SlidingPaneLayout.SlidingPanelLayoutImplJB();
      } else {
         h = new SlidingPaneLayout.SlidingPanelLayoutImplBase();
      }
   }

   public SlidingPaneLayout(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public SlidingPaneLayout(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.g = new ArrayList<>();
      float var4 = var1.getResources().getDisplayMetrics().density;
      this.m = (int)(32.0F * var4 + 0.5F);
      this.setWillNotDraw(false);
      ViewCompat.a(this, new SlidingPaneLayout.AccessibilityDelegate(this));
      ViewCompat.a(this, 1);
      this.e = ViewDragHelper.a(this, 0.5F, new SlidingPaneLayout.DragHelperCallback(this));
      this.e.a(var4 * 400.0F);
   }

   private void a(float var1) {
      boolean var8;
      int var10;
      label39: {
         var8 = this.f();
         SlidingPaneLayout.LayoutParams var9 = (SlidingPaneLayout.LayoutParams)this.a.getLayoutParams();
         if (var9.c) {
            if (var8) {
               var10 = var9.rightMargin;
            } else {
               var10 = var9.leftMargin;
            }

            if (var10 <= 0) {
               var10 = 1;
               break label39;
            }
         }

         var10 = 0;
      }

      int var7 = this.getChildCount();

      for (int var4 = 0; var4 < var7; var4++) {
         View var12 = this.getChildAt(var4);
         if (var12 != this.a) {
            int var5 = (int)((1.0F - this.o) * this.p);
            this.o = var1;
            int var6 = var5 - (int)((1.0F - var1) * this.p);
            var5 = var6;
            if (var8) {
               var5 = -var6;
            }

            var12.offsetLeftAndRight(var5);
            if (var10) {
               float var2;
               if (var8) {
                  var2 = this.o - 1.0F;
               } else {
                  var2 = 1.0F - this.o;
               }

               this.a(var12, var2, this.j);
            }
         }
      }
   }

   private void a(View var1, float var2, int var3) {
      SlidingPaneLayout.LayoutParams var5 = (SlidingPaneLayout.LayoutParams)var1.getLayoutParams();
      if (var2 > 0.0F && var3 != 0) {
         int var4 = (int)(((0xFF000000 & var3) >>> 24) * var2);
         if (var5.d == null) {
            var5.d = new Paint();
         }

         var5.d.setColorFilter(new PorterDuffColorFilter(var4 << 24 | 16777215 & var3, Mode.SRC_OVER));
         if (var1.getLayerType() != 2) {
            var1.setLayerType(2, var5.d);
         }

         this.e(var1);
      } else if (var1.getLayerType() != 0) {
         if (var5.d != null) {
            var5.d.setColorFilter(null);
         }

         SlidingPaneLayout.DisableLayerRunnable var6 = new SlidingPaneLayout.DisableLayerRunnable(this, var1);
         this.g.add(var6);
         ViewCompat.a(this, var6);
      }
   }

   private boolean a(View var1, int var2) {
      boolean var3 = false;
      if (this.t || this.a(0.0F, var2)) {
         this.f = false;
         var3 = true;
      }

      return var3;
   }

   private boolean b(View var1, int var2) {
      boolean var3 = true;
      if (!this.t && !this.a(1.0F, var2)) {
         var3 = false;
      } else {
         this.f = true;
      }

      return var3;
   }

   private static boolean g(View var0) {
      boolean var1 = true;
      if (!var0.isOpaque()) {
         if (VERSION.SDK_INT >= 18) {
            var1 = false;
         } else {
            Drawable var2 = var0.getBackground();
            if (var2 != null) {
               if (var2.getOpacity() != -1) {
                  var1 = false;
               }
            } else {
               var1 = false;
            }
         }
      }

      return var1;
   }

   void a() {
      int var2 = this.getChildCount();

      for (int var1 = 0; var1 < var2; var1++) {
         View var3 = this.getChildAt(var1);
         if (var3.getVisibility() == 4) {
            var3.setVisibility(0);
         }
      }
   }

   void a(int var1) {
      if (this.a == null) {
         this.b = 0.0F;
      } else {
         boolean var4 = this.f();
         SlidingPaneLayout.LayoutParams var5 = (SlidingPaneLayout.LayoutParams)this.a.getLayoutParams();
         int var3 = this.a.getWidth();
         int var2 = var1;
         if (var4) {
            var2 = this.getWidth() - var1 - var3;
         }

         if (var4) {
            var1 = this.getPaddingRight();
         } else {
            var1 = this.getPaddingLeft();
         }

         if (var4) {
            var3 = var5.rightMargin;
         } else {
            var3 = var5.leftMargin;
         }

         this.b = (float)(var2 - (var3 + var1)) / this.c;
         if (this.p != 0) {
            this.a(this.b);
         }

         if (var5.c) {
            this.a(this.a, this.b, this.i);
         }

         this.a(this.a);
      }
   }

   void a(View var1) {
      if (this.s != null) {
         this.s.a(var1, this.b);
      }
   }

   boolean a(float var1, int var2) {
      boolean var5;
      if (!this.n) {
         var5 = false;
      } else {
         var5 = this.f();
         SlidingPaneLayout.LayoutParams var6 = (SlidingPaneLayout.LayoutParams)this.a.getLayoutParams();
         if (var5) {
            int var4 = this.getPaddingRight();
            var2 = var6.rightMargin;
            int var3 = this.a.getWidth();
            var2 = (int)(this.getWidth() - (var2 + var4 + this.c * var1 + var3));
         } else {
            var2 = this.getPaddingLeft();
            var2 = (int)(var6.leftMargin + var2 + this.c * var1);
         }

         if (this.e.a(this.a, var2, this.a.getTop())) {
            this.a();
            ViewCompat.c(this);
            var5 = true;
         } else {
            var5 = false;
         }
      }

      return var5;
   }

   void b(View var1) {
      if (this.s != null) {
         this.s.a(var1);
      }

      this.sendAccessibilityEvent(32);
   }

   public boolean b() {
      return this.b(this.a, 0);
   }

   void c(View var1) {
      if (this.s != null) {
         this.s.b(var1);
      }

      this.sendAccessibilityEvent(32);
   }

   public boolean c() {
      return this.a(this.a, 0);
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      boolean var2;
      if (var1 instanceof SlidingPaneLayout.LayoutParams && super.checkLayoutParams(var1)) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   public void computeScroll() {
      if (this.e.a(true)) {
         if (!this.n) {
            this.e.f();
         } else {
            ViewCompat.c(this);
         }
      }
   }

   void d(View var1) {
      boolean var17 = this.f();
      int var2;
      if (var17) {
         var2 = this.getWidth() - this.getPaddingRight();
      } else {
         var2 = this.getPaddingLeft();
      }

      int var3;
      if (var17) {
         var3 = this.getPaddingLeft();
      } else {
         var3 = this.getWidth() - this.getPaddingRight();
      }

      int var11 = this.getPaddingTop();
      int var12 = this.getHeight();
      int var10 = this.getPaddingBottom();
      int var4;
      int var5;
      int var6;
      int var7;
      if (var1 != null && g(var1)) {
         var5 = var1.getLeft();
         var7 = var1.getRight();
         var6 = var1.getTop();
         var4 = var1.getBottom();
      } else {
         var4 = 0;
         var6 = 0;
         var7 = 0;
         var5 = 0;
      }

      int var13 = this.getChildCount();

      for (int var8 = 0; var8 < var13; var8++) {
         View var18 = this.getChildAt(var8);
         if (var18 == var1) {
            break;
         }

         if (var18.getVisibility() != 8) {
            int var9;
            if (var17) {
               var9 = var3;
            } else {
               var9 = var2;
            }

            int var14 = Math.max(var9, var18.getLeft());
            int var15 = Math.max(var11, var18.getTop());
            if (var17) {
               var9 = var2;
            } else {
               var9 = var3;
            }

            int var16 = Math.min(var9, var18.getRight());
            var9 = Math.min(var12 - var10, var18.getBottom());
            byte var21;
            if (var14 >= var5 && var15 >= var6 && var16 <= var7 && var9 <= var4) {
               var21 = 4;
            } else {
               var21 = 0;
            }

            var18.setVisibility(var21);
         }
      }
   }

   public boolean d() {
      boolean var1;
      if (this.n && this.b != 1.0F) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public void draw(Canvas var1) {
      super.draw(var1);
      Drawable var7;
      if (this.f()) {
         var7 = this.l;
      } else {
         var7 = this.k;
      }

      View var8;
      if (this.getChildCount() > 1) {
         var8 = this.getChildAt(1);
      } else {
         var8 = null;
      }

      if (var8 != null && var7 != null) {
         int var4 = var8.getTop();
         int var5 = var8.getBottom();
         int var6 = var7.getIntrinsicWidth();
         int var2;
         int var3;
         if (this.f()) {
            var3 = var8.getRight();
            var2 = var3 + var6;
         } else {
            var2 = var8.getLeft();
            var3 = var2 - var6;
         }

         var7.setBounds(var3, var4, var2, var5);
         var7.draw(var1);
      }
   }

   protected boolean drawChild(Canvas var1, View var2, long var3) {
      SlidingPaneLayout.LayoutParams var7 = (SlidingPaneLayout.LayoutParams)var2.getLayoutParams();
      int var5 = var1.save();
      if (this.n && !var7.b && this.a != null) {
         var1.getClipBounds(this.u);
         if (this.f()) {
            this.u.left = Math.max(this.u.left, this.a.getRight());
         } else {
            this.u.right = Math.min(this.u.right, this.a.getLeft());
         }

         var1.clipRect(this.u);
      }

      boolean var6 = super.drawChild(var1, var2, var3);
      var1.restoreToCount(var5);
      return var6;
   }

   void e(View var1) {
      h.a(this, var1);
   }

   public boolean e() {
      return this.n;
   }

   boolean f() {
      boolean var1 = true;
      if (ViewCompat.e(this) != 1) {
         var1 = false;
      }

      return var1;
   }

   boolean f(View var1) {
      boolean var2 = false;
      if (var1 != null) {
         SlidingPaneLayout.LayoutParams var3 = (SlidingPaneLayout.LayoutParams)var1.getLayoutParams();
         if (this.n && var3.c && this.b > 0.0F) {
            var2 = true;
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
      return new SlidingPaneLayout.LayoutParams();
   }

   public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet var1) {
      return new SlidingPaneLayout.LayoutParams(this.getContext(), var1);
   }

   protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      SlidingPaneLayout.LayoutParams var2;
      if (var1 instanceof MarginLayoutParams) {
         var2 = new SlidingPaneLayout.LayoutParams((MarginLayoutParams)var1);
      } else {
         var2 = new SlidingPaneLayout.LayoutParams(var1);
      }

      return var2;
   }

   public int getCoveredFadeColor() {
      return this.j;
   }

   public int getParallaxDistance() {
      return this.p;
   }

   public int getSliderFadeColor() {
      return this.i;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      this.t = true;
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.t = true;
      int var2 = this.g.size();

      for (int var1 = 0; var1 < var2; var1++) {
         this.g.get(var1).run();
      }

      this.g.clear();
   }

   public boolean onInterceptTouchEvent(MotionEvent var1) {
      boolean var6 = false;
      int var4 = var1.getActionMasked();
      if (!this.n && var4 == 0 && this.getChildCount() > 1) {
         View var7 = this.getChildAt(1);
         if (var7 != null) {
            boolean var5;
            if (!this.e.b(var7, (int)var1.getX(), (int)var1.getY())) {
               var5 = true;
            } else {
               var5 = false;
            }

            this.f = var5;
         }
      }

      boolean var13;
      if (this.n && (!this.d || var4 == 0)) {
         if (var4 != 3 && var4 != 1) {
            label49: {
               switch (var4) {
                  case 0:
                     this.d = false;
                     float var11 = var1.getX();
                     float var9 = var1.getY();
                     this.q = var11;
                     this.r = var9;
                     if (this.e.b(this.a, (int)var11, (int)var9) && this.f(this.a)) {
                        var12 = true;
                        break label49;
                     }
                  case 1:
                  default:
                     break;
                  case 2:
                     float var2 = var1.getX();
                     float var3 = var1.getY();
                     var2 = Math.abs(var2 - this.q);
                     var3 = Math.abs(var3 - this.r);
                     if (var2 > this.e.d() && var3 > var2) {
                        this.e.e();
                        this.d = true;
                        var13 = var6;
                        return var13;
                     }
               }

               var12 = false;
            }

            if (!this.e.a(var1)) {
               var13 = var6;
               if (!var12) {
                  return var13;
               }
            }

            var13 = true;
         } else {
            this.e.e();
            var13 = var6;
         }
      } else {
         this.e.e();
         var13 = super.onInterceptTouchEvent(var1);
      }

      return var13;
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      boolean var13 = this.f();
      if (var13) {
         this.e.a(2);
      } else {
         this.e.a(1);
      }

      int var9 = var4 - var2;
      if (var13) {
         var2 = this.getPaddingRight();
      } else {
         var2 = this.getPaddingLeft();
      }

      if (var13) {
         var5 = this.getPaddingLeft();
      } else {
         var5 = this.getPaddingRight();
      }

      int var11 = this.getPaddingTop();
      int var10 = this.getChildCount();
      if (this.t) {
         float var6;
         if (this.n && this.f) {
            var6 = 1.0F;
         } else {
            var6 = 0.0F;
         }

         this.b = var6;
      }

      int var7 = 0;
      var3 = var2;

      while (var7 < var10) {
         View var14 = this.getChildAt(var7);
         if (var14.getVisibility() == 8) {
            var4 = var2;
            var2 = var3;
            var3 = var4;
         } else {
            SlidingPaneLayout.LayoutParams var15 = (SlidingPaneLayout.LayoutParams)var14.getLayoutParams();
            int var12 = var14.getMeasuredWidth();
            if (var15.b) {
               var4 = var15.leftMargin;
               int var8 = var15.rightMargin;
               var8 = Math.min(var2, var9 - var5 - this.m) - var3 - (var4 + var8);
               this.c = var8;
               if (var13) {
                  var4 = var15.rightMargin;
               } else {
                  var4 = var15.leftMargin;
               }

               if (var3 + var4 + var8 + var12 / 2 > var9 - var5) {
                  var1 = true;
               } else {
                  var1 = false;
               }

               var15.c = var1;
               var8 = (int)(var8 * this.b);
               var3 += var4 + var8;
               this.b = (float)var8 / this.c;
               var4 = 0;
            } else if (this.n && this.p != 0) {
               var4 = (int)((1.0F - this.b) * this.p);
               var3 = var2;
            } else {
               var4 = 0;
               var3 = var2;
            }

            int var33;
            if (var13) {
               var4 = var9 - var3 + var4;
               var33 = var4 - var12;
            } else {
               var33 = var3 - var4;
               var4 = var33 + var12;
            }

            var14.layout(var33, var11, var4, var14.getMeasuredHeight() + var11);
            var4 = var14.getWidth() + var2;
            var2 = var3;
            var3 = var4;
         }

         var7++;
         var4 = var3;
         var3 = var2;
         var2 = var4;
      }

      if (this.t) {
         if (this.n) {
            if (this.p != 0) {
               this.a(this.b);
            }

            if (((SlidingPaneLayout.LayoutParams)this.a.getLayoutParams()).c) {
               this.a(this.a, this.b, this.i);
            }
         } else {
            for (int var19 = 0; var19 < var10; var19++) {
               this.a(this.getChildAt(var19), 0.0F, this.i);
            }
         }

         this.d(this.a);
      }

      this.t = false;
   }

   protected void onMeasure(int var1, int var2) {
      int var23;
      label176: {
         int var7 = MeasureSpec.getMode(var1);
         var23 = MeasureSpec.getSize(var1);
         int var6 = MeasureSpec.getMode(var2);
         var1 = MeasureSpec.getSize(var2);
         if (var7 != 1073741824) {
            if (!this.isInEditMode()) {
               throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
            }

            if (var7 == Integer.MIN_VALUE) {
               var2 = var23;
               var23 = var6;
               break label176;
            }

            if (var7 == 0) {
               var23 = var6;
               var2 = 300;
               break label176;
            }
         } else if (var6 == 0) {
            if (!this.isInEditMode()) {
               throw new IllegalStateException("Height must not be UNSPECIFIED");
            }

            if (var6 == 0) {
               var6 = Integer.MIN_VALUE;
               var2 = var23;
               var1 = 300;
               var23 = var6;
               break label176;
            }
         }

         var2 = var23;
         var23 = var6;
      }

      int var31;
      switch (var23) {
         case Integer.MIN_VALUE:
            int var8 = this.getPaddingTop();
            var31 = this.getPaddingBottom();
            byte var28 = 0;
            var31 = var1 - var8 - var31;
            var1 = var28;
            break;
         case 1073741824:
            var1 = var1 - this.getPaddingTop() - this.getPaddingBottom();
            var31 = var1;
            break;
         default:
            var1 = 0;
            var31 = 0;
      }

      boolean var15 = false;
      int var11 = var2 - this.getPaddingLeft() - this.getPaddingRight();
      int var12 = this.getChildCount();
      if (var12 > 2) {
         Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
      }

      this.a = null;
      int var10 = 0;
      int var29 = var11;
      float var3 = 0.0F;

      while (var10 < var12) {
         View var17 = this.getChildAt(var10);
         SlidingPaneLayout.LayoutParams var18 = (SlidingPaneLayout.LayoutParams)var17.getLayoutParams();
         if (var17.getVisibility() == 8) {
            var18.c = false;
            int var33 = var29;
            var29 = var1;
            var1 = var33;
         } else {
            label186: {
               float var4 = var3;
               if (var18.a > 0.0F) {
                  var3 += var18.a;
                  var4 = var3;
                  if (var18.width == 0) {
                     int var37 = var29;
                     var29 = var1;
                     var1 = var37;
                     break label186;
                  }
               }

               int var34 = var18.leftMargin + var18.rightMargin;
               if (var18.width == -2) {
                  var34 = MeasureSpec.makeMeasureSpec(var11 - var34, Integer.MIN_VALUE);
               } else if (var18.width == -1) {
                  var34 = MeasureSpec.makeMeasureSpec(var11 - var34, 1073741824);
               } else {
                  var34 = MeasureSpec.makeMeasureSpec(var18.width, 1073741824);
               }

               int var9;
               if (var18.height == -2) {
                  var9 = MeasureSpec.makeMeasureSpec(var31, Integer.MIN_VALUE);
               } else if (var18.height == -1) {
                  var9 = MeasureSpec.makeMeasureSpec(var31, 1073741824);
               } else {
                  var9 = MeasureSpec.makeMeasureSpec(var18.height, 1073741824);
               }

               var17.measure(var34, var9);
               var9 = var17.getMeasuredWidth();
               int var13 = var17.getMeasuredHeight();
               var34 = var1;
               if (var23 == Integer.MIN_VALUE) {
                  var34 = var1;
                  if (var13 > var1) {
                     var34 = Math.min(var13, var31);
                  }
               }

               var1 = var29 - var9;
               boolean var16;
               if (var1 < 0) {
                  var16 = true;
               } else {
                  var16 = false;
               }

               var18.b = var16;
               if (var18.b) {
                  this.a = var17;
               }

               var29 = var34;
               var15 |= var16;
               var3 = var4;
            }
         }

         var10++;
         int var38 = var29;
         var29 = var1;
         var1 = var38;
      }

      if (var15 || var3 > 0.0F) {
         var10 = var11 - this.m;

         for (int var39 = 0; var39 < var12; var39++) {
            View var47 = this.getChildAt(var39);
            if (var47.getVisibility() != 8) {
               SlidingPaneLayout.LayoutParams var46 = (SlidingPaneLayout.LayoutParams)var47.getLayoutParams();
               if (var47.getVisibility() != 8) {
                  boolean var24;
                  if (var46.width == 0 && var46.a > 0.0F) {
                     var24 = 1;
                  } else {
                     var24 = 0;
                  }

                  int var41;
                  if (var24) {
                     var41 = 0;
                  } else {
                     var41 = var47.getMeasuredWidth();
                  }

                  if (var15 && var47 != this.a) {
                     if (var46.width < 0 && (var41 > var10 || var46.a > 0.0F)) {
                        if (var24) {
                           if (var46.height == -2) {
                              var24 = MeasureSpec.makeMeasureSpec(var31, Integer.MIN_VALUE);
                           } else if (var46.height == -1) {
                              var24 = MeasureSpec.makeMeasureSpec(var31, 1073741824);
                           } else {
                              var24 = MeasureSpec.makeMeasureSpec(var46.height, 1073741824);
                           }
                        } else {
                           var24 = MeasureSpec.makeMeasureSpec(var47.getMeasuredHeight(), 1073741824);
                        }

                        var47.measure(MeasureSpec.makeMeasureSpec(var10, 1073741824), var24);
                     }
                  } else if (var46.a > 0.0F) {
                     if (var46.width == 0) {
                        if (var46.height == -2) {
                           var24 = MeasureSpec.makeMeasureSpec(var31, Integer.MIN_VALUE);
                        } else if (var46.height == -1) {
                           var24 = MeasureSpec.makeMeasureSpec(var31, 1073741824);
                        } else {
                           var24 = MeasureSpec.makeMeasureSpec(var46.height, 1073741824);
                        }
                     } else {
                        var24 = MeasureSpec.makeMeasureSpec(var47.getMeasuredHeight(), 1073741824);
                     }

                     if (var15) {
                        int var43 = var46.leftMargin;
                        int var14 = var11 - (var46.rightMargin + var43);
                        var43 = MeasureSpec.makeMeasureSpec(var14, 1073741824);
                        if (var41 != var14) {
                           var47.measure(var43, var24);
                        }
                     } else {
                        int var45 = Math.max(0, var29);
                        var47.measure(MeasureSpec.makeMeasureSpec((int)(var46.a * var45 / var3) + var41, 1073741824), var24);
                     }
                  }
               }
            }
         }
      }

      this.setMeasuredDimension(var2, this.getPaddingTop() + var1 + this.getPaddingBottom());
      this.n = var15;
      if (this.e.a() != 0 && !var15) {
         this.e.f();
      }
   }

   protected void onRestoreInstanceState(Parcelable var1) {
      if (!(var1 instanceof SlidingPaneLayout.SavedState)) {
         super.onRestoreInstanceState(var1);
      } else {
         var1 = var1;
         super.onRestoreInstanceState(var1.a());
         if (var1.a) {
            this.b();
         } else {
            this.c();
         }

         this.f = var1.a;
      }
   }

   protected Parcelable onSaveInstanceState() {
      SlidingPaneLayout.SavedState var2 = new SlidingPaneLayout.SavedState(super.onSaveInstanceState());
      boolean var1;
      if (this.e()) {
         var1 = this.d();
      } else {
         var1 = this.f;
      }

      var2.a = var1;
      return var2;
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      if (var1 != var3) {
         this.t = true;
      }
   }

   public boolean onTouchEvent(MotionEvent var1) {
      boolean var7;
      if (!this.n) {
         var7 = super.onTouchEvent(var1);
      } else {
         this.e.b(var1);
         boolean var8 = true;
         switch (var1.getActionMasked()) {
            case 0:
               float var9 = var1.getX();
               float var10 = var1.getY();
               this.q = var9;
               this.r = var10;
               var7 = var8;
               break;
            case 1:
               var7 = var8;
               if (this.f(this.a)) {
                  float var4 = var1.getX();
                  float var5 = var1.getY();
                  float var2 = var4 - this.q;
                  float var3 = var5 - this.r;
                  int var6 = this.e.d();
                  var7 = var8;
                  if (var2 * var2 + var3 * var3 < var6 * var6) {
                     var7 = var8;
                     if (this.e.b(this.a, (int)var4, (int)var5)) {
                        this.a(this.a, 0);
                        var7 = var8;
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

   public void requestChildFocus(View var1, View var2) {
      super.requestChildFocus(var1, var2);
      if (!this.isInTouchMode() && !this.n) {
         boolean var3;
         if (var1 == this.a) {
            var3 = true;
         } else {
            var3 = false;
         }

         this.f = var3;
      }
   }

   public void setCoveredFadeColor(int var1) {
      this.j = var1;
   }

   public void setPanelSlideListener(SlidingPaneLayout.PanelSlideListener var1) {
      this.s = var1;
   }

   public void setParallaxDistance(int var1) {
      this.p = var1;
      this.requestLayout();
   }

   @Deprecated
   public void setShadowDrawable(Drawable var1) {
      this.setShadowDrawableLeft(var1);
   }

   public void setShadowDrawableLeft(Drawable var1) {
      this.k = var1;
   }

   public void setShadowDrawableRight(Drawable var1) {
      this.l = var1;
   }

   @Deprecated
   public void setShadowResource(int var1) {
      this.setShadowDrawable(this.getResources().getDrawable(var1));
   }

   public void setShadowResourceLeft(int var1) {
      this.setShadowDrawableLeft(ContextCompat.a(this.getContext(), var1));
   }

   public void setShadowResourceRight(int var1) {
      this.setShadowDrawableRight(ContextCompat.a(this.getContext(), var1));
   }

   public void setSliderFadeColor(int var1) {
      this.i = var1;
   }

   class AccessibilityDelegate extends AccessibilityDelegateCompat {
      final SlidingPaneLayout a;
      private final Rect c;

      AccessibilityDelegate(SlidingPaneLayout var1) {
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
         var1.b(var2.c());
      }

      @Override
      public void a(View var1, AccessibilityNodeInfoCompat var2) {
         AccessibilityNodeInfoCompat var5 = AccessibilityNodeInfoCompat.a(var2);
         super.a(var1, var5);
         this.a(var2, var5);
         var5.t();
         var2.b(SlidingPaneLayout.class.getName());
         var2.a(var1);
         ViewParent var6 = ViewCompat.f(var1);
         if (var6 instanceof View) {
            var2.c((View)var6);
         }

         int var4 = this.a.getChildCount();

         for (int var3 = 0; var3 < var4; var3++) {
            var1 = this.a.getChildAt(var3);
            if (!this.b(var1) && var1.getVisibility() == 0) {
               ViewCompat.a(var1, 1);
               var2.b(var1);
            }
         }
      }

      @Override
      public void a(View var1, AccessibilityEvent var2) {
         super.a(var1, var2);
         var2.setClassName(SlidingPaneLayout.class.getName());
      }

      @Override
      public boolean a(ViewGroup var1, View var2, AccessibilityEvent var3) {
         boolean var4;
         if (!this.b(var2)) {
            var4 = super.a(var1, var2, var3);
         } else {
            var4 = false;
         }

         return var4;
      }

      public boolean b(View var1) {
         return this.a.f(var1);
      }
   }

   private class DisableLayerRunnable implements Runnable {
      final View a;
      final SlidingPaneLayout b;

      DisableLayerRunnable(SlidingPaneLayout var1, View var2) {
         this.b = var1;
         this.a = var2;
      }

      @Override
      public void run() {
         if (this.a.getParent() == this.b) {
            this.a.setLayerType(0, null);
            this.b.e(this.a);
         }

         this.b.g.remove(this);
      }
   }

   private class DragHelperCallback extends ViewDragHelper.Callback {
      final SlidingPaneLayout a;

      DragHelperCallback(SlidingPaneLayout var1) {
         this.a = var1;
      }

      @Override
      public int a(View var1, int var2, int var3) {
         return var1.getTop();
      }

      @Override
      public void a(int var1) {
         if (this.a.e.a() == 0) {
            if (this.a.b == 0.0F) {
               this.a.d(this.a.a);
               this.a.c(this.a.a);
               this.a.f = false;
            } else {
               this.a.b(this.a.a);
               this.a.f = true;
            }
         }
      }

      @Override
      public void a(View var1, float var2, float var3) {
         SlidingPaneLayout.LayoutParams var6 = (SlidingPaneLayout.LayoutParams)var1.getLayoutParams();
         int var8;
         if (this.a.f()) {
            label26: {
               var8 = this.a.getPaddingRight();
               int var5 = var6.rightMargin + var8;
               if (!(var2 < 0.0F)) {
                  var8 = var5;
                  if (var2 != 0.0F) {
                     break label26;
                  }

                  var8 = var5;
                  if (!(this.a.b > 0.5F)) {
                     break label26;
                  }
               }

               var8 = var5 + this.a.c;
            }

            int var10 = this.a.a.getWidth();
            var8 = this.a.getWidth() - var8 - var10;
         } else {
            label20: {
               var8 = this.a.getPaddingLeft();
               int var11 = var6.leftMargin + var8;
               if (!(var2 > 0.0F)) {
                  var8 = var11;
                  if (var2 != 0.0F) {
                     break label20;
                  }

                  var8 = var11;
                  if (!(this.a.b > 0.5F)) {
                     break label20;
                  }
               }

               var8 = var11 + this.a.c;
            }
         }

         this.a.e.a(var8, var1.getTop());
         this.a.invalidate();
      }

      @Override
      public void a(View var1, int var2, int var3, int var4, int var5) {
         this.a.a(var2);
         this.a.invalidate();
      }

      @Override
      public boolean a(View var1, int var2) {
         boolean var3;
         if (this.a.d) {
            var3 = false;
         } else {
            var3 = ((SlidingPaneLayout.LayoutParams)var1.getLayoutParams()).b;
         }

         return var3;
      }

      @Override
      public int b(View var1) {
         return this.a.c;
      }

      @Override
      public int b(View var1, int var2, int var3) {
         SlidingPaneLayout.LayoutParams var5 = (SlidingPaneLayout.LayoutParams)this.a.a.getLayoutParams();
         if (this.a.f()) {
            var3 = this.a.getWidth();
            int var4 = this.a.getPaddingRight();
            var4 = var3 - (var5.rightMargin + var4 + this.a.a.getWidth());
            var3 = this.a.c;
            var2 = Math.max(Math.min(var2, var4), var4 - var3);
         } else {
            var3 = this.a.getPaddingLeft();
            var3 = var5.leftMargin + var3;
            int var12 = this.a.c;
            var2 = Math.min(Math.max(var2, var3), var12 + var3);
         }

         return var2;
      }

      @Override
      public void b(int var1, int var2) {
         this.a.e.a(this.a.a, var2);
      }

      @Override
      public void b(View var1, int var2) {
         this.a.a();
      }
   }

   public static class LayoutParams extends MarginLayoutParams {
      private static final int[] e = new int[]{16843137};
      public float a = 0.0F;
      boolean b;
      boolean c;
      Paint d;

      public LayoutParams() {
         super(-1, -1);
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, e);
         this.a = var3.getFloat(0, 0.0F);
         var3.recycle();
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
      }
   }

   public interface PanelSlideListener {
      void a(View var1);

      void a(View var1, float var2);

      void b(View var1);
   }

   static class SavedState extends AbsSavedState {
      public static final Creator<SlidingPaneLayout.SavedState> CREATOR = new ClassLoaderCreator<SlidingPaneLayout.SavedState>() {
         public SlidingPaneLayout.SavedState a(Parcel var1) {
            return new SlidingPaneLayout.SavedState(var1, null);
         }

         public SlidingPaneLayout.SavedState a(Parcel var1, ClassLoader var2) {
            return new SlidingPaneLayout.SavedState(var1, null);
         }

         public SlidingPaneLayout.SavedState[] a(int var1) {
            return new SlidingPaneLayout.SavedState[var1];
         }
      };
      boolean a;

      SavedState(Parcel var1, ClassLoader var2) {
         super(var1, var2);
         boolean var3;
         if (var1.readInt() != 0) {
            var3 = true;
         } else {
            var3 = false;
         }

         this.a = var3;
      }

      SavedState(Parcelable var1) {
         super(var1);
      }

      @Override
      public void writeToParcel(Parcel var1, int var2) {
         super.writeToParcel(var1, var2);
         byte var3;
         if (this.a) {
            var3 = 1;
         } else {
            var3 = 0;
         }

         var1.writeInt(var3);
      }
   }

   interface SlidingPanelLayoutImpl {
      void a(SlidingPaneLayout var1, View var2);
   }

   static class SlidingPanelLayoutImplBase implements SlidingPaneLayout.SlidingPanelLayoutImpl {
      @Override
      public void a(SlidingPaneLayout var1, View var2) {
         ViewCompat.a(var1, var2.getLeft(), var2.getTop(), var2.getRight(), var2.getBottom());
      }
   }

   static class SlidingPanelLayoutImplJB extends SlidingPaneLayout.SlidingPanelLayoutImplBase {
      private Method a;
      private Field b;

      SlidingPanelLayoutImplJB() {
         try {
            this.a = View.class.getDeclaredMethod("getDisplayList", (Class<?>[])null);
         } catch (NoSuchMethodException var3) {
            Log.e("SlidingPaneLayout", "Couldn't fetch getDisplayList method; dimming won't work right.", var3);
         }

         try {
            this.b = View.class.getDeclaredField("mRecreateDisplayList");
            this.b.setAccessible(true);
         } catch (NoSuchFieldException var2) {
            Log.e("SlidingPaneLayout", "Couldn't fetch mRecreateDisplayList field; dimming will be slow.", var2);
         }
      }

      @Override
      public void a(SlidingPaneLayout var1, View var2) {
         if (this.a != null && this.b != null) {
            try {
               this.b.setBoolean(var2, true);
               this.a.invoke(var2, (Object[])null);
            } catch (Exception var4) {
               Log.e("SlidingPaneLayout", "Error refreshing display list state", var4);
            }

            super.a(var1, var2);
         } else {
            var2.invalidate();
         }
      }
   }

   static class SlidingPanelLayoutImplJBMR1 extends SlidingPaneLayout.SlidingPanelLayoutImplBase {
      @Override
      public void a(SlidingPaneLayout var1, View var2) {
         ViewCompat.a(var2, ((SlidingPaneLayout.LayoutParams)var2.getLayoutParams()).d);
      }
   }
}
