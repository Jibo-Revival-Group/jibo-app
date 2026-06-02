package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;

public final class zzav extends zzeu implements zzat {
   zzav(IBinder var1) {
      super(var1, "com.google.android.gms.common.internal.ICertData");
   }

   @Override
   public final IObjectWrapper a() throws RemoteException {
      Parcel var2 = this.a(1, this.c());
      IObjectWrapper var1 = IObjectWrapper.zza.a(var2.readStrongBinder());
      var2.recycle();
      return var1;
   }

   @Override
   public final int b() throws RemoteException {
      Parcel var2 = this.a(2, this.c());
      int var1 = var2.readInt();
      var2.recycle();
      return var1;
   }
}
