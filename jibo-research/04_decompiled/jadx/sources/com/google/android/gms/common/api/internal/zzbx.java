package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public final class zzbx extends BroadcastReceiver {

    /* JADX INFO: renamed from: a */
    private Context f6329a;

    /* JADX INFO: renamed from: b */
    private final zzby f6330b;

    public zzbx(zzby zzbyVar) {
        this.f6330b = zzbyVar;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m7153a() {
        if (this.f6329a != null) {
            this.f6329a.unregisterReceiver(this);
        }
        this.f6329a = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m7154a(Context context) {
        this.f6329a = context;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f6330b.mo7077a();
            m7153a();
        }
    }
}
