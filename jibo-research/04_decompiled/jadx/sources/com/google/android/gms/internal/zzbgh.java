package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public final class zzbgh extends zzbfm {
    public static final Parcelable.Creator<zzbgh> CREATOR = new zzbgi();

    /* JADX INFO: renamed from: a */
    private int f6940a;

    /* JADX INFO: renamed from: b */
    private final zzbgj f6941b;

    zzbgh(int i, zzbgj zzbgjVar) {
        this.f6940a = i;
        this.f6941b = zzbgjVar;
    }

    private zzbgh(zzbgj zzbgjVar) {
        this.f6940a = 1;
        this.f6941b = zzbgjVar;
    }

    /* JADX INFO: renamed from: a */
    public static zzbgh m7775a(zzbgp<?, ?> zzbgpVar) {
        if (zzbgpVar instanceof zzbgj) {
            return new zzbgh((zzbgj) zzbgpVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    /* JADX INFO: renamed from: a */
    public final zzbgp<?, ?> m7776a() {
        if (this.f6941b != null) {
            return this.f6941b;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6940a);
        zzbfp.m7743a(parcel, 2, (Parcelable) this.f6941b, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
