package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzax extends zzev implements zzaw {
   public zzax() {
      this.attachInterface(this, "com.google.android.gms.common.internal.IGmsCallbacks");
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      boolean var5;
      if (this.a(var1, var2, var3, var4)) {
         var5 = true;
      } else {
         switch (var1) {
            case 1:
               this.a(var2.readInt(), var2.readStrongBinder(), zzew.a(var2, Bundle.CREATOR));
               break;
            case 2:
               this.a(var2.readInt(), zzew.a(var2, Bundle.CREATOR));
               break;
            default:
               var5 = false;
               return var5;
         }

         var3.writeNoException();
         var5 = true;
      }

      return var5;
   }
}
