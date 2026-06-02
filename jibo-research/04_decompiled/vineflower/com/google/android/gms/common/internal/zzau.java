package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzau extends zzev implements zzat {
   public zzau() {
      this.attachInterface(this, "com.google.android.gms.common.internal.ICertData");
   }

   public static zzat a(IBinder var0) {
      zzat var2;
      if (var0 == null) {
         var2 = null;
      } else {
         IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
         if (var1 instanceof zzat) {
            var2 = (zzat)var1;
         } else {
            var2 = new zzav(var0);
         }
      }

      return var2;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      boolean var5 = true;
      if (!this.a(var1, var2, var3, var4)) {
         switch (var1) {
            case 1:
               IObjectWrapper var7 = this.a();
               var3.writeNoException();
               zzew.a(var3, var7);
               break;
            case 2:
               var1 = this.b();
               var3.writeNoException();
               var3.writeInt(var1);
               break;
            default:
               var5 = false;
         }
      }

      return var5;
   }
}
