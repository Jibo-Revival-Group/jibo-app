package com.google.firebase.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class zzf extends Binder {

    /* JADX INFO: renamed from: a */
    private final zzb f8650a;

    zzf(zzb zzbVar) {
        this.f8650a = zzbVar;
    }

    /* JADX INFO: renamed from: a */
    public final void m9130a(zzd zzdVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "service received new intent via bind strategy");
        }
        if (this.f8650a.mo9127c(zzdVar.f8644a)) {
            zzdVar.m9128a();
            return;
        }
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "intent being queued for bg execution");
        }
        this.f8650a.f8636a.execute(new zzg(this, zzdVar));
    }
}
