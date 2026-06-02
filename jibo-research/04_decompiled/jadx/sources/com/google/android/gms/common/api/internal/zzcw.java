package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
final class zzcw implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcv f6368a;

    zzcw(zzcv zzcvVar) {
        this.f6368a = zzcvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6368a.f6367h.mo7152b(new ConnectionResult(4));
    }
}
