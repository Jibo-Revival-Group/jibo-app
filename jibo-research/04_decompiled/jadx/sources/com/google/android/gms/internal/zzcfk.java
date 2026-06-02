package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.location.LocationAvailability;

/* JADX INFO: loaded from: classes.dex */
public final class zzcfk extends zzcdt {

    /* JADX INFO: renamed from: e */
    private final zzcfd f7017e;

    public zzcfk(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, zzr zzrVar) {
        super(context, looper, connectionCallbacks, onConnectionFailedListener, str, zzrVar);
        this.f7017e = new zzcfd(context, this.f6989d);
    }

    /* JADX INFO: renamed from: e */
    public final Location m7837e() throws RemoteException {
        return this.f7017e.m7829a();
    }

    @Override // com.google.android.gms.common.internal.zzd, com.google.android.gms.common.api.Api.zze
    /* JADX INFO: renamed from: f */
    public final void mo6861f() {
        synchronized (this.f7017e) {
            if (m7429g()) {
                try {
                    this.f7017e.m7832c();
                    this.f7017e.m7833d();
                } catch (Exception e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
                super.mo6861f();
            } else {
                super.mo6861f();
            }
        }
    }

    /* JADX INFO: renamed from: x */
    public final LocationAvailability m7838x() throws RemoteException {
        return this.f7017e.m7831b();
    }
}
