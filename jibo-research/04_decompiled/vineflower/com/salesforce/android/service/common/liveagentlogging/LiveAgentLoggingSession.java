package com.salesforce.android.service.common.liveagentlogging;

import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.internal.response.BatchedEventsResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import java.util.Collection;

public interface LiveAgentLoggingSession {
   LiveAgentLoggingSession a(LiveAgentLoggingSession.Listener var1);

   Async<BatchedEventsResponse> a();

   void a(BaseEvent var1);

   void a(Collection<? extends BaseEvent> var1);

   interface Listener {
      void a(Async<BatchedEventsResponse> var1);

      void c();

      void d();
   }
}
