package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzal implements zzbh {

    /* JADX INFO: renamed from: a */
    private final zzbi f6187a;

    /* JADX INFO: renamed from: b */
    private boolean f6188b = false;

    public zzal(zzbi zzbiVar) {
        this.f6187a = zzbiVar;
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: a */
    public final <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T mo7014a(T t) {
        return (T) mo7019b(t);
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: a */
    public final void mo7015a() {
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: a */
    public final void mo7016a(int i) {
        this.f6187a.m7080a((ConnectionResult) null);
        this.f6187a.f6270e.mo7069a(i, this.f6188b);
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
        try {
            this.f6187a.f6269d.f6234e.m7203a(t);
            zzba zzbaVar = this.f6187a.f6269d;
            Api.zze zzeVar = zzbaVar.f6231b.get(t.m7226g());
            com.google.android.gms.common.internal.zzbq.m7374a(zzeVar, "Appropriate Api was not requested.");
            if (zzeVar.m6862g() || !this.f6187a.f6267b.containsKey(t.m7226g())) {
                boolean z = zzeVar instanceof com.google.android.gms.common.internal.zzbz;
                A aM7395e = zzeVar;
                if (z) {
                    aM7395e = com.google.android.gms.common.internal.zzbz.m7395e();
                }
                t.m7224b(aM7395e);
            } else {
                t.m7225c(new Status(17));
            }
        } catch (DeadObjectException e) {
            this.f6187a.m7082a(new zzam(this, this));
        }
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: b */
    public final boolean mo7020b() {
        if (this.f6188b) {
            return false;
        }
        if (!this.f6187a.f6269d.m7073m()) {
            this.f6187a.m7080a((ConnectionResult) null);
            return true;
        }
        this.f6188b = true;
        Iterator<zzdg> it = this.f6187a.f6269d.f6233d.iterator();
        while (it.hasNext()) {
            it.next().m7200a();
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zzbh
    /* JADX INFO: renamed from: c */
    public final void mo7021c() {
        if (this.f6188b) {
            this.f6188b = false;
            this.f6187a.m7082a(new zzan(this, this));
        }
    }

    /* JADX INFO: renamed from: d */
    final void m7022d() {
        if (this.f6188b) {
            this.f6188b = false;
            this.f6187a.f6269d.f6234e.m7202a();
            mo7020b();
        }
    }
}
