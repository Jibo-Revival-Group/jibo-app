package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.measurement.AppMeasurement;

/* JADX INFO: loaded from: classes.dex */
final class zzckl implements Runnable {

    /* JADX INFO: renamed from: a */
    private /* synthetic */ AppMeasurement.zzb f7523a;

    /* JADX INFO: renamed from: b */
    private /* synthetic */ zzckg f7524b;

    zzckl(zzckg zzckgVar, AppMeasurement.zzb zzbVar) {
        this.f7524b = zzckgVar;
        this.f7523a = zzbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzche zzcheVar = this.f7524b.f7509b;
        if (zzcheVar == null) {
            this.f7524b.mo7872t().m8106y().m8108a("Failed to send current screen to service");
            return;
        }
        try {
            if (this.f7523a == null) {
                zzcheVar.mo8047a(0L, (String) null, (String) null, this.f7524b.mo7864l().getPackageName());
            } else {
                zzcheVar.mo8047a(this.f7523a.f8398d, this.f7523a.f8396b, this.f7523a.f8397c, this.f7524b.mo7864l().getPackageName());
            }
            this.f7524b.m8319F();
        } catch (RemoteException e) {
            this.f7524b.mo7872t().m8106y().m8109a("Failed to send current screen to the service", e);
        }
    }
}
