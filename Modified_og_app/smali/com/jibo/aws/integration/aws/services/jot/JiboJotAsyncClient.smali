.class public Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;
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
.method public createMessage(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/jibo/aws/integration/aws/services/jot/model/Message;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/jibo/aws/integration/aws/services/jot/model/Message;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/jot/JiboJotClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotClient;->createMessage(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/jibo/aws/integration/aws/services/jot/model/Message;

    move-result-object v0

    return-object v0
.end method

.method public createMessage(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/jot/model/MessagePart;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/jot/model/CreateMessageRequest;",
            "Lcom/jibo/aws/integration/aws/services/jot/model/Message;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/jot/model/Message;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v7

    new-instance v0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$1;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$1;-><init>(Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v7, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/jot/JiboJotClient;

    move-result-object v0

    return-object v0
.end method

.method public getJiboClient()Lcom/jibo/aws/integration/aws/services/jot/JiboJotClient;
    .locals 1

    invoke-super {p0}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotClient;

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/jot/JiboJotClient;

    move-result-object v0

    return-object v0
.end method

.method public listMessages(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            "Ljava/lang/Long;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/jot/model/Message;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/jot/JiboJotClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotClient;->listMessages(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public listMessages(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            "Ljava/lang/Long;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/jot/model/ListMessagesRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/jot/model/Message;",
            ">;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/jot/model/Message;",
            ">;>;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v6

    new-instance v0, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$2;-><init>(Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v6, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public markRead(Ljava/util/List;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/jot/JiboJotClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotClient;->markRead(Ljava/util/List;)Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;

    move-result-object v0

    return-object v0
.end method

.method public markRead(Ljava/util/List;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
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
            "Lcom/jibo/aws/integration/aws/services/jot/model/MarkReadRequest;",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/common/model/CommandResponse;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$3;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient$3;-><init>(Lcom/jibo/aws/integration/aws/services/jot/JiboJotAsyncClient;Ljava/util/List;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
