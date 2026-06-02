package org.joda.time.chrono;

import org.joda.time.DateTimeZone;
import org.joda.time.Instant;

class GJCacheKey {
   private final DateTimeZone a;
   private final Instant b;
   private final int c;

   GJCacheKey(DateTimeZone var1, Instant var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 == null) {
            var2 = false;
         } else if (!(var1 instanceof GJCacheKey)) {
            var2 = false;
         } else {
            var1 = var1;
            if (this.b == null) {
               if (var1.b != null) {
                  var2 = false;
                  return var2;
               }
            } else if (!this.b.equals(var1.b)) {
               var2 = false;
               return var2;
            }

            if (this.c != var1.c) {
               var2 = false;
            } else if (this.a == null) {
               if (var1.a != null) {
                  var2 = false;
               }
            } else if (!this.a.equals(var1.a)) {
               var2 = false;
            }
         }
      }

      return var2;
   }

   @Override
   public int hashCode() {
      int var2 = 0;
      int var1;
      if (this.b == null) {
         var1 = 0;
      } else {
         var1 = this.b.hashCode();
      }

      int var3 = this.c;
      if (this.a != null) {
         var2 = this.a.hashCode();
      }

      return ((var1 + 31) * 31 + var3) * 31 + var2;
   }
}
