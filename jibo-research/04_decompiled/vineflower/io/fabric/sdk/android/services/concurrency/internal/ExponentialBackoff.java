package io.fabric.sdk.android.services.concurrency.internal;

public class ExponentialBackoff implements Backoff {
   private final long a;
   private final int b;

   public ExponentialBackoff(long var1, int var3) {
      this.a = var1;
      this.b = var3;
   }

   @Override
   public long a(int var1) {
      return (long)(this.a * Math.pow(this.b, var1));
   }
}
