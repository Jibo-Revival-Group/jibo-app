package com.google.android.gms.internal;

import android.util.Log;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
final class zzewj {

    /* JADX INFO: renamed from: a */
    private static final long f7877a = TimeUnit.MINUTES.toMicros(1);

    /* JADX INFO: renamed from: b */
    private long f7878b;

    /* JADX INFO: renamed from: c */
    private long f7879c;

    /* JADX INFO: renamed from: d */
    private zzewn f7880d = new zzewn();

    /* JADX INFO: renamed from: e */
    private long f7881e;

    /* JADX INFO: renamed from: f */
    private final zzewk f7882f;

    /* JADX INFO: renamed from: g */
    private long f7883g;

    /* JADX INFO: renamed from: h */
    private long f7884h;

    /* JADX INFO: renamed from: i */
    private long f7885i;

    /* JADX INFO: renamed from: j */
    private long f7886j;

    /* JADX INFO: renamed from: k */
    private final boolean f7887k;

    /* JADX WARN: Removed duplicated region for block: B:34:0x0152 A[PHI: r2
      0x0152: PHI (r2v3 long) = (r2v2 long), (r2v41 long) binds: [B:3:0x0036, B:5:0x004c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    zzewj(long r14, long r16, com.google.android.gms.internal.zzewk r18, java.util.Map<java.lang.String, java.lang.Long> r19, com.google.android.gms.internal.zzewi r20, boolean r21) {
        /*
            Method dump skipped, instruction units count: 341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzewj.<init>(long, long, com.google.android.gms.internal.zzewk, java.util.Map, com.google.android.gms.internal.zzewi, boolean):void");
    }

    /* JADX INFO: renamed from: a */
    final synchronized void m8597a(boolean z) {
        this.f7879c = z ? this.f7883g : this.f7885i;
        this.f7878b = z ? this.f7884h : this.f7886j;
    }

    /* JADX INFO: renamed from: a */
    final synchronized boolean m8598a(zzewx zzewxVar) {
        boolean z;
        zzewn zzewnVar = new zzewn();
        this.f7881e = Math.min(Math.max(0L, (this.f7880d.m8599a(zzewnVar) * this.f7879c) / f7877a) + this.f7881e, this.f7878b);
        if (this.f7881e > 0) {
            this.f7881e--;
            this.f7880d = zzewnVar;
            z = true;
        } else {
            if (this.f7887k) {
                Log.w("FirebasePerformance", "Exceeded log rate limit, dropping the log.");
            }
            z = false;
        }
        return z;
    }
}
