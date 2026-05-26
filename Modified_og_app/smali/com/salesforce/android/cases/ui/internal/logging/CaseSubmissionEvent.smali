.class public Lcom/salesforce/android/cases/ui/internal/logging/CaseSubmissionEvent;
.super Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;
.source "CaseSubmissionEvent.java"


# annotations
.annotation runtime Lcom/salesforce/android/service/common/liveagentlogging/BatchedEvent;
    a = "caseSubmissionEvents"
.end annotation


# instance fields
.field private final caseBasicInfo:Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "caseBasicInfo"
    .end annotation
.end field

.field private final caseId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "caseId"
    .end annotation
.end field

.field private final eventType:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "eventType"
    .end annotation
.end field

.field private final result:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "result"
    .end annotation
.end field

.field private final wordCount:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "wordCount"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 49
    const-string v0, "case"

    invoke-direct {p0, v0, p2}, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/logging/CaseSubmissionEvent;->caseBasicInfo:Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;

    .line 51
    iput-object p3, p0, Lcom/salesforce/android/cases/ui/internal/logging/CaseSubmissionEvent;->eventType:Ljava/lang/String;

    .line 52
    iput-object p4, p0, Lcom/salesforce/android/cases/ui/internal/logging/CaseSubmissionEvent;->result:Ljava/lang/String;

    .line 53
    iput-object p5, p0, Lcom/salesforce/android/cases/ui/internal/logging/CaseSubmissionEvent;->caseId:Ljava/lang/String;

    .line 54
    iput p6, p0, Lcom/salesforce/android/cases/ui/internal/logging/CaseSubmissionEvent;->wordCount:I

    .line 55
    return-void
.end method
