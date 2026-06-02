package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class LogTime {

    /* JADX INFO: renamed from: a */
    private static final double f5005a;

    static {
        f5005a = 17 <= Build.VERSION.SDK_INT ? 1.0d / Math.pow(10.0d, 6.0d) : 1.0d;
    }

    @TargetApi(17)
    /* JADX INFO: renamed from: a */
    public static long m5581a() {
        return 17 <= Build.VERSION.SDK_INT ? SystemClock.elapsedRealtimeNanos() : System.currentTimeMillis();
    }

    /* JADX INFO: renamed from: a */
    public static double m5580a(long j) {
        return (m5581a() - j) * f5005a;
    }
}
