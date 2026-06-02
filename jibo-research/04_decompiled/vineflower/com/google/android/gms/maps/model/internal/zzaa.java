package com.google.android.gms.maps.model.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.maps.model.Tile;

public abstract class zzaa extends zzev implements zzz {
   public static zzz a(IBinder var0) {
      zzz var2;
      if (var0 == null) {
         var2 = null;
      } else {
         IInterface var1 = var0.queryLocalInterface("com.google.android.gms.maps.model.internal.ITileProviderDelegate");
         if (var1 instanceof zzz) {
            var2 = (zzz)var1;
         } else {
            var2 = new zzab(var0);
         }
      }

      return var2;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      boolean var5 = true;
      if (!this.a(var1, var2, var3, var4)) {
         if (var1 == 1) {
            Tile var6 = this.a(var2.readInt(), var2.readInt(), var2.readInt());
            var3.writeNoException();
            zzew.b(var3, var6);
         } else {
            var5 = false;
         }
      }

      return var5;
   }
}
