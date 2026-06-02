package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.internal.RetryState;

class RetryManager {
   long a;
   private RetryState b;

   public RetryManager(RetryState var1) {
      if (var1 == null) {
         throw new NullPointerException("retryState must not be null");
      }

      this.b = var1;
   }

   public void a() {
      this.a = 0L;
      this.b = this.b.c();
   }

   public boolean a(long var1) {
      long var3 = this.b.a();
      boolean var5;
      if (var1 - this.a >= 1000000L * var3) {
         var5 = true;
      } else {
         var5 = false;
      }

      return var5;
   }

   public void b(long var1) {
      this.a = var1;
      this.b = this.b.b();
   }
}
