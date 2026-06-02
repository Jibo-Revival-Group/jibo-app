package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public class ProxyRequest extends zzbfm {
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new zza();

    /* JADX INFO: renamed from: a */
    public static final int f5960a = 0;

    /* JADX INFO: renamed from: b */
    public static final int f5961b = 1;

    /* JADX INFO: renamed from: c */
    public static final int f5962c = 2;

    /* JADX INFO: renamed from: d */
    public static final int f5963d = 3;

    /* JADX INFO: renamed from: e */
    public static final int f5964e = 4;

    /* JADX INFO: renamed from: f */
    public static final int f5965f = 5;

    /* JADX INFO: renamed from: g */
    public static final int f5966g = 6;

    /* JADX INFO: renamed from: h */
    public static final int f5967h = 7;

    /* JADX INFO: renamed from: i */
    public static final int f5968i = 7;

    /* JADX INFO: renamed from: j */
    public final String f5969j;

    /* JADX INFO: renamed from: k */
    public final int f5970k;

    /* JADX INFO: renamed from: l */
    public final long f5971l;

    /* JADX INFO: renamed from: m */
    public final byte[] f5972m;

    /* JADX INFO: renamed from: n */
    private int f5973n;

    /* JADX INFO: renamed from: o */
    private Bundle f5974o;

    ProxyRequest(int i, String str, int i2, long j, byte[] bArr, Bundle bundle) {
        this.f5973n = i;
        this.f5969j = str;
        this.f5970k = i2;
        this.f5971l = j;
        this.f5972m = bArr;
        this.f5974o = bundle;
    }

    public String toString() {
        String str = this.f5969j;
        return new StringBuilder(String.valueOf(str).length() + 42).append("ProxyRequest[ url: ").append(str).append(", method: ").append(this.f5970k).append(" ]").toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7748a(parcel, 1, this.f5969j, false);
        zzbfp.m7738a(parcel, 2, this.f5970k);
        zzbfp.m7739a(parcel, 3, this.f5971l);
        zzbfp.m7752a(parcel, 4, this.f5972m, false);
        zzbfp.m7740a(parcel, 5, this.f5974o, false);
        zzbfp.m7738a(parcel, 1000, this.f5973n);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
