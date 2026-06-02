package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzab extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    private zzaa f8635a;

    public zzab(zzaa zzaaVar) {
        this.f8635a = zzaaVar;
    }

    /* JADX INFO: renamed from: a */
    public final void m9124a() {
        if (FirebaseInstanceId.m9098h()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.f8635a.m9122a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f8635a != null && this.f8635a.m9123b()) {
            if (FirebaseInstanceId.m9098h()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.m9096a(this.f8635a, 0L);
            this.f8635a.m9122a().unregisterReceiver(this);
            this.f8635a = null;
        }
    }
}
