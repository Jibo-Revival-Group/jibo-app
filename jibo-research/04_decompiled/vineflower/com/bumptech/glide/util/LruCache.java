package com.bumptech.glide.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LruCache<T, Y> {
   private final LinkedHashMap<T, Y> cache = new LinkedHashMap<>(100, 0.75F, true);
   private int currentSize = 0;
   private final int initialMaxSize;
   private int maxSize;

   public LruCache(int var1) {
      this.initialMaxSize = var1;
      this.maxSize = var1;
   }

   private void evict() {
      this.trimToSize(this.maxSize);
   }

   public void clearMemory() {
      this.trimToSize(0);
   }

   public Y get(T var1) {
      return this.cache.get(var1);
   }

   public int getCurrentSize() {
      return this.currentSize;
   }

   protected int getSize(Y var1) {
      return 1;
   }

   protected void onItemEvicted(T var1, Y var2) {
   }

   public Y put(T var1, Y var2) {
      if (this.getSize((Y)var2) >= this.maxSize) {
         this.onItemEvicted((T)var1, (Y)var2);
         var1 = null;
      } else {
         var1 = this.cache.put((T)var1, (Y)var2);
         if (var2 != null) {
            this.currentSize = this.currentSize + this.getSize((Y)var2);
         }

         if (var1 != null) {
            this.currentSize = this.currentSize - this.getSize((Y)var1);
         }

         this.evict();
      }

      return (Y)var1;
   }

   public Y remove(T var1) {
      var1 = this.cache.remove(var1);
      if (var1 != null) {
         this.currentSize = this.currentSize - this.getSize((Y)var1);
      }

      return (Y)var1;
   }

   protected void trimToSize(int var1) {
      while (this.currentSize > var1) {
         Entry var3 = this.cache.entrySet().iterator().next();
         Object var2 = var3.getValue();
         this.currentSize = this.currentSize - this.getSize((Y)var2);
         Object var4 = var3.getKey();
         this.cache.remove(var4);
         this.onItemEvicted((T)var4, (Y)var2);
      }
   }
}
