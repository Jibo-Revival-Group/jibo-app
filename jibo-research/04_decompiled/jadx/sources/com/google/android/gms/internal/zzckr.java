package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
final class zzckr implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ AtomicReference f7546a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ String f7547b;

    /* JADX INFO: renamed from: c */
    private /* synthetic */ String f7548c;

    /* JADX INFO: renamed from: d */
    private /* synthetic */ String f7549d;

    /* JADX INFO: renamed from: e */
    private /* synthetic */ boolean f7550e;

    /* JADX INFO: renamed from: f */
    private /* synthetic */ zzcgi f7551f;

    /* JADX INFO: renamed from: g */
    private /* synthetic */ zzckg f7552g;

    zzckr(zzckg zzckgVar, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzcgi zzcgiVar) {
        this.f7552g = zzckgVar;
        this.f7546a = atomicReference;
        this.f7547b = str;
        this.f7548c = str2;
        this.f7549d = str3;
        this.f7550e = z;
        this.f7551f = zzcgiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzche zzcheVar;
        synchronized (this.f7546a) {
            try {
                try {
                    zzcheVar = this.f7552g.f7509b;
                } catch (RemoteException e) {
                    this.f7552g.mo7872t().m8106y().m8111a("Failed to get user properties", zzchm.m8093a(this.f7547b), this.f7548c, e);
                    this.f7546a.set(Collections.emptyList());
                    this.f7546a.notify();
                }
                if (zzcheVar == null) {
                    this.f7552g.mo7872t().m8106y().m8111a("Failed to get user properties", zzchm.m8093a(this.f7547b), this.f7548c, this.f7549d);
                    this.f7546a.set(Collections.emptyList());
                } else {
                    if (TextUtils.isEmpty(this.f7547b)) {
                        this.f7546a.set(zzcheVar.mo8046a(this.f7548c, this.f7549d, this.f7550e, this.f7551f));
                    } else {
                        this.f7546a.set(zzcheVar.mo8045a(this.f7547b, this.f7548c, this.f7549d, this.f7550e));
                    }
                    this.f7552g.m8319F();
                }
            } finally {
                this.f7546a.notify();
            }
        }
    }
}
