package com.salesforce.androidsdk.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class LogoutCompleteReceiver extends BroadcastReceiver {
   protected abstract void a();

   public void onReceive(Context var1, Intent var2) {
      if (var2 != null && var2.getAction().equals("com.salesforce.LOGOUT_COMPLETE")) {
         this.a();
      }
   }
}
