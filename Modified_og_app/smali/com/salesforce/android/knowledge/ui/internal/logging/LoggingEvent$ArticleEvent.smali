.class Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$ArticleEvent;
.super Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$EventTypeEvent;
.source "LoggingEvent.java"


# annotations
.annotation runtime Lcom/salesforce/android/service/common/liveagentlogging/BatchedEvent;
    a = "articleEvents"
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "ArticleEvent"
.end annotation


# instance fields
.field final mArticleId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "articleId"
    .end annotation
.end field

.field final mArticleName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "articleName"
    .end annotation
.end field

.field final mParentCategory:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "parentCategory"
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 81
    invoke-direct {p0, p1, p2, p3}, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$EventTypeEvent;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    iput-object p4, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$ArticleEvent;->mParentCategory:Ljava/lang/String;

    .line 83
    iput-object p5, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$ArticleEvent;->mArticleId:Ljava/lang/String;

    .line 84
    iput-object p6, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$ArticleEvent;->mArticleName:Ljava/lang/String;

    .line 85
    return-void
.end method
