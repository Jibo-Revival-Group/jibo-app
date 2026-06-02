package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class zzf extends Binder {

    /* JADX INFO: renamed from: a */
    private final zzb f6809a;

    zzf(zzb zzbVar) {
        this.f6809a = zzbVar;
    }

    /* JADX INFO: renamed from: a */
    public final void m7621a(zzd zzdVar) {
        if (Binder.getCallingUid() != Process.myUid()) {
            throw new SecurityException("Binding only allowed within app");
        }
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "service received new intent via bind strategy");
        }
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "intent being queued for bg execution");
        }
        this.f6809a.f6795a.execute(new zzg(this, zzdVar));
    }
}
