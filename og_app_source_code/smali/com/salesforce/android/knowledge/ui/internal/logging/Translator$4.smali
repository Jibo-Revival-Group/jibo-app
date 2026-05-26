.class Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$4;
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
    .line 68
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$4;->c:Lcom/salesforce/android/knowledge/ui/internal/logging/Translator;

    iput-object p2, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$4;->a:Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;

    iput-object p3, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$4;->b:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;Ljava/util/Map;)Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;
    .locals 5
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
    .line 71
    const-string v0, "KNOWLEDGE_UI_DATA_CATEGORY_LABEL"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 72
    new-instance v1, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$DataCategoryEvent;

    iget-object v2, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$4;->a:Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;

    iget-object v3, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/Translator$4;->b:Ljava/lang/String;

    const-string v4, "dataCategory_selected"

    invoke-direct {v1, v2, v3, v4, v0}, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$DataCategoryEvent;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v1
.end method
