package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzl extends zzeu implements zzk {
   zzl(IBinder var1) {
      super(var1, "com.google.android.gms.dynamite.IDynamiteLoader");
   }

   @Override
   public final int a(IObjectWrapper var1, String var2, boolean var3) throws RemoteException {
      Parcel var5 = this.c();
      zzew.a(var5, var1);
      var5.writeString(var2);
      zzew.a(var5, var3);
      Parcel var6 = this.a(3, var5);
      int var4 = var6.readInt();
      var6.recycle();
      return var4;
   }

   @Override
   public final IObjectWrapper a(IObjectWrapper var1, String var2, int var3) throws RemoteException {
      Parcel var4 = this.c();
      zzew.a(var4, var1);
      var4.writeString(var2);
      var4.writeInt(var3);
      Parcel var5 = this.a(2, var4);
      IObjectWrapper var6 = IObjectWrapper.zza.a(var5.readStrongBinder());
      var5.recycle();
      return var6;
   }
}
