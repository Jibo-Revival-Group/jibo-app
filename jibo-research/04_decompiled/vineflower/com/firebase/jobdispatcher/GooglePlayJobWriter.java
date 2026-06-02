package com.firebase.jobdispatcher;

import android.net.Uri;
import android.os.Bundle;

final class GooglePlayJobWriter {
   private final JobCoder a = new JobCoder("com.firebase.jobdispatcher.");

   private static int a(int var0) {
      byte var1;
      switch (var0) {
         case 2:
            var1 = 1;
            break;
         default:
            var1 = 0;
      }

      return var1;
   }

   private static void a(Bundle var0) {
      var0.putInt("trigger_type", 2);
      var0.putLong("window_start", 0L);
      var0.putLong("window_end", 1L);
   }

   private static void a(Bundle var0, JobTrigger.ContentUriTrigger var1) {
      var0.putInt("trigger_type", 3);
      int var3 = var1.a().size();
      int[] var4 = new int[var3];
      Uri[] var5 = new Uri[var3];

      for (int var2 = 0; var2 < var3; var2++) {
         ObservedUri var6 = var1.a().get(var2);
         var4[var2] = var6.b();
         var5[var2] = var6.a();
      }

      var0.putIntArray("content_uri_flags_array", var4);
      var0.putParcelableArray("content_uri_array", var5);
   }

   private static void a(JobParameters var0, Bundle var1, JobTrigger.ExecutionWindowTrigger var2) {
      var1.putInt("trigger_type", 1);
      if (var0.h()) {
         var1.putLong("period", var2.b());
         var1.putLong("period_flex", var2.b() - var2.a());
      } else {
         var1.putLong("window_start", var2.a());
         var1.putLong("window_end", var2.b());
      }
   }

   private static int b(int var0) {
      byte var1 = 2;
      byte var2 = 1;
      if ((var0 & 2) == 2) {
         var1 = 0;
      }

      if ((var0 & 1) == 1) {
         var1 = var2;
      }

      return var1;
   }

   private static void b(JobParameters var0, Bundle var1) {
      RetryStrategy var3 = var0.c();
      Bundle var2 = new Bundle();
      var2.putInt("retry_policy", a(var3.a()));
      var2.putInt("initial_backoff_seconds", var3.b());
      var2.putInt("maximum_backoff_seconds", var3.c());
      var1.putBundle("retryStrategy", var2);
   }

   private static void c(JobParameters var0, Bundle var1) {
      JobTrigger var2 = var0.f();
      if (var2 == Trigger.a) {
         a(var1);
      } else if (var2 instanceof JobTrigger.ExecutionWindowTrigger) {
         a(var0, var1, (JobTrigger.ExecutionWindowTrigger)var2);
      } else {
         if (!(var2 instanceof JobTrigger.ContentUriTrigger)) {
            throw new IllegalArgumentException("Unknown trigger: " + var2.getClass());
         }

         a(var1, (JobTrigger.ContentUriTrigger)var2);
      }
   }

   private static void d(JobParameters var0, Bundle var1) {
      boolean var4 = true;
      int var2 = Constraint.a(var0.a());
      boolean var3;
      if ((var2 & 4) == 4) {
         var3 = true;
      } else {
         var3 = false;
      }

      var1.putBoolean("requiresCharging", var3);
      if ((var2 & 8) == 8) {
         var3 = var4;
      } else {
         var3 = false;
      }

      var1.putBoolean("requiresIdle", var3);
      var1.putInt("requiredNetwork", b(var2));
   }

   public Bundle a(JobParameters var1, Bundle var2) {
      var2.putString("tag", var1.e());
      var2.putBoolean("update_current", var1.d());
      boolean var3;
      if (var1.g() == 2) {
         var3 = true;
      } else {
         var3 = false;
      }

      var2.putBoolean("persisted", var3);
      var2.putString("service", GooglePlayReceiver.class.getName());
      c(var1, var2);
      d(var1, var2);
      b(var1, var2);
      Bundle var5 = var1.b();
      Bundle var4 = var5;
      if (var5 == null) {
         var4 = new Bundle();
      }

      var2.putBundle("extras", this.a.a(var1, var4));
      return var2;
   }
}
