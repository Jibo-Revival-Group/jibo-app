.class public Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;
.super Ljava/lang/Object;
.source "CaseBasicInfo.java"


# instance fields
.field private final caseListName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "caseListName"
    .end annotation
.end field

.field private final communityUrlString:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "communityUrlString"
    .end annotation
.end field

.field private final createCaseActionName:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "createCaseActionName"
    .end annotation
.end field

.field private final userType:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "userType"
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput-object p1, p0, Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;->communityUrlString:Ljava/lang/String;

    .line 47
    iput-object p2, p0, Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;->caseListName:Ljava/lang/String;

    .line 48
    iput-object p3, p0, Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;->createCaseActionName:Ljava/lang/String;

    .line 49
    iput-object p4, p0, Lcom/salesforce/android/cases/ui/internal/logging/CaseBasicInfo;->userType:Ljava/lang/String;

    .line 50
    return-void
.end method
