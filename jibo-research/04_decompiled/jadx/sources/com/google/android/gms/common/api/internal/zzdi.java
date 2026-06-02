package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
final class zzdi extends Handler {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzdg f6389a;

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        switch (message.what) {
            case 0:
                PendingResult<?> pendingResult = (PendingResult) message.obj;
                synchronized (this.f6389a.f6382e) {
                    if (pendingResult == null) {
                        this.f6389a.f6379b.m7189a(new Status(13, "Transform returned null"));
                    } else if (pendingResult instanceof zzct) {
                        this.f6389a.f6379b.m7189a(((zzct) pendingResult).m7178d());
                    } else {
                        this.f6389a.f6379b.m7201a(pendingResult);
                    }
                    break;
                }
                return;
            case 1:
                RuntimeException runtimeException = (RuntimeException) message.obj;
                String strValueOf = String.valueOf(runtimeException.getMessage());
                Log.e("TransformedResultImpl", strValueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(strValueOf) : new String("Runtime exception on the transformation worker thread: "));
                throw runtimeException;
            default:
                Log.e("TransformedResultImpl", new StringBuilder(70).append("TransformationResultHandler received unknown message type: ").append(message.what).toString());
                return;
        }
    }
}
