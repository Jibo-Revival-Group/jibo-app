package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zze;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class zzdj {

    /* JADX INFO: renamed from: a */
    public static final Status f6390a = new Status(8, "The connection to Google Play services was lost");

    /* JADX INFO: renamed from: c */
    private static final BasePendingResult<?>[] f6391c = new BasePendingResult[0];

    /* JADX INFO: renamed from: b */
    final Set<BasePendingResult<?>> f6392b = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* JADX INFO: renamed from: d */
    private final zzdm f6393d = new zzdk(this);

    /* JADX INFO: renamed from: e */
    private final Map<Api.zzc<?>, Api.zze> f6394e;

    public zzdj(Map<Api.zzc<?>, Api.zze> map) {
        this.f6394e = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public final void m7202a() {
        zze zzeVar = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        zze zzeVar2 = null;
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f6392b.toArray(f6391c)) {
            basePendingResult.m6943a((zzdm) null);
            if (basePendingResult.mo6922c() != null) {
                basePendingResult.mo6920a((ResultCallback) null);
                IBinder iBinderM6866k = this.f6394e.get(((zzm) basePendingResult).m7226g()).m6866k();
                if (basePendingResult.m6945d()) {
                    basePendingResult.m6943a(new zzdl(basePendingResult, objArr4 == true ? 1 : 0, iBinderM6866k, objArr3 == true ? 1 : 0));
                } else if (iBinderM6866k == null || !iBinderM6866k.isBinderAlive()) {
                    basePendingResult.m6943a((zzdm) null);
                    basePendingResult.mo6918a();
                    zzeVar.m7260a(basePendingResult.mo6922c().intValue());
                } else {
                    zzdl zzdlVar = new zzdl(basePendingResult, objArr2 == true ? 1 : 0, iBinderM6866k, objArr == true ? 1 : 0);
                    basePendingResult.m6943a(zzdlVar);
                    try {
                        iBinderM6866k.linkToDeath(zzdlVar, 0);
                    } catch (RemoteException e) {
                        basePendingResult.mo6918a();
                        zzeVar2.m7260a(basePendingResult.mo6922c().intValue());
                    }
                }
                this.f6392b.remove(basePendingResult);
            } else if (basePendingResult.m6946e()) {
                this.f6392b.remove(basePendingResult);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    final void m7203a(BasePendingResult<? extends Result> basePendingResult) {
        this.f6392b.add(basePendingResult);
        basePendingResult.m6943a(this.f6393d);
    }

    /* JADX INFO: renamed from: b */
    public final void m7204b() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f6392b.toArray(f6391c)) {
            basePendingResult.m6944b(f6390a);
        }
    }
}
