package com.salesforce.android.service.common.liveagentlogging.event;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;

@BatchedEvent(a = "backgroundedEvents")
public class BackgroundedEvent extends BaseEvent {
   @SerializedName(a = "backgrounded")
   private final boolean mBackgrounded;

   public BackgroundedEvent(String var1, String var2, boolean var3) {
      super(var1, var2);
      this.mBackgrounded = var3;
   }
}
