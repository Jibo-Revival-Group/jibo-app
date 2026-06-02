package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public final class MarkerOptions extends zzbfm {
    public static final Parcelable.Creator<MarkerOptions> CREATOR = new zzh();

    /* JADX INFO: renamed from: a */
    private LatLng f8318a;

    /* JADX INFO: renamed from: b */
    private String f8319b;

    /* JADX INFO: renamed from: c */
    private String f8320c;

    /* JADX INFO: renamed from: d */
    private BitmapDescriptor f8321d;

    /* JADX INFO: renamed from: e */
    private float f8322e;

    /* JADX INFO: renamed from: f */
    private float f8323f;

    /* JADX INFO: renamed from: g */
    private boolean f8324g;

    /* JADX INFO: renamed from: h */
    private boolean f8325h;

    /* JADX INFO: renamed from: i */
    private boolean f8326i;

    /* JADX INFO: renamed from: j */
    private float f8327j;

    /* JADX INFO: renamed from: k */
    private float f8328k;

    /* JADX INFO: renamed from: l */
    private float f8329l;

    /* JADX INFO: renamed from: m */
    private float f8330m;

    /* JADX INFO: renamed from: n */
    private float f8331n;

    public MarkerOptions() {
        this.f8322e = 0.5f;
        this.f8323f = 1.0f;
        this.f8325h = true;
        this.f8326i = false;
        this.f8327j = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f8328k = 0.5f;
        this.f8329l = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f8330m = 1.0f;
    }

    MarkerOptions(LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2, boolean z3, float f3, float f4, float f5, float f6, float f7) {
        this.f8322e = 0.5f;
        this.f8323f = 1.0f;
        this.f8325h = true;
        this.f8326i = false;
        this.f8327j = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f8328k = 0.5f;
        this.f8329l = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f8330m = 1.0f;
        this.f8318a = latLng;
        this.f8319b = str;
        this.f8320c = str2;
        if (iBinder == null) {
            this.f8321d = null;
        } else {
            this.f8321d = new BitmapDescriptor(IObjectWrapper.zza.m7552a(iBinder));
        }
        this.f8322e = f;
        this.f8323f = f2;
        this.f8324g = z;
        this.f8325h = z2;
        this.f8326i = z3;
        this.f8327j = f3;
        this.f8328k = f4;
        this.f8329l = f5;
        this.f8330m = f6;
        this.f8331n = f7;
    }

    /* JADX INFO: renamed from: a */
    public final LatLng m8872a() {
        return this.f8318a;
    }

    /* JADX INFO: renamed from: b */
    public final String m8873b() {
        return this.f8319b;
    }

    /* JADX INFO: renamed from: c */
    public final String m8874c() {
        return this.f8320c;
    }

    /* JADX INFO: renamed from: d */
    public final float m8875d() {
        return this.f8322e;
    }

    /* JADX INFO: renamed from: e */
    public final float m8876e() {
        return this.f8323f;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m8877f() {
        return this.f8324g;
    }

    /* JADX INFO: renamed from: g */
    public final boolean m8878g() {
        return this.f8325h;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m8879h() {
        return this.f8326i;
    }

    /* JADX INFO: renamed from: i */
    public final float m8880i() {
        return this.f8327j;
    }

    /* JADX INFO: renamed from: j */
    public final float m8881j() {
        return this.f8328k;
    }

    /* JADX INFO: renamed from: k */
    public final float m8882k() {
        return this.f8329l;
    }

    /* JADX INFO: renamed from: l */
    public final float m8883l() {
        return this.f8330m;
    }

    /* JADX INFO: renamed from: m */
    public final float m8884m() {
        return this.f8331n;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7743a(parcel, 2, (Parcelable) m8872a(), i, false);
        zzbfp.m7748a(parcel, 3, m8873b(), false);
        zzbfp.m7748a(parcel, 4, m8874c(), false);
        zzbfp.m7741a(parcel, 5, this.f8321d == null ? null : this.f8321d.m8843a().asBinder(), false);
        zzbfp.m7737a(parcel, 6, m8875d());
        zzbfp.m7737a(parcel, 7, m8876e());
        zzbfp.m7751a(parcel, 8, m8877f());
        zzbfp.m7751a(parcel, 9, m8878g());
        zzbfp.m7751a(parcel, 10, m8879h());
        zzbfp.m7737a(parcel, 11, m8880i());
        zzbfp.m7737a(parcel, 12, m8881j());
        zzbfp.m7737a(parcel, 13, m8882k());
        zzbfp.m7737a(parcel, 14, m8883l());
        zzbfp.m7737a(parcel, 15, m8884m());
        zzbfp.m7734a(parcel, iM7733a);
    }
}
