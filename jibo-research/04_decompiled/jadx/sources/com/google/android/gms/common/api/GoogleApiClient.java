package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.zzba;
import com.google.android.gms.common.api.internal.zzce;
import com.google.android.gms.common.api.internal.zzcu;
import com.google.android.gms.common.api.internal.zzdg;
import com.google.android.gms.common.api.internal.zzi;
import com.google.android.gms.common.api.internal.zzm;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.internal.zzcxa;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.internal.zzcxe;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public abstract class GoogleApiClient {

    /* JADX INFO: renamed from: a */
    private static final Set<GoogleApiClient> f6106a = Collections.newSetFromMap(new WeakHashMap());

    public static final class Builder {

        /* JADX INFO: renamed from: a */
        private Account f6107a;

        /* JADX INFO: renamed from: d */
        private int f6110d;

        /* JADX INFO: renamed from: e */
        private View f6111e;

        /* JADX INFO: renamed from: f */
        private String f6112f;

        /* JADX INFO: renamed from: g */
        private String f6113g;

        /* JADX INFO: renamed from: i */
        private final Context f6115i;

        /* JADX INFO: renamed from: k */
        private zzce f6117k;

        /* JADX INFO: renamed from: m */
        private OnConnectionFailedListener f6119m;

        /* JADX INFO: renamed from: n */
        private Looper f6120n;

        /* JADX INFO: renamed from: b */
        private final Set<Scope> f6108b = new HashSet();

        /* JADX INFO: renamed from: c */
        private final Set<Scope> f6109c = new HashSet();

        /* JADX INFO: renamed from: h */
        private final Map<Api<?>, zzt> f6114h = new ArrayMap();

        /* JADX INFO: renamed from: j */
        private final Map<Api<?>, Api.ApiOptions> f6116j = new ArrayMap();

        /* JADX INFO: renamed from: l */
        private int f6118l = -1;

        /* JADX INFO: renamed from: o */
        private GoogleApiAvailability f6121o = GoogleApiAvailability.m6828a();

        /* JADX INFO: renamed from: p */
        private Api.zza<? extends zzcxd, zzcxe> f6122p = zzcxa.f7767a;

        /* JADX INFO: renamed from: q */
        private final ArrayList<ConnectionCallbacks> f6123q = new ArrayList<>();

        /* JADX INFO: renamed from: r */
        private final ArrayList<OnConnectionFailedListener> f6124r = new ArrayList<>();

        /* JADX INFO: renamed from: s */
        private boolean f6125s = false;

        public Builder(Context context) {
            this.f6115i = context;
            this.f6120n = context.getMainLooper();
            this.f6112f = context.getPackageName();
            this.f6113g = context.getClass().getName();
        }

        /* JADX INFO: renamed from: a */
        public final Builder m6907a(Handler handler) {
            zzbq.m7374a(handler, "Handler must not be null");
            this.f6120n = handler.getLooper();
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final Builder m6908a(Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            zzbq.m7374a(api, "Api must not be null");
            this.f6116j.put(api, null);
            List<Scope> listMo6805a = api.m6850a().mo6805a(null);
            this.f6109c.addAll(listMo6805a);
            this.f6108b.addAll(listMo6805a);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final <O extends Api.ApiOptions.HasOptions> Builder m6909a(Api<O> api, O o) {
            zzbq.m7374a(api, "Api must not be null");
            zzbq.m7374a(o, "Null options are not permitted for this Api");
            this.f6116j.put(api, o);
            List<Scope> listMo6805a = api.m6850a().mo6805a(o);
            this.f6109c.addAll(listMo6805a);
            this.f6108b.addAll(listMo6805a);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final Builder m6910a(ConnectionCallbacks connectionCallbacks) {
            zzbq.m7374a(connectionCallbacks, "Listener must not be null");
            this.f6123q.add(connectionCallbacks);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final Builder m6911a(OnConnectionFailedListener onConnectionFailedListener) {
            zzbq.m7374a(onConnectionFailedListener, "Listener must not be null");
            this.f6124r.add(onConnectionFailedListener);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public final zzr m6912a() {
            zzcxe zzcxeVar = zzcxe.f7775a;
            if (this.f6116j.containsKey(zzcxa.f7768b)) {
                zzcxeVar = (zzcxe) this.f6116j.get(zzcxa.f7768b);
            }
            return new zzr(this.f6107a, this.f6108b, this.f6114h, this.f6110d, this.f6111e, this.f6112f, this.f6113g, zzcxeVar);
        }

        /* JADX INFO: renamed from: b */
        public final GoogleApiClient m6913b() {
            zzbq.m7383b(!this.f6116j.isEmpty(), "must call addApi() to add at least one API");
            zzr zzrVarM6912a = m6912a();
            Api<?> api = null;
            Map<Api<?>, zzt> mapM7456f = zzrVarM6912a.m7456f();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (Api<?> api2 : this.f6116j.keySet()) {
                Api.ApiOptions apiOptions = this.f6116j.get(api2);
                boolean z2 = mapM7456f.get(api2) != null;
                arrayMap.put(api2, Boolean.valueOf(z2));
                com.google.android.gms.common.api.internal.zzt zztVar = new com.google.android.gms.common.api.internal.zzt(api2, z2);
                arrayList.add(zztVar);
                Api.zza<?, O> zzaVarM6851b = api2.m6851b();
                Api.zze zzeVarMo6804a = zzaVarM6851b.mo6804a(this.f6115i, this.f6120n, zzrVarM6912a, apiOptions, zztVar, zztVar);
                arrayMap2.put(api2.m6852c(), zzeVarMo6804a);
                boolean z3 = zzaVarM6851b.m6856a() == 1 ? apiOptions != null : z;
                if (!zzeVarMo6804a.mo6771c()) {
                    api2 = api;
                } else if (api != null) {
                    String strM6853d = api2.m6853d();
                    String strM6853d2 = api.m6853d();
                    throw new IllegalStateException(new StringBuilder(String.valueOf(strM6853d).length() + 21 + String.valueOf(strM6853d2).length()).append(strM6853d).append(" cannot be used with ").append(strM6853d2).toString());
                }
                z = z3;
                api = api2;
            }
            if (api != null) {
                if (z) {
                    String strM6853d3 = api.m6853d();
                    throw new IllegalStateException(new StringBuilder(String.valueOf(strM6853d3).length() + 82).append("With using ").append(strM6853d3).append(", GamesOptions can only be specified within GoogleSignInOptions.Builder").toString());
                }
                zzbq.m7380a(this.f6107a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api.m6853d());
                zzbq.m7380a(this.f6108b.equals(this.f6109c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api.m6853d());
            }
            zzba zzbaVar = new zzba(this.f6115i, new ReentrantLock(), this.f6120n, zzrVarM6912a, this.f6121o, this.f6122p, arrayMap, this.f6123q, this.f6124r, arrayMap2, this.f6118l, zzba.m7058a((Iterable<Api.zze>) arrayMap2.values(), true), arrayList, false);
            synchronized (GoogleApiClient.f6106a) {
                GoogleApiClient.f6106a.add(zzbaVar);
            }
            if (this.f6118l >= 0) {
                zzi.m7212b(this.f6117k).m7214a(this.f6118l, zzbaVar, this.f6119m);
            }
            return zzbaVar;
        }
    }

    public interface ConnectionCallbacks {
        /* JADX INFO: renamed from: a */
        void mo6914a(int i);

        /* JADX INFO: renamed from: a */
        void mo6915a(Bundle bundle);
    }

    public interface OnConnectionFailedListener {
        /* JADX INFO: renamed from: a */
        void mo6916a(ConnectionResult connectionResult);
    }

    /* JADX INFO: renamed from: a */
    public static Set<GoogleApiClient> m6886a() {
        Set<GoogleApiClient> set;
        synchronized (f6106a) {
            set = f6106a;
        }
        return set;
    }

    /* JADX INFO: renamed from: a */
    public <C extends Api.zze> C mo6888a(Api.zzc<C> zzcVar) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: a */
    public <A extends Api.zzb, R extends Result, T extends zzm<R, A>> T mo6889a(T t) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: a */
    public void mo6890a(int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo6891a(OnConnectionFailedListener onConnectionFailedListener);

    /* JADX INFO: renamed from: a */
    public void mo6892a(zzdg zzdgVar) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo6893a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* JADX INFO: renamed from: a */
    public boolean mo6894a(zzcu zzcuVar) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: b */
    public Context mo6895b() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: b */
    public <A extends Api.zzb, T extends zzm<? extends Result, A>> T mo6896b(T t) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: b */
    public abstract void mo6897b(OnConnectionFailedListener onConnectionFailedListener);

    /* JADX INFO: renamed from: b */
    public void mo6898b(zzdg zzdgVar) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: c */
    public Looper mo6899c() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: d */
    public void mo6900d() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: e */
    public abstract void mo6901e();

    /* JADX INFO: renamed from: f */
    public abstract ConnectionResult mo6902f();

    /* JADX INFO: renamed from: g */
    public abstract void mo6903g();

    /* JADX INFO: renamed from: h */
    public abstract void mo6904h();

    /* JADX INFO: renamed from: i */
    public abstract PendingResult<Status> mo6905i();

    /* JADX INFO: renamed from: j */
    public abstract boolean mo6906j();
}
