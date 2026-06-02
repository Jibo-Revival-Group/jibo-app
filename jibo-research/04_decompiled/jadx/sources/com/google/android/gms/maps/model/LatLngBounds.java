package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class LatLngBounds extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<LatLngBounds> CREATOR = new zze();

    /* JADX INFO: renamed from: a */
    public final LatLng f8314a;

    /* JADX INFO: renamed from: b */
    public final LatLng f8315b;

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        zzbq.m7374a(latLng, "null southwest");
        zzbq.m7374a(latLng2, "null northeast");
        zzbq.m7384b(latLng2.f8312a >= latLng.f8312a, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(latLng.f8312a), Double.valueOf(latLng2.f8312a));
        this.f8314a = latLng;
        this.f8315b = latLng2;
    }

    /* JADX INFO: renamed from: a */
    public static LatLngBounds m8871a(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        Float fValueOf = typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_latLngBoundsSouthWestLatitude) ? Float.valueOf(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_latLngBoundsSouthWestLatitude, CropImageView.DEFAULT_ASPECT_RATIO)) : null;
        Float fValueOf2 = typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_latLngBoundsSouthWestLongitude) ? Float.valueOf(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_latLngBoundsSouthWestLongitude, CropImageView.DEFAULT_ASPECT_RATIO)) : null;
        Float fValueOf3 = typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_latLngBoundsNorthEastLatitude) ? Float.valueOf(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_latLngBoundsNorthEastLatitude, CropImageView.DEFAULT_ASPECT_RATIO)) : null;
        Float fValueOf4 = typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_latLngBoundsNorthEastLongitude) ? Float.valueOf(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_latLngBoundsNorthEastLongitude, CropImageView.DEFAULT_ASPECT_RATIO)) : null;
        if (fValueOf == null || fValueOf2 == null || fValueOf3 == null || fValueOf4 == null) {
            return null;
        }
        return new LatLngBounds(new LatLng(fValueOf.floatValue(), fValueOf2.floatValue()), new LatLng(fValueOf3.floatValue(), fValueOf4.floatValue()));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.f8314a.equals(latLngBounds.f8314a) && this.f8315b.equals(latLngBounds.f8315b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8314a, this.f8315b});
    }

    public final String toString() {
        return zzbg.m7370a(this).m7372a("southwest", this.f8314a).m7372a("northeast", this.f8315b).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 2, (Parcelable) this.f8314a, i, false);
        zzbfp.m7743a(parcel, 3, (Parcelable) this.f8315b, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
