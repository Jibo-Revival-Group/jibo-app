package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public class ProxyResponse extends zzbfm {
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new zzb();

    /* JADX INFO: renamed from: a */
    public final int f5975a;

    /* JADX INFO: renamed from: b */
    public final PendingIntent f5976b;

    /* JADX INFO: renamed from: c */
    public final int f5977c;

    /* JADX INFO: renamed from: d */
    public final byte[] f5978d;

    /* JADX INFO: renamed from: e */
    private int f5979e;

    /* JADX INFO: renamed from: f */
    private Bundle f5980f;

    ProxyResponse(int i, int i2, PendingIntent pendingIntent, int i3, Bundle bundle, byte[] bArr) {
        this.f5979e = i;
        this.f5975a = i2;
        this.f5977c = i3;
        this.f5980f = bundle;
        this.f5978d = bArr;
        this.f5976b = pendingIntent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f5975a);
        zzbfp.m7743a(parcel, 2, (Parcelable) this.f5976b, i, false);
        zzbfp.m7738a(parcel, 3, this.f5977c);
        zzbfp.m7740a(parcel, 4, this.f5980f, false);
        zzbfp.m7752a(parcel, 5, this.f5978d, false);
        zzbfp.m7738a(parcel, 1000, this.f5979e);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
