.class public Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;
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
.method public createDevice(Lcom/jibo/aws/integration/aws/services/common/model/Device;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/aws/integration/aws/services/common/model/Device;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/Device;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/push/JiboPushClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/push/JiboPushClient;->createDevice(Lcom/jibo/aws/integration/aws/services/common/model/Device;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public createDevice(Lcom/jibo/aws/integration/aws/services/common/model/Device;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/aws/integration/aws/services/common/model/Device;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/push/model/CreateDeviceRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/Device;",
            ">;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/Device;",
            ">;>;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient$3;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient$3;-><init>(Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;Lcom/jibo/aws/integration/aws/services/common/model/Device;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/push/JiboPushClient;

    move-result-object v0

    return-object v0
.end method

.method public getJiboClient()Lcom/jibo/aws/integration/aws/services/push/JiboPushClient;
    .locals 1

    invoke-super {p0}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/push/JiboPushClient;

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/push/JiboPushClient;

    move-result-object v0

    return-object v0
.end method

.method public getJotNotificationsMode()Lcom/jibo/aws/integration/aws/services/push/model/JotNotificationsModeResponse;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/push/JiboPushClient;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushClient;->getJotNotificationsMode()Lcom/jibo/aws/integration/aws/services/push/model/JotNotificationsModeResponse;

    move-result-object v0

    return-object v0
.end method

.method public getJotNotificationsMode(Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/push/model/GetJotNotificationsModeRequest;",
            "Lcom/jibo/aws/integration/aws/services/push/model/JotNotificationsModeResponse;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/push/model/JotNotificationsModeResponse;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient$2;

    invoke-direct {v1, p0, p1}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient$2;-><init>(Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public removeDevice(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/Device;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/push/JiboPushClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/push/JiboPushClient;->removeDevice(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public removeDevice(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/push/model/RemoveDeviceRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/Device;",
            ">;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/Device;",
            ">;>;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient$4;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient$4;-><init>(Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public updateJotNotificationsMode(Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;)Lcom/jibo/aws/integration/aws/services/push/model/JotNotificationsModeResponse;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/push/JiboPushClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/push/JiboPushClient;->updateJotNotificationsMode(Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;)Lcom/jibo/aws/integration/aws/services/push/model/JotNotificationsModeResponse;

    move-result-object v0

    return-object v0
.end method

.method public updateJotNotificationsMode(Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/push/model/UpdateJotNotificationsModeRequest;",
            "Lcom/jibo/aws/integration/aws/services/push/model/JotNotificationsModeResponse;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/push/model/JotNotificationsModeResponse;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient$1;-><init>(Lcom/jibo/aws/integration/aws/services/push/JiboPushAsyncClient;Lcom/jibo/aws/integration/aws/services/push/model/JotPushNotificationsMode;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
