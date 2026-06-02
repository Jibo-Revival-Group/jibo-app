package org.joda.time;

import org.joda.time.format.DateTimeFormat;

public class IllegalInstantException extends IllegalArgumentException {
   public IllegalInstantException(long var1, String var3) {
      super(a(var1, var3));
   }

   public IllegalInstantException(String var1) {
      super(var1);
   }

   private static String a(long var0, String var2) {
      String var3 = DateTimeFormat.a("yyyy-MM-dd'T'HH:mm:ss.SSS").a(new Instant(var0));
      if (var2 != null) {
         var2 = " (" + var2 + ")";
      } else {
         var2 = "";
      }

      return "Illegal instant due to time zone offset transition (daylight savings time 'gap'): " + var3 + var2;
   }
}
