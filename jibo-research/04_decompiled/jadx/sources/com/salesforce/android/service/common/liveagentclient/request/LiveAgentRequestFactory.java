package com.salesforce.android.service.common.liveagentclient.request;

import com.salesforce.android.service.common.liveagentclient.SessionInfo;

/* JADX INFO: loaded from: classes.dex */
public interface LiveAgentRequestFactory {
    /* JADX INFO: renamed from: a */
    CreateSessionRequest mo13862a();

    /* JADX INFO: renamed from: a */
    MessagesRequest mo13863a(SessionInfo sessionInfo);

    /* JADX INFO: renamed from: b */
    DeleteSessionRequest mo13864b(SessionInfo sessionInfo);
}
