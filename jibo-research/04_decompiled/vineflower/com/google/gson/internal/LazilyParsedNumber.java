package com.google.gson.internal;

import java.io.ObjectStreamException;
import java.math.BigDecimal;

public final class LazilyParsedNumber extends Number {
   private final String a;

   public LazilyParsedNumber(String var1) {
      this.a = var1;
   }

   private Object writeReplace() throws ObjectStreamException {
      return new BigDecimal(this.a);
   }

   @Override
   public double doubleValue() {
      return Double.parseDouble(this.a);
   }

   @Override
   public boolean equals(Object var1) {
      boolean var3 = false;
      boolean var2;
      if (this == var1) {
         var2 = true;
      } else {
         var2 = var3;
         if (var1 instanceof LazilyParsedNumber) {
            var1 = var1;
            if (this.a != var1.a) {
               var2 = var3;
               if (!this.a.equals(var1.a)) {
                  return var2;
               }
            }

            var2 = true;
         }
      }

      return var2;
   }

   @Override
   public float floatValue() {
      return Float.parseFloat(this.a);
   }

   @Override
   public int hashCode() {
      return this.a.hashCode();
   }

   @Override
   public int intValue() {
      int var1;
      try {
         var1 = Integer.parseInt(this.a);
      } catch (NumberFormatException var6) {
         long var2;
         try {
            var2 = Long.parseLong(this.a);
         } catch (NumberFormatException var5) {
            return new BigDecimal(this.a).intValue();
         }

         var1 = (int)var2;
      }

      return var1;
   }

   @Override
   public long longValue() {
      long var1;
      try {
         var1 = Long.parseLong(this.a);
      } catch (NumberFormatException var4) {
         var1 = new BigDecimal(this.a).longValue();
      }

      return var1;
   }

   @Override
   public String toString() {
      return this.a;
   }
}
