package com.google.android.gms.internal;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
final class zzclg extends zzcgs {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzclf f7586a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzclg(zzclf zzclfVar, zzcim zzcimVar) {
        super(zzcimVar);
        this.f7586a = zzclfVar;
    }

    @Override // com.google.android.gms.internal.zzcgs
    /* JADX INFO: renamed from: a */
    public final void mo8015a() {
        zzclf zzclfVar = this.f7586a;
        zzclfVar.mo7855c();
        zzclfVar.mo7872t().m8101E().m8109a("Session started, time", Long.valueOf(zzclfVar.mo7863k().mo7497b()));
        zzclfVar.mo7873u().f7267l.m8134a(false);
        zzclfVar.mo7858f().m8289a("auto", "_s", new Bundle());
        zzclfVar.mo7873u().f7268m.m8137a(zzclfVar.mo7863k().mo7496a());
    }
}
