package com.salesforce.android.knowledge.ui;

import com.salesforce.android.service.common.analytics.internal.InternalServiceAnalytics;

public final class KnowledgeUIAnalyticsEmit {
   public static void a() {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_RESPONSE_CLOSED");
   }

   public static void a(KnowledgeScene var0, KnowledgeScene var1) {
      InternalServiceAnalytics.a(
         "KNOWLEDGE_UI_USER_NAVIGATE_BACK", "KNOWLEDGE_UI_DATA_KNOWLEDGE_FROM_SCENE", var0, "KNOWLEDGE_UI_DATA_KNOWLEDGE_TO_SCENE", var1
      );
   }

   public static void a(CharSequence var0) {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_USER_INPUT_SEARCH_TERM", "KNOWLEDGE_UI_DATA_SEARCH_TERM", var0);
   }

   public static void a(String var0, String var1) {
      InternalServiceAnalytics.a(
         "KNOWLEDGE_UI_RESPONSE_COLLAPSED_CATEGORY_HEADER", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", var0, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", var1
      );
   }

   public static void a(String var0, String var1, String var2, Boolean var3, Boolean var4) {
      InternalServiceAnalytics.a(
         "KNOWLEDGE_UI_USER_INITIALIZE_CLIENT",
         "KNOWLEDGE_UI_DATA_COMMUNITY_URL",
         var0,
         "KNOWLEDGE_UI_DATA_CATEGORY_GROUP_NAME",
         var1,
         "KNOWLEDGE_UI_DATA_ROOT_CATEGORY_NAME",
         var2,
         "KNOWLEDGE_UI_DATA_IS_CORE_CLIENT_PROVIDED",
         var3,
         "KNOWLEDGE_UI_DATA_IS_IMAGE_PROVIDER_PRESENT",
         var4
      );
   }

   public static void b() {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_RESPONSE_INITIALIZED_CLIENT");
   }

   public static void b(String var0, String var1) {
      InternalServiceAnalytics.a(
         "KNOWLEDGE_UI_RESPONSE_EXPANDED_CATEGORY_HEADER", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", var0, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", var1
      );
   }

   public static void c() {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_RESPONSE_LAUNCHED");
   }

   public static void c(String var0, String var1) {
      InternalServiceAnalytics.a(
         "KNOWLEDGE_UI_RESPONSE_LOADED_ARTICLE_DETAIL_VIEW", "KNOWLEDGE_UI_DATA_ARTICLE_ID", var0, "KNOWLEDGE_UI_DATA_ARTICLE_TITLE", var1
      );
   }

   public static void d() {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_RESPONSE_LOADED_SEARCH_RESULT");
   }

   public static void d(String var0, String var1) {
      InternalServiceAnalytics.a(
         "KNOWLEDGE_UI_RESPONSE_LOADED_ARTICLE_LIST_VIEW", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", var0, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", var1
      );
   }

   public static void e() {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_RESPONSE_LOADED_SEARCH_VIEW");
   }

   public static void e(String var0, String var1) {
      InternalServiceAnalytics.a(
         "KNOWLEDGE_UI_RESPONSE_LOADED_CATEGORY_DETAIL_VIEW", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", var0, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", var1
      );
   }

   public static void f() {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_RESPONSE_MAXIMIZED");
   }

   public static void f(String var0, String var1) {
      InternalServiceAnalytics.a(
         "KNOWLEDGE_UI_RESPONSE_LOADED_MORE_ARTICLES", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", var0, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", var1
      );
   }

   public static void g() {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_RESPONSE_MINIMIZED");
   }

   public static void g(String var0, String var1) {
      InternalServiceAnalytics.a(
         "KNOWLEDGE_UI_RESPONSE_LOADED_SUPPORT_HOME_VIEW", "KNOWLEDGE_UI_DATA_CATEGORY_GROUP_NAME", var0, "KNOWLEDGE_UI_DATA_ROOT_CATEGORY_NAME", var1
      );
   }

   public static void h() {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_USER_CLEAR_SEARCH_TERM");
   }

   public static void h(String var0, String var1) {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_USER_MAXIMIZE", "KNOWLEDGE_UI_DATA_ARTICLE_ID", var0, "KNOWLEDGE_UI_DATA_ARTICLE_TITLE", var1);
   }

   public static void i() {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_USER_CLOSE");
   }

   public static void i(String var0, String var1) {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_USER_MINIMIZE", "KNOWLEDGE_UI_DATA_ARTICLE_ID", var0, "KNOWLEDGE_UI_DATA_ARTICLE_TITLE", var1);
   }

   public static void j() {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_USER_LAUNCH");
   }

   public static void j(String var0, String var1) {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_USER_SELECT_ARTICLE_DETAILS", "KNOWLEDGE_UI_DATA_ARTICLE_ID", var0, "KNOWLEDGE_UI_DATA_ARTICLE_TITLE", var1);
   }

   public static void k() {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_USER_MOVE_THUMBNAIL");
   }

   public static void k(String var0, String var1) {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_USER_SELECT_ARTICLE_LIST", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", var0, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", var1);
   }

   public static void l() {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_USER_SELECT_SEARCH_VIEW");
   }

   public static void l(String var0, String var1) {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_USER_SELECT_CATEGORY_DETAIL", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", var0, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", var1);
   }

   public static void m(String var0, String var1) {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_USER_SELECT_CATEGORY_HEADER", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", var0, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", var1);
   }

   public static void n(String var0, String var1) {
      InternalServiceAnalytics.a("KNOWLEDGE_UI_USER_SHOW_MORE_ARTICLES", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", var0, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", var1);
   }
}
