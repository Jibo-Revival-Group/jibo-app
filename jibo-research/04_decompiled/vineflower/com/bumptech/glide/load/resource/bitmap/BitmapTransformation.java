package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

public abstract class BitmapTransformation implements Transformation<Bitmap> {
   private BitmapPool bitmapPool;

   public BitmapTransformation(BitmapPool var1) {
      this.bitmapPool = var1;
   }

   protected abstract Bitmap transform(BitmapPool var1, Bitmap var2, int var3, int var4);

   @Override
   public final Resource<Bitmap> transform(Resource<Bitmap> var1, int var2, int var3) {
      if (!Util.a(var2, var3)) {
         throw new IllegalArgumentException(
            "Cannot apply transformation on width: " + var2 + " or height: " + var3 + " less than or equal to zero and not Target.SIZE_ORIGINAL"
         );
      }

      Bitmap var6 = (Bitmap)var1.get();
      int var4 = var2;
      if (var2 == Integer.MIN_VALUE) {
         var4 = var6.getWidth();
      }

      var2 = var3;
      if (var3 == Integer.MIN_VALUE) {
         var2 = var6.getHeight();
      }

      Bitmap var5 = this.transform(this.bitmapPool, var6, var4, var2);
      if (!var6.equals(var5)) {
         var1 = BitmapResource.obtain(var5, this.bitmapPool);
      }

      return var1;
   }
}
