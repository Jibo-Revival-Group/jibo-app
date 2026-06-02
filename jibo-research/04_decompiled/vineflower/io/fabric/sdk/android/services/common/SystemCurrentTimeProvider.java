package io.fabric.sdk.android.services.common;

public class SystemCurrentTimeProvider implements CurrentTimeProvider {
   @Override
   public long a() {
      return System.currentTimeMillis();
   }
}
