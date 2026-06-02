package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import java.io.IOException;
import java.io.InputStream;

public class ImageVideoBitmapDecoder implements ResourceDecoder<ImageVideoWrapper, Bitmap> {
   private final ResourceDecoder<ParcelFileDescriptor, Bitmap> fileDescriptorDecoder;
   private final ResourceDecoder<InputStream, Bitmap> streamDecoder;

   public ImageVideoBitmapDecoder(ResourceDecoder<InputStream, Bitmap> var1, ResourceDecoder<ParcelFileDescriptor, Bitmap> var2) {
      this.streamDecoder = var1;
      this.fileDescriptorDecoder = var2;
   }

   public Resource<Bitmap> decode(ImageVideoWrapper var1, int var2, int var3) throws IOException {
      Resource var8;
      label25: {
         InputStream var4 = var1.getStream();
         if (var4 != null) {
            try {
               var8 = this.streamDecoder.decode(var4, var2, var3);
               break label25;
            } catch (IOException var6) {
               if (Log.isLoggable("ImageVideoDecoder", 2)) {
                  Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", var6);
               }
            }
         }

         var8 = null;
      }

      Resource var5 = var8;
      if (var8 == null) {
         ParcelFileDescriptor var7 = var1.getFileDescriptor();
         var5 = var8;
         if (var7 != null) {
            var5 = this.fileDescriptorDecoder.decode(var7, var2, var3);
         }
      }

      return var5;
   }

   @Override
   public String getId() {
      return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
   }
}
