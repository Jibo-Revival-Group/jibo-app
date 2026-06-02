package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes.dex */
final class zzx implements zzcd {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzv f6449a;

    private zzx(zzv zzvVar) {
        this.f6449a = zzvVar;
    }

    /* synthetic */ zzx(zzv zzvVar, zzw zzwVar) {
        this(zzvVar);
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    /* JADX INFO: renamed from: a */
    public final void mo7069a(int i, boolean z) {
        this.f6449a.f6446m.lock();
        try {
            if (this.f6449a.f6445l || this.f6449a.f6444k == null || !this.f6449a.f6444k.m6821b()) {
                this.f6449a.f6445l = false;
                this.f6449a.m7238a(i, z);
            } else {
                this.f6449a.f6445l = true;
                this.f6449a.f6438e.mo6914a(i);
            }
        } finally {
            this.f6449a.f6446m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    /* JADX INFO: renamed from: a */
    public final void mo7070a(Bundle bundle) {
        this.f6449a.f6446m.lock();
        try {
            this.f6449a.m7239a(bundle);
            this.f6449a.f6443j = ConnectionResult.f6064a;
            this.f6449a.m7252h();
        } finally {
            this.f6449a.f6446m.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzcd
    /* JADX INFO: renamed from: a */
    public final void mo7071a(ConnectionResult connectionResult) {
        this.f6449a.f6446m.lock();
        try {
            this.f6449a.f6443j = connectionResult;
            this.f6449a.m7252h();
        } finally {
            this.f6449a.f6446m.unlock();
        }
    }
}
