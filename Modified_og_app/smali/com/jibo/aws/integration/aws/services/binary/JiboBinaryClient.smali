.class public Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;
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

.field protected b:Ljava/lang/String;

.field protected c:Ljava/lang/String;

.field private d:Lcom/amazonaws/auth/AWSCredentialsProvider;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const-class v0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;

    invoke-static {v0}, Lcom/jibo/aws/integration/util/a;->a(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    new-instance v0, Lcom/amazonaws/auth/DefaultAWSCredentialsProviderChain;

    invoke-direct {v0}, Lcom/amazonaws/auth/DefaultAWSCredentialsProviderChain;-><init>()V

    new-instance v1, Lcom/amazonaws/ClientConfiguration;

    invoke-direct {v1}, Lcom/amazonaws/ClientConfiguration;-><init>()V

    invoke-direct {p0, v0, v1}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/ClientConfiguration;)V
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    new-instance v0, Lcom/amazonaws/auth/DefaultAWSCredentialsProviderChain;

    invoke-direct {v0}, Lcom/amazonaws/auth/DefaultAWSCredentialsProviderChain;-><init>()V

    invoke-direct {p0, v0, p1}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;)V
    .locals 1

    new-instance v0, Lcom/amazonaws/ClientConfiguration;

    invoke-direct {v0}, Lcom/amazonaws/ClientConfiguration;-><init>()V

    invoke-direct {p0, p1, v0}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;-><init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentials;Lcom/amazonaws/ClientConfiguration;)V
    .locals 1

    new-instance v0, Lcom/amazonaws/internal/StaticCredentialsProvider;

    invoke-direct {v0, p1}, Lcom/amazonaws/internal/StaticCredentialsProvider;-><init>(Lcom/amazonaws/auth/AWSCredentials;)V

    invoke-direct {p0, v0, p2}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;)V
    .locals 1

    new-instance v0, Lcom/amazonaws/ClientConfiguration;

    invoke-direct {v0}, Lcom/amazonaws/ClientConfiguration;-><init>()V

    invoke-direct {p0, p1, v0}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;)V
    .locals 1

    new-instance v0, Lcom/amazonaws/http/UrlHttpClient;

    invoke-direct {v0, p2}, Lcom/amazonaws/http/UrlHttpClient;-><init>(Lcom/amazonaws/ClientConfiguration;)V

    invoke-direct {p0, p1, p2, v0}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;-><init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;Lcom/amazonaws/http/HttpClient;)V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;Lcom/amazonaws/http/HttpClient;)V
    .locals 1

    invoke-static {p2}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a(Lcom/amazonaws/ClientConfiguration;)Lcom/amazonaws/ClientConfiguration;

    move-result-object v0

    invoke-direct {p0, v0, p3}, Lcom/amazonaws/AmazonWebServiceClient;-><init>(Lcom/amazonaws/ClientConfiguration;Lcom/amazonaws/http/HttpClient;)V

    const-string v0, "binary"

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->b:Ljava/lang/String;

    const-string v0, "Binary_20151201."

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->c:Ljava/lang/String;

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->d:Lcom/amazonaws/auth/AWSCredentialsProvider;

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a()V

    return-void
.end method

.method public constructor <init>(Lcom/amazonaws/auth/AWSCredentialsProvider;Lcom/amazonaws/ClientConfiguration;Lcom/amazonaws/metrics/RequestMetricCollector;)V
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    invoke-static {p2}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a(Lcom/amazonaws/ClientConfiguration;)Lcom/amazonaws/ClientConfiguration;

    move-result-object v0

    invoke-direct {p0, v0, p3}, Lcom/amazonaws/AmazonWebServiceClient;-><init>(Lcom/amazonaws/ClientConfiguration;Lcom/amazonaws/metrics/RequestMetricCollector;)V

    const-string v0, "binary"

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->b:Ljava/lang/String;

    const-string v0, "Binary_20151201."

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->c:Ljava/lang/String;

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->d:Lcom/amazonaws/auth/AWSCredentialsProvider;

    invoke-direct {p0}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a()V

    return-void
.end method

.method private static a(Lcom/amazonaws/ClientConfiguration;)Lcom/amazonaws/ClientConfiguration;
    .locals 0

    return-object p0
.end method

.method private a(Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;
    .locals 5
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

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->endpoint:Ljava/net/URI;

    invoke-interface {p1, v0}, Lcom/amazonaws/Request;->setEndpoint(Ljava/net/URI;)V

    iget v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->timeOffset:I

    invoke-interface {p1, v0}, Lcom/amazonaws/Request;->setTimeOffset(I)V

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->c:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-interface {p1}, Lcom/amazonaws/Request;->getHeaders()Ljava/util/Map;

    move-result-object v0

    const-string v1, "X-Amz-Target"

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-interface {p1}, Lcom/amazonaws/Request;->getHeaders()Ljava/util/Map;

    move-result-object v1

    const-string v2, "X-Amz-Target"

    const-string v3, "$TARGET$."

    iget-object v4, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->c:Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->b:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->b:Ljava/lang/String;

    invoke-interface {p1, v0}, Lcom/amazonaws/Request;->setServiceName(Ljava/lang/String;)V

    :cond_1
    invoke-virtual {p3}, Lcom/amazonaws/http/ExecutionContext;->getAwsRequestMetrics()Lcom/amazonaws/util/AWSRequestMetrics;

    move-result-object v1

    sget-object v0, Lcom/amazonaws/util/AWSRequestMetrics$Field;->CredentialsRequestTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v1, v0}, Lcom/amazonaws/util/AWSRequestMetrics;->startEvent(Lcom/amazonaws/metrics/MetricType;)V

    :try_start_0
    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->d:Lcom/amazonaws/auth/AWSCredentialsProvider;

    invoke-interface {v0}, Lcom/amazonaws/auth/AWSCredentialsProvider;->getCredentials()Lcom/amazonaws/auth/AWSCredentials;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    sget-object v2, Lcom/amazonaws/util/AWSRequestMetrics$Field;->CredentialsRequestTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v1, v2}, Lcom/amazonaws/util/AWSRequestMetrics;->endEvent(Lcom/amazonaws/metrics/MetricType;)V

    invoke-interface {p1}, Lcom/amazonaws/Request;->getOriginalRequest()Lcom/amazonaws/AmazonWebServiceRequest;

    move-result-object v1

    if-eqz v1, :cond_2

    invoke-virtual {v1}, Lcom/amazonaws/AmazonWebServiceRequest;->getRequestCredentials()Lcom/amazonaws/auth/AWSCredentials;

    move-result-object v2

    if-eqz v2, :cond_2

    invoke-virtual {v1}, Lcom/amazonaws/AmazonWebServiceRequest;->getRequestCredentials()Lcom/amazonaws/auth/AWSCredentials;

    move-result-object v0

    :cond_2
    invoke-virtual {p3, v0}, Lcom/amazonaws/http/ExecutionContext;->setCredentials(Lcom/amazonaws/auth/AWSCredentials;)V

    new-instance v0, Lcom/amazonaws/http/JsonErrorResponseHandler;

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a:Ljava/util/List;

    invoke-direct {v0, v1}, Lcom/amazonaws/http/JsonErrorResponseHandler;-><init>(Ljava/util/List;)V

    iget-object v1, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->client:Lcom/amazonaws/http/AmazonHttpClient;

    invoke-virtual {v1, p1, p2, v0, p3}, Lcom/amazonaws/http/AmazonHttpClient;->execute(Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;

    move-result-object v0

    return-object v0

    :catchall_0
    move-exception v0

    sget-object v2, Lcom/amazonaws/util/AWSRequestMetrics$Field;->CredentialsRequestTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v1, v2}, Lcom/amazonaws/util/AWSRequestMetrics;->endEvent(Lcom/amazonaws/metrics/MetricType;)V

    throw v0
.end method

.method private a()V
    .locals 2

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a:Ljava/util/List;

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/h;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/h;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/d;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/d;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/a;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/a;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/b;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/b;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/c;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/c;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/e;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/e;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/f;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/f;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/g;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/g;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/i;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/i;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/j;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/j;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a:Ljava/util/List;

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/a/j;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/exception/a/j;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a:Ljava/util/List;

    new-instance v1, Lcom/amazonaws/transform/JsonErrorUnmarshaller;

    invoke-direct {v1}, Lcom/amazonaws/transform/JsonErrorUnmarshaller;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    sget-object v0, Lcom/jibo/aws/integration/util/Commons;->ROOT_ENDPOINT:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->setEndpoint(Ljava/lang/String;)V

    new-instance v0, Lcom/amazonaws/handlers/HandlerChainFactory;

    invoke-direct {v0}, Lcom/amazonaws/handlers/HandlerChainFactory;-><init>()V

    return-void
.end method

.method public static downloadFileFromUrl(Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    .locals 13

    const/4 v2, 0x0

    sget-object v0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "downloadFileFromUrl: "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " to "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/aws/integration/util/a;->a(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v8

    :try_start_0
    new-instance v0, Ljava/net/URL;

    invoke-direct {v0, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    invoke-static {v0}, Lcom/google/firebase/perf/network/FirebasePerfUrlConnection;->instrument(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/net/URLConnection;

    check-cast v0, Ljava/net/HttpURLConnection;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    :try_start_1
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->connect()V

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v1

    const/16 v3, 0xc8

    if-eq v1, v3, :cond_3

    new-instance v1, Lcom/jibo/aws/integration/aws/services/exception/ResourceNotFoundException;

    invoke-direct {v1, p0}, Lcom/jibo/aws/integration/aws/services/exception/ResourceNotFoundException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    :catch_0
    move-exception v1

    move-object v3, v2

    move-object v12, v0

    move-object v0, v1

    move-object v1, v12

    :goto_0
    :try_start_2
    sget-object v4, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->TAG:Ljava/lang/String;

    const-string v5, "downloadFileFromUrl"

    invoke-static {v4, v5, v0}, Lcom/jibo/aws/integration/util/a;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    new-instance v4, Lcom/jibo/aws/integration/aws/services/exception/ServiceException;

    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v4, v0}, Lcom/jibo/aws/integration/aws/services/exception/ServiceException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :catchall_0
    move-exception v0

    :goto_1
    if-eqz v2, :cond_0

    :try_start_3
    invoke-virtual {v2}, Ljava/io/OutputStream;->close()V

    :cond_0
    if-eqz v3, :cond_1

    invoke-virtual {v3}, Ljava/io/InputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2

    :cond_1
    :goto_2
    if-eqz v1, :cond_2

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_2
    throw v0

    :cond_3
    :try_start_4
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getContentLength()I

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    move-result-object v4

    :try_start_5
    new-instance v3, Ljava/io/FileOutputStream;

    invoke-virtual {p1}, Ljava/io/File;->getAbsoluteFile()Ljava/io/File;

    move-result-object v1

    invoke-direct {v3, v1}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_4
    .catchall {:try_start_5 .. :try_end_5} :catchall_3

    const v1, 0xffff

    :try_start_6
    new-array v1, v1, [B

    const-wide/16 v6, 0x0

    :goto_3
    invoke-virtual {v4, v1}, Ljava/io/InputStream;->read([B)I

    move-result v2

    const/4 v5, -0x1

    if-eq v2, v5, :cond_4

    int-to-long v10, v2

    add-long/2addr v6, v10

    const/4 v5, 0x0

    invoke-virtual {v3, v1, v5, v2}, Ljava/io/OutputStream;->write([BII)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_4

    goto :goto_3

    :catch_1
    move-exception v1

    move-object v2, v3

    move-object v3, v4

    move-object v12, v1

    move-object v1, v0

    move-object v0, v12

    goto :goto_0

    :cond_4
    if-eqz v3, :cond_5

    :try_start_7
    invoke-virtual {v3}, Ljava/io/OutputStream;->close()V

    :cond_5
    if-eqz v4, :cond_6

    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_5

    :cond_6
    :goto_4
    if-eqz v0, :cond_7

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_7
    sget-object v0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "downloadFileFromUrl elapsed: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v2

    sub-long/2addr v2, v8

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " ms result "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/jibo/aws/integration/util/a;->a(Ljava/lang/String;Ljava/lang/String;)V

    return-object p1

    :catch_2
    move-exception v2

    goto :goto_2

    :catchall_1
    move-exception v0

    move-object v1, v2

    move-object v3, v2

    goto :goto_1

    :catchall_2
    move-exception v1

    move-object v3, v2

    move-object v12, v0

    move-object v0, v1

    move-object v1, v12

    goto :goto_1

    :catchall_3
    move-exception v1

    move-object v3, v4

    move-object v12, v0

    move-object v0, v1

    move-object v1, v12

    goto/16 :goto_1

    :catchall_4
    move-exception v1

    move-object v2, v3

    move-object v3, v4

    move-object v12, v1

    move-object v1, v0

    move-object v0, v12

    goto/16 :goto_1

    :catch_3
    move-exception v0

    move-object v1, v2

    move-object v3, v2

    goto/16 :goto_0

    :catch_4
    move-exception v1

    move-object v3, v4

    move-object v12, v0

    move-object v0, v1

    move-object v1, v12

    goto/16 :goto_0

    :catch_5
    move-exception v1

    goto :goto_4
.end method


# virtual methods
.method public create(Ljava/lang/String;Ljava/io/File;Ljava/util/Map;)Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/io/File;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;"
        }
    .end annotation

    const/4 v2, 0x0

    const/4 v7, 0x1

    new-instance v0, Lcom/jibo/aws/integration/aws/services/binary/model/CreateBinaryRequest;

    invoke-direct {v0, p1, p2, p3}, Lcom/jibo/aws/integration/aws/services/binary/model/CreateBinaryRequest;-><init>(Ljava/lang/String;Ljava/io/File;Ljava/util/Map;)V

    invoke-virtual {p0, v0}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->createExecutionContext(Lcom/amazonaws/AmazonWebServiceRequest;)Lcom/amazonaws/http/ExecutionContext;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazonaws/http/ExecutionContext;->getAwsRequestMetrics()Lcom/amazonaws/util/AWSRequestMetrics;

    move-result-object v4

    sget-object v1, Lcom/amazonaws/util/AWSRequestMetrics$Field;->ClientExecuteTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v4, v1}, Lcom/amazonaws/util/AWSRequestMetrics;->startEvent(Lcom/amazonaws/metrics/MetricType;)V

    :try_start_0
    sget-object v1, Lcom/amazonaws/util/AWSRequestMetrics$Field;->RequestMarshallTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v4, v1}, Lcom/amazonaws/util/AWSRequestMetrics;->startEvent(Lcom/amazonaws/metrics/MetricType;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    :try_start_1
    new-instance v1, Lcom/jibo/aws/integration/aws/services/binary/model/a/c;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/binary/model/a/c;-><init>()V

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/binary/model/a/c;->a(Lcom/jibo/aws/integration/aws/services/common/model/JiboRequestAbstract;)Lcom/amazonaws/Request;
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
    new-instance v0, Lcom/jibo/aws/integration/aws/services/binary/model/a/a;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/binary/model/a/a;-><init>()V

    new-instance v5, Lcom/amazonaws/http/JsonResponseHandler;

    invoke-direct {v5, v0}, Lcom/amazonaws/http/JsonResponseHandler;-><init>(Lcom/amazonaws/transform/Unmarshaller;)V

    invoke-direct {p0, v1, v5, v3}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a(Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    invoke-virtual {p0, v4, v1, v2, v7}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->endClientExecution(Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V

    return-object v0

    :catch_0
    move-exception v0

    move-object v1, v2

    :goto_1
    :try_start_4
    sget-object v5, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->TAG:Ljava/lang/String;

    const-string v6, "uploadFile"

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
    invoke-virtual {p0, v4, v1, v2, v7}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->endClientExecution(Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V

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

.method public get(Landroid/content/Context;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;
    .locals 5

    invoke-virtual {p0, p2}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->get(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    :try_start_0
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;->getUrl()Ljava/lang/String;

    move-result-object v1

    const-string v2, "BIN"

    const-string v3, "bin"

    invoke-virtual {p1}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v4

    invoke-static {v2, v3, v4}, Ljava/io/File;->createTempFile(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->downloadFileFromUrl(Ljava/lang/String;Ljava/io/File;)Ljava/io/File;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;->setFile(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v0, Lcom/jibo/aws/integration/aws/services/exception/ResourceNotFoundException;

    invoke-direct {v0, p2}, Lcom/jibo/aws/integration/aws/services/exception/ResourceNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    new-instance v0, Lcom/jibo/aws/integration/aws/services/exception/ResourceNotFoundException;

    invoke-direct {v0, p2}, Lcom/jibo/aws/integration/aws/services/exception/ResourceNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public get(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;
    .locals 8

    const/4 v2, 0x0

    const/4 v7, 0x1

    new-instance v0, Lcom/jibo/aws/integration/aws/services/binary/model/GetBinaryRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/binary/model/GetBinaryRequest;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->createExecutionContext(Lcom/amazonaws/AmazonWebServiceRequest;)Lcom/amazonaws/http/ExecutionContext;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazonaws/http/ExecutionContext;->getAwsRequestMetrics()Lcom/amazonaws/util/AWSRequestMetrics;

    move-result-object v4

    sget-object v1, Lcom/amazonaws/util/AWSRequestMetrics$Field;->ClientExecuteTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v4, v1}, Lcom/amazonaws/util/AWSRequestMetrics;->startEvent(Lcom/amazonaws/metrics/MetricType;)V

    :try_start_0
    sget-object v1, Lcom/amazonaws/util/AWSRequestMetrics$Field;->RequestMarshallTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v4, v1}, Lcom/amazonaws/util/AWSRequestMetrics;->startEvent(Lcom/amazonaws/metrics/MetricType;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    :try_start_1
    new-instance v1, Lcom/jibo/aws/integration/aws/services/binary/model/a/d;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/binary/model/a/d;-><init>()V

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/binary/model/a/d;->a(Lcom/jibo/aws/integration/aws/services/binary/model/PathRequest;)Lcom/amazonaws/Request;
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
    new-instance v0, Lcom/jibo/aws/integration/aws/services/binary/model/a/a;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/binary/model/a/a;-><init>()V

    new-instance v5, Lcom/amazonaws/http/JsonResponseHandler;

    invoke-direct {v5, v0}, Lcom/amazonaws/http/JsonResponseHandler;-><init>(Lcom/amazonaws/transform/Unmarshaller;)V

    invoke-direct {p0, v1, v5, v3}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a(Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    invoke-virtual {p0, v4, v1, v2, v7}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->endClientExecution(Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V

    return-object v0

    :catch_0
    move-exception v0

    move-object v1, v2

    :goto_1
    :try_start_4
    sget-object v5, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->TAG:Ljava/lang/String;

    const-string v6, "removeFile"

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
    invoke-virtual {p0, v4, v1, v2, v7}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->endClientExecution(Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V

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

.method public get(Ljava/lang/String;Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;
    .locals 3

    invoke-virtual {p0, p1}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->get(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    :try_start_0
    invoke-virtual {v0}, Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;->getUrl()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/io/File;

    invoke-direct {v2, p2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v1, v2}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->downloadFileFromUrl(Ljava/lang/String;Ljava/io/File;)Ljava/io/File;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;->setFile(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    return-object v0

    :catch_0
    move-exception v0

    new-instance v0, Lcom/jibo/aws/integration/aws/services/exception/ResourceNotFoundException;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/exception/ResourceNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    new-instance v0, Lcom/jibo/aws/integration/aws/services/exception/ResourceNotFoundException;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/exception/ResourceNotFoundException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public list(Ljava/lang/String;)Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;",
            ">;"
        }
    .end annotation

    const/4 v2, 0x0

    const/4 v7, 0x1

    new-instance v0, Lcom/jibo/aws/integration/aws/services/binary/model/ListBinaryRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/binary/model/ListBinaryRequest;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->createExecutionContext(Lcom/amazonaws/AmazonWebServiceRequest;)Lcom/amazonaws/http/ExecutionContext;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazonaws/http/ExecutionContext;->getAwsRequestMetrics()Lcom/amazonaws/util/AWSRequestMetrics;

    move-result-object v4

    sget-object v1, Lcom/amazonaws/util/AWSRequestMetrics$Field;->ClientExecuteTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v4, v1}, Lcom/amazonaws/util/AWSRequestMetrics;->startEvent(Lcom/amazonaws/metrics/MetricType;)V

    :try_start_0
    sget-object v1, Lcom/amazonaws/util/AWSRequestMetrics$Field;->RequestMarshallTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v4, v1}, Lcom/amazonaws/util/AWSRequestMetrics;->startEvent(Lcom/amazonaws/metrics/MetricType;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    :try_start_1
    new-instance v1, Lcom/jibo/aws/integration/aws/services/binary/model/a/d;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/binary/model/a/d;-><init>()V

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/binary/model/a/d;->a(Lcom/jibo/aws/integration/aws/services/binary/model/PathRequest;)Lcom/amazonaws/Request;
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
    new-instance v0, Lcom/jibo/aws/integration/aws/services/binary/model/a/b;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/binary/model/a/b;-><init>()V

    new-instance v5, Lcom/amazonaws/http/JsonResponseHandler;

    invoke-direct {v5, v0}, Lcom/amazonaws/http/JsonResponseHandler;-><init>(Lcom/amazonaws/transform/Unmarshaller;)V

    invoke-direct {p0, v1, v5, v3}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a(Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    invoke-virtual {p0, v4, v1, v2, v7}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->endClientExecution(Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V

    return-object v0

    :catch_0
    move-exception v0

    move-object v1, v2

    :goto_1
    :try_start_4
    sget-object v5, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->TAG:Ljava/lang/String;

    const-string v6, "listFiles"

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
    invoke-virtual {p0, v4, v1, v2, v7}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->endClientExecution(Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V

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

.method public remove(Ljava/lang/String;)Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;
    .locals 8

    const/4 v2, 0x0

    const/4 v7, 0x1

    new-instance v0, Lcom/jibo/aws/integration/aws/services/binary/model/RemoveBinaryRequest;

    invoke-direct {v0, p1}, Lcom/jibo/aws/integration/aws/services/binary/model/RemoveBinaryRequest;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->createExecutionContext(Lcom/amazonaws/AmazonWebServiceRequest;)Lcom/amazonaws/http/ExecutionContext;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazonaws/http/ExecutionContext;->getAwsRequestMetrics()Lcom/amazonaws/util/AWSRequestMetrics;

    move-result-object v4

    sget-object v1, Lcom/amazonaws/util/AWSRequestMetrics$Field;->ClientExecuteTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v4, v1}, Lcom/amazonaws/util/AWSRequestMetrics;->startEvent(Lcom/amazonaws/metrics/MetricType;)V

    :try_start_0
    sget-object v1, Lcom/amazonaws/util/AWSRequestMetrics$Field;->RequestMarshallTime:Lcom/amazonaws/util/AWSRequestMetrics$Field;

    invoke-virtual {v4, v1}, Lcom/amazonaws/util/AWSRequestMetrics;->startEvent(Lcom/amazonaws/metrics/MetricType;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    :try_start_1
    new-instance v1, Lcom/jibo/aws/integration/aws/services/binary/model/a/d;

    invoke-direct {v1}, Lcom/jibo/aws/integration/aws/services/binary/model/a/d;-><init>()V

    invoke-virtual {v1, v0}, Lcom/jibo/aws/integration/aws/services/binary/model/a/d;->a(Lcom/jibo/aws/integration/aws/services/binary/model/PathRequest;)Lcom/amazonaws/Request;
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
    new-instance v0, Lcom/jibo/aws/integration/aws/services/binary/model/a/a;

    invoke-direct {v0}, Lcom/jibo/aws/integration/aws/services/binary/model/a/a;-><init>()V

    new-instance v5, Lcom/amazonaws/http/JsonResponseHandler;

    invoke-direct {v5, v0}, Lcom/amazonaws/http/JsonResponseHandler;-><init>(Lcom/amazonaws/transform/Unmarshaller;)V

    invoke-direct {p0, v1, v5, v3}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->a(Lcom/amazonaws/Request;Lcom/amazonaws/http/HttpResponseHandler;Lcom/amazonaws/http/ExecutionContext;)Lcom/amazonaws/Response;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazonaws/Response;->getAwsResponse()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/jibo/aws/integration/aws/services/binary/model/BinaryLink;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    invoke-virtual {p0, v4, v1, v2, v7}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->endClientExecution(Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V

    return-object v0

    :catch_0
    move-exception v0

    move-object v1, v2

    :goto_1
    :try_start_4
    sget-object v5, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->TAG:Ljava/lang/String;

    const-string v6, "removeFile"

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
    invoke-virtual {p0, v4, v1, v2, v7}, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->endClientExecution(Lcom/amazonaws/util/AWSRequestMetrics;Lcom/amazonaws/Request;Lcom/amazonaws/Response;Z)V

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

.method public setServiceType(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    iput-object p1, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->b:Ljava/lang/String;

    iput-object p2, p0, Lcom/jibo/aws/integration/aws/services/binary/JiboBinaryClient;->c:Ljava/lang/String;

    return-void
.end method
