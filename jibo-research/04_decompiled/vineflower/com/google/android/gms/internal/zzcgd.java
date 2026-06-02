package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Map;

public final class zzcgd extends zzcjk {
   private final Map<String, Long> a;
   private final Map<String, Integer> b = new ArrayMap<>();
   private long c;

   public zzcgd(zzcim var1) {
      super(var1);
      this.a = new ArrayMap<>();
   }

   private final void a(long var1, AppMeasurement.zzb var3) {
      if (var3 == null) {
         this.t().E().a("Not logging ad exposure. No active activity");
      } else if (var1 < 1000L) {
         this.t().E().a("Not logging ad exposure. Less than 1000 ms. exposure", var1);
      } else {
         Bundle var4 = new Bundle();
         var4.putLong("_xt", var1);
         zzckc.a(var3, var4);
         this.f().a("am", "_xa", var4);
      }
   }

   private final void a(String var1, long var2) {
      this.c();
      zzbq.a(var1);
      if (this.b.isEmpty()) {
         this.c = var2;
      }

      Integer var4 = this.b.get(var1);
      if (var4 != null) {
         this.b.put(var1, var4 + 1);
      } else if (this.b.size() >= 100) {
         this.t().A().a("Too many ads visible");
      } else {
         this.b.put(var1, 1);
         this.a.put(var1, var2);
      }
   }

   private final void a(String var1, long var2, AppMeasurement.zzb var4) {
      if (var4 == null) {
         this.t().E().a("Not logging ad unit exposure. No active activity");
      } else if (var2 < 1000L) {
         this.t().E().a("Not logging ad unit exposure. Less than 1000 ms. exposure", var2);
      } else {
         Bundle var5 = new Bundle();
         var5.putString("_ai", var1);
         var5.putLong("_xt", var2);
         zzckc.a(var4, var5);
         this.f().a("am", "_xu", var5);
      }
   }

   private final void b(long var1) {
      for (String var4 : this.a.keySet()) {
         this.a.put(var4, var1);
      }

      if (!this.a.isEmpty()) {
         this.c = var1;
      }
   }

   private final void b(String var1, long var2) {
      this.c();
      zzbq.a(var1);
      Integer var8 = this.b.get(var1);
      if (var8 != null) {
         zzckf var7 = this.j().y();
         int var4 = var8 - 1;
         if (var4 == 0) {
            this.b.remove(var1);
            Long var9 = this.a.get(var1);
            if (var9 == null) {
               this.t().y().a("First ad unit exposure time was never set");
            } else {
               long var5 = var9;
               this.a.remove(var1);
               this.a(var1, var2 - var5, var7);
            }

            if (this.b.isEmpty()) {
               if (this.c == 0L) {
                  this.t().y().a("First ad exposure time was never set");
               } else {
                  this.a(var2 - this.c, var7);
                  this.c = 0L;
               }
            }
         } else {
            this.b.put(var1, var4);
         }
      } else {
         this.t().y().a("Call to endAdUnitExposure for unknown ad unit id", var1);
      }
   }

   public final void a(long var1) {
      zzckf var4 = this.j().y();

      for (String var5 : this.a.keySet()) {
         this.a(var5, var1 - this.a.get(var5), var4);
      }

      if (!this.a.isEmpty()) {
         this.a(var1 - this.c, var4);
      }

      this.b(var1);
   }

   public final void a(String var1) {
      if (var1 != null && var1.length() != 0) {
         long var2 = this.k().b();
         this.s().a(new zzcge(this, var1, var2));
      } else {
         this.t().y().a("Ad unit id must be a non-empty string");
      }
   }

   public final void b(String var1) {
      if (var1 != null && var1.length() != 0) {
         long var2 = this.k().b();
         this.s().a(new zzcgf(this, var1, var2));
      } else {
         this.t().y().a("Ad unit id must be a non-empty string");
      }
   }
}
