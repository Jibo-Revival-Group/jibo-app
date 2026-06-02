package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: loaded from: classes.dex */
final class zzcjp implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ AppMeasurement.ConditionalUserProperty f7451a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcjn f7452b;

    zzcjp(zzcjn zzcjnVar, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.f7452b = zzcjnVar;
        this.f7451a = conditionalUserProperty;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7452b.m8277d(this.f7451a);
    }
}
