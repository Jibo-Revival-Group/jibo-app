package com.bumptech.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;

public class GifBitmapWrapperTransformation implements Transformation<GifBitmapWrapper> {
   private final Transformation<Bitmap> bitmapTransformation;
   private final Transformation<GifDrawable> gifDataTransformation;

   GifBitmapWrapperTransformation(Transformation<Bitmap> var1, Transformation<GifDrawable> var2) {
      this.bitmapTransformation = var1;
      this.gifDataTransformation = var2;
   }

   public GifBitmapWrapperTransformation(BitmapPool var1, Transformation<Bitmap> var2) {
      this(var2, new GifDrawableTransformation(var2, var1));
   }

   @Override
   public String getId() {
      return this.bitmapTransformation.getId();
   }

   @Override
   public Resource<GifBitmapWrapper> transform(Resource<GifBitmapWrapper> var1, int var2, int var3) {
      Resource var6 = ((GifBitmapWrapper)var1.get()).getBitmapResource();
      Resource var5 = ((GifBitmapWrapper)var1.get()).getGifResource();
      Resource var4;
      if (var6 != null && this.bitmapTransformation != null) {
         var5 = this.bitmapTransformation.transform(var6, var2, var3);
         var4 = var1;
         if (!var6.equals(var5)) {
            var4 = new GifBitmapWrapperResource(new GifBitmapWrapper(var5, ((GifBitmapWrapper)var1.get()).getGifResource()));
         }
      } else {
         var4 = var1;
         if (var5 != null) {
            var4 = var1;
            if (this.gifDataTransformation != null) {
               var6 = this.gifDataTransformation.transform(var5, var2, var3);
               var4 = var1;
               if (!var5.equals(var6)) {
                  var4 = new GifBitmapWrapperResource(new GifBitmapWrapper(((GifBitmapWrapper)var1.get()).getBitmapResource(), var6));
               }
            }
         }
      }

      return var4;
   }
}
