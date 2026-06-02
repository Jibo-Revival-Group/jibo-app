package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzbgd extends zzev implements zzbgc {
   public zzbgd() {
      this.attachInterface(this, "com.google.android.gms.common.internal.service.ICommonCallbacks");
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      boolean var5 = true;
      if (!this.a(var1, var2, var3, var4)) {
         if (var1 == 1) {
            this.a(var2.readInt());
            var3.writeNoException();
         } else {
            var5 = false;
         }
      }

      return var5;
   }
}
