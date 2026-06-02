package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class zzavh extends zzbfm {
    public static final Parcelable.Creator<zzavh> CREATOR = new zzavi();

    /* JADX INFO: renamed from: a */
    private int f6844a = 1;

    /* JADX INFO: renamed from: b */
    private String f6845b;

    zzavh(int i, String str) {
        this.f6845b = (String) zzbq.m7373a(str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6844a);
        zzbfp.m7748a(parcel, 2, this.f6845b, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
