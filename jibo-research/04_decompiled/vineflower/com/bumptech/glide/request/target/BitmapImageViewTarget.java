package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class BitmapImageViewTarget extends ImageViewTarget<Bitmap> {
   public BitmapImageViewTarget(ImageView var1) {
      super(var1);
   }

   protected void a(Bitmap var1) {
      this.a.setImageBitmap(var1);
   }
}
