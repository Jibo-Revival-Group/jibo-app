package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

/* JADX INFO: loaded from: classes.dex */
public class zzcdt extends zzab<zzcez> {

    /* JADX INFO: renamed from: d */
    protected final zzcfu<zzcez> f6989d;

    /* JADX INFO: renamed from: e */
    private final String f6990e;

    public zzcdt(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, zzr zzrVar) {
        super(context, looper, 23, zzrVar, connectionCallbacks, onConnectionFailedListener);
        this.f6989d = new zzcdu(this);
        this.f6990e = str;
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ IInterface mo6768a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return iInterfaceQueryLocalInterface instanceof zzcez ? (zzcez) iInterfaceQueryLocalInterface : new zzcfa(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: b */
    protected final String mo6769b() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: b_ */
    protected final String mo6770b_() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: t */
    protected final Bundle mo7437t() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.f6990e);
        return bundle;
    }
}
