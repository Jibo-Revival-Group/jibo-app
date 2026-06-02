package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.location.places.internal.zzab;
import com.google.android.gms.location.places.internal.zzad;
import com.google.android.gms.location.places.internal.zzy;

/* JADX INFO: loaded from: classes.dex */
public class Places {

    /* JADX INFO: renamed from: e */
    private static Api.zzf<com.google.android.gms.location.places.internal.zzn> f8126e = new Api.zzf<>();

    /* JADX INFO: renamed from: f */
    private static Api.zzf<zzab> f8127f = new Api.zzf<>();

    /* JADX INFO: renamed from: a */
    public static final Api<PlacesOptions> f8122a = new Api<>("Places.GEO_DATA_API", new com.google.android.gms.location.places.internal.zzp(), f8126e);

    /* JADX INFO: renamed from: b */
    public static final Api<PlacesOptions> f8123b = new Api<>("Places.PLACE_DETECTION_API", new zzad(), f8127f);

    /* JADX INFO: renamed from: c */
    public static final GeoDataApi f8124c = new com.google.android.gms.location.places.internal.zzh();

    /* JADX INFO: renamed from: d */
    public static final PlaceDetectionApi f8125d = new zzy();
}
