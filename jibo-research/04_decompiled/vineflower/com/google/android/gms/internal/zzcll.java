package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobInfo.Builder;
import android.content.ComponentName;
import android.content.Intent;
import android.os.PersistableBundle;
import android.os.Build.VERSION;

public final class zzcll extends zzcjl {
   private final AlarmManager a = (AlarmManager)this.l().getSystemService("alarm");
   private final zzcgs b;
   private Integer c;

   protected zzcll(zzcim var1) {
      super(var1);
      this.b = new zzclm(this, var1);
   }

   private final int A() {
      if (this.c == null) {
         String var1 = String.valueOf(this.l().getPackageName());
         if (var1.length() != 0) {
            var1 = "measurement".concat(var1);
         } else {
            var1 = new String("measurement");
         }

         this.c = var1.hashCode();
      }

      return this.c;
   }

   private final PendingIntent B() {
      Intent var1 = new Intent().setClassName(this.l(), "com.google.android.gms.measurement.AppMeasurementReceiver");
      var1.setAction("com.google.android.gms.measurement.UPLOAD");
      return PendingIntent.getBroadcast(this.l(), 0, var1, 0);
   }

   @TargetApi(24)
   private final void z() {
      JobScheduler var1 = (JobScheduler)this.l().getSystemService("jobscheduler");
      this.t().E().a("Cancelling job. JobID", this.A());
      var1.cancel(this.A());
   }

   public final void a(long var1) {
      this.Q();
      if (!zzcid.a(this.l())) {
         this.t().D().a("Receiver not registered/enabled");
      }

      if (!zzcla.a(this.l(), false)) {
         this.t().D().a("Service not registered/enabled");
      }

      this.y();
      long var3 = this.k().b();
      if (var1 < Math.max(0L, zzchc.z.b()) && !this.b.b()) {
         this.t().E().a("Scheduling upload with DelayedRunnable");
         this.b.a(var1);
      }

      if (VERSION.SDK_INT >= 24) {
         this.t().E().a("Scheduling upload with JobScheduler");
         ComponentName var6 = new ComponentName(this.l(), "com.google.android.gms.measurement.AppMeasurementJobService");
         JobScheduler var5 = (JobScheduler)this.l().getSystemService("jobscheduler");
         Builder var7 = new Builder(this.A(), var6);
         var7.setMinimumLatency(var1);
         var7.setOverrideDeadline(var1 << 1);
         PersistableBundle var8 = new PersistableBundle();
         var8.putString("action", "com.google.android.gms.measurement.UPLOAD");
         var7.setExtras(var8);
         JobInfo var9 = var7.build();
         this.t().E().a("Scheduling job. JobID", this.A());
         var5.schedule(var9);
      } else {
         this.t().E().a("Scheduling upload with AlarmManager");
         this.a.setInexactRepeating(2, var3 + var1, Math.max(zzchc.u.b(), var1), this.B());
      }
   }

   @Override
   protected final boolean w() {
      this.a.cancel(this.B());
      if (VERSION.SDK_INT >= 24) {
         this.z();
      }

      return false;
   }

   public final void y() {
      this.Q();
      this.a.cancel(this.B());
      this.b.c();
      if (VERSION.SDK_INT >= 24) {
         this.z();
      }
   }
}
