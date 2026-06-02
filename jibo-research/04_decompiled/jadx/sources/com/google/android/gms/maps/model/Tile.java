package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class Tile extends zzbfm {
    public static final Parcelable.Creator<Tile> CREATOR = new zzq();

    /* JADX INFO: renamed from: a */
    public final int f8373a;

    /* JADX INFO: renamed from: b */
    public final int f8374b;

    /* JADX INFO: renamed from: c */
    public final byte[] f8375c;

    public Tile(int i, int i2, byte[] bArr) {
        this.f8373a = i;
        this.f8374b = i2;
        this.f8375c = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 2, this.f8373a);
        zzbfp.m7738a(parcel, 3, this.f8374b);
        zzbfp.m7752a(parcel, 4, this.f8375c, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
