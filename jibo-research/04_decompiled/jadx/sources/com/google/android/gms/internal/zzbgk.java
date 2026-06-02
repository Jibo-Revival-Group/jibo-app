package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgk extends zzbfm {
    public static final Parcelable.Creator<zzbgk> CREATOR = new zzbgm();

    /* JADX INFO: renamed from: a */
    final String f6946a;

    /* JADX INFO: renamed from: b */
    final int f6947b;

    /* JADX INFO: renamed from: c */
    private int f6948c;

    zzbgk(int i, String str, int i2) {
        this.f6948c = i;
        this.f6946a = str;
        this.f6947b = i2;
    }

    zzbgk(String str, int i) {
        this.f6948c = 1;
        this.f6946a = str;
        this.f6947b = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6948c);
        zzbfp.m7748a(parcel, 2, this.f6946a, false);
        zzbfp.m7738a(parcel, 3, this.f6947b);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
