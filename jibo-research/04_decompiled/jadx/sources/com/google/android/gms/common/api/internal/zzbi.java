package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public final class zzbi implements zzcc, zzu {

    /* JADX INFO: renamed from: a */
    final Map<Api.zzc<?>, Api.zze> f6266a;

    /* JADX INFO: renamed from: c */
    int f6268c;

    /* JADX INFO: renamed from: d */
    final zzba f6269d;

    /* JADX INFO: renamed from: e */
    final zzcd f6270e;

    /* JADX INFO: renamed from: f */
    private final Lock f6271f;

    /* JADX INFO: renamed from: g */
    private final Condition f6272g;

    /* JADX INFO: renamed from: h */
    private final Context f6273h;

    /* JADX INFO: renamed from: i */
    private final com.google.android.gms.common.zzf f6274i;

    /* JADX INFO: renamed from: j */
    private final zzbk f6275j;

    /* JADX INFO: renamed from: k */
    private com.google.android.gms.common.internal.zzr f6276k;

    /* JADX INFO: renamed from: l */
    private Map<Api<?>, Boolean> f6277l;

    /* JADX INFO: renamed from: m */
    private Api.zza<? extends zzcxd, zzcxe> f6278m;

    /* JADX INFO: renamed from: n */
    private volatile zzbh f6279n;

    /* JADX INFO: renamed from: b */
    final Map<Api.zzc<?>, ConnectionResult> f6267b = new HashMap();

    /* JADX INFO: renamed from: o */
    private ConnectionResult f6280o = null;

    public zzbi(Context context, zzba zzbaVar, Lock lock, Looper looper, com.google.android.gms.common.zzf zzfVar, Map<Api.zzc<?>, Api.zze> map, com.google.android.gms.common.internal.zzr zzrVar, Map<Api<?>, Boolean> map2, Api.zza<? extends zzcxd, zzcxe> zzaVar, ArrayList<zzt> arrayList, zzcd zzcdVar) {
        this.f6273h = context;
        this.f6271f = lock;
        this.f6274i = zzfVar;
        this.f6266a = map;
        this.f6276k = zzrVar;
        this.f6277l = map2;
        this.f6278m = zzaVar;
        this.f6269d = zzbaVar;
        this.f6270e = zzcdVar;
        ArrayList<zzt> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            zzt zztVar = arrayList2.get(i);
            i++;
            zztVar.m7234a(this);
        }
        this.f6275j = new zzbk(this, looper);
        this.f6272g = lock.newCondition();
        this.f6279n = new zzaz(this);
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: a */
    public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T mo6990a(T t) {
        t.m6947f();
        return (T) this.f6279n.mo7014a(t);
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: a */
    public final void mo6991a() {
        this.f6279n.mo7021c();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public final void mo6914a(int i) {
        this.f6271f.lock();
        try {
            this.f6279n.mo7016a(i);
        } finally {
            this.f6271f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public final void mo6915a(Bundle bundle) {
        this.f6271f.lock();
        try {
            this.f6279n.mo7017a(bundle);
        } finally {
            this.f6271f.unlock();
        }
    }

    /* JADX INFO: renamed from: a */
    final void m7080a(ConnectionResult connectionResult) {
        this.f6271f.lock();
        try {
            this.f6280o = connectionResult;
            this.f6279n = new zzaz(this);
            this.f6279n.mo7015a();
            this.f6272g.signalAll();
        } finally {
            this.f6271f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzu
    /* JADX INFO: renamed from: a */
    public final void mo7081a(ConnectionResult connectionResult, Api<?> api, boolean z) {
        this.f6271f.lock();
        try {
            this.f6279n.mo7018a(connectionResult, api, z);
        } finally {
            this.f6271f.unlock();
        }
    }

    /* JADX INFO: renamed from: a */
    final void m7082a(zzbj zzbjVar) {
        this.f6275j.sendMessage(this.f6275j.obtainMessage(1, zzbjVar));
    }

    /* JADX INFO: renamed from: a */
    final void m7083a(RuntimeException runtimeException) {
        this.f6275j.sendMessage(this.f6275j.obtainMessage(2, runtimeException));
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: a */
    public final void mo6992a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String strConcat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.f6279n);
        for (Api<?> api : this.f6277l.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) api.m6853d()).println(":");
            this.f6266a.get(api.m6852c()).m6860a(strConcat, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: a */
    public final boolean mo6993a(zzcu zzcuVar) {
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: b */
    public final ConnectionResult mo6994b() {
        mo6991a();
        while (m7086i()) {
            try {
                this.f6272g.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        return mo6997d() ? ConnectionResult.f6064a : this.f6280o != null ? this.f6280o : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: b */
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T mo6995b(T t) {
        t.m6947f();
        return (T) this.f6279n.mo7019b(t);
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: c */
    public final void mo6996c() {
        if (this.f6279n.mo7020b()) {
            this.f6267b.clear();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: d */
    public final boolean mo6997d() {
        return this.f6279n instanceof zzal;
    }

    /* JADX INFO: renamed from: e */
    final void m7084e() {
        this.f6271f.lock();
        try {
            this.f6279n = new zzao(this, this.f6276k, this.f6277l, this.f6274i, this.f6278m, this.f6271f, this.f6273h);
            this.f6279n.mo7015a();
            this.f6272g.signalAll();
        } finally {
            this.f6271f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: f */
    public final void mo6999f() {
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: g */
    public final void mo7000g() {
        if (mo6997d()) {
            ((zzal) this.f6279n).m7022d();
        }
    }

    /* JADX INFO: renamed from: h */
    final void m7085h() {
        this.f6271f.lock();
        try {
            this.f6269d.m7072l();
            this.f6279n = new zzal(this);
            this.f6279n.mo7015a();
            this.f6272g.signalAll();
        } finally {
            this.f6271f.unlock();
        }
    }

    /* JADX INFO: renamed from: i */
    public final boolean m7086i() {
        return this.f6279n instanceof zzao;
    }
}
