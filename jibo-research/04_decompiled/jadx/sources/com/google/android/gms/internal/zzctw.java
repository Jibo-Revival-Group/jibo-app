package com.google.android.gms.internal;

import android.database.ContentObserver;
import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
final class zzctw extends ContentObserver {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzctv f7727a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzctw(zzctv zzctvVar, Handler handler) {
        super(null);
        this.f7727a = zzctvVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        this.f7727a.m8464b();
    }
}
