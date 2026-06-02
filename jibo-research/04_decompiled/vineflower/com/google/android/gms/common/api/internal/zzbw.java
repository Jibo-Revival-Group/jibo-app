package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;

public final class zzbw<O extends Api.ApiOptions> extends zzak {
   private final GoogleApi<O> a;

   public zzbw(GoogleApi<O> var1) {
      super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
      this.a = var1;
   }

   @Override
   public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T a(T var1) {
      return this.a.a((T)var1);
   }

   @Override
   public final void a(zzdg var1) {
   }

   @Override
   public final Context b() {
      return this.a.f();
   }

   @Override
   public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T b(T var1) {
      return this.a.b((T)var1);
   }

   @Override
   public final void b(zzdg var1) {
   }

   @Override
   public final Looper c() {
      return this.a.e();
   }
}
