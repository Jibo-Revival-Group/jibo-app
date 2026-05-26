.class public Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;
.super Lcom/jibo/aws/integration/aws/services/file/JiboFileClient;


# instance fields
.field private d:Ljava/util/concurrent/ExecutorService;


# direct methods
.method public constructor <init>()V
    .locals 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    new-instance v0, Lcom/amazonaws/auth/DefaultAWSCredentialsProviderChain;

    invoke-direct {v0}, Lcom/amazonaws/auth/DefaultAWSCredentialsProviderChain;-><init>()V

    new-instance v1, Lcom/amazonaws/ClientConfiguration;

    invoke-direct {v1}, Lcom/amazonaws/ClientConfiguration;-><init>()V

    invoke-direct {p0, v0, v1}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/ClientConfiguration;)V
    .locals 3
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    new-instance v0, Lcom/amazonaws/auth/BasicAWSCredentials;

    const-string v1, ""

    const-string v2, ""

    invoke-direct {v0, v1, v2}, Lcom/amazonaws/auth/BasicAWSCredentials;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/amazonaws/ClientConfiguration;->getMaxConnections()I

    move-result v1

    invoke-static {v1}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v1

    invoke-direct {p0, v0, p1, v1}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;Ljava/util/concurrent/ExecutorService;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;)V
    .locals 1

    const/16 v0, 0xa

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;Ljava/util/concurrent/ExecutorService;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;Ljava/util/concurrent/ExecutorService;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/file/JiboFileClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;)V

    iput-object p3, p0, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;->d:Ljava/util/concurrent/ExecutorService;

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;Ljava/util/concurrent/ExecutorService;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/jibo/aws/integration/aws/services/file/JiboFileClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    iput-object p2, p0, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;->d:Ljava/util/concurrent/ExecutorService;

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;)V
    .locals 1

    const/16 v0, 0xa

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Ljava/util/concurrent/ExecutorService;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V
    .locals 1

    invoke-virtual {p2}, Lcom/amazonaws/ClientConfiguration;->getMaxConnections()I

    move-result v0

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newFixedThreadPool(I)Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    invoke-direct {p0, p1, p2, v0}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;Ljava/util/concurrent/ExecutorService;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;Ljava/util/concurrent/ExecutorService;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/file/JiboFileClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V

    iput-object p3, p0, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;->d:Ljava/util/concurrent/ExecutorService;

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Ljava/util/concurrent/ExecutorService;)V
    .locals 1

    new-instance v0, Lcom/amazonaws/ClientConfiguration;

    invoke-direct {v0}, Lcom/amazonaws/ClientConfiguration;-><init>()V

    invoke-direct {p0, p1, v0, p2}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;Ljava/util/concurrent/ExecutorService;)V

    return-void
.end method


# virtual methods
.method public getExecutorService()Ljava/util/concurrent/ExecutorService;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;->d:Ljava/util/concurrent/ExecutorService;

    return-object v0
.end method

.method public getFile(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/file/model/GetFileRequest;",
            "Lcom/jibo/aws/integration/aws/services/file/model/FileLink;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/file/model/FileLink;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;->d:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient$4;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient$4;-><init>(Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public listFiles(Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/file/model/ListFilesRequest;",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/file/model/FileLink;",
            ">;>;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/file/model/FileLink;",
            ">;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;->d:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient$3;

    invoke-direct {v1, p0, p1}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient$3;-><init>(Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public removeFile(Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/file/model/RemoveFileRequest;",
            "Lcom/jibo/aws/integration/aws/services/file/model/FileLink;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/file/model/FileLink;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;->d:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient$2;

    invoke-direct {v1, p0, p1, p2}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient$2;-><init>(Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;Ljava/lang/String;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method

.method public shutdown()V
    .locals 1

    invoke-super {p0}, Lcom/jibo/aws/integration/aws/services/file/JiboFileClient;->shutdown()V

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;->d:Ljava/util/concurrent/ExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ExecutorService;->shutdownNow()Ljava/util/List;

    return-void
.end method

.method public uploadFile(Ljava/lang/String;Ljava/io/File;Lcom/amazonaws/handlers/AsyncHandler;)Ljava/util/concurrent/Future;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/io/File;",
            "Lcom/amazonaws/handlers/AsyncHandler",
            "<",
            "Lcom/jibo/aws/integration/aws/services/file/model/UploadFileRequest;",
            "Lcom/jibo/aws/integration/aws/services/file/model/FileLink;",
            ">;)",
            "Ljava/util/concurrent/Future",
            "<",
            "Lcom/jibo/aws/integration/aws/services/file/model/FileLink;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;->d:Ljava/util/concurrent/ExecutorService;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient$1;

    invoke-direct {v1, p0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient$1;-><init>(Lcom/jibo/aws/integration/aws/services/file/JiboFileAsyncClient;Ljava/lang/String;Ljava/io/File;Lcom/amazonaws/handlers/AsyncHandler;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    move-result-object v0

    return-object v0
.end method
