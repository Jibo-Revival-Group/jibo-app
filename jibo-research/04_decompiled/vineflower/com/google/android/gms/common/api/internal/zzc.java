package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public final class zzc<A extends zzm<? extends Result, Api.zzb>> extends zza {
   private A a;

   public zzc(int var1, A var2) {
      super(var1);
      this.a = (A)var2;
   }

   @Override
   public final void a(Status var1) {
      this.a.c(var1);
   }

   @Override
   public final void a(zzae var1, boolean var2) {
      var1.a(this.a, var2);
   }

   @Override
   public final void a(zzbo<?> var1) throws DeadObjectException {
      this.a.b(var1.b());
   }
}
