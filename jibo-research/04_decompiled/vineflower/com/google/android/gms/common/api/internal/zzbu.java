package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

final class zzbu implements zzcy, com.google.android.gms.common.internal.zzj {
   final zzbm a;
   private final Api.zze b;
   private final zzh<?> c;
   private com.google.android.gms.common.internal.zzan d;
   private Set<Scope> e;
   private boolean f;

   public zzbu(zzbm var1, Api.zze var2, zzh var3) {
      this.a = var1;
      this.d = null;
      this.e = null;
      this.f = false;
      this.b = var2;
      this.c = var3;
   }

   private final void a() {
      if (this.f && this.d != null) {
         this.b.a(this.d, this.e);
      }
   }

   @Override
   public final void a(ConnectionResult var1) {
      zzbm.a(this.a).post(new zzbv(this, var1));
   }

   @Override
   public final void a(com.google.android.gms.common.internal.zzan var1, Set<Scope> var2) {
      if (var1 != null && var2 != null) {
         this.d = var1;
         this.e = var2;
         this.a();
      } else {
         Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
         this.b(new ConnectionResult(4));
      }
   }

   @Override
   public final void b(ConnectionResult var1) {
      ((zzbo)zzbm.j(this.a).get(this.c)).b(var1);
   }
}
