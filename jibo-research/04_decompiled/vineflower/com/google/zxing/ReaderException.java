package com.google.zxing;

public abstract class ReaderException extends Exception {
   protected static final boolean a;

   static {
      boolean var0;
      if (System.getProperty("surefire.test.class.path") != null) {
         var0 = true;
      } else {
         var0 = false;
      }

      a = var0;
   }

   ReaderException() {
   }

   @Override
   public final Throwable fillInStackTrace() {
      return null;
   }
}
