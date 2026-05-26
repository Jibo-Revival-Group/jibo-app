.class Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;
.super Lcom/salesforce/android/knowledge/core/internal/operations/KnowledgeFetchSaveOp;
.source "ArticleDetailsOp.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/knowledge/core/internal/operations/KnowledgeFetchSaveOp",
        "<",
        "Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;",
        "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;


# direct methods
.method constructor <init>(Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/internal/http/HttpService;Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;)V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0, p1, p2, p3}, Lcom/salesforce/android/knowledge/core/internal/operations/KnowledgeFetchSaveOp;-><init>(Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/internal/http/HttpService;)V

    .line 46
    iput-object p4, p0, Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;->a:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;

    .line 47
    return-void
.end method

.method static synthetic a(Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;)Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;->a:Lcom/salesforce/android/knowledge/core/offline/OfflineResourceCacher;

    return-object v0
.end method


# virtual methods
.method protected a(Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbService;",
            "Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
            ">;"
        }
    .end annotation

    .prologue
    .line 55
    invoke-virtual {p1, p2}, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->a(Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method protected a(Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/internal/db/DbService;",
            "Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 76
    invoke-virtual {p1, p3}, Lcom/salesforce/android/knowledge/core/internal/db/DbService;->a(Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic a(Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1

    .prologue
    .line 36
    check-cast p2, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;->a(Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic a(Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;Ljava/lang/Object;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1

    .prologue
    .line 36
    check-cast p2, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;

    check-cast p3, Lcom/salesforce/android/knowledge/core/model/ArticleDetails;

    invoke-virtual {p0, p1, p2, p3}, Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;->a(Lcom/salesforce/android/knowledge/core/internal/db/DbService;Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;Lcom/salesforce/android/knowledge/core/model/ArticleDetails;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method protected a(Lcom/salesforce/android/knowledge/core/internal/http/HttpService;Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/knowledge/core/internal/http/HttpService;",
            "Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/knowledge/core/model/ArticleDetails;",
            ">;"
        }
    .end annotation

    .prologue
    .line 60
    invoke-virtual {p1, p2}, Lcom/salesforce/android/knowledge/core/internal/http/HttpService;->a(Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 62
    invoke-virtual {p2}, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;->b()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 63
    new-instance v1, Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp$1;

    invoke-direct {v1, p0}, Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp$1;-><init>(Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->a(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 71
    :cond_0
    return-object v0
.end method

.method protected bridge synthetic a(Lcom/salesforce/android/knowledge/core/internal/http/HttpService;Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 1

    .prologue
    .line 36
    check-cast p2, Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/knowledge/core/internal/operations/ArticleDetailsOp;->a(Lcom/salesforce/android/knowledge/core/internal/http/HttpService;Lcom/salesforce/android/knowledge/core/requests/ArticleDetailRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method protected b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    const-string v0, "Could not fetch Article Details"

    return-object v0
.end method
