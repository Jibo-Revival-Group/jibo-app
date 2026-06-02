package com.firebase.jobdispatcher;

/* JADX INFO: loaded from: classes.dex */
public final class RetryStrategy {

    /* JADX INFO: renamed from: a */
    public static final RetryStrategy f5784a = new RetryStrategy(1, 30, 3600);

    /* JADX INFO: renamed from: b */
    public static final RetryStrategy f5785b = new RetryStrategy(2, 30, 3600);

    /* JADX INFO: renamed from: c */
    private final int f5786c;

    /* JADX INFO: renamed from: d */
    private final int f5787d;

    /* JADX INFO: renamed from: e */
    private final int f5788e;

    RetryStrategy(int i, int i2, int i3) {
        this.f5786c = i;
        this.f5787d = i2;
        this.f5788e = i3;
    }

    /* JADX INFO: renamed from: a */
    public int m6639a() {
        return this.f5786c;
    }

    /* JADX INFO: renamed from: b */
    public int m6640b() {
        return this.f5787d;
    }

    /* JADX INFO: renamed from: c */
    public int m6641c() {
        return this.f5788e;
    }

    static final class Builder {

        /* JADX INFO: renamed from: a */
        private final ValidationEnforcer f5789a;

        Builder(ValidationEnforcer validationEnforcer) {
            this.f5789a = validationEnforcer;
        }
    }
}
