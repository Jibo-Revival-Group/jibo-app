package com.google.android.gms.internal;

import java.util.Arrays;

final class zzfju {
   final int a;
   final byte[] b;

   zzfju(int var1, byte[] var2) {
      this.a = var1;
      this.b = var2;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (var1 != this) {
         if (!(var1 instanceof zzfju)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.a != var1.a || !Arrays.equals(this.b, var1.b)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return (this.a + 527) * 31 + Arrays.hashCode(this.b);
   }
}
