package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzt extends zzev implements zzs {
   public static zzs a(IBinder var0) {
      zzs var2;
      if (var0 == null) {
         var2 = null;
      } else {
         IInterface var1 = var0.queryLocalInterface("com.google.android.gms.location.ILocationListener");
         if (var1 instanceof zzs) {
            var2 = (zzs)var1;
         } else {
            var2 = new zzu(var0);
         }
      }

      return var2;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      boolean var5;
      if (this.a(var1, var2, var3, var4)) {
         var5 = true;
      } else if (var1 == 1) {
         this.a(zzew.a(var2, Location.CREATOR));
         var5 = true;
      } else {
         var5 = false;
      }

      return var5;
   }
}
