package com.google.android.gms.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzckj implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ AtomicReference f7518a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzcgi f7519b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzckg f7520c;

    zzckj(zzckg zzckgVar, AtomicReference atomicReference, zzcgi zzcgiVar) {
        this.f7520c = zzckgVar;
        this.f7518a = atomicReference;
        this.f7519b = zzcgiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzche zzcheVar;
        synchronized (this.f7518a) {
            try {
                try {
                    zzcheVar = this.f7520c.f7509b;
                } catch (RemoteException e) {
                    this.f7520c.mo7872t().m8106y().m8109a("Failed to get app instance id", e);
                    this.f7518a.notify();
                }
                if (zzcheVar == null) {
                    this.f7520c.mo7872t().m8106y().m8108a("Failed to get app instance id");
                    return;
                }
                this.f7518a.set(zzcheVar.mo8056c(this.f7519b));
                String str = (String) this.f7518a.get();
                if (str != null) {
                    this.f7520c.mo7858f().m8288a(str);
                    this.f7520c.mo7873u().f7264i.m8143a(str);
                }
                this.f7520c.m8319F();
            } finally {
                this.f7518a.notify();
            }
        }
    }
}
