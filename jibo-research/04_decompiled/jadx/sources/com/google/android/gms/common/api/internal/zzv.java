package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
final class zzv implements zzcc {

    /* JADX INFO: renamed from: a */
    private final Context f6434a;

    /* JADX INFO: renamed from: b */
    private final zzba f6435b;

    /* JADX INFO: renamed from: c */
    private final Looper f6436c;

    /* JADX INFO: renamed from: d */
    private final zzbi f6437d;

    /* JADX INFO: renamed from: e */
    private final zzbi f6438e;

    /* JADX INFO: renamed from: f */
    private final Map<Api.zzc<?>, zzbi> f6439f;

    /* JADX INFO: renamed from: h */
    private final Api.zze f6441h;

    /* JADX INFO: renamed from: i */
    private Bundle f6442i;

    /* JADX INFO: renamed from: m */
    private final Lock f6446m;

    /* JADX INFO: renamed from: g */
    private final Set<zzcu> f6440g = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: j */
    private ConnectionResult f6443j = null;

    /* JADX INFO: renamed from: k */
    private ConnectionResult f6444k = null;

    /* JADX INFO: renamed from: l */
    private boolean f6445l = false;

    /* JADX INFO: renamed from: n */
    private int f6447n = 0;

    private zzv(Context context, zzba zzbaVar, Lock lock, Looper looper, com.google.android.gms.common.zzf zzfVar, Map<Api.zzc<?>, Api.zze> map, Map<Api.zzc<?>, Api.zze> map2, com.google.android.gms.common.internal.zzr zzrVar, Api.zza<? extends zzcxd, zzcxe> zzaVar, Api.zze zzeVar, ArrayList<zzt> arrayList, ArrayList<zzt> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.f6434a = context;
        this.f6435b = zzbaVar;
        this.f6446m = lock;
        this.f6436c = looper;
        this.f6441h = zzeVar;
        this.f6437d = new zzbi(context, this.f6435b, lock, looper, zzfVar, map2, null, map4, null, arrayList2, new zzx(this, null));
        this.f6438e = new zzbi(context, this.f6435b, lock, looper, zzfVar, map, zzrVar, map3, zzaVar, arrayList, new zzy(this, null));
        ArrayMap arrayMap = new ArrayMap();
        Iterator<Api.zzc<?>> it = map2.keySet().iterator();
        while (it.hasNext()) {
            arrayMap.put(it.next(), this.f6437d);
        }
        Iterator<Api.zzc<?>> it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            arrayMap.put(it2.next(), this.f6438e);
        }
        this.f6439f = Collections.unmodifiableMap(arrayMap);
    }

    /* JADX INFO: renamed from: a */
    public static zzv m7236a(Context context, zzba zzbaVar, Lock lock, Looper looper, com.google.android.gms.common.zzf zzfVar, Map<Api.zzc<?>, Api.zze> map, com.google.android.gms.common.internal.zzr zzrVar, Map<Api<?>, Boolean> map2, Api.zza<? extends zzcxd, zzcxe> zzaVar, ArrayList<zzt> arrayList) {
        Api.zze zzeVar = null;
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        for (Map.Entry<Api.zzc<?>, Api.zze> entry : map.entrySet()) {
            Api.zze value = entry.getValue();
            if (value.mo6771c()) {
                zzeVar = value;
            }
            if (value.mo6864i()) {
                arrayMap.put(entry.getKey(), value);
            } else {
                arrayMap2.put(entry.getKey(), value);
            }
        }
        com.google.android.gms.common.internal.zzbq.m7379a(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api<?> api : map2.keySet()) {
            Api.zzc<?> zzcVarM6852c = api.m6852c();
            if (arrayMap.containsKey(zzcVarM6852c)) {
                arrayMap3.put(api, map2.get(api));
            } else {
                if (!arrayMap2.containsKey(zzcVarM6852c)) {
                    throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                }
                arrayMap4.put(api, map2.get(api));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList<zzt> arrayList4 = arrayList;
        int size = arrayList4.size();
        int i = 0;
        while (i < size) {
            zzt zztVar = arrayList4.get(i);
            i++;
            zzt zztVar2 = zztVar;
            if (arrayMap3.containsKey(zztVar2.f6431a)) {
                arrayList2.add(zztVar2);
            } else {
                if (!arrayMap4.containsKey(zztVar2.f6431a)) {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                }
                arrayList3.add(zztVar2);
            }
        }
        return new zzv(context, zzbaVar, lock, looper, zzfVar, arrayMap, arrayMap2, zzrVar, zzaVar, zzeVar, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m7238a(int i, boolean z) {
        this.f6435b.mo7069a(i, z);
        this.f6444k = null;
        this.f6443j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m7239a(Bundle bundle) {
        if (this.f6442i == null) {
            this.f6442i = bundle;
        } else if (bundle != null) {
            this.f6442i.putAll(bundle);
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m7240a(ConnectionResult connectionResult) {
        switch (this.f6447n) {
            case 2:
                this.f6435b.mo7071a(connectionResult);
            case 1:
                m7253i();
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        this.f6447n = 0;
    }

    /* JADX INFO: renamed from: b */
    private static boolean m7246b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.m6821b();
    }

    /* JADX INFO: renamed from: c */
    private final boolean m7247c(zzm<? extends Result, ? extends Api.zzb> zzmVar) {
        Object objM7226g = zzmVar.m7226g();
        com.google.android.gms.common.internal.zzbq.m7383b(this.f6439f.containsKey(objM7226g), "GoogleApiClient is not configured to use the API required for this call.");
        return this.f6439f.get(objM7226g).equals(this.f6438e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public final void m7252h() {
        if (!m7246b(this.f6443j)) {
            if (this.f6443j != null && m7246b(this.f6444k)) {
                this.f6438e.mo6996c();
                m7240a(this.f6443j);
                return;
            } else {
                if (this.f6443j == null || this.f6444k == null) {
                    return;
                }
                ConnectionResult connectionResult = this.f6443j;
                if (this.f6438e.f6268c < this.f6437d.f6268c) {
                    connectionResult = this.f6444k;
                }
                m7240a(connectionResult);
                return;
            }
        }
        if (m7246b(this.f6444k) || m7254j()) {
            switch (this.f6447n) {
                case 2:
                    this.f6435b.mo7070a(this.f6442i);
                case 1:
                    m7253i();
                    break;
                default:
                    Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                    break;
            }
            this.f6447n = 0;
            return;
        }
        if (this.f6444k != null) {
            if (this.f6447n == 1) {
                m7253i();
            } else {
                m7240a(this.f6444k);
                this.f6437d.mo6996c();
            }
        }
    }

    /* JADX INFO: renamed from: i */
    private final void m7253i() {
        Iterator<zzcu> it = this.f6440g.iterator();
        while (it.hasNext()) {
            it.next().mo6767h();
        }
        this.f6440g.clear();
    }

    /* JADX INFO: renamed from: j */
    private final boolean m7254j() {
        return this.f6444k != null && this.f6444k.m6822c() == 4;
    }

    /* JADX INFO: renamed from: k */
    private final PendingIntent m7255k() {
        if (this.f6441h == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f6434a, System.identityHashCode(this.f6435b), this.f6441h.mo6772d(), 134217728);
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: a */
    public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T mo6990a(T t) {
        if (!m7247c((zzm<? extends Result, ? extends Api.zzb>) t)) {
            return (T) this.f6437d.mo6990a(t);
        }
        if (!m7254j()) {
            return (T) this.f6438e.mo6990a(t);
        }
        t.m7225c(new Status(4, null, m7255k()));
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: a */
    public final void mo6991a() {
        this.f6447n = 2;
        this.f6445l = false;
        this.f6444k = null;
        this.f6443j = null;
        this.f6437d.mo6991a();
        this.f6438e.mo6991a();
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: a */
    public final void mo6992a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.f6438e.mo6992a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.f6437d.mo6992a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: a */
    public final boolean mo6993a(zzcu zzcuVar) {
        this.f6446m.lock();
        try {
            if ((!m7256e() && !mo6997d()) || this.f6438e.mo6997d()) {
                this.f6446m.unlock();
                return false;
            }
            this.f6440g.add(zzcuVar);
            if (this.f6447n == 0) {
                this.f6447n = 1;
            }
            this.f6444k = null;
            this.f6438e.mo6991a();
            return true;
        } finally {
            this.f6446m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: b */
    public final ConnectionResult mo6994b() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: b */
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T mo6995b(T t) {
        if (!m7247c((zzm<? extends Result, ? extends Api.zzb>) t)) {
            return (T) this.f6437d.mo6995b(t);
        }
        if (!m7254j()) {
            return (T) this.f6438e.mo6995b(t);
        }
        t.m7225c(new Status(4, null, m7255k()));
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: c */
    public final void mo6996c() {
        this.f6444k = null;
        this.f6443j = null;
        this.f6447n = 0;
        this.f6437d.mo6996c();
        this.f6438e.mo6996c();
        m7253i();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0026  */
    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean mo6997d() {
        /*
            r2 = this;
            r0 = 1
            java.util.concurrent.locks.Lock r1 = r2.f6446m
            r1.lock()
            com.google.android.gms.common.api.internal.zzbi r1 = r2.f6437d     // Catch: java.lang.Throwable -> L28
            boolean r1 = r1.mo6997d()     // Catch: java.lang.Throwable -> L28
            if (r1 == 0) goto L26
            com.google.android.gms.common.api.internal.zzbi r1 = r2.f6438e     // Catch: java.lang.Throwable -> L28
            boolean r1 = r1.mo6997d()     // Catch: java.lang.Throwable -> L28
            if (r1 != 0) goto L20
            boolean r1 = r2.m7254j()     // Catch: java.lang.Throwable -> L28
            if (r1 != 0) goto L20
            int r1 = r2.f6447n     // Catch: java.lang.Throwable -> L28
            if (r1 != r0) goto L26
        L20:
            java.util.concurrent.locks.Lock r1 = r2.f6446m
            r1.unlock()
            return r0
        L26:
            r0 = 0
            goto L20
        L28:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r2.f6446m
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzv.mo6997d():boolean");
    }

    /* JADX INFO: renamed from: e */
    public final boolean m7256e() {
        this.f6446m.lock();
        try {
            return this.f6447n == 2;
        } finally {
            this.f6446m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: f */
    public final void mo6999f() {
        this.f6446m.lock();
        try {
            boolean zM7256e = m7256e();
            this.f6438e.mo6996c();
            this.f6444k = new ConnectionResult(4);
            if (zM7256e) {
                new Handler(this.f6436c).post(new zzw(this));
            } else {
                m7253i();
            }
        } finally {
            this.f6446m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcc
    /* JADX INFO: renamed from: g */
    public final void mo7000g() {
        this.f6437d.mo7000g();
        this.f6438e.mo7000g();
    }
}
