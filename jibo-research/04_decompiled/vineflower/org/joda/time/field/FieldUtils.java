package org.joda.time.field;

import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.IllegalFieldValueException;

public class FieldUtils {
   public static int a(int var0, int var1) {
      int var2 = var0 + var1;
      if ((var0 ^ var2) < 0 && (var0 ^ var1) >= 0) {
         throw new ArithmeticException("The calculation caused an overflow: " + var0 + " + " + var1);
      } else {
         return var2;
      }
   }

   public static int a(long var0) {
      if (-2147483648L <= var0 && var0 <= 2147483647L) {
         return (int)var0;
      } else {
         throw new ArithmeticException("Value cannot fit in an int: " + var0);
      }
   }

   public static long a(long var0, int var2) {
      long var3 = var0;
      switch (var2) {
         case -1:
            if (var0 == Long.MIN_VALUE) {
               throw new ArithmeticException("Multiplication overflows a long: " + var0 + " * " + var2);
            }

            var3 = -var0;
            break;
         case 0:
            var3 = 0L;
         case 1:
            break;
         default:
            var3 = var2 * var0;
            if (var3 / var2 != var0) {
               throw new ArithmeticException("Multiplication overflows a long: " + var0 + " * " + var2);
            }
      }

      return var3;
   }

   public static long a(long var0, long var2) {
      long var4 = var0 + var2;
      if ((var0 ^ var4) < 0L && (var0 ^ var2) >= 0L) {
         throw new ArithmeticException("The calculation caused an overflow: " + var0 + " + " + var2);
      } else {
         return var4;
      }
   }

   public static void a(DateTimeField var0, int var1, int var2, int var3) {
      if (var1 < var2 || var1 > var3) {
         throw new IllegalFieldValueException(var0.a(), var1, var2, var3);
      }
   }

   public static void a(DateTimeFieldType var0, int var1, int var2, int var3) {
      if (var1 < var2 || var1 > var3) {
         throw new IllegalFieldValueException(var0, var1, var2, var3);
      }
   }

   public static boolean a(Object var0, Object var1) {
      boolean var2;
      if (var0 == var1) {
         var2 = true;
      } else if (var0 != null && var1 != null) {
         var2 = var0.equals(var1);
      } else {
         var2 = false;
      }

      return var2;
   }

   public static long b(long var0, long var2) {
      if (var2 != 1L) {
         if (var0 == 1L) {
            var0 = var2;
         } else if (var0 != 0L && var2 != 0L) {
            long var4 = var0 * var2;
            if (var4 / var2 != var0 || var0 == Long.MIN_VALUE && var2 == -1L || var2 == Long.MIN_VALUE && var0 == -1L) {
               throw new ArithmeticException("Multiplication overflows a long: " + var0 + " * " + var2);
            }

            var0 = var4;
         } else {
            var0 = 0L;
         }
      }

      return var0;
   }
}
