package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;

final class zzcjp implements Runnable {
   private AppMeasurement.ConditionalUserProperty a;
   private zzcjn b;

   zzcjp(zzcjn var1, AppMeasurement.ConditionalUserProperty var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      zzcjn.a(this.b, this.a);
   }
}
