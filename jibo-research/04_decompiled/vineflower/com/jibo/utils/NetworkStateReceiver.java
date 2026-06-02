package com.jibo.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkStateReceiver extends BroadcastReceiver {
   public static boolean a(Context var0) {
      NetworkInfo var2 = ((ConnectivityManager)var0.getSystemService("connectivity")).getActiveNetworkInfo();
      boolean var1;
      if (var2 != null && var2.isConnectedOrConnecting()) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1;
   }

   public void a(boolean var1) {
   }

   public void onReceive(Context var1, Intent var2) {
      this.a(a(var1));
   }
}
