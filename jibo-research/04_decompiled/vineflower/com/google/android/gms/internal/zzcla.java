package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Build.VERSION;
import com.google.android.gms.common.internal.zzbq;

public final class zzcla<T extends Context & zzcle> {
   private final T a;

   public zzcla(T var1) {
      zzbq.a(var1);
      this.a = (T)var1;
   }

   private final void a(Runnable var1) {
      zzcim var2 = zzcim.a(this.a);
      var2.f();
      var2.h().a(new zzcld(this, var2, var1));
   }

   public static boolean a(Context var0, boolean var1) {
      zzbq.a(var0);
      if (VERSION.SDK_INT >= 24) {
         var1 = zzclq.a(var0, "com.google.android.gms.measurement.AppMeasurementJobService");
      } else {
         var1 = zzclq.a(var0, "com.google.android.gms.measurement.AppMeasurementService");
      }

      return var1;
   }

   private final zzchm c() {
      return zzcim.a(this.a).f();
   }

   public final int a(Intent var1, int var2, int var3) {
      zzchm var4 = zzcim.a(this.a).f();
      if (var1 == null) {
         var4.A().a("AppMeasurementService started with null intent");
      } else {
         String var5 = var1.getAction();
         var4.E().a("Local AppMeasurementService called. startId, action", var3, var5);
         if ("com.google.android.gms.measurement.UPLOAD".equals(var5)) {
            this.a(new zzclb(this, var3, var4, var1));
         }
      }

      return 2;
   }

   public final IBinder a(Intent var1) {
      Object var2 = null;
      zzcir var3;
      if (var1 == null) {
         this.c().y().a("onBind called with null intent");
         var3 = (zzcir)var2;
      } else {
         String var4 = var1.getAction();
         if ("com.google.android.gms.measurement.START".equals(var4)) {
            var3 = new zzcir(zzcim.a(this.a));
         } else {
            this.c().A().a("onBind received unknown action", var4);
            var3 = (zzcir)var2;
         }
      }

      return var3;
   }

   public final void a() {
      zzcim.a(this.a).f().E().a("Local AppMeasurementService is starting up");
   }

   @TargetApi(24)
   public final boolean a(JobParameters var1) {
      zzchm var3 = zzcim.a(this.a).f();
      String var2 = var1.getExtras().getString("action");
      var3.E().a("Local AppMeasurementJobService called. action", var2);
      if ("com.google.android.gms.measurement.UPLOAD".equals(var2)) {
         this.a(new zzclc(this, var3, var1));
      }

      return true;
   }

   public final void b() {
      zzcim.a(this.a).f().E().a("Local AppMeasurementService is shutting down");
   }

   public final boolean b(Intent var1) {
      if (var1 == null) {
         this.c().y().a("onUnbind called with null intent");
      } else {
         String var2 = var1.getAction();
         this.c().E().a("onUnbind called for intent. action", var2);
      }

      return true;
   }

   public final void c(Intent var1) {
      if (var1 == null) {
         this.c().y().a("onRebind called with null intent");
      } else {
         String var2 = var1.getAction();
         this.c().E().a("onRebind called. action", var2);
      }
   }
}
