package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public final class zzl implements ServiceConnection {

    /* JADX INFO: renamed from: a */
    private final int f6626a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzd f6627b;

    public zzl(zzd zzdVar, int i) {
        this.f6627b = zzdVar;
        this.f6626a = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzay zzazVar;
        if (iBinder == null) {
            this.f6627b.m7408c(16);
            return;
        }
        synchronized (this.f6627b.f6605o) {
            zzd zzdVar = this.f6627b;
            if (iBinder == null) {
                zzazVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                zzazVar = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof zzay)) ? new zzaz(iBinder) : (zzay) iInterfaceQueryLocalInterface;
            }
            zzdVar.f6606p = zzazVar;
        }
        this.f6627b.m7419a(0, (Bundle) null, this.f6626a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f6627b.f6605o) {
            this.f6627b.f6606p = null;
        }
        this.f6627b.f6591a.sendMessage(this.f6627b.f6591a.obtainMessage(6, this.f6626a, 1));
    }
}
