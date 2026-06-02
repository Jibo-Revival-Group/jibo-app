package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;

public abstract class BaseTarget<Z> implements Target<Z> {
   private Request request;

   @Override
   public Request getRequest() {
      return this.request;
   }

   @Override
   public void onDestroy() {
   }

   @Override
   public void onLoadCleared(Drawable var1) {
   }

   @Override
   public void onLoadFailed(Exception var1, Drawable var2) {
   }

   @Override
   public void onLoadStarted(Drawable var1) {
   }

   @Override
   public void onStart() {
   }

   @Override
   public void onStop() {
   }

   @Override
   public void setRequest(Request var1) {
      this.request = var1;
   }
}
