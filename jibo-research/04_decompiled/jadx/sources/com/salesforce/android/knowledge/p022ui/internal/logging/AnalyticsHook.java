package com.salesforce.android.knowledge.p022ui.internal.logging;

import com.salesforce.android.service.common.analytics.ServiceAnalytics;
import com.salesforce.android.service.common.analytics.ServiceAnalyticsListener;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class AnalyticsHook implements ServiceAnalyticsListener {

    /* JADX INFO: renamed from: a */
    Listener f13290a;

    /* JADX INFO: renamed from: b */
    private final Map<String, Translation> f13291b = new HashMap();

    interface Listener {
        /* JADX INFO: renamed from: a */
        void mo13590a(BaseEvent baseEvent);
    }

    interface Translation {
        /* JADX INFO: renamed from: a */
        BaseEvent mo13591a(String str, Map<String, Object> map);
    }

    AnalyticsHook() {
    }

    /* JADX INFO: renamed from: a */
    void m13586a() {
        ServiceAnalytics.m13717a(this);
    }

    /* JADX INFO: renamed from: b */
    void m13589b() {
        ServiceAnalytics.m13718b(this);
    }

    /* JADX INFO: renamed from: a */
    void m13588a(String str, Translation translation) {
        this.f13291b.put(str, translation);
    }

    /* JADX INFO: renamed from: a */
    void m13587a(Listener listener) {
        this.f13290a = listener;
    }

    @Override // com.salesforce.android.service.common.analytics.ServiceAnalyticsListener
    /* JADX INFO: renamed from: a */
    public void mo13029a(String str, Map<String, Object> map) {
        Translation translation;
        BaseEvent baseEventMo13591a;
        if (this.f13290a != null && (translation = this.f13291b.get(str)) != null && (baseEventMo13591a = translation.mo13591a(str, map)) != null) {
            this.f13290a.mo13590a(baseEventMo13591a);
        }
    }
}
