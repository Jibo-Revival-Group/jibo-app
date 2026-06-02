package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.util.ArraySet;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzcxd;
import com.google.android.gms.tasks.Task;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class zzbm implements Handler.Callback {

    /* JADX INFO: renamed from: a */
    public static final Status f6284a = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* JADX INFO: renamed from: b */
    private static final Status f6285b = new Status(4, "The user must be signed in to make this API call.");

    /* JADX INFO: renamed from: f */
    private static final Object f6286f = new Object();

    /* JADX INFO: renamed from: g */
    private static zzbm f6287g;

    /* JADX INFO: renamed from: h */
    private final Context f6291h;

    /* JADX INFO: renamed from: i */
    private final GoogleApiAvailability f6292i;

    /* JADX INFO: renamed from: q */
    private final Handler f6300q;

    /* JADX INFO: renamed from: c */
    private long f6288c = 5000;

    /* JADX INFO: renamed from: d */
    private long f6289d = 120000;

    /* JADX INFO: renamed from: e */
    private long f6290e = 10000;

    /* JADX INFO: renamed from: j */
    private int f6293j = -1;

    /* JADX INFO: renamed from: k */
    private final AtomicInteger f6294k = new AtomicInteger(1);

    /* JADX INFO: renamed from: l */
    private final AtomicInteger f6295l = new AtomicInteger(0);

    /* JADX INFO: renamed from: m */
    private final Map<zzh<?>, zzbo<?>> f6296m = new ConcurrentHashMap(5, 0.75f, 1);

    /* JADX INFO: renamed from: n */
    private zzah f6297n = null;

    /* JADX INFO: renamed from: o */
    private final Set<zzh<?>> f6298o = new ArraySet();

    /* JADX INFO: renamed from: p */
    private final Set<zzh<?>> f6299p = new ArraySet();

    private zzbm(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.f6291h = context;
        this.f6300q = new Handler(looper, this);
        this.f6292i = googleApiAvailability;
        this.f6300q.sendMessage(this.f6300q.obtainMessage(6));
    }

    /* JADX INFO: renamed from: a */
    public static zzbm m7091a() {
        zzbm zzbmVar;
        synchronized (f6286f) {
            com.google.android.gms.common.internal.zzbq.m7374a(f6287g, "Must guarantee manager is non-null before using getInstance");
            zzbmVar = f6287g;
        }
        return zzbmVar;
    }

    /* JADX INFO: renamed from: a */
    public static zzbm m7092a(Context context) {
        zzbm zzbmVar;
        synchronized (f6286f) {
            if (f6287g == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                f6287g = new zzbm(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.m6828a());
            }
            zzbmVar = f6287g;
        }
        return zzbmVar;
    }

    /* JADX INFO: renamed from: b */
    public static void m7094b() {
        synchronized (f6286f) {
            if (f6287g != null) {
                zzbm zzbmVar = f6287g;
                zzbmVar.f6295l.incrementAndGet();
                zzbmVar.f6300q.sendMessageAtFrontOfQueue(zzbmVar.f6300q.obtainMessage(10));
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m7095b(GoogleApi<?> googleApi) {
        Object objM6877b = googleApi.m6877b();
        zzbo<?> zzboVar = this.f6296m.get(objM6877b);
        if (zzboVar == null) {
            zzboVar = new zzbo<>(this, googleApi);
            this.f6296m.put((zzh<?>) objM6877b, zzboVar);
        }
        if (zzboVar.m7142k()) {
            this.f6299p.add((zzh<?>) objM6877b);
        }
        zzboVar.m7140i();
    }

    /* JADX INFO: renamed from: h */
    private final void m7104h() {
        Iterator<zzh<?>> it = this.f6299p.iterator();
        while (it.hasNext()) {
            this.f6296m.remove(it.next()).m7128a();
        }
        this.f6299p.clear();
    }

    /* JADX INFO: renamed from: a */
    final PendingIntent m7107a(zzh<?> zzhVar, int i) {
        zzcxd zzcxdVarM7144m;
        zzbo<?> zzboVar = this.f6296m.get(zzhVar);
        if (zzboVar != null && (zzcxdVarM7144m = zzboVar.m7144m()) != null) {
            return PendingIntent.getActivity(this.f6291h, i, zzcxdVarM7144m.mo6772d(), 134217728);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public final Task<Map<zzh<?>, String>> m7108a(Iterable<? extends GoogleApi<?>> iterable) {
        zzj zzjVar = new zzj(iterable);
        for (GoogleApi<?> googleApi : iterable) {
            zzbo<?> zzboVar = this.f6296m.get(googleApi.m6877b());
            if (zzboVar == null || !zzboVar.m7141j()) {
                this.f6300q.sendMessage(this.f6300q.obtainMessage(2, zzjVar));
                return zzjVar.m7217b();
            }
            zzjVar.m7216a(googleApi.m6877b(), ConnectionResult.f6064a, zzboVar.m7132b().m6867l());
        }
        return zzjVar.m7217b();
    }

    /* JADX INFO: renamed from: a */
    public final void m7109a(GoogleApi<?> googleApi) {
        this.f6300q.sendMessage(this.f6300q.obtainMessage(7, googleApi));
    }

    /* JADX INFO: renamed from: a */
    public final <O extends Api.ApiOptions> void m7110a(GoogleApi<O> googleApi, int i, zzm<? extends Result, Api.zzb> zzmVar) {
        this.f6300q.sendMessage(this.f6300q.obtainMessage(4, new zzcp(new zzc(i, zzmVar), this.f6295l.get(), googleApi)));
    }

    /* JADX INFO: renamed from: a */
    public final void m7111a(zzah zzahVar) {
        synchronized (f6286f) {
            if (this.f6297n != zzahVar) {
                this.f6297n = zzahVar;
                this.f6298o.clear();
                this.f6298o.addAll(zzahVar.m7012g());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    final boolean m7112a(ConnectionResult connectionResult, int i) {
        return this.f6292i.m6842a(this.f6291h, connectionResult, i);
    }

    /* JADX INFO: renamed from: b */
    public final void m7113b(ConnectionResult connectionResult, int i) {
        if (m7112a(connectionResult, i)) {
            return;
        }
        this.f6300q.sendMessage(this.f6300q.obtainMessage(5, i, 0, connectionResult));
    }

    /* JADX INFO: renamed from: b */
    final void m7114b(zzah zzahVar) {
        synchronized (f6286f) {
            if (this.f6297n == zzahVar) {
                this.f6297n = null;
                this.f6298o.clear();
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final int m7115c() {
        return this.f6294k.getAndIncrement();
    }

    /* JADX INFO: renamed from: d */
    public final void m7116d() {
        this.f6300q.sendMessage(this.f6300q.obtainMessage(3));
    }

    /* JADX INFO: renamed from: e */
    final void m7117e() {
        this.f6295l.incrementAndGet();
        this.f6300q.sendMessage(this.f6300q.obtainMessage(10));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        zzbo<?> next;
        switch (message.what) {
            case 1:
                this.f6290e = ((Boolean) message.obj).booleanValue() ? 10000L : 300000L;
                this.f6300q.removeMessages(12);
                Iterator<zzh<?>> it = this.f6296m.keySet().iterator();
                while (it.hasNext()) {
                    this.f6300q.sendMessageDelayed(this.f6300q.obtainMessage(12, it.next()), this.f6290e);
                }
                break;
            case 2:
                zzj zzjVar = (zzj) message.obj;
                Iterator<zzh<?>> it2 = zzjVar.m7215a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    } else {
                        zzh<?> next2 = it2.next();
                        zzbo<?> zzboVar = this.f6296m.get(next2);
                        if (zzboVar == null) {
                            zzjVar.m7216a(next2, new ConnectionResult(13), null);
                            break;
                        } else if (zzboVar.m7141j()) {
                            zzjVar.m7216a(next2, ConnectionResult.f6064a, zzboVar.m7132b().m6867l());
                        } else if (zzboVar.m7136e() != null) {
                            zzjVar.m7216a(next2, zzboVar.m7136e(), null);
                        } else {
                            zzboVar.m7131a(zzjVar);
                        }
                    }
                }
                break;
            case 3:
                for (zzbo<?> zzboVar2 : this.f6296m.values()) {
                    zzboVar2.m7135d();
                    zzboVar2.m7140i();
                }
                break;
            case 4:
            case 8:
            case 13:
                zzcp zzcpVar = (zzcp) message.obj;
                zzbo<?> zzboVar3 = this.f6296m.get(zzcpVar.f6354c.m6877b());
                if (zzboVar3 == null) {
                    m7095b(zzcpVar.f6354c);
                    zzboVar3 = this.f6296m.get(zzcpVar.f6354c.m6877b());
                }
                if (!zzboVar3.m7142k() || this.f6295l.get() == zzcpVar.f6353b) {
                    zzboVar3.m7130a(zzcpVar.f6352a);
                } else {
                    zzcpVar.f6352a.mo6961a(f6284a);
                    zzboVar3.m7128a();
                }
                break;
            case 5:
                int i = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<zzbo<?>> it3 = this.f6296m.values().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        next = it3.next();
                        if (next.m7143l() == i) {
                        }
                    } else {
                        next = null;
                    }
                }
                if (next != null) {
                    String strMo6843b = this.f6292i.mo6843b(connectionResult.m6822c());
                    String strM6824e = connectionResult.m6824e();
                    next.m7129a(new Status(17, new StringBuilder(String.valueOf(strMo6843b).length() + 69 + String.valueOf(strM6824e).length()).append("Error resolution was canceled by the user, original error message: ").append(strMo6843b).append(": ").append(strM6824e).toString()));
                } else {
                    Log.wtf("GoogleApiManager", new StringBuilder(76).append("Could not find API instance ").append(i).append(" while trying to fail enqueued calls.").toString(), new Exception());
                }
                break;
            case 6:
                if (this.f6291h.getApplicationContext() instanceof Application) {
                    zzk.m7219a((Application) this.f6291h.getApplicationContext());
                    zzk.m7218a().m7221a(new zzbn(this));
                    if (!zzk.m7218a().m7222a(true)) {
                        this.f6290e = 300000L;
                    }
                }
                break;
            case 7:
                m7095b((GoogleApi<?>) message.obj);
                break;
            case 9:
                if (this.f6296m.containsKey(message.obj)) {
                    this.f6296m.get(message.obj).m7137f();
                }
                break;
            case 10:
                m7104h();
                break;
            case 11:
                if (this.f6296m.containsKey(message.obj)) {
                    this.f6296m.get(message.obj).m7138g();
                }
                break;
            case 12:
                if (this.f6296m.containsKey(message.obj)) {
                    this.f6296m.get(message.obj).m7139h();
                }
                break;
            default:
                Log.w("GoogleApiManager", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                return false;
        }
        return true;
    }
}
