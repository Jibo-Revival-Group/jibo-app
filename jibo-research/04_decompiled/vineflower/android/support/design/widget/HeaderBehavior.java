package android.support.design.widget;

import android.content.Context;
import android.support.v4.math.MathUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
   OverScroller a;
   private Runnable b;
   private boolean c;
   private int d = -1;
   private int e;
   private int f = -1;
   private VelocityTracker g;

   public HeaderBehavior() {
   }

   public HeaderBehavior(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   private void d() {
      if (this.g == null) {
         this.g = VelocityTracker.obtain();
      }
   }

   int a() {
      return this.b();
   }

   int a(CoordinatorLayout var1, V var2, int var3, int var4, int var5) {
      int var8 = this.b();
      byte var7 = 0;
      int var6 = var7;
      if (var4 != 0) {
         var6 = var7;
         if (var8 >= var4) {
            var6 = var7;
            if (var8 <= var5) {
               var3 = MathUtils.a(var3, var4, var5);
               var6 = var7;
               if (var8 != var3) {
                  this.a(var3);
                  var6 = var8 - var3;
               }
            }
         }
      }

      return var6;
   }

   int a(V var1) {
      return var1.getHeight();
   }

   void a(CoordinatorLayout var1, V var2) {
   }

   final boolean a(CoordinatorLayout var1, V var2, int var3, int var4, float var5) {
      boolean var6 = false;
      if (this.b != null) {
         var2.removeCallbacks(this.b);
         this.b = null;
      }

      if (this.a == null) {
         this.a = new OverScroller(var2.getContext());
      }

      this.a.fling(0, this.b(), 0, Math.round(var5), 0, 0, var3, var4);
      if (this.a.computeScrollOffset()) {
         this.b = new HeaderBehavior.FlingRunnable(this, (V)var1, var2);
         ViewCompat.a(var2, this.b);
         var6 = true;
      } else {
         this.a(var1, (V)var2);
      }

      return var6;
   }

   @Override
   public boolean a(CoordinatorLayout var1, V var2, MotionEvent var3) {
      boolean var6 = true;
      if (this.f < 0) {
         this.f = ViewConfiguration.get(var1.getContext()).getScaledTouchSlop();
      }

      if (var3.getAction() != 2 || !this.c) {
         switch (var3.getActionMasked()) {
            case 0:
               this.c = false;
               int var5 = (int)var3.getX();
               int var9 = (int)var3.getY();
               if (this.c((V)var2) && var1.a(var2, var5, var9)) {
                  this.e = var9;
                  this.d = var3.getPointerId(0);
                  this.d();
               }
               break;
            case 1:
            case 3:
               this.c = false;
               this.d = -1;
               if (this.g != null) {
                  this.g.recycle();
                  this.g = null;
               }
               break;
            case 2:
               int var4 = this.d;
               if (var4 != -1) {
                  var4 = var3.findPointerIndex(var4);
                  if (var4 != -1) {
                     var4 = (int)var3.getY(var4);
                     if (Math.abs(var4 - this.e) > this.f) {
                        this.c = true;
                        this.e = var4;
                     }
                  }
               }
         }

         if (this.g != null) {
            this.g.addMovement(var3);
         }

         var6 = this.c;
      }

      return var6;
   }

   int a_(CoordinatorLayout var1, V var2, int var3) {
      return this.a(var1, (V)var2, var3, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }

   final int b(CoordinatorLayout var1, V var2, int var3, int var4, int var5) {
      return this.a(var1, (V)var2, this.a() - var3, var4, var5);
   }

   int b(V var1) {
      return -var1.getHeight();
   }

   @Override
   public boolean b(CoordinatorLayout var1, V var2, MotionEvent var3) {
      boolean var9 = false;
      if (this.f < 0) {
         this.f = ViewConfiguration.get(var1.getContext()).getScaledTouchSlop();
      }

      switch (var3.getActionMasked()) {
         case 0:
            int var12 = (int)var3.getX();
            int var11 = (int)var3.getY();
            boolean var13 = var9;
            if (!var1.a(var2, var12, var11)) {
               return var13;
            }

            var13 = var9;
            if (!this.c((V)var2)) {
               return var13;
            }

            this.e = var11;
            this.d = var3.getPointerId(0);
            this.d();
            break;
         case 1:
            if (this.g != null) {
               this.g.addMovement(var3);
               this.g.computeCurrentVelocity(1000);
               float var4 = this.g.getYVelocity(this.d);
               this.a(var1, (V)var2, -this.a((V)var2), 0, var4);
            }
         case 3:
            this.c = false;
            this.d = -1;
            if (this.g != null) {
               this.g.recycle();
               this.g = null;
            }
            break;
         case 2:
            int var5 = var3.findPointerIndex(this.d);
            boolean var8 = var9;
            if (var5 == -1) {
               return var8;
            }

            int var7 = (int)var3.getY(var5);
            int var6 = this.e - var7;
            var5 = var6;
            if (!this.c) {
               var5 = var6;
               if (Math.abs(var6) > this.f) {
                  this.c = true;
                  if (var6 > 0) {
                     var5 = var6 - this.f;
                  } else {
                     var5 = var6 + this.f;
                  }
               }
            }

            if (this.c) {
               this.e = var7;
               this.b(var1, (V)var2, var5, this.b((V)var2), 0);
            }
      }

      if (this.g != null) {
         this.g.addMovement(var3);
      }

      return true;
   }

   boolean c(V var1) {
      return false;
   }

   private class FlingRunnable implements Runnable {
      final HeaderBehavior a;
      private final CoordinatorLayout b;
      private final V c;

      FlingRunnable(HeaderBehavior var1, CoordinatorLayout var2, View var3) {
         this.a = var1;
         this.b = var2;
         this.c = (V)var3;
      }

      @Override
      public void run() {
         if (this.c != null && this.a.a != null) {
            if (this.a.a.computeScrollOffset()) {
               this.a.a_(this.b, this.c, this.a.a.getCurrY());
               ViewCompat.a(this.c, this);
            } else {
               this.a.a(this.b, this.c);
            }
         }
      }
   }
}
