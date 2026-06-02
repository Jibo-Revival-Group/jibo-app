package com.salesforce.android.service.common.liveagentlogging.internal.service;

import android.content.Intent;
import android.os.IBinder;
import android.support.v4.util.ArraySet;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.internal.InternalLiveAgentLoggingSession;
import com.salesforce.android.service.common.liveagentlogging.internal.PodConnectionManager;
import com.salesforce.android.service.common.liveagentlogging.internal.service.LiveAgentLoggingServiceBinder;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
class LiveAgentLoggingServiceDelegate {

    /* JADX INFO: renamed from: a */
    protected static final ServiceLogger f13650a = ServiceLogging.m14203a((Class<?>) LiveAgentLoggingService.class);

    /* JADX INFO: renamed from: b */
    protected Set<PodConnectionManager> f13651b;

    /* JADX INFO: renamed from: c */
    protected Set<InternalLiveAgentLoggingSession> f13652c;

    /* JADX INFO: renamed from: d */
    private final LiveAgentLoggingService f13653d;

    /* JADX INFO: renamed from: e */
    private final LiveAgentLoggingServiceBinder.Builder f13654e;

    /* JADX INFO: renamed from: f */
    private final PodConnectionManager.Builder f13655f;

    /* JADX INFO: renamed from: g */
    private final InternalLiveAgentLoggingSession.Builder f13656g;

    LiveAgentLoggingServiceDelegate(LiveAgentLoggingService liveAgentLoggingService) {
        this(liveAgentLoggingService, new LiveAgentLoggingServiceBinder.Builder(), new PodConnectionManager.Builder(), new InternalLiveAgentLoggingSession.Builder());
    }

    LiveAgentLoggingServiceDelegate(LiveAgentLoggingService liveAgentLoggingService, LiveAgentLoggingServiceBinder.Builder builder, PodConnectionManager.Builder builder2, InternalLiveAgentLoggingSession.Builder builder3) {
        this.f13651b = new ArraySet();
        this.f13652c = new ArraySet();
        this.f13653d = liveAgentLoggingService;
        this.f13654e = builder;
        this.f13655f = builder2;
        this.f13656g = builder3;
    }

    /* JADX INFO: renamed from: b */
    private void m13932b() {
        Iterator<PodConnectionManager> it = this.f13651b.iterator();
        while (it.hasNext()) {
            it.next().m13912b();
        }
    }

    /* JADX INFO: renamed from: a */
    public IBinder m13933a(Intent intent) {
        f13650a.mo14188b("LiveAgentLoggingService is starting");
        LiveAgentLoggingConfiguration liveAgentLoggingConfiguration = (LiveAgentLoggingConfiguration) intent.getSerializableExtra("com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration");
        Arguments.m14235a(liveAgentLoggingConfiguration);
        PodConnectionManager podConnectionManagerM13916a = this.f13655f.m13914a(this.f13653d).m13915a(liveAgentLoggingConfiguration).m13916a();
        InternalLiveAgentLoggingSession internalLiveAgentLoggingSessionM13904a = this.f13656g.m13901a(this.f13653d).m13902a(liveAgentLoggingConfiguration).m13903a(podConnectionManagerM13916a).m13904a();
        this.f13651b.add(podConnectionManagerM13916a);
        this.f13652c.add(internalLiveAgentLoggingSessionM13904a);
        return this.f13654e.m13925a(internalLiveAgentLoggingSessionM13904a).m13926a();
    }

    /* JADX INFO: renamed from: a */
    public void m13934a() {
        m13932b();
        for (final InternalLiveAgentLoggingSession internalLiveAgentLoggingSession : this.f13652c) {
            internalLiveAgentLoggingSession.mo13889a().mo14072a(new Async.CompletionHandler() { // from class: com.salesforce.android.service.common.liveagentlogging.internal.service.LiveAgentLoggingServiceDelegate.2
                @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
                /* JADX INFO: renamed from: a */
                public void mo12580a(Async<?> async) {
                    internalLiveAgentLoggingSession.m13899c();
                }
            }).mo14073a(new Async.ErrorHandler() { // from class: com.salesforce.android.service.common.liveagentlogging.internal.service.LiveAgentLoggingServiceDelegate.1
                @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
                /* JADX INFO: renamed from: a */
                public void mo12581a(Async<?> async, Throwable th) {
                    LiveAgentLoggingServiceDelegate.f13650a.mo14195e("Error encountered while sending final logging events. {}", th.getMessage());
                    internalLiveAgentLoggingSession.m13899c();
                }
            });
        }
        f13650a.mo14188b("LiveAgentLoggingService has been destroyed");
    }
}
