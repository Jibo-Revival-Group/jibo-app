package com.bumptech.glide.load.engine;

import android.os.Looper;
import com.bumptech.glide.load.Key;

class EngineResource<Z> implements Resource<Z> {
   private int acquired;
   private final boolean isCacheable;
   private boolean isRecycled;
   private Key key;
   private EngineResource.ResourceListener listener;
   private final Resource<Z> resource;

   EngineResource(Resource<Z> var1, boolean var2) {
      if (var1 == null) {
         throw new NullPointerException("Wrapped resource must not be null");
      }

      this.resource = var1;
      this.isCacheable = var2;
   }

   void acquire() {
      if (this.isRecycled) {
         throw new IllegalStateException("Cannot acquire a recycled resource");
      }

      if (!Looper.getMainLooper().equals(Looper.myLooper())) {
         throw new IllegalThreadStateException("Must call acquire on the main thread");
      }

      this.acquired++;
   }

   @Override
   public Z get() {
      return this.resource.get();
   }

   @Override
   public int getSize() {
      return this.resource.getSize();
   }

   boolean isCacheable() {
      return this.isCacheable;
   }

   @Override
   public void recycle() {
      if (this.acquired > 0) {
         throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
      }

      if (this.isRecycled) {
         throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
      }

      this.isRecycled = true;
      this.resource.recycle();
   }

   void release() {
      if (this.acquired <= 0) {
         throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
      }

      if (!Looper.getMainLooper().equals(Looper.myLooper())) {
         throw new IllegalThreadStateException("Must call release on the main thread");
      }

      int var1 = this.acquired - 1;
      this.acquired = var1;
      if (var1 == 0) {
         this.listener.onResourceReleased(this.key, this);
      }
   }

   void setResourceListener(Key var1, EngineResource.ResourceListener var2) {
      this.key = var1;
      this.listener = var2;
   }

   interface ResourceListener {
      void onResourceReleased(Key var1, EngineResource<?> var2);
   }
}
