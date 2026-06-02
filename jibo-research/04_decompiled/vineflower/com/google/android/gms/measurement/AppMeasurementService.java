package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.zzcla;
import com.google.android.gms.internal.zzcle;

public final class AppMeasurementService extends Service implements zzcle {
   private zzcla<AppMeasurementService> a;

   private final zzcla<AppMeasurementService> a() {
      if (this.a == null) {
         this.a = new zzcla(this);
      }

      return this.a;
   }

   @Override
   public final void a(JobParameters var1, boolean var2) {
      throw new UnsupportedOperationException();
   }

   @Override
   public final void a(Intent var1) {
      AppMeasurementReceiver.a(var1);
   }

   @Override
   public final boolean a(int var1) {
      return this.stopSelfResult(var1);
   }

   public final IBinder onBind(Intent var1) {
      return this.a().a(var1);
   }

   public final void onCreate() {
      super.onCreate();
      this.a().a();
   }

   public final void onDestroy() {
      this.a().b();
      super.onDestroy();
   }

   public final void onRebind(Intent var1) {
      this.a().c(var1);
   }

   public final int onStartCommand(Intent var1, int var2, int var3) {
      return this.a().a(var1, var2, var3);
   }

   public final boolean onUnbind(Intent var1) {
      return this.a().b(var1);
   }
}
