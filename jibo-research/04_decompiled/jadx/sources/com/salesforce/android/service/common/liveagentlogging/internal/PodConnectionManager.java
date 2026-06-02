package com.salesforce.android.service.common.liveagentlogging.internal;

import android.content.Context;
import android.support.v4.util.ArraySet;
import com.google.gson.GsonBuilder;
import com.salesforce.android.service.common.liveagentclient.LiveAgentClient;
import com.salesforce.android.service.common.liveagentclient.LiveAgentSession;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionListener;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.internal.PodProvider;
import com.salesforce.android.service.common.liveagentlogging.internal.json.BaseEventSerializer;
import com.salesforce.android.service.common.liveagentlogging.internal.json.BatchedEventsSerializer;
import com.salesforce.android.service.common.liveagentlogging.internal.request.BatchedEvents;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectionInfo;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityState;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityTracker;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.lang.reflect.Type;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class PodConnectionManager implements SessionListener, ConnectivityTracker.Listener {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f13615a = ServiceLogging.m14203a((Class<?>) PodConnectionManager.class);

    /* JADX INFO: renamed from: b */
    private final PodProvider f13616b;

    /* JADX INFO: renamed from: c */
    private final LiveAgentClient.Builder f13617c;

    /* JADX INFO: renamed from: d */
    private final LiveAgentSession.Builder f13618d;

    /* JADX INFO: renamed from: e */
    private final ConnectivityTracker f13619e;

    /* JADX INFO: renamed from: f */
    private final GsonBuilder f13620f;

    /* JADX INFO: renamed from: g */
    private Set<Listener> f13621g = new ArraySet();

    /* JADX INFO: renamed from: h */
    private LiveAgentSession f13622h;

    /* JADX INFO: renamed from: i */
    private SessionInfo f13623i;

    /* JADX INFO: renamed from: j */
    private String f13624j;

    interface Listener {
        /* JADX INFO: renamed from: a */
        void mo13897a(LiveAgentSession liveAgentSession, SessionInfo sessionInfo);

        /* JADX INFO: renamed from: d */
        void mo13900d();
    }

    protected PodConnectionManager(Builder builder) {
        this.f13616b = builder.f13627c;
        this.f13617c = builder.f13628d;
        this.f13618d = builder.f13629e;
        this.f13619e = builder.f13630f.m14140a(this).m14141a();
        this.f13620f = builder.f13631g;
        m13907d();
    }

    /* JADX INFO: renamed from: a */
    public boolean m13910a() {
        return (this.f13622h == null || this.f13623i == null) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    public void m13912b() {
        this.f13619e.m14138c();
    }

    /* JADX INFO: renamed from: c */
    public void m13913c() {
        if (this.f13622h != null) {
            this.f13622h.m13810b();
        }
    }

    /* JADX INFO: renamed from: a */
    public PodConnectionManager m13909a(Listener listener) {
        this.f13621g.add(listener);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public PodConnectionManager m13911b(Listener listener) {
        this.f13621g.remove(listener);
        return this;
    }

    /* JADX INFO: renamed from: d */
    private void m13907d() {
        if (this.f13619e.m14135a() != ConnectivityState.CONNECTED) {
            f13615a.mo14190c("Unable to connect to a LiveAgent Logging pod because the network is not connected. Waiting for network to be restored...");
            return;
        }
        try {
            this.f13624j = this.f13616b.m13917a();
            f13615a.mo14191c("Attempting to create a LiveAgent Logging session on pod {}", this.f13624j);
            this.f13622h = m13905a(this.f13624j);
        } catch (AllPodsUnavailableException e) {
            f13615a.mo14194e("Unable to connect to any LiveAgent pod for Logging. Logging has failed.");
            m13908e();
        } catch (GeneralSecurityException e2) {
            f13615a.mo14193d("Unable to connect to the LiveAgent pod {} for Logging. Trying another pod.\n{}", this.f13624j, e2.getMessage());
            this.f13616b.m13918a(this.f13624j);
            m13907d();
        }
    }

    /* JADX INFO: renamed from: a */
    private LiveAgentSession m13905a(String str) throws GeneralSecurityException {
        this.f13622h = this.f13618d.m13812a(this.f13617c.m13797a(str).m13796a(this.f13620f).m13798a()).m13813a();
        this.f13622h.m13801a(this);
        this.f13622h.m13803a();
        return this.f13622h;
    }

    @Override // com.salesforce.android.service.common.liveagentclient.SessionListener
    /* JADX INFO: renamed from: a */
    public void mo13819a(SessionInfo sessionInfo) {
        this.f13623i = sessionInfo;
        m13906a(this.f13622h, this.f13623i);
    }

    @Override // com.salesforce.android.service.common.liveagentclient.SessionListener
    /* JADX INFO: renamed from: a */
    public void mo13820a(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
        if (liveAgentState == LiveAgentState.Ended && this.f13622h != null) {
            this.f13622h.m13809b(this);
        }
    }

    @Override // com.salesforce.android.service.common.liveagentclient.SessionListener
    /* JADX INFO: renamed from: a */
    public void mo13821a(Throwable th) {
        ServiceLogger serviceLogger = f13615a;
        Object[] objArr = new Object[3];
        objArr[0] = this.f13624j;
        objArr[1] = this.f13623i != null ? this.f13623i.m13815a() : "UNKNOWN";
        objArr[2] = th.getMessage();
        serviceLogger.mo14195e("Error encountered during LiveAgent Logging session [Pod - {}, LiveAgent Session ID - {}]\n{}", objArr);
        if (this.f13622h != null) {
            this.f13622h.m13810b();
        }
        m13907d();
    }

    @Override // com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityTracker.Listener
    /* JADX INFO: renamed from: a */
    public void mo13027a(ConnectionInfo connectionInfo, ConnectivityState connectivityState, ConnectivityState connectivityState2) {
        if (!m13910a() && connectivityState == ConnectivityState.CONNECTED) {
            f13615a.mo14186a("Network connection has been restored. Retrying LiveAgent Logging connection.");
            m13907d();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m13906a(LiveAgentSession liveAgentSession, SessionInfo sessionInfo) {
        Iterator<Listener> it = this.f13621g.iterator();
        while (it.hasNext()) {
            it.next().mo13897a(liveAgentSession, sessionInfo);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m13908e() {
        Iterator<Listener> it = this.f13621g.iterator();
        while (it.hasNext()) {
            it.next().mo13900d();
        }
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected Context f13625a;

        /* JADX INFO: renamed from: b */
        protected LiveAgentLoggingConfiguration f13626b;

        /* JADX INFO: renamed from: c */
        protected PodProvider f13627c;

        /* JADX INFO: renamed from: d */
        protected LiveAgentClient.Builder f13628d;

        /* JADX INFO: renamed from: e */
        protected LiveAgentSession.Builder f13629e;

        /* JADX INFO: renamed from: f */
        protected ConnectivityTracker.Builder f13630f;

        /* JADX INFO: renamed from: g */
        protected GsonBuilder f13631g;

        /* JADX INFO: renamed from: a */
        public Builder m13914a(Context context) {
            this.f13625a = context;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13915a(LiveAgentLoggingConfiguration liveAgentLoggingConfiguration) {
            this.f13626b = liveAgentLoggingConfiguration;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public PodConnectionManager m13916a() {
            Arguments.m14235a(this.f13625a);
            Arguments.m14235a(this.f13626b);
            if (this.f13627c == null) {
                this.f13627c = new PodProvider.Builder().m13919a(this.f13626b.m13883a()).m13920a();
            }
            if (this.f13628d == null) {
                this.f13628d = new LiveAgentClient.Builder();
            }
            if (this.f13629e == null) {
                this.f13629e = new LiveAgentSession.Builder().m13811a(this.f13625a);
            }
            if (this.f13630f == null) {
                this.f13630f = new ConnectivityTracker.Builder();
            }
            if (this.f13631g == null) {
                this.f13631g = new GsonBuilder().m9380a((Type) BaseEvent.class, (Object) new BaseEventSerializer()).m9380a((Type) BatchedEvents.class, (Object) new BatchedEventsSerializer()).m9379a("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            }
            this.f13630f.m14139a(this.f13625a);
            return new PodConnectionManager(this);
        }
    }
}
