package com.google.android.gms.location.places.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;

public interface zzs extends IInterface {
   void a(String var1, LatLngBounds var2, AutocompleteFilter var3, zzat var4, zzw var5) throws RemoteException;

   void a(List<String> var1, zzat var2, zzw var3) throws RemoteException;
}
