package com.salesforce.android.cases.p020ui.internal.client;

import android.app.Activity;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import com.salesforce.android.cases.R;
import com.salesforce.android.cases.core.CaseClient;
import com.salesforce.android.cases.core.NotificationHandler;
import com.salesforce.android.cases.core.internal.local.DbUtils;
import com.salesforce.android.cases.core.model.PushNotification;
import com.salesforce.android.cases.p020ui.CaseUIClient;
import com.salesforce.android.cases.p020ui.CaseUIConfiguration;
import com.salesforce.android.cases.p020ui.CasesUIAnalyticsEmit;
import com.salesforce.android.cases.p020ui.internal.features.casefeed.CaseFeedActivity;
import com.salesforce.android.cases.p020ui.internal.features.casefeed.CaseFeedPresenterProvider;
import com.salesforce.android.cases.p020ui.internal.features.caselist.CaseListActivity;
import com.salesforce.android.cases.p020ui.internal.features.caselist.CaseListPresenterProvider;
import com.salesforce.android.cases.p020ui.internal.features.publisher.CasePublisherActivity;
import com.salesforce.android.cases.p020ui.internal.features.publisher.CasePublisherPresenterProvider;
import com.salesforce.android.cases.p020ui.internal.features.shared.CasesSdkActivity;
import com.salesforce.android.cases.p020ui.internal.features.shared.manager.PresenterManager;
import com.salesforce.android.cases.p020ui.internal.logging.LiveAgentCasesLogger;
import com.salesforce.android.service.common.analytics.ServiceAnalytics;
import com.salesforce.android.service.common.utilities.activity.ActivityTracker;
import com.salesforce.android.service.common.utilities.internal.android.notification.NotificationChannel;
import com.salesforce.android.service.common.utilities.internal.android.notification.NotificationManager;
import com.salesforce.android.service.common.utilities.internal.android.notification.SalesforceNotificationBuilder;
import com.salesforce.android.service.common.utilities.internal.android.notification.SalesforceNotificationChannel;
import com.salesforce.android.service.common.utilities.internal.android.notification.SalesforceNotificationManager;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import java.util.Random;

/* JADX INFO: loaded from: classes.dex */
public class CaseUIClientImpl implements NotificationHandler, CaseUIClient {

    /* JADX INFO: renamed from: a */
    private final CaseUIConfiguration f12619a;

    /* JADX INFO: renamed from: b */
    private final CaseClient f12620b;

    /* JADX INFO: renamed from: c */
    private final PresenterManager f12621c;

    /* JADX INFO: renamed from: d */
    private final ActivityTracker f12622d = new ActivityTracker();

    /* JADX INFO: renamed from: e */
    private final NotificationManager f12623e;

    /* JADX INFO: renamed from: f */
    private final NotificationChannel f12624f;

    /* JADX INFO: renamed from: g */
    private final SalesforceNotificationBuilder.Builder f12625g;

    private CaseUIClientImpl(Context context, CaseUIConfiguration caseUIConfiguration, CaseClient caseClient, PresenterManager presenterManager, SalesforceNotificationBuilder.Builder builder) {
        this.f12619a = caseUIConfiguration;
        this.f12620b = caseClient;
        this.f12621c = presenterManager;
        this.f12624f = new SalesforceNotificationChannel(context.getString(R.string.case_notification_channel_id), context.getString(R.string.case_notification_channel_name), caseUIConfiguration.m12725a());
        this.f12623e = SalesforceNotificationManager.m14129a(context);
        this.f12623e.mo14125a(this.f12624f);
        this.f12625g = builder;
        if (context instanceof Application) {
            LiveAgentCasesLogger.Builder builderM13041a = new LiveAgentCasesLogger.Builder().m13041a(context.getApplicationContext());
            if (SalesforceSDKManager.m14403a().m14450o() != null && SalesforceSDKManager.m14403a().m14450o().m14275b() != null) {
                builderM13041a.m13042a(SalesforceSDKManager.m14403a().m14450o().m14275b().m14246f());
            }
            final LiveAgentCasesLogger liveAgentCasesLoggerM13043a = builderM13041a.m13043a();
            ServiceAnalytics.m13717a(liveAgentCasesLoggerM13043a);
            this.f12622d.m14064a(context.getApplicationContext());
            this.f12622d.m14060a(new ActivityTracker.OnStartListener() { // from class: com.salesforce.android.cases.ui.internal.client.CaseUIClientImpl.1
                @Override // com.salesforce.android.service.common.utilities.activity.ActivityTracker.OnStartListener
                /* JADX INFO: renamed from: a */
                public void mo12740a(Activity activity) {
                    if (activity instanceof CasesSdkActivity) {
                        liveAgentCasesLoggerM13043a.m13024a();
                    }
                }
            });
            this.f12622d.m14061a(new ActivityTracker.OnStopListener() { // from class: com.salesforce.android.cases.ui.internal.client.CaseUIClientImpl.2
                @Override // com.salesforce.android.service.common.utilities.activity.ActivityTracker.OnStopListener
                /* JADX INFO: renamed from: a */
                public void mo12741a(Activity activity) {
                    if (!(CaseUIClientImpl.this.f12622d.m14065b() instanceof CasesSdkActivity)) {
                        liveAgentCasesLoggerM13043a.m13030b();
                    }
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    public static CaseUIClientImpl m12736a(Context context, CaseUIConfiguration caseUIConfiguration, CaseClient caseClient) {
        return new CaseUIClientImpl(context, caseUIConfiguration, caseClient, PresenterManager.m13014a(new CasePublisherPresenterProvider(), new CaseListPresenterProvider(), new CaseFeedPresenterProvider()), new SalesforceNotificationBuilder.Builder());
    }

    @Override // com.salesforce.android.cases.p020ui.CaseUIClient
    /* JADX INFO: renamed from: b */
    public void mo12717b(Context context) {
        CasePublisherActivity.m12928a(context);
    }

    /* JADX INFO: renamed from: c */
    public void m12738c(Context context) {
        CaseListActivity.m12832a(context);
    }

    @Override // com.salesforce.android.cases.p020ui.CaseUIClient
    /* JADX INFO: renamed from: a */
    public void mo12714a(Context context) {
        if (mo12720e()) {
            m12738c(context);
        } else {
            mo12717b(context);
        }
    }

    @Override // com.salesforce.android.cases.p020ui.CaseUIClient
    /* JADX INFO: renamed from: a */
    public CaseClient mo12713a() {
        return this.f12620b;
    }

    @Override // com.salesforce.android.cases.p020ui.CaseUIClient
    /* JADX INFO: renamed from: b */
    public String mo12716b() {
        return this.f12619a.m12727c().m12176a();
    }

    @Override // com.salesforce.android.cases.p020ui.CaseUIClient
    /* JADX INFO: renamed from: c */
    public String mo12718c() {
        return this.f12619a.m12727c().m12177b();
    }

    @Override // com.salesforce.android.cases.p020ui.CaseUIClient
    /* JADX INFO: renamed from: d */
    public String mo12719d() {
        return this.f12619a.m12727c().m12178c();
    }

    @Override // com.salesforce.android.cases.p020ui.CaseUIClient
    /* JADX INFO: renamed from: e */
    public boolean mo12720e() {
        return DbUtils.m12369a(this.f12619a.m12727c().m12184i());
    }

    @Override // com.salesforce.android.cases.p020ui.CaseUIClient
    /* JADX INFO: renamed from: a */
    public void mo12715a(Context context, String str) {
        CaseFeedActivity.m12742a(context, str);
    }

    @Override // com.salesforce.android.cases.core.NotificationHandler
    /* JADX INFO: renamed from: a */
    public void mo12189a(Context context, PushNotification pushNotification) {
        CasesUIAnalyticsEmit.m12731a(mo12716b(), mo12719d(), mo12718c(), mo12720e() ? "authenticated" : "guest", "agent", pushNotification.m12621a());
        Intent intent = new Intent(context, (Class<?>) CaseListActivity.class);
        intent.addFlags(335544320);
        this.f12623e.mo14124a(m12735a(pushNotification.m12621a()), this.f12625g.m14127a(this.f12624f).m14128a(context).m14126a(pushNotification.m12622b()).mo14116a(this.f12619a.m12727c().m12182g()).mo14120b(-1).mo14118a(new NotificationCompat.BigTextStyle().m1728b(pushNotification.m12622b())).mo14119a(true).mo14121c(this.f12619a.m12726b()).mo14117a(PendingIntent.getActivity(context, 0, intent, 1073741824)).mo14115a());
    }

    @Override // com.salesforce.android.cases.core.NotificationHandler
    /* JADX INFO: renamed from: a */
    public void mo12190a(PushNotification pushNotification) {
        CasesUIAnalyticsEmit.m12733b(mo12716b(), mo12719d(), mo12718c(), mo12720e() ? "authenticated" : "guest", pushNotification.m12621a(), pushNotification.m12622b());
    }

    @Override // com.salesforce.android.cases.p020ui.CaseUIClient
    /* JADX INFO: renamed from: f */
    public void mo12721f() {
        this.f12622d.m14062a();
    }

    /* JADX INFO: renamed from: a */
    private int m12735a(String str) {
        return str == null ? new Random().nextInt() : str.hashCode();
    }

    /* JADX INFO: renamed from: g */
    public PresenterManager m12739g() {
        return this.f12621c;
    }
}
