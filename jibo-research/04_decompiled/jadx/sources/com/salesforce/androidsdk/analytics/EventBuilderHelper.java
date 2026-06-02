package com.salesforce.androidsdk.analytics;

import com.salesforce.androidsdk.accounts.UserAccount;
import com.salesforce.androidsdk.accounts.UserAccountManager;
import com.salesforce.androidsdk.analytics.model.InstrumentationEvent;
import com.salesforce.androidsdk.analytics.model.InstrumentationEventBuilder;
import com.salesforce.androidsdk.app.SalesforceSDKManager;
import com.salesforce.androidsdk.util.SalesforceSDKLogger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class EventBuilderHelper {

    /* JADX INFO: renamed from: a */
    private static boolean f13994a = true;

    /* JADX INFO: renamed from: b */
    private static final ExecutorService f13995b = Executors.newFixedThreadPool(2);

    /* JADX INFO: renamed from: a */
    public static void m14288a(final String str, final UserAccount userAccount, final String str2, final JSONObject jSONObject) {
        if (f13994a) {
            if (SalesforceSDKManager.m14403a().m14421C()) {
                m14291d(str, userAccount, str2, jSONObject);
            } else {
                f13995b.execute(new Runnable() { // from class: com.salesforce.androidsdk.analytics.EventBuilderHelper.1
                    @Override // java.lang.Runnable
                    public void run() {
                        EventBuilderHelper.m14291d(str, userAccount, str2, jSONObject);
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m14289b(String str, UserAccount userAccount, String str2, JSONObject jSONObject) {
        m14291d(str, userAccount, str2, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public static void m14291d(String str, UserAccount userAccount, String str2, JSONObject jSONObject) {
        if (f13994a) {
            if (userAccount == null) {
                userAccount = UserAccountManager.m14264a().m14275b();
            }
            if (userAccount != null) {
                SalesforceAnalyticsManager salesforceAnalyticsManagerM14292a = SalesforceAnalyticsManager.m14292a(userAccount);
                InstrumentationEventBuilder instrumentationEventBuilderM14355a = InstrumentationEventBuilder.m14355a(salesforceAnalyticsManagerM14292a.m14302a(), SalesforceSDKManager.m14403a().m14446k());
                instrumentationEventBuilderM14355a.m14361a(str);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("context", str2);
                } catch (JSONException e) {
                    SalesforceSDKLogger.m15016a("EventBuilderHelper", "Exception thrown while building page object", e);
                }
                instrumentationEventBuilderM14355a.m14364b(jSONObject2);
                if (jSONObject != null) {
                    instrumentationEventBuilderM14355a.m14358a(jSONObject.optLong("startTime"));
                    if (jSONObject.has("endTime")) {
                        instrumentationEventBuilderM14355a.m14363b(jSONObject.optLong("endTime"));
                    }
                    instrumentationEventBuilderM14355a.m14362a(jSONObject);
                }
                instrumentationEventBuilderM14355a.m14360a(InstrumentationEvent.SchemaType.LightningInteraction);
                instrumentationEventBuilderM14355a.m14359a(InstrumentationEvent.EventType.system);
                try {
                    salesforceAnalyticsManagerM14292a.m14302a().m14333d().m14382a(instrumentationEventBuilderM14355a.m14357a());
                } catch (InstrumentationEventBuilder.EventBuilderException e2) {
                    SalesforceSDKLogger.m15016a("EventBuilderHelper", "Exception thrown while building event", e2);
                }
            }
        }
    }
}
