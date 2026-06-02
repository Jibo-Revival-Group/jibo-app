package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

final class zzab extends BroadcastReceiver {
   private zzaa a;

   public zzab(zzaa var1) {
      this.a = var1;
   }

   public final void a() {
      if (FirebaseInstanceId.h()) {
         Log.d("FirebaseInstanceId", "Connectivity change received registered");
      }

      IntentFilter var1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      this.a.a().registerReceiver(this, var1);
   }

   public final void onReceive(Context var1, Intent var2) {
      if (this.a != null && this.a.b()) {
         if (FirebaseInstanceId.h()) {
            Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
         }

         FirebaseInstanceId.a(this.a, 0L);
         this.a.a().unregisterReceiver(this);
         this.a = null;
      }
   }
}
