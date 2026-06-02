package com.google.android.gms.common.api.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzbn implements zzl {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzbm f6301a;

    zzbn(zzbm zzbmVar) {
        this.f6301a = zzbmVar;
    }

    @Override // com.google.android.gms.common.api.internal.zzl
    /* JADX INFO: renamed from: a */
    public final void mo7118a(boolean z) {
        this.f6301a.f6300q.sendMessage(this.f6301a.f6300q.obtainMessage(1, Boolean.valueOf(z)));
    }
}
