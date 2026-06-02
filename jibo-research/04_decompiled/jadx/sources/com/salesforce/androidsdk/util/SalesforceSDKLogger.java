package com.salesforce.androidsdk.util;

import com.salesforce.androidsdk.analytics.logger.SalesforceLogger;
import com.salesforce.androidsdk.app.SalesforceSDKManager;

/* JADX INFO: loaded from: classes.dex */
public class SalesforceSDKLogger {
    /* JADX INFO: renamed from: a */
    public static void m15015a(String str, String str2) {
        m15014a().m14320a(str, str2);
    }

    /* JADX INFO: renamed from: a */
    public static void m15016a(String str, String str2, Throwable th) {
        m15014a().m14321a(str, str2, th);
    }

    /* JADX INFO: renamed from: b */
    public static void m15017b(String str, String str2) {
        m15014a().m14322b(str, str2);
    }

    /* JADX INFO: renamed from: b */
    public static void m15018b(String str, String str2, Throwable th) {
        m15014a().m14323b(str, str2, th);
    }

    /* JADX INFO: renamed from: c */
    public static void m15019c(String str, String str2) {
        m15014a().m14324c(str, str2);
    }

    /* JADX INFO: renamed from: c */
    public static void m15020c(String str, String str2, Throwable th) {
        m15014a().m14325c(str, str2, th);
    }

    /* JADX INFO: renamed from: a */
    private static SalesforceLogger m15014a() {
        return SalesforceLogger.m14312a("SalesforceSDK", SalesforceSDKManager.m14403a().m14446k());
    }
}
