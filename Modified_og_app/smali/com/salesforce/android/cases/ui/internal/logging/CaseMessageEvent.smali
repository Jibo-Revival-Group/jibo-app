.class public Lcom/salesforce/android/cases/ui/internal/logging/CaseMessageEvent;
.super Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;
.source "CaseMessageEvent.java"


# annotations
.annotation runtime Lcom/salesforce/android/service/common/liveagentlogging/BatchedEvent;
    a = "caseMessageEvents"
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

.field private final sender:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "sender"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 47
    const-string v0, "case"

    invoke-direct {p0, v0, p2}, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/logging/CaseMessageEvent;->caseBasicInfo:Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;

    .line 49
    iput-object p3, p0, Lcom/salesforce/android/cases/ui/internal/logging/CaseMessageEvent;->sender:Ljava/lang/String;

    .line 50
    iput-object p4, p0, Lcom/salesforce/android/cases/ui/internal/logging/CaseMessageEvent;->caseId:Ljava/lang/String;

    .line 51
    return-void
.end method
