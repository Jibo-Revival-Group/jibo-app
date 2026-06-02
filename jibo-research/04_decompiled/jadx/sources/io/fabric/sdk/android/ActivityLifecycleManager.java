package io.fabric.sdk.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ActivityLifecycleManager {

    /* JADX INFO: renamed from: a */
    private final Application f14490a;

    /* JADX INFO: renamed from: b */
    private ActivityLifecycleCallbacksWrapper f14491b;

    public static abstract class Callbacks {
        /* JADX INFO: renamed from: a */
        public void mo5628a(Activity activity, Bundle bundle) {
        }

        /* JADX INFO: renamed from: a */
        public void mo5627a(Activity activity) {
        }

        /* JADX INFO: renamed from: b */
        public void mo5629b(Activity activity) {
        }

        /* JADX INFO: renamed from: c */
        public void mo5631c(Activity activity) {
        }

        /* JADX INFO: renamed from: d */
        public void mo5632d(Activity activity) {
        }

        /* JADX INFO: renamed from: b */
        public void mo5630b(Activity activity, Bundle bundle) {
        }

        /* JADX INFO: renamed from: e */
        public void mo5633e(Activity activity) {
        }
    }

    public ActivityLifecycleManager(Context context) {
        this.f14490a = (Application) context.getApplicationContext();
        if (Build.VERSION.SDK_INT >= 14) {
            this.f14491b = new ActivityLifecycleCallbacksWrapper(this.f14490a);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m15056a(Callbacks callbacks) {
        return this.f14491b != null && this.f14491b.m15060a(callbacks);
    }

    /* JADX INFO: renamed from: a */
    public void m15055a() {
        if (this.f14491b == null) {
            return;
        }
        this.f14491b.m15057a();
    }

    private static class ActivityLifecycleCallbacksWrapper {

        /* JADX INFO: renamed from: a */
        private final Set<Application.ActivityLifecycleCallbacks> f14492a = new HashSet();

        /* JADX INFO: renamed from: b */
        private final Application f14493b;

        ActivityLifecycleCallbacksWrapper(Application application) {
            this.f14493b = application;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(14)
        /* JADX INFO: renamed from: a */
        public void m15057a() {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.f14492a.iterator();
            while (it.hasNext()) {
                this.f14493b.unregisterActivityLifecycleCallbacks(it.next());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @TargetApi(14)
        /* JADX INFO: renamed from: a */
        public boolean m15060a(final Callbacks callbacks) {
            if (this.f14493b == null) {
                return false;
            }
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: io.fabric.sdk.android.ActivityLifecycleManager.ActivityLifecycleCallbacksWrapper.1
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    callbacks.mo5628a(activity, bundle);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    callbacks.mo5627a(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    callbacks.mo5629b(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    callbacks.mo5631c(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    callbacks.mo5632d(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    callbacks.mo5630b(activity, bundle);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    callbacks.mo5633e(activity);
                }
            };
            this.f14493b.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
            this.f14492a.add(activityLifecycleCallbacks);
            return true;
        }
    }
}
