package org.slf4j.helpers;

public final class Util {
   private static boolean a = false;

   public static String a(String var0) {
      if (var0 == null) {
         throw new IllegalArgumentException("null input");
      }

      Object var1 = null;

      try {
         var0 = System.getProperty(var0);
      } catch (SecurityException var2) {
         var0 = (String)var1;
      }

      return var0;
   }

   public static final void a(String var0, Throwable var1) {
      System.err.println(var0);
      System.err.println("Reported exception:");
      var1.printStackTrace();
   }

   public static boolean b(String var0) {
      var0 = a(var0);
      boolean var1;
      if (var0 == null) {
         var1 = false;
      } else {
         var1 = var0.equalsIgnoreCase("true");
      }

      return var1;
   }

   public static final void c(String var0) {
      System.err.println("SLF4J: " + var0);
   }
}
