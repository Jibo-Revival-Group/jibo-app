package com.bumptech.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

public class GifBitmapWrapper {
   private final Resource<Bitmap> bitmapResource;
   private final Resource<GifDrawable> gifResource;

   public GifBitmapWrapper(Resource<Bitmap> var1, Resource<GifDrawable> var2) {
      if (var1 != null && var2 != null) {
         throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
      }

      if (var1 == null && var2 == null) {
         throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
      }

      this.bitmapResource = var1;
      this.gifResource = var2;
   }

   public Resource<Bitmap> getBitmapResource() {
      return this.bitmapResource;
   }

   public Resource<GifDrawable> getGifResource() {
      return this.gifResource;
   }

   public int getSize() {
      int var1;
      if (this.bitmapResource != null) {
         var1 = this.bitmapResource.getSize();
      } else {
         var1 = this.gifResource.getSize();
      }

      return var1;
   }
}
