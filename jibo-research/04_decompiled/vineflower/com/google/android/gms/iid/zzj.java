package com.google.android.gms.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzj extends zzeu implements zzi {
   zzj(IBinder var1) {
      super(var1, "com.google.android.gms.iid.IMessengerCompat");
   }

   @Override
   public final void a(Message var1) throws RemoteException {
      Parcel var2 = this.c();
      zzew.a(var2, var1);
      this.c(1, var2);
   }
}
