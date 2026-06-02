package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzac implements zzf {
   private GoogleApiClient.ConnectionCallbacks a;

   zzac(GoogleApiClient.ConnectionCallbacks var1) {
      this.a = var1;
      super();
   }

   @Override
   public final void a(int var1) {
      this.a.a(var1);
   }

   @Override
   public final void a(Bundle var1) {
      this.a.a(var1);
   }
}
