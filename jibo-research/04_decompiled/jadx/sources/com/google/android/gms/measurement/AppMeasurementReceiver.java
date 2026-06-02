package com.google.android.gms.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.google.android.gms.internal.zzcid;
import com.google.android.gms.internal.zzcif;

/* JADX INFO: loaded from: classes.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzcif {

    /* JADX INFO: renamed from: a */
    private zzcid f8401a;

    @Override // com.google.android.gms.internal.zzcif
    /* JADX INFO: renamed from: a */
    public final BroadcastReceiver.PendingResult mo8146a() {
        return goAsync();
    }

    @Override // com.google.android.gms.internal.zzcif
    /* JADX INFO: renamed from: a */
    public final void mo8147a(Context context, Intent intent) {
        m1900a_(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (this.f8401a == null) {
            this.f8401a = new zzcid(this);
        }
        this.f8401a.m8145a(context, intent);
    }
}
