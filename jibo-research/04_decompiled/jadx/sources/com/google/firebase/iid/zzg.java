package com.google.firebase.iid;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzg implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzd f8651a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzf f8652b;

    zzg(zzf zzfVar, zzd zzdVar) {
        this.f8652b = zzfVar;
        this.f8651a = zzdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        this.f8652b.f8650a.mo9117b(this.f8651a.f8644a);
        this.f8651a.m9128a();
    }
}
