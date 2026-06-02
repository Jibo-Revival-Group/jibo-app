package com.google.android.gms.location.places;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.location.places.internal.zzab;
import com.google.android.gms.location.places.internal.zzad;
import com.google.android.gms.location.places.internal.zzy;

public class Places {
   public static final Api<PlacesOptions> a = new Api<>("Places.GEO_DATA_API", new com.google.android.gms.location.places.internal.zzp(), Places.e);
   public static final Api<PlacesOptions> b = new Api<>("Places.PLACE_DETECTION_API", new zzad(), Places.f);
   public static final GeoDataApi c = new com.google.android.gms.location.places.internal.zzh();
   public static final PlaceDetectionApi d = new zzy();
   private static Api.zzf<com.google.android.gms.location.places.internal.zzn> e = new Api.zzf<>();
   private static Api.zzf<zzab> f = new Api.zzf<>();
}
