package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class DrawableImageViewTarget extends ImageViewTarget<Drawable> {
   public DrawableImageViewTarget(ImageView var1) {
      super(var1);
   }

   protected void b(Drawable var1) {
      this.a.setImageDrawable(var1);
   }
}
