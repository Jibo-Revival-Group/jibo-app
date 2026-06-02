package com.bumptech.glide.request.animation;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;

public class DrawableCrossFadeViewAnimation<T extends Drawable> implements GlideAnimation<T> {
   private final GlideAnimation<T> a;
   private final int b;

   public DrawableCrossFadeViewAnimation(GlideAnimation<T> var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean a(T var1, GlideAnimation.ViewAdapter var2) {
      boolean var3 = true;
      Drawable var4 = var2.b();
      if (var4 != null) {
         TransitionDrawable var5 = new TransitionDrawable(new Drawable[]{var4, var1});
         var5.setCrossFadeEnabled(true);
         var5.startTransition(this.b);
         var2.a(var5);
      } else {
         this.a.a((T)var1, var2);
         var3 = false;
      }

      return var3;
   }
}
