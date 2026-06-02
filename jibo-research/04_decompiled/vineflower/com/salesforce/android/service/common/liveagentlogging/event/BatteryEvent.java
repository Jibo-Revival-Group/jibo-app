package com.salesforce.android.service.common.liveagentlogging.event;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;

@BatchedEvent(a = "batteryEvents")
public class BatteryEvent extends BaseEvent {
   @SerializedName(a = "level")
   private final int mLevel;

   public BatteryEvent(String var1, String var2, int var3) {
      byte var4 = 100;
      super(var1, var2);
      if (var3 < 0) {
         var3 = 0;
      }

      if (var3 > 100) {
         var3 = var4;
      }

      this.mLevel = var3;
   }
}
