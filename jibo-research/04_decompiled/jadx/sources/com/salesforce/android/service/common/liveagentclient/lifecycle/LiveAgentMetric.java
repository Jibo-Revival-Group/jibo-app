package com.salesforce.android.service.common.liveagentclient.lifecycle;

import com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetric;
import com.segment.analytics.internal.Utils;

/* JADX INFO: loaded from: classes.dex */
public enum LiveAgentMetric implements LifecycleMetric {
    Initiated,
    SessionInfoReceived,
    ConnectionEstablished(Utils.DEFAULT_FLUSH_INTERVAL),
    Ending,
    Deleted;

    private int mTimeoutMs;

    LiveAgentMetric(int i) {
        this.mTimeoutMs = i;
    }

    @Override // com.salesforce.android.service.common.utilities.lifecycle.LifecycleMetric
    public Integer getTimeoutMs() {
        return Integer.valueOf(this.mTimeoutMs);
    }
}
