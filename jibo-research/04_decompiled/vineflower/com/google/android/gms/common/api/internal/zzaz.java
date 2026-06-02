package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import java.util.Collections;
import java.util.Iterator;

public final class zzaz implements zzbh {
   private final zzbi a;

   public zzaz(zzbi var1) {
      this.a = var1;
   }

   @Override
   public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T a(T var1) {
      this.a.d.a.add(var1);
      return (T)var1;
   }

   @Override
   public final void a() {
      Iterator var1 = this.a.a.values().iterator();

      while (var1.hasNext()) {
         ((Api.zze)var1.next()).f();
      }

      this.a.d.c = Collections.emptySet();
   }

   @Override
   public final void a(int var1) {
   }

   @Override
   public final void a(Bundle var1) {
   }

   @Override
   public final void a(ConnectionResult var1, Api<?> var2, boolean var3) {
   }

   @Override
   public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T b(T var1) {
      throw new IllegalStateException("GoogleApiClient is not connected yet.");
   }

   @Override
   public final boolean b() {
      return true;
   }

   @Override
   public final void c() {
      this.a.e();
   }
}
