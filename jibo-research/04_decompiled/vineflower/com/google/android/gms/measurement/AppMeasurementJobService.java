package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.internal.zzcla;
import com.google.android.gms.internal.zzcle;

@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements zzcle {
   private zzcla<AppMeasurementJobService> a;

   private final zzcla<AppMeasurementJobService> a() {
      if (this.a == null) {
         this.a = new zzcla(this);
      }

      return this.a;
   }

   @TargetApi(24)
   @Override
   public final void a(JobParameters var1, boolean var2) {
      this.jobFinished(var1, false);
   }

   @Override
   public final void a(Intent var1) {
   }

   @Override
   public final boolean a(int var1) {
      throw new UnsupportedOperationException();
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

   public final boolean onStartJob(JobParameters var1) {
      return this.a().a(var1);
   }

   public final boolean onStopJob(JobParameters var1) {
      return false;
   }

   public final boolean onUnbind(Intent var1) {
      return this.a().b(var1);
   }
}
