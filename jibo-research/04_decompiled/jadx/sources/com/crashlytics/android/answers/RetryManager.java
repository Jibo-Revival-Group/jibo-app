package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.internal.RetryState;

/* JADX INFO: loaded from: classes.dex */
class RetryManager {

    /* JADX INFO: renamed from: a */
    long f5064a;

    /* JADX INFO: renamed from: b */
    private RetryState f5065b;

    public RetryManager(RetryState retryState) {
        if (retryState == null) {
            throw new NullPointerException("retryState must not be null");
        }
        this.f5065b = retryState;
    }

    /* JADX INFO: renamed from: a */
    public boolean m5658a(long j) {
        return j - this.f5064a >= 1000000 * this.f5065b.m15313a();
    }

    /* JADX INFO: renamed from: b */
    public void m5659b(long j) {
        this.f5064a = j;
        this.f5065b = this.f5065b.m15314b();
    }

    /* JADX INFO: renamed from: a */
    public void m5657a() {
        this.f5064a = 0L;
        this.f5065b = this.f5065b.m15315c();
    }
}
