.class public Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;
.super Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/AbstractMultipartRequestHandler;
.source "GetCommunitiesResultsHandler.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/AbstractMultipartRequestHandler",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/salesforce/android/cases/core/model/Community;",
        ">;>;"
    }
.end annotation


# instance fields
.field private b:Lcom/salesforce/android/service/common/utilities/control/Async;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseFeed;",
            ">;"
        }
    .end annotation
.end field

.field private final c:Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

.field private final d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

.field private final e:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

.field private final f:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

.field private final g:Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0, p1}, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/AbstractMultipartRequestHandler;-><init>(Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;)V

    .line 56
    iput-object p3, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->c:Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    .line 57
    iput-object p4, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    .line 58
    iput-object p5, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->e:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    .line 59
    iput-object p6, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->f:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    .line 60
    iput-object p2, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->g:Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

    .line 61
    return-void
.end method

.method private a(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/Community;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 77
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/model/Community;

    .line 78
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Community;->b()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 79
    invoke-interface {v0}, Lcom/salesforce/android/cases/core/model/Community;->a()Ljava/lang/String;

    move-result-object v0

    .line 82
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private a(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 86
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->c:Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->c()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private b(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 91
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    new-instance v0, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->g:Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

    .line 92
    invoke-virtual {v2}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;->a()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, p1, v2}, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->g:Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

    .line 93
    invoke-virtual {v2}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;->l()Z

    move-result v2

    .line 92
    invoke-virtual {v0, v2}, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;->c(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->g:Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

    .line 94
    invoke-virtual {v2}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;->m()Z

    move-result v2

    invoke-virtual {v0, v2}, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;->d(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->g:Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

    .line 95
    invoke-virtual {v2}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;->n()Z

    move-result v2

    invoke-virtual {v0, v2}, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;->e(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;

    .line 96
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/CaseFeedRequest$CaseFeedRequestBuilder;->b()Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;

    move-result-object v0

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->e:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    iget-object v3, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->f:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    .line 91
    invoke-virtual {v1, v0, v2, v3}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 96
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 97
    new-instance v1, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCaseFeedHandler;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;

    iget-object v3, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->c:Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    invoke-direct {v1, v2, v3}, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCaseFeedHandler;-><init>(Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 99
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;

    invoke-interface {v1, v0}, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;->c(Lcom/salesforce/android/service/common/utilities/control/Async;)V

    .line 102
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->b:Lcom/salesforce/android/service/common/utilities/control/Async;

    if-eqz v1, :cond_0

    .line 103
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->b:Lcom/salesforce/android/service/common/utilities/control/Async;

    invoke-interface {v1, v2}, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;->b(Lcom/salesforce/android/service/common/utilities/control/Async;)V

    .line 105
    :cond_0
    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->b:Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 106
    return-void
.end method


# virtual methods
.method public bridge synthetic a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 40
    check-cast p2, Ljava/util/List;

    invoke-virtual {p0, p1, p2}, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/util/List;)V

    return-void
.end method

.method public a(Lcom/salesforce/android/service/common/utilities/control/Async;Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<*>;",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/Community;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 65
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->g:Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;->c()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p2, v0}, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->a(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 68
    invoke-direct {p0, v0}, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->a(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 69
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->c:Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    invoke-virtual {v1, v0}, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->a(Ljava/lang/String;)Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    .line 70
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->a:Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;

    invoke-interface {v1}, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;->g()V

    .line 71
    invoke-direct {p0, v0}, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;->b(Ljava/lang/String;)V

    .line 73
    :cond_0
    return-void
.end method
