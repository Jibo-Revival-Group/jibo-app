package com.google.android.gms.common.api.internal;

final class zzdk implements zzdm {
   private zzdj a;

   zzdk(zzdj var1) {
      this.a = var1;
      super();
   }

   @Override
   public final void a(BasePendingResult<?> var1) {
      this.a.b.remove(var1);
   }
}
