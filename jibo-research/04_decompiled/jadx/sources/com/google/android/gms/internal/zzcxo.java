package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbr;

/* JADX INFO: loaded from: classes.dex */
public final class zzcxo extends zzbfm {
    public static final Parcelable.Creator<zzcxo> CREATOR = new zzcxp();

    /* JADX INFO: renamed from: a */
    private int f7791a;

    /* JADX INFO: renamed from: b */
    private zzbr f7792b;

    zzcxo(int i, zzbr zzbrVar) {
        this.f7791a = i;
        this.f7792b = zzbrVar;
    }

    public zzcxo(zzbr zzbrVar) {
        this(1, zzbrVar);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f7791a);
        zzbfp.m7743a(parcel, 2, (Parcelable) this.f7792b, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
