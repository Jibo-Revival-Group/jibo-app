package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;

public abstract class zzt extends zzev implements zzs {
   public zzt() {
      this.attachInterface(this, "com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      boolean var5;
      if (this.a(var1, var2, var3, var4)) {
         var5 = true;
      } else {
         switch (var1) {
            case 101:
               this.a(zzew.a(var2, GoogleSignInAccount.CREATOR), zzew.a(var2, Status.CREATOR));
               break;
            case 102:
               this.a(zzew.a(var2, Status.CREATOR));
               break;
            case 103:
               this.b(zzew.a(var2, Status.CREATOR));
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
