package com.salesforce.android.service.common.utilities.internal.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;
import com.salesforce.android.service.common.utilities.spatial.Orientation;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class OrientationTracker extends BroadcastReceiver {
   private final Context a;
   private final OrientationTracker.Listener b;

   protected OrientationTracker(OrientationTracker.Builder var1) {
      this.a = var1.a;
      this.b = var1.b;
      IntentFilter var2 = var1.c.a("android.intent.action.CONFIGURATION_CHANGED");
      this.a.registerReceiver(this, var2);
   }

   public void a() {
      this.a.unregisterReceiver(this);
   }

   public Orientation b() {
      Orientation var1;
      if (this.a.getResources().getConfiguration().orientation == 1) {
         var1 = Orientation.e;
      } else {
         var1 = Orientation.f;
      }

      return var1;
   }

   public void onReceive(Context var1, Intent var2) {
      if (var2.getAction().equals("android.intent.action.CONFIGURATION_CHANGED")) {
         this.b.a(this.b());
      }
   }

   public static class Builder {
      protected Context a;
      protected OrientationTracker.Listener b;
      protected IntentFactory c;

      public OrientationTracker.Builder a(Context var1) {
         this.a = var1;
         return this;
      }

      public OrientationTracker.Builder a(OrientationTracker.Listener var1) {
         this.b = var1;
         return this;
      }

      public OrientationTracker a() {
         Arguments.a((Context)this.a);
         Arguments.a(this.b);
         if (this.c == null) {
            this.c = new IntentFactory();
         }

         return new OrientationTracker(this);
      }
   }

   public interface Listener {
      void a(Orientation var1);
   }
}
