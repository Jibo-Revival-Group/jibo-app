package com.google.android.gms.internal;

import android.os.Looper;

final class zzcgt implements Runnable {
   private zzcgs a;

   zzcgt(zzcgs var1) {
      this.a = var1;
      super();
   }

   @Override
   public final void run() {
      if (Looper.myLooper() == Looper.getMainLooper()) {
         zzcgs.a(this.a).h().a(this);
      } else {
         boolean var1 = this.a.b();
         zzcgs.a(this.a, 0L);
         if (var1 && zzcgs.b(this.a)) {
            this.a.a();
         }
      }
   }
}
