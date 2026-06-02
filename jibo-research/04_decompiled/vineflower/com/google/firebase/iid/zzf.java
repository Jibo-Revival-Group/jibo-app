package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

public final class zzf extends Binder {
   private final zzb a;

   zzf(zzb var1) {
      this.a = var1;
   }

   public final void a(zzd var1) {
      if (Binder.getCallingUid() != Process.myUid()) {
         throw new SecurityException("Binding only allowed within app");
      }

      if (Log.isLoggable("EnhancedIntentService", 3)) {
         Log.d("EnhancedIntentService", "service received new intent via bind strategy");
      }

      if (this.a.c(var1.a)) {
         var1.a();
      } else {
         if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "intent being queued for bg execution");
         }

         this.a.a.execute(new zzg(this, var1));
      }
   }
}
