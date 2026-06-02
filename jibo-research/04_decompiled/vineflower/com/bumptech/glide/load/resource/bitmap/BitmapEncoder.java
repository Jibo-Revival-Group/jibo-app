package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.OutputStream;

public class BitmapEncoder implements ResourceEncoder<Bitmap> {
   private CompressFormat compressFormat;
   private int quality;

   public BitmapEncoder() {
      this(null, 90);
   }

   public BitmapEncoder(CompressFormat var1, int var2) {
      this.compressFormat = var1;
      this.quality = var2;
   }

   private CompressFormat getFormat(Bitmap var1) {
      CompressFormat var2;
      if (this.compressFormat != null) {
         var2 = this.compressFormat;
      } else if (var1.hasAlpha()) {
         var2 = CompressFormat.PNG;
      } else {
         var2 = CompressFormat.JPEG;
      }

      return var2;
   }

   public boolean encode(Resource<Bitmap> var1, OutputStream var2) {
      Bitmap var5 = (Bitmap)var1.get();
      long var3 = LogTime.a();
      CompressFormat var6 = this.getFormat(var5);
      var5.compress(var6, this.quality, var2);
      if (Log.isLoggable("BitmapEncoder", 2)) {
         Log.v("BitmapEncoder", "Compressed with type: " + var6 + " of size " + Util.a(var5) + " in " + LogTime.a(var3));
      }

      return true;
   }

   @Override
   public String getId() {
      return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
   }
}
