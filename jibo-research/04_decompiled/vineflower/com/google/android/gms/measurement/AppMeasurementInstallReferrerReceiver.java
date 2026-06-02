package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver.PendingResult;
import com.google.android.gms.internal.zzcid;
import com.google.android.gms.internal.zzcif;

public final class AppMeasurementInstallReferrerReceiver extends BroadcastReceiver implements zzcif {
   private zzcid a;

   @Override
   public final PendingResult a() {
      return this.goAsync();
   }

   @Override
   public final void a(Context var1, Intent var2) {
   }

   public final void onReceive(Context var1, Intent var2) {
      if (this.a == null) {
         this.a = new zzcid(this);
      }

      this.a.a(var1, var2);
   }
}
