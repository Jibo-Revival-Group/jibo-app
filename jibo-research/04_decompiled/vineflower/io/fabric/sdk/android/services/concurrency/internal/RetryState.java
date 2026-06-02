package io.fabric.sdk.android.services.concurrency.internal;

public class RetryState {
   private final int a;
   private final Backoff b;
   private final RetryPolicy c;

   public RetryState(int var1, Backoff var2, RetryPolicy var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public RetryState(Backoff var1, RetryPolicy var2) {
      this(0, var1, var2);
   }

   public long a() {
      return this.b.a(this.a);
   }

   public RetryState b() {
      return new RetryState(this.a + 1, this.b, this.c);
   }

   public RetryState c() {
      return new RetryState(this.b, this.c);
   }
}
