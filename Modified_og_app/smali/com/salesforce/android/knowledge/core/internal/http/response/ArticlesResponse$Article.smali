.class public Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;
.super Ljava/lang/Object;
.source "ArticlesResponse.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Article"
.end annotation


# instance fields
.field mArticleNumber:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "articleNumber"
    .end annotation
.end field

.field mId:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "id"
    .end annotation
.end field

.field mLastPublishedDate:Ljava/util/Date;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "lastPublishedDate"
    .end annotation
.end field

.field mSummary:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "summary"
    .end annotation
.end field

.field mTitle:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "title"
    .end annotation
.end field

.field mUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "url"
    .end annotation
.end field

.field mViewCount:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "viewCount"
    .end annotation
.end field

.field mViewScore:D
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "viewScore"
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;->mId:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;->mArticleNumber:Ljava/lang/String;

    return-object v0
.end method

.method public c()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;->mTitle:Ljava/lang/String;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;->mSummary:Ljava/lang/String;

    return-object v0
.end method

.method public e()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;->mUrl:Ljava/lang/String;

    return-object v0
.end method

.method public f()I
    .locals 1

    .prologue
    .line 86
    iget v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;->mViewCount:I

    return v0
.end method

.method public g()D
    .locals 2

    .prologue
    .line 90
    iget-wide v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;->mViewScore:D

    return-wide v0
.end method

.method public h()Ljava/util/Date;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;->mLastPublishedDate:Ljava/util/Date;

    return-object v0
.end method
