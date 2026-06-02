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

/* JADX INFO: loaded from: classes.dex */
public class CreateSessionHandler implements SessionListener, Async.Handler<CreateSessionResponse> {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f13514a = ServiceLogging.m14203a((Class<?>) LiveAgentSession.class);

    /* JADX INFO: renamed from: b */
    private final LiveAgentClient f13515b;

    /* JADX INFO: renamed from: c */
    private final LiveAgentRequestFactory f13516c;

    /* JADX INFO: renamed from: d */
    private final SessionListenerNotifier f13517d;

    /* JADX INFO: renamed from: e */
    private final LifecycleEvaluator<LiveAgentState, LiveAgentMetric> f13518e;

    /* JADX INFO: renamed from: f */
    private boolean f13519f;

    @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo9875a(Async async, Object obj) {
        m13825a((Async<?>) async, (CreateSessionResponse) obj);
    }

    public CreateSessionHandler(LiveAgentClient liveAgentClient, LiveAgentRequestFactory liveAgentRequestFactory, SessionListenerNotifier sessionListenerNotifier, LifecycleEvaluator<LiveAgentState, LiveAgentMetric> lifecycleEvaluator) {
        this.f13515b = liveAgentClient;
        this.f13516c = liveAgentRequestFactory;
        this.f13517d = sessionListenerNotifier.m13822a(this);
        this.f13518e = lifecycleEvaluator;
    }

    /* JADX INFO: renamed from: a */
    private void m13824a() {
        if (!this.f13519f) {
            this.f13515b.m13791a(this.f13516c.mo13862a(), CreateSessionResponse.class).mo14077b(this);
        }
    }

    @Override // com.salesforce.android.service.common.liveagentclient.SessionListener
    /* JADX INFO: renamed from: a */
    public void mo13819a(SessionInfo sessionInfo) {
        this.f13519f = true;
    }

    @Override // com.salesforce.android.service.common.liveagentclient.SessionListener
    /* JADX INFO: renamed from: a */
    public void mo13820a(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
        switch (liveAgentState) {
            case Connecting:
                m13824a();
                break;
            case Ended:
                this.f13519f = false;
                break;
        }
    }

    @Override // com.salesforce.android.service.common.liveagentclient.SessionListener
    /* JADX INFO: renamed from: a */
    public void mo13821a(Throwable th) {
    }

    /* JADX INFO: renamed from: a */
    public void m13825a(Async<?> async, CreateSessionResponse createSessionResponse) {
        this.f13517d.mo13819a(new SessionInfo(createSessionResponse.m13867a(), createSessionResponse.m13869c(), createSessionResponse.m13868b(), createSessionResponse.m13870d()));
        this.f13518e.m14167b(LiveAgentMetric.SessionInfoReceived).m14164a();
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
    /* JADX INFO: renamed from: a */
    public void mo12580a(Async<?> async) {
        this.f13518e.m14167b(LiveAgentMetric.ConnectionEstablished).m14164a();
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
    /* JADX INFO: renamed from: a */
    public void mo12581a(Async<?> async, Throwable th) {
        f13514a.mo14195e("LiveAgent session has encountered an error while creating a session - {}", th);
        this.f13518e.m14166b().m14167b(LiveAgentMetric.Deleted).m14164a();
        this.f13517d.mo13821a(th);
    }
}
