package com.bumptech.glide.request.animation;

import android.graphics.drawable.Drawable;
import android.view.View;

public interface GlideAnimation<R> {
   boolean a(R var1, GlideAnimation.ViewAdapter var2);

   interface ViewAdapter {
      View a();

      void a(Drawable var1);

      Drawable b();
   }
}
