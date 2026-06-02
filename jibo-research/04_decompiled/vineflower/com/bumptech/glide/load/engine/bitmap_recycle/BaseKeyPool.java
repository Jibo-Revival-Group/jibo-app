package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.util.Util;
import java.util.Queue;

abstract class BaseKeyPool<T extends Poolable> {
   private final Queue<T> keyPool = Util.a(20);

   protected abstract T create();

   protected T get() {
      Poolable var2 = this.keyPool.poll();
      Poolable var1 = var2;
      if (var2 == null) {
         var1 = this.create();
      }

      return (T)var1;
   }

   public void offer(T var1) {
      if (this.keyPool.size() < 20) {
         this.keyPool.offer((T)var1);
      }
   }
}
