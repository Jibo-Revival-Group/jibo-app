package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class zzcln extends zzbfm {
    public static final Parcelable.Creator<zzcln> CREATOR = new zzclo();

    /* JADX INFO: renamed from: a */
    public final String f7598a;

    /* JADX INFO: renamed from: b */
    public final long f7599b;

    /* JADX INFO: renamed from: c */
    public final String f7600c;

    /* JADX INFO: renamed from: d */
    private int f7601d;

    /* JADX INFO: renamed from: e */
    private Long f7602e;

    /* JADX INFO: renamed from: f */
    private Float f7603f;

    /* JADX INFO: renamed from: g */
    private String f7604g;

    /* JADX INFO: renamed from: h */
    private Double f7605h;

    zzcln(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        this.f7601d = i;
        this.f7598a = str;
        this.f7599b = j;
        this.f7602e = l;
        this.f7603f = null;
        if (i == 1) {
            this.f7605h = f != null ? Double.valueOf(f.doubleValue()) : null;
        } else {
            this.f7605h = d;
        }
        this.f7604g = str2;
        this.f7600c = str3;
    }

    zzcln(zzclp zzclpVar) {
        this(zzclpVar.f7608c, zzclpVar.f7609d, zzclpVar.f7610e, zzclpVar.f7607b);
    }

    zzcln(String str, long j, Object obj, String str2) {
        zzbq.m7375a(str);
        this.f7601d = 2;
        this.f7598a = str;
        this.f7599b = j;
        this.f7600c = str2;
        if (obj == null) {
            this.f7602e = null;
            this.f7603f = null;
            this.f7605h = null;
            this.f7604g = null;
            return;
        }
        if (obj instanceof Long) {
            this.f7602e = (Long) obj;
            this.f7603f = null;
            this.f7605h = null;
            this.f7604g = null;
            return;
        }
        if (obj instanceof String) {
            this.f7602e = null;
            this.f7603f = null;
            this.f7605h = null;
            this.f7604g = (String) obj;
            return;
        }
        if (!(obj instanceof Double)) {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
        this.f7602e = null;
        this.f7603f = null;
        this.f7605h = (Double) obj;
        this.f7604g = null;
    }

    /* JADX INFO: renamed from: a */
    public final Object m8383a() {
        if (this.f7602e != null) {
            return this.f7602e;
        }
        if (this.f7605h != null) {
            return this.f7605h;
        }
        if (this.f7604g != null) {
            return this.f7604g;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f7601d);
        zzbfp.m7748a(parcel, 2, this.f7598a, false);
        zzbfp.m7739a(parcel, 3, this.f7599b);
        zzbfp.m7747a(parcel, 4, this.f7602e, false);
        zzbfp.m7745a(parcel, 5, (Float) null, false);
        zzbfp.m7748a(parcel, 6, this.f7604g, false);
        zzbfp.m7748a(parcel, 7, this.f7600c, false);
        zzbfp.m7744a(parcel, 8, this.f7605h, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
