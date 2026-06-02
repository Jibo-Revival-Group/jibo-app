package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;

final class zzcjj implements Runnable {
   private String a;
   private String b;
   private String c;
   private long d;
   private zzcir e;

   zzcjj(zzcir var1, String var2, String var3, String var4, long var5) {
      this.e = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
      super();
   }

   @Override
   public final void run() {
      if (this.a == null) {
         zzcir.a(this.e).v().a(this.b, null);
      } else {
         AppMeasurement.zzb var1 = new AppMeasurement.zzb();
         var1.b = this.c;
         var1.c = this.a;
         var1.d = this.d;
         zzcir.a(this.e).v().a(this.b, var1);
      }
   }
}
