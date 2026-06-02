package com.bumptech.glide.request.animation;

import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class DrawableCrossFadeFactory<T extends Drawable> implements GlideAnimationFactory<T> {
   private final ViewAnimationFactory<T> a;
   private final int b;
   private DrawableCrossFadeViewAnimation<T> c;
   private DrawableCrossFadeViewAnimation<T> d;

   public DrawableCrossFadeFactory() {
      this(300);
   }

   public DrawableCrossFadeFactory(int var1) {
      this(new ViewAnimationFactory<>(new DrawableCrossFadeFactory.DefaultAnimationFactory(var1)), var1);
   }

   DrawableCrossFadeFactory(ViewAnimationFactory<T> var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   private GlideAnimation<T> a() {
      if (this.c == null) {
         this.c = new DrawableCrossFadeViewAnimation<>(this.a.a(false, true), this.b);
      }

      return this.c;
   }

   private GlideAnimation<T> b() {
      if (this.d == null) {
         this.d = new DrawableCrossFadeViewAnimation<>(this.a.a(false, false), this.b);
      }

      return this.d;
   }

   @Override
   public GlideAnimation<T> a(boolean var1, boolean var2) {
      GlideAnimation var3;
      if (var1) {
         var3 = NoAnimation.b();
      } else if (var2) {
         var3 = this.a();
      } else {
         var3 = this.b();
      }

      return var3;
   }

   private static class DefaultAnimationFactory implements ViewAnimation.AnimationFactory {
      private final int a;

      DefaultAnimationFactory(int var1) {
         this.a = var1;
      }

      @Override
      public Animation a() {
         AlphaAnimation var1 = new AlphaAnimation(0.0F, 1.0F);
         var1.setDuration(this.a);
         return var1;
      }
   }
}
