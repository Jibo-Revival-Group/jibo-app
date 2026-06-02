package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.model.ImageVideoWrapperEncoder;
import com.bumptech.glide.provider.DataLoadProvider;
import java.io.File;
import java.io.InputStream;

public class ImageVideoDataLoadProvider implements DataLoadProvider<ImageVideoWrapper, Bitmap> {
   private final ResourceDecoder<File, Bitmap> cacheDecoder;
   private final ResourceEncoder<Bitmap> encoder;
   private final ImageVideoBitmapDecoder sourceDecoder;
   private final ImageVideoWrapperEncoder sourceEncoder;

   public ImageVideoDataLoadProvider(DataLoadProvider<InputStream, Bitmap> var1, DataLoadProvider<ParcelFileDescriptor, Bitmap> var2) {
      this.encoder = var1.getEncoder();
      this.sourceEncoder = new ImageVideoWrapperEncoder(var1.getSourceEncoder(), var2.getSourceEncoder());
      this.cacheDecoder = var1.getCacheDecoder();
      this.sourceDecoder = new ImageVideoBitmapDecoder(var1.getSourceDecoder(), var2.getSourceDecoder());
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
   public ResourceDecoder<ImageVideoWrapper, Bitmap> getSourceDecoder() {
      return this.sourceDecoder;
   }

   @Override
   public Encoder<ImageVideoWrapper> getSourceEncoder() {
      return this.sourceEncoder;
   }
}
