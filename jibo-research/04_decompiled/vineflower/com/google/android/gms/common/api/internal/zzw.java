package com.google.android.gms.common.api.internal;

final class zzw implements Runnable {
   private zzv a;

   zzw(zzv var1) {
      this.a = var1;
      super();
   }

   @Override
   public final void run() {
      zzv.a(this.a).lock();

      try {
         zzv.b(this.a);
      } finally {
         zzv.a(this.a).unlock();
      }
   }
}
