package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzbf extends Handler {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzba f6264a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbf(zzba zzbaVar, Looper looper) {
        super(looper);
        this.f6264a = zzbaVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f6264a.m7068q();
                break;
            case 2:
                this.f6264a.m7067p();
                break;
            default:
                Log.w("GoogleApiClientImpl", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                break;
        }
    }
}
