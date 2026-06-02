package com.bumptech.glide.load.resource.transcode;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawableResource;

public class GlideBitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, GlideBitmapDrawable> {
   private final BitmapPool bitmapPool;
   private final Resources resources;

   public GlideBitmapDrawableTranscoder(Resources var1, BitmapPool var2) {
      this.resources = var1;
      this.bitmapPool = var2;
   }

   @Override
   public String getId() {
      return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
   }

   @Override
   public Resource<GlideBitmapDrawable> transcode(Resource<Bitmap> var1) {
      return new GlideBitmapDrawableResource(new GlideBitmapDrawable(this.resources, (Bitmap)var1.get()), this.bitmapPool);
   }
}
