package com.google.android.gms.common.api.internal;

final class zzbn implements zzl {
   private zzbm a;

   zzbn(zzbm var1) {
      this.a = var1;
      super();
   }

   @Override
   public final void a(boolean var1) {
      zzbm.a(this.a).sendMessage(zzbm.a(this.a).obtainMessage(1, var1));
   }
}
