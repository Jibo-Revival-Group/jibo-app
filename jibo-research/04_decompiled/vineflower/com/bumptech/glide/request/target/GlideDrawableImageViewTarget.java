package com.bumptech.glide.request.target;

import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;

public class GlideDrawableImageViewTarget extends ImageViewTarget<GlideDrawable> {
   private int b;
   private GlideDrawable c;

   public GlideDrawableImageViewTarget(ImageView var1) {
      this(var1, -1);
   }

   public GlideDrawableImageViewTarget(ImageView var1, int var2) {
      super(var1);
      this.b = var2;
   }

   protected void a(GlideDrawable var1) {
      this.a.setImageDrawable(var1);
   }

   public void a(GlideDrawable var1, GlideAnimation<? super GlideDrawable> var2) {
      GlideDrawable var5 = var1;
      if (!var1.isAnimated()) {
         float var3 = (float)this.a.getWidth() / this.a.getHeight();
         float var4 = (float)var1.getIntrinsicWidth() / var1.getIntrinsicHeight();
         var5 = var1;
         if (Math.abs(var3 - 1.0F) <= 0.05F) {
            var5 = var1;
            if (Math.abs(var4 - 1.0F) <= 0.05F) {
               var5 = new SquaringDrawable(var1, this.a.getWidth());
            }
         }
      }

      super.onResourceReady(var5, var2);
      this.c = var5;
      var5.setLoopCount(this.b);
      var5.start();
   }

   @Override
   public void onStart() {
      if (this.c != null) {
         this.c.start();
      }
   }

   @Override
   public void onStop() {
      if (this.c != null) {
         this.c.stop();
      }
   }
}
