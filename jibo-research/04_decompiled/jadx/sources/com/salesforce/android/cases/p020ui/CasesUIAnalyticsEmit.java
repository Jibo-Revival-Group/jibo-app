package com.salesforce.android.cases.p020ui;

import com.salesforce.android.service.common.analytics.internal.InternalServiceAnalytics;

/* JADX INFO: loaded from: classes.dex */
public final class CasesUIAnalyticsEmit {
    /* JADX INFO: renamed from: a */
    public static void m12731a(String str, String str2, String str3, String str4, String str5, String str6) {
        InternalServiceAnalytics.m13722a("CASE_RESPONSE_MESSAGE_EVENT", "communityUrl", str, "caseListname", str2, "createCaseActionName", str3, "userType", str4, "sender", str5, "caseId", str6);
    }

    /* JADX INFO: renamed from: b */
    public static void m12733b(String str, String str2, String str3, String str4, String str5, String str6) {
        InternalServiceAnalytics.m13722a("CASE_RESPONSE_NOTIFICATION_EVENT", "communityUrl", str, "caseListname", str2, "createCaseActionName", str3, "userType", str4, "caseId", str5, "subject", str6);
    }

    /* JADX INFO: renamed from: c */
    public static void m12734c(String str, String str2, String str3, String str4, String str5, String str6) {
        InternalServiceAnalytics.m13722a("CASE_USER_CASE_DETAIL_EVENT", "communityUrl", str, "caseListname", str2, "createCaseActionName", str3, "userType", str4, "eventType", str5, "caseId", str6);
    }

    /* JADX INFO: renamed from: a */
    public static void m12730a(String str, String str2, String str3, String str4, String str5, Integer num) {
        InternalServiceAnalytics.m13722a("CASE_USER_CASE_LIST_EVENT", "communityUrl", str, "caseListname", str2, "createCaseActionName", str3, "userType", str4, "eventType", str5, "caseCount", num);
    }

    /* JADX INFO: renamed from: a */
    public static void m12729a(String str, String str2, String str3, String str4, String str5) {
        InternalServiceAnalytics.m13722a("CASE_USER_CASE_PUBLISHER_LAYOUT_EVENT", "communityUrl", str, "caseListname", str2, "createCaseActionName", str3, "userType", str4, "eventType", str5);
    }

    /* JADX INFO: renamed from: a */
    public static void m12732a(String str, String str2, String str3, String str4, String str5, String str6, String str7, Integer num) {
        InternalServiceAnalytics.m13722a("CASE_USER_CASE_SUBMISSION_EVENT", "communityUrl", str, "caseListname", str2, "createCaseActionName", str3, "userType", str4, "eventType", str5, "result", str6, "caseId", str7, "wordCount", num);
    }

    /* JADX INFO: renamed from: a */
    public static void m12728a(String str, String str2, String str3, String str4, Integer num) {
        InternalServiceAnalytics.m13722a("CASE_USER_EXIT_PUBLISHER_WITH_DATA_ENTERED_EVENT", "communityUrl", str, "caseListname", str2, "createCaseActionName", str3, "userType", str4, "wordCount", num);
    }
}
