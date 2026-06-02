package com.google.android.gms.iid;

import android.content.Intent;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zze implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Intent f6807a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzd f6808b;

    zze(zzd zzdVar, Intent intent) {
        this.f6808b = zzdVar;
        this.f6807a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String action = this.f6807a.getAction();
        Log.w("EnhancedIntentService", new StringBuilder(String.valueOf(action).length() + 61).append("Service took too long to process intent: ").append(action).append(" App may get closed.").toString());
        this.f6808b.m7619a();
    }
}
