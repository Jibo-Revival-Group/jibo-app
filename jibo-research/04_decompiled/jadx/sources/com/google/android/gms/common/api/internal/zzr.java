package com.google.android.gms.common.api.internal;

import android.app.Dialog;

/* JADX INFO: loaded from: classes.dex */
final class zzr extends zzby {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Dialog f6429a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzq f6430b;

    zzr(zzq zzqVar, Dialog dialog) {
        this.f6430b = zzqVar;
        this.f6429a = dialog;
    }

    @Override // com.google.android.gms.common.api.internal.zzby
    /* JADX INFO: renamed from: a */
    public final void mo7077a() {
        this.f6430b.f6427a.m7230h();
        if (this.f6429a.isShowing()) {
            this.f6429a.dismiss();
        }
    }
}
