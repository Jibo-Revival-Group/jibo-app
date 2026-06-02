package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.util.zzh;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.perf.FirebasePerformance;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class zzevz {

    /* JADX INFO: renamed from: a */
    private static volatile zzevz f7848a;

    /* JADX INFO: renamed from: b */
    private final ThreadPoolExecutor f7849b;

    /* JADX INFO: renamed from: c */
    private FirebaseApp f7850c;

    /* JADX INFO: renamed from: d */
    private FirebasePerformance f7851d;

    /* JADX INFO: renamed from: e */
    private Context f7852e;

    /* JADX INFO: renamed from: f */
    private zzbdy f7853f;

    /* JADX INFO: renamed from: g */
    private String f7854g;

    /* JADX INFO: renamed from: h */
    private zzews f7855h;

    /* JADX INFO: renamed from: i */
    private zzewh f7856i;

    /* JADX INFO: renamed from: j */
    private zzevw f7857j;

    /* JADX INFO: renamed from: k */
    private boolean f7858k;

    private zzevz(ThreadPoolExecutor threadPoolExecutor) {
        this.f7849b = threadPoolExecutor;
        this.f7849b.execute(new zzewa(this));
    }

    /* JADX INFO: renamed from: a */
    public static zzevz m8561a() {
        if (f7848a == null) {
            synchronized (zzevz.class) {
                if (f7848a == null) {
                    try {
                        FirebaseApp.m9080d();
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                        f7848a = new zzevz(threadPoolExecutor);
                    } catch (IllegalStateException e) {
                        return null;
                    }
                }
            }
        }
        return f7848a;
    }

    /* JADX INFO: renamed from: a */
    private static String m8562a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m8566a(zzewx zzewxVar) {
        boolean z;
        if (this.f7853f == null) {
            return;
        }
        if (this.f7855h.f7895b == null) {
            this.f7855h.f7895b = FirebaseInstanceId.m9094a().m9107c();
        }
        if (this.f7855h.f7895b == null) {
            Log.w("FirebasePerformance", "App Instance ID is null, dropping the log.");
            return;
        }
        if (this.f7851d.m9244b()) {
            ArrayList arrayList = new ArrayList();
            if (zzewxVar.f7923b != null) {
                arrayList.add(new zzewf(zzewxVar.f7923b));
            }
            if (zzewxVar.f7924c != null) {
                arrayList.add(new zzewe(zzewxVar.f7924c));
            }
            if (zzewxVar.f7922a != null) {
                arrayList.add(new zzevy(zzewxVar.f7922a));
            }
            if (!arrayList.isEmpty()) {
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        z = true;
                        break;
                    }
                    Object obj = arrayList2.get(i);
                    i++;
                    if (!((zzewg) obj).mo8560a()) {
                        z = false;
                        break;
                    }
                }
            } else {
                Log.d("FirebasePerformance", "No validators found for PerfMetric.");
                z = false;
            }
            if (!z) {
                Log.i("FirebasePerformance", "Unable to process an HTTP request/response due to missing or invalid values. See earlier log statements for additional information on the specific invalid/missing values.");
                return;
            }
            if (this.f7856i.m8596a(zzewxVar)) {
                this.f7853f.m7667a(zzfjs.m8711a(zzewxVar)).m7668a();
            } else if (zzewxVar.f7924c != null) {
                this.f7857j.m8551a(zzewl.NETWORK_TRACE_EVENT_RATE_LIMITED.toString(), 1L);
            } else if (zzewxVar.f7923b != null) {
                this.f7857j.m8551a(zzewl.TRACE_EVENT_RATE_LIMITED.toString(), 1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final void m8567b() {
        this.f7850c = FirebaseApp.m9080d();
        this.f7851d = FirebasePerformance.m9240a();
        this.f7852e = this.f7850c.m9084a();
        this.f7854g = this.f7850c.m9086c().m9092a();
        this.f7855h = new zzews();
        this.f7855h.f7894a = this.f7854g;
        this.f7855h.f7895b = FirebaseInstanceId.m9094a().m9107c();
        this.f7855h.f7896c = new zzewr();
        this.f7855h.f7896c.f7891a = this.f7852e.getPackageName();
        this.f7855h.f7896c.f7892b = "1.0.0.178131943";
        this.f7855h.f7896c.f7893c = m8562a(this.f7852e);
        try {
            Context context = this.f7852e;
            this.f7853f = new zzbdy(context, -1, "FIREPERF", null, null, true, zzbej.m7672a(context), zzh.m7501d(), null, new zzbeu(context));
        } catch (SecurityException e) {
            Log.i("FirebasePerformance", "Caught SecurityException while init ClearcutLogger.");
            this.f7853f = null;
        }
        this.f7856i = new zzewh(this.f7852e, this.f7854g, 100L, 500L);
        this.f7857j = zzevw.m8544a();
        this.f7858k = zzewq.m8607a(this.f7852e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final void m8568b(zzewv zzewvVar, int i) {
        if (this.f7851d.m9244b()) {
            if (this.f7858k) {
                Log.i("FirebasePerformance", String.format("Logging NetworkRequestMetric - %s %db %dms,", zzewvVar.f7907a, Long.valueOf(zzewvVar.f7910d != null ? zzewvVar.f7910d.longValue() : 0L), Long.valueOf((zzewvVar.f7917k == null ? 0L : zzewvVar.f7917k.longValue()) / 1000)));
            }
            zzewx zzewxVar = new zzewx();
            zzewxVar.f7922a = this.f7855h;
            zzewxVar.f7922a.f7897d = Integer.valueOf(i);
            zzewxVar.f7924c = zzewvVar;
            m8566a(zzewxVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final void m8569b(zzewy zzewyVar, int i) {
        int i2 = 0;
        if (this.f7851d.m9244b()) {
            if (this.f7858k) {
                Log.i("FirebasePerformance", String.format("Logging TraceMetric - %s %dms", zzewyVar.f7926a, Long.valueOf((zzewyVar.f7928c == null ? 0L : zzewyVar.f7928c.longValue()) / 1000)));
            }
            zzewx zzewxVar = new zzewx();
            zzewxVar.f7922a = this.f7855h;
            zzewxVar.f7922a.f7897d = Integer.valueOf(i);
            zzewxVar.f7923b = zzewyVar;
            Map<String, String> mapM9245c = FirebasePerformance.m9240a().m9245c();
            if (!mapM9245c.isEmpty()) {
                zzewxVar.f7922a.f7898e = new zzewt[mapM9245c.size()];
                for (String str : mapM9245c.keySet()) {
                    String str2 = mapM9245c.get(str);
                    zzewt zzewtVar = new zzewt();
                    zzewtVar.f7901a = str;
                    zzewtVar.f7902b = str2;
                    zzewxVar.f7922a.f7898e[i2] = zzewtVar;
                    i2++;
                }
            }
            m8566a(zzewxVar);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8570a(zzewv zzewvVar, int i) {
        try {
            byte[] bArrM8711a = zzfjs.m8711a(zzewvVar);
            zzewv zzewvVar2 = new zzewv();
            zzfjs.m8709a(zzewvVar2, bArrM8711a);
            this.f7849b.execute(new zzewc(this, zzewvVar2, i));
        } catch (zzfjr e) {
            Log.w("FirebasePerformance", "Clone NetworkRequestMetric throws exception", e);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8571a(zzewy zzewyVar, int i) {
        try {
            byte[] bArrM8711a = zzfjs.m8711a(zzewyVar);
            zzewy zzewyVar2 = new zzewy();
            zzfjs.m8709a(zzewyVar2, bArrM8711a);
            this.f7849b.execute(new zzewb(this, zzewyVar2, i));
        } catch (zzfjr e) {
            String strValueOf = String.valueOf(e);
            Log.w("FirebasePerformance", new StringBuilder(String.valueOf(strValueOf).length() + 35).append("Clone TraceMetric throws exception ").append(strValueOf).toString());
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8572a(boolean z) {
        this.f7849b.execute(new zzewd(this, z));
    }

    /* JADX INFO: renamed from: b */
    public final void m8573b(boolean z) {
        this.f7856i.m8595a(z);
    }
}
