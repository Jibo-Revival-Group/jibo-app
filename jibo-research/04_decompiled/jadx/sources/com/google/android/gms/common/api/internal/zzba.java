package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzbft;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes.dex */
public final class zzba extends GoogleApiClient implements zzcd {

    /* JADX INFO: renamed from: b */
    final Map<Api.zzc<?>, Api.zze> f6231b;

    /* JADX INFO: renamed from: e */
    final zzdj f6234e;

    /* JADX INFO: renamed from: f */
    private final Lock f6235f;

    /* JADX INFO: renamed from: h */
    private final com.google.android.gms.common.internal.zzae f6237h;

    /* JADX INFO: renamed from: j */
    private final int f6239j;

    /* JADX INFO: renamed from: k */
    private final Context f6240k;

    /* JADX INFO: renamed from: l */
    private final Looper f6241l;

    /* JADX INFO: renamed from: m */
    private volatile boolean f6242m;

    /* JADX INFO: renamed from: p */
    private final zzbf f6245p;

    /* JADX INFO: renamed from: q */
    private final GoogleApiAvailability f6246q;

    /* JADX INFO: renamed from: r */
    private zzbx f6247r;

    /* JADX INFO: renamed from: s */
    private com.google.android.gms.common.internal.zzr f6248s;

    /* JADX INFO: renamed from: t */
    private Map<Api<?>, Boolean> f6249t;

    /* JADX INFO: renamed from: u */
    private Api.zza<? extends zzcxd, zzcxe> f6250u;

    /* JADX INFO: renamed from: w */
    private final ArrayList<zzt> f6252w;

    /* JADX INFO: renamed from: x */
    private Integer f6253x;

    /* JADX INFO: renamed from: i */
    private zzcc f6238i = null;

    /* JADX INFO: renamed from: a */
    final Queue<zzm<?, ?>> f6230a = new LinkedList();

    /* JADX INFO: renamed from: n */
    private long f6243n = 120000;

    /* JADX INFO: renamed from: o */
    private long f6244o = 5000;

    /* JADX INFO: renamed from: c */
    Set<Scope> f6232c = new HashSet();

    /* JADX INFO: renamed from: v */
    private final zzcm f6251v = new zzcm();

    /* JADX INFO: renamed from: d */
    Set<zzdg> f6233d = null;

    /* JADX INFO: renamed from: y */
    private final com.google.android.gms.common.internal.zzaf f6254y = new zzbb(this);

    /* JADX INFO: renamed from: g */
    private boolean f6236g = false;

    public zzba(Context context, Lock lock, Looper looper, com.google.android.gms.common.internal.zzr zzrVar, GoogleApiAvailability googleApiAvailability, Api.zza<? extends zzcxd, zzcxe> zzaVar, Map<Api<?>, Boolean> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.zzc<?>, Api.zze> map2, int i, int i2, ArrayList<zzt> arrayList, boolean z) {
        this.f6253x = null;
        this.f6240k = context;
        this.f6235f = lock;
        this.f6237h = new com.google.android.gms.common.internal.zzae(looper, this.f6254y);
        this.f6241l = looper;
        this.f6245p = new zzbf(this, looper);
        this.f6246q = googleApiAvailability;
        this.f6239j = i;
        if (this.f6239j >= 0) {
            this.f6253x = Integer.valueOf(i2);
        }
        this.f6249t = map;
        this.f6231b = map2;
        this.f6252w = arrayList;
        this.f6234e = new zzdj(this.f6231b);
        Iterator<GoogleApiClient.ConnectionCallbacks> it = list.iterator();
        while (it.hasNext()) {
            this.f6237h.m7322a(it.next());
        }
        Iterator<GoogleApiClient.OnConnectionFailedListener> it2 = list2.iterator();
        while (it2.hasNext()) {
            this.f6237h.m7323a(it2.next());
        }
        this.f6248s = zzrVar;
        this.f6250u = zzaVar;
    }

    /* JADX INFO: renamed from: a */
    public static int m7058a(Iterable<Api.zze> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Api.zze zzeVar : iterable) {
            if (zzeVar.mo6864i()) {
                z3 = true;
            }
            z2 = zzeVar.mo6771c() ? true : z2;
        }
        if (z3) {
            return (z2 && z) ? 2 : 1;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m7059a(GoogleApiClient googleApiClient, zzda zzdaVar, boolean z) {
        zzbft.f6933c.mo7766a(googleApiClient).mo6920a(new zzbe(this, zzdaVar, z, googleApiClient));
    }

    /* JADX INFO: renamed from: b */
    private final void m7062b(int i) {
        if (this.f6253x == null) {
            this.f6253x = Integer.valueOf(i);
        } else if (this.f6253x.intValue() != i) {
            String strM7065c = m7065c(i);
            String strM7065c2 = m7065c(this.f6253x.intValue());
            throw new IllegalStateException(new StringBuilder(String.valueOf(strM7065c).length() + 51 + String.valueOf(strM7065c2).length()).append("Cannot use sign-in mode: ").append(strM7065c).append(". Mode was already set to ").append(strM7065c2).toString());
        }
        if (this.f6238i != null) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (Api.zze zzeVar : this.f6231b.values()) {
            if (zzeVar.mo6864i()) {
                z2 = true;
            }
            z = zzeVar.mo6771c() ? true : z;
        }
        switch (this.f6253x.intValue()) {
            case 1:
                if (!z2) {
                    throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                }
                if (z) {
                    throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
                break;
            case 2:
                if (z2) {
                    if (this.f6236g) {
                        this.f6238i = new zzaa(this.f6240k, this.f6235f, this.f6241l, this.f6246q, this.f6231b, this.f6248s, this.f6249t, this.f6250u, this.f6252w, this, true);
                        return;
                    } else {
                        this.f6238i = zzv.m7236a(this.f6240k, this, this.f6235f, this.f6241l, this.f6246q, this.f6231b, this.f6248s, this.f6249t, this.f6250u, this.f6252w);
                        return;
                    }
                }
                break;
        }
        if (!this.f6236g || z) {
            this.f6238i = new zzbi(this.f6240k, this, this.f6235f, this.f6241l, this.f6246q, this.f6231b, this.f6248s, this.f6249t, this.f6250u, this.f6252w, this);
        } else {
            this.f6238i = new zzaa(this.f6240k, this.f6235f, this.f6241l, this.f6246q, this.f6231b, this.f6248s, this.f6249t, this.f6250u, this.f6252w, this, false);
        }
    }

    /* JADX INFO: renamed from: c */
    private static String m7065c(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    /* JADX INFO: renamed from: o */
    private final void m7066o() {
        this.f6237h.m7324b();
        this.f6238i.mo6991a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: p */
    public final void m7067p() {
        this.f6235f.lock();
        try {
            if (this.f6242m) {
                m7066o();
            }
        } finally {
            this.f6235f.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q */
    public final void m7068q() {
        this.f6235f.lock();
        try {
            if (m7072l()) {
                m7066o();
            }
        } finally {
            this.f6235f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: a */
    public final <C extends Api.zze> C mo6888a(Api.zzc<C> zzcVar) {
        C c = (C) this.f6231b.get(zzcVar);
        com.google.android.gms.common.internal.zzbq.m7374a(c, "Appropriate Api was not requested.");
        return c;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: a */
    public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T mo6889a(T t) {
        com.google.android.gms.common.internal.zzbq.m7383b(t.m7226g() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean zContainsKey = this.f6231b.containsKey(t.m7226g());
        String strM6853d = t.m7227h() != null ? t.m7227h().m6853d() : "the API";
        com.google.android.gms.common.internal.zzbq.m7383b(zContainsKey, new StringBuilder(String.valueOf(strM6853d).length() + 65).append("GoogleApiClient is not configured to use ").append(strM6853d).append(" required for this call.").toString());
        this.f6235f.lock();
        try {
            if (this.f6238i == null) {
                this.f6230a.add(t);
            } else {
                t = (T) this.f6238i.mo6990a(t);
            }
            return t;
        } finally {
            this.f6235f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: a */
    public final void mo6890a(int i) {
        boolean z = true;
        this.f6235f.lock();
        if (i != 3 && i != 1 && i != 2) {
            z = false;
        }
        try {
            com.google.android.gms.common.internal.zzbq.m7383b(z, new StringBuilder(33).append("Illegal sign-in mode: ").append(i).toString());
            m7062b(i);
            m7066o();
        } finally {
            this.f6235f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    /* JADX INFO: renamed from: a */
    public final void mo7069a(int i, boolean z) {
        if (i == 1 && !z && !this.f6242m) {
            this.f6242m = true;
            if (this.f6247r == null) {
                this.f6247r = GoogleApiAvailability.m6829a(this.f6240k.getApplicationContext(), new zzbg(this));
            }
            this.f6245p.sendMessageDelayed(this.f6245p.obtainMessage(1), this.f6243n);
            this.f6245p.sendMessageDelayed(this.f6245p.obtainMessage(2), this.f6244o);
        }
        this.f6234e.m7204b();
        this.f6237h.m7319a(i);
        this.f6237h.m7318a();
        if (i == 2) {
            m7066o();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    /* JADX INFO: renamed from: a */
    public final void mo7070a(Bundle bundle) {
        while (!this.f6230a.isEmpty()) {
            mo6896b(this.f6230a.remove());
        }
        this.f6237h.m7320a(bundle);
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    /* JADX INFO: renamed from: a */
    public final void mo7071a(ConnectionResult connectionResult) {
        if (!com.google.android.gms.common.zzf.m7531b(this.f6240k, connectionResult.m6822c())) {
            m7072l();
        }
        if (this.f6242m) {
            return;
        }
        this.f6237h.m7321a(connectionResult);
        this.f6237h.m7318a();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: a */
    public final void mo6891a(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f6237h.m7323a(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: a */
    public final void mo6892a(zzdg zzdgVar) {
        this.f6235f.lock();
        try {
            if (this.f6233d == null) {
                this.f6233d = new HashSet();
            }
            this.f6233d.add(zzdgVar);
        } finally {
            this.f6235f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: a */
    public final void mo6893a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.f6240k);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.f6242m);
        printWriter.append(" mWorkQueue.size()=").print(this.f6230a.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f6234e.f6392b.size());
        if (this.f6238i != null) {
            this.f6238i.mo6992a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: a */
    public final boolean mo6894a(zzcu zzcuVar) {
        return this.f6238i != null && this.f6238i.mo6993a(zzcuVar);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: b */
    public final Context mo6895b() {
        return this.f6240k;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: b */
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T mo6896b(T t) {
        com.google.android.gms.common.internal.zzbq.m7383b(t.m7226g() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean zContainsKey = this.f6231b.containsKey(t.m7226g());
        String strM6853d = t.m7227h() != null ? t.m7227h().m6853d() : "the API";
        com.google.android.gms.common.internal.zzbq.m7383b(zContainsKey, new StringBuilder(String.valueOf(strM6853d).length() + 65).append("GoogleApiClient is not configured to use ").append(strM6853d).append(" required for this call.").toString());
        this.f6235f.lock();
        try {
            if (this.f6238i == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.f6242m) {
                this.f6230a.add(t);
                while (!this.f6230a.isEmpty()) {
                    zzm<?, ?> zzmVarRemove = this.f6230a.remove();
                    this.f6234e.m7203a(zzmVarRemove);
                    zzmVarRemove.m7225c(Status.f6131c);
                }
            } else {
                t = (T) this.f6238i.mo6995b(t);
            }
            return t;
        } finally {
            this.f6235f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: b */
    public final void mo6897b(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f6237h.m7325b(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: b */
    public final void mo6898b(zzdg zzdgVar) {
        this.f6235f.lock();
        try {
            if (this.f6233d == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.f6233d.remove(zzdgVar)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!m7073m()) {
                this.f6238i.mo7000g();
            }
        } finally {
            this.f6235f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: c */
    public final Looper mo6899c() {
        return this.f6241l;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: d */
    public final void mo6900d() {
        if (this.f6238i != null) {
            this.f6238i.mo6999f();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: e */
    public final void mo6901e() {
        this.f6235f.lock();
        try {
            if (this.f6239j >= 0) {
                com.google.android.gms.common.internal.zzbq.m7379a(this.f6253x != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f6253x == null) {
                this.f6253x = Integer.valueOf(m7058a((Iterable<Api.zze>) this.f6231b.values(), false));
            } else if (this.f6253x.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            mo6890a(this.f6253x.intValue());
        } finally {
            this.f6235f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: f */
    public final ConnectionResult mo6902f() {
        com.google.android.gms.common.internal.zzbq.m7379a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.f6235f.lock();
        try {
            if (this.f6239j >= 0) {
                com.google.android.gms.common.internal.zzbq.m7379a(this.f6253x != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f6253x == null) {
                this.f6253x = Integer.valueOf(m7058a((Iterable<Api.zze>) this.f6231b.values(), false));
            } else if (this.f6253x.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m7062b(this.f6253x.intValue());
            this.f6237h.m7324b();
            return this.f6238i.mo6994b();
        } finally {
            this.f6235f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: g */
    public final void mo6903g() {
        this.f6235f.lock();
        try {
            this.f6234e.m7202a();
            if (this.f6238i != null) {
                this.f6238i.mo6996c();
            }
            this.f6251v.m7174a();
            for (zzm<?, ?> zzmVar : this.f6230a) {
                zzmVar.m6943a((zzdm) null);
                zzmVar.mo6918a();
            }
            this.f6230a.clear();
            if (this.f6238i == null) {
                return;
            }
            m7072l();
            this.f6237h.m7318a();
        } finally {
            this.f6235f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: h */
    public final void mo6904h() {
        mo6903g();
        mo6901e();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: i */
    public final PendingResult<Status> mo6905i() {
        com.google.android.gms.common.internal.zzbq.m7379a(mo6906j(), "GoogleApiClient is not connected yet.");
        com.google.android.gms.common.internal.zzbq.m7379a(this.f6253x.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        zzda zzdaVar = new zzda(this);
        if (this.f6231b.containsKey(zzbft.f6931a)) {
            m7059a(this, zzdaVar, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient googleApiClientM6913b = new GoogleApiClient.Builder(this.f6240k).m6908a(zzbft.f6932b).m6910a(new zzbc(this, atomicReference, zzdaVar)).m6911a(new zzbd(this, zzdaVar)).m6907a(this.f6245p).m6913b();
            atomicReference.set(googleApiClientM6913b);
            googleApiClientM6913b.mo6901e();
        }
        return zzdaVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    /* JADX INFO: renamed from: j */
    public final boolean mo6906j() {
        return this.f6238i != null && this.f6238i.mo6997d();
    }

    /* JADX INFO: renamed from: l */
    final boolean m7072l() {
        if (!this.f6242m) {
            return false;
        }
        this.f6242m = false;
        this.f6245p.removeMessages(2);
        this.f6245p.removeMessages(1);
        if (this.f6247r != null) {
            this.f6247r.m7153a();
            this.f6247r = null;
        }
        return true;
    }

    /* JADX INFO: renamed from: m */
    final boolean m7073m() {
        this.f6235f.lock();
        try {
            if (this.f6233d != null) {
                z = this.f6233d.isEmpty() ? false : true;
            }
            return z;
        } finally {
            this.f6235f.unlock();
        }
    }

    /* JADX INFO: renamed from: n */
    final String m7074n() {
        StringWriter stringWriter = new StringWriter();
        mo6893a("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }
}
