package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzm;

/* JADX INFO: loaded from: classes.dex */
public final class zzc<A extends zzm<? extends Result, Api.zzb>> extends zza {

    /* JADX INFO: renamed from: a */
    private A f6337a;

    public zzc(int i, A a) {
        super(i);
        this.f6337a = a;
    }

    @Override // com.google.android.gms.common.api.internal.zza
    /* JADX INFO: renamed from: a */
    public final void mo6961a(Status status) {
        this.f6337a.m7225c(status);
    }

    @Override // com.google.android.gms.common.api.internal.zza
    /* JADX INFO: renamed from: a */
    public final void mo6962a(zzae zzaeVar, boolean z) {
        zzaeVar.m7005a(this.f6337a, z);
    }

    @Override // com.google.android.gms.common.api.internal.zza
    /* JADX INFO: renamed from: a */
    public final void mo6963a(zzbo<?> zzboVar) throws DeadObjectException {
        this.f6337a.m7224b(zzboVar.m7132b());
    }
}
