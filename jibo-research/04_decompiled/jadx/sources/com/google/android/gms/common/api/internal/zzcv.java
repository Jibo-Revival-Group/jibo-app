package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzcxa;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import com.google.android.gms.internal.zzcxi;
import com.google.android.gms.internal.zzcxq;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class zzcv extends zzcxi implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* JADX INFO: renamed from: a */
    private static Api.zza<? extends zzcxd, zzcxe> f6360a = zzcxa.f7767a;

    /* JADX INFO: renamed from: b */
    private final Context f6361b;

    /* JADX INFO: renamed from: c */
    private final Handler f6362c;

    /* JADX INFO: renamed from: d */
    private final Api.zza<? extends zzcxd, zzcxe> f6363d;

    /* JADX INFO: renamed from: e */
    private Set<Scope> f6364e;

    /* JADX INFO: renamed from: f */
    private com.google.android.gms.common.internal.zzr f6365f;

    /* JADX INFO: renamed from: g */
    private zzcxd f6366g;

    /* JADX INFO: renamed from: h */
    private zzcy f6367h;

    public zzcv(Context context, Handler handler, com.google.android.gms.common.internal.zzr zzrVar) {
        this(context, handler, zzrVar, f6360a);
    }

    public zzcv(Context context, Handler handler, com.google.android.gms.common.internal.zzr zzrVar, Api.zza<? extends zzcxd, zzcxe> zzaVar) {
        this.f6361b = context;
        this.f6362c = handler;
        this.f6365f = (com.google.android.gms.common.internal.zzr) com.google.android.gms.common.internal.zzbq.m7374a(zzrVar, "ClientSettings must not be null");
        this.f6364e = zzrVar.m7454d();
        this.f6363d = zzaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final void m7181b(zzcxq zzcxqVar) {
        ConnectionResult connectionResultM8511a = zzcxqVar.m8511a();
        if (connectionResultM8511a.m6821b()) {
            com.google.android.gms.common.internal.zzbt zzbtVarM8512b = zzcxqVar.m8512b();
            ConnectionResult connectionResultM7387b = zzbtVarM8512b.m7387b();
            if (!connectionResultM7387b.m6821b()) {
                String strValueOf = String.valueOf(connectionResultM7387b);
                Log.wtf("SignInCoordinator", new StringBuilder(String.valueOf(strValueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(strValueOf).toString(), new Exception());
                this.f6367h.mo7152b(connectionResultM7387b);
                this.f6366g.mo6861f();
                return;
            }
            this.f6367h.mo7151a(zzbtVarM8512b.m7386a(), this.f6364e);
        } else {
            this.f6367h.mo7152b(connectionResultM8511a);
        }
        this.f6366g.mo6861f();
    }

    /* JADX INFO: renamed from: a */
    public final zzcxd m7182a() {
        return this.f6366g;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public final void mo6914a(int i) {
        this.f6366g.mo6861f();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    /* JADX INFO: renamed from: a */
    public final void mo6915a(Bundle bundle) {
        this.f6366g.mo8496a(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    /* JADX INFO: renamed from: a */
    public final void mo6916a(ConnectionResult connectionResult) {
        this.f6367h.mo7152b(connectionResult);
    }

    /* JADX INFO: renamed from: a */
    public final void m7183a(zzcy zzcyVar) {
        if (this.f6366g != null) {
            this.f6366g.mo6861f();
        }
        this.f6365f.m7451a(Integer.valueOf(System.identityHashCode(this)));
        this.f6366g = (zzcxd) this.f6363d.mo6804a(this.f6361b, this.f6362c.getLooper(), this.f6365f, this.f6365f.m7459i(), this, this);
        this.f6367h = zzcyVar;
        if (this.f6364e == null || this.f6364e.isEmpty()) {
            this.f6362c.post(new zzcw(this));
        } else {
            this.f6366g.mo8498m();
        }
    }

    @Override // com.google.android.gms.internal.zzcxi, com.google.android.gms.internal.zzcxj
    /* JADX INFO: renamed from: a */
    public final void mo7056a(zzcxq zzcxqVar) {
        this.f6362c.post(new zzcx(this, zzcxqVar));
    }

    /* JADX INFO: renamed from: b */
    public final void m7184b() {
        if (this.f6366g != null) {
            this.f6366g.mo6861f();
        }
    }
}
