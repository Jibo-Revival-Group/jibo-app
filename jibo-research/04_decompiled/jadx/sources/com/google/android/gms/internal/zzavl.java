package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class zzavl extends zzbfm {
    public static final Parcelable.Creator<zzavl> CREATOR = new zzavm();

    /* JADX INFO: renamed from: a */
    private int f6849a = 1;

    /* JADX INFO: renamed from: b */
    private String f6850b;

    /* JADX INFO: renamed from: c */
    private PendingIntent f6851c;

    zzavl(int i, String str, PendingIntent pendingIntent) {
        this.f6850b = (String) zzbq.m7373a(str);
        this.f6851c = (PendingIntent) zzbq.m7373a(pendingIntent);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7738a(parcel, 1, this.f6849a);
        zzbfp.m7748a(parcel, 2, this.f6850b, false);
        zzbfp.m7743a(parcel, 3, (Parcelable) this.f6851c, i, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
