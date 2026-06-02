package com.google.android.gms.internal;

/* JADX INFO: loaded from: classes.dex */
final class zzewb implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzewy f7861a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ int f7862b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzevz f7863c;

    zzewb(zzevz zzevzVar, zzewy zzewyVar, int i) {
        this.f7863c = zzevzVar;
        this.f7861a = zzewyVar;
        this.f7862b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7863c.m8569b(this.f7861a, this.f7862b);
    }
}
