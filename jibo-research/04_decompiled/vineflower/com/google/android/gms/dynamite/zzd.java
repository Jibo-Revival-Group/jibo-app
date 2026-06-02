package com.google.android.gms.dynamite;

import android.content.Context;

final class zzd implements DynamiteModule.zzd {
   @Override
   public final zzj a(Context var1, String var2, zzi var3) throws DynamiteModule.zzc {
      zzj var4 = new zzj();
      var4.a = var3.a(var1, var2);
      var4.b = var3.a(var1, var2, true);
      if (var4.a == 0 && var4.b == 0) {
         var4.c = 0;
      } else if (var4.a >= var4.b) {
         var4.c = -1;
      } else {
         var4.c = 1;
      }

      return var4;
   }
}
