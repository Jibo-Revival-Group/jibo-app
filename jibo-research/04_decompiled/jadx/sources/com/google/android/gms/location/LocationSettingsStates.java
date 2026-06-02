package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class LocationSettingsStates extends zzbfm {
    public static final Parcelable.Creator<LocationSettingsStates> CREATOR = new zzad();

    /* JADX INFO: renamed from: a */
    private final boolean f8077a;

    /* JADX INFO: renamed from: b */
    private final boolean f8078b;

    /* JADX INFO: renamed from: c */
    private final boolean f8079c;

    /* JADX INFO: renamed from: d */
    private final boolean f8080d;

    /* JADX INFO: renamed from: e */
    private final boolean f8081e;

    /* JADX INFO: renamed from: f */
    private final boolean f8082f;

    public LocationSettingsStates(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.f8077a = z;
        this.f8078b = z2;
        this.f8079c = z3;
        this.f8080d = z4;
        this.f8081e = z5;
        this.f8082f = z6;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m8747a() {
        return this.f8077a;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m8748b() {
        return this.f8080d;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m8749c() {
        return this.f8078b;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m8750d() {
        return this.f8081e;
    }

    /* JADX INFO: renamed from: e */
    public final boolean m8751e() {
        return this.f8079c;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m8752f() {
        return this.f8082f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7751a(parcel, 1, m8747a());
        zzbfp.m7751a(parcel, 2, m8749c());
        zzbfp.m7751a(parcel, 3, m8751e());
        zzbfp.m7751a(parcel, 4, m8748b());
        zzbfp.m7751a(parcel, 5, m8750d());
        zzbfp.m7751a(parcel, 6, m8752f());
        zzbfp.m7734a(parcel, iM7733a);
    }
}
