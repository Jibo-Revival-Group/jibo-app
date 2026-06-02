package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
final class zzp {

    /* JADX INFO: renamed from: a */
    private final int f6425a;

    /* JADX INFO: renamed from: b */
    private final ConnectionResult f6426b;

    zzp(ConnectionResult connectionResult, int i) {
        com.google.android.gms.common.internal.zzbq.m7373a(connectionResult);
        this.f6426b = connectionResult;
        this.f6425a = i;
    }

    /* JADX INFO: renamed from: a */
    final int m7231a() {
        return this.f6425a;
    }

    /* JADX INFO: renamed from: b */
    final ConnectionResult m7232b() {
        return this.f6426b;
    }
}
