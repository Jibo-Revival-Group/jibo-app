package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.Encoder;
import java.io.InputStream;
import java.io.OutputStream;

public class ImageVideoWrapperEncoder implements Encoder<ImageVideoWrapper> {
   private final Encoder<ParcelFileDescriptor> fileDescriptorEncoder;
   private String id;
   private final Encoder<InputStream> streamEncoder;

   public ImageVideoWrapperEncoder(Encoder<InputStream> var1, Encoder<ParcelFileDescriptor> var2) {
      this.streamEncoder = var1;
      this.fileDescriptorEncoder = var2;
   }

   public boolean encode(ImageVideoWrapper var1, OutputStream var2) {
      boolean var3;
      if (var1.getStream() != null) {
         var3 = this.streamEncoder.encode(var1.getStream(), var2);
      } else {
         var3 = this.fileDescriptorEncoder.encode(var1.getFileDescriptor(), var2);
      }

      return var3;
   }

   @Override
   public String getId() {
      if (this.id == null) {
         this.id = this.streamEncoder.getId() + this.fileDescriptorEncoder.getId();
      }

      return this.id;
   }
}
