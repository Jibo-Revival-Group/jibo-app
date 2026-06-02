package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class zzavf extends zzbfm {
    public static final Parcelable.Creator<zzavf> CREATOR = new zzavg();

    /* JADX INFO: renamed from: a */
    private int f6841a = 1;

    /* JADX INFO: renamed from: b */
    private String f6842b;

    /* JADX INFO: renamed from: c */
    private int f6843c;

    zzavf(int i, String str, int i2) {
        this.f6842b = (String) zzbq.m7373a(str);
        this.f6843c = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6841a);
        zzbfp.m7748a(parcel, 2, this.f6842b, false);
        zzbfp.m7738a(parcel, 3, this.f6843c);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
