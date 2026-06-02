package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;

public class VideoBitmapDecoder implements BitmapDecoder<ParcelFileDescriptor> {
   private static final VideoBitmapDecoder.MediaMetadataRetrieverFactory DEFAULT_FACTORY = new VideoBitmapDecoder.MediaMetadataRetrieverFactory();
   private VideoBitmapDecoder.MediaMetadataRetrieverFactory factory;
   private int frame;

   public VideoBitmapDecoder() {
      this(DEFAULT_FACTORY, -1);
   }

   VideoBitmapDecoder(VideoBitmapDecoder.MediaMetadataRetrieverFactory var1, int var2) {
      this.factory = var1;
      this.frame = var2;
   }

   public Bitmap decode(ParcelFileDescriptor var1, BitmapPool var2, int var3, int var4, DecodeFormat var5) throws IOException {
      MediaMetadataRetriever var7 = this.factory.a();
      var7.setDataSource(var1.getFileDescriptor());
      Bitmap var6;
      if (this.frame >= 0) {
         var6 = var7.getFrameAtTime(this.frame);
      } else {
         var6 = var7.getFrameAtTime();
      }

      var7.release();
      var1.close();
      return var6;
   }

   @Override
   public String getId() {
      return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
   }

   static class MediaMetadataRetrieverFactory {
      public MediaMetadataRetriever a() {
         return new MediaMetadataRetriever();
      }
   }
}
