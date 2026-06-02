package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;

public final class zzz<O extends Api.ApiOptions> extends GoogleApi<O> {
   private final Api.zze b;
   private final zzt c;
   private final com.google.android.gms.common.internal.zzr d;
   private final Api.zza<? extends zzcxd, zzcxe> e;

   public zzz(
      Context var1, Api<O> var2, Looper var3, Api.zze var4, zzt var5, com.google.android.gms.common.internal.zzr var6, Api.zza<? extends zzcxd, zzcxe> var7
   ) {
      super(var1, var2, var3);
      this.b = var4;
      this.c = var5;
      this.d = var6;
      this.e = var7;
      this.a.a(this);
   }

   @Override
   public final Api.zze a(Looper var1, zzbo<O> var2) {
      this.c.a(var2);
      return this.b;
   }

   @Override
   public final zzcv a(Context var1, Handler var2) {
      return new zzcv(var1, var2, this.d, this.e);
   }

   public final Api.zze g() {
      return this.b;
   }
}
