package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
final class zzcj extends Handler {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzci f6348a;

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        com.google.android.gms.common.internal.zzbq.m7382b(message.what == 1);
        this.f6348a.m7171b((zzcl) message.obj);
    }
}
