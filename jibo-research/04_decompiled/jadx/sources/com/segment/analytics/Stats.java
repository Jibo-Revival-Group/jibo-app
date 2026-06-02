package com.segment.analytics;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class Stats {
    private static final String STATS_THREAD_NAME = "Segment-Stats";
    long flushCount;
    long flushEventCount;
    final StatsHandler handler;
    long integrationOperationCount;
    long integrationOperationDuration;
    Map<String, Long> integrationOperationDurationByIntegration = new HashMap();
    final HandlerThread statsThread = new HandlerThread(STATS_THREAD_NAME, 10);

    Stats() {
        this.statsThread.start();
        this.handler = new StatsHandler(this.statsThread.getLooper(), this);
    }

    void shutdown() {
        this.statsThread.quit();
    }

    void dispatchFlush(int i) {
        this.handler.sendMessage(this.handler.obtainMessage(1, i, 0));
    }

    void performFlush(int i) {
        this.flushCount++;
        this.flushEventCount += (long) i;
    }

    void dispatchIntegrationOperation(String str, long j) {
        this.handler.sendMessage(this.handler.obtainMessage(2, new Pair(str, Long.valueOf(j))));
    }

    void performIntegrationOperation(Pair<String, Long> pair) {
        this.integrationOperationCount++;
        this.integrationOperationDuration = ((Long) pair.second).longValue() + this.integrationOperationDuration;
        Long l = this.integrationOperationDurationByIntegration.get(pair.first);
        if (l == null) {
            this.integrationOperationDurationByIntegration.put((String) pair.first, (Long) pair.second);
        } else {
            this.integrationOperationDurationByIntegration.put((String) pair.first, Long.valueOf(l.longValue() + ((Long) pair.second).longValue()));
        }
    }

    StatsSnapshot createSnapshot() {
        return new StatsSnapshot(System.currentTimeMillis(), this.flushCount, this.flushEventCount, this.integrationOperationCount, this.integrationOperationDuration, Collections.unmodifiableMap(this.integrationOperationDurationByIntegration));
    }

    private static class StatsHandler extends Handler {
        static final int TRACK_FLUSH = 1;
        static final int TRACK_INTEGRATION_OPERATION = 2;
        private final Stats stats;

        StatsHandler(Looper looper, Stats stats) {
            super(looper);
            this.stats = stats;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.stats.performFlush(message.arg1);
                    return;
                case 2:
                    this.stats.performIntegrationOperation((Pair) message.obj);
                    return;
                default:
                    throw new AssertionError("Unknown Stats handler message: " + message);
            }
        }
    }
}
