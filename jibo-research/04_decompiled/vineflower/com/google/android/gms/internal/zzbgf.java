package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbgf extends zzeu implements zzbge {
   zzbgf(IBinder var1) {
      super(var1, "com.google.android.gms.common.internal.service.ICommonService");
   }

   @Override
   public final void a(zzbgc var1) throws RemoteException {
      Parcel var2 = this.c();
      zzew.a(var2, var1);
      this.c(1, var2);
   }
}
