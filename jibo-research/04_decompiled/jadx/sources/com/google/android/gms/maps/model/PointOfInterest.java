package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class PointOfInterest extends zzbfm {
    public static final Parcelable.Creator<PointOfInterest> CREATOR = new zzj();

    /* JADX INFO: renamed from: a */
    public final LatLng f8335a;

    /* JADX INFO: renamed from: b */
    public final String f8336b;

    /* JADX INFO: renamed from: c */
    public final String f8337c;

    public PointOfInterest(LatLng latLng, String str, String str2) {
        this.f8335a = latLng;
        this.f8336b = str;
        this.f8337c = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 2, (Parcelable) this.f8335a, i, false);
        zzbfp.m7748a(parcel, 3, this.f8336b, false);
        zzbfp.m7748a(parcel, 4, this.f8337c, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
