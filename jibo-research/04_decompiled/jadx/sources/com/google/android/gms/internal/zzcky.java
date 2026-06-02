package com.google.android.gms.internal;

import android.content.ComponentName;

/* JADX INFO: loaded from: classes.dex */
final class zzcky implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcku f7570a;

    zzcky(zzcku zzckuVar) {
        this.f7570a = zzckuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7570a.f7561a.m8325a(new ComponentName(this.f7570a.f7561a.mo7864l(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
