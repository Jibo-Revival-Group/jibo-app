package com.bumptech.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.provider.DataLoadProvider;
import java.io.File;
import java.io.InputStream;

public class ImageVideoGifDrawableLoadProvider implements DataLoadProvider<ImageVideoWrapper, GifBitmapWrapper> {
   private final ResourceDecoder<File, GifBitmapWrapper> cacheDecoder;
   private final ResourceEncoder<GifBitmapWrapper> encoder;
   private final ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> sourceDecoder;
   private final Encoder<ImageVideoWrapper> sourceEncoder;

   public ImageVideoGifDrawableLoadProvider(DataLoadProvider<ImageVideoWrapper, Bitmap> var1, DataLoadProvider<InputStream, GifDrawable> var2, BitmapPool var3) {
      GifBitmapWrapperResourceDecoder var4 = new GifBitmapWrapperResourceDecoder(var1.getSourceDecoder(), var2.getSourceDecoder(), var3);
      this.cacheDecoder = new FileToStreamDecoder<>(new GifBitmapWrapperStreamResourceDecoder(var4));
      this.sourceDecoder = var4;
      this.encoder = new GifBitmapWrapperResourceEncoder(var1.getEncoder(), var2.getEncoder());
      this.sourceEncoder = var1.getSourceEncoder();
   }

   @Override
   public ResourceDecoder<File, GifBitmapWrapper> getCacheDecoder() {
      return this.cacheDecoder;
   }

   @Override
   public ResourceEncoder<GifBitmapWrapper> getEncoder() {
      return this.encoder;
   }

   @Override
   public ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> getSourceDecoder() {
      return this.sourceDecoder;
   }

   @Override
   public Encoder<ImageVideoWrapper> getSourceEncoder() {
      return this.sourceEncoder;
   }
}
