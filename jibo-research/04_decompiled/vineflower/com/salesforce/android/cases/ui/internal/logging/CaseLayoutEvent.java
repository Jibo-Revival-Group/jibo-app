package com.salesforce.android.cases.ui.internal.logging;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;

@BatchedEvent(a = "caseLayoutEvents")
public class CaseLayoutEvent extends BaseEvent {
   @SerializedName(a = "caseBasicInfo")
   private final CaseBasicInfo caseBasicInfo;
   @SerializedName(a = "eventType")
   private final String eventType;

   public CaseLayoutEvent(CaseBasicInfo var1, String var2, String var3) {
      super("case", var2);
      this.caseBasicInfo = var1;
      this.eventType = var3;
   }
}
