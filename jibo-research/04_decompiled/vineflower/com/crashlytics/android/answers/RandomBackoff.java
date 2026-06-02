package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.internal.Backoff;
import java.util.Random;

class RandomBackoff implements Backoff {
   final Backoff a;
   final Random b;
   final double c;

   public RandomBackoff(Backoff var1, double var2) {
      this(var1, var2, new Random());
   }

   public RandomBackoff(Backoff var1, double var2, Random var4) {
      if (var2 < 0.0 || var2 > 1.0) {
         throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
      }

      if (var1 == null) {
         throw new NullPointerException("backoff must not be null");
      }

      if (var4 == null) {
         throw new NullPointerException("random must not be null");
      }

      this.a = var1;
      this.c = var2;
      this.b = var4;
   }

   double a() {
      double var1 = 1.0 - this.c;
      return var1 + (this.c + 1.0 - var1) * this.b.nextDouble();
   }

   @Override
   public long a(int var1) {
      return (long)(this.a() * this.a.a(var1));
   }
}
