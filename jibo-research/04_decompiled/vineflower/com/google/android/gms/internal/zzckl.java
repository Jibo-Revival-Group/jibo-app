package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.measurement.AppMeasurement;

final class zzckl implements Runnable {
   private AppMeasurement.zzb a;
   private zzckg b;

   zzckl(zzckg var1, AppMeasurement.zzb var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   // $VF: Duplicated exception handlers to handle obfuscated exceptions
   @Override
   public final void run() {
      zzche var1 = zzckg.d(this.b);
      if (var1 == null) {
         this.b.t().y().a("Failed to send current screen to service");
      } else {
         label33: {
            try {
               if (this.a == null) {
                  var1.a(0L, null, null, this.b.l().getPackageName());
                  break label33;
               }
            } catch (RemoteException var4) {
               this.b.t().y().a("Failed to send current screen to the service", var4);
               return;
            }

            try {
               var1.a(this.a.d, this.a.b, this.a.c, this.b.l().getPackageName());
            } catch (RemoteException var3) {
               this.b.t().y().a("Failed to send current screen to the service", var3);
               return;
            }
         }

         try {
            zzckg.e(this.b);
         } catch (RemoteException var2) {
            this.b.t().y().a("Failed to send current screen to the service", var2);
         }
      }
   }
}
