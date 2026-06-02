package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
public final class zzci<L> {

    /* JADX INFO: renamed from: a */
    private final zzcj f6346a;

    /* JADX INFO: renamed from: b */
    private volatile L f6347b;

    /* JADX INFO: renamed from: a */
    public final void m7169a() {
        this.f6347b = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m7170a(zzcl<? super L> zzclVar) {
        com.google.android.gms.common.internal.zzbq.m7374a(zzclVar, "Notifier must not be null");
        this.f6346a.sendMessage(this.f6346a.obtainMessage(1, zzclVar));
    }

    /* JADX INFO: renamed from: b */
    final void m7171b(zzcl<? super L> zzclVar) {
        L l = this.f6347b;
        if (l == null) {
            zzclVar.mo7172a();
            return;
        }
        try {
            zzclVar.mo7173a(l);
        } catch (RuntimeException e) {
            zzclVar.mo7172a();
            throw e;
        }
    }
}
