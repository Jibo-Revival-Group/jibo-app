package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.google.android.gms.maps.model.internal.zzaa;
import com.google.android.gms.maps.model.internal.zzz;
import com.yalantis.ucrop.view.CropImageView;

/* JADX INFO: loaded from: classes.dex */
public final class TileOverlayOptions extends zzbfm {
    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new zzt();

    /* JADX INFO: renamed from: a */
    private zzz f8376a;

    /* JADX INFO: renamed from: b */
    private TileProvider f8377b;

    /* JADX INFO: renamed from: c */
    private boolean f8378c;

    /* JADX INFO: renamed from: d */
    private float f8379d;

    /* JADX INFO: renamed from: e */
    private boolean f8380e;

    /* JADX INFO: renamed from: f */
    private float f8381f;

    public TileOverlayOptions() {
        this.f8378c = true;
        this.f8380e = true;
        this.f8381f = CropImageView.DEFAULT_ASPECT_RATIO;
    }

    TileOverlayOptions(IBinder iBinder, boolean z, float f, boolean z2, float f2) {
        this.f8378c = true;
        this.f8380e = true;
        this.f8381f = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f8376a = zzaa.m8914a(iBinder);
        this.f8377b = this.f8376a == null ? null : new zzr(this);
        this.f8378c = z;
        this.f8379d = f;
        this.f8380e = z2;
        this.f8381f = f2;
    }

    /* JADX INFO: renamed from: a */
    public final float m8910a() {
        return this.f8379d;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m8911b() {
        return this.f8378c;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m8912c() {
        return this.f8380e;
    }

    /* JADX INFO: renamed from: d */
    public final float m8913d() {
        return this.f8381f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7741a(parcel, 2, this.f8376a.asBinder(), false);
        zzbfp.m7751a(parcel, 3, m8911b());
        zzbfp.m7737a(parcel, 4, m8910a());
        zzbfp.m7751a(parcel, 5, m8912c());
        zzbfp.m7737a(parcel, 6, m8913d());
        zzbfp.m7734a(parcel, iM7733a);
    }
}
