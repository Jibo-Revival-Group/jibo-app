.class public final Lcom/salesforce/android/knowledge/ui/KnowledgeUIAnalyticsEmit;
.super Ljava/lang/Object;
.source "KnowledgeUIAnalyticsEmit.java"


# direct methods
.method public static a()V
    .locals 2

    .prologue
    .line 17
    const-string v0, "KNOWLEDGE_UI_RESPONSE_CLOSED"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 18
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/ui/KnowledgeScene;Lcom/salesforce/android/knowledge/ui/KnowledgeScene;)V
    .locals 4

    .prologue
    .line 114
    const-string v0, "KNOWLEDGE_UI_USER_NAVIGATE_BACK"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_KNOWLEDGE_FROM_SCENE"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "KNOWLEDGE_UI_DATA_KNOWLEDGE_TO_SCENE"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 115
    return-void
.end method

.method public static a(Ljava/lang/CharSequence;)V
    .locals 4

    .prologue
    .line 93
    const-string v0, "KNOWLEDGE_UI_USER_INPUT_SEARCH_TERM"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_SEARCH_TERM"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 94
    return-void
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 22
    const-string v0, "KNOWLEDGE_UI_RESPONSE_COLLAPSED_CATEGORY_HEADER"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_LABEL"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_NAME"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 23
    return-void
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;)V
    .locals 4

    .prologue
    .line 89
    const-string v0, "KNOWLEDGE_UI_USER_INITIALIZE_CLIENT"

    const/16 v1, 0xa

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_COMMUNITY_URL"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_GROUP_NAME"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    const/4 v2, 0x4

    const-string v3, "KNOWLEDGE_UI_DATA_ROOT_CATEGORY_NAME"

    aput-object v3, v1, v2

    const/4 v2, 0x5

    aput-object p2, v1, v2

    const/4 v2, 0x6

    const-string v3, "KNOWLEDGE_UI_DATA_IS_CORE_CLIENT_PROVIDED"

    aput-object v3, v1, v2

    const/4 v2, 0x7

    aput-object p3, v1, v2

    const/16 v2, 0x8

    const-string v3, "KNOWLEDGE_UI_DATA_IS_IMAGE_PROVIDER_PRESENT"

    aput-object v3, v1, v2

    const/16 v2, 0x9

    aput-object p4, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 90
    return-void
.end method

.method public static b()V
    .locals 2

    .prologue
    .line 31
    const-string v0, "KNOWLEDGE_UI_RESPONSE_INITIALIZED_CLIENT"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 32
    return-void
.end method

.method public static b(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 27
    const-string v0, "KNOWLEDGE_UI_RESPONSE_EXPANDED_CATEGORY_HEADER"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_LABEL"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_NAME"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 28
    return-void
.end method

.method public static c()V
    .locals 2

    .prologue
    .line 35
    const-string v0, "KNOWLEDGE_UI_RESPONSE_LAUNCHED"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 36
    return-void
.end method

.method public static c(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 40
    const-string v0, "KNOWLEDGE_UI_RESPONSE_LOADED_ARTICLE_DETAIL_VIEW"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_ARTICLE_ID"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "KNOWLEDGE_UI_DATA_ARTICLE_TITLE"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 41
    return-void
.end method

.method public static d()V
    .locals 2

    .prologue
    .line 58
    const-string v0, "KNOWLEDGE_UI_RESPONSE_LOADED_SEARCH_RESULT"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 59
    return-void
.end method

.method public static d(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 45
    const-string v0, "KNOWLEDGE_UI_RESPONSE_LOADED_ARTICLE_LIST_VIEW"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_LABEL"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_NAME"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 46
    return-void
.end method

.method public static e()V
    .locals 2

    .prologue
    .line 62
    const-string v0, "KNOWLEDGE_UI_RESPONSE_LOADED_SEARCH_VIEW"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 63
    return-void
.end method

.method public static e(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 50
    const-string v0, "KNOWLEDGE_UI_RESPONSE_LOADED_CATEGORY_DETAIL_VIEW"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_LABEL"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_NAME"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 51
    return-void
.end method

.method public static f()V
    .locals 2

    .prologue
    .line 71
    const-string v0, "KNOWLEDGE_UI_RESPONSE_MAXIMIZED"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 72
    return-void
.end method

.method public static f(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 54
    const-string v0, "KNOWLEDGE_UI_RESPONSE_LOADED_MORE_ARTICLES"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_LABEL"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_NAME"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 55
    return-void
.end method

.method public static g()V
    .locals 2

    .prologue
    .line 75
    const-string v0, "KNOWLEDGE_UI_RESPONSE_MINIMIZED"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 76
    return-void
.end method

.method public static g(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 67
    const-string v0, "KNOWLEDGE_UI_RESPONSE_LOADED_SUPPORT_HOME_VIEW"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_GROUP_NAME"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "KNOWLEDGE_UI_DATA_ROOT_CATEGORY_NAME"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 68
    return-void
.end method

.method public static h()V
    .locals 2

    .prologue
    .line 79
    const-string v0, "KNOWLEDGE_UI_USER_CLEAR_SEARCH_TERM"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 80
    return-void
.end method

.method public static h(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 101
    const-string v0, "KNOWLEDGE_UI_USER_MAXIMIZE"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_ARTICLE_ID"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "KNOWLEDGE_UI_DATA_ARTICLE_TITLE"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 102
    return-void
.end method

.method public static i()V
    .locals 2

    .prologue
    .line 83
    const-string v0, "KNOWLEDGE_UI_USER_CLOSE"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 84
    return-void
.end method

.method public static i(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 105
    const-string v0, "KNOWLEDGE_UI_USER_MINIMIZE"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_ARTICLE_ID"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "KNOWLEDGE_UI_DATA_ARTICLE_TITLE"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 106
    return-void
.end method

.method public static j()V
    .locals 2

    .prologue
    .line 97
    const-string v0, "KNOWLEDGE_UI_USER_LAUNCH"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 98
    return-void
.end method

.method public static j(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 118
    const-string v0, "KNOWLEDGE_UI_USER_SELECT_ARTICLE_DETAILS"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_ARTICLE_ID"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "KNOWLEDGE_UI_DATA_ARTICLE_TITLE"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 119
    return-void
.end method

.method public static k()V
    .locals 2

    .prologue
    .line 109
    const-string v0, "KNOWLEDGE_UI_USER_MOVE_THUMBNAIL"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 110
    return-void
.end method

.method public static k(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 122
    const-string v0, "KNOWLEDGE_UI_USER_SELECT_ARTICLE_LIST"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_LABEL"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_NAME"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 123
    return-void
.end method

.method public static l()V
    .locals 2

    .prologue
    .line 134
    const-string v0, "KNOWLEDGE_UI_USER_SELECT_SEARCH_VIEW"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 135
    return-void
.end method

.method public static l(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 126
    const-string v0, "KNOWLEDGE_UI_USER_SELECT_CATEGORY_DETAIL"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_LABEL"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_NAME"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 127
    return-void
.end method

.method public static m(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 130
    const-string v0, "KNOWLEDGE_UI_USER_SELECT_CATEGORY_HEADER"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_LABEL"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_NAME"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 131
    return-void
.end method

.method public static n(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 138
    const-string v0, "KNOWLEDGE_UI_USER_SHOW_MORE_ARTICLES"

    const/4 v1, 0x4

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_LABEL"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    const/4 v2, 0x2

    const-string v3, "KNOWLEDGE_UI_DATA_CATEGORY_NAME"

    aput-object v3, v1, v2

    const/4 v2, 0x3

    aput-object p1, v1, v2

    invoke-static {v0, v1}, Lcom/salesforce/android/service/common/analytics/internal/InternalServiceAnalytics;->a(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 139
    return-void
.end method
