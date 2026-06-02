package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class zzbv extends zzbfm {
    public static final Parcelable.Creator<zzbv> CREATOR = new zzbw();

    /* JADX INFO: renamed from: a */
    private int f6583a;

    /* JADX INFO: renamed from: b */
    private final int f6584b;

    /* JADX INFO: renamed from: c */
    private final int f6585c;

    /* JADX INFO: renamed from: d */
    @Deprecated
    private final Scope[] f6586d;

    zzbv(int i, int i2, int i3, Scope[] scopeArr) {
        this.f6583a = i;
        this.f6584b = i2;
        this.f6585c = i3;
        this.f6586d = scopeArr;
    }

    public zzbv(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6583a);
        zzbfp.m7738a(parcel, 2, this.f6584b);
        zzbfp.m7738a(parcel, 3, this.f6585c);
        zzbfp.m7754a(parcel, 4, (Parcelable[]) this.f6586d, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
