package com.google.android.gms.internal;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzcio implements Callable<String> {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ String f7380a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcim f7381b;

    zzcio(zzcim zzcimVar, String str) {
        this.f7381b = zzcimVar;
        this.f7380a = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        zzcgh zzcghVarM7993b = this.f7381b.m8244q().m7993b(this.f7380a);
        if (zzcghVarM7993b != null) {
            return zzcghVarM7993b.m7885c();
        }
        this.f7381b.m8233f().m8097A().m8108a("App info was null when attempting to get app instance id");
        return null;
    }
}
