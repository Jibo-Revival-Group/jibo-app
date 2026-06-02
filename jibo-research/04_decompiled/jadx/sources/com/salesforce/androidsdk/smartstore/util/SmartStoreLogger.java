package com.salesforce.androidsdk.smartstore.util;

import com.salesforce.androidsdk.analytics.logger.SalesforceLogger;
import com.salesforce.androidsdk.app.SalesforceSDKManager;

/* JADX INFO: loaded from: classes.dex */
public class SmartStoreLogger {
    /* JADX INFO: renamed from: a */
    public static void m14825a(String str, String str2, Throwable th) {
        m14823a().m14321a(str, str2, th);
    }

    /* JADX INFO: renamed from: a */
    public static void m14824a(String str, String str2) {
        m14823a().m14322b(str, str2);
    }

    /* JADX INFO: renamed from: b */
    public static void m14827b(String str, String str2, Throwable th) {
        m14823a().m14323b(str, str2, th);
    }

    /* JADX INFO: renamed from: b */
    public static void m14826b(String str, String str2) {
        m14823a().m14324c(str, str2);
    }

    /* JADX INFO: renamed from: c */
    public static void m14828c(String str, String str2) {
        m14823a().m14326d(str, str2);
    }

    /* JADX INFO: renamed from: c */
    public static void m14829c(String str, String str2, Throwable th) {
        m14823a().m14327d(str, str2, th);
    }

    /* JADX INFO: renamed from: a */
    private static SalesforceLogger m14823a() {
        return SalesforceLogger.m14312a("SmartStore", SalesforceSDKManager.m14403a().m14446k());
    }
}
