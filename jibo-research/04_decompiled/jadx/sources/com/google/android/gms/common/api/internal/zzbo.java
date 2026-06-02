package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzbo<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zzu {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ zzbm f6302a;

    /* JADX INFO: renamed from: c */
    private final Api.zze f6304c;

    /* JADX INFO: renamed from: d */
    private final Api.zzb f6305d;

    /* JADX INFO: renamed from: e */
    private final zzh<O> f6306e;

    /* JADX INFO: renamed from: f */
    private final zzae f6307f;

    /* JADX INFO: renamed from: i */
    private final int f6310i;

    /* JADX INFO: renamed from: j */
    private final zzcv f6311j;

    /* JADX INFO: renamed from: k */
    private boolean f6312k;

    /* JADX INFO: renamed from: b */
    private final Queue<zza> f6303b = new LinkedList();

    /* JADX INFO: renamed from: g */
    private final Set<zzj> f6308g = new HashSet();

    /* JADX INFO: renamed from: h */
    private final Map<zzck<?>, zzcr> f6309h = new HashMap();

    /* JADX INFO: renamed from: l */
    private ConnectionResult f6313l = null;

    public zzbo(zzbm zzbmVar, GoogleApi<O> googleApi) {
        this.f6302a = zzbmVar;
        this.f6304c = googleApi.mo6873a(zzbmVar.f6300q.getLooper(), this);
        if (this.f6304c instanceof com.google.android.gms.common.internal.zzbz) {
            this.f6305d = com.google.android.gms.common.internal.zzbz.m7395e();
        } else {
            this.f6305d = this.f6304c;
        }
        this.f6306e = googleApi.m6877b();
        this.f6307f = new zzae();
        this.f6310i = googleApi.m6879c();
        if (this.f6304c.mo6864i()) {
            this.f6311j = googleApi.mo6875a(zzbmVar.f6291h, zzbmVar.f6300q);
        } else {
            this.f6311j = null;
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m7120b(zza zzaVar) {
        zzaVar.mo6962a(this.f6307f, m7142k());
        try {
            zzaVar.mo6963a((zzbo<?>) this);
        } catch (DeadObjectException e) {
            mo6914a(1);
            this.f6304c.mo6861f();
        }
    }

    /* JADX INFO: renamed from: c */
    private final void m7123c(ConnectionResult connectionResult) {
        for (zzj zzjVar : this.f6308g) {
            String strM6867l = null;
            if (connectionResult == ConnectionResult.f6064a) {
                strM6867l = this.f6304c.m6867l();
            }
            zzjVar.m7216a(this.f6306e, connectionResult, strM6867l);
        }
        this.f6308g.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: n */
    public final void m7124n() {
        m7135d();
        m7123c(ConnectionResult.f6064a);
        m7126p();
        Iterator<zzcr> it = this.f6309h.values().iterator();
        while (it.hasNext()) {
            try {
                it.next().f6356a.m7176a(this.f6305d, new TaskCompletionSource<>());
            } catch (DeadObjectException e) {
                mo6914a(1);
                this.f6304c.mo6861f();
            } catch (RemoteException e2) {
            }
        }
        while (this.f6304c.m6862g() && !this.f6303b.isEmpty()) {
            m7120b(this.f6303b.remove());
        }
        m7127q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: o */
    public final void m7125o() {
        m7135d();
        this.f6312k = true;
        this.f6307f.m7008c();
        this.f6302a.f6300q.sendMessageDelayed(Message.obtain(this.f6302a.f6300q, 9, this.f6306e), this.f6302a.f6288c);
        this.f6302a.f6300q.sendMessageDelayed(Message.obtain(this.f6302a.f6300q, 11, this.f6306e), this.f6302a.f6289d);
        this.f6302a.f6293j = -1;
    }

    /* JADX INFO: renamed from: p */
    private final void m7126p() {
        if (this.f6312k) {
            this.f6302a.f6300q.removeMessages(11, this.f6306e);
            this.f6302a.f6300q.removeMessages(9, this.f6306e);
            this.f6312k = false;
        }
    }

    /* JADX INFO: renamed from: q */
    private final void m7127q() {
        this.f6302a.f6300q.removeMessages(12, this.f6306e);
        this.f6302a.f6300q.sendMessageDelayed(this.f6302a.f6300q.obtainMessage(12, this.f6306e), this.f6302a.f6290e);
    }

    /* JADX INFO: renamed from: a */
    public final void m7128a() {
        com.google.android.gms.common.internal.zzbq.m7377a(this.f6302a.f6300q);
        m7129a(zzbm.f6284a);
        this.f6307f.m7007b();
        for (zzck zzckVar : (zzck[]) this.f6309h.keySet().toArray(new zzck[this.f6309h.size()])) {
            m7130a(new zzf(zzckVar, new TaskCompletionSource()));
        }
        m7123c(new ConnectionResult(4));
        if (this.f6304c.m6862g()) {
            this.f6304c.m6859a(new zzbs(this));
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public final void mo6914a(int i) {
        if (Looper.myLooper() == this.f6302a.f6300q.getLooper()) {
            m7125o();
        } else {
            this.f6302a.f6300q.post(new zzbq(this));
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public final void mo6915a(Bundle bundle) {
        if (Looper.myLooper() == this.f6302a.f6300q.getLooper()) {
            m7124n();
        } else {
            this.f6302a.f6300q.post(new zzbp(this));
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    /* JADX INFO: renamed from: a */
    public final void mo6916a(ConnectionResult connectionResult) {
        com.google.android.gms.common.internal.zzbq.m7377a(this.f6302a.f6300q);
        if (this.f6311j != null) {
            this.f6311j.m7184b();
        }
        m7135d();
        this.f6302a.f6293j = -1;
        m7123c(connectionResult);
        if (connectionResult.m6822c() == 4) {
            m7129a(zzbm.f6285b);
            return;
        }
        if (this.f6303b.isEmpty()) {
            this.f6313l = connectionResult;
            return;
        }
        synchronized (zzbm.f6286f) {
            if (this.f6302a.f6297n != null && this.f6302a.f6298o.contains(this.f6306e)) {
                this.f6302a.f6297n.m7229b(connectionResult, this.f6310i);
            } else if (!this.f6302a.m7112a(connectionResult, this.f6310i)) {
                if (connectionResult.m6822c() == 18) {
                    this.f6312k = true;
                }
                if (this.f6312k) {
                    this.f6302a.f6300q.sendMessageDelayed(Message.obtain(this.f6302a.f6300q, 9, this.f6306e), this.f6302a.f6288c);
                } else {
                    String strM7210a = this.f6306e.m7210a();
                    m7129a(new Status(17, new StringBuilder(String.valueOf(strM7210a).length() + 38).append("API: ").append(strM7210a).append(" is not available on this device.").toString()));
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzu
    /* JADX INFO: renamed from: a */
    public final void mo7081a(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (Looper.myLooper() == this.f6302a.f6300q.getLooper()) {
            mo6916a(connectionResult);
        } else {
            this.f6302a.f6300q.post(new zzbr(this, connectionResult));
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m7129a(Status status) {
        com.google.android.gms.common.internal.zzbq.m7377a(this.f6302a.f6300q);
        Iterator<zza> it = this.f6303b.iterator();
        while (it.hasNext()) {
            it.next().mo6961a(status);
        }
        this.f6303b.clear();
    }

    /* JADX INFO: renamed from: a */
    public final void m7130a(zza zzaVar) {
        com.google.android.gms.common.internal.zzbq.m7377a(this.f6302a.f6300q);
        if (this.f6304c.m6862g()) {
            m7120b(zzaVar);
            m7127q();
            return;
        }
        this.f6303b.add(zzaVar);
        if (this.f6313l == null || !this.f6313l.m6820a()) {
            m7140i();
        } else {
            mo6916a(this.f6313l);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m7131a(zzj zzjVar) {
        com.google.android.gms.common.internal.zzbq.m7377a(this.f6302a.f6300q);
        this.f6308g.add(zzjVar);
    }

    /* JADX INFO: renamed from: b */
    public final Api.zze m7132b() {
        return this.f6304c;
    }

    /* JADX INFO: renamed from: b */
    public final void m7133b(ConnectionResult connectionResult) {
        com.google.android.gms.common.internal.zzbq.m7377a(this.f6302a.f6300q);
        this.f6304c.mo6861f();
        mo6916a(connectionResult);
    }

    /* JADX INFO: renamed from: c */
    public final Map<zzck<?>, zzcr> m7134c() {
        return this.f6309h;
    }

    /* JADX INFO: renamed from: d */
    public final void m7135d() {
        com.google.android.gms.common.internal.zzbq.m7377a(this.f6302a.f6300q);
        this.f6313l = null;
    }

    /* JADX INFO: renamed from: e */
    public final ConnectionResult m7136e() {
        com.google.android.gms.common.internal.zzbq.m7377a(this.f6302a.f6300q);
        return this.f6313l;
    }

    /* JADX INFO: renamed from: f */
    public final void m7137f() {
        com.google.android.gms.common.internal.zzbq.m7377a(this.f6302a.f6300q);
        if (this.f6312k) {
            m7140i();
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m7138g() {
        com.google.android.gms.common.internal.zzbq.m7377a(this.f6302a.f6300q);
        if (this.f6312k) {
            m7126p();
            m7129a(this.f6302a.f6292i.mo6834a(this.f6302a.f6291h) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
            this.f6304c.mo6861f();
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m7139h() {
        com.google.android.gms.common.internal.zzbq.m7377a(this.f6302a.f6300q);
        if (this.f6304c.m6862g() && this.f6309h.size() == 0) {
            if (this.f6307f.m7006a()) {
                m7127q();
            } else {
                this.f6304c.mo6861f();
            }
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m7140i() {
        com.google.android.gms.common.internal.zzbq.m7377a(this.f6302a.f6300q);
        if (this.f6304c.m6862g() || this.f6304c.m6863h()) {
            return;
        }
        if (this.f6304c.m6865j() && this.f6302a.f6293j != 0) {
            this.f6302a.f6293j = this.f6302a.f6292i.mo6834a(this.f6302a.f6291h);
            if (this.f6302a.f6293j != 0) {
                mo6916a(new ConnectionResult(this.f6302a.f6293j, null));
                return;
            }
        }
        zzbu zzbuVar = new zzbu(this.f6302a, this.f6304c, this.f6306e);
        if (this.f6304c.mo6864i()) {
            this.f6311j.m7183a(zzbuVar);
        }
        this.f6304c.m6858a(zzbuVar);
    }

    /* JADX INFO: renamed from: j */
    final boolean m7141j() {
        return this.f6304c.m6862g();
    }

    /* JADX INFO: renamed from: k */
    public final boolean m7142k() {
        return this.f6304c.mo6864i();
    }

    /* JADX INFO: renamed from: l */
    public final int m7143l() {
        return this.f6310i;
    }

    /* JADX INFO: renamed from: m */
    final zzcxd m7144m() {
        if (this.f6311j == null) {
            return null;
        }
        return this.f6311j.m7182a();
    }
}
