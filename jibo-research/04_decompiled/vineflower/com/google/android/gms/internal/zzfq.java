package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzfq extends zzeu implements zzfo {
   zzfq(IBinder var1) {
      super(var1, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
   }

   @Override
   public final String a() throws RemoteException {
      Parcel var1 = this.a(1, this.c());
      String var2 = var1.readString();
      var1.recycle();
      return var2;
   }

   @Override
   public final boolean a(boolean var1) throws RemoteException {
      Parcel var2 = this.c();
      zzew.a(var2, true);
      var2 = this.a(2, var2);
      var1 = zzew.a(var2);
      var2.recycle();
      return var1;
   }

   @Override
   public final boolean b() throws RemoteException {
      Parcel var2 = this.a(6, this.c());
      boolean var1 = zzew.a(var2);
      var2.recycle();
      return var1;
   }
}
