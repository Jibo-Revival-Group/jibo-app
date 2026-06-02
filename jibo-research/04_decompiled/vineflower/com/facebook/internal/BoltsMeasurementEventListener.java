package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.facebook.appevents.AppEventsLogger;

public class BoltsMeasurementEventListener extends BroadcastReceiver {
   private static final String BOLTS_MEASUREMENT_EVENT_PREFIX = "bf_";
   private static final String MEASUREMENT_EVENT_ARGS_KEY = "event_args";
   private static final String MEASUREMENT_EVENT_NAME_KEY = "event_name";
   private static final String MEASUREMENT_EVENT_NOTIFICATION_NAME = "com.parse.bolts.measurement_event";
   private static BoltsMeasurementEventListener _instance;
   private Context applicationContext;

   private BoltsMeasurementEventListener(Context var1) {
      this.applicationContext = var1.getApplicationContext();
   }

   private void close() {
      LocalBroadcastManager.a(this.applicationContext).a(this);
   }

   public static BoltsMeasurementEventListener getInstance(Context var0) {
      BoltsMeasurementEventListener var1;
      if (_instance != null) {
         var1 = _instance;
      } else {
         _instance = new BoltsMeasurementEventListener(var0);
         _instance.open();
         var1 = _instance;
      }

      return var1;
   }

   private void open() {
      LocalBroadcastManager.a(this.applicationContext).a(this, new IntentFilter("com.parse.bolts.measurement_event"));
   }

   protected void finalize() throws Throwable {
      try {
         this.close();
      } finally {
         super.finalize();
      }
   }

   public void onReceive(Context var1, Intent var2) {
      AppEventsLogger var7 = AppEventsLogger.newLogger(var1);
      String var3 = "bf_" + var2.getStringExtra("event_name");
      Bundle var6 = var2.getBundleExtra("event_args");
      Bundle var4 = new Bundle();

      for (String var5 : var6.keySet()) {
         var4.putString(var5.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", "").replaceAll("[ -]*$", ""), (String)var6.get(var5));
      }

      var7.logEvent(var3, var4);
   }
}
