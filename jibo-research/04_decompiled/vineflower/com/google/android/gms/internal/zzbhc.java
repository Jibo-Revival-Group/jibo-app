package com.google.android.gms.internal;

import android.os.Process;

final class zzbhc implements Runnable {
   private final Runnable a;
   private final int b;

   public zzbhc(Runnable var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   @Override
   public final void run() {
      Process.setThreadPriority(this.b);
      this.a.run();
   }
}
