package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzbha;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public final class zzaa implements zzcc {

    /* JADX INFO: renamed from: c */
    private final Map<Api<?>, Boolean> f6161c;

    /* JADX INFO: renamed from: d */
    private final zzbm f6162d;

    /* JADX INFO: renamed from: e */
    private final zzba f6163e;

    /* JADX INFO: renamed from: f */
    private final Lock f6164f;

    /* JADX INFO: renamed from: g */
    private final Looper f6165g;

    /* JADX INFO: renamed from: h */
    private final com.google.android.gms.common.zzf f6166h;

    /* JADX INFO: renamed from: i */
    private final Condition f6167i;

    /* JADX INFO: renamed from: j */
    private final com.google.android.gms.common.internal.zzr f6168j;

    /* JADX INFO: renamed from: k */
    private final boolean f6169k;

    /* JADX INFO: renamed from: l */
    private final boolean f6170l;

    /* JADX INFO: renamed from: n */
    private boolean f6172n;

    /* JADX INFO: renamed from: o */
    private Map<zzh<?>, ConnectionResult> f6173o;

    /* JADX INFO: renamed from: p */
    private Map<zzh<?>, ConnectionResult> f6174p;

    /* JADX INFO: renamed from: q */
    private zzad f6175q;

    /* JADX INFO: renamed from: r */
    private ConnectionResult f6176r;

    /* JADX INFO: renamed from: a */
    private final Map<Api.zzc<?>, zzz<?>> f6159a = new HashMap();

    /* JADX INFO: renamed from: b */
    private final Map<Api.zzc<?>, zzz<?>> f6160b = new HashMap();

    /* JADX INFO: renamed from: m */
    private final Queue<zzm<?, ?>> f6171m = new LinkedList();

    public zzaa(Context context, Lock lock, Looper looper, com.google.android.gms.common.zzf zzfVar, Map<Api.zzc<?>, Api.zze> map, com.google.android.gms.common.internal.zzr zzrVar, Map<Api<?>, Boolean> map2, Api.zza<? extends zzcxd, zzcxe> zzaVar, ArrayList<zzt> arrayList, zzba zzbaVar, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        this.f6164f = lock;
        this.f6165g = looper;
        this.f6167i = lock.newCondition();
        this.f6166h = zzfVar;
        this.f6163e = zzbaVar;
        this.f6161c = map2;
        this.f6168j = zzrVar;
        this.f6169k = z;
        HashMap map3 = new HashMap();
        for (Api<?> api : map2.keySet()) {
            map3.put(api.m6852c(), api);
        }
        HashMap map4 = new HashMap();
        ArrayList<zzt> arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            zzt zztVar = arrayList2.get(i);
            i++;
            zzt zztVar2 = zztVar;
            map4.put(zztVar2.f6431a, zztVar2);
        }
        boolean z5 = true;
        boolean z6 = false;
        boolean z7 = false;
        for (Map.Entry<Api.zzc<?>, Api.zze> entry : map.entrySet()) {
            Api api2 = (Api) map3.get(entry.getKey());
            Api.zze value = entry.getValue();
            if (value.m6865j()) {
                z2 = true;
                if (this.f6161c.get(api2).booleanValue()) {
                    z3 = z5;
                    z4 = z6;
                } else {
                    z3 = z5;
                    z4 = true;
                }
            } else {
                z2 = z7;
                z3 = false;
                z4 = z6;
            }
            zzz<?> zzzVar = new zzz<>(context, api2, looper, value, (zzt) map4.get(api2), zzrVar, zzaVar);
            this.f6159a.put(entry.getKey(), zzzVar);
            if (value.mo6864i()) {
                this.f6160b.put(entry.getKey(), zzzVar);
            }
            z7 = z2;
            z5 = z3;
            z6 = z4;
        }
        this.f6170l = (!z7 || z5 || z6) ? false : true;
        this.f6162d = zzbm.m7091a();
    }

    /* JADX INFO: renamed from: a */
    private final ConnectionResult m6964a(Api.zzc<?> zzcVar) {
        this.f6164f.lock();
        try {
            zzz<?> zzzVar = this.f6159a.get(zzcVar);
            if (this.f6173o != null && zzzVar != null) {
                return this.f6173o.get(zzzVar.m6877b());
            }
            this.f6164f.unlock();
            return null;
        } finally {
            this.f6164f.unlock();
        }
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m6969a(zzaa zzaaVar, boolean z) {
        zzaaVar.f6172n = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final boolean m6970a(zzz<?> zzzVar, ConnectionResult connectionResult) {
        return !connectionResult.m6821b() && !connectionResult.m6820a() && this.f6161c.get(zzzVar.m6874a()).booleanValue() && zzzVar.m7257g().m6865j() && this.f6166h.mo6840a(connectionResult.m6822c());
    }

    /* JADX INFO: renamed from: c */
    private final <T extends zzm<? extends Result, ? extends Api.zzb>> boolean m6974c(T t) {
        Api.zzc<?> zzcVarM7226g = t.m7226g();
        ConnectionResult connectionResultM6964a = m6964a(zzcVarM7226g);
        if (connectionResultM6964a == null || connectionResultM6964a.m6822c() != 4) {
            return false;
        }
        t.m7225c(new Status(4, null, this.f6162d.m7107a(this.f6159a.get(zzcVarM7226g).m6877b(), System.identityHashCode(this.f6163e))));
        return true;
    }

    /* JADX INFO: renamed from: h */
    private final boolean m6980h() {
        this.f6164f.lock();
        try {
            if (!this.f6172n || !this.f6169k) {
                return false;
            }
            Iterator<Api.zzc<?>> it = this.f6160b.keySet().iterator();
            while (it.hasNext()) {
                ConnectionResult connectionResultM6964a = m6964a(it.next());
                if (connectionResultM6964a == null || !connectionResultM6964a.m6821b()) {
                    return false;
                }
            }
            this.f6164f.unlock();
            return true;
        } finally {
            this.f6164f.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i */
    public final void m6981i() {
        if (this.f6168j == null) {
            this.f6163e.f6232c = Collections.emptySet();
            return;
        }
        HashSet hashSet = new HashSet(this.f6168j.m7454d());
        Map<Api<?>, com.google.android.gms.common.internal.zzt> mapM7456f = this.f6168j.m7456f();
        for (Api<?> api : mapM7456f.keySet()) {
            ConnectionResult connectionResultM6989a = m6989a(api);
            if (connectionResultM6989a != null && connectionResultM6989a.m6821b()) {
                hashSet.addAll(mapM7456f.get(api).f6648a);
            }
        }
        this.f6163e.f6232c = hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: j */
    public final void m6983j() {
        while (!this.f6171m.isEmpty()) {
            mo6995b(this.f6171m.remove());
        }
        this.f6163e.mo7070a((Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: k */
    public final ConnectionResult m6985k() {
        ConnectionResult connectionResult;
        int i;
        int i2 = 0;
        ConnectionResult connectionResult2 = null;
        int i3 = 0;
        ConnectionResult connectionResult3 = null;
        for (zzz<?> zzzVar : this.f6159a.values()) {
            Api<?> apiM6874a = zzzVar.m6874a();
            ConnectionResult connectionResult4 = this.f6173o.get(zzzVar.m6877b());
            if (!connectionResult4.m6821b() && (!this.f6161c.get(apiM6874a).booleanValue() || connectionResult4.m6820a() || this.f6166h.mo6840a(connectionResult4.m6822c()))) {
                if (connectionResult4.m6822c() == 4 && this.f6169k) {
                    int iM6856a = apiM6874a.m6850a().m6856a();
                    if (connectionResult2 == null || i2 > iM6856a) {
                        i2 = iM6856a;
                        connectionResult2 = connectionResult4;
                    }
                } else {
                    int iM6856a2 = apiM6874a.m6850a().m6856a();
                    if (connectionResult3 == null || i3 > iM6856a2) {
                        connectionResult = connectionResult4;
                        i = iM6856a2;
                    } else {
                        i = i3;
                        connectionResult = connectionResult3;
                    }
                    i3 = i;
                    connectionResult3 = connectionResult;
                }
            }
        }
        return (connectionResult3 == null || connectionResult2 == null || i3 <= i2) ? connectionResult3 : connectionResult2;
    }

    /* JADX INFO: renamed from: a */
    public final ConnectionResult m6989a(Api<?> api) {
        return m6964a(api.m6852c());
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: a */
    public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T mo6990a(T t) {
        if (this.f6169k && m6974c(t)) {
            return t;
        }
        if (mo6997d()) {
            this.f6163e.f6234e.m7203a(t);
            return (T) this.f6159a.get(t.m7226g()).m6876a(t);
        }
        this.f6171m.add(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: a */
    public final void mo6991a() {
        this.f6164f.lock();
        try {
            if (this.f6172n) {
                return;
            }
            this.f6172n = true;
            this.f6173o = null;
            this.f6174p = null;
            this.f6175q = null;
            this.f6176r = null;
            this.f6162d.m7116d();
            this.f6162d.m7108a(this.f6159a.values()).mo8926a(new zzbha(this.f6165g), new zzac(this));
        } finally {
            this.f6164f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: a */
    public final void mo6992a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: a */
    public final boolean mo6993a(zzcu zzcuVar) {
        this.f6164f.lock();
        try {
            if (!this.f6172n || m6980h()) {
                this.f6164f.unlock();
                return false;
            }
            this.f6162d.m7116d();
            this.f6175q = new zzad(this, zzcuVar);
            this.f6162d.m7108a(this.f6160b.values()).mo8926a(new zzbha(this.f6165g), this.f6175q);
            this.f6164f.unlock();
            return true;
        } catch (Throwable th) {
            this.f6164f.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: b */
    public final ConnectionResult mo6994b() {
        mo6991a();
        while (m6998e()) {
            try {
                this.f6167i.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        return mo6997d() ? ConnectionResult.f6064a : this.f6176r != null ? this.f6176r : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: b */
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T mo6995b(T t) {
        Api.zzc<A> zzcVarM7226g = t.m7226g();
        if (this.f6169k && m6974c(t)) {
            return t;
        }
        this.f6163e.f6234e.m7203a(t);
        return (T) this.f6159a.get(zzcVarM7226g).m6878b(t);
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: c */
    public final void mo6996c() {
        this.f6164f.lock();
        try {
            this.f6172n = false;
            this.f6173o = null;
            this.f6174p = null;
            if (this.f6175q != null) {
                this.f6175q.m7002a();
                this.f6175q = null;
            }
            this.f6176r = null;
            while (!this.f6171m.isEmpty()) {
                zzm<?, ?> zzmVarRemove = this.f6171m.remove();
                zzmVarRemove.m6943a((zzdm) null);
                zzmVarRemove.mo6918a();
            }
            this.f6167i.signalAll();
        } finally {
            this.f6164f.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean mo6997d() {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.f6164f
            r0.lock()
            java.util.Map<com.google.android.gms.common.api.internal.zzh<?>, com.google.android.gms.common.ConnectionResult> r0 = r2.f6173o     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L14
            com.google.android.gms.common.ConnectionResult r0 = r2.f6176r     // Catch: java.lang.Throwable -> L16
            if (r0 != 0) goto L14
            r0 = 1
        Le:
            java.util.concurrent.locks.Lock r1 = r2.f6164f
            r1.unlock()
            return r0
        L14:
            r0 = 0
            goto Le
        L16:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r2.f6164f
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzaa.mo6997d():boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m6998e() {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.f6164f
            r0.lock()
            java.util.Map<com.google.android.gms.common.api.internal.zzh<?>, com.google.android.gms.common.ConnectionResult> r0 = r2.f6173o     // Catch: java.lang.Throwable -> L16
            if (r0 != 0) goto L14
            boolean r0 = r2.f6172n     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L14
            r0 = 1
        Le:
            java.util.concurrent.locks.Lock r1 = r2.f6164f
            r1.unlock()
            return r0
        L14:
            r0 = 0
            goto Le
        L16:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r2.f6164f
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzaa.m6998e():boolean");
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: f */
    public final void mo6999f() {
        this.f6164f.lock();
        try {
            this.f6162d.m7117e();
            if (this.f6175q != null) {
                this.f6175q.m7002a();
                this.f6175q = null;
            }
            if (this.f6174p == null) {
                this.f6174p = new ArrayMap(this.f6160b.size());
            }
            ConnectionResult connectionResult = new ConnectionResult(4);
            Iterator<zzz<?>> it = this.f6160b.values().iterator();
            while (it.hasNext()) {
                this.f6174p.put(it.next().m6877b(), connectionResult);
            }
            if (this.f6173o != null) {
                this.f6173o.putAll(this.f6174p);
            }
        } finally {
            this.f6164f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: g */
    public final void mo7000g() {
    }
}
