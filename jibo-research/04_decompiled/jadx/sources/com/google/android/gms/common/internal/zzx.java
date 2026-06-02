package com.google.android.gms.common.internal;

import android.content.Intent;
import android.support.v4.app.Fragment;

/* JADX INFO: loaded from: classes.dex */
final class zzx extends zzv {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Intent f6653a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ Fragment f6654b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ int f6655c;

    zzx(Intent intent, Fragment fragment, int i) {
        this.f6653a = intent;
        this.f6654b = fragment;
        this.f6655c = i;
    }

    @Override // com.google.android.gms.common.internal.zzv
    /* JADX INFO: renamed from: a */
    public final void mo7478a() {
        if (this.f6653a != null) {
            this.f6654b.startActivityForResult(this.f6653a, this.f6655c);
        }
    }
}
