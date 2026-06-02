package com.salesforce.android.service.common.liveagentclient.handler;

import com.salesforce.android.service.common.liveagentclient.LiveAgentClient;
import com.salesforce.android.service.common.liveagentclient.LiveAgentSession;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionListener;
import com.salesforce.android.service.common.liveagentclient.SessionListenerNotifier;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentMetric;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequestFactory;
import com.salesforce.android.service.common.liveagentclient.response.CreateSessionResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleEvaluator;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;

public class CreateSessionHandler implements SessionListener, Async.Handler<CreateSessionResponse> {
   private static final ServiceLogger a = ServiceLogging.a(LiveAgentSession.class);
   private final LiveAgentClient b;
   private final LiveAgentRequestFactory c;
   private final SessionListenerNotifier d;
   private final LifecycleEvaluator<LiveAgentState, LiveAgentMetric> e;
   private boolean f;

   public CreateSessionHandler(
      LiveAgentClient var1, LiveAgentRequestFactory var2, SessionListenerNotifier var3, LifecycleEvaluator<LiveAgentState, LiveAgentMetric> var4
   ) {
      this.b = var1;
      this.c = var2;
      this.d = var3.a(this);
      this.e = var4;
   }

   private void a() {
      if (!this.f) {
         this.b.a(this.c.a(), CreateSessionResponse.class).b(this);
      }
   }

   @Override
   public void a(SessionInfo var1) {
      this.f = true;
   }

   @Override
   public void a(LiveAgentState var1, LiveAgentState var2) {
      switch (<unrepresentable>.a[var1.ordinal()]) {
         case 1:
            this.a();
            break;
         case 2:
            this.f = false;
      }
   }

   @Override
   public void a(Async<?> var1) {
      this.e.b(LiveAgentMetric.ConnectionEstablished).a();
   }

   public void a(Async<?> var1, CreateSessionResponse var2) {
      SessionInfo var3 = new SessionInfo(var2.a(), var2.c(), var2.b(), var2.d());
      this.d.a(var3);
      this.e.b(LiveAgentMetric.SessionInfoReceived).a();
   }

   @Override
   public void a(Async<?> var1, Throwable var2) {
      a.e("LiveAgent session has encountered an error while creating a session - {}", var2);
      this.e.b().b(LiveAgentMetric.Deleted).a();
      this.d.a(var2);
   }

   @Override
   public void a(Throwable var1) {
   }
}
