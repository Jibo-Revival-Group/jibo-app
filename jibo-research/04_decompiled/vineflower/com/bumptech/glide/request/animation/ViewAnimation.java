package com.bumptech.glide.request.animation;

import android.view.animation.Animation;

public class ViewAnimation<R> implements GlideAnimation<R> {
   private final ViewAnimation.AnimationFactory a;

   ViewAnimation(ViewAnimation.AnimationFactory var1) {
      this.a = var1;
   }

   @Override
   public boolean a(R var1, GlideAnimation.ViewAdapter var2) {
      var1 = var2.a();
      if (var1 != null) {
         var1.clearAnimation();
         var1.startAnimation(this.a.a());
      }

      return false;
   }

   interface AnimationFactory {
      Animation a();
   }
}
