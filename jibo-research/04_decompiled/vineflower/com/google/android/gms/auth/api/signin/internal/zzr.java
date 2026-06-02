package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzev;

public abstract class zzr extends zzev implements zzq {
   public zzr() {
      this.attachInterface(this, "com.google.android.gms.auth.api.signin.internal.IRevocationService");
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      boolean var5 = true;
      if (!this.a(var1, var2, var3, var4)) {
         switch (var1) {
            case 1:
               this.a();
               break;
            case 2:
               this.b();
               break;
            default:
               var5 = false;
         }
      }

      return var5;
   }
}
