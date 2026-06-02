package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzab;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class zzd extends zzab<zzu> {

    /* JADX INFO: renamed from: d */
    private final GoogleSignInOptions f6035d;

    public zzd(Context context, Looper looper, com.google.android.gms.common.internal.zzr zzrVar, GoogleSignInOptions googleSignInOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 91, zzrVar, connectionCallbacks, onConnectionFailedListener);
        googleSignInOptions = googleSignInOptions == null ? new GoogleSignInOptions.Builder().m6756c() : googleSignInOptions;
        if (!zzrVar.m7455e().isEmpty()) {
            GoogleSignInOptions.Builder builder = new GoogleSignInOptions.Builder(googleSignInOptions);
            Iterator<Scope> it = zzrVar.m7455e().iterator();
            while (it.hasNext()) {
                builder.m6754a(it.next(), new Scope[0]);
            }
            googleSignInOptions = builder.m6756c();
        }
        this.f6035d = googleSignInOptions;
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: a */
    protected final /* synthetic */ IInterface mo6768a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof zzu ? (zzu) iInterfaceQueryLocalInterface : new zzv(iBinder);
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: b */
    protected final String mo6769b() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.zzd
    /* JADX INFO: renamed from: b_ */
    protected final String mo6770b_() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    @Override // com.google.android.gms.common.internal.zzd, com.google.android.gms.common.api.Api.zze
    /* JADX INFO: renamed from: c */
    public final boolean mo6771c() {
        return true;
    }

    @Override // com.google.android.gms.common.internal.zzd, com.google.android.gms.common.api.Api.zze
    /* JADX INFO: renamed from: d */
    public final Intent mo6772d() {
        return zze.m6774a(m7436s(), this.f6035d);
    }

    /* JADX INFO: renamed from: e */
    public final GoogleSignInOptions m6773e() {
        return this.f6035d;
    }
}
