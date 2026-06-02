package com.google.android.gms.internal;

import android.os.RemoteException;

final class zzcki implements Runnable {
   private zzcgi a;
   private zzckg b;

   zzcki(zzckg var1, zzcgi var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      zzche var1 = zzckg.d(this.b);
      if (var1 == null) {
         this.b.t().y().a("Failed to reset data on the service; null service");
      } else {
         try {
            var1.d(this.a);
         } catch (RemoteException var2) {
            this.b.t().y().a("Failed to reset data on the service", var2);
         }

         zzckg.e(this.b);
      }
   }
}
