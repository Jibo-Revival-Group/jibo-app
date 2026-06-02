package android.support.design.widget;

import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
   private boolean a;
   ViewDragHelper b;
   SwipeDismissBehavior.OnDismissListener c;
   int d;
   float e;
   float f;
   float g;
   private float h = 0.0F;
   private boolean i;
   private final ViewDragHelper.Callback j;

   public SwipeDismissBehavior() {
      this.d = 2;
      this.e = 0.5F;
      this.f = 0.0F;
      this.g = 0.5F;
      this.j = new ViewDragHelper.Callback(this) {
         final SwipeDismissBehavior a;
         private int b;
         private int c;

         {
            this.a = var1;
            this.c = -1;
         }

         private boolean a(View var1, float var2) {
            boolean var6 = true;
            if (var2 != 0.0F) {
               boolean var3;
               if (ViewCompat.e(var1) == 1) {
                  var3 = true;
               } else {
                  var3 = false;
               }

               if (this.a.d != 2) {
                  if (this.a.d == 0) {
                     if (var3) {
                        if (!(var2 < 0.0F)) {
                           var6 = false;
                        }
                     } else if (!(var2 > 0.0F)) {
                        var6 = false;
                     }
                  } else if (this.a.d == 1) {
                     if (var3) {
                        if (!(var2 > 0.0F)) {
                           var6 = false;
                        }
                     } else if (!(var2 < 0.0F)) {
                        var6 = false;
                     }
                  } else {
                     var6 = false;
                  }
               }
            } else {
               int var5 = var1.getLeft();
               int var4 = this.b;
               int var7 = Math.round(var1.getWidth() * this.a.e);
               if (Math.abs(var5 - var4) < var7) {
                  var6 = false;
               }
            }

            return var6;
         }

         @Override
         public int a(View var1, int var2, int var3) {
            return var1.getTop();
         }

         @Override
         public void a(int var1) {
            if (this.a.c != null) {
               this.a.c.a(var1);
            }
         }

         @Override
         public void a(View var1, float var2, float var3) {
            this.c = -1;
            int var4 = var1.getWidth();
            boolean var5 = false;
            if (this.a(var1, var2)) {
               if (var1.getLeft() < this.b) {
                  var4 = this.b - var4;
               } else {
                  var4 = this.b + var4;
               }

               var5 = true;
            } else {
               var4 = this.b;
            }

            if (this.a.b.a(var4, var1.getTop())) {
               ViewCompat.a(var1, this.a.new SettleRunnable(this.a, var1, var5));
            } else if (var5 && this.a.c != null) {
               this.a.c.a(var1);
            }
         }

         @Override
         public void a(View var1, int var2, int var3, int var4, int var5) {
            float var7 = this.b + var1.getWidth() * this.a.f;
            float var6 = this.b + var1.getWidth() * this.a.g;
            if (var2 <= var7) {
               var1.setAlpha(1.0F);
            } else if (var2 >= var6) {
               var1.setAlpha(0.0F);
            } else {
               var1.setAlpha(SwipeDismissBehavior.a(0.0F, 1.0F - SwipeDismissBehavior.b(var7, var6, var2), 1.0F));
            }
         }

         @Override
         public boolean a(View var1, int var2) {
            boolean var3;
            if (this.c == -1 && this.a.a(var1)) {
               var3 = true;
            } else {
               var3 = false;
            }

            return var3;
         }

         @Override
         public int b(View var1) {
            return var1.getWidth();
         }

         @Override
         public int b(View var1, int var2, int var3) {
            boolean var5;
            if (ViewCompat.e(var1) == 1) {
               var5 = 1;
            } else {
               var5 = 0;
            }

            int var4;
            if (this.a.d == 0) {
               if (var5) {
                  var4 = this.b - var1.getWidth();
                  var5 = this.b;
               } else {
                  var4 = this.b;
                  var5 = this.b + var1.getWidth();
               }
            } else if (this.a.d == 1) {
               if (var5) {
                  var4 = this.b;
                  var5 = this.b + var1.getWidth();
               } else {
                  var4 = this.b - var1.getWidth();
                  var5 = this.b;
               }
            } else {
               var4 = this.b - var1.getWidth();
               var5 = this.b + var1.getWidth();
            }

            return SwipeDismissBehavior.a(var4, var2, var5);
         }

         @Override
         public void b(View var1, int var2) {
            this.c = var2;
            this.b = var1.getLeft();
            ViewParent var3 = var1.getParent();
            if (var3 != null) {
               var3.requestDisallowInterceptTouchEvent(true);
            }
         }
      };
   }

   static float a(float var0, float var1, float var2) {
      return Math.min(Math.max(var0, var1), var2);
   }

   static int a(int var0, int var1, int var2) {
      return Math.min(Math.max(var0, var1), var2);
   }

   private void a(ViewGroup var1) {
      if (this.b == null) {
         ViewDragHelper var2;
         if (this.i) {
            var2 = ViewDragHelper.a(var1, this.h, this.j);
         } else {
            var2 = ViewDragHelper.a(var1, this.j);
         }

         this.b = var2;
      }
   }

   static float b(float var0, float var1, float var2) {
      return (var2 - var0) / (var1 - var0);
   }

   public void a(float var1) {
      this.f = a(0.0F, var1, 1.0F);
   }

   public void a(int var1) {
      this.d = var1;
   }

   public void a(SwipeDismissBehavior.OnDismissListener var1) {
      this.c = var1;
   }

   @Override
   public boolean a(CoordinatorLayout var1, V var2, MotionEvent var3) {
      boolean var5 = false;
      boolean var6 = this.a;
      boolean var4 = var6;
      switch (var3.getActionMasked()) {
         case 0:
            this.a = var1.a(var2, (int)var3.getX(), (int)var3.getY());
            var4 = this.a;
            break;
         case 1:
         case 3:
            this.a = false;
            var4 = var6;
         case 2:
            break;
         default:
            var4 = var6;
      }

      if (var4) {
         this.a(var1);
         var5 = this.b.a(var3);
      }

      return var5;
   }

   public boolean a(View var1) {
      return true;
   }

   public void b(float var1) {
      this.g = a(0.0F, var1, 1.0F);
   }

   @Override
   public boolean b(CoordinatorLayout var1, V var2, MotionEvent var3) {
      boolean var4;
      if (this.b != null) {
         this.b.b(var3);
         var4 = true;
      } else {
         var4 = false;
      }

      return var4;
   }

   public interface OnDismissListener {
      void a(int var1);

      void a(View var1);
   }

   private class SettleRunnable implements Runnable {
      final SwipeDismissBehavior a;
      private final View b;
      private final boolean c;

      SettleRunnable(SwipeDismissBehavior var1, View var2, boolean var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      @Override
      public void run() {
         if (this.a.b != null && this.a.b.a(true)) {
            ViewCompat.a(this.b, this);
         } else if (this.c && this.a.c != null) {
            this.a.c.a(this.b);
         }
      }
   }
}
