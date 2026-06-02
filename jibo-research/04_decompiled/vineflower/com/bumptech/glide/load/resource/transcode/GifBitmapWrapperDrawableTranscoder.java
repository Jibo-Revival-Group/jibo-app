package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;

public class GifBitmapWrapperDrawableTranscoder implements ResourceTranscoder<GifBitmapWrapper, GlideDrawable> {
   private final ResourceTranscoder<Bitmap, GlideBitmapDrawable> bitmapDrawableResourceTranscoder;

   public GifBitmapWrapperDrawableTranscoder(ResourceTranscoder<Bitmap, GlideBitmapDrawable> var1) {
      this.bitmapDrawableResourceTranscoder = var1;
   }

   @Override
   public String getId() {
      return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
   }

   @Override
   public Resource<GlideDrawable> transcode(Resource<GifBitmapWrapper> var1) {
      GifBitmapWrapper var2 = (GifBitmapWrapper)var1.get();
      var1 = var2.getBitmapResource();
      if (var1 != null) {
         var1 = this.bitmapDrawableResourceTranscoder.transcode(var1);
      } else {
         var1 = var2.getGifResource();
      }

      return var1;
   }
}
