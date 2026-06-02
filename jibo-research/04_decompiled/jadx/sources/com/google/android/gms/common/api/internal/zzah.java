package com.google.android.gms.common.api.internal;

import android.support.v4.util.ArraySet;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
public class zzah extends zzo {

    /* JADX INFO: renamed from: e */
    private final ArraySet<zzh<?>> f6184e;

    /* JADX INFO: renamed from: f */
    private zzbm f6185f;

    /* JADX INFO: renamed from: i */
    private final void m7009i() {
        if (this.f6184e.isEmpty()) {
            return;
        }
        this.f6185f.m7111a(this);
    }

    @Override // com.google.android.gms.common.api.internal.zzo
    /* JADX INFO: renamed from: a */
    protected final void mo7010a(ConnectionResult connectionResult, int i) {
        this.f6185f.m7113b(connectionResult, i);
    }

    @Override // com.google.android.gms.common.api.internal.zzo, com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: b */
    public final void mo6954b() {
        super.mo6954b();
        m7009i();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: c */
    public final void mo6956c() {
        super.mo6956c();
        m7009i();
    }

    @Override // com.google.android.gms.common.api.internal.zzo, com.google.android.gms.common.api.internal.LifecycleCallback
    /* JADX INFO: renamed from: d */
    public final void mo6957d() {
        super.mo6957d();
        this.f6185f.m7114b(this);
    }

    @Override // com.google.android.gms.common.api.internal.zzo
    /* JADX INFO: renamed from: f */
    protected final void mo7011f() {
        this.f6185f.m7116d();
    }

    /* JADX INFO: renamed from: g */
    final ArraySet<zzh<?>> m7012g() {
        return this.f6184e;
    }
}
