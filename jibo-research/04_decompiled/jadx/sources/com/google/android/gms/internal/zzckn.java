package com.google.android.gms.internal;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class zzckn implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcgi f7526a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzckg f7527b;

    zzckn(zzckg zzckgVar, zzcgi zzcgiVar) {
        this.f7527b = zzckgVar;
        this.f7526a = zzcgiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzche zzcheVar = this.f7527b.f7509b;
        if (zzcheVar == null) {
            this.f7527b.mo7872t().m8106y().m8108a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzcheVar.mo8055b(this.f7526a);
            this.f7527b.m8319F();
        } catch (RemoteException e) {
            this.f7527b.mo7872t().m8106y().m8109a("Failed to send measurementEnabled to the service", e);
        }
    }
}
