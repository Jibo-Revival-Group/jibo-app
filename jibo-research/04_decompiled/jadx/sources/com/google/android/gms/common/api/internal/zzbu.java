package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
final class zzbu implements zzcy, com.google.android.gms.common.internal.zzj {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ zzbm f6320a;

    /* JADX INFO: renamed from: b */
    private final Api.zze f6321b;

    /* JADX INFO: renamed from: c */
    private final zzh<?> f6322c;

    /* JADX INFO: renamed from: d */
    private com.google.android.gms.common.internal.zzan f6323d = null;

    /* JADX INFO: renamed from: e */
    private Set<Scope> f6324e = null;

    /* JADX INFO: renamed from: f */
    private boolean f6325f = false;

    public zzbu(zzbm zzbmVar, Api.zze zzeVar, zzh<?> zzhVar) {
        this.f6320a = zzbmVar;
        this.f6321b = zzeVar;
        this.f6322c = zzhVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public final void m7147a() {
        if (!this.f6325f || this.f6323d == null) {
            return;
        }
        this.f6321b.m6857a(this.f6323d, this.f6324e);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m7148a(zzbu zzbuVar, boolean z) {
        zzbuVar.f6325f = true;
        return true;
    }

    @Override // com.google.android.gms.common.internal.zzj
    /* JADX INFO: renamed from: a */
    public final void mo7054a(ConnectionResult connectionResult) {
        this.f6320a.f6300q.post(new zzbv(this, connectionResult));
    }

    @Override // com.google.android.gms.common.api.internal.zzcy
    /* JADX INFO: renamed from: a */
    public final void mo7151a(com.google.android.gms.common.internal.zzan zzanVar, Set<Scope> set) {
        if (zzanVar == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            mo7152b(new ConnectionResult(4));
        } else {
            this.f6323d = zzanVar;
            this.f6324e = set;
            m7147a();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcy
    /* JADX INFO: renamed from: b */
    public final void mo7152b(ConnectionResult connectionResult) {
        ((zzbo) this.f6320a.f6296m.get(this.f6322c)).m7133b(connectionResult);
    }
}
