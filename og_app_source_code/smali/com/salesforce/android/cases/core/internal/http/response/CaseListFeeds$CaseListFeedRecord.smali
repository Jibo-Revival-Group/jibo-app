.class public Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds$CaseListFeedRecord;
.super Ljava/lang/Object;
.source "CaseListFeeds.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "CaseListFeedRecord"
.end annotation


# instance fields
.field private body:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "Body"
    .end annotation
.end field

.field private createdById:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "CreatedById"
    .end annotation
.end field

.field private lastModifiedDate:Ljava/util/Date;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "LastModifiedDate"
    .end annotation
.end field


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds$CaseListFeedRecord;->body:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds$CaseListFeedRecord;->createdById:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/util/Date;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds$CaseListFeedRecord;->lastModifiedDate:Ljava/util/Date;

    return-object v0
.end method
