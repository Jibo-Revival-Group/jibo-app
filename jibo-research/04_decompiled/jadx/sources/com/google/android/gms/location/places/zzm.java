package com.google.android.gms.location.places;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzcga;
import com.google.android.gms.location.places.internal.zzx;

/* JADX INFO: loaded from: classes.dex */
public class zzm extends zzx {

    /* JADX INFO: renamed from: a */
    private static final String f8210a = zzm.class.getSimpleName();

    /* JADX INFO: renamed from: b */
    private final zzd f8211b;

    /* JADX INFO: renamed from: c */
    private final zza f8212c;

    /* JADX INFO: renamed from: d */
    private final zze f8213d;

    /* JADX INFO: renamed from: e */
    private final zzf f8214e;

    /* JADX INFO: renamed from: f */
    private final zzc f8215f;

    public static abstract class zza<A extends Api.zze> extends zzb<AutocompletePredictionBuffer, A> {
        public zza(Api api, GoogleApiClient googleApiClient) {
            super(api, googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        /* JADX INFO: renamed from: a */
        protected final /* synthetic */ Result mo6777a(Status status) {
            return new AutocompletePredictionBuffer(DataHolder.m7268b(status.m6936d()));
        }
    }

    public static abstract class zzb<R extends Result, A extends Api.zze> extends com.google.android.gms.common.api.internal.zzm<R, A> {
        public zzb(Api api, GoogleApiClient googleApiClient) {
            super(api, googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.zzm, com.google.android.gms.common.api.internal.zzn
        /* JADX INFO: renamed from: a */
        public final /* bridge */ /* synthetic */ void mo6779a(Object obj) {
            super.m6942a((Result) obj);
        }
    }

    public static abstract class zzc<A extends Api.zze> extends zzb<PlaceBuffer, A> {
        public zzc(Api api, GoogleApiClient googleApiClient) {
            super(api, googleApiClient);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        /* JADX INFO: renamed from: a */
        protected final /* synthetic */ Result mo6777a(Status status) {
            return new PlaceBuffer(DataHolder.m7268b(status.m6936d()));
        }
    }

    public static abstract class zzd<A extends Api.zze> extends zzb<PlaceLikelihoodBuffer, A> {
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        /* JADX INFO: renamed from: a */
        protected final /* synthetic */ Result mo6777a(Status status) {
            return new PlaceLikelihoodBuffer(DataHolder.m7268b(status.m6936d()), 100);
        }
    }

    @Deprecated
    public static abstract class zze<A extends Api.zze> extends zzb<zzcga, A> {
    }

    public static abstract class zzf<A extends Api.zze> extends zzb<Status, A> {
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        /* JADX INFO: renamed from: a */
        protected final /* synthetic */ Result mo6777a(Status status) {
            return status;
        }
    }

    public zzm(zza zzaVar) {
        this.f8211b = null;
        this.f8212c = zzaVar;
        this.f8213d = null;
        this.f8214e = null;
        this.f8215f = null;
    }

    public zzm(zzc zzcVar) {
        this.f8211b = null;
        this.f8212c = null;
        this.f8213d = null;
        this.f8214e = null;
        this.f8215f = zzcVar;
    }

    @Override // com.google.android.gms.location.places.internal.zzw
    /* JADX INFO: renamed from: a */
    public final void mo8804a(Status status) throws RemoteException {
        this.f8214e.m6942a(status);
    }

    @Override // com.google.android.gms.location.places.internal.zzw
    /* JADX INFO: renamed from: a */
    public final void mo8805a(DataHolder dataHolder) throws RemoteException {
        zzbq.m7379a(this.f8211b != null, "placeEstimator cannot be null");
        if (dataHolder != null) {
            Bundle bundleM7276c = dataHolder.m7276c();
            this.f8211b.m6942a(new PlaceLikelihoodBuffer(dataHolder, bundleM7276c == null ? 100 : PlaceLikelihoodBuffer.m8767a(bundleM7276c)));
        } else {
            if (Log.isLoggable(f8210a, 6)) {
                Log.e(f8210a, "onPlaceEstimated received null DataHolder", new Throwable());
            }
            this.f8211b.m7225c(Status.f6131c);
        }
    }

    @Override // com.google.android.gms.location.places.internal.zzw
    /* JADX INFO: renamed from: b */
    public final void mo8806b(DataHolder dataHolder) throws RemoteException {
        if (dataHolder != null) {
            this.f8212c.m6942a(new AutocompletePredictionBuffer(dataHolder));
            return;
        }
        if (Log.isLoggable(f8210a, 6)) {
            Log.e(f8210a, "onAutocompletePrediction received null DataHolder", new Throwable());
        }
        this.f8212c.m7225c(Status.f6131c);
    }

    @Override // com.google.android.gms.location.places.internal.zzw
    /* JADX INFO: renamed from: c */
    public final void mo8807c(DataHolder dataHolder) throws RemoteException {
        com.google.android.gms.common.api.internal.zzm zzmVar = null;
        if (dataHolder != null) {
            zzmVar.m6942a(new zzcga(dataHolder));
            return;
        }
        if (Log.isLoggable(f8210a, 6)) {
            Log.e(f8210a, "onPlaceUserDataFetched received null DataHolder", new Throwable());
        }
        zzmVar.m7225c(Status.f6131c);
    }

    @Override // com.google.android.gms.location.places.internal.zzw
    /* JADX INFO: renamed from: d */
    public final void mo8808d(DataHolder dataHolder) throws RemoteException {
        this.f8215f.m6942a(new PlaceBuffer(dataHolder));
    }
}
