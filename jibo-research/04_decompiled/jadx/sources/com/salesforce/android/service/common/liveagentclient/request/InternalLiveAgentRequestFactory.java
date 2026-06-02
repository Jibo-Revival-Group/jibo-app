package com.salesforce.android.service.common.liveagentclient.request;

import com.salesforce.android.service.common.liveagentclient.SessionInfo;

/* JADX INFO: loaded from: classes.dex */
public class InternalLiveAgentRequestFactory implements LiveAgentRequestFactory {
    @Override // com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequestFactory
    /* JADX INFO: renamed from: a */
    public CreateSessionRequest mo13862a() {
        return new CreateSessionRequest();
    }

    @Override // com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequestFactory
    /* JADX INFO: renamed from: a */
    public MessagesRequest mo13863a(SessionInfo sessionInfo) {
        return new MessagesRequest(sessionInfo.m13816b(), sessionInfo.m13817c());
    }

    @Override // com.salesforce.android.service.common.liveagentclient.request.LiveAgentRequestFactory
    /* JADX INFO: renamed from: b */
    public DeleteSessionRequest mo13864b(SessionInfo sessionInfo) {
        return new DeleteSessionRequest(sessionInfo.m13816b(), sessionInfo.m13817c());
    }
}
