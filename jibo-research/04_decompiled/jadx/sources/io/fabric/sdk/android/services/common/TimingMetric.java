package io.fabric.sdk.android.services.common;

import android.os.SystemClock;
import android.util.Log;

/* JADX INFO: loaded from: classes2.dex */
public class TimingMetric {

    /* JADX INFO: renamed from: a */
    private final String f14615a;

    /* JADX INFO: renamed from: b */
    private final String f14616b;

    /* JADX INFO: renamed from: c */
    private final boolean f14617c;

    /* JADX INFO: renamed from: d */
    private long f14618d;

    /* JADX INFO: renamed from: e */
    private long f14619e;

    public TimingMetric(String str, String str2) {
        this.f14615a = str;
        this.f14616b = str2;
        this.f14617c = !Log.isLoggable(str2, 2);
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m15268a() {
        if (!this.f14617c) {
            this.f14618d = SystemClock.elapsedRealtime();
            this.f14619e = 0L;
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m15269b() {
        if (!this.f14617c && this.f14619e == 0) {
            this.f14619e = SystemClock.elapsedRealtime() - this.f14618d;
            m15267c();
        }
    }

    /* JADX INFO: renamed from: c */
    private void m15267c() {
        Log.v(this.f14616b, this.f14615a + ": " + this.f14619e + "ms");
    }
}
