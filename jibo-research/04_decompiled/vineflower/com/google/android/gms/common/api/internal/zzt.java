package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

public final class zzt implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
   public final Api<?> a;
   private final boolean b;
   private zzu c;

   public zzt(Api<?> var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   private final void a() {
      com.google.android.gms.common.internal.zzbq.a(this.c, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
   }

   @Override
   public final void a(int var1) {
      this.a();
      this.c.a(var1);
   }

   @Override
   public final void a(Bundle var1) {
      this.a();
      this.c.a(var1);
   }

   @Override
   public final void a(ConnectionResult var1) {
      this.a();
      this.c.a(var1, this.a, this.b);
   }

   public final void a(zzu var1) {
      this.c = var1;
   }
}
