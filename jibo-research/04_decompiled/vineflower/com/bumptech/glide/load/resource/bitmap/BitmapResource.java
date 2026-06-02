package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

public class BitmapResource implements Resource<Bitmap> {
   private final Bitmap bitmap;
   private final BitmapPool bitmapPool;

   public BitmapResource(Bitmap var1, BitmapPool var2) {
      if (var1 == null) {
         throw new NullPointerException("Bitmap must not be null");
      }

      if (var2 == null) {
         throw new NullPointerException("BitmapPool must not be null");
      }

      this.bitmap = var1;
      this.bitmapPool = var2;
   }

   public static BitmapResource obtain(Bitmap var0, BitmapPool var1) {
      BitmapResource var2;
      if (var0 == null) {
         var2 = null;
      } else {
         var2 = new BitmapResource(var0, var1);
      }

      return var2;
   }

   public Bitmap get() {
      return this.bitmap;
   }

   @Override
   public int getSize() {
      return Util.a(this.bitmap);
   }

   @Override
   public void recycle() {
      if (!this.bitmapPool.put(this.bitmap)) {
         this.bitmap.recycle();
      }
   }
}
