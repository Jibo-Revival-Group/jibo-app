package com.google.firebase.perf.metrics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.android.gms.internal.zzevz;
import com.google.android.gms.internal.zzewk;
import com.google.android.gms.internal.zzewm;
import com.google.android.gms.internal.zzewn;
import com.google.android.gms.internal.zzewy;
import com.google.firebase.perf.provider.FirebasePerfProvider;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class AppStartTrace implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a */
    private static final long f8726a = TimeUnit.MINUTES.toMicros(1);

    /* JADX INFO: renamed from: b */
    private static volatile AppStartTrace f8727b;

    /* JADX INFO: renamed from: e */
    private final zzewk f8730e;

    /* JADX INFO: renamed from: f */
    private Context f8731f;

    /* JADX INFO: renamed from: g */
    private WeakReference<Activity> f8732g;

    /* JADX INFO: renamed from: h */
    private WeakReference<Activity> f8733h;

    /* JADX INFO: renamed from: c */
    private boolean f8728c = false;

    /* JADX INFO: renamed from: i */
    private boolean f8734i = false;

    /* JADX INFO: renamed from: j */
    private zzewn f8735j = null;

    /* JADX INFO: renamed from: k */
    private zzewn f8736k = null;

    /* JADX INFO: renamed from: l */
    private zzewn f8737l = null;

    /* JADX INFO: renamed from: m */
    private boolean f8738m = false;

    /* JADX INFO: renamed from: d */
    private zzevz f8729d = null;

    public static class zza implements Runnable {

        /* JADX INFO: renamed from: a */
        private final AppStartTrace f8739a;

        public zza(AppStartTrace appStartTrace) {
            this.f8739a = appStartTrace;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f8739a.f8735j == null) {
                AppStartTrace.m9249a(this.f8739a, true);
            }
        }
    }

    private AppStartTrace(zzevz zzevzVar, zzewk zzewkVar) {
        this.f8730e = zzewkVar;
    }

    /* JADX INFO: renamed from: a */
    public static AppStartTrace m9247a() {
        return f8727b != null ? f8727b : m9248a((zzevz) null, new zzewk());
    }

    /* JADX INFO: renamed from: a */
    private static AppStartTrace m9248a(zzevz zzevzVar, zzewk zzewkVar) {
        if (f8727b == null) {
            synchronized (AppStartTrace.class) {
                if (f8727b == null) {
                    f8727b = new AppStartTrace(null, zzewkVar);
                }
            }
        }
        return f8727b;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ boolean m9249a(AppStartTrace appStartTrace, boolean z) {
        appStartTrace.f8738m = true;
        return true;
    }

    /* JADX INFO: renamed from: b */
    private final synchronized void m9250b() {
        if (this.f8728c) {
            ((Application) this.f8731f).unregisterActivityLifecycleCallbacks(this);
            this.f8728c = false;
        }
    }

    @Keep
    public static void setLauncherActivityOnCreateTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnResumeTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnStartTime(String str) {
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m9251a(Context context) {
        if (!this.f8728c) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(this);
                this.f8728c = true;
                this.f8731f = applicationContext;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityCreated(Activity activity, Bundle bundle) {
        if (!this.f8738m && this.f8735j == null) {
            this.f8732g = new WeakReference<>(activity);
            this.f8735j = new zzewn();
            if (FirebasePerfProvider.zzckv().m8599a(this.f8735j) > f8726a) {
                this.f8734i = true;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityResumed(Activity activity) {
        if (!this.f8738m && this.f8737l == null && !this.f8734i) {
            this.f8733h = new WeakReference<>(activity);
            this.f8737l = new zzewn();
            zzewn zzewnVarZzckv = FirebasePerfProvider.zzckv();
            String name = activity.getClass().getName();
            Log.d("FirebasePerformance", new StringBuilder(String.valueOf(name).length() + 30).append("onResume ").append(name).append(":").append(zzewnVarZzckv.m8599a(this.f8737l)).toString());
            zzewy zzewyVar = new zzewy();
            zzewyVar.f7926a = zzewm.APP_START_TRACE_NAME.toString();
            zzewyVar.f7927b = Long.valueOf(zzewnVarZzckv.m8601b());
            zzewyVar.f7928c = Long.valueOf(zzewnVarZzckv.m8599a(this.f8737l));
            zzewy zzewyVar2 = new zzewy();
            zzewyVar2.f7926a = zzewm.ON_CREATE_TRACE_NAME.toString();
            zzewyVar2.f7927b = Long.valueOf(zzewnVarZzckv.m8601b());
            zzewyVar2.f7928c = Long.valueOf(zzewnVarZzckv.m8599a(this.f8735j));
            zzewy zzewyVar3 = new zzewy();
            zzewyVar3.f7926a = zzewm.ON_START_TRACE_NAME.toString();
            zzewyVar3.f7927b = Long.valueOf(this.f8735j.m8601b());
            zzewyVar3.f7928c = Long.valueOf(this.f8735j.m8599a(this.f8736k));
            zzewy zzewyVar4 = new zzewy();
            zzewyVar4.f7926a = zzewm.ON_RESUME_TRACE_NAME.toString();
            zzewyVar4.f7927b = Long.valueOf(this.f8736k.m8601b());
            zzewyVar4.f7928c = Long.valueOf(this.f8736k.m8599a(this.f8737l));
            zzewyVar.f7930e = new zzewy[]{zzewyVar2, zzewyVar3, zzewyVar4};
            if (this.f8729d == null) {
                this.f8729d = zzevz.m8561a();
            }
            if (this.f8729d != null) {
                this.f8729d.m8571a(zzewyVar, 3);
            }
            if (this.f8728c) {
                m9250b();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStarted(Activity activity) {
        if (!this.f8738m && this.f8736k == null && !this.f8734i) {
            this.f8736k = new zzewn();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public synchronized void onActivityStopped(Activity activity) {
    }
}
