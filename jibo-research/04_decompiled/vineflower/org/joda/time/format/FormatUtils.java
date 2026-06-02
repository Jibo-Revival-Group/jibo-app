package org.joda.time.format;

import java.io.IOException;

public class FormatUtils {
   private static final double a = Math.log(10.0);

   static int a(CharSequence var0, int var1) {
      int var2 = var0.charAt(var1) - '0';
      return (var2 << 1) + (var2 << 3) + var0.charAt(var1 + 1) - 48;
   }

   static String a(String var0, int var1) {
      int var2 = var1 + 32;
      String var3;
      if (var0.length() <= var2 + 3) {
         var3 = var0;
      } else {
         var3 = var0.substring(0, var2).concat("...");
      }

      if (var1 <= 0) {
         var0 = "Invalid format: \"" + var3 + '"';
      } else if (var1 >= var0.length()) {
         var0 = "Invalid format: \"" + var3 + "\" is too short";
      } else {
         var0 = "Invalid format: \"" + var3 + "\" is malformed at \"" + var3.substring(var1) + '"';
      }

      return var0;
   }

   public static void a(Appendable var0, int var1) throws IOException {
      int var2 = var1;
      if (var1 < 0) {
         var0.append('-');
         if (var1 == Integer.MIN_VALUE) {
            var0.append("2147483648");
            return;
         }

         var2 = -var1;
      }

      if (var2 < 10) {
         var0.append((char)(var2 + 48));
      } else if (var2 < 100) {
         var1 = (var2 + 1) * 13421772 >> 27;
         var0.append((char)(var1 + 48));
         var0.append((char)(var2 - (var1 << 3) - (var1 << 1) + 48));
      } else {
         var0.append(Integer.toString(var2));
      }
   }

   public static void a(Appendable var0, int var1, int var2) throws IOException {
      int var3 = var1;
      if (var1 < 0) {
         var0.append('-');
         var3 = var2;
         if (var1 == Integer.MIN_VALUE) {
            while (var3 > 10) {
               var0.append('0');
               var3--;
            }

            var0.append("2147483648");
            return;
         }

         var3 = -var1;
      }

      if (var3 >= 10) {
         if (var3 >= 100) {
            if (var3 < 1000) {
               var1 = 3;
            } else if (var3 < 10000) {
               var1 = 4;
            } else {
               var1 = (int)(Math.log(var3) / a) + 1;
            }

            while (var2 > var1) {
               var0.append('0');
               var2--;
            }

            var0.append(Integer.toString(var3));
         } else {
            while (var2 > 2) {
               var0.append('0');
               var2--;
            }

            var1 = (var3 + 1) * 13421772 >> 27;
            var0.append((char)(var1 + 48));
            var0.append((char)(var3 - (var1 << 3) - (var1 << 1) + 48));
         }
      } else {
         while (var2 > 1) {
            var0.append('0');
            var2--;
         }

         var0.append((char)(var3 + 48));
      }
   }

   public static void a(StringBuffer var0, int var1, int var2) {
      try {
         a((Appendable)var0, var1, var2);
      } catch (IOException var3) {
      }
   }
}
