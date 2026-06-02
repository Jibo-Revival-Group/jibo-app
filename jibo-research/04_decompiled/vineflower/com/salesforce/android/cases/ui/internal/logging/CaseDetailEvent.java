package com.salesforce.android.cases.ui.internal.logging;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;

@BatchedEvent(a = "caseDetailEvents")
public class CaseDetailEvent extends BaseEvent {
   @SerializedName(a = "caseBasicInfo")
   private final CaseBasicInfo caseBasicInfo;
   @SerializedName(a = "caseId")
   private final String caseId;
   @SerializedName(a = "eventType")
   private final String eventType;

   public CaseDetailEvent(CaseBasicInfo var1, String var2, String var3, String var4) {
      super("case", var2);
      this.caseBasicInfo = var1;
      this.eventType = var3;
      this.caseId = var4;
   }
}
