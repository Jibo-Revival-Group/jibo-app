package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzap extends zzeu implements zzan {
   zzap(IBinder var1) {
      super(var1, "com.google.android.gms.common.internal.IAccountAccessor");
   }

   @Override
   public final Account a() throws RemoteException {
      Parcel var2 = this.a(2, this.c());
      Account var1 = zzew.a(var2, Account.CREATOR);
      var2.recycle();
      return var1;
   }
}
