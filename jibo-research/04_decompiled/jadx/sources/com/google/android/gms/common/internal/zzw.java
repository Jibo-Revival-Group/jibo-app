package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class zzw extends zzv {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Intent f6650a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ Activity f6651b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ int f6652c;

    zzw(Intent intent, Activity activity, int i) {
        this.f6650a = intent;
        this.f6651b = activity;
        this.f6652c = i;
    }

    @Override // com.google.android.gms.common.internal.zzv
    /* JADX INFO: renamed from: a */
    public final void mo7478a() {
        if (this.f6650a != null) {
            this.f6651b.startActivityForResult(this.f6650a, this.f6652c);
        }
    }
}
