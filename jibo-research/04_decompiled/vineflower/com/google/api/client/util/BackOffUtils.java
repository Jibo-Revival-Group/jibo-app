package com.google.api.client.util;

import java.io.IOException;

@Beta
public final class BackOffUtils {
   private BackOffUtils() {
   }

   public static boolean next(Sleeper var0, BackOff var1) throws InterruptedException, IOException {
      long var3 = var1.nextBackOffMillis();
      boolean var2;
      if (var3 == -1L) {
         var2 = false;
      } else {
         var0.sleep(var3);
         var2 = true;
      }

      return var2;
   }
}
