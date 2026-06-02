package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.zzcz;
import com.google.android.gms.common.internal.zzbq;

public final class zzd {
   private zzcz a;
   private Looper b;

   public final GoogleApi.zza a() {
      if (this.a == null) {
         this.a = new com.google.android.gms.common.api.internal.zzg();
      }

      if (this.b == null) {
         this.b = Looper.getMainLooper();
      }

      return new GoogleApi.zza(this.a, null, this.b, null);
   }

   public final zzd a(zzcz var1) {
      zzbq.a(var1, "StatusExceptionMapper must not be null.");
      this.a = var1;
      return this;
   }
}
