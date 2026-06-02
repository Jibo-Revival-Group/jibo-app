package com.crashlytics.android.beta;

import android.annotation.TargetApi;
import android.app.Activity;
import io.fabric.sdk.android.ActivityLifecycleManager;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
@TargetApi(14)
class ActivityLifecycleCheckForUpdatesController extends AbstractCheckForUpdatesController {

    /* JADX INFO: renamed from: a */
    private final ActivityLifecycleManager.Callbacks f5119a = new ActivityLifecycleManager.Callbacks() { // from class: com.crashlytics.android.beta.ActivityLifecycleCheckForUpdatesController.1
        @Override // io.fabric.sdk.android.ActivityLifecycleManager.Callbacks
        /* JADX INFO: renamed from: a */
        public void mo5627a(Activity activity) {
            if (ActivityLifecycleCheckForUpdatesController.this.m5686a()) {
                ActivityLifecycleCheckForUpdatesController.this.f5120b.submit(new Runnable() { // from class: com.crashlytics.android.beta.ActivityLifecycleCheckForUpdatesController.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ActivityLifecycleCheckForUpdatesController.this.m5688c();
                    }
                });
            }
        }
    };

    /* JADX INFO: renamed from: b */
    private final ExecutorService f5120b;

    public ActivityLifecycleCheckForUpdatesController(ActivityLifecycleManager activityLifecycleManager, ExecutorService executorService) {
        this.f5120b = executorService;
        activityLifecycleManager.m15056a(this.f5119a);
    }
}
