package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlacesOptions;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class zzab extends com.google.android.gms.common.internal.zzab<zzq> {

    /* JADX INFO: renamed from: d */
    private final zzat f8168d;

    /* JADX INFO: renamed from: e */
    private final Locale f8169e;

    private zzab(Context context, Looper looper, com.google.android.gms.common.internal.zzr zzrVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, PlacesOptions placesOptions) {
        super(context, looper, 67, zzrVar, connectionCallbacks, onConnectionFailedListener);
        this.f8169e = Locale.getDefault();
        this.f8168d = new zzat(str, this.f8169e, zzrVar.m7452b() != null ? zzrVar.m7452b().name : null, null, 0);
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ IInterface mo6768a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
        return iInterfaceQueryLocalInterface instanceof zzq ? (zzq) iInterfaceQueryLocalInterface : new zzr(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: b */
    protected final String mo6769b() {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: b_ */
    protected final String mo6770b_() {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }
}
