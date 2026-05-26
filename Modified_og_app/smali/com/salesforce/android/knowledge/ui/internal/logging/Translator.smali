.class Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;
.super Ljava/lang/Object;
.source "Translator.java"


# instance fields
.field a:Ljava/lang/String;

.field b:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;->a:Ljava/lang/String;

    .line 40
    iput-object v0, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;->b:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method a(Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;)V
    .locals 2

    .prologue
    .line 44
    const-string v0, "KNOWLEDGE_UI_USER_LAUNCH"

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$1;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    invoke-virtual {p3, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V

    .line 52
    const-string v0, "KNOWLEDGE_UI_RESPONSE_LAUNCHED"

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$2;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$2;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    invoke-virtual {p3, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V

    .line 60
    const-string v0, "KNOWLEDGE_UI_USER_CLOSE"

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$3;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$3;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    invoke-virtual {p3, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V

    .line 68
    const-string v0, "KNOWLEDGE_UI_RESPONSE_EXPANDED_CATEGORY_HEADER"

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$4;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$4;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    invoke-virtual {p3, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V

    .line 77
    const-string v0, "KNOWLEDGE_UI_USER_SELECT_ARTICLE_DETAILS"

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$5;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$5;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    invoke-virtual {p3, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V

    .line 88
    const-string v0, "KNOWLEDGE_UI_RESPONSE_LOADED_ARTICLE_DETAIL_VIEW"

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$6;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$6;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    invoke-virtual {p3, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V

    .line 99
    const-string v0, "KNOWLEDGE_UI_USER_NAVIGATE_BACK"

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$7;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$7;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    invoke-virtual {p3, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V

    .line 110
    const-string v0, "KNOWLEDGE_UI_USER_SELECT_CATEGORY_DETAIL"

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$8;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$8;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    invoke-virtual {p3, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V

    .line 120
    const-string v0, "KNOWLEDGE_UI_RESPONSE_LOADED_CATEGORY_DETAIL_VIEW"

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$9;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$9;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    invoke-virtual {p3, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V

    .line 130
    const-string v0, "KNOWLEDGE_UI_USER_MINIMIZE"

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$10;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$10;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    invoke-virtual {p3, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V

    .line 140
    const-string v0, "KNOWLEDGE_UI_USER_MAXIMIZE"

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$11;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$11;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    invoke-virtual {p3, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V

    .line 150
    const-string v0, "KNOWLEDGE_UI_USER_SELECT_ARTICLE_LIST"

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$12;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$12;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    invoke-virtual {p3, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V

    .line 159
    const-string v0, "KNOWLEDGE_UI_RESPONSE_LOADED_ARTICLE_LIST_VIEW"

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$13;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$13;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    invoke-virtual {p3, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V

    .line 168
    const-string v0, "KNOWLEDGE_UI_USER_SHOW_MORE_ARTICLES"

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$14;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$14;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    invoke-virtual {p3, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V

    .line 177
    const-string v0, "KNOWLEDGE_UI_RESPONSE_LOADED_MORE_ARTICLES"

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$15;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$15;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    invoke-virtual {p3, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V

    .line 186
    const-string v0, "KNOWLEDGE_UI_USER_INPUT_SEARCH_TERM"

    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$16;

    invoke-direct {v1, p0, p1, p2}, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$16;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V

    invoke-virtual {p3, v0, v1}, Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;->a(Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;)V

    .line 192
    return-void
.end method
