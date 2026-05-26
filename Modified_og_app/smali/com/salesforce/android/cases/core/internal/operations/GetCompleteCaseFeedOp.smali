.class public Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;
.super Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;
.source "GetCompleteCaseFeedOp.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation",
        "<",
        "Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;",
        ">;"
    }
.end annotation


# instance fields
.field private final a:Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

.field private final b:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

.field private final c:Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

.field private final d:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

.field private final e:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

.field private final f:Lcom/salesforce/androidsdk/accounts/UserAccount;


# direct methods
.method public constructor <init>(Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;Lcom/salesforce/androidsdk/accounts/UserAccount;)V
    .locals 1

    .prologue
    .line 55
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/operations/MultipartOperation;-><init>()V

    .line 56
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->a:Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

    .line 57
    iput-object p4, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->b:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    .line 58
    new-instance v0, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    invoke-direct {v0}, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->c:Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    .line 59
    iput-object p2, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->e:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    .line 60
    iput-object p3, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->d:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    .line 61
    iput-object p5, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->f:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 62
    return-void
.end method


# virtual methods
.method public a()V
    .locals 11

    .prologue
    .line 65
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->a:Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;->l()Z

    move-result v7

    .line 66
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->a:Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;->m()Z

    move-result v8

    .line 67
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->a:Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;->n()Z

    move-result v9

    .line 71
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->b:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    new-instance v0, Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest$CommunitiesListRequestBuilder;

    invoke-direct {v0}, Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest$CommunitiesListRequestBuilder;-><init>()V

    .line 72
    invoke-virtual {v0, v7}, Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest$CommunitiesListRequestBuilder;->c(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest$CommunitiesListRequestBuilder;

    .line 73
    invoke-virtual {v0, v8}, Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest$CommunitiesListRequestBuilder;->d(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest$CommunitiesListRequestBuilder;

    .line 74
    invoke-virtual {v0, v9}, Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest$CommunitiesListRequestBuilder;->e(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest$CommunitiesListRequestBuilder;

    .line 75
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest$CommunitiesListRequestBuilder;->b()Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest;

    move-result-object v0

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->e:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    iget-object v3, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->d:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    .line 71
    invoke-virtual {v1, v0, v2, v3}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 75
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v10

    .line 76
    new-instance v0, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->a:Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

    iget-object v3, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->c:Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    iget-object v4, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->b:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    iget-object v5, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->e:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    iget-object v6, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->d:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    move-object v1, p0

    invoke-direct/range {v0 .. v6}, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCommunitiesResultsHandler;-><init>(Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V

    invoke-interface {v10, v0}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 79
    invoke-virtual {p0, v10}, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->c(Lcom/salesforce/android/service/common/utilities/control/Async;)V

    .line 81
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->b:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    new-instance v0, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->a:Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

    .line 82
    invoke-virtual {v2}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;->a()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v7}, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;->c(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;

    .line 84
    invoke-virtual {v0, v8}, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;->d(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;

    .line 85
    invoke-virtual {v0, v9}, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;->e(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;

    .line 86
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/CaseDetailRequest$CaseDetailRequestBuilder;->b()Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;

    move-result-object v0

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->e:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    iget-object v3, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->d:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    .line 81
    invoke-virtual {v1, v0, v2, v3}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 86
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 87
    new-instance v1, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCaseDetailHandler;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->c:Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    invoke-direct {v1, p0, v2}, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/GetCaseDetailHandler;-><init>(Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 88
    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->c(Lcom/salesforce/android/service/common/utilities/control/Async;)V

    .line 90
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->b:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    new-instance v0, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->a:Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

    .line 92
    invoke-virtual {v2}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;->b()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v7}, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;->c(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;

    .line 93
    invoke-virtual {v0, v8}, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;->d(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;

    .line 94
    invoke-virtual {v0, v9}, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;->e(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;

    .line 95
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest$DefaultValuesRequestBuilder;->b()Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;

    move-result-object v0

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->e:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    iget-object v3, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->d:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    .line 90
    invoke-virtual {v1, v0, v2, v3}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 95
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 96
    new-instance v1, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/DefaultValuesHandler;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->c:Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    invoke-direct {v1, p0, v2}, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/DefaultValuesHandler;-><init>(Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 97
    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->c(Lcom/salesforce/android/service/common/utilities/control/Async;)V

    .line 99
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->b:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    new-instance v0, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->a:Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;

    .line 101
    invoke-virtual {v2}, Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;->b()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v7}, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;->c(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;

    .line 102
    invoke-virtual {v0, v8}, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;->d(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;

    .line 103
    invoke-virtual {v0, v9}, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;->e(Z)Lcom/salesforce/android/service/common/fetchsave/requests/FetchSaveRequest$FetchSaveRequestBuilder;

    move-result-object v0

    check-cast v0, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;

    .line 104
    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest$CreateCaseQuickActionRequestBuilder;->b()Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;

    move-result-object v0

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->e:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    iget-object v3, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->d:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    iget-object v4, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->f:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 99
    invoke-virtual {v1, v0, v2, v3, v4}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 104
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 105
    new-instance v1, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/CreateCaseQuickActionHandler;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->c:Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    invoke-direct {v1, p0, v2}, Lcom/salesforce/android/cases/core/internal/operations/resulthandlers/CreateCaseQuickActionHandler;-><init>(Lcom/salesforce/android/cases/core/internal/operations/MultipartOperationObserver;Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;)V

    invoke-interface {v0, v1}, Lcom/salesforce/android/service/common/utilities/control/Async;->b(Lcom/salesforce/android/service/common/utilities/control/Async$ResultHandler;)Lcom/salesforce/android/service/common/utilities/control/Async;

    .line 106
    invoke-virtual {p0, v0}, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->c(Lcom/salesforce/android/service/common/utilities/control/Async;)V

    .line 107
    return-void
.end method

.method b()Z
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->c:Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->a()Z

    move-result v0

    return v0
.end method

.method c()Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->c:Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/internal/model/CompleteCaseFeedModel;->b()Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;

    move-result-object v0

    return-object v0
.end method

.method synthetic d()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 44
    invoke-virtual {p0}, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;->c()Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;

    move-result-object v0

    return-object v0
.end method
