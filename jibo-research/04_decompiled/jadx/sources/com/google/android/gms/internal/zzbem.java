package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zzm;

/* JADX INFO: loaded from: classes.dex */
final class zzbem extends zzm<Status, zzbeo> {

    /* JADX INFO: renamed from: b */
    private final zzbeh f6904b;

    zzbem(zzbeh zzbehVar, GoogleApiClient googleApiClient) {
        super(zzbdy.f6857a, googleApiClient);
        this.f6904b = zzbehVar;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ Result mo6777a(Status status) {
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.zzm
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ void mo6778a(Api.zzb zzbVar) throws RemoteException {
        zzbeo zzbeoVar = (zzbeo) zzbVar;
        zzben zzbenVar = new zzben(this);
        try {
            zzbeh zzbehVar = this.f6904b;
            if (zzbehVar.f6896d != null && zzbehVar.f6895c.f7996c.length == 0) {
                zzbehVar.f6895c.f7996c = zzbehVar.f6896d.m7670a();
            }
            if (zzbehVar.f6897e != null && zzbehVar.f6895c.f7998e.length == 0) {
                zzbehVar.f6895c.f7998e = zzbehVar.f6897e.m7670a();
            }
            zzbehVar.f6894b = zzfjs.m8711a(zzbehVar.f6895c);
            ((zzbes) zzbeoVar.m7439v()).mo7688a(zzbenVar, this.f6904b);
        } catch (RuntimeException e) {
            Log.e("ClearcutLoggerApiImpl", "derived ClearcutLogger.MessageProducer ", e);
            m7225c(new Status(10, "MessageProducer"));
        }
    }

    @Override // com.google.android.gms.common.api.internal.zzm, com.google.android.gms.common.api.internal.zzn
    /* JADX INFO: renamed from: a */
    public final /* bridge */ /* synthetic */ void mo6779a(Object obj) {
        super.m6942a((Status) obj);
    }
}
