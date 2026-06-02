package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.util.zzd;

final class zzclk {
   private final zzd a;
   private long b;

   public zzclk(zzd var1) {
      zzbq.a(var1);
      this.a = var1;
   }

   public final void a() {
      this.b = this.a.b();
   }

   public final boolean a(long var1) {
      boolean var3 = true;
      if (this.b != 0L && this.a.b() - this.b < 3600000L) {
         var3 = false;
      }

      return var3;
   }

   public final void b() {
      this.b = 0L;
   }
}
