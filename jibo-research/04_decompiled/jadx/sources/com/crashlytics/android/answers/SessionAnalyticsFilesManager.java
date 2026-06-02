package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.events.EventsFilesManager;
import io.fabric.sdk.android.services.events.EventsStorage;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
class SessionAnalyticsFilesManager extends EventsFilesManager<SessionEvent> {

    /* JADX INFO: renamed from: g */
    private AnalyticsSettingsData f5068g;

    SessionAnalyticsFilesManager(Context context, SessionEventTransform sessionEventTransform, CurrentTimeProvider currentTimeProvider, EventsStorage eventsStorage) throws IOException {
        super(context, sessionEventTransform, currentTimeProvider, eventsStorage, 100);
    }

    @Override // io.fabric.sdk.android.services.events.EventsFilesManager
    /* JADX INFO: renamed from: a */
    protected String mo5660a() {
        return "sa_" + UUID.randomUUID().toString() + "_" + this.f14667c.mo15215a() + ".tap";
    }

    @Override // io.fabric.sdk.android.services.events.EventsFilesManager
    /* JADX INFO: renamed from: b */
    protected int mo5662b() {
        return this.f5068g == null ? super.mo5662b() : this.f5068g.f14725e;
    }

    @Override // io.fabric.sdk.android.services.events.EventsFilesManager
    /* JADX INFO: renamed from: c */
    protected int mo5663c() {
        return this.f5068g == null ? super.mo5663c() : this.f5068g.f14723c;
    }

    /* JADX INFO: renamed from: a */
    void m5661a(AnalyticsSettingsData analyticsSettingsData) {
        this.f5068g = analyticsSettingsData;
    }
}
