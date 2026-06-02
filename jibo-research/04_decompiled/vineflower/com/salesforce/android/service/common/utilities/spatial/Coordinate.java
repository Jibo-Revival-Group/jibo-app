package com.salesforce.android.service.common.utilities.spatial;

import java.io.Serializable;

public class Coordinate implements Serializable {
   private final int a;
   private final int b;

   private Coordinate(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public static Coordinate a(int var0, int var1) {
      return new Coordinate(var0, var1);
   }

   public int a() {
      return this.a;
   }

   public int b() {
      return this.b;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 instanceof Coordinate) {
            var1 = var1;
            if (this.a != var1.a || this.b != var1.b) {
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
      return this.a * 31 + this.b;
   }

   @Override
   public String toString() {
      return "[" + this.a + "," + this.b + "]";
   }
}
