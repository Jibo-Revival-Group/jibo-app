package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zzda;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class PendingResults {

    static final class zzb<R extends Result> extends BasePendingResult<R> {

        /* JADX INFO: renamed from: b */
        private final R f6126b;

        public zzb(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.f6126b = r;
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        /* JADX INFO: renamed from: a */
        protected final R mo6777a(Status status) {
            return this.f6126b;
        }
    }

    /* JADX INFO: renamed from: a */
    public static <R extends Result> PendingResult<R> m6924a(R r, GoogleApiClient googleApiClient) {
        zzbq.m7374a(r, "Result must not be null");
        zzbq.m7383b(!r.mo6927a().m6935c(), "Status code must not be SUCCESS");
        zzb zzbVar = new zzb(googleApiClient, r);
        zzbVar.m6942a(r);
        return zzbVar;
    }

    /* JADX INFO: renamed from: a */
    public static PendingResult<Status> m6925a(Status status) {
        zzbq.m7374a(status, "Result must not be null");
        zzda zzdaVar = new zzda(Looper.getMainLooper());
        zzdaVar.m6942a(status);
        return zzdaVar;
    }
}
