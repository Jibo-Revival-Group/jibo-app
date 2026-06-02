package com.google.firebase.iid;

import android.content.Intent;
import android.content.BroadcastReceiver.PendingResult;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzd {
   final Intent a;
   private final PendingResult b;
   private boolean c = false;
   private final ScheduledFuture<?> d;

   zzd(Intent var1, PendingResult var2, ScheduledExecutorService var3) {
      this.a = var1;
      this.b = var2;
      this.d = var3.schedule(new zze(this, var1), 9500L, TimeUnit.MILLISECONDS);
   }

   final void a() {
      synchronized (this) {
         if (!this.c) {
            this.b.finish();
            this.d.cancel(false);
            this.c = true;
         }
      }
   }
}
