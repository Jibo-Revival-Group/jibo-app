package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzbet extends zzeu implements zzbes {
   zzbet(IBinder var1) {
      super(var1, "com.google.android.gms.clearcut.internal.IClearcutLoggerService");
   }

   @Override
   public final void a(zzbeq var1, zzbeh var2) throws RemoteException {
      Parcel var3 = this.c();
      zzew.a(var3, var1);
      zzew.a(var3, var2);
      this.c(1, var3);
   }
}
