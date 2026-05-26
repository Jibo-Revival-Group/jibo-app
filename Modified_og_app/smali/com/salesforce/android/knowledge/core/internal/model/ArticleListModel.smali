.class public Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;
.super Ljava/lang/Object;
.source "ArticleListModel.java"

# interfaces
.implements Lcom/salesforce/android/knowledge/core/model/ArticleList;


# instance fields
.field private final a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleSummary;",
            ">;"
        }
    .end annotation
.end field

.field private final b:I

.field private final c:Z


# direct methods
.method private constructor <init>(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;Ljava/util/List;Z)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 46
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    new-instance v0, Ljava/util/ArrayList;

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    .line 49
    invoke-interface {v0, p2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 50
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;->a:Ljava/util/List;

    .line 52
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;->b()I

    move-result v0

    iput v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;->b:I

    .line 53
    iput-boolean p3, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;->c:Z

    .line 54
    return-void
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse;)Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;
    .locals 3

    .prologue
    .line 57
    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse;->b()Ljava/util/List;

    move-result-object v0

    .line 58
    new-instance v1, Ljava/util/ArrayList;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(I)V

    .line 60
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;

    .line 61
    invoke-static {v0}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;->a(Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse$Article;)Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 64
    :cond_0
    new-instance v2, Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;

    invoke-virtual {p1}, Lcom/salesforce/android/knowledge/core/internal/http/response/ArticlesResponse;->a()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_1
    invoke-direct {v2, p0, v1, v0}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;-><init>(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;Ljava/util/List;Z)V

    return-object v2

    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public static a(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;Ljava/util/List;Z)Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/internal/model/ArticleSummaryModel;",
            ">;Z)",
            "Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;"
        }
    .end annotation

    .prologue
    .line 68
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;

    invoke-direct {v0, p0, p1, p2}, Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;-><init>(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;Ljava/util/List;Z)V

    return-object v0
.end method


# virtual methods
.method public a()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleSummary;",
            ">;"
        }
    .end annotation

    .prologue
    .line 76
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;->a:Ljava/util/List;

    return-object v0
.end method

.method public b()I
    .locals 1

    .prologue
    .line 80
    iget v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;->b:I

    return v0
.end method

.method public c()Z
    .locals 1

    .prologue
    .line 84
    iget-boolean v0, p0, Lcom/salesforce/android/knowledge/core/internal/model/ArticleListModel;->c:Z

    return v0
.end method
