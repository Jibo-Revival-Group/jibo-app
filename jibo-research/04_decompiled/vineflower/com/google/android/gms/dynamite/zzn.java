package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzn extends zzeu implements zzm {
   zzn(IBinder var1) {
      super(var1, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
   }

   @Override
   public final IObjectWrapper a(IObjectWrapper var1, String var2, int var3, IObjectWrapper var4) throws RemoteException {
      Parcel var5 = this.c();
      zzew.a(var5, var1);
      var5.writeString(var2);
      var5.writeInt(var3);
      zzew.a(var5, var4);
      Parcel var6 = this.a(2, var5);
      IObjectWrapper var7 = IObjectWrapper.zza.a(var6.readStrongBinder());
      var6.recycle();
      return var7;
   }
}
