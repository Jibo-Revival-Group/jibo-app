package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzcz;
import com.google.android.gms.common.api.internal.zzg;

/* JADX INFO: loaded from: classes.dex */
public final class zzbej extends GoogleApi<Object> implements zzbee {
    private zzbej(Context context) {
        super(context, (Api<Api.ApiOptions>) zzbdy.f6857a, (Api.ApiOptions) null, (zzcz) new zzg());
    }

    /* JADX INFO: renamed from: a */
    public static zzbee m7672a(Context context) {
        return new zzbej(context);
    }

    @Override // com.google.android.gms.internal.zzbee
    /* JADX INFO: renamed from: a */
    public final PendingResult<Status> mo7671a(zzbeh zzbehVar) {
        return m6880c(new zzbem(zzbehVar, m6881d()));
    }
}
