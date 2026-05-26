.class Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$ArticleListEvent;
.super Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$EventTypeEvent;
.source "LoggingEvent.java"


# annotations
.annotation runtime Lcom/salesforce/android/service/common/liveagentlogging/BatchedEvent;
    a = "articleListEvents"
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ArticleListEvent"
.end annotation


# instance fields
.field final mCurrentView:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "currentView"
    .end annotation
.end field

.field final mDataCategory:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "dataCategory"
    .end annotation
.end field

.field final mPreviousView:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "previousView"
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 121
    invoke-direct {p0, p1, p2, p3}, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$EventTypeEvent;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    iput-object p4, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$ArticleListEvent;->mCurrentView:Ljava/lang/String;

    .line 123
    iput-object p5, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$ArticleListEvent;->mPreviousView:Ljava/lang/String;

    .line 124
    iput-object p6, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$ArticleListEvent;->mDataCategory:Ljava/lang/String;

    .line 125
    return-void
.end method
