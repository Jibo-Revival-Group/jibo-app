package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public abstract class RateLimiter {

    /* JADX INFO: renamed from: a */
    private final SleepingStopwatch f8583a;

    /* JADX INFO: renamed from: b */
    private volatile Object f8584b;

    /* JADX INFO: renamed from: a */
    abstract void mo9059a(double d, long j);

    /* JADX INFO: renamed from: b */
    abstract double mo9060b();

    /* JADX INFO: renamed from: b */
    abstract long mo9062b(int i, long j);

    /* JADX INFO: renamed from: a */
    public static RateLimiter m9051a(double d, long j, TimeUnit timeUnit) {
        Preconditions.m9020a(j >= 0, "warmupPeriod must not be negative: %s", j);
        return m9052a(d, j, timeUnit, 3.0d, SleepingStopwatch.m9064b());
    }

    /* JADX INFO: renamed from: a */
    static RateLimiter m9052a(double d, long j, TimeUnit timeUnit, double d2, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothWarmingUp smoothWarmingUp = new SmoothRateLimiter.SmoothWarmingUp(sleepingStopwatch, j, timeUnit, d2);
        smoothWarmingUp.m9058a(d);
        return smoothWarmingUp;
    }

    /* JADX INFO: renamed from: d */
    private Object m9054d() {
        Object obj = this.f8584b;
        if (obj == null) {
            synchronized (this) {
                obj = this.f8584b;
                if (obj == null) {
                    obj = new Object();
                    this.f8584b = obj;
                }
            }
        }
        return obj;
    }

    RateLimiter(SleepingStopwatch sleepingStopwatch) {
        this.f8583a = (SleepingStopwatch) Preconditions.m9015a(sleepingStopwatch);
    }

    /* JADX INFO: renamed from: a */
    public final void m9058a(double d) {
        Preconditions.m9018a(d > 0.0d && !Double.isNaN(d), "rate must be positive");
        synchronized (m9054d()) {
            mo9059a(d, this.f8583a.mo9065a());
        }
    }

    /* JADX INFO: renamed from: a */
    public final double m9055a() {
        double dMo9060b;
        synchronized (m9054d()) {
            dMo9060b = mo9060b();
        }
        return dMo9060b;
    }

    /* JADX INFO: renamed from: c */
    public double m9063c() {
        return m9056a(1);
    }

    /* JADX INFO: renamed from: a */
    public double m9056a(int i) {
        long jM9061b = m9061b(i);
        this.f8583a.mo9066a(jM9061b);
        return (jM9061b * 1.0d) / TimeUnit.SECONDS.toMicros(1L);
    }

    /* JADX INFO: renamed from: b */
    final long m9061b(int i) {
        long jM9057a;
        m9053c(i);
        synchronized (m9054d()) {
            jM9057a = m9057a(i, this.f8583a.mo9065a());
        }
        return jM9057a;
    }

    /* JADX INFO: renamed from: a */
    final long m9057a(int i, long j) {
        return Math.max(mo9062b(i, j) - j, 0L);
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", Double.valueOf(m9055a()));
    }

    static abstract class SleepingStopwatch {
        /* JADX INFO: renamed from: a */
        protected abstract long mo9065a();

        /* JADX INFO: renamed from: a */
        protected abstract void mo9066a(long j);

        protected SleepingStopwatch() {
        }

        /* JADX INFO: renamed from: b */
        public static final SleepingStopwatch m9064b() {
            return new SleepingStopwatch() { // from class: com.google.common.util.concurrent.RateLimiter.SleepingStopwatch.1

                /* JADX INFO: renamed from: a */
                final Stopwatch f8585a = Stopwatch.m9037a();

                @Override // com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
                /* JADX INFO: renamed from: a */
                protected long mo9065a() {
                    return this.f8585a.m9041a(TimeUnit.MICROSECONDS);
                }

                @Override // com.google.common.util.concurrent.RateLimiter.SleepingStopwatch
                /* JADX INFO: renamed from: a */
                protected void mo9066a(long j) {
                    if (j > 0) {
                        Uninterruptibles.m9072a(j, TimeUnit.MICROSECONDS);
                    }
                }
            };
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m9053c(int i) {
        Preconditions.m9019a(i > 0, "Requested permits (%s) must be positive", i);
    }
}
