.class public abstract Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;
.super Lcom/amazonaws/AmazonWebServiceClient;


# static fields
.field public static final TAG:Ljava/lang/String;


# instance fields
.field protected a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazonaws/transform/JsonErrorUnmarshaller;",
            ">;"
        }
    .end annotation
.end field

.field protected b:Lcom/amazonaws/auth/AWSCredentialsProvider;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;

    invoke-static {v0}, Lcom/jibo/aws/integration/util/a;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;)V
    .locals 1

    new-instance v0, Lcom/amazonaws/ClientConfiguration;

    invoke-direct {v0}, Lcom/amazonaws/ClientConfiguration;-><init>()V

    invoke-direct {p0, p1, v0}, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;)V
    .locals 1

    new-instance v0, Lcom/amazonaws/internal/StaticCredentialsProvider;

    invoke-direct {v0, p1}, Lcom/amazonaws/internal/StaticCredentialsProvider;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    invoke-direct {p0, v0, p2}, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;)V
    .locals 1

    new-instance v0, Lcom/amazonaws/ClientConfiguration;

    invoke-direct {v0}, Lcom/amazonaws/ClientConfiguration;-><init>()V

    invoke-direct {p0, p1, v0}, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V
    .locals 1

    new-instance v0, Lcom/amazonaws/http/UrlHttpClient;

    invoke-direct {v0, p2}, Lcom/amazonaws/http/UrlHttpClient;-><init>(Lcom/amazonaws/ClientConfiguration;)V

    invoke-direct {p0, p1, p2, v0}, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;Lcom/amazonaws/http/HttpClient;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;Lcom/amazonaws/http/HttpClient;)V
    .locals 1

    invoke-static {p2}, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->a(Lcom/amazonaws/ClientConfiguration;)Lcom/amazonaws/ClientConfiguration;

    move-result-object v0

    invoke-direct {p0, v0, p3}, Lcom/amazonaws/AmazonWebServiceClient;-><init>(Lcom/amazonaws/ClientConfiguration;Lcom/amazonaws/http/HttpClient;)V

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->b:Lcom/amazonaws/auth/AWSCredentialsProvider;

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->a()V

    return-void
.end method

.method private static a(Lcom/amazonaws/ClientConfiguration;)Lcom/amazonaws/ClientConfiguration;
    .locals 0

    return-object p0
.end method

.method private a()V
    .locals 2

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->a:Ljava/util/List;

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/b;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/b;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/c;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/c;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/e;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/e;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/f;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/f;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/g;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/g;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/i;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/i;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/j;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/j;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/j;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/j;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->a:Ljava/util/List;

    new-instance v1, Lcom/amazonaws/transform/JsonErrorUnmarshaller;

    invoke-direct {v1}, Lcom/amazonaws/transform/JsonErrorUnmarshaller;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    sget-object v0, Lcom/jibo/aws/integration/util/Commons;->ROOT_ENDPOINT:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->setEndpoint(Ljava/lang/String;)V

    new-instance v0, Lcom/amazonaws/handlers/HandlerChainFactory;

    invoke-direct {v0}, Lcom/amazonaws/handlers/HandlerChainFactory;-><init>()V

    return-void
.end method


# virtual methods
.method protected a(Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<X:",
            "Ljava/lang/Object;",
            "Y:",
            "Lcom/amazonaws/AmazonWebServiceRequest;",
            ">(",
            "Lcom/amazonaws/Request",
            "<TY;>;",
            "Lcom/amazonaws/http/HttpResponseHandler",
            "<",
            "Lcom/amazonaws/AmazonWebServiceResponse",
            "<TX;>;>;",
            "Lcom/amazonaws/http/ExecutionContext;",
            ")",
            "Lcom/amazonaws/Response",
            "<TX;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->endpoint:Ljava/net/URI;

    invoke-interface {p1, v0}, Lcom/amazonaws/Request;->setEndpoint(Ljava/net/URI;)V

    iget v0, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->timeOffset:I

    invoke-interface {p1, v0}, Lcom/amazonaws/Request;->setTimeOffset(I)V

    invoke-virtual {p3}, Lcom/amazonaws/http/ExecutionContext;->getAwsRequestMetrics()Lcom/amazonaws/util/AWSRequestMetrics;

    move-result-object v1

    sget-object v0, Lcom/amazonaws/util/AWSRequestMetrics$Field;->CredentialsRequestTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v1, v0}, Lcom/amazonaws/util/AWSRequestMetrics;->startEvent(Lcom/amazonaws/metrics/MetricType;)V

    :try_start_0
    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->b:Lcom/amazonaws/auth/AWSCredentialsProvider;

    invoke-interface {v0}, Lcom/amazonaws/auth/AWSCredentialsProvider;->getCredentials()Lcom/amazonaws/auth/AWSCredentials;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    sget-object v2, Lcom/amazonaws/util/AWSRequestMetrics$Field;->CredentialsRequestTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v1, v2}, Lcom/amazonaws/util/AWSRequestMetrics;->endEvent(Lcom/amazonaws/metrics/MetricType;)V

    invoke-interface {p1}, Lcom/amazonaws/Request;->getOriginalRequest()Lcom/amazonaws/AmazonWebServiceRequest;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/amazonaws/AmazonWebServiceRequest;->getRequestCredentials()Lcom/amazonaws/auth/AWSCredentials;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v1}, Lcom/amazonaws/AmazonWebServiceRequest;->getRequestCredentials()Lcom/amazonaws/auth/AWSCredentials;

    move-result-object v0

    :cond_0
    invoke-virtual {p3, v0}, Lcom/amazonaws/http/ExecutionContext;->setCredentials(Lcom/amazonaws/auth/AWSCredentials;)V

    new-instance v0, Lcom/amazonaws/http/JsonErrorResponseHandler;

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->a:Ljava/util/List;

    invoke-direct {v0, v1}, Lcom/amazonaws/http/JsonErrorResponseHandler;-><init>(Ljava/util/List;)V

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->client:Lcom/amazonaws/http/AmazonHttpClient;

    invoke-virtual {v1, p1, p2, v0, p3}, Lcom/amazonaws/http/AmazonHttpClient;->execute(Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;

    move-result-object v0

    return-object v0

    :catchall_0
    move-exception v0

    sget-object v2, Lcom/amazonaws/util/AWSRequestMetrics$Field;->CredentialsRequestTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v1, v2}, Lcom/amazonaws/util/AWSRequestMetrics;->endEvent(Lcom/amazonaws/metrics/MetricType;)V

    throw v0
.end method

.method protected a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;Lcom/jibo/aws/integration/aws/services/common/model/a/e;Lcom/amazonaws/transform/Unmarshaller;)Lcom/amazonaws/Response;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<X:",
            "Ljava/lang/Object;",
            "Y:",
            "Lcom/amazonaws/AmazonWebServiceRequest;",
            ">(",
            "Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;",
            "Lcom/jibo/aws/integration/aws/services/common/model/a/e;",
            "Lcom/amazonaws/transform/Unmarshaller",
            "<TX;",
            "Lcom/amazonaws/transform/JsonUnmarshallerContext;",
            ">;)",
            "Lcom/amazonaws/Response",
            "<TX;>;"
        }
    .end annotation

    const/4 v2, 0x0

    const/4 v7, 0x1

    invoke-virtual {p0, p1}, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->createExecutionContext(Lcom/amazonaws/AmazonWebServiceRequest;)Lcom/amazonaws/http/ExecutionContext;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazonaws/http/ExecutionContext;->getAwsRequestMetrics()Lcom/amazonaws/util/AWSRequestMetrics;

    move-result-object v4

    sget-object v0, Lcom/amazonaws/util/AWSRequestMetrics$Field;->ClientExecuteTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v4, v0}, Lcom/amazonaws/util/AWSRequestMetrics;->startEvent(Lcom/amazonaws/metrics/MetricType;)V

    :try_start_0
    sget-object v0, Lcom/amazonaws/util/AWSRequestMetrics$Field;->RequestMarshallTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v4, v0}, Lcom/amazonaws/util/AWSRequestMetrics;->startEvent(Lcom/amazonaws/metrics/MetricType;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    if-nez p2, :cond_0

    :try_start_1
    new-instance p2, Lcom/jibo/aws/integration/aws/services/common/model/a/e;

    invoke-direct {p2}, Lcom/jibo/aws/integration/aws/services/common/model/a/e;-><init>()V

    :cond_0
    invoke-virtual {p2, p1}, Lcom/jibo/aws/integration/aws/services/common/model/a/e;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;)Lcom/amazonaws/Request;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v1

    :try_start_2
    invoke-interface {v1, v4}, Lcom/amazonaws/Request;->setAWSRequestMetrics(Lcom/amazonaws/util/AWSRequestMetrics;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_3

    :try_start_3
    sget-object v0, Lcom/amazonaws/util/AWSRequestMetrics$Field;->RequestMarshallTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v4, v0}, Lcom/amazonaws/util/AWSRequestMetrics;->endEvent(Lcom/amazonaws/metrics/MetricType;)V

    :goto_0
    new-instance v0, Lcom/amazonaws/http/JsonResponseHandler;

    invoke-direct {v0, p3}, Lcom/amazonaws/http/JsonResponseHandler;-><init>(Lcom/amazonaws/transform/Unmarshaller;)V

    invoke-virtual {p0, v1, v0, v3}, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->a(Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v0

    invoke-virtual {p0, v4, v1, v0, v7}, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->endClientExecution(Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V

    return-object v0

    :catch_0
    move-exception v0

    move-object v1, v2

    :goto_1
    :try_start_4
    sget-object v5, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->TAG:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6, v0}, Lcom/jibo/aws/integration/util/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_3

    :try_start_5
    sget-object v0, Lcom/amazonaws/util/AWSRequestMetrics$Field;->RequestMarshallTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v4, v0}, Lcom/amazonaws/util/AWSRequestMetrics;->endEvent(Lcom/amazonaws/metrics/MetricType;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    :goto_2
    invoke-virtual {p0, v4, v1, v2, v7}, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->endClientExecution(Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V

    throw v0

    :catchall_1
    move-exception v0

    move-object v1, v2

    :goto_3
    :try_start_6
    sget-object v3, Lcom/amazonaws/util/AWSRequestMetrics$Field;->RequestMarshallTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v4, v3}, Lcom/amazonaws/util/AWSRequestMetrics;->endEvent(Lcom/amazonaws/metrics/MetricType;)V

    throw v0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    :catchall_2
    move-exception v0

    move-object v1, v2

    goto :goto_2

    :catchall_3
    move-exception v0

    goto :goto_3

    :catch_1
    move-exception v0

    goto :goto_1
.end method

.method public getAwsCredentialsProvider()Lcom/amazonaws/auth/AWSCredentialsProvider;
    .locals 1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/AbstractJiboClient;->b:Lcom/amazonaws/auth/AWSCredentialsProvider;

    return-object v0
.end method

.method public setEndpoint(Ljava/lang/String;)V
    .locals 0

    invoke-super {p0, p1}, Lcom/amazonaws/AmazonWebServiceClient;->setEndpoint(Ljava/lang/String;)V

    return-void
.end method

.method public setRegion(Lcom/amazonaws/regions/Region;)V
    .locals 0

    invoke-super {p0, p1}, Lcom/amazonaws/AmazonWebServiceClient;->setRegion(Lcom/amazonaws/regions/Region;)V

    return-void
.end method
