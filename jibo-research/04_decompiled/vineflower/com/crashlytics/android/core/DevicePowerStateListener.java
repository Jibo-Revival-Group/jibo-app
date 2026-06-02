package com.crashlytics.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

class DevicePowerStateListener {
   private static final IntentFilter a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
   private static final IntentFilter b = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
   private static final IntentFilter c = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
   private final AtomicBoolean d;
   private final Context e;
   private final BroadcastReceiver f;
   private final BroadcastReceiver g;
   private boolean h;

   public DevicePowerStateListener(Context var1) {
      int var2 = -1;
      super();
      this.e = var1;
      Intent var4 = var1.registerReceiver(null, a);
      if (var4 != null) {
         var2 = var4.getIntExtra("status", -1);
      }

      boolean var3;
      if (var2 != 2 && var2 != 5) {
         var3 = false;
      } else {
         var3 = true;
      }

      this.h = var3;
      this.g = new BroadcastReceiver(this) {
         final DevicePowerStateListener a;

         {
            this.a = var1;
         }

         public void onReceive(Context var1, Intent var2x) {
            this.a.h = true;
         }
      };
      this.f = new BroadcastReceiver(this) {
         final DevicePowerStateListener a;

         {
            this.a = var1;
         }

         public void onReceive(Context var1, Intent var2) {
            this.a.h = false;
         }
      };
      var1.registerReceiver(this.g, b);
      var1.registerReceiver(this.f, c);
      this.d = new AtomicBoolean(true);
   }

   public boolean a() {
      return this.h;
   }

   public void b() {
      if (this.d.getAndSet(false)) {
         this.e.unregisterReceiver(this.g);
         this.e.unregisterReceiver(this.f);
      }
   }
}
