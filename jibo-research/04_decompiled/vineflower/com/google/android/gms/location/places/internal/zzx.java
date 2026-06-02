package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzx extends zzev implements zzw {
   public zzx() {
      this.attachInterface(this, "com.google.android.gms.location.places.internal.IPlacesCallbacks");
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      boolean var5;
      if (this.a(var1, var2, var3, var4)) {
         var5 = true;
      } else {
         switch (var1) {
            case 1:
               this.a(zzew.a(var2, DataHolder.CREATOR));
               break;
            case 2:
               this.b(zzew.a(var2, DataHolder.CREATOR));
               break;
            case 3:
               this.c(zzew.a(var2, DataHolder.CREATOR));
               break;
            case 4:
               this.a(zzew.a(var2, Status.CREATOR));
               break;
            case 5:
               this.d(zzew.a(var2, DataHolder.CREATOR));
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
