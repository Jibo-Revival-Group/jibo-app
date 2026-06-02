package com.google.api.client.repackaged.com.google.common.base;

import com.google.api.client.repackaged.com.google.common.annotations.Beta;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Throwables {
   private Throwables() {
   }

   @Beta
   public static List<Throwable> getCausalChain(Throwable var0) {
      Preconditions.checkNotNull(var0);
      ArrayList var1 = new ArrayList(4);

      while (var0 != null) {
         var1.add(var0);
         var0 = var0.getCause();
      }

      return Collections.unmodifiableList(var1);
   }

   public static Throwable getRootCause(Throwable var0) {
      while (true) {
         Throwable var1 = var0.getCause();
         if (var1 == null) {
            return var0;
         }

         var0 = var1;
      }
   }

   public static String getStackTraceAsString(Throwable var0) {
      StringWriter var1 = new StringWriter();
      var0.printStackTrace(new PrintWriter(var1));
      return var1.toString();
   }

   public static RuntimeException propagate(Throwable var0) {
      propagateIfPossible(Preconditions.checkNotNull(var0));
      throw new RuntimeException(var0);
   }

   public static <X extends Throwable> void propagateIfInstanceOf(Throwable var0, Class<X> var1) throws X {
      if (var0 != null && var1.isInstance(var0)) {
         throw (Throwable)var1.cast(var0);
      }
   }

   public static void propagateIfPossible(Throwable var0) {
      propagateIfInstanceOf(var0, Error.class);
      propagateIfInstanceOf(var0, RuntimeException.class);
   }

   public static <X extends Throwable> void propagateIfPossible(Throwable var0, Class<X> var1) throws X {
      propagateIfInstanceOf(var0, var1);
      propagateIfPossible(var0);
   }

   public static <X1 extends Throwable, X2 extends Throwable> void propagateIfPossible(Throwable var0, Class<X1> var1, Class<X2> var2) throws X1, X2 {
      Preconditions.checkNotNull(var2);
      propagateIfInstanceOf(var0, var1);
      propagateIfPossible(var0, var2);
   }
}
