package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzao extends zzbfm {
    public static final Parcelable.Creator<zzao> CREATOR = new zzf();

    /* JADX INFO: renamed from: a */
    private int f8186a;

    /* JADX INFO: renamed from: b */
    private int f8187b;

    /* JADX INFO: renamed from: c */
    private int f8188c;

    /* JADX INFO: renamed from: d */
    private int f8189d;

    /* JADX INFO: renamed from: e */
    private int f8190e;

    /* JADX INFO: renamed from: f */
    private int f8191f;

    /* JADX INFO: renamed from: g */
    private List<zzan> f8192g;

    zzao(int i, int i2, int i3, int i4, int i5, int i6, List<zzan> list) {
        this.f8186a = i;
        this.f8187b = i2;
        this.f8188c = i3;
        this.f8189d = i4;
        this.f8190e = i5;
        this.f8191f = i6;
        this.f8192g = Collections.unmodifiableList(list);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f8186a);
        zzbfp.m7738a(parcel, 2, this.f8187b);
        zzbfp.m7738a(parcel, 3, this.f8188c);
        zzbfp.m7738a(parcel, 4, this.f8189d);
        zzbfp.m7738a(parcel, 5, this.f8190e);
        zzbfp.m7738a(parcel, 6, this.f8191f);
        zzbfp.m7762c(parcel, 7, this.f8192g, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
