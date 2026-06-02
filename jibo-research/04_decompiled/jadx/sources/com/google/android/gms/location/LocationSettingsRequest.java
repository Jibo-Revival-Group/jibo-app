package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class LocationSettingsRequest extends zzbfm {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new zzab();

    /* JADX INFO: renamed from: a */
    private final List<LocationRequest> f8071a;

    /* JADX INFO: renamed from: b */
    private final boolean f8072b;

    /* JADX INFO: renamed from: c */
    private final boolean f8073c;

    /* JADX INFO: renamed from: d */
    private zzz f8074d;

    LocationSettingsRequest(List<LocationRequest> list, boolean z, boolean z2, zzz zzzVar) {
        this.f8071a = list;
        this.f8072b = z;
        this.f8073c = z2;
        this.f8074d = zzzVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7762c(parcel, 1, Collections.unmodifiableList(this.f8071a), false);
        zzbfp.m7751a(parcel, 2, this.f8072b);
        zzbfp.m7751a(parcel, 3, this.f8073c);
        zzbfp.m7743a(parcel, 5, (Parcelable) this.f8074d, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
