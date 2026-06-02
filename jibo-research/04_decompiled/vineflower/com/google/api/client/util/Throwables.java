package com.google.api.client.util;

public final class Throwables {
   private Throwables() {
   }

   public static RuntimeException propagate(Throwable var0) {
      return com.google.api.client.repackaged.com.google.common.base.Throwables.propagate(var0);
   }

   public static void propagateIfPossible(Throwable var0) {
      if (var0 != null) {
         if (var0 instanceof RuntimeException) {
            throw (RuntimeException)var0;
         }

         if (var0 instanceof Error) {
            throw (Error)var0;
         }
      }
   }

   public static <X extends Throwable> void propagateIfPossible(Throwable var0, Class<X> var1) throws X {
      com.google.api.client.repackaged.com.google.common.base.Throwables.propagateIfPossible(var0, var1);
   }
}
