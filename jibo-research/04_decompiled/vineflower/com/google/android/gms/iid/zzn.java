package com.google.android.gms.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

final class zzn extends BroadcastReceiver {
   private zzl a;

   zzn(zzl var1) {
      this.a = var1;
      super();
   }

   public final void onReceive(Context var1, Intent var2) {
      if (Log.isLoggable("InstanceID/Rpc", 3)) {
         Log.d("InstanceID/Rpc", "Received GSF callback via dynamic receiver");
      }

      this.a.b(var2);
   }
}
