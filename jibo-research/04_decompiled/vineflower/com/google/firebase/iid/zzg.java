package com.google.firebase.iid;

import android.util.Log;

final class zzg implements Runnable {
   private zzd a;
   private zzf b;

   zzg(zzf var1, zzd var2) {
      this.b = var1;
      this.a = var2;
      super();
   }

   @Override
   public final void run() {
      if (Log.isLoggable("EnhancedIntentService", 3)) {
         Log.d("EnhancedIntentService", "bg processing of the intent starting now");
      }

      zzf.a(this.b).b(this.a.a);
      this.a.a();
   }
}
