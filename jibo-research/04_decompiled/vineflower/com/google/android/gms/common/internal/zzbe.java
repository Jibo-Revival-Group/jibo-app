package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzbe extends zzeu implements zzbd {
   zzbe(IBinder var1) {
      super(var1, "com.google.android.gms.common.internal.ISignInButtonCreator");
   }

   @Override
   public final IObjectWrapper a(IObjectWrapper var1, zzbv var2) throws RemoteException {
      Parcel var3 = this.c();
      zzew.a(var3, var1);
      zzew.a(var3, var2);
      Parcel var5 = this.a(2, var3);
      var1 = IObjectWrapper.zza.a(var5.readStrongBinder());
      var5.recycle();
      return var1;
   }
}
