package com.salesforce.android.service.common.liveagentlogging;

import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.internal.response.BatchedEventsResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import java.util.Collection;

/* JADX INFO: loaded from: classes.dex */
public interface LiveAgentLoggingSession {

    public interface Listener {
        /* JADX INFO: renamed from: a */
        void mo13026a(Async<BatchedEventsResponse> async);

        /* JADX INFO: renamed from: c */
        void mo13031c();

        /* JADX INFO: renamed from: d */
        void mo13032d();
    }

    /* JADX INFO: renamed from: a */
    LiveAgentLoggingSession mo13888a(Listener listener);

    /* JADX INFO: renamed from: a */
    Async<BatchedEventsResponse> mo13889a();

    /* JADX INFO: renamed from: a */
    void mo13890a(BaseEvent baseEvent);

    /* JADX INFO: renamed from: a */
    void mo13891a(Collection<? extends BaseEvent> collection);
}
