package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.yalantis.ucrop.view.CropImageView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CircleOptions extends zzbfm {
    public static final Parcelable.Creator<CircleOptions> CREATOR = new zzc();

    /* JADX INFO: renamed from: a */
    private LatLng f8287a;

    /* JADX INFO: renamed from: b */
    private double f8288b;

    /* JADX INFO: renamed from: c */
    private float f8289c;

    /* JADX INFO: renamed from: d */
    private int f8290d;

    /* JADX INFO: renamed from: e */
    private int f8291e;

    /* JADX INFO: renamed from: f */
    private float f8292f;

    /* JADX INFO: renamed from: g */
    private boolean f8293g;

    /* JADX INFO: renamed from: h */
    private boolean f8294h;

    /* JADX INFO: renamed from: i */
    private List<PatternItem> f8295i;

    public CircleOptions() {
        this.f8287a = null;
        this.f8288b = 0.0d;
        this.f8289c = 10.0f;
        this.f8290d = -16777216;
        this.f8291e = 0;
        this.f8292f = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f8293g = true;
        this.f8294h = false;
        this.f8295i = null;
    }

    CircleOptions(LatLng latLng, double d, float f, int i, int i2, float f2, boolean z, boolean z2, List<PatternItem> list) {
        this.f8287a = null;
        this.f8288b = 0.0d;
        this.f8289c = 10.0f;
        this.f8290d = -16777216;
        this.f8291e = 0;
        this.f8292f = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f8293g = true;
        this.f8294h = false;
        this.f8295i = null;
        this.f8287a = latLng;
        this.f8288b = d;
        this.f8289c = f;
        this.f8290d = i;
        this.f8291e = i2;
        this.f8292f = f2;
        this.f8293g = z;
        this.f8294h = z2;
        this.f8295i = list;
    }

    /* JADX INFO: renamed from: a */
    public final LatLng m8851a() {
        return this.f8287a;
    }

    /* JADX INFO: renamed from: b */
    public final double m8852b() {
        return this.f8288b;
    }

    /* JADX INFO: renamed from: c */
    public final float m8853c() {
        return this.f8289c;
    }

    /* JADX INFO: renamed from: d */
    public final int m8854d() {
        return this.f8290d;
    }

    /* JADX INFO: renamed from: e */
    public final List<PatternItem> m8855e() {
        return this.f8295i;
    }

    /* JADX INFO: renamed from: f */
    public final int m8856f() {
        return this.f8291e;
    }

    /* JADX INFO: renamed from: g */
    public final float m8857g() {
        return this.f8292f;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m8858h() {
        return this.f8293g;
    }

    /* JADX INFO: renamed from: i */
    public final boolean m8859i() {
        return this.f8294h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 2, (Parcelable) m8851a(), i, false);
        zzbfp.m7736a(parcel, 3, m8852b());
        zzbfp.m7737a(parcel, 4, m8853c());
        zzbfp.m7738a(parcel, 5, m8854d());
        zzbfp.m7738a(parcel, 6, m8856f());
        zzbfp.m7737a(parcel, 7, m8857g());
        zzbfp.m7751a(parcel, 8, m8858h());
        zzbfp.m7751a(parcel, 9, m8859i());
        zzbfp.m7762c(parcel, 10, m8855e(), false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
