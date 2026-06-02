package com.salesforce.android.service.common.liveagentclient;

import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;

public interface SessionListener {
   void a(SessionInfo var1);

   void a(LiveAgentState var1, LiveAgentState var2);

   void a(Throwable var1);
}
