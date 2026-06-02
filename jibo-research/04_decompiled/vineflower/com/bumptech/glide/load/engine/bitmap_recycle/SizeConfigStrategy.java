package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.Map.Entry;

@TargetApi(19)
public class SizeConfigStrategy implements LruPoolStrategy {
   private static final Config[] ALPHA_8_IN_CONFIGS = new Config[]{Config.ALPHA_8};
   private static final Config[] ARGB_4444_IN_CONFIGS = new Config[]{Config.ARGB_4444};
   private static final Config[] ARGB_8888_IN_CONFIGS = new Config[]{Config.ARGB_8888, null};
   private static final Config[] RGB_565_IN_CONFIGS = new Config[]{Config.RGB_565};
   private final GroupedLinkedMap<SizeConfigStrategy.Key, Bitmap> groupedMap;
   private final SizeConfigStrategy.KeyPool keyPool = new SizeConfigStrategy.KeyPool();
   private final Map<Config, NavigableMap<Integer, Integer>> sortedSizes;

   public SizeConfigStrategy() {
      this.groupedMap = new GroupedLinkedMap<>();
      this.sortedSizes = new HashMap<>();
   }

   private void decrementBitmapOfSize(Integer var1, Config var2) {
      NavigableMap var3 = this.getSizesForConfig(var2);
      Integer var4 = (Integer)var3.get(var1);
      if (var4 == 1) {
         var3.remove(var1);
      } else {
         var3.put(var1, var4 - 1);
      }
   }

   private SizeConfigStrategy.Key findBestKey(SizeConfigStrategy.Key var1, int var2, Config var3) {
      Config[] var8 = getInConfigs(var3);
      int var5 = var8.length;
      int var4 = 0;

      SizeConfigStrategy.Key var6;
      while (true) {
         var6 = var1;
         if (var4 >= var5) {
            break;
         }

         Config var7 = var8[var4];
         Integer var9 = this.getSizesForConfig(var7).ceilingKey(var2);
         if (var9 != null && var9 <= var2 * 8) {
            if (var9 == var2) {
               if (var7 == null) {
                  var6 = var1;
                  if (var3 == null) {
                     break;
                  }
               } else {
                  var6 = var1;
                  if (var7.equals(var3)) {
                     break;
                  }
               }
            }

            this.keyPool.offer(var1);
            var6 = this.keyPool.a(var9, var7);
            break;
         }

         var4++;
      }

      return var6;
   }

   private static String getBitmapString(int var0, Config var1) {
      return "[" + var0 + "](" + var1 + ")";
   }

   private static Config[] getInConfigs(Config var0) {
      Config[] var2;
      switch (<unrepresentable>.$SwitchMap$android$graphics$Bitmap$Config[var0.ordinal()]) {
         case 1:
            var2 = ARGB_8888_IN_CONFIGS;
            break;
         case 2:
            var2 = RGB_565_IN_CONFIGS;
            break;
         case 3:
            var2 = ARGB_4444_IN_CONFIGS;
            break;
         case 4:
            var2 = ALPHA_8_IN_CONFIGS;
            break;
         default:
            Config[] var1 = new Config[]{var0};
            var2 = var1;
      }

      return var2;
   }

   private NavigableMap<Integer, Integer> getSizesForConfig(Config var1) {
      NavigableMap var3 = this.sortedSizes.get(var1);
      NavigableMap var2 = var3;
      if (var3 == null) {
         var2 = new TreeMap();
         this.sortedSizes.put(var1, var2);
      }

      return var2;
   }

   @Override
   public Bitmap get(int var1, int var2, Config var3) {
      int var4 = Util.a(var1, var2, var3);
      SizeConfigStrategy.Key var6 = this.findBestKey(this.keyPool.a(var4, var3), var4, var3);
      Bitmap var5 = this.groupedMap.get(var6);
      if (var5 != null) {
         this.decrementBitmapOfSize(Util.a(var5), var5.getConfig());
         if (var5.getConfig() != null) {
            var3 = var5.getConfig();
         } else {
            var3 = Config.ARGB_8888;
         }

         var5.reconfigure(var1, var2, var3);
      }

      return var5;
   }

   @Override
   public int getSize(Bitmap var1) {
      return Util.a(var1);
   }

   @Override
   public String logBitmap(int var1, int var2, Config var3) {
      return getBitmapString(Util.a(var1, var2, var3), var3);
   }

   @Override
   public String logBitmap(Bitmap var1) {
      return getBitmapString(Util.a(var1), var1.getConfig());
   }

   @Override
   public void put(Bitmap var1) {
      int var2 = Util.a(var1);
      SizeConfigStrategy.Key var4 = this.keyPool.a(var2, var1.getConfig());
      this.groupedMap.put(var4, var1);
      NavigableMap var5 = this.getSizesForConfig(var1.getConfig());
      Integer var6 = (Integer)var5.get(var4.size);
      int var3 = var4.size;
      if (var6 == null) {
         var2 = 1;
      } else {
         var2 = var6 + 1;
      }

      var5.put(var3, var2);
   }

   @Override
   public Bitmap removeLast() {
      Bitmap var1 = this.groupedMap.removeLast();
      if (var1 != null) {
         this.decrementBitmapOfSize(Util.a(var1), var1.getConfig());
      }

      return var1;
   }

   @Override
   public String toString() {
      StringBuilder var3 = new StringBuilder().append("SizeConfigStrategy{groupedMap=").append(this.groupedMap).append(", sortedSizes=(");

      for (Entry var2 : this.sortedSizes.entrySet()) {
         var3.append(var2.getKey()).append('[').append(var2.getValue()).append("], ");
      }

      if (!this.sortedSizes.isEmpty()) {
         var3.replace(var3.length() - 2, var3.length(), "");
      }

      return var3.append(")}").toString();
   }

   static final class Key implements Poolable {
      private Config config;
      private final SizeConfigStrategy.KeyPool pool;
      private int size;

      public Key(SizeConfigStrategy.KeyPool var1) {
         this.pool = var1;
      }

      @Override
      public boolean equals(Object var1) {
         boolean var3 = false;
         boolean var2 = var3;
         if (var1 instanceof SizeConfigStrategy.Key) {
            var1 = var1;
            var2 = var3;
            if (this.size == var1.size) {
               if (this.config == null) {
                  var2 = var3;
                  if (var1.config != null) {
                     return var2;
                  }
               } else {
                  var2 = var3;
                  if (!this.config.equals(var1.config)) {
                     return var2;
                  }
               }

               var2 = true;
            }
         }

         return var2;
      }

      @Override
      public int hashCode() {
         int var2 = this.size;
         int var1;
         if (this.config != null) {
            var1 = this.config.hashCode();
         } else {
            var1 = 0;
         }

         return var1 + var2 * 31;
      }

      public void init(int var1, Config var2) {
         this.size = var1;
         this.config = var2;
      }

      @Override
      public void offer() {
         this.pool.offer(this);
      }

      @Override
      public String toString() {
         return SizeConfigStrategy.getBitmapString(this.size, this.config);
      }
   }

   static class KeyPool extends BaseKeyPool<SizeConfigStrategy.Key> {
      protected SizeConfigStrategy.Key a() {
         return new SizeConfigStrategy.Key(this);
      }

      public SizeConfigStrategy.Key a(int var1, Config var2) {
         SizeConfigStrategy.Key var3 = this.get();
         var3.init(var1, var2);
         return var3;
      }
   }
}
