package com.salesforce.android.service.common.ui.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Path.Direction;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.Interpolator;
import com.salesforce.android.service.common.ui.R;
import com.salesforce.android.service.common.ui.internal.utils.DrawableUtils;
import com.salesforce.android.service.common.utilities.spatial.Coordinate;

class SalesforceFloatingActionButtonImpl {
   final View a;
   GradientDrawable b;
   GradientDrawable c;
   GradientDrawable d;
   Path e = new Path();
   Drawable f;
   Drawable g;
   Drawable h;
   int i;
   int j;
   int k;
   Interpolator l;
   ValueAnimator m;
   ValueAnimator n;
   private int o;
   private int p;
   private int q;

   SalesforceFloatingActionButtonImpl(SalesforceFloatingActionButtonImpl.Builder var1) {
      this.a = var1.a;
      this.a.setWillNotDraw(false);
      this.a.setBackgroundColor(0);
      this.p = this.a.getResources().getDimensionPixelSize(R.dimen.salesforce_fab_default_icon_size);
      this.q = this.a.getResources().getDimensionPixelSize(R.dimen.salesforce_fab_elevation);
      this.l = new FastOutSlowInInterpolator();
      this.b = this.a(var1.b);
      this.c = this.a(var1.c);
      this.d = this.a(var1.b);
      this.i = var1.d;
      this.j = var1.e;
      this.g = var1.f;
      this.h = var1.g;
      this.a(this.g, this.i);
   }

   private ValueAnimator a() {
      ValueAnimator var1 = ValueAnimator.ofFloat(new float[]{0.0F, 1.0F});
      var1.setDuration(250L).setInterpolator(this.l);
      return var1;
   }

   private GradientDrawable a(int var1) {
      GradientDrawable var2 = new GradientDrawable();
      var2.setShape(1);
      var2.setColor(var1);
      return var2;
   }

   static SalesforceFloatingActionButtonImpl.Builder a(View var0) {
      return new SalesforceFloatingActionButtonImpl.Builder(var0);
   }

   private Rect b(int var1, int var2) {
      return new Rect(var1 / 2 - var2 / 2, var1 / 2 - var2 / 2, var1 / 2 + var2 / 2, var1 / 2 + var2 / 2);
   }

   @SuppressLint("NewApi")
   private void b(int var1) {
      if (VERSION.SDK_INT >= 21) {
         this.a.setOutlineProvider(new ViewOutlineProvider(this, var1) {
            final int a;
            final SalesforceFloatingActionButtonImpl b;

            {
               this.b = var1;
               this.a = var2;
            }

            @TargetApi(21)
            public void getOutline(View var1, Outline var2) {
               var2.setOval(new Rect(0, 0, this.a, this.a));
            }
         });
         this.a.setElevation(this.q);
      }
   }

   Animator a(Coordinate var1) {
      if (this.m != null && this.m.isRunning()) {
         this.m.cancel();
      }

      this.m = this.a();
      this.m.addUpdateListener(new AnimatorUpdateListener(this, var1) {
         final Coordinate a;
         final SalesforceFloatingActionButtonImpl b;

         {
            this.b = var1;
            this.a = var2;
         }

         public void onAnimationUpdate(ValueAnimator var1) {
            float var2 = (Float)this.b.m.getAnimatedValue();
            this.b.a(this.b.c, this.b.c(this.a), var2);
            this.b.a.invalidate();
         }
      });
      this.m.addListener(new AnimatorListenerAdapter(this) {
         final SalesforceFloatingActionButtonImpl a;

         {
            this.a = var1;
         }

         public void onAnimationStart(Animator var1) {
            this.a.a(this.a.h, this.a.j);
         }
      });
      return this.m;
   }

   void a(int var1, int var2) {
      this.o = Math.min(var1, var2);
      this.b.setBounds(0, 0, this.o, this.o);
      this.g.setBounds(this.b(this.o, this.p));
      this.e.addOval(new RectF(0.0F, 0.0F, this.o, this.o), Direction.CW);
      this.b(this.o);
      this.a(this.f, this.k);
   }

   void a(Canvas var1) {
      if (VERSION.SDK_INT >= 21) {
         var1.clipPath(this.e);
      }

      this.b.draw(var1);
      this.c.draw(var1);
      this.d.draw(var1);
      this.f.draw(var1);
   }

   void a(Drawable var1, int var2) {
      this.f = var1;
      this.k = var2;
      this.f.setBounds(this.b(this.o, this.p));
      DrawableUtils.a(this.f, this.k);
   }

   void a(Drawable var1, Coordinate var2, float var3) {
      int var4;
      if (VERSION.SDK_INT >= 21) {
         var4 = Math.max(var2.a(), var2.b()) + Math.round(this.o * 1.2F);
      } else {
         var4 = this.o;
      }

      int var5 = Math.round(var4 * var3);
      var4 = Math.round(var4 * var3);
      var1.setBounds(var2.a() - var5 / 2, var2.b() - var4 / 2, var5, var4);
   }

   Animator b(Coordinate var1) {
      if (this.n != null && this.n.isRunning()) {
         this.n.cancel();
      }

      this.n = this.a();
      this.n.addUpdateListener(new AnimatorUpdateListener(this, var1) {
         final Coordinate a;
         final SalesforceFloatingActionButtonImpl b;

         {
            this.b = var1;
            this.a = var2;
         }

         public void onAnimationUpdate(ValueAnimator var1) {
            float var2 = (Float)var1.getAnimatedValue();
            this.b.a(this.b.d, this.b.c(this.a), var2);
            this.b.a.invalidate();
         }
      });
      this.n.addListener(new AnimatorListenerAdapter(this) {
         final SalesforceFloatingActionButtonImpl a;

         {
            this.a = var1;
         }

         public void onAnimationEnd(Animator var1) {
            this.a.c.setBounds(0, 0, 0, 0);
            this.a.d.setBounds(0, 0, 0, 0);
            this.a.a(this.a.g, this.a.i);
            this.a.a.invalidate();
         }
      });
      return this.n;
   }

   Coordinate c(Coordinate var1) {
      if (VERSION.SDK_INT < 21) {
         var1 = Coordinate.a(this.o / 2, this.o / 2);
      }

      return var1;
   }

   static class Builder {
      final View a;
      int b;
      int c;
      int d;
      int e;
      Drawable f;
      Drawable g;

      public Builder(View var1) {
         this.a = var1;
      }

      public SalesforceFloatingActionButtonImpl.Builder a(int var1) {
         this.b = var1;
         return this;
      }

      public SalesforceFloatingActionButtonImpl.Builder a(Drawable var1) {
         this.f = var1;
         return this;
      }

      public SalesforceFloatingActionButtonImpl a() {
         if (this.g == null) {
            this.g = this.f;
         }

         return new SalesforceFloatingActionButtonImpl(this);
      }

      public SalesforceFloatingActionButtonImpl.Builder b(int var1) {
         this.c = var1;
         return this;
      }

      public SalesforceFloatingActionButtonImpl.Builder b(Drawable var1) {
         this.g = var1;
         return this;
      }

      public SalesforceFloatingActionButtonImpl.Builder c(int var1) {
         this.d = var1;
         return this;
      }

      public SalesforceFloatingActionButtonImpl.Builder d(int var1) {
         this.e = var1;
         return this;
      }
   }
}
