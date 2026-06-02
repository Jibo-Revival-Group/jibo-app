package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class zzz extends zzbfm {
    public static final Parcelable.Creator<zzz> CREATOR = new zzaa();

    /* JADX INFO: renamed from: a */
    private final String f8234a;

    /* JADX INFO: renamed from: b */
    private final String f8235b;

    /* JADX INFO: renamed from: c */
    private final int f8236c;

    /* JADX INFO: renamed from: d */
    private final boolean f8237d;

    /* JADX INFO: renamed from: e */
    private final String f8238e;

    zzz(String str, String str2, String str3, int i, boolean z) {
        this.f8238e = str;
        this.f8234a = str2;
        this.f8235b = str3;
        this.f8236c = i;
        this.f8237d = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 1, this.f8234a, false);
        zzbfp.m7748a(parcel, 2, this.f8235b, false);
        zzbfp.m7738a(parcel, 3, this.f8236c);
        zzbfp.m7751a(parcel, 4, this.f8237d);
        zzbfp.m7748a(parcel, 5, this.f8238e, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
