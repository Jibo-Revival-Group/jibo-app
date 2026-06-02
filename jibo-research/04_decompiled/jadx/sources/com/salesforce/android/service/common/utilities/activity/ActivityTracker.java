package com.salesforce.android.service.common.utilities.activity;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ActivityTracker {

    /* JADX INFO: renamed from: j */
    private static final ServiceLogger f13806j = ServiceLogging.m14203a((Class<?>) ActivityTracker.class);

    /* JADX INFO: renamed from: a */
    ActivityReference<Activity> f13807a = ActivityReference.m14053a();

    /* JADX INFO: renamed from: b */
    final LifecycleCallbacks f13808b = new LifecycleCallbacks();

    /* JADX INFO: renamed from: c */
    final Set<OnCreateListener> f13809c = new HashSet();

    /* JADX INFO: renamed from: d */
    final Set<OnStartListener> f13810d = new HashSet();

    /* JADX INFO: renamed from: e */
    final Set<OnResumeListener> f13811e = new HashSet();

    /* JADX INFO: renamed from: f */
    final Set<OnPauseListener> f13812f = new HashSet();

    /* JADX INFO: renamed from: g */
    final Set<OnDestroyListener> f13813g = new HashSet();

    /* JADX INFO: renamed from: h */
    final Set<OnStopListener> f13814h = new HashSet();

    /* JADX INFO: renamed from: i */
    private Application f13815i;

    public interface OnCreateListener {
        /* JADX INFO: renamed from: c */
        void mo13529c(Activity activity);
    }

    public interface OnDestroyListener {
        /* JADX INFO: renamed from: d */
        void mo13530d(Activity activity);
    }

    public interface OnPauseListener {
        /* JADX INFO: renamed from: c */
        void mo13984c(Activity activity);
    }

    public interface OnResumeListener {
        /* JADX INFO: renamed from: b */
        void mo13982b(Activity activity);
    }

    public interface OnStartListener {
        /* JADX INFO: renamed from: a */
        void mo12740a(Activity activity);
    }

    public interface OnStopListener {
        /* JADX INFO: renamed from: a */
        void mo12741a(Activity activity);
    }

    /* JADX INFO: renamed from: a */
    public void m14064a(Context context) {
        this.f13815i = (Application) context.getApplicationContext();
        this.f13815i.registerActivityLifecycleCallbacks(this.f13808b);
    }

    /* JADX INFO: renamed from: a */
    public void m14062a() {
        if (this.f13815i != null) {
            this.f13815i.unregisterActivityLifecycleCallbacks(this.f13808b);
            this.f13815i = null;
        }
    }

    /* JADX INFO: renamed from: b */
    public Activity m14065b() {
        return this.f13807a.get();
    }

    /* JADX INFO: renamed from: a */
    public void m14063a(Activity activity) {
        this.f13807a = ActivityReference.m14054a(activity);
    }

    /* JADX INFO: renamed from: a */
    public ActivityTracker m14056a(OnCreateListener onCreateListener) {
        this.f13809c.add(onCreateListener);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public ActivityTracker m14066b(OnCreateListener onCreateListener) {
        this.f13809c.remove(onCreateListener);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ActivityTracker m14060a(OnStartListener onStartListener) {
        this.f13810d.add(onStartListener);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public ActivityTracker m14070b(OnStartListener onStartListener) {
        this.f13810d.remove(onStartListener);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ActivityTracker m14059a(OnResumeListener onResumeListener) {
        this.f13811e.add(onResumeListener);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public ActivityTracker m14069b(OnResumeListener onResumeListener) {
        this.f13811e.remove(onResumeListener);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ActivityTracker m14058a(OnPauseListener onPauseListener) {
        this.f13812f.add(onPauseListener);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public ActivityTracker m14068b(OnPauseListener onPauseListener) {
        this.f13812f.remove(onPauseListener);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ActivityTracker m14057a(OnDestroyListener onDestroyListener) {
        this.f13813g.add(onDestroyListener);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public ActivityTracker m14067b(OnDestroyListener onDestroyListener) {
        this.f13813g.remove(onDestroyListener);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public ActivityTracker m14061a(OnStopListener onStopListener) {
        this.f13814h.add(onStopListener);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public ActivityTracker m14071b(OnStopListener onStopListener) {
        this.f13814h.remove(onStopListener);
        return this;
    }

    private class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
        LifecycleCallbacks() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Iterator<OnCreateListener> it = ActivityTracker.this.f13809c.iterator();
            while (it.hasNext()) {
                it.next().mo13529c(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Iterator<OnStartListener> it = ActivityTracker.this.f13810d.iterator();
            while (it.hasNext()) {
                it.next().mo12740a(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (ActivityTracker.this.f13807a.m14100b()) {
                ActivityTracker.f13806j.mo14191c("Ignoring onActivityResume on {}. It is behind another activity.", activity);
                return;
            }
            ActivityTracker.this.f13807a = ActivityReference.m14054a(activity);
            Iterator<OnResumeListener> it = ActivityTracker.this.f13811e.iterator();
            while (it.hasNext()) {
                it.next().mo13982b(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            ActivityTracker.this.f13807a.m14099b(activity);
            Iterator<OnPauseListener> it = ActivityTracker.this.f13812f.iterator();
            while (it.hasNext()) {
                it.next().mo13984c(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Iterator<OnStopListener> it = ActivityTracker.this.f13814h.iterator();
            while (it.hasNext()) {
                it.next().mo12741a(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Iterator<OnDestroyListener> it = ActivityTracker.this.f13813g.iterator();
            while (it.hasNext()) {
                it.next().mo13530d(activity);
            }
        }
    }
}
