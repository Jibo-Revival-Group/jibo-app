package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

/* JADX INFO: loaded from: classes.dex */
public final class StreetViewPanoramaOptions extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaOptions> CREATOR = new zzai();

    /* JADX INFO: renamed from: a */
    private StreetViewPanoramaCamera f8260a;

    /* JADX INFO: renamed from: b */
    private String f8261b;

    /* JADX INFO: renamed from: c */
    private LatLng f8262c;

    /* JADX INFO: renamed from: d */
    private Integer f8263d;

    /* JADX INFO: renamed from: e */
    private Boolean f8264e;

    /* JADX INFO: renamed from: f */
    private Boolean f8265f;

    /* JADX INFO: renamed from: g */
    private Boolean f8266g;

    /* JADX INFO: renamed from: h */
    private Boolean f8267h;

    /* JADX INFO: renamed from: i */
    private Boolean f8268i;

    public StreetViewPanoramaOptions() {
        this.f8264e = true;
        this.f8265f = true;
        this.f8266g = true;
        this.f8267h = true;
    }

    StreetViewPanoramaOptions(StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5) {
        this.f8264e = true;
        this.f8265f = true;
        this.f8266g = true;
        this.f8267h = true;
        this.f8260a = streetViewPanoramaCamera;
        this.f8262c = latLng;
        this.f8263d = num;
        this.f8261b = str;
        this.f8264e = zza.m8842a(b);
        this.f8265f = zza.m8842a(b2);
        this.f8266g = zza.m8842a(b3);
        this.f8267h = zza.m8842a(b4);
        this.f8268i = zza.m8842a(b5);
    }

    /* JADX INFO: renamed from: a */
    public final StreetViewPanoramaCamera m8837a() {
        return this.f8260a;
    }

    /* JADX INFO: renamed from: b */
    public final LatLng m8838b() {
        return this.f8262c;
    }

    /* JADX INFO: renamed from: c */
    public final Integer m8839c() {
        return this.f8263d;
    }

    /* JADX INFO: renamed from: d */
    public final String m8840d() {
        return this.f8261b;
    }

    public final String toString() {
        return zzbg.m7370a(this).m7372a("PanoramaId", this.f8261b).m7372a("Position", this.f8262c).m7372a("Radius", this.f8263d).m7372a("StreetViewPanoramaCamera", this.f8260a).m7372a("UserNavigationEnabled", this.f8264e).m7372a("ZoomGesturesEnabled", this.f8265f).m7372a("PanningGesturesEnabled", this.f8266g).m7372a("StreetNamesEnabled", this.f8267h).m7372a("UseViewLifecycleInFragment", this.f8268i).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 2, (Parcelable) m8837a(), i, false);
        zzbfp.m7748a(parcel, 3, m8840d(), false);
        zzbfp.m7743a(parcel, 4, (Parcelable) m8838b(), i, false);
        zzbfp.m7746a(parcel, 5, m8839c(), false);
        zzbfp.m7735a(parcel, 6, zza.m8841a(this.f8264e));
        zzbfp.m7735a(parcel, 7, zza.m8841a(this.f8265f));
        zzbfp.m7735a(parcel, 8, zza.m8841a(this.f8266g));
        zzbfp.m7735a(parcel, 9, zza.m8841a(this.f8267h));
        zzbfp.m7735a(parcel, 10, zza.m8841a(this.f8268i));
        zzbfp.m7734a(parcel, iM7733a);
    }
}
