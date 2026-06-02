package com.salesforce.android.service.common.liveagentlogging.event;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;

@BatchedEvent(a = "connectivityEvents")
public class ConnectivityEvent extends BaseEvent {
   @SerializedName(a = "radioType")
   private final String mRadioType;
   @SerializedName(a = "technology")
   private final String mTechnology;

   public ConnectivityEvent(String var1, String var2, String var3, String var4) {
      super(var1, var2);
      this.mTechnology = var3;
      this.mRadioType = var4;
   }
}
