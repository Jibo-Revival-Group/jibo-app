package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
final class zzcko implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ boolean f7528a = true;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ boolean f7529b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ zzcha f7530c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ zzcgi f7531d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ String f7532e;

    /* JADX INFO: renamed from: f */
    private /* synthetic */ zzckg f7533f;

    zzcko(zzckg zzckgVar, boolean z, boolean z2, zzcha zzchaVar, zzcgi zzcgiVar, String str) {
        this.f7533f = zzckgVar;
        this.f7529b = z2;
        this.f7530c = zzchaVar;
        this.f7531d = zzcgiVar;
        this.f7532e = str;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        zzche zzcheVar = this.f7533f.f7509b;
        if (zzcheVar == null) {
            this.f7533f.mo7872t().m8106y().m8108a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f7528a) {
            this.f7533f.m8340a(zzcheVar, this.f7529b ? null : this.f7530c, this.f7531d);
        } else {
            try {
                if (TextUtils.isEmpty(this.f7532e)) {
                    zzcheVar.mo8051a(this.f7530c, this.f7531d);
                } else {
                    zzcheVar.mo8052a(this.f7530c, this.f7532e, this.f7533f.mo7872t().m8102F());
                }
            } catch (RemoteException e) {
                this.f7533f.mo7872t().m8106y().m8109a("Failed to send event to the service", e);
            }
        }
        this.f7533f.m8319F();
    }
}
