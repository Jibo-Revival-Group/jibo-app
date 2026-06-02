package com.salesforce.android.service.common.liveagentlogging.internal.request;

import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import java.util.List;

public interface LiveAgentLoggingRequestFactory {
   BatchedEvents a(SessionInfo var1, List<BaseEvent> var2);
}
