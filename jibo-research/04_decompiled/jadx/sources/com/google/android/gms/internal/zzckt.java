package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzckt implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ AtomicReference f7557a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcgi f7558b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ boolean f7559c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ zzckg f7560d;

    zzckt(zzckg zzckgVar, AtomicReference atomicReference, zzcgi zzcgiVar, boolean z) {
        this.f7560d = zzckgVar;
        this.f7557a = atomicReference;
        this.f7558b = zzcgiVar;
        this.f7559c = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzche zzcheVar;
        synchronized (this.f7557a) {
            try {
                try {
                    zzcheVar = this.f7560d.f7509b;
                } catch (RemoteException e) {
                    this.f7560d.mo7872t().m8106y().m8109a("Failed to get user properties", e);
                    this.f7557a.notify();
                }
                if (zzcheVar == null) {
                    this.f7560d.mo7872t().m8106y().m8108a("Failed to get user properties");
                } else {
                    this.f7557a.set(zzcheVar.mo8042a(this.f7558b, this.f7559c));
                    this.f7560d.m8319F();
                }
            } finally {
                this.f7557a.notify();
            }
        }
    }
}
