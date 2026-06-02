package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

public final class zzm implements zzj {
   private zzd a;

   public zzm(zzd var1) {
      this.a = var1;
      super();
   }

   @Override
   public final void a(ConnectionResult var1) {
      if (var1.b()) {
         this.a.a(null, this.a.o());
      } else if (zzd.g(this.a) != null) {
         zzd.g(this.a).a(var1);
      }
   }
}
