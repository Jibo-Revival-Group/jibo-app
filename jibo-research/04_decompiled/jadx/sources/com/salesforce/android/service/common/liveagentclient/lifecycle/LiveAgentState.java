package com.salesforce.android.service.common.liveagentclient.lifecycle;

import com.salesforce.android.service.common.utilities.lifecycle.LifecycleState;

/* JADX INFO: loaded from: classes.dex */
public enum LiveAgentState implements LifecycleState<LiveAgentMetric> {
    Initializing(LiveAgentMetric.Initiated),
    Connecting(LiveAgentMetric.ConnectionEstablished, LiveAgentMetric.SessionInfoReceived),
    LongPolling(LiveAgentMetric.Ending),
    Deleting(LiveAgentMetric.Deleted),
    Ended(new LiveAgentMetric[0]);

    private final LiveAgentMetric[] mMetrics;

    LiveAgentState(LiveAgentMetric... liveAgentMetricArr) {
        this.mMetrics = liveAgentMetricArr;
    }

    @Override // com.salesforce.android.service.common.utilities.lifecycle.LifecycleState
    public LiveAgentMetric[] getMetrics() {
        return this.mMetrics;
    }
}
