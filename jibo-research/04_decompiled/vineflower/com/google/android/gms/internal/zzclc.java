package com.google.android.gms.internal;

import android.app.job.JobParameters;

// $VF: synthetic class
final class zzclc implements Runnable {
   private final zzcla a;
   private final zzchm b;
   private final JobParameters c;

   zzclc(zzcla var1, zzchm var2, JobParameters var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   @Override
   public final void run() {
      this.a.a(this.b, this.c);
   }
}
