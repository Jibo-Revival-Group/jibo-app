package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbfm;
import com.google.android.gms.internal.zzbfp;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzam extends zzbfm {
    public static final Parcelable.Creator<zzam> CREATOR = new zzap();

    /* JADX INFO: renamed from: a */
    private List<zzan> f8182a;

    /* JADX INFO: renamed from: b */
    private List<zzao> f8183b;

    zzam(List<zzan> list, List<zzao> list2) {
        this.f8182a = Collections.unmodifiableList(list);
        this.f8183b = Collections.unmodifiableList(list2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM7733a = zzbfp.m7733a(parcel);
        zzbfp.m7762c(parcel, 1, this.f8182a, false);
        zzbfp.m7762c(parcel, 2, this.f8183b, false);
        zzbfp.m7734a(parcel, iM7733a);
    }
}
