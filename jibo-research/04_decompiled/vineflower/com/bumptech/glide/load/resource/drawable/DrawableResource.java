package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;

public abstract class DrawableResource<T extends Drawable> implements Resource<T> {
   protected final T drawable;

   public DrawableResource(T var1) {
      if (var1 == null) {
         throw new NullPointerException("Drawable must not be null!");
      }

      this.drawable = (T)var1;
   }

   public final T get() {
      return (T)this.drawable.getConstantState().newDrawable();
   }
}
