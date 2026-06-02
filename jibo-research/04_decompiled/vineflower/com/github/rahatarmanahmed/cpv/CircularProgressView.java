package com.github.rahatarmanahmed.cpv;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.AnimatorSet.Builder;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CircularProgressView extends View {
   private Paint a;
   private int b = 0;
   private RectF c;
   private boolean d;
   private boolean e;
   private float f;
   private float g;
   private float h;
   private float i;
   private int j;
   private int k;
   private int l;
   private int m;
   private int n;
   private int o;
   private List<CircularProgressViewListener> p;
   private float q;
   private float r;
   private ValueAnimator s;
   private ValueAnimator t;
   private AnimatorSet u;
   private float v;

   public CircularProgressView(Context var1) {
      super(var1);
      this.a(null, 0);
   }

   public CircularProgressView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.a(var2, 0);
   }

   public CircularProgressView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a(var2, var3);
   }

   private AnimatorSet a(float var1) {
      float var2 = 360.0F * (this.o - 1) / this.o + 15.0F;
      float var3 = -90.0F + (var2 - 15.0F) * var1;
      ValueAnimator var6 = ValueAnimator.ofFloat(new float[]{15.0F, var2});
      var6.setDuration(this.l / this.o / 2);
      var6.setInterpolator(new DecelerateInterpolator(1.0F));
      var6.addUpdateListener(new AnimatorUpdateListener(this) {
         final CircularProgressView a;

         {
            this.a = var1;
         }

         public void onAnimationUpdate(ValueAnimator var1) {
            this.a.h = (Float)var1.getAnimatedValue();
            this.a.invalidate();
         }
      });
      ValueAnimator var8 = ValueAnimator.ofFloat(new float[]{var1 * 720.0F / this.o, (0.5F + var1) * 720.0F / this.o});
      var8.setDuration(this.l / this.o / 2);
      var8.setInterpolator(new LinearInterpolator());
      var8.addUpdateListener(new AnimatorUpdateListener(this) {
         final CircularProgressView a;

         {
            this.a = var1;
         }

         public void onAnimationUpdate(ValueAnimator var1) {
            this.a.i = (Float)var1.getAnimatedValue();
         }
      });
      ValueAnimator var4 = ValueAnimator.ofFloat(new float[]{var3, var3 + var2 - 15.0F});
      var4.setDuration(this.l / this.o / 2);
      var4.setInterpolator(new DecelerateInterpolator(1.0F));
      var4.addUpdateListener(new AnimatorUpdateListener(this, var2, var3) {
         final float a;
         final float b;
         final CircularProgressView c;

         {
            this.c = var1;
            this.a = var2x;
            this.b = var3x;
         }

         public void onAnimationUpdate(ValueAnimator var1) {
            this.c.q = (Float)var1.getAnimatedValue();
            this.c.h = this.a - this.c.q + this.b;
            this.c.invalidate();
         }
      });
      ValueAnimator var5 = ValueAnimator.ofFloat(new float[]{(0.5F + var1) * 720.0F / this.o, (1.0F + var1) * 720.0F / this.o});
      var5.setDuration(this.l / this.o / 2);
      var5.setInterpolator(new LinearInterpolator());
      var5.addUpdateListener(new AnimatorUpdateListener(this) {
         final CircularProgressView a;

         {
            this.a = var1;
         }

         public void onAnimationUpdate(ValueAnimator var1) {
            this.a.i = (Float)var1.getAnimatedValue();
         }
      });
      AnimatorSet var7 = new AnimatorSet();
      var7.play(var6).with(var8);
      var7.play(var4).with(var5).after(var8);
      return var7;
   }

   private void b(AttributeSet var1, int var2) {
      TypedArray var5 = this.getContext().obtainStyledAttributes(var1, R.styleable.CircularProgressView, var2, 0);
      Resources var4 = this.getResources();
      this.f = var5.getFloat(R.styleable.CircularProgressView_cpv_progress, var4.getInteger(R.integer.cpv_default_progress));
      this.g = var5.getFloat(R.styleable.CircularProgressView_cpv_maxProgress, var4.getInteger(R.integer.cpv_default_max_progress));
      this.j = var5.getDimensionPixelSize(R.styleable.CircularProgressView_cpv_thickness, var4.getDimensionPixelSize(R.dimen.cpv_default_thickness));
      this.d = var5.getBoolean(R.styleable.CircularProgressView_cpv_indeterminate, var4.getBoolean(R.bool.cpv_default_is_indeterminate));
      this.e = var5.getBoolean(R.styleable.CircularProgressView_cpv_animAutostart, var4.getBoolean(R.bool.cpv_default_anim_autostart));
      this.v = var5.getFloat(R.styleable.CircularProgressView_cpv_startAngle, var4.getInteger(R.integer.cpv_default_start_angle));
      this.q = this.v;
      var2 = this.getContext().getResources().getIdentifier("colorAccent", "attr", this.getContext().getPackageName());
      if (var5.hasValue(R.styleable.CircularProgressView_cpv_color)) {
         this.k = var5.getColor(R.styleable.CircularProgressView_cpv_color, var4.getColor(R.color.cpv_default_color));
      } else if (var2 != 0) {
         TypedValue var3 = new TypedValue();
         this.getContext().getTheme().resolveAttribute(var2, var3, true);
         this.k = var3.data;
      } else if (VERSION.SDK_INT >= 21) {
         this.k = this.getContext().obtainStyledAttributes(new int[]{16843829}).getColor(0, var4.getColor(R.color.cpv_default_color));
      } else {
         this.k = var4.getColor(R.color.cpv_default_color);
      }

      this.l = var5.getInteger(R.styleable.CircularProgressView_cpv_animDuration, var4.getInteger(R.integer.cpv_default_anim_duration));
      this.m = var5.getInteger(R.styleable.CircularProgressView_cpv_animSwoopDuration, var4.getInteger(R.integer.cpv_default_anim_swoop_duration));
      this.n = var5.getInteger(R.styleable.CircularProgressView_cpv_animSyncDuration, var4.getInteger(R.integer.cpv_default_anim_sync_duration));
      this.o = var5.getInteger(R.styleable.CircularProgressView_cpv_animSteps, var4.getInteger(R.integer.cpv_default_anim_steps));
      var5.recycle();
   }

   private void d() {
      int var1 = this.getPaddingLeft();
      int var2 = this.getPaddingTop();
      this.c.set(this.j + var1, this.j + var2, this.b - var1 - this.j, this.b - var2 - this.j);
   }

   private void e() {
      this.a.setColor(this.k);
      this.a.setStyle(Style.STROKE);
      this.a.setStrokeWidth(this.j);
      this.a.setStrokeCap(Cap.BUTT);
   }

   public void a() {
      this.b();
   }

   protected void a(AttributeSet var1, int var2) {
      this.p = new ArrayList<>();
      this.b(var1, var2);
      this.a = new Paint(1);
      this.e();
      this.c = new RectF();
   }

   public void b() {
      int var1 = 0;
      if (this.s != null && this.s.isRunning()) {
         this.s.cancel();
      }

      if (this.t != null && this.t.isRunning()) {
         this.t.cancel();
      }

      if (this.u != null && this.u.isRunning()) {
         this.u.cancel();
      }

      if (!this.d) {
         this.q = this.v;
         this.s = ValueAnimator.ofFloat(new float[]{this.q, this.q + 360.0F});
         this.s.setDuration(this.m);
         this.s.setInterpolator(new DecelerateInterpolator(2.0F));
         this.s.addUpdateListener(new AnimatorUpdateListener(this) {
            final CircularProgressView a;

            {
               this.a = var1;
            }

            public void onAnimationUpdate(ValueAnimator var1) {
               this.a.q = (Float)var1.getAnimatedValue();
               this.a.invalidate();
            }
         });
         this.s.start();
         this.r = 0.0F;
         this.t = ValueAnimator.ofFloat(new float[]{this.r, this.f});
         this.t.setDuration(this.n);
         this.t.setInterpolator(new LinearInterpolator());
         this.t.addUpdateListener(new AnimatorUpdateListener(this) {
            final CircularProgressView a;

            {
               this.a = var1;
            }

            public void onAnimationUpdate(ValueAnimator var1) {
               this.a.r = (Float)var1.getAnimatedValue();
               this.a.invalidate();
            }
         });
         this.t.start();
      } else {
         this.h = 15.0F;
         this.u = new AnimatorSet();
         AnimatorSet var2 = null;

         while (var1 < this.o) {
            AnimatorSet var3 = this.a(var1);
            Builder var4 = this.u.play(var3);
            if (var2 != null) {
               var4.after(var2);
            }

            var1++;
            var2 = var3;
         }

         this.u.addListener(new AnimatorListenerAdapter(this) {
            boolean a;
            final CircularProgressView b;

            {
               this.b = var1;
               this.a = false;
            }

            public void onAnimationCancel(Animator var1) {
               this.a = true;
            }

            public void onAnimationEnd(Animator var1) {
               if (!this.a) {
                  this.b.b();
               }
            }
         });
         this.u.start();
         Iterator var5 = this.p.iterator();

         while (var5.hasNext()) {
            ((CircularProgressViewListener)var5.next()).a();
         }
      }
   }

   public void c() {
      if (this.s != null) {
         this.s.cancel();
         this.s = null;
      }

      if (this.t != null) {
         this.t.cancel();
         this.t = null;
      }

      if (this.u != null) {
         this.u.cancel();
         this.u = null;
      }
   }

   public int getColor() {
      return this.k;
   }

   public float getMaxProgress() {
      return this.g;
   }

   public float getProgress() {
      return this.f;
   }

   public int getThickness() {
      return this.j;
   }

   protected void onAttachedToWindow() {
      super.onAttachedToWindow();
      if (this.e) {
         this.a();
      }
   }

   protected void onDetachedFromWindow() {
      super.onDetachedFromWindow();
      this.c();
   }

   protected void onDraw(Canvas var1) {
      super.onDraw(var1);
      float var2;
      if (this.isInEditMode()) {
         var2 = this.f / this.g * 360.0F;
      } else {
         var2 = this.r / this.g * 360.0F;
      }

      if (!this.d) {
         var1.drawArc(this.c, this.q, var2, false, this.a);
      } else {
         RectF var3 = this.c;
         var2 = this.q;
         var1.drawArc(var3, this.i + var2, this.h, false, this.a);
      }
   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(var1, var2);
      int var4 = this.getPaddingLeft() + this.getPaddingRight();
      int var3 = this.getPaddingTop() + this.getPaddingBottom();
      var2 = this.getMeasuredWidth() - var4;
      var1 = this.getMeasuredHeight() - var3;
      if (var2 < var1) {
         var1 = var2;
      }

      this.b = var1;
      this.setMeasuredDimension(this.b + var4, this.b + var3);
   }

   protected void onSizeChanged(int var1, int var2, int var3, int var4) {
      super.onSizeChanged(var1, var2, var3, var4);
      if (var1 >= var2) {
         var1 = var2;
      }

      this.b = var1;
      this.d();
   }

   public void setColor(int var1) {
      this.k = var1;
      this.e();
      this.invalidate();
   }

   public void setIndeterminate(boolean var1) {
      boolean var3 = this.d;
      boolean var2;
      if (this.d == var1) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.d = var1;
      if (var2) {
         this.b();
      }

      if (var3 != var1) {
         Iterator var4 = this.p.iterator();

         while (var4.hasNext()) {
            ((CircularProgressViewListener)var4.next()).a(var1);
         }
      }
   }

   public void setMaxProgress(float var1) {
      this.g = var1;
      this.invalidate();
   }

   public void setProgress(float var1) {
      this.f = var1;
      if (!this.d) {
         if (this.t != null && this.t.isRunning()) {
            this.t.cancel();
         }

         this.t = ValueAnimator.ofFloat(new float[]{this.r, var1});
         this.t.setDuration(this.n);
         this.t.setInterpolator(new LinearInterpolator());
         this.t.addUpdateListener(new AnimatorUpdateListener(this) {
            final CircularProgressView a;

            {
               this.a = var1;
            }

            public void onAnimationUpdate(ValueAnimator var1) {
               this.a.r = (Float)var1.getAnimatedValue();
               this.a.invalidate();
            }
         });
         this.t.addListener(new AnimatorListenerAdapter(this, var1) {
            final float a;
            final CircularProgressView b;

            {
               this.b = var1;
               this.a = var2;
            }

            public void onAnimationEnd(Animator var1) {
               Iterator var2 = this.b.p.iterator();

               while (var2.hasNext()) {
                  ((CircularProgressViewListener)var2.next()).b(this.a);
               }
            }
         });
         this.t.start();
      }

      this.invalidate();
      Iterator var2 = this.p.iterator();

      while (var2.hasNext()) {
         ((CircularProgressViewListener)var2.next()).a(var1);
      }
   }

   public void setThickness(int var1) {
      this.j = var1;
      this.e();
      this.d();
      this.invalidate();
   }

   public void setVisibility(int var1) {
      int var2 = this.getVisibility();
      super.setVisibility(var1);
      if (var1 != var2) {
         if (var1 == 0) {
            this.b();
         } else if (var1 == 8 || var1 == 4) {
            this.c();
         }
      }
   }
}
