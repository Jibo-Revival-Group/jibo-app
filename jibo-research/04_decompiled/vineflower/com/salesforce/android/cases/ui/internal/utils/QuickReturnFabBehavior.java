package com.salesforce.android.cases.ui.internal.utils;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Interpolator;

public class QuickReturnFabBehavior extends CoordinatorLayout.Behavior<View> {
   private static final Interpolator a = new FastOutSlowInInterpolator();
   private int b;
   private boolean c;
   private boolean d;
   private boolean e;
   private float f;

   public QuickReturnFabBehavior(Context var1, AttributeSet var2) {
      super(var1, var2);
   }

   private void a(View var1) {
      this.d = true;
      this.e = true;
      ViewPropertyAnimator var2 = var1.animate().translationY(var1.getHeight() * 2).setInterpolator(a).setDuration(200L);
      var2.setListener(new AnimatorListener(this, var1) {
         final View a;
         final QuickReturnFabBehavior b;

         {
            this.b = var1;
            this.a = var2x;
         }

         public void onAnimationCancel(Animator var1) {
            this.b.d = false;
            if (!this.b.c) {
               this.b.b(this.a);
            }
         }

         public void onAnimationEnd(Animator var1) {
            this.b.d = false;
         }

         public void onAnimationRepeat(Animator var1) {
         }

         public void onAnimationStart(Animator var1) {
         }
      });
      var2.start();
   }

   private void b(View var1) {
      this.c = true;
      this.e = false;
      ViewPropertyAnimator var2 = var1.animate().translationY(this.f).setInterpolator(a).setDuration(200L);
      var2.setListener(new AnimatorListener(this, var1) {
         final View a;
         final QuickReturnFabBehavior b;

         {
            this.b = var1;
            this.a = var2x;
         }

         public void onAnimationCancel(Animator var1) {
            this.b.c = false;
            if (!this.b.d) {
               this.b.a(this.a);
            }
         }

         public void onAnimationEnd(Animator var1) {
            this.b.c = false;
         }

         public void onAnimationRepeat(Animator var1) {
         }

         public void onAnimationStart(Animator var1) {
         }
      });
      var2.start();
   }

   @Override
   public void a(CoordinatorLayout var1, View var2, View var3, int var4, int var5, int[] var6) {
      if (var5 > 0 && this.b < 0 || var5 < 0 && this.b > 0) {
         var2.animate().cancel();
         this.b = 0;
      }

      this.b += var5;
      if (this.b >= 200 && !this.e && !this.d && this.f == 0.0F) {
         this.a(var2);
      } else if (this.b < 0 && this.e && !this.c) {
         this.b(var2);
      }
   }

   @Override
   public boolean a(CoordinatorLayout var1, View var2, View var3) {
      boolean var4;
      if (!super.a(var1, var2, var3) && !(var3 instanceof Snackbar.SnackbarLayout)) {
         var4 = false;
      } else {
         var4 = true;
      }

      return var4;
   }

   @Override
   public boolean a(CoordinatorLayout var1, View var2, View var3, View var4, int var5) {
      boolean var6;
      if ((var5 & 2) != 0) {
         var6 = true;
      } else {
         var6 = false;
      }

      return var6;
   }

   @Override
   public boolean b(CoordinatorLayout var1, View var2, View var3) {
      boolean var5;
      if (var3 instanceof Snackbar.SnackbarLayout) {
         float var4 = Math.min(0.0F, var3.getTranslationY() - var3.getHeight());
         this.f = var4;
         if (!this.e) {
            var2.setTranslationY(var4);
         }

         var5 = true;
      } else {
         var5 = false;
      }

      return var5;
   }

   @Override
   public void d(CoordinatorLayout var1, View var2, View var3) {
      super.d(var1, var2, var3);
      if (var3 instanceof Snackbar.SnackbarLayout) {
         float var4 = Math.min(0, var1.getBottom() - var2.getBottom());
         this.f = var4;
         if (!this.e) {
            var2.animate().translationY(var4).start();
         }
      }
   }
}
