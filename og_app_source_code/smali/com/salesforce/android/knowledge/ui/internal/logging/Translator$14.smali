.class Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$14;
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
    .line 168
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$14;->c:Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;

    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$14;->a:Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;

    iput-object p3, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$14;->b:Ljava/lang/String;

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

    .line 171
    const-string v0, "KNOWLEDGE_UI_DATA_CATEGORY_LABEL"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    .line 172
    new-instance v0, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$ArticleListEvent;

    iget-object v1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$14;->a:Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$14;->b:Ljava/lang/String;

    const-string v3, "showMore_selected"

    move-object v5, v4

    invoke-direct/range {v0 .. v6}, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$ArticleListEvent;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method
