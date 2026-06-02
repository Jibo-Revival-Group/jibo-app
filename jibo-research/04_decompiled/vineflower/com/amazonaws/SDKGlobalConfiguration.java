package com.amazonaws;

import java.util.concurrent.atomic.AtomicInteger;

public class SDKGlobalConfiguration {
   private static final AtomicInteger globalTimeOffset = new AtomicInteger(0);

   public static int getGlobalTimeOffset() {
      return globalTimeOffset.get();
   }

   public static void setGlobalTimeOffset(int var0) {
      globalTimeOffset.set(var0);
   }
}
