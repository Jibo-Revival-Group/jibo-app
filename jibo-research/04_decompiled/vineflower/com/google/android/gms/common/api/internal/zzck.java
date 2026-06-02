package com.google.android.gms.common.api.internal;

public final class zzck<L> {
   private final L a;
   private final String b;

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (!(var1 instanceof zzck)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.a != var1.a || !this.b.equals(var1.b)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return System.identityHashCode(this.a) * 31 + this.b.hashCode();
   }
}
