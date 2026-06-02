package com.bumptech.glide.request.target;

import com.bumptech.glide.util.Util;

public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
   private final int height;
   private final int width;

   public SimpleTarget() {
      this(Integer.MIN_VALUE, Integer.MIN_VALUE);
   }

   public SimpleTarget(int var1, int var2) {
      this.width = var1;
      this.height = var2;
   }

   @Override
   public final void getSize(SizeReadyCallback var1) {
      if (!Util.a(this.width, this.height)) {
         throw new IllegalArgumentException(
            "Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: "
               + this.width
               + " and height: "
               + this.height
               + ", either provide dimensions in the constructor"
               + " or call override()"
         );
      }

      var1.a(this.width, this.height);
   }
}
