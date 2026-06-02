package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.zzt;

final class zzcfi extends zzt {
   private final zzci<LocationListener> a;

   @Override
   public final void a(Location var1) {
      synchronized (this) {
         zzci var3 = this.a;
         zzcfj var2 = new zzcfj(this, var1);
         var3.a(var2);
      }
   }
}
