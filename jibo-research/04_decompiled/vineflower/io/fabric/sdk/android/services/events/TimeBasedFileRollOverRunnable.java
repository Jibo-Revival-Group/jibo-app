package io.fabric.sdk.android.services.events;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;

public class TimeBasedFileRollOverRunnable implements Runnable {
   private final Context a;
   private final FileRollOverManager b;

   public TimeBasedFileRollOverRunnable(Context var1, FileRollOverManager var2) {
      this.a = var1;
      this.b = var2;
   }

   @Override
   public void run() {
      try {
         CommonUtils.a(this.a, "Performing time based file roll over.");
         if (!this.b.c()) {
            this.b.d();
         }
      } catch (Exception var2) {
         CommonUtils.a(this.a, "Failed to roll over file", var2);
      }
   }
}
