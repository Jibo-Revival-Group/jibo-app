.class public Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;
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
.method public bridge synthetic getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeClient;

    move-result-object v0

    return-object v0
.end method

.method public getJiboClient()Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeClient;
    .locals 1

    invoke-super {p0}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeClient;

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeClient;

    move-result-object v0

    return-object v0
.end method

.method public getStatus(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/oobe/model/StatusContainer;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeClient;->getStatus(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/oobe/model/StatusContainer;

    move-result-object v0

    return-object v0
.end method

.method public getStatus(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/oobe/model/GetStatusRequest;",
            "Lcom/jibo/aws/integration/aws/services/oobe/model/StatusContainer;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/oobe/model/StatusContainer;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient$3;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient$3;-><init>(Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public prepareRobot(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeClient;->prepareRobot(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;

    move-result-object v0

    return-object v0
.end method

.method public prepareRobot(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/oobe/model/PrepareRobotRequest;",
            "Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/oobe/model/TokenContainer;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient$1;-><init>(Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public setupRobot(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/oobe/model/KeysContainer;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeClient;->setupRobot(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/oobe/model/KeysContainer;

    move-result-object v0

    return-object v0
.end method

.method public setupRobot(Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/oobe/model/SetupRobotRequest;",
            "Lcom/jibo/aws/integration/aws/services/oobe/model/KeysContainer;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/oobe/model/KeysContainer;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient$2;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient$2;-><init>(Lcom/jibo/aws/integration/aws/services/oobe/JiboOobeAsyncClient;Ljava/lang/String;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
