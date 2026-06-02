package com.google.android.gms.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzag extends zzbfm {
    public static final Parcelable.Creator<zzag> CREATOR = new zzah();

    /* JADX INFO: renamed from: a */
    private final List<String> f8226a;

    /* JADX INFO: renamed from: b */
    private final PendingIntent f8227b;

    /* JADX INFO: renamed from: c */
    private final String f8228c;

    zzag(List<String> list, PendingIntent pendingIntent, String str) {
        this.f8226a = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        this.f8227b = pendingIntent;
        this.f8228c = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7760b(parcel, 1, this.f8226a, false);
        zzbfp.m7743a(parcel, 2, (Parcelable) this.f8227b, i, false);
        zzbfp.m7748a(parcel, 3, this.f8228c, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
