package io.fabric.sdk.android.services.concurrency.internal;

/* JADX INFO: loaded from: classes2.dex */
public class ExponentialBackoff implements Backoff {

    /* JADX INFO: renamed from: a */
    private final long f14660a;

    /* JADX INFO: renamed from: b */
    private final int f14661b;

    public ExponentialBackoff(long j, int i) {
        this.f14660a = j;
        this.f14661b = i;
    }

    @Override // io.fabric.sdk.android.services.concurrency.internal.Backoff
    /* JADX INFO: renamed from: a */
    public long mo5656a(int i) {
        return (long) (this.f14660a * Math.pow(this.f14661b, i));
    }
}
