package android.support.v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;

public final class ViewPropertyAnimatorCompat {
   Runnable a = null;
   Runnable b = null;
   int c = -1;
   private WeakReference<View> d;

   ViewPropertyAnimatorCompat(View var1) {
      this.d = new WeakReference<>(var1);
   }

   private void a(View var1, ViewPropertyAnimatorListener var2) {
      if (var2 != null) {
         var1.animate().setListener(new AnimatorListenerAdapter(this, var2, var1) {
            final ViewPropertyAnimatorListener a;
            final View b;
            final ViewPropertyAnimatorCompat c;

            {
               this.c = var1;
               this.a = var2x;
               this.b = var3;
            }

            public void onAnimationCancel(Animator var1) {
               this.a.c(this.b);
            }

            public void onAnimationEnd(Animator var1) {
               this.a.b(this.b);
            }

            public void onAnimationStart(Animator var1) {
               this.a.a(this.b);
            }
         });
      } else {
         var1.animate().setListener(null);
      }
   }

   public long a() {
      View var3 = this.d.get();
      long var1;
      if (var3 != null) {
         var1 = var3.animate().getDuration();
      } else {
         var1 = 0L;
      }

      return var1;
   }

   public ViewPropertyAnimatorCompat a(float var1) {
      View var2 = this.d.get();
      if (var2 != null) {
         var2.animate().alpha(var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat a(long var1) {
      View var3 = this.d.get();
      if (var3 != null) {
         var3.animate().setDuration(var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat a(ViewPropertyAnimatorListener var1) {
      View var2 = this.d.get();
      if (var2 != null) {
         if (VERSION.SDK_INT >= 16) {
            this.a(var2, var1);
         } else {
            var2.setTag(2113929216, var1);
            this.a(var2, new ViewPropertyAnimatorCompat.ViewPropertyAnimatorListenerApi14(this));
         }
      }

      return this;
   }

   public ViewPropertyAnimatorCompat a(ViewPropertyAnimatorUpdateListener var1) {
      View var3 = this.d.get();
      if (var3 != null && VERSION.SDK_INT >= 19) {
         AnimatorUpdateListener var2 = null;
         if (var1 != null) {
            var2 = new AnimatorUpdateListener(this, var1, var3) {
               final ViewPropertyAnimatorUpdateListener a;
               final View b;
               final ViewPropertyAnimatorCompat c;

               {
                  this.c = var1;
                  this.a = var2x;
                  this.b = var3x;
               }

               public void onAnimationUpdate(ValueAnimator var1) {
                  this.a.a(this.b);
               }
            };
         }

         var3.animate().setUpdateListener(var2);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat a(Interpolator var1) {
      View var2 = this.d.get();
      if (var2 != null) {
         var2.animate().setInterpolator(var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat b(float var1) {
      View var2 = this.d.get();
      if (var2 != null) {
         var2.animate().translationY(var1);
      }

      return this;
   }

   public ViewPropertyAnimatorCompat b(long var1) {
      View var3 = this.d.get();
      if (var3 != null) {
         var3.animate().setStartDelay(var1);
      }

      return this;
   }

   public void b() {
      View var1 = this.d.get();
      if (var1 != null) {
         var1.animate().cancel();
      }
   }

   public void c() {
      View var1 = this.d.get();
      if (var1 != null) {
         var1.animate().start();
      }
   }

   static class ViewPropertyAnimatorListenerApi14 implements ViewPropertyAnimatorListener {
      ViewPropertyAnimatorCompat a;
      boolean b;

      ViewPropertyAnimatorListenerApi14(ViewPropertyAnimatorCompat var1) {
         this.a = var1;
      }

      @Override
      public void a(View var1) {
         this.b = false;
         if (this.a.c > -1) {
            var1.setLayerType(2, null);
         }

         if (this.a.a != null) {
            Runnable var2 = this.a.a;
            this.a.a = null;
            var2.run();
         }

         ViewPropertyAnimatorListener var3 = (ViewPropertyAnimatorListener)var1.getTag(2113929216);
         if (var3 instanceof ViewPropertyAnimatorListener) {
            var3 = var3;
         } else {
            var3 = null;
         }

         if (var3 != null) {
            var3.a(var1);
         }
      }

      @Override
      public void b(View var1) {
         if (this.a.c > -1) {
            var1.setLayerType(this.a.c, null);
            this.a.c = -1;
         }

         if (VERSION.SDK_INT >= 16 || !this.b) {
            if (this.a.b != null) {
               Runnable var2 = this.a.b;
               this.a.b = null;
               var2.run();
            }

            ViewPropertyAnimatorListener var3 = (ViewPropertyAnimatorListener)var1.getTag(2113929216);
            if (var3 instanceof ViewPropertyAnimatorListener) {
               var3 = var3;
            } else {
               var3 = null;
            }

            if (var3 != null) {
               var3.b(var1);
            }

            this.b = true;
         }
      }

      @Override
      public void c(View var1) {
         ViewPropertyAnimatorListener var2 = (ViewPropertyAnimatorListener)var1.getTag(2113929216);
         if (var2 instanceof ViewPropertyAnimatorListener) {
            var2 = var2;
         } else {
            var2 = null;
         }

         if (var2 != null) {
            var2.c(var1);
         }
      }
   }
}
