package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;

/* JADX INFO: loaded from: classes.dex */
public final class zzn extends zzbfm {
    public static final Parcelable.Creator<zzn> CREATOR = new zzm();

    /* JADX INFO: renamed from: a */
    private int f6038a;

    /* JADX INFO: renamed from: b */
    private int f6039b;

    /* JADX INFO: renamed from: c */
    private Bundle f6040c;

    zzn(int i, int i2, Bundle bundle) {
        this.f6038a = i;
        this.f6039b = i2;
        this.f6040c = bundle;
    }

    /* JADX INFO: renamed from: a */
    public final int m6780a() {
        return this.f6039b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6038a);
        zzbfp.m7738a(parcel, 2, this.f6039b);
        zzbfp.m7740a(parcel, 3, this.f6040c, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
