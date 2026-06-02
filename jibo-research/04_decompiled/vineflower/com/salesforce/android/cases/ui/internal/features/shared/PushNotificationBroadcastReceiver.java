package com.salesforce.android.cases.ui.internal.features.shared;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.salesforce.android.cases.core.model.PushNotification;

public abstract class PushNotificationBroadcastReceiver extends BroadcastReceiver {
   public final void a(Context var1) {
      if (var1 != null) {
         LocalBroadcastManager.a(var1).a(this, new IntentFilter("Body"));
      }
   }

   public abstract void a(PushNotification var1);

   public final void b(Context var1) {
      if (var1 != null) {
         LocalBroadcastManager.a(var1).a(this);
      }
   }

   public final void onReceive(Context var1, Intent var2) {
      if (var1 != null) {
         this.a(new PushNotification(var2.getExtras()));
      }
   }
}
