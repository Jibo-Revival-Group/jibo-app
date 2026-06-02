package com.google.android.gms.iid;

import android.content.Intent;

final class zzc implements Runnable {
   private Intent a;
   private Intent b;
   private zzb c;

   zzc(zzb var1, Intent var2, Intent var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
      super();
   }

   @Override
   public final void run() {
      this.c.handleIntent(this.a);
      zzb.a(this.c, this.b);
   }
}
