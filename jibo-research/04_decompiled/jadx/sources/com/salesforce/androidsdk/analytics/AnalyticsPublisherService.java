package com.salesforce.androidsdk.analytics;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.accounts.UserAccountManager;

/* JADX INFO: loaded from: classes.dex */
public class AnalyticsPublisherService extends IntentService {
    public AnalyticsPublisherService() {
        super("AnalyticsPublisherService");
    }

    /* JADX INFO: renamed from: a */
    public static void m14287a(Context context) {
        Intent intent = new Intent(context, (Class<?>) AnalyticsPublisherService.class);
        intent.setAction("com.salesforce.androidsdk.analytics.action.ANALYTICS_PUBLISH");
        context.startService(intent);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        if (intent != null && "com.salesforce.androidsdk.analytics.action.ANALYTICS_PUBLISH".equals(intent.getAction())) {
            m14286a();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m14286a() {
        UserAccount userAccountM14275b = UserAccountManager.m14264a().m14275b();
        if (userAccountM14275b != null) {
            SalesforceAnalyticsManager.m14292a(userAccountM14275b).m14306c();
        }
    }
}
