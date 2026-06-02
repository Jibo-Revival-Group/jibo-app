package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;

class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
   private static final int[] g = new int[]{16842919};
   private static final int[] h = new int[0];
   private final int[] A;
   private final ValueAnimator B;
   private int C;
   private final Runnable D;
   private final RecyclerView.OnScrollListener E;
   int a;
   int b;
   float c;
   int d;
   int e;
   float f;
   private final int i;
   private final int j;
   private final StateListDrawable k;
   private final Drawable l;
   private final int m;
   private final int n;
   private final StateListDrawable o;
   private final Drawable p;
   private final int q;
   private final int r;
   private int s = 0;
   private int t = 0;
   private RecyclerView u;
   private boolean v = false;
   private boolean w = false;
   private int x = 0;
   private int y = 0;
   private final int[] z = new int[2];

   FastScroller(RecyclerView var1, StateListDrawable var2, Drawable var3, StateListDrawable var4, Drawable var5, int var6, int var7, int var8) {
      this.A = new int[2];
      this.B = ValueAnimator.ofFloat(new float[]{0.0F, 1.0F});
      this.C = 0;
      this.D = new Runnable(this) {
         final FastScroller a;

         {
            this.a = var1;
         }

         @Override
         public void run() {
            this.a.a(500);
         }
      };
      this.E = new RecyclerView.OnScrollListener(this) {
         final FastScroller a;

         {
            this.a = var1;
         }

         @Override
         public void a(RecyclerView var1, int var2x, int var3x) {
            this.a.a(var1.computeHorizontalScrollOffset(), var1.computeVerticalScrollOffset());
         }
      };
      this.k = var2;
      this.l = var3;
      this.o = var4;
      this.p = var5;
      this.m = Math.max(var6, var2.getIntrinsicWidth());
      this.n = Math.max(var6, var3.getIntrinsicWidth());
      this.q = Math.max(var6, var4.getIntrinsicWidth());
      this.r = Math.max(var6, var5.getIntrinsicWidth());
      this.i = var7;
      this.j = var8;
      this.k.setAlpha(255);
      this.l.setAlpha(255);
      this.B.addListener(new FastScroller.AnimatorListener(this));
      this.B.addUpdateListener(new FastScroller.AnimatorUpdater(this));
      this.a(var1);
   }

   private int a(float var1, float var2, int[] var3, int var4, int var5, int var6) {
      byte var7 = 0;
      int var8 = var3[1] - var3[0];
      if (var8 == 0) {
         var4 = var7;
      } else {
         var1 = (var2 - var1) / var8;
         var8 = var4 - var6;
         var6 = (int)(var1 * var8);
         var5 += var6;
         var4 = var7;
         if (var5 < var8) {
            var4 = var7;
            if (var5 >= 0) {
               var4 = var6;
            }
         }
      }

      return var4;
   }

   private void a(float var1) {
      int[] var3 = this.g();
      var1 = Math.max(var3[0], Math.min(var3[1], var1));
      if (!(Math.abs(this.b - var1) < 2.0F)) {
         int var2 = this.a(this.c, var1, var3, this.u.computeVerticalScrollRange(), this.u.computeVerticalScrollOffset(), this.t);
         if (var2 != 0) {
            this.u.scrollBy(0, var2);
         }

         this.c = var1;
      }
   }

   private void a(Canvas var1) {
      int var3 = this.s - this.m;
      int var2 = this.b - this.a / 2;
      this.k.setBounds(0, 0, this.m, this.a);
      this.l.setBounds(0, 0, this.n, this.t);
      if (this.e()) {
         this.l.draw(var1);
         var1.translate(this.m, var2);
         var1.scale(-1.0F, 1.0F);
         this.k.draw(var1);
         var1.scale(1.0F, 1.0F);
         var1.translate(-this.m, -var2);
      } else {
         var1.translate(var3, 0.0F);
         this.l.draw(var1);
         var1.translate(0.0F, var2);
         this.k.draw(var1);
         var1.translate(-var3, -var2);
      }
   }

   private void b() {
      this.u.addItemDecoration(this);
      this.u.addOnItemTouchListener(this);
      this.u.addOnScrollListener(this.E);
   }

   private void b(float var1) {
      int[] var3 = this.h();
      var1 = Math.max(var3[0], Math.min(var3[1], var1));
      if (!(Math.abs(this.e - var1) < 2.0F)) {
         int var2 = this.a(this.f, var1, var3, this.u.computeHorizontalScrollRange(), this.u.computeHorizontalScrollOffset(), this.s);
         if (var2 != 0) {
            this.u.scrollBy(var2, 0);
         }

         this.f = var1;
      }
   }

   private void b(int var1) {
      if (var1 == 2 && this.x != 2) {
         this.k.setState(g);
         this.f();
      }

      if (var1 == 0) {
         this.d();
      } else {
         this.a();
      }

      if (this.x == 2 && var1 != 2) {
         this.k.setState(h);
         this.c(1200);
      } else if (var1 == 1) {
         this.c(1500);
      }

      this.x = var1;
   }

   private void b(Canvas var1) {
      int var2 = this.t - this.q;
      int var3 = this.e - this.d / 2;
      this.o.setBounds(0, 0, this.d, this.q);
      this.p.setBounds(0, 0, this.s, this.r);
      var1.translate(0.0F, var2);
      this.p.draw(var1);
      var1.translate(var3, 0.0F);
      this.o.draw(var1);
      var1.translate(-var3, -var2);
   }

   private void c() {
      this.u.removeItemDecoration(this);
      this.u.removeOnItemTouchListener(this);
      this.u.removeOnScrollListener(this.E);
      this.f();
   }

   private void c(int var1) {
      this.f();
      this.u.postDelayed(this.D, var1);
   }

   private void d() {
      this.u.invalidate();
   }

   private boolean e() {
      boolean var1 = true;
      if (ViewCompat.e(this.u) != 1) {
         var1 = false;
      }

      return var1;
   }

   private void f() {
      this.u.removeCallbacks(this.D);
   }

   private int[] g() {
      this.z[0] = this.j;
      this.z[1] = this.t - this.j;
      return this.z;
   }

   private int[] h() {
      this.A[0] = this.j;
      this.A[1] = this.s - this.j;
      return this.A;
   }

   public void a() {
      switch (this.C) {
         case 3:
            this.B.cancel();
         case 0:
            this.C = 1;
            this.B.setFloatValues(new float[]{(Float)this.B.getAnimatedValue(), 1.0F});
            this.B.setDuration(500L);
            this.B.setStartDelay(0L);
            this.B.start();
         case 1:
         case 2:
      }
   }

   void a(int var1) {
      switch (this.C) {
         case 1:
            this.B.cancel();
         case 2:
            this.C = 3;
            this.B.setFloatValues(new float[]{(Float)this.B.getAnimatedValue(), 0.0F});
            this.B.setDuration(var1);
            this.B.start();
      }
   }

   void a(int var1, int var2) {
      int var4 = this.u.computeVerticalScrollRange();
      int var6 = this.t;
      boolean var7;
      if (var4 - var6 > 0 && this.t >= this.i) {
         var7 = true;
      } else {
         var7 = false;
      }

      this.v = var7;
      int var5 = this.u.computeHorizontalScrollRange();
      int var3 = this.s;
      if (var5 - var3 > 0 && this.s >= this.i) {
         var7 = true;
      } else {
         var7 = false;
      }

      this.w = var7;
      if (!this.v && !this.w) {
         if (this.x != 0) {
            this.b(0);
         }
      } else {
         if (this.v) {
            this.b = (int)((var2 + var6 / 2.0F) * var6 / var4);
            this.a = Math.min(var6, var6 * var6 / var4);
         }

         if (this.w) {
            this.e = (int)((var1 + var3 / 2.0F) * var3 / var5);
            this.d = Math.min(var3, var3 * var3 / var5);
         }

         if (this.x == 0 || this.x == 1) {
            this.b(1);
         }
      }
   }

   @Override
   public void a(Canvas var1, RecyclerView var2, RecyclerView.State var3) {
      if (this.s != this.u.getWidth() || this.t != this.u.getHeight()) {
         this.s = this.u.getWidth();
         this.t = this.u.getHeight();
         this.b(0);
      } else if (this.C != 0) {
         if (this.v) {
            this.a(var1);
         }

         if (this.w) {
            this.b(var1);
         }
      }
   }

   public void a(RecyclerView var1) {
      if (this.u != var1) {
         if (this.u != null) {
            this.c();
         }

         this.u = var1;
         if (this.u != null) {
            this.b();
         }
      }
   }

   @Override
   public void a(boolean var1) {
   }

   boolean a(float var1, float var2) {
      boolean var3;
      if ((this.e() ? var1 <= this.m / 2 : var1 >= this.s - this.m) && var2 >= this.b - this.a / 2 && var2 <= this.b + this.a / 2) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   @Override
   public boolean a(RecyclerView var1, MotionEvent var2) {
      boolean var3 = true;
      if (this.x == 1) {
         boolean var4 = this.a(var2.getX(), var2.getY());
         boolean var5 = this.b(var2.getX(), var2.getY());
         if (var2.getAction() == 0 && (var4 || var5)) {
            if (var5) {
               this.y = 1;
               this.f = (int)var2.getX();
            } else if (var4) {
               this.y = 2;
               this.c = (int)var2.getY();
            }

            this.b(2);
         } else {
            var3 = false;
         }
      } else if (this.x != 2) {
         var3 = false;
      }

      return var3;
   }

   @Override
   public void b(RecyclerView var1, MotionEvent var2) {
      if (this.x != 0) {
         if (var2.getAction() == 0) {
            boolean var3 = this.a(var2.getX(), var2.getY());
            boolean var4 = this.b(var2.getX(), var2.getY());
            if (var3 || var4) {
               if (var4) {
                  this.y = 1;
                  this.f = (int)var2.getX();
               } else if (var3) {
                  this.y = 2;
                  this.c = (int)var2.getY();
               }

               this.b(2);
            }
         } else if (var2.getAction() == 1 && this.x == 2) {
            this.c = 0.0F;
            this.f = 0.0F;
            this.b(1);
            this.y = 0;
         } else if (var2.getAction() == 2 && this.x == 2) {
            this.a();
            if (this.y == 1) {
               this.b(var2.getX());
            }

            if (this.y == 2) {
               this.a(var2.getY());
            }
         }
      }
   }

   boolean b(float var1, float var2) {
      boolean var3;
      if (var2 >= this.t - this.q && var1 >= this.e - this.d / 2 && var1 <= this.e + this.d / 2) {
         var3 = true;
      } else {
         var3 = false;
      }

      return var3;
   }

   private class AnimatorListener extends AnimatorListenerAdapter {
      final FastScroller a;
      private boolean b;

      private AnimatorListener(FastScroller var1) {
         this.a = var1;
         this.b = false;
      }

      public void onAnimationCancel(Animator var1) {
         this.b = true;
      }

      public void onAnimationEnd(Animator var1) {
         if (this.b) {
            this.b = false;
         } else if ((Float)this.a.B.getAnimatedValue() == 0.0F) {
            this.a.C = 0;
            this.a.b(0);
         } else {
            this.a.C = 2;
            this.a.d();
         }
      }
   }

   private class AnimatorUpdater implements AnimatorUpdateListener {
      final FastScroller a;

      private AnimatorUpdater(FastScroller var1) {
         this.a = var1;
      }

      public void onAnimationUpdate(ValueAnimator var1) {
         int var2 = (int)((Float)var1.getAnimatedValue() * 255.0F);
         this.a.k.setAlpha(var2);
         this.a.l.setAlpha(var2);
         this.a.d();
      }
   }
}
