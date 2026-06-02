package com.salesforce.android.service.common.liveagentclient.handler;

import com.salesforce.android.service.common.liveagentclient.LiveAgentClient;
import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentclient.SessionListener;
import com.salesforce.android.service.common.liveagentclient.SessionListenerNotifier;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentMetric;
import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequestFactory;
import com.salesforce.android.service.common.liveagentclient.response.MessagesResponse;
import com.salesforce.android.service.common.liveagentclient.response.message.AsyncResult;
import com.salesforce.android.service.common.liveagentclient.response.message.LiveAgentMessage;
import com.salesforce.android.service.common.liveagentclient.response.message.SwitchServerMessage;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.lifecycle.LifecycleEvaluator;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.HandlerManager;
import com.salesforce.android.service.common.utilities.threading.Timer;

/* JADX INFO: loaded from: classes.dex */
public class MessagesHandler implements SessionListener, Async.Handler<MessagesResponse>, HandlerManager.OnTimerElapsedListener {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f13528a = ServiceLogging.m14203a((Class<?>) MessagesHandler.class);

    /* JADX INFO: renamed from: b */
    private final LiveAgentClient f13529b;

    /* JADX INFO: renamed from: c */
    private final LiveAgentRequestFactory f13530c;

    /* JADX INFO: renamed from: d */
    private final SessionListenerNotifier f13531d;

    /* JADX INFO: renamed from: e */
    private final LifecycleEvaluator<LiveAgentState, LiveAgentMetric> f13532e;

    /* JADX INFO: renamed from: f */
    private final int f13533f;

    /* JADX INFO: renamed from: g */
    private final Timer f13534g;

    /* JADX INFO: renamed from: h */
    private SessionInfo f13535h;

    /* JADX INFO: renamed from: i */
    private boolean f13536i;

    /* JADX INFO: renamed from: j */
    private int f13537j;

    /* JADX INFO: renamed from: k */
    private int f13538k;

    @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
    /* JADX INFO: renamed from: a */
    public /* bridge */ /* synthetic */ void mo9875a(Async async, Object obj) {
        m13831a((Async<?>) async, (MessagesResponse) obj);
    }

    protected MessagesHandler(Builder builder) {
        this.f13529b = builder.f13540a;
        this.f13530c = builder.f13541b;
        this.f13531d = builder.f13542c.m13822a(this);
        this.f13532e = builder.f13543d;
        this.f13533f = builder.f13546g;
        this.f13534g = builder.f13544e.m14232a(this.f13533f).mo14221b(this).mo14222b();
        this.f13537j = builder.f13545f;
    }

    /* JADX INFO: renamed from: a */
    public void m13828a(int i) {
        this.f13537j = i / this.f13533f;
    }

    /* JADX INFO: renamed from: a */
    void m13827a() {
        if (this.f13535h != null) {
            this.f13529b.m13793a(this.f13530c.mo13863a(this.f13535h), MessagesResponse.class, this.f13535h.m13818d()).mo14077b(this);
        }
    }

    @Override // com.salesforce.android.service.common.liveagentclient.SessionListener
    /* JADX INFO: renamed from: a */
    public void mo13819a(SessionInfo sessionInfo) {
        this.f13535h = sessionInfo;
    }

    @Override // com.salesforce.android.service.common.liveagentclient.SessionListener
    /* JADX INFO: renamed from: a */
    public void mo13820a(LiveAgentState liveAgentState, LiveAgentState liveAgentState2) {
        switch (liveAgentState) {
            case LongPolling:
                m13827a();
                break;
            case Ended:
                this.f13535h = null;
                break;
        }
    }

    @Override // com.salesforce.android.service.common.liveagentclient.SessionListener
    /* JADX INFO: renamed from: a */
    public void mo13821a(Throwable th) {
    }

    /* JADX INFO: renamed from: a */
    public void m13831a(Async<?> async, MessagesResponse messagesResponse) {
        f13528a.mo14186a("LiveAgent heartbeat response (MessagesResponse) has been received");
        for (LiveAgentMessage liveAgentMessage : messagesResponse.m13871a()) {
            if (liveAgentMessage.m13875a().equals("SwitchServer")) {
                m13830a((SwitchServerMessage) liveAgentMessage.m13874a(SwitchServerMessage.class));
            } else if (liveAgentMessage.m13875a().equals("AsyncResult")) {
                m13829a((AsyncResult) liveAgentMessage.m13874a(AsyncResult.class));
            }
        }
        this.f13531d.mo13814a(messagesResponse);
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
    /* JADX INFO: renamed from: a */
    public void mo12580a(Async<?> async) {
        this.f13538k = 0;
        m13827a();
    }

    @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
    /* JADX INFO: renamed from: a */
    public void mo12581a(Async<?> async, Throwable th) {
        if (this.f13532e.m14172e() == LiveAgentState.LongPolling) {
            this.f13538k++;
            if (this.f13538k > this.f13537j) {
                f13528a.mo14195e("LiveAgent session has encountered an unrecoverable error while retrieving messages - {}", th);
                this.f13532e.m14166b().m14164a();
                this.f13531d.mo13821a(th);
            } else {
                f13528a.mo14193d("LiveAgent session is attempting to reconnect. Retry #{} of {}", Integer.valueOf(this.f13538k), Integer.valueOf(this.f13537j));
                this.f13534g.mo14214a();
            }
        }
    }

    @Override // com.salesforce.android.service.common.utilities.threading.HandlerManager.OnTimerElapsedListener
    /* JADX INFO: renamed from: b */
    public void mo13832b() {
        m13827a();
    }

    /* JADX INFO: renamed from: a */
    void m13830a(SwitchServerMessage switchServerMessage) {
        String strM13877b = switchServerMessage.m13877b();
        if (strM13877b == null) {
            f13528a.mo14192d("Failed to switch to a different LiveAgent Server: Address is null.");
            this.f13532e.m14166b().m14164a();
        } else {
            f13528a.mo14186a("Switching to a different LiveAgent Server: {}" + switchServerMessage.m13876a());
            this.f13529b.m13795a(strM13877b);
            this.f13532e.m14168c(LiveAgentMetric.ConnectionEstablished).m14164a();
        }
    }

    /* JADX INFO: renamed from: a */
    void m13829a(AsyncResult asyncResult) {
        if (asyncResult.m13872a() && this.f13536i) {
            f13528a.mo14195e("LiveAgent session has encountered an error while creating a session - {}", asyncResult.m13873b());
            this.f13532e.m14166b().m14164a();
            this.f13531d.mo13821a(new Exception(asyncResult.m13873b()));
        }
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected LiveAgentClient f13540a;

        /* JADX INFO: renamed from: b */
        protected LiveAgentRequestFactory f13541b;

        /* JADX INFO: renamed from: c */
        protected SessionListenerNotifier f13542c;

        /* JADX INFO: renamed from: d */
        protected LifecycleEvaluator<LiveAgentState, LiveAgentMetric> f13543d;

        /* JADX INFO: renamed from: e */
        protected Timer.Builder f13544e;

        /* JADX INFO: renamed from: f */
        protected int f13545f = 20;

        /* JADX INFO: renamed from: g */
        protected int f13546g = 2000;

        /* JADX INFO: renamed from: a */
        public Builder m13834a(LiveAgentClient liveAgentClient) {
            this.f13540a = liveAgentClient;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13836a(LiveAgentRequestFactory liveAgentRequestFactory) {
            this.f13541b = liveAgentRequestFactory;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13835a(SessionListenerNotifier sessionListenerNotifier) {
            this.f13542c = sessionListenerNotifier;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13837a(LifecycleEvaluator<LiveAgentState, LiveAgentMetric> lifecycleEvaluator) {
            this.f13543d = lifecycleEvaluator;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13833a(int i) {
            this.f13546g = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public MessagesHandler m13838a() {
            if (this.f13544e == null) {
                this.f13544e = new Timer.Builder();
            }
            return new MessagesHandler(this);
        }
    }
}
