package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.SystemClock;
import android.os.Build.VERSION;

public final class LogTime {
   private static final double a;

   static {
      double var0 = 1.0;
      if (17 <= VERSION.SDK_INT) {
         var0 = 1.0 / Math.pow(10.0, 6.0);
      }

      a = var0;
   }

   public static double a(long var0) {
      return (a() - var0) * a;
   }

   @TargetApi(17)
   public static long a() {
      long var0;
      if (17 <= VERSION.SDK_INT) {
         var0 = SystemClock.elapsedRealtimeNanos();
      } else {
         var0 = System.currentTimeMillis();
      }

      return var0;
   }
}
