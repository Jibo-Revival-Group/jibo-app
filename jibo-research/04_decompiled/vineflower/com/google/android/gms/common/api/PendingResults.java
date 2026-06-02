package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zzda;
import com.google.android.gms.common.internal.zzbq;

public final class PendingResults {
   public static <R extends Result> PendingResult<R> a(R var0, GoogleApiClient var1) {
      zzbq.a(var0, "Result must not be null");
      boolean var2;
      if (!var0.a().c()) {
         var2 = true;
      } else {
         var2 = false;
      }

      zzbq.b(var2, "Status code must not be SUCCESS");
      PendingResults.zzb var3 = new PendingResults.zzb<>(var1, var0);
      var3.a(var0);
      return var3;
   }

   public static PendingResult<Status> a(Status var0) {
      zzbq.a(var0, "Result must not be null");
      zzda var1 = new zzda(Looper.getMainLooper());
      var1.a(var0);
      return var1;
   }

   static final class zzb<R extends Result> extends BasePendingResult<R> {
      private final R b;

      public zzb(GoogleApiClient var1, R var2) {
         super(var1);
         this.b = (R)var2;
      }

      @Override
      protected final R a(Status var1) {
         return this.b;
      }
   }
}
