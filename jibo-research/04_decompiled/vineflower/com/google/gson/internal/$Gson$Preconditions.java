package com.google.gson.internal;

public final class $Gson$Preconditions {
   public static <T> T a(T var0) {
      if (var0 == null) {
         throw new NullPointerException();
      } else {
         return (T)var0;
      }
   }

   public static void a(boolean var0) {
      if (!var0) {
         throw new IllegalArgumentException();
      }
   }
}
