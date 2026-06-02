package com.google.firebase.perf.metrics;

import com.google.android.gms.internal.zzewy;
import com.google.android.gms.internal.zzewz;
import com.google.android.gms.internal.zzexa;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zze {
   private final Trace a;

   zze(Trace var1) {
      this.a = var1;
   }

   final zzewy a() {
      byte var2 = 0;
      zzewy var3 = new zzewy();
      var3.a = this.a.a();
      var3.b = this.a.c().b();
      var3.c = this.a.c().a(this.a.d());
      Map var7 = this.a.b();
      if (!var7.isEmpty()) {
         var3.d = new zzewz[var7.size()];
         Iterator var8 = var7.keySet().iterator();

         for (int var1 = 0; var8.hasNext(); var1++) {
            String var5 = (String)var8.next();
            zza var4 = (zza)var7.get(var5);
            zzewz var6 = new zzewz();
            var6.a = var5;
            var6.b = var4.a();
            var3.d[var1] = var6;
         }
      }

      List var11 = this.a.h();
      if (!var11.isEmpty()) {
         var3.e = new zzewy[var11.size()];
         Iterator var12 = var11.iterator();

         for (int var9 = 0; var12.hasNext(); var9++) {
            Trace var14 = (Trace)var12.next();
            var3.e[var9] = new zze(var14).a();
         }
      }

      Map var16 = this.a.getAttributes();
      if (!var16.isEmpty()) {
         var3.f = new zzexa[var16.size()];
         Iterator var15 = var16.keySet().iterator();

         for (int var10 = var2; var15.hasNext(); var10++) {
            String var13 = (String)var15.next();
            String var18 = (String)var16.get(var13);
            zzexa var17 = new zzexa();
            var17.a = var13;
            var17.b = var18;
            var3.f[var10] = var17;
         }
      }

      return var3;
   }
}
