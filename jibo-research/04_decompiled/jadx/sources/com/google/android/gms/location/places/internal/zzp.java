package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.places.PlacesOptions;

/* JADX INFO: loaded from: classes.dex */
public final class zzp extends Api.zza<zzn, PlacesOptions> {
    @Override // com.google.android.gms.common.api.Api.zza
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Api.zze mo6804a(Context context, Looper looper, com.google.android.gms.common.internal.zzr zzrVar, PlacesOptions placesOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        PlacesOptions placesOptions2 = placesOptions;
        return new zzn(context, looper, zzrVar, connectionCallbacks, onConnectionFailedListener, context.getPackageName(), placesOptions2 == null ? new PlacesOptions.Builder().m8772a() : placesOptions2);
    }
}
