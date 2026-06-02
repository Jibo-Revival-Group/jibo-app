package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzber extends zzev implements zzbeq {
   public zzber() {
      this.attachInterface(this, "com.google.android.gms.clearcut.internal.IClearcutLoggerCallbacks");
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      boolean var5;
      if (this.a(var1, var2, var3, var4)) {
         var5 = true;
      } else {
         switch (var1) {
            case 1:
               this.a(zzew.a(var2, Status.CREATOR));
               break;
            case 2:
               this.b(zzew.a(var2, Status.CREATOR));
               break;
            case 3:
               this.a(zzew.a(var2, Status.CREATOR), var2.readLong());
               break;
            case 4:
               this.c(zzew.a(var2, Status.CREATOR));
               break;
            case 5:
               this.b(zzew.a(var2, Status.CREATOR), var2.readLong());
               break;
            case 6:
               this.a(zzew.a(var2, Status.CREATOR), (zzbeh[])var2.createTypedArray(zzbeh.CREATOR));
               break;
            case 7:
               this.a(zzew.a(var2, DataHolder.CREATOR));
               break;
            case 8:
               this.a(zzew.a(var2, Status.CREATOR), zzew.a(var2, zzbef.CREATOR));
               break;
            case 9:
               this.b(zzew.a(var2, Status.CREATOR), zzew.a(var2, zzbef.CREATOR));
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
