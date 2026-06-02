package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzan;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzr;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class Api<O extends ApiOptions> {

    /* JADX INFO: renamed from: a */
    private final zza<?, O> f6086a;

    /* JADX INFO: renamed from: b */
    private final zzh<?, O> f6087b;

    /* JADX INFO: renamed from: c */
    private final zzf<?> f6088c;

    /* JADX INFO: renamed from: d */
    private final zzi<?> f6089d;

    /* JADX INFO: renamed from: e */
    private final String f6090e;

    public interface ApiOptions {

        public interface HasAccountOptions extends HasOptions, NotRequiredOptions {
            /* JADX INFO: renamed from: a */
            Account m6854a();
        }

        public interface HasGoogleSignInAccountOptions extends HasOptions {
            /* JADX INFO: renamed from: a */
            GoogleSignInAccount m6855a();
        }

        public interface HasOptions extends ApiOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public static abstract class zza<T extends zze, O> extends zzd<T, O> {
        /* JADX INFO: renamed from: a */
        public abstract T mo6804a(Context context, Looper looper, zzr zzrVar, O o, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener);
    }

    public interface zzb {
    }

    public static class zzc<C extends zzb> {
    }

    public static abstract class zzd<T extends zzb, O> {
        /* JADX INFO: renamed from: a */
        public int m6856a() {
            return Integer.MAX_VALUE;
        }

        /* JADX INFO: renamed from: a */
        public List<Scope> mo6805a(O o) {
            return Collections.emptyList();
        }
    }

    public interface zze extends zzb {
        /* JADX INFO: renamed from: a */
        void m6857a(zzan zzanVar, Set<Scope> set);

        /* JADX INFO: renamed from: a */
        void m6858a(zzj zzjVar);

        /* JADX INFO: renamed from: a */
        void m6859a(zzp zzpVar);

        /* JADX INFO: renamed from: a */
        void m6860a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        /* JADX INFO: renamed from: c */
        boolean mo6771c();

        /* JADX INFO: renamed from: d */
        Intent mo6772d();

        /* JADX INFO: renamed from: f */
        void mo6861f();

        /* JADX INFO: renamed from: g */
        boolean m6862g();

        /* JADX INFO: renamed from: h */
        boolean m6863h();

        /* JADX INFO: renamed from: i */
        boolean mo6864i();

        /* JADX INFO: renamed from: j */
        boolean m6865j();

        /* JADX INFO: renamed from: k */
        IBinder m6866k();

        /* JADX INFO: renamed from: l */
        String m6867l();
    }

    public static final class zzf<C extends zze> extends zzc<C> {
    }

    public interface zzg<T extends IInterface> extends zzb {
    }

    public static abstract class zzh<T extends zzg, O> extends zzd<T, O> {
    }

    public static final class zzi<C extends zzg> extends zzc<C> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends zze> Api(String str, zza<C, O> zzaVar, zzf<C> zzfVar) {
        zzbq.m7374a(zzaVar, "Cannot construct an Api with a null ClientBuilder");
        zzbq.m7374a(zzfVar, "Cannot construct an Api with a null ClientKey");
        this.f6090e = str;
        this.f6086a = zzaVar;
        this.f6087b = null;
        this.f6088c = zzfVar;
        this.f6089d = null;
    }

    /* JADX INFO: renamed from: a */
    public final zzd<?, O> m6850a() {
        return this.f6086a;
    }

    /* JADX INFO: renamed from: b */
    public final zza<?, O> m6851b() {
        zzbq.m7379a(this.f6086a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f6086a;
    }

    /* JADX INFO: renamed from: c */
    public final zzc<?> m6852c() {
        if (this.f6088c != null) {
            return this.f6088c;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }

    /* JADX INFO: renamed from: d */
    public final String m6853d() {
        return this.f6090e;
    }
}
