package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.yalantis.ucrop.view.CropImageView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class StreetViewPanoramaCamera extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<StreetViewPanoramaCamera> CREATOR = new zzm();

    /* JADX INFO: renamed from: a */
    public final float f8360a;

    /* JADX INFO: renamed from: b */
    public final float f8361b;

    /* JADX INFO: renamed from: c */
    public final float f8362c;

    /* JADX INFO: renamed from: d */
    private final StreetViewPanoramaOrientation f8363d;

    public StreetViewPanoramaCamera(float f, float f2, float f3) {
        zzbq.m7383b(-90.0f <= f2 && f2 <= 90.0f, new StringBuilder(62).append("Tilt needs to be between -90 and 90 inclusive: ").append(f2).toString());
        this.f8360a = ((double) f) <= 0.0d ? 0.0f : f;
        this.f8361b = f2 + CropImageView.DEFAULT_ASPECT_RATIO;
        this.f8362c = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
        this.f8363d = new StreetViewPanoramaOrientation.Builder().m8906a(f2).m8908b(f3).m8907a();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaCamera)) {
            return false;
        }
        StreetViewPanoramaCamera streetViewPanoramaCamera = (StreetViewPanoramaCamera) obj;
        return Float.floatToIntBits(this.f8360a) == Float.floatToIntBits(streetViewPanoramaCamera.f8360a) && Float.floatToIntBits(this.f8361b) == Float.floatToIntBits(streetViewPanoramaCamera.f8361b) && Float.floatToIntBits(this.f8362c) == Float.floatToIntBits(streetViewPanoramaCamera.f8362c);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f8360a), Float.valueOf(this.f8361b), Float.valueOf(this.f8362c)});
    }

    public String toString() {
        return zzbg.m7370a(this).m7372a("zoom", Float.valueOf(this.f8360a)).m7372a("tilt", Float.valueOf(this.f8361b)).m7372a("bearing", Float.valueOf(this.f8362c)).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7737a(parcel, 2, this.f8360a);
        zzbfp.m7737a(parcel, 3, this.f8361b);
        zzbfp.m7737a(parcel, 4, this.f8362c);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
