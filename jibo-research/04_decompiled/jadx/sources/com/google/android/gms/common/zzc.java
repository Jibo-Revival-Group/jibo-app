package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class zzc extends zzbfm {
    public static final Parcelable.Creator<zzc> CREATOR = new zzd();

    /* JADX INFO: renamed from: a */
    private String f6701a;

    /* JADX INFO: renamed from: b */
    private int f6702b;

    public zzc(String str, int i) {
        this.f6701a = str;
        this.f6702b = i;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 1, this.f6701a, false);
        zzbfp.m7738a(parcel, 2, this.f6702b);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
