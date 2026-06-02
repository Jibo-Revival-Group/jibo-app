package com.salesforce.android.service.common.liveagentclient.request;

import com.salesforce.android.service.common.liveagentclient.SessionInfo;

public class InternalLiveAgentRequestFactory implements LiveAgentRequestFactory {
   @Override
   public CreateSessionRequest a() {
      return new CreateSessionRequest();
   }

   @Override
   public MessagesRequest a(SessionInfo var1) {
      return new MessagesRequest(var1.b(), var1.c());
   }

   @Override
   public DeleteSessionRequest b(SessionInfo var1) {
      return new DeleteSessionRequest(var1.b(), var1.c());
   }
}
