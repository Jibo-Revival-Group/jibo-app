package com.bumptech.glide.request.animation;

public class NoAnimation<R> implements GlideAnimation<R> {
   private static final NoAnimation<?> a = new NoAnimation();
   private static final GlideAnimationFactory<?> b = new NoAnimation.NoAnimationFactory();

   public static <R> GlideAnimationFactory<R> a() {
      return (GlideAnimationFactory<R>)b;
   }

   public static <R> GlideAnimation<R> b() {
      return (GlideAnimation<R>)a;
   }

   @Override
   public boolean a(Object var1, GlideAnimation.ViewAdapter var2) {
      return false;
   }

   public static class NoAnimationFactory<R> implements GlideAnimationFactory<R> {
      @Override
      public GlideAnimation<R> a(boolean var1, boolean var2) {
         return (GlideAnimation<R>)NoAnimation.a;
      }
   }
}
