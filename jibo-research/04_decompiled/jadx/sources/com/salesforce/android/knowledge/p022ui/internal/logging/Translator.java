package com.salesforce.android.knowledge.p022ui.internal.logging;

import com.salesforce.android.knowledge.p022ui.KnowledgeScene;
import com.salesforce.android.knowledge.p022ui.internal.logging.AnalyticsHook;
import com.salesforce.android.knowledge.p022ui.internal.logging.LoggingEvent;
import com.salesforce.android.service.common.liveagentlogging.event.BaseEvent;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class Translator {

    /* JADX INFO: renamed from: a */
    String f13307a = null;

    /* JADX INFO: renamed from: b */
    String f13308b = null;

    Translator() {
    }

    /* JADX INFO: renamed from: a */
    void m13606a(final KbBasicInfo kbBasicInfo, final String str, AnalyticsHook analyticsHook) {
        analyticsHook.m13588a("KNOWLEDGE_UI_USER_LAUNCH", new AnalyticsHook.Translation() { // from class: com.salesforce.android.knowledge.ui.internal.logging.Translator.1
            @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Translation
            /* JADX INFO: renamed from: a */
            public BaseEvent mo13591a(String str2, Map<String, Object> map) {
                return new LoggingEvent.KnowledgeEvent(kbBasicInfo, str, "kb_launched");
            }
        });
        analyticsHook.m13588a("KNOWLEDGE_UI_RESPONSE_LAUNCHED", new AnalyticsHook.Translation() { // from class: com.salesforce.android.knowledge.ui.internal.logging.Translator.2
            @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Translation
            /* JADX INFO: renamed from: a */
            public BaseEvent mo13591a(String str2, Map<String, Object> map) {
                return new LoggingEvent.KnowledgeEvent(kbBasicInfo, str, "kb_loaded");
            }
        });
        analyticsHook.m13588a("KNOWLEDGE_UI_USER_CLOSE", new AnalyticsHook.Translation() { // from class: com.salesforce.android.knowledge.ui.internal.logging.Translator.3
            @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Translation
            /* JADX INFO: renamed from: a */
            public BaseEvent mo13591a(String str2, Map<String, Object> map) {
                return new LoggingEvent.KnowledgeEvent(kbBasicInfo, str, "kb_dismissed");
            }
        });
        analyticsHook.m13588a("KNOWLEDGE_UI_RESPONSE_EXPANDED_CATEGORY_HEADER", new AnalyticsHook.Translation() { // from class: com.salesforce.android.knowledge.ui.internal.logging.Translator.4
            @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Translation
            /* JADX INFO: renamed from: a */
            public BaseEvent mo13591a(String str2, Map<String, Object> map) {
                return new LoggingEvent.DataCategoryEvent(kbBasicInfo, str, "dataCategory_selected", (String) map.get("KNOWLEDGE_UI_DATA_CATEGORY_LABEL"));
            }
        });
        analyticsHook.m13588a("KNOWLEDGE_UI_USER_SELECT_ARTICLE_DETAILS", new AnalyticsHook.Translation() { // from class: com.salesforce.android.knowledge.ui.internal.logging.Translator.5
            @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Translation
            /* JADX INFO: renamed from: a */
            public BaseEvent mo13591a(String str2, Map<String, Object> map) {
                Translator.this.f13307a = (String) map.get("KNOWLEDGE_UI_DATA_ARTICLE_ID");
                Translator.this.f13308b = (String) map.get("KNOWLEDGE_UI_DATA_ARTICLE_TITLE");
                return new LoggingEvent.ArticleEvent(kbBasicInfo, str, "article_selected", null, Translator.this.f13307a, Translator.this.f13308b);
            }
        });
        analyticsHook.m13588a("KNOWLEDGE_UI_RESPONSE_LOADED_ARTICLE_DETAIL_VIEW", new AnalyticsHook.Translation() { // from class: com.salesforce.android.knowledge.ui.internal.logging.Translator.6
            @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Translation
            /* JADX INFO: renamed from: a */
            public BaseEvent mo13591a(String str2, Map<String, Object> map) {
                return new LoggingEvent.ArticleEvent(kbBasicInfo, str, "article_loaded", null, (String) map.get("KNOWLEDGE_UI_DATA_ARTICLE_ID"), (String) map.get("KNOWLEDGE_UI_DATA_ARTICLE_TITLE"));
            }
        });
        analyticsHook.m13588a("KNOWLEDGE_UI_USER_NAVIGATE_BACK", new AnalyticsHook.Translation() { // from class: com.salesforce.android.knowledge.ui.internal.logging.Translator.7
            @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Translation
            /* JADX INFO: renamed from: a */
            public BaseEvent mo13591a(String str2, Map<String, Object> map) {
                if (map.get("KNOWLEDGE_UI_DATA_KNOWLEDGE_FROM_SCENE") == KnowledgeScene.SCENE_ARTICLE_DETAIL) {
                    return new LoggingEvent.ArticleEvent(kbBasicInfo, str, "article_dismissed", null, Translator.this.f13307a, Translator.this.f13308b);
                }
                return null;
            }
        });
        analyticsHook.m13588a("KNOWLEDGE_UI_USER_SELECT_CATEGORY_DETAIL", new AnalyticsHook.Translation() { // from class: com.salesforce.android.knowledge.ui.internal.logging.Translator.8
            @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Translation
            /* JADX INFO: renamed from: a */
            public BaseEvent mo13591a(String str2, Map<String, Object> map) {
                return new LoggingEvent.CategoryEvent(kbBasicInfo, str, "category_selected", (String) map.get("KNOWLEDGE_UI_DATA_CATEGORY_LABEL"), null);
            }
        });
        analyticsHook.m13588a("KNOWLEDGE_UI_RESPONSE_LOADED_CATEGORY_DETAIL_VIEW", new AnalyticsHook.Translation() { // from class: com.salesforce.android.knowledge.ui.internal.logging.Translator.9
            @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Translation
            /* JADX INFO: renamed from: a */
            public BaseEvent mo13591a(String str2, Map<String, Object> map) {
                return new LoggingEvent.CategoryEvent(kbBasicInfo, str, "category_loaded", (String) map.get("KNOWLEDGE_UI_DATA_CATEGORY_LABEL"), null);
            }
        });
        analyticsHook.m13588a("KNOWLEDGE_UI_USER_MINIMIZE", new AnalyticsHook.Translation() { // from class: com.salesforce.android.knowledge.ui.internal.logging.Translator.10
            @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Translation
            /* JADX INFO: renamed from: a */
            public BaseEvent mo13591a(String str2, Map<String, Object> map) {
                return new LoggingEvent.ViewStateEvent(kbBasicInfo, str, "minimized", (String) map.get("KNOWLEDGE_UI_DATA_ARTICLE_ID"), (String) map.get("KNOWLEDGE_UI_DATA_ARTICLE_TITLE"));
            }
        });
        analyticsHook.m13588a("KNOWLEDGE_UI_USER_MAXIMIZE", new AnalyticsHook.Translation() { // from class: com.salesforce.android.knowledge.ui.internal.logging.Translator.11
            @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Translation
            /* JADX INFO: renamed from: a */
            public BaseEvent mo13591a(String str2, Map<String, Object> map) {
                return new LoggingEvent.ViewStateEvent(kbBasicInfo, str, "maximized", (String) map.get("KNOWLEDGE_UI_DATA_ARTICLE_ID"), (String) map.get("KNOWLEDGE_UI_DATA_ARTICLE_TITLE"));
            }
        });
        analyticsHook.m13588a("KNOWLEDGE_UI_USER_SELECT_ARTICLE_LIST", new AnalyticsHook.Translation() { // from class: com.salesforce.android.knowledge.ui.internal.logging.Translator.12
            @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Translation
            /* JADX INFO: renamed from: a */
            public BaseEvent mo13591a(String str2, Map<String, Object> map) {
                return new LoggingEvent.ArticleListEvent(kbBasicInfo, str, "articleList_selected", null, null, (String) map.get("KNOWLEDGE_UI_DATA_CATEGORY_LABEL"));
            }
        });
        analyticsHook.m13588a("KNOWLEDGE_UI_RESPONSE_LOADED_ARTICLE_LIST_VIEW", new AnalyticsHook.Translation() { // from class: com.salesforce.android.knowledge.ui.internal.logging.Translator.13
            @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Translation
            /* JADX INFO: renamed from: a */
            public BaseEvent mo13591a(String str2, Map<String, Object> map) {
                return new LoggingEvent.ArticleListEvent(kbBasicInfo, str, "articleList_loaded", null, null, (String) map.get("KNOWLEDGE_UI_DATA_CATEGORY_LABEL"));
            }
        });
        analyticsHook.m13588a("KNOWLEDGE_UI_USER_SHOW_MORE_ARTICLES", new AnalyticsHook.Translation() { // from class: com.salesforce.android.knowledge.ui.internal.logging.Translator.14
            @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Translation
            /* JADX INFO: renamed from: a */
            public BaseEvent mo13591a(String str2, Map<String, Object> map) {
                return new LoggingEvent.ArticleListEvent(kbBasicInfo, str, "showMore_selected", null, null, (String) map.get("KNOWLEDGE_UI_DATA_CATEGORY_LABEL"));
            }
        });
        analyticsHook.m13588a("KNOWLEDGE_UI_RESPONSE_LOADED_MORE_ARTICLES", new AnalyticsHook.Translation() { // from class: com.salesforce.android.knowledge.ui.internal.logging.Translator.15
            @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Translation
            /* JADX INFO: renamed from: a */
            public BaseEvent mo13591a(String str2, Map<String, Object> map) {
                return new LoggingEvent.ArticleListEvent(kbBasicInfo, str, "showMore_loaded", null, null, (String) map.get("KNOWLEDGE_UI_DATA_CATEGORY_LABEL"));
            }
        });
        analyticsHook.m13588a("KNOWLEDGE_UI_USER_INPUT_SEARCH_TERM", new AnalyticsHook.Translation() { // from class: com.salesforce.android.knowledge.ui.internal.logging.Translator.16
            @Override // com.salesforce.android.knowledge.ui.internal.logging.AnalyticsHook.Translation
            /* JADX INFO: renamed from: a */
            public BaseEvent mo13591a(String str2, Map<String, Object> map) {
                return new LoggingEvent.SearchEvent(kbBasicInfo, str);
            }
        });
    }
}
