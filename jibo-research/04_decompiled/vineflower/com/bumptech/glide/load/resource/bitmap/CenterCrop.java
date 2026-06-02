package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public class CenterCrop extends BitmapTransformation {
   public CenterCrop(BitmapPool var1) {
      super(var1);
   }

   @Override
   public String getId() {
      return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
   }

   @Override
   protected Bitmap transform(BitmapPool var1, Bitmap var2, int var3, int var4) {
      Config var5;
      if (var2.getConfig() != null) {
         var5 = var2.getConfig();
      } else {
         var5 = Config.ARGB_8888;
      }

      Bitmap var7 = var1.get(var3, var4, var5);
      var2 = TransformationUtils.a(var7, var2, var3, var4);
      if (var7 != null && var7 != var2 && !var1.put(var7)) {
         var7.recycle();
      }

      return var2;
   }
}
