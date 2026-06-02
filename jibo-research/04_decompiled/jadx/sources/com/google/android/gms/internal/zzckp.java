package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
final class zzckp implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ boolean f7534a = true;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ boolean f7535b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzcgl f7536c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ zzcgi f7537d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ zzcgl f7538e;

    /* JADX INFO: renamed from: f */
    private /* synthetic */ zzckg f7539f;

    zzckp(zzckg zzckgVar, boolean z, boolean z2, zzcgl zzcglVar, zzcgi zzcgiVar, zzcgl zzcglVar2) {
        this.f7539f = zzckgVar;
        this.f7535b = z2;
        this.f7536c = zzcglVar;
        this.f7537d = zzcgiVar;
        this.f7538e = zzcglVar2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzche zzcheVar = this.f7539f.f7509b;
        if (zzcheVar == null) {
            this.f7539f.mo7872t().m8106y().m8108a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f7534a) {
            this.f7539f.m8340a(zzcheVar, this.f7535b ? null : this.f7536c, this.f7537d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f7538e.f7102a)) {
                    zzcheVar.mo8050a(this.f7536c, this.f7537d);
                } else {
                    zzcheVar.mo8049a(this.f7536c);
                }
            } catch (RemoteException e) {
                this.f7539f.mo7872t().m8106y().m8109a("Failed to send conditional user property to the service", e);
            }
        }
        this.f7539f.m8319F();
    }
}
