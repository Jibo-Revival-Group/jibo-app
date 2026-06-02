package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;

public class ImageViewTargetFactory {
   public <Z> Target<Z> a(ImageView var1, Class<Z> var2) {
      ImageViewTarget var3;
      if (GlideDrawable.class.isAssignableFrom(var2)) {
         var3 = new GlideDrawableImageViewTarget(var1);
      } else if (Bitmap.class.equals(var2)) {
         var3 = new BitmapImageViewTarget(var1);
      } else {
         if (!Drawable.class.isAssignableFrom(var2)) {
            throw new IllegalArgumentException("Unhandled class: " + var2 + ", try .as*(Class).transcode(ResourceTranscoder)");
         }

         var3 = new DrawableImageViewTarget(var1);
      }

      return var3;
   }
}
