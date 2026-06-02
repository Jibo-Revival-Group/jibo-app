package com.salesforce.android.service.common.liveagentclient.request;

import com.salesforce.android.service.common.liveagentclient.SessionInfo;

public interface LiveAgentRequestFactory {
   CreateSessionRequest a();

   MessagesRequest a(SessionInfo var1);

   DeleteSessionRequest b(SessionInfo var1);
}
