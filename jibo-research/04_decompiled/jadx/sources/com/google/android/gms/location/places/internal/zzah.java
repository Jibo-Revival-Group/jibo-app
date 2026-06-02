package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.location.places.PlaceLikelihood;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class zzah extends zzbfm implements PlaceLikelihood {
    public static final Parcelable.Creator<zzah> CREATOR = new zzai();

    /* JADX INFO: renamed from: a */
    private PlaceEntity f8175a;

    /* JADX INFO: renamed from: b */
    private float f8176b;

    zzah(PlaceEntity placeEntity, float f) {
        this.f8175a = placeEntity;
        this.f8176b = f;
    }

    /* JADX INFO: renamed from: a */
    public final float m8784a() {
        return this.f8176b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        zzah zzahVar = (zzah) obj;
        return this.f8175a.equals(zzahVar.f8175a) && this.f8176b == zzahVar.f8176b;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8175a, Float.valueOf(this.f8176b)});
    }

    public final String toString() {
        return zzbg.m7370a(this).m7372a("place", this.f8175a).m7372a("likelihood", Float.valueOf(this.f8176b)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 1, (Parcelable) this.f8175a, i, false);
        zzbfp.m7737a(parcel, 2, this.f8176b);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
