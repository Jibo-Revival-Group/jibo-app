package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class StreetViewPanoramaOrientation extends zzbfm {
    public static final Parcelable.Creator<StreetViewPanoramaOrientation> CREATOR = new zzp();

    /* JADX INFO: renamed from: a */
    public final float f8369a;

    /* JADX INFO: renamed from: b */
    public final float f8370b;

    public static final class Builder {

        /* JADX INFO: renamed from: a */
        public float f8371a;

        /* JADX INFO: renamed from: b */
        public float f8372b;

        /* JADX INFO: renamed from: a */
        public final Builder m8906a(float f) {
            this.f8372b = f;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final StreetViewPanoramaOrientation m8907a() {
            return new StreetViewPanoramaOrientation(this.f8372b, this.f8371a);
        }

        /* JADX INFO: renamed from: b */
        public final Builder m8908b(float f) {
            this.f8371a = f;
            return this;
        }
    }

    public StreetViewPanoramaOrientation(float f, float f2) {
        zzbq.m7383b(-90.0f <= f && f <= 90.0f, new StringBuilder(62).append("Tilt needs to be between -90 and 90 inclusive: ").append(f).toString());
        this.f8369a = CropImageView.DEFAULT_ASPECT_RATIO + f;
        this.f8370b = (((double) f2) <= 0.0d ? (f2 % 360.0f) + 360.0f : f2) % 360.0f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaOrientation)) {
            return false;
        }
        StreetViewPanoramaOrientation streetViewPanoramaOrientation = (StreetViewPanoramaOrientation) obj;
        return Float.floatToIntBits(this.f8369a) == Float.floatToIntBits(streetViewPanoramaOrientation.f8369a) && Float.floatToIntBits(this.f8370b) == Float.floatToIntBits(streetViewPanoramaOrientation.f8370b);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f8369a), Float.valueOf(this.f8370b)});
    }

    public String toString() {
        return zzbg.m7370a(this).m7372a("tilt", Float.valueOf(this.f8369a)).m7372a("bearing", Float.valueOf(this.f8370b)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7737a(parcel, 2, this.f8369a);
        zzbfp.m7737a(parcel, 3, this.f8370b);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
