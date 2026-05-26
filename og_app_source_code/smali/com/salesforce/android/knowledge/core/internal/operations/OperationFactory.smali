.class public Lcom/salesforce/android/knowledge/core/internal/operations/OperationFactory;
.super Ljava/lang/Object;
.source "OperationFactory.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/internal/http/HttpService;Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbService;",
            "Lcom/salesforce/android/knowledge/core/internal/http/HttpService;",
            "Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
            ">;"
        }
    .end annotation

    .prologue
    .line 53
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;-><init>(Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/internal/http/HttpService;Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;)V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/internal/http/HttpService;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbService;",
            "Lcom/salesforce/android/knowledge/core/internal/http/HttpService;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 45
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/operations/ArticlesOp;

    invoke-direct {v0, p1, p2, p3}, Lcom/salesforce/android/knowledge/core/internal/operations/ArticlesOp;-><init>(Lcom/salesforce/android/knowledge/core/requests/ArticleListRequest;Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/internal/http/HttpService;)V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/internal/http/HttpService;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbService;",
            "Lcom/salesforce/android/knowledge/core/internal/http/HttpService;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryList;",
            ">;"
        }
    .end annotation

    .prologue
    .line 61
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoriesOp;

    invoke-direct {v0, p1, p2, p3}, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoriesOp;-><init>(Lcom/salesforce/android/knowledge/core/requests/DataCategoriesRequest;Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/internal/http/HttpService;)V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/internal/http/HttpService;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbService;",
            "Lcom/salesforce/android/knowledge/core/internal/http/HttpService;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/DataCategoryGroup;",
            ">;"
        }
    .end annotation

    .prologue
    .line 49
    new-instance v0, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp;

    invoke-direct {v0, p1, p2, p3}, Lcom/salesforce/android/knowledge/core/internal/operations/DataCategoryGroupOp;-><init>(Lcom/salesforce/android/knowledge/core/requests/DataCategoryGroupRequest;Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/internal/http/HttpService;)V

    return-object v0
.end method
