package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzbc extends zzeu implements zzba {
   zzbc(IBinder var1) {
      super(var1, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
   }

   @Override
   public final boolean a(com.google.android.gms.common.zzn var1, IObjectWrapper var2) throws RemoteException {
      Parcel var4 = this.c();
      zzew.a(var4, var1);
      zzew.a(var4, var2);
      Parcel var5 = this.a(5, var4);
      boolean var3 = zzew.a(var5);
      var5.recycle();
      return var3;
   }
}
