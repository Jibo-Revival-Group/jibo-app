package com.salesforce.android.service.common.utilities.spatial;

public class Orientation {
   public static Orientation a = a(0);
   public static Orientation b = a(90);
   public static Orientation c = a(180);
   public static Orientation d = a(270);
   public static Orientation e = a;
   public static Orientation f = b;
   private final int g;

   private Orientation(int var1) {
      this.g = var1;
   }

   public static Orientation a(int var0) {
      return new Orientation(var0);
   }

   public boolean a() {
      boolean var1;
      if (this.g != 0 && this.g != 180) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   public boolean b() {
      boolean var1;
      if (this.g != 90 && this.g != 270) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1;
   }

   @Override
   public boolean equals(Object var1) {
      boolean var2 = true;
      if (this != var1) {
         if (var1 instanceof Orientation) {
            var1 = var1;
            if (this.g != var1.g) {
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
      return Integer.valueOf(this.g).hashCode();
   }

   @Override
   public String toString() {
      return "[" + this.g + "]";
   }
}
