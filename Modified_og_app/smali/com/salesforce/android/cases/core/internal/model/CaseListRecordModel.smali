.class public Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;
.super Ljava/lang/Object;
.source "CaseListRecordModel.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/model/CaseListRecord;


# instance fields
.field private a:Ljava/lang/String;

.field private b:Ljava/lang/String;

.field private c:Ljava/lang/String;

.field private d:Ljava/util/Date;

.field private e:Ljava/util/Date;

.field private f:Z

.field private g:Z

.field private h:Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;)V
    .locals 2

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    if-nez p1, :cond_0

    .line 47
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "CaseListResponse.CaseListRecord cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 50
    :cond_0
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;->c()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->a:Ljava/lang/String;

    .line 51
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;->a()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->b:Ljava/lang/String;

    .line 52
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->c:Ljava/lang/String;

    .line 53
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;->d()Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->d:Ljava/util/Date;

    .line 55
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;->f()Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;->f()Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds;->a()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 57
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;->f()Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds;->a()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds$CaseListFeedRecord;

    invoke-static {v0}, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->a(Lcom/salesforce/android/cases/core/internal/http/response/CaseListFeeds$CaseListFeedRecord;)Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->h:Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;

    .line 60
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->h:Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->h:Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->c()Ljava/util/Date;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 61
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->h:Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->c()Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->e:Ljava/util/Date;

    .line 65
    :goto_0
    return-void

    .line 63
    :cond_2
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;->e()Ljava/util/Date;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->e:Ljava/util/Date;

    goto :goto_0
.end method

.method public static a(Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;)Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;
    .locals 1

    .prologue
    .line 69
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;-><init>(Lcom/salesforce/android/cases/core/internal/http/response/CaseListRecord;)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->a:Ljava/lang/String;

    return-object v0
.end method

.method public a(Z)V
    .locals 0

    .prologue
    .line 97
    iput-boolean p1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->f:Z

    .line 98
    return-void
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->b:Ljava/lang/String;

    return-object v0
.end method

.method public b(Z)V
    .locals 0

    .prologue
    .line 105
    iput-boolean p1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->g:Z

    .line 106
    return-void
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->c:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/util/Date;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->e:Ljava/util/Date;

    return-object v0
.end method

.method public e()Z
    .locals 1

    .prologue
    .line 93
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->f:Z

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 113
    if-ne p0, p1, :cond_1

    move v1, v0

    .line 132
    :cond_0
    :goto_0
    return v1

    .line 114
    :cond_1
    if-eqz p1, :cond_0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    if-ne v2, v3, :cond_0

    .line 116
    check-cast p1, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;

    .line 118
    iget-boolean v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->f:Z

    iget-boolean v3, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->f:Z

    if-ne v2, v3, :cond_0

    .line 119
    iget-boolean v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->g:Z

    iget-boolean v3, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->g:Z

    if-ne v2, v3, :cond_0

    .line 120
    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->a:Ljava/lang/String;

    if-eqz v2, :cond_8

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->a:Ljava/lang/String;

    iget-object v3, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 121
    :cond_2
    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->b:Ljava/lang/String;

    if-eqz v2, :cond_9

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->b:Ljava/lang/String;

    iget-object v3, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->b:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 122
    :cond_3
    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->c:Ljava/lang/String;

    if-eqz v2, :cond_a

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->c:Ljava/lang/String;

    iget-object v3, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->c:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 125
    :cond_4
    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->d:Ljava/util/Date;

    if-eqz v2, :cond_b

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->d:Ljava/util/Date;

    iget-object v3, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->d:Ljava/util/Date;

    invoke-virtual {v2, v3}, Ljava/util/Date;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 128
    :cond_5
    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->e:Ljava/util/Date;

    if-eqz v2, :cond_c

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->e:Ljava/util/Date;

    iget-object v3, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->e:Ljava/util/Date;

    invoke-virtual {v2, v3}, Ljava/util/Date;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 132
    :cond_6
    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->h:Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;

    if-eqz v2, :cond_d

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->h:Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;

    iget-object v1, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->h:Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;

    invoke-virtual {v0, v1}, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->equals(Ljava/lang/Object;)Z

    move-result v0

    :cond_7
    :goto_1
    move v1, v0

    goto :goto_0

    .line 120
    :cond_8
    iget-object v2, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->a:Ljava/lang/String;

    if-eqz v2, :cond_2

    goto :goto_0

    .line 121
    :cond_9
    iget-object v2, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->b:Ljava/lang/String;

    if-eqz v2, :cond_3

    goto :goto_0

    .line 122
    :cond_a
    iget-object v2, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->c:Ljava/lang/String;

    if-eqz v2, :cond_4

    goto :goto_0

    .line 125
    :cond_b
    iget-object v2, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->d:Ljava/util/Date;

    if-eqz v2, :cond_5

    goto/16 :goto_0

    .line 128
    :cond_c
    iget-object v2, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->e:Ljava/util/Date;

    if-eqz v2, :cond_6

    goto/16 :goto_0

    .line 132
    :cond_d
    iget-object v2, p1, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->h:Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;

    if-eqz v2, :cond_7

    move v0, v1

    goto :goto_1
.end method

.method public f()Z
    .locals 1

    .prologue
    .line 101
    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->g:Z

    return v0
.end method

.method public g()Lcom/salesforce/android/cases/core/model/CaseListFeedRecord;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->h:Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;

    return-object v0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 137
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->a:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->a:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 138
    :goto_0
    mul-int/lit8 v3, v0, 0x1f

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->b:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->b:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_1
    add-int/2addr v0, v3

    .line 139
    mul-int/lit8 v3, v0, 0x1f

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->c:Ljava/lang/String;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->c:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->hashCode()I

    move-result v0

    :goto_2
    add-int/2addr v0, v3

    .line 140
    mul-int/lit8 v3, v0, 0x1f

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->d:Ljava/util/Date;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->d:Ljava/util/Date;

    invoke-virtual {v0}, Ljava/util/Date;->hashCode()I

    move-result v0

    :goto_3
    add-int/2addr v0, v3

    .line 141
    mul-int/lit8 v3, v0, 0x1f

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->e:Ljava/util/Date;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->e:Ljava/util/Date;

    invoke-virtual {v0}, Ljava/util/Date;->hashCode()I

    move-result v0

    :goto_4
    add-int/2addr v0, v3

    .line 142
    mul-int/lit8 v3, v0, 0x1f

    iget-boolean v0, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->f:Z

    if-eqz v0, :cond_6

    move v0, v2

    :goto_5
    add-int/2addr v0, v3

    .line 143
    mul-int/lit8 v0, v0, 0x1f

    iget-boolean v3, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->g:Z

    if-eqz v3, :cond_7

    :goto_6
    add-int/2addr v0, v2

    .line 144
    mul-int/lit8 v0, v0, 0x1f

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->h:Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;

    if-eqz v2, :cond_0

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/model/CaseListRecordModel;->h:Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;

    invoke-virtual {v1}, Lcom/salesforce/android/cases/core/internal/model/CaseListFeedRecordModel;->hashCode()I

    move-result v1

    :cond_0
    add-int/2addr v0, v1

    .line 145
    return v0

    :cond_1
    move v0, v1

    .line 137
    goto :goto_0

    :cond_2
    move v0, v1

    .line 138
    goto :goto_1

    :cond_3
    move v0, v1

    .line 139
    goto :goto_2

    :cond_4
    move v0, v1

    .line 140
    goto :goto_3

    :cond_5
    move v0, v1

    .line 141
    goto :goto_4

    :cond_6
    move v0, v1

    .line 142
    goto :goto_5

    :cond_7
    move v2, v1

    .line 143
    goto :goto_6
.end method
