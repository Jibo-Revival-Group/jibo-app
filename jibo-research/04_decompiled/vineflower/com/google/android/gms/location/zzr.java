package com.google.android.gms.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzr extends zzeu implements zzp {
   zzr(IBinder var1) {
      super(var1, "com.google.android.gms.location.ILocationCallback");
   }

   @Override
   public final void a(LocationAvailability var1) throws RemoteException {
      Parcel var2 = this.c();
      zzew.a(var2, var1);
      this.c(2, var2);
   }

   @Override
   public final void a(LocationResult var1) throws RemoteException {
      Parcel var2 = this.c();
      zzew.a(var2, var1);
      this.c(1, var2);
   }
}
