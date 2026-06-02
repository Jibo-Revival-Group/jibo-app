package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class LatLng extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLng> CREATOR = new zzf();

    /* JADX INFO: renamed from: a */
    public final double f8312a;

    /* JADX INFO: renamed from: b */
    public final double f8313b;

    public LatLng(double d, double d2) {
        if (-180.0d > d2 || d2 >= 180.0d) {
            this.f8313b = ((((d2 - 180.0d) % 360.0d) + 360.0d) % 360.0d) - 180.0d;
        } else {
            this.f8313b = d2;
        }
        this.f8312a = Math.max(-90.0d, Math.min(90.0d, d));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLng)) {
            return false;
        }
        LatLng latLng = (LatLng) obj;
        return Double.doubleToLongBits(this.f8312a) == Double.doubleToLongBits(latLng.f8312a) && Double.doubleToLongBits(this.f8313b) == Double.doubleToLongBits(latLng.f8313b);
    }

    public final int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.f8312a);
        int i = ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32))) + 31;
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.f8313b);
        return (i * 31) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
    }

    public final String toString() {
        double d = this.f8312a;
        return new StringBuilder(60).append("lat/lng: (").append(d).append(",").append(this.f8313b).append(")").toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7736a(parcel, 2, this.f8312a);
        zzbfp.m7736a(parcel, 3, this.f8313b);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
