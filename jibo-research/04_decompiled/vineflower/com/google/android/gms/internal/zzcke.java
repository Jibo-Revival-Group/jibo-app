package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;

final class zzcke implements Runnable {
   private zzckf a;
   private zzckc b;

   zzcke(zzckc var1, zzckf var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      zzckc.a(this.b, this.a);
      this.b.a = null;
      this.b.i().a((AppMeasurement.zzb)null);
   }
}
