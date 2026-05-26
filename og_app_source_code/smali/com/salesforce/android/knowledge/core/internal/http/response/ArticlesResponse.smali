.class public Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse;
.super Ljava/lang/Object;
.source "ArticlesResponse.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;
    }
.end annotation


# instance fields
.field mArticles:Ljava/util/List;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "articles"
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;",
            ">;"
        }
    .end annotation
.end field

.field mCurrentPageUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "currentPageUrl"
    .end annotation
.end field

.field mNextPageUrl:Ljava/lang/String;
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "nextPageUrl"
    .end annotation
.end field

.field mPageNumber:I
    .annotation runtime Lcom/google/gson/annotations/SerializedName;
        a = "pageNumber"
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
.method public a()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse;->mNextPageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public b()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;",
            ">;"
        }
    .end annotation

    .prologue
    .line 52
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse;->mArticles:Ljava/util/List;

    return-object v0
.end method
