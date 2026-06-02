package com.salesforce.android.service.common.liveagentlogging.internal;

import android.content.Context;
import com.salesforce.android.service.common.liveagentclient.LiveAgentSession;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.integrity.LiveAgentQueue;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.internal.PodConnectionManager;
import com.salesforce.android.service.common.liveagentlogging.internal.request.BatchedEvents;
import com.salesforce.android.service.common.liveagentlogging.internal.request.InternalLiveAgentLoggingRequestFactory;
import com.salesforce.android.service.common.liveagentlogging.internal.request.LiveAgentLoggingRequestFactory;
import com.salesforce.android.service.common.liveagentlogging.internal.response.BatchedEventsResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.control.BasicAsync;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.HandlerManager;
import com.salesforce.android.service.common.utilities.threading.Timer;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class InternalLiveAgentLoggingSession implements LiveAgentLoggingSession, PodConnectionManager.Listener, HandlerManager.OnTimerElapsedListener {

    /* JADX INFO: renamed from: b */
    private static final ServiceLogger f13596b = ServiceLogging.m14203a((Class<?>) InternalLiveAgentLoggingSession.class);

    /* JADX INFO: renamed from: a */
    protected final LiveAgentQueue f13597a;

    /* JADX INFO: renamed from: c */
    private final PodConnectionManager f13598c;

    /* JADX INFO: renamed from: d */
    private final LiveAgentLoggingRequestFactory f13599d;

    /* JADX INFO: renamed from: e */
    private final Timer f13600e;

    /* JADX INFO: renamed from: f */
    private final LiveAgentLoggingConfiguration f13601f;

    /* JADX INFO: renamed from: g */
    private final int f13602g;

    /* JADX INFO: renamed from: h */
    private Set<LiveAgentLoggingSession.Listener> f13603h = new HashSet();

    /* JADX INFO: renamed from: i */
    private List<BaseEvent> f13604i = new ArrayList();

    /* JADX INFO: renamed from: j */
    private LiveAgentSession f13605j;

    /* JADX INFO: renamed from: k */
    private SessionInfo f13606k;

    protected InternalLiveAgentLoggingSession(Builder builder) {
        this.f13598c = builder.f13611c.m13909a(this);
        this.f13599d = builder.f13612d;
        this.f13600e = builder.f13613e.mo14221b(this).mo14222b();
        this.f13601f = builder.f13610b;
        this.f13602g = builder.f13610b.m13885c();
        this.f13597a = builder.f13614f.m13854a(true).m13855a();
    }

    @Override // com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession
    /* JADX INFO: renamed from: a */
    public void mo13890a(BaseEvent baseEvent) {
        f13596b.mo14187a("Queuing a Logging Event: {}", baseEvent.getClass().getSimpleName());
        this.f13604i.add(baseEvent);
        if (this.f13604i.size() == 1) {
            this.f13600e.mo14214a();
        } else if (this.f13604i.size() >= this.f13602g) {
            mo13889a();
        }
    }

    @Override // com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession
    /* JADX INFO: renamed from: a */
    public void mo13891a(Collection<? extends BaseEvent> collection) {
        f13596b.mo14187a("Batch queueing {} events", Integer.valueOf(collection.size()));
        this.f13604i.addAll(collection);
        if (this.f13604i.size() == collection.size()) {
            this.f13600e.mo14214a();
        } else if (this.f13604i.size() >= this.f13602g) {
            m13898a(mo13889a());
        }
    }

    @Override // com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession
    /* JADX INFO: renamed from: a */
    public Async<BatchedEventsResponse> mo13889a() {
        ArrayList arrayList;
        if (!this.f13598c.m13910a() || this.f13605j == null || this.f13606k == null) {
            f13596b.mo14192d("Unable to send logging events without an active LiveAgent session.");
            return BasicAsync.m14087h();
        }
        if (this.f13604i.isEmpty()) {
            f13596b.mo14188b("There are no queued logging events to send.");
            return BasicAsync.m14087h();
        }
        synchronized (this) {
            arrayList = new ArrayList(this.f13604i);
            this.f13604i.clear();
            this.f13600e.mo14215b();
        }
        f13596b.mo14187a("Sending {} queued events [LiveAgent Session ID - {}]", Integer.valueOf(arrayList.size()), this.f13606k.m13815a());
        final BatchedEvents batchedEventsMo13923a = this.f13599d.mo13923a(this.f13606k, arrayList);
        Async<BatchedEventsResponse> asyncM13845a = this.f13597a.m13845a(batchedEventsMo13923a, BatchedEventsResponse.class);
        asyncM13845a.mo14073a(new Async.ErrorHandler() { // from class: com.salesforce.android.service.common.liveagentlogging.internal.InternalLiveAgentLoggingSession.1
            @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
            /* JADX INFO: renamed from: a */
            public void mo12581a(Async<?> async, Throwable th) {
                InternalLiveAgentLoggingSession.this.f13597a.m13845a(batchedEventsMo13923a, BatchedEventsResponse.class);
            }
        });
        m13898a(asyncM13845a);
        return asyncM13845a;
    }

    @Override // com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession
    /* JADX INFO: renamed from: a */
    public LiveAgentLoggingSession mo13888a(LiveAgentLoggingSession.Listener listener) {
        this.f13603h.add(listener);
        return this;
    }

    /* JADX INFO: renamed from: c */
    public void m13899c() {
        f13596b.mo14190c("Tearing down the Live Agent Logging session.");
        this.f13597a.m13846a();
        this.f13598c.m13911b(this);
        this.f13598c.m13913c();
        this.f13600e.mo14215b();
        this.f13604i.clear();
    }

    /* JADX INFO: renamed from: a */
    void m13898a(Async<BatchedEventsResponse> async) {
        Iterator<LiveAgentLoggingSession.Listener> it = this.f13603h.iterator();
        while (it.hasNext()) {
            it.next().mo13026a(async);
        }
    }

    @Override // com.salesforce.android.service.common.utilities.threading.HandlerManager.OnTimerElapsedListener
    /* JADX INFO: renamed from: b */
    public void mo13832b() {
        if (this.f13606k != null) {
            m13898a(mo13889a());
        } else {
            f13596b.mo14192d("Unable to flush via timer. LiveAgent session is not active.");
        }
    }

    @Override // com.salesforce.android.service.common.liveagentlogging.internal.PodConnectionManager.Listener
    /* JADX INFO: renamed from: a */
    public void mo13897a(LiveAgentSession liveAgentSession, SessionInfo sessionInfo) {
        f13596b.mo14191c("Connected to a new Live Agent session {}", sessionInfo.m13815a());
        this.f13605j = liveAgentSession;
        this.f13606k = sessionInfo;
        this.f13605j.m13804a(this.f13601f.m13884b());
        this.f13597a.m13848a(this.f13605j);
        Iterator<LiveAgentLoggingSession.Listener> it = this.f13603h.iterator();
        while (it.hasNext()) {
            it.next().mo13031c();
        }
    }

    @Override // com.salesforce.android.service.common.liveagentlogging.internal.PodConnectionManager.Listener
    /* JADX INFO: renamed from: d */
    public void mo13900d() {
        this.f13597a.m13846a();
        Iterator<LiveAgentLoggingSession.Listener> it = this.f13603h.iterator();
        while (it.hasNext()) {
            it.next().mo13032d();
        }
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected Context f13609a;

        /* JADX INFO: renamed from: b */
        protected LiveAgentLoggingConfiguration f13610b;

        /* JADX INFO: renamed from: c */
        protected PodConnectionManager f13611c;

        /* JADX INFO: renamed from: d */
        protected LiveAgentLoggingRequestFactory f13612d;

        /* JADX INFO: renamed from: e */
        protected Timer.Builder f13613e;

        /* JADX INFO: renamed from: f */
        protected LiveAgentQueue.Builder f13614f;

        /* JADX INFO: renamed from: a */
        public Builder m13901a(Context context) {
            this.f13609a = context;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13902a(LiveAgentLoggingConfiguration liveAgentLoggingConfiguration) {
            this.f13610b = liveAgentLoggingConfiguration;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13903a(PodConnectionManager podConnectionManager) {
            this.f13611c = podConnectionManager;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public InternalLiveAgentLoggingSession m13904a() {
            Arguments.m14235a(this.f13609a);
            Arguments.m14235a(this.f13610b);
            Arguments.m14235a(this.f13611c);
            if (this.f13612d == null) {
                this.f13612d = new InternalLiveAgentLoggingRequestFactory();
            }
            if (this.f13613e == null) {
                this.f13613e = new Timer.Builder();
            }
            if (this.f13614f == null) {
                this.f13614f = new LiveAgentQueue.Builder().m13853a(this.f13609a);
            }
            this.f13613e.m14232a(this.f13610b.m13886d());
            return new InternalLiveAgentLoggingSession(this);
        }
    }
}
