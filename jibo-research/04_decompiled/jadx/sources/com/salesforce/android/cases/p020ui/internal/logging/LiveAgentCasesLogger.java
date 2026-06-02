package com.salesforce.android.cases.p020ui.internal.logging;

import android.content.Context;
import com.salesforce.android.service.common.analytics.ServiceAnalyticsListener;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLogger;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingConfiguration;
import com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BatteryEvent;
import com.salesforce.android.service.common.liveagentlogging.event.ConnectivityEvent;
import com.salesforce.android.service.common.liveagentlogging.event.DeviceEvent;
import com.salesforce.android.service.common.liveagentlogging.event.OrientationEvent;
import com.salesforce.android.service.common.liveagentlogging.internal.response.BatchedEventsResponse;
import com.salesforce.android.service.common.utilities.control.Async;
import com.salesforce.android.service.common.utilities.functional.Consumer;
import com.salesforce.android.service.common.utilities.functional.Optional;
import com.salesforce.android.service.common.utilities.internal.android.UUIDProvider;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectionInfo;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityState;
import com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityTracker;
import com.salesforce.android.service.common.utilities.internal.device.BatteryLevelTracker;
import com.salesforce.android.service.common.utilities.internal.device.DeviceInfoLoader;
import com.salesforce.android.service.common.utilities.internal.device.OrientationTracker;
import com.salesforce.android.service.common.utilities.logging.ServiceLogger;
import com.salesforce.android.service.common.utilities.logging.ServiceLogging;
import com.salesforce.android.service.common.utilities.spatial.Orientation;
import com.salesforce.android.service.common.utilities.validation.Arguments;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LiveAgentCasesLogger implements ServiceAnalyticsListener, LiveAgentLoggingSession.Listener, ConnectivityTracker.Listener, OrientationTracker.Listener {

    /* JADX INFO: renamed from: a */
    private static final ServiceLogger f12832a = ServiceLogging.m14203a((Class<?>) LiveAgentCasesLogger.class);

    /* JADX INFO: renamed from: b */
    private final Context f12833b;

    /* JADX INFO: renamed from: c */
    private final String f12834c;

    /* JADX INFO: renamed from: d */
    private final Optional<String> f12835d;

    /* JADX INFO: renamed from: e */
    private LiveAgentLogger f12836e;

    /* JADX INFO: renamed from: f */
    private LiveAgentLoggingSession f12837f;

    /* JADX INFO: renamed from: g */
    private final OrientationTracker f12838g;

    /* JADX INFO: renamed from: h */
    private final BatteryLevelTracker f12839h;

    /* JADX INFO: renamed from: i */
    private final ConnectivityTracker f12840i;

    /* JADX INFO: renamed from: j */
    private final DeviceInfoLoader f12841j;

    /* JADX INFO: renamed from: k */
    private boolean f12842k;

    /* JADX INFO: renamed from: l */
    private final List<BaseEvent> f12843l;

    private LiveAgentCasesLogger(Builder builder) {
        this.f12842k = false;
        this.f12843l = new ArrayList();
        this.f12833b = builder.f12849a;
        this.f12834c = builder.f12850b;
        this.f12835d = Optional.m14095a(builder.f12851c);
        this.f12838g = builder.f12852d.m14160a(this).m14161a();
        this.f12839h = builder.f12853e.m14144a();
        this.f12840i = builder.f12854f.m14140a(this).m14141a();
        this.f12841j = builder.f12855g.m14156a();
    }

    /* JADX INFO: renamed from: a */
    public void m13024a() {
        if (!this.f12842k) {
            this.f12842k = true;
            m13023f();
            this.f12836e = new LiveAgentLogger.Builder().m13881a(new LiveAgentLoggingConfiguration.Builder().m13887a()).m13882a();
            this.f12836e.m13879a(this.f12833b).mo14074a(new Async.ResultHandler<LiveAgentLoggingSession>() { // from class: com.salesforce.android.cases.ui.internal.logging.LiveAgentCasesLogger.1
                @Override // com.salesforce.android.service.common.utilities.control.Async.ResultHandler
                /* JADX INFO: renamed from: a */
                public /* bridge */ /* synthetic */ void mo9875a(Async async, LiveAgentLoggingSession liveAgentLoggingSession) {
                    a2((Async<?>) async, liveAgentLoggingSession);
                }

                /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
                public void a2(Async<?> async, LiveAgentLoggingSession liveAgentLoggingSession) {
                    LiveAgentCasesLogger.this.f12837f = liveAgentLoggingSession;
                    LiveAgentCasesLogger.this.f12837f.mo13888a(LiveAgentCasesLogger.this);
                    LiveAgentCasesLogger.this.f12837f.mo13891a(LiveAgentCasesLogger.this.f12843l);
                    LiveAgentCasesLogger.this.f12843l.clear();
                }
            });
        }
    }

    /* JADX INFO: renamed from: b */
    public void m13030b() {
        this.f12842k = false;
        if (this.f12837f != null) {
            this.f12836e.m13880a();
            try {
                this.f12840i.m14138c();
            } catch (IllegalArgumentException e) {
            }
            try {
                this.f12838g.m14157a();
            } catch (IllegalArgumentException e2) {
            }
            this.f12837f = null;
        }
    }

    /* JADX INFO: renamed from: f */
    private void m13023f() {
        m13025a(new BatteryEvent("case", this.f12834c, this.f12839h.m14142a()));
        m13025a(new DeviceEvent("case", this.f12834c, "1.0", this.f12841j.m14153c(), this.f12841j.m14151a(), this.f12841j.m14152b(), this.f12841j.m14154d()));
        ConnectionInfo connectionInfoM14137b = this.f12840i.m14137b();
        m13025a(new ConnectivityEvent("case", this.f12834c, connectionInfoM14137b.m14131b().name(), connectionInfoM14137b.m14132c().getRadioName()));
    }

    @Override // com.salesforce.android.service.common.utilities.internal.device.OrientationTracker.Listener
    /* JADX INFO: renamed from: a */
    public void mo13028a(Orientation orientation) {
        m13025a(new OrientationEvent("case", this.f12834c, orientation));
    }

    @Override // com.salesforce.android.service.common.utilities.internal.connectivity.ConnectivityTracker.Listener
    /* JADX INFO: renamed from: a */
    public void mo13027a(ConnectionInfo connectionInfo, ConnectivityState connectivityState, ConnectivityState connectivityState2) {
        m13025a(new ConnectivityEvent("case", this.f12834c, connectionInfo.m14131b().name(), connectionInfo.m14132c().getRadioName()));
    }

    @Override // com.salesforce.android.service.common.analytics.ServiceAnalyticsListener
    /* JADX INFO: renamed from: a */
    public void mo13029a(String str, Map<String, Object> map) {
        m13021b(str, map);
    }

    @Override // com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession.Listener
    /* JADX INFO: renamed from: c */
    public void mo13031c() {
        f12832a.mo14190c("Logging session connected");
        if (this.f12837f != null) {
            this.f12837f.mo13889a();
        }
    }

    @Override // com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession.Listener
    /* JADX INFO: renamed from: a */
    public void mo13026a(Async<BatchedEventsResponse> async) {
        async.mo14072a(new Async.CompletionHandler() { // from class: com.salesforce.android.cases.ui.internal.logging.LiveAgentCasesLogger.3
            @Override // com.salesforce.android.service.common.utilities.control.Async.CompletionHandler
            /* JADX INFO: renamed from: a */
            public void mo12580a(Async<?> async2) {
                LiveAgentCasesLogger.f12832a.mo14190c("Log event sent successfully");
            }
        }).mo14073a(new Async.ErrorHandler() { // from class: com.salesforce.android.cases.ui.internal.logging.LiveAgentCasesLogger.2
            @Override // com.salesforce.android.service.common.utilities.control.Async.ErrorHandler
            /* JADX INFO: renamed from: a */
            public void mo12581a(Async<?> async2, Throwable th) {
                LiveAgentCasesLogger.f12832a.mo14195e("Log flush ERROR {}", th.getMessage());
            }
        });
    }

    @Override // com.salesforce.android.service.common.liveagentlogging.LiveAgentLoggingSession.Listener
    /* JADX INFO: renamed from: d */
    public void mo13032d() {
        f12832a.mo14190c("Logging session ended");
    }

    /* JADX INFO: renamed from: a */
    void m13025a(final BaseEvent baseEvent) {
        this.f12835d.m14096a(new Consumer<String>() { // from class: com.salesforce.android.cases.ui.internal.logging.LiveAgentCasesLogger.4
            @Override // com.salesforce.android.service.common.utilities.functional.Consumer
            /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public void mo13033a(String str) {
                baseEvent.m13893a(str);
            }
        });
        if (this.f12837f == null) {
            this.f12843l.add(baseEvent);
        } else {
            this.f12837f.mo13890a(baseEvent);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m13021b(String str, Map<String, Object> map) {
        CaseBasicInfo caseBasicInfo;
        caseBasicInfo = new CaseBasicInfo((String) map.get("communityUrl"), (String) map.get("caseListname"), (String) map.get("createCaseActionName"), (String) map.get("userType"));
        switch (str) {
            case "CASE_USER_CASE_PUBLISHER_LAYOUT_EVENT":
                m13025a(new CaseLayoutEvent(caseBasicInfo, this.f12834c, (String) map.get("eventType")));
                break;
            case "CASE_USER_CASE_SUBMISSION_EVENT":
                m13025a(new CaseSubmissionEvent(caseBasicInfo, this.f12834c, (String) map.get("eventType"), (String) map.get("result"), (String) map.get("caseId"), map.get("wordCount") != null ? ((Integer) map.get("wordCount")).intValue() : 0));
                break;
            case "CASE_USER_CASE_LIST_EVENT":
                m13025a(new CaseListEvent(caseBasicInfo, this.f12834c, (String) map.get("eventType"), map.get("caseCount") != null ? ((Integer) map.get("caseCount")).intValue() : 0));
                break;
            case "CASE_USER_CASE_DETAIL_EVENT":
                m13025a(new CaseDetailEvent(caseBasicInfo, this.f12834c, (String) map.get("eventType"), (String) map.get("caseId")));
                break;
            case "CASE_RESPONSE_MESSAGE_EVENT":
                m13025a(new CaseMessageEvent(caseBasicInfo, this.f12834c, (String) map.get("sender"), (String) map.get("caseId")));
                break;
            case "CASE_RESPONSE_NOTIFICATION_EVENT":
                m13025a(new CaseNotificationEvent(caseBasicInfo, this.f12834c, (String) map.get("caseId")));
                break;
            case "CASE_USER_EXIT_PUBLISHER_WITH_DATA_ENTERED_EVENT":
                m13025a(new CaseDataEnteredEvent(caseBasicInfo, this.f12834c, map.get("wordCount") != null ? ((Integer) map.get("wordCount")).intValue() : 0));
                break;
        }
    }

    public static class Builder {

        /* JADX INFO: renamed from: a */
        private Context f12849a;

        /* JADX INFO: renamed from: b */
        private String f12850b;

        /* JADX INFO: renamed from: c */
        private String f12851c;

        /* JADX INFO: renamed from: d */
        private OrientationTracker.Builder f12852d;

        /* JADX INFO: renamed from: e */
        private BatteryLevelTracker.Builder f12853e;

        /* JADX INFO: renamed from: f */
        private ConnectivityTracker.Builder f12854f;

        /* JADX INFO: renamed from: g */
        private DeviceInfoLoader.Builder f12855g;

        /* JADX INFO: renamed from: a */
        public Builder m13041a(Context context) {
            this.f12849a = context;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Builder m13042a(String str) {
            if (str.length() > 15) {
                this.f12851c = str.substring(0, 15);
            } else {
                this.f12851c = str;
            }
            return this;
        }

        /* JADX INFO: renamed from: a */
        public LiveAgentCasesLogger m13043a() {
            Arguments.m14235a(this.f12849a);
            if (this.f12850b == null) {
                this.f12850b = new UUIDProvider().m14114a().toString();
            }
            if (this.f12852d == null) {
                this.f12852d = new OrientationTracker.Builder().m14159a(this.f12849a);
            }
            if (this.f12853e == null) {
                this.f12853e = new BatteryLevelTracker.Builder().m14143a(this.f12849a);
            }
            if (this.f12854f == null) {
                this.f12854f = new ConnectivityTracker.Builder().m14139a(this.f12849a);
            }
            if (this.f12855g == null) {
                this.f12855g = new DeviceInfoLoader.Builder().m14155a(this.f12849a);
            }
            return new LiveAgentCasesLogger(this);
        }
    }
}
