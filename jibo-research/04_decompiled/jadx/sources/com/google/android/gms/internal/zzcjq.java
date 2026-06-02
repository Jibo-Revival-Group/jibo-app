package com.google.android.gms.internal;

import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: loaded from: classes.dex */
final class zzcjq implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ AppMeasurement.ConditionalUserProperty f7453a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcjn f7454b;

    zzcjq(zzcjn zzcjnVar, AppMeasurement.ConditionalUserProperty conditionalUserProperty) {
        this.f7454b = zzcjnVar;
        this.f7453a = conditionalUserProperty;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7454b.m8278e(this.f7453a);
    }
}
