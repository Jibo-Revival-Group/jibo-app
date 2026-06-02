package com.google.android.gms.internal;

import android.content.Intent;

final class zzclm extends zzcgs {
   private zzcll a;

   zzclm(zzcll var1, zzcim var2) {
      this.a = var1;
      super(var2);
   }

   @Override
   public final void a() {
      this.a.y();
      this.a.t().E().a("Sending upload intent from DelayedRunnable");
      Intent var1 = new Intent().setClassName(this.a.l(), "com.google.android.gms.measurement.AppMeasurementReceiver");
      var1.setAction("com.google.android.gms.measurement.UPLOAD");
      this.a.l().sendBroadcast(var1);
   }
}
