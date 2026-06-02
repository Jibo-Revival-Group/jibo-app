package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.concurrent.atomic.AtomicReference;

final class zzbc implements GoogleApiClient.ConnectionCallbacks {
   private AtomicReference a;
   private zzda b;
   private zzba c;

   zzbc(zzba var1, AtomicReference var2, zzda var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
      super();
   }

   @Override
   public final void a(int var1) {
   }

   @Override
   public final void a(Bundle var1) {
      zzba.a(this.c, (GoogleApiClient)this.a.get(), this.b, true);
   }
}
