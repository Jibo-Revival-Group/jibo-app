package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class VisibleRegion extends zzbfm {
    public static final Parcelable.Creator<VisibleRegion> CREATOR = new zzu();

    /* JADX INFO: renamed from: a */
    public final LatLng f8383a;

    /* JADX INFO: renamed from: b */
    public final LatLng f8384b;

    /* JADX INFO: renamed from: c */
    public final LatLng f8385c;

    /* JADX INFO: renamed from: d */
    public final LatLng f8386d;

    /* JADX INFO: renamed from: e */
    public final LatLngBounds f8387e;

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.f8383a = latLng;
        this.f8384b = latLng2;
        this.f8385c = latLng3;
        this.f8386d = latLng4;
        this.f8387e = latLngBounds;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        return this.f8383a.equals(visibleRegion.f8383a) && this.f8384b.equals(visibleRegion.f8384b) && this.f8385c.equals(visibleRegion.f8385c) && this.f8386d.equals(visibleRegion.f8386d) && this.f8387e.equals(visibleRegion.f8387e);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8383a, this.f8384b, this.f8385c, this.f8386d, this.f8387e});
    }

    public final String toString() {
        return zzbg.m7370a(this).m7372a("nearLeft", this.f8383a).m7372a("nearRight", this.f8384b).m7372a("farLeft", this.f8385c).m7372a("farRight", this.f8386d).m7372a("latLngBounds", this.f8387e).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 2, (Parcelable) this.f8383a, i, false);
        zzbfp.m7743a(parcel, 3, (Parcelable) this.f8384b, i, false);
        zzbfp.m7743a(parcel, 4, (Parcelable) this.f8385c, i, false);
        zzbfp.m7743a(parcel, 5, (Parcelable) this.f8386d, i, false);
        zzbfp.m7743a(parcel, 6, (Parcelable) this.f8387e, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
