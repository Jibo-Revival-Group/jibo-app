package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
final class zzy implements zzcd {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzv f6450a;

    private zzy(zzv zzvVar) {
        this.f6450a = zzvVar;
    }

    /* synthetic */ zzy(zzv zzvVar, zzw zzwVar) {
        this(zzvVar);
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    /* JADX INFO: renamed from: a */
    public final void mo7069a(int i, boolean z) {
        this.f6450a.f6446m.lock();
        try {
            if (this.f6450a.f6445l) {
                this.f6450a.f6445l = false;
                this.f6450a.m7238a(i, z);
            } else {
                this.f6450a.f6445l = true;
                this.f6450a.f6437d.mo6914a(i);
            }
        } finally {
            this.f6450a.f6446m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    /* JADX INFO: renamed from: a */
    public final void mo7070a(Bundle bundle) {
        this.f6450a.f6446m.lock();
        try {
            this.f6450a.f6444k = ConnectionResult.f6064a;
            this.f6450a.m7252h();
        } finally {
            this.f6450a.f6446m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    /* JADX INFO: renamed from: a */
    public final void mo7071a(ConnectionResult connectionResult) {
        this.f6450a.f6446m.lock();
        try {
            this.f6450a.f6444k = connectionResult;
            this.f6450a.m7252h();
        } finally {
            this.f6450a.f6446m.unlock();
        }
    }
}
