package com.salesforce.android.service.common.utilities.internal.connectivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class ConnectivityTracker extends BroadcastReceiver {
   private static final ServiceLogger a = ServiceLogging.a(ConnectivityTracker.class);
   private final Context b;
   private final ConnectivityTracker.Listener c;
   private final ConnectivityManager d;
   private final ConnectionInfo.Builder e;
   private ConnectivityState f = ConnectivityState.UNKNOWN;

   protected ConnectivityTracker(ConnectivityTracker.Builder var1) {
      this.b = var1.a;
      this.c = var1.b;
      this.d = var1.d;
      this.e = var1.e;
      a.b("Setting up network connectivity broadcast receiver");
      IntentFilter var2 = var1.c.a("android.net.conn.CONNECTIVITY_CHANGE");
      this.b.registerReceiver(this, var2);
      this.f = this.a();
   }

   public ConnectivityState a() {
      NetworkInfo var1 = this.d.getActiveNetworkInfo();
      return this.a(var1, this.e.a(var1).a().a());
   }

   ConnectivityState a(NetworkInfo var1, boolean var2) {
      State var3;
      if (var1 != null) {
         var3 = var1.getState();
      } else {
         var3 = State.DISCONNECTED;
      }

      ConnectivityState var4;
      switch (<unrepresentable>.a[var3.ordinal()]) {
         case 1:
            if (var2) {
               var4 = ConnectivityState.SWITCHING;
            } else {
               var4 = ConnectivityState.DISCONNECTED;
            }
            break;
         case 2:
            var4 = ConnectivityState.CONNECTED;
            break;
         default:
            var4 = ConnectivityState.UNKNOWN;
      }

      return var4;
   }

   public ConnectionInfo b() {
      NetworkInfo var1 = this.d.getActiveNetworkInfo();
      return this.e.a(var1).a();
   }

   public void c() {
      a.b("Removing network connectivity broadcast receiver");
      this.b.unregisterReceiver(this);
   }

   public void onReceive(Context var1, Intent var2) {
      Bundle var4 = var2.getExtras();
      if (var4 != null) {
         Object var5 = var4.get("networkInfo");
         if (var5 != null && var5 instanceof NetworkInfo) {
            NetworkInfo var7 = (NetworkInfo)var5;
            ConnectionInfo var6 = this.e.a(var7).a();
            ConnectivityState var8 = this.a(var7, var6.a());
            if (var8 != this.f) {
               ConnectivityState var3 = this.f;
               this.f = var8;
               a.b("Connectivity change: {} -> {}", var3.name(), this.f.name());
               a.b("{}", var6);
               this.c.a(var6, this.f, var3);
            }
         }
      }
   }

   public static class Builder {
      protected Context a;
      protected ConnectivityTracker.Listener b;
      protected IntentFactory c;
      protected ConnectivityManager d;
      protected ConnectionInfo.Builder e;

      public ConnectivityTracker.Builder a(Context var1) {
         this.a = var1;
         return this;
      }

      public ConnectivityTracker.Builder a(ConnectivityTracker.Listener var1) {
         this.b = var1;
         return this;
      }

      public ConnectivityTracker a() {
         Arguments.a((Context)this.a);
         Arguments.a(this.b);
         if (this.d == null) {
            this.d = (ConnectivityManager)this.a.getSystemService("connectivity");
         }

         if (this.c == null) {
            this.c = new IntentFactory();
         }

         if (this.e == null) {
            this.e = new ConnectionInfo.Builder();
         }

         return new ConnectivityTracker(this);
      }
   }

   public interface Listener {
      void a(ConnectionInfo var1, ConnectivityState var2, ConnectivityState var3);
   }
}
