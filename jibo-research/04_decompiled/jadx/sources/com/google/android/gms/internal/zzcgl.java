package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class zzcgl extends zzbfm {
    public static final Parcelable.Creator<zzcgl> CREATOR = new zzcgm();

    /* JADX INFO: renamed from: a */
    public String f7102a;

    /* JADX INFO: renamed from: b */
    public String f7103b;

    /* JADX INFO: renamed from: c */
    public zzcln f7104c;

    /* JADX INFO: renamed from: d */
    public long f7105d;

    /* JADX INFO: renamed from: e */
    public boolean f7106e;

    /* JADX INFO: renamed from: f */
    public String f7107f;

    /* JADX INFO: renamed from: g */
    public zzcha f7108g;

    /* JADX INFO: renamed from: h */
    public long f7109h;

    /* JADX INFO: renamed from: i */
    public zzcha f7110i;

    /* JADX INFO: renamed from: j */
    public long f7111j;

    /* JADX INFO: renamed from: k */
    public zzcha f7112k;

    /* JADX INFO: renamed from: l */
    private int f7113l;

    zzcgl(int i, String str, String str2, zzcln zzclnVar, long j, boolean z, String str3, zzcha zzchaVar, long j2, zzcha zzchaVar2, long j3, zzcha zzchaVar3) {
        this.f7113l = i;
        this.f7102a = str;
        this.f7103b = str2;
        this.f7104c = zzclnVar;
        this.f7105d = j;
        this.f7106e = z;
        this.f7107f = str3;
        this.f7108g = zzchaVar;
        this.f7109h = j2;
        this.f7110i = zzchaVar2;
        this.f7111j = j3;
        this.f7112k = zzchaVar3;
    }

    zzcgl(zzcgl zzcglVar) {
        this.f7113l = 1;
        zzbq.m7373a(zzcglVar);
        this.f7102a = zzcglVar.f7102a;
        this.f7103b = zzcglVar.f7103b;
        this.f7104c = zzcglVar.f7104c;
        this.f7105d = zzcglVar.f7105d;
        this.f7106e = zzcglVar.f7106e;
        this.f7107f = zzcglVar.f7107f;
        this.f7108g = zzcglVar.f7108g;
        this.f7109h = zzcglVar.f7109h;
        this.f7110i = zzcglVar.f7110i;
        this.f7111j = zzcglVar.f7111j;
        this.f7112k = zzcglVar.f7112k;
    }

    zzcgl(String str, String str2, zzcln zzclnVar, long j, boolean z, String str3, zzcha zzchaVar, long j2, zzcha zzchaVar2, long j3, zzcha zzchaVar3) {
        this.f7113l = 1;
        this.f7102a = str;
        this.f7103b = str2;
        this.f7104c = zzclnVar;
        this.f7105d = j;
        this.f7106e = z;
        this.f7107f = str3;
        this.f7108g = zzchaVar;
        this.f7109h = j2;
        this.f7110i = zzchaVar2;
        this.f7111j = j3;
        this.f7112k = zzchaVar3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f7113l);
        zzbfp.m7748a(parcel, 2, this.f7102a, false);
        zzbfp.m7748a(parcel, 3, this.f7103b, false);
        zzbfp.m7743a(parcel, 4, (Parcelable) this.f7104c, i, false);
        zzbfp.m7739a(parcel, 5, this.f7105d);
        zzbfp.m7751a(parcel, 6, this.f7106e);
        zzbfp.m7748a(parcel, 7, this.f7107f, false);
        zzbfp.m7743a(parcel, 8, (Parcelable) this.f7108g, i, false);
        zzbfp.m7739a(parcel, 9, this.f7109h);
        zzbfp.m7743a(parcel, 10, (Parcelable) this.f7110i, i, false);
        zzbfp.m7739a(parcel, 11, this.f7111j);
        zzbfp.m7743a(parcel, 12, (Parcelable) this.f7112k, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
