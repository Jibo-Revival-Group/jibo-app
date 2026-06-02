package com.salesforce.android.service.common.utilities.internal.device;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.salesforce.android.service.common.utilities.internal.android.IntentFactory;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;

public class BatteryLevelTracker {
   private static final ServiceLogger a = ServiceLogging.a(BatteryLevelTracker.class);
   private final Context b;
   private final IntentFilter c;

   protected BatteryLevelTracker(BatteryLevelTracker.Builder var1) {
      this.b = var1.a;
      this.c = var1.b.a("android.intent.action.BATTERY_CHANGED");
   }

   public int a() {
      byte var2 = -1;
      Intent var4 = this.b.registerReceiver(null, this.c);
      int var1;
      if (var4 == null) {
         var1 = 0;
      } else {
         int var3 = var4.getIntExtra("level", 0);
         var1 = var4.getIntExtra("scale", -1);
         if (var1 == 0) {
            var1 = var2;
         }

         var1 = Math.round((float)var3 / var1 * 100.0F);
         a.c("Battery level: {}", var1);
      }

      return var1;
   }

   public static class Builder {
      protected Context a;
      protected IntentFactory b;

      public BatteryLevelTracker.Builder a(Context var1) {
         this.a = var1;
         return this;
      }

      public BatteryLevelTracker a() {
         Arguments.a((Context)this.a);
         if (this.b == null) {
            this.b = new IntentFactory();
         }

         return new BatteryLevelTracker(this);
      }
   }
}
