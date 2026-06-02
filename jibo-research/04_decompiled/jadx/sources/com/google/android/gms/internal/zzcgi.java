package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgi extends zzbfm {
    public static final Parcelable.Creator<zzcgi> CREATOR = new zzcgj();

    /* JADX INFO: renamed from: a */
    public final String f7087a;

    /* JADX INFO: renamed from: b */
    public final String f7088b;

    /* JADX INFO: renamed from: c */
    public final String f7089c;

    /* JADX INFO: renamed from: d */
    public final String f7090d;

    /* JADX INFO: renamed from: e */
    public final long f7091e;

    /* JADX INFO: renamed from: f */
    public final long f7092f;

    /* JADX INFO: renamed from: g */
    public final String f7093g;

    /* JADX INFO: renamed from: h */
    public final boolean f7094h;

    /* JADX INFO: renamed from: i */
    public final boolean f7095i;

    /* JADX INFO: renamed from: j */
    public final long f7096j;

    /* JADX INFO: renamed from: k */
    public final String f7097k;

    /* JADX INFO: renamed from: l */
    public final long f7098l;

    /* JADX INFO: renamed from: m */
    public final long f7099m;

    /* JADX INFO: renamed from: n */
    public final int f7100n;

    /* JADX INFO: renamed from: o */
    public final boolean f7101o;

    zzcgi(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3) {
        zzbq.m7375a(str);
        this.f7087a = str;
        this.f7088b = TextUtils.isEmpty(str2) ? null : str2;
        this.f7089c = str3;
        this.f7096j = j;
        this.f7090d = str4;
        this.f7091e = j2;
        this.f7092f = j3;
        this.f7093g = str5;
        this.f7094h = z;
        this.f7095i = z2;
        this.f7097k = str6;
        this.f7098l = j4;
        this.f7099m = j5;
        this.f7100n = i;
        this.f7101o = z3;
    }

    zzcgi(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, long j5, int i, boolean z3) {
        this.f7087a = str;
        this.f7088b = str2;
        this.f7089c = str3;
        this.f7096j = j3;
        this.f7090d = str4;
        this.f7091e = j;
        this.f7092f = j2;
        this.f7093g = str5;
        this.f7094h = z;
        this.f7095i = z2;
        this.f7097k = str6;
        this.f7098l = j4;
        this.f7099m = j5;
        this.f7100n = i;
        this.f7101o = z3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 2, this.f7087a, false);
        zzbfp.m7748a(parcel, 3, this.f7088b, false);
        zzbfp.m7748a(parcel, 4, this.f7089c, false);
        zzbfp.m7748a(parcel, 5, this.f7090d, false);
        zzbfp.m7739a(parcel, 6, this.f7091e);
        zzbfp.m7739a(parcel, 7, this.f7092f);
        zzbfp.m7748a(parcel, 8, this.f7093g, false);
        zzbfp.m7751a(parcel, 9, this.f7094h);
        zzbfp.m7751a(parcel, 10, this.f7095i);
        zzbfp.m7739a(parcel, 11, this.f7096j);
        zzbfp.m7748a(parcel, 12, this.f7097k, false);
        zzbfp.m7739a(parcel, 13, this.f7098l);
        zzbfp.m7739a(parcel, 14, this.f7099m);
        zzbfp.m7738a(parcel, 15, this.f7100n);
        zzbfp.m7751a(parcel, 16, this.f7101o);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
