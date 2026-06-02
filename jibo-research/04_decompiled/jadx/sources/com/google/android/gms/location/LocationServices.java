package com.google.android.gms.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzceb;
import com.google.android.gms.internal.zzceq;
import com.google.android.gms.internal.zzcfk;
import com.google.android.gms.internal.zzcfv;

/* JADX INFO: loaded from: classes.dex */
public class LocationServices {

    /* JADX INFO: renamed from: e */
    private static final Api.zzf<zzcfk> f8069e = new Api.zzf<>();

    /* JADX INFO: renamed from: f */
    private static final Api.zza<zzcfk, Object> f8070f = new zzy();

    /* JADX INFO: renamed from: a */
    public static final Api<Object> f8065a = new Api<>("LocationServices.API", f8070f, f8069e);

    /* JADX INFO: renamed from: b */
    @Deprecated
    public static final FusedLocationProviderApi f8066b = new zzceb();

    /* JADX INFO: renamed from: c */
    @Deprecated
    public static final GeofencingApi f8067c = new zzceq();

    /* JADX INFO: renamed from: d */
    @Deprecated
    public static final SettingsApi f8068d = new zzcfv();

    /* JADX INFO: renamed from: a */
    public static zzcfk m8745a(GoogleApiClient googleApiClient) {
        zzbq.m7383b(googleApiClient != null, "GoogleApiClient parameter is required.");
        zzcfk zzcfkVar = (zzcfk) googleApiClient.mo6888a(f8069e);
        zzbq.m7379a(zzcfkVar != null, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
        return zzcfkVar;
    }
}
