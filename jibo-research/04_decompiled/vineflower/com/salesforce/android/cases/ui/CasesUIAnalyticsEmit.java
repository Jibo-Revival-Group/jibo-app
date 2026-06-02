package com.salesforce.android.cases.ui;

import com.salesforce.android.service.common.analytics.internal.InternalServiceAnalytics;

public final class CasesUIAnalyticsEmit {
   public static void a(String var0, String var1, String var2, String var3, Integer var4) {
      InternalServiceAnalytics.a(
         "CASE_USER_EXIT_PUBLISHER_WITH_DATA_ENTERED_EVENT",
         "communityUrl",
         var0,
         "caseListname",
         var1,
         "createCaseActionName",
         var2,
         "userType",
         var3,
         "wordCount",
         var4
      );
   }

   public static void a(String var0, String var1, String var2, String var3, String var4) {
      InternalServiceAnalytics.a(
         "CASE_USER_CASE_PUBLISHER_LAYOUT_EVENT", "communityUrl", var0, "caseListname", var1, "createCaseActionName", var2, "userType", var3, "eventType", var4
      );
   }

   public static void a(String var0, String var1, String var2, String var3, String var4, Integer var5) {
      InternalServiceAnalytics.a(
         "CASE_USER_CASE_LIST_EVENT",
         "communityUrl",
         var0,
         "caseListname",
         var1,
         "createCaseActionName",
         var2,
         "userType",
         var3,
         "eventType",
         var4,
         "caseCount",
         var5
      );
   }

   public static void a(String var0, String var1, String var2, String var3, String var4, String var5) {
      InternalServiceAnalytics.a(
         "CASE_RESPONSE_MESSAGE_EVENT",
         "communityUrl",
         var0,
         "caseListname",
         var1,
         "createCaseActionName",
         var2,
         "userType",
         var3,
         "sender",
         var4,
         "caseId",
         var5
      );
   }

   public static void a(String var0, String var1, String var2, String var3, String var4, String var5, String var6, Integer var7) {
      InternalServiceAnalytics.a(
         "CASE_USER_CASE_SUBMISSION_EVENT",
         "communityUrl",
         var0,
         "caseListname",
         var1,
         "createCaseActionName",
         var2,
         "userType",
         var3,
         "eventType",
         var4,
         "result",
         var5,
         "caseId",
         var6,
         "wordCount",
         var7
      );
   }

   public static void b(String var0, String var1, String var2, String var3, String var4, String var5) {
      InternalServiceAnalytics.a(
         "CASE_RESPONSE_NOTIFICATION_EVENT",
         "communityUrl",
         var0,
         "caseListname",
         var1,
         "createCaseActionName",
         var2,
         "userType",
         var3,
         "caseId",
         var4,
         "subject",
         var5
      );
   }

   public static void c(String var0, String var1, String var2, String var3, String var4, String var5) {
      InternalServiceAnalytics.a(
         "CASE_USER_CASE_DETAIL_EVENT",
         "communityUrl",
         var0,
         "caseListname",
         var1,
         "createCaseActionName",
         var2,
         "userType",
         var3,
         "eventType",
         var4,
         "caseId",
         var5
      );
   }
}
