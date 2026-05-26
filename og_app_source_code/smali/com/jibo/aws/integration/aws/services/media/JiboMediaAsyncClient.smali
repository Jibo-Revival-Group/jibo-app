.class public Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;
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
.method public create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/Boolean;)Lcom/jibo/aws/integration/aws/services/media/model/Media;
    .locals 7

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    move-result-object v0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    invoke-virtual/range {v0 .. v6}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;->create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/Boolean;)Lcom/jibo/aws/integration/aws/services/media/model/Media;

    move-result-object v0

    return-object v0
.end method

.method public create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/Boolean;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/io/File;",
            "Ljava/lang/Boolean;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/media/model/CreateRequest;",
            "Lcom/jibo/aws/integration/aws/services/media/model/Media;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/media/model/Media;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v9

    new-instance v0, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient$1;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-object v6, p5

    move-object/from16 v7, p6

    move-object/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient$1;-><init>(Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/io/File;Ljava/lang/Boolean;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v9, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

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
            "Lcom/jibo/aws/integration/aws/services/media/model/Media;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;->get(Ljava/util/List;)Ljava/util/List;

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
            "Lcom/jibo/aws/integration/aws/services/media/model/GetRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/media/model/Media;",
            ">;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/media/model/Media;",
            ">;>;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient$4;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient$4;-><init>(Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;Ljava/util/List;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    move-result-object v0

    return-object v0
.end method

.method public getJiboClient()Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;
    .locals 1

    invoke-super {p0}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    move-result-object v0

    return-object v0
.end method

.method public list(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/Long;",
            "Ljava/lang/Long;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/media/model/Media;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;->list(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public list(Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/Long;",
            "Ljava/lang/Long;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/media/model/ListRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/media/model/Media;",
            ">;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/media/model/Media;",
            ">;>;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v6

    new-instance v0, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient$2;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient$2;-><init>(Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;Ljava/util/List;Ljava/lang/Long;Ljava/lang/Long;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v6, v0}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public remove(Ljava/util/List;)Ljava/util/List;
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
            "Lcom/jibo/aws/integration/aws/services/media/model/Media;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaClient;->remove(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public remove(Ljava/util/List;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
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
            "Lcom/jibo/aws/integration/aws/services/media/model/RemoveRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/media/model/Media;",
            ">;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/media/model/Media;",
            ">;>;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient$3;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient$3;-><init>(Lcom/jibo/aws/integration/aws/services/media/JiboMediaAsyncClient;Ljava/util/List;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
