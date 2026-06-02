package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

public class GlideBitmapDrawableResource extends DrawableResource<GlideBitmapDrawable> {
   private final BitmapPool bitmapPool;

   public GlideBitmapDrawableResource(GlideBitmapDrawable var1, BitmapPool var2) {
      super(var1);
      this.bitmapPool = var2;
   }

   @Override
   public int getSize() {
      return Util.a(this.drawable.getBitmap());
   }

   @Override
   public void recycle() {
      this.bitmapPool.put(this.drawable.getBitmap());
   }
}
