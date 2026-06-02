package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.PasswordSpecification;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.zzaur;
import com.google.android.gms.internal.zzaus;
import com.google.android.gms.internal.zzaut;
import com.google.android.gms.internal.zzavp;
import com.google.android.gms.internal.zzavy;
import com.google.android.gms.internal.zzawx;

/* JADX INFO: loaded from: classes.dex */
public final class Auth {

    /* JADX INFO: renamed from: a */
    public static final Api.zzf<zzavy> f5858a = new Api.zzf<>();

    /* JADX INFO: renamed from: i */
    private static Api.zzf<zzaut> f5866i = new Api.zzf<>();

    /* JADX INFO: renamed from: b */
    public static final Api.zzf<com.google.android.gms.auth.api.signin.internal.zzd> f5859b = new Api.zzf<>();

    /* JADX INFO: renamed from: j */
    private static final Api.zza<zzavy, AuthCredentialsOptions> f5867j = new zza();

    /* JADX INFO: renamed from: k */
    private static final Api.zza<zzaut, Object> f5868k = new zzb();

    /* JADX INFO: renamed from: l */
    private static final Api.zza<com.google.android.gms.auth.api.signin.internal.zzd, GoogleSignInOptions> f5869l = new zzc();

    /* JADX INFO: renamed from: c */
    public static final Api<zzf> f5860c = zzd.f6053a;

    /* JADX INFO: renamed from: d */
    public static final Api<AuthCredentialsOptions> f5861d = new Api<>("Auth.CREDENTIALS_API", f5867j, f5858a);

    /* JADX INFO: renamed from: e */
    public static final Api<GoogleSignInOptions> f5862e = new Api<>("Auth.GOOGLE_SIGN_IN_API", f5869l, f5859b);

    /* JADX INFO: renamed from: m */
    private static Api<Object> f5870m = new Api<>("Auth.ACCOUNT_STATUS_API", f5868k, f5866i);

    /* JADX INFO: renamed from: f */
    public static final ProxyApi f5863f = new zzawx();

    /* JADX INFO: renamed from: g */
    public static final CredentialsApi f5864g = new zzavp();

    /* JADX INFO: renamed from: n */
    private static zzaur f5871n = new zzaus();

    /* JADX INFO: renamed from: h */
    public static final GoogleSignInApi f5865h = new com.google.android.gms.auth.api.signin.internal.zzc();

    @Deprecated
    public static class AuthCredentialsOptions implements Api.ApiOptions.Optional {

        /* JADX INFO: renamed from: a */
        private static AuthCredentialsOptions f5872a = new Builder().m6675a();

        /* JADX INFO: renamed from: b */
        private final String f5873b = null;

        /* JADX INFO: renamed from: c */
        private final PasswordSpecification f5874c;

        /* JADX INFO: renamed from: d */
        private final boolean f5875d;

        @Deprecated
        public static class Builder {

            /* JADX INFO: renamed from: a */
            protected PasswordSpecification f5876a = PasswordSpecification.f5946a;

            /* JADX INFO: renamed from: b */
            protected Boolean f5877b = false;

            /* JADX INFO: renamed from: a */
            public AuthCredentialsOptions m6675a() {
                return new AuthCredentialsOptions(this);
            }
        }

        public AuthCredentialsOptions(Builder builder) {
            this.f5874c = builder.f5876a;
            this.f5875d = builder.f5877b.booleanValue();
        }

        /* JADX INFO: renamed from: a */
        public final Bundle m6674a() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", null);
            bundle.putParcelable("password_specification", this.f5874c);
            bundle.putBoolean("force_save_dialog", this.f5875d);
            return bundle;
        }
    }
}
