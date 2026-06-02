package com.google.android.gms.internal;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class zzckk implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcgi f7521a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzckg f7522b;

    zzckk(zzckg zzckgVar, zzcgi zzcgiVar) {
        this.f7522b = zzckgVar;
        this.f7521a = zzcgiVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzche zzcheVar = this.f7522b.f7509b;
        if (zzcheVar == null) {
            this.f7522b.mo7872t().m8106y().m8108a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzcheVar.mo8048a(this.f7521a);
            this.f7522b.m8340a(zzcheVar, null, this.f7521a);
            this.f7522b.m8319F();
        } catch (RemoteException e) {
            this.f7522b.mo7872t().m8106y().m8109a("Failed to send app launch to the service", e);
        }
    }
}
