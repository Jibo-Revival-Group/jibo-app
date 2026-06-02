package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.zzbhf;

public final class zzc {
   public static boolean a(Context var0, String var1) {
      boolean var3 = false;
      "com.google.android.gms".equals(var1);

      int var2;
      try {
         var2 = zzbhf.a(var0).a(var1, 0).flags;
      } catch (NameNotFoundException var4) {
         return var3;
      }

      if ((var2 & 2097152) != 0) {
         var3 = true;
      }

      return var3;
   }
}
