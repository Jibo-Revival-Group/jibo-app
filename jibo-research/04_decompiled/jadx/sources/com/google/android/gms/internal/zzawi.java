package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.zzd;
import com.google.android.gms.auth.api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;

/* JADX INFO: loaded from: classes.dex */
public final class zzawi extends zzab<zzawl> {

    /* JADX INFO: renamed from: d */
    private final Bundle f6855d;

    public zzawi(Context context, Looper looper, zzr zzrVar, zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, zzrVar, connectionCallbacks, onConnectionFailedListener);
        if (zzfVar != null) {
            throw new NoSuchMethodError();
        }
        this.f6855d = new Bundle();
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ IInterface mo6768a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        return iInterfaceQueryLocalInterface instanceof zzawl ? (zzawl) iInterfaceQueryLocalInterface : new zzawm(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: b */
    protected final String mo6769b() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: b_ */
    protected final String mo6770b_() {
        return "com.google.android.gms.auth.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzd, com.google.android.gms.common.api.Api.zze
    /* JADX INFO: renamed from: i */
    public final boolean mo6864i() {
        zzr zzrVarM7312n = m7312n();
        return (TextUtils.isEmpty(zzrVarM7312n.m7449a()) || zzrVarM7312n.m7450a(zzd.f6053a).isEmpty()) ? false : true;
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: t */
    protected final Bundle mo7437t() {
        return this.f6855d;
    }
}
