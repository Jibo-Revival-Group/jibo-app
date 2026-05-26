.class Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$DataCategoryEvent;
.super Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$EventTypeEvent;
.source "LoggingEvent.java"


# annotations
.annotation runtime Lcom/salesforce/android/service/common/liveagentlogging/BatchedEvent;
    a = "dataCategoryEvents"
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "DataCategoryEvent"
.end annotation


# instance fields
.field final mCategoryName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "dataCategoryName"
    .end annotation
.end field


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 69
    invoke-direct {p0, p1, p2, p3}, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$EventTypeEvent;-><init>(Lcom/salesforce/android/knowledge/ui/internal/logging/KbBasicInfo;Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    iput-object p4, p0, Lcom/salesforce/android/knowledge/ui/internal/logging/LoggingEvent$DataCategoryEvent;->mCategoryName:Ljava/lang/String;

    .line 71
    return-void
.end method
