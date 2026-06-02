package com.google.android.gms.internal;

import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
final class zzcki implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzcgi f7516a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzckg f7517b;

    zzcki(zzckg zzckgVar, zzcgi zzcgiVar) {
        this.f7517b = zzckgVar;
        this.f7516a = zzcgiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzche zzcheVar = this.f7517b.f7509b;
        if (zzcheVar == null) {
            this.f7517b.mo7872t().m8106y().m8108a("Failed to reset data on the service; null service");
            return;
        }
        try {
            zzcheVar.mo8057d(this.f7516a);
        } catch (RemoteException e) {
            this.f7517b.mo7872t().m8106y().m8109a("Failed to reset data on the service", e);
        }
        this.f7517b.m8319F();
    }
}
