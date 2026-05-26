.class public Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;
.super Ljava/lang/Object;
.source "ArticleDetailsResponse.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$LayoutItem;,
        Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;
    }
.end annotation


# instance fields
.field private mAllViewCount:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "allViewCount"
    .end annotation
.end field

.field private mAllViewScore:D
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "allViewScore"
    .end annotation
.end field

.field private mAppDownVoteCount:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "appDownVoteCount"
    .end annotation
.end field

.field private mAppUpVoteCount:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "appUpVoteCount"
    .end annotation
.end field

.field private mAppViewCount:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "appViewCount"
    .end annotation
.end field

.field private mAppViewScore:D
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "appViewScore"
    .end annotation
.end field

.field private mArticleNumber:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "articleNumber"
    .end annotation
.end field

.field private mCreatedBy:Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "createdBy"
    .end annotation
.end field

.field private mCreatedDate:Ljava/util/Date;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "createdDate"
    .end annotation
.end field

.field private mCspDownVoteCount:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "cspDownVoteCount"
    .end annotation
.end field

.field private mCspUpVoteCount:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "cspUpVoteCount"
    .end annotation
.end field

.field private mCspViewCount:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "cspViewCount"
    .end annotation
.end field

.field private mCspViewScore:D
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "cspViewScore"
    .end annotation
.end field

.field private mId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "id"
    .end annotation
.end field

.field private mLastModifiedBy:Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "lastModifiedBy"
    .end annotation
.end field

.field private mLastModifiedDate:Ljava/util/Date;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "lastModifiedDate"
    .end annotation
.end field

.field private mLastPublishedDate:Ljava/util/Date;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "lastPublishedDate"
    .end annotation
.end field

.field private mLayoutItems:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "layoutItems"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$LayoutItem;",
            ">;"
        }
    .end annotation
.end field

.field private mPkbDownVoteCount:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "pkbDownVoteCount"
    .end annotation
.end field

.field private mPkbUpVoteCount:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "pkbUpVoteCount"
    .end annotation
.end field

.field private mPkbViewCount:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "pkbViewCount"
    .end annotation
.end field

.field private mPkbViewScore:D
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "pkbViewScore"
    .end annotation
.end field

.field private mSummary:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "summary"
    .end annotation
.end field

.field private mTitle:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "title"
    .end annotation
.end field

.field private mUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "url"
    .end annotation
.end field

.field private mVersionNumber:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "versionNumber"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()I
    .locals 1

    .prologue
    .line 62
    iget v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->mAllViewCount:I

    return v0
.end method

.method public b()D
    .locals 2

    .prologue
    .line 66
    iget-wide v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->mAllViewScore:D

    return-wide v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->mArticleNumber:Ljava/lang/String;

    return-object v0
.end method

.method public d()Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->mCreatedBy:Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;

    return-object v0
.end method

.method public e()Ljava/util/Date;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->mCreatedDate:Ljava/util/Date;

    return-object v0
.end method

.method public f()Ljava/lang/String;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->mId:Ljava/lang/String;

    return-object v0
.end method

.method public g()Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->mLastModifiedBy:Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$User;

    return-object v0
.end method

.method public h()Ljava/util/Date;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->mLastModifiedDate:Ljava/util/Date;

    return-object v0
.end method

.method public i()Ljava/util/Date;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->mLastPublishedDate:Ljava/util/Date;

    return-object v0
.end method

.method public j()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse$LayoutItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 130
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->mLayoutItems:Ljava/util/List;

    return-object v0
.end method

.method public k()Ljava/lang/String;
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->mSummary:Ljava/lang/String;

    return-object v0
.end method

.method public l()Ljava/lang/String;
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->mTitle:Ljava/lang/String;

    return-object v0
.end method

.method public m()Ljava/lang/String;
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->mUrl:Ljava/lang/String;

    return-object v0
.end method

.method public n()I
    .locals 1

    .prologue
    .line 162
    iget v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticleDetailsResponse;->mVersionNumber:I

    return v0
.end method
