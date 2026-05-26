.class public Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;
.super Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;"
    }
.end annotation


# direct methods
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
.method public backupEncryptedKey(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;->backupEncryptedKey(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    move-result-object v0

    return-object v0
.end method

.method public backupEncryptedKey(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/key/model/BackupRequest;",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v6

    new-instance v0, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient$5;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient$5;-><init>(Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v6, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public createRequest(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/key/model/Request;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;->createRequest(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/key/model/Request;

    move-result-object v0

    return-object v0
.end method

.method public createRequest(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/key/model/CreateRequest;",
            "Lcom/jibo/aws/integration/aws/services/key/model/Request;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/key/model/Request;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient$2;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient$2;-><init>(Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;

    move-result-object v0

    return-object v0
.end method

.method public getJiboClient()Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;
    .locals 1

    invoke-super {p0}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;

    move-result-object v0

    return-object v0
.end method

.method public getRequest(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/key/model/Request;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;->getRequest(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/key/model/Request;

    move-result-object v0

    return-object v0
.end method

.method public getRequest(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/key/model/GetRequest;",
            "Lcom/jibo/aws/integration/aws/services/key/model/Request;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/key/model/Request;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient$1;-><init>(Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public listIncomingRequests(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/key/model/Request;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;->listIncomingRequests(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public listIncomingRequests(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/key/model/ListIncomingRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/key/model/Request;",
            ">;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/key/model/Request;",
            ">;>;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient$4;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient$4;-><init>(Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public restoreEncryptedKey(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/key/model/Backup;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;->restoreEncryptedKey(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/key/model/Backup;

    move-result-object v0

    return-object v0
.end method

.method public restoreEncryptedKey(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/key/model/RestoreRequest;",
            "Lcom/jibo/aws/integration/aws/services/key/model/Backup;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/key/model/Backup;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient$6;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient$6;-><init>(Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public share(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/key/model/Request;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyClient;->share(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/key/model/Request;

    move-result-object v0

    return-object v0
.end method

.method public share(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/key/model/ShareRequest;",
            "Lcom/jibo/aws/integration/aws/services/key/model/Request;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/key/model/Request;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient$3;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient$3;-><init>(Lcom/jibo/aws/integration/aws/services/key/JiboKeyAsyncClient;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
