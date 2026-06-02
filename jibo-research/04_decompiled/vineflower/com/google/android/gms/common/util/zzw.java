package com.google.android.gms.common.util;

import android.os.Looper;

public final class zzw {
   public static boolean a() {
      boolean var0;
      if (Looper.getMainLooper() == Looper.myLooper()) {
         var0 = true;
      } else {
         var0 = false;
      }

      return var0;
   }
}
