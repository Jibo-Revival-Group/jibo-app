package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzey extends zzev implements zzex {
   public static zzex a(IBinder var0) {
      zzex var2;
      if (var0 == null) {
         var2 = null;
      } else {
         IInterface var1 = var0.queryLocalInterface("com.google.android.auth.IAuthManagerService");
         if (var1 instanceof zzex) {
            var2 = (zzex)var1;
         } else {
            var2 = new zzez(var0);
         }
      }

      return var2;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      throw new NoSuchMethodError();
   }
}
