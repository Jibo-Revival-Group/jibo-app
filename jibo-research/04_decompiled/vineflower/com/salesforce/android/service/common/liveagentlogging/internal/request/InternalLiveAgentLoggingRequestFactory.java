package com.salesforce.android.service.common.liveagentlogging.internal.request;

import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import java.util.List;

public class InternalLiveAgentLoggingRequestFactory implements LiveAgentLoggingRequestFactory {
   @Override
   public BatchedEvents a(SessionInfo var1, List<BaseEvent> var2) {
      return new BatchedEvents(var1.b(), var1.c(), var2);
   }
}
