package com.google.firebase.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
final class zzw extends Handler {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzv f8695a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzw(zzv zzvVar, Looper looper) {
        super(looper);
        this.f8695a = zzvVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.f8695a.m9164a(message);
    }
}
