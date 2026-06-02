package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzq extends zzev implements zzp {
   public static zzp a(IBinder var0) {
      zzp var2;
      if (var0 == null) {
         var2 = null;
      } else {
         IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
         if (var1 instanceof zzp) {
            var2 = (zzp)var1;
         } else {
            var2 = new zzr(var0);
         }
      }

      return var2;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      boolean var5;
      if (this.a(var1, var2, var3, var4)) {
         var5 = true;
      } else {
         switch (var1) {
            case 1:
               this.a(zzew.a(var2, LocationResult.CREATOR));
               break;
            case 2:
               this.a(zzew.a(var2, LocationAvailability.CREATOR));
               break;
            default:
               var5 = false;
               return var5;
         }

         var5 = true;
      }

      return var5;
   }
}
