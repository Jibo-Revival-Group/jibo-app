.class public Lcom/salesforce/android/cases/ui/internal/logging/CaseDataEnteredEvent;
.super Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;
.source "CaseDataEnteredEvent.java"


# annotations
.annotation runtime Lcom/salesforce/android/service/common/liveagentlogging/BatchedEvent;
    a = "caseDataEnteredEvents"
.end annotation


# instance fields
.field private final caseBasicInfo:Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "caseBasicInfo"
    .end annotation
.end field

.field private final wordCount:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "wordCount"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 27
    const-string v0, "case"

    invoke-direct {p0, v0, p2}, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 28
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/logging/CaseDataEnteredEvent;->caseBasicInfo:Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;

    .line 29
    iput p3, p0, Lcom/salesforce/android/cases/ui/internal/logging/CaseDataEnteredEvent;->wordCount:I

    .line 30
    return-void
.end method
