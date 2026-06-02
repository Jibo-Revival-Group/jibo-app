package com.google.zxing;

public final class FormatException extends ReaderException {
   private static final FormatException b = new FormatException();

   private FormatException() {
   }

   public static FormatException a() {
      FormatException var0;
      if (a) {
         var0 = new FormatException();
      } else {
         var0 = b;
      }

      return var0;
   }
}
