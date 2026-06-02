package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.design.R;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Interpolator;

class FloatingActionButtonImpl {
   static final Interpolator a = AnimationUtils.c;
   static final int[] j = new int[]{16842919, 16842910};
   static final int[] k = new int[]{16842908, 16842910};
   static final int[] l = new int[]{16842910};
   static final int[] m = new int[0];
   int b = 0;
   ShadowDrawableWrapper c;
   Drawable d;
   Drawable e;
   CircularBorderDrawable f;
   Drawable g;
   float h;
   float i;
   final VisibilityAwareImageButton n;
   final ShadowViewDelegate o;
   private final StateListAnimator p;
   private float q;
   private final Rect r = new Rect();
   private OnPreDrawListener s;

   FloatingActionButtonImpl(VisibilityAwareImageButton var1, ShadowViewDelegate var2) {
      this.n = var1;
      this.o = var2;
      this.p = new StateListAnimator();
      this.p.a(j, this.a(new FloatingActionButtonImpl.ElevateToTranslationZAnimation(this)));
      this.p.a(k, this.a(new FloatingActionButtonImpl.ElevateToTranslationZAnimation(this)));
      this.p.a(l, this.a(new FloatingActionButtonImpl.ResetElevationAnimation(this)));
      this.p.a(m, this.a(new FloatingActionButtonImpl.DisabledElevationAnimation(this)));
      this.q = this.n.getRotation();
   }

   private ValueAnimator a(FloatingActionButtonImpl.ShadowAnimatorImpl var1) {
      ValueAnimator var2 = new ValueAnimator();
      var2.setInterpolator(a);
      var2.setDuration(100L);
      var2.addListener(var1);
      var2.addUpdateListener(var1);
      var2.setFloatValues(new float[]{0.0F, 1.0F});
      return var2;
   }

   private static ColorStateList b(int var0) {
      return new ColorStateList(new int[][]{k, j, new int[0]}, new int[]{var0, var0, 0});
   }

   private void o() {
      if (this.s == null) {
         this.s = new OnPreDrawListener(this) {
            final FloatingActionButtonImpl a;

            {
               this.a = var1;
            }

            public boolean onPreDraw() {
               this.a.j();
               return true;
            }
         };
      }
   }

   private boolean p() {
      boolean var1;
      if (ViewCompat.y(this.n) && !this.n.isInEditMode()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private void q() {
      if (VERSION.SDK_INT == 19) {
         if (this.q % 90.0F != 0.0F) {
            if (this.n.getLayerType() != 1) {
               this.n.setLayerType(1, null);
            }
         } else if (this.n.getLayerType() != 0) {
            this.n.setLayerType(0, null);
         }
      }

      if (this.c != null) {
         this.c.a(-this.q);
      }

      if (this.f != null) {
         this.f.b(-this.q);
      }
   }

   float a() {
      return this.h;
   }

   CircularBorderDrawable a(int var1, ColorStateList var2) {
      Context var4 = this.n.getContext();
      CircularBorderDrawable var3 = this.i();
      var3.a(
         ContextCompat.c(var4, R.color.design_fab_stroke_top_outer_color),
         ContextCompat.c(var4, R.color.design_fab_stroke_top_inner_color),
         ContextCompat.c(var4, R.color.design_fab_stroke_end_inner_color),
         ContextCompat.c(var4, R.color.design_fab_stroke_end_outer_color)
      );
      var3.a(var1);
      var3.a(var2);
      return var3;
   }

   final void a(float var1) {
      if (this.h != var1) {
         this.h = var1;
         this.a(var1, this.i);
      }
   }

   void a(float var1, float var2) {
      if (this.c != null) {
         this.c.a(var1, this.i + var1);
         this.e();
      }
   }

   void a(int var1) {
      if (this.e != null) {
         DrawableCompat.a(this.e, b(var1));
      }
   }

   void a(ColorStateList var1) {
      if (this.d != null) {
         DrawableCompat.a(this.d, var1);
      }

      if (this.f != null) {
         this.f.a(var1);
      }
   }

   void a(ColorStateList var1, Mode var2, int var3, int var4) {
      this.d = DrawableCompat.g(this.k());
      DrawableCompat.a(this.d, var1);
      if (var2 != null) {
         DrawableCompat.a(this.d, var2);
      }

      this.e = DrawableCompat.g(this.k());
      DrawableCompat.a(this.e, b(var3));
      Drawable[] var5;
      if (var4 > 0) {
         this.f = this.a(var4, var1);
         var5 = new Drawable[]{this.f, this.d, this.e};
      } else {
         this.f = null;
         var5 = new Drawable[]{this.d, this.e};
      }

      this.g = new LayerDrawable(var5);
      this.c = new ShadowDrawableWrapper(this.n.getContext(), this.g, this.o.a(), this.h, this.h + this.i);
      this.c.a(false);
      this.o.a(this.c);
   }

   void a(Mode var1) {
      if (this.d != null) {
         DrawableCompat.a(this.d, var1);
      }
   }

   void a(Rect var1) {
      this.c.getPadding(var1);
   }

   void a(FloatingActionButtonImpl.InternalVisibilityChangedListener var1, boolean var2) {
      if (!this.n()) {
         this.n.animate().cancel();
         if (this.p()) {
            this.b = 1;
            this.n
               .animate()
               .scaleX(0.0F)
               .scaleY(0.0F)
               .alpha(0.0F)
               .setDuration(200L)
               .setInterpolator(AnimationUtils.c)
               .setListener(new AnimatorListenerAdapter(this, var2, var1) {
                  final boolean a;
                  final FloatingActionButtonImpl.InternalVisibilityChangedListener b;
                  final FloatingActionButtonImpl c;
                  private boolean d;

                  {
                     this.c = var1;
                     this.a = var2x;
                     this.b = var3;
                  }

                  public void onAnimationCancel(Animator var1) {
                     this.d = true;
                  }

                  public void onAnimationEnd(Animator var1) {
                     this.c.b = 0;
                     if (!this.d) {
                        VisibilityAwareImageButton var3 = this.c.n;
                        byte var2x;
                        if (this.a) {
                           var2x = 8;
                        } else {
                           var2x = 4;
                        }

                        var3.a(var2x, this.a);
                        if (this.b != null) {
                           this.b.b();
                        }
                     }
                  }

                  public void onAnimationStart(Animator var1) {
                     this.c.n.a(0, this.a);
                     this.d = false;
                  }
               });
         } else {
            VisibilityAwareImageButton var4 = this.n;
            byte var3;
            if (var2) {
               var3 = 8;
            } else {
               var3 = 4;
            }

            var4.a(var3, var2);
            if (var1 != null) {
               var1.b();
            }
         }
      }
   }

   void a(int[] var1) {
      this.p.a(var1);
   }

   void b() {
      this.p.a();
   }

   final void b(float var1) {
      if (this.i != var1) {
         this.i = var1;
         this.a(this.h, var1);
      }
   }

   void b(Rect var1) {
   }

   void b(FloatingActionButtonImpl.InternalVisibilityChangedListener var1, boolean var2) {
      if (!this.m()) {
         this.n.animate().cancel();
         if (this.p()) {
            this.b = 2;
            if (this.n.getVisibility() != 0) {
               this.n.setAlpha(0.0F);
               this.n.setScaleY(0.0F);
               this.n.setScaleX(0.0F);
            }

            this.n
               .animate()
               .scaleX(1.0F)
               .scaleY(1.0F)
               .alpha(1.0F)
               .setDuration(200L)
               .setInterpolator(AnimationUtils.d)
               .setListener(new AnimatorListenerAdapter(this, var2, var1) {
                  final boolean a;
                  final FloatingActionButtonImpl.InternalVisibilityChangedListener b;
                  final FloatingActionButtonImpl c;

                  {
                     this.c = var1;
                     this.a = var2x;
                     this.b = var3;
                  }

                  public void onAnimationEnd(Animator var1) {
                     this.c.b = 0;
                     if (this.b != null) {
                        this.b.a();
                     }
                  }

                  public void onAnimationStart(Animator var1) {
                     this.c.n.a(0, this.a);
                  }
               });
         } else {
            this.n.a(0, var2);
            this.n.setAlpha(1.0F);
            this.n.setScaleY(1.0F);
            this.n.setScaleX(1.0F);
            if (var1 != null) {
               var1.a();
            }
         }
      }
   }

   final Drawable c() {
      return this.g;
   }

   void d() {
   }

   final void e() {
      Rect var1 = this.r;
      this.a(var1);
      this.b(var1);
      this.o.a(var1.left, var1.top, var1.right, var1.bottom);
   }

   void f() {
      if (this.h()) {
         this.o();
         this.n.getViewTreeObserver().addOnPreDrawListener(this.s);
      }
   }

   void g() {
      if (this.s != null) {
         this.n.getViewTreeObserver().removeOnPreDrawListener(this.s);
         this.s = null;
      }
   }

   boolean h() {
      return true;
   }

   CircularBorderDrawable i() {
      return new CircularBorderDrawable();
   }

   void j() {
      float var1 = this.n.getRotation();
      if (this.q != var1) {
         this.q = var1;
         this.q();
      }
   }

   GradientDrawable k() {
      GradientDrawable var1 = this.l();
      var1.setShape(1);
      var1.setColor(-1);
      return var1;
   }

   GradientDrawable l() {
      return new GradientDrawable();
   }

   boolean m() {
      boolean var1 = true;
      if (this.n.getVisibility() != 0) {
         if (this.b != 2) {
            var1 = false;
         }
      } else if (this.b == 1) {
         var1 = false;
      }

      return var1;
   }

   boolean n() {
      boolean var1 = true;
      if (this.n.getVisibility() == 0) {
         if (this.b != 1) {
            var1 = false;
         }
      } else if (this.b == 2) {
         var1 = false;
      }

      return var1;
   }

   private class DisabledElevationAnimation extends FloatingActionButtonImpl.ShadowAnimatorImpl {
      final FloatingActionButtonImpl a;

      DisabledElevationAnimation(FloatingActionButtonImpl var1) {
         super(var1);
         this.a = var1;
      }

      @Override
      protected float a() {
         return 0.0F;
      }
   }

   private class ElevateToTranslationZAnimation extends FloatingActionButtonImpl.ShadowAnimatorImpl {
      final FloatingActionButtonImpl a;

      ElevateToTranslationZAnimation(FloatingActionButtonImpl var1) {
         super(var1);
         this.a = var1;
      }

      @Override
      protected float a() {
         return this.a.h + this.a.i;
      }
   }

   interface InternalVisibilityChangedListener {
      void a();

      void b();
   }

   private class ResetElevationAnimation extends FloatingActionButtonImpl.ShadowAnimatorImpl {
      final FloatingActionButtonImpl a;

      ResetElevationAnimation(FloatingActionButtonImpl var1) {
         super(var1);
         this.a = var1;
      }

      @Override
      protected float a() {
         return this.a.h;
      }
   }

   private abstract class ShadowAnimatorImpl extends AnimatorListenerAdapter implements AnimatorUpdateListener {
      private boolean a;
      final FloatingActionButtonImpl b;
      private float c;
      private float d;

      private ShadowAnimatorImpl(FloatingActionButtonImpl var1) {
         this.b = var1;
      }

      protected abstract float a();

      public void onAnimationEnd(Animator var1) {
         this.b.c.b(this.d);
         this.a = false;
      }

      public void onAnimationUpdate(ValueAnimator var1) {
         if (!this.a) {
            this.c = this.b.c.a();
            this.d = this.a();
            this.a = true;
         }

         this.b.c.b(this.c + (this.d - this.c) * var1.getAnimatedFraction());
      }
   }
}
