package io.fabric.sdk.android.services.common;

class AdvertisingInfo {
   public final String a;
   public final boolean b;

   AdvertisingInfo(String var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 != null && this.getClass() == var1.getClass()) {
            var1 = var1;
            if (this.b != var1.b) {
               var2 = false;
            } else if (this.a != null ? !this.a.equals(var1.a) : var1.a != null) {
               var2 = false;
            }
         } else {
            var2 = false;
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      byte var2 = 0;
      int var1;
      if (this.a != null) {
         var1 = this.a.hashCode();
      } else {
         var1 = 0;
      }

      if (this.b) {
         var2 = 1;
      }

      return var1 * 31 + var2;
   }
}
