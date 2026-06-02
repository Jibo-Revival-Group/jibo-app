package com.salesforce.android.knowledge.p022ui;

import com.salesforce.android.service.common.analytics.internal.InternalServiceAnalytics;

/* JADX INFO: loaded from: classes.dex */
public final class KnowledgeUIAnalyticsEmit {
    /* JADX INFO: renamed from: a */
    public static void m13361a() {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_RESPONSE_CLOSED", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public static void m13364a(String str, String str2) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_RESPONSE_COLLAPSED_CATEGORY_HEADER", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", str, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", str2);
    }

    /* JADX INFO: renamed from: b */
    public static void m13367b(String str, String str2) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_RESPONSE_EXPANDED_CATEGORY_HEADER", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", str, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", str2);
    }

    /* JADX INFO: renamed from: b */
    public static void m13366b() {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_RESPONSE_INITIALIZED_CLIENT", new Object[0]);
    }

    /* JADX INFO: renamed from: c */
    public static void m13368c() {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_RESPONSE_LAUNCHED", new Object[0]);
    }

    /* JADX INFO: renamed from: c */
    public static void m13369c(String str, String str2) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_RESPONSE_LOADED_ARTICLE_DETAIL_VIEW", "KNOWLEDGE_UI_DATA_ARTICLE_ID", str, "KNOWLEDGE_UI_DATA_ARTICLE_TITLE", str2);
    }

    /* JADX INFO: renamed from: d */
    public static void m13371d(String str, String str2) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_RESPONSE_LOADED_ARTICLE_LIST_VIEW", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", str, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", str2);
    }

    /* JADX INFO: renamed from: e */
    public static void m13373e(String str, String str2) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_RESPONSE_LOADED_CATEGORY_DETAIL_VIEW", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", str, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", str2);
    }

    /* JADX INFO: renamed from: f */
    public static void m13375f(String str, String str2) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_RESPONSE_LOADED_MORE_ARTICLES", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", str, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", str2);
    }

    /* JADX INFO: renamed from: d */
    public static void m13370d() {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_RESPONSE_LOADED_SEARCH_RESULT", new Object[0]);
    }

    /* JADX INFO: renamed from: e */
    public static void m13372e() {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_RESPONSE_LOADED_SEARCH_VIEW", new Object[0]);
    }

    /* JADX INFO: renamed from: g */
    public static void m13377g(String str, String str2) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_RESPONSE_LOADED_SUPPORT_HOME_VIEW", "KNOWLEDGE_UI_DATA_CATEGORY_GROUP_NAME", str, "KNOWLEDGE_UI_DATA_ROOT_CATEGORY_NAME", str2);
    }

    /* JADX INFO: renamed from: f */
    public static void m13374f() {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_RESPONSE_MAXIMIZED", new Object[0]);
    }

    /* JADX INFO: renamed from: g */
    public static void m13376g() {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_RESPONSE_MINIMIZED", new Object[0]);
    }

    /* JADX INFO: renamed from: h */
    public static void m13378h() {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_USER_CLEAR_SEARCH_TERM", new Object[0]);
    }

    /* JADX INFO: renamed from: i */
    public static void m13380i() {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_USER_CLOSE", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public static void m13365a(String str, String str2, String str3, Boolean bool, Boolean bool2) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_USER_INITIALIZE_CLIENT", "KNOWLEDGE_UI_DATA_COMMUNITY_URL", str, "KNOWLEDGE_UI_DATA_CATEGORY_GROUP_NAME", str2, "KNOWLEDGE_UI_DATA_ROOT_CATEGORY_NAME", str3, "KNOWLEDGE_UI_DATA_IS_CORE_CLIENT_PROVIDED", bool, "KNOWLEDGE_UI_DATA_IS_IMAGE_PROVIDER_PRESENT", bool2);
    }

    /* JADX INFO: renamed from: a */
    public static void m13363a(CharSequence charSequence) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_USER_INPUT_SEARCH_TERM", "KNOWLEDGE_UI_DATA_SEARCH_TERM", charSequence);
    }

    /* JADX INFO: renamed from: j */
    public static void m13382j() {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_USER_LAUNCH", new Object[0]);
    }

    /* JADX INFO: renamed from: h */
    public static void m13379h(String str, String str2) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_USER_MAXIMIZE", "KNOWLEDGE_UI_DATA_ARTICLE_ID", str, "KNOWLEDGE_UI_DATA_ARTICLE_TITLE", str2);
    }

    /* JADX INFO: renamed from: i */
    public static void m13381i(String str, String str2) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_USER_MINIMIZE", "KNOWLEDGE_UI_DATA_ARTICLE_ID", str, "KNOWLEDGE_UI_DATA_ARTICLE_TITLE", str2);
    }

    /* JADX INFO: renamed from: k */
    public static void m13384k() {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_USER_MOVE_THUMBNAIL", new Object[0]);
    }

    /* JADX INFO: renamed from: a */
    public static void m13362a(KnowledgeScene knowledgeScene, KnowledgeScene knowledgeScene2) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_USER_NAVIGATE_BACK", "KNOWLEDGE_UI_DATA_KNOWLEDGE_FROM_SCENE", knowledgeScene, "KNOWLEDGE_UI_DATA_KNOWLEDGE_TO_SCENE", knowledgeScene2);
    }

    /* JADX INFO: renamed from: j */
    public static void m13383j(String str, String str2) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_USER_SELECT_ARTICLE_DETAILS", "KNOWLEDGE_UI_DATA_ARTICLE_ID", str, "KNOWLEDGE_UI_DATA_ARTICLE_TITLE", str2);
    }

    /* JADX INFO: renamed from: k */
    public static void m13385k(String str, String str2) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_USER_SELECT_ARTICLE_LIST", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", str, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", str2);
    }

    /* JADX INFO: renamed from: l */
    public static void m13387l(String str, String str2) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_USER_SELECT_CATEGORY_DETAIL", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", str, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", str2);
    }

    /* JADX INFO: renamed from: m */
    public static void m13388m(String str, String str2) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_USER_SELECT_CATEGORY_HEADER", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", str, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", str2);
    }

    /* JADX INFO: renamed from: l */
    public static void m13386l() {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_USER_SELECT_SEARCH_VIEW", new Object[0]);
    }

    /* JADX INFO: renamed from: n */
    public static void m13389n(String str, String str2) {
        InternalServiceAnalytics.m13722a("KNOWLEDGE_UI_USER_SHOW_MORE_ARTICLES", "KNOWLEDGE_UI_DATA_CATEGORY_LABEL", str, "KNOWLEDGE_UI_DATA_CATEGORY_NAME", str2);
    }
}
