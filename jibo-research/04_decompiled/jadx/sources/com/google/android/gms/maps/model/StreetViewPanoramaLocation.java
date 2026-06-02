package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class StreetViewPanoramaLocation extends zzbfm {
    public static final Parcelable.Creator<StreetViewPanoramaLocation> CREATOR = new zzo();

    /* JADX INFO: renamed from: a */
    public final StreetViewPanoramaLink[] f8366a;

    /* JADX INFO: renamed from: b */
    public final LatLng f8367b;

    /* JADX INFO: renamed from: c */
    public final String f8368c;

    public StreetViewPanoramaLocation(StreetViewPanoramaLink[] streetViewPanoramaLinkArr, LatLng latLng, String str) {
        this.f8366a = streetViewPanoramaLinkArr;
        this.f8367b = latLng;
        this.f8368c = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLocation)) {
            return false;
        }
        StreetViewPanoramaLocation streetViewPanoramaLocation = (StreetViewPanoramaLocation) obj;
        return this.f8368c.equals(streetViewPanoramaLocation.f8368c) && this.f8367b.equals(streetViewPanoramaLocation.f8367b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8367b, this.f8368c});
    }

    public String toString() {
        return zzbg.m7370a(this).m7372a("panoId", this.f8368c).m7372a("position", this.f8367b.toString()).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7754a(parcel, 2, (Parcelable[]) this.f8366a, i, false);
        zzbfp.m7743a(parcel, 3, (Parcelable) this.f8367b, i, false);
        zzbfp.m7748a(parcel, 4, this.f8368c, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
