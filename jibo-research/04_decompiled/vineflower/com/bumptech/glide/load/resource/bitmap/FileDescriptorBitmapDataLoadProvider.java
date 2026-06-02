package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.NullEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.provider.DataLoadProvider;
import java.io.File;

public class FileDescriptorBitmapDataLoadProvider implements DataLoadProvider<ParcelFileDescriptor, Bitmap> {
   private final ResourceDecoder<File, Bitmap> cacheDecoder;
   private final BitmapEncoder encoder;
   private final FileDescriptorBitmapDecoder sourceDecoder;
   private final Encoder<ParcelFileDescriptor> sourceEncoder;

   public FileDescriptorBitmapDataLoadProvider(BitmapPool var1, DecodeFormat var2) {
      this.cacheDecoder = new FileToStreamDecoder<>(new StreamBitmapDecoder(var1, var2));
      this.sourceDecoder = new FileDescriptorBitmapDecoder(var1, var2);
      this.encoder = new BitmapEncoder();
      this.sourceEncoder = NullEncoder.get();
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
   public ResourceDecoder<ParcelFileDescriptor, Bitmap> getSourceDecoder() {
      return this.sourceDecoder;
   }

   @Override
   public Encoder<ParcelFileDescriptor> getSourceEncoder() {
      return this.sourceEncoder;
   }
}
