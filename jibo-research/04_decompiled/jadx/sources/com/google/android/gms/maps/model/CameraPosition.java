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
public final class CameraPosition extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<CameraPosition> CREATOR = new zza();

    /* JADX INFO: renamed from: a */
    public final LatLng f8275a;

    /* JADX INFO: renamed from: b */
    public final float f8276b;

    /* JADX INFO: renamed from: c */
    public final float f8277c;

    /* JADX INFO: renamed from: d */
    public final float f8278d;

    public static final class Builder {

        /* JADX INFO: renamed from: a */
        private LatLng f8279a;

        /* JADX INFO: renamed from: b */
        private float f8280b;

        /* JADX INFO: renamed from: c */
        private float f8281c;

        /* JADX INFO: renamed from: d */
        private float f8282d;

        /* JADX INFO: renamed from: a */
        public final Builder m8846a(float f) {
            this.f8280b = f;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final Builder m8847a(LatLng latLng) {
            this.f8279a = latLng;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final CameraPosition m8848a() {
            return new CameraPosition(this.f8279a, this.f8280b, this.f8281c, this.f8282d);
        }

        /* JADX INFO: renamed from: b */
        public final Builder m8849b(float f) {
            this.f8281c = f;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public final Builder m8850c(float f) {
            this.f8282d = f;
            return this;
        }
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        zzbq.m7374a(latLng, "null camera target");
        zzbq.m7384b(CropImageView.DEFAULT_ASPECT_RATIO <= f2 && f2 <= 90.0f, "Tilt needs to be between 0 and 90 inclusive: %s", Float.valueOf(f2));
        this.f8275a = latLng;
        this.f8276b = f;
        this.f8277c = f2 + CropImageView.DEFAULT_ASPECT_RATIO;
        this.f8278d = (((double) f3) <= 0.0d ? (f3 % 360.0f) + 360.0f : f3) % 360.0f;
    }

    /* JADX INFO: renamed from: a */
    public static Builder m8844a() {
        return new Builder();
    }

    /* JADX INFO: renamed from: a */
    public static CameraPosition m8845a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        LatLng latLng = new LatLng(typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraTargetLat) ? typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraTargetLat, CropImageView.DEFAULT_ASPECT_RATIO) : 0.0f, typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraTargetLng) ? typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraTargetLng, CropImageView.DEFAULT_ASPECT_RATIO) : 0.0f);
        Builder builderM8844a = m8844a();
        builderM8844a.m8847a(latLng);
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraZoom)) {
            builderM8844a.m8846a(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraZoom, CropImageView.DEFAULT_ASPECT_RATIO));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraBearing)) {
            builderM8844a.m8850c(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraBearing, CropImageView.DEFAULT_ASPECT_RATIO));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraTilt)) {
            builderM8844a.m8849b(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraTilt, CropImageView.DEFAULT_ASPECT_RATIO));
        }
        return builderM8844a.m8848a();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        return this.f8275a.equals(cameraPosition.f8275a) && Float.floatToIntBits(this.f8276b) == Float.floatToIntBits(cameraPosition.f8276b) && Float.floatToIntBits(this.f8277c) == Float.floatToIntBits(cameraPosition.f8277c) && Float.floatToIntBits(this.f8278d) == Float.floatToIntBits(cameraPosition.f8278d);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8275a, Float.valueOf(this.f8276b), Float.valueOf(this.f8277c), Float.valueOf(this.f8278d)});
    }

    public final String toString() {
        return zzbg.m7370a(this).m7372a("target", this.f8275a).m7372a("zoom", Float.valueOf(this.f8276b)).m7372a("tilt", Float.valueOf(this.f8277c)).m7372a("bearing", Float.valueOf(this.f8278d)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 2, (Parcelable) this.f8275a, i, false);
        zzbfp.m7737a(parcel, 3, this.f8276b);
        zzbfp.m7737a(parcel, 4, this.f8277c);
        zzbfp.m7737a(parcel, 5, this.f8278d);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
