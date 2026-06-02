package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzaz implements zzbh {

    /* JADX INFO: renamed from: a */
    private final zzbi f6228a;

    public zzaz(zzbi zzbiVar) {
        this.f6228a = zzbiVar;
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: a */
    public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T mo7014a(T t) {
        this.f6228a.f6269d.f6230a.add(t);
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: a */
    public final void mo7015a() {
        Iterator<Api.zze> it = this.f6228a.f6266a.values().iterator();
        while (it.hasNext()) {
            it.next().mo6861f();
        }
        this.f6228a.f6269d.f6232c = Collections.emptySet();
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: a */
    public final void mo7016a(int i) {
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: a */
    public final void mo7017a(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: a */
    public final void mo7018a(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: b */
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T mo7019b(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: b */
    public final boolean mo7020b() {
        return true;
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: c */
    public final void mo7021c() {
        this.f6228a.m7084e();
    }
}
