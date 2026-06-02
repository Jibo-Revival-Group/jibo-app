package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.internal.DefaultRetryPolicy;
import io.fabric.sdk.android.services.concurrency.internal.ExponentialBackoff;
import io.fabric.sdk.android.services.concurrency.internal.RetryState;
import io.fabric.sdk.android.services.events.FilesSender;
import java.io.File;
import java.util.List;

class AnswersRetryFilesSender implements FilesSender {
   private final SessionAnalyticsFilesSender a;
   private final RetryManager b;

   AnswersRetryFilesSender(SessionAnalyticsFilesSender var1, RetryManager var2) {
      this.a = var1;
      this.b = var2;
   }

   public static AnswersRetryFilesSender a(SessionAnalyticsFilesSender var0) {
      return new AnswersRetryFilesSender(
         var0, new RetryManager(new RetryState(new RandomBackoff(new ExponentialBackoff(1000L, 8), 0.1), new DefaultRetryPolicy(5)))
      );
   }

   @Override
   public boolean a(List<File> var1) {
      boolean var5 = false;
      long var2 = System.nanoTime();
      boolean var4 = var5;
      if (this.b.a(var2)) {
         if (this.a.a(var1)) {
            this.b.a();
            var4 = true;
         } else {
            this.b.b(var2);
            var4 = var5;
         }
      }

      return var4;
   }
}
