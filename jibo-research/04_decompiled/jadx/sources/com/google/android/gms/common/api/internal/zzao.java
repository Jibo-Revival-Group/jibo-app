package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import com.google.android.gms.internal.zzcxq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public final class zzao implements zzbh {

    /* JADX INFO: renamed from: a */
    private final zzbi f6191a;

    /* JADX INFO: renamed from: b */
    private final Lock f6192b;

    /* JADX INFO: renamed from: c */
    private final Context f6193c;

    /* JADX INFO: renamed from: d */
    private final com.google.android.gms.common.zzf f6194d;

    /* JADX INFO: renamed from: e */
    private ConnectionResult f6195e;

    /* JADX INFO: renamed from: f */
    private int f6196f;

    /* JADX INFO: renamed from: h */
    private int f6198h;

    /* JADX INFO: renamed from: k */
    private zzcxd f6201k;

    /* JADX INFO: renamed from: l */
    private boolean f6202l;

    /* JADX INFO: renamed from: m */
    private boolean f6203m;

    /* JADX INFO: renamed from: n */
    private boolean f6204n;

    /* JADX INFO: renamed from: o */
    private com.google.android.gms.common.internal.zzan f6205o;

    /* JADX INFO: renamed from: p */
    private boolean f6206p;

    /* JADX INFO: renamed from: q */
    private boolean f6207q;

    /* JADX INFO: renamed from: r */
    private final com.google.android.gms.common.internal.zzr f6208r;

    /* JADX INFO: renamed from: s */
    private final Map<Api<?>, Boolean> f6209s;

    /* JADX INFO: renamed from: t */
    private final Api.zza<? extends zzcxd, zzcxe> f6210t;

    /* JADX INFO: renamed from: g */
    private int f6197g = 0;

    /* JADX INFO: renamed from: i */
    private final Bundle f6199i = new Bundle();

    /* JADX INFO: renamed from: j */
    private final Set<Api.zzc> f6200j = new HashSet();

    /* JADX INFO: renamed from: u */
    private ArrayList<Future<?>> f6211u = new ArrayList<>();

    public zzao(zzbi zzbiVar, com.google.android.gms.common.internal.zzr zzrVar, Map<Api<?>, Boolean> map, com.google.android.gms.common.zzf zzfVar, Api.zza<? extends zzcxd, zzcxe> zzaVar, Lock lock, Context context) {
        this.f6191a = zzbiVar;
        this.f6208r = zzrVar;
        this.f6209s = map;
        this.f6194d = zzfVar;
        this.f6210t = zzaVar;
        this.f6192b = lock;
        this.f6193c = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m7028a(zzcxq zzcxqVar) {
        if (m7035b(0)) {
            ConnectionResult connectionResultM8511a = zzcxqVar.m8511a();
            if (!connectionResultM8511a.m6821b()) {
                if (!m7030a(connectionResultM8511a)) {
                    m7033b(connectionResultM8511a);
                    return;
                } else {
                    m7046g();
                    m7041e();
                    return;
                }
            }
            com.google.android.gms.common.internal.zzbt zzbtVarM8512b = zzcxqVar.m8512b();
            ConnectionResult connectionResultM7387b = zzbtVarM8512b.m7387b();
            if (!connectionResultM7387b.m6821b()) {
                String strValueOf = String.valueOf(connectionResultM7387b);
                Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(strValueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(strValueOf).toString(), new Exception());
                m7033b(connectionResultM7387b);
            } else {
                this.f6204n = true;
                this.f6205o = zzbtVarM8512b.m7386a();
                this.f6206p = zzbtVarM8512b.m7388c();
                this.f6207q = zzbtVarM8512b.m7389d();
                m7041e();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m7029a(boolean z) {
        if (this.f6201k != null) {
            if (this.f6201k.m6862g() && z) {
                this.f6201k.mo8497e();
            }
            this.f6201k.mo6861f();
            this.f6205o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final boolean m7030a(ConnectionResult connectionResult) {
        return this.f6202l && !connectionResult.m6820a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final void m7033b(ConnectionResult connectionResult) {
        m7048h();
        m7029a(!connectionResult.m6820a());
        this.f6191a.m7080a(connectionResult);
        this.f6191a.f6270e.mo7071a(connectionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0015  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m7034b(com.google.android.gms.common.ConnectionResult r6, com.google.android.gms.common.api.Api<?> r7, boolean r8) {
        /*
            r5 = this;
            r1 = 0
            r0 = 1
            com.google.android.gms.common.api.Api$zzd r2 = r7.m6850a()
            int r3 = r2.m6856a()
            if (r8 == 0) goto L15
            boolean r2 = r6.m6820a()
            if (r2 == 0) goto L2f
            r2 = r0
        L13:
            if (r2 == 0) goto L3f
        L15:
            com.google.android.gms.common.ConnectionResult r2 = r5.f6195e
            if (r2 == 0) goto L1d
            int r2 = r5.f6196f
            if (r3 >= r2) goto L3f
        L1d:
            if (r0 == 0) goto L23
            r5.f6195e = r6
            r5.f6196f = r3
        L23:
            com.google.android.gms.common.api.internal.zzbi r0 = r5.f6191a
            java.util.Map<com.google.android.gms.common.api.Api$zzc<?>, com.google.android.gms.common.ConnectionResult> r0 = r0.f6267b
            com.google.android.gms.common.api.Api$zzc r1 = r7.m6852c()
            r0.put(r1, r6)
            return
        L2f:
            com.google.android.gms.common.zzf r2 = r5.f6194d
            int r4 = r6.m6822c()
            android.content.Intent r2 = r2.m7535c(r4)
            if (r2 == 0) goto L3d
            r2 = r0
            goto L13
        L3d:
            r2 = r1
            goto L13
        L3f:
            r0 = r1
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzao.m7034b(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.Api, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final boolean m7035b(int i) {
        if (this.f6197g == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.f6191a.f6269d.m7074n());
        String strValueOf = String.valueOf(this);
        Log.w("GoogleApiClientConnecting", new StringBuilder(String.valueOf(strValueOf).length() + 23).append("Unexpected callback in ").append(strValueOf).toString());
        Log.w("GoogleApiClientConnecting", new StringBuilder(33).append("mRemainingConnections=").append(this.f6198h).toString());
        String strM7037c = m7037c(this.f6197g);
        String strM7037c2 = m7037c(i);
        Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(strM7037c).length() + 70 + String.valueOf(strM7037c2).length()).append("GoogleApiClient connecting is in step ").append(strM7037c).append(" but received callback for step ").append(strM7037c2).toString(), new Exception());
        m7033b(new ConnectionResult(8, null));
        return false;
    }

    /* JADX INFO: renamed from: c */
    private static String m7037c(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public final boolean m7040d() {
        this.f6198h--;
        if (this.f6198h > 0) {
            return false;
        }
        if (this.f6198h < 0) {
            Log.w("GoogleApiClientConnecting", this.f6191a.f6269d.m7074n());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m7033b(new ConnectionResult(8, null));
            return false;
        }
        if (this.f6195e == null) {
            return true;
        }
        this.f6191a.f6268c = this.f6196f;
        m7033b(this.f6195e);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public final void m7041e() {
        if (this.f6198h != 0) {
            return;
        }
        if (!this.f6203m || this.f6204n) {
            ArrayList arrayList = new ArrayList();
            this.f6197g = 1;
            this.f6198h = this.f6191a.f6266a.size();
            for (Api.zzc<?> zzcVar : this.f6191a.f6266a.keySet()) {
                if (!this.f6191a.f6267b.containsKey(zzcVar)) {
                    arrayList.add(this.f6191a.f6266a.get(zzcVar));
                } else if (m7040d()) {
                    m7044f();
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            this.f6211u.add(zzbl.m7088a().submit(new zzau(this, arrayList)));
        }
    }

    /* JADX INFO: renamed from: f */
    private final void m7044f() {
        this.f6191a.m7085h();
        zzbl.m7088a().execute(new zzap(this));
        if (this.f6201k != null) {
            if (this.f6206p) {
                this.f6201k.mo8495a(this.f6205o, this.f6207q);
            }
            m7029a(false);
        }
        Iterator<Api.zzc<?>> it = this.f6191a.f6267b.keySet().iterator();
        while (it.hasNext()) {
            this.f6191a.f6266a.get(it.next()).mo6861f();
        }
        this.f6191a.f6270e.mo7070a(this.f6199i.isEmpty() ? null : this.f6199i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public final void m7046g() {
        this.f6203m = false;
        this.f6191a.f6269d.f6232c = Collections.emptySet();
        for (Api.zzc<?> zzcVar : this.f6200j) {
            if (!this.f6191a.f6267b.containsKey(zzcVar)) {
                this.f6191a.f6267b.put(zzcVar, new ConnectionResult(17, null));
            }
        }
    }

    /* JADX INFO: renamed from: h */
    private final void m7048h() {
        ArrayList<Future<?>> arrayList = this.f6211u;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Future<?> future = arrayList.get(i);
            i++;
            future.cancel(true);
        }
        this.f6211u.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i */
    public final Set<Scope> m7049i() {
        if (this.f6208r == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.f6208r.m7454d());
        Map<Api<?>, com.google.android.gms.common.internal.zzt> mapM7456f = this.f6208r.m7456f();
        for (Api<?> api : mapM7456f.keySet()) {
            if (!this.f6191a.f6267b.containsKey(api.m6852c())) {
                hashSet.addAll(mapM7456f.get(api).f6648a);
            }
        }
        return hashSet;
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: a */
    public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T mo7014a(T t) {
        this.f6191a.f6269d.f6230a.add(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: a */
    public final void mo7015a() {
        zzap zzapVar = null;
        this.f6191a.f6267b.clear();
        this.f6203m = false;
        this.f6195e = null;
        this.f6197g = 0;
        this.f6202l = true;
        this.f6204n = false;
        this.f6206p = false;
        HashMap map = new HashMap();
        boolean z = false;
        for (Api<?> api : this.f6209s.keySet()) {
            Api.zze zzeVar = this.f6191a.f6266a.get(api.m6852c());
            boolean z2 = (api.m6850a().m6856a() == 1) | z;
            boolean zBooleanValue = this.f6209s.get(api).booleanValue();
            if (zzeVar.mo6864i()) {
                this.f6203m = true;
                if (zBooleanValue) {
                    this.f6200j.add(api.m6852c());
                } else {
                    this.f6202l = false;
                }
            }
            map.put(zzeVar, new zzaq(this, api, zBooleanValue));
            z = z2;
        }
        if (z) {
            this.f6203m = false;
        }
        if (this.f6203m) {
            this.f6208r.m7451a(Integer.valueOf(System.identityHashCode(this.f6191a.f6269d)));
            zzax zzaxVar = new zzax(this, zzapVar);
            this.f6201k = (zzcxd) this.f6210t.mo6804a(this.f6193c, this.f6191a.f6269d.mo6899c(), this.f6208r, this.f6208r.m7459i(), zzaxVar, zzaxVar);
        }
        this.f6198h = this.f6191a.f6266a.size();
        this.f6211u.add(zzbl.m7088a().submit(new zzar(this, map)));
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: a */
    public final void mo7016a(int i) {
        m7033b(new ConnectionResult(8, null));
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: a */
    public final void mo7017a(Bundle bundle) {
        if (m7035b(1)) {
            if (bundle != null) {
                this.f6199i.putAll(bundle);
            }
            if (m7040d()) {
                m7044f();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: a */
    public final void mo7018a(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (m7035b(1)) {
            m7034b(connectionResult, api, z);
            if (m7040d()) {
                m7044f();
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: b */
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T mo7019b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: b */
    public final boolean mo7020b() {
        m7048h();
        m7029a(true);
        this.f6191a.m7080a((ConnectionResult) null);
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: c */
    public final void mo7021c() {
    }
}
