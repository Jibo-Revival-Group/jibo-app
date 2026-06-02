package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zze implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ Intent f8648a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzd f8649b;

    zze(zzd zzdVar, Intent intent) {
        this.f8649b = zzdVar;
        this.f8648a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String action = this.f8648a.getAction();
        Log.w("EnhancedIntentService", new StringBuilder(String.valueOf(action).length() + 61).append("Service took too long to process intent: ").append(action).append(" App may get closed.").toString());
        this.f8649b.m9128a();
    }
}
