package com.crashlytics.android.answers;

import com.crashlytics.android.answers.SessionEvent;
import io.fabric.sdk.android.services.settings.AnalyticsSettingsData;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class DisabledSessionAnalyticsManagerStrategy implements SessionAnalyticsManagerStrategy {
    DisabledSessionAnalyticsManagerStrategy() {
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    /* JADX INFO: renamed from: a */
    public void mo5648a(AnalyticsSettingsData analyticsSettingsData, String str) {
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    /* JADX INFO: renamed from: a */
    public void mo5647a(SessionEvent.Builder builder) {
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    /* JADX INFO: renamed from: a */
    public void mo5646a() {
    }

    @Override // com.crashlytics.android.answers.SessionAnalyticsManagerStrategy
    /* JADX INFO: renamed from: b */
    public void mo5649b() {
    }

    @Override // io.fabric.sdk.android.services.events.FileRollOverManager
    /* JADX INFO: renamed from: c */
    public boolean mo5650c() throws IOException {
        return false;
    }

    @Override // io.fabric.sdk.android.services.events.FileRollOverManager
    /* JADX INFO: renamed from: d */
    public void mo5651d() {
    }
}
