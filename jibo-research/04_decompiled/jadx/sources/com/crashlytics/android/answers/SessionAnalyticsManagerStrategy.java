package com.crashlytics.android.answers;

import com.crashlytics.android.answers.SessionEvent;
import io.fabric.sdk.android.services.events.FileRollOverManager;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;

/* JADX INFO: loaded from: classes.dex */
interface SessionAnalyticsManagerStrategy extends FileRollOverManager {
    /* JADX INFO: renamed from: a */
    void mo5646a();

    /* JADX INFO: renamed from: a */
    void mo5647a(SessionEvent.Builder builder);

    /* JADX INFO: renamed from: a */
    void mo5648a(AnalyticsSettingsData analyticsSettingsData, String str);

    /* JADX INFO: renamed from: b */
    void mo5649b();
}
