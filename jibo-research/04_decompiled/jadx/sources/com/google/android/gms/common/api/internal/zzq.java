package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;

/* JADX INFO: loaded from: classes.dex */
final class zzq implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ zzo f6427a;

    /* JADX INFO: renamed from: b */
    private final zzp f6428b;

    zzq(zzo zzoVar, zzp zzpVar) {
        this.f6427a = zzoVar;
        this.f6428b = zzpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f6427a.f6421b) {
            ConnectionResult connectionResultM7232b = this.f6428b.m7232b();
            if (connectionResultM7232b.m6820a()) {
                this.f6427a.f6157a.startActivityForResult(GoogleApiActivity.m6885a(this.f6427a.m6950a(), connectionResultM7232b.m6823d(), this.f6428b.m7231a(), false), 1);
                return;
            }
            if (this.f6427a.f6423d.mo6840a(connectionResultM7232b.m6822c())) {
                this.f6427a.f6423d.m6841a(this.f6427a.m6950a(), this.f6427a.f6157a, connectionResultM7232b.m6822c(), 2, this.f6427a);
            } else if (connectionResultM7232b.m6822c() != 18) {
                this.f6427a.mo7010a(connectionResultM7232b, this.f6428b.m7231a());
            } else {
                GoogleApiAvailability.m6829a(this.f6427a.m6950a().getApplicationContext(), new zzr(this, GoogleApiAvailability.m6826a(this.f6427a.m6950a(), this.f6427a)));
            }
        }
    }
}
