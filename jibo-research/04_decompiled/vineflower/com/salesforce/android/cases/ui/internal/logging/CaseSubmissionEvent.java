package com.salesforce.android.cases.ui.internal.logging;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;

@BatchedEvent(a = "caseSubmissionEvents")
public class CaseSubmissionEvent extends BaseEvent {
   @SerializedName(a = "caseBasicInfo")
   private final CaseBasicInfo caseBasicInfo;
   @SerializedName(a = "caseId")
   private final String caseId;
   @SerializedName(a = "eventType")
   private final String eventType;
   @SerializedName(a = "result")
   private final String result;
   @SerializedName(a = "wordCount")
   private final int wordCount;

   public CaseSubmissionEvent(CaseBasicInfo var1, String var2, String var3, String var4, String var5, int var6) {
      super("case", var2);
      this.caseBasicInfo = var1;
      this.eventType = var3;
      this.result = var4;
      this.caseId = var5;
      this.wordCount = var6;
   }
}
