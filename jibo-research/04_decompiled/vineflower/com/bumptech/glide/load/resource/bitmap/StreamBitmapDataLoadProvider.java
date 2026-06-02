package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.provider.DataLoadProvider;
import java.io.File;
import java.io.InputStream;

public class StreamBitmapDataLoadProvider implements DataLoadProvider<InputStream, Bitmap> {
   private final FileToStreamDecoder<Bitmap> cacheDecoder;
   private final StreamBitmapDecoder decoder;
   private final BitmapEncoder encoder;
   private final StreamEncoder sourceEncoder = new StreamEncoder();

   public StreamBitmapDataLoadProvider(BitmapPool var1, DecodeFormat var2) {
      this.decoder = new StreamBitmapDecoder(var1, var2);
      this.encoder = new BitmapEncoder();
      this.cacheDecoder = new FileToStreamDecoder<>(this.decoder);
   }

   @Override
   public ResourceDecoder<File, Bitmap> getCacheDecoder() {
      return this.cacheDecoder;
   }

   @Override
   public ResourceEncoder<Bitmap> getEncoder() {
      return this.encoder;
   }

   @Override
   public ResourceDecoder<InputStream, Bitmap> getSourceDecoder() {
      return this.decoder;
   }

   @Override
   public Encoder<InputStream> getSourceEncoder() {
      return this.sourceEncoder;
   }
}
