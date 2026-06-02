package com.google.android.gms.location.places.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzeu;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

public final class zzt extends zzeu implements zzs {
   zzt(IBinder var1) {
      super(var1, "com.google.android.gms.location.places.internal.IGooglePlacesService");
   }

   @Override
   public final void a(String var1, LatLngBounds var2, AutocompleteFilter var3, zzat var4, zzw var5) throws RemoteException {
      Parcel var6 = this.c();
      var6.writeString(var1);
      zzew.a(var6, var2);
      zzew.a(var6, var3);
      zzew.a(var6, var4);
      zzew.a(var6, var5);
      this.b(13, var6);
   }

   @Override
   public final void a(List<String> var1, zzat var2, zzw var3) throws RemoteException {
      Parcel var4 = this.c();
      var4.writeStringList(var1);
      zzew.a(var4, var2);
      zzew.a(var4, var3);
      this.b(17, var4);
   }
}
