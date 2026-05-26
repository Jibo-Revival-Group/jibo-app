.class abstract Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent;
.super Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;
.source "LoggingEvent.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$SearchEvent;,
        Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$ArticleListEvent;,
        Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$ViewStateEvent;,
        Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$CategoryEvent;,
        Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$ArticleEvent;,
        Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$DataCategoryEvent;,
        Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$KnowledgeEvent;,
        Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$EventTypeEvent;
    }
.end annotation


# instance fields
.field final mKbBasicInfo:Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "kbBasicInfo"
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 36
    const-string v0, "KB"

    invoke-direct {p0, v0, p2}, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 37
    iput-object p1, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent;->mKbBasicInfo:Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;

    .line 38
    return-void
.end method
