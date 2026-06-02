package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public abstract class zzcxk extends zzev implements zzcxj {
   public zzcxk() {
      this.attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) throws RemoteException {
      boolean var5;
      if (this.a(var1, var2, var3, var4)) {
         var5 = true;
      } else {
         switch (var1) {
            case 3:
               zzew.a(var2, ConnectionResult.CREATOR);
               zzew.a(var2, zzcxg.CREATOR);
               break;
            case 4:
               zzew.a(var2, Status.CREATOR);
               break;
            case 5:
            default:
               var5 = false;
               return var5;
            case 6:
               zzew.a(var2, Status.CREATOR);
               break;
            case 7:
               zzew.a(var2, Status.CREATOR);
               zzew.a(var2, GoogleSignInAccount.CREATOR);
               break;
            case 8:
               this.a(zzew.a(var2, zzcxq.CREATOR));
         }

         var3.writeNoException();
         var5 = true;
      }

      return var5;
   }
}
