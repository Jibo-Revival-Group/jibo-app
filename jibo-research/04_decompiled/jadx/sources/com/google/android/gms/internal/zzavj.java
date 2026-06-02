package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class zzavj extends zzbfm {
    public static final Parcelable.Creator<zzavj> CREATOR = new zzavk();

    /* JADX INFO: renamed from: a */
    private int f6846a = 1;

    /* JADX INFO: renamed from: b */
    private String f6847b;

    /* JADX INFO: renamed from: c */
    private byte[] f6848c;

    zzavj(int i, String str, byte[] bArr) {
        this.f6847b = (String) zzbq.m7373a(str);
        this.f6848c = (byte[]) zzbq.m7373a(bArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6846a);
        zzbfp.m7748a(parcel, 2, this.f6847b, false);
        zzbfp.m7752a(parcel, 3, this.f6848c, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
