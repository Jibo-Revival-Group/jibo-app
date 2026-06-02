package com.salesforce.android.service.common.liveagentclient;

import android.content.Context;
import com.salesforce.android.service.common.liveagentclient.handler.CreateSessionHandler;
import com.salesforce.android.service.common.liveagentclient.handler.DeleteSessionHandler;
import com.salesforce.android.service.common.liveagentclient.handler.MessagesHandler;
import com.salesforce.android.service.common.liveagentclient.integrity.LiveAgentQueueRequestListener;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentMetric;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.request.InternalLiveAgentRequestFactory;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequestFactory;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleEvaluator;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleListener;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class LiveAgentSession implements LiveAgentQueueRequestListener, LifecycleListener<LiveAgentState, LiveAgentMetric> {

    /* JADX INFO: renamed from: a */
    protected static final ServiceLogger f13491a = ServiceLogging.m14203a((Class<?>) LiveAgentSession.class);

    /* JADX INFO: renamed from: b */
    protected AtomicInteger f13492b = new AtomicInteger();

    /* JADX INFO: renamed from: c */
    private final LiveAgentClient f13493c;

    /* JADX INFO: renamed from: d */
    private final LifecycleEvaluator<LiveAgentState, LiveAgentMetric> f13494d;

    /* JADX INFO: renamed from: e */
    private final SessionListenerNotifier f13495e;

    /* JADX INFO: renamed from: f */
    private final MessagesHandler f13496f;

    /* JADX INFO: renamed from: g */
    private final CreateSessionHandler f13497g;

    /* JADX INFO: renamed from: h */
    private final DeleteSessionHandler f13498h;

    LiveAgentSession(Builder builder) {
        this.f13493c = builder.f13500a;
        this.f13495e = builder.f13502c;
        this.f13497g = builder.f13503d;
        this.f13496f = builder.f13504e;
        this.f13498h = builder.f13505f;
        this.f13494d = builder.f13501b.m14162a(LiveAgentState.Deleting);
        this.f13494d.m14165a(this);
    }

    /* JADX INFO: renamed from: a */
    public LiveAgentSession m13801a(SessionListener sessionListener) {
        this.f13495e.m13822a(sessionListener);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public LiveAgentSession m13809b(SessionListener sessionListener) {
        this.f13495e.m13823b(sessionListener);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m13803a() {
        this.f13494d.m14167b(LiveAgentMetric.Initiated).m14164a();
    }

    /* JADX INFO: renamed from: b */
    public void m13810b() {
        this.f13494d.m14166b().m14164a();
    }

    /* JADX INFO: renamed from: a */
    public void m13804a(int i) {
        if (i > 0) {
            this.f13496f.m13828a(i);
        }
    }

    @Override // com.salesforce.android.service.common.liveagentclient.integrity.LiveAgentQueueRequestListener
    /* JADX INFO: renamed from: a */
    public <T> Async<T> mo13802a(LiveAgentRequest liveAgentRequest, Class<T> cls) {
        int iIncrementAndGet = this.f13492b.incrementAndGet();
        f13491a.mo14189b("Handling pending request #{}, {}", Integer.valueOf(iIncrementAndGet), liveAgentRequest.getClass().getSimpleName());
        return this.f13493c.m13792a(liveAgentRequest, (Class) cls, iIncrementAndGet).mo14073a(new Async.ErrorHandler() { // from class: com.salesforce.android.service.common.liveagentclient.LiveAgentSession.1
            @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
            /* JADX INFO: renamed from: a */
            public void mo12581a(Async<?> async, Throwable th) {
                LiveAgentSession.this.f13492b.decrementAndGet();
            }
        });
    }

    @Override // com.salesforce.android.service.common.utilities.lifecycle.LifecycleListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo13808a(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
        if (liveAgentState == LiveAgentState.Connecting) {
            f13491a.mo14190c("Creating LiveAgent Session...");
        } else if (liveAgentState == LiveAgentState.LongPolling) {
            f13491a.mo14190c("Starting LiveAgent heartbeat (Long polling, MessagesRequest)");
        } else if (liveAgentState == LiveAgentState.Deleting) {
            f13491a.mo14190c("Ending LiveAgent Session");
        } else if (liveAgentState == LiveAgentState.Ended) {
            f13491a.mo14190c("LiveAgent Session has ended");
        }
        this.f13495e.mo13820a(liveAgentState, liveAgentState2);
    }

    @Override // com.salesforce.android.service.common.utilities.lifecycle.LifecycleListener
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo13807a(LiveAgentMetric liveAgentMetric) {
        this.f13494d.m14166b().m14164a();
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected LiveAgentClient f13500a;

        /* JADX INFO: renamed from: b */
        protected LifecycleEvaluator<LiveAgentState, LiveAgentMetric> f13501b;

        /* JADX INFO: renamed from: c */
        protected SessionListenerNotifier f13502c;

        /* JADX INFO: renamed from: d */
        protected CreateSessionHandler f13503d;

        /* JADX INFO: renamed from: e */
        protected MessagesHandler f13504e;

        /* JADX INFO: renamed from: f */
        protected DeleteSessionHandler f13505f;

        /* JADX INFO: renamed from: g */
        protected LiveAgentRequestFactory f13506g = new InternalLiveAgentRequestFactory();

        /* JADX INFO: renamed from: h */
        private Context f13507h;

        /* JADX INFO: renamed from: a */
        public Builder m13811a(Context context) {
            this.f13507h = context;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13812a(LiveAgentClient liveAgentClient) {
            this.f13500a = liveAgentClient;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public LiveAgentSession m13813a() {
            Arguments.m14235a(this.f13507h);
            Arguments.m14235a(this.f13500a);
            int integer = this.f13507h.getResources().getInteger(R.integer.salesforce_live_agent_message_retry_timeout_ms);
            if (this.f13501b == null) {
                this.f13501b = new LifecycleEvaluator.Builder().m14177a(LiveAgentState.class, LiveAgentMetric.class);
            }
            if (this.f13502c == null) {
                this.f13502c = new SessionListenerNotifier();
            }
            if (this.f13503d == null) {
                this.f13503d = new CreateSessionHandler(this.f13500a, this.f13506g, this.f13502c, this.f13501b);
            }
            if (this.f13504e == null) {
                this.f13504e = new MessagesHandler.Builder().m13834a(this.f13500a).m13836a(this.f13506g).m13835a(this.f13502c).m13837a(this.f13501b).m13833a(integer).m13838a();
            }
            if (this.f13505f == null) {
                this.f13505f = new DeleteSessionHandler(this.f13500a, this.f13506g, this.f13502c, this.f13501b);
            }
            return new LiveAgentSession(this);
        }
    }
}
