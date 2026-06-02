package com.segment.analytics;

import com.yalantis.ucrop.view.CropImageView;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class StatsSnapshot {
    public final long flushCount;
    public final long flushEventCount;
    public final float integrationOperationAverageDuration;
    public final long integrationOperationCount;
    public final long integrationOperationDuration;
    public final Map<String, Long> integrationOperationDurationByIntegration;
    public final long timestamp;

    public StatsSnapshot(long j, long j2, long j3, long j4, long j5, Map<String, Long> map) {
        this.timestamp = j;
        this.flushCount = j2;
        this.flushEventCount = j3;
        this.integrationOperationCount = j4;
        this.integrationOperationDuration = j5;
        this.integrationOperationAverageDuration = j4 == 0 ? CropImageView.DEFAULT_ASPECT_RATIO : j5 / j4;
        this.integrationOperationDurationByIntegration = map;
    }

    public String toString() {
        return "StatsSnapshot{timestamp=" + this.timestamp + ", flushCount=" + this.flushCount + ", flushEventCount=" + this.flushEventCount + ", integrationOperationCount=" + this.integrationOperationCount + ", integrationOperationDuration=" + this.integrationOperationDuration + ", integrationOperationAverageDuration=" + this.integrationOperationAverageDuration + ", integrationOperationDurationByIntegration=" + this.integrationOperationDurationByIntegration + '}';
    }
}
