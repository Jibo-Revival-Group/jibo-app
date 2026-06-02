package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

public class GifDrawableResource extends DrawableResource<GifDrawable> {
   public GifDrawableResource(GifDrawable var1) {
      super(var1);
   }

   @Override
   public int getSize() {
      int var1 = this.drawable.getData().length;
      return Util.a(this.drawable.getFirstFrame()) + var1;
   }

   @Override
   public void recycle() {
      this.drawable.stop();
      this.drawable.recycle();
   }
}
