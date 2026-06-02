package com.bumptech.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.ByteArrayPool;
import java.io.IOException;
import java.io.InputStream;

public class GifBitmapWrapperResourceDecoder implements ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> {
   private static final GifBitmapWrapperResourceDecoder.ImageTypeParser DEFAULT_PARSER = new GifBitmapWrapperResourceDecoder.ImageTypeParser();
   private static final GifBitmapWrapperResourceDecoder.BufferedStreamFactory DEFAULT_STREAM_FACTORY = new GifBitmapWrapperResourceDecoder.BufferedStreamFactory();
   private final ResourceDecoder<ImageVideoWrapper, Bitmap> bitmapDecoder;
   private final BitmapPool bitmapPool;
   private final ResourceDecoder<InputStream, GifDrawable> gifDecoder;
   private String id;
   private final GifBitmapWrapperResourceDecoder.ImageTypeParser parser;
   private final GifBitmapWrapperResourceDecoder.BufferedStreamFactory streamFactory;

   public GifBitmapWrapperResourceDecoder(ResourceDecoder<ImageVideoWrapper, Bitmap> var1, ResourceDecoder<InputStream, GifDrawable> var2, BitmapPool var3) {
      this(var1, var2, var3, DEFAULT_PARSER, DEFAULT_STREAM_FACTORY);
   }

   GifBitmapWrapperResourceDecoder(
      ResourceDecoder<ImageVideoWrapper, Bitmap> var1,
      ResourceDecoder<InputStream, GifDrawable> var2,
      BitmapPool var3,
      GifBitmapWrapperResourceDecoder.ImageTypeParser var4,
      GifBitmapWrapperResourceDecoder.BufferedStreamFactory var5
   ) {
      this.bitmapDecoder = var1;
      this.gifDecoder = var2;
      this.bitmapPool = var3;
      this.parser = var4;
      this.streamFactory = var5;
   }

   private GifBitmapWrapper decode(ImageVideoWrapper var1, int var2, int var3, byte[] var4) throws IOException {
      GifBitmapWrapper var5;
      if (var1.getStream() != null) {
         var5 = this.decodeStream(var1, var2, var3, var4);
      } else {
         var5 = this.decodeBitmapWrapper(var1, var2, var3);
      }

      return var5;
   }

   private GifBitmapWrapper decodeBitmapWrapper(ImageVideoWrapper var1, int var2, int var3) throws IOException {
      Resource var4 = this.bitmapDecoder.decode(var1, var2, var3);
      GifBitmapWrapper var5;
      if (var4 != null) {
         var5 = new GifBitmapWrapper(var4, null);
      } else {
         var5 = null;
      }

      return var5;
   }

   private GifBitmapWrapper decodeGifWrapper(InputStream var1, int var2, int var3) throws IOException {
      Resource var5 = this.gifDecoder.decode(var1, var2, var3);
      GifBitmapWrapper var6;
      if (var5 != null) {
         GifDrawable var4 = (GifDrawable)var5.get();
         if (var4.getFrameCount() > 1) {
            var6 = new GifBitmapWrapper(null, var5);
         } else {
            var6 = new GifBitmapWrapper(new BitmapResource(var4.getFirstFrame(), this.bitmapPool), null);
         }
      } else {
         var6 = null;
      }

      return var6;
   }

   private GifBitmapWrapper decodeStream(ImageVideoWrapper var1, int var2, int var3, byte[] var4) throws IOException {
      InputStream var6 = this.streamFactory.a(var1.getStream(), var4);
      var6.mark(2048);
      ImageHeaderParser.ImageType var5 = this.parser.a(var6);
      var6.reset();
      GifBitmapWrapper var7 = null;
      if (var5 == ImageHeaderParser.ImageType.GIF) {
         var7 = this.decodeGifWrapper(var6, var2, var3);
      }

      GifBitmapWrapper var8 = var7;
      if (var7 == null) {
         var8 = this.decodeBitmapWrapper(new ImageVideoWrapper(var6, var1.getFileDescriptor()), var2, var3);
      }

      return var8;
   }

   public Resource<GifBitmapWrapper> decode(ImageVideoWrapper var1, int var2, int var3) throws IOException {
      ByteArrayPool var4 = ByteArrayPool.a();
      byte[] var5 = var4.b();

      try {
         var8 = this.decode(var1, var2, var3, var5);
      } finally {
         var4.a(var5);
      }

      GifBitmapWrapperResource var9;
      if (var8 != null) {
         var9 = new GifBitmapWrapperResource(var8);
      } else {
         var9 = null;
      }

      return var9;
   }

   @Override
   public String getId() {
      if (this.id == null) {
         this.id = this.gifDecoder.getId() + this.bitmapDecoder.getId();
      }

      return this.id;
   }

   static class BufferedStreamFactory {
      public InputStream a(InputStream var1, byte[] var2) {
         return new RecyclableBufferedInputStream(var1, var2);
      }
   }

   static class ImageTypeParser {
      public ImageHeaderParser.ImageType a(InputStream var1) throws IOException {
         return new ImageHeaderParser(var1).getType();
      }
   }
}
