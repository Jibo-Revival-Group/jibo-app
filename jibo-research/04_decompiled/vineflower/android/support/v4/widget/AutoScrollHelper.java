package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.View.OnTouchListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class AutoScrollHelper implements OnTouchListener {
   private static final int r = ViewConfiguration.getTapTimeout();
   final AutoScrollHelper.ClampedScroller a = new AutoScrollHelper.ClampedScroller();
   final View b;
   boolean c;
   boolean d;
   boolean e;
   private final Interpolator f = new AccelerateInterpolator();
   private Runnable g;
   private float[] h = new float[]{0.0F, 0.0F};
   private float[] i = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
   private int j;
   private int k;
   private float[] l = new float[]{0.0F, 0.0F};
   private float[] m = new float[]{0.0F, 0.0F};
   private float[] n = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
   private boolean o;
   private boolean p;
   private boolean q;

   public AutoScrollHelper(View var1) {
      this.b = var1;
      DisplayMetrics var4 = Resources.getSystem().getDisplayMetrics();
      int var2 = (int)(1575.0F * var4.density + 0.5F);
      int var3 = (int)(var4.density * 315.0F + 0.5F);
      this.a((float)var2, (float)var2);
      this.b(var3, var3);
      this.a(1);
      this.e(Float.MAX_VALUE, Float.MAX_VALUE);
      this.d(0.2F, 0.2F);
      this.c(1.0F, 1.0F);
      this.b(r);
      this.c(500);
      this.d(500);
   }

   static float a(float var0, float var1, float var2) {
      if (!(var0 > var2)) {
         if (var0 < var1) {
            var2 = var1;
         } else {
            var2 = var0;
         }
      }

      return var2;
   }

   private float a(float var1, float var2, float var3, float var4) {
      float var5 = 0.0F;
      var1 = a(var1 * var2, 0.0F, var3);
      var3 = this.f(var4, var1);
      var2 = this.f(var2 - var4, var1) - var3;
      if (var2 < 0.0F) {
         var1 = -this.f.getInterpolation(-var2);
      } else {
         var1 = var5;
         if (!(var2 > 0.0F)) {
            return var1;
         }

         var1 = this.f.getInterpolation(var2);
      }

      return a(var1, -1.0F, 1.0F);
   }

   private float a(int var1, float var2, float var3, float var4) {
      float var5 = 0.0F;
      var2 = this.a(this.h[var1], var3, this.i[var1], var2);
      if (var2 == 0.0F) {
         var2 = var5;
      } else {
         float var6 = this.l[var1];
         var5 = this.m[var1];
         var3 = this.n[var1];
         var4 = var6 * var4;
         if (var2 > 0.0F) {
            var2 = a(var2 * var4, var5, var3);
         } else {
            var2 = -a(-var2 * var4, var5, var3);
         }
      }

      return var2;
   }

   static int a(int var0, int var1, int var2) {
      if (var0 <= var2) {
         if (var0 < var1) {
            var2 = var1;
         } else {
            var2 = var0;
         }
      }

      return var2;
   }

   private void c() {
      if (this.g == null) {
         this.g = new AutoScrollHelper.ScrollAnimationRunnable(this);
      }

      this.e = true;
      this.c = true;
      if (!this.o && this.k > 0) {
         ViewCompat.a(this.b, this.g, this.k);
      } else {
         this.g.run();
      }

      this.o = true;
   }

   private void d() {
      if (this.c) {
         this.e = false;
      } else {
         this.a.b();
      }
   }

   private float f(float var1, float var2) {
      float var4 = 0.0F;
      float var3;
      if (var2 == 0.0F) {
         var3 = var4;
      } else {
         switch (this.j) {
            case 0:
            case 1:
               var3 = var4;
               if (var1 < var2) {
                  if (var1 >= 0.0F) {
                     var3 = 1.0F - var1 / var2;
                  } else {
                     var3 = var4;
                     if (this.e) {
                        var3 = var4;
                        if (this.j == 1) {
                           var3 = 1.0F;
                        }
                     }
                  }
               }
               break;
            case 2:
               var3 = var4;
               if (var1 < 0.0F) {
                  var3 = var1 / -var2;
               }
               break;
            default:
               var3 = var4;
         }
      }

      return var3;
   }

   public AutoScrollHelper a(float var1, float var2) {
      this.n[0] = var1 / 1000.0F;
      this.n[1] = var2 / 1000.0F;
      return this;
   }

   public AutoScrollHelper a(int var1) {
      this.j = var1;
      return this;
   }

   public AutoScrollHelper a(boolean var1) {
      if (this.p && !var1) {
         this.d();
      }

      this.p = var1;
      return this;
   }

   public abstract void a(int var1, int var2);

   boolean a() {
      AutoScrollHelper.ClampedScroller var4 = this.a;
      int var1 = var4.f();
      int var2 = var4.e();
      boolean var3;
      if ((var1 == 0 || !this.f(var1)) && (var2 == 0 || !this.e(var2))) {
         var3 = false;
      } else {
         var3 = true;
      }

      return var3;
   }

   public AutoScrollHelper b(float var1, float var2) {
      this.m[0] = var1 / 1000.0F;
      this.m[1] = var2 / 1000.0F;
      return this;
   }

   public AutoScrollHelper b(int var1) {
      this.k = var1;
      return this;
   }

   void b() {
      long var1 = SystemClock.uptimeMillis();
      MotionEvent var3 = MotionEvent.obtain(var1, var1, 3, 0.0F, 0.0F, 0);
      this.b.onTouchEvent(var3);
      var3.recycle();
   }

   public AutoScrollHelper c(float var1, float var2) {
      this.l[0] = var1 / 1000.0F;
      this.l[1] = var2 / 1000.0F;
      return this;
   }

   public AutoScrollHelper c(int var1) {
      this.a.a(var1);
      return this;
   }

   public AutoScrollHelper d(float var1, float var2) {
      this.h[0] = var1;
      this.h[1] = var2;
      return this;
   }

   public AutoScrollHelper d(int var1) {
      this.a.b(var1);
      return this;
   }

   public AutoScrollHelper e(float var1, float var2) {
      this.i[0] = var1;
      this.i[1] = var2;
      return this;
   }

   public abstract boolean e(int var1);

   public abstract boolean f(int var1);

   public boolean onTouch(View var1, MotionEvent var2) {
      boolean var6 = true;
      boolean var5 = false;
      if (this.p) {
         switch (var2.getActionMasked()) {
            case 0:
               this.d = true;
               this.o = false;
            case 2:
               float var3 = this.a(0, var2.getX(), var1.getWidth(), this.b.getWidth());
               float var4 = this.a(1, var2.getY(), var1.getHeight(), this.b.getHeight());
               this.a.a(var3, var4);
               if (!this.e && this.a()) {
                  this.c();
               }
               break;
            case 1:
            case 3:
               this.d();
         }

         if (this.q && this.e) {
            var5 = var6;
         } else {
            var5 = false;
         }
      }

      return var5;
   }

   private static class ClampedScroller {
      private int a;
      private int b;
      private float c;
      private float d;
      private long e = Long.MIN_VALUE;
      private long f;
      private int g;
      private int h;
      private long i = -1L;
      private float j;
      private int k;

      ClampedScroller() {
         this.f = 0L;
         this.g = 0;
         this.h = 0;
      }

      private float a(float var1) {
         return -4.0F * var1 * var1 + 4.0F * var1;
      }

      private float a(long var1) {
         float var3 = 0.0F;
         if (var1 >= this.e) {
            if (this.i >= 0L && var1 >= this.i) {
               long var5 = this.i;
               var3 = this.j;
               float var4 = this.j;
               var3 = AutoScrollHelper.a((float)(var1 - var5) / this.k, 0.0F, 1.0F) * var4 + (1.0F - var3);
            } else {
               var3 = AutoScrollHelper.a((float)(var1 - this.e) / this.a, 0.0F, 1.0F) * 0.5F;
            }
         }

         return var3;
      }

      public void a() {
         this.e = AnimationUtils.currentAnimationTimeMillis();
         this.i = -1L;
         this.f = this.e;
         this.j = 0.5F;
         this.g = 0;
         this.h = 0;
      }

      public void a(float var1, float var2) {
         this.c = var1;
         this.d = var2;
      }

      public void a(int var1) {
         this.a = var1;
      }

      public void b() {
         long var1 = AnimationUtils.currentAnimationTimeMillis();
         this.k = AutoScrollHelper.a((int)(var1 - this.e), 0, this.b);
         this.j = this.a(var1);
         this.i = var1;
      }

      public void b(int var1) {
         this.b = var1;
      }

      public boolean c() {
         boolean var1;
         if (this.i > 0L && AnimationUtils.currentAnimationTimeMillis() > this.i + this.k) {
            var1 = true;
         } else {
            var1 = false;
         }

         return var1;
      }

      public void d() {
         if (this.f == 0L) {
            throw new RuntimeException("Cannot compute scroll delta before calling start()");
         }

         long var2 = AnimationUtils.currentAnimationTimeMillis();
         float var1 = this.a(this.a(var2));
         long var4 = var2 - this.f;
         this.f = var2;
         this.g = (int)((float)var4 * var1 * this.c);
         this.h = (int)((float)var4 * var1 * this.d);
      }

      public int e() {
         return (int)(this.c / Math.abs(this.c));
      }

      public int f() {
         return (int)(this.d / Math.abs(this.d));
      }

      public int g() {
         return this.g;
      }

      public int h() {
         return this.h;
      }
   }

   private class ScrollAnimationRunnable implements Runnable {
      final AutoScrollHelper a;

      ScrollAnimationRunnable(AutoScrollHelper var1) {
         this.a = var1;
      }

      @Override
      public void run() {
         if (this.a.e) {
            if (this.a.c) {
               this.a.c = false;
               this.a.a.a();
            }

            AutoScrollHelper.ClampedScroller var3 = this.a.a;
            if (!var3.c() && this.a.a()) {
               if (this.a.d) {
                  this.a.d = false;
                  this.a.b();
               }

               var3.d();
               int var2 = var3.g();
               int var1 = var3.h();
               this.a.a(var2, var1);
               ViewCompat.a(this.a.b, this);
            } else {
               this.a.e = false;
            }
         }
      }
   }
}
