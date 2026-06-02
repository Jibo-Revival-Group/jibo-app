package com.salesforce.android.service.common.liveagentlogging.internal.request;

import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class InternalLiveAgentLoggingRequestFactory implements LiveAgentLoggingRequestFactory {
    @Override // com.salesforce.android.service.common.liveagentlogging.internal.request.LiveAgentLoggingRequestFactory
    /* JADX INFO: renamed from: a */
    public BatchedEvents mo13923a(SessionInfo sessionInfo, List<BaseEvent> list) {
        return new BatchedEvents(sessionInfo.m13816b(), sessionInfo.m13817c(), list);
    }
}
