package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzckn implements Runnable {
   private zzcgi a;
   private zzckg b;

   zzckn(zzckg var1, zzcgi var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      zzche var1 = zzckg.d(this.b);
      if (var1 == null) {
         this.b.t().y().a("Failed to send measurementEnabled to service");
      } else {
         try {
            var1.b(this.a);
            zzckg.e(this.b);
         } catch (RemoteException var2) {
            this.b.t().y().a("Failed to send measurementEnabled to the service", var2);
         }
      }
   }
}
