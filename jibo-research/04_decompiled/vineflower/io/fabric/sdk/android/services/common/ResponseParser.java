package io.fabric.sdk.android.services.common;

public class ResponseParser {
   public static int a(int var0) {
      byte var1 = 0;
      if (var0 < 200 || var0 > 299) {
         if (var0 >= 300 && var0 <= 399) {
            var1 = 1;
         } else if (var0 < 400 || var0 > 499) {
            if (var0 >= 500) {
               var1 = 1;
            } else {
               var1 = 1;
            }
         }
      }

      return var1;
   }
}
