package android.support.v4.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path.FillType;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.Preconditions;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

public class CircularProgressDrawable extends Drawable implements Animatable {
   private static final Interpolator a = new LinearInterpolator();
   private static final Interpolator b = new FastOutSlowInInterpolator();
   private static final int[] c = new int[]{-16777216};
   private final CircularProgressDrawable.Ring d;
   private float e;
   private Resources f;
   private Animator g;
   private float h;
   private boolean i;

   public CircularProgressDrawable(Context var1) {
      this.f = Preconditions.a(var1).getResources();
      this.d = new CircularProgressDrawable.Ring();
      this.d.a(c);
      this.a(2.5F);
      this.a();
   }

   private int a(float var1, int var2, int var3) {
      int var4 = var2 >> 24 & 0xFF;
      int var6 = var2 >> 16 & 0xFF;
      int var5 = var2 >> 8 & 0xFF;
      var2 &= 255;
      return var4 + (int)(((var3 >> 24 & 0xFF) - var4) * var1) << 24
         | var6 + (int)(((var3 >> 16 & 0xFF) - var6) * var1) << 16
         | (int)(((var3 >> 8 & 0xFF) - var5) * var1) + var5 << 8
         | (int)(((var3 & 0xFF) - var2) * var1) + var2;
   }

   private void a() {
      CircularProgressDrawable.Ring var2 = this.d;
      ValueAnimator var1 = ValueAnimator.ofFloat(new float[]{0.0F, 1.0F});
      var1.addUpdateListener(new AnimatorUpdateListener(this, var2) {
         final CircularProgressDrawable.Ring a;
         final CircularProgressDrawable b;

         {
            this.b = var1;
            this.a = var2x;
         }

         public void onAnimationUpdate(ValueAnimator var1) {
            float var2x = (Float)var1.getAnimatedValue();
            this.b.a(var2x, this.a);
            this.b.a(var2x, this.a, false);
            this.b.invalidateSelf();
         }
      });
      var1.setRepeatCount(-1);
      var1.setRepeatMode(1);
      var1.setInterpolator(a);
      var1.addListener(new AnimatorListener(this, var2) {
         final CircularProgressDrawable.Ring a;
         final CircularProgressDrawable b;

         {
            this.b = var1;
            this.a = var2;
         }

         public void onAnimationCancel(Animator var1) {
         }

         public void onAnimationEnd(Animator var1) {
         }

         public void onAnimationRepeat(Animator var1) {
            this.b.a(1.0F, this.a, true);
            this.a.k();
            this.a.c();
            if (this.b.i) {
               this.b.i = false;
               var1.cancel();
               var1.setDuration(1332L);
               var1.start();
               this.a.a(false);
            } else {
               this.b.h = this.b.h + 1.0F;
            }
         }

         public void onAnimationStart(Animator var1) {
            this.b.h = 0.0F;
         }
      });
      this.g = var1;
   }

   private void a(float var1, float var2, float var3, float var4) {
      CircularProgressDrawable.Ring var6 = this.d;
      float var5 = this.f.getDisplayMetrics().density;
      var6.a(var2 * var5);
      var6.e(var1 * var5);
      var6.b(0);
      var6.a(var3 * var5, var5 * var4);
   }

   private void a(float var1, CircularProgressDrawable.Ring var2) {
      if (var1 > 0.75F) {
         var2.a(this.a((var1 - 0.75F) / 0.25F, var2.h(), var2.a()));
      } else {
         var2.a(var2.h());
      }
   }

   private void a(float var1, CircularProgressDrawable.Ring var2, boolean var3) {
      if (this.i) {
         this.b(var1, var2);
      } else if (var1 != 1.0F || var3) {
         float var6 = var2.j();
         float var5;
         float var8;
         if (var1 < 0.5F) {
            var8 = var1 / 0.5F;
            var5 = var2.f();
            var8 = b.getInterpolation(var8) * 0.79F + 0.01F + var5;
         } else {
            var5 = (var1 - 0.5F) / 0.5F;
            var8 = var2.f() + 0.79F;
            var5 = var8 - ((1.0F - b.getInterpolation(var5)) * 0.79F + 0.01F);
         }

         float var7 = this.h;
         var2.b(var5);
         var2.c(var8);
         var2.d(var6 + 0.20999998F * var1);
         this.d(216.0F * (var7 + var1));
      }
   }

   private void b(float var1, CircularProgressDrawable.Ring var2) {
      this.a(var1, var2);
      float var3 = (float)(Math.floor(var2.j() / 0.8F) + 1.0);
      var2.b(var2.f() + (var2.g() - 0.01F - var2.f()) * var1);
      var2.c(var2.g());
      float var4 = var2.j();
      var2.d((var3 - var2.j()) * var1 + var4);
   }

   private void d(float var1) {
      this.e = var1;
   }

   public void a(float var1) {
      this.d.a(var1);
      this.invalidateSelf();
   }

   public void a(float var1, float var2) {
      this.d.b(var1);
      this.d.c(var2);
      this.invalidateSelf();
   }

   public void a(int var1) {
      if (var1 == 0) {
         this.a(11.0F, 3.0F, 12.0F, 6.0F);
      } else {
         this.a(7.5F, 2.5F, 10.0F, 5.0F);
      }

      this.invalidateSelf();
   }

   public void a(boolean var1) {
      this.d.a(var1);
      this.invalidateSelf();
   }

   public void a(int... var1) {
      this.d.a(var1);
      this.d.b(0);
      this.invalidateSelf();
   }

   public void b(float var1) {
      this.d.f(var1);
      this.invalidateSelf();
   }

   public void c(float var1) {
      this.d.d(var1);
      this.invalidateSelf();
   }

   public void draw(Canvas var1) {
      Rect var2 = this.getBounds();
      var1.save();
      var1.rotate(this.e, var2.exactCenterX(), var2.exactCenterY());
      this.d.a(var1, var2);
      var1.restore();
   }

   public int getAlpha() {
      return this.d.d();
   }

   public int getOpacity() {
      return -3;
   }

   public boolean isRunning() {
      return this.g.isRunning();
   }

   public void setAlpha(int var1) {
      this.d.c(var1);
      this.invalidateSelf();
   }

   public void setColorFilter(ColorFilter var1) {
      this.d.a(var1);
      this.invalidateSelf();
   }

   public void start() {
      this.g.cancel();
      this.d.k();
      if (this.d.i() != this.d.e()) {
         this.i = true;
         this.g.setDuration(666L);
         this.g.start();
      } else {
         this.d.b(0);
         this.d.l();
         this.g.setDuration(1332L);
         this.g.start();
      }
   }

   public void stop() {
      this.g.cancel();
      this.d(0.0F);
      this.d.a(false);
      this.d.b(0);
      this.d.l();
      this.invalidateSelf();
   }

   private static class Ring {
      final RectF a = new RectF();
      final Paint b = new Paint();
      final Paint c = new Paint();
      final Paint d = new Paint();
      float e = 0.0F;
      float f = 0.0F;
      float g = 0.0F;
      float h = 5.0F;
      int[] i;
      int j;
      float k;
      float l;
      float m;
      boolean n;
      Path o;
      float p = 1.0F;
      float q;
      int r;
      int s;
      int t = 255;
      int u;

      Ring() {
         this.b.setStrokeCap(Cap.SQUARE);
         this.b.setAntiAlias(true);
         this.b.setStyle(Style.STROKE);
         this.c.setStyle(Style.FILL);
         this.c.setAntiAlias(true);
         this.d.setColor(0);
      }

      int a() {
         return this.i[this.b()];
      }

      void a(float var1) {
         this.h = var1;
         this.b.setStrokeWidth(var1);
      }

      void a(float var1, float var2) {
         this.r = (int)var1;
         this.s = (int)var2;
      }

      void a(int var1) {
         this.u = var1;
      }

      void a(Canvas var1, float var2, float var3, RectF var4) {
         if (this.n) {
            if (this.o == null) {
               this.o = new Path();
               this.o.setFillType(FillType.EVEN_ODD);
            } else {
               this.o.reset();
            }

            float var6 = Math.min(var4.width(), var4.height()) / 2.0F;
            float var5 = this.r * this.p / 2.0F;
            this.o.moveTo(0.0F, 0.0F);
            this.o.lineTo(this.r * this.p, 0.0F);
            this.o.lineTo(this.r * this.p / 2.0F, this.s * this.p);
            this.o.offset(var6 + var4.centerX() - var5, var4.centerY() + this.h / 2.0F);
            this.o.close();
            this.c.setColor(this.u);
            this.c.setAlpha(this.t);
            var1.save();
            var1.rotate(var2 + var3, var4.centerX(), var4.centerY());
            var1.drawPath(this.o, this.c);
            var1.restore();
         }
      }

      void a(Canvas var1, Rect var2) {
         RectF var6 = this.a;
         float var3 = this.q + this.h / 2.0F;
         if (this.q <= 0.0F) {
            var3 = Math.min(var2.width(), var2.height()) / 2.0F - Math.max(this.r * this.p / 2.0F, this.h / 2.0F);
         }

         var6.set(var2.centerX() - var3, var2.centerY() - var3, var2.centerX() + var3, var3 + var2.centerY());
         float var5 = (this.e + this.g) * 360.0F;
         var3 = (this.f + this.g) * 360.0F - var5;
         this.b.setColor(this.u);
         this.b.setAlpha(this.t);
         float var4 = this.h / 2.0F;
         var6.inset(var4, var4);
         var1.drawCircle(var6.centerX(), var6.centerY(), var6.width() / 2.0F, this.d);
         var6.inset(-var4, -var4);
         var1.drawArc(var6, var5, var3, false, this.b);
         this.a(var1, var5, var3, var6);
      }

      void a(ColorFilter var1) {
         this.b.setColorFilter(var1);
      }

      void a(boolean var1) {
         if (this.n != var1) {
            this.n = var1;
         }
      }

      void a(int[] var1) {
         this.i = var1;
         this.b(0);
      }

      int b() {
         return (this.j + 1) % this.i.length;
      }

      void b(float var1) {
         this.e = var1;
      }

      void b(int var1) {
         this.j = var1;
         this.u = this.i[this.j];
      }

      void c() {
         this.b(this.b());
      }

      void c(float var1) {
         this.f = var1;
      }

      void c(int var1) {
         this.t = var1;
      }

      int d() {
         return this.t;
      }

      void d(float var1) {
         this.g = var1;
      }

      float e() {
         return this.e;
      }

      void e(float var1) {
         this.q = var1;
      }

      float f() {
         return this.k;
      }

      void f(float var1) {
         if (var1 != this.p) {
            this.p = var1;
         }
      }

      float g() {
         return this.l;
      }

      int h() {
         return this.i[this.j];
      }

      float i() {
         return this.f;
      }

      float j() {
         return this.m;
      }

      void k() {
         this.k = this.e;
         this.l = this.f;
         this.m = this.g;
      }

      void l() {
         this.k = 0.0F;
         this.l = 0.0F;
         this.m = 0.0F;
         this.b(0.0F);
         this.c(0.0F);
         this.d(0.0F);
      }
   }
}
