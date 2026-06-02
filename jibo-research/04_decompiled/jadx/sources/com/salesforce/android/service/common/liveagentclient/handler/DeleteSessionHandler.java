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

/* JADX INFO: loaded from: classes.dex */
public class DeleteSessionHandler implements SessionListener, Async.CompletionHandler, Async.ErrorHandler {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f13521a = ServiceLogging.m14203a((Class<?>) DeleteSessionHandler.class);

    /* JADX INFO: renamed from: b */
    private final LiveAgentClient f13522b;

    /* JADX INFO: renamed from: c */
    private final LiveAgentRequestFactory f13523c;

    /* JADX INFO: renamed from: d */
    private final SessionListenerNotifier f13524d;

    /* JADX INFO: renamed from: e */
    private final LifecycleEvaluator<LiveAgentState, LiveAgentMetric> f13525e;

    /* JADX INFO: renamed from: f */
    private SessionInfo f13526f;

    public DeleteSessionHandler(LiveAgentClient liveAgentClient, LiveAgentRequestFactory liveAgentRequestFactory, SessionListenerNotifier sessionListenerNotifier, LifecycleEvaluator<LiveAgentState, LiveAgentMetric> lifecycleEvaluator) {
        this.f13522b = liveAgentClient;
        this.f13523c = liveAgentRequestFactory;
        this.f13524d = sessionListenerNotifier.m13822a(this);
        this.f13525e = lifecycleEvaluator;
    }

    /* JADX INFO: renamed from: a */
    private void m13826a() {
        if (this.f13526f == null) {
            this.f13525e.m14167b(LiveAgentMetric.Deleted).m14164a();
        } else {
            this.f13522b.m13791a(this.f13523c.mo13864b(this.f13526f), LiveAgentStringResponse.class).mo14072a((Async.CompletionHandler) this).mo14073a((Async.ErrorHandler) this);
        }
    }

    @Override // com.salesforce.android.service.common.liveagentclient.SessionListener
    /* JADX INFO: renamed from: a */
    public void mo13819a(SessionInfo sessionInfo) {
        this.f13526f = sessionInfo;
    }

    @Override // com.salesforce.android.service.common.liveagentclient.SessionListener
    /* JADX INFO: renamed from: a */
    public void mo13820a(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
        switch (liveAgentState) {
            case Deleting:
                m13826a();
                break;
            case Ended:
                this.f13526f = null;
                break;
        }
    }

    @Override // com.salesforce.android.service.common.liveagentclient.SessionListener
    /* JADX INFO: renamed from: a */
    public void mo13821a(Throwable th) {
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
    /* JADX INFO: renamed from: a */
    public void mo12580a(Async<?> async) {
        this.f13525e.m14167b(LiveAgentMetric.Deleted).m14164a();
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
    /* JADX INFO: renamed from: a */
    public void mo12581a(Async<?> async, Throwable th) {
        f13521a.mo14193d("LiveAgent session has encountered an error while attempting to delete the session. Ending the session anyway. - {}", th);
        this.f13525e.m14167b(LiveAgentMetric.Deleted).m14164a();
        this.f13524d.mo13821a(th);
    }
}
