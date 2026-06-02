package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;

public abstract class zzbb extends zzev implements zzba {
   public static zzba a(IBinder var0) {
      zzba var2;
      if (var0 == null) {
         var2 = null;
      } else {
         IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
         if (var1 instanceof zzba) {
            var2 = (zzba)var1;
         } else {
            var2 = new zzbc(var0);
         }
      }

      return var2;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      throw new NoSuchMethodError();
   }
}
