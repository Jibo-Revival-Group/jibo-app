package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzv extends zzeu implements zzu {
   zzv(IBinder var1) {
      super(var1, "com.google.android.gms.auth.api.signin.internal.ISignInService");
   }

   @Override
   public final void a(zzs var1, GoogleSignInOptions var2) throws RemoteException {
      Parcel var3 = this.c();
      zzew.a(var3, var1);
      zzew.a(var3, var2);
      this.b(103, var3);
   }
}
