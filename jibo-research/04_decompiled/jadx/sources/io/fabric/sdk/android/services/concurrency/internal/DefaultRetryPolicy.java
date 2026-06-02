package io.fabric.sdk.android.services.concurrency.internal;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultRetryPolicy implements RetryPolicy {

    /* JADX INFO: renamed from: a */
    private final int f14659a;

    public DefaultRetryPolicy() {
        this(1);
    }

    public DefaultRetryPolicy(int i) {
        this.f14659a = i;
    }
}
