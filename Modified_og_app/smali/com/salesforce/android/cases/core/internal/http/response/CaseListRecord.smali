.class public Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;
.super Ljava/lang/Object;
.source "CaseListRecord.java"


# instance fields
.field private caseNumber:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "CaseNumber"
    .end annotation
.end field

.field private createdDate:Ljava/util/Date;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "CreatedDate"
    .end annotation
.end field

.field private feeds:Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "Feeds"
    .end annotation
.end field

.field private id:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "Id"
    .end annotation
.end field

.field private lastModifiedDate:Ljava/util/Date;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "LastModifiedDate"
    .end annotation
.end field

.field private subject:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "Subject"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 38
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;->id:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;->caseNumber:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;->subject:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/util/Date;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;->createdDate:Ljava/util/Date;

    return-object v0
.end method

.method public e()Ljava/util/Date;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;->lastModifiedDate:Ljava/util/Date;

    return-object v0
.end method

.method public f()Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;->feeds:Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds;

    return-object v0
.end method
