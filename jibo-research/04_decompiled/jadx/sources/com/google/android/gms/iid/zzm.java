package com.google.android.gms.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
final class zzm extends Handler {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzl f6835a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzm(zzl zzlVar, Looper looper) {
        super(looper);
        this.f6835a = zzlVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.f6835a.m7640a(message);
    }
}
