package com.google.android.gms.iid;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzg implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzd f6810a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzf f6811b;

    zzg(zzf zzfVar, zzd zzdVar) {
        this.f6811b = zzfVar;
        this.f6810a = zzdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        this.f6811b.f6809a.handleIntent(this.f6810a.f6803a);
        this.f6810a.m7619a();
    }
}
