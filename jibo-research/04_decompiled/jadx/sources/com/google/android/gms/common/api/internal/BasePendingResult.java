package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
@KeepName
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {

    /* JADX INFO: renamed from: a */
    static final ThreadLocal<Boolean> f6140a = new zzs();

    /* JADX INFO: renamed from: b */
    private final Object f6141b;

    /* JADX INFO: renamed from: c */
    private zza<R> f6142c;

    /* JADX INFO: renamed from: d */
    private WeakReference<GoogleApiClient> f6143d;

    /* JADX INFO: renamed from: e */
    private final CountDownLatch f6144e;

    /* JADX INFO: renamed from: f */
    private final ArrayList<PendingResult.zza> f6145f;

    /* JADX INFO: renamed from: g */
    private ResultCallback<? super R> f6146g;

    /* JADX INFO: renamed from: h */
    private final AtomicReference<zzdm> f6147h;

    /* JADX INFO: renamed from: i */
    private R f6148i;

    /* JADX INFO: renamed from: j */
    private Status f6149j;

    /* JADX INFO: renamed from: k */
    private volatile boolean f6150k;

    /* JADX INFO: renamed from: l */
    private boolean f6151l;

    /* JADX INFO: renamed from: m */
    private boolean f6152m;

    @KeepName
    private zzb mResultGuardian;

    /* JADX INFO: renamed from: n */
    private com.google.android.gms.common.internal.zzaq f6153n;

    /* JADX INFO: renamed from: o */
    private volatile zzdg<R> f6154o;

    /* JADX INFO: renamed from: p */
    private boolean f6155p;

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        /* JADX INFO: renamed from: a */
        public final void m6948a(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    ResultCallback resultCallback = (ResultCallback) pair.first;
                    Result result = (Result) pair.second;
                    try {
                        resultCallback.mo6928a(result);
                        return;
                    } catch (RuntimeException e) {
                        BasePendingResult.m6939b(result);
                        throw e;
                    }
                case 2:
                    ((BasePendingResult) message.obj).m6944b(Status.f6132d);
                    return;
                default:
                    Log.wtf("BasePendingResult", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
                    return;
            }
        }
    }

    final class zzb {
        private zzb() {
        }

        /* synthetic */ zzb(BasePendingResult basePendingResult, zzs zzsVar) {
            this();
        }

        protected final void finalize() throws Throwable {
            BasePendingResult.m6939b(BasePendingResult.this.f6148i);
            super.finalize();
        }
    }

    @Deprecated
    BasePendingResult() {
        this.f6141b = new Object();
        this.f6144e = new CountDownLatch(1);
        this.f6145f = new ArrayList<>();
        this.f6147h = new AtomicReference<>();
        this.f6155p = false;
        this.f6142c = new zza<>(Looper.getMainLooper());
        this.f6143d = new WeakReference<>(null);
    }

    @Deprecated
    protected BasePendingResult(Looper looper) {
        this.f6141b = new Object();
        this.f6144e = new CountDownLatch(1);
        this.f6145f = new ArrayList<>();
        this.f6147h = new AtomicReference<>();
        this.f6155p = false;
        this.f6142c = new zza<>(looper);
        this.f6143d = new WeakReference<>(null);
    }

    protected BasePendingResult(GoogleApiClient googleApiClient) {
        this.f6141b = new Object();
        this.f6144e = new CountDownLatch(1);
        this.f6145f = new ArrayList<>();
        this.f6147h = new AtomicReference<>();
        this.f6155p = false;
        this.f6142c = new zza<>(googleApiClient != null ? googleApiClient.mo6899c() : Looper.getMainLooper());
        this.f6143d = new WeakReference<>(googleApiClient);
    }

    /* JADX INFO: renamed from: b */
    public static void m6939b(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).mo6926c_();
            } catch (RuntimeException e) {
                String strValueOf = String.valueOf(result);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(strValueOf).length() + 18).append("Unable to release ").append(strValueOf).toString(), e);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private final void m6940c(R r) {
        zzs zzsVar = null;
        this.f6148i = r;
        this.f6153n = null;
        this.f6144e.countDown();
        this.f6149j = this.f6148i.mo6927a();
        if (this.f6151l) {
            this.f6146g = null;
        } else if (this.f6146g != null) {
            this.f6142c.removeMessages(2);
            this.f6142c.m6948a(this.f6146g, m6941g());
        } else if (this.f6148i instanceof Releasable) {
            this.mResultGuardian = new zzb(this, zzsVar);
        }
        ArrayList<PendingResult.zza> arrayList = this.f6145f;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            PendingResult.zza zzaVar = arrayList.get(i);
            i++;
            zzaVar.mo6923a(this.f6149j);
        }
        this.f6145f.clear();
    }

    /* JADX INFO: renamed from: g */
    private final R m6941g() {
        R r;
        synchronized (this.f6141b) {
            com.google.android.gms.common.internal.zzbq.m7379a(this.f6150k ? false : true, "Result has already been consumed.");
            com.google.android.gms.common.internal.zzbq.m7379a(m6945d(), "Result is not ready.");
            r = this.f6148i;
            this.f6148i = null;
            this.f6146g = null;
            this.f6150k = true;
        }
        zzdm andSet = this.f6147h.getAndSet(null);
        if (andSet != null) {
            andSet.mo7205a(this);
        }
        return r;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    /* JADX INFO: renamed from: a */
    public final R mo6917a(long j, TimeUnit timeUnit) {
        if (j > 0) {
            com.google.android.gms.common.internal.zzbq.m7385c("await must not be called on the UI thread when time is greater than zero.");
        }
        com.google.android.gms.common.internal.zzbq.m7379a(!this.f6150k, "Result has already been consumed.");
        com.google.android.gms.common.internal.zzbq.m7379a(this.f6154o == null, "Cannot await if then() has been called.");
        try {
            if (!this.f6144e.await(j, timeUnit)) {
                m6944b(Status.f6132d);
            }
        } catch (InterruptedException e) {
            m6944b(Status.f6130b);
        }
        com.google.android.gms.common.internal.zzbq.m7379a(m6945d(), "Result is not ready.");
        return (R) m6941g();
    }

    /* JADX INFO: renamed from: a */
    protected abstract R mo6777a(Status status);

    @Override // com.google.android.gms.common.api.PendingResult
    /* JADX INFO: renamed from: a */
    public void mo6918a() {
        synchronized (this.f6141b) {
            if (this.f6151l || this.f6150k) {
                return;
            }
            if (this.f6153n != null) {
                try {
                    this.f6153n.m7357a();
                } catch (RemoteException e) {
                }
            }
            m6939b(this.f6148i);
            this.f6151l = true;
            m6940c(mo6777a(Status.f6133e));
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    /* JADX INFO: renamed from: a */
    public final void mo6919a(PendingResult.zza zzaVar) {
        com.google.android.gms.common.internal.zzbq.m7383b(zzaVar != null, "Callback cannot be null.");
        synchronized (this.f6141b) {
            if (m6945d()) {
                zzaVar.mo6923a(this.f6149j);
            } else {
                this.f6145f.add(zzaVar);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m6942a(R r) {
        synchronized (this.f6141b) {
            if (this.f6152m || this.f6151l) {
                m6939b(r);
                return;
            }
            if (m6945d()) {
            }
            com.google.android.gms.common.internal.zzbq.m7379a(!m6945d(), "Results have already been set");
            com.google.android.gms.common.internal.zzbq.m7379a(this.f6150k ? false : true, "Result has already been consumed");
            m6940c(r);
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    /* JADX INFO: renamed from: a */
    public final void mo6920a(ResultCallback<? super R> resultCallback) {
        synchronized (this.f6141b) {
            if (resultCallback == null) {
                this.f6146g = null;
                return;
            }
            com.google.android.gms.common.internal.zzbq.m7379a(!this.f6150k, "Result has already been consumed.");
            com.google.android.gms.common.internal.zzbq.m7379a(this.f6154o == null, "Cannot set callbacks if then() has been called.");
            if (mo6921b()) {
                return;
            }
            if (m6945d()) {
                this.f6142c.m6948a(resultCallback, m6941g());
            } else {
                this.f6146g = resultCallback;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m6943a(zzdm zzdmVar) {
        this.f6147h.set(zzdmVar);
    }

    /* JADX INFO: renamed from: b */
    public final void m6944b(Status status) {
        synchronized (this.f6141b) {
            if (!m6945d()) {
                m6942a(mo6777a(status));
                this.f6152m = true;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    /* JADX INFO: renamed from: b */
    public boolean mo6921b() {
        boolean z;
        synchronized (this.f6141b) {
            z = this.f6151l;
        }
        return z;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    /* JADX INFO: renamed from: c */
    public final Integer mo6922c() {
        return null;
    }

    /* JADX INFO: renamed from: d */
    public final boolean m6945d() {
        return this.f6144e.getCount() == 0;
    }

    /* JADX INFO: renamed from: e */
    public final boolean m6946e() {
        boolean zMo6921b;
        synchronized (this.f6141b) {
            if (this.f6143d.get() == null || !this.f6155p) {
                mo6918a();
            }
            zMo6921b = mo6921b();
        }
        return zMo6921b;
    }

    /* JADX INFO: renamed from: f */
    public final void m6947f() {
        this.f6155p = this.f6155p || f6140a.get().booleanValue();
    }
}
