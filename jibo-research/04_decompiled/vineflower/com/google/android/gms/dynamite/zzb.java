package com.google.android.gms.dynamite;

import android.content.Context;

final class zzb implements DynamiteModule.zzd {
   @Override
   public final zzj a(Context var1, String var2, zzi var3) throws DynamiteModule.zzc {
      zzj var4 = new zzj();
      var4.b = var3.a(var1, var2, true);
      if (var4.b != 0) {
         var4.c = 1;
      } else {
         var4.a = var3.a(var1, var2);
         if (var4.a != 0) {
            var4.c = -1;
         }
      }

      return var4;
   }
}
