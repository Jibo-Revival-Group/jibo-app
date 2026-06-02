package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

final class zzas extends zzbj {
   private ConnectionResult a;
   private zzar b;

   zzas(zzar var1, zzbh var2, ConnectionResult var3) {
      this.b = var1;
      this.a = var3;
      super(var2);
   }

   @Override
   public final void a() {
      zzao.a(this.b.a, this.a);
   }
}
