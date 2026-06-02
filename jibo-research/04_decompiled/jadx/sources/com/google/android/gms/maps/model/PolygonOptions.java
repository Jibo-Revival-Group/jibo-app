package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import com.yalantis.ucrop.view.CropImageView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PolygonOptions extends zzbfm {
    public static final Parcelable.Creator<PolygonOptions> CREATOR = new zzk();

    /* JADX INFO: renamed from: a */
    private final List<LatLng> f8338a;

    /* JADX INFO: renamed from: b */
    private final List<List<LatLng>> f8339b;

    /* JADX INFO: renamed from: c */
    private float f8340c;

    /* JADX INFO: renamed from: d */
    private int f8341d;

    /* JADX INFO: renamed from: e */
    private int f8342e;

    /* JADX INFO: renamed from: f */
    private float f8343f;

    /* JADX INFO: renamed from: g */
    private boolean f8344g;

    /* JADX INFO: renamed from: h */
    private boolean f8345h;

    /* JADX INFO: renamed from: i */
    private boolean f8346i;

    /* JADX INFO: renamed from: j */
    private int f8347j;

    /* JADX INFO: renamed from: k */
    private List<PatternItem> f8348k;

    public PolygonOptions() {
        this.f8340c = 10.0f;
        this.f8341d = -16777216;
        this.f8342e = 0;
        this.f8343f = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f8344g = true;
        this.f8345h = false;
        this.f8346i = false;
        this.f8347j = 0;
        this.f8348k = null;
        this.f8338a = new ArrayList();
        this.f8339b = new ArrayList();
    }

    PolygonOptions(List<LatLng> list, List list2, float f, int i, int i2, float f2, boolean z, boolean z2, boolean z3, int i3, List<PatternItem> list3) {
        this.f8340c = 10.0f;
        this.f8341d = -16777216;
        this.f8342e = 0;
        this.f8343f = CropImageView.DEFAULT_ASPECT_RATIO;
        this.f8344g = true;
        this.f8345h = false;
        this.f8346i = false;
        this.f8347j = 0;
        this.f8348k = null;
        this.f8338a = list;
        this.f8339b = list2;
        this.f8340c = f;
        this.f8341d = i;
        this.f8342e = i2;
        this.f8343f = f2;
        this.f8344g = z;
        this.f8345h = z2;
        this.f8346i = z3;
        this.f8347j = i3;
        this.f8348k = list3;
    }

    /* JADX INFO: renamed from: a */
    public final List<LatLng> m8885a() {
        return this.f8338a;
    }

    /* JADX INFO: renamed from: b */
    public final float m8886b() {
        return this.f8340c;
    }

    /* JADX INFO: renamed from: c */
    public final int m8887c() {
        return this.f8341d;
    }

    /* JADX INFO: renamed from: d */
    public final int m8888d() {
        return this.f8347j;
    }

    /* JADX INFO: renamed from: e */
    public final List<PatternItem> m8889e() {
        return this.f8348k;
    }

    /* JADX INFO: renamed from: f */
    public final int m8890f() {
        return this.f8342e;
    }

    /* JADX INFO: renamed from: g */
    public final float m8891g() {
        return this.f8343f;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m8892h() {
        return this.f8344g;
    }

    /* JADX INFO: renamed from: i */
    public final boolean m8893i() {
        return this.f8345h;
    }

    /* JADX INFO: renamed from: j */
    public final boolean m8894j() {
        return this.f8346i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7762c(parcel, 2, m8885a(), false);
        zzbfp.m7763d(parcel, 3, this.f8339b, false);
        zzbfp.m7737a(parcel, 4, m8886b());
        zzbfp.m7738a(parcel, 5, m8887c());
        zzbfp.m7738a(parcel, 6, m8890f());
        zzbfp.m7737a(parcel, 7, m8891g());
        zzbfp.m7751a(parcel, 8, m8892h());
        zzbfp.m7751a(parcel, 9, m8893i());
        zzbfp.m7751a(parcel, 10, m8894j());
        zzbfp.m7738a(parcel, 11, m8888d());
        zzbfp.m7762c(parcel, 12, m8889e(), false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
