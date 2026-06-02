package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzg;

public final class zzbej extends GoogleApi<Object> implements zzbee {
   private zzbej(Context var1) {
      super(var1, zzbdy.a, null, new zzg());
   }

   public static zzbee a(Context var0) {
      return new zzbej(var0);
   }

   @Override
   public final PendingResult<Status> a(zzbeh var1) {
      return this.c(new zzbem(var1, this.d()));
   }
}
