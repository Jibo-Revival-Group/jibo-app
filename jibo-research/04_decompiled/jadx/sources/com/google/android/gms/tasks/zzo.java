package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class zzo implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzn f8431a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ Callable f8432b;

    zzo(zzn zznVar, Callable callable) {
        this.f8431a = zznVar;
        this.f8432b = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f8431a.m8960a(this.f8432b.call());
        } catch (Exception e) {
            this.f8431a.m8959a(e);
        }
    }
}
