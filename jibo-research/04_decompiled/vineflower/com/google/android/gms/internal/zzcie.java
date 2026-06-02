package com.google.android.gms.internal;

import android.content.Context;
import android.content.BroadcastReceiver.PendingResult;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

final class zzcie implements Runnable {
   private zzcim a;
   private long b;
   private Bundle c;
   private Context d;
   private zzchm e;
   private PendingResult f;

   zzcie(zzcid var1, zzcim var2, long var3, Bundle var5, Context var6, zzchm var7, PendingResult var8) {
      this.a = var2;
      this.b = var3;
      this.c = var5;
      this.d = var6;
      this.e = var7;
      this.f = var8;
      super();
   }

   @Override
   public final void run() {
      zzclp var5 = this.a.q().c(this.a.y().z(), "_fot");
      long var1;
      if (var5 != null && var5.e instanceof Long) {
         var1 = (Long)var5.e;
      } else {
         var1 = 0L;
      }

      long var3 = this.b;
      if (var1 <= 0L || var3 < var1 && var3 > 0L) {
         var1 = var3;
      } else {
         var1--;
      }

      if (var1 > 0L) {
         this.c.putLong("click_timestamp", var1);
      }

      AppMeasurement.getInstance(this.d).logEventInternal("auto", "_cmp", this.c);
      this.e.E().a("Install campaign recorded");
      if (this.f != null) {
         this.f.finish();
      }
   }
}
