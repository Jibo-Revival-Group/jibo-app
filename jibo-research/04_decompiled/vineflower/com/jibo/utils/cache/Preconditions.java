package com.jibo.utils.cache;

public final class Preconditions {
   public static <T> T a(T var0) {
      return a((T)var0, "Argument must not be null");
   }

   public static <T> T a(T var0, String var1) {
      if (var0 == null) {
         throw new NullPointerException(var1);
      } else {
         return (T)var0;
      }
   }
}
