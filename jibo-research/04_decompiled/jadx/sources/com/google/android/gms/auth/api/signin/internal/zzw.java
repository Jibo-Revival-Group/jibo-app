package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes.dex */
public final class zzw extends zzr {

    /* JADX INFO: renamed from: a */
    private final Context f6047a;

    public zzw(Context context) {
        this.f6047a = context;
    }

    /* JADX INFO: renamed from: c */
    private final void m6791c() {
        if (GooglePlayServicesUtil.zzf(this.f6047a, Binder.getCallingUid())) {
            return;
        }
        throw new SecurityException(new StringBuilder(52).append("Calling UID ").append(Binder.getCallingUid()).append(" is not Google Play services.").toString());
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzq
    /* JADX INFO: renamed from: a */
    public final void mo6788a() {
        m6791c();
        zzz zzzVarM6793a = zzz.m6793a(this.f6047a);
        GoogleSignInAccount googleSignInAccountM6798a = zzzVarM6793a.m6798a();
        GoogleSignInOptions googleSignInOptionsM6801b = GoogleSignInOptions.f6000f;
        if (googleSignInAccountM6798a != null) {
            googleSignInOptionsM6801b = zzzVarM6793a.m6801b();
        }
        GoogleApiClient googleApiClientM6913b = new GoogleApiClient.Builder(this.f6047a).m6909a(Auth.f5862e, googleSignInOptionsM6801b).m6913b();
        try {
            if (googleApiClientM6913b.mo6902f().m6821b()) {
                if (googleSignInAccountM6798a != null) {
                    Auth.f5865h.mo6738a(googleApiClientM6913b);
                } else {
                    googleApiClientM6913b.mo6905i();
                }
            }
        } finally {
            googleApiClientM6913b.mo6903g();
        }
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzq
    /* JADX INFO: renamed from: b */
    public final void mo6789b() {
        m6791c();
        zzo.m6781a(this.f6047a).m6783a();
    }
}
