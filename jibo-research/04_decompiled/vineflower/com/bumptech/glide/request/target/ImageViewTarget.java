package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.animation.GlideAnimation;

public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements GlideAnimation.ViewAdapter {
   public ImageViewTarget(ImageView var1) {
      super(var1);
   }

   @Override
   public void a(Drawable var1) {
      this.a.setImageDrawable(var1);
   }

   @Override
   protected abstract void a(Z var1);

   @Override
   public Drawable b() {
      return this.a.getDrawable();
   }

   @Override
   public void onLoadCleared(Drawable var1) {
      this.a.setImageDrawable(var1);
   }

   @Override
   public void onLoadFailed(Exception var1, Drawable var2) {
      this.a.setImageDrawable(var2);
   }

   @Override
   public void onLoadStarted(Drawable var1) {
      this.a.setImageDrawable(var1);
   }

   @Override
   public void onResourceReady(Z var1, GlideAnimation<? super Z> var2) {
      if (var2 == null || !var2.a(var1, this)) {
         this.a((Z)var1);
      }
   }
}
