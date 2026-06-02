package com.google.android.gms.internal;

import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.zzbq;

public final class zzcic {
   private final String a;
   private final String b;
   private boolean c;
   private String d;
   private zzchx e;

   public zzcic(zzchx var1, String var2, String var3) {
      this.e = var1;
      super();
      zzbq.a(var2);
      this.a = var2;
      this.b = null;
   }

   public final String a() {
      if (!this.c) {
         this.c = true;
         this.d = zzchx.a(this.e).getString(this.a, null);
      }

      return this.d;
   }

   public final void a(String var1) {
      if (!zzclq.a(var1, this.d)) {
         Editor var2 = zzchx.a(this.e).edit();
         var2.putString(this.a, var1);
         var2.apply();
         this.d = var1;
      }
   }
}
