.class public Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;
.super Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;-><init>()V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V

    return-void
.end method


# virtual methods
.method public activateByCode(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->activateByCode(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    return-object v0
.end method

.method public activateByCode(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/ActivateByCodeRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$20;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$20;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public activateById(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->activateById(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    return-object v0
.end method

.method public activateById(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/ActivateByIdRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$21;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$21;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public changeEmail(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->changeEmail(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;

    move-result-object v0

    return-object v0
.end method

.method public changeEmail(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/ChangeEmailRequest;",
            "Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$15;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$15;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public changePassword(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->changePassword(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    return-object v0
.end method

.method public changePassword(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/ChangePasswordRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$3;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$3;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    return-object v0
.end method

.method public create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v6

    new-instance v0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$1;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$1;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v6, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public createAccessToken()Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->createAccessToken()Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;

    move-result-object v0

    return-object v0
.end method

.method public createAccessToken(Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/CreateAccessTokenRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$8;

    invoke-direct {v1, p0, p1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$8;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public facebookConnect(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->facebookConnect(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    return-object v0
.end method

.method public facebookConnect(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/FacebookConnectRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$10;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$10;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public facebookMobileConnect(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->facebookMobileConnect(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;

    move-result-object v0

    return-object v0
.end method

.method public facebookMobileConnect(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/FacebookMobileConnectRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/TokenContainer;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$11;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$11;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public facebookPrepareLogin()Lcom/jibo/aws/integration/aws/services/account/model/FacebookPrepareLogin;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->facebookPrepareLogin()Lcom/jibo/aws/integration/aws/services/account/model/FacebookPrepareLogin;

    move-result-object v0

    return-object v0
.end method

.method public facebookPrepareLogin(Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/FacebookPrepareLoginRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/FacebookPrepareLogin;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/FacebookPrepareLogin;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$9;

    invoke-direct {v1, p0, p1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$9;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public get(Ljava/util/List;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->get(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public get(Ljava/util/List;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/GetRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;>;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$17;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$17;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Ljava/util/List;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    return-object v0
.end method

.method public getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;
    .locals 1

    invoke-super {p0}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    return-object v0
.end method

.method public login(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->login(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    return-object v0
.end method

.method public login(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/AccountRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$12;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$12;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public logout()V
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->logout()V

    return-void
.end method

.method public passwordResetByCode(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->passwordResetByCode(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    return-object v0
.end method

.method public passwordResetByCode(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/PasswordResetByCodeRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$5;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$5;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public remove()Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->remove()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    return-object v0
.end method

.method public remove(Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/RemoveRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$19;

    invoke-direct {v1, p0, p1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$19;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public removePhoto()Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->removePhoto()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    return-object v0
.end method

.method public removePhoto(Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/RemovePhotoRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$7;

    invoke-direct {v1, p0, p1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$7;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public resendActivationCode(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->resendActivationCode(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    return-object v0
.end method

.method public resendActivationCode(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/EmailRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$22;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$22;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public resetKeys()Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->resetKeys()Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    return-object v0
.end method

.method public resetKeys(Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/ResetKeysRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$16;

    invoke-direct {v1, p0, p1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$16;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public search(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->search(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public search(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/SearchRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;>;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$2;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$2;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public sendPasswordReset(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->sendPasswordReset(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    return-object v0
.end method

.method public sendPasswordReset(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/SendPasswordResetRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$4;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$4;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public sendPhoneVerificationCode(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->sendPhoneVerificationCode(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;

    move-result-object v0

    return-object v0
.end method

.method public sendPhoneVerificationCode(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/SendPhoneVerificationCodeRequest;",
            "Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/IdResponse;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$13;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$13;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public update(Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->update(Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;)Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    return-object v0
.end method

.method public update(Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$18;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$18;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Lcom/jibo/aws/integration/aws/services/account/model/UpdateRequest;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public updatePhoto(Ljava/io/File;Ljava/util/Map;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->updatePhoto(Ljava/io/File;Ljava/util/Map;)Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    return-object v0
.end method

.method public updatePhoto(Ljava/io/File;Ljava/util/Map;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/UpdatePhotoRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$6;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$6;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Ljava/io/File;Ljava/util/Map;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public verifyPhoneByCode(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountClient;->verifyPhoneByCode(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/account/model/Account;

    move-result-object v0

    return-object v0
.end method

.method public verifyPhoneByCode(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/VerifyPhoneByCodeRequest;",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/account/model/Account;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$14;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient$14;-><init>(Lcom/jibo/aws/integration/aws/services/account/JiboAccountAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
