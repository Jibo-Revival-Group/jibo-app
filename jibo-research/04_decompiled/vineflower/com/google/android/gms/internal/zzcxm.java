package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzan;

public final class zzcxm extends zzeu implements zzcxl {
   zzcxm(IBinder var1) {
      super(var1, "com.google.android.gms.signin.internal.ISignInService");
   }

   @Override
   public final void a(int var1) throws RemoteException {
      Parcel var2 = this.c();
      var2.writeInt(var1);
      this.b(7, var2);
   }

   @Override
   public final void a(zzan var1, int var2, boolean var3) throws RemoteException {
      Parcel var4 = this.c();
      zzew.a(var4, var1);
      var4.writeInt(var2);
      zzew.a(var4, var3);
      this.b(9, var4);
   }

   @Override
   public final void a(zzcxo var1, zzcxj var2) throws RemoteException {
      Parcel var3 = this.c();
      zzew.a(var3, var1);
      zzew.a(var3, var2);
      this.b(12, var3);
   }
}
