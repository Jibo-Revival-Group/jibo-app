package com.google.android.gms.internal;

import com.google.android.gms.common.api.internal.zzci;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzq;

final class zzcfe extends zzq {
   private final zzci<LocationCallback> a;

   @Override
   public final void a(LocationAvailability var1) {
      this.a.a(new zzcfg(this, var1));
   }

   @Override
   public final void a(LocationResult var1) {
      this.a.a(new zzcff(this, var1));
   }
}
