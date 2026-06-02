package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.internal.DefaultRetryPolicy;
import io.fabric.sdk.android.services.concurrency.internal.ExponentialBackoff;
import io.fabric.sdk.android.services.concurrency.internal.RetryState;
import io.fabric.sdk.android.services.events.FilesSender;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class AnswersRetryFilesSender implements FilesSender {

    /* JADX INFO: renamed from: a */
    private final SessionAnalyticsFilesSender f5040a;

    /* JADX INFO: renamed from: b */
    private final RetryManager f5041b;

    /* JADX INFO: renamed from: a */
    public static AnswersRetryFilesSender m5637a(SessionAnalyticsFilesSender sessionAnalyticsFilesSender) {
        return new AnswersRetryFilesSender(sessionAnalyticsFilesSender, new RetryManager(new RetryState(new RandomBackoff(new ExponentialBackoff(1000L, 8), 0.1d), new DefaultRetryPolicy(5))));
    }

    AnswersRetryFilesSender(SessionAnalyticsFilesSender sessionAnalyticsFilesSender, RetryManager retryManager) {
        this.f5040a = sessionAnalyticsFilesSender;
        this.f5041b = retryManager;
    }

    @Override // io.fabric.sdk.android.services.events.FilesSender
    /* JADX INFO: renamed from: a */
    public boolean mo5638a(List<File> list) {
        long jNanoTime = System.nanoTime();
        if (!this.f5041b.m5658a(jNanoTime)) {
            return false;
        }
        if (this.f5040a.mo5638a(list)) {
            this.f5041b.m5657a();
            return true;
        }
        this.f5041b.m5659b(jNanoTime);
        return false;
    }
}
