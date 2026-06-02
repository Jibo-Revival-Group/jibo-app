package com.google.common.util.concurrent;

import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
abstract class SmoothRateLimiter extends RateLimiter {

    /* JADX INFO: renamed from: a */
    double f8586a;

    /* JADX INFO: renamed from: b */
    double f8587b;

    /* JADX INFO: renamed from: c */
    double f8588c;

    /* JADX INFO: renamed from: d */
    private long f8589d;

    /* JADX INFO: renamed from: a */
    abstract void mo9067a(double d, double d2);

    /* JADX INFO: renamed from: b */
    abstract long mo9069b(double d, double d2);

    /* JADX INFO: renamed from: d */
    abstract double mo9070d();

    static final class SmoothWarmingUp extends SmoothRateLimiter {

        /* JADX INFO: renamed from: d */
        private final long f8590d;

        /* JADX INFO: renamed from: e */
        private double f8591e;

        /* JADX INFO: renamed from: f */
        private double f8592f;

        /* JADX INFO: renamed from: g */
        private double f8593g;

        SmoothWarmingUp(RateLimiter.SleepingStopwatch sleepingStopwatch, long j, TimeUnit timeUnit, double d) {
            super(sleepingStopwatch);
            this.f8590d = timeUnit.toMicros(j);
            this.f8593g = d;
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        /* JADX INFO: renamed from: a */
        void mo9067a(double d, double d2) {
            double d3 = this.f8587b;
            double d4 = this.f8593g * d2;
            this.f8592f = (0.5d * this.f8590d) / d2;
            this.f8587b = this.f8592f + ((2.0d * this.f8590d) / (d2 + d4));
            this.f8591e = (d4 - d2) / (this.f8587b - this.f8592f);
            if (d3 == Double.POSITIVE_INFINITY) {
                this.f8586a = 0.0d;
            } else {
                this.f8586a = d3 == 0.0d ? this.f8587b : (this.f8586a * this.f8587b) / d3;
            }
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        /* JADX INFO: renamed from: b */
        long mo9069b(double d, double d2) {
            double d3 = d - this.f8592f;
            long jM9071b = 0;
            if (d3 > 0.0d) {
                double dMin = Math.min(d3, d2);
                jM9071b = (long) (((m9071b(d3) + m9071b(d3 - dMin)) * dMin) / 2.0d);
                d2 -= dMin;
            }
            return (long) (jM9071b + (this.f8588c * d2));
        }

        /* JADX INFO: renamed from: b */
        private double m9071b(double d) {
            return this.f8588c + (this.f8591e * d);
        }

        @Override // com.google.common.util.concurrent.SmoothRateLimiter
        /* JADX INFO: renamed from: d */
        double mo9070d() {
            return this.f8590d / this.f8587b;
        }
    }

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch) {
        super(sleepingStopwatch);
        this.f8589d = 0L;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    /* JADX INFO: renamed from: a */
    final void mo9059a(double d, long j) {
        m9068a(j);
        double micros = TimeUnit.SECONDS.toMicros(1L) / d;
        this.f8588c = micros;
        mo9067a(d, micros);
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    /* JADX INFO: renamed from: b */
    final double mo9060b() {
        return TimeUnit.SECONDS.toMicros(1L) / this.f8588c;
    }

    @Override // com.google.common.util.concurrent.RateLimiter
    /* JADX INFO: renamed from: b */
    final long mo9062b(int i, long j) {
        m9068a(j);
        long j2 = this.f8589d;
        double dMin = Math.min(i, this.f8586a);
        this.f8589d = LongMath.m9050a(this.f8589d, ((long) ((((double) i) - dMin) * this.f8588c)) + mo9069b(this.f8586a, dMin));
        this.f8586a -= dMin;
        return j2;
    }

    /* JADX INFO: renamed from: a */
    void m9068a(long j) {
        if (j > this.f8589d) {
            this.f8586a = Math.min(this.f8587b, ((j - this.f8589d) / mo9070d()) + this.f8586a);
            this.f8589d = j;
        }
    }
}
