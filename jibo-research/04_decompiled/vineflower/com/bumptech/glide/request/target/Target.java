package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.animation.GlideAnimation;

public interface Target<R> extends LifecycleListener {
   Request getRequest();

   void getSize(SizeReadyCallback var1);

   void onLoadCleared(Drawable var1);

   void onLoadFailed(Exception var1, Drawable var2);

   void onLoadStarted(Drawable var1);

   void onResourceReady(R var1, GlideAnimation<? super R> var2);

   void setRequest(Request var1);
}
