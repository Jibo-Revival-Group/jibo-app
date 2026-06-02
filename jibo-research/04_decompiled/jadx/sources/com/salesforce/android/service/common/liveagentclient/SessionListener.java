package com.salesforce.android.service.common.liveagentclient;

import com.salesforce.android.service.common.liveagentclient.lifecycle.LiveAgentState;

/* JADX INFO: loaded from: classes.dex */
public interface SessionListener {
    /* JADX INFO: renamed from: a */
    void mo13819a(SessionInfo sessionInfo);

    /* JADX INFO: renamed from: a */
    void mo13820a(LiveAgentState liveAgentState, LiveAgentState liveAgentState2);

    /* JADX INFO: renamed from: a */
    void mo13821a(Throwable th);
}
