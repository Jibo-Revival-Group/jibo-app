package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;

class TranslationAnimationCreator {
   static Animator a(View var0, TransitionValues var1, int var2, int var3, float var4, float var5, float var6, float var7, TimeInterpolator var8) {
      float var10 = var0.getTranslationX();
      float var9 = var0.getTranslationY();
      int[] var13 = (int[])var1.b.getTag(R.id.transition_position);
      if (var13 != null) {
         var4 = var13[0] - var2 + var10;
         var5 = var13[1] - var3 + var9;
      }

      int var11 = Math.round(var4 - var10);
      int var12 = Math.round(var5 - var9);
      var0.setTranslationX(var4);
      var0.setTranslationY(var5);
      ObjectAnimator var15;
      if (var4 == var6 && var5 == var7) {
         var15 = null;
      } else {
         ObjectAnimator var16 = ObjectAnimator.ofPropertyValuesHolder(
            var0,
            new PropertyValuesHolder[]{
               PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{var4, var6}),
               PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{var5, var7})
            }
         );
         TranslationAnimationCreator.TransitionPositionListener var14 = new TranslationAnimationCreator.TransitionPositionListener(
            var0, var1.b, var2 + var11, var3 + var12, var10, var9
         );
         var16.addListener(var14);
         AnimatorUtils.a(var16, var14);
         var16.setInterpolator(var8);
         var15 = var16;
      }

      return var15;
   }

   private static class TransitionPositionListener extends AnimatorListenerAdapter {
      private final View a;
      private final View b;
      private final int c;
      private final int d;
      private int[] e;
      private float f;
      private float g;
      private final float h;
      private final float i;

      private TransitionPositionListener(View var1, View var2, int var3, int var4, float var5, float var6) {
         this.b = var1;
         this.a = var2;
         this.c = var3 - Math.round(this.b.getTranslationX());
         this.d = var4 - Math.round(this.b.getTranslationY());
         this.h = var5;
         this.i = var6;
         this.e = (int[])this.a.getTag(R.id.transition_position);
         if (this.e != null) {
            this.a.setTag(R.id.transition_position, null);
         }
      }

      public void onAnimationCancel(Animator var1) {
         if (this.e == null) {
            this.e = new int[2];
         }

         this.e[0] = Math.round(this.c + this.b.getTranslationX());
         this.e[1] = Math.round(this.d + this.b.getTranslationY());
         this.a.setTag(R.id.transition_position, this.e);
      }

      public void onAnimationEnd(Animator var1) {
         this.b.setTranslationX(this.h);
         this.b.setTranslationY(this.i);
      }

      public void onAnimationPause(Animator var1) {
         this.f = this.b.getTranslationX();
         this.g = this.b.getTranslationY();
         this.b.setTranslationX(this.h);
         this.b.setTranslationY(this.i);
      }

      public void onAnimationResume(Animator var1) {
         this.b.setTranslationX(this.f);
         this.b.setTranslationY(this.g);
      }
   }
}
