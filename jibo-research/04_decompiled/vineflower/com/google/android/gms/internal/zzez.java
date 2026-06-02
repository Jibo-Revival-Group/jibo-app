package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzez extends zzeu implements zzex {
   zzez(IBinder var1) {
      super(var1, "com.google.android.auth.IAuthManagerService");
   }

   @Override
   public final Bundle a(Account var1, String var2, Bundle var3) throws RemoteException {
      Parcel var4 = this.c();
      zzew.a(var4, var1);
      var4.writeString(var2);
      zzew.a(var4, var3);
      Parcel var6 = this.a(5, var4);
      Bundle var5 = zzew.a(var6, Bundle.CREATOR);
      var6.recycle();
      return var5;
   }
}
