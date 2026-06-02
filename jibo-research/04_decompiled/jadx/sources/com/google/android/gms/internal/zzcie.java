package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: loaded from: classes.dex */
final class zzcie implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcim f7299a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ long f7300b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ Bundle f7301c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ Context f7302d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ zzchm f7303e;

    /* JADX INFO: renamed from: f */
    private /* synthetic */ BroadcastReceiver.PendingResult f7304f;

    zzcie(zzcid zzcidVar, zzcim zzcimVar, long j, Bundle bundle, Context context, zzchm zzchmVar, BroadcastReceiver.PendingResult pendingResult) {
        this.f7299a = zzcimVar;
        this.f7300b = j;
        this.f7301c = bundle;
        this.f7302d = context;
        this.f7303e = zzchmVar;
        this.f7304f = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzclp zzclpVarM7997c = this.f7299a.m8244q().m7997c(this.f7299a.m8252y().m8065z(), "_fot");
        long jLongValue = (zzclpVarM7997c == null || !(zzclpVarM7997c.f7610e instanceof Long)) ? 0L : ((Long) zzclpVarM7997c.f7610e).longValue();
        long j = this.f7300b;
        long j2 = (jLongValue <= 0 || (j < jLongValue && j > 0)) ? j : jLongValue - 1;
        if (j2 > 0) {
            this.f7301c.putLong("click_timestamp", j2);
        }
        AppMeasurement.getInstance(this.f7302d).logEventInternal("auto", "_cmp", this.f7301c);
        this.f7303e.m8101E().m8108a("Install campaign recorded");
        if (this.f7304f != null) {
            this.f7304f.finish();
        }
    }
}
