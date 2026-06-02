package com.google.android.gms.internal;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class zzclm extends zzcgs {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcll f7597a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzclm(zzcll zzcllVar, zzcim zzcimVar) {
        super(zzcimVar);
        this.f7597a = zzcllVar;
    }

    @Override // com.google.android.gms.internal.zzcgs
    /* JADX INFO: renamed from: a */
    public final void mo8015a() {
        this.f7597a.m8382y();
        this.f7597a.mo7872t().m8101E().m8108a("Sending upload intent from DelayedRunnable");
        Intent className = new Intent().setClassName(this.f7597a.mo7864l(), "com.google.android.gms.measurement.AppMeasurementReceiver");
        className.setAction("com.google.android.gms.measurement.UPLOAD");
        this.f7597a.mo7864l().sendBroadcast(className);
    }
}
