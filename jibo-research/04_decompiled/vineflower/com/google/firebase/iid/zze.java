package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

final class zze implements Runnable {
   private Intent a;
   private zzd b;

   zze(zzd var1, Intent var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      String var1 = this.a.getAction();
      Log.w(
         "EnhancedIntentService",
         new StringBuilder(String.valueOf(var1).length() + 61)
            .append("Service took too long to process intent: ")
            .append(var1)
            .append(" App may get closed.")
            .toString()
      );
      this.b.a();
   }
}
