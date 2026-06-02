package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.internal.zzbm;
import com.google.android.gms.common.api.internal.zzbo;
import com.google.android.gms.common.api.internal.zzbw;
import com.google.android.gms.common.api.internal.zzcv;
import com.google.android.gms.common.api.internal.zzcz;
import com.google.android.gms.common.api.internal.zzh;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzs;
import java.util.Collections;

/* JADX INFO: loaded from: classes.dex */
public class GoogleApi<O extends Api.ApiOptions> {

    /* JADX INFO: renamed from: a */
    protected final zzbm f6093a;

    /* JADX INFO: renamed from: b */
    private final Context f6094b;

    /* JADX INFO: renamed from: c */
    private final Api<O> f6095c;

    /* JADX INFO: renamed from: d */
    private final O f6096d;

    /* JADX INFO: renamed from: e */
    private final zzh<O> f6097e;

    /* JADX INFO: renamed from: f */
    private final Looper f6098f;

    /* JADX INFO: renamed from: g */
    private final int f6099g;

    /* JADX INFO: renamed from: h */
    private final GoogleApiClient f6100h;

    /* JADX INFO: renamed from: i */
    private final zzcz f6101i;

    public static class zza {

        /* JADX INFO: renamed from: a */
        public static final zza f6102a = new zzd().m7258a();

        /* JADX INFO: renamed from: b */
        public final zzcz f6103b;

        /* JADX INFO: renamed from: c */
        public final Looper f6104c;

        private zza(zzcz zzczVar, Account account, Looper looper) {
            this.f6103b = zzczVar;
            this.f6104c = looper;
        }
    }

    protected GoogleApi(Context context, Api<O> api, Looper looper) {
        zzbq.m7374a(context, "Null context is not permitted.");
        zzbq.m7374a(api, "Api must not be null.");
        zzbq.m7374a(looper, "Looper must not be null.");
        this.f6094b = context.getApplicationContext();
        this.f6095c = api;
        this.f6096d = null;
        this.f6098f = looper;
        this.f6097e = zzh.m7208a(api);
        this.f6100h = new zzbw(this);
        this.f6093a = zzbm.m7092a(this.f6094b);
        this.f6099g = this.f6093a.m7115c();
        this.f6101i = new com.google.android.gms.common.api.internal.zzg();
    }

    public GoogleApi(Context context, Api<O> api, O o, zza zzaVar) {
        zzbq.m7374a(context, "Null context is not permitted.");
        zzbq.m7374a(api, "Api must not be null.");
        zzbq.m7374a(zzaVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        this.f6094b = context.getApplicationContext();
        this.f6095c = api;
        this.f6096d = o;
        this.f6098f = zzaVar.f6104c;
        this.f6097e = zzh.m7209a(this.f6095c, this.f6096d);
        this.f6100h = new zzbw(this);
        this.f6093a = zzbm.m7092a(this.f6094b);
        this.f6099g = this.f6093a.m7115c();
        this.f6101i = zzaVar.f6103b;
        this.f6093a.m7109a((GoogleApi<?>) this);
    }

    @Deprecated
    public GoogleApi(Context context, Api<O> api, O o, zzcz zzczVar) {
        this(context, api, o, new zzd().m7259a(zzczVar).m7258a());
    }

    /* JADX INFO: renamed from: a */
    private final <A extends Api.zzb, T extends zzm<? extends Result, A>> T m6871a(int i, T t) {
        t.m6947f();
        this.f6093a.m7110a(this, i, t);
        return t;
    }

    /* JADX INFO: renamed from: g */
    private final zzs m6872g() {
        GoogleSignInAccount googleSignInAccountM6855a;
        GoogleSignInAccount googleSignInAccountM6855a2;
        return new zzs().m7462a((!(this.f6096d instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccountM6855a2 = ((Api.ApiOptions.HasGoogleSignInAccountOptions) this.f6096d).m6855a()) == null) ? this.f6096d instanceof Api.ApiOptions.HasAccountOptions ? ((Api.ApiOptions.HasAccountOptions) this.f6096d).m6854a() : null : googleSignInAccountM6855a2.m6729d()).m7464a((!(this.f6096d instanceof Api.ApiOptions.HasGoogleSignInAccountOptions) || (googleSignInAccountM6855a = ((Api.ApiOptions.HasGoogleSignInAccountOptions) this.f6096d).m6855a()) == null) ? Collections.emptySet() : googleSignInAccountM6855a.m6736k());
    }

    /* JADX INFO: renamed from: a */
    public Api.zze mo6873a(Looper looper, zzbo<O> zzboVar) {
        return this.f6095c.m6851b().mo6804a(this.f6094b, looper, m6872g().m7463a(this.f6094b.getPackageName()).m7465b(this.f6094b.getClass().getName()).m7461a(), this.f6096d, zzboVar, zzboVar);
    }

    /* JADX INFO: renamed from: a */
    public final Api<O> m6874a() {
        return this.f6095c;
    }

    /* JADX INFO: renamed from: a */
    public zzcv mo6875a(Context context, Handler handler) {
        return new zzcv(context, handler, m6872g().m7461a());
    }

    /* JADX INFO: renamed from: a */
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T m6876a(T t) {
        return (T) m6871a(0, t);
    }

    /* JADX INFO: renamed from: b */
    public final zzh<O> m6877b() {
        return this.f6097e;
    }

    /* JADX INFO: renamed from: b */
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T m6878b(T t) {
        return (T) m6871a(1, t);
    }

    /* JADX INFO: renamed from: c */
    public final int m6879c() {
        return this.f6099g;
    }

    /* JADX INFO: renamed from: c */
    public final <A extends Api.zzb, T extends zzm<? extends Result, A>> T m6880c(T t) {
        return (T) m6871a(2, t);
    }

    /* JADX INFO: renamed from: d */
    public final GoogleApiClient m6881d() {
        return this.f6100h;
    }

    /* JADX INFO: renamed from: e */
    public final Looper m6882e() {
        return this.f6098f;
    }

    /* JADX INFO: renamed from: f */
    public final Context m6883f() {
        return this.f6094b;
    }
}
