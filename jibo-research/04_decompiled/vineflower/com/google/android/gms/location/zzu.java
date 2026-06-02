package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;

public final class zzu extends zzeu implements zzs {
   zzu(IBinder var1) {
      super(var1, "com.google.android.gms.location.ILocationListener");
   }

   @Override
   public final void a(Location var1) throws RemoteException {
      Parcel var2 = this.c();
      zzew.a(var2, var1);
      this.c(1, var2);
   }
}
