package com.salesforce.android.service.common.liveagentclient.integrity;

import android.content.Context;
import com.salesforce.android.service.common.liveagentclient.R;
import com.salesforce.android.service.common.liveagentclient.integrity.EnqueuedRequest;
import com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequest;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.threading.BackoffTimer;
import com.salesforce.android.service.common.utilities.threading.HandlerManager;
import com.salesforce.android.service.common.utilities.threading.Timer;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public class LiveAgentQueue implements HandlerManager.OnTimerElapsedListener {

    /* JADX INFO: renamed from: a */
    protected static final ServiceLogger f13551a = ServiceLogging.m14203a((Class<?>) LiveAgentQueue.class);

    /* JADX INFO: renamed from: c */
    private final HandlerManager f13553c;

    /* JADX INFO: renamed from: d */
    private final EnqueuedRequest.Factory f13554d;

    /* JADX INFO: renamed from: e */
    private LiveAgentQueueRequestListener f13555e;

    /* JADX INFO: renamed from: b */
    protected Queue<EnqueuedRequest> f13552b = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: f */
    private AtomicBoolean f13556f = new AtomicBoolean();

    LiveAgentQueue(Builder builder) {
        this.f13553c = builder.f13561a.mo14221b(this).mo14222b();
        this.f13554d = builder.f13562b;
        this.f13555e = builder.f13563c;
    }

    /* JADX INFO: renamed from: a */
    public void m13848a(LiveAgentQueueRequestListener liveAgentQueueRequestListener) {
        this.f13555e = liveAgentQueueRequestListener;
        m13851d();
    }

    /* JADX INFO: renamed from: a */
    public void m13846a() {
        f13551a.mo14191c("Clearing LiveAgentQueue and cancelling {} queued requests.", Integer.valueOf(this.f13552b.size()));
        this.f13553c.mo14215b();
        Iterator<EnqueuedRequest> it = this.f13552b.iterator();
        while (it.hasNext()) {
            it.next().m13843e();
        }
        this.f13552b.clear();
    }

    /* JADX INFO: renamed from: a */
    public <T> Async<T> m13845a(LiveAgentRequest liveAgentRequest, Class<T> cls) {
        f13551a.mo14189b("Queuing: {}", liveAgentRequest.getClass().getSimpleName());
        EnqueuedRequest<T> enqueuedRequestM13844a = this.f13554d.m13844a(liveAgentRequest, cls);
        this.f13552b.add(enqueuedRequestM13844a);
        m13851d();
        return enqueuedRequestM13844a.m13841c();
    }

    /* JADX INFO: renamed from: c */
    public boolean m13850c() {
        return this.f13556f.get();
    }

    /* JADX INFO: renamed from: d */
    void m13851d() {
        if (this.f13555e != null && this.f13552b.size() != 0 && !m13850c()) {
            this.f13556f.set(true);
            final EnqueuedRequest enqueuedRequestElement = this.f13552b.element();
            this.f13555e.mo13802a(enqueuedRequestElement.m13839a(), enqueuedRequestElement.m13840b()).mo14072a(new Async.CompletionHandler() { // from class: com.salesforce.android.service.common.liveagentclient.integrity.LiveAgentQueue.2
                @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
                /* JADX INFO: renamed from: a */
                public void mo12580a(Async<?> async) {
                    LiveAgentQueue.this.m13847a(enqueuedRequestElement);
                }
            }).mo14073a(new Async.ErrorHandler() { // from class: com.salesforce.android.service.common.liveagentclient.integrity.LiveAgentQueue.1
                @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
                /* JADX INFO: renamed from: a */
                public void mo12581a(Async<?> async, Throwable th) {
                    LiveAgentQueue.this.m13849b(enqueuedRequestElement);
                }
            });
        }
    }

    /* JADX INFO: renamed from: e */
    void m13852e() {
        this.f13556f.set(false);
        m13851d();
    }

    /* JADX INFO: renamed from: a */
    void m13847a(EnqueuedRequest enqueuedRequest) {
        this.f13552b.remove(enqueuedRequest);
        enqueuedRequest.m13841c().mo12613b();
        f13551a.mo14187a("Success in sending {}", enqueuedRequest);
        m13852e();
    }

    /* JADX INFO: renamed from: b */
    void m13849b(EnqueuedRequest enqueuedRequest) {
        enqueuedRequest.m13842d();
        f13551a.mo14193d("Error occurred while sending {}. Scheduling another attempt.", enqueuedRequest);
        this.f13553c.mo14214a();
    }

    @Override // com.salesforce.android.service.common.utilities.threading.HandlerManager.OnTimerElapsedListener
    /* JADX INFO: renamed from: b */
    public void mo13832b() {
        m13852e();
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        protected HandlerManager.Builder f13561a;

        /* JADX INFO: renamed from: b */
        protected EnqueuedRequest.Factory f13562b;

        /* JADX INFO: renamed from: c */
        protected LiveAgentQueueRequestListener f13563c;

        /* JADX INFO: renamed from: d */
        private Context f13564d;

        /* JADX INFO: renamed from: e */
        private boolean f13565e;

        /* JADX INFO: renamed from: f */
        private int f13566f = 5;

        /* JADX INFO: renamed from: a */
        public Builder m13853a(Context context) {
            this.f13564d = context;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13854a(boolean z) {
            this.f13565e = z;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public LiveAgentQueue m13855a() {
            Arguments.m14235a(this.f13564d);
            if (this.f13565e && this.f13561a == null) {
                this.f13561a = new BackoffTimer.Builder().m14218a(this.f13566f);
            } else if (this.f13561a == null) {
                this.f13561a = new Timer.Builder().m14232a(this.f13564d.getResources().getInteger(R.integer.salesforce_live_agent_message_retry_timeout_ms));
            }
            if (this.f13562b == null) {
                this.f13562b = new EnqueuedRequest.Factory();
            }
            return new LiveAgentQueue(this);
        }
    }
}
