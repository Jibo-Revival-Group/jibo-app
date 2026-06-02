package com.google.maps.internal;

public class StringJoin {
   private StringJoin() {
   }

   public static String join(char var0, StringJoin.UrlValue... var1) {
      int var3 = 0;
      String[] var5 = new String[var1.length];
      int var4 = var1.length;

      for (int var2 = 0; var3 < var4; var2++) {
         var5[var2] = var1[var3].toString();
         var3++;
      }

      return join(var0, var5);
   }

   public static String join(char var0, String... var1) {
      StringBuilder var3 = new StringBuilder();

      for (int var2 = 0; var2 < var1.length; var2++) {
         if (var2 != 0) {
            var3.append(var0);
         }

         var3.append(var1[var2]);
      }

      return var3.toString();
   }

   public interface UrlValue {
      String toUrlValue();
   }
}
