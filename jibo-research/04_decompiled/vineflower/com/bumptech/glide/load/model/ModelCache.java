package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public class ModelCache<A, B> {
   private final LruCache<ModelCache.ModelKey<A>, B> cache;

   public ModelCache() {
      this(250);
   }

   public ModelCache(int var1) {
      this.cache = new LruCache<ModelCache.ModelKey<A>, B>(this, var1) {
         final ModelCache this$0;

         {
            this.this$0 = var1;
         }

         protected void onItemEvicted(ModelCache.ModelKey<A> var1, B var2) {
            var1.release();
         }
      };
   }

   public B get(A var1, int var2, int var3) {
      ModelCache.ModelKey var4 = ModelCache.ModelKey.get(var1, var2, var3);
      var1 = this.cache.get(var4);
      var4.release();
      return (B)var1;
   }

   public void put(A var1, int var2, int var3, B var4) {
      var1 = ModelCache.ModelKey.get(var1, var2, var3);
      this.cache.put((ModelCache.ModelKey<A>)var1, (B)var4);
   }

   static final class ModelKey<A> {
      private static final Queue<ModelCache.ModelKey<?>> KEY_QUEUE = Util.a(0);
      private int height;
      private A model;
      private int width;

      private ModelKey() {
      }

      static <A> ModelCache.ModelKey<A> get(A var0, int var1, int var2) {
         ModelCache.ModelKey var4 = KEY_QUEUE.poll();
         ModelCache.ModelKey var3 = var4;
         if (var4 == null) {
            var3 = new ModelCache.ModelKey();
         }

         var3.init(var0, var1, var2);
         return var3;
      }

      private void init(A var1, int var2, int var3) {
         this.model = (A)var1;
         this.width = var2;
         this.height = var3;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2 = var3;
         if (var1 instanceof ModelCache.ModelKey) {
            var1 = var1;
            var2 = var3;
            if (this.width == var1.width) {
               var2 = var3;
               if (this.height == var1.height) {
                  var2 = var3;
                  if (this.model.equals(var1.model)) {
                     var2 = true;
                  }
               }
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         return (this.height * 31 + this.width) * 31 + this.model.hashCode();
      }

      public void release() {
         KEY_QUEUE.offer(this);
      }
   }
}
