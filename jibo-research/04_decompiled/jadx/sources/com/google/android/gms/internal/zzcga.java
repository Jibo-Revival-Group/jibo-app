package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.location.places.PlacesStatusCodes;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class zzcga extends zzd<zzcfz> implements Result {

    /* JADX INFO: renamed from: b */
    private final Status f7048b;

    public zzcga(DataHolder dataHolder) {
        this(dataHolder, PlacesStatusCodes.m8774c(dataHolder.m7273b()));
    }

    private zzcga(DataHolder dataHolder, Status status) {
        super(dataHolder, zzcfz.CREATOR);
        zzbq.m7382b(dataHolder == null || dataHolder.m7273b() == status.m6936d());
        this.f7048b = status;
    }

    @Override // com.google.android.gms.common.api.Result
    /* JADX INFO: renamed from: a */
    public final Status mo6927a() {
        return this.f7048b;
    }
}
