package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.stats.zza;

/* JADX INFO: loaded from: classes.dex */
public final class zzcku implements ServiceConnection, zzf, zzg {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ zzckg f7561a;

    /* JADX INFO: renamed from: b */
    private volatile boolean f7562b;

    /* JADX INFO: renamed from: c */
    private volatile zzchl f7563c;

    protected zzcku(zzckg zzckgVar) {
        this.f7561a = zzckgVar;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m8349a(zzcku zzckuVar, boolean z) {
        zzckuVar.f7562b = false;
        return false;
    }

    /* JADX INFO: renamed from: a */
    public final void m8350a() {
        this.f7561a.mo7855c();
        Context contextMo7864l = this.f7561a.mo7864l();
        synchronized (this) {
            if (this.f7562b) {
                this.f7561a.mo7872t().m8101E().m8108a("Connection attempt already in progress");
                return;
            }
            if (this.f7563c != null) {
                this.f7561a.mo7872t().m8101E().m8108a("Already awaiting connection attempt");
                return;
            }
            this.f7563c = new zzchl(contextMo7864l, Looper.getMainLooper(), this, this);
            this.f7561a.mo7872t().m8101E().m8108a("Connecting to remote service");
            this.f7562b = true;
            this.f7563c.m7435r();
        }
    }

    @Override // com.google.android.gms.common.internal.zzf
    /* JADX INFO: renamed from: a */
    public final void mo7315a(int i) {
        zzbq.m7381b("MeasurementServiceConnection.onConnectionSuspended");
        this.f7561a.mo7872t().m8100D().m8108a("Service connection suspended");
        this.f7561a.mo7871s().m8173a(new zzcky(this));
    }

    /* JADX INFO: renamed from: a */
    public final void m8351a(Intent intent) {
        this.f7561a.mo7855c();
        Context contextMo7864l = this.f7561a.mo7864l();
        zza zzaVarM7483a = zza.m7483a();
        synchronized (this) {
            if (this.f7562b) {
                this.f7561a.mo7872t().m8101E().m8108a("Connection attempt already in progress");
                return;
            }
            this.f7561a.mo7872t().m8101E().m8108a("Using local app measurement service");
            this.f7562b = true;
            zzaVarM7483a.m7484a(contextMo7864l, intent, this.f7561a.f7508a, 129);
        }
    }

    @Override // com.google.android.gms.common.internal.zzf
    /* JADX INFO: renamed from: a */
    public final void mo7316a(Bundle bundle) {
        zzbq.m7381b("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                zzche zzcheVarM7439v = this.f7563c.m7439v();
                this.f7563c = null;
                this.f7561a.mo7871s().m8173a(new zzckx(this, zzcheVarM7439v));
            } catch (DeadObjectException | IllegalStateException e) {
                this.f7563c = null;
                this.f7562b = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.zzg
    /* JADX INFO: renamed from: a */
    public final void mo7317a(ConnectionResult connectionResult) {
        zzbq.m7381b("MeasurementServiceConnection.onConnectionFailed");
        zzchm zzchmVarM8234g = this.f7561a.f7441p.m8234g();
        if (zzchmVarM8234g != null) {
            zzchmVarM8234g.m8097A().m8109a("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f7562b = false;
            this.f7563c = null;
        }
        this.f7561a.mo7871s().m8173a(new zzckz(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzche zzchgVar;
        zzbq.m7381b("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f7562b = false;
                this.f7561a.mo7872t().m8106y().m8108a("Service connected with null binder");
                return;
            }
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    if (iBinder == null) {
                        zzchgVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                        zzchgVar = iInterfaceQueryLocalInterface instanceof zzche ? (zzche) iInterfaceQueryLocalInterface : new zzchg(iBinder);
                    }
                    try {
                        this.f7561a.mo7872t().m8101E().m8108a("Bound to IMeasurementService interface");
                    } catch (RemoteException e) {
                        this.f7561a.mo7872t().m8106y().m8108a("Service connect failed to get IMeasurementService");
                    }
                } else {
                    this.f7561a.mo7872t().m8106y().m8109a("Got binder with a wrong descriptor", interfaceDescriptor);
                    zzchgVar = null;
                }
            } catch (RemoteException e2) {
                zzchgVar = null;
            }
            if (zzchgVar == null) {
                this.f7562b = false;
                try {
                    zza.m7483a();
                    this.f7561a.mo7864l().unbindService(this.f7561a.f7508a);
                } catch (IllegalArgumentException e3) {
                }
            } else {
                this.f7561a.mo7871s().m8173a(new zzckv(this, zzchgVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbq.m7381b("MeasurementServiceConnection.onServiceDisconnected");
        this.f7561a.mo7872t().m8100D().m8108a("Service disconnected");
        this.f7561a.mo7871s().m8173a(new zzckw(this, componentName));
    }
}
