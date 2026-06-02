package com.salesforce.android.service.common.liveagentclient.handler;

import com.salesforce.android.service.common.liveagentclient.LiveAgentClient;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionListener;
import com.salesforce.android.service.common.liveagentclient.SessionListenerNotifier;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentMetric;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequestFactory;
import com.salesforce.android.service.common.liveagentclient.response.LiveAgentStringResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleEvaluator;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;

public class DeleteSessionHandler implements SessionListener, Async.CompletionHandler, Async.ErrorHandler {
   private static final ServiceLogger a = ServiceLogging.a(DeleteSessionHandler.class);
   private final LiveAgentClient b;
   private final LiveAgentRequestFactory c;
   private final SessionListenerNotifier d;
   private final LifecycleEvaluator<LiveAgentState, LiveAgentMetric> e;
   private SessionInfo f;

   public DeleteSessionHandler(
      LiveAgentClient var1, LiveAgentRequestFactory var2, SessionListenerNotifier var3, LifecycleEvaluator<LiveAgentState, LiveAgentMetric> var4
   ) {
      this.b = var1;
      this.c = var2;
      this.d = var3.a(this);
      this.e = var4;
   }

   private void a() {
      if (this.f == null) {
         this.e.b(LiveAgentMetric.Deleted).a();
      } else {
         this.b.a(this.c.b(this.f), LiveAgentStringResponse.class).a(this).a(this);
      }
   }

   @Override
   public void a(SessionInfo var1) {
      this.f = var1;
   }

   @Override
   public void a(LiveAgentState var1, LiveAgentState var2) {
      switch (<unrepresentable>.a[var1.ordinal()]) {
         case 1:
            this.a();
            break;
         case 2:
            this.f = null;
      }
   }

   @Override
   public void a(Async<?> var1) {
      this.e.b(LiveAgentMetric.Deleted).a();
   }

   @Override
   public void a(Async<?> var1, Throwable var2) {
      a.d("LiveAgent session has encountered an error while attempting to delete the session. Ending the session anyway. - {}", var2);
      this.e.b(LiveAgentMetric.Deleted).a();
      this.d.a(var2);
   }

   @Override
   public void a(Throwable var1) {
   }
}
