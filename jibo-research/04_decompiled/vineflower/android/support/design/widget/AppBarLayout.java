package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Build.VERSION;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.R;
import android.support.v4.math.MathUtils;
import android.support.v4.util.ObjectsCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@CoordinatorLayout.DefaultBehavior(a = AppBarLayout.Behavior.class)
public class AppBarLayout extends LinearLayout {
   private int a = -1;
   private int b = -1;
   private int c = -1;
   private boolean d;
   private int e = 0;
   private WindowInsetsCompat f;
   private List<AppBarLayout.OnOffsetChangedListener> g;
   private boolean h;
   private boolean i;
   private int[] j;

   public AppBarLayout(Context var1) {
      this(var1, null);
   }

   public AppBarLayout(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.setOrientation(1);
      ThemeUtils.a(var1);
      if (VERSION.SDK_INT >= 21) {
         ViewUtilsLollipop.a(this);
         ViewUtilsLollipop.a(this, var2, 0, R.style.Widget_Design_AppBarLayout);
      }

      TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.AppBarLayout, 0, R.style.Widget_Design_AppBarLayout);
      ViewCompat.a(this, var3.getDrawable(R.styleable.AppBarLayout_android_background));
      if (var3.hasValue(R.styleable.AppBarLayout_expanded)) {
         this.a(var3.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
      }

      if (VERSION.SDK_INT >= 21 && var3.hasValue(R.styleable.AppBarLayout_elevation)) {
         ViewUtilsLollipop.a(this, var3.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
      }

      if (VERSION.SDK_INT >= 26) {
         if (var3.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster)) {
            this.setKeyboardNavigationCluster(var3.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
         }

         if (var3.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
            this.setTouchscreenBlocksFocus(var3.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
         }
      }

      var3.recycle();
      ViewCompat.a(this, new OnApplyWindowInsetsListener(this) {
         final AppBarLayout a;

         {
            this.a = var1;
         }

         @Override
         public WindowInsetsCompat a(View var1, WindowInsetsCompat var2x) {
            return this.a.a(var2x);
         }
      });
   }

   private void a(boolean var1, boolean var2, boolean var3) {
      byte var6 = 0;
      byte var4;
      if (var1) {
         var4 = 1;
      } else {
         var4 = 2;
      }

      byte var5;
      if (var2) {
         var5 = 4;
      } else {
         var5 = 0;
      }

      if (var3) {
         var6 = 8;
      }

      this.e = var6 | var5 | var4;
      this.requestLayout();
   }

   private boolean b(boolean var1) {
      if (this.h != var1) {
         this.h = var1;
         this.refreshDrawableState();
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private void e() {
      int var2 = this.getChildCount();
      int var1 = 0;

      boolean var3;
      while (true) {
         if (var1 >= var2) {
            var3 = false;
            break;
         }

         if (((AppBarLayout.LayoutParams)this.getChildAt(var1).getLayoutParams()).c()) {
            var3 = true;
            break;
         }

         var1++;
      }

      this.b(var3);
   }

   private void f() {
      this.a = -1;
      this.b = -1;
      this.c = -1;
   }

   protected AppBarLayout.LayoutParams a() {
      return new AppBarLayout.LayoutParams(-1, -2);
   }

   public AppBarLayout.LayoutParams a(AttributeSet var1) {
      return new AppBarLayout.LayoutParams(this.getContext(), var1);
   }

   protected AppBarLayout.LayoutParams a(android.view.ViewGroup.LayoutParams var1) {
      AppBarLayout.LayoutParams var2;
      if (VERSION.SDK_INT >= 19 && var1 instanceof android.widget.LinearLayout.LayoutParams) {
         var2 = new AppBarLayout.LayoutParams((android.widget.LinearLayout.LayoutParams)var1);
      } else if (var1 instanceof MarginLayoutParams) {
         var2 = new AppBarLayout.LayoutParams((MarginLayoutParams)var1);
      } else {
         var2 = new AppBarLayout.LayoutParams(var1);
      }

      return var2;
   }

   WindowInsetsCompat a(WindowInsetsCompat var1) {
      WindowInsetsCompat var2 = null;
      if (ViewCompat.r(this)) {
         var2 = var1;
      }

      if (!ObjectsCompat.a(this.f, var2)) {
         this.f = var2;
         this.f();
      }

      return var1;
   }

   void a(int var1) {
      if (this.g != null) {
         int var3 = this.g.size();

         for (int var2 = 0; var2 < var3; var2++) {
            AppBarLayout.OnOffsetChangedListener var4 = this.g.get(var2);
            if (var4 != null) {
               var4.a(this, var1);
            }
         }
      }
   }

   public void a(AppBarLayout.OnOffsetChangedListener var1) {
      if (this.g == null) {
         this.g = new ArrayList<>();
      }

      if (var1 != null && !this.g.contains(var1)) {
         this.g.add(var1);
      }
   }

   public void a(boolean var1, boolean var2) {
      this.a(var1, var2, true);
   }

   boolean a(boolean var1) {
      if (this.i != var1) {
         this.i = var1;
         this.refreshDrawableState();
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void b(AppBarLayout.OnOffsetChangedListener var1) {
      if (this.g != null && var1 != null) {
         this.g.remove(var1);
      }
   }

   boolean b() {
      return this.d;
   }

   boolean c() {
      boolean var1;
      if (this.getTotalScrollRange() != 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      return var1 instanceof AppBarLayout.LayoutParams;
   }

   void d() {
      this.e = 0;
   }

   int getDownNestedPreScrollRange() {
      int var1;
      if (this.b != -1) {
         var1 = this.b;
      } else {
         int var2 = this.getChildCount() - 1;
         var1 = 0;

         while (var2 >= 0) {
            View var6 = this.getChildAt(var2);
            AppBarLayout.LayoutParams var7 = (AppBarLayout.LayoutParams)var6.getLayoutParams();
            int var3 = var6.getMeasuredHeight();
            int var4 = var7.a;
            if ((var4 & 5) == 5) {
               int var5 = var7.topMargin;
               var1 = var7.bottomMargin + var5 + var1;
               if ((var4 & 8) != 0) {
                  var1 += ViewCompat.k(var6);
               } else if ((var4 & 2) != 0) {
                  var1 += var3 - ViewCompat.k(var6);
               } else {
                  var1 += var3 - this.getTopInset();
               }
            } else if (var1 > 0) {
               break;
            }

            var2--;
         }

         var1 = Math.max(0, var1);
         this.b = var1;
      }

      return var1;
   }

   int getDownNestedScrollRange() {
      int var1;
      if (this.c != -1) {
         var1 = this.c;
      } else {
         int var3 = this.getChildCount();
         int var2 = 0;
         var1 = 0;

         while (var2 < var3) {
            View var8 = this.getChildAt(var2);
            AppBarLayout.LayoutParams var9 = (AppBarLayout.LayoutParams)var8.getLayoutParams();
            int var7 = var8.getMeasuredHeight();
            int var5 = var9.topMargin;
            int var6 = var9.bottomMargin;
            int var4 = var9.a;
            if ((var4 & 1) == 0) {
               break;
            }

            var1 += var7 + var5 + var6;
            if ((var4 & 2) != 0) {
               var1 -= ViewCompat.k(var8) + this.getTopInset();
               break;
            }

            var2++;
         }

         var1 = Math.max(0, var1);
         this.c = var1;
      }

      return var1;
   }

   final int getMinimumHeightForVisibleOverlappingContent() {
      int var2 = this.getTopInset();
      int var1 = ViewCompat.k(this);
      if (var1 != 0) {
         var1 = var1 * 2 + var2;
      } else {
         var1 = this.getChildCount();
         if (var1 >= 1) {
            var1 = ViewCompat.k(this.getChildAt(var1 - 1));
         } else {
            var1 = 0;
         }

         if (var1 != 0) {
            var1 = var1 * 2 + var2;
         } else {
            var1 = this.getHeight() / 3;
         }
      }

      return var1;
   }

   int getPendingAction() {
      return this.e;
   }

   @Deprecated
   public float getTargetElevation() {
      return 0.0F;
   }

   final int getTopInset() {
      int var1;
      if (this.f != null) {
         var1 = this.f.b();
      } else {
         var1 = 0;
      }

      return var1;
   }

   public final int getTotalScrollRange() {
      int var1;
      if (this.a != -1) {
         var1 = this.a;
      } else {
         int var3 = this.getChildCount();
         int var2 = 0;
         var1 = 0;

         while (var2 < var3) {
            View var7 = this.getChildAt(var2);
            AppBarLayout.LayoutParams var8 = (AppBarLayout.LayoutParams)var7.getLayoutParams();
            int var5 = var7.getMeasuredHeight();
            int var4 = var8.a;
            if ((var4 & 1) == 0) {
               break;
            }

            int var6 = var8.topMargin;
            var1 += var8.bottomMargin + var5 + var6;
            if ((var4 & 2) != 0) {
               var1 -= ViewCompat.k(var7);
               break;
            }

            var2++;
         }

         var1 = Math.max(0, var1 - this.getTopInset());
         this.a = var1;
      }

      return var1;
   }

   int getUpNestedPreScrollRange() {
      return this.getTotalScrollRange();
   }

   protected int[] onCreateDrawableState(int var1) {
      if (this.j == null) {
         this.j = new int[2];
      }

      int[] var3 = this.j;
      int[] var2 = super.onCreateDrawableState(var3.length + var1);
      if (this.h) {
         var1 = R.attr.state_collapsible;
      } else {
         var1 = -R.attr.state_collapsible;
      }

      var3[0] = var1;
      if (this.h && this.i) {
         var1 = R.attr.state_collapsed;
      } else {
         var1 = -R.attr.state_collapsed;
      }

      var3[1] = var1;
      return mergeDrawableStates(var2, var3);
   }

   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      this.f();
      this.d = false;
      var3 = this.getChildCount();

      for (int var6 = 0; var6 < var3; var6++) {
         if (((AppBarLayout.LayoutParams)this.getChildAt(var6).getLayoutParams()).b() != null) {
            this.d = true;
            break;
         }
      }

      this.e();
   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      this.f();
   }

   public void setExpanded(boolean var1) {
      this.a(var1, ViewCompat.y(this));
   }

   public void setOrientation(int var1) {
      if (var1 != 1) {
         throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
      }

      super.setOrientation(var1);
   }

   @Deprecated
   public void setTargetElevation(float var1) {
      if (VERSION.SDK_INT >= 21) {
         ViewUtilsLollipop.a(this, var1);
      }
   }

   public static class Behavior extends HeaderBehavior<AppBarLayout> {
      private int b;
      private ValueAnimator c;
      private int d = -1;
      private boolean e;
      private float f;
      private WeakReference<View> g;
      private AppBarLayout.Behavior.DragCallback h;

      public Behavior() {
      }

      public Behavior(Context var1, AttributeSet var2) {
         super(var1, var2);
      }

      private int a(AppBarLayout var1, int var2) {
         int var3 = 0;
         int var4 = var1.getChildCount();

         while (true) {
            if (var3 >= var4) {
               var3 = -1;
               break;
            }

            View var5 = var1.getChildAt(var3);
            if (var5.getTop() <= -var2 && var5.getBottom() >= -var2) {
               break;
            }

            var3++;
         }

         return var3;
      }

      private void a(CoordinatorLayout var1, AppBarLayout var2, int var3, float var4) {
         int var5 = Math.abs(this.a() - var3);
         var4 = Math.abs(var4);
         if (var4 > 0.0F) {
            var5 = Math.round(var5 / var4 * 1000.0F) * 3;
         } else {
            var5 = (int)(((float)var5 / var2.getHeight() + 1.0F) * 150.0F);
         }

         this.a(var1, var2, var3, var5);
      }

      private void a(CoordinatorLayout var1, AppBarLayout var2, int var3, int var4) {
         int var5 = this.a();
         if (var5 == var3) {
            if (this.c != null && this.c.isRunning()) {
               this.c.cancel();
            }
         } else {
            if (this.c == null) {
               this.c = new ValueAnimator();
               this.c.setInterpolator(AnimationUtils.e);
               this.c.addUpdateListener(new AnimatorUpdateListener(this, var1, var2) {
                  final CoordinatorLayout a;
                  final AppBarLayout b;
                  final AppBarLayout.Behavior c;

                  {
                     this.c = var1;
                     this.a = var2x;
                     this.b = var3x;
                  }

                  public void onAnimationUpdate(ValueAnimator var1) {
                     this.c.a_(this.a, this.b, (Integer)var1.getAnimatedValue());
                  }
               });
            } else {
               this.c.cancel();
            }

            this.c.setDuration(Math.min(var4, 600));
            this.c.setIntValues(new int[]{var5, var3});
            this.c.start();
         }
      }

      private void a(CoordinatorLayout var1, AppBarLayout var2, int var3, int var4, boolean var5) {
         boolean var10 = true;
         boolean var9 = false;
         View var11 = c(var2, var3);
         if (var11 != null) {
            int var6 = ((AppBarLayout.LayoutParams)var11.getLayoutParams()).a();
            boolean var8 = var9;
            if ((var6 & 1) != 0) {
               int var7 = ViewCompat.k(var11);
               if (var4 > 0 && (var6 & 12) != 0) {
                  if (-var3 >= var11.getBottom() - var7 - var2.getTopInset()) {
                     var8 = true;
                  } else {
                     var8 = false;
                  }
               } else {
                  var8 = var9;
                  if ((var6 & 2) != 0) {
                     if (-var3 >= var11.getBottom() - var7 - var2.getTopInset()) {
                        var8 = var10;
                     } else {
                        var8 = false;
                     }
                  }
               }
            }

            var8 = var2.a(var8);
            if (VERSION.SDK_INT >= 11 && (var5 || var8 && this.d(var1, var2))) {
               var2.jumpDrawablesToCurrentState();
            }
         }
      }

      private static boolean a(int var0, int var1) {
         boolean var2;
         if ((var0 & var1) == var1) {
            var2 = true;
         } else {
            var2 = false;
         }

         return var2;
      }

      private int b(AppBarLayout var1, int var2) {
         int var6 = Math.abs(var2);
         int var7 = var1.getChildCount();
         int var5 = 0;

         int var4;
         while (true) {
            var4 = var2;
            if (var5 >= var7) {
               break;
            }

            View var10 = var1.getChildAt(var5);
            AppBarLayout.LayoutParams var9 = (AppBarLayout.LayoutParams)var10.getLayoutParams();
            Interpolator var8 = var9.b();
            if (var6 >= var10.getTop() && var6 <= var10.getBottom()) {
               var4 = var2;
               if (var8 != null) {
                  var7 = var9.a();
                  if ((var7 & 1) != 0) {
                     var4 = var10.getHeight();
                     var5 = var9.topMargin;
                     var5 = var9.bottomMargin + var4 + var5 + 0;
                     var4 = var5;
                     if ((var7 & 2) != 0) {
                        var4 = var5 - ViewCompat.k(var10);
                     }
                  } else {
                     var4 = 0;
                  }

                  var5 = var4;
                  if (ViewCompat.r(var10)) {
                     var5 = var4 - var1.getTopInset();
                  }

                  var4 = var2;
                  if (var5 > 0) {
                     var4 = var10.getTop();
                     float var3 = var5;
                     var4 = Math.round(var8.getInterpolation((float)(var6 - var4) / var5) * var3);
                     var4 = Integer.signum(var2) * (var4 + var10.getTop());
                  }
               }
               break;
            }

            var5++;
         }

         return var4;
      }

      private static View c(AppBarLayout var0, int var1) {
         int var3 = Math.abs(var1);
         int var2 = var0.getChildCount();
         var1 = 0;

         while (true) {
            if (var1 >= var2) {
               var5 = null;
               break;
            }

            View var4 = var0.getChildAt(var1);
            if (var3 >= var4.getTop() && var3 <= var4.getBottom()) {
               var5 = var4;
               break;
            }

            var1++;
         }

         return var5;
      }

      private void c(CoordinatorLayout var1, AppBarLayout var2) {
         int var7 = this.a();
         int var8 = this.a(var2, var7);
         if (var8 >= 0) {
            View var9 = var2.getChildAt(var8);
            int var6 = ((AppBarLayout.LayoutParams)var9.getLayoutParams()).a();
            if ((var6 & 17) == 17) {
               int var5 = -var9.getTop();
               int var3 = -var9.getBottom();
               int var4 = var3;
               if (var8 == var2.getChildCount() - 1) {
                  var4 = var3 + var2.getTopInset();
               }

               if (a(var6, 2)) {
                  var4 += ViewCompat.k(var9);
                  var3 = var5;
               } else if (a(var6, 5)) {
                  var6 = ViewCompat.k(var9) + var4;
                  var3 = var6;
                  if (var7 >= var6) {
                     var4 = var6;
                     var3 = var5;
                  }
               } else {
                  var3 = var5;
               }

               if (var7 < (var4 + var3) / 2) {
                  var3 = var4;
               }

               this.a(var1, var2, MathUtils.a(var3, -var2.getTotalScrollRange(), 0), 0.0F);
            }
         }
      }

      private boolean d(CoordinatorLayout var1, AppBarLayout var2) {
         List var7 = var1.d(var2);
         int var4 = var7.size();
         int var3 = 0;

         boolean var5;
         while (true) {
            if (var3 >= var4) {
               var5 = false;
               break;
            }

            CoordinatorLayout.Behavior var6 = ((CoordinatorLayout.LayoutParams)((View)var7.get(var3)).getLayoutParams()).b();
            if (var6 instanceof AppBarLayout.ScrollingViewBehavior) {
               if (((AppBarLayout.ScrollingViewBehavior)var6).d() != 0) {
                  var5 = true;
               } else {
                  var5 = false;
               }
               break;
            }

            var3++;
         }

         return var5;
      }

      @Override
      int a() {
         return this.b() + this.b;
      }

      int a(CoordinatorLayout var1, AppBarLayout var2, int var3, int var4, int var5) {
         byte var6 = 0;
         int var7 = this.a();
         if (var4 != 0 && var7 >= var4 && var7 <= var5) {
            var4 = MathUtils.a(var3, var4, var5);
            var3 = var6;
            if (var7 != var4) {
               if (var2.b()) {
                  var3 = this.b(var2, var4);
               } else {
                  var3 = var4;
               }

               boolean var8 = this.a(var3);
               this.b = var4 - var3;
               if (!var8 && var2.b()) {
                  var1.b(var2);
               }

               var2.a(this.b());
               byte var11;
               if (var4 < var7) {
                  var11 = -1;
               } else {
                  var11 = 1;
               }

               this.a(var1, var2, var4, var11, false);
               var3 = var7 - var4;
            }
         } else {
            this.b = 0;
            var3 = var6;
         }

         return var3;
      }

      void a(CoordinatorLayout var1, AppBarLayout var2) {
         this.c(var1, var2);
      }

      public void a(CoordinatorLayout var1, AppBarLayout var2, Parcelable var3) {
         if (var3 instanceof AppBarLayout.Behavior.SavedState) {
            var3 = var3;
            super.a(var1, var2, var3.a());
            this.d = var3.a;
            this.f = var3.b;
            this.e = var3.c;
         } else {
            super.a(var1, var2, var3);
            this.d = -1;
         }
      }

      public void a(CoordinatorLayout var1, AppBarLayout var2, View var3, int var4) {
         if (var4 == 0) {
            this.c(var1, var2);
         }

         this.g = new WeakReference<>(var3);
      }

      public void a(CoordinatorLayout var1, AppBarLayout var2, View var3, int var4, int var5, int var6, int var7, int var8) {
         if (var7 < 0) {
            this.b(var1, var2, var7, -var2.getDownNestedScrollRange(), 0);
         }
      }

      public void a(CoordinatorLayout var1, AppBarLayout var2, View var3, int var4, int var5, int[] var6, int var7) {
         if (var5 != 0) {
            if (var5 < 0) {
               var7 = -var2.getTotalScrollRange();
               var4 = var7 + var2.getDownNestedPreScrollRange();
            } else {
               var7 = -var2.getUpNestedPreScrollRange();
               var4 = 0;
            }

            if (var7 != var4) {
               var6[1] = this.b(var1, var2, var5, var7, var4);
            }
         }
      }

      boolean a(AppBarLayout var1) {
         boolean var2;
         if (this.h != null) {
            var2 = this.h.a(var1);
         } else if (this.g != null) {
            View var3 = this.g.get();
            if (var3 != null && var3.isShown() && !var3.canScrollVertically(-1)) {
               var2 = true;
            } else {
               var2 = false;
            }
         } else {
            var2 = true;
         }

         return var2;
      }

      public boolean a(CoordinatorLayout var1, AppBarLayout var2, int var3) {
         boolean var5 = super.a(var1, var2, var3);
         int var4 = var2.getPendingAction();
         if (this.d >= 0 && (var4 & 8) == 0) {
            View var6 = var2.getChildAt(this.d);
            var3 = -var6.getBottom();
            if (this.e) {
               var3 = ViewCompat.k(var6) + var2.getTopInset() + var3;
            } else {
               var3 = Math.round(var6.getHeight() * this.f) + var3;
            }

            this.a_(var1, var2, var3);
         } else if (var4 != 0) {
            boolean var7;
            if ((var4 & 4) != 0) {
               var7 = true;
            } else {
               var7 = false;
            }

            if ((var4 & 2) != 0) {
               var4 = -var2.getUpNestedPreScrollRange();
               if (var7) {
                  this.a(var1, var2, var4, 0.0F);
               } else {
                  this.a_(var1, var2, var4);
               }
            } else if ((var4 & 1) != 0) {
               if (var7) {
                  this.a(var1, var2, 0, 0.0F);
               } else {
                  this.a_(var1, var2, 0);
               }
            }
         }

         var2.d();
         this.d = -1;
         this.a(MathUtils.a(this.b(), -var2.getTotalScrollRange(), 0));
         this.a(var1, var2, this.b(), 0, true);
         var2.a(this.b());
         return var5;
      }

      public boolean a(CoordinatorLayout var1, AppBarLayout var2, int var3, int var4, int var5, int var6) {
         boolean var7;
         if (((CoordinatorLayout.LayoutParams)var2.getLayoutParams()).height == -2) {
            var1.a(var2, var3, var4, MeasureSpec.makeMeasureSpec(0, 0), var6);
            var7 = true;
         } else {
            var7 = super.a(var1, var2, var3, var4, var5, var6);
         }

         return var7;
      }

      public boolean a(CoordinatorLayout var1, AppBarLayout var2, View var3, View var4, int var5, int var6) {
         boolean var7;
         if ((var5 & 2) != 0 && var2.c() && var1.getHeight() - var3.getHeight() <= var2.getHeight()) {
            var7 = true;
         } else {
            var7 = false;
         }

         if (var7 && this.c != null) {
            this.c.cancel();
         }

         this.g = null;
         return var7;
      }

      int b(AppBarLayout var1) {
         return -var1.getDownNestedScrollRange();
      }

      public Parcelable b(CoordinatorLayout var1, AppBarLayout var2) {
         boolean var7 = false;
         Parcelable var9 = super.b(var1, var2);
         int var4 = this.b();
         int var5 = var2.getChildCount();

         for (int var3 = 0; var3 < var5; var3++) {
            View var8 = var2.getChildAt(var3);
            int var6 = var8.getBottom() + var4;
            if (var8.getTop() + var4 <= 0 && var6 >= 0) {
               var9 = new AppBarLayout.Behavior.SavedState(var9);
               var9.a = var3;
               if (var6 == ViewCompat.k(var8) + var2.getTopInset()) {
                  var7 = true;
               }

               var9.c = var7;
               var9.b = (float)var6 / var8.getHeight();
               break;
            }
         }

         return var9;
      }

      int c(AppBarLayout var1) {
         return var1.getTotalScrollRange();
      }

      public abstract static class DragCallback {
         public abstract boolean a(AppBarLayout var1);
      }

      protected static class SavedState extends AbsSavedState {
         public static final Creator<AppBarLayout.Behavior.SavedState> CREATOR = new ClassLoaderCreator<AppBarLayout.Behavior.SavedState>() {
            public AppBarLayout.Behavior.SavedState a(Parcel var1) {
               return new AppBarLayout.Behavior.SavedState(var1, null);
            }

            public AppBarLayout.Behavior.SavedState a(Parcel var1, ClassLoader var2) {
               return new AppBarLayout.Behavior.SavedState(var1, var2);
            }

            public AppBarLayout.Behavior.SavedState[] a(int var1) {
               return new AppBarLayout.Behavior.SavedState[var1];
            }
         };
         int a;
         float b;
         boolean c;

         public SavedState(Parcel var1, ClassLoader var2) {
            super(var1, var2);
            this.a = var1.readInt();
            this.b = var1.readFloat();
            boolean var3;
            if (var1.readByte() != 0) {
               var3 = true;
            } else {
               var3 = false;
            }

            this.c = var3;
         }

         public SavedState(Parcelable var1) {
            super(var1);
         }

         @Override
         public void writeToParcel(Parcel var1, int var2) {
            super.writeToParcel(var1, var2);
            var1.writeInt(this.a);
            var1.writeFloat(this.b);
            byte var3;
            if (this.c) {
               var3 = 1;
            } else {
               var3 = 0;
            }

            var1.writeByte((byte)var3);
         }
      }
   }

   public static class LayoutParams extends android.widget.LinearLayout.LayoutParams {
      int a = 1;
      Interpolator b;

      public LayoutParams(int var1, int var2) {
         super(var1, var2);
      }

      public LayoutParams(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.AppBarLayout_Layout);
         this.a = var3.getInt(R.styleable.AppBarLayout_Layout_layout_scrollFlags, 0);
         if (var3.hasValue(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator)) {
            this.b = android.view.animation.AnimationUtils.loadInterpolator(
               var1, var3.getResourceId(R.styleable.AppBarLayout_Layout_layout_scrollInterpolator, 0)
            );
         }

         var3.recycle();
      }

      public LayoutParams(android.view.ViewGroup.LayoutParams var1) {
         super(var1);
      }

      public LayoutParams(MarginLayoutParams var1) {
         super(var1);
      }

      public LayoutParams(android.widget.LinearLayout.LayoutParams var1) {
         super(var1);
      }

      public int a() {
         return this.a;
      }

      public Interpolator b() {
         return this.b;
      }

      boolean c() {
         boolean var1 = true;
         if ((this.a & 1) != 1 || (this.a & 10) == 0) {
            var1 = false;
         }

         return var1;
      }
   }

   public interface OnOffsetChangedListener {
      void a(AppBarLayout var1, int var2);
   }

   public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
      public ScrollingViewBehavior() {
      }

      public ScrollingViewBehavior(Context var1, AttributeSet var2) {
         super(var1, var2);
         TypedArray var3 = var1.obtainStyledAttributes(var2, R.styleable.ScrollingViewBehavior_Layout);
         this.b(var3.getDimensionPixelSize(R.styleable.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
         var3.recycle();
      }

      private static int a(AppBarLayout var0) {
         CoordinatorLayout.Behavior var2 = ((CoordinatorLayout.LayoutParams)var0.getLayoutParams()).b();
         int var1;
         if (var2 instanceof AppBarLayout.Behavior) {
            var1 = ((AppBarLayout.Behavior)var2).a();
         } else {
            var1 = 0;
         }

         return var1;
      }

      private void e(CoordinatorLayout var1, View var2, View var3) {
         CoordinatorLayout.Behavior var6 = ((CoordinatorLayout.LayoutParams)var3.getLayoutParams()).b();
         if (var6 instanceof AppBarLayout.Behavior) {
            AppBarLayout.Behavior var7 = (AppBarLayout.Behavior)var6;
            int var4 = var3.getBottom();
            int var5 = var2.getTop();
            ViewCompat.c(var2, var7.b + (var4 - var5) + this.a() - this.c(var3));
         }
      }

      @Override
      float a(View var1) {
         float var3 = 0.0F;
         float var2 = var3;
         if (var1 instanceof AppBarLayout) {
            AppBarLayout var7 = (AppBarLayout)var1;
            int var6 = var7.getTotalScrollRange();
            int var5 = var7.getDownNestedPreScrollRange();
            int var4 = a(var7);
            if (var5 != 0 && var6 + var4 <= var5) {
               var2 = var3;
            } else {
               var5 = var6 - var5;
               var2 = var3;
               if (var5 != 0) {
                  var2 = 1.0F + (float)var4 / var5;
               }
            }
         }

         return var2;
      }

      AppBarLayout a(List<View> var1) {
         int var3 = var1.size();
         int var2 = 0;

         while (true) {
            if (var2 >= var3) {
               var5 = null;
               break;
            }

            View var4 = (View)var1.get(var2);
            if (var4 instanceof AppBarLayout) {
               var5 = (AppBarLayout)var4;
               break;
            }

            var2++;
         }

         return var5;
      }

      @Override
      public boolean a(CoordinatorLayout var1, View var2, Rect var3, boolean var4) {
         boolean var5 = true;
         AppBarLayout var6 = this.a(var1.c(var2));
         if (var6 != null) {
            var3.offset(var2.getLeft(), var2.getTop());
            Rect var7 = this.a;
            var7.set(0, 0, var1.getWidth(), var1.getHeight());
            if (!var7.contains(var3)) {
               if (!var4) {
                  var4 = true;
               } else {
                  var4 = false;
               }

               var6.a(false, var4);
               return var5;
            }
         }

         return false;
      }

      @Override
      public boolean a(CoordinatorLayout var1, View var2, View var3) {
         return var3 instanceof AppBarLayout;
      }

      @Override
      int b(View var1) {
         int var2;
         if (var1 instanceof AppBarLayout) {
            var2 = ((AppBarLayout)var1).getTotalScrollRange();
         } else {
            var2 = super.b(var1);
         }

         return var2;
      }

      @Override
      public boolean b(CoordinatorLayout var1, View var2, View var3) {
         this.e(var1, var2, var3);
         return false;
      }
   }
}
