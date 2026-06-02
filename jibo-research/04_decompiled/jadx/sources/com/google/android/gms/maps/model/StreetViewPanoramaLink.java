package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class StreetViewPanoramaLink extends zzbfm {
    public static final Parcelable.Creator<StreetViewPanoramaLink> CREATOR = new zzn();

    /* JADX INFO: renamed from: a */
    public final String f8364a;

    /* JADX INFO: renamed from: b */
    public final float f8365b;

    public StreetViewPanoramaLink(String str, float f) {
        this.f8364a = str;
        this.f8365b = (((double) f) <= 0.0d ? (f % 360.0f) + 360.0f : f) % 360.0f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
        return this.f8364a.equals(streetViewPanoramaLink.f8364a) && Float.floatToIntBits(this.f8365b) == Float.floatToIntBits(streetViewPanoramaLink.f8365b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8364a, Float.valueOf(this.f8365b)});
    }

    public String toString() {
        return zzbg.m7370a(this).m7372a("panoId", this.f8364a).m7372a("bearing", Float.valueOf(this.f8365b)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 2, this.f8364a, false);
        zzbfp.m7737a(parcel, 3, this.f8365b);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
