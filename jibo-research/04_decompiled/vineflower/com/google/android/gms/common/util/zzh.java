package com.google.android.gms.common.util;

import android.os.SystemClock;

public final class zzh implements zzd {
   private static zzh a = new zzh();

   private zzh() {
   }

   public static zzd d() {
      return a;
   }

   @Override
   public final long a() {
      return System.currentTimeMillis();
   }

   @Override
   public final long b() {
      return SystemClock.elapsedRealtime();
   }

   @Override
   public final long c() {
      return System.nanoTime();
   }
}
