package com.salesforce.android.cases.ui.internal.logging;

import com.google.gson.annotations.SerializedName;
import com.salesforce.android.service.common.liveagentlogging.BatchedEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;

@BatchedEvent(a = "caseNotificationEvents")
public class CaseNotificationEvent extends BaseEvent {
   @SerializedName(a = "caseBasicInfo")
   private final CaseBasicInfo caseBasicInfo;
   @SerializedName(a = "sender")
   private final String caseId;

   public CaseNotificationEvent(CaseBasicInfo var1, String var2, String var3) {
      super("case", var2);
      this.caseBasicInfo = var1;
      this.caseId = var3;
   }
}
