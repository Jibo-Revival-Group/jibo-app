.class public Lcom/salesforce/android/cases/ui/internal/logging/CaseNotificationEvent;
.super Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;
.source "CaseNotificationEvent.java"


# annotations
.annotation runtime Lcom/salesforce/android/service/common/liveagentlogging/BatchedEvent;
    a = "caseNotificationEvents"
.end annotation


# instance fields
.field private final caseBasicInfo:Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "caseBasicInfo"
    .end annotation
.end field

.field private final caseId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "sender"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 46
    const-string v0, "case"

    invoke-direct {p0, v0, p2}, Lcom/salesforce/android/service/common/liveagentlogging/event/BaseEvent;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/logging/CaseNotificationEvent;->caseBasicInfo:Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;

    .line 48
    iput-object p3, p0, Lcom/salesforce/android/cases/ui/internal/logging/CaseNotificationEvent;->caseId:Ljava/lang/String;

    .line 49
    return-void
.end method
