package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.engine.Resource;

public class GifBitmapWrapperResource implements Resource<GifBitmapWrapper> {
   private final GifBitmapWrapper data;

   public GifBitmapWrapperResource(GifBitmapWrapper var1) {
      if (var1 == null) {
         throw new NullPointerException("Data must not be null");
      }

      this.data = var1;
   }

   public GifBitmapWrapper get() {
      return this.data;
   }

   @Override
   public int getSize() {
      return this.data.getSize();
   }

   @Override
   public void recycle() {
      Resource var1 = this.data.getBitmapResource();
      if (var1 != null) {
         var1.recycle();
      }

      var1 = this.data.getGifResource();
      if (var1 != null) {
         var1.recycle();
      }
   }
}
