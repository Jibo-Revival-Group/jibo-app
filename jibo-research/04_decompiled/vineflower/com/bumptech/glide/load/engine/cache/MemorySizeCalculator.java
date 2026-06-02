package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

public class MemorySizeCalculator {
   private final int bitmapPoolSize;
   private final Context context;
   private final int memoryCacheSize;

   public MemorySizeCalculator(Context var1) {
      this(
         var1,
         (ActivityManager)var1.getSystemService("activity"),
         new MemorySizeCalculator.DisplayMetricsScreenDimensions(var1.getResources().getDisplayMetrics())
      );
   }

   MemorySizeCalculator(Context var1, ActivityManager var2, MemorySizeCalculator.ScreenDimensions var3) {
      this.context = var1;
      int var4 = getMaxSize(var2);
      int var6 = var3.getWidthPixels() * var3.getHeightPixels() * 4;
      int var5 = var6 * 4;
      int var7 = var6 * 2;
      if (var7 + var5 <= var4) {
         this.memoryCacheSize = var7;
         this.bitmapPoolSize = var5;
      } else {
         var6 = Math.round(var4 / 6.0F);
         this.memoryCacheSize = var6 * 2;
         this.bitmapPoolSize = var6 * 4;
      }

      if (Log.isLoggable("MemorySizeCalculator", 3)) {
         StringBuilder var9 = new StringBuilder()
            .append("Calculated memory cache size: ")
            .append(this.toMb(this.memoryCacheSize))
            .append(" pool size: ")
            .append(this.toMb(this.bitmapPoolSize))
            .append(" memory class limited? ");
         boolean var8;
         if (var7 + var5 > var4) {
            var8 = true;
         } else {
            var8 = false;
         }

         Log.d(
            "MemorySizeCalculator",
            var9.append(var8)
               .append(" max size: ")
               .append(this.toMb(var4))
               .append(" memoryClass: ")
               .append(var2.getMemoryClass())
               .append(" isLowMemoryDevice: ")
               .append(isLowMemoryDevice(var2))
               .toString()
         );
      }
   }

   private static int getMaxSize(ActivityManager var0) {
      int var3 = var0.getMemoryClass();
      boolean var4 = isLowMemoryDevice(var0);
      float var2 = var3 * 1024 * 1024;
      float var1;
      if (var4) {
         var1 = 0.33F;
      } else {
         var1 = 0.4F;
      }

      return Math.round(var1 * var2);
   }

   @TargetApi(19)
   private static boolean isLowMemoryDevice(ActivityManager var0) {
      boolean var1;
      if (VERSION.SDK_INT >= 19) {
         var1 = var0.isLowRamDevice();
      } else if (VERSION.SDK_INT < 11) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   private String toMb(int var1) {
      return Formatter.formatFileSize(this.context, var1);
   }

   public int getBitmapPoolSize() {
      return this.bitmapPoolSize;
   }

   public int getMemoryCacheSize() {
      return this.memoryCacheSize;
   }

   private static class DisplayMetricsScreenDimensions implements MemorySizeCalculator.ScreenDimensions {
      private final DisplayMetrics displayMetrics;

      public DisplayMetricsScreenDimensions(DisplayMetrics var1) {
         this.displayMetrics = var1;
      }

      @Override
      public int getHeightPixels() {
         return this.displayMetrics.heightPixels;
      }

      @Override
      public int getWidthPixels() {
         return this.displayMetrics.widthPixels;
      }
   }

   interface ScreenDimensions {
      int getHeightPixels();

      int getWidthPixels();
   }
}
