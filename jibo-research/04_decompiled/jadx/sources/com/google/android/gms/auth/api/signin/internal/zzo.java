package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.zzbq;

/* JADX INFO: loaded from: classes.dex */
public final class zzo {

    /* JADX INFO: renamed from: a */
    private static zzo f6041a = null;

    /* JADX INFO: renamed from: b */
    private zzz f6042b;

    /* JADX INFO: renamed from: c */
    private GoogleSignInAccount f6043c;

    /* JADX INFO: renamed from: d */
    private GoogleSignInOptions f6044d;

    private zzo(Context context) {
        this.f6042b = zzz.m6793a(context);
        this.f6043c = this.f6042b.m6798a();
        this.f6044d = this.f6042b.m6801b();
    }

    /* JADX INFO: renamed from: a */
    public static synchronized zzo m6781a(Context context) {
        return m6782b(context.getApplicationContext());
    }

    /* JADX INFO: renamed from: b */
    private static synchronized zzo m6782b(Context context) {
        if (f6041a == null) {
            f6041a = new zzo(context);
        }
        return f6041a;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m6783a() {
        this.f6042b.m6803d();
        this.f6043c = null;
        this.f6044d = null;
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m6784a(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        zzz zzzVar = this.f6042b;
        zzbq.m7373a(googleSignInAccount);
        zzbq.m7373a(googleSignInOptions);
        zzzVar.m6800a("defaultGoogleSignInAccount", googleSignInAccount.m6735j());
        zzzVar.m6799a(googleSignInAccount, googleSignInOptions);
        this.f6043c = googleSignInAccount;
        this.f6044d = googleSignInOptions;
    }
}
