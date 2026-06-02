package com.google.android.gms.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzn extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ zzl f6836a;

    zzn(zzl zzlVar) {
        this.f6836a = zzlVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            Log.d("InstanceID/Rpc", "Received GSF callback via dynamic receiver");
        }
        this.f6836a.m7641b(intent);
    }
}
