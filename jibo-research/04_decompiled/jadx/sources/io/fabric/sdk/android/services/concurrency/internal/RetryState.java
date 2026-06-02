package io.fabric.sdk.android.services.concurrency.internal;

/* JADX INFO: loaded from: classes2.dex */
public class RetryState {

    /* JADX INFO: renamed from: a */
    private final int f14662a;

    /* JADX INFO: renamed from: b */
    private final Backoff f14663b;

    /* JADX INFO: renamed from: c */
    private final RetryPolicy f14664c;

    public RetryState(Backoff backoff, RetryPolicy retryPolicy) {
        this(0, backoff, retryPolicy);
    }

    public RetryState(int i, Backoff backoff, RetryPolicy retryPolicy) {
        this.f14662a = i;
        this.f14663b = backoff;
        this.f14664c = retryPolicy;
    }

    /* JADX INFO: renamed from: a */
    public long m15313a() {
        return this.f14663b.mo5656a(this.f14662a);
    }

    /* JADX INFO: renamed from: b */
    public RetryState m15314b() {
        return new RetryState(this.f14662a + 1, this.f14663b, this.f14664c);
    }

    /* JADX INFO: renamed from: c */
    public RetryState m15315c() {
        return new RetryState(this.f14663b, this.f14664c);
    }
}
