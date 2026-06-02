package com.salesforce.android.cases.ui.internal.logging;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;

@BatchedEvent(a = "caseDataEnteredEvents")
public class CaseDataEnteredEvent extends BaseEvent {
   @SerializedName(a = "caseBasicInfo")
   private final CaseBasicInfo caseBasicInfo;
   @SerializedName(a = "wordCount")
   private final int wordCount;

   public CaseDataEnteredEvent(CaseBasicInfo var1, String var2, int var3) {
      super("case", var2);
      this.caseBasicInfo = var1;
      this.wordCount = var3;
   }
}
