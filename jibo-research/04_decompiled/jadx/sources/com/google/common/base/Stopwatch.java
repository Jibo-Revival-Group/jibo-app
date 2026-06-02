package com.google.common.base;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class Stopwatch {

    /* JADX INFO: renamed from: a */
    private final Ticker f8570a = Ticker.m9043b();

    /* JADX INFO: renamed from: b */
    private boolean f8571b;

    /* JADX INFO: renamed from: c */
    private long f8572c;

    /* JADX INFO: renamed from: d */
    private long f8573d;

    /* JADX INFO: renamed from: a */
    public static Stopwatch m9037a() {
        return new Stopwatch().m9042b();
    }

    Stopwatch() {
    }

    /* JADX INFO: renamed from: b */
    public Stopwatch m9042b() {
        Preconditions.m9023b(!this.f8571b, "This stopwatch is already running.");
        this.f8571b = true;
        this.f8573d = this.f8570a.mo9044a();
        return this;
    }

    /* JADX INFO: renamed from: c */
    private long m9040c() {
        return this.f8571b ? (this.f8570a.mo9044a() - this.f8573d) + this.f8572c : this.f8572c;
    }

    /* JADX INFO: renamed from: a */
    public long m9041a(TimeUnit timeUnit) {
        return timeUnit.convert(m9040c(), TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long jM9040c = m9040c();
        return Platform.m9011a(jM9040c / TimeUnit.NANOSECONDS.convert(1L, r2)) + " " + m9039b(m9038a(jM9040c));
    }

    /* JADX INFO: renamed from: a */
    private static TimeUnit m9038a(long j) {
        if (TimeUnit.DAYS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.DAYS;
        }
        if (TimeUnit.HOURS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.HOURS;
        }
        if (TimeUnit.MINUTES.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MINUTES;
        }
        if (TimeUnit.SECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.SECONDS;
        }
        if (TimeUnit.MILLISECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MILLISECONDS;
        }
        if (TimeUnit.MICROSECONDS.convert(j, TimeUnit.NANOSECONDS) > 0) {
            return TimeUnit.MICROSECONDS;
        }
        return TimeUnit.NANOSECONDS;
    }

    /* JADX INFO: renamed from: com.google.common.base.Stopwatch$1 */
    static /* synthetic */ class C07011 {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f8574a = new int[TimeUnit.values().length];

        static {
            try {
                f8574a[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8574a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8574a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8574a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f8574a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f8574a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f8574a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static String m9039b(TimeUnit timeUnit) {
        switch (C07011.f8574a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }
}
