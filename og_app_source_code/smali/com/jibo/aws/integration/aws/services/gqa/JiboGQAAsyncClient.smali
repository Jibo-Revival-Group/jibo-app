.class public Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;
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

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAClient;

    move-result-object v0

    return-object v0
.end method

.method public getJiboClient()Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAClient;
    .locals 1

    invoke-super {p0}, Lcom/jibo/aws/integration/aws/services/AbstractJiboAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAClient;

    return-object v0
.end method

.method public bridge synthetic getJiboClient()Ljava/lang/Object;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAClient;

    move-result-object v0

    return-object v0
.end method

.method public listAttributions(Ljava/lang/String;J)Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;
    .locals 2

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAClient;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAClient;->listAttributions(Ljava/lang/String;J)Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;

    move-result-object v0

    return-object v0
.end method

.method public listAttributions(Ljava/lang/String;JLcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "J",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/gqa/model/ListAttributionRequest;",
            "Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/gqa/model/AttributionListResponse;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient$2;

    move-object v2, p0

    move-object v3, p1

    move-wide v4, p2

    move-object v6, p4

    invoke-direct/range {v1 .. v6}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient$2;-><init>(Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;Ljava/lang/String;JLcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public sendQuestion(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;
    .locals 1

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;->getJiboClient()Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAClient;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAClient;->sendQuestion(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;

    move-result-object v0

    return-object v0
.end method

.method public sendQuestion(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/gqa/model/QuestionRequest;",
            "Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/gqa/model/GQAAttribution;",
            ">;"
        }
    .end annotation

    invoke-virtual {p0}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;->c()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    new-instance v1, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient$1;-><init>(Lcom/jibo/aws/integration/aws/services/gqa/JiboGQAAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
