package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class zzcha extends zzbfm {
    public static final Parcelable.Creator<zzcha> CREATOR = new zzchb();

    /* JADX INFO: renamed from: a */
    public final String f7156a;

    /* JADX INFO: renamed from: b */
    public final zzcgx f7157b;

    /* JADX INFO: renamed from: c */
    public final String f7158c;

    /* JADX INFO: renamed from: d */
    public final long f7159d;

    zzcha(zzcha zzchaVar, long j) {
        zzbq.m7373a(zzchaVar);
        this.f7156a = zzchaVar.f7156a;
        this.f7157b = zzchaVar.f7157b;
        this.f7158c = zzchaVar.f7158c;
        this.f7159d = j;
    }

    public zzcha(String str, zzcgx zzcgxVar, String str2, long j) {
        this.f7156a = str;
        this.f7157b = zzcgxVar;
        this.f7158c = str2;
        this.f7159d = j;
    }

    public final String toString() {
        String str = this.f7158c;
        String str2 = this.f7156a;
        String strValueOf = String.valueOf(this.f7157b);
        return new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(strValueOf).length()).append("origin=").append(str).append(",name=").append(str2).append(",params=").append(strValueOf).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 2, this.f7156a, false);
        zzbfp.m7743a(parcel, 3, (Parcelable) this.f7157b, i, false);
        zzbfp.m7748a(parcel, 4, this.f7158c, false);
        zzbfp.m7739a(parcel, 5, this.f7159d);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
