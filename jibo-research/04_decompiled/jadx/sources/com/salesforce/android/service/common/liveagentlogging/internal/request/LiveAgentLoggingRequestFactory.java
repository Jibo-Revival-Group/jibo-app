package com.salesforce.android.service.common.liveagentlogging.internal.request;

import com.salesforce.android.service.common.liveagentclient.SessionInfo;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface LiveAgentLoggingRequestFactory {
    /* JADX INFO: renamed from: a */
    BatchedEvents mo13923a(SessionInfo sessionInfo, List<BaseEvent> list);
}
