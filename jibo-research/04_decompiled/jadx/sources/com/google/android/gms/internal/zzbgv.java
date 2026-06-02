package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgv extends zzbfm {
    public static final Parcelable.Creator<zzbgv> CREATOR = new zzbgs();

    /* JADX INFO: renamed from: a */
    final String f6967a;

    /* JADX INFO: renamed from: b */
    final zzbgo<?, ?> f6968b;

    /* JADX INFO: renamed from: c */
    private int f6969c;

    zzbgv(int i, String str, zzbgo<?, ?> zzbgoVar) {
        this.f6969c = i;
        this.f6967a = str;
        this.f6968b = zzbgoVar;
    }

    zzbgv(String str, zzbgo<?, ?> zzbgoVar) {
        this.f6969c = 1;
        this.f6967a = str;
        this.f6968b = zzbgoVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6969c);
        zzbfp.m7748a(parcel, 2, this.f6967a, false);
        zzbfp.m7743a(parcel, 3, (Parcelable) this.f6968b, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
