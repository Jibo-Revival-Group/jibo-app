package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.zzcf;

/* JADX INFO: loaded from: classes.dex */
final class zzy extends zzv {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Intent f6656a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcf f6657b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ int f6658c;

    zzy(Intent intent, zzcf zzcfVar, int i) {
        this.f6656a = intent;
        this.f6657b = zzcfVar;
        this.f6658c = i;
    }

    @Override // com.google.android.gms.common.internal.zzv
    /* JADX INFO: renamed from: a */
    public final void mo7478a() {
        if (this.f6656a != null) {
            this.f6657b.startActivityForResult(this.f6656a, this.f6658c);
        }
    }
}
