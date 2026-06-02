package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;

public class zzn extends zzev implements zzm {
   public static zzm a(IBinder var0) {
      zzm var2;
      if (var0 == null) {
         var2 = null;
      } else {
         IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
         if (var1 instanceof zzm) {
            var2 = (zzm)var1;
         } else {
            var2 = new zzo(var0);
         }
      }

      return var2;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      throw new NoSuchMethodError();
   }
}
