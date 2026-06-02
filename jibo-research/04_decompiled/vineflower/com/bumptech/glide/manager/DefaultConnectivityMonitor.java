package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

class DefaultConnectivityMonitor implements ConnectivityMonitor {
   private final Context a;
   private final ConnectivityMonitor.ConnectivityListener b;
   private boolean c;
   private boolean d;
   private final BroadcastReceiver e = new BroadcastReceiver(this) {
      final DefaultConnectivityMonitor a;

      {
         this.a = var1;
      }

      public void onReceive(Context var1, Intent var2) {
         boolean var3 = this.a.c;
         this.a.c = this.a.a(var1);
         if (var3 != this.a.c) {
            this.a.b.a(this.a.c);
         }
      }
   };

   public DefaultConnectivityMonitor(Context var1, ConnectivityMonitor.ConnectivityListener var2) {
      this.a = var1.getApplicationContext();
      this.b = var2;
   }

   private void a() {
      if (!this.d) {
         this.c = this.a(this.a);
         this.a.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
         this.d = true;
      }
   }

   private boolean a(Context var1) {
      NetworkInfo var3 = ((ConnectivityManager)var1.getSystemService("connectivity")).getActiveNetworkInfo();
      boolean var2;
      if (var3 != null && var3.isConnected()) {
         var2 = true;
      } else {
         var2 = false;
      }

      return var2;
   }

   private void b() {
      if (this.d) {
         this.a.unregisterReceiver(this.e);
         this.d = false;
      }
   }

   @Override
   public void onDestroy() {
   }

   @Override
   public void onStart() {
      this.a();
   }

   @Override
   public void onStop() {
      this.b();
   }
}
