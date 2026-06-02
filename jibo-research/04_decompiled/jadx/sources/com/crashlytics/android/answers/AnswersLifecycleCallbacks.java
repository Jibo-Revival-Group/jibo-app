package com.crashlytics.android.answers;

import android.app.Activity;
import android.os.Bundle;
import com.crashlytics.android.answers.SessionEvent;
import io.fabric.sdk.android.ActivityLifecycleManager;

/* JADX INFO: loaded from: classes.dex */
class AnswersLifecycleCallbacks extends ActivityLifecycleManager.Callbacks {

    /* JADX INFO: renamed from: a */
    private final SessionAnalyticsManager f5037a;

    /* JADX INFO: renamed from: b */
    private final BackgroundManager f5038b;

    public AnswersLifecycleCallbacks(SessionAnalyticsManager sessionAnalyticsManager, BackgroundManager backgroundManager) {
        this.f5037a = sessionAnalyticsManager;
        this.f5038b = backgroundManager;
    }

    @Override // io.fabric.sdk.android.ActivityLifecycleManager.Callbacks
    /* JADX INFO: renamed from: a */
    public void mo5628a(Activity activity, Bundle bundle) {
    }

    @Override // io.fabric.sdk.android.ActivityLifecycleManager.Callbacks
    /* JADX INFO: renamed from: a */
    public void mo5627a(Activity activity) {
        this.f5037a.m5666a(activity, SessionEvent.Type.START);
    }

    @Override // io.fabric.sdk.android.ActivityLifecycleManager.Callbacks
    /* JADX INFO: renamed from: b */
    public void mo5629b(Activity activity) {
        this.f5037a.m5666a(activity, SessionEvent.Type.RESUME);
        this.f5038b.m5641a();
    }

    @Override // io.fabric.sdk.android.ActivityLifecycleManager.Callbacks
    /* JADX INFO: renamed from: c */
    public void mo5631c(Activity activity) {
        this.f5037a.m5666a(activity, SessionEvent.Type.PAUSE);
        this.f5038b.m5644b();
    }

    @Override // io.fabric.sdk.android.ActivityLifecycleManager.Callbacks
    /* JADX INFO: renamed from: d */
    public void mo5632d(Activity activity) {
        this.f5037a.m5666a(activity, SessionEvent.Type.STOP);
    }

    @Override // io.fabric.sdk.android.ActivityLifecycleManager.Callbacks
    /* JADX INFO: renamed from: b */
    public void mo5630b(Activity activity, Bundle bundle) {
    }

    @Override // io.fabric.sdk.android.ActivityLifecycleManager.Callbacks
    /* JADX INFO: renamed from: e */
    public void mo5633e(Activity activity) {
    }
}
