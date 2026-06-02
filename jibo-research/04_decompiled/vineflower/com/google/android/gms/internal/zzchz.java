package com.google.android.gms.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.zzbq;

public final class zzchz {
   private final String a;
   private final boolean b;
   private boolean c;
   private boolean d;
   private zzchx e;

   public zzchz(zzchx var1, String var2, boolean var3) {
      this.e = var1;
      super();
      zzbq.a(var2);
      this.a = var2;
      this.b = true;
   }

   public final void a(boolean var1) {
      Editor var2 = zzchx.a(this.e).edit();
      var2.putBoolean(this.a, var1);
      var2.apply();
      this.d = var1;
   }

   public final boolean a() {
      if (!this.c) {
         this.c = true;
         this.d = zzchx.a(this.e).getBoolean(this.a, this.b);
      }

      return this.d;
   }
}
