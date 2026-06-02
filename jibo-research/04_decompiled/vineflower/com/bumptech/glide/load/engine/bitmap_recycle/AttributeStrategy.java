package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.util.Util;

class AttributeStrategy implements LruPoolStrategy {
   private final GroupedLinkedMap<AttributeStrategy.Key, Bitmap> groupedMap;
   private final AttributeStrategy.KeyPool keyPool = new AttributeStrategy.KeyPool();

   AttributeStrategy() {
      this.groupedMap = new GroupedLinkedMap<>();
   }

   private static String getBitmapString(int var0, int var1, Config var2) {
      return "[" + var0 + "x" + var1 + "], " + var2;
   }

   private static String getBitmapString(Bitmap var0) {
      return getBitmapString(var0.getWidth(), var0.getHeight(), var0.getConfig());
   }

   @Override
   public Bitmap get(int var1, int var2, Config var3) {
      AttributeStrategy.Key var4 = this.keyPool.a(var1, var2, var3);
      return this.groupedMap.get(var4);
   }

   @Override
   public int getSize(Bitmap var1) {
      return Util.a(var1);
   }

   @Override
   public String logBitmap(int var1, int var2, Config var3) {
      return getBitmapString(var1, var2, var3);
   }

   @Override
   public String logBitmap(Bitmap var1) {
      return getBitmapString(var1);
   }

   @Override
   public void put(Bitmap var1) {
      AttributeStrategy.Key var2 = this.keyPool.a(var1.getWidth(), var1.getHeight(), var1.getConfig());
      this.groupedMap.put(var2, var1);
   }

   @Override
   public Bitmap removeLast() {
      return this.groupedMap.removeLast();
   }

   @Override
   public String toString() {
      return "AttributeStrategy:\n  " + this.groupedMap;
   }

   static class Key implements Poolable {
      private Config config;
      private int height;
      private final AttributeStrategy.KeyPool pool;
      private int width;

      public Key(AttributeStrategy.KeyPool var1) {
         this.pool = var1;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2 = var3;
         if (var1 instanceof AttributeStrategy.Key) {
            var1 = var1;
            var2 = var3;
            if (this.width == var1.width) {
               var2 = var3;
               if (this.height == var1.height) {
                  var2 = var3;
                  if (this.config == var1.config) {
                     var2 = true;
                  }
               }
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         int var2 = this.width;
         int var3 = this.height;
         int var1;
         if (this.config != null) {
            var1 = this.config.hashCode();
         } else {
            var1 = 0;
         }

         return var1 + (var2 * 31 + var3) * 31;
      }

      public void init(int var1, int var2, Config var3) {
         this.width = var1;
         this.height = var2;
         this.config = var3;
      }

      @Override
      public void offer() {
         this.pool.offer(this);
      }

      @Override
      public String toString() {
         return AttributeStrategy.getBitmapString(this.width, this.height, this.config);
      }
   }

   static class KeyPool extends BaseKeyPool<AttributeStrategy.Key> {
      protected AttributeStrategy.Key a() {
         return new AttributeStrategy.Key(this);
      }

      public AttributeStrategy.Key a(int var1, int var2, Config var3) {
         AttributeStrategy.Key var4 = this.get();
         var4.init(var1, var2, var3);
         return var4;
      }
   }
}
