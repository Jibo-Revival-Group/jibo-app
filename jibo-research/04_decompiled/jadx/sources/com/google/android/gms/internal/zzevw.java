package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class zzevw implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a */
    private static volatile zzevw f7831a;

    /* JADX INFO: renamed from: d */
    private final zzewk f7834d;

    /* JADX INFO: renamed from: g */
    private zzewn f7837g;

    /* JADX INFO: renamed from: h */
    private zzewn f7838h;

    /* JADX INFO: renamed from: b */
    private boolean f7832b = false;

    /* JADX INFO: renamed from: e */
    private boolean f7835e = true;

    /* JADX INFO: renamed from: f */
    private final Set<Activity> f7836f = new HashSet();

    /* JADX INFO: renamed from: i */
    private final Map<String, Long> f7839i = new HashMap();

    /* JADX INFO: renamed from: j */
    private AtomicInteger f7840j = new AtomicInteger(0);

    /* JADX INFO: renamed from: k */
    private int f7841k = 2;

    /* JADX INFO: renamed from: l */
    private Set<WeakReference<zza>> f7842l = new HashSet();

    /* JADX INFO: renamed from: c */
    private zzevz f7833c = null;

    public interface zza {
        /* JADX INFO: renamed from: b */
        void mo8555b(int i);
    }

    private zzevw(zzevz zzevzVar, zzewk zzewkVar) {
        this.f7834d = zzewkVar;
    }

    /* JADX INFO: renamed from: a */
    public static zzevw m8544a() {
        return f7831a != null ? f7831a : m8545a((zzevz) null, new zzewk());
    }

    /* JADX INFO: renamed from: a */
    private static zzevw m8545a(zzevz zzevzVar, zzewk zzewkVar) {
        if (f7831a == null) {
            synchronized (zzevw.class) {
                if (f7831a == null) {
                    f7831a = new zzevw(null, zzewkVar);
                }
            }
        }
        return f7831a;
    }

    /* JADX INFO: renamed from: a */
    private final void m8546a(String str, zzewn zzewnVar, zzewn zzewnVar2) {
        if (this.f7833c == null) {
            this.f7833c = zzevz.m8561a();
        }
        zzewy zzewyVar = new zzewy();
        zzewyVar.f7926a = str;
        zzewyVar.f7927b = Long.valueOf(zzewnVar.m8601b());
        zzewyVar.f7928c = Long.valueOf(zzewnVar.m8599a(zzewnVar2));
        int andSet = this.f7840j.getAndSet(0);
        synchronized (this.f7839i) {
            if (!this.f7839i.isEmpty() || andSet != 0) {
                zzewyVar.f7929d = new zzewz[andSet != 0 ? this.f7839i.size() + 1 : this.f7839i.size()];
                int i = 0;
                for (String str2 : this.f7839i.keySet()) {
                    long jLongValue = this.f7839i.get(str2).longValue();
                    zzewz zzewzVar = new zzewz();
                    zzewzVar.f7934a = str2;
                    zzewzVar.f7935b = Long.valueOf(jLongValue);
                    zzewyVar.f7929d[i] = zzewzVar;
                    i++;
                }
                if (andSet != 0) {
                    zzewz zzewzVar2 = new zzewz();
                    zzewzVar2.f7934a = zzewl.TRACE_STARTED_NOT_STOPPED.toString();
                    zzewzVar2.f7935b = Long.valueOf(andSet);
                    zzewyVar.f7929d[i] = zzewzVar2;
                }
            }
            this.f7839i.clear();
        }
        if (this.f7833c != null) {
            this.f7833c.m8571a(zzewyVar, 3);
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m8547a(boolean z) {
        if (this.f7833c == null) {
            this.f7833c = zzevz.m8561a();
        }
        if (this.f7833c != null) {
            this.f7833c.m8572a(z);
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m8548b(int i) {
        this.f7841k = i;
        synchronized (this.f7842l) {
            Iterator<WeakReference<zza>> it = this.f7842l.iterator();
            while (it.hasNext()) {
                zza zzaVar = it.next().get();
                if (zzaVar != null) {
                    zzaVar.mo8555b(this.f7841k);
                } else {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8549a(int i) {
        this.f7840j.addAndGet(1);
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m8550a(Context context) {
        if (!this.f7832b) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
                this.f7832b = true;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8551a(String str, long j) {
        synchronized (this.f7839i) {
            Long l = this.f7839i.get(str);
            if (l == null) {
                this.f7839i.put(str, 1L);
            } else {
                this.f7839i.put(str, Long.valueOf(l.longValue() + 1));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m8552a(WeakReference<zza> weakReference) {
        synchronized (this.f7842l) {
            this.f7842l.add(weakReference);
        }
    }

    /* JADX INFO: renamed from: b */
    public final int m8553b() {
        return this.f7841k;
    }

    /* JADX INFO: renamed from: b */
    public final void m8554b(WeakReference<zza> weakReference) {
        synchronized (this.f7842l) {
            this.f7842l.remove(weakReference);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
        if (this.f7836f.isEmpty()) {
            this.f7838h = new zzewn();
            this.f7836f.add(activity);
            if (this.f7835e) {
                this.f7835e = false;
                m8548b(1);
                m8547a(true);
            } else {
                if (zzewq.m8607a(activity.getApplicationContext())) {
                    String strValueOf = String.valueOf(zzewm.BACKGROUND_TRACE_NAME);
                    Log.d("FirebasePerformance", new StringBuilder(String.valueOf(strValueOf).length() + 39).append("onActivityResumed ").append(strValueOf).append(":").append(this.f7837g.m8599a(this.f7838h)).toString());
                }
                m8548b(1);
                m8547a(true);
                m8546a(zzewm.BACKGROUND_TRACE_NAME.toString(), this.f7837g, this.f7838h);
            }
        } else {
            this.f7836f.add(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStopped(Activity activity) {
        if (this.f7836f.contains(activity)) {
            this.f7836f.remove(activity);
            if (this.f7836f.isEmpty()) {
                this.f7837g = new zzewn();
                if (zzewq.m8607a(activity.getApplicationContext())) {
                    String strValueOf = String.valueOf(zzewm.FOREGROUND_TRACE_NAME);
                    Log.d("FirebasePerformance", new StringBuilder(String.valueOf(strValueOf).length() + 39).append("onActivityStopped ").append(strValueOf).append(":").append(this.f7838h.m8599a(this.f7837g)).toString());
                }
                m8548b(2);
                m8547a(false);
                m8546a(zzewm.FOREGROUND_TRACE_NAME.toString(), this.f7838h, this.f7837g);
            }
        }
    }
}
