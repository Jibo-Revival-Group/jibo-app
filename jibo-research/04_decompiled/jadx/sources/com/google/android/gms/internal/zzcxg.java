package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class zzcxg extends zzbfm implements Result {
    public static final Parcelable.Creator<zzcxg> CREATOR = new zzcxh();

    /* JADX INFO: renamed from: a */
    private int f7784a;

    /* JADX INFO: renamed from: b */
    private int f7785b;

    /* JADX INFO: renamed from: c */
    private Intent f7786c;

    public zzcxg() {
        this(0, null);
    }

    zzcxg(int i, int i2, Intent intent) {
        this.f7784a = i;
        this.f7785b = i2;
        this.f7786c = intent;
    }

    private zzcxg(int i, Intent intent) {
        this(2, 0, null);
    }

    @Override // com.google.android.gms.common.api.Result
    /* JADX INFO: renamed from: a */
    public final Status mo6927a() {
        return this.f7785b == 0 ? Status.f6129a : Status.f6133e;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f7784a);
        zzbfp.m7738a(parcel, 2, this.f7785b);
        zzbfp.m7743a(parcel, 3, (Parcelable) this.f7786c, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
