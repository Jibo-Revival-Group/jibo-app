package com.bumptech.glide.request.animation;

public class ViewAnimationFactory<R> implements GlideAnimationFactory<R> {
   private final ViewAnimation.AnimationFactory a;
   private GlideAnimation<R> b;

   ViewAnimationFactory(ViewAnimation.AnimationFactory var1) {
      this.a = var1;
   }

   @Override
   public GlideAnimation<R> a(boolean var1, boolean var2) {
      GlideAnimation var3;
      if (!var1 && var2) {
         if (this.b == null) {
            this.b = new ViewAnimation<>(this.a);
         }

         var3 = this.b;
      } else {
         var3 = NoAnimation.b();
      }

      return var3;
   }
}
