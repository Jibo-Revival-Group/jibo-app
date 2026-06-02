package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzad implements zzg {
   private GoogleApiClient.OnConnectionFailedListener a;

   zzad(GoogleApiClient.OnConnectionFailedListener var1) {
      this.a = var1;
      super();
   }

   @Override
   public final void a(ConnectionResult var1) {
      this.a.a(var1);
   }
}
