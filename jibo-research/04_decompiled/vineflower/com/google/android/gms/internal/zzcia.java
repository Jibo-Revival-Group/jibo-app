package com.google.android.gms.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.zzbq;

public final class zzcia {
   private final String a;
   private final long b;
   private boolean c;
   private long d;
   private zzchx e;

   public zzcia(zzchx var1, String var2, long var3) {
      this.e = var1;
      super();
      zzbq.a(var2);
      this.a = var2;
      this.b = var3;
   }

   public final long a() {
      if (!this.c) {
         this.c = true;
         this.d = zzchx.a(this.e).getLong(this.a, this.b);
      }

      return this.d;
   }

   public final void a(long var1) {
      Editor var3 = zzchx.a(this.e).edit();
      var3.putLong(this.a, var1);
      var3.apply();
      this.d = var1;
   }
}
