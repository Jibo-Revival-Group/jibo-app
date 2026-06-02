package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public final class GroundOverlayOptions extends zzbfm {
    public static final Parcelable.Creator<GroundOverlayOptions> CREATOR = new zzd();

    /* JADX INFO: renamed from: a */
    private BitmapDescriptor f8300a;

    /* JADX INFO: renamed from: b */
    private LatLng f8301b;

    /* JADX INFO: renamed from: c */
    private float f8302c;

    /* JADX INFO: renamed from: d */
    private float f8303d;

    /* JADX INFO: renamed from: e */
    private LatLngBounds f8304e;

    /* JADX INFO: renamed from: f */
    private float f8305f;

    /* JADX INFO: renamed from: g */
    private float f8306g;

    /* JADX INFO: renamed from: h */
    private boolean f8307h;

    /* JADX INFO: renamed from: i */
    private float f8308i;

    /* JADX INFO: renamed from: j */
    private float f8309j;

    /* JADX INFO: renamed from: k */
    private float f8310k;

    /* JADX INFO: renamed from: l */
    private boolean f8311l;

    public GroundOverlayOptions() {
        this.f8307h = true;
        this.f8308i = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f8309j = 0.5f;
        this.f8310k = 0.5f;
        this.f8311l = false;
    }

    GroundOverlayOptions(IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7, boolean z2) {
        this.f8307h = true;
        this.f8308i = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f8309j = 0.5f;
        this.f8310k = 0.5f;
        this.f8311l = false;
        this.f8300a = new BitmapDescriptor(IObjectWrapper.zza.m7552a(iBinder));
        this.f8301b = latLng;
        this.f8302c = f;
        this.f8303d = f2;
        this.f8304e = latLngBounds;
        this.f8305f = f3;
        this.f8306g = f4;
        this.f8307h = z;
        this.f8308i = f5;
        this.f8309j = f6;
        this.f8310k = f7;
        this.f8311l = z2;
    }

    /* JADX INFO: renamed from: a */
    public final LatLng m8860a() {
        return this.f8301b;
    }

    /* JADX INFO: renamed from: b */
    public final float m8861b() {
        return this.f8302c;
    }

    /* JADX INFO: renamed from: c */
    public final float m8862c() {
        return this.f8303d;
    }

    /* JADX INFO: renamed from: d */
    public final LatLngBounds m8863d() {
        return this.f8304e;
    }

    /* JADX INFO: renamed from: e */
    public final float m8864e() {
        return this.f8305f;
    }

    /* JADX INFO: renamed from: f */
    public final float m8865f() {
        return this.f8306g;
    }

    /* JADX INFO: renamed from: g */
    public final float m8866g() {
        return this.f8308i;
    }

    /* JADX INFO: renamed from: h */
    public final float m8867h() {
        return this.f8309j;
    }

    /* JADX INFO: renamed from: i */
    public final float m8868i() {
        return this.f8310k;
    }

    /* JADX INFO: renamed from: j */
    public final boolean m8869j() {
        return this.f8307h;
    }

    /* JADX INFO: renamed from: k */
    public final boolean m8870k() {
        return this.f8311l;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7741a(parcel, 2, this.f8300a.m8843a().asBinder(), false);
        zzbfp.m7743a(parcel, 3, (Parcelable) m8860a(), i, false);
        zzbfp.m7737a(parcel, 4, m8861b());
        zzbfp.m7737a(parcel, 5, m8862c());
        zzbfp.m7743a(parcel, 6, (Parcelable) m8863d(), i, false);
        zzbfp.m7737a(parcel, 7, m8864e());
        zzbfp.m7737a(parcel, 8, m8865f());
        zzbfp.m7751a(parcel, 9, m8869j());
        zzbfp.m7737a(parcel, 10, m8866g());
        zzbfp.m7737a(parcel, 11, m8867h());
        zzbfp.m7737a(parcel, 12, m8868i());
        zzbfp.m7751a(parcel, 13, m8870k());
        zzbfp.m7734a(parcel, iM7733a);
    }
}
