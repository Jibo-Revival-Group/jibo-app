package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.internal.Backoff;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
class RandomBackoff implements Backoff {

    /* JADX INFO: renamed from: a */
    final Backoff f5061a;

    /* JADX INFO: renamed from: b */
    final Random f5062b;

    /* JADX INFO: renamed from: c */
    final double f5063c;

    public RandomBackoff(Backoff backoff, double d) {
        this(backoff, d, new Random());
    }

    public RandomBackoff(Backoff backoff, double d, Random random) {
        if (d < 0.0d || d > 1.0d) {
            throw new IllegalArgumentException("jitterPercent must be between 0.0 and 1.0");
        }
        if (backoff == null) {
            throw new NullPointerException("backoff must not be null");
        }
        if (random == null) {
            throw new NullPointerException("random must not be null");
        }
        this.f5061a = backoff;
        this.f5063c = d;
        this.f5062b = random;
    }

    @Override // io.fabric.sdk.android.services.concurrency.internal.Backoff
    /* JADX INFO: renamed from: a */
    public long mo5656a(int i) {
        return (long) (m5655a() * this.f5061a.mo5656a(i));
    }

    /* JADX INFO: renamed from: a */
    double m5655a() {
        double d = 1.0d - this.f5063c;
        return d + (((this.f5063c + 1.0d) - d) * this.f5062b.nextDouble());
    }
}
