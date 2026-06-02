package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.Iterator;
import java.util.Map;

final class zzar extends zzay {
   final zzao a;
   private final Map<Api.zze, zzaq> b;

   public zzar(zzao var1, Map var2) {
      super(var1, null);
      this.a = var1;
      this.b = var2;
   }

   @Override
   public final void a() {
      boolean var5 = true;
      int var4 = 0;
      Iterator var6 = this.b.keySet().iterator();
      boolean var2 = true;
      boolean var1 = false;

      boolean var3;
      while (true) {
         if (!var6.hasNext()) {
            var3 = var1;
            var1 = false;
            break;
         }

         Api.zze var7 = (Api.zze)var6.next();
         if (var7.j()) {
            if (!zzaq.a(this.b.get(var7))) {
               var1 = true;
               var3 = var5;
               break;
            }

            var1 = var2;
            var2 = true;
         } else {
            var3 = false;
            var2 = var1;
            var1 = var3;
         }

         var3 = var2;
         var2 = var1;
         var1 = var3;
      }

      if (var3) {
         var4 = zzao.b(this.a).a(zzao.a(this.a));
      }

      if (var4 == 0 || !var1 && !var2) {
         if (zzao.e(this.a)) {
            zzao.f(this.a).m();
         }

         for (Api.zze var8 : this.b.keySet()) {
            com.google.android.gms.common.internal.zzj var16 = this.b.get(var8);
            if (var8.j() && var4 != 0) {
               zzao.d(this.a).a(new zzat(this, this.a, var16));
            } else {
               var8.a(var16);
            }
         }
      } else {
         ConnectionResult var14 = new ConnectionResult(var4, null);
         zzao.d(this.a).a(new zzas(this, this.a, var14));
      }
   }
}
