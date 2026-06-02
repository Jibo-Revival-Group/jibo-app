package com.google.android.gms.auth.api.signin.internal;

public final class zzp {
   private static int a = 31;
   private int b = 1;

   public final int a() {
      return this.b;
   }

   public final zzp a(Object var1) {
      int var4 = a;
      int var3 = this.b;
      int var2;
      if (var1 == null) {
         var2 = 0;
      } else {
         var2 = var1.hashCode();
      }

      this.b = var2 + var3 * var4;
      return this;
   }

   public final zzp a(boolean var1) {
      int var4 = a;
      int var3 = this.b;
      byte var2;
      if (var1) {
         var2 = 1;
      } else {
         var2 = 0;
      }

      this.b = var2 + var3 * var4;
      return this;
   }
}
