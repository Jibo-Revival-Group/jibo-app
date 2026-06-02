package com.google.android.gms.maps.internal;

public final class zza {
   public static byte a(Boolean var0) {
      byte var1;
      if (var0 != null) {
         if (var0) {
            var1 = 1;
         } else {
            var1 = 0;
         }
      } else {
         var1 = -1;
      }

      return var1;
   }

   public static Boolean a(byte var0) {
      Boolean var1;
      switch (var0) {
         case 0:
            var1 = Boolean.FALSE;
            break;
         case 1:
            var1 = Boolean.TRUE;
            break;
         default:
            var1 = null;
      }

      return var1;
   }
}
