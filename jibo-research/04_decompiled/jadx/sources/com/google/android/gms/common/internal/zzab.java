package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public abstract class zzab<T extends IInterface> extends zzd<T> implements Api.zze, zzaf {

    /* JADX INFO: renamed from: d */
    private final zzr f6524d;

    /* JADX INFO: renamed from: e */
    private final Set<Scope> f6525e;

    /* JADX INFO: renamed from: f */
    private final Account f6526f;

    protected zzab(Context context, Looper looper, int i, zzr zzrVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzag.m7326a(context), GoogleApiAvailability.m6828a(), i, zzrVar, (GoogleApiClient.ConnectionCallbacks) zzbq.m7373a(connectionCallbacks), (GoogleApiClient.OnConnectionFailedListener) zzbq.m7373a(onConnectionFailedListener));
    }

    private zzab(Context context, Looper looper, zzag zzagVar, GoogleApiAvailability googleApiAvailability, int i, zzr zzrVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, zzagVar, googleApiAvailability, i, connectionCallbacks == null ? null : new zzac(connectionCallbacks), onConnectionFailedListener == null ? null : new zzad(onConnectionFailedListener), zzrVar.m7458h());
        this.f6524d = zzrVar;
        this.f6526f = zzrVar.m7452b();
        Set<Scope> setM7455e = zzrVar.m7455e();
        Set<Scope> setM7310a = m7310a(setM7455e);
        Iterator<Scope> it = setM7310a.iterator();
        while (it.hasNext()) {
            if (!setM7455e.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f6525e = setM7310a;
    }

    /* JADX INFO: renamed from: a */
    protected Set<Scope> m7310a(Set<Scope> set) {
        return set;
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: e_ */
    public final Account mo7311e_() {
        return this.f6526f;
    }

    /* JADX INFO: renamed from: n */
    protected final zzr m7312n() {
        return this.f6524d;
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: o */
    protected final Set<Scope> mo7313o() {
        return this.f6525e;
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: p */
    public com.google.android.gms.common.zzc[] mo7314p() {
        return new com.google.android.gms.common.zzc[0];
    }
}
