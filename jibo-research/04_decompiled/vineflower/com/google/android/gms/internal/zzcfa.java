package com.google.android.gms.internal;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationAvailability;

public final class zzcfa extends zzeu implements zzcez {
   zzcfa(IBinder var1) {
      super(var1, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
   }

   @Override
   public final Location a(String var1) throws RemoteException {
      Parcel var2 = this.c();
      var2.writeString(var1);
      Parcel var3 = this.a(21, var2);
      Location var4 = zzew.a(var3, Location.CREATOR);
      var3.recycle();
      return var4;
   }

   @Override
   public final void a(zzcdz var1) throws RemoteException {
      Parcel var2 = this.c();
      zzew.a(var2, var1);
      this.b(75, var2);
   }

   @Override
   public final void a(zzcfq var1) throws RemoteException {
      Parcel var2 = this.c();
      zzew.a(var2, var1);
      this.b(59, var2);
   }

   @Override
   public final void a(boolean var1) throws RemoteException {
      Parcel var2 = this.c();
      zzew.a(var2, var1);
      this.b(12, var2);
   }

   @Override
   public final LocationAvailability b(String var1) throws RemoteException {
      Parcel var2 = this.c();
      var2.writeString(var1);
      var2 = this.a(34, var2);
      LocationAvailability var3 = zzew.a(var2, LocationAvailability.CREATOR);
      var2.recycle();
      return var3;
   }
}
