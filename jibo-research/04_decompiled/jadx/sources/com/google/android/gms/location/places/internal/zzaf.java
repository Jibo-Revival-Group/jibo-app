package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzaf extends zzbfm {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzag();

    /* JADX INFO: renamed from: a */
    private final List<Integer> f8170a;

    /* JADX INFO: renamed from: b */
    private final String f8171b;

    /* JADX INFO: renamed from: c */
    private final Uri f8172c;

    /* JADX INFO: renamed from: d */
    private final float f8173d;

    /* JADX INFO: renamed from: e */
    private final int f8174e;

    zzaf(List<Integer> list, String str, Uri uri, float f, int i) {
        this.f8170a = Collections.unmodifiableList(list);
        this.f8171b = str;
        this.f8172c = uri;
        this.f8173d = f;
        this.f8174e = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7749a(parcel, 1, this.f8170a, false);
        zzbfp.m7748a(parcel, 2, this.f8171b, false);
        zzbfp.m7743a(parcel, 3, (Parcelable) this.f8172c, i, false);
        zzbfp.m7737a(parcel, 4, this.f8173d);
        zzbfp.m7738a(parcel, 5, this.f8174e);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
