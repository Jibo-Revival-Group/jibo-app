package com.google.android.gms.common.util;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public final class zzh implements zzd {

    /* JADX INFO: renamed from: a */
    private static zzh f6690a = new zzh();

    private zzh() {
    }

    /* JADX INFO: renamed from: d */
    public static zzd m7501d() {
        return f6690a;
    }

    @Override // com.google.android.gms.common.util.zzd
    /* JADX INFO: renamed from: a */
    public final long mo7496a() {
        return System.currentTimeMillis();
    }

    @Override // com.google.android.gms.common.util.zzd
    /* JADX INFO: renamed from: b */
    public final long mo7497b() {
        return SystemClock.elapsedRealtime();
    }

    @Override // com.google.android.gms.common.util.zzd
    /* JADX INFO: renamed from: c */
    public final long mo7498c() {
        return System.nanoTime();
    }
}
