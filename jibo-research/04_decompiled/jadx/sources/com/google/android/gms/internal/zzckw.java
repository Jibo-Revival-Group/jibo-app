package com.google.android.gms.internal;

import android.content.ComponentName;

/* JADX INFO: loaded from: classes.dex */
final class zzckw implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ ComponentName f7566a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcku f7567b;

    zzckw(zzcku zzckuVar, ComponentName componentName) {
        this.f7567b = zzckuVar;
        this.f7566a = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7567b.f7561a.m8325a(this.f7566a);
    }
}
