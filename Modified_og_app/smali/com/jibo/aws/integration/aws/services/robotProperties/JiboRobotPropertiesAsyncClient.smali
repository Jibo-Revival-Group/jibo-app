.class public Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;
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
.method public createRobot(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;->createRobot(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    move-result-object v0

    return-object v0
.end method

.method public createRobot(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/robotProperties/model/CreateRobotRequest;",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient$2;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient$2;-><init>(Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public getFriendlyIds(I)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/robotProperties/model/IdPair;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;->getFriendlyIds(I)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getFriendlyIds(ILcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetFriendlyIdsRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/robotProperties/model/IdPair;",
            ">;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/robotProperties/model/IdPair;",
            ">;>;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient$1;-><init>(Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;ILcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;

    move-result-object v0

    return-object v0
.end method

.method public getJiboClient()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;
    .locals 1

    invoke-super {p0}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;

    move-result-object v0

    return-object v0
.end method

.method public getRobot(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;->getRobot(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;

    move-result-object v0

    return-object v0
.end method

.method public getRobot(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/robotProperties/model/GetRobotRequest;",
            "Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient$4;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient$4;-><init>(Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public removeRobot(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;->removeRobot(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    move-result-object v0

    return-object v0
.end method

.method public removeRobot(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/robotProperties/model/RemoveRobotRequest;",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient$5;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient$5;-><init>(Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public updateRobot(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesClient;->updateRobot(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    move-result-object v0

    return-object v0
.end method

.method public updateRobot(Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/robotProperties/model/CreateRobotRequest;",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient$3;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient$3;-><init>(Lcom/jibo/aws/integration/aws/services/robotProperties/JiboRobotPropertiesAsyncClient;Lcom/jibo/aws/integration/aws/services/robotProperties/model/Robot;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
