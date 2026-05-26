.class Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$7;
.super Ljava/lang/Object;
.source "Translator.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook$Translation;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;->a(Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;Lcom/salesforce/android/knowledge/ui/internal/logging/AnalyticsHook;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;

.field final synthetic b:Ljava/lang/String;

.field final synthetic c:Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 99
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$7;->c:Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;

    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$7;->a:Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;

    iput-object p3, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$7;->b:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;Ljava/util/Map;)Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)",
            "Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 102
    const-string v0, "KNOWLEDGE_UI_DATA_KNOWLEDGE_FROM_SCENE"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    sget-object v1, Lcom/salesforce/android/knowledge/ui/KnowledgeScene;->SCENE_ARTICLE_DETAIL:Lcom/salesforce/android/knowledge/ui/KnowledgeScene;

    if-ne v0, v1, :cond_0

    .line 103
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$ArticleEvent;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$7;->a:Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$7;->b:Ljava/lang/String;

    const-string v3, "article_dismissed"

    iget-object v5, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$7;->c:Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;

    iget-object v5, v5, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;->a:Ljava/lang/String;

    iget-object v6, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$7;->c:Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;

    iget-object v6, v6, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;->b:Ljava/lang/String;

    invoke-direct/range {v0 .. v6}, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$ArticleEvent;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    :goto_0
    return-object v0

    :cond_0
    move-object v0, v4

    goto :goto_0
.end method
