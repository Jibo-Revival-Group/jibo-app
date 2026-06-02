package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzbd implements GoogleApiClient.OnConnectionFailedListener {
   private zzda a;

   zzbd(zzba var1, zzda var2) {
      this.a = var2;
      super();
   }

   @Override
   public final void a(ConnectionResult var1) {
      this.a.a((Status)(new Status(8)));
   }
}
