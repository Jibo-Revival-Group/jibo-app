package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.InputStream;

public class StreamBitmapDecoder implements ResourceDecoder<InputStream, Bitmap> {
   private BitmapPool bitmapPool;
   private DecodeFormat decodeFormat;
   private final Downsampler downsampler;
   private String id;

   public StreamBitmapDecoder(BitmapPool var1, DecodeFormat var2) {
      this(Downsampler.AT_LEAST, var1, var2);
   }

   public StreamBitmapDecoder(Downsampler var1, BitmapPool var2, DecodeFormat var3) {
      this.downsampler = var1;
      this.bitmapPool = var2;
      this.decodeFormat = var3;
   }

   public Resource<Bitmap> decode(InputStream var1, int var2, int var3) {
      return BitmapResource.obtain(this.downsampler.decode(var1, this.bitmapPool, var2, var3, this.decodeFormat), this.bitmapPool);
   }

   @Override
   public String getId() {
      if (this.id == null) {
         this.id = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.downsampler.getId() + this.decodeFormat.name();
      }

      return this.id;
   }
}
