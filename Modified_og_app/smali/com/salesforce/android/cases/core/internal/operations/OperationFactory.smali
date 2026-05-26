.class public Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;
.super Ljava/lang/Object;
.source "OperationFactory.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;",
            "Lcom/salesforce/android/cases/core/internal/local/LocalRepository;",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseDetailRecord;",
            ">;"
        }
    .end annotation

    .prologue
    .line 106
    new-instance v0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseDetailOp;

    invoke-direct {v0, p1, p2, p3}, Lcom/salesforce/android/cases/core/internal/operations/GetCaseDetailOp;-><init>(Lcom/salesforce/android/cases/core/requests/CaseDetailRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;",
            "Lcom/salesforce/android/cases/core/internal/local/LocalRepository;",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseFeed;",
            ">;"
        }
    .end annotation

    .prologue
    .line 101
    new-instance v0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseFeedOp;

    invoke-direct {v0, p1, p2, p3}, Lcom/salesforce/android/cases/core/internal/operations/GetCaseFeedOp;-><init>(Lcom/salesforce/android/cases/core/requests/CaseFeedRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CaseListRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CaseListRequest;",
            "Lcom/salesforce/android/cases/core/internal/local/LocalRepository;",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 96
    new-instance v0, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp;

    invoke-direct {v0, p1, p2, p3}, Lcom/salesforce/android/cases/core/internal/operations/GetCaseListOp;-><init>(Lcom/salesforce/android/cases/core/requests/CaseListRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CommentPostRequest;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CommentPostRequest;",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Lcom/salesforce/android/cases/core/model/CommentPost;",
            ">;"
        }
    .end annotation

    .prologue
    .line 111
    new-instance v0, Lcom/salesforce/android/cases/core/internal/operations/PostCommentOp;

    invoke-direct {v0, p1, p2}, Lcom/salesforce/android/cases/core/internal/operations/PostCommentOp;-><init>(Lcom/salesforce/android/cases/core/requests/CommentPostRequest;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest;",
            "Lcom/salesforce/android/cases/core/internal/local/LocalRepository;",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/Community;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 71
    new-instance v0, Lcom/salesforce/android/cases/core/internal/operations/GetCommunitiesListOp;

    invoke-direct {v0, p1, p2, p3}, Lcom/salesforce/android/cases/core/internal/operations/GetCommunitiesListOp;-><init>(Lcom/salesforce/android/cases/core/requests/CommunitiesListRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;",
            "Lcom/salesforce/android/cases/core/internal/local/LocalRepository;",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            "Lcom/salesforce/androidsdk/accounts/UserAccount;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;",
            ">;"
        }
    .end annotation

    .prologue
    .line 131
    new-instance v0, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p0

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/salesforce/android/cases/core/internal/operations/GetCompleteCaseFeedOp;-><init>(Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;",
            "Lcom/salesforce/android/cases/core/internal/local/LocalRepository;",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            "Lcom/salesforce/androidsdk/accounts/UserAccount;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseLayoutData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 61
    new-instance v0, Lcom/salesforce/android/cases/core/internal/operations/GetCreateCaseLayoutDataOp;

    invoke-direct {v0, p1, p2, p3, p4}, Lcom/salesforce/android/cases/core/internal/operations/GetCreateCaseLayoutDataOp;-><init>(Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;Lcom/salesforce/androidsdk/accounts/UserAccount;)V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Lcom/salesforce/android/cases/core/model/CreateCaseRecordResult;",
            ">;"
        }
    .end annotation

    .prologue
    .line 66
    new-instance v0, Lcom/salesforce/android/cases/core/internal/operations/CreateCaseRecordOp;

    invoke-direct {v0, p1, p2}, Lcom/salesforce/android/cases/core/internal/operations/CreateCaseRecordOp;-><init>(Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;",
            "Lcom/salesforce/android/cases/core/internal/local/LocalRepository;",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Lcom/salesforce/android/cases/core/model/DefaultValues;",
            ">;"
        }
    .end annotation

    .prologue
    .line 116
    new-instance v0, Lcom/salesforce/android/cases/core/internal/operations/GetDefaultValuesOp;

    invoke-direct {v0, p1, p2, p3}, Lcom/salesforce/android/cases/core/internal/operations/GetDefaultValuesOp;-><init>(Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;",
            "Lcom/salesforce/android/cases/core/internal/local/LocalRepository;",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Lcom/salesforce/android/cases/core/model/ListViewDescribe;",
            ">;"
        }
    .end annotation

    .prologue
    .line 91
    new-instance v0, Lcom/salesforce/android/cases/core/internal/operations/GetListViewDescribeOp;

    invoke-direct {v0, p1, p2, p3}, Lcom/salesforce/android/cases/core/internal/operations/GetListViewDescribeOp;-><init>(Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/ListViewRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/ListViewRequest;",
            "Lcom/salesforce/android/cases/core/internal/local/LocalRepository;",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 81
    new-instance v0, Lcom/salesforce/android/cases/core/internal/operations/GetListViewIdOp;

    invoke-direct {v0, p1, p2, p3}, Lcom/salesforce/android/cases/core/internal/operations/GetListViewIdOp;-><init>(Lcom/salesforce/android/cases/core/requests/ListViewRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;",
            "Lcom/salesforce/android/cases/core/internal/local/LocalRepository;",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 126
    new-instance v0, Lcom/salesforce/android/cases/core/internal/operations/SetCaseHiddenOp;

    invoke-direct {v0, p1, p2, p3}, Lcom/salesforce/android/cases/core/internal/operations/SetCaseHiddenOp;-><init>(Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;",
            "Lcom/salesforce/android/cases/core/internal/local/LocalRepository;",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 121
    new-instance v0, Lcom/salesforce/android/cases/core/internal/operations/SetCaseLastReadDateOp;

    invoke-direct {v0, p1, p2, p3}, Lcom/salesforce/android/cases/core/internal/operations/SetCaseLastReadDateOp;-><init>(Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V

    return-object v0
.end method

.method public b(Lcom/salesforce/android/cases/core/requests/ListViewRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/ListViewRequest;",
            "Lcom/salesforce/android/cases/core/internal/local/LocalRepository;",
            "Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;",
            ")",
            "Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 86
    new-instance v0, Lcom/salesforce/android/cases/core/internal/operations/GetListViewLabelOp;

    invoke-direct {v0, p1, p2, p3}, Lcom/salesforce/android/cases/core/internal/operations/GetListViewLabelOp;-><init>(Lcom/salesforce/android/cases/core/requests/ListViewRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)V

    return-object v0
.end method
