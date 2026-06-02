package com.salesforce.android.knowledge.p022ui.internal.logging;

import android.content.Context;
import com.salesforce.android.knowledge.p022ui.internal.logging.AnalyticsHook;
import com.salesforce.android.knowledge.p022ui.internal.logging.CommonEventHook;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLogger;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BatteryEvent;
import com.salesforce.android.service.common.liveagentlogging.event.DeviceEvent;
import com.salesforce.android.service.common.liveagentlogging.internal.response.BatchedEventsResponse;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.internal.android.UUIDProvider;
import com.salesforce.android.service.common.utilities.internal.device.BatteryLevelTracker;
import com.salesforce.android.service.common.utilities.internal.device.DeviceInfoLoader;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LiveAgentKnowledgeLogger implements AnalyticsHook.Listener, CommonEventHook.Listener, LiveAgentLoggingSession.Listener {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f13297a = ServiceLogging.m14203a((Class<?>) LiveAgentKnowledgeLogger.class);

    /* JADX INFO: renamed from: b */
    private final DeviceInfoLoader.Builder f13298b;

    /* JADX INFO: renamed from: c */
    private final LiveAgentLogger.Builder f13299c;

    /* JADX INFO: renamed from: d */
    private final AnalyticsHook f13300d;

    /* JADX INFO: renamed from: e */
    private final CommonEventHook f13301e;

    /* JADX INFO: renamed from: f */
    private final String f13302f;

    /* JADX INFO: renamed from: g */
    private LiveAgentLogger f13303g;

    /* JADX INFO: renamed from: h */
    private LiveAgentLoggingSession f13304h;

    /* JADX INFO: renamed from: i */
    private final List<BaseEvent> f13305i = new ArrayList();

    LiveAgentKnowledgeLogger(String str, CommonEventHook commonEventHook, AnalyticsHook analyticsHook, DeviceInfoLoader.Builder builder, LiveAgentLogger.Builder builder2) {
        this.f13302f = str;
        this.f13300d = analyticsHook;
        this.f13301e = commonEventHook;
        this.f13298b = builder;
        this.f13299c = builder2;
    }

    /* JADX INFO: renamed from: a */
    public static LiveAgentKnowledgeLogger m13599a(String str, String str2, String str3, ActivityTracker activityTracker) {
        KbBasicInfo kbBasicInfo = new KbBasicInfo(str, str2, str3, false);
        String string = new UUIDProvider().m14114a().toString();
        AnalyticsHook analyticsHook = new AnalyticsHook();
        new Translator().m13606a(kbBasicInfo, string, analyticsHook);
        return new LiveAgentKnowledgeLogger(string, CommonEventHook.m13592a(activityTracker, string), analyticsHook, new DeviceInfoLoader.Builder(), new LiveAgentLogger.Builder());
    }

    /* JADX INFO: renamed from: a */
    public void m13604a(Context context) {
        if (this.f13303g == null) {
            DeviceInfoLoader deviceInfoLoaderM14156a = this.f13298b.m14155a(context).m14156a();
            this.f13303g = this.f13299c.m13881a(new LiveAgentLoggingConfiguration.Builder().m13887a()).m13882a();
            this.f13303g.m13879a(context).mo14074a(new Async.ResultHandler<LiveAgentLoggingSession>() { // from class: com.salesforce.android.knowledge.ui.internal.logging.LiveAgentKnowledgeLogger.1
                @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
                /* JADX INFO: renamed from: a */
                public /* bridge */ /* synthetic */ void mo9875a(Async async, LiveAgentLoggingSession liveAgentLoggingSession) {
                    a2((Async<?>) async, liveAgentLoggingSession);
                }

                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
                public void a2(Async<?> async, LiveAgentLoggingSession liveAgentLoggingSession) {
                    LiveAgentKnowledgeLogger.this.m13605a(liveAgentLoggingSession);
                }
            });
            m13600a(context, deviceInfoLoaderM14156a);
            this.f13300d.m13587a(this);
            this.f13300d.m13586a();
            this.f13301e.m13596a(this);
            this.f13301e.m13595a(context);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m13603a() {
        this.f13301e.m13596a((CommonEventHook.Listener) null);
        this.f13301e.m13594a();
        this.f13300d.m13587a(null);
        this.f13300d.m13589b();
        if (this.f13303g != null) {
            this.f13303g.m13880a();
            this.f13303g = null;
            this.f13304h = null;
        }
    }

    @Override // com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession.Listener
    /* JADX INFO: renamed from: c */
    public void mo13031c() {
        f13297a.mo14190c("Logging session connected");
        this.f13304h.mo13889a();
    }

    @Override // com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession.Listener
    /* JADX INFO: renamed from: a */
    public void mo13026a(Async<BatchedEventsResponse> async) {
    }

    @Override // com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession.Listener
    /* JADX INFO: renamed from: d */
    public void mo13032d() {
        f13297a.mo14190c("Logging session ended");
    }

    @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Listener
    /* JADX INFO: renamed from: a */
    public void mo13590a(BaseEvent baseEvent) {
        m13602c(baseEvent);
    }

    @Override // com.salesforce.android.knowledge.ui.internal.logging.CommonEventHook.Listener
    /* JADX INFO: renamed from: b */
    public void mo13598b(BaseEvent baseEvent) {
        m13602c(baseEvent);
    }

    /* JADX INFO: renamed from: c */
    private void m13602c(BaseEvent baseEvent) {
        if (this.f13304h != null) {
            this.f13304h.mo13890a(baseEvent);
        } else {
            this.f13305i.add(baseEvent);
        }
    }

    /* JADX INFO: renamed from: a */
    void m13605a(LiveAgentLoggingSession liveAgentLoggingSession) {
        this.f13304h = liveAgentLoggingSession;
        m13601b(liveAgentLoggingSession);
    }

    /* JADX INFO: renamed from: b */
    private void m13601b(LiveAgentLoggingSession liveAgentLoggingSession) {
        liveAgentLoggingSession.mo13891a(this.f13305i);
        this.f13305i.clear();
    }

    /* JADX INFO: renamed from: a */
    private void m13600a(Context context, DeviceInfoLoader deviceInfoLoader) {
        m13602c(new DeviceEvent("KB", this.f13302f, "3.0.0+android", deviceInfoLoader.m14153c(), deviceInfoLoader.m14151a(), deviceInfoLoader.m14152b(), deviceInfoLoader.m14154d()));
        m13602c(new BatteryEvent("KB", this.f13302f, new BatteryLevelTracker.Builder().m14143a(context).m14144a().m14142a()));
    }
}
