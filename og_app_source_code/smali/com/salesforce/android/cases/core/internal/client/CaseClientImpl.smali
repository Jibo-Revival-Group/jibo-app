.class public Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;
.super Ljava/lang/Object;
.source "CaseClientImpl.java"

# interfaces
.implements Lcom/salesforce/android/cases/core/CaseClient;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;
    }
.end annotation


# instance fields
.field a:Landroid/content/Context;

.field b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

.field private final c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

.field private final d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

.field private final e:Lcom/salesforce/android/cases/core/CaseClientCallbacks;

.field private final f:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

.field private final g:Lcom/salesforce/androidsdk/accounts/UserAccount;

.field private h:Lcom/salesforce/android/cases/core/NotificationHandler;


# direct methods
.method constructor <init>(Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;)V
    .locals 2

    .prologue
    .line 89
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 90
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->c()Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    .line 91
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->d()Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    .line 92
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->b()Lcom/salesforce/android/cases/core/CaseClientCallbacks;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->e:Lcom/salesforce/android/cases/core/CaseClientCallbacks;

    .line 93
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->e()Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->f:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    .line 94
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->h()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->a:Landroid/content/Context;

    .line 95
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->g()Lcom/salesforce/android/cases/core/CaseConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/salesforce/android/cases/core/CaseConfiguration;->i()Lcom/salesforce/androidsdk/accounts/UserAccount;

    move-result-object v0

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->g:Lcom/salesforce/androidsdk/accounts/UserAccount;

    .line 96
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    if-nez v0, :cond_0

    .line 97
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "RemoteRepository cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 100
    :cond_0
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    if-nez v0, :cond_1

    .line 101
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "OperationFactory cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 104
    :cond_1
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->f:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    if-nez v0, :cond_2

    .line 105
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "LocalRepository cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 108
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->a:Landroid/content/Context;

    if-nez v0, :cond_3

    .line 109
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Context cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 112
    :cond_3
    invoke-virtual {p1}, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;->f()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 113
    invoke-static {}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a()Lcom/salesforce/androidsdk/app/SalesforceSDKManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/salesforce/androidsdk/app/SalesforceSDKManager;->a(Lcom/salesforce/androidsdk/push/PushNotificationInterface;)V

    .line 114
    new-instance v0, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-direct {v0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;-><init>()V

    iput-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    .line 115
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->a:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->a(Landroid/content/Context;)V

    .line 117
    :cond_4
    return-void
.end method

.method public static a(Lcom/salesforce/android/cases/core/CaseConfiguration;)Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;
    .locals 1

    .prologue
    .line 120
    new-instance v0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;

    invoke-direct {v0, p0}, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl$Builder;-><init>(Lcom/salesforce/android/cases/core/CaseConfiguration;)V

    return-object v0
.end method

.method private b()Z
    .locals 1

    .prologue
    .line 248
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->b:Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;

    invoke-virtual {v0}, Lcom/salesforce/android/service/common/utilities/activity/ActivityTracker;->b()Landroid/app/Activity;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public a()Lcom/salesforce/android/cases/core/CaseClientCallbacks;
    .locals 1

    .prologue
    .line 212
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->e:Lcom/salesforce/android/cases/core/CaseClientCallbacks;

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CaseListRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CaseListRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseListRecord;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 166
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->f:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    invoke-virtual {v0, p1, v1, v2}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/cases/core/requests/CaseListRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 167
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 168
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 166
    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CommentPostRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CommentPostRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/CommentPost;",
            ">;"
        }
    .end annotation

    .prologue
    .line 216
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    invoke-virtual {v0, p1, v1}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/cases/core/requests/CommentPostRequest;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/CompleteCaseFeed;",
            ">;"
        }
    .end annotation

    .prologue
    .line 202
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->f:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    iget-object v3, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->g:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-virtual {v0, p1, v1, v2, v3}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/cases/core/requests/CompleteCaseFeedRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 203
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 202
    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/CaseLayoutData;",
            ">;"
        }
    .end annotation

    .prologue
    .line 129
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->f:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    iget-object v3, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->g:Lcom/salesforce/androidsdk/accounts/UserAccount;

    invoke-virtual {v0, p1, v1, v2, v3}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/cases/core/requests/CreateCaseQuickActionRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;Lcom/salesforce/androidsdk/accounts/UserAccount;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 130
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 129
    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/CreateCaseRecordResult;",
            ">;"
        }
    .end annotation

    .prologue
    .line 134
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    invoke-virtual {v0, p1, v1}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/cases/core/requests/CreateCaseRecordRequest;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/DefaultValues;",
            ">;"
        }
    .end annotation

    .prologue
    .line 184
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->f:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    invoke-virtual {v0, p1, v1, v2}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/cases/core/requests/DefaultValuesRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 185
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 186
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 184
    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Lcom/salesforce/android/cases/core/model/ListViewDescribe;",
            ">;"
        }
    .end annotation

    .prologue
    .line 160
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->f:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    invoke-virtual {v0, p1, v1, v2}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/cases/core/requests/ListViewDescribeRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 161
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 162
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 160
    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/ListViewRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/ListViewRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 148
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->f:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    invoke-virtual {v0, p1, v1, v2}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/cases/core/requests/ListViewRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 149
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 150
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 148
    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 196
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->f:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    invoke-virtual {v0, p1, v1, v2}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/cases/core/requests/SetCaseHiddenRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 197
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 198
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 196
    return-object v0
.end method

.method public a(Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 190
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->f:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    invoke-virtual {v0, p1, v1, v2}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;->a(Lcom/salesforce/android/cases/core/requests/SetCaseLastReadDateRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 191
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 192
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 190
    return-object v0
.end method

.method public a(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 220
    const/4 v0, 0x0

    .line 222
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->e:Lcom/salesforce/android/cases/core/CaseClientCallbacks;

    if-eqz v1, :cond_0

    .line 223
    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->b()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 224
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->e:Lcom/salesforce/android/cases/core/CaseClientCallbacks;

    invoke-interface {v0, p1}, Lcom/salesforce/android/cases/core/CaseClientCallbacks;->b(Landroid/os/Bundle;)Z

    move-result v0

    .line 230
    :cond_0
    :goto_0
    new-instance v1, Lcom/salesforce/android/cases/core/model/PushNotification;

    invoke-direct {v1, p1}, Lcom/salesforce/android/cases/core/model/PushNotification;-><init>(Landroid/os/Bundle;)V

    .line 232
    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->h:Lcom/salesforce/android/cases/core/NotificationHandler;

    if-eqz v2, :cond_1

    .line 233
    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->h:Lcom/salesforce/android/cases/core/NotificationHandler;

    invoke-interface {v2, v1}, Lcom/salesforce/android/cases/core/NotificationHandler;->a(Lcom/salesforce/android/cases/core/model/PushNotification;)V

    .line 236
    :cond_1
    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->h:Lcom/salesforce/android/cases/core/NotificationHandler;

    if-eqz v2, :cond_2

    if-nez v0, :cond_2

    invoke-direct {p0}, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->b()Z

    move-result v0

    if-nez v0, :cond_2

    .line 237
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->h:Lcom/salesforce/android/cases/core/NotificationHandler;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->a:Landroid/content/Context;

    invoke-interface {v0, v2, v1}, Lcom/salesforce/android/cases/core/NotificationHandler;->a(Landroid/content/Context;Lcom/salesforce/android/cases/core/model/PushNotification;)V

    .line 241
    :cond_2
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->a:Landroid/content/Context;

    if-eqz v0, :cond_3

    .line 242
    new-instance v0, Landroid/content/Intent;

    const-string v1, "Body"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v0

    .line 243
    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->a:Landroid/content/Context;

    invoke-static {v1}, Landroid/support/v4/content/LocalBroadcastManager;->a(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v4/content/LocalBroadcastManager;->a(Landroid/content/Intent;)Z

    .line 245
    :cond_3
    return-void

    .line 226
    :cond_4
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->e:Lcom/salesforce/android/cases/core/CaseClientCallbacks;

    invoke-interface {v0, p1}, Lcom/salesforce/android/cases/core/CaseClientCallbacks;->a(Landroid/os/Bundle;)Z

    move-result v0

    goto :goto_0
.end method

.method public a(Lcom/salesforce/android/cases/core/NotificationHandler;)V
    .locals 0

    .prologue
    .line 124
    iput-object p1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->h:Lcom/salesforce/android/cases/core/NotificationHandler;

    .line 125
    return-void
.end method

.method public b(Lcom/salesforce/android/cases/core/requests/ListViewRequest;)Lcom/salesforce/android/service/common/utilities/control/Async;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/salesforce/android/cases/core/requests/ListViewRequest;",
            ")",
            "Lcom/salesforce/android/service/common/utilities/control/Async",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 154
    iget-object v0, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->d:Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;

    iget-object v1, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->f:Lcom/salesforce/android/cases/core/internal/local/LocalRepository;

    iget-object v2, p0, Lcom/salesforce/android/cases/core/internal/client/CaseClientImpl;->c:Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;

    invoke-virtual {v0, p1, v1, v2}, Lcom/salesforce/android/cases/core/internal/operations/OperationFactory;->b(Lcom/salesforce/android/cases/core/requests/ListViewRequest;Lcom/salesforce/android/cases/core/internal/local/LocalRepository;Lcom/salesforce/android/cases/core/internal/remote/RemoteRepository;)Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 155
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->e()Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;

    move-result-object v0

    .line 156
    invoke-interface {v0}, Lcom/salesforce/android/service/common/fetchsave/internal/operations/Operation;->f()Lcom/salesforce/android/service/common/utilities/control/Async;

    move-result-object v0

    .line 154
    return-object v0
.end method
