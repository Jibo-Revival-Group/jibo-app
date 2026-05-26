.class public Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;
.super Ljava/lang/Object;
.source "CaseListFeedRecordModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/CaseListFeedRecord;


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Ljava/util/Date;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds$CaseListFeedRecord;)V
    .locals 2

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    if-nez p1, :cond_0

    .line 41
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "record cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 44
    :cond_0
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds$CaseListFeedRecord;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->a:Ljava/lang/String;

    .line 45
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds$CaseListFeedRecord;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->b:Ljava/lang/String;

    .line 46
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds$CaseListFeedRecord;->c()Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->c:Ljava/util/Date;

    .line 47
    return-void
.end method

.method public static a(Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds$CaseListFeedRecord;)Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;
    .locals 1

    .prologue
    .line 51
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;-><init>(Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds$CaseListFeedRecord;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->a:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->b:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/util/Date;
    .locals 1

    .prologue
    .line 63
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->c:Ljava/util/Date;

    return-object v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 67
    if-ne p0, p1, :cond_1

    move v1, v0

    .line 76
    :cond_0
    :goto_0
    return v1

    .line 68
    :cond_1
    if-eqz p1, :cond_0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-ne v2, v3, :cond_0

    .line 70
    check-cast p1, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;

    .line 72
    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->a:Ljava/lang/String;

    if-eqz v2, :cond_5

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->a:Ljava/lang/String;

    iget-object v3, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 73
    :cond_2
    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->b:Ljava/lang/String;

    if-eqz v2, :cond_6

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->b:Ljava/lang/String;

    iget-object v3, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->b:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 76
    :cond_3
    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->c:Ljava/util/Date;

    if-eqz v2, :cond_7

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->c:Ljava/util/Date;

    iget-object v1, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->c:Ljava/util/Date;

    invoke-virtual {v0, v1}, Ljava/util/Date;->equals(Ljava/lang/Object;)Z

    move-result v0

    :cond_4
    :goto_1
    move v1, v0

    goto :goto_0

    .line 72
    :cond_5
    iget-object v2, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->a:Ljava/lang/String;

    if-eqz v2, :cond_2

    goto :goto_0

    .line 73
    :cond_6
    iget-object v2, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->b:Ljava/lang/String;

    if-eqz v2, :cond_3

    goto :goto_0

    .line 76
    :cond_7
    iget-object v2, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->c:Ljava/util/Date;

    if-eqz v2, :cond_4

    move v0, v1

    goto :goto_1
.end method

.method public hashCode()I
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 81
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->a:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->a:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 82
    :goto_0
    mul-int/lit8 v2, v0, 0x1f

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->b:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->b:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_1
    add-int/2addr v0, v2

    .line 83
    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->c:Ljava/util/Date;

    if-eqz v2, :cond_0

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->c:Ljava/util/Date;

    invoke-virtual {v1}, Ljava/util/Date;->hashCode()I

    move-result v1

    :cond_0
    add-int/2addr v0, v1

    .line 84
    return v0

    :cond_1
    move v0, v1

    .line 81
    goto :goto_0

    :cond_2
    move v0, v1

    .line 82
    goto :goto_1
.end method
