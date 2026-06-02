package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class BitmapPoolAdapter implements BitmapPool {
   @Override
   public void clearMemory() {
   }

   @Override
   public Bitmap get(int var1, int var2, Config var3) {
      return null;
   }

   @Override
   public Bitmap getDirty(int var1, int var2, Config var3) {
      return null;
   }

   @Override
   public boolean put(Bitmap var1) {
      return false;
   }

   @Override
   public void trimMemory(int var1) {
   }
}
