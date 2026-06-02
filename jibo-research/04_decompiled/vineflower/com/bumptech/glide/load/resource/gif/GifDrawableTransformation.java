package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

public class GifDrawableTransformation implements Transformation<GifDrawable> {
   private final BitmapPool bitmapPool;
   private final Transformation<Bitmap> wrapped;

   public GifDrawableTransformation(Transformation<Bitmap> var1, BitmapPool var2) {
      this.wrapped = var1;
      this.bitmapPool = var2;
   }

   @Override
   public String getId() {
      return this.wrapped.getId();
   }

   @Override
   public Resource<GifDrawable> transform(Resource<GifDrawable> var1, int var2, int var3) {
      GifDrawable var4 = (GifDrawable)var1.get();
      Bitmap var5 = ((GifDrawable)var1.get()).getFirstFrame();
      BitmapResource var6 = new BitmapResource(var5, this.bitmapPool);
      Bitmap var7 = this.wrapped.transform(var6, var2, var3).get();
      if (!var7.equals(var5)) {
         var1 = new GifDrawableResource(new GifDrawable(var4, var7, this.wrapped));
      }

      return var1;
   }
}
