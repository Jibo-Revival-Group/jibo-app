package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

/* JADX INFO: loaded from: classes.dex */
public final class GoogleMapOptions extends zzbfm implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleMapOptions> CREATOR = new zzaa();

    /* JADX INFO: renamed from: a */
    private Boolean f8239a;

    /* JADX INFO: renamed from: b */
    private Boolean f8240b;

    /* JADX INFO: renamed from: c */
    private int f8241c;

    /* JADX INFO: renamed from: d */
    private CameraPosition f8242d;

    /* JADX INFO: renamed from: e */
    private Boolean f8243e;

    /* JADX INFO: renamed from: f */
    private Boolean f8244f;

    /* JADX INFO: renamed from: g */
    private Boolean f8245g;

    /* JADX INFO: renamed from: h */
    private Boolean f8246h;

    /* JADX INFO: renamed from: i */
    private Boolean f8247i;

    /* JADX INFO: renamed from: j */
    private Boolean f8248j;

    /* JADX INFO: renamed from: k */
    private Boolean f8249k;

    /* JADX INFO: renamed from: l */
    private Boolean f8250l;

    /* JADX INFO: renamed from: m */
    private Boolean f8251m;

    /* JADX INFO: renamed from: n */
    private Float f8252n;

    /* JADX INFO: renamed from: o */
    private Float f8253o;

    /* JADX INFO: renamed from: p */
    private LatLngBounds f8254p;

    public GoogleMapOptions() {
        this.f8241c = -1;
        this.f8252n = null;
        this.f8253o = null;
        this.f8254p = null;
    }

    GoogleMapOptions(byte b, byte b2, int i, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, Float f, Float f2, LatLngBounds latLngBounds) {
        this.f8241c = -1;
        this.f8252n = null;
        this.f8253o = null;
        this.f8254p = null;
        this.f8239a = zza.m8842a(b);
        this.f8240b = zza.m8842a(b2);
        this.f8241c = i;
        this.f8242d = cameraPosition;
        this.f8243e = zza.m8842a(b3);
        this.f8244f = zza.m8842a(b4);
        this.f8245g = zza.m8842a(b5);
        this.f8246h = zza.m8842a(b6);
        this.f8247i = zza.m8842a(b7);
        this.f8248j = zza.m8842a(b8);
        this.f8249k = zza.m8842a(b9);
        this.f8250l = zza.m8842a(b10);
        this.f8251m = zza.m8842a(b11);
        this.f8252n = f;
        this.f8253o = f2;
        this.f8254p = latLngBounds;
    }

    /* JADX INFO: renamed from: a */
    public static GoogleMapOptions m8815a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_mapType)) {
            googleMapOptions.m8818a(typedArrayObtainAttributes.getInt(R.styleable.MapAttrs_mapType, -1));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.m8821a(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.m8823b(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.m8827d(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiCompass, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.m8833h(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.m8829e(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.m8832g(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.m8831f(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.m8825c(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.m8834i(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_liteMode, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.m8835j(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_uiMapToolbar, true));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_ambientEnabled)) {
            googleMapOptions.m8836k(typedArrayObtainAttributes.getBoolean(R.styleable.MapAttrs_ambientEnabled, false));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.m8817a(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraMinZoomPreference, Float.NEGATIVE_INFINITY));
        }
        if (typedArrayObtainAttributes.hasValue(R.styleable.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.m8822b(typedArrayObtainAttributes.getFloat(R.styleable.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
        }
        googleMapOptions.m8820a(LatLngBounds.m8871a(context, attributeSet));
        googleMapOptions.m8819a(CameraPosition.m8845a(context, attributeSet));
        typedArrayObtainAttributes.recycle();
        return googleMapOptions;
    }

    /* JADX INFO: renamed from: a */
    public final int m8816a() {
        return this.f8241c;
    }

    /* JADX INFO: renamed from: a */
    public final GoogleMapOptions m8817a(float f) {
        this.f8252n = Float.valueOf(f);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public final GoogleMapOptions m8818a(int i) {
        this.f8241c = i;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public final GoogleMapOptions m8819a(CameraPosition cameraPosition) {
        this.f8242d = cameraPosition;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public final GoogleMapOptions m8820a(LatLngBounds latLngBounds) {
        this.f8254p = latLngBounds;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public final GoogleMapOptions m8821a(boolean z) {
        this.f8239a = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public final GoogleMapOptions m8822b(float f) {
        this.f8253o = Float.valueOf(f);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public final GoogleMapOptions m8823b(boolean z) {
        this.f8240b = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public final CameraPosition m8824b() {
        return this.f8242d;
    }

    /* JADX INFO: renamed from: c */
    public final GoogleMapOptions m8825c(boolean z) {
        this.f8243e = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: renamed from: c */
    public final Float m8826c() {
        return this.f8252n;
    }

    /* JADX INFO: renamed from: d */
    public final GoogleMapOptions m8827d(boolean z) {
        this.f8244f = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: renamed from: d */
    public final Float m8828d() {
        return this.f8253o;
    }

    /* JADX INFO: renamed from: e */
    public final GoogleMapOptions m8829e(boolean z) {
        this.f8245g = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: renamed from: e */
    public final LatLngBounds m8830e() {
        return this.f8254p;
    }

    /* JADX INFO: renamed from: f */
    public final GoogleMapOptions m8831f(boolean z) {
        this.f8246h = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: renamed from: g */
    public final GoogleMapOptions m8832g(boolean z) {
        this.f8247i = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: renamed from: h */
    public final GoogleMapOptions m8833h(boolean z) {
        this.f8248j = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: renamed from: i */
    public final GoogleMapOptions m8834i(boolean z) {
        this.f8249k = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: renamed from: j */
    public final GoogleMapOptions m8835j(boolean z) {
        this.f8250l = Boolean.valueOf(z);
        return this;
    }

    /* JADX INFO: renamed from: k */
    public final GoogleMapOptions m8836k(boolean z) {
        this.f8251m = Boolean.valueOf(z);
        return this;
    }

    public final String toString() {
        return zzbg.m7370a(this).m7372a("MapType", Integer.valueOf(this.f8241c)).m7372a("LiteMode", this.f8249k).m7372a("Camera", this.f8242d).m7372a("CompassEnabled", this.f8244f).m7372a("ZoomControlsEnabled", this.f8243e).m7372a("ScrollGesturesEnabled", this.f8245g).m7372a("ZoomGesturesEnabled", this.f8246h).m7372a("TiltGesturesEnabled", this.f8247i).m7372a("RotateGesturesEnabled", this.f8248j).m7372a("MapToolbarEnabled", this.f8250l).m7372a("AmbientEnabled", this.f8251m).m7372a("MinZoomPreference", this.f8252n).m7372a("MaxZoomPreference", this.f8253o).m7372a("LatLngBoundsForCameraTarget", this.f8254p).m7372a("ZOrderOnTop", this.f8239a).m7372a("UseViewLifecycleInFragment", this.f8240b).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7735a(parcel, 2, zza.m8841a(this.f8239a));
        zzbfp.m7735a(parcel, 3, zza.m8841a(this.f8240b));
        zzbfp.m7738a(parcel, 4, m8816a());
        zzbfp.m7743a(parcel, 5, (Parcelable) m8824b(), i, false);
        zzbfp.m7735a(parcel, 6, zza.m8841a(this.f8243e));
        zzbfp.m7735a(parcel, 7, zza.m8841a(this.f8244f));
        zzbfp.m7735a(parcel, 8, zza.m8841a(this.f8245g));
        zzbfp.m7735a(parcel, 9, zza.m8841a(this.f8246h));
        zzbfp.m7735a(parcel, 10, zza.m8841a(this.f8247i));
        zzbfp.m7735a(parcel, 11, zza.m8841a(this.f8248j));
        zzbfp.m7735a(parcel, 12, zza.m8841a(this.f8249k));
        zzbfp.m7735a(parcel, 14, zza.m8841a(this.f8250l));
        zzbfp.m7735a(parcel, 15, zza.m8841a(this.f8251m));
        zzbfp.m7745a(parcel, 16, m8826c(), false);
        zzbfp.m7745a(parcel, 17, m8828d(), false);
        zzbfp.m7743a(parcel, 18, (Parcelable) m8830e(), i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
