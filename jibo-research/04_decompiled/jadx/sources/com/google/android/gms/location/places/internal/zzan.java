package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class zzan extends zzbfm {
    public static final Parcelable.Creator<zzan> CREATOR = new zze();

    /* JADX INFO: renamed from: a */
    private int f8184a;

    /* JADX INFO: renamed from: b */
    private int f8185b;

    zzan(int i, int i2) {
        this.f8184a = i;
        this.f8185b = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f8184a);
        zzbfp.m7738a(parcel, 2, this.f8185b);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
