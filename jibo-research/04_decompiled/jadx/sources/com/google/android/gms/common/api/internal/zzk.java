package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class zzk implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* JADX INFO: renamed from: a */
    private static final zzk f6414a = new zzk();

    /* JADX INFO: renamed from: b */
    private final AtomicBoolean f6415b = new AtomicBoolean();

    /* JADX INFO: renamed from: c */
    private final AtomicBoolean f6416c = new AtomicBoolean();

    /* JADX INFO: renamed from: d */
    private final ArrayList<zzl> f6417d = new ArrayList<>();

    /* JADX INFO: renamed from: e */
    private boolean f6418e = false;

    private zzk() {
    }

    /* JADX INFO: renamed from: a */
    public static zzk m7218a() {
        return f6414a;
    }

    /* JADX INFO: renamed from: a */
    public static void m7219a(Application application) {
        synchronized (f6414a) {
            if (!f6414a.f6418e) {
                application.registerActivityLifecycleCallbacks(f6414a);
                application.registerComponentCallbacks(f6414a);
                f6414a.f6418e = true;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private final void m7220b(boolean z) {
        synchronized (f6414a) {
            ArrayList<zzl> arrayList = this.f6417d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                zzl zzlVar = arrayList.get(i);
                i++;
                zzlVar.mo7118a(z);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m7221a(zzl zzlVar) {
        synchronized (f6414a) {
            this.f6417d.add(zzlVar);
        }
    }

    @TargetApi(16)
    /* JADX INFO: renamed from: a */
    public final boolean m7222a(boolean z) {
        if (!this.f6416c.get()) {
            if (!com.google.android.gms.common.util.zzq.m7511b()) {
                return true;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f6416c.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f6415b.set(true);
            }
        }
        return this.f6415b.get();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean zCompareAndSet = this.f6415b.compareAndSet(true, false);
        this.f6416c.set(true);
        if (zCompareAndSet) {
            m7220b(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean zCompareAndSet = this.f6415b.compareAndSet(true, false);
        this.f6416c.set(true);
        if (zCompareAndSet) {
            m7220b(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20 && this.f6415b.compareAndSet(false, true)) {
            this.f6416c.set(true);
            m7220b(true);
        }
    }
}
