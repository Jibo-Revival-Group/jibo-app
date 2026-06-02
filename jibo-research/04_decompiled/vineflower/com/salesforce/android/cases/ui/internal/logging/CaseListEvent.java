package com.salesforce.android.cases.ui.internal.logging;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;

@BatchedEvent(a = "caseListEvents")
public class CaseListEvent extends BaseEvent {
   @SerializedName(a = "caseBasicInfo")
   private final CaseBasicInfo caseBasicInfo;
   @SerializedName(a = "caseCount")
   private final int caseCount;
   @SerializedName(a = "eventType")
   private final String eventType;

   public CaseListEvent(CaseBasicInfo var1, String var2, String var3, int var4) {
      super("case", var2);
      this.caseBasicInfo = var1;
      this.eventType = var3;
      this.caseCount = var4;
   }
}
