package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzax implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
   private zzao a;

   private zzax(zzao var1) {
      this.a = var1;
      super();
   }

   @Override
   public final void a(int var1) {
   }

   @Override
   public final void a(Bundle var1) {
      zzao.f(this.a).a(new zzav(this.a));
   }

   @Override
   public final void a(ConnectionResult var1) {
      zzao.c(this.a).lock();

      try {
         if (zzao.b(this.a, var1)) {
            zzao.i(this.a);
            zzao.j(this.a);
         } else {
            zzao.a(this.a, var1);
         }
      } finally {
         zzao.c(this.a).unlock();
      }
   }
}
