package com.google.android.gms.gcm;

public final class zzi {
   public static final zzi a = new zzi(0, 30, 3600);
   private static zzi b = new zzi(1, 30, 3600);
   private final int c;
   private final int d;
   private final int e;

   private zzi(int var1, int var2, int var3) {
      this.c = var1;
      this.d = 30;
      this.e = 3600;
   }

   @Override
   public final boolean equals(Object var1) {
      boolean var2 = true;
      if (var1 != this) {
         if (!(var1 instanceof zzi)) {
            var2 = false;
         } else {
            var1 = var1;
            if (var1.c != this.c || var1.d != this.d || var1.e != this.e) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public final int hashCode() {
      return ((this.c + 1 ^ 1000003) * 1000003 ^ this.d) * 1000003 ^ this.e;
   }

   @Override
   public final String toString() {
      int var2 = this.c;
      int var3 = this.d;
      int var1 = this.e;
      return new StringBuilder(74).append("policy=").append(var2).append(" initial_backoff=").append(var3).append(" maximum_backoff=").append(var1).toString();
   }
}
