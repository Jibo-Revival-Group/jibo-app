package com.crashlytics.android.answers;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import com.crashlytics.android.answers.BackgroundManager;
import com.crashlytics.android.answers.SessionEvent;
import io.fabric.sdk.android.ActivityLifecycleManager;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.services.common.ExecutorUtils;
import io.fabric.sdk.android.services.common.IdManager;
import io.fabric.sdk.android.services.network.DefaultHttpRequestFactory;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: classes.dex */
class SessionAnalyticsManager implements BackgroundManager.Listener {

    /* JADX INFO: renamed from: a */
    final AnswersEventsHandler f5070a;

    /* JADX INFO: renamed from: b */
    final ActivityLifecycleManager f5071b;

    /* JADX INFO: renamed from: c */
    final BackgroundManager f5072c;

    /* JADX INFO: renamed from: d */
    final AnswersPreferenceManager f5073d;

    /* JADX INFO: renamed from: e */
    private final long f5074e;

    /* JADX INFO: renamed from: a */
    public static SessionAnalyticsManager m5664a(Kit kit, Context context, IdManager idManager, String str, String str2, long j) {
        SessionMetadataCollector sessionMetadataCollector = new SessionMetadataCollector(context, idManager, str, str2);
        AnswersFilesManagerProvider answersFilesManagerProvider = new AnswersFilesManagerProvider(context, new FileStoreImpl(kit));
        DefaultHttpRequestFactory defaultHttpRequestFactory = new DefaultHttpRequestFactory(Fabric.m15085h());
        ActivityLifecycleManager activityLifecycleManager = new ActivityLifecycleManager(context);
        ScheduledExecutorService scheduledExecutorServiceM15219b = ExecutorUtils.m15219b("Answers Events Handler");
        return new SessionAnalyticsManager(new AnswersEventsHandler(kit, context, answersFilesManagerProvider, sessionMetadataCollector, defaultHttpRequestFactory, scheduledExecutorServiceM15219b), activityLifecycleManager, new BackgroundManager(scheduledExecutorServiceM15219b), AnswersPreferenceManager.m5634a(context), j);
    }

    SessionAnalyticsManager(AnswersEventsHandler answersEventsHandler, ActivityLifecycleManager activityLifecycleManager, BackgroundManager backgroundManager, AnswersPreferenceManager answersPreferenceManager, long j) {
        this.f5070a = answersEventsHandler;
        this.f5071b = activityLifecycleManager;
        this.f5072c = backgroundManager;
        this.f5073d = answersPreferenceManager;
        this.f5074e = j;
    }

    /* JADX INFO: renamed from: b */
    public void m5670b() {
        this.f5070a.m5622b();
        this.f5071b.m15056a(new AnswersLifecycleCallbacks(this, this.f5072c));
        this.f5072c.m5642a(this);
        if (m5672d()) {
            m5665a(this.f5074e);
            this.f5073d.m5635a();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m5671c() {
        this.f5071b.m15055a();
        this.f5070a.m5617a();
    }

    /* JADX INFO: renamed from: a */
    public void m5669a(String str, String str2) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new IllegalStateException("onCrash called from main thread!!!");
        }
        Fabric.m15085h().mo15063a("Answers", "Logged crash");
        this.f5070a.m5625c(SessionEvent.m5676a(str, str2));
    }

    /* JADX INFO: renamed from: a */
    public void m5668a(String str) {
    }

    /* JADX INFO: renamed from: a */
    public void m5665a(long j) {
        Fabric.m15085h().mo15063a("Answers", "Logged install");
        this.f5070a.m5623b(SessionEvent.m5673a(j));
    }

    /* JADX INFO: renamed from: a */
    public void m5666a(Activity activity, SessionEvent.Type type) {
        Fabric.m15085h().mo15063a("Answers", "Logged lifecycle event: " + type.name());
        this.f5070a.m5618a(SessionEvent.m5674a(type, activity));
    }

    @Override // com.crashlytics.android.answers.BackgroundManager.Listener
    /* JADX INFO: renamed from: a */
    public void mo5645a() {
        Fabric.m15085h().mo15063a("Answers", "Flush events when app is backgrounded");
        this.f5070a.m5624c();
    }

    /* JADX INFO: renamed from: a */
    public void m5667a(AnalyticsSettingsData analyticsSettingsData, String str) {
        this.f5072c.m5643a(analyticsSettingsData.f14728h);
        this.f5070a.m5620a(analyticsSettingsData, str);
    }

    /* JADX INFO: renamed from: d */
    boolean m5672d() {
        return !this.f5073d.m5636b();
    }
}
