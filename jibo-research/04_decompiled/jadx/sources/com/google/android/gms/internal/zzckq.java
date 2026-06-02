package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzckq implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ AtomicReference f7540a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f7541b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f7542c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ String f7543d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ zzcgi f7544e;

    /* JADX INFO: renamed from: f */
    private /* synthetic */ zzckg f7545f;

    zzckq(zzckg zzckgVar, AtomicReference atomicReference, String str, String str2, String str3, zzcgi zzcgiVar) {
        this.f7545f = zzckgVar;
        this.f7540a = atomicReference;
        this.f7541b = str;
        this.f7542c = str2;
        this.f7543d = str3;
        this.f7544e = zzcgiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzche zzcheVar;
        synchronized (this.f7540a) {
            try {
                try {
                    zzcheVar = this.f7545f.f7509b;
                } catch (RemoteException e) {
                    this.f7545f.mo7872t().m8106y().m8111a("Failed to get conditional properties", zzchm.m8093a(this.f7541b), this.f7542c, e);
                    this.f7540a.set(Collections.emptyList());
                    this.f7540a.notify();
                }
                if (zzcheVar == null) {
                    this.f7545f.mo7872t().m8106y().m8111a("Failed to get conditional properties", zzchm.m8093a(this.f7541b), this.f7542c, this.f7543d);
                    this.f7540a.set(Collections.emptyList());
                } else {
                    if (TextUtils.isEmpty(this.f7541b)) {
                        this.f7540a.set(zzcheVar.mo8043a(this.f7542c, this.f7543d, this.f7544e));
                    } else {
                        this.f7540a.set(zzcheVar.mo8044a(this.f7541b, this.f7542c, this.f7543d));
                    }
                    this.f7545f.m8319F();
                }
            } finally {
                this.f7540a.notify();
            }
        }
    }
}
