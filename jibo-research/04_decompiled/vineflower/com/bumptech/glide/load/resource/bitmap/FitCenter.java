package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public class FitCenter extends BitmapTransformation {
   public FitCenter(BitmapPool var1) {
      super(var1);
   }

   @Override
   public String getId() {
      return "FitCenter.com.bumptech.glide.load.resource.bitmap";
   }

   @Override
   protected Bitmap transform(BitmapPool var1, Bitmap var2, int var3, int var4) {
      return TransformationUtils.a(var2, var1, var3, var4);
   }
}
